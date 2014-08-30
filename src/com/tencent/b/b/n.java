package com.tencent.b.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.tencent.b.a.a.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n
  implements b.a, e.b, f.a, m.a
{
  private static boolean t = false;
  private static n u = null;
  private d A = null;
  private int B = 0;
  private int C = 0;
  private int D = 1;
  private String E = "";
  private String F = "";
  private String G = "";
  private String H = "";
  private String I = "";
  private String J = "";
  private boolean K = false;
  private boolean L;
  private long M = 0L;
  private Handler N = null;
  private Runnable O = new B(this);
  private final BroadcastReceiver P = new C(this);
  private long a = 5000L;
  private Context b = null;
  private e c = null;
  private m d = null;
  private f e = null;
  private int f = 1024;
  private int g = 4;
  private c h = null;
  private b i = null;
  private com.tencent.b.a.a.b j = null;
  private int k;
  private int l;
  private int m;
  private byte[] n = new byte[0];
  private byte[] o = new byte[0];
  private boolean p = false;
  private y q = null;
  private z r = null;
  private A s = null;
  private long v = -1L;
  private e.a w = null;
  private m.b x = null;
  private f.b y = null;
  private d z = null;

  public static n a()
  {
    try
    {
      if (u == null)
        u = new n();
      n localn = u;
      return localn;
    }
    finally
    {
    }
  }

  private static ArrayList<com.tencent.b.a.a.c> a(JSONArray paramJSONArray)
  {
    int i1 = paramJSONArray.length();
    ArrayList localArrayList = new ArrayList();
    for (int i2 = 0; i2 < i1; i2++)
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i2);
      localArrayList.add(new com.tencent.b.a.a.c(localJSONObject.getString("name"), localJSONObject.getString("addr"), localJSONObject.getString("catalog"), localJSONObject.getDouble("dist"), Double.parseDouble(localJSONObject.getString("latitude")), Double.parseDouble(localJSONObject.getString("longitude"))));
    }
    return localArrayList;
  }

  private void a(String paramString)
  {
    try
    {
      this.z = new d();
      JSONObject localJSONObject1 = new JSONObject(paramString);
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("location");
      this.z.a = 1;
      this.z.b = s.a(localJSONObject2.getDouble("latitude"), 6);
      this.z.c = s.a(localJSONObject2.getDouble("longitude"), 6);
      this.z.d = s.a(localJSONObject2.getDouble("altitude"), 1);
      this.z.e = s.a(localJSONObject2.getDouble("accuracy"), 1);
      d locald1 = this.z;
      boolean bool;
      int i1;
      int i2;
      double d1;
      double d2;
      label236: int i5;
      JSONObject localJSONObject4;
      if (this.m == 1)
      {
        bool = true;
        locald1.x = bool;
        String str = localJSONObject1.getString("bearing");
        i1 = -100;
        i2 = 0;
        if (str != null)
        {
          int i3 = str.split(",").length;
          i2 = 0;
          if (i3 > 1)
            i2 = Integer.parseInt(str.split(",")[1]);
        }
        if (this.x != null)
          i1 = this.x.f;
        d locald2 = this.z;
        d1 = this.z.e;
        if (i2 < 6)
          break label674;
        d2 = 40.0D;
        locald2.e = d2;
        this.z.z = 0;
        if (((this.l == 3) || (this.l == 4)) && (this.m == 1))
        {
          JSONObject localJSONObject5 = localJSONObject1.getJSONObject("details").getJSONObject("subnation");
          this.z.a(localJSONObject5.getString("name"));
          this.z.m = localJSONObject5.getString("town");
          this.z.n = localJSONObject5.getString("village");
          this.z.o = localJSONObject5.getString("street");
          this.z.p = localJSONObject5.getString("street_no");
          this.z.z = 3;
          this.z.h = 0;
        }
        if ((this.l == 4) && (this.m == 1))
        {
          JSONArray localJSONArray = localJSONObject1.getJSONObject("details").getJSONArray("poilist");
          this.z.w = a(localJSONArray);
          this.z.z = 4;
        }
        if ((this.l == 7) && (this.m == 1))
        {
          JSONObject localJSONObject3 = localJSONObject1.getJSONObject("details");
          i5 = localJSONObject3.getInt("stat");
          localJSONObject4 = localJSONObject3.getJSONObject("subnation");
          if (i5 != 0)
            break label850;
          this.z.a(localJSONObject4.getString("name"));
          this.z.m = localJSONObject4.getString("town");
          this.z.n = localJSONObject4.getString("village");
          this.z.o = localJSONObject4.getString("street");
          this.z.p = localJSONObject4.getString("street_no");
        }
      }
      while (true)
      {
        this.z.h = i5;
        this.z.z = 7;
        this.z.y = 0;
        this.A = new d(this.z);
        this.B = 0;
        if (this.h != null)
          this.h.a(paramString);
        if ((this.j != null) && (this.k == 1) && ((this.w == null) || (!this.w.a())))
        {
          this.j.onLocationUpdate(this.z);
          this.v = System.currentTimeMillis();
        }
        return;
        bool = false;
        break;
        label674: if (i2 == 5)
        {
          d2 = 60.0D;
          break label236;
        }
        if (i2 == 4)
        {
          d2 = 70.0D;
          break label236;
        }
        if (i2 == 3)
        {
          d2 = 90.0D;
          break label236;
        }
        if (i2 == 2)
        {
          d2 = 110.0D;
          break label236;
        }
        int i4;
        if ((i1 >= -72) && (i2 == 0))
          i4 = 10 * (int)(0.45D * d1 / 10.0D);
        while (true)
        {
          d2 = i4;
          break;
          if (d1 <= 100.0D)
            i4 = 10 * (int)(1.0D + (d1 - 1.0D) / 10.0D);
          else if ((d1 > 100.0D) && (d1 <= 800.0D))
            i4 = 10 * (int)(0.85D * d1 / 10.0D);
          else
            i4 = 10 * (int)(0.8D * d1 / 10.0D);
        }
        label850: if (i5 == 1)
        {
          this.z.i = localJSONObject4.getString("nation");
          this.z.q = localJSONObject4.getString("admin_level_1");
          this.z.r = localJSONObject4.getString("admin_level_2");
          this.z.s = localJSONObject4.getString("admin_level_3");
          this.z.t = localJSONObject4.getString("locality");
          this.z.u = localJSONObject4.getString("sublocality");
          this.z.v = localJSONObject4.getString("route");
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.z = new d();
        this.z.z = -1;
        this.z.y = 2;
        this.B = 2;
      }
    }
  }

  private void a(boolean paramBoolean)
  {
    if ((this.w != null) && (this.w.a()))
    {
      Location localLocation = this.w.b();
      this.z = new d();
      this.z.b = s.a(localLocation.getLatitude(), 6);
      this.z.c = s.a(localLocation.getLongitude(), 6);
      this.z.d = s.a(localLocation.getAltitude(), 1);
      this.z.e = s.a(localLocation.getAccuracy(), 1);
      this.z.f = s.a(localLocation.getSpeed(), 1);
      this.z.g = s.a(localLocation.getBearing(), 1);
      this.z.a = 0;
      this.z.x = false;
      if (paramBoolean)
        break label237;
    }
    label237: for (this.z.y = 0; ; this.z.y = 1)
    {
      this.z.z = 0;
      this.A = new d(this.z);
      this.B = 0;
      if ((System.currentTimeMillis() - this.v >= this.a) && (this.j != null) && (this.k == 1))
      {
        this.j.onLocationUpdate(this.z);
        this.v = System.currentTimeMillis();
      }
      return;
    }
  }

  private void e()
  {
    if (this.s != null)
      return;
    this.s = new A(this, this.w, this.x, this.y);
    this.s.start();
  }

  private void f()
  {
    this.z = new d();
    this.B = 1;
    this.z.y = 1;
    this.z.z = -1;
    this.z.a = 1;
    if ((this.j != null) && (this.k == 1))
      this.j.onLocationUpdate(this.z);
  }

  public final void a(double paramDouble1, double paramDouble2)
  {
    synchronized (this.o)
    {
      Message localMessage = this.q.obtainMessage(6);
      Location localLocation = new Location("Deflect");
      localLocation.setLatitude(paramDouble1);
      localLocation.setLongitude(paramDouble2);
      localMessage.obj = localLocation;
      this.q.sendMessage(localMessage);
      return;
    }
  }

  public final void a(int paramInt)
  {
    synchronized (this.o)
    {
      Message localMessage = this.q.obtainMessage(4, paramInt, 0);
      this.q.sendMessage(localMessage);
      return;
    }
  }

  public final void a(e.a parama)
  {
    synchronized (this.o)
    {
      Message localMessage = this.q.obtainMessage(1, parama);
      this.q.sendMessage(localMessage);
      return;
    }
  }

  public final void a(f.b paramb)
  {
    synchronized (this.o)
    {
      Message localMessage = this.q.obtainMessage(3, paramb);
      this.q.sendMessage(localMessage);
      return;
    }
  }

  public final void a(m.b paramb)
  {
    synchronized (this.o)
    {
      Message localMessage = this.q.obtainMessage(2, paramb);
      this.q.sendMessage(localMessage);
      return;
    }
  }

  // ERROR //
  public final boolean a(Context paramContext, com.tencent.b.a.a.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 108	com/tencent/b/b/n:n	[B
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull +7 -> 15
    //   11: aload_2
    //   12: ifnonnull +7 -> 19
    //   15: aload_3
    //   16: monitorexit
    //   17: iconst_0
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 152	com/tencent/b/b/n:J	Ljava/lang/String;
    //   23: invokestatic 591	com/tencent/b/b/s:a	(Ljava/lang/String;)Z
    //   26: ifne +7 -> 33
    //   29: aload_3
    //   30: monitorexit
    //   31: iconst_0
    //   32: ireturn
    //   33: aload_0
    //   34: new 555	com/tencent/b/b/y
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 592	com/tencent/b/b/y:<init>	(Lcom/tencent/b/b/n;)V
    //   42: putfield 114	com/tencent/b/b/n:q	Lcom/tencent/b/b/y;
    //   45: aload_0
    //   46: new 594	android/os/Handler
    //   49: dup
    //   50: invokestatic 600	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   53: invokespecial 603	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   56: putfield 158	com/tencent/b/b/n:N	Landroid/os/Handler;
    //   59: aload_0
    //   60: aload_1
    //   61: putfield 90	com/tencent/b/b/n:b	Landroid/content/Context;
    //   64: aload_0
    //   65: aload_2
    //   66: putfield 106	com/tencent/b/b/n:j	Lcom/tencent/b/a/a/b;
    //   69: invokestatic 608	com/tencent/b/b/t:a	()Lcom/tencent/b/b/t;
    //   72: aload_0
    //   73: getfield 90	com/tencent/b/b/n:b	Landroid/content/Context;
    //   76: invokevirtual 614	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   79: invokevirtual 617	com/tencent/b/b/t:a	(Landroid/content/Context;)V
    //   82: aload_1
    //   83: ldc_w 619
    //   86: invokevirtual 623	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   89: checkcast 625	android/net/ConnectivityManager
    //   92: astore 9
    //   94: aload 9
    //   96: ifnull +23 -> 119
    //   99: aload 9
    //   101: invokevirtual 629	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   104: ifnull +15 -> 119
    //   107: aload_0
    //   108: aload 9
    //   110: invokevirtual 629	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   113: invokevirtual 634	android/net/NetworkInfo:isRoaming	()Z
    //   116: putfield 154	com/tencent/b/b/n:K	Z
    //   119: aload_0
    //   120: getfield 90	com/tencent/b/b/n:b	Landroid/content/Context;
    //   123: aload_0
    //   124: getfield 170	com/tencent/b/b/n:P	Landroid/content/BroadcastReceiver;
    //   127: new 636	android/content/IntentFilter
    //   130: dup
    //   131: ldc_w 638
    //   134: invokespecial 639	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   137: invokevirtual 643	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   140: pop
    //   141: aload_0
    //   142: aload_0
    //   143: getfield 106	com/tencent/b/b/n:j	Lcom/tencent/b/a/a/b;
    //   146: invokevirtual 646	com/tencent/b/a/a/b:getReqType	()I
    //   149: putfield 353	com/tencent/b/b/n:k	I
    //   152: aload_0
    //   153: aload_0
    //   154: getfield 106	com/tencent/b/b/n:j	Lcom/tencent/b/a/a/b;
    //   157: invokevirtual 649	com/tencent/b/a/a/b:getReqLevel	()I
    //   160: putfield 306	com/tencent/b/b/n:l	I
    //   163: aload_0
    //   164: aload_0
    //   165: getfield 106	com/tencent/b/b/n:j	Lcom/tencent/b/a/a/b;
    //   168: invokevirtual 652	com/tencent/b/a/a/b:getReqGeoType	()I
    //   171: putfield 372	com/tencent/b/b/n:m	I
    //   174: aload_0
    //   175: ldc2_w 119
    //   178: putfield 122	com/tencent/b/b/n:v	J
    //   181: aload_0
    //   182: getfield 306	com/tencent/b/b/n:l	I
    //   185: bipush 7
    //   187: if_icmpne +8 -> 195
    //   190: aload_0
    //   191: iconst_0
    //   192: putfield 306	com/tencent/b/b/n:l	I
    //   195: aload_0
    //   196: iconst_1
    //   197: putfield 138	com/tencent/b/b/n:D	I
    //   200: aload_0
    //   201: getfield 92	com/tencent/b/b/n:c	Lcom/tencent/b/b/e;
    //   204: aload_0
    //   205: aload_0
    //   206: getfield 90	com/tencent/b/b/n:b	Landroid/content/Context;
    //   209: invokevirtual 655	com/tencent/b/b/e:a	(Lcom/tencent/b/b/e$b;Landroid/content/Context;)Z
    //   212: istore 6
    //   214: aload_0
    //   215: getfield 94	com/tencent/b/b/n:d	Lcom/tencent/b/b/m;
    //   218: aload_0
    //   219: getfield 90	com/tencent/b/b/n:b	Landroid/content/Context;
    //   222: aload_0
    //   223: invokevirtual 658	com/tencent/b/b/m:a	(Landroid/content/Context;Lcom/tencent/b/b/m$a;)Z
    //   226: istore 7
    //   228: aload_0
    //   229: getfield 96	com/tencent/b/b/n:e	Lcom/tencent/b/b/f;
    //   232: aload_0
    //   233: getfield 90	com/tencent/b/b/n:b	Landroid/content/Context;
    //   236: aload_0
    //   237: iconst_1
    //   238: invokevirtual 661	com/tencent/b/b/f:a	(Landroid/content/Context;Lcom/tencent/b/b/f$a;I)Z
    //   241: istore 8
    //   243: aload_0
    //   244: invokestatic 664	com/tencent/b/b/c:a	()Lcom/tencent/b/b/c;
    //   247: putfield 102	com/tencent/b/b/n:h	Lcom/tencent/b/b/c;
    //   250: aload_0
    //   251: invokestatic 667	com/tencent/b/b/b:a	()Lcom/tencent/b/b/b;
    //   254: putfield 104	com/tencent/b/b/n:i	Lcom/tencent/b/b/b;
    //   257: aload_0
    //   258: aconst_null
    //   259: putfield 124	com/tencent/b/b/n:w	Lcom/tencent/b/b/e$a;
    //   262: aload_0
    //   263: aconst_null
    //   264: putfield 126	com/tencent/b/b/n:x	Lcom/tencent/b/b/m$b;
    //   267: aload_0
    //   268: aconst_null
    //   269: putfield 128	com/tencent/b/b/n:y	Lcom/tencent/b/b/f$b;
    //   272: aload_0
    //   273: aconst_null
    //   274: putfield 130	com/tencent/b/b/n:z	Lcom/tencent/b/a/a/d;
    //   277: aload_0
    //   278: aconst_null
    //   279: putfield 132	com/tencent/b/b/n:A	Lcom/tencent/b/a/a/d;
    //   282: aload_0
    //   283: iconst_0
    //   284: putfield 134	com/tencent/b/b/n:B	I
    //   287: aload_0
    //   288: getfield 102	com/tencent/b/b/n:h	Lcom/tencent/b/b/c;
    //   291: ifnull +10 -> 301
    //   294: aload_0
    //   295: getfield 102	com/tencent/b/b/n:h	Lcom/tencent/b/b/c;
    //   298: invokevirtual 669	com/tencent/b/b/c:b	()V
    //   301: aload_0
    //   302: iconst_1
    //   303: putfield 136	com/tencent/b/b/n:C	I
    //   306: iload 6
    //   308: ifeq +14 -> 322
    //   311: aload_0
    //   312: getfield 372	com/tencent/b/b/n:m	I
    //   315: ifne +7 -> 322
    //   318: aload_3
    //   319: monitorexit
    //   320: iconst_1
    //   321: ireturn
    //   322: iload 7
    //   324: ifne +8 -> 332
    //   327: iload 8
    //   329: ifeq +7 -> 336
    //   332: aload_3
    //   333: monitorexit
    //   334: iconst_1
    //   335: ireturn
    //   336: aload_3
    //   337: monitorexit
    //   338: iconst_0
    //   339: ireturn
    //   340: astore 4
    //   342: aload_3
    //   343: monitorexit
    //   344: aload 4
    //   346: athrow
    //   347: astore 5
    //   349: goto -208 -> 141
    //
    // Exception table:
    //   from	to	target	type
    //   19	31	340	finally
    //   33	82	340	finally
    //   82	94	340	finally
    //   99	119	340	finally
    //   119	141	340	finally
    //   141	195	340	finally
    //   195	301	340	finally
    //   301	306	340	finally
    //   311	320	340	finally
    //   82	94	347	java/lang/Exception
    //   99	119	347	java/lang/Exception
    //   119	141	347	java/lang/Exception
  }

  public final boolean a(String paramString1, String paramString2)
  {
    synchronized (this.n)
    {
      if (a.a().a(paramString1, paramString2))
      {
        this.J = paramString1;
        return true;
      }
      return false;
    }
  }

  public final void b()
  {
    try
    {
      synchronized (this.n)
      {
        if (this.j != null)
        {
          this.j = null;
          this.N.removeCallbacks(this.O);
          this.b.unregisterReceiver(this.P);
          this.c.a();
          this.d.a();
          this.e.a();
        }
        label62: return;
      }
    }
    catch (Exception localException)
    {
      break label62;
    }
  }

  public final void b(int paramInt)
  {
    synchronized (this.o)
    {
      Message localMessage = this.q.obtainMessage(5, paramInt, 0);
      this.q.sendMessage(localMessage);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.n
 * JD-Core Version:    0.6.2
 */