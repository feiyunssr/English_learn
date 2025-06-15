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
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.englishlearn.data.entities.LearningSession;
import java.lang.Class;
import java.lang.Exception;
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
public final class LearningSessionDao_Impl implements LearningSessionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LearningSession> __insertionAdapterOfLearningSession;

  private final EntityDeletionOrUpdateAdapter<LearningSession> __deletionAdapterOfLearningSession;

  private final EntityDeletionOrUpdateAdapter<LearningSession> __updateAdapterOfLearningSession;

  public LearningSessionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLearningSession = new EntityInsertionAdapter<LearningSession>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `learning_sessions` (`id`,`documentId`,`startTime`,`endTime`,`duration`,`wordsLookedUp`,`translationsRequested`,`pagesRead`,`newVocabularyLearned`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LearningSession entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getDocumentId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDocumentId());
        }
        statement.bindLong(3, entity.getStartTime());
        if (entity.getEndTime() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getEndTime());
        }
        statement.bindLong(5, entity.getDuration());
        statement.bindLong(6, entity.getWordsLookedUp());
        statement.bindLong(7, entity.getTranslationsRequested());
        statement.bindLong(8, entity.getPagesRead());
        statement.bindLong(9, entity.getNewVocabularyLearned());
        statement.bindLong(10, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfLearningSession = new EntityDeletionOrUpdateAdapter<LearningSession>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `learning_sessions` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LearningSession entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfLearningSession = new EntityDeletionOrUpdateAdapter<LearningSession>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `learning_sessions` SET `id` = ?,`documentId` = ?,`startTime` = ?,`endTime` = ?,`duration` = ?,`wordsLookedUp` = ?,`translationsRequested` = ?,`pagesRead` = ?,`newVocabularyLearned` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LearningSession entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getDocumentId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDocumentId());
        }
        statement.bindLong(3, entity.getStartTime());
        if (entity.getEndTime() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getEndTime());
        }
        statement.bindLong(5, entity.getDuration());
        statement.bindLong(6, entity.getWordsLookedUp());
        statement.bindLong(7, entity.getTranslationsRequested());
        statement.bindLong(8, entity.getPagesRead());
        statement.bindLong(9, entity.getNewVocabularyLearned());
        statement.bindLong(10, entity.getCreatedAt());
        if (entity.getId() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insertSession(final LearningSession session,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLearningSession.insert(session);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteSession(final LearningSession session,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfLearningSession.handle(session);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateSession(final LearningSession session,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfLearningSession.handle(session);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<LearningSession>> getAllSessions() {
    final String _sql = "SELECT * FROM learning_sessions ORDER BY startTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"learning_sessions"}, new Callable<List<LearningSession>>() {
      @Override
      @NonNull
      public List<LearningSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDocumentId = CursorUtil.getColumnIndexOrThrow(_cursor, "documentId");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordsLookedUp = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsLookedUp");
          final int _cursorIndexOfTranslationsRequested = CursorUtil.getColumnIndexOrThrow(_cursor, "translationsRequested");
          final int _cursorIndexOfPagesRead = CursorUtil.getColumnIndexOrThrow(_cursor, "pagesRead");
          final int _cursorIndexOfNewVocabularyLearned = CursorUtil.getColumnIndexOrThrow(_cursor, "newVocabularyLearned");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<LearningSession> _result = new ArrayList<LearningSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LearningSession _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpDocumentId;
            if (_cursor.isNull(_cursorIndexOfDocumentId)) {
              _tmpDocumentId = null;
            } else {
              _tmpDocumentId = _cursor.getString(_cursorIndexOfDocumentId);
            }
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final Long _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordsLookedUp;
            _tmpWordsLookedUp = _cursor.getInt(_cursorIndexOfWordsLookedUp);
            final int _tmpTranslationsRequested;
            _tmpTranslationsRequested = _cursor.getInt(_cursorIndexOfTranslationsRequested);
            final int _tmpPagesRead;
            _tmpPagesRead = _cursor.getInt(_cursorIndexOfPagesRead);
            final int _tmpNewVocabularyLearned;
            _tmpNewVocabularyLearned = _cursor.getInt(_cursorIndexOfNewVocabularyLearned);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new LearningSession(_tmpId,_tmpDocumentId,_tmpStartTime,_tmpEndTime,_tmpDuration,_tmpWordsLookedUp,_tmpTranslationsRequested,_tmpPagesRead,_tmpNewVocabularyLearned,_tmpCreatedAt);
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
  public Object getAllSessionsList(final Continuation<? super List<LearningSession>> $completion) {
    final String _sql = "SELECT * FROM learning_sessions ORDER BY startTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<LearningSession>>() {
      @Override
      @NonNull
      public List<LearningSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDocumentId = CursorUtil.getColumnIndexOrThrow(_cursor, "documentId");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordsLookedUp = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsLookedUp");
          final int _cursorIndexOfTranslationsRequested = CursorUtil.getColumnIndexOrThrow(_cursor, "translationsRequested");
          final int _cursorIndexOfPagesRead = CursorUtil.getColumnIndexOrThrow(_cursor, "pagesRead");
          final int _cursorIndexOfNewVocabularyLearned = CursorUtil.getColumnIndexOrThrow(_cursor, "newVocabularyLearned");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<LearningSession> _result = new ArrayList<LearningSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LearningSession _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpDocumentId;
            if (_cursor.isNull(_cursorIndexOfDocumentId)) {
              _tmpDocumentId = null;
            } else {
              _tmpDocumentId = _cursor.getString(_cursorIndexOfDocumentId);
            }
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final Long _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordsLookedUp;
            _tmpWordsLookedUp = _cursor.getInt(_cursorIndexOfWordsLookedUp);
            final int _tmpTranslationsRequested;
            _tmpTranslationsRequested = _cursor.getInt(_cursorIndexOfTranslationsRequested);
            final int _tmpPagesRead;
            _tmpPagesRead = _cursor.getInt(_cursorIndexOfPagesRead);
            final int _tmpNewVocabularyLearned;
            _tmpNewVocabularyLearned = _cursor.getInt(_cursorIndexOfNewVocabularyLearned);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new LearningSession(_tmpId,_tmpDocumentId,_tmpStartTime,_tmpEndTime,_tmpDuration,_tmpWordsLookedUp,_tmpTranslationsRequested,_tmpPagesRead,_tmpNewVocabularyLearned,_tmpCreatedAt);
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

  @Override
  public Flow<List<LearningSession>> getSessionsByDocument(final String documentId) {
    final String _sql = "SELECT * FROM learning_sessions WHERE documentId = ? ORDER BY startTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (documentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, documentId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"learning_sessions"}, new Callable<List<LearningSession>>() {
      @Override
      @NonNull
      public List<LearningSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDocumentId = CursorUtil.getColumnIndexOrThrow(_cursor, "documentId");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordsLookedUp = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsLookedUp");
          final int _cursorIndexOfTranslationsRequested = CursorUtil.getColumnIndexOrThrow(_cursor, "translationsRequested");
          final int _cursorIndexOfPagesRead = CursorUtil.getColumnIndexOrThrow(_cursor, "pagesRead");
          final int _cursorIndexOfNewVocabularyLearned = CursorUtil.getColumnIndexOrThrow(_cursor, "newVocabularyLearned");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<LearningSession> _result = new ArrayList<LearningSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LearningSession _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpDocumentId;
            if (_cursor.isNull(_cursorIndexOfDocumentId)) {
              _tmpDocumentId = null;
            } else {
              _tmpDocumentId = _cursor.getString(_cursorIndexOfDocumentId);
            }
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final Long _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordsLookedUp;
            _tmpWordsLookedUp = _cursor.getInt(_cursorIndexOfWordsLookedUp);
            final int _tmpTranslationsRequested;
            _tmpTranslationsRequested = _cursor.getInt(_cursorIndexOfTranslationsRequested);
            final int _tmpPagesRead;
            _tmpPagesRead = _cursor.getInt(_cursorIndexOfPagesRead);
            final int _tmpNewVocabularyLearned;
            _tmpNewVocabularyLearned = _cursor.getInt(_cursorIndexOfNewVocabularyLearned);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new LearningSession(_tmpId,_tmpDocumentId,_tmpStartTime,_tmpEndTime,_tmpDuration,_tmpWordsLookedUp,_tmpTranslationsRequested,_tmpPagesRead,_tmpNewVocabularyLearned,_tmpCreatedAt);
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
  public Flow<List<LearningSession>> getSessionsByDateRange(final long startTime,
      final long endTime) {
    final String _sql = "SELECT * FROM learning_sessions WHERE startTime >= ? AND startTime <= ? ORDER BY startTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startTime);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endTime);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"learning_sessions"}, new Callable<List<LearningSession>>() {
      @Override
      @NonNull
      public List<LearningSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDocumentId = CursorUtil.getColumnIndexOrThrow(_cursor, "documentId");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordsLookedUp = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsLookedUp");
          final int _cursorIndexOfTranslationsRequested = CursorUtil.getColumnIndexOrThrow(_cursor, "translationsRequested");
          final int _cursorIndexOfPagesRead = CursorUtil.getColumnIndexOrThrow(_cursor, "pagesRead");
          final int _cursorIndexOfNewVocabularyLearned = CursorUtil.getColumnIndexOrThrow(_cursor, "newVocabularyLearned");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<LearningSession> _result = new ArrayList<LearningSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LearningSession _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpDocumentId;
            if (_cursor.isNull(_cursorIndexOfDocumentId)) {
              _tmpDocumentId = null;
            } else {
              _tmpDocumentId = _cursor.getString(_cursorIndexOfDocumentId);
            }
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final Long _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordsLookedUp;
            _tmpWordsLookedUp = _cursor.getInt(_cursorIndexOfWordsLookedUp);
            final int _tmpTranslationsRequested;
            _tmpTranslationsRequested = _cursor.getInt(_cursorIndexOfTranslationsRequested);
            final int _tmpPagesRead;
            _tmpPagesRead = _cursor.getInt(_cursorIndexOfPagesRead);
            final int _tmpNewVocabularyLearned;
            _tmpNewVocabularyLearned = _cursor.getInt(_cursorIndexOfNewVocabularyLearned);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new LearningSession(_tmpId,_tmpDocumentId,_tmpStartTime,_tmpEndTime,_tmpDuration,_tmpWordsLookedUp,_tmpTranslationsRequested,_tmpPagesRead,_tmpNewVocabularyLearned,_tmpCreatedAt);
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
  public Object getTotalStudyTimeFromDate(final long startTime,
      final Continuation<? super Long> $completion) {
    final String _sql = "SELECT SUM(duration) FROM learning_sessions WHERE startTime >= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startTime);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      @Nullable
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if (_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = _tmp;
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
  public Object getAverageStudyTimeFromDate(final long startTime,
      final Continuation<? super Long> $completion) {
    final String _sql = "SELECT AVG(duration) FROM learning_sessions WHERE startTime >= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startTime);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      @Nullable
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if (_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = _tmp;
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
