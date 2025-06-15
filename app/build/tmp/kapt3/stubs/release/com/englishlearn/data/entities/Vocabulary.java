package com.englishlearn.data.entities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b5\b\u0087\b\u0018\u00002\u00020\u0001B\u00d3\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0002\u0010\u001aJ\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u000fH\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0013H\u00c6\u0003J\t\u00109\u001a\u00020\u000fH\u00c6\u0003J\t\u0010:\u001a\u00020\u000fH\u00c6\u0003J\t\u0010;\u001a\u00020\u0017H\u00c6\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003\u00a2\u0006\u0002\u0010-J\u0010\u0010=\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003\u00a2\u0006\u0002\u0010-J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\t\u0010E\u001a\u00020\rH\u00c6\u0003J\u00e0\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u00c6\u0001\u00a2\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020\u00132\b\u0010I\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010J\u001a\u00020\u000fH\u00d6\u0001J\t\u0010K\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010+R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\n\n\u0002\u0010.\u001a\u0004\b/\u0010-R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001e\u00a8\u0006L"}, d2 = {"Lcom/englishlearn/data/entities/Vocabulary;", "", "id", "", "word", "definition", "phonetic", "audioUrl", "examples", "", "synonyms", "antonyms", "difficulty", "Lcom/englishlearn/data/entities/DifficultyLevel;", "frequency", "", "documentId", "context", "isBookmarked", "", "reviewCount", "correctCount", "createdAt", "", "lastReviewedAt", "nextReviewAt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/englishlearn/data/entities/DifficultyLevel;ILjava/lang/String;Ljava/lang/String;ZIIJLjava/lang/Long;Ljava/lang/Long;)V", "getAntonyms", "()Ljava/util/List;", "getAudioUrl", "()Ljava/lang/String;", "getContext", "getCorrectCount", "()I", "getCreatedAt", "()J", "getDefinition", "getDifficulty", "()Lcom/englishlearn/data/entities/DifficultyLevel;", "getDocumentId", "getExamples", "getFrequency", "getId", "()Z", "getLastReviewedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNextReviewAt", "getPhonetic", "getReviewCount", "getSynonyms", "getWord", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/englishlearn/data/entities/DifficultyLevel;ILjava/lang/String;Ljava/lang/String;ZIIJLjava/lang/Long;Ljava/lang/Long;)Lcom/englishlearn/data/entities/Vocabulary;", "equals", "other", "hashCode", "toString", "app_release"})
@androidx.room.Entity(tableName = "vocabulary")
public final class Vocabulary {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String word = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String definition = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String phonetic = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String audioUrl = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> examples = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> synonyms = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> antonyms = null;
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.data.entities.DifficultyLevel difficulty = null;
    private final int frequency = 0;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String documentId = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String context = null;
    private final boolean isBookmarked = false;
    private final int reviewCount = 0;
    private final int correctCount = 0;
    private final long createdAt = 0L;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Long lastReviewedAt = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Long nextReviewAt = null;
    
    public Vocabulary(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String word, @org.jetbrains.annotations.NotNull
    java.lang.String definition, @org.jetbrains.annotations.Nullable
    java.lang.String phonetic, @org.jetbrains.annotations.Nullable
    java.lang.String audioUrl, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> examples, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> synonyms, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> antonyms, @org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.DifficultyLevel difficulty, int frequency, @org.jetbrains.annotations.Nullable
    java.lang.String documentId, @org.jetbrains.annotations.Nullable
    java.lang.String context, boolean isBookmarked, int reviewCount, int correctCount, long createdAt, @org.jetbrains.annotations.Nullable
    java.lang.Long lastReviewedAt, @org.jetbrains.annotations.Nullable
    java.lang.Long nextReviewAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getWord() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDefinition() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPhonetic() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAudioUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getExamples() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getSynonyms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getAntonyms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.englishlearn.data.entities.DifficultyLevel getDifficulty() {
        return null;
    }
    
    public final int getFrequency() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDocumentId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getContext() {
        return null;
    }
    
    public final boolean isBookmarked() {
        return false;
    }
    
    public final int getReviewCount() {
        return 0;
    }
    
    public final int getCorrectCount() {
        return 0;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getLastReviewedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getNextReviewAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    public final int component10() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component12() {
        return null;
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final int component14() {
        return 0;
    }
    
    public final int component15() {
        return 0;
    }
    
    public final long component16() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.englishlearn.data.entities.DifficultyLevel component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.englishlearn.data.entities.Vocabulary copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String word, @org.jetbrains.annotations.NotNull
    java.lang.String definition, @org.jetbrains.annotations.Nullable
    java.lang.String phonetic, @org.jetbrains.annotations.Nullable
    java.lang.String audioUrl, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> examples, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> synonyms, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> antonyms, @org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.DifficultyLevel difficulty, int frequency, @org.jetbrains.annotations.Nullable
    java.lang.String documentId, @org.jetbrains.annotations.Nullable
    java.lang.String context, boolean isBookmarked, int reviewCount, int correctCount, long createdAt, @org.jetbrains.annotations.Nullable
    java.lang.Long lastReviewedAt, @org.jetbrains.annotations.Nullable
    java.lang.Long nextReviewAt) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}