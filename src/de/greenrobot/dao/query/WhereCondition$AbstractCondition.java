package de.greenrobot.dao.query;

import java.util.List;

public abstract class WhereCondition$AbstractCondition
  implements WhereCondition
{
  protected final boolean hasSingleValue;
  protected final Object value;
  protected final Object[] values;

  public WhereCondition$AbstractCondition()
  {
    this.hasSingleValue = false;
    this.value = null;
    this.values = null;
  }

  public WhereCondition$AbstractCondition(Object paramObject)
  {
    this.value = paramObject;
    this.hasSingleValue = true;
    this.values = null;
  }

  public WhereCondition$AbstractCondition(Object[] paramArrayOfObject)
  {
    this.value = null;
    this.hasSingleValue = false;
    this.values = paramArrayOfObject;
  }

  public void appendValuesTo(List<Object> paramList)
  {
    if (this.hasSingleValue)
      paramList.add(this.value);
    if (this.values != null)
    {
      Object[] arrayOfObject = this.values;
      int i = arrayOfObject.length;
      for (int j = 0; j < i; j++)
        paramList.add(arrayOfObject[j]);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.WhereCondition.AbstractCondition
 * JD-Core Version:    0.6.2
 */