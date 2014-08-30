package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public class MAlarmHandler
{
  public static final long NEXT_FIRE_INTERVAL = 9223372036854775807L;
  private static int a;
  private static Map<Integer, MAlarmHandler> f = new HashMap();
  private static MAlarmHandler.IBumper h;
  private static boolean i = false;
  private final int b;
  private final boolean c;
  private long d = 0L;
  private long e = 0L;
  private final MAlarmHandler.CallBack g;

  public MAlarmHandler(MAlarmHandler.CallBack paramCallBack, boolean paramBoolean)
  {
    Assert.assertTrue("bumper not initialized", i);
    this.g = paramCallBack;
    this.c = paramBoolean;
    if (a >= 8192)
      a = 0;
    int j = 1 + a;
    a = j;
    this.b = j;
  }

  public static long fire()
  {
    LinkedList localLinkedList = new LinkedList();
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(f.keySet());
    Iterator localIterator = localHashSet.iterator();
    long l1 = 9223372036854775807L;
    MAlarmHandler localMAlarmHandler;
    long l3;
    if (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localMAlarmHandler = (MAlarmHandler)f.get(localInteger);
      if (localMAlarmHandler == null)
        break label266;
      l3 = Util.ticksToNow(localMAlarmHandler.d);
      if (l3 < 0L)
        l3 = 0L;
      if (l3 > localMAlarmHandler.e)
      {
        if ((!localMAlarmHandler.g.onTimerExpired()) || (!localMAlarmHandler.c))
          localLinkedList.add(localInteger);
        while (true)
        {
          localMAlarmHandler.d = Util.currentTicks();
          break;
          l1 = localMAlarmHandler.e;
        }
      }
      if (localMAlarmHandler.e - l3 >= l1)
        break label266;
    }
    label266: for (long l2 = localMAlarmHandler.e - l3; ; l2 = l1)
    {
      l1 = l2;
      break;
      for (int j = 0; j < localLinkedList.size(); j++)
        f.remove(localLinkedList.get(j));
      if ((l1 == 9223372036854775807L) && (h != null))
      {
        h.cancel();
        Log.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
      }
      return l1;
    }
  }

  public static void initAlarmBumper(MAlarmHandler.IBumper paramIBumper)
  {
    i = true;
    h = paramIBumper;
  }

  protected void finalize()
  {
    stopTimer();
    super.finalize();
  }

  public void startTimer(long paramLong)
  {
    this.e = paramLong;
    this.d = Util.currentTicks();
    long l1 = this.e;
    Log.d("MicroMsg.MAlarmHandler", "check need prepare: check=" + l1);
    Iterator localIterator = f.entrySet().iterator();
    long l2 = 9223372036854775807L;
    MAlarmHandler localMAlarmHandler;
    long l4;
    while (localIterator.hasNext())
    {
      localMAlarmHandler = (MAlarmHandler)((Map.Entry)localIterator.next()).getValue();
      if (localMAlarmHandler == null)
        break label229;
      l4 = Util.ticksToNow(localMAlarmHandler.d);
      if (l4 < 0L)
        l4 = 0L;
      if (l4 > localMAlarmHandler.e)
        l2 = localMAlarmHandler.e;
      else
        if (localMAlarmHandler.e - l4 >= l2)
          break label229;
    }
    label229: for (long l3 = localMAlarmHandler.e - l4; ; l3 = l2)
    {
      l2 = l3;
      break;
      if (l2 > l1);
      for (int j = 1; ; j = 0)
      {
        stopTimer();
        f.put(Integer.valueOf(this.b), this);
        if ((h != null) && (j != 0))
        {
          Log.v("MicroMsg.MAlarmHandler", "prepare bumper");
          h.prepare();
        }
        return;
      }
    }
  }

  public void stopTimer()
  {
    f.remove(Integer.valueOf(this.b));
  }

  public boolean stopped()
  {
    return !f.containsKey(Integer.valueOf(this.b));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MAlarmHandler
 * JD-Core Version:    0.6.2
 */