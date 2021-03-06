package de.greenrobot.dao.query;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

public class CountQuery<T> extends AbstractQuery<T>
{
  private final CountQuery.QueryData<T> queryData;

  private CountQuery(CountQuery.QueryData<T> paramQueryData, AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    super(paramAbstractDao, paramString, paramArrayOfString);
    this.queryData = paramQueryData;
  }

  static <T2> CountQuery<T2> create(AbstractDao<T2, ?> paramAbstractDao, String paramString, Object[] paramArrayOfObject)
  {
    return (CountQuery)new CountQuery.QueryData(paramAbstractDao, paramString, toStringArray(paramArrayOfObject), null).forCurrentThread();
  }

  public long count()
  {
    checkThread();
    Cursor localCursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    try
    {
      if (!localCursor.moveToNext())
        throw new DaoException("No result for count");
    }
    finally
    {
      localCursor.close();
    }
    if (!localCursor.isLast())
      throw new DaoException("Unexpected row count: " + localCursor.getCount());
    if (localCursor.getColumnCount() != 1)
      throw new DaoException("Unexpected column count: " + localCursor.getColumnCount());
    long l = localCursor.getLong(0);
    localCursor.close();
    return l;
  }

  public CountQuery<T> forCurrentThread()
  {
    return (CountQuery)this.queryData.forCurrentThread(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.CountQuery
 * JD-Core Version:    0.6.2
 */