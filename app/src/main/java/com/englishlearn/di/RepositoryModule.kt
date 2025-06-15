package com.englishlearn.di

import com.englishlearn.data.repository.DocumentRepositoryImpl
import com.englishlearn.data.repository.VocabularyRepositoryImpl
import com.englishlearn.domain.repository.DocumentRepository
import com.englishlearn.domain.repository.VocabularyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDocumentRepository(
        documentRepositoryImpl: DocumentRepositoryImpl
    ): DocumentRepository

    @Binds
    @Singleton
    abstract fun bindVocabularyRepository(
        vocabularyRepositoryImpl: VocabularyRepositoryImpl
    ): VocabularyRepository
}