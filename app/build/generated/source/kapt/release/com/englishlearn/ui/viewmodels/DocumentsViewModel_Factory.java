// Generated by Dagger (https://dagger.dev).
package com.englishlearn.ui.viewmodels;

import com.englishlearn.domain.repository.DocumentRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DocumentsViewModel_Factory implements Factory<DocumentsViewModel> {
  private final Provider<DocumentRepository> documentRepositoryProvider;

  public DocumentsViewModel_Factory(Provider<DocumentRepository> documentRepositoryProvider) {
    this.documentRepositoryProvider = documentRepositoryProvider;
  }

  @Override
  public DocumentsViewModel get() {
    return newInstance(documentRepositoryProvider.get());
  }

  public static DocumentsViewModel_Factory create(
      Provider<DocumentRepository> documentRepositoryProvider) {
    return new DocumentsViewModel_Factory(documentRepositoryProvider);
  }

  public static DocumentsViewModel newInstance(DocumentRepository documentRepository) {
    return new DocumentsViewModel(documentRepository);
  }
}
