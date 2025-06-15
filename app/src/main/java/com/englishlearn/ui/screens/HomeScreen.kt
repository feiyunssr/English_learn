package com.englishlearn.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.englishlearn.ui.viewmodels.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val documents by viewModel.recentDocuments.collectAsState()
    val categories by viewModel.categories.collectAsState()
    val totalWordsLearned by viewModel.totalWordsLearned.collectAsState()
    val totalDocumentsRead by viewModel.totalDocumentsRead.collectAsState()
    val totalReadingTime by viewModel.totalReadingTime.collectAsState()
    val todayWordsLearned by viewModel.todayWordsLearned.collectAsState()
    val streakDays by viewModel.streakDays.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("智能英语学习助手") },
                actions = {
                    IconButton(onClick = { navController.navigate("settings") }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("import_document") }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Document")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "学习统计",
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            StatisticItem(
                                title = "今日阅读", 
                                value = "${totalReadingTime / 60000} 分钟"
                            )
                            StatisticItem(
                                title = "新单词", 
                                value = "$todayWordsLearned"
                            )
                            StatisticItem(
                                title = "连续打卡", 
                                value = "$streakDays 天"
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            StatisticItem(
                                title = "总词汇量", 
                                value = "$totalWordsLearned"
                            )
                            StatisticItem(
                                title = "已读文档", 
                                value = "$totalDocumentsRead"
                            )
                            StatisticItem(
                                title = "文档总数", 
                                value = "${documents.size}"
                            )
                        }
                    }
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Card(
                        modifier = Modifier.weight(1f),
                        onClick = { navController.navigate("documents") }
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                Icons.Default.Book,
                                contentDescription = "Documents",
                                modifier = Modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("我的文档")
                        }
                    }
                    
                    Card(
                        modifier = Modifier.weight(1f),
                        onClick = { navController.navigate("vocabulary") }
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                Icons.Default.Book,
                                contentDescription = "Vocabulary",
                                modifier = Modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("生词本")
                        }
                    }
                }
            }

            item {
                Text(
                    text = "最近阅读",
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            if (documents.isEmpty()) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "还没有导入任何文档\n点击右下角的 + 按钮开始导入",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            } else {
                items(documents) { document ->
                    DocumentCard(
                        title = document.title,
                        category = document.category,
                        progress = document.readingProgress,
                        onClick = { navController.navigate("reading/${document.id}") }
                    )
                }
            }
        }
    }
}

@Composable
fun StatisticItem(title: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DocumentCard(
    title: String,
    category: String,
    progress: Float,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = category,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier.fillMaxWidth(),
            )
            Text(
                text = "${(progress * 100).toInt()}% 完成",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}