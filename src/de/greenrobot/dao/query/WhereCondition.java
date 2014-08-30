package de.greenrobot.dao.query;

import java.util.List;

public abstract interface WhereCondition
{
  public abstract void appendTo(StringBuilder paramStringBuilder, String paramString);

  public abstract void appendValuesTo(List<Object> paramList);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.WhereCondition
 * JD-Core Version:    0.6.2
 */