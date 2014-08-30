package com.loopj.android.http;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class d
  implements Runnable
{
  d(AsyncHttpClient paramAsyncHttpClient, Context paramContext, boolean paramBoolean)
  {
  }

  public final void run()
  {
    List localList = (List)AsyncHttpClient.b(this.a).get(this.b);
    Iterator localIterator;
    if (localList != null)
      localIterator = localList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        AsyncHttpClient.b(this.a).remove(this.b);
        return;
      }
      ((RequestHandle)localIterator.next()).cancel(this.c);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.d
 * JD-Core Version:    0.6.2
 */