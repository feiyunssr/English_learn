package com.englishlearn.utils

import com.englishlearn.data.entities.DocumentType
import com.tom_roush.pdfbox.android.PDFBoxResourceLoader
import com.tom_roush.pdfbox.pdmodel.PDDocument
import com.tom_roush.pdfbox.text.PDFTextStripper
import java.io.File
import java.io.FileInputStream
import javax.inject.Inject
import javax.inject.Singleton
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext

@Singleton
class DocumentProcessor @Inject constructor(
    @ApplicationContext private val context: Context
) {
    
    private var isPdfBoxInitialized = false
    
    @Synchronized
    private fun ensurePdfBoxInitialized() {
        if (!isPdfBoxInitialized) {
            try {
                PDFBoxResourceLoader.init(context)
                isPdfBoxInitialized = true
            } catch (e: Exception) {
                android.util.Log.e("DocumentProcessor", "Failed to initialize PDFBox", e)
            }
        }
    }

    fun extractText(file: File, documentType: DocumentType): String {
        return try {
            if (!file.exists()) {
                return "文件不存在: ${file.absolutePath}"
            }
            
            if (!file.canRead()) {
                return "无法读取文件: ${file.absolutePath}"
            }
            
            if (file.length() == 0L) {
                return "文件为空"
            }
            
            when (documentType) {
                DocumentType.PDF -> extractPdfText(file)
                DocumentType.TXT -> extractTxtText(file)
                DocumentType.DOC -> extractDocText(file)
                DocumentType.DOCX -> extractDocxText(file)
                DocumentType.EPUB -> extractEpubText(file)
                DocumentType.URL -> extractTxtText(file) // URLs saved as text
            }
        } catch (e: Exception) {
            "文档处理错误: ${e.message}"
        }
    }
    
    fun extractTextPage(file: File, documentType: DocumentType, pageNumber: Int): String {
        return try {
            if (!file.exists()) {
                return "文件不存在: ${file.absolutePath}"
            }
            
            if (!file.canRead()) {
                return "无法读取文件: ${file.absolutePath}"
            }
            
            if (file.length() == 0L) {
                return "文件为空"
            }
            
            when (documentType) {
                DocumentType.PDF -> extractPdfTextPage(file, pageNumber)
                DocumentType.TXT -> {
                    // TXT文件不支持分页，返回全部内容
                    if (pageNumber == 1) extractTxtText(file) else ""
                }
                DocumentType.DOC -> {
                    // DOC暂不支持
                    if (pageNumber == 1) extractDocText(file) else ""
                }
                DocumentType.DOCX -> {
                    // DOCX暂不支持
                    if (pageNumber == 1) extractDocxText(file) else ""
                }
                DocumentType.EPUB -> {
                    // EPUB暂不支持分页
                    if (pageNumber == 1) extractEpubText(file) else ""
                }
                DocumentType.URL -> {
                    if (pageNumber == 1) extractTxtText(file) else ""
                }
            }
        } catch (e: Exception) {
            "页面加载错误: ${e.message}"
        }
    }

    fun getPageCount(file: File, documentType: DocumentType): Int {
        return when (documentType) {
            DocumentType.PDF -> getPdfPageCount(file)
            DocumentType.TXT -> 1
            DocumentType.DOC -> getDocPageCount(file)
            DocumentType.DOCX -> getDocxPageCount(file)
            DocumentType.EPUB -> getEpubPageCount(file)
            DocumentType.URL -> 1
        }
    }

    private fun extractPdfText(file: File): String {
        return try {
            // 确保PDFBox已初始化
            ensurePdfBoxInitialized()
            
            // 检查文件大小作为警告，但不阻止处理
            if (file.length() > 50 * 1024 * 1024) { // 50MB警告
                android.util.Log.w("DocumentProcessor", "Large PDF file: ${file.length() / 1024 / 1024}MB")
            }
            
            // 使用文件输入流而不是直接加载文件
            file.inputStream().buffered().use { inputStream ->
                PDDocument.load(inputStream).use { document ->
                    val stripper = PDFTextStripper()
                    stripper.sortByPosition = true
                    
                    // 分批处理页面，避免一次性加载太多内容
                    val pageCount = document.numberOfPages
                    val pageChunkSize = 10
                    val stringBuilder = StringBuilder()
                    
                    android.util.Log.d("DocumentProcessor", "Processing PDF with $pageCount pages")
                    
                    for (startPage in 1..pageCount step pageChunkSize) {
                        val endPage = minOf(startPage + pageChunkSize - 1, pageCount)
                        stripper.startPage = startPage
                        stripper.endPage = endPage
                        
                        try {
                            val pageText = stripper.getText(document)
                            stringBuilder.append(pageText)
                            
                            // 检查是否取消或内存压力
                            if (Thread.currentThread().isInterrupted) {
                                break
                            }
                        } catch (e: Exception) {
                            android.util.Log.e("DocumentProcessor", "Error processing pages $startPage-$endPage", e)
                        }
                    }
                    
                    val result = stringBuilder.toString()
                    android.util.Log.d("DocumentProcessor", "Extracted ${result.length} characters")
                    result
                }
            }
        } catch (e: OutOfMemoryError) {
            android.util.Log.e("DocumentProcessor", "OutOfMemoryError", e)
            System.gc()
            "PDF文件过大，内存不足，请关闭其他应用后重试"
        } catch (e: Exception) {
            android.util.Log.e("DocumentProcessor", "PDF extraction error: ${e.javaClass.simpleName}", e)
            "PDF文本提取失败: ${e.localizedMessage ?: e.message}"
        }
    }
    
    private fun extractPdfTextPage(file: File, pageNumber: Int): String {
        return try {
            // 确保PDFBox已初始化
            ensurePdfBoxInitialized()
            
            // 使用文件输入流加载PDF
            file.inputStream().buffered().use { inputStream ->
                PDDocument.load(inputStream).use { document ->
                    val pageCount = document.numberOfPages
                    
                    // 验证页码有效性
                    if (pageNumber < 1 || pageNumber > pageCount) {
                        return "页码无效。文档共 $pageCount 页"
                    }
                    
                    android.util.Log.d("DocumentProcessor", "Extracting page $pageNumber of $pageCount")
                    
                    val stripper = PDFTextStripper()
                    stripper.sortByPosition = true
                    stripper.startPage = pageNumber
                    stripper.endPage = pageNumber
                    
                    val pageText = stripper.getText(document)
                    android.util.Log.d("DocumentProcessor", "Page $pageNumber extracted: ${pageText.length} characters")
                    
                    pageText
                }
            }
        } catch (e: OutOfMemoryError) {
            android.util.Log.e("DocumentProcessor", "OutOfMemoryError on page $pageNumber", e)
            System.gc()
            "内存不足，请关闭其他应用后重试"
        } catch (e: Exception) {
            android.util.Log.e("DocumentProcessor", "PDF page extraction error: ${e.javaClass.simpleName}", e)
            "页面提取失败: ${e.localizedMessage ?: e.message}"
        }
    }

    private fun extractTxtText(file: File): String {
        return try {
            // 检查文件大小，避免加载过大的文本文件导致内存溢出
            if (file.length() > 10 * 1024 * 1024) { // 10MB限制
                return "文本文件过大，请选择小于10MB的文件"
            }
            
            val text = file.readText(Charsets.UTF_8)
            if (text.length > 100000) { // 限制文本长度为100K字符
                text.substring(0, 100000) + "\n\n[文档已截断，仅显示前100,000个字符]"
            } else {
                text
            }
        } catch (e: OutOfMemoryError) {
            "文本文件过大，内存不足，请选择较小的文件"
        } catch (e: Exception) {
            "文本文件读取失败: ${e.message}"
        }
    }

    private fun extractDocText(file: File): String {
        return try {
            // DOC support temporarily disabled due to POI library Android compatibility issues
            "DOC format is not supported in this version. Please convert to TXT or PDF."
        } catch (e: Exception) {
            "Error extracting DOC text: ${e.message}"
        }
    }

    private fun extractDocxText(file: File): String {
        return try {
            // DOCX support temporarily disabled due to POI library Android compatibility issues
            "DOCX format is not supported in this version. Please convert to TXT or PDF."
        } catch (e: Exception) {
            "Error extracting DOCX text: ${e.message}"
        }
    }

    private fun extractEpubText(file: File): String {
        // EPUB text extraction would be implemented using an EPUB library
        return "EPUB content extraction not yet implemented"
    }

    private fun getPdfPageCount(file: File): Int {
        return try {
            PDDocument.load(file).use { document ->
                document.numberOfPages
            }
        } catch (e: Exception) {
            1
        }
    }

    private fun getDocPageCount(file: File): Int {
        return try {
            // DOC page count would require Apache POI library
            1
        } catch (e: Exception) {
            1
        }
    }

    private fun getDocxPageCount(file: File): Int {
        return try {
            // DOCX support temporarily disabled
            1
        } catch (e: Exception) {
            1
        }
    }

    private fun getEpubPageCount(file: File): Int {
        // EPUB page count estimation
        return 1
    }
}