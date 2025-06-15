package com.englishlearn.ui.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _darkMode = MutableStateFlow(false)
    val darkMode: StateFlow<Boolean> = _darkMode.asStateFlow()

    private val _notificationsEnabled = MutableStateFlow(true)
    val notificationsEnabled: StateFlow<Boolean> = _notificationsEnabled.asStateFlow()

    private val _autoBackup = MutableStateFlow(false)
    val autoBackup: StateFlow<Boolean> = _autoBackup.asStateFlow()

    private val _selectedAiModel = MutableStateFlow("gemini-pro")
    val selectedAiModel: StateFlow<String> = _selectedAiModel.asStateFlow()

    private val _googleApiKey = MutableStateFlow("")
    val googleApiKey: StateFlow<String> = _googleApiKey.asStateFlow()

    private val _selectedDictionary = MutableStateFlow("Oxford")
    val selectedDictionary: StateFlow<String> = _selectedDictionary.asStateFlow()

    private val _fontSize = MutableStateFlow(16)
    val fontSize: StateFlow<Int> = _fontSize.asStateFlow()

    private val _voiceSpeed = MutableStateFlow(1.0f)
    val voiceSpeed: StateFlow<Float> = _voiceSpeed.asStateFlow()

    init {
        loadSettings()
    }

    private fun loadSettings() {
        viewModelScope.launch {
            val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
            _darkMode.value = prefs.getBoolean("dark_mode", false)
            _notificationsEnabled.value = prefs.getBoolean("notifications_enabled", true)
            _autoBackup.value = prefs.getBoolean("auto_backup", false)
            _selectedAiModel.value = prefs.getString("google_ai_model", "gemini-pro") ?: "gemini-pro"
            _googleApiKey.value = prefs.getString("google_api_key", "") ?: ""
            _selectedDictionary.value = prefs.getString("dictionary", "Oxford") ?: "Oxford"
            _fontSize.value = prefs.getInt("font_size", 16)
            _voiceSpeed.value = prefs.getFloat("voice_speed", 1.0f)
        }
    }

    fun toggleDarkMode() {
        viewModelScope.launch {
            _darkMode.value = !_darkMode.value
            saveSettings()
        }
    }

    fun toggleNotifications() {
        viewModelScope.launch {
            _notificationsEnabled.value = !_notificationsEnabled.value
            saveSettings()
        }
    }

    fun toggleAutoBackup() {
        viewModelScope.launch {
            _autoBackup.value = !_autoBackup.value
            saveSettings()
        }
    }

    fun updateAiModel(model: String) {
        viewModelScope.launch {
            _selectedAiModel.value = model
            saveSettings()
        }
    }

    fun updateGoogleApiKey(apiKey: String) {
        viewModelScope.launch {
            _googleApiKey.value = apiKey
            saveSettings()
        }
    }

    fun updateDictionary(dictionary: String) {
        viewModelScope.launch {
            _selectedDictionary.value = dictionary
            saveSettings()
        }
    }

    fun updateFontSize(size: Int) {
        viewModelScope.launch {
            _fontSize.value = size
            saveSettings()
        }
    }

    fun updateVoiceSpeed(speed: Float) {
        viewModelScope.launch {
            _voiceSpeed.value = speed
            saveSettings()
        }
    }

    private fun saveSettings() {
        val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
        prefs.edit().apply {
            putBoolean("dark_mode", _darkMode.value)
            putBoolean("notifications_enabled", _notificationsEnabled.value)
            putBoolean("auto_backup", _autoBackup.value)
            putString("google_ai_model", _selectedAiModel.value)
            putString("google_api_key", _googleApiKey.value)
            putString("dictionary", _selectedDictionary.value)
            putInt("font_size", _fontSize.value)
            putFloat("voice_speed", _voiceSpeed.value)
            apply()
        }
    }

    fun exportData(): Boolean {
        return try {
            // 导出学习数据的逻辑
            true
        } catch (e: Exception) {
            false
        }
    }

    fun importData(): Boolean {
        return try {
            // 导入学习数据的逻辑
            true
        } catch (e: Exception) {
            false
        }
    }

    fun clearAllData(): Boolean {
        return try {
            // 清除所有数据的逻辑
            true
        } catch (e: Exception) {
            false
        }
    }
}