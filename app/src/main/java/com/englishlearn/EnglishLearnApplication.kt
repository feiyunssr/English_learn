package com.englishlearn

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import com.tom_roush.pdfbox.android.PDFBoxResourceLoader

@HiltAndroidApp
class EnglishLearnApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        // 设置全局未捕获异常处理器
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            android.util.Log.e("EnglishLearnApp", "Uncaught exception in thread ${thread.name}", throwable)
            
            // 记录崩溃信息但不让应用直接退出
            when (throwable) {
                is OutOfMemoryError -> {
                    System.gc()
                    android.util.Log.e("EnglishLearnApp", "OutOfMemoryError - attempting recovery")
                }
                else -> {
                    // 让默认处理器处理其他异常
                    Thread.getDefaultUncaughtExceptionHandler()?.uncaughtException(thread, throwable)
                }
            }
        }
        
        // 在后台线程初始化PDFBox
        Thread {
            try {
                PDFBoxResourceLoader.init(applicationContext)
                android.util.Log.d("EnglishLearnApp", "PDFBox initialized successfully")
            } catch (e: Exception) {
                android.util.Log.e("EnglishLearnApp", "Failed to initialize PDFBox", e)
            }
        }.start()
    }
}