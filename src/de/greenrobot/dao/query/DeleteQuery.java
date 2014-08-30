package de.greenrobot.dao.query;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;

public class DeleteQuery<T> extends AbstractQuery<T>
{
  private final DeleteQuery.QueryData<T> queryData;

  private DeleteQuery(DeleteQuery.QueryData<T> paramQueryData, AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    super(paramAbstractDao, paramString, paramArrayOfString);
    this.queryData = paramQueryData;
  }

  static <T2> DeleteQuery<T2> create(AbstractDao<T2, ?> paramAbstractDao, String paramString, Object[] paramArrayOfObject)
  {
    return (DeleteQuery)new DeleteQuery.QueryData(paramAbstractDao, paramString, toStringArray(paramArrayOfObject), null).forCurrentThread();
  }

  public void executeDeleteWithoutDetachingEntities()
  {
    checkThread();
    SQLiteDatabase localSQLiteDatabase = this.dao.getDatabase();
    if (localSQLiteDatabase.isDbLockedByCurrentThread())
    {
      this.dao.getDatabase().execSQL(this.sql, this.parameters);
      return;
    }
    localSQLiteDatabase.beginTransaction();
    try
    {
      this.dao.getDatabase().execSQL(this.sql, this.parameters);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }

  public DeleteQuery<T> forCurrentThread()
  {
    return (DeleteQuery)this.queryData.forCurrentThread(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.DeleteQuery
 * JD-Core Version:    0.6.2
 */