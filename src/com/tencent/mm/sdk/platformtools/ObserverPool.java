package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import junit.framework.Assert;

public final class ObserverPool
{
  private final HashMap<String, LinkedList<ObserverPool.Listener>> a = new HashMap();

  public final boolean add(String paramString, ObserverPool.Listener paramListener)
  {
    try
    {
      Assert.assertNotNull(paramListener);
      LinkedList localLinkedList = (LinkedList)this.a.get(paramString);
      if (localLinkedList == null)
      {
        localLinkedList = new LinkedList();
        this.a.put(paramString, localLinkedList);
      }
      if (localLinkedList.contains(paramListener))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = Util.getStack();
        Log.e("MicroMsg.ObserverPool", "Cannot add the same listener twice. EventId: %s, Stack: %s.", arrayOfObject);
      }
      boolean bool1;
      for (boolean bool2 = false; ; bool2 = bool1)
      {
        return bool2;
        bool1 = localLinkedList.add(paramListener);
      }
    }
    finally
    {
    }
  }

  public final void asyncPublish(ObserverPool.Event paramEvent)
  {
    asyncPublish(paramEvent, Looper.myLooper());
  }

  public final void asyncPublish(ObserverPool.Event paramEvent, Looper paramLooper)
  {
    Assert.assertNotNull(paramLooper);
    new Handler(paramLooper).post(new o(this, paramEvent));
  }

  public final boolean publish(ObserverPool.Event paramEvent)
  {
    Assert.assertNotNull(paramEvent);
    String str = paramEvent.getId();
    LinkedList localLinkedList = (LinkedList)this.a.get(str);
    if (localLinkedList == null)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str;
      arrayOfObject[1] = Util.getStack();
      Log.w("MicroMsg.ObserverPool", "No listener for this event %s, Stack: %s.", arrayOfObject);
      return false;
    }
    int i = 0x1 & paramEvent.getFlag();
    int j = 0;
    if (i != 0)
      j = 1;
    if (j != 0)
      Collections.sort(localLinkedList, new n(this));
    Iterator localIterator = localLinkedList.iterator();
    while ((localIterator.hasNext()) && ((!((ObserverPool.Listener)localIterator.next()).callback(paramEvent)) || (j == 0)));
    paramEvent.onComplete();
    return true;
  }

  public final void release()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final boolean remove(String paramString)
  {
    try
    {
      Assert.assertNotNull(paramString);
      Object localObject2 = this.a.remove(paramString);
      if (localObject2 != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public final boolean remove(String paramString, ObserverPool.Listener paramListener)
  {
    while (true)
    {
      try
      {
        Assert.assertNotNull(paramListener);
        LinkedList localLinkedList = (LinkedList)this.a.get(paramString);
        if (localLinkedList != null)
        {
          bool = localLinkedList.remove(paramListener);
          if (!bool)
          {
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = paramString;
            arrayOfObject[1] = Util.getStack();
            Log.e("MicroMsg.ObserverPool", "Listener isnot existed in the map. EventId: %s, Stack: %s.", arrayOfObject);
          }
          return bool;
        }
      }
      finally
      {
      }
      boolean bool = false;
    }
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ObserverPool profile:\n");
    localStringBuilder.append("\tEvent number: ").append(this.a.size()).append("\n");
    localStringBuilder.append("\tDetail:\n");
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append("\t").append(str).append(" : ").append(((LinkedList)this.a.get(str)).size()).append("\n");
    }
    localStringBuilder.append("End...");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ObserverPool
 * JD-Core Version:    0.6.2
 */