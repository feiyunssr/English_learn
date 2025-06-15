package com.englishlearn.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/englishlearn/data/database/EnglishLearnDatabase;", "Landroidx/room/RoomDatabase;", "()V", "documentDao", "Lcom/englishlearn/data/dao/DocumentDao;", "learningSessionDao", "Lcom/englishlearn/data/dao/LearningSessionDao;", "translationDao", "Lcom/englishlearn/data/dao/TranslationDao;", "vocabularyDao", "Lcom/englishlearn/data/dao/VocabularyDao;", "Companion", "app_release"})
@androidx.room.Database(entities = {com.englishlearn.data.entities.Document.class, com.englishlearn.data.entities.Vocabulary.class, com.englishlearn.data.entities.Translation.class, com.englishlearn.data.entities.LearningSession.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.englishlearn.data.database.Converters.class})
public abstract class EnglishLearnDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.englishlearn.data.database.EnglishLearnDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.englishlearn.data.database.EnglishLearnDatabase.Companion Companion = null;
    
    public EnglishLearnDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.englishlearn.data.dao.DocumentDao documentDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.englishlearn.data.dao.VocabularyDao vocabularyDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.englishlearn.data.dao.TranslationDao translationDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.englishlearn.data.dao.LearningSessionDao learningSessionDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/englishlearn/data/database/EnglishLearnDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/englishlearn/data/database/EnglishLearnDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.englishlearn.data.database.EnglishLearnDatabase getDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}