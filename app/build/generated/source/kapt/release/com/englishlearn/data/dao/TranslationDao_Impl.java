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
import com.englishlearn.data.entities.Translation;
import java.lang.Class;
import java.lang.Exception;
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
public final class TranslationDao_Impl implements TranslationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Translation> __insertionAdapterOfTranslation;

  private final EntityDeletionOrUpdateAdapter<Translation> __deletionAdapterOfTranslation;

  private final EntityDeletionOrUpdateAdapter<Translation> __updateAdapterOfTranslation;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBookmarkStatus;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTranslationById;

  public TranslationDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTranslation = new EntityInsertionAdapter<Translation>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `translations` (`id`,`originalText`,`translatedText`,`sourceLanguage`,`targetLanguage`,`aiModel`,`documentId`,`context`,`confidence`,`isBookmarked`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Translation entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getOriginalText() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getOriginalText());
        }
        if (entity.getTranslatedText() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTranslatedText());
        }
        if (entity.getSourceLanguage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getSourceLanguage());
        }
        if (entity.getTargetLanguage() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTargetLanguage());
        }
        if (entity.getAiModel() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getAiModel());
        }
        if (entity.getDocumentId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDocumentId());
        }
        if (entity.getContext() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getContext());
        }
        statement.bindDouble(9, entity.getConfidence());
        final int _tmp = entity.isBookmarked() ? 1 : 0;
        statement.bindLong(10, _tmp);
        statement.bindLong(11, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfTranslation = new EntityDeletionOrUpdateAdapter<Translation>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `translations` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Translation entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfTranslation = new EntityDeletionOrUpdateAdapter<Translation>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `translations` SET `id` = ?,`originalText` = ?,`translatedText` = ?,`sourceLanguage` = ?,`targetLanguage` = ?,`aiModel` = ?,`documentId` = ?,`context` = ?,`confidence` = ?,`isBookmarked` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Translation entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getOriginalText() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getOriginalText());
        }
        if (entity.getTranslatedText() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTranslatedText());
        }
        if (entity.getSourceLanguage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getSourceLanguage());
        }
        if (entity.getTargetLanguage() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTargetLanguage());
        }
        if (entity.getAiModel() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getAiModel());
        }
        if (entity.getDocumentId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDocumentId());
        }
        if (entity.getContext() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getContext());
        }
        statement.bindDouble(9, entity.getConfidence());
        final int _tmp = entity.isBookmarked() ? 1 : 0;
        statement.bindLong(10, _tmp);
        statement.bindLong(11, entity.getCreatedAt());
        if (entity.getId() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getId());
        }
      }
    };
    this.__preparedStmtOfUpdateBookmarkStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE translations SET isBookmarked = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteTranslationById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM translations WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertTranslation(final Translation translation,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTranslation.insert(translation);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteTranslation(final Translation translation,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfTranslation.handle(translation);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTranslation(final Translation translation,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTranslation.handle(translation);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
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
  public Object deleteTranslationById(final String id,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTranslationById.acquire();
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
          __preparedStmtOfDeleteTranslationById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Translation>> getAllTranslations() {
    final String _sql = "SELECT * FROM translations ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"translations"}, new Callable<List<Translation>>() {
      @Override
      @NonNull
      public List<Translation> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOriginalText = CursorUtil.getColumnIndexOrThrow(_cursor, "originalText");
          final int _cursorIndexOfTranslatedText = CursorUtil.getColumnIndexOrThrow(_cursor, "translatedText");
          final int _cursorIndexOfSourceLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "sourceLanguage");
          final int _cursorIndexOfTargetLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "targetLanguage");
          final int _cursorIndexOfAiModel = CursorUtil.getColumnIndexOrThrow(_cursor, "aiModel");
          final int _cursorIndexOfDocumentId = CursorUtil.getColumnIndexOrThrow(_cursor, "documentId");
          final int _cursorIndexOfContext = CursorUtil.getColumnIndexOrThrow(_cursor, "context");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Translation> _result = new ArrayList<Translation>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Translation _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpOriginalText;
            if (_cursor.isNull(_cursorIndexOfOriginalText)) {
              _tmpOriginalText = null;
            } else {
              _tmpOriginalText = _cursor.getString(_cursorIndexOfOriginalText);
            }
            final String _tmpTranslatedText;
            if (_cursor.isNull(_cursorIndexOfTranslatedText)) {
              _tmpTranslatedText = null;
            } else {
              _tmpTranslatedText = _cursor.getString(_cursorIndexOfTranslatedText);
            }
            final String _tmpSourceLanguage;
            if (_cursor.isNull(_cursorIndexOfSourceLanguage)) {
              _tmpSourceLanguage = null;
            } else {
              _tmpSourceLanguage = _cursor.getString(_cursorIndexOfSourceLanguage);
            }
            final String _tmpTargetLanguage;
            if (_cursor.isNull(_cursorIndexOfTargetLanguage)) {
              _tmpTargetLanguage = null;
            } else {
              _tmpTargetLanguage = _cursor.getString(_cursorIndexOfTargetLanguage);
            }
            final String _tmpAiModel;
            if (_cursor.isNull(_cursorIndexOfAiModel)) {
              _tmpAiModel = null;
            } else {
              _tmpAiModel = _cursor.getString(_cursorIndexOfAiModel);
            }
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
            final float _tmpConfidence;
            _tmpConfidence = _cursor.getFloat(_cursorIndexOfConfidence);
            final boolean _tmpIsBookmarked;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Translation(_tmpId,_tmpOriginalText,_tmpTranslatedText,_tmpSourceLanguage,_tmpTargetLanguage,_tmpAiModel,_tmpDocumentId,_tmpContext,_tmpConfidence,_tmpIsBookmarked,_tmpCreatedAt);
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
  public Object getTranslationByText(final String originalText,
      final Continuation<? super Translation> $completion) {
    final String _sql = "SELECT * FROM translations WHERE originalText = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (originalText == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, originalText);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Translation>() {
      @Override
      @Nullable
      public Translation call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOriginalText = CursorUtil.getColumnIndexOrThrow(_cursor, "originalText");
          final int _cursorIndexOfTranslatedText = CursorUtil.getColumnIndexOrThrow(_cursor, "translatedText");
          final int _cursorIndexOfSourceLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "sourceLanguage");
          final int _cursorIndexOfTargetLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "targetLanguage");
          final int _cursorIndexOfAiModel = CursorUtil.getColumnIndexOrThrow(_cursor, "aiModel");
          final int _cursorIndexOfDocumentId = CursorUtil.getColumnIndexOrThrow(_cursor, "documentId");
          final int _cursorIndexOfContext = CursorUtil.getColumnIndexOrThrow(_cursor, "context");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final Translation _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpOriginalText;
            if (_cursor.isNull(_cursorIndexOfOriginalText)) {
              _tmpOriginalText = null;
            } else {
              _tmpOriginalText = _cursor.getString(_cursorIndexOfOriginalText);
            }
            final String _tmpTranslatedText;
            if (_cursor.isNull(_cursorIndexOfTranslatedText)) {
              _tmpTranslatedText = null;
            } else {
              _tmpTranslatedText = _cursor.getString(_cursorIndexOfTranslatedText);
            }
            final String _tmpSourceLanguage;
            if (_cursor.isNull(_cursorIndexOfSourceLanguage)) {
              _tmpSourceLanguage = null;
            } else {
              _tmpSourceLanguage = _cursor.getString(_cursorIndexOfSourceLanguage);
            }
            final String _tmpTargetLanguage;
            if (_cursor.isNull(_cursorIndexOfTargetLanguage)) {
              _tmpTargetLanguage = null;
            } else {
              _tmpTargetLanguage = _cursor.getString(_cursorIndexOfTargetLanguage);
            }
            final String _tmpAiModel;
            if (_cursor.isNull(_cursorIndexOfAiModel)) {
              _tmpAiModel = null;
            } else {
              _tmpAiModel = _cursor.getString(_cursorIndexOfAiModel);
            }
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
            final float _tmpConfidence;
            _tmpConfidence = _cursor.getFloat(_cursorIndexOfConfidence);
            final boolean _tmpIsBookmarked;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new Translation(_tmpId,_tmpOriginalText,_tmpTranslatedText,_tmpSourceLanguage,_tmpTargetLanguage,_tmpAiModel,_tmpDocumentId,_tmpContext,_tmpConfidence,_tmpIsBookmarked,_tmpCreatedAt);
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
  public Flow<List<Translation>> getBookmarkedTranslations() {
    final String _sql = "SELECT * FROM translations WHERE isBookmarked = 1 ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"translations"}, new Callable<List<Translation>>() {
      @Override
      @NonNull
      public List<Translation> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOriginalText = CursorUtil.getColumnIndexOrThrow(_cursor, "originalText");
          final int _cursorIndexOfTranslatedText = CursorUtil.getColumnIndexOrThrow(_cursor, "translatedText");
          final int _cursorIndexOfSourceLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "sourceLanguage");
          final int _cursorIndexOfTargetLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "targetLanguage");
          final int _cursorIndexOfAiModel = CursorUtil.getColumnIndexOrThrow(_cursor, "aiModel");
          final int _cursorIndexOfDocumentId = CursorUtil.getColumnIndexOrThrow(_cursor, "documentId");
          final int _cursorIndexOfContext = CursorUtil.getColumnIndexOrThrow(_cursor, "context");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Translation> _result = new ArrayList<Translation>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Translation _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpOriginalText;
            if (_cursor.isNull(_cursorIndexOfOriginalText)) {
              _tmpOriginalText = null;
            } else {
              _tmpOriginalText = _cursor.getString(_cursorIndexOfOriginalText);
            }
            final String _tmpTranslatedText;
            if (_cursor.isNull(_cursorIndexOfTranslatedText)) {
              _tmpTranslatedText = null;
            } else {
              _tmpTranslatedText = _cursor.getString(_cursorIndexOfTranslatedText);
            }
            final String _tmpSourceLanguage;
            if (_cursor.isNull(_cursorIndexOfSourceLanguage)) {
              _tmpSourceLanguage = null;
            } else {
              _tmpSourceLanguage = _cursor.getString(_cursorIndexOfSourceLanguage);
            }
            final String _tmpTargetLanguage;
            if (_cursor.isNull(_cursorIndexOfTargetLanguage)) {
              _tmpTargetLanguage = null;
            } else {
              _tmpTargetLanguage = _cursor.getString(_cursorIndexOfTargetLanguage);
            }
            final String _tmpAiModel;
            if (_cursor.isNull(_cursorIndexOfAiModel)) {
              _tmpAiModel = null;
            } else {
              _tmpAiModel = _cursor.getString(_cursorIndexOfAiModel);
            }
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
            final float _tmpConfidence;
            _tmpConfidence = _cursor.getFloat(_cursorIndexOfConfidence);
            final boolean _tmpIsBookmarked;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Translation(_tmpId,_tmpOriginalText,_tmpTranslatedText,_tmpSourceLanguage,_tmpTargetLanguage,_tmpAiModel,_tmpDocumentId,_tmpContext,_tmpConfidence,_tmpIsBookmarked,_tmpCreatedAt);
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
  public Flow<List<Translation>> getTranslationsByDocument(final String documentId) {
    final String _sql = "SELECT * FROM translations WHERE documentId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (documentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, documentId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"translations"}, new Callable<List<Translation>>() {
      @Override
      @NonNull
      public List<Translation> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOriginalText = CursorUtil.getColumnIndexOrThrow(_cursor, "originalText");
          final int _cursorIndexOfTranslatedText = CursorUtil.getColumnIndexOrThrow(_cursor, "translatedText");
          final int _cursorIndexOfSourceLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "sourceLanguage");
          final int _cursorIndexOfTargetLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "targetLanguage");
          final int _cursorIndexOfAiModel = CursorUtil.getColumnIndexOrThrow(_cursor, "aiModel");
          final int _cursorIndexOfDocumentId = CursorUtil.getColumnIndexOrThrow(_cursor, "documentId");
          final int _cursorIndexOfContext = CursorUtil.getColumnIndexOrThrow(_cursor, "context");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Translation> _result = new ArrayList<Translation>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Translation _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpOriginalText;
            if (_cursor.isNull(_cursorIndexOfOriginalText)) {
              _tmpOriginalText = null;
            } else {
              _tmpOriginalText = _cursor.getString(_cursorIndexOfOriginalText);
            }
            final String _tmpTranslatedText;
            if (_cursor.isNull(_cursorIndexOfTranslatedText)) {
              _tmpTranslatedText = null;
            } else {
              _tmpTranslatedText = _cursor.getString(_cursorIndexOfTranslatedText);
            }
            final String _tmpSourceLanguage;
            if (_cursor.isNull(_cursorIndexOfSourceLanguage)) {
              _tmpSourceLanguage = null;
            } else {
              _tmpSourceLanguage = _cursor.getString(_cursorIndexOfSourceLanguage);
            }
            final String _tmpTargetLanguage;
            if (_cursor.isNull(_cursorIndexOfTargetLanguage)) {
              _tmpTargetLanguage = null;
            } else {
              _tmpTargetLanguage = _cursor.getString(_cursorIndexOfTargetLanguage);
            }
            final String _tmpAiModel;
            if (_cursor.isNull(_cursorIndexOfAiModel)) {
              _tmpAiModel = null;
            } else {
              _tmpAiModel = _cursor.getString(_cursorIndexOfAiModel);
            }
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
            final float _tmpConfidence;
            _tmpConfidence = _cursor.getFloat(_cursorIndexOfConfidence);
            final boolean _tmpIsBookmarked;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Translation(_tmpId,_tmpOriginalText,_tmpTranslatedText,_tmpSourceLanguage,_tmpTargetLanguage,_tmpAiModel,_tmpDocumentId,_tmpContext,_tmpConfidence,_tmpIsBookmarked,_tmpCreatedAt);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
