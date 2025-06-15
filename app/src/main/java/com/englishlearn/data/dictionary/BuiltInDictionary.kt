package com.englishlearn.data.dictionary

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BuiltInDictionary @Inject constructor() {
    
    // 使用懒加载避免启动时内存占用
    private val englishChineseDictionary by lazy { 
        mapOf(
        "hello" to DictionaryEntry(
            word = "hello",
            phonetic = "/həˈləʊ/",
            meanings = listOf(
                Meaning(
                    partOfSpeech = "感叹词",
                    definitions = listOf("你好", "喂"),
                    examples = listOf("Hello, how are you?", "Hello! Is anyone there?")
                ),
                Meaning(
                    partOfSpeech = "名词",
                    definitions = listOf("问候", "招呼"),
                    examples = listOf("He gave me a warm hello.")
                )
            )
        ),
        "world" to DictionaryEntry(
            word = "world",
            phonetic = "/wɜːld/",
            meanings = listOf(
                Meaning(
                    partOfSpeech = "名词",
                    definitions = listOf("世界", "地球", "领域"),
                    examples = listOf("The whole world is watching.", "Welcome to the world of programming.")
                )
            )
        ),
        "learn" to DictionaryEntry(
            word = "learn",
            phonetic = "/lɜːn/",
            meanings = listOf(
                Meaning(
                    partOfSpeech = "动词",
                    definitions = listOf("学习", "学会", "得知"),
                    examples = listOf("I want to learn English.", "We learned about the accident yesterday.")
                )
            )
        ),
        "english" to DictionaryEntry(
            word = "english",
            phonetic = "/ˈɪŋɡlɪʃ/",
            meanings = listOf(
                Meaning(
                    partOfSpeech = "名词",
                    definitions = listOf("英语", "英文"),
                    examples = listOf("She speaks fluent English.")
                ),
                Meaning(
                    partOfSpeech = "形容词",
                    definitions = listOf("英国的", "英语的"),
                    examples = listOf("English literature", "English breakfast")
                )
            )
        ),
        "read" to DictionaryEntry(
            word = "read",
            phonetic = "/riːd/",
            meanings = listOf(
                Meaning(
                    partOfSpeech = "动词",
                    definitions = listOf("阅读", "读", "理解"),
                    examples = listOf("I like to read books.", "Can you read this sign?")
                )
            )
        ),
        "write" to DictionaryEntry(
            word = "write",
            phonetic = "/raɪt/",
            meanings = listOf(
                Meaning(
                    partOfSpeech = "动词",
                    definitions = listOf("写", "写作", "编写"),
                    examples = listOf("Please write your name here.", "She writes for a newspaper.")
                )
            )
        ),
        "study" to DictionaryEntry(
            word = "study",
            phonetic = "/ˈstʌdi/",
            meanings = listOf(
                Meaning(
                    partOfSpeech = "动词",
                    definitions = listOf("学习", "研究", "调查"),
                    examples = listOf("I study at university.", "Scientists study climate change.")
                ),
                Meaning(
                    partOfSpeech = "名词",
                    definitions = listOf("学习", "研究", "书房"),
                    examples = listOf("His study of history is impressive.", "She's in her study.")
                )
            )
        ),
        "book" to DictionaryEntry(
            word = "book",
            phonetic = "/bʊk/",
            meanings = listOf(
                Meaning(
                    partOfSpeech = "名词",
                    definitions = listOf("书", "书籍", "账本"),
                    examples = listOf("I'm reading a good book.", "Keep the books balanced.")
                ),
                Meaning(
                    partOfSpeech = "动词",
                    definitions = listOf("预订", "登记"),
                    examples = listOf("I need to book a hotel.", "The police booked him for speeding.")
                )
            )
        ),
        "language" to DictionaryEntry(
            word = "language",
            phonetic = "/ˈlæŋɡwɪdʒ/",
            meanings = listOf(
                Meaning(
                    partOfSpeech = "名词",
                    definitions = listOf("语言", "语言文字", "措辞"),
                    examples = listOf("English is a global language.", "Mind your language!")
                )
            )
        ),
        "translate" to DictionaryEntry(
            word = "translate",
            phonetic = "/trænzˈleɪt/",
            meanings = listOf(
                Meaning(
                    partOfSpeech = "动词",
                    definitions = listOf("翻译", "转化", "解释"),
                    examples = listOf("Can you translate this for me?", "Ideas don't always translate into action.")
                )
            )
        )
        )
    }
    
    // 英英词典数据 - 也使用懒加载
    private val englishEnglishDictionary by lazy { 
        mapOf(
        "hello" to DictionaryEntry(
            word = "hello",
            phonetic = "/həˈləʊ/",
            meanings = listOf(
                Meaning(
                    partOfSpeech = "exclamation",
                    definitions = listOf("used as a greeting or to begin a phone conversation"),
                    examples = listOf("Hello, how are you?", "Hello! Is anyone there?")
                ),
                Meaning(
                    partOfSpeech = "noun",
                    definitions = listOf("an instance or manner of greeting someone"),
                    examples = listOf("She gave him a warm hello.")
                )
            )
        ),
        "world" to DictionaryEntry(
            word = "world",
            phonetic = "/wɜːld/",
            meanings = listOf(
                Meaning(
                    partOfSpeech = "noun",
                    definitions = listOf(
                        "the earth, together with all of its countries and peoples",
                        "a particular region or group of countries",
                        "human and social existence"
                    ),
                    examples = listOf(
                        "He has traveled around the world.",
                        "The English-speaking world",
                        "The academic world"
                    )
                )
            )
        ),
        "learn" to DictionaryEntry(
            word = "learn",
            phonetic = "/lɜːn/",
            meanings = listOf(
                Meaning(
                    partOfSpeech = "verb",
                    definitions = listOf(
                        "gain or acquire knowledge of or skill in (something) by study, experience, or being taught",
                        "commit to memory",
                        "become aware of (something) by information or from observation"
                    ),
                    examples = listOf(
                        "They'd learned to dance at school",
                        "I learned the poem by heart",
                        "I learned that they had eaten already"
                    )
                )
            )
        )
        )
    }
    
    fun lookupWord(word: String, useChineseDictionary: Boolean = true): DictionaryEntry? {
        val normalizedWord = word.lowercase().trim()
        return if (useChineseDictionary) {
            englishChineseDictionary[normalizedWord]
        } else {
            englishEnglishDictionary[normalizedWord]
        }
    }
    
    fun getDefinition(word: String): String {
        val normalizedWord = word.lowercase().trim()
        
        // 先查英中词典
        val chineseEntry = englishChineseDictionary[normalizedWord]
        val englishEntry = englishEnglishDictionary[normalizedWord]
        
        return buildString {
            if (chineseEntry != null) {
                appendLine("【英-中词典】")
                appendLine("发音: ${chineseEntry.phonetic}")
                chineseEntry.meanings.forEach { meaning ->
                    appendLine()
                    appendLine("${meaning.partOfSpeech}:")
                    meaning.definitions.forEachIndexed { index, def ->
                        appendLine("  ${index + 1}. $def")
                    }
                    if (meaning.examples.isNotEmpty()) {
                        appendLine("  例句:")
                        meaning.examples.forEach { example ->
                            appendLine("    • $example")
                        }
                    }
                }
            }
            
            if (englishEntry != null) {
                if (chineseEntry != null) {
                    appendLine()
                    appendLine("---")
                    appendLine()
                }
                appendLine("【英-英词典】")
                appendLine("Pronunciation: ${englishEntry.phonetic}")
                englishEntry.meanings.forEach { meaning ->
                    appendLine()
                    appendLine("${meaning.partOfSpeech}:")
                    meaning.definitions.forEachIndexed { index, def ->
                        appendLine("  ${index + 1}. $def")
                    }
                    if (meaning.examples.isNotEmpty()) {
                        appendLine("  Examples:")
                        meaning.examples.forEach { example ->
                            appendLine("    • $example")
                        }
                    }
                }
            }
            
            if (chineseEntry == null && englishEntry == null) {
                append("暂无词典数据。您可以尝试使用在线词典或AI翻译功能。")
            }
        }
    }
}

data class DictionaryEntry(
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>
)

data class Meaning(
    val partOfSpeech: String,
    val definitions: List<String>,
    val examples: List<String> = emptyList()
)