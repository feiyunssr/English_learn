# 智能英语学习助手 📱

一款基于人工智能技术的Android英语学习应用，专为英语学习者设计，提供智能化的阅读学习体验。

## 🌟 项目特色

- **智能文档导入**: 支持PDF、DOCX、TXT、EPUB等多种格式
- **权威词典集成**: 内置牛津、柯林斯等权威英汉/英英词典
- **AI智能翻译**: 基于OpenRouter API，支持GPT-4、Claude等多种模型
- **语音播放功能**: 单词发音、翻译朗读，支持语速调节
- **文档智能摘要**: AI驱动的文档内容分析和关键信息提取
- **个性化学习**: 生词本、学习进度跟踪、成就系统
- **现代化界面**: 基于Material Design，支持暗夜模式

## 📋 核心功能

### 📚 文档管理
- **多格式支持**: PDF、DOC/DOCX、TXT、EPUB等主流文档格式
- **多种导入方式**:
  - 本地文件选择
  - 云存储导入（Google Drive、OneDrive）
  - URL链接导入（新闻、学术期刊）
  - 拍照OCR识别
- **智能分类**: 论文、新闻、小说等自动分类管理
- **阅读进度**: 自动记录阅读位置和进度

### 📖 智能阅读
- **点击查词**: 即点即查，支持词根词缀分析
- **长按翻译**: 智能句子识别，上下文翻译
- **语音播放**: 
  - 英文单词真人发音
  - 翻译结果中英文朗读
  - 可调节语速和音调
- **阅读设置**: 字体大小、行间距、背景色自定义

### 📚 权威词典
推荐使用以下权威词典资源：

#### 英英词典
- **Oxford English Dictionary (OED)**: 英语界最权威词典
- **Merriam-Webster Dictionary**: 美国权威词典
- **Cambridge Advanced Learner's Dictionary**: 学习者首选

#### 英汉词典
- **牛津高阶英汉双解词典**: 学习者必备
- **柯林斯COBUILD高阶英汉双解学习词典**: 释义清晰易懂
- **朗文当代高级英语词典**: 词汇应用丰富

#### 词典功能特性
- 🔊 **音标显示**: IPA国际音标标准显示
- 🎵 **发音播放**: 英美音真人发音
- 📝 **详细释义**: 中英文对照解释
- 📄 **例句展示**: 丰富的使用示例
- 🔗 **同义反义**: 词汇扩展学习
- ⭐ **词频标注**: CEFR等级、柯林斯星级

### 🤖 AI智能功能
- **智能翻译**: 
  - 上下文理解翻译
  - 专业术语精确翻译
  - 支持多种AI模型选择
- **文档摘要**: 
  - 自动生成文档概要
  - 关键词提取
  - 章节要点总结
- **学习建议**: 基于用户水平的个性化建议

### 📊 学习管理
- **生词本**: 自动收集查询词汇，支持复习
- **学习统计**: 阅读时长、查词次数等数据分析
- **进度跟踪**: 个人学习轨迹记录
- **成就系统**: 学习激励和等级提升

## 🛠️ 技术架构

### 开发技术栈
- **开发语言**: Kotlin
- **UI框架**: Jetpack Compose
- **架构模式**: MVVM + Clean Architecture
- **依赖注入**: Hilt
- **数据库**: Room Database + SQLite
- **网络请求**: Retrofit + OkHttp
- **异步处理**: Coroutines + Flow

### 核心依赖
- **AI服务**: OpenRouter API (支持GPT-4, Claude, Gemini等)
- **TTS语音**: Google Text-to-Speech
- **OCR识别**: Google ML Kit
- **文档解析**: Apache PDFBox, Apache POI
- **图像加载**: Glide
- **JSON处理**: Gson

### 系统要求
- **Android版本**: Android 7.0+ (API Level 24+)
- **内存需求**: 最低2GB RAM
- **存储空间**: 最低500MB可用空间
- **网络要求**: 支持HTTPS的网络连接

## 📁 项目结构

```
app/
├── src/main/
│   ├── java/com/englishlearning/app/
│   │   ├── data/              # 数据层
│   │   │   ├── local/         # 本地数据库
│   │   │   ├── remote/        # 网络API
│   │   │   └── repository/    # 数据仓库
│   │   ├── domain/            # 业务逻辑层
│   │   │   ├── model/         # 数据模型
│   │   │   ├── repository/    # 仓库接口
│   │   │   └── usecase/       # 用例
│   │   ├── presentation/      # 表现层
│   │   │   ├── ui/            # UI组件
│   │   │   ├── viewmodel/     # ViewModel
│   │   │   └── navigation/    # 导航
│   │   └── di/                # 依赖注入
│   └── res/                   # 资源文件
├── docs/                      # 项目文档
│   ├── product_requirements_document.md
│   ├── technical_design_document.md
│   └── api_documentation.md
└── README.md
```

## 🚀 快速开始

### 环境准备
1. **Android Studio**: Hedgehog | 2023.1.1 或更高版本
2. **JDK**: JDK 8 或更高版本
3. **Gradle**: 8.0 或更高版本

### API密钥配置
1. 在项目根目录创建 `local.properties` 文件
2. 添加以下配置：
```properties
OPENROUTER_API_KEY=your_openrouter_api_key
AZURE_SPEECH_KEY=your_azure_speech_key (可选)
```

### 构建运行
```bash
# 克隆项目
git clone https://github.com/your-username/english-learning-app.git

# 进入项目目录
cd english-learning-app

# 使用Android Studio打开项目
# 或者使用命令行构建
./gradlew assembleDebug
```

## 📚 文档说明

- **[产品需求文档](docs/product_requirements_document.md)**: 详细的功能需求和用户故事
- **[技术设计文档](docs/technical_design_document.md)**: 系统架构和技术实现方案
- **[API集成文档](docs/api_documentation.md)**: 第三方服务集成指南

## 🤝 贡献指南

欢迎参与项目贡献！请遵循以下步骤：

1. Fork 本仓库
2. 创建功能分支 (`git checkout -b feature/amazing-feature`)
3. 提交更改 (`git commit -m 'Add some amazing feature'`)
4. 推送到分支 (`git push origin feature/amazing-feature`)
5. 创建 Pull Request

### 代码规范
- 遵循 Kotlin 官方编码规范
- 使用有意义的变量和函数命名
- 添加必要的注释和文档
- 确保代码通过 lint 检查

## 📄 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情

## 📞 联系方式

- **项目作者**: [您的姓名]
- **邮箱**: your.email@example.com
- **GitHub**: [@your-username](https://github.com/your-username)

## 🙏 致谢

感谢以下开源项目和服务：
- [OpenRouter](https://openrouter.ai/) - AI模型API聚合服务
- [Oxford Dictionary API](https://developer.oxforddictionaries.com/) - 权威词典数据
- [Google ML Kit](https://developers.google.com/ml-kit) - 机器学习工具包
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - 现代化UI框架

## 📈 项目状态

![GitHub stars](https://img.shields.io/github/stars/your-username/english-learning-app)
![GitHub forks](https://img.shields.io/github/forks/your-username/english-learning-app)
![GitHub issues](https://img.shields.io/github/issues/your-username/english-learning-app)
![GitHub license](https://img.shields.io/github/license/your-username/english-learning-app)

---

🌟 **如果这个项目对您有帮助，请给我们一个Star！** ⭐