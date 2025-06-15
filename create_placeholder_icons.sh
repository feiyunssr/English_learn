#!/bin/bash

# 创建临时占位图标的脚本
echo "Creating placeholder icons..."

# 创建一个1x1像素的PNG文件
# Base64编码的最小PNG文件
PNG_BASE64="iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mNkYPhfDwAChwGA60e6kgAAAABJRU5ErkJggg=="

# 创建各个分辨率的目录
res_dir="app/src/main/res"
for dir in mipmap-hdpi mipmap-mdpi mipmap-xhdpi mipmap-xxhdpi mipmap-xxxhdpi; do
    mkdir -p "$res_dir/$dir"
    # 解码Base64到PNG文件
    echo "$PNG_BASE64" | base64 -d > "$res_dir/$dir/ic_launcher.png"
    echo "$PNG_BASE64" | base64 -d > "$res_dir/$dir/ic_launcher_round.png"
done

echo "Placeholder icons created successfully!"