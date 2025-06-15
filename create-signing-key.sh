#!/bin/bash

# 创建APK签名密钥脚本
# Create APK signing key script

echo "🔐 创建APK签名密钥..."
echo "🔐 Creating APK signing key..."

KEYSTORE_FILE="english-learn-keystore.jks"
KEY_ALIAS="english-learn-key"

if [ -f "$KEYSTORE_FILE" ]; then
    echo "⚠️ 密钥库文件已存在: $KEYSTORE_FILE"
    echo "⚠️ Keystore file already exists: $KEYSTORE_FILE"
    read -p "是否要覆盖现有密钥库? (y/N): " -n 1 -r
    echo
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        echo "操作已取消"
        echo "Operation cancelled"
        exit 0
    fi
    rm -f "$KEYSTORE_FILE"
fi

echo "请输入密钥库信息 (留空使用默认值):"
echo "Please enter keystore information (leave empty for defaults):"

read -p "密钥库密码 (Keystore password) [englishlearn123]: " KEYSTORE_PASSWORD
KEYSTORE_PASSWORD=${KEYSTORE_PASSWORD:-englishlearn123}

read -p "密钥别名 (Key alias) [$KEY_ALIAS]: " INPUT_ALIAS
KEY_ALIAS=${INPUT_ALIAS:-$KEY_ALIAS}

read -p "密钥密码 (Key password) [englishlearn123]: " KEY_PASSWORD
KEY_PASSWORD=${KEY_PASSWORD:-englishlearn123}

read -p "您的姓名 (Your name) [English Learn Team]: " DNAME_CN
DNAME_CN=${DNAME_CN:-"English Learn Team"}

read -p "组织单位 (Organization unit) [Development]: " DNAME_OU
DNAME_OU=${DNAME_OU:-"Development"}

read -p "组织 (Organization) [English Learn App]: " DNAME_O
DNAME_O=${DNAME_O:-"English Learn App"}

read -p "城市 (City) [Beijing]: " DNAME_L
DNAME_L=${DNAME_L:-"Beijing"}

read -p "省份 (State) [Beijing]: " DNAME_ST
DNAME_ST=${DNAME_ST:-"Beijing"}

read -p "国家代码 (Country code) [CN]: " DNAME_C
DNAME_C=${DNAME_C:-"CN"}

echo ""
echo "🔨 生成密钥库..."
echo "🔨 Generating keystore..."

# 创建密钥库
keytool -genkey -v \
    -keystore "$KEYSTORE_FILE" \
    -alias "$KEY_ALIAS" \
    -keyalg RSA \
    -keysize 2048 \
    -validity 10000 \
    -storepass "$KEYSTORE_PASSWORD" \
    -keypass "$KEY_PASSWORD" \
    -dname "CN=$DNAME_CN, OU=$DNAME_OU, O=$DNAME_O, L=$DNAME_L, ST=$DNAME_ST, C=$DNAME_C"

if [ $? -eq 0 ]; then
    echo "✅ 密钥库创建成功: $KEYSTORE_FILE"
    echo "✅ Keystore created successfully: $KEYSTORE_FILE"
    
    # 创建签名配置文件
    cat > keystore.properties << EOF
storeFile=$KEYSTORE_FILE
storePassword=$KEYSTORE_PASSWORD
keyAlias=$KEY_ALIAS
keyPassword=$KEY_PASSWORD
EOF
    
    echo "📄 签名配置文件已创建: keystore.properties"
    echo "📄 Signing config file created: keystore.properties"
    
    echo ""
    echo "⚠️ 重要提醒:"
    echo "⚠️ Important reminders:"
    echo "1. 请妥善保管密钥库文件和密码"
    echo "1. Please keep keystore file and passwords safe"
    echo "2. 不要将密钥库文件提交到版本控制系统"
    echo "2. Do not commit keystore file to version control"
    echo "3. 建议备份密钥库文件到安全位置"
    echo "3. Backup keystore file to secure location"
    
else
    echo "❌ 密钥库创建失败"
    echo "❌ Keystore creation failed"
    echo "💡 请确保已安装Java并配置好环境变量"
    echo "💡 Please ensure Java is installed and environment variables are configured"
fi