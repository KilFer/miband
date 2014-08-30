package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class CursorFieldHelper
{
  private static final Map<Class<?>, CursorFieldHelper.ISetMethod> a = new HashMap();
  private static final Map<Class<?>, CursorFieldHelper.IGetMethod> b = new HashMap();
  private static final Map<Class<?>, String> c = new HashMap();

  static
  {
    try
    {
      a.put([B.class, new a());
      a.put(Short.TYPE, new l());
      a.put(Short.class, new v());
      a.put(Boolean.TYPE, new w());
      a.put(Boolean.class, new x());
      a.put(Integer.TYPE, new y());
      a.put(Integer.class, new z());
      a.put(Float.TYPE, new A());
      a.put(Float.class, new B());
      a.put(Double.TYPE, new b());
      a.put(Double.class, new c());
      a.put(Long.TYPE, new d());
      a.put(Long.class, new e());
      a.put(String.class, new f());
      b.put([B.class, new g());
      b.put(Short.TYPE, new h());
      b.put(Short.class, new i());
      b.put(Boolean.TYPE, new j());
      b.put(Boolean.class, new k());
      b.put(Integer.TYPE, new m());
      b.put(Integer.class, new n());
      b.put(Float.TYPE, new o());
      b.put(Float.class, new p());
      b.put(Double.TYPE, new q());
      b.put(Double.class, new r());
      b.put(Long.TYPE, new s());
      b.put(Long.class, new t());
      b.put(String.class, new u());
      c.put([B.class, "BLOB");
      c.put(Short.TYPE, "SHORT");
      c.put(Short.class, "SHORT");
      c.put(Boolean.TYPE, "INTEGER");
      c.put(Boolean.class, "INTEGER");
      c.put(Integer.TYPE, "INTEGER");
      c.put(Integer.class, "INTEGER");
      c.put(Float.TYPE, "FLOAT");
      c.put(Float.class, "FLOAT");
      c.put(Double.TYPE, "DOUBLE");
      c.put(Double.class, "DOUBLE");
      c.put(Long.TYPE, "LONG");
      c.put(Long.class, "LONG");
      c.put(String.class, "TEXT");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static String a(Class<?> paramClass)
  {
    return (String)c.get(paramClass);
  }

  public static void a(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      paramContentValues.put(MAutoDBItem.getColName(paramField), (byte[])paramField.get(paramObject));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void a(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      paramField.set(paramObject, paramCursor.getBlob(paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static CursorFieldHelper.IGetMethod b(Class<?> paramClass)
  {
    return (CursorFieldHelper.IGetMethod)b.get(paramClass);
  }

  public static void b(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      paramContentValues.put(MAutoDBItem.getColName(paramField), Short.valueOf(paramField.getShort(paramObject)));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void b(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Short.TYPE))
      {
        paramField.setShort(paramObject, paramCursor.getShort(paramInt));
        return;
      }
      paramField.set(paramObject, Short.valueOf(paramCursor.getShort(paramInt)));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static CursorFieldHelper.ISetMethod c(Class<?> paramClass)
  {
    return (CursorFieldHelper.ISetMethod)a.get(paramClass);
  }

  public static void c(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      String str = MAutoDBItem.getColName(paramField);
      if (paramField.getBoolean(paramObject));
      for (int i = 1; ; i = 0)
      {
        paramContentValues.put(str, Integer.valueOf(i));
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void c(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    while (true)
    {
      try
      {
        if (paramField.getType().equals(Boolean.TYPE))
        {
          if (paramCursor.getInt(paramInt) != 0)
          {
            bool = true;
            paramField.setBoolean(paramObject, bool);
          }
        }
        else
        {
          paramField.set(paramObject, Integer.valueOf(paramCursor.getInt(paramInt)));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }

  public static void d(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      if (!paramField.getType().equals(Integer.TYPE))
      {
        paramContentValues.put(MAutoDBItem.getColName(paramField), (Integer)paramField.get(paramObject));
        return;
      }
      paramContentValues.put(MAutoDBItem.getColName(paramField), Integer.valueOf(paramField.getInt(paramObject)));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void d(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Integer.TYPE))
      {
        paramField.setInt(paramObject, paramCursor.getInt(paramInt));
        return;
      }
      paramField.set(paramObject, Integer.valueOf(paramCursor.getInt(paramInt)));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void e(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      if (!paramField.getType().equals(Float.TYPE))
      {
        paramContentValues.put(MAutoDBItem.getColName(paramField), (Float)paramField.get(paramObject));
        return;
      }
      paramContentValues.put(MAutoDBItem.getColName(paramField), Float.valueOf(paramField.getFloat(paramObject)));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void e(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Float.TYPE))
      {
        paramField.setFloat(paramObject, paramCursor.getFloat(paramInt));
        return;
      }
      paramField.set(paramObject, Float.valueOf(paramCursor.getFloat(paramInt)));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void f(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      if (!paramField.getType().equals(Double.TYPE))
      {
        paramContentValues.put(MAutoDBItem.getColName(paramField), (Double)paramField.get(paramObject));
        return;
      }
      paramContentValues.put(MAutoDBItem.getColName(paramField), Double.valueOf(paramField.getDouble(paramObject)));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void f(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Double.TYPE))
      {
        paramField.setDouble(paramObject, paramCursor.getDouble(paramInt));
        return;
      }
      paramField.set(paramObject, Double.valueOf(paramCursor.getDouble(paramInt)));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void g(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      if (!paramField.getType().equals(Long.TYPE))
      {
        paramContentValues.put(MAutoDBItem.getColName(paramField), (Long)paramField.get(paramObject));
        return;
      }
      paramContentValues.put(MAutoDBItem.getColName(paramField), Long.valueOf(paramField.getLong(paramObject)));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void g(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Long.TYPE))
      {
        paramField.setLong(paramObject, paramCursor.getLong(paramInt));
        return;
      }
      paramField.set(paramObject, Long.valueOf(paramCursor.getLong(paramInt)));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void h(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      paramContentValues.put(MAutoDBItem.getColName(paramField), (String)paramField.get(paramObject));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void h(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      paramField.set(paramObject, paramCursor.getString(paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.CursorFieldHelper
 * JD-Core Version:    0.6.2
 */