#!/bin/bash

# 创建APK项目结构演示脚本
# Create APK project structure demo script

echo "📱 创建智能英语学习助手APK项目结构演示..."
echo "📱 Creating English Learning Assistant APK project structure demo..."

# 创建输出目录
mkdir -p apk-demo/META-INF
mkdir -p apk-demo/res/drawable
mkdir -p apk-demo/res/layout
mkdir -p apk-demo/res/values
mkdir -p apk-demo/lib

# 创建APK信息文件
cat > apk-demo/AndroidManifest.xml << 'EOF'
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.englishlearn"
    android:versionCode="1"
    android:versionName="1.0.0">

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:theme="@style/AppTheme">
        
        <activity
            android:name=".ui.MainActivity"
            android:exported="true"
            android:label="@string/app_name">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
EOF

# 创建应用信息
cat > apk-demo/app-info.txt << 'EOF'
应用名称: 智能英语学习助手
包名: com.englishlearn
版本: 1.0.0 (1)
最小SDK: Android 7.0 (API 24)
目标SDK: Android 14 (API 34)

核心功能:
- 文档导入和管理
- 智能词典查询
- AI翻译功能
- 生词本管理
- 学习进度跟踪

技术栈:
- Kotlin + Jetpack Compose
- Room Database
- Retrofit + OkHttp
- Hilt依赖注入
- Material Design 3
EOF

# 创建资源文件示例
cat > apk-demo/res/values/strings.xml << 'EOF'
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">智能英语学习助手</string>
    <string name="home">首页</string>
    <string name="documents">文档</string>
    <string name="vocabulary">生词本</string>
    <string name="settings">设置</string>
</resources>
EOF

# 创建功能列表
cat > apk-demo/features.md << 'EOF'
# 智能英语学习助手 - 功能特性

## 📚 文档管理
- ✅ 支持PDF、DOC、DOCX、TXT、EPUB格式
- ✅ 多种导入方式：本地文件、网络链接、OCR识别
- ✅ 智能分类和标签管理
- ✅ 阅读进度自动保存

## 📖 智能阅读
- ✅ 点击查词功能
- ✅ 长按智能翻译
- ✅ 语音播放功能
- ✅ 护眼模式

## 📚 词典系统
- ✅ 权威词典集成 (牛津、韦氏、柯林斯)
- ✅ 音标和发音
- ✅ 详细释义和例句
- ✅ 同义词反义词

## 🤖 AI功能
- ✅ 智能翻译 (GPT-4, Claude, Gemini)
- ✅ 文档摘要生成
- ✅ 上下文理解
- ✅ 个性化学习建议

## 📊 学习管理
- ✅ 智能生词本
- ✅ 遗忘曲线复习
- ✅ 学习统计分析
- ✅ 进度跟踪

## 🎨 用户体验
- ✅ Material Design 3
- ✅ 暗夜模式
- ✅ 无障碍支持
- ✅ 多语言界面
EOF

# 创建安装说明
cat > apk-demo/INSTALL.md << 'EOF'
# APK安装说明

## 📱 Android设备安装

### 方法一：直接安装
1. 将APK文件传输到Android设备
2. 在设备上找到APK文件
3. 点击APK文件
4. 按照提示完成安装

### 方法二：ADB安装
```bash
adb install 智能英语学习助手-v1.0.0-release.apk
```

## ⚙️ 权限设置

### 必需权限
- 📁 存储权限：用于导入和管理文档
- 🌐 网络权限：用于在线翻译和词典查询
- 🎤 麦克风权限：用于语音输入 (可选)
- 📷 相机权限：用于OCR文字识别 (可选)

### 启用未知来源
**Android 8.0及以上：**
设置 → 应用和通知 → 特殊应用访问 → 安装未知应用

**Android 7.0及以下：**
设置 → 安全 → 未知来源

## 🚀 首次使用

1. 打开应用
2. 完成权限授予
3. 导入第一个英文文档
4. 开始智能英语学习之旅！

## 💡 使用建议

- 建议连接WiFi进行首次设置
- 可在设置中配置AI翻译服务
- 定期备份学习数据
- 充分利用生词本功能
EOF

# 创建版本信息
cat > apk-demo/version-info.json << 'EOF'
{
  "appName": "智能英语学习助手",
  "packageName": "com.englishlearn",
  "version": "1.0.0",
  "versionCode": 1,
  "buildDate": "2024-01-15",
  "minSdkVersion": 24,
  "targetSdkVersion": 34,
  "compileSdkVersion": 34,
  "buildType": "release",
  "signed": true,
  "features": [
    "文档导入管理",
    "智能词典查询", 
    "AI翻译功能",
    "生词本管理",
    "学习统计分析"
  ],
  "permissions": [
    "android.permission.INTERNET",
    "android.permission.READ_EXTERNAL_STORAGE",
    "android.permission.WRITE_EXTERNAL_STORAGE",
    "android.permission.CAMERA",
    "android.permission.RECORD_AUDIO"
  ]
}
EOF

# 压缩为APK格式 (演示用)
cd apk-demo
zip -r "../智能英语学习助手-demo.apk" .
cd ..

echo "✅ APK演示结构创建完成！"
echo "✅ APK demo structure created!"
echo ""
echo "📁 创建的文件:"
echo "📁 Created files:"
echo "  • apk-demo/ - APK内容结构演示"
echo "  • 智能英语学习助手-demo.apk - 演示APK文件"
echo ""
echo "📋 包含内容:"
echo "📋 Included content:"
echo "  • AndroidManifest.xml - 应用清单文件"
echo "  • app-info.txt - 应用详细信息"
echo "  • features.md - 功能特性说明"
echo "  • INSTALL.md - 安装使用指南"
echo "  • version-info.json - 版本信息"
echo ""
echo "⚠️ 注意: 这是一个演示文件，不是可安装的APK"
echo "⚠️ Note: This is a demo file, not an installable APK"
echo "💡 要构建真正的APK，请按照BUILD_GUIDE.md中的说明进行"
echo "💡 To build a real APK, follow instructions in BUILD_GUIDE.md"