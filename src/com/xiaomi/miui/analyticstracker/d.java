package com.xiaomi.miui.analyticstracker;

import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.miui.analyticstracker.service.DispatcherHelper;
import com.xiaomi.miui.analyticstracker.utils.EventUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class d
{
  private static final int a = 1;
  private static final int b = 2;
  private static final int c = 3;
  private boolean d = false;
  private f e = f.a;
  private Context f;
  private j g;
  private ObjectBuilder<j> h = new ObjectBuilder();
  private ObjectBuilder<Event> i = new ObjectBuilder();
  private Handler j;
  private Object k = new Object();
  private DispatcherHelper l = null;
  private long m;

  public d()
  {
    this.i.registerClass(TrackEvent.class, "2");
    this.i.registerClass(LogEvent.class, "1");
    this.i.registerClass(TrackPageViewEvent.class, "3");
    this.h.registerClass(i.class, "ANALYTICS.SQLITESTORE");
  }

  private void a(String paramString)
  {
    this.g = ((j)this.h.buildObject("ANALYTICS.SQLITESTORE"));
    this.g.a(this.f, paramString);
  }

  private void a(String paramString, long paramLong)
  {
    a(new TrackEvent(paramString, null, paramLong));
  }

  private void b()
  {
    this.l = new DispatcherHelper(this.f);
    this.m = 0L;
    boolean bool = EventUtils.enableWrite(this.f);
    this.d = bool;
    if (bool)
    {
      String str = EventUtils.getDatabaseName();
      long l1 = EventUtils.getDay(System.currentTimeMillis());
      File localFile = this.f.getDatabasePath(str);
      if ((localFile.exists()) && (l1 - EventUtils.getDay(localFile.lastModified()) >= 7L))
        EventUtils.deleteDatabaseFile(this.f, str);
      a(str);
    }
  }

  private void b(Event paramEvent)
  {
    if ((this.g != null) && (f.a == this.e) && (this.d))
      paramEvent.writeEvent(this.g);
    if ((this.l != null) && (System.currentTimeMillis() - this.m >= 3600000L))
    {
      this.m = System.currentTimeMillis();
      this.l.dispatch();
    }
  }

  private void b(String paramString)
  {
    long l1 = EventUtils.getDay(System.currentTimeMillis());
    File localFile = this.f.getDatabasePath(paramString);
    if ((localFile.exists()) && (l1 - EventUtils.getDay(localFile.lastModified()) >= 7L))
      EventUtils.deleteDatabaseFile(this.f, paramString);
  }

  private void c()
  {
    if (this.g != null)
    {
      this.g.a();
      this.g = null;
    }
    this.f = null;
  }

  private boolean c(String paramString)
  {
    j localj = (j)this.h.buildObject(paramString);
    if (localj != null)
    {
      if ((this.g != null) && (localj != this.g))
        this.g.a();
      this.g = localj;
      return true;
    }
    return false;
  }

  public final List<Event> a(String paramString, List<Item> paramList)
  {
    if (this.g != null)
    {
      Cursor localCursor = this.g.a(paramString);
      if (localCursor != null)
      {
        ArrayList localArrayList = new ArrayList();
        try
        {
          while (localCursor.moveToNext())
          {
            int n = localCursor.getInt(localCursor.getColumnIndexOrThrow("type"));
            Event localEvent = (Event)this.i.buildObject(n);
            if (localEvent != null)
            {
              localEvent.restore(localCursor);
              Iterator localIterator = paramList.iterator();
              Item localItem;
              do
              {
                if (!localIterator.hasNext())
                  break;
                localItem = (Item)localIterator.next();
              }
              while ((!localItem.idMatches(localEvent.getEventId())) || (!localItem.isDispatch(Build.VERSION.INCREMENTAL)));
              localEvent.setPolicy(localItem.getPolicy());
              localArrayList.add(localEvent);
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
          localCursor.close();
          this.g.b(paramString);
          return localArrayList;
        }
      }
    }
    return Collections.emptyList();
  }

  public final void a()
  {
    if (this.j != null)
    {
      Message localMessage = new Message();
      localMessage.what = 3;
      this.j.sendMessage(localMessage);
      return;
    }
    c();
  }

  public final void a(Context paramContext)
  {
    this.f = paramContext.getApplicationContext();
    this.e = f.a;
    synchronized (this.k)
    {
      new g(this, (byte)0).start();
    }
    try
    {
      this.k.wait();
      label41: Message localMessage = new Message();
      localMessage.what = 1;
      this.j.sendMessage(localMessage);
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label41;
    }
  }

  public final void a(Context paramContext, String paramString)
  {
    this.f = paramContext.getApplicationContext();
    this.e = f.b;
    a(paramString);
  }

  public final void a(Event paramEvent)
  {
    if (this.j != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = paramEvent.clone();
      this.j.sendMessage(localMessage);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.d
 * JD-Core Version:    0.6.2
 */