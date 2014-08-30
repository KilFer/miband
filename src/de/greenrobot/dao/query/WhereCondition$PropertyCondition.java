package de.greenrobot.dao.query;

import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.Property;
import java.util.Date;

public class WhereCondition$PropertyCondition extends WhereCondition.AbstractCondition
{
  public final String op;
  public final Property property;

  public WhereCondition$PropertyCondition(Property paramProperty, String paramString)
  {
    this.property = paramProperty;
    this.op = paramString;
  }

  public WhereCondition$PropertyCondition(Property paramProperty, String paramString, Object paramObject)
  {
    super(checkValueForType(paramProperty, paramObject));
    this.property = paramProperty;
    this.op = paramString;
  }

  public WhereCondition$PropertyCondition(Property paramProperty, String paramString, Object[] paramArrayOfObject)
  {
    super(checkValuesForType(paramProperty, paramArrayOfObject));
    this.property = paramProperty;
    this.op = paramString;
  }

  private static Object checkValueForType(Property paramProperty, Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass().isArray()))
      throw new DaoException("Illegal value: found array, but simple object required");
    if (paramProperty.type == Date.class)
      if ((paramObject instanceof Date))
        paramObject = Long.valueOf(((Date)paramObject).getTime());
    do
    {
      int i;
      do
      {
        do
        {
          do
            return paramObject;
          while ((paramObject instanceof Long));
          throw new DaoException("Illegal date value: expected java.util.Date or Long for value " + paramObject);
        }
        while ((paramProperty.type != Boolean.TYPE) && (paramProperty.type != Boolean.class));
        if ((paramObject instanceof Boolean))
        {
          if (((Boolean)paramObject).booleanValue());
          for (int j = 1; ; j = 0)
            return Integer.valueOf(j);
        }
        if (!(paramObject instanceof Number))
          break;
        i = ((Number)paramObject).intValue();
      }
      while ((i == 0) || (i == 1));
      throw new DaoException("Illegal boolean value: numbers must be 0 or 1, but was " + paramObject);
    }
    while (!(paramObject instanceof String));
    String str = (String)paramObject;
    if ("TRUE".equalsIgnoreCase(str))
      return Integer.valueOf(1);
    if ("FALSE".equalsIgnoreCase(str))
      return Integer.valueOf(0);
    throw new DaoException("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insesnsitive), but was " + paramObject);
  }

  private static Object[] checkValuesForType(Property paramProperty, Object[] paramArrayOfObject)
  {
    for (int i = 0; i < paramArrayOfObject.length; i++)
      paramArrayOfObject[i] = checkValueForType(paramProperty, paramArrayOfObject[i]);
    return paramArrayOfObject;
  }

  public void appendTo(StringBuilder paramStringBuilder, String paramString)
  {
    if (paramString != null)
      paramStringBuilder.append(paramString).append('.');
    paramStringBuilder.append('\'').append(this.property.columnName).append('\'').append(this.op);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.WhereCondition.PropertyCondition
 * JD-Core Version:    0.6.2
 */