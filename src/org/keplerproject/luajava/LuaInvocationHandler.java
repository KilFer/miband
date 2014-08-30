package org.keplerproject.luajava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LuaInvocationHandler
  implements InvocationHandler
{
  private LuaObject obj;

  public LuaInvocationHandler(LuaObject paramLuaObject)
  {
    this.obj = paramLuaObject;
  }

  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Number localNumber;
    for (Object localObject1 = null; ; localObject1 = localNumber)
    {
      Class localClass;
      do
      {
        LuaObject localLuaObject;
        synchronized (this.obj.L)
        {
          String str = paramMethod.getName();
          localLuaObject = this.obj.getField(str);
          if (localLuaObject.isNil())
            return null;
          localClass = paramMethod.getReturnType();
          if ((localClass.equals(Void.class)) || (localClass.equals(Void.TYPE)))
          {
            localLuaObject.call(paramArrayOfObject, 0);
            return localObject1;
          }
        }
        localObject1 = localLuaObject.call(paramArrayOfObject, 1)[0];
      }
      while ((localObject1 == null) || (!(localObject1 instanceof Double)));
      localNumber = LuaState.convertLuaNumber((Double)localObject1, localClass);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.keplerproject.luajava.LuaInvocationHandler
 * JD-Core Version:    0.6.2
 */