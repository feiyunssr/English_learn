package com.englishlearn.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.englishlearn.ui.screens.*

@Composable
fun EnglishLearnNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController = navController)
        }
        
        composable("documents") {
            DocumentsScreen(navController = navController)
        }
        
        composable("import_document") {
            DocumentImportScreen(navController = navController)
        }
        
        composable("reading/{documentId}") { backStackEntry ->
            val documentId = backStackEntry.arguments?.getString("documentId") ?: ""
            ReadingScreen(navController = navController, documentId = documentId)
        }
        
        composable("vocabulary") {
            VocabularyScreen(navController = navController)
        }
        
        composable("settings") {
            SettingsScreen(navController = navController)
        }
    }
}