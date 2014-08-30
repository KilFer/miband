package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class LocalBroadcastManager
{
  private static final String a = "LocalBroadcastManager";
  private static final boolean b = false;
  private static int g = 1;
  private static final Object i = new Object();
  private static LocalBroadcastManager j;
  private final Context c;
  private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> d = new HashMap();
  private final HashMap<String, ArrayList<n>> e = new HashMap();
  private final ArrayList<c> f = new ArrayList();
  private final Handler h;

  private LocalBroadcastManager(Context paramContext)
  {
    this.c = paramContext;
    this.h = new l(this, paramContext.getMainLooper());
  }

  private void a()
  {
    while (true)
    {
      int m;
      synchronized (this.d)
      {
        int k = this.f.size();
        if (k <= 0)
          return;
        c[] arrayOfc = new c[k];
        this.f.toArray(arrayOfc);
        this.f.clear();
        m = 0;
        if (m >= arrayOfc.length)
          continue;
        c localc = arrayOfc[m];
        int n = 0;
        if (n < localc.b.size())
        {
          ((n)localc.b.get(n)).b.onReceive(this.c, localc.a);
          n++;
        }
      }
      m++;
    }
  }

  public static LocalBroadcastManager getInstance(Context paramContext)
  {
    synchronized (i)
    {
      if (j == null)
        j = new LocalBroadcastManager(paramContext.getApplicationContext());
      LocalBroadcastManager localLocalBroadcastManager = j;
      return localLocalBroadcastManager;
    }
  }

  public void registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    synchronized (this.d)
    {
      n localn = new n(paramIntentFilter, paramBroadcastReceiver);
      ArrayList localArrayList1 = (ArrayList)this.d.get(paramBroadcastReceiver);
      if (localArrayList1 == null)
      {
        localArrayList1 = new ArrayList(1);
        this.d.put(paramBroadcastReceiver, localArrayList1);
      }
      localArrayList1.add(paramIntentFilter);
      for (int k = 0; k < paramIntentFilter.countActions(); k++)
      {
        String str = paramIntentFilter.getAction(k);
        ArrayList localArrayList2 = (ArrayList)this.e.get(str);
        if (localArrayList2 == null)
        {
          localArrayList2 = new ArrayList(1);
          this.e.put(str, localArrayList2);
        }
        localArrayList2.add(localn);
      }
      return;
    }
  }

  public boolean sendBroadcast(Intent paramIntent)
  {
    int k;
    label156: int m;
    Object localObject2;
    Object localObject3;
    int i1;
    synchronized (this.d)
    {
      String str1 = paramIntent.getAction();
      String str2 = paramIntent.resolveTypeIfNeeded(this.c.getContentResolver());
      Uri localUri = paramIntent.getData();
      String str3 = paramIntent.getScheme();
      Set localSet = paramIntent.getCategories();
      if ((0x8 & paramIntent.getFlags()) == 0)
        break label500;
      k = 1;
      if (k != 0)
        Log.v("LocalBroadcastManager", "Resolving type " + str2 + " scheme " + str3 + " of intent " + paramIntent);
      ArrayList localArrayList = (ArrayList)this.e.get(paramIntent.getAction());
      if (localArrayList == null)
        break label470;
      if (k == 0)
        break label481;
      Log.v("LocalBroadcastManager", "Action list: " + localArrayList);
      break label481;
      if (m >= localArrayList.size())
        break label541;
      n localn = (n)localArrayList.get(m);
      if (k != 0)
        Log.v("LocalBroadcastManager", "Matching against filter " + localn.a);
      if (localn.c)
      {
        if (k == 0)
          break label506;
        Log.v("LocalBroadcastManager", "  Filter's target already added");
        localObject3 = localObject2;
      }
      else
      {
        i1 = localn.a.match(str1, str2, str3, localUri, localSet, "LocalBroadcastManager");
        if (i1 >= 0)
        {
          if (k != 0)
            Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(i1));
          if (localObject2 != null)
            break label474;
          localObject3 = new ArrayList();
          label309: ((ArrayList)localObject3).add(localn);
          localn.c = true;
        }
      }
    }
    String str4;
    if (k != 0)
      switch (i1)
      {
      default:
        str4 = "unknown reason";
        label372: Log.v("LocalBroadcastManager", "  Filter did not match: " + str4);
        break;
      case -3:
      case -4:
      case -2:
      case -1:
      }
    while (true)
    {
      int n;
      if (n < ((ArrayList)localObject2).size())
      {
        ((n)((ArrayList)localObject2).get(n)).c = false;
        n++;
      }
      else
      {
        this.f.add(new c(paramIntent, (ArrayList)localObject2));
        if (!this.h.hasMessages(1))
          this.h.sendEmptyMessage(1);
        return true;
        label470: label474: label481: label500: label506: 
        do
        {
          return false;
          localObject3 = localObject2;
          break label309;
          localObject2 = null;
          m = 0;
          break label156;
          while (true)
          {
            m++;
            localObject2 = localObject3;
            break label156;
            k = 0;
            break;
            localObject3 = localObject2;
          }
          str4 = "action";
          break label372;
          str4 = "category";
          break label372;
          str4 = "data";
          break label372;
          str4 = "type";
          break label372;
        }
        while (localObject2 == null);
        label541: n = 0;
      }
    }
  }

  public void sendBroadcastSync(Intent paramIntent)
  {
    if (sendBroadcast(paramIntent))
      a();
  }

  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    while (true)
    {
      int m;
      synchronized (this.d)
      {
        ArrayList localArrayList1 = (ArrayList)this.d.remove(paramBroadcastReceiver);
        if (localArrayList1 != null)
          break label174;
        return;
        if (k < localArrayList1.size())
        {
          IntentFilter localIntentFilter = (IntentFilter)localArrayList1.get(k);
          m = 0;
          if (m >= localIntentFilter.countActions())
            break label195;
          String str = localIntentFilter.getAction(m);
          ArrayList localArrayList2 = (ArrayList)this.e.get(str);
          if (localArrayList2 == null)
            break label189;
          n = 0;
          if (n < localArrayList2.size())
          {
            if (((n)localArrayList2.get(n)).b == paramBroadcastReceiver)
            {
              localArrayList2.remove(n);
              i1 = n - 1;
              break label180;
            }
          }
          else
          {
            if (localArrayList2.size() > 0)
              break label189;
            this.e.remove(str);
            break label189;
          }
        }
        else
        {
          return;
        }
      }
      int i1 = n;
      break label180;
      label174: int k = 0;
      continue;
      label180: int n = i1 + 1;
      continue;
      label189: m++;
      continue;
      label195: k++;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.LocalBroadcastManager
 * JD-Core Version:    0.6.2
 */