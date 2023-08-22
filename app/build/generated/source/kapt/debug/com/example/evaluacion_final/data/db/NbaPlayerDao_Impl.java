package com.example.evaluacion_final.data.db;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.evaluacion_final.model.NbaPlayer;
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
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class NbaPlayerDao_Impl implements NbaPlayerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NbaPlayer> __insertionAdapterOfNbaPlayer;

  private final EntityDeletionOrUpdateAdapter<NbaPlayer> __deletionAdapterOfNbaPlayer;

  public NbaPlayerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNbaPlayer = new EntityInsertionAdapter<NbaPlayer>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `player` (`id`,`name`,`age`,`games`,`minutes_pg`,`PTS`,`team`,`field_percent`,`isFavorite`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NbaPlayer value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getAge());
        stmt.bindLong(4, value.getGames());
        if (value.getMinutes_pg() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMinutes_pg());
        }
        if (value.getPTS() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPTS());
        }
        if (value.getTeam() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTeam());
        }
        if (value.getField_percent() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getField_percent());
        }
        final int _tmp = value.isFavorite() ? 1 : 0;
        stmt.bindLong(9, _tmp);
      }
    };
    this.__deletionAdapterOfNbaPlayer = new EntityDeletionOrUpdateAdapter<NbaPlayer>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `player` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NbaPlayer value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public Object addFavorite(final NbaPlayer player, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNbaPlayer.insert(player);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteFavorite(final NbaPlayer player,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfNbaPlayer.handle(player);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public List<NbaPlayer> getFavorites() {
    final String _sql = "SELECT * FROM player";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
      final int _cursorIndexOfGames = CursorUtil.getColumnIndexOrThrow(_cursor, "games");
      final int _cursorIndexOfMinutesPg = CursorUtil.getColumnIndexOrThrow(_cursor, "minutes_pg");
      final int _cursorIndexOfPTS = CursorUtil.getColumnIndexOrThrow(_cursor, "PTS");
      final int _cursorIndexOfTeam = CursorUtil.getColumnIndexOrThrow(_cursor, "team");
      final int _cursorIndexOfFieldPercent = CursorUtil.getColumnIndexOrThrow(_cursor, "field_percent");
      final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
      final List<NbaPlayer> _result = new ArrayList<NbaPlayer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final NbaPlayer _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final int _tmpAge;
        _tmpAge = _cursor.getInt(_cursorIndexOfAge);
        final int _tmpGames;
        _tmpGames = _cursor.getInt(_cursorIndexOfGames);
        final String _tmpMinutes_pg;
        if (_cursor.isNull(_cursorIndexOfMinutesPg)) {
          _tmpMinutes_pg = null;
        } else {
          _tmpMinutes_pg = _cursor.getString(_cursorIndexOfMinutesPg);
        }
        final String _tmpPTS;
        if (_cursor.isNull(_cursorIndexOfPTS)) {
          _tmpPTS = null;
        } else {
          _tmpPTS = _cursor.getString(_cursorIndexOfPTS);
        }
        final String _tmpTeam;
        if (_cursor.isNull(_cursorIndexOfTeam)) {
          _tmpTeam = null;
        } else {
          _tmpTeam = _cursor.getString(_cursorIndexOfTeam);
        }
        final String _tmpField_percent;
        if (_cursor.isNull(_cursorIndexOfFieldPercent)) {
          _tmpField_percent = null;
        } else {
          _tmpField_percent = _cursor.getString(_cursorIndexOfFieldPercent);
        }
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        _item = new NbaPlayer(_tmpId,_tmpName,_tmpAge,_tmpGames,_tmpMinutes_pg,_tmpPTS,_tmpTeam,_tmpField_percent,_tmpIsFavorite);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
