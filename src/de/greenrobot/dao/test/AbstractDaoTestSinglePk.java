package de.greenrobot.dao.test;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.InternalUnitTestDaoAccess;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class AbstractDaoTestSinglePk<D extends AbstractDao<T, K>, T, K> extends AbstractDaoTest<D, T, K>
{
  private Property pkColumn;
  protected Set<K> usedPks = new HashSet();

  public AbstractDaoTestSinglePk(Class<D> paramClass)
  {
    super(paramClass);
  }

  protected abstract T createEntity(K paramK);

  protected T createEntityWithRandomPk()
  {
    return createEntity(nextPk());
  }

  protected abstract K createRandomPk();

  protected K nextPk()
  {
    for (int i = 0; i < 100000; i++)
    {
      Object localObject = createRandomPk();
      if (this.usedPks.add(localObject))
        return localObject;
    }
    throw new IllegalStateException("Could not find a new PK");
  }

  protected Cursor queryWithDummyColumnsInFront(int paramInt, String paramString, K paramK)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("SELECT ");
    for (int j = 0; j < paramInt; j++)
      localStringBuilder.append(paramString).append(",");
    SqlUtils.appendColumns(localStringBuilder, "T", this.dao.getAllColumns()).append(" FROM ");
    localStringBuilder.append(this.dao.getTablename()).append(" T");
    if (paramK != null)
    {
      localStringBuilder.append(" WHERE ");
      assertEquals(1, this.dao.getPkColumns().length);
      localStringBuilder.append(this.dao.getPkColumns()[0]).append("=");
      DatabaseUtils.appendValueToSql(localStringBuilder, paramK);
    }
    String str = localStringBuilder.toString();
    Cursor localCursor = this.db.rawQuery(str, null);
    assertTrue(localCursor.moveToFirst());
    while (true)
    {
      if (i < paramInt);
      try
      {
        assertEquals(paramString, localCursor.getString(i));
        i++;
        continue;
        if (paramK != null)
          assertEquals(1, localCursor.getCount());
        return localCursor;
      }
      catch (RuntimeException localRuntimeException)
      {
        localCursor.close();
        throw localRuntimeException;
      }
    }
  }

  protected void runLoadPkTest(int paramInt)
  {
    Object localObject1 = nextPk();
    Object localObject2 = createEntity(localObject1);
    this.dao.insert(localObject2);
    Cursor localCursor = queryWithDummyColumnsInFront(paramInt, "42", localObject1);
    try
    {
      assertEquals(localObject1, this.daoAccess.readKey(localCursor, paramInt));
      return;
    }
    finally
    {
      localCursor.close();
    }
  }

  protected void setUp()
  {
    super.setUp();
    for (Property localProperty : this.daoAccess.getProperties())
      if (localProperty.primaryKey)
      {
        if (this.pkColumn != null)
          throw new RuntimeException("Test does not work with multiple PK columns");
        this.pkColumn = localProperty;
      }
    if (this.pkColumn == null)
      throw new RuntimeException("Test does not work without a PK column");
  }

  public void testCount()
  {
    this.dao.deleteAll();
    assertEquals(0L, this.dao.count());
    this.dao.insert(createEntityWithRandomPk());
    assertEquals(1L, this.dao.count());
    this.dao.insert(createEntityWithRandomPk());
    assertEquals(2L, this.dao.count());
  }

  public void testDelete()
  {
    Object localObject1 = nextPk();
    this.dao.deleteByKey(localObject1);
    Object localObject2 = createEntity(localObject1);
    this.dao.insert(localObject2);
    assertNotNull(this.dao.load(localObject1));
    this.dao.deleteByKey(localObject1);
    assertNull(this.dao.load(localObject1));
  }

  public void testDeleteAll()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < 10; i++)
      localArrayList.add(createEntityWithRandomPk());
    this.dao.insertInTx(localArrayList);
    this.dao.deleteAll();
    assertEquals(0L, this.dao.count());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = this.daoAccess.getKey(localObject1);
      assertNotNull(localObject2);
      assertNull(this.dao.load(localObject2));
    }
  }

  public void testDeleteByKeyInTx()
  {
    ArrayList localArrayList1 = new ArrayList();
    for (int i = 0; i < 10; i++)
      localArrayList1.add(createEntityWithRandomPk());
    this.dao.insertInTx(localArrayList1);
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(this.daoAccess.getKey(localArrayList1.get(0)));
    localArrayList2.add(this.daoAccess.getKey(localArrayList1.get(3)));
    localArrayList2.add(this.daoAccess.getKey(localArrayList1.get(4)));
    localArrayList2.add(this.daoAccess.getKey(localArrayList1.get(8)));
    this.dao.deleteByKeyInTx(localArrayList2);
    assertEquals(localArrayList1.size() - localArrayList2.size(), this.dao.count());
    Iterator localIterator = localArrayList2.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      assertNotNull(localObject);
      assertNull(this.dao.load(localObject));
    }
  }

  public void testDeleteInTx()
  {
    ArrayList localArrayList1 = new ArrayList();
    for (int i = 0; i < 10; i++)
      localArrayList1.add(createEntityWithRandomPk());
    this.dao.insertInTx(localArrayList1);
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(localArrayList1.get(0));
    localArrayList2.add(localArrayList1.get(3));
    localArrayList2.add(localArrayList1.get(4));
    localArrayList2.add(localArrayList1.get(8));
    this.dao.deleteInTx(localArrayList2);
    assertEquals(localArrayList1.size() - localArrayList2.size(), this.dao.count());
    Iterator localIterator = localArrayList2.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = this.daoAccess.getKey(localObject1);
      assertNotNull(localObject2);
      assertNull(this.dao.load(localObject2));
    }
  }

  public void testInsertAndLoad()
  {
    Object localObject1 = nextPk();
    Object localObject2 = createEntity(localObject1);
    this.dao.insert(localObject2);
    assertEquals(localObject1, this.daoAccess.getKey(localObject2));
    Object localObject3 = this.dao.load(localObject1);
    assertNotNull(localObject3);
    assertEquals(this.daoAccess.getKey(localObject2), this.daoAccess.getKey(localObject3));
  }

  public void testInsertInTx()
  {
    this.dao.deleteAll();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < 20; i++)
      localArrayList.add(createEntityWithRandomPk());
    this.dao.insertInTx(localArrayList);
    assertEquals(localArrayList.size(), this.dao.count());
  }

  public void testInsertOrReplaceInTx()
  {
    this.dao.deleteAll();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    for (int i = 0; i < 20; i++)
    {
      Object localObject = createEntityWithRandomPk();
      if (i % 2 == 0)
        localArrayList1.add(localObject);
      localArrayList2.add(localObject);
    }
    this.dao.insertOrReplaceInTx(localArrayList1);
    this.dao.insertOrReplaceInTx(localArrayList2);
    assertEquals(localArrayList2.size(), this.dao.count());
  }

  public void testInsertOrReplaceTwice()
  {
    Object localObject = createEntityWithRandomPk();
    long l1 = this.dao.insert(localObject);
    long l2 = this.dao.insertOrReplace(localObject);
    if (this.dao.getPkProperty().type == Long.class)
      assertEquals(l1, l2);
  }

  public void testInsertTwice()
  {
    Object localObject = createEntity(nextPk());
    this.dao.insert(localObject);
    try
    {
      this.dao.insert(localObject);
      fail("Inserting twice should not work");
      return;
    }
    catch (SQLException localSQLException)
    {
    }
  }

  public void testLoadAll()
  {
    this.dao.deleteAll();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < 15; i++)
      localArrayList.add(createEntity(nextPk()));
    this.dao.insertInTx(localArrayList);
    List localList = this.dao.loadAll();
    assertEquals(localArrayList.size(), localList.size());
  }

  public void testLoadPk()
  {
    runLoadPkTest(0);
  }

  public void testLoadPkWithOffset()
  {
    runLoadPkTest(10);
  }

  public void testQuery()
  {
    this.dao.insert(createEntityWithRandomPk());
    Object localObject = nextPk();
    this.dao.insert(createEntity(localObject));
    this.dao.insert(createEntityWithRandomPk());
    String str = "WHERE " + this.dao.getPkColumns()[0] + "=?";
    AbstractDao localAbstractDao = this.dao;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = localObject.toString();
    List localList = localAbstractDao.queryRaw(str, arrayOfString);
    assertEquals(1, localList.size());
    assertEquals(localObject, this.daoAccess.getKey(localList.get(0)));
  }

  public void testReadWithOffset()
  {
    Object localObject1 = nextPk();
    Object localObject2 = createEntity(localObject1);
    this.dao.insert(localObject2);
    Cursor localCursor = queryWithDummyColumnsInFront(5, "42", localObject1);
    try
    {
      Object localObject4 = this.daoAccess.readEntity(localCursor, 5);
      assertEquals(localObject1, this.daoAccess.getKey(localObject4));
      return;
    }
    finally
    {
      localCursor.close();
    }
  }

  public void testRowId()
  {
    Object localObject1 = createEntityWithRandomPk();
    Object localObject2 = createEntityWithRandomPk();
    if (this.dao.insert(localObject1) != this.dao.insert(localObject2));
    for (boolean bool = true; ; bool = false)
    {
      assertTrue(bool);
      return;
    }
  }

  public void testUpdate()
  {
    this.dao.deleteAll();
    Object localObject = createEntityWithRandomPk();
    this.dao.insert(localObject);
    this.dao.update(localObject);
    assertEquals(1L, this.dao.count());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.test.AbstractDaoTestSinglePk
 * JD-Core Version:    0.6.2
 */