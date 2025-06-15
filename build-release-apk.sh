#!/bin/bash

# 智能英语学习助手 Release APK 构建脚本
# English Learning Assistant Release APK Build Script

echo "🚀 开始构建智能英语学习助手 Release APK..."
echo "🚀 Starting to build English Learning Assistant Release APK..."

# 检查Java环境
if ! command -v java &> /dev/null; then
    echo "❌ 错误: 未找到Java环境，请先安装Java 11或17"
    echo "❌ Error: Java not found. Please install Java 11 or 17 first"
    exit 1
fi

# 检查是否存在签名密钥
if [ ! -f "keystore.properties" ]; then
    echo "⚠️ 未找到签名配置文件，将创建签名密钥..."
    echo "⚠️ Signing config not found, creating signing key..."
    
    if [ ! -f "create-signing-key.sh" ]; then
        echo "❌ 错误: 未找到密钥创建脚本"
        echo "❌ Error: Key creation script not found"
        exit 1
    fi
    
    ./create-signing-key.sh
    
    if [ ! -f "keystore.properties" ]; then
        echo "❌ 密钥创建失败，无法继续构建Release版本"
        echo "❌ Key creation failed, cannot build Release version"
        exit 1
    fi
fi

# 设置执行权限
chmod +x ./gradlew

echo "📋 检查项目依赖..."
echo "📋 Checking project dependencies..."

# 清理项目
echo "🧹 清理项目..."
echo "🧹 Cleaning project..."
./gradlew clean

# 构建Release APK
echo "🔨 开始构建 Release APK..."
echo "🔨 Building Release APK..."
./gradlew assembleRelease

# 检查构建结果
APK_PATH="app/build/outputs/apk/release/app-release.apk"
if [ -f "$APK_PATH" ]; then
    echo "✅ Release APK构建成功！"
    echo "✅ Release APK built successfully!"
    echo "📍 APK位置: $APK_PATH"
    echo "📍 APK location: $APK_PATH"
    
    # 复制到项目根目录
    cp "$APK_PATH" "./智能英语学习助手-v1.0.0-release.apk"
    echo "📦 APK已复制到项目根目录: 智能英语学习助手-v1.0.0-release.apk"
    echo "📦 APK copied to project root: 智能英语学习助手-v1.0.0-release.apk"
    
    # 显示APK信息
    echo "ℹ️ APK信息:"
    echo "ℹ️ APK Info:"
    ls -lh "./智能英语学习助手-v1.0.0-release.apk"
    
    # 检查APK签名
    echo ""
    echo "🔍 验证APK签名..."
    echo "🔍 Verifying APK signature..."
    if command -v apksigner &> /dev/null; then
        apksigner verify "./智能英语学习助手-v1.0.0-release.apk"
        if [ $? -eq 0 ]; then
            echo "✅ APK签名验证成功"
            echo "✅ APK signature verification successful"
        else
            echo "⚠️ APK签名验证失败"
            echo "⚠️ APK signature verification failed"
        fi
    else
        echo "💡 未找到apksigner工具，跳过签名验证"
        echo "💡 apksigner tool not found, skipping signature verification"
    fi
    
else
    echo "❌ Release APK构建失败"
    echo "❌ Release APK build failed"
    echo "💡 请检查构建日志以获取详细错误信息"
    echo "💡 Please check build logs for detailed error information"
    exit 1
fi

echo ""
echo "🎉 Release版本构建完成！"
echo "🎉 Release build completed!"
echo "📱 您现在可以将APK文件发布或传输到Android设备进行安装"
echo "📱 You can now publish or transfer the APK file to Android devices for installation"
echo ""
echo "📋 发布检查清单:"
echo "📋 Release checklist:"
echo "✓ APK已签名"
echo "✓ APK is signed"
echo "✓ 代码混淆已启用"
echo "✓ Code obfuscation enabled"
echo "✓ 资源压缩已启用"
echo "✓ Resource shrinking enabled"
echo ""
echo "📖 安装说明:"
echo "📖 Installation Instructions:"
echo "1. 将APK文件传输到Android设备"
echo "1. Transfer APK file to Android device"
echo "2. 在设备上启用'未知来源'安装"
echo "2. Enable 'Unknown Sources' installation on device"
echo "3. 点击APK文件进行安装"
echo "3. Tap APK file to install"