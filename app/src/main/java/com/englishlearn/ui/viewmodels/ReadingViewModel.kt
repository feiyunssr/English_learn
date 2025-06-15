package com.englishlearn.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.englishlearn.data.entities.Document
import com.englishlearn.data.entities.Translation
import com.englishlearn.data.entities.Vocabulary
import com.englishlearn.domain.repository.DocumentRepository
import com.englishlearn.domain.repository.VocabularyRepository
import com.englishlearn.domain.usecase.DictionaryUseCase
import com.englishlearn.domain.usecase.TranslationUseCase
import com.englishlearn.utils.DocumentProcessor
import java.io.File
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReadingViewModel @Inject constructor(
    private val documentRepository: DocumentRepository,
    private val vocabularyRepository: VocabularyRepository,
    private val dictionaryUseCase: DictionaryUseCase,
    private val translationUseCase: TranslationUseCase,
    private val documentProcessor: DocumentProcessor
) : ViewModel() {

    private val _document = MutableStateFlow<Document?>(null)
    val document: StateFlow<Document?> = _document.asStateFlow()
    
    private val _documentContent = MutableStateFlow<String>("")
    val documentContent: StateFlow<String> = _documentContent.asStateFlow()

    private val _selectedWord = MutableStateFlow<String?>(null)
    val selectedWord: StateFlow<String?> = _selectedWord.asStateFlow()

    private val _selectedText = MutableStateFlow<String?>(null)
    val selectedText: StateFlow<String?> = _selectedText.asStateFlow()

    private val _wordDefinition = MutableStateFlow<String?>(null)
    val wordDefinition: StateFlow<String?> = _wordDefinition.asStateFlow()

    private val _translation = MutableStateFlow<String?>(null)
    val translation: StateFlow<String?> = _translation.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    // 页面导航相关状态
    private val _currentPageNumber = MutableStateFlow(1)
    val currentPageNumber: StateFlow<Int> = _currentPageNumber.asStateFlow()
    
    private val _totalPages = MutableStateFlow(0)
    val totalPages: StateFlow<Int> = _totalPages.asStateFlow()
    
    private val _pageContent = MutableStateFlow<String>("")
    val pageContent: StateFlow<String> = _pageContent.asStateFlow()

    fun loadDocument(documentId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _documentContent.value = "正在加载文档..."
            
            try {
                val doc = documentRepository.getDocumentById(documentId)
                _document.value = doc
                
                // Load document content from file in IO dispatcher
                doc?.let { document ->
                    val file = File(document.filePath)
                    if (file.exists() && file.canRead()) {
                        try {
                            // 获取文档总页数
                            val pageCount = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
                                documentProcessor.getPageCount(file, document.fileType)
                            }
                            _totalPages.value = pageCount
                            
                            // 恢复上次阅读的页码，如果没有则从第1页开始
                            val lastPage = if (document.currentPage > 0) document.currentPage else 1
                            _currentPageNumber.value = lastPage
                            
                            // 加载指定页面
                            loadPage(lastPage)
                            
                        } catch (e: Exception) {
                            _documentContent.value = "文档处理错误: ${e.localizedMessage}"
                        }
                    } else {
                        _documentContent.value = if (!file.exists()) {
                            "文档文件未找到: ${document.filePath}"
                        } else {
                            "无法读取文档文件，请检查文件权限"
                        }
                    }
                }
            } catch (e: OutOfMemoryError) {
                _documentContent.value = "内存不足，请关闭其他应用后重试"
                System.gc()
            } catch (e: Exception) {
                _documentContent.value = "加载文档失败: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun lookupWord(word: String) {
        viewModelScope.launch {
            _selectedWord.value = word
            _isLoading.value = true
            _wordDefinition.value = null
            
            try {
                val result = dictionaryUseCase.lookupWord(
                    word = word,
                    documentId = _document.value?.id,
                    context = "阅读上下文"
                )
                
                result.onSuccess { vocabulary ->
                    _wordDefinition.value = vocabulary.definition
                    // 如果定义为空或为默认值，显示更友好的提示
                    if (vocabulary.definition.isEmpty() || 
                        vocabulary.definition == "暂无词典数据。您可以尝试使用在线词典或AI翻译功能。") {
                        _wordDefinition.value = "未找到该单词的释义，请尝试AI翻译功能"
                    }
                }.onFailure {
                    _wordDefinition.value = "词典查询失败，请稍后重试"
                }
            } catch (e: Exception) {
                _wordDefinition.value = "词典查询出错: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun translateText(text: String) {
        viewModelScope.launch {
            _selectedText.value = text
            _isLoading.value = true
            _translation.value = null
            
            try {
                val result = translationUseCase.translateText(
                    text = text,
                    sourceLanguage = "English",
                    targetLanguage = "Chinese"
                )
                
                result.onSuccess { translation ->
                    _translation.value = translation.translatedText
                }.onFailure { exception ->
                    _translation.value = "翻译失败: ${exception.message}"
                }
            } catch (e: Exception) {
                _translation.value = "翻译出错: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun addToVocabulary(word: String) {
        viewModelScope.launch {
            try {
                val vocabulary = Vocabulary(
                    word = word,
                    definition = _wordDefinition.value ?: "暂无释义",
                    documentId = _document.value?.id,
                    context = "从阅读中添加",
                    isBookmarked = true
                )
                vocabularyRepository.insertVocabulary(vocabulary)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun saveTranslation(originalText: String, translatedText: String) {
        viewModelScope.launch {
            try {
                // 保存翻译记录的逻辑
                // 实际应用中会保存到Translation表
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun playWordAudio(word: String) {
        // TODO: 实现TTS播放单词发音
        // 使用Android TextToSpeech API
    }

    fun playTranslationAudio(text: String) {
        // TODO: 实现TTS播放翻译结果
        // 使用Android TextToSpeech API
    }

    fun updateReadingProgress(progress: Float) {
        viewModelScope.launch {
            _document.value?.let { doc ->
                documentRepository.updateReadingProgress(
                    id = doc.id,
                    progress = progress,
                    currentPage = (progress * doc.totalPages).toInt()
                )
            }
        }
    }

    fun clearSelection() {
        _selectedWord.value = null
        _selectedText.value = null
        _wordDefinition.value = null
        _translation.value = null
    }
    
    // 页面导航方法
    fun loadPage(pageNumber: Int) {
        viewModelScope.launch {
            _document.value?.let { document ->
                val file = File(document.filePath)
                if (file.exists() && file.canRead()) {
                    _isLoading.value = true
                    try {
                        val content = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
                            documentProcessor.extractTextPage(file, document.fileType, pageNumber)
                        }
                        _pageContent.value = content
                        _documentContent.value = content
                        _currentPageNumber.value = pageNumber
                        
                        // 保存当前页码到数据库
                        savePageProgress()
                    } catch (e: Exception) {
                        _pageContent.value = "页面加载失败: ${e.localizedMessage}"
                        _documentContent.value = "页面加载失败: ${e.localizedMessage}"
                    } finally {
                        _isLoading.value = false
                    }
                }
            }
        }
    }
    
    fun nextPage() {
        val currentPage = _currentPageNumber.value
        val totalPages = _totalPages.value
        if (currentPage < totalPages) {
            loadPage(currentPage + 1)
        }
    }
    
    fun previousPage() {
        val currentPage = _currentPageNumber.value
        if (currentPage > 1) {
            loadPage(currentPage - 1)
        }
    }
    
    fun canGoToNextPage(): Boolean {
        return _currentPageNumber.value < _totalPages.value
    }
    
    fun canGoToPreviousPage(): Boolean {
        return _currentPageNumber.value > 1
    }
    
    private fun savePageProgress() {
        viewModelScope.launch {
            _document.value?.let { doc ->
                val currentPage = _currentPageNumber.value
                val progress = if (_totalPages.value > 0) {
                    currentPage.toFloat() / _totalPages.value.toFloat()
                } else {
                    0f
                }
                
                documentRepository.updateReadingProgress(
                    id = doc.id,
                    progress = progress,
                    currentPage = currentPage
                )
            }
        }
    }
}