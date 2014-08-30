package de.greenrobot.dao.test;

import de.greenrobot.dao.AbstractDao;
import java.util.Random;

public abstract class AbstractDaoTestStringPk<D extends AbstractDao<T, String>, T> extends AbstractDaoTestSinglePk<D, T, String>
{
  public AbstractDaoTestStringPk(Class<D> paramClass)
  {
    super(paramClass);
  }

  protected String createRandomPk()
  {
    int i = 1 + this.random.nextInt(30);
    StringBuilder localStringBuilder = new StringBuilder();
    for (int j = 0; j < i; j++)
      localStringBuilder.append((char)(97 + this.random.nextInt(25)));
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.test.AbstractDaoTestStringPk
 * JD-Core Version:    0.6.2
 */