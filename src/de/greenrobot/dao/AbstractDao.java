package de.greenrobot.dao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.identityscope.IdentityScope;
import de.greenrobot.dao.identityscope.IdentityScopeLong;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.FastCursor;
import de.greenrobot.dao.internal.TableStatements;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractDao<T, K>
{
  protected final DaoConfig config;
  protected final SQLiteDatabase db;
  protected IdentityScope<K, T> identityScope;
  protected IdentityScopeLong<T> identityScopeLong;
  protected final int pkOrdinal;
  protected final AbstractDaoSession session;
  protected TableStatements statements;

  public AbstractDao(DaoConfig paramDaoConfig)
  {
    this(paramDaoConfig, null);
  }

  public AbstractDao(DaoConfig paramDaoConfig, AbstractDaoSession paramAbstractDaoSession)
  {
    this.config = paramDaoConfig;
    this.session = paramAbstractDaoSession;
    this.db = paramDaoConfig.db;
    this.identityScope = paramDaoConfig.getIdentityScope();
    if ((this.identityScope instanceof IdentityScopeLong))
      this.identityScopeLong = ((IdentityScopeLong)this.identityScope);
    this.statements = paramDaoConfig.statements;
    if (paramDaoConfig.pkProperty != null);
    for (int i = paramDaoConfig.pkProperty.ordinal; ; i = -1)
    {
      this.pkOrdinal = i;
      return;
    }
  }

  private void deleteByKeyInsideSynchronized(K paramK, SQLiteStatement paramSQLiteStatement)
  {
    if ((paramK instanceof Long))
      paramSQLiteStatement.bindLong(1, ((Long)paramK).longValue());
    while (true)
    {
      paramSQLiteStatement.execute();
      return;
      if (paramK == null)
        throw new DaoException("Cannot delete entity, key is null");
      paramSQLiteStatement.bindString(1, paramK.toString());
    }
  }

  private void deleteInTxInternal(Iterable<T> paramIterable, Iterable<K> paramIterable1)
  {
    assertSinglePk();
    SQLiteStatement localSQLiteStatement = this.statements.getDeleteStatement();
    this.db.beginTransaction();
    ArrayList localArrayList;
    try
    {
      try
      {
        IdentityScope localIdentityScope = this.identityScope;
        localArrayList = null;
        if (localIdentityScope != null)
        {
          this.identityScope.lock();
          localArrayList = new ArrayList();
        }
        if (paramIterable != null)
          try
          {
            Iterator localIterator2 = paramIterable.iterator();
            while (localIterator2.hasNext())
            {
              Object localObject5 = getKeyVerified(localIterator2.next());
              deleteByKeyInsideSynchronized(localObject5, localSQLiteStatement);
              if (localArrayList != null)
                localArrayList.add(localObject5);
            }
          }
          finally
          {
            if (this.identityScope != null)
              this.identityScope.unlock();
          }
      }
      finally
      {
      }
    }
    finally
    {
      this.db.endTransaction();
    }
    if (paramIterable1 != null)
    {
      Iterator localIterator1 = paramIterable1.iterator();
      while (localIterator1.hasNext())
      {
        Object localObject3 = localIterator1.next();
        deleteByKeyInsideSynchronized(localObject3, localSQLiteStatement);
        if (localArrayList != null)
          localArrayList.add(localObject3);
      }
    }
    if (this.identityScope != null)
      this.identityScope.unlock();
    this.db.setTransactionSuccessful();
    if ((localArrayList != null) && (this.identityScope != null))
      this.identityScope.remove(localArrayList);
    this.db.endTransaction();
  }

  private long executeInsert(T paramT, SQLiteStatement paramSQLiteStatement)
  {
    long l;
    if (this.db.isDbLockedByCurrentThread())
      try
      {
        bindValues(paramSQLiteStatement, paramT);
        l = paramSQLiteStatement.executeInsert();
        updateKeyAfterInsertAndAttach(paramT, l, true);
        return l;
      }
      finally
      {
      }
    this.db.beginTransaction();
    try
    {
    }
    finally
    {
      try
      {
        bindValues(paramSQLiteStatement, paramT);
        l = paramSQLiteStatement.executeInsert();
        this.db.setTransactionSuccessful();
        this.db.endTransaction();
      }
      finally
      {
      }
      this.db.endTransaction();
    }
  }

  private void executeInsertInTx(SQLiteStatement paramSQLiteStatement, Iterable<T> paramIterable, boolean paramBoolean)
  {
    this.db.beginTransaction();
    while (true)
    {
      try
      {
        try
        {
          if (this.identityScope != null)
            this.identityScope.lock();
          try
          {
            Iterator localIterator = paramIterable.iterator();
            if (!localIterator.hasNext())
              break;
            Object localObject4 = localIterator.next();
            bindValues(paramSQLiteStatement, localObject4);
            if (paramBoolean)
            {
              updateKeyAfterInsertAndAttach(localObject4, paramSQLiteStatement.executeInsert(), false);
              continue;
            }
          }
          finally
          {
            if (this.identityScope != null)
              this.identityScope.unlock();
          }
        }
        finally
        {
        }
      }
      finally
      {
        this.db.endTransaction();
      }
      paramSQLiteStatement.execute();
    }
    if (this.identityScope != null)
      this.identityScope.unlock();
    this.db.setTransactionSuccessful();
    this.db.endTransaction();
  }

  protected void assertSinglePk()
  {
    if (this.config.pkColumns.length != 1)
      throw new DaoException(this + " (" + this.config.tablename + ") does not have a single-column primary key");
  }

  protected void attachEntity(T paramT)
  {
  }

  protected final void attachEntity(K paramK, T paramT, boolean paramBoolean)
  {
    attachEntity(paramT);
    if ((this.identityScope != null) && (paramK != null))
    {
      if (paramBoolean)
        this.identityScope.put(paramK, paramT);
    }
    else
      return;
    this.identityScope.putNoLock(paramK, paramT);
  }

  protected abstract void bindValues(SQLiteStatement paramSQLiteStatement, T paramT);

  public long count()
  {
    return DatabaseUtils.queryNumEntries(this.db, "'" + this.config.tablename + '\'');
  }

  public void delete(T paramT)
  {
    assertSinglePk();
    deleteByKey(getKeyVerified(paramT));
  }

  public void deleteAll()
  {
    this.db.execSQL("DELETE FROM '" + this.config.tablename + "'");
    if (this.identityScope != null)
      this.identityScope.clear();
  }

  public void deleteByKey(K paramK)
  {
    assertSinglePk();
    SQLiteStatement localSQLiteStatement = this.statements.getDeleteStatement();
    if (this.db.isDbLockedByCurrentThread())
      try
      {
        deleteByKeyInsideSynchronized(paramK, localSQLiteStatement);
        if (this.identityScope != null)
          this.identityScope.remove(paramK);
        return;
      }
      finally
      {
      }
    this.db.beginTransaction();
    try
    {
    }
    finally
    {
      try
      {
        deleteByKeyInsideSynchronized(paramK, localSQLiteStatement);
        this.db.setTransactionSuccessful();
        this.db.endTransaction();
      }
      finally
      {
      }
      this.db.endTransaction();
    }
  }

  public void deleteByKeyInTx(Iterable<K> paramIterable)
  {
    deleteInTxInternal(null, paramIterable);
  }

  public void deleteByKeyInTx(K[] paramArrayOfK)
  {
    deleteInTxInternal(null, Arrays.asList(paramArrayOfK));
  }

  public void deleteInTx(Iterable<T> paramIterable)
  {
    deleteInTxInternal(paramIterable, null);
  }

  public void deleteInTx(T[] paramArrayOfT)
  {
    deleteInTxInternal(Arrays.asList(paramArrayOfT), null);
  }

  public boolean detach(T paramT)
  {
    if (this.identityScope != null)
    {
      Object localObject = getKeyVerified(paramT);
      return this.identityScope.detach(localObject, paramT);
    }
    return false;
  }

  public String[] getAllColumns()
  {
    return this.config.allColumns;
  }

  public SQLiteDatabase getDatabase()
  {
    return this.db;
  }

  protected abstract K getKey(T paramT);

  protected K getKeyVerified(T paramT)
  {
    Object localObject = getKey(paramT);
    if (localObject == null)
    {
      if (paramT == null)
        throw new NullPointerException("Entity may not be null");
      throw new DaoException("Entity has no key");
    }
    return localObject;
  }

  public String[] getNonPkColumns()
  {
    return this.config.nonPkColumns;
  }

  public String[] getPkColumns()
  {
    return this.config.pkColumns;
  }

  public Property getPkProperty()
  {
    return this.config.pkProperty;
  }

  public Property[] getProperties()
  {
    return this.config.properties;
  }

  public AbstractDaoSession getSession()
  {
    return this.session;
  }

  TableStatements getStatements()
  {
    return this.config.statements;
  }

  public String getTablename()
  {
    return this.config.tablename;
  }

  public long insert(T paramT)
  {
    return executeInsert(paramT, this.statements.getInsertStatement());
  }

  public void insertInTx(Iterable<T> paramIterable)
  {
    insertInTx(paramIterable, isEntityUpdateable());
  }

  public void insertInTx(Iterable<T> paramIterable, boolean paramBoolean)
  {
    executeInsertInTx(this.statements.getInsertStatement(), paramIterable, paramBoolean);
  }

  public void insertInTx(T[] paramArrayOfT)
  {
    insertInTx(Arrays.asList(paramArrayOfT), isEntityUpdateable());
  }

  public long insertOrReplace(T paramT)
  {
    return executeInsert(paramT, this.statements.getInsertOrReplaceStatement());
  }

  public void insertOrReplaceInTx(Iterable<T> paramIterable)
  {
    insertOrReplaceInTx(paramIterable, isEntityUpdateable());
  }

  public void insertOrReplaceInTx(Iterable<T> paramIterable, boolean paramBoolean)
  {
    executeInsertInTx(this.statements.getInsertOrReplaceStatement(), paramIterable, paramBoolean);
  }

  public void insertOrReplaceInTx(T[] paramArrayOfT)
  {
    insertOrReplaceInTx(Arrays.asList(paramArrayOfT), isEntityUpdateable());
  }

  public long insertWithoutSettingPk(T paramT)
  {
    SQLiteStatement localSQLiteStatement = this.statements.getInsertStatement();
    if (this.db.isDbLockedByCurrentThread())
      try
      {
        bindValues(localSQLiteStatement, paramT);
        long l2 = localSQLiteStatement.executeInsert();
        return l2;
      }
      finally
      {
        localObject3 = finally;
        throw localObject3;
      }
    this.db.beginTransaction();
    try
    {
      try
      {
        bindValues(localSQLiteStatement, paramT);
        long l1 = localSQLiteStatement.executeInsert();
        this.db.setTransactionSuccessful();
        return l1;
      }
      finally
      {
      }
    }
    finally
    {
      this.db.endTransaction();
    }
  }

  protected abstract boolean isEntityUpdateable();

  public T load(K paramK)
  {
    assertSinglePk();
    Object localObject;
    if (paramK == null)
      localObject = null;
    do
    {
      return localObject;
      if (this.identityScope == null)
        break;
      localObject = this.identityScope.get(paramK);
    }
    while (localObject != null);
    String str = this.statements.getSelectByKey();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramK.toString();
    return loadUniqueAndCloseCursor(this.db.rawQuery(str, arrayOfString));
  }

  public List<T> loadAll()
  {
    return loadAllAndCloseCursor(this.db.rawQuery(this.statements.getSelectAll(), null));
  }

  protected List<T> loadAllAndCloseCursor(Cursor paramCursor)
  {
    try
    {
      List localList = loadAllFromCursor(paramCursor);
      return localList;
    }
    finally
    {
      paramCursor.close();
    }
  }

  protected List<T> loadAllFromCursor(Cursor paramCursor)
  {
    int i = paramCursor.getCount();
    ArrayList localArrayList = new ArrayList(i);
    CursorWindow localCursorWindow;
    if ((paramCursor instanceof CrossProcessCursor))
    {
      localCursorWindow = ((CrossProcessCursor)paramCursor).getWindow();
      if (localCursorWindow != null)
      {
        if (localCursorWindow.getNumRows() != i)
          break label138;
        paramCursor = new FastCursor(localCursorWindow);
      }
    }
    while (true)
    {
      if (paramCursor.moveToFirst())
        if (this.identityScope != null)
        {
          this.identityScope.lock();
          this.identityScope.reserveRoom(i);
        }
      try
      {
        boolean bool;
        do
        {
          localArrayList.add(loadCurrent(paramCursor, 0, false));
          bool = paramCursor.moveToNext();
        }
        while (bool);
        return localArrayList;
        label138: DaoLog.d("Window vs. result size: " + localCursorWindow.getNumRows() + "/" + i);
      }
      finally
      {
        if (this.identityScope != null)
          this.identityScope.unlock();
      }
    }
  }

  public T loadByRowId(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(paramLong);
    return loadUniqueAndCloseCursor(this.db.rawQuery(this.statements.getSelectByRowId(), arrayOfString));
  }

  protected final T loadCurrent(Cursor paramCursor, int paramInt, boolean paramBoolean)
  {
    Object localObject3;
    if (this.identityScopeLong != null)
      if (paramInt != 0)
      {
        boolean bool = paramCursor.isNull(paramInt + this.pkOrdinal);
        localObject3 = null;
        if (!bool);
      }
    label116: Object localObject2;
    do
    {
      while (true)
      {
        return localObject3;
        long l = paramCursor.getLong(paramInt + this.pkOrdinal);
        if (paramBoolean);
        Object localObject6;
        for (localObject3 = this.identityScopeLong.get2(l); localObject3 == null; localObject3 = this.identityScopeLong.get2NoLock(l))
        {
          localObject6 = readEntity(paramCursor, paramInt);
          attachEntity(localObject6);
          if (!paramBoolean)
            break label116;
          this.identityScopeLong.put2(l, localObject6);
          return localObject6;
        }
        continue;
        this.identityScopeLong.put2NoLock(l, localObject6);
        return localObject6;
        if (this.identityScope == null)
          break;
        Object localObject4 = readKey(paramCursor, paramInt);
        if (paramInt != 0)
        {
          localObject3 = null;
          if (localObject4 == null);
        }
        else
        {
          if (paramBoolean);
          for (localObject3 = this.identityScope.get(localObject4); localObject3 == null; localObject3 = this.identityScope.getNoLock(localObject4))
          {
            Object localObject5 = readEntity(paramCursor, paramInt);
            attachEntity(localObject4, localObject5, paramBoolean);
            return localObject5;
          }
        }
      }
      if (paramInt == 0)
        break;
      localObject2 = readKey(paramCursor, paramInt);
      localObject3 = null;
    }
    while (localObject2 == null);
    Object localObject1 = readEntity(paramCursor, paramInt);
    attachEntity(localObject1);
    return localObject1;
  }

  protected final <O> O loadCurrentOther(AbstractDao<O, ?> paramAbstractDao, Cursor paramCursor, int paramInt)
  {
    return paramAbstractDao.loadCurrent(paramCursor, paramInt, true);
  }

  protected T loadUnique(Cursor paramCursor)
  {
    if (!paramCursor.moveToFirst())
      return null;
    if (!paramCursor.isLast())
      throw new DaoException("Expected unique result, but count was " + paramCursor.getCount());
    return loadCurrent(paramCursor, 0, true);
  }

  protected T loadUniqueAndCloseCursor(Cursor paramCursor)
  {
    try
    {
      Object localObject2 = loadUnique(paramCursor);
      return localObject2;
    }
    finally
    {
      paramCursor.close();
    }
  }

  public QueryBuilder<T> queryBuilder()
  {
    return QueryBuilder.internalCreate(this);
  }

  public List<T> queryRaw(String paramString, String[] paramArrayOfString)
  {
    return loadAllAndCloseCursor(this.db.rawQuery(this.statements.getSelectAll() + paramString, paramArrayOfString));
  }

  public Query<T> queryRawCreate(String paramString, Object[] paramArrayOfObject)
  {
    return queryRawCreateListArgs(paramString, Arrays.asList(paramArrayOfObject));
  }

  public Query<T> queryRawCreateListArgs(String paramString, Collection<Object> paramCollection)
  {
    return Query.internalCreate(this, this.statements.getSelectAll() + paramString, paramCollection.toArray());
  }

  protected abstract T readEntity(Cursor paramCursor, int paramInt);

  protected abstract void readEntity(Cursor paramCursor, T paramT, int paramInt);

  protected abstract K readKey(Cursor paramCursor, int paramInt);

  public void refresh(T paramT)
  {
    assertSinglePk();
    Object localObject1 = getKeyVerified(paramT);
    String str = this.statements.getSelectByKey();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = localObject1.toString();
    Cursor localCursor = this.db.rawQuery(str, arrayOfString);
    try
    {
      if (!localCursor.moveToFirst())
        throw new DaoException("Entity does not exist in the database anymore: " + paramT.getClass() + " with key " + localObject1);
    }
    finally
    {
      localCursor.close();
    }
    if (!localCursor.isLast())
      throw new DaoException("Expected unique result, but count was " + localCursor.getCount());
    readEntity(localCursor, paramT, 0);
    attachEntity(localObject1, paramT, true);
    localCursor.close();
  }

  public void update(T paramT)
  {
    assertSinglePk();
    SQLiteStatement localSQLiteStatement = this.statements.getUpdateStatement();
    if (this.db.isDbLockedByCurrentThread())
      try
      {
        updateInsideSynchronized(paramT, localSQLiteStatement, true);
        return;
      }
      finally
      {
        localObject3 = finally;
        throw localObject3;
      }
    this.db.beginTransaction();
    try
    {
      try
      {
        updateInsideSynchronized(paramT, localSQLiteStatement, true);
        this.db.setTransactionSuccessful();
        return;
      }
      finally
      {
      }
    }
    finally
    {
      this.db.endTransaction();
    }
  }

  public void updateInTx(Iterable<T> paramIterable)
  {
    SQLiteStatement localSQLiteStatement = this.statements.getUpdateStatement();
    this.db.beginTransaction();
    try
    {
      try
      {
        if (this.identityScope != null)
          this.identityScope.lock();
        try
        {
          Iterator localIterator = paramIterable.iterator();
          while (localIterator.hasNext())
            updateInsideSynchronized(localIterator.next(), localSQLiteStatement, false);
        }
        finally
        {
          if (this.identityScope != null)
            this.identityScope.unlock();
        }
      }
      finally
      {
      }
    }
    finally
    {
      this.db.endTransaction();
    }
    if (this.identityScope != null)
      this.identityScope.unlock();
    this.db.setTransactionSuccessful();
    this.db.endTransaction();
  }

  public void updateInTx(T[] paramArrayOfT)
  {
    updateInTx(Arrays.asList(paramArrayOfT));
  }

  protected void updateInsideSynchronized(T paramT, SQLiteStatement paramSQLiteStatement, boolean paramBoolean)
  {
    bindValues(paramSQLiteStatement, paramT);
    int i = 1 + this.config.allColumns.length;
    Object localObject = getKey(paramT);
    if ((localObject instanceof Long))
      paramSQLiteStatement.bindLong(i, ((Long)localObject).longValue());
    while (true)
    {
      paramSQLiteStatement.execute();
      attachEntity(localObject, paramT, paramBoolean);
      return;
      if (localObject == null)
        throw new DaoException("Cannot update entity without key - was it inserted before?");
      paramSQLiteStatement.bindString(i, localObject.toString());
    }
  }

  protected abstract K updateKeyAfterInsert(T paramT, long paramLong);

  protected void updateKeyAfterInsertAndAttach(T paramT, long paramLong, boolean paramBoolean)
  {
    if (paramLong != -1L)
    {
      attachEntity(updateKeyAfterInsert(paramT, paramLong), paramT, paramBoolean);
      return;
    }
    DaoLog.w("Could not insert row (executeInsert returned -1)");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.AbstractDao
 * JD-Core Version:    0.6.2
 */