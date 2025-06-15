package com.englishlearn.domain.usecase;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J6\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0011"}, d2 = {"Lcom/englishlearn/domain/usecase/DocumentSummaryUseCase;", "", "context", "Landroid/content/Context;", "googleAIApi", "Lcom/englishlearn/data/api/GoogleAIApi;", "(Landroid/content/Context;Lcom/englishlearn/data/api/GoogleAIApi;)V", "summarizeDocument", "Lkotlin/Result;", "", "documentContent", "documentTitle", "summaryType", "Lcom/englishlearn/domain/usecase/DocumentSummaryUseCase$SummaryType;", "summarizeDocument-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Lcom/englishlearn/domain/usecase/DocumentSummaryUseCase$SummaryType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SummaryType", "app_release"})
public final class DocumentSummaryUseCase {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.data.api.GoogleAIApi googleAIApi = null;
    
    @javax.inject.Inject
    public DocumentSummaryUseCase(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.englishlearn.data.api.GoogleAIApi googleAIApi) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/englishlearn/domain/usecase/DocumentSummaryUseCase$SummaryType;", "", "(Ljava/lang/String;I)V", "BRIEF", "DETAILED", "KEY_POINTS", "CHAPTER", "app_release"})
    public static enum SummaryType {
        /*public static final*/ BRIEF /* = new BRIEF() */,
        /*public static final*/ DETAILED /* = new DETAILED() */,
        /*public static final*/ KEY_POINTS /* = new KEY_POINTS() */,
        /*public static final*/ CHAPTER /* = new CHAPTER() */;
        
        SummaryType() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.englishlearn.domain.usecase.DocumentSummaryUseCase.SummaryType> getEntries() {
            return null;
        }
    }
}