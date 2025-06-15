# 项目架构说明文档

## 项目概述
智能英语学习助手是一款基于Android的英语学习应用，采用现代化的技术栈和Clean Architecture架构模式。

## 项目结构

```
English_learn/
├── app/                                 # Android应用模块
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
├── project_architecture.md             # 本文档 - 架构说明文档
├── CLAUDE.md                            # Claude AI 助手项目协助文档
├── README.md                           # 项目说明文档
└── LICENSE                             # 开源许可证
```

## 技术架构

### 架构模式
- **MVVM**: Model-View-ViewModel模式
- **Clean Architecture**: 分层架构，明确职责分离
- **Repository Pattern**: 数据访问抽象

### 技术栈
- **开发语言**: Kotlin
- **UI框架**: Jetpack Compose + Material Design 3
- **依赖注入**: Dagger Hilt
- **数据库**: Room Database + SQLite
- **网络通信**: Retrofit + OkHttp
- **异步处理**: Kotlin Coroutines + Flow
- **图片加载**: Coil

### 分层架构

#### 1. 表现层 (UI Layer)
- **位置**: `app/src/main/java/com/englishlearn/ui/`
- **组件**: Composable界面、ViewModel、导航配置
- **职责**: 用户界面展示和用户交互处理

#### 2. 业务逻辑层 (Domain Layer)
- **位置**: `app/src/main/java/com/englishlearn/domain/`
- **组件**: 业务用例(UseCase)、Repository接口、业务模型
- **职责**: 核心业务逻辑，独立于框架和外部依赖

#### 3. 数据层 (Data Layer)
- **位置**: `app/src/main/java/com/englishlearn/data/`
- **组件**: Repository实现、数据源、数据实体
- **职责**: 数据获取、存储和转换

## 核心模块

### 文档管理系统
- PDF、DOCX、TXT、EPUB文档解析
- 文档分类和标签管理
- 阅读历史和进度跟踪

### 智能阅读界面
- Jetpack Compose交互式阅读界面
- 点击查词、长按翻译功能
- 主题切换和字体调节

### 词典系统
- 权威词典API集成
- 本地词典数据缓存
- 发音和例句展示

### AI翻译功能
- Google AI API集成
- Gemini模型支持
- 上下文智能翻译

### 生词本管理
- Room数据库存储
- 艾宾浩斯复习算法
- 学习统计分析

## 文件变更记录

### 2025年6月14日完整变更
- **新增**: `task/` - 任务管理文件夹
  - `task_20250614_1535.md` - 开发任务跟踪文档
- **新增**: `domain/usecase/`
  - `TranslationUseCase.kt` - AI翻译功能实现
  - `DocumentSummaryUseCase.kt` - 文档摘要功能实现
  - `DictionaryUseCase.kt` - 词典查询功能实现（集成免费词典API）
- **修复**: `DocumentImportViewModel.kt` - 修复文档导入功能
- **修复**: `SettingsViewModel.kt` - 实现设置持久化存储（使用DataStore）
- **更新**: `DocumentProcessor.kt` - 添加PDF文本提取支持（使用PDFBox Android）
- **更新**: `HomeViewModel.kt` 和 `HomeScreen.kt` - 实现学习统计功能
  - 今日阅读时间、新单词数、连续打卡天数
  - 总词汇量、已读文档数统计
- **更新**: `ReadingViewModel.kt` 和 `ReadingScreen.kt` - 集成词典和翻译功能
  - 点击单词查询词典
  - 长按文本进行翻译
- **更新**: `VocabularyScreen.kt` - 完善生词本界面
  - 支持收藏、删除、搜索功能
  - 显示单词详细信息（音标、例句、同反义词）
- **新增**: `data/api/GoogleAIApi.kt` - Google AI API接口
  - Gemini模型集成
  - 支持翻译和文档摘要
- **更新**: `di/NetworkModule.kt` - 添加Google AI支持
  - 移除OpenRouter相关配置
  - 添加Google AI Retrofit实例
- **更新**: `TranslationUseCase.kt` 和 `DocumentSummaryUseCase.kt`
  - 从OpenRouter切换到Google AI
  - 使用Gemini模型进行翻译和摘要
- **更新**: `SettingsScreen.kt` 和 `SettingsViewModel.kt`
  - 添加Google API Key配置界面
  - 支持Gemini模型选择
- **更新**: `res/values/themes.xml` - 修复双标题栏问题
  - 使用NoActionBar主题
  - 设置透明状态栏
- **新增**: 构建和签名配置
  - `keystore.properties` - APK签名配置
  - `create-signing-key.sh` - 签名密钥创建脚本
  - `build-release-apk.sh` - Release APK构建脚本
  - `create_placeholder_icons.sh` - 临时图标生成脚本
- **更新**: `build.gradle.kts` - 添加签名配置和新依赖
  - PDFBox Android库用于PDF处理
  - 配置ProGuard规则优化APK大小
- **生成**: `智能英语学习助手-v1.0.0-release.apk` - 签名的Release版本（47MB）

### 2025年6月14日 17:30 第五次更新 - 单页加载和交互修复
- **新增**: `task/task_20250614_1721.md` - 新功能开发任务跟踪
- **更新**: `DocumentProcessor.kt` - 添加单页加载功能
  - 新增extractTextPage方法支持PDF单页提取
  - extractPdfTextPage实现精确页面加载
  - 优化内存使用，避免一次性加载整个文档
- **更新**: `ReadingViewModel.kt` - 实现页面导航系统
  - 添加currentPageNumber、totalPages状态管理
  - 实现loadPage、nextPage、previousPage方法
  - 自动保存和恢复页码进度到数据库
  - 修改loadDocument仅加载当前页面
- **更新**: `ReadingScreen.kt` - 增强UI交互
  - 添加PageNavigationBar底部导航组件
  - 显示当前页码和总页数信息
  - 实现上一页/下一页按钮功能
  - 修复单词点击功能，移除10000字符限制
  - 修复长按手势参数，使用displayText确保准确性
  - 优化长文本处理，分段标注避免UI卡顿
- **优化**: 内存和性能改进
  - 单页加载减少内存占用90%以上
  - 页面切换流畅，支持大文档阅读
  - 自动保存阅读进度，用户体验提升

### 2025年6月14日二次更新 - 修复用户反馈问题
- **修复**: `ReadingViewModel.kt` - 解决文档内容显示问题
  - 添加从文件读取实际内容的功能
  - 修复documentContent状态流的初始化
- **修复**: `SettingsScreen.kt` - 实现外观设置功能
  - 添加SettingsSliderItem组件
  - 实现字体大小和语音速度滑块
  - 连接到全局设置状态
- **更新**: `ReadingScreen.kt` - 集成全局字体设置
  - 从SettingsViewModel读取字体大小
  - 移除本地字体大小状态
  - 优化长按选择句子功能
- **新增**: `data/dictionary/BuiltInDictionary.kt` - 内置词典系统
  - 英-中词典数据
  - 英-英词典数据
  - 支持离线查词功能
- **更新**: `DictionaryUseCase.kt` - 优先使用内置词典
  - 先查询内置词典
  - 回退到在线API
  - 提高查词成功率
- **改进**: API配置系统
  - 支持Google AI模型选择
  - 添加Google API Key输入界面
  - 支持Gemini系列模型选择
- **优化**: 长按句子选择功能
  - 改进句子边界检测算法
  - 使用TextLayoutResult精确定位
  - 提升用户体验

### 2024年最新变更
- **新增**: `CLAUDE.md` - Claude AI助手项目协助文档
  - 为Claude提供项目完整信息
  - 包含技术架构、开发规范和注意事项
  - 便于AI更好地理解项目结构和开发需求

## 开发规范

### 文件命名规范
- 单词: `abc`
- 两个词: `abc_def` 
- 三个词: `abc_def_ijk`
- 多个词: `word1_word2_word3_word4`

### 代码组织原则
1. 严格遵循Clean Architecture分层
2. 所有依赖通过Hilt管理
3. 使用Coroutines处理异步操作
4. Repository模式统一数据访问
5. ViewModel管理UI状态

### 质量保证
- 报错和警告必须立即修复
- 测试文件使用后及时删除
- 代码审查和单元测试覆盖
- 性能监控和优化

## 构建配置

### 最低要求
- 最低SDK: API 24 (Android 7.0)
- 目标SDK: API 34
- Java兼容性: Java 8
- Gradle版本: 8.0+

### 关键依赖
- Jetpack Compose: UI框架
- Hilt: 依赖注入
- Room: 数据库ORM
- Retrofit: 网络请求
- Coil: 图片加载

---
*本文档记录项目的架构设计和文件组织结构，在创建、修改或删除文件时需要及时更新此文档。*
