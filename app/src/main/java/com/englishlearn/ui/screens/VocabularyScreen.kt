package com.englishlearn.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.englishlearn.data.entities.Vocabulary
import com.englishlearn.ui.viewmodels.VocabularyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VocabularyScreen(
    navController: NavController,
    viewModel: VocabularyViewModel = hiltViewModel()
) {
    val vocabulary by viewModel.vocabulary.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val showBookmarkedOnly by viewModel.showBookmarkedOnly.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("生词本") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.toggleBookmarkedFilter() }) {
                        Icon(
                            if (showBookmarkedOnly) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                            contentDescription = "Filter Bookmarks"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = viewModel::updateSearchQuery,
                label = { Text("搜索单词") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null)
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { viewModel.updateSearchQuery("") }) {
                            Icon(Icons.Default.Clear, contentDescription = "Clear")
                        }
                    }
                }
            )

            // Vocabulary Statistics
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    VocabularyStatItem(
                        title = "总单词",
                        value = vocabulary.size.toString()
                    )
                    VocabularyStatItem(
                        title = "已收藏",
                        value = vocabulary.count { it.isBookmarked }.toString()
                    )
                    VocabularyStatItem(
                        title = "待复习",
                        value = vocabulary.count { 
                            it.nextReviewAt != null && it.nextReviewAt!! <= System.currentTimeMillis() 
                        }.toString()
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Vocabulary List
            if (vocabulary.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            Icons.Default.Book,
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "暂无生词",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "在阅读时查询单词会自动添加到生词本",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(vocabulary) { vocab ->
                        VocabularyItem(
                            vocabulary = vocab,
                            onBookmarkToggle = { viewModel.toggleBookmark(vocab.id) },
                            onPlayAudio = { viewModel.playAudio(vocab) },
                            onDelete = { viewModel.deleteVocabulary(vocab.id) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun VocabularyStatItem(title: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VocabularyItem(
    vocabulary: Vocabulary,
    onBookmarkToggle: () -> Unit,
    onPlayAudio: () -> Unit,
    onDelete: () -> Unit
) {
    var showDefinition by remember { mutableStateOf(false) }
    var showMenu by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = vocabulary.word,
                            style = MaterialTheme.typography.titleMedium
                        )
                        if (vocabulary.phonetic != null) {
                            Text(
                                text = " [${vocabulary.phonetic}]",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        if (vocabulary.audioUrl != null) {
                            IconButton(
                                onClick = onPlayAudio,
                                modifier = Modifier.size(32.dp)
                            ) {
                                Icon(
                                    Icons.Default.VolumeUp,
                                    contentDescription = "Play Audio",
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                    
                    Text(
                        text = vocabulary.definition.take(100) + if (vocabulary.definition.length > 100) "..." else "",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    
                    if (vocabulary.context != null) {
                        Text(
                            text = "上下文: ${vocabulary.context}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                
                Box {
                    IconButton(onClick = { showMenu = true }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "More")
                    }
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text(if (vocabulary.isBookmarked) "取消收藏" else "添加收藏") },
                            onClick = {
                                onBookmarkToggle()
                                showMenu = false
                            },
                            leadingIcon = {
                                Icon(
                                    if (vocabulary.isBookmarked) Icons.Default.BookmarkRemove 
                                    else Icons.Default.BookmarkAdd,
                                    contentDescription = null
                                )
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("查看详情") },
                            onClick = {
                                showDefinition = !showDefinition
                                showMenu = false
                            },
                            leadingIcon = {
                                Icon(Icons.Default.Info, contentDescription = null)
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("删除") },
                            onClick = {
                                onDelete()
                                showMenu = false
                            },
                            leadingIcon = {
                                Icon(Icons.Default.Delete, contentDescription = null)
                            }
                        )
                    }
                }
            }
            
            if (showDefinition) {
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Spacer(modifier = Modifier.height(8.dp))
                
                if (vocabulary.examples.isNotEmpty()) {
                    Text(
                        text = "例句:",
                        style = MaterialTheme.typography.labelMedium
                    )
                    vocabulary.examples.forEach { example ->
                        Text(
                            text = "• $example",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
                
                if (vocabulary.synonyms.isNotEmpty()) {
                    Text(
                        text = "同义词: ${vocabulary.synonyms.joinToString(", ")}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                
                if (vocabulary.antonyms.isNotEmpty()) {
                    Text(
                        text = "反义词: ${vocabulary.antonyms.joinToString(", ")}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}