package com.englishlearn.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.englishlearn.data.database.Converters;
import com.englishlearn.data.entities.DifficultyLevel;
import com.englishlearn.data.entities.Vocabulary;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class VocabularyDao_Impl implements VocabularyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Vocabulary> __insertionAdapterOfVocabulary;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Vocabulary> __deletionAdapterOfVocabulary;

  private final EntityDeletionOrUpdateAdapter<Vocabulary> __updateAdapterOfVocabulary;

  private final SharedSQLiteStatement __preparedStmtOfUpdateReviewStats;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBookmarkStatus;

  private final SharedSQLiteStatement __preparedStmtOfDeleteVocabularyById;

  public VocabularyDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVocabulary = new EntityInsertionAdapter<Vocabulary>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `vocabulary` (`id`,`word`,`definition`,`phonetic`,`audioUrl`,`examples`,`synonyms`,`antonyms`,`difficulty`,`frequency`,`documentId`,`context`,`isBookmarked`,`reviewCount`,`correctCount`,`createdAt`,`lastReviewedAt`,`nextReviewAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Vocabulary entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getWord() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getWord());
        }
        if (entity.getDefinition() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDefinition());
        }
        if (entity.getPhonetic() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhonetic());
        }
        if (entity.getAudioUrl() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAudioUrl());
        }
        final String _tmp = __converters.fromStringList(entity.getExamples());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp);
        }
        final String _tmp_1 = __converters.fromStringList(entity.getSynonyms());
        if (_tmp_1 == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, _tmp_1);
        }
        final String _tmp_2 = __converters.fromStringList(entity.getAntonyms());
        if (_tmp_2 == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp_2);
        }
        statement.bindString(9, __DifficultyLevel_enumToString(entity.getDifficulty()));
        statement.bindLong(10, entity.getFrequency());
        if (entity.getDocumentId() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getDocumentId());
        }
        if (entity.getContext() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getContext());
        }
        final int _tmp_3 = entity.isBookmarked() ? 1 : 0;
        statement.bindLong(13, _tmp_3);
        statement.bindLong(14, entity.getReviewCount());
        statement.bindLong(15, entity.getCorrectCount());
        statement.bindLong(16, entity.getCreatedAt());
        if (entity.getLastReviewedAt() == null) {
          statement.bindNull(17);
        } else {
          statement.bindLong(17, entity.getLastReviewedAt());
        }
        if (entity.getNextReviewAt() == null) {
          statement.bindNull(18);
        } else {
          statement.bindLong(18, entity.getNextReviewAt());
        }
      }
    };
    this.__deletionAdapterOfVocabulary = new EntityDeletionOrUpdateAdapter<Vocabulary>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `vocabulary` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Vocabulary entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfVocabulary = new EntityDeletionOrUpdateAdapter<Vocabulary>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `vocabulary` SET `id` = ?,`word` = ?,`definition` = ?,`phonetic` = ?,`audioUrl` = ?,`examples` = ?,`synonyms` = ?,`antonyms` = ?,`difficulty` = ?,`frequency` = ?,`documentId` = ?,`context` = ?,`isBookmarked` = ?,`reviewCount` = ?,`correctCount` = ?,`createdAt` = ?,`lastReviewedAt` = ?,`nextReviewAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Vocabulary entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getWord() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getWord());
        }
        if (entity.getDefinition() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDefinition());
        }
        if (entity.getPhonetic() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhonetic());
        }
        if (entity.getAudioUrl() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAudioUrl());
        }
        final String _tmp = __converters.fromStringList(entity.getExamples());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp);
        }
        final String _tmp_1 = __converters.fromStringList(entity.getSynonyms());
        if (_tmp_1 == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, _tmp_1);
        }
        final String _tmp_2 = __converters.fromStringList(entity.getAntonyms());
        if (_tmp_2 == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp_2);
        }
        statement.bindString(9, __DifficultyLevel_enumToString(entity.getDifficulty()));
        statement.bindLong(10, entity.getFrequency());
        if (entity.getDocumentId() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getDocumentId());
        }
        if (entity.getContext() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getContext());
        }
        final int _tmp_3 = entity.isBookmarked() ? 1 : 0;
        statement.bindLong(13, _tmp_3);
        statement.bindLong(14, entity.getReviewCount());
        statement.bindLong(15, entity.getCorrectCount());
        statement.bindLong(16, entity.getCreatedAt());
        if (entity.getLastReviewedAt() == null) {
          statement.bindNull(17);
        } else {
          statement.bindLong(17, entity.getLastReviewedAt());
        }
        if (entity.getNextReviewAt() == null) {
          statement.bindNull(18);
        } else {
          statement.bindLong(18, entity.getNextReviewAt());
        }
        if (entity.getId() == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, entity.getId());
        }
      }
    };
    this.__preparedStmtOfUpdateReviewStats = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE vocabulary SET reviewCount = reviewCount + 1, correctCount = correctCount + ?, lastReviewedAt = ?, nextReviewAt = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateBookmarkStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE vocabulary SET isBookmarked = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteVocabularyById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM vocabulary WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertVocabulary(final Vocabulary vocabulary,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfVocabulary.insert(vocabulary);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteVocabulary(final Vocabulary vocabulary,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfVocabulary.handle(vocabulary);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateVocabulary(final Vocabulary vocabulary,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfVocabulary.handle(vocabulary);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateReviewStats(final String id, final int correct, final long reviewTime,
      final long nextReviewTime, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateReviewStats.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, correct);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, reviewTime);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, nextReviewTime);
        _argIndex = 4;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateReviewStats.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateBookmarkStatus(final String id, final boolean isBookmarked,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBookmarkStatus.acquire();
        int _argIndex = 1;
        final int _tmp = isBookmarked ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateBookmarkStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteVocabularyById(final String id,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteVocabularyById.acquire();
        int _argIndex = 1;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteVocabularyById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Vocabulary>> getAllVocabulary() {
    final String _sql = "SELECT * FROM vocabulary ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"vocabulary"}, new Callable<List<Vocabulary>>() {
      @Override
      @NonNull
      public List<Vocabulary> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWord = CursorUtil.getColumnIndexOrThrow(_cursor, "word");
          final int _cursorIndexOfDefinition = CursorUtil.getColumnIndexOrThrow(_cursor, "definition");
          final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
          final int _cursorIndexOfAudioUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "audioUrl");
          final int _cursorIndexOfExamples = CursorUtil.getColumnIndexOrThrow(_cursor, "examples");
          final int _cursorIndexOfSynonyms = CursorUtil.getColumnIndexOrThrow(_cursor, "synonyms");
          final int _cursorIndexOfAntonyms = CursorUtil.getColumnIndexOrThrow(_cursor, "antonyms");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "frequency");
          final int _cursorIndexOfDocumentId = CursorUtil.getColumnIndexOrThrow(_cursor, "documentId");
          final int _cursorIndexOfContext = CursorUtil.getColumnIndexOrThrow(_cursor, "context");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfCorrectCount = CursorUtil.getColumnIndexOrThrow(_cursor, "correctCount");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastReviewedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastReviewedAt");
          final int _cursorIndexOfNextReviewAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextReviewAt");
          final List<Vocabulary> _result = new ArrayList<Vocabulary>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Vocabulary _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpWord;
            if (_cursor.isNull(_cursorIndexOfWord)) {
              _tmpWord = null;
            } else {
              _tmpWord = _cursor.getString(_cursorIndexOfWord);
            }
            final String _tmpDefinition;
            if (_cursor.isNull(_cursorIndexOfDefinition)) {
              _tmpDefinition = null;
            } else {
              _tmpDefinition = _cursor.getString(_cursorIndexOfDefinition);
            }
            final String _tmpPhonetic;
            if (_cursor.isNull(_cursorIndexOfPhonetic)) {
              _tmpPhonetic = null;
            } else {
              _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
            }
            final String _tmpAudioUrl;
            if (_cursor.isNull(_cursorIndexOfAudioUrl)) {
              _tmpAudioUrl = null;
            } else {
              _tmpAudioUrl = _cursor.getString(_cursorIndexOfAudioUrl);
            }
            final List<String> _tmpExamples;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfExamples)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfExamples);
            }
            _tmpExamples = __converters.toStringList(_tmp);
            final List<String> _tmpSynonyms;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSynonyms)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfSynonyms);
            }
            _tmpSynonyms = __converters.toStringList(_tmp_1);
            final List<String> _tmpAntonyms;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfAntonyms)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfAntonyms);
            }
            _tmpAntonyms = __converters.toStringList(_tmp_2);
            final DifficultyLevel _tmpDifficulty;
            _tmpDifficulty = __DifficultyLevel_stringToEnum(_cursor.getString(_cursorIndexOfDifficulty));
            final int _tmpFrequency;
            _tmpFrequency = _cursor.getInt(_cursorIndexOfFrequency);
            final String _tmpDocumentId;
            if (_cursor.isNull(_cursorIndexOfDocumentId)) {
              _tmpDocumentId = null;
            } else {
              _tmpDocumentId = _cursor.getString(_cursorIndexOfDocumentId);
            }
            final String _tmpContext;
            if (_cursor.isNull(_cursorIndexOfContext)) {
              _tmpContext = null;
            } else {
              _tmpContext = _cursor.getString(_cursorIndexOfContext);
            }
            final boolean _tmpIsBookmarked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp_3 != 0;
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final int _tmpCorrectCount;
            _tmpCorrectCount = _cursor.getInt(_cursorIndexOfCorrectCount);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final Long _tmpLastReviewedAt;
            if (_cursor.isNull(_cursorIndexOfLastReviewedAt)) {
              _tmpLastReviewedAt = null;
            } else {
              _tmpLastReviewedAt = _cursor.getLong(_cursorIndexOfLastReviewedAt);
            }
            final Long _tmpNextReviewAt;
            if (_cursor.isNull(_cursorIndexOfNextReviewAt)) {
              _tmpNextReviewAt = null;
            } else {
              _tmpNextReviewAt = _cursor.getLong(_cursorIndexOfNextReviewAt);
            }
            _item = new Vocabulary(_tmpId,_tmpWord,_tmpDefinition,_tmpPhonetic,_tmpAudioUrl,_tmpExamples,_tmpSynonyms,_tmpAntonyms,_tmpDifficulty,_tmpFrequency,_tmpDocumentId,_tmpContext,_tmpIsBookmarked,_tmpReviewCount,_tmpCorrectCount,_tmpCreatedAt,_tmpLastReviewedAt,_tmpNextReviewAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getVocabularyByWord(final String word,
      final Continuation<? super Vocabulary> $completion) {
    final String _sql = "SELECT * FROM vocabulary WHERE word = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (word == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, word);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Vocabulary>() {
      @Override
      @Nullable
      public Vocabulary call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWord = CursorUtil.getColumnIndexOrThrow(_cursor, "word");
          final int _cursorIndexOfDefinition = CursorUtil.getColumnIndexOrThrow(_cursor, "definition");
          final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
          final int _cursorIndexOfAudioUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "audioUrl");
          final int _cursorIndexOfExamples = CursorUtil.getColumnIndexOrThrow(_cursor, "examples");
          final int _cursorIndexOfSynonyms = CursorUtil.getColumnIndexOrThrow(_cursor, "synonyms");
          final int _cursorIndexOfAntonyms = CursorUtil.getColumnIndexOrThrow(_cursor, "antonyms");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "frequency");
          final int _cursorIndexOfDocumentId = CursorUtil.getColumnIndexOrThrow(_cursor, "documentId");
          final int _cursorIndexOfContext = CursorUtil.getColumnIndexOrThrow(_cursor, "context");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfCorrectCount = CursorUtil.getColumnIndexOrThrow(_cursor, "correctCount");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastReviewedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastReviewedAt");
          final int _cursorIndexOfNextReviewAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextReviewAt");
          final Vocabulary _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpWord;
            if (_cursor.isNull(_cursorIndexOfWord)) {
              _tmpWord = null;
            } else {
              _tmpWord = _cursor.getString(_cursorIndexOfWord);
            }
            final String _tmpDefinition;
            if (_cursor.isNull(_cursorIndexOfDefinition)) {
              _tmpDefinition = null;
            } else {
              _tmpDefinition = _cursor.getString(_cursorIndexOfDefinition);
            }
            final String _tmpPhonetic;
            if (_cursor.isNull(_cursorIndexOfPhonetic)) {
              _tmpPhonetic = null;
            } else {
              _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
            }
            final String _tmpAudioUrl;
            if (_cursor.isNull(_cursorIndexOfAudioUrl)) {
              _tmpAudioUrl = null;
            } else {
              _tmpAudioUrl = _cursor.getString(_cursorIndexOfAudioUrl);
            }
            final List<String> _tmpExamples;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfExamples)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfExamples);
            }
            _tmpExamples = __converters.toStringList(_tmp);
            final List<String> _tmpSynonyms;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSynonyms)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfSynonyms);
            }
            _tmpSynonyms = __converters.toStringList(_tmp_1);
            final List<String> _tmpAntonyms;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfAntonyms)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfAntonyms);
            }
            _tmpAntonyms = __converters.toStringList(_tmp_2);
            final DifficultyLevel _tmpDifficulty;
            _tmpDifficulty = __DifficultyLevel_stringToEnum(_cursor.getString(_cursorIndexOfDifficulty));
            final int _tmpFrequency;
            _tmpFrequency = _cursor.getInt(_cursorIndexOfFrequency);
            final String _tmpDocumentId;
            if (_cursor.isNull(_cursorIndexOfDocumentId)) {
              _tmpDocumentId = null;
            } else {
              _tmpDocumentId = _cursor.getString(_cursorIndexOfDocumentId);
            }
            final String _tmpContext;
            if (_cursor.isNull(_cursorIndexOfContext)) {
              _tmpContext = null;
            } else {
              _tmpContext = _cursor.getString(_cursorIndexOfContext);
            }
            final boolean _tmpIsBookmarked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp_3 != 0;
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final int _tmpCorrectCount;
            _tmpCorrectCount = _cursor.getInt(_cursorIndexOfCorrectCount);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final Long _tmpLastReviewedAt;
            if (_cursor.isNull(_cursorIndexOfLastReviewedAt)) {
              _tmpLastReviewedAt = null;
            } else {
              _tmpLastReviewedAt = _cursor.getLong(_cursorIndexOfLastReviewedAt);
            }
            final Long _tmpNextReviewAt;
            if (_cursor.isNull(_cursorIndexOfNextReviewAt)) {
              _tmpNextReviewAt = null;
            } else {
              _tmpNextReviewAt = _cursor.getLong(_cursorIndexOfNextReviewAt);
            }
            _result = new Vocabulary(_tmpId,_tmpWord,_tmpDefinition,_tmpPhonetic,_tmpAudioUrl,_tmpExamples,_tmpSynonyms,_tmpAntonyms,_tmpDifficulty,_tmpFrequency,_tmpDocumentId,_tmpContext,_tmpIsBookmarked,_tmpReviewCount,_tmpCorrectCount,_tmpCreatedAt,_tmpLastReviewedAt,_tmpNextReviewAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Vocabulary>> getBookmarkedVocabulary() {
    final String _sql = "SELECT * FROM vocabulary WHERE isBookmarked = 1 ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"vocabulary"}, new Callable<List<Vocabulary>>() {
      @Override
      @NonNull
      public List<Vocabulary> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWord = CursorUtil.getColumnIndexOrThrow(_cursor, "word");
          final int _cursorIndexOfDefinition = CursorUtil.getColumnIndexOrThrow(_cursor, "definition");
          final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
          final int _cursorIndexOfAudioUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "audioUrl");
          final int _cursorIndexOfExamples = CursorUtil.getColumnIndexOrThrow(_cursor, "examples");
          final int _cursorIndexOfSynonyms = CursorUtil.getColumnIndexOrThrow(_cursor, "synonyms");
          final int _cursorIndexOfAntonyms = CursorUtil.getColumnIndexOrThrow(_cursor, "antonyms");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "frequency");
          final int _cursorIndexOfDocumentId = CursorUtil.getColumnIndexOrThrow(_cursor, "documentId");
          final int _cursorIndexOfContext = CursorUtil.getColumnIndexOrThrow(_cursor, "context");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfCorrectCount = CursorUtil.getColumnIndexOrThrow(_cursor, "correctCount");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastReviewedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastReviewedAt");
          final int _cursorIndexOfNextReviewAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextReviewAt");
          final List<Vocabulary> _result = new ArrayList<Vocabulary>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Vocabulary _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpWord;
            if (_cursor.isNull(_cursorIndexOfWord)) {
              _tmpWord = null;
            } else {
              _tmpWord = _cursor.getString(_cursorIndexOfWord);
            }
            final String _tmpDefinition;
            if (_cursor.isNull(_cursorIndexOfDefinition)) {
              _tmpDefinition = null;
            } else {
              _tmpDefinition = _cursor.getString(_cursorIndexOfDefinition);
            }
            final String _tmpPhonetic;
            if (_cursor.isNull(_cursorIndexOfPhonetic)) {
              _tmpPhonetic = null;
            } else {
              _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
            }
            final String _tmpAudioUrl;
            if (_cursor.isNull(_cursorIndexOfAudioUrl)) {
              _tmpAudioUrl = null;
            } else {
              _tmpAudioUrl = _cursor.getString(_cursorIndexOfAudioUrl);
            }
            final List<String> _tmpExamples;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfExamples)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfExamples);
            }
            _tmpExamples = __converters.toStringList(_tmp);
            final List<String> _tmpSynonyms;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSynonyms)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfSynonyms);
            }
            _tmpSynonyms = __converters.toStringList(_tmp_1);
            final List<String> _tmpAntonyms;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfAntonyms)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfAntonyms);
            }
            _tmpAntonyms = __converters.toStringList(_tmp_2);
            final DifficultyLevel _tmpDifficulty;
            _tmpDifficulty = __DifficultyLevel_stringToEnum(_cursor.getString(_cursorIndexOfDifficulty));
            final int _tmpFrequency;
            _tmpFrequency = _cursor.getInt(_cursorIndexOfFrequency);
            final String _tmpDocumentId;
            if (_cursor.isNull(_cursorIndexOfDocumentId)) {
              _tmpDocumentId = null;
            } else {
              _tmpDocumentId = _cursor.getString(_cursorIndexOfDocumentId);
            }
            final String _tmpContext;
            if (_cursor.isNull(_cursorIndexOfContext)) {
              _tmpContext = null;
            } else {
              _tmpContext = _cursor.getString(_cursorIndexOfContext);
            }
            final boolean _tmpIsBookmarked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp_3 != 0;
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final int _tmpCorrectCount;
            _tmpCorrectCount = _cursor.getInt(_cursorIndexOfCorrectCount);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final Long _tmpLastReviewedAt;
            if (_cursor.isNull(_cursorIndexOfLastReviewedAt)) {
              _tmpLastReviewedAt = null;
            } else {
              _tmpLastReviewedAt = _cursor.getLong(_cursorIndexOfLastReviewedAt);
            }
            final Long _tmpNextReviewAt;
            if (_cursor.isNull(_cursorIndexOfNextReviewAt)) {
              _tmpNextReviewAt = null;
            } else {
              _tmpNextReviewAt = _cursor.getLong(_cursorIndexOfNextReviewAt);
            }
            _item = new Vocabulary(_tmpId,_tmpWord,_tmpDefinition,_tmpPhonetic,_tmpAudioUrl,_tmpExamples,_tmpSynonyms,_tmpAntonyms,_tmpDifficulty,_tmpFrequency,_tmpDocumentId,_tmpContext,_tmpIsBookmarked,_tmpReviewCount,_tmpCorrectCount,_tmpCreatedAt,_tmpLastReviewedAt,_tmpNextReviewAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Vocabulary>> getVocabularyByDocument(final String documentId) {
    final String _sql = "SELECT * FROM vocabulary WHERE documentId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (documentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, documentId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"vocabulary"}, new Callable<List<Vocabulary>>() {
      @Override
      @NonNull
      public List<Vocabulary> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWord = CursorUtil.getColumnIndexOrThrow(_cursor, "word");
          final int _cursorIndexOfDefinition = CursorUtil.getColumnIndexOrThrow(_cursor, "definition");
          final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
          final int _cursorIndexOfAudioUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "audioUrl");
          final int _cursorIndexOfExamples = CursorUtil.getColumnIndexOrThrow(_cursor, "examples");
          final int _cursorIndexOfSynonyms = CursorUtil.getColumnIndexOrThrow(_cursor, "synonyms");
          final int _cursorIndexOfAntonyms = CursorUtil.getColumnIndexOrThrow(_cursor, "antonyms");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "frequency");
          final int _cursorIndexOfDocumentId = CursorUtil.getColumnIndexOrThrow(_cursor, "documentId");
          final int _cursorIndexOfContext = CursorUtil.getColumnIndexOrThrow(_cursor, "context");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfCorrectCount = CursorUtil.getColumnIndexOrThrow(_cursor, "correctCount");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastReviewedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastReviewedAt");
          final int _cursorIndexOfNextReviewAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextReviewAt");
          final List<Vocabulary> _result = new ArrayList<Vocabulary>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Vocabulary _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpWord;
            if (_cursor.isNull(_cursorIndexOfWord)) {
              _tmpWord = null;
            } else {
              _tmpWord = _cursor.getString(_cursorIndexOfWord);
            }
            final String _tmpDefinition;
            if (_cursor.isNull(_cursorIndexOfDefinition)) {
              _tmpDefinition = null;
            } else {
              _tmpDefinition = _cursor.getString(_cursorIndexOfDefinition);
            }
            final String _tmpPhonetic;
            if (_cursor.isNull(_cursorIndexOfPhonetic)) {
              _tmpPhonetic = null;
            } else {
              _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
            }
            final String _tmpAudioUrl;
            if (_cursor.isNull(_cursorIndexOfAudioUrl)) {
              _tmpAudioUrl = null;
            } else {
              _tmpAudioUrl = _cursor.getString(_cursorIndexOfAudioUrl);
            }
            final List<String> _tmpExamples;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfExamples)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfExamples);
            }
            _tmpExamples = __converters.toStringList(_tmp);
            final List<String> _tmpSynonyms;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSynonyms)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfSynonyms);
            }
            _tmpSynonyms = __converters.toStringList(_tmp_1);
            final List<String> _tmpAntonyms;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfAntonyms)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfAntonyms);
            }
            _tmpAntonyms = __converters.toStringList(_tmp_2);
            final DifficultyLevel _tmpDifficulty;
            _tmpDifficulty = __DifficultyLevel_stringToEnum(_cursor.getString(_cursorIndexOfDifficulty));
            final int _tmpFrequency;
            _tmpFrequency = _cursor.getInt(_cursorIndexOfFrequency);
            final String _tmpDocumentId;
            if (_cursor.isNull(_cursorIndexOfDocumentId)) {
              _tmpDocumentId = null;
            } else {
              _tmpDocumentId = _cursor.getString(_cursorIndexOfDocumentId);
            }
            final String _tmpContext;
            if (_cursor.isNull(_cursorIndexOfContext)) {
              _tmpContext = null;
            } else {
              _tmpContext = _cursor.getString(_cursorIndexOfContext);
            }
            final boolean _tmpIsBookmarked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp_3 != 0;
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final int _tmpCorrectCount;
            _tmpCorrectCount = _cursor.getInt(_cursorIndexOfCorrectCount);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final Long _tmpLastReviewedAt;
            if (_cursor.isNull(_cursorIndexOfLastReviewedAt)) {
              _tmpLastReviewedAt = null;
            } else {
              _tmpLastReviewedAt = _cursor.getLong(_cursorIndexOfLastReviewedAt);
            }
            final Long _tmpNextReviewAt;
            if (_cursor.isNull(_cursorIndexOfNextReviewAt)) {
              _tmpNextReviewAt = null;
            } else {
              _tmpNextReviewAt = _cursor.getLong(_cursorIndexOfNextReviewAt);
            }
            _item = new Vocabulary(_tmpId,_tmpWord,_tmpDefinition,_tmpPhonetic,_tmpAudioUrl,_tmpExamples,_tmpSynonyms,_tmpAntonyms,_tmpDifficulty,_tmpFrequency,_tmpDocumentId,_tmpContext,_tmpIsBookmarked,_tmpReviewCount,_tmpCorrectCount,_tmpCreatedAt,_tmpLastReviewedAt,_tmpNextReviewAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getVocabularyForReview(final long currentTime,
      final Continuation<? super List<Vocabulary>> $completion) {
    final String _sql = "SELECT * FROM vocabulary WHERE nextReviewAt <= ? ORDER BY nextReviewAt ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, currentTime);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Vocabulary>>() {
      @Override
      @NonNull
      public List<Vocabulary> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWord = CursorUtil.getColumnIndexOrThrow(_cursor, "word");
          final int _cursorIndexOfDefinition = CursorUtil.getColumnIndexOrThrow(_cursor, "definition");
          final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
          final int _cursorIndexOfAudioUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "audioUrl");
          final int _cursorIndexOfExamples = CursorUtil.getColumnIndexOrThrow(_cursor, "examples");
          final int _cursorIndexOfSynonyms = CursorUtil.getColumnIndexOrThrow(_cursor, "synonyms");
          final int _cursorIndexOfAntonyms = CursorUtil.getColumnIndexOrThrow(_cursor, "antonyms");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "frequency");
          final int _cursorIndexOfDocumentId = CursorUtil.getColumnIndexOrThrow(_cursor, "documentId");
          final int _cursorIndexOfContext = CursorUtil.getColumnIndexOrThrow(_cursor, "context");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfCorrectCount = CursorUtil.getColumnIndexOrThrow(_cursor, "correctCount");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastReviewedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastReviewedAt");
          final int _cursorIndexOfNextReviewAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextReviewAt");
          final List<Vocabulary> _result = new ArrayList<Vocabulary>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Vocabulary _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpWord;
            if (_cursor.isNull(_cursorIndexOfWord)) {
              _tmpWord = null;
            } else {
              _tmpWord = _cursor.getString(_cursorIndexOfWord);
            }
            final String _tmpDefinition;
            if (_cursor.isNull(_cursorIndexOfDefinition)) {
              _tmpDefinition = null;
            } else {
              _tmpDefinition = _cursor.getString(_cursorIndexOfDefinition);
            }
            final String _tmpPhonetic;
            if (_cursor.isNull(_cursorIndexOfPhonetic)) {
              _tmpPhonetic = null;
            } else {
              _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
            }
            final String _tmpAudioUrl;
            if (_cursor.isNull(_cursorIndexOfAudioUrl)) {
              _tmpAudioUrl = null;
            } else {
              _tmpAudioUrl = _cursor.getString(_cursorIndexOfAudioUrl);
            }
            final List<String> _tmpExamples;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfExamples)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfExamples);
            }
            _tmpExamples = __converters.toStringList(_tmp);
            final List<String> _tmpSynonyms;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSynonyms)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfSynonyms);
            }
            _tmpSynonyms = __converters.toStringList(_tmp_1);
            final List<String> _tmpAntonyms;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfAntonyms)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfAntonyms);
            }
            _tmpAntonyms = __converters.toStringList(_tmp_2);
            final DifficultyLevel _tmpDifficulty;
            _tmpDifficulty = __DifficultyLevel_stringToEnum(_cursor.getString(_cursorIndexOfDifficulty));
            final int _tmpFrequency;
            _tmpFrequency = _cursor.getInt(_cursorIndexOfFrequency);
            final String _tmpDocumentId;
            if (_cursor.isNull(_cursorIndexOfDocumentId)) {
              _tmpDocumentId = null;
            } else {
              _tmpDocumentId = _cursor.getString(_cursorIndexOfDocumentId);
            }
            final String _tmpContext;
            if (_cursor.isNull(_cursorIndexOfContext)) {
              _tmpContext = null;
            } else {
              _tmpContext = _cursor.getString(_cursorIndexOfContext);
            }
            final boolean _tmpIsBookmarked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp_3 != 0;
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final int _tmpCorrectCount;
            _tmpCorrectCount = _cursor.getInt(_cursorIndexOfCorrectCount);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final Long _tmpLastReviewedAt;
            if (_cursor.isNull(_cursorIndexOfLastReviewedAt)) {
              _tmpLastReviewedAt = null;
            } else {
              _tmpLastReviewedAt = _cursor.getLong(_cursorIndexOfLastReviewedAt);
            }
            final Long _tmpNextReviewAt;
            if (_cursor.isNull(_cursorIndexOfNextReviewAt)) {
              _tmpNextReviewAt = null;
            } else {
              _tmpNextReviewAt = _cursor.getLong(_cursorIndexOfNextReviewAt);
            }
            _item = new Vocabulary(_tmpId,_tmpWord,_tmpDefinition,_tmpPhonetic,_tmpAudioUrl,_tmpExamples,_tmpSynonyms,_tmpAntonyms,_tmpDifficulty,_tmpFrequency,_tmpDocumentId,_tmpContext,_tmpIsBookmarked,_tmpReviewCount,_tmpCorrectCount,_tmpCreatedAt,_tmpLastReviewedAt,_tmpNextReviewAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __DifficultyLevel_enumToString(@NonNull final DifficultyLevel _value) {
    switch (_value) {
      case ELEMENTARY: return "ELEMENTARY";
      case INTERMEDIATE: return "INTERMEDIATE";
      case ADVANCED: return "ADVANCED";
      case UNKNOWN: return "UNKNOWN";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private DifficultyLevel __DifficultyLevel_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "ELEMENTARY": return DifficultyLevel.ELEMENTARY;
      case "INTERMEDIATE": return DifficultyLevel.INTERMEDIATE;
      case "ADVANCED": return DifficultyLevel.ADVANCED;
      case "UNKNOWN": return DifficultyLevel.UNKNOWN;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
