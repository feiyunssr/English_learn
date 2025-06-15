package com.englishlearn.di

import android.content.Context
import androidx.room.Room
import com.englishlearn.data.dao.*
import com.englishlearn.data.database.EnglishLearnDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): EnglishLearnDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            EnglishLearnDatabase::class.java,
            "english_learn_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideDocumentDao(database: EnglishLearnDatabase): DocumentDao = 
        database.documentDao()

    @Provides
    fun provideVocabularyDao(database: EnglishLearnDatabase): VocabularyDao = 
        database.vocabularyDao()

    @Provides
    fun provideTranslationDao(database: EnglishLearnDatabase): TranslationDao = 
        database.translationDao()

    @Provides
    fun provideLearningSessionDao(database: EnglishLearnDatabase): LearningSessionDao = 
        database.learningSessionDao()
}