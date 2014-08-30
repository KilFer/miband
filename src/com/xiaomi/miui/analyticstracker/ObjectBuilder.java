package com.xiaomi.miui.analyticstracker;

import java.util.ArrayList;
import java.util.Iterator;

public class ObjectBuilder<T>
{
  private ArrayList<ObjectBuilder<T>.c> a = new ArrayList();

  public T buildObject(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.b.equals(paramString))
        try
        {
          Object localObject2 = localc.a.newInstance();
          localObject1 = localObject2;
        }
        catch (InstantiationException localInstantiationException)
        {
          localInstantiationException.printStackTrace();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
    }
    return localObject1;
  }

  public boolean registerClass(Class<? extends T> paramClass, String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      if (paramString.equals(((c)localIterator.next()).b))
        return false;
    return this.a.add(new c(this, paramClass, paramString));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.ObjectBuilder
 * JD-Core Version:    0.6.2
 */