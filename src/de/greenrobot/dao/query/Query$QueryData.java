package de.greenrobot.dao.query;

import de.greenrobot.dao.AbstractDao;

final class Query$QueryData<T2> extends AbstractQueryData<T2, Query<T2>>
{
  private final int limitPosition;
  private final int offsetPosition;

  Query$QueryData(AbstractDao<T2, ?> paramAbstractDao, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    super(paramAbstractDao, paramString, paramArrayOfString);
    this.limitPosition = paramInt1;
    this.offsetPosition = paramInt2;
  }

  protected final Query<T2> createQuery()
  {
    return new Query(this, this.dao, this.sql, (String[])this.initialValues.clone(), this.limitPosition, this.offsetPosition, null);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.Query.QueryData
 * JD-Core Version:    0.6.2
 */