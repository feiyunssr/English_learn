package com.englishlearn.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0013J\u0006\u00104\u001a\u00020\u0015J\u0006\u00105\u001a\u00020\u0015J\u0006\u00106\u001a\u000202J\u000e\u00107\u001a\u0002022\u0006\u00108\u001a\u00020\u0013J\u000e\u00109\u001a\u0002022\u0006\u0010:\u001a\u00020\u000fJ\u000e\u0010;\u001a\u0002022\u0006\u00103\u001a\u00020\u0013J\u0006\u0010<\u001a\u000202J\u000e\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020\u0013J\u000e\u0010?\u001a\u0002022\u0006\u00103\u001a\u00020\u0013J\u0006\u0010@\u001a\u000202J\b\u0010A\u001a\u000202H\u0002J\u0016\u0010B\u001a\u0002022\u0006\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u0013J\u000e\u0010E\u001a\u0002022\u0006\u0010>\u001a\u00020\u0013J\u000e\u0010F\u001a\u0002022\u0006\u0010G\u001a\u00020HR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0019\u0010\'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0019\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0019\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001f\u00a8\u0006I"}, d2 = {"Lcom/englishlearn/ui/viewmodels/ReadingViewModel;", "Landroidx/lifecycle/ViewModel;", "documentRepository", "Lcom/englishlearn/domain/repository/DocumentRepository;", "vocabularyRepository", "Lcom/englishlearn/domain/repository/VocabularyRepository;", "dictionaryUseCase", "Lcom/englishlearn/domain/usecase/DictionaryUseCase;", "translationUseCase", "Lcom/englishlearn/domain/usecase/TranslationUseCase;", "documentProcessor", "Lcom/englishlearn/utils/DocumentProcessor;", "(Lcom/englishlearn/domain/repository/DocumentRepository;Lcom/englishlearn/domain/repository/VocabularyRepository;Lcom/englishlearn/domain/usecase/DictionaryUseCase;Lcom/englishlearn/domain/usecase/TranslationUseCase;Lcom/englishlearn/utils/DocumentProcessor;)V", "_currentPageNumber", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_document", "Lcom/englishlearn/data/entities/Document;", "_documentContent", "", "_isLoading", "", "_pageContent", "_selectedText", "_selectedWord", "_totalPages", "_translation", "_wordDefinition", "currentPageNumber", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentPageNumber", "()Lkotlinx/coroutines/flow/StateFlow;", "document", "getDocument", "documentContent", "getDocumentContent", "isLoading", "pageContent", "getPageContent", "selectedText", "getSelectedText", "selectedWord", "getSelectedWord", "totalPages", "getTotalPages", "translation", "getTranslation", "wordDefinition", "getWordDefinition", "addToVocabulary", "", "word", "canGoToNextPage", "canGoToPreviousPage", "clearSelection", "loadDocument", "documentId", "loadPage", "pageNumber", "lookupWord", "nextPage", "playTranslationAudio", "text", "playWordAudio", "previousPage", "savePageProgress", "saveTranslation", "originalText", "translatedText", "translateText", "updateReadingProgress", "progress", "", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ReadingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.domain.repository.DocumentRepository documentRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.domain.repository.VocabularyRepository vocabularyRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.domain.usecase.DictionaryUseCase dictionaryUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.domain.usecase.TranslationUseCase translationUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.utils.DocumentProcessor documentProcessor = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.englishlearn.data.entities.Document> _document = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.englishlearn.data.entities.Document> document = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _documentContent = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> documentContent = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedWord = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selectedWord = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedText = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selectedText = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _wordDefinition = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> wordDefinition = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _translation = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> translation = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _currentPageNumber = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> currentPageNumber = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _totalPages = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> totalPages = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _pageContent = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> pageContent = null;
    
    @javax.inject.Inject
    public ReadingViewModel(@org.jetbrains.annotations.NotNull
    com.englishlearn.domain.repository.DocumentRepository documentRepository, @org.jetbrains.annotations.NotNull
    com.englishlearn.domain.repository.VocabularyRepository vocabularyRepository, @org.jetbrains.annotations.NotNull
    com.englishlearn.domain.usecase.DictionaryUseCase dictionaryUseCase, @org.jetbrains.annotations.NotNull
    com.englishlearn.domain.usecase.TranslationUseCase translationUseCase, @org.jetbrains.annotations.NotNull
    com.englishlearn.utils.DocumentProcessor documentProcessor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.englishlearn.data.entities.Document> getDocument() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getDocumentContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelectedWord() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelectedText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getWordDefinition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getTranslation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getCurrentPageNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getTotalPages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getPageContent() {
        return null;
    }
    
    public final void loadDocument(@org.jetbrains.annotations.NotNull
    java.lang.String documentId) {
    }
    
    public final void lookupWord(@org.jetbrains.annotations.NotNull
    java.lang.String word) {
    }
    
    public final void translateText(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    public final void addToVocabulary(@org.jetbrains.annotations.NotNull
    java.lang.String word) {
    }
    
    public final void saveTranslation(@org.jetbrains.annotations.NotNull
    java.lang.String originalText, @org.jetbrains.annotations.NotNull
    java.lang.String translatedText) {
    }
    
    public final void playWordAudio(@org.jetbrains.annotations.NotNull
    java.lang.String word) {
    }
    
    public final void playTranslationAudio(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    public final void updateReadingProgress(float progress) {
    }
    
    public final void clearSelection() {
    }
    
    public final void loadPage(int pageNumber) {
    }
    
    public final void nextPage() {
    }
    
    public final void previousPage() {
    }
    
    public final boolean canGoToNextPage() {
        return false;
    }
    
    public final boolean canGoToPreviousPage() {
        return false;
    }
    
    private final void savePageProgress() {
    }
}