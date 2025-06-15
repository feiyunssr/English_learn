package com.englishlearn.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.englishlearn.ui.viewmodels.ReadingViewModel
import com.englishlearn.ui.viewmodels.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadingScreen(
    navController: NavController,
    documentId: String,
    viewModel: ReadingViewModel = hiltViewModel(),
    settingsViewModel: SettingsViewModel = hiltViewModel()
) {
    val document by viewModel.document.collectAsState()
    val documentContent by viewModel.documentContent.collectAsState()
    val selectedWord by viewModel.selectedWord.collectAsState()
    val selectedText by viewModel.selectedText.collectAsState()
    val wordDefinition by viewModel.wordDefinition.collectAsState()
    val translation by viewModel.translation.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    
    val fontSize by settingsViewModel.fontSize.collectAsState()
    
    // 页面导航相关状态
    val currentPageNumber by viewModel.currentPageNumber.collectAsState()
    val totalPages by viewModel.totalPages.collectAsState()
    val canGoNext = viewModel.canGoToNextPage()
    val canGoPrevious = viewModel.canGoToPreviousPage()
    
    var showWordDialog by remember { mutableStateOf(false) }
    var showTranslationDialog by remember { mutableStateOf(false) }
    var showSettings by remember { mutableStateOf(false) }

    LaunchedEffect(documentId) {
        viewModel.loadDocument(documentId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        text = document?.title ?: "阅读中...",
                        maxLines = 1
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "返回")
                    }
                },
                actions = {
                    IconButton(onClick = { showSettings = !showSettings }) {
                        Icon(Icons.Default.Settings, contentDescription = "阅读设置")
                    }
                    IconButton(onClick = { navController.navigate("vocabulary") }) {
                        Icon(Icons.Default.Book, contentDescription = "生词本")
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
            // 主要内容区域
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                // 阅读设置面板
                if (showSettings) {
                    ReadingSettingsPanel(
                        fontSize = fontSize,
                        onFontSizeChange = { settingsViewModel.updateFontSize(it) },
                        onDismiss = { showSettings = false }
                    )
                }

                // 主要阅读内容
                if (document != null && documentContent.isNotEmpty()) {
                    ReadingContent(
                        document = document!!,
                        content = documentContent,
                        fontSize = fontSize,
                        onWordClick = { word ->
                            viewModel.lookupWord(word)
                            showWordDialog = true
                        },
                        onTextSelection = { text ->
                            viewModel.translateText(text)
                            showTranslationDialog = true
                        }
                    )
                } else {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        if (isLoading) {
                            CircularProgressIndicator()
                        } else {
                            Text("文档加载失败")
                        }
                    }
                }
            }
            
            // 页面导航栏
            if (document != null && totalPages > 1) {
                PageNavigationBar(
                    currentPage = currentPageNumber,
                    totalPages = totalPages,
                    canGoPrevious = canGoPrevious,
                    canGoNext = canGoNext,
                    onPreviousPage = { viewModel.previousPage() },
                    onNextPage = { viewModel.nextPage() },
                    isLoading = isLoading
                )
            }

            // 单词查询对话框
            if (showWordDialog && selectedWord != null) {
                WordDefinitionDialog(
                    word = selectedWord!!,
                    definition = wordDefinition,
                    isLoading = isLoading,
                    onDismiss = { 
                        showWordDialog = false
                        viewModel.clearSelection()
                    },
                    onAddToVocabulary = { viewModel.addToVocabulary(selectedWord!!) },
                    onPlayAudio = { viewModel.playWordAudio(selectedWord!!) }
                )
            }

            // 翻译对话框
            if (showTranslationDialog && selectedText != null) {
                TranslationDialog(
                    originalText = selectedText!!,
                    translation = translation,
                    isLoading = isLoading,
                    onDismiss = { 
                        showTranslationDialog = false
                        viewModel.clearSelection()
                    },
                    onSaveTranslation = { viewModel.saveTranslation(selectedText!!, translation ?: "") },
                    onPlayAudio = { viewModel.playTranslationAudio(translation ?: "") }
                )
            }
        }
    }
}

@Composable
fun ReadingContent(
    document: com.englishlearn.data.entities.Document,
    content: String,
    fontSize: Int,
    onWordClick: (String) -> Unit,
    onTextSelection: (String) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 文档信息
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = document.title,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "分类: ${document.category}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    if (document.tags.isNotEmpty()) {
                        Text(
                            text = "标签: ${document.tags.joinToString(", ")}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }

        // 阅读进度
        item {
            LinearProgressIndicator(
                progress = document.readingProgress,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "阅读进度: ${(document.readingProgress * 100).toInt()}%",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        // 文档内容
        item {
            ClickableText(
                text = content,
                fontSize = fontSize,
                onWordClick = onWordClick,
                onTextSelection = onTextSelection
            )
        }
    }
}

@Composable
fun ClickableText(
    text: String,
    fontSize: Int,
    onWordClick: (String) -> Unit,
    onTextSelection: (String) -> Unit
) {
    var layoutResult by remember { mutableStateOf<androidx.compose.ui.text.TextLayoutResult?>(null) }
    val primaryColor = MaterialTheme.colorScheme.primary
    val hapticFeedback = LocalHapticFeedback.current
    var selectedSentence by remember { mutableStateOf<String?>(null) }
    
    // 限制显示的文本长度，避免UI性能问题
    val displayText = remember(text) {
        if (text.length > 50000) {
            text.substring(0, 50000) + "\n\n[文档过长，仅显示前50,000个字符]"
        } else {
            text
        }
    }
    
    val annotatedText = remember(displayText, primaryColor) {
        buildAnnotatedString {
            // 优化：分段处理长文本，避免UI卡顿
            val maxWordsPerSegment = 5000
            val words = displayText.split(Regex("\\s+"))
            val totalWords = words.size
            
            // 处理单词的内部函数
            fun processWords(words: List<String>, color: androidx.compose.ui.graphics.Color) {
                words.forEachIndexed { index, word ->
                    if (index > 0) {
                        append(" ")
                    }
                    
                    val cleanWord = word.replace(Regex("[^a-zA-Z]"), "")
                    if (cleanWord.isNotEmpty()) {
                        pushStringAnnotation(tag = "word", annotation = cleanWord)
                        withStyle(
                            style = SpanStyle(
                                color = color,
                                fontWeight = FontWeight.Normal
                            )
                        ) {
                            append(word)
                        }
                        pop()
                    } else {
                        append(word)
                    }
                }
            }
            
            if (totalWords <= maxWordsPerSegment) {
                // 较短文本，全部进行单词标注
                processWords(words, primaryColor)
            } else {
                // 长文本分段处理，只标注前面部分
                val processedWords = words.take(maxWordsPerSegment)
                processWords(processedWords, primaryColor)
                
                // 剩余部分直接追加
                if (totalWords > maxWordsPerSegment) {
                    append("\n\n... [文本较长，仅对前${maxWordsPerSegment}个单词启用点击功能]")
                }
            }
        }
    }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        androidx.compose.foundation.text.ClickableText(
            text = annotatedText,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = fontSize.sp,
                lineHeight = (fontSize * 1.5f).sp
            ),
            modifier = Modifier
                .padding(16.dp)
                .pointerInput(displayText) {
                    detectTapGestures(
                        onLongPress = { offset ->
                            // 触觉反馈
                            hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                            
                            // 使用layoutResult获取准确的文本位置
                            layoutResult?.let { layout ->
                                val position = layout.getOffsetForPosition(offset)
                                val sentence = extractSentence(displayText, position)
                                if (sentence.isNotEmpty()) {
                                    selectedSentence = sentence
                                    onTextSelection(sentence)
                                }
                            }
                        }
                    )
                },
            onClick = { offset ->
                annotatedText.getStringAnnotations(
                    tag = "word",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let { annotation ->
                    onWordClick(annotation.item)
                }
            },
            onTextLayout = { textLayoutResult ->
                layoutResult = textLayoutResult
            }
        )
    }
}

private fun extractSentence(text: String, clickPosition: Int): String {
    // 改进的句子提取逻辑
    if (clickPosition < 0 || clickPosition >= text.length) return ""
    
    // 定义句子结束符
    val sentenceEnders = setOf('.', '!', '?', '。', '！', '？')
    
    // 向前查找句子开始
    var start = clickPosition
    while (start > 0) {
        val prevChar = text[start - 1]
        if (sentenceEnders.contains(prevChar)) {
            // 跳过结束符后的空格
            while (start < text.length && text[start].isWhitespace()) {
                start++
            }
            break
        }
        start--
    }
    
    // 向后查找句子结束
    var end = clickPosition
    while (end < text.length) {
        if (sentenceEnders.contains(text[end])) {
            end++ // 包含结束符
            break
        }
        end++
    }
    
    // 提取句子并去除首尾空白
    return if (start < end) {
        text.substring(start, end).trim()
    } else {
        ""
    }
}

@Composable
fun ReadingSettingsPanel(
    fontSize: Int,
    onFontSizeChange: (Int) -> Unit,
    onDismiss: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "阅读设置",
                    style = MaterialTheme.typography.titleMedium
                )
                IconButton(onClick = onDismiss) {
                    Icon(Icons.Default.Close, contentDescription = "关闭")
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(text = "字体大小: ${fontSize}sp")
            Slider(
                value = fontSize.toFloat(),
                onValueChange = { onFontSizeChange(it.toInt()) },
                valueRange = 12f..24f,
                steps = 11
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { onFontSizeChange(14) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("小")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { onFontSizeChange(16) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("中")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { onFontSizeChange(20) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("大")
                }
            }
        }
    }
}

@Composable
fun WordDefinitionDialog(
    word: String,
    definition: String?,
    isLoading: Boolean,
    onDismiss: () -> Unit,
    onAddToVocabulary: () -> Unit,
    onPlayAudio: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = word,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Row {
                        IconButton(onClick = onPlayAudio) {
                            Icon(Icons.Default.VolumeUp, contentDescription = "播放发音")
                        }
                        IconButton(onClick = onDismiss) {
                            Icon(Icons.Default.Close, contentDescription = "关闭")
                        }
                    }
                }
                
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                
                if (isLoading) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    Text(
                        text = definition ?: "词典释义加载中...",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Button(
                        onClick = onAddToVocabulary,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.BookmarkAdd, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("添加到生词本")
                    }
                }
            }
        }
    }
}

@Composable
fun TranslationDialog(
    originalText: String,
    translation: String?,
    isLoading: Boolean,
    onDismiss: () -> Unit,
    onSaveTranslation: () -> Unit,
    onPlayAudio: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "AI 翻译",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "关闭")
                    }
                }
                
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                
                Text(
                    text = "原文:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = originalText,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "译文:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold
                )
                
                if (isLoading) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    Text(
                        text = translation ?: "翻译加载中...",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = onPlayAudio,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.VolumeUp, contentDescription = null)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("朗读")
                        }
                        Button(
                            onClick = onSaveTranslation,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.Save, contentDescription = null)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("保存")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PageNavigationBar(
    currentPage: Int,
    totalPages: Int,
    canGoPrevious: Boolean,
    canGoNext: Boolean,
    onPreviousPage: () -> Unit,
    onNextPage: () -> Unit,
    isLoading: Boolean
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 3.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 上一页按钮
            IconButton(
                onClick = onPreviousPage,
                enabled = canGoPrevious && !isLoading
            ) {
                Icon(
                    Icons.Default.NavigateBefore,
                    contentDescription = "上一页",
                    modifier = Modifier.size(32.dp)
                )
            }
            
            // 页码显示
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "第 $currentPage 页",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "共 $totalPages 页",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            // 下一页按钮
            IconButton(
                onClick = onNextPage,
                enabled = canGoNext && !isLoading
            ) {
                Icon(
                    Icons.Default.NavigateNext,
                    contentDescription = "下一页",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}