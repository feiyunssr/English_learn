package com.englishlearn.utils

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FileUtils @Inject constructor(
    @ApplicationContext private val context: Context,
    private val okHttpClient: OkHttpClient
) {

    fun getFileName(uri: Uri): String? {
        var fileName: String? = null
        if (uri.scheme == "content") {
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            cursor?.use {
                if (it.moveToFirst()) {
                    val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                    if (nameIndex >= 0) {
                        fileName = it.getString(nameIndex)
                    }
                }
            }
        }
        if (fileName == null) {
            fileName = uri.path?.let { path ->
                val cut = path.lastIndexOf('/')
                if (cut != -1) {
                    path.substring(cut + 1)
                } else {
                    path
                }
            }
        }
        return fileName
    }

    suspend fun copyToInternalStorage(uri: Uri, fileName: String): File = withContext(Dispatchers.IO) {
        val documentsDir = File(context.filesDir, "documents")
        if (!documentsDir.exists()) {
            documentsDir.mkdirs()
        }
        
        val destinationFile = File(documentsDir, fileName)
        
        context.contentResolver.openInputStream(uri)?.use { inputStream ->
            FileOutputStream(destinationFile).use { outputStream ->
                inputStream.copyTo(outputStream)
            }
        } ?: throw IOException("Could not open input stream for URI: $uri")
        
        destinationFile
    }

    suspend fun downloadFromUrl(url: String): File = withContext(Dispatchers.IO) {
        val request = Request.Builder()
            .url(url)
            .build()
            
        val response = okHttpClient.newCall(request).execute()
        
        if (!response.isSuccessful) {
            throw IOException("Failed to download file: ${response.code}")
        }
        
        val fileName = extractFileNameFromUrl(url) ?: "downloaded_${System.currentTimeMillis()}.txt"
        val documentsDir = File(context.filesDir, "documents")
        if (!documentsDir.exists()) {
            documentsDir.mkdirs()
        }
        
        val destinationFile = File(documentsDir, fileName)
        
        response.body?.byteStream()?.use { inputStream ->
            FileOutputStream(destinationFile).use { outputStream ->
                inputStream.copyTo(outputStream)
            }
        } ?: throw IOException("Response body is null")
        
        destinationFile
    }

    private fun extractFileNameFromUrl(url: String): String? {
        return try {
            val path = Uri.parse(url).path
            path?.substringAfterLast("/")?.takeIf { it.isNotEmpty() }
        } catch (e: Exception) {
            null
        }
    }

    fun getFileSize(file: File): Long = file.length()

    fun deleteFile(file: File): Boolean = file.delete()

    fun createBackup(document: com.englishlearn.data.entities.Document): File {
        // Create backup of document metadata and content
        val backupsDir = File(context.filesDir, "backups")
        if (!backupsDir.exists()) {
            backupsDir.mkdirs()
        }
        
        val backupFile = File(backupsDir, "${document.id}_backup.json")
        // Implementation would serialize document data to JSON
        return backupFile
    }
}