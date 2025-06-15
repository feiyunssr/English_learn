package com.englishlearn.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Link
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.englishlearn.ui.viewmodels.DocumentImportViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DocumentImportScreen(
    navController: NavController,
    viewModel: DocumentImportViewModel = hiltViewModel()
) {
    var title by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var url by remember { mutableStateOf("") }
    var isUrlImport by remember { mutableStateOf(false) }
    
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            viewModel.importDocument(it, title, category)
        }
    }

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            navController.popBackStack()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("导入文档") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("文档标题") },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("为文档输入一个标题") }
            )

            OutlinedTextField(
                value = category,
                onValueChange = { category = it },
                label = { Text("分类") },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("如：论文、新闻、小说等") }
            )

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "导入方式",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FilterChip(
                            onClick = { isUrlImport = false },
                            label = { Text("本地文件") },
                            selected = !isUrlImport,
                            leadingIcon = {
                                Icon(Icons.Default.Add, contentDescription = null)
                            }
                        )
                        FilterChip(
                            onClick = { isUrlImport = true },
                            label = { Text("网络链接") },
                            selected = isUrlImport,
                            leadingIcon = {
                                Icon(Icons.Default.Link, contentDescription = null)
                            }
                        )
                    }
                }
            }

            if (isUrlImport) {
                OutlinedTextField(
                    value = url,
                    onValueChange = { url = it },
                    label = { Text("网络链接") },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("输入文档的网络链接") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri)
                )
            }

            if (uiState.isLoading) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            if (uiState.error != null) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer
                    )
                ) {
                    Text(
                        text = "导入失败: ${uiState.error}",
                        modifier = Modifier.padding(16.dp),
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    if (isUrlImport) {
                        if (url.isNotEmpty()) {
                            viewModel.importFromUrl(url, title, category)
                        }
                    } else {
                        filePickerLauncher.launch("*/*")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !uiState.isLoading && (
                    (!isUrlImport) || (isUrlImport && url.isNotEmpty())
                )
            ) {
                Text(if (isUrlImport) "从链接导入" else "选择文件导入")
            }
        }
    }
}