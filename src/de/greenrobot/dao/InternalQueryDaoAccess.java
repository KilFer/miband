package de.greenrobot.dao;

import android.database.Cursor;
import de.greenrobot.dao.internal.TableStatements;
import java.util.List;

public final class InternalQueryDaoAccess<T>
{
  private final AbstractDao<T, ?> dao;

  public InternalQueryDaoAccess(AbstractDao<T, ?> paramAbstractDao)
  {
    this.dao = paramAbstractDao;
  }

  public static <T2> TableStatements getStatements(AbstractDao<T2, ?> paramAbstractDao)
  {
    return paramAbstractDao.getStatements();
  }

  public final TableStatements getStatements()
  {
    return this.dao.getStatements();
  }

  public final List<T> loadAllAndCloseCursor(Cursor paramCursor)
  {
    return this.dao.loadAllAndCloseCursor(paramCursor);
  }

  public final T loadCurrent(Cursor paramCursor, int paramInt, boolean paramBoolean)
  {
    return this.dao.loadCurrent(paramCursor, paramInt, paramBoolean);
  }

  public final T loadUniqueAndCloseCursor(Cursor paramCursor)
  {
    return this.dao.loadUniqueAndCloseCursor(paramCursor);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.InternalQueryDaoAccess
 * JD-Core Version:    0.6.2
 */