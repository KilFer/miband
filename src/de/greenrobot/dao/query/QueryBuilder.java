package de.greenrobot.dao.query;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.InternalQueryDaoAccess;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.TableStatements;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class QueryBuilder<T>
{
  public static boolean LOG_SQL;
  public static boolean LOG_VALUES;
  private final AbstractDao<T, ?> dao;
  private StringBuilder joinBuilder;
  private Integer limit;
  private Integer offset;
  private StringBuilder orderBuilder;
  private final String tablePrefix;
  private final List<Object> values;
  private final List<WhereCondition> whereConditions;

  protected QueryBuilder(AbstractDao<T, ?> paramAbstractDao)
  {
    this(paramAbstractDao, "T");
  }

  protected QueryBuilder(AbstractDao<T, ?> paramAbstractDao, String paramString)
  {
    this.dao = paramAbstractDao;
    this.tablePrefix = paramString;
    this.values = new ArrayList();
    this.whereConditions = new ArrayList();
  }

  private void appendWhereClause(StringBuilder paramStringBuilder, String paramString)
  {
    this.values.clear();
    if (!this.whereConditions.isEmpty())
    {
      paramStringBuilder.append(" WHERE ");
      ListIterator localListIterator = this.whereConditions.listIterator();
      while (localListIterator.hasNext())
      {
        if (localListIterator.hasPrevious())
          paramStringBuilder.append(" AND ");
        WhereCondition localWhereCondition = (WhereCondition)localListIterator.next();
        localWhereCondition.appendTo(paramStringBuilder, paramString);
        localWhereCondition.appendValuesTo(this.values);
      }
    }
  }

  private void checkOrderBuilder()
  {
    if (this.orderBuilder == null)
      this.orderBuilder = new StringBuilder();
    while (this.orderBuilder.length() <= 0)
      return;
    this.orderBuilder.append(",");
  }

  public static <T2> QueryBuilder<T2> internalCreate(AbstractDao<T2, ?> paramAbstractDao)
  {
    return new QueryBuilder(paramAbstractDao);
  }

  private void orderAscOrDesc(String paramString, Property[] paramArrayOfProperty)
  {
    int i = paramArrayOfProperty.length;
    for (int j = 0; j < i; j++)
    {
      Property localProperty = paramArrayOfProperty[j];
      checkOrderBuilder();
      append(this.orderBuilder, localProperty);
      if (String.class.equals(localProperty.type))
        this.orderBuilder.append(" COLLATE LOCALIZED");
      this.orderBuilder.append(paramString);
    }
  }

  protected void addCondition(StringBuilder paramStringBuilder, List<Object> paramList, WhereCondition paramWhereCondition)
  {
    checkCondition(paramWhereCondition);
    paramWhereCondition.appendTo(paramStringBuilder, this.tablePrefix);
    paramWhereCondition.appendValuesTo(paramList);
  }

  public WhereCondition and(WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition[] paramArrayOfWhereCondition)
  {
    return combineWhereConditions(" AND ", paramWhereCondition1, paramWhereCondition2, paramArrayOfWhereCondition);
  }

  protected StringBuilder append(StringBuilder paramStringBuilder, Property paramProperty)
  {
    checkProperty(paramProperty);
    paramStringBuilder.append(this.tablePrefix).append('.').append('\'').append(paramProperty.columnName).append('\'');
    return paramStringBuilder;
  }

  public Query<T> build()
  {
    int i = -1;
    String str1;
    StringBuilder localStringBuilder;
    if ((this.joinBuilder == null) || (this.joinBuilder.length() == 0))
    {
      str1 = InternalQueryDaoAccess.getStatements(this.dao).getSelectAll();
      localStringBuilder = new StringBuilder(str1);
      appendWhereClause(localStringBuilder, this.tablePrefix);
      if ((this.orderBuilder != null) && (this.orderBuilder.length() > 0))
        localStringBuilder.append(" ORDER BY ").append(this.orderBuilder);
      if (this.limit == null)
        break label286;
      localStringBuilder.append(" LIMIT ?");
      this.values.add(this.limit);
    }
    label286: for (int j = -1 + this.values.size(); ; j = i)
    {
      if (this.offset != null)
      {
        if (this.limit == null)
        {
          throw new IllegalStateException("Offset cannot be set without limit");
          str1 = SqlUtils.createSqlSelect(this.dao.getTablename(), this.tablePrefix, this.dao.getAllColumns());
          break;
        }
        localStringBuilder.append(" OFFSET ?");
        this.values.add(this.offset);
        i = -1 + this.values.size();
      }
      String str2 = localStringBuilder.toString();
      if (LOG_SQL)
        DaoLog.d("Built SQL for query: " + str2);
      if (LOG_VALUES)
        DaoLog.d("Values for query: " + this.values);
      return Query.create(this.dao, str2, this.values.toArray(), j, i);
    }
  }

  public CountQuery<T> buildCount()
  {
    StringBuilder localStringBuilder = new StringBuilder(SqlUtils.createSqlSelectCountStar(this.dao.getTablename(), this.tablePrefix));
    appendWhereClause(localStringBuilder, this.tablePrefix);
    String str = localStringBuilder.toString();
    if (LOG_SQL)
      DaoLog.d("Built SQL for count query: " + str);
    if (LOG_VALUES)
      DaoLog.d("Values for count query: " + this.values);
    return CountQuery.create(this.dao, str, this.values.toArray());
  }

  public DeleteQuery<T> buildDelete()
  {
    String str1 = this.dao.getTablename();
    StringBuilder localStringBuilder = new StringBuilder(SqlUtils.createSqlDelete(str1, null));
    appendWhereClause(localStringBuilder, this.tablePrefix);
    String str2 = localStringBuilder.toString().replace(this.tablePrefix + ".'", str1 + ".'");
    if (LOG_SQL)
      DaoLog.d("Built SQL for delete query: " + str2);
    if (LOG_VALUES)
      DaoLog.d("Values for delete query: " + this.values);
    return DeleteQuery.create(this.dao, str2, this.values.toArray());
  }

  protected void checkCondition(WhereCondition paramWhereCondition)
  {
    if ((paramWhereCondition instanceof WhereCondition.PropertyCondition))
      checkProperty(((WhereCondition.PropertyCondition)paramWhereCondition).property);
  }

  protected void checkProperty(Property paramProperty)
  {
    if (this.dao != null)
    {
      Property[] arrayOfProperty = this.dao.getProperties();
      int i = arrayOfProperty.length;
      for (int j = 0; ; j++)
      {
        int k = 0;
        if (j < i)
        {
          if (paramProperty == arrayOfProperty[j])
            k = 1;
        }
        else
        {
          if (k != 0)
            break;
          throw new DaoException("Property '" + paramProperty.name + "' is not part of " + this.dao);
        }
      }
    }
  }

  protected WhereCondition combineWhereConditions(String paramString, WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition[] paramArrayOfWhereCondition)
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    ArrayList localArrayList = new ArrayList();
    addCondition(localStringBuilder, localArrayList, paramWhereCondition1);
    localStringBuilder.append(paramString);
    addCondition(localStringBuilder, localArrayList, paramWhereCondition2);
    int i = paramArrayOfWhereCondition.length;
    for (int j = 0; j < i; j++)
    {
      WhereCondition localWhereCondition = paramArrayOfWhereCondition[j];
      localStringBuilder.append(paramString);
      addCondition(localStringBuilder, localArrayList, localWhereCondition);
    }
    localStringBuilder.append(')');
    return new WhereCondition.StringCondition(localStringBuilder.toString(), localArrayList.toArray());
  }

  public long count()
  {
    return buildCount().count();
  }

  public <J> QueryBuilder<J> join(Class<J> paramClass, Property paramProperty)
  {
    throw new UnsupportedOperationException();
  }

  public <J> QueryBuilder<J> joinToMany(Class<J> paramClass, Property paramProperty)
  {
    throw new UnsupportedOperationException();
  }

  public QueryBuilder<T> limit(int paramInt)
  {
    this.limit = Integer.valueOf(paramInt);
    return this;
  }

  public List<T> list()
  {
    return build().list();
  }

  public CloseableListIterator<T> listIterator()
  {
    return build().listIterator();
  }

  public LazyList<T> listLazy()
  {
    return build().listLazy();
  }

  public LazyList<T> listLazyUncached()
  {
    return build().listLazyUncached();
  }

  public QueryBuilder<T> offset(int paramInt)
  {
    this.offset = Integer.valueOf(paramInt);
    return this;
  }

  public WhereCondition or(WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition[] paramArrayOfWhereCondition)
  {
    return combineWhereConditions(" OR ", paramWhereCondition1, paramWhereCondition2, paramArrayOfWhereCondition);
  }

  public QueryBuilder<T> orderAsc(Property[] paramArrayOfProperty)
  {
    orderAscOrDesc(" ASC", paramArrayOfProperty);
    return this;
  }

  public QueryBuilder<T> orderCustom(Property paramProperty, String paramString)
  {
    checkOrderBuilder();
    append(this.orderBuilder, paramProperty).append(' ');
    this.orderBuilder.append(paramString);
    return this;
  }

  public QueryBuilder<T> orderDesc(Property[] paramArrayOfProperty)
  {
    orderAscOrDesc(" DESC", paramArrayOfProperty);
    return this;
  }

  public QueryBuilder<T> orderRaw(String paramString)
  {
    checkOrderBuilder();
    this.orderBuilder.append(paramString);
    return this;
  }

  public T unique()
  {
    return build().unique();
  }

  public T uniqueOrThrow()
  {
    return build().uniqueOrThrow();
  }

  public QueryBuilder<T> where(WhereCondition paramWhereCondition, WhereCondition[] paramArrayOfWhereCondition)
  {
    this.whereConditions.add(paramWhereCondition);
    int i = paramArrayOfWhereCondition.length;
    for (int j = 0; j < i; j++)
    {
      WhereCondition localWhereCondition = paramArrayOfWhereCondition[j];
      checkCondition(localWhereCondition);
      this.whereConditions.add(localWhereCondition);
    }
    return this;
  }

  public QueryBuilder<T> whereOr(WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition[] paramArrayOfWhereCondition)
  {
    this.whereConditions.add(or(paramWhereCondition1, paramWhereCondition2, paramArrayOfWhereCondition));
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.QueryBuilder
 * JD-Core Version:    0.6.2
 */