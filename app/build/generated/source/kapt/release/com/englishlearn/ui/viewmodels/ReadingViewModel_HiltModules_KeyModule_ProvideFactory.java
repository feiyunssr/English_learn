// Generated by Dagger (https://dagger.dev).
package com.englishlearn.ui.viewmodels;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.internal.lifecycle.HiltViewModelMap.KeySet")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ReadingViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static ReadingViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(ReadingViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final ReadingViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ReadingViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}
