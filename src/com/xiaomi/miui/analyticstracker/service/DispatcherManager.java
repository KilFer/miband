package com.xiaomi.miui.analyticstracker.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.miui.analyticstracker.Dispatchable;
import com.xiaomi.miui.analyticstracker.Event;
import com.xiaomi.miui.analyticstracker.EventReader;
import com.xiaomi.miui.analyticstracker.Item;
import com.xiaomi.miui.analyticstracker.ObjectBuilder;
import com.xiaomi.miui.analyticstracker.utils.EventUtils;
import com.xiaomi.miui.analyticstracker.utils.SysUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DispatcherManager
{
  private static final String f = "DispatcherManager";
  private Map<Dispatchable, String> a = new HashMap();
  private ObjectBuilder<Dispatchable> b = new ObjectBuilder();
  private EventReader c = new EventReader();
  private PolicyHelper d = new PolicyHelper();
  private Context e;

  public DispatcherManager(Context paramContext)
  {
    this.e = paramContext;
    this.b.registerClass(XiaomiDispatcher.class, "xiaomi");
  }

  private void a(String paramString, List<Item> paramList)
  {
    this.c.open(this.e, paramString);
    Iterator localIterator = this.c.readEvents(null, paramList).iterator();
    while (localIterator.hasNext())
    {
      Event localEvent = (Event)localIterator.next();
      Policy localPolicy = this.d.getPolicy(localEvent.getPolicy());
      if (localPolicy != null)
      {
        if ((!SysUtils.isWifiConnected(this.e)) || (!EventUtils.enableWrite(this.e)))
          break;
        localPolicy.execute(localEvent);
      }
    }
    this.c.close();
  }

  public static boolean databaseExist(Context paramContext, String paramString)
  {
    return paramContext.getDatabasePath(paramString).exists();
  }

  public void dispatch(List<Item> paramList)
  {
    Iterator localIterator1 = this.a.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Dispatchable localDispatchable = (Dispatchable)localIterator1.next();
      localDispatchable.start(this.e, (String)this.a.get(localDispatchable));
    }
    this.d.clear();
    int i = EventUtils.getDatabaseIndexFromTime(System.currentTimeMillis());
    int j = 0;
    int k;
    if (j < 7)
    {
      k = i - 1;
      if (k >= 0)
        break label306;
    }
    label306: for (i = k + 7; ; i = k)
    {
      if ((SysUtils.isWifiConnected(this.e)) && (EventUtils.enableWrite(this.e)))
      {
        String str = EventUtils.getDatabaseName(i);
        if (databaseExist(this.e, str))
        {
          this.c.open(this.e, str);
          Iterator localIterator3 = this.c.readEvents(null, paramList).iterator();
          while (localIterator3.hasNext())
          {
            Event localEvent = (Event)localIterator3.next();
            Policy localPolicy = this.d.getPolicy(localEvent.getPolicy());
            if (localPolicy != null)
            {
              if ((!SysUtils.isWifiConnected(this.e)) || (!EventUtils.enableWrite(this.e)))
                break;
              localPolicy.execute(localEvent);
            }
          }
          this.c.close();
        }
        j++;
        break;
      }
      this.d.end();
      Iterator localIterator2 = this.a.keySet().iterator();
      while (localIterator2.hasNext())
        ((Dispatchable)localIterator2.next()).stop();
      return;
    }
  }

  public void switchDispatcher(Map<String, String> paramMap)
  {
    this.a.clear();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Dispatchable localDispatchable = (Dispatchable)this.b.buildObject(str);
        if (localDispatchable == null)
          Log.d("DispatcherManager", String.format("server:%s does not exist", new Object[] { str }));
        else
          this.a.put(localDispatchable, paramMap.get(str));
      }
      if (paramMap.size() > 0)
        Event.setDispatcher(new ArrayList(this.a.keySet()));
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.service.DispatcherManager
 * JD-Core Version:    0.6.2
 */