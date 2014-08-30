package de.greenrobot.dao.query;

import de.greenrobot.dao.AbstractDao;

final class DeleteQuery$QueryData<T2> extends AbstractQueryData<T2, DeleteQuery<T2>>
{
  private DeleteQuery$QueryData(AbstractDao<T2, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    super(paramAbstractDao, paramString, paramArrayOfString);
  }

  protected final DeleteQuery<T2> createQuery()
  {
    return new DeleteQuery(this, this.dao, this.sql, (String[])this.initialValues.clone(), null);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.DeleteQuery.QueryData
 * JD-Core Version:    0.6.2
 */