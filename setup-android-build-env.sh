#!/bin/bash

# 智能英语学习助手 - Android构建环境自动安装脚本
# English Learning Assistant - Android Build Environment Auto Setup Script

set -e  # 遇到错误时退出

echo "🚀 开始安装Android构建环境..."
echo "🚀 Starting Android build environment setup..."

# 颜色定义
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

print_status() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

print_success() {
    echo -e "${GREEN}[SUCCESS]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# 检查是否有sudo权限
check_sudo() {
    if ! sudo -n true 2>/dev/null; then
        print_error "需要sudo权限来安装系统依赖"
        print_error "Need sudo permission to install system dependencies"
        echo "请运行: sudo $0"
        echo "Please run: sudo $0"
        exit 1
    fi
}

# 安装Java JDK
install_java() {
    print_status "安装Java JDK 17..."
    print_status "Installing Java JDK 17..."
    
    if command -v java &> /dev/null; then
        JAVA_VERSION=$(java -version 2>&1 | head -n1 | cut -d'"' -f2)
        print_success "Java已安装: $JAVA_VERSION"
        print_success "Java already installed: $JAVA_VERSION"
    else
        sudo apt update
        sudo apt install -y openjdk-17-jdk
        
        # 设置JAVA_HOME
        export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
        echo "export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64" >> ~/.bashrc
        echo "export PATH=\$PATH:\$JAVA_HOME/bin" >> ~/.bashrc
        
        print_success "Java JDK 17 安装完成"
        print_success "Java JDK 17 installation completed"
    fi
}

# 安装Android SDK
install_android_sdk() {
    print_status "安装Android SDK..."
    print_status "Installing Android SDK..."
    
    ANDROID_HOME="/opt/android-sdk"
    
    if [ -d "$ANDROID_HOME" ]; then
        print_warning "Android SDK目录已存在: $ANDROID_HOME"
        print_warning "Android SDK directory already exists: $ANDROID_HOME"
    else
        # 创建Android SDK目录
        sudo mkdir -p $ANDROID_HOME
        cd $ANDROID_HOME
        
        # 下载Android命令行工具
        print_status "下载Android命令行工具..."
        print_status "Downloading Android command line tools..."
        sudo wget -q https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip
        sudo unzip -q commandlinetools-linux-9477386_latest.zip
        sudo rm commandlinetools-linux-9477386_latest.zip
        
        # 重新组织目录结构
        sudo mkdir -p cmdline-tools/latest
        sudo mv cmdline-tools/* cmdline-tools/latest/ 2>/dev/null || true
        
        # 设置权限
        sudo chown -R $USER:$USER $ANDROID_HOME
        sudo chmod -R 755 $ANDROID_HOME
        
        print_success "Android SDK下载完成"
        print_success "Android SDK download completed"
    fi
    
    # 设置环境变量
    export ANDROID_HOME=$ANDROID_HOME
    export ANDROID_SDK_ROOT=$ANDROID_HOME
    export PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools
    
    echo "export ANDROID_HOME=$ANDROID_HOME" >> ~/.bashrc
    echo "export ANDROID_SDK_ROOT=\$ANDROID_HOME" >> ~/.bashrc
    echo "export PATH=\$PATH:\$ANDROID_HOME/cmdline-tools/latest/bin:\$ANDROID_HOME/platform-tools" >> ~/.bashrc
    
    # 安装必需的SDK组件
    print_status "安装SDK组件..."
    print_status "Installing SDK components..."
    
    yes | $ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager --sdk_root=$ANDROID_HOME \
        "platform-tools" \
        "platforms;android-34" \
        "build-tools;34.0.0" \
        "platforms;android-24" \
        "build-tools;30.0.3" 2>/dev/null || true
    
    print_success "Android SDK安装完成"
    print_success "Android SDK installation completed"
}

# 安装其他必需工具
install_tools() {
    print_status "安装其他必需工具..."
    print_status "Installing other required tools..."
    
    sudo apt install -y wget unzip curl git
    
    print_success "工具安装完成"
    print_success "Tools installation completed"
}

# 验证安装
verify_installation() {
    print_status "验证安装..."
    print_status "Verifying installation..."
    
    # 检查Java
    if command -v java &> /dev/null; then
        JAVA_VERSION=$(java -version 2>&1 | head -n1 | cut -d'"' -f2)
        print_success "✓ Java: $JAVA_VERSION"
    else
        print_error "✗ Java未安装"
        return 1
    fi
    
    # 检查Android SDK
    if [ -f "$ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager" ]; then
        print_success "✓ Android SDK: $ANDROID_HOME"
    else
        print_error "✗ Android SDK未安装"
        return 1
    fi
    
    # 检查必需的SDK组件
    if [ -d "$ANDROID_HOME/platforms/android-34" ]; then
        print_success "✓ Android Platform 34"
    else
        print_warning "⚠ Android Platform 34未安装"
    fi
    
    if [ -d "$ANDROID_HOME/build-tools/34.0.0" ]; then
        print_success "✓ Build Tools 34.0.0"
    else
        print_warning "⚠ Build Tools 34.0.0未安装"
    fi
    
    print_success "安装验证完成"
    print_success "Installation verification completed"
}

# 更新项目配置
update_project_config() {
    print_status "更新项目配置..."
    print_status "Updating project configuration..."
    
    # 更新local.properties
    cat > local.properties << EOF
# Android SDK路径
sdk.dir=$ANDROID_HOME

# API密钥 (可选)
OPENROUTER_API_KEY=your_openrouter_api_key_here
OXFORD_DICT_APP_ID=your_oxford_app_id
OXFORD_DICT_APP_KEY=your_oxford_app_key
EOF
    
    print_success "项目配置更新完成"
    print_success "Project configuration updated"
}

# 主函数
main() {
    echo "=================================================="
    echo "  智能英语学习助手 Android构建环境安装"
    echo "  English Learning Assistant Build Environment"
    echo "=================================================="
    echo ""
    
    # 检查sudo权限
    check_sudo
    
    # 安装组件
    install_tools
    install_java
    install_android_sdk
    
    # 更新项目配置
    update_project_config
    
    # 验证安装
    verify_installation
    
    echo ""
    echo "=================================================="
    print_success "🎉 Android构建环境安装完成！"
    print_success "🎉 Android build environment setup completed!"
    echo "=================================================="
    echo ""
    echo "下一步:"
    echo "Next steps:"
    echo "1. 重新加载环境变量: source ~/.bashrc"
    echo "1. Reload environment: source ~/.bashrc"
    echo "2. 构建APK: ./build-apk.sh"
    echo "2. Build APK: ./build-apk.sh"
    echo ""
    
    # 立即测试构建
    read -p "是否立即尝试构建APK? (y/N): " -n 1 -r
    echo
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        print_status "开始构建APK..."
        print_status "Starting APK build..."
        
        # 重新加载环境变量
        source ~/.bashrc 2>/dev/null || true
        export ANDROID_HOME=$ANDROID_HOME
        export ANDROID_SDK_ROOT=$ANDROID_HOME
        export PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools
        
        # 构建APK
        chmod +x ./build-apk.sh
        ./build-apk.sh
    fi
}

# 运行主函数
main "$@"