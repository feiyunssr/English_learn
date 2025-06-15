package com.englishlearn.domain.usecase;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJF\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016JF\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001b"}, d2 = {"Lcom/englishlearn/domain/usecase/DocumentImportUseCase;", "", "context", "Landroid/content/Context;", "documentRepository", "Lcom/englishlearn/domain/repository/DocumentRepository;", "documentProcessor", "Lcom/englishlearn/utils/DocumentProcessor;", "fileUtils", "Lcom/englishlearn/utils/FileUtils;", "(Landroid/content/Context;Lcom/englishlearn/domain/repository/DocumentRepository;Lcom/englishlearn/utils/DocumentProcessor;Lcom/englishlearn/utils/FileUtils;)V", "importDocument", "Lkotlin/Result;", "Lcom/englishlearn/data/entities/Document;", "uri", "Landroid/net/Uri;", "title", "", "category", "tags", "", "importDocument-yxL6bBk", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importFromUrl", "url", "importFromUrl-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class DocumentImportUseCase {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.domain.repository.DocumentRepository documentRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.utils.DocumentProcessor documentProcessor = null;
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.utils.FileUtils fileUtils = null;
    
    @javax.inject.Inject
    public DocumentImportUseCase(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.englishlearn.domain.repository.DocumentRepository documentRepository, @org.jetbrains.annotations.NotNull
    com.englishlearn.utils.DocumentProcessor documentProcessor, @org.jetbrains.annotations.NotNull
    com.englishlearn.utils.FileUtils fileUtils) {
        super();
    }
}