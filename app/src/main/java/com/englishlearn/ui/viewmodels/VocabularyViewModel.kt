package com.englishlearn.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.englishlearn.data.entities.Vocabulary
import com.englishlearn.domain.repository.VocabularyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VocabularyViewModel @Inject constructor(
    private val vocabularyRepository: VocabularyRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _showBookmarkedOnly = MutableStateFlow(false)
    val showBookmarkedOnly: StateFlow<Boolean> = _showBookmarkedOnly.asStateFlow()

    val vocabulary: StateFlow<List<Vocabulary>> = combine(
        vocabularyRepository.getAllVocabulary(),
        _searchQuery,
        _showBookmarkedOnly
    ) { allVocabulary, query, bookmarkedOnly ->
        var filteredVocabulary = allVocabulary

        // Filter by bookmarked status
        if (bookmarkedOnly) {
            filteredVocabulary = filteredVocabulary.filter { it.isBookmarked }
        }

        // Filter by search query
        if (query.isNotEmpty()) {
            filteredVocabulary = filteredVocabulary.filter { vocab ->
                vocab.word.contains(query, ignoreCase = true) ||
                vocab.definition.contains(query, ignoreCase = true)
            }
        }

        // Sort by creation date (newest first)
        filteredVocabulary.sortedByDescending { it.createdAt }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun toggleBookmarkedFilter() {
        _showBookmarkedOnly.value = !_showBookmarkedOnly.value
    }

    fun toggleBookmark(vocabularyId: String) {
        viewModelScope.launch {
            val vocab = vocabulary.value.find { it.id == vocabularyId }
            vocab?.let {
                vocabularyRepository.updateBookmarkStatus(vocabularyId, !it.isBookmarked)
            }
        }
    }

    fun playAudio(vocabulary: Vocabulary) {
        // TODO: Implement TTS audio playback
        // This would use Android's TextToSpeech or play the audio URL
    }

    fun deleteVocabulary(vocabularyId: String) {
        viewModelScope.launch {
            val vocab = vocabulary.value.find { it.id == vocabularyId }
            vocab?.let {
                vocabularyRepository.deleteVocabulary(it)
            }
        }
    }

    fun markAsReviewed(vocabularyId: String, correct: Boolean) {
        viewModelScope.launch {
            vocabularyRepository.updateReviewStats(vocabularyId, correct)
        }
    }
}