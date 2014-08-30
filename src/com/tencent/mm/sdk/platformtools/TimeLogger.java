package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import java.util.ArrayList;

public class TimeLogger
{
  private String a;
  private String b;
  private boolean c;
  private ArrayList<Long> d;
  private ArrayList<String> e;

  public TimeLogger(String paramString1, String paramString2)
  {
    reset(paramString1, paramString2);
  }

  public void addSplit(String paramString)
  {
    long l = SystemClock.elapsedRealtime();
    this.d.add(Long.valueOf(l));
    this.e.add(paramString);
  }

  public void dumpToLog()
  {
    Log.d(this.a, this.b + ": begin");
    long l1 = ((Long)this.d.get(0)).longValue();
    int i = 1;
    long l3;
    for (long l2 = l1; i < this.d.size(); l2 = l3)
    {
      l3 = ((Long)this.d.get(i)).longValue();
      String str = (String)this.e.get(i);
      long l4 = ((Long)this.d.get(i - 1)).longValue();
      Log.d(this.a, this.b + ":      " + (l3 - l4) + " ms, " + str);
      i++;
    }
    Log.d(this.a, this.b + ": end, " + (l2 - l1) + " ms");
  }

  public void reset()
  {
    this.c = false;
    if (this.d == null)
    {
      this.d = new ArrayList();
      this.e = new ArrayList();
    }
    while (true)
    {
      addSplit(null);
      return;
      this.d.clear();
      this.e.clear();
    }
  }

  public void reset(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    reset();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.TimeLogger
 * JD-Core Version:    0.6.2
 */