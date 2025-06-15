package com.englishlearn.utils;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/englishlearn/utils/DocumentProcessor;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isPdfBoxInitialized", "", "ensurePdfBoxInitialized", "", "extractDocText", "", "file", "Ljava/io/File;", "extractDocxText", "extractEpubText", "extractPdfText", "extractPdfTextPage", "pageNumber", "", "extractText", "documentType", "Lcom/englishlearn/data/entities/DocumentType;", "extractTextPage", "extractTxtText", "getDocPageCount", "getDocxPageCount", "getEpubPageCount", "getPageCount", "getPdfPageCount", "app_release"})
public final class DocumentProcessor {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    private boolean isPdfBoxInitialized = false;
    
    @javax.inject.Inject
    public DocumentProcessor(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @kotlin.jvm.Synchronized
    private final synchronized void ensurePdfBoxInitialized() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String extractText(@org.jetbrains.annotations.NotNull
    java.io.File file, @org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.DocumentType documentType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String extractTextPage(@org.jetbrains.annotations.NotNull
    java.io.File file, @org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.DocumentType documentType, int pageNumber) {
        return null;
    }
    
    public final int getPageCount(@org.jetbrains.annotations.NotNull
    java.io.File file, @org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.DocumentType documentType) {
        return 0;
    }
    
    private final java.lang.String extractPdfText(java.io.File file) {
        return null;
    }
    
    private final java.lang.String extractPdfTextPage(java.io.File file, int pageNumber) {
        return null;
    }
    
    private final java.lang.String extractTxtText(java.io.File file) {
        return null;
    }
    
    private final java.lang.String extractDocText(java.io.File file) {
        return null;
    }
    
    private final java.lang.String extractDocxText(java.io.File file) {
        return null;
    }
    
    private final java.lang.String extractEpubText(java.io.File file) {
        return null;
    }
    
    private final int getPdfPageCount(java.io.File file) {
        return 0;
    }
    
    private final int getDocPageCount(java.io.File file) {
        return 0;
    }
    
    private final int getDocxPageCount(java.io.File file) {
        return 0;
    }
    
    private final int getEpubPageCount(java.io.File file) {
        return 0;
    }
}