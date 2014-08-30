package com.tencent.open;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class a$a
{
  public void call(String paramString, List<String> paramList, a.b paramb)
  {
    Method[] arrayOfMethod = getClass().getDeclaredMethods();
    int i = arrayOfMethod.length;
    int j = 0;
    while (true)
    {
      Object localObject1 = null;
      if (j < i)
      {
        Method localMethod = arrayOfMethod[j];
        if ((localMethod.getName().equals(paramString)) && (localMethod.getParameterTypes().length == paramList.size()))
          localObject1 = localMethod;
      }
      else if (localObject1 == null);
      try
      {
        Object localObject2;
        switch (paramList.size())
        {
        default:
          Object[] arrayOfObject6 = new Object[6];
          arrayOfObject6[0] = paramList.get(0);
          arrayOfObject6[1] = paramList.get(1);
          arrayOfObject6[2] = paramList.get(2);
          arrayOfObject6[3] = paramList.get(3);
          arrayOfObject6[4] = paramList.get(4);
          arrayOfObject6[5] = paramList.get(5);
          localObject2 = localObject1.invoke(this, arrayOfObject6);
          label199: if (localObject1.getReturnType() == Void.class)
          {
            if (paramb != null)
              paramb.a(null);
            if (paramb != null)
              paramb.a();
          }
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
        while ((paramb == null) || (!customCallback()))
        {
          return;
          j++;
          break;
          localObject2 = localObject1.invoke(this, new Object[0]);
          break label199;
          Object[] arrayOfObject5 = new Object[1];
          arrayOfObject5[0] = paramList.get(0);
          localObject2 = localObject1.invoke(this, arrayOfObject5);
          break label199;
          Object[] arrayOfObject4 = new Object[2];
          arrayOfObject4[0] = paramList.get(0);
          arrayOfObject4[1] = paramList.get(1);
          localObject2 = localObject1.invoke(this, arrayOfObject4);
          break label199;
          Object[] arrayOfObject3 = new Object[3];
          arrayOfObject3[0] = paramList.get(0);
          arrayOfObject3[1] = paramList.get(1);
          arrayOfObject3[2] = paramList.get(2);
          localObject2 = localObject1.invoke(this, arrayOfObject3);
          break label199;
          Object[] arrayOfObject2 = new Object[4];
          arrayOfObject2[0] = paramList.get(0);
          arrayOfObject2[1] = paramList.get(1);
          arrayOfObject2[2] = paramList.get(2);
          arrayOfObject2[3] = paramList.get(3);
          localObject2 = localObject1.invoke(this, arrayOfObject2);
          break label199;
          Object[] arrayOfObject1 = new Object[5];
          arrayOfObject1[0] = paramList.get(0);
          arrayOfObject1[1] = paramList.get(1);
          arrayOfObject1[2] = paramList.get(2);
          arrayOfObject1[3] = paramList.get(3);
          arrayOfObject1[4] = paramList.get(4);
          localObject2 = localObject1.invoke(this, arrayOfObject1);
          break label199;
        }
        paramb.a(localObject2.toString());
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        while (true)
          if (paramb != null)
            paramb.a();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        while (true)
          if (paramb != null)
            paramb.a();
      }
      catch (Exception localException)
      {
        while (true)
          if (paramb != null)
            paramb.a();
      }
    }
  }

  public boolean customCallback()
  {
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.a.a
 * JD-Core Version:    0.6.2
 */