// Generated by Dagger (https://dagger.dev).
package com.englishlearn.data.dictionary;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class BuiltInDictionary_Factory implements Factory<BuiltInDictionary> {
  @Override
  public BuiltInDictionary get() {
    return newInstance();
  }

  public static BuiltInDictionary_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BuiltInDictionary newInstance() {
    return new BuiltInDictionary();
  }

  private static final class InstanceHolder {
    private static final BuiltInDictionary_Factory INSTANCE = new BuiltInDictionary_Factory();
  }
}
