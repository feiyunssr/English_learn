package com.englishlearn.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.englishlearn.data.entities.Document
import com.englishlearn.domain.repository.DocumentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DocumentsViewModel @Inject constructor(
    private val documentRepository: DocumentRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow<String?>(null)
    val selectedCategory: StateFlow<String?> = _selectedCategory.asStateFlow()

    val categories: StateFlow<List<String>> = documentRepository.getAllCategories()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val documents: StateFlow<List<Document>> = combine(
        documentRepository.getAllDocuments(),
        _searchQuery,
        _selectedCategory
    ) { allDocuments, query, category ->
        var filteredDocuments = allDocuments

        // Filter by category
        if (category != null) {
            filteredDocuments = filteredDocuments.filter { it.category == category }
        }

        // Filter by search query
        if (query.isNotEmpty()) {
            filteredDocuments = filteredDocuments.filter { document ->
                document.title.contains(query, ignoreCase = true) ||
                document.category.contains(query, ignoreCase = true) ||
                document.tags.any { tag -> tag.contains(query, ignoreCase = true) }
            }
        }

        filteredDocuments
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun selectCategory(category: String?) {
        _selectedCategory.value = category
    }

    fun toggleBookmark(documentId: String) {
        viewModelScope.launch {
            val document = documentRepository.getDocumentById(documentId)
            document?.let {
                documentRepository.updateBookmarkStatus(documentId, !it.isBookmarked)
            }
        }
    }

    fun deleteDocument(documentId: String) {
        viewModelScope.launch {
            documentRepository.deleteDocumentById(documentId)
        }
    }
}