package com.englishlearn.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.englishlearn.data.entities.Document
import com.englishlearn.domain.repository.DocumentRepository
import com.englishlearn.domain.repository.VocabularyRepository
import com.englishlearn.data.dao.LearningSessionDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val documentRepository: DocumentRepository,
    private val vocabularyRepository: VocabularyRepository,
    private val learningSessionDao: LearningSessionDao
) : ViewModel() {

    private val _recentDocuments = MutableStateFlow<List<Document>>(emptyList())
    val recentDocuments: StateFlow<List<Document>> = _recentDocuments.asStateFlow()

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories.asStateFlow()
    
    // Learning Statistics
    private val _totalWordsLearned = MutableStateFlow(0)
    val totalWordsLearned: StateFlow<Int> = _totalWordsLearned.asStateFlow()
    
    private val _totalDocumentsRead = MutableStateFlow(0)
    val totalDocumentsRead: StateFlow<Int> = _totalDocumentsRead.asStateFlow()
    
    private val _totalReadingTime = MutableStateFlow(0L) // in milliseconds
    val totalReadingTime: StateFlow<Long> = _totalReadingTime.asStateFlow()
    
    private val _todayWordsLearned = MutableStateFlow(0)
    val todayWordsLearned: StateFlow<Int> = _todayWordsLearned.asStateFlow()
    
    private val _streakDays = MutableStateFlow(0)
    val streakDays: StateFlow<Int> = _streakDays.asStateFlow()

    init {
        loadRecentDocuments()
        loadCategories()
        loadLearningStatistics()
    }

    private fun loadRecentDocuments() {
        viewModelScope.launch {
            documentRepository.getAllDocuments().collect { documents ->
                _recentDocuments.value = documents.take(5) // Show only recent 5 documents
            }
        }
    }

    private fun loadCategories() {
        viewModelScope.launch {
            documentRepository.getAllCategories().collect { categories ->
                _categories.value = categories
            }
        }
    }
    
    private fun loadLearningStatistics() {
        viewModelScope.launch {
            // Load total words learned
            vocabularyRepository.getAllVocabulary().collect { vocabularyList ->
                _totalWordsLearned.value = vocabularyList.size
                
                // Calculate today's words
                val todayStart = getTodayStartTimestamp()
                _todayWordsLearned.value = vocabularyList.count { vocab ->
                    vocab.createdAt >= todayStart
                }
            }
        }
        
        viewModelScope.launch {
            // Load total documents read
            documentRepository.getAllDocuments().collect { documents ->
                _totalDocumentsRead.value = documents.count { it.readingProgress > 0.9f }
            }
        }
        
        viewModelScope.launch {
            // Load total reading time and streak from learning sessions
            val allSessions = learningSessionDao.getAllSessionsList()
            _totalReadingTime.value = allSessions.sumOf { it.duration }
            _streakDays.value = calculateStreakDays(allSessions)
        }
    }
    
    private fun getTodayStartTimestamp(): Long {
        val now = System.currentTimeMillis()
        val calendar = java.util.Calendar.getInstance()
        calendar.timeInMillis = now
        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0)
        calendar.set(java.util.Calendar.MINUTE, 0)
        calendar.set(java.util.Calendar.SECOND, 0)
        calendar.set(java.util.Calendar.MILLISECOND, 0)
        return calendar.timeInMillis
    }
    
    private fun calculateStreakDays(sessions: List<com.englishlearn.data.entities.LearningSession>): Int {
        if (sessions.isEmpty()) return 0
        
        val sortedSessions = sessions.sortedByDescending { it.startTime }
        val calendar = java.util.Calendar.getInstance()
        var streak = 0
        var currentDate = getTodayStartTimestamp()
        
        for (i in 0 until 30) { // Check last 30 days
            val hasSessionOnDate = sortedSessions.any { session ->
                session.startTime >= currentDate && session.startTime < currentDate + 86400000L
            }
            
            if (hasSessionOnDate) {
                streak++
                currentDate -= 86400000L // Go to previous day
            } else if (i > 0) { // Allow today to be empty
                break
            }
        }
        
        return streak
    }
}