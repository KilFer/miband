package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import java.io.File;
import java.util.Scanner;

public final class TrafficStats
{
  public static final String DEV_FILE = "/proc/self/net/dev";
  public static final String GPRSLINE = "rmnet0";
  public static final String WIFILINE = "tiwlan0";
  private static long a;
  private static long b;
  private static long c;
  private static long d;
  private static long e;
  private static long f;
  private static long g;
  private static long h;

  public static long getMobileRx(long paramLong)
  {
    if (f > paramLong)
      paramLong = f;
    return paramLong;
  }

  public static long getMobileTx(long paramLong)
  {
    if (e > paramLong)
      paramLong = e;
    return paramLong;
  }

  public static long getWifiRx(long paramLong)
  {
    if (h > paramLong)
      paramLong = h;
    return paramLong;
  }

  public static long getWifiTx(long paramLong)
  {
    if (g > paramLong)
      paramLong = g;
    return paramLong;
  }

  public static void reset()
  {
    a = -1L;
    b = -1L;
    c = -1L;
    d = -1L;
    update();
  }

  public static void update()
  {
    long l1 = 0L;
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    try
    {
      Scanner localScanner = new Scanner(new File("/proc/" + Process.myPid() + "/net/dev"));
      localScanner.nextLine();
      localScanner.nextLine();
      while (localScanner.hasNext())
      {
        String[] arrayOfString = localScanner.nextLine().split("[ :\t]+");
        if (arrayOfString[0].length() != 0)
          break label627;
        i = 1;
        if ((!arrayOfString[0].equals("lo")) && (arrayOfString[i].startsWith("rmnet")))
        {
          l1 += Long.parseLong(arrayOfString[(i + 9)]);
          l2 += Long.parseLong(arrayOfString[(i + 1)]);
        }
        if ((!arrayOfString[i].equals("lo")) && (!arrayOfString[i].startsWith("rmnet")))
        {
          l3 += Long.parseLong(arrayOfString[(i + 9)]);
          l4 += Long.parseLong(arrayOfString[(i + 1)]);
        }
      }
      localScanner.close();
      if (a < 0L)
      {
        a = l1;
        Object[] arrayOfObject7 = new Object[1];
        arrayOfObject7[0] = Long.valueOf(l1);
        Log.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileTx %d", arrayOfObject7);
      }
      if (b < 0L)
      {
        b = l2;
        Object[] arrayOfObject6 = new Object[1];
        arrayOfObject6[0] = Long.valueOf(l2);
        Log.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileRx %d", arrayOfObject6);
      }
      if (c < 0L)
      {
        c = l3;
        Object[] arrayOfObject5 = new Object[1];
        arrayOfObject5[0] = Long.valueOf(l3);
        Log.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiTx %d", arrayOfObject5);
      }
      if (d < 0L)
      {
        d = l4;
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = Long.valueOf(l4);
        Log.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiRx %d", arrayOfObject4);
      }
      if (l4 - d < 0L)
      {
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = Long.valueOf(l4 - d);
        Log.v("MicroMsg.SDK.TrafficStats", "minu %d", arrayOfObject3);
      }
      if (l3 - c < 0L)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Long.valueOf(l3 - c);
        Log.v("MicroMsg.SDK.TrafficStats", "minu %d", arrayOfObject2);
      }
      long l5;
      long l6;
      label468: long l7;
      if (l1 >= a)
      {
        l5 = l1 - a;
        e = l5;
        if (l2 < b)
          break label597;
        l6 = l2 - b;
        f = l6;
        if (l3 < c)
          break label603;
        l7 = l3 - c;
        label490: g = l7;
        if (l4 < d)
          break label610;
      }
      label597: label603: label610: for (long l8 = l4 - d; ; l8 = l4)
      {
        h = l8;
        a = l1;
        b = l2;
        c = l3;
        d = l4;
        Object[] arrayOfObject1 = new Object[4];
        arrayOfObject1[0] = Long.valueOf(h);
        arrayOfObject1[1] = Long.valueOf(g);
        arrayOfObject1[2] = Long.valueOf(f);
        arrayOfObject1[3] = Long.valueOf(e);
        Log.d("MicroMsg.SDK.TrafficStats", "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d", arrayOfObject1);
        return;
        l5 = l1;
        break;
        l6 = l2;
        break label468;
        l7 = l3;
        break label490;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        continue;
        label627: int i = 0;
      }
    }
  }

  public static long updateMobileRx(long paramLong)
  {
    update();
    return getMobileRx(paramLong);
  }

  public static long updateMobileTx(long paramLong)
  {
    update();
    return getMobileTx(paramLong);
  }

  public static long updateWifiRx(long paramLong)
  {
    update();
    return getWifiRx(paramLong);
  }

  public static long updateWifiTx(long paramLong)
  {
    update();
    return getWifiTx(paramLong);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.TrafficStats
 * JD-Core Version:    0.6.2
 */