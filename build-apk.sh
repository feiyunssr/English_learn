#!/bin/bash

# 智能英语学习助手 APK 构建脚本
# English Learning Assistant APK Build Script

echo "🚀 开始构建智能英语学习助手 APK..."
echo "🚀 Starting to build English Learning Assistant APK..."

# 检查Java环境
if ! command -v java &> /dev/null; then
    echo "❌ 错误: 未找到Java环境，请先安装Java 11或17"
    echo "❌ Error: Java not found. Please install Java 11 or 17 first"
    echo "💡 安装命令 (Ubuntu/Debian): sudo apt install openjdk-17-jdk"
    echo "💡 Install command (Ubuntu/Debian): sudo apt install openjdk-17-jdk"
    exit 1
fi

# 检查Android SDK
if [ -z "$ANDROID_HOME" ] && [ -z "$ANDROID_SDK_ROOT" ]; then
    echo "❌ 错误: 未设置ANDROID_HOME或ANDROID_SDK_ROOT环境变量"
    echo "❌ Error: ANDROID_HOME or ANDROID_SDK_ROOT environment variable not set"
    echo "💡 请下载并安装Android SDK: https://developer.android.com/studio"
    echo "💡 Please download and install Android SDK: https://developer.android.com/studio"
    exit 1
fi

# 检查Gradle Wrapper
if [ ! -f "./gradlew" ]; then
    echo "❌ 错误: 未找到gradlew文件"
    echo "❌ Error: gradlew file not found"
    exit 1
fi

# 设置执行权限
chmod +x ./gradlew

echo "📋 检查项目依赖..."
echo "📋 Checking project dependencies..."

# 清理项目
echo "🧹 清理项目..."
echo "🧹 Cleaning project..."
./gradlew clean

# 构建Debug APK
echo "🔨 开始构建 Debug APK..."
echo "🔨 Building Debug APK..."
./gradlew assembleDebug

# 检查构建结果
APK_PATH="app/build/outputs/apk/debug/app-debug.apk"
if [ -f "$APK_PATH" ]; then
    echo "✅ APK构建成功！"
    echo "✅ APK built successfully!"
    echo "📍 APK位置: $APK_PATH"
    echo "📍 APK location: $APK_PATH"
    
    # 复制到项目根目录
    cp "$APK_PATH" "./智能英语学习助手-debug.apk"
    echo "📦 APK已复制到项目根目录: 智能英语学习助手-debug.apk"
    echo "📦 APK copied to project root: 智能英语学习助手-debug.apk"
    
    # 显示APK信息
    echo "ℹ️ APK信息:"
    echo "ℹ️ APK Info:"
    ls -lh "./智能英语学习助手-debug.apk"
else
    echo "❌ APK构建失败"
    echo "❌ APK build failed"
    echo "💡 请检查构建日志以获取详细错误信息"
    echo "💡 Please check build logs for detailed error information"
    exit 1
fi

echo ""
echo "🎉 构建完成！"
echo "🎉 Build completed!"
echo "📱 您现在可以将APK文件传输到Android设备进行安装"
echo "📱 You can now transfer the APK file to an Android device for installation"
echo ""
echo "📖 安装说明:"
echo "📖 Installation Instructions:"
echo "1. 将APK文件传输到Android设备"
echo "1. Transfer APK file to Android device"
echo "2. 在设备上启用'未知来源'安装"
echo "2. Enable 'Unknown Sources' installation on device"
echo "3. 点击APK文件进行安装"
echo "3. Tap APK file to install"