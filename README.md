# 智能英语学习助手 📱

一款基于人工智能技术的Android英语学习应用，专为英语学习者设计，通过阅读英文资料提供智能化的学习体验。

## 🌟 项目特色

- **智能文档导入**: 支持PDF、DOCX、TXT、EPUB等多种格式文档导入
- **权威词典集成**: 集成牛津、韦氏等权威英汉/英英词典
- **AI智能翻译**: 基于OpenRouter API，支持GPT-4、Claude、Gemini等多种AI模型
- **个性化生词本**: 自动收集学习词汇，支持复习和进度跟踪
- **学习统计分析**: 详细的学习数据统计和进度可视化
- **现代化界面**: 基于Material Design 3，支持暗夜模式和无障碍功能

## 📋 核心功能

### 📚 文档管理系统
- **多格式支持**: 
  - PDF文档阅读和文本提取
  - Microsoft Word文档 (DOC/DOCX)
  - 纯文本文件 (TXT)
  - 电子书格式 (EPUB)
  - 网络链接文章导入

- **智能导入方式**:
  - 本地文件选择器导入
  - 云存储服务集成 (Google Drive、OneDrive)
  - URL链接在线导入
  - 拍照OCR文字识别导入

- **文档组织管理**:
  - 智能分类系统 (论文、新闻、小说、技术文档等)
  - 自定义标签管理
  - 收藏夹功能
  - 阅读历史记录和进度跟踪

### 📖 智能阅读界面
- **交互式阅读体验**:
  - 点击单词即时查询词典
  - 长按自动识别句子边界进行翻译
  - 可调节字体大小、行间距、背景色
  - 护眼模式和夜间阅读模式

- **语音功能**:
  - 英文单词标准发音播放
  - 翻译结果TTS朗读
  - 可调节语速和音调
  - 支持英美音切换

### 📚 权威词典系统

本应用集成多个权威词典资源，为用户提供准确、全面的词汇释义：

#### 英英词典
- **Oxford English Dictionary (OED)**: 英语界最权威的词典，提供词汇的历史演变和精确定义
- **Merriam-Webster Dictionary**: 美国权威词典，特别适合美式英语学习
- **Cambridge Advanced Learner's Dictionary**: 专为英语学习者设计

#### 英汉词典
- **牛津高阶英汉双解词典**: 中国英语学习者首选，释义准确易懂
- **柯林斯COBUILD高阶英汉双解学习词典**: 采用整句释义法，语境丰富
- **朗文当代高级英语词典**: 词汇应用示例丰富

#### 词典功能特性
- 🔊 **标准音标**: IPA国际音标标准显示
- 🎵 **真人发音**: 英美音标准发音播放
- 📝 **详细释义**: 中英文对照，多义项完整展示
- 📄 **例句展示**: 丰富的真实语境使用示例
- 🔗 **词汇扩展**: 同义词、反义词、词根词缀分析
- ⭐ **难度标注**: CEFR等级、柯林斯星级、词频统计
- 📚 **词汇变形**: 时态变化、复数形式、比较级等

### 🤖 AI智能功能
- **上下文翻译**: 
  - 基于文档上下文的智能翻译
  - 专业术语和学术论文优化
  - 支持多种AI模型切换 (GPT-4, Claude-3, Gemini等)
  - 翻译质量评估和历史记录

- **文档智能分析**: 
  - AI驱动的文档内容摘要生成
  - 关键词自动提取
  - 章节要点总结
  - 文档难度等级评估
  - 个性化学习建议

### 📊 个性化学习管理
- **智能生词本**:
  - 阅读过程中自动收集查询单词
  - 艾宾浩斯遗忘曲线复习提醒
  - 单词掌握程度追踪
  - 词汇分类和标签管理

- **学习数据统计**:
  - 每日/每周/每月阅读时长统计
  - 查词频次和学习轨迹
  - 词汇量增长曲线
  - 阅读速度和理解能力分析

- **成就激励系统**:
  - 学习里程碑成就
  - 连续学习天数记录
  - 词汇掌握等级提升
  - 社区排行榜 (可选)

## 🛠️ 技术架构

### 开发技术栈
- **开发语言**: Kotlin
- **UI框架**: Jetpack Compose + Material Design 3
- **架构模式**: MVVM + Clean Architecture + Repository Pattern
- **依赖注入**: Dagger Hilt
- **数据库**: Room Database + SQLite
- **网络通信**: Retrofit + OkHttp
- **异步处理**: Kotlin Coroutines + Flow
- **图片加载**: Coil (Compose优化)

### 第三方服务集成
- **AI翻译服务**: OpenRouter API (统一多个AI模型接口)
- **语音合成**: Google Text-to-Speech / Azure Cognitive Services
- **OCR文字识别**: Google ML Kit OCR
- **云存储**: Firebase Storage
- **词典API**: Oxford Dictionary API / Free Dictionary API

### 性能优化
- **启动时间**: 应用冷启动 < 3秒
- **响应速度**: UI交互响应 < 200ms
- **内存管理**: 峰值内存使用 < 512MB
- **离线功能**: 基础词典和已下载文档支持离线使用
- **数据缓存**: 智能缓存策略，减少网络请求

### 系统要求
- **Android版本**: Android 7.0+ (API Level 24+)
- **内存需求**: 最低3GB RAM推荐
- **存储空间**: 最低1GB可用空间
- **网络要求**: 支持HTTPS的稳定网络连接

## 📁 项目结构

```
English_learn/
├── app/
│   ├── src/main/
│   │   ├── java/com/englishlearn/
│   │   │   ├── data/                    # 数据层
│   │   │   │   ├── api/                 # 网络API接口
│   │   │   │   ├── dao/                 # 数据库访问对象
│   │   │   │   ├── database/            # Room数据库配置
│   │   │   │   ├── entities/            # 数据库实体
│   │   │   │   └── repository/          # Repository实现
│   │   │   ├── domain/                  # 业务逻辑层
│   │   │   │   ├── repository/          # Repository接口
│   │   │   │   └── usecase/             # 业务用例
│   │   │   ├── ui/                      # 表现层
│   │   │   │   ├── navigation/          # 导航配置
│   │   │   │   ├── screens/             # Compose界面
│   │   │   │   ├── theme/               # 主题配置
│   │   │   │   └── viewmodels/          # ViewModel
│   │   │   ├── di/                      # 依赖注入模块
│   │   │   ├── utils/                   # 工具类
│   │   │   └── EnglishLearnApplication.kt
│   │   └── res/                         # 资源文件
│   │       ├── layout/                  # 布局文件
│   │       ├── values/                  # 字符串、颜色等资源
│   │       └── drawable/                # 图标和图片资源
│   ├── build.gradle.kts                 # 应用级构建配置
│   └── proguard-rules.pro              # 代码混淆规则
├── docs/                                # 项目文档
│   ├── product_requirements_document.md # 产品需求文档
│   └── English_learn.code-workspace    # VS Code工作区配置
├── build.gradle.kts                     # 项目级构建配置
├── gradle.properties                    # Gradle配置属性
├── settings.gradle.kts                  # 项目设置
├── project_architecture.md             # 架构说明文档
└── README.md                           # 项目说明文档
```

## 🚀 使用指南

### 安装和启动

#### 开发环境要求
1. **Android Studio**: Hedgehog 2023.1.1 或更高版本
2. **JDK**: OpenJDK 8 或更高版本
3. **Android SDK**: API Level 24 (Android 7.0) 及以上
4. **Gradle**: 8.0 或更高版本

#### 环境配置步骤
```bash
# 1. 克隆项目仓库
git clone https://github.com/your-username/English_learn.git

# 2. 进入项目目录
cd English_learn

# 3. 配置API密钥 (在项目根目录创建 local.properties 文件)
echo "OPENROUTER_API_KEY=your_openrouter_api_key_here" >> local.properties
echo "OXFORD_DICT_APP_ID=your_oxford_app_id" >> local.properties
echo "OXFORD_DICT_APP_KEY=your_oxford_app_key" >> local.properties

# 4. 使用Android Studio打开项目或命令行构建
./gradlew assembleDebug
```

### 应用使用方法

#### 1. 首次启动设置
- 打开应用后，系统会引导您完成初始设置
- 选择学习偏好 (英式/美式发音、AI翻译模型等)
- 授予必要权限 (存储、麦克风等)

#### 2. 文档导入和管理

**导入本地文档**:
1. 点击主界面右下角的 "+" 按钮
2. 选择 "本地文件" 选项
3. 从文件管理器中选择支持的文档格式
4. 输入文档标题和分类
5. 确认导入，系统会自动处理文档

**从网络导入**:
1. 点击主界面右下角的 "+" 按钮
2. 选择 "网络链接" 选项
3. 输入文章或文档的URL链接
4. 设置标题和分类
5. 确认导入，应用会自动下载并处理内容

**文档分类管理**:
- 在文档库中，可以按分类筛选文档
- 支持自定义标签和分类
- 可以收藏重要文档到收藏夹
- 搜索功能支持标题、内容和标签搜索

#### 3. 智能阅读功能

**基础阅读操作**:
- 打开任意文档开始阅读
- 滑动翻页或使用页面导航
- 调整字体大小和行间距 (设置菜单)
- 切换日间/夜间阅读模式

**词汇查询**:
- **单词查询**: 点击任意英文单词，立即显示详细释义
- **发音播放**: 点击音标图标播放标准发音
- **添加生词本**: 查询后自动添加到生词本，可手动管理

**智能翻译**:
- **句子翻译**: 长按文本自动识别句子边界
- **段落翻译**: 选择多行文本进行整段翻译
- **AI模型选择**: 在设置中切换不同AI翻译模型
- **翻译历史**: 查看和管理历史翻译记录

#### 4. 生词本管理

**词汇学习**:
1. 进入生词本查看收集的词汇
2. 点击词汇查看详细信息 (释义、例句、同义词等)
3. 播放单词发音进行听力练习
4. 标记已掌握的词汇或添加到收藏

**复习系统**:
- 系统根据艾宾浩斯遗忘曲线推荐复习时间
- 支持按难度等级筛选词汇
- 定期复习提醒和学习统计

#### 5. 学习统计和分析

**数据统计**:
- 在主界面查看今日学习统计
- 详细的学习报告 (每日/每周/每月)
- 词汇量增长曲线
- 阅读速度和理解能力分析

**个性化建议**:
- 基于学习数据的个性化推荐
- 学习计划制定和目标设置
- 薄弱环节识别和改进建议

### 高级功能使用

#### AI功能配置
1. 进入设置页面
2. 在"AI服务配置"中输入OpenRouter API密钥
3. 选择偏好的AI模型 (GPT-4推荐准确性，Claude推荐上下文理解)
4. 调整翻译参数 (创造性、准确性等)

#### 离线功能
- 已导入的文档支持离线阅读
- 生词本支持离线查看和管理
- 基础词典可下载离线包

#### 数据备份和同步
- 支持本地数据备份
- 可选择备份到云存储服务
- 跨设备数据同步 (需要登录账户)

## 🎯 最佳实践建议

### 学习效率优化
1. **制定学习计划**: 每天设置固定的阅读时间和词汇学习目标
2. **分级阅读**: 从简单文档开始，逐步提高难度
3. **主动学习**: 充分利用查词和翻译功能，不要跳过不懂的内容
4. **定期复习**: 遵循遗忘曲线，定期复习生词本中的词汇
5. **多样化阅读**: 阅读不同类型的文档 (新闻、文学、科技等)

### 功能使用技巧
1. **智能翻译**: 优先使用句子翻译理解整体含义，再查询关键词汇
2. **生词管理**: 定期整理生词本，删除已熟练掌握的词汇
3. **阅读设置**: 根据环境光线调整界面亮度和对比度
4. **语音功能**: 利用发音功能提高听力和口语能力

## 📚 项目文档

### 开发文档
- **[产品需求文档](docs/product_requirements_document.md)**: 详细的功能需求、用户故事和验收标准
- **[项目架构说明](project_architecture.md)**: 系统架构设计和技术选型说明

### 用户文档
- **用户手册**: 详细的功能使用说明和常见问题解答
- **API集成指南**: 第三方服务集成配置和故障排除

## 🤝 贡献指南

我们欢迎社区贡献！参与项目贡献请遵循以下步骤：

### 参与方式
1. **问题反馈**: 在Issues中报告bug或提出功能建议
2. **代码贡献**: Fork项目并提交Pull Request
3. **文档改进**: 帮助完善用户文档和开发文档
4. **翻译支持**: 协助应用界面和文档的多语言翻译

### 开发流程
```bash
# 1. Fork项目到个人仓库
# 2. 克隆Fork的仓库
git clone https://github.com/your-username/English_learn.git

# 3. 创建功能分支
git checkout -b feature/amazing-feature

# 4. 进行开发并提交
git add .
git commit -m "Add: 实现了令人惊叹的新功能"

# 5. 推送到个人仓库
git push origin feature/amazing-feature

# 6. 在GitHub上创建Pull Request
```

### 代码规范
- **Kotlin编码风格**: 遵循官方Kotlin编码规范
- **注释规范**: 关键函数和复杂逻辑必须添加注释
- **命名规范**: 使用有意义的变量和函数名称
- **提交信息**: 使用清晰的提交信息描述变更内容
- **测试覆盖**: 新功能需要包含相应的单元测试

## 📄 开源许可

本项目采用 MIT 许可证开源，详情请查看 [LICENSE](LICENSE) 文件。

MIT许可证允许您：
- ✅ 商业使用
- ✅ 修改代码
- ✅ 分发代码
- ✅ 私人使用

## 📞 联系和支持

### 获取帮助
- **GitHub Issues**: 报告bug和功能请求
- **讨论区**: 在GitHub Discussions中进行技术讨论
- **邮件支持**: support@englishlearn.app

### 社区和交流
- **官方QQ群**: 123456789
- **微信交流群**: 扫描二维码加群
- **开发者博客**: [技术分享和更新日志]

## 🙏 致谢

感谢以下开源项目和服务提供商：

### 技术支持
- **[OpenRouter](https://openrouter.ai/)**: 提供统一的AI模型API接口
- **[Oxford Dictionary API](https://developer.oxforddictionaries.com/)**: 权威英语词典数据
- **[Google ML Kit](https://developers.google.com/ml-kit)**: 机器学习和OCR功能
- **[Jetpack Compose](https://developer.android.com/jetpack/compose)**: 现代化Android UI框架

### 词典资源
- **牛津大学出版社**: 提供权威词典内容
- **柯林斯出版社**: 高质量英语学习词典
- **剑桥大学出版社**: 学习者词典标准制定者

### 开源库
- **Retrofit**: 优雅的HTTP客户端
- **Room**: 强大的SQLite数据库框架
- **Hilt**: 简化的依赖注入框架
- **Coil**: 高效的图片加载库

## 📈 项目状态

[![GitHub Stars](https://img.shields.io/github/stars/your-username/English_learn?style=social)](https://github.com/your-username/English_learn/stargazers)
[![GitHub Forks](https://img.shields.io/github/forks/your-username/English_learn?style=social)](https://github.com/your-username/English_learn/network/members)
[![GitHub Issues](https://img.shields.io/github/issues/your-username/English_learn)](https://github.com/your-username/English_learn/issues)
[![GitHub License](https://img.shields.io/github/license/your-username/English_learn)](https://github.com/your-username/English_learn/blob/main/LICENSE)
[![Android CI](https://github.com/your-username/English_learn/workflows/Android%20CI/badge.svg)](https://github.com/your-username/English_learn/actions)

### 开发进度
- ✅ **Phase 1**: 核心阅读和词典功能 (已完成)
- ✅ **Phase 2**: 文档导入和管理系统 (已完成)
- ✅ **Phase 3**: 生词本和基础学习功能 (已完成)
- 🚧 **Phase 4**: AI翻译和智能摘要 (开发中)
- 📋 **Phase 5**: 高级学习分析和社交功能 (规划中)

### 版本发布计划
- **v1.0.0 Beta**: 核心功能测试版本
- **v1.0.0**: 正式发布版本，包含完整基础功能
- **v1.1.0**: 增强AI功能和用户体验优化
- **v1.2.0**: 社交功能和高级学习分析

---

🌟 **如果这个项目对您的英语学习有帮助，请给我们一个Star！您的支持是我们持续改进的动力！** ⭐

📱 **立即下载体验智能英语学习的魅力，让AI助力您的英语进步之路！**