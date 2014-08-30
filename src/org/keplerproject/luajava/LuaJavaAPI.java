package org.keplerproject.luajava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class LuaJavaAPI
{
  public static int checkField(int paramInt, Object paramObject, String paramString)
  {
    synchronized (LuaStateFactory.getExistingState(paramInt))
    {
      Class localClass;
      if ((paramObject instanceof Class))
        localClass = (Class)paramObject;
      Field localField;
      try
      {
        while (true)
        {
          localField = localClass.getField(paramString);
          if (localField != null)
            break;
          return 0;
          localClass = paramObject.getClass();
        }
      }
      catch (Exception localException1)
      {
        return 0;
      }
      Object localObject2;
      try
      {
        localObject2 = localField.get(paramObject);
        if (paramObject == null)
          return 0;
      }
      catch (Exception localException2)
      {
        return 0;
      }
      ???.pushObjectValue(localObject2);
      return 1;
    }
  }

  public static int checkMethod(int paramInt, Object paramObject, String paramString)
  {
    synchronized (LuaStateFactory.getExistingState(paramInt))
    {
      if ((paramObject instanceof Class));
      Method[] arrayOfMethod;
      int i;
      for (Class localClass = (Class)paramObject; ; localClass = paramObject.getClass())
      {
        arrayOfMethod = localClass.getMethods();
        i = 0;
        if (i < arrayOfMethod.length)
          break;
        return 0;
      }
      if (arrayOfMethod[i].getName().equals(paramString))
        return 1;
      i++;
    }
  }

  public static int classIndex(int paramInt, Class paramClass, String paramString)
  {
    synchronized (LuaStateFactory.getExistingState(paramInt))
    {
      if (checkField(paramInt, paramClass, paramString) != 0)
        return 1;
      if (checkMethod(paramInt, paramClass, paramString) != 0)
        return 2;
      return 0;
    }
  }

  private static Object compareTypes(LuaState paramLuaState, Class paramClass, int paramInt)
  {
    int i = 1;
    int j;
    Object localObject1;
    if (paramLuaState.isBoolean(paramInt))
      if (paramClass.isPrimitive())
      {
        Class localClass = Boolean.TYPE;
        j = 0;
        if (paramClass == localClass)
          break label82;
        Boolean localBoolean = new Boolean(paramLuaState.toBoolean(paramInt));
        i = j;
        localObject1 = localBoolean;
      }
    while (true)
    {
      label82: Number localNumber;
      if (i == 0)
      {
        throw new LuaException("Invalid Parameter.");
        boolean bool = paramClass.isAssignableFrom(Boolean.class);
        j = 0;
        if (!bool)
          break;
        j = i;
        break;
        if (paramLuaState.type(paramInt) == LuaState.LUA_TSTRING.intValue())
        {
          if (!paramClass.isAssignableFrom(String.class))
          {
            localObject1 = null;
            i = 0;
            continue;
          }
          localObject1 = paramLuaState.toString(paramInt);
          continue;
        }
        if (paramLuaState.isFunction(paramInt))
        {
          if (!paramClass.isAssignableFrom(LuaObject.class))
          {
            localObject1 = null;
            i = 0;
            continue;
          }
          localObject1 = paramLuaState.getLuaObject(paramInt);
          continue;
        }
        if (paramLuaState.isTable(paramInt))
        {
          if (!paramClass.isAssignableFrom(LuaObject.class))
          {
            localObject1 = null;
            i = 0;
            continue;
          }
          localObject1 = paramLuaState.getLuaObject(paramInt);
          continue;
        }
        if (paramLuaState.type(paramInt) == LuaState.LUA_TNUMBER.intValue())
        {
          localNumber = LuaState.convertLuaNumber(new Double(paramLuaState.toNumber(paramInt)), paramClass);
          if (localNumber != null)
            break label349;
          localObject1 = localNumber;
          i = 0;
          continue;
        }
        if (paramLuaState.isUserdata(paramInt))
        {
          if (paramLuaState.isObject(paramInt))
          {
            Object localObject2 = paramLuaState.getObjectFromUserdata(paramInt);
            if (!paramClass.isAssignableFrom(localObject2.getClass()))
            {
              localObject1 = null;
              i = 0;
              continue;
            }
            localObject1 = localObject2;
            continue;
          }
          if (!paramClass.isAssignableFrom(LuaObject.class))
          {
            localObject1 = null;
            i = 0;
            continue;
          }
          localObject1 = paramLuaState.getLuaObject(paramInt);
          continue;
        }
        if (paramLuaState.isNil(paramInt))
        {
          localObject1 = null;
          continue;
        }
        throw new LuaException("Invalid Parameters.");
      }
      return localObject1;
      label349: localObject1 = localNumber;
    }
  }

  public static int createProxyObject(int paramInt, String paramString)
  {
    synchronized (LuaStateFactory.getExistingState(paramInt))
    {
      try
      {
        if (!???.isTable(2))
          throw new LuaException("Parameter is not a table. Can't create proxy.");
      }
      catch (Exception localException)
      {
        throw new LuaException(localException);
      }
    }
    ???.pushJavaObject(???.getLuaObject(2).createProxy(paramString));
    return 1;
  }

  private static Object getObjInstance(LuaState paramLuaState, Class paramClass)
  {
    Object[] arrayOfObject;
    Constructor localConstructor;
    while (true)
    {
      int i;
      Constructor[] arrayOfConstructor;
      int j;
      try
      {
        i = paramLuaState.getTop();
        arrayOfObject = new Object[i - 1];
        arrayOfConstructor = paramClass.getConstructors();
        j = 0;
        int k = arrayOfConstructor.length;
        localConstructor = null;
        if (j >= k)
        {
          if (localConstructor != null)
            break;
          throw new LuaException("Invalid method call. No such method.");
        }
      }
      finally
      {
      }
      Class[] arrayOfClass = arrayOfConstructor[j].getParameterTypes();
      if (arrayOfClass.length == i - 1)
      {
        int m = 1;
        int n = 0;
        if (n >= arrayOfClass.length);
        while (true)
          while (true)
          {
            if (m == 0)
              break label139;
            localConstructor = arrayOfConstructor[j];
            break;
            try
            {
              arrayOfObject[n] = compareTypes(paramLuaState, arrayOfClass[n], n + 2);
              n++;
            }
            catch (Exception localException2)
            {
              m = 0;
            }
          }
      }
      label139: j++;
    }
    Object localObject2;
    try
    {
      localObject2 = localConstructor.newInstance(arrayOfObject);
      if (localObject2 == null)
        throw new LuaException("Couldn't instantiate java Object");
    }
    catch (Exception localException1)
    {
      throw new LuaException(localException1);
    }
    return localObject2;
  }

  // ERROR //
  public static int javaLoadLib(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iload_0
    //   1: invokestatic 18	org/keplerproject/luajava/LuaStateFactory:getExistingState	(I)Lorg/keplerproject/luajava/LuaState;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: invokestatic 204	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   11: astore 6
    //   13: aload 6
    //   15: aload_2
    //   16: iconst_1
    //   17: anewarray 20	java/lang/Class
    //   20: dup
    //   21: iconst_0
    //   22: ldc 36
    //   24: aastore
    //   25: invokevirtual 208	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   28: aconst_null
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_3
    //   36: aastore
    //   37: invokevirtual 212	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore 8
    //   42: aload 8
    //   44: ifnull +45 -> 89
    //   47: aload 8
    //   49: instanceof 106
    //   52: ifeq +37 -> 89
    //   55: aload 8
    //   57: checkcast 106	java/lang/Integer
    //   60: invokevirtual 110	java/lang/Integer:intValue	()I
    //   63: istore 9
    //   65: aload_3
    //   66: monitorexit
    //   67: iload 9
    //   69: ireturn
    //   70: astore 5
    //   72: new 87	org/keplerproject/luajava/LuaException
    //   75: dup
    //   76: aload 5
    //   78: invokespecial 164	org/keplerproject/luajava/LuaException:<init>	(Ljava/lang/Exception;)V
    //   81: athrow
    //   82: astore 4
    //   84: aload_3
    //   85: monitorexit
    //   86: aload 4
    //   88: athrow
    //   89: aload_3
    //   90: monitorexit
    //   91: iconst_0
    //   92: ireturn
    //   93: astore 7
    //   95: new 87	org/keplerproject/luajava/LuaException
    //   98: dup
    //   99: new 214	java/lang/StringBuilder
    //   102: dup
    //   103: ldc 216
    //   105: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload 7
    //   110: invokevirtual 220	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   113: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 92	org/keplerproject/luajava/LuaException:<init>	(Ljava/lang/String;)V
    //   122: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   7	13	70	java/lang/ClassNotFoundException
    //   7	13	82	finally
    //   13	42	82	finally
    //   47	65	82	finally
    //   65	67	82	finally
    //   72	82	82	finally
    //   84	86	82	finally
    //   95	123	82	finally
    //   13	42	93	java/lang/Exception
    //   47	65	93	java/lang/Exception
  }

  public static int javaNew(int paramInt, Class paramClass)
  {
    synchronized (LuaStateFactory.getExistingState(paramInt))
    {
      ???.pushJavaObject(getObjInstance(???, paramClass));
      return 1;
    }
  }

  public static int javaNewInstance(int paramInt, String paramString)
  {
    synchronized (LuaStateFactory.getExistingState(paramInt))
    {
      try
      {
        Class localClass = Class.forName(paramString);
        ???.pushJavaObject(getObjInstance(???, localClass));
        return 1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new LuaException(localClassNotFoundException);
      }
    }
  }

  public static int objectIndex(int paramInt, Object paramObject, String paramString)
  {
    Object[] arrayOfObject;
    Method localMethod;
    while (true)
    {
      int i;
      Method[] arrayOfMethod;
      int j;
      synchronized (LuaStateFactory.getExistingState(paramInt))
      {
        i = ???.getTop();
        arrayOfObject = new Object[i - 1];
        if ((paramObject instanceof Class))
        {
          localClass = (Class)paramObject;
          arrayOfMethod = localClass.getMethods();
          j = 0;
          if (j < arrayOfMethod.length)
            break label87;
          localMethod = null;
          if (localMethod != null)
            break;
          throw new LuaException("Invalid method call. No such method.");
        }
      }
      Class localClass = paramObject.getClass();
      continue;
      label87: if (arrayOfMethod[j].getName().equals(paramString))
      {
        Class[] arrayOfClass = arrayOfMethod[j].getParameterTypes();
        if (arrayOfClass.length == i - 1)
        {
          int k = 0;
          int m;
          if (k >= arrayOfClass.length)
            m = 1;
          while (true)
            while (true)
            {
              if (m == 0)
                break label183;
              localMethod = arrayOfMethod[j];
              break;
              try
              {
                arrayOfObject[k] = compareTypes(???, arrayOfClass[k], k + 2);
                k++;
              }
              catch (Exception localException2)
              {
                m = 0;
              }
            }
        }
      }
      label183: j++;
    }
    Object localObject3;
    try
    {
      if (Modifier.isPublic(localMethod.getModifiers()))
        localMethod.setAccessible(true);
      Object localObject4;
      if ((paramObject instanceof Class))
        localObject4 = localMethod.invoke(null, arrayOfObject);
      Object localObject2;
      for (localObject3 = localObject4; localObject3 == null; localObject3 = localObject2)
      {
        return 0;
        localObject2 = localMethod.invoke(paramObject, arrayOfObject);
      }
    }
    catch (Exception localException1)
    {
      throw new LuaException(localException1);
    }
    ???.pushObjectValue(localObject3);
    return 1;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.keplerproject.luajava.LuaJavaAPI
 * JD-Core Version:    0.6.2
 */