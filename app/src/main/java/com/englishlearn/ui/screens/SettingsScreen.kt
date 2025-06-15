package com.englishlearn.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.englishlearn.ui.viewmodels.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val darkMode by viewModel.darkMode.collectAsState()
    val notificationsEnabled by viewModel.notificationsEnabled.collectAsState()
    val autoBackup by viewModel.autoBackup.collectAsState()
    val selectedAiModel by viewModel.selectedAiModel.collectAsState()
    val selectedDictionary by viewModel.selectedDictionary.collectAsState()
    val fontSize by viewModel.fontSize.collectAsState()
    val voiceSpeed by viewModel.voiceSpeed.collectAsState()
    
    var showApiKeyDialog by remember { mutableStateOf(false) }
    var showAiModelDialog by remember { mutableStateOf(false) }
    var showDictionaryDialog by remember { mutableStateOf(false) }
    var showAboutDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("设置") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "返回")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Text(
                    text = "外观设置",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            
            item {
                SettingsSwitchItem(
                    title = "深色模式",
                    description = "使用深色主题保护眼睛",
                    checked = darkMode,
                    onCheckedChange = { viewModel.toggleDarkMode() },
                    icon = Icons.Default.DarkMode
                )
            }
            
            item {
                SettingsSliderItem(
                    title = "字体大小",
                    description = "阅读界面字体大小",
                    value = fontSize.toFloat(),
                    onValueChange = { viewModel.updateFontSize(it.toInt()) },
                    valueRange = 12f..24f,
                    steps = 11,
                    icon = Icons.Default.TextFormat
                )
            }
            
            item {
                SettingsSliderItem(
                    title = "语音速度",
                    description = "TTS朗读速度",
                    value = voiceSpeed,
                    onValueChange = { viewModel.updateVoiceSpeed(it) },
                    valueRange = 0.5f..2.0f,
                    steps = 14,
                    icon = Icons.Default.Speed
                )
            }
            
            item {
                Divider()
            }
            
            item {
                Text(
                    text = "学习设置",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            
            item {
                SettingsSwitchItem(
                    title = "学习提醒",
                    description = "定时提醒您进行英语学习",
                    checked = notificationsEnabled,
                    onCheckedChange = { viewModel.toggleNotifications() },
                    icon = Icons.Default.Notifications
                )
            }
            
            item {
                SettingsSwitchItem(
                    title = "自动备份",
                    description = "自动备份学习数据到云端",
                    checked = autoBackup,
                    onCheckedChange = { viewModel.toggleAutoBackup() },
                    icon = Icons.Default.CloudUpload
                )
            }
            
            item {
                Divider()
            }
            
            item {
                Text(
                    text = "API配置",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            
            item {
                SettingsClickableItem(
                    title = "API Key配置",
                    description = "配置Google AI API密钥",
                    icon = Icons.Default.Key,
                    onClick = { showApiKeyDialog = true }
                )
            }
            
            item {
                SettingsClickableItem(
                    title = "AI模型选择",
                    description = "当前: $selectedAiModel",
                    icon = Icons.Default.Psychology,
                    onClick = { showAiModelDialog = true }
                )
            }
            
            item {
                SettingsClickableItem(
                    title = "词典服务",
                    description = "当前: $selectedDictionary",
                    icon = Icons.Default.Book,
                    onClick = { showDictionaryDialog = true }
                )
            }
            
            item {
                Divider()
            }
            
            item {
                Text(
                    text = "关于",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            
            item {
                SettingsClickableItem(
                    title = "版本信息",
                    description = "智能英语学习助手 v1.0.0",
                    icon = Icons.Default.Info,
                    onClick = { showAboutDialog = true }
                )
            }
            
            item {
                SettingsClickableItem(
                    title = "帮助与反馈",
                    description = "获取使用帮助或提交反馈",
                    icon = Icons.Default.Help,
                    onClick = { /* TODO: 打开帮助页面 */ }
                )
            }
            
            item {
                SettingsClickableItem(
                    title = "隐私政策",
                    description = "查看应用隐私政策",
                    icon = Icons.Default.PrivacyTip,
                    onClick = { /* TODO: 打开隐私政策 */ }
                )
            }
        }
        
        // 对话框
        if (showApiKeyDialog) {
            GoogleApiKeyDialog(
                viewModel = viewModel,
                onDismiss = { showApiKeyDialog = false }
            )
        }
        
        if (showAiModelDialog) {
            GoogleAiModelSelectionDialog(
                currentModel = selectedAiModel,
                onModelSelected = { model ->
                    viewModel.updateAiModel(model)
                    showAiModelDialog = false
                },
                onDismiss = { showAiModelDialog = false }
            )
        }
        
        if (showDictionaryDialog) {
            DictionarySelectionDialog(
                currentDictionary = selectedDictionary,
                onDictionarySelected = { dictionary ->
                    viewModel.updateDictionary(dictionary)
                    showDictionaryDialog = false
                },
                onDismiss = { showDictionaryDialog = false }
            )
        }
        
        if (showAboutDialog) {
            AboutDialog(
                onDismiss = { showAboutDialog = false }
            )
        }
    }
}

@Composable
fun SettingsSwitchItem(
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsClickableItem(
    title: String,
    description: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "进入",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun GoogleApiKeyDialog(
    viewModel: SettingsViewModel,
    onDismiss: () -> Unit
) {
    val googleApiKey by viewModel.googleApiKey.collectAsState()
    var tempApiKey by remember { mutableStateOf(googleApiKey) }
    var showPassword by remember { mutableStateOf(false) }
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Google AI API Key设置") },
        text = {
            Column {
                OutlinedTextField(
                    value = tempApiKey,
                    onValueChange = { tempApiKey = it },
                    label = { Text("Google API Key") },
                    placeholder = { Text("输入你的Google AI API Key") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    visualTransformation = if (showPassword) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    trailingIcon = {
                        IconButton(onClick = { showPassword = !showPassword }) {
                            Icon(
                                imageVector = if (showPassword) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                contentDescription = if (showPassword) "隐藏密钥" else "显示密钥"
                            )
                        }
                    }
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "Google AI API Key用于访问Gemini等模型",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                TextButton(
                    onClick = {
                        // TODO: 打开Google AI获取API Key页面
                    }
                ) {
                    Text("获取API Key", style = MaterialTheme.typography.bodySmall)
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    viewModel.updateGoogleApiKey(tempApiKey)
                    onDismiss()
                },
                enabled = tempApiKey.isNotEmpty()
            ) {
                Text("保存")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("取消")
            }
        }
    )
}

@Composable
fun GoogleAiModelSelectionDialog(
    currentModel: String,
    onModelSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    // Google AI支持的模型列表
    val models = listOf(
        "gemini-pro" to "Gemini Pro",
        "gemini-pro-vision" to "Gemini Pro Vision",
        "gemini-1.5-pro-latest" to "Gemini 1.5 Pro"
    )
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("选择Google AI模型") },
        text = {
            Column {
                LazyColumn(
                    modifier = Modifier.height(200.dp)
                ) {
                    items(models) { (modelId, modelName) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onModelSelected(modelId) }
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = modelId == currentModel,
                                onClick = { onModelSelected(modelId) }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(
                                    text = modelName,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text(
                                    text = modelId,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("确定")
            }
        }
    )
}


@Composable
fun DictionarySelectionDialog(
    currentDictionary: String,
    onDictionarySelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val dictionaries = listOf("Oxford", "Cambridge", "Merriam-Webster", "柯林斯", "朗文")
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("选择词典") },
        text = {
            LazyColumn {
                items(dictionaries) { dictionary ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onDictionarySelected(dictionary) }
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = dictionary == currentDictionary,
                            onClick = { onDictionarySelected(dictionary) }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(dictionary)
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("确定")
            }
        }
    )
}

@Composable
fun SettingsSliderItem(
    title: String,
    description: String,
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>,
    steps: Int = 0,
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = when (title) {
                        "字体大小" -> "${value.toInt()}sp"
                        "语音速度" -> "${String.format("%.1f", value)}x"
                        else -> value.toString()
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.width(60.dp),
                    textAlign = TextAlign.End
                )
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Slider(
                    value = value,
                    onValueChange = onValueChange,
                    valueRange = valueRange,
                    steps = steps,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun AboutDialog(
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("关于应用") },
        text = {
            Column {
                Text("🎓 智能英语学习助手")
                Text("📱 版本: v1.0.0")
                Text("🗓️ 发布日期: 2024年6月")
                Spacer(modifier = Modifier.height(8.dp))
                Text("✨ 功能特色:")
                Text("• 智能文档导入管理")
                Text("• AI驱动的翻译和词典")
                Text("• 个性化学习跟踪")
                Text("• 现代化Material Design界面")
                Spacer(modifier = Modifier.height(8.dp))
                Text("🔧 技术栈:")
                Text("• Kotlin + Jetpack Compose")
                Text("• Room + Hilt + MVVM")
                Text("• Google AI API")
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("确定")
            }
        }
    )
}