package de.greenrobot.dao.internal;

import de.greenrobot.dao.DaoException;

public class SqlUtils
{
  public static StringBuilder appendColumn(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('\'').append(paramString).append('\'');
    return paramStringBuilder;
  }

  public static StringBuilder appendColumn(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append(paramString1).append(".'").append(paramString2).append('\'');
    return paramStringBuilder;
  }

  public static StringBuilder appendColumns(StringBuilder paramStringBuilder, String paramString, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      appendColumn(paramStringBuilder, paramString, paramArrayOfString[j]);
      if (j < i - 1)
        paramStringBuilder.append(',');
    }
    return paramStringBuilder;
  }

  public static StringBuilder appendColumns(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      paramStringBuilder.append('\'').append(paramArrayOfString[j]).append('\'');
      if (j < i - 1)
        paramStringBuilder.append(',');
    }
    return paramStringBuilder;
  }

  public static StringBuilder appendColumnsEqValue(StringBuilder paramStringBuilder, String paramString, String[] paramArrayOfString)
  {
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      appendColumn(paramStringBuilder, paramString, paramArrayOfString[i]).append("=?");
      if (i < -1 + paramArrayOfString.length)
        paramStringBuilder.append(',');
    }
    return paramStringBuilder;
  }

  public static StringBuilder appendColumnsEqualPlaceholders(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      appendColumn(paramStringBuilder, paramArrayOfString[i]).append("=?");
      if (i < -1 + paramArrayOfString.length)
        paramStringBuilder.append(',');
    }
    return paramStringBuilder;
  }

  public static StringBuilder appendPlaceholders(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    if (i < paramInt)
    {
      if (i < paramInt - 1)
        paramStringBuilder.append("?,");
      while (true)
      {
        i++;
        break;
        paramStringBuilder.append('?');
      }
    }
    return paramStringBuilder;
  }

  public static String createSqlDelete(String paramString, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder("DELETE FROM ");
    localStringBuilder.append(paramString);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      localStringBuilder.append(" WHERE ");
      appendColumnsEqValue(localStringBuilder, paramString, paramArrayOfString);
    }
    return localStringBuilder.toString();
  }

  public static String createSqlInsert(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    localStringBuilder.append(paramString2).append(" (");
    appendColumns(localStringBuilder, paramArrayOfString);
    localStringBuilder.append(") VALUES (");
    appendPlaceholders(localStringBuilder, paramArrayOfString.length);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }

  public static String createSqlSelect(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder("SELECT ");
    if ((paramString2 == null) || (paramString2.length() < 0))
      throw new DaoException("Table alias required");
    appendColumns(localStringBuilder, paramString2, paramArrayOfString).append(" FROM ");
    localStringBuilder.append(paramString1).append(' ').append(paramString2).append(' ');
    return localStringBuilder.toString();
  }

  public static String createSqlSelectCountStar(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
    localStringBuilder.append(paramString1).append(' ');
    if (paramString2 != null)
      localStringBuilder.append(paramString2).append(' ');
    return localStringBuilder.toString();
  }

  public static String createSqlUpdate(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("UPDATE ");
    localStringBuilder.append(paramString).append(" SET ");
    appendColumnsEqualPlaceholders(localStringBuilder, paramArrayOfString1);
    localStringBuilder.append(" WHERE ");
    appendColumnsEqValue(localStringBuilder, paramString, paramArrayOfString2);
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.internal.SqlUtils
 * JD-Core Version:    0.6.2
 */