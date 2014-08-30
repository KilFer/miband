package de.greenrobot.dao.test;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.InternalUnitTestDaoAccess;
import java.util.Random;

public abstract class AbstractDaoTestLongPk<D extends AbstractDao<T, Long>, T> extends AbstractDaoTestSinglePk<D, T, Long>
{
  public AbstractDaoTestLongPk(Class<D> paramClass)
  {
    super(paramClass);
  }

  protected Long createRandomPk()
  {
    return Long.valueOf(this.random.nextLong());
  }

  public void testAssignPk()
  {
    if (this.daoAccess.isEntityUpdateable())
    {
      Object localObject1 = createEntity(null);
      if (localObject1 != null)
      {
        Object localObject2 = createEntity(null);
        this.dao.insert(localObject1);
        this.dao.insert(localObject2);
        Long localLong1 = (Long)this.daoAccess.getKey(localObject1);
        assertNotNull(localLong1);
        Long localLong2 = (Long)this.daoAccess.getKey(localObject2);
        assertNotNull(localLong2);
        assertFalse(localLong1.equals(localLong2));
        assertNotNull(this.dao.load(localLong1));
        assertNotNull(this.dao.load(localLong2));
        return;
      }
      DaoLog.d("Skipping testAssignPk for " + this.daoClass + " (createEntity returned null for null key)");
      return;
    }
    DaoLog.d("Skipping testAssignPk for not updateable " + this.daoClass);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.test.AbstractDaoTestLongPk
 * JD-Core Version:    0.6.2
 */