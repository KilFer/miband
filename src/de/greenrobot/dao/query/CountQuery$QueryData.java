package de.greenrobot.dao.query;

import de.greenrobot.dao.AbstractDao;

final class CountQuery$QueryData<T2> extends AbstractQueryData<T2, CountQuery<T2>>
{
  private CountQuery$QueryData(AbstractDao<T2, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    super(paramAbstractDao, paramString, paramArrayOfString);
  }

  protected final CountQuery<T2> createQuery()
  {
    return new CountQuery(this, this.dao, this.sql, (String[])this.initialValues.clone(), null);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.CountQuery.QueryData
 * JD-Core Version:    0.6.2
 */