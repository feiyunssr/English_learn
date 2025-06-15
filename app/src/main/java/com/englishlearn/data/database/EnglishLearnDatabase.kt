package com.englishlearn.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.englishlearn.data.dao.*
import com.englishlearn.data.entities.*

@Database(
    entities = [
        Document::class,
        Vocabulary::class,
        Translation::class,
        LearningSession::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class EnglishLearnDatabase : RoomDatabase() {
    abstract fun documentDao(): DocumentDao
    abstract fun vocabularyDao(): VocabularyDao
    abstract fun translationDao(): TranslationDao
    abstract fun learningSessionDao(): LearningSessionDao

    companion object {
        @Volatile
        private var INSTANCE: EnglishLearnDatabase? = null

        fun getDatabase(context: Context): EnglishLearnDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EnglishLearnDatabase::class.java,
                    "english_learn_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}