package de.greenrobot.dao.query;

public class WhereCondition$StringCondition extends WhereCondition.AbstractCondition
{
  protected final String string;

  public WhereCondition$StringCondition(String paramString)
  {
    this.string = paramString;
  }

  public WhereCondition$StringCondition(String paramString, Object paramObject)
  {
    super(paramObject);
    this.string = paramString;
  }

  public WhereCondition$StringCondition(String paramString, Object[] paramArrayOfObject)
  {
    super(paramArrayOfObject);
    this.string = paramString;
  }

  public void appendTo(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(this.string);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.WhereCondition.StringCondition
 * JD-Core Version:    0.6.2
 */