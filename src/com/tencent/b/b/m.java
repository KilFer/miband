package com.tencent.b.b;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private Context a = null;
  private TelephonyManager b = null;
  private m.c c = null;
  private m.a d = null;
  private m.b e = null;
  private boolean f = false;
  private List<NeighboringCellInfo> g = new LinkedList();
  private byte[] h = new byte[0];
  private byte[] i = new byte[0];
  private boolean j = false;

  private int a(int paramInt)
  {
    String str = this.b.getNetworkOperator();
    if ((str != null) && (str.length() >= 3));
    int k;
    while (true)
    {
      try
      {
        int m = Integer.valueOf(str.substring(0, 3)).intValue();
        k = m;
        if ((paramInt != 2) || (k != -1))
          break;
        return 0;
      }
      catch (Exception localException)
      {
      }
      k = -1;
    }
    return k;
  }

  public final void a()
  {
    synchronized (this.h)
    {
      if (!this.f)
        return;
      if (this.b != null)
      {
        m.c localc = this.c;
        if (localc == null);
      }
    }
    try
    {
      this.b.listen(this.c, 0);
      this.f = false;
      return;
      localObject = finally;
      throw localObject;
    }
    catch (Exception localException)
    {
      while (true)
        this.f = false;
    }
  }

  public final boolean a(Context paramContext, m.a parama)
  {
    synchronized (this.h)
    {
      if (this.f)
        return true;
      if ((paramContext == null) || (parama == null))
        return false;
      this.a = paramContext;
      this.d = parama;
      try
      {
        this.b = ((TelephonyManager)this.a.getSystemService("phone"));
        TelephonyManager localTelephonyManager = this.b;
        if (localTelephonyManager == null)
          return false;
        int k = this.b.getPhoneType();
        this.c = new m.c(this, a(k), k);
        m.c localc = this.c;
        if (localc == null)
          return false;
        this.b.listen(this.c, 18);
        this.f = true;
        return this.f;
      }
      catch (Exception localException)
      {
        return false;
      }
    }
  }

  public final List<NeighboringCellInfo> b()
  {
    synchronized (this.i)
    {
      List localList = this.g;
      LinkedList localLinkedList = null;
      if (localList != null)
      {
        localLinkedList = new LinkedList();
        localLinkedList.addAll(this.g);
      }
      return localLinkedList;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.m
 * JD-Core Version:    0.6.2
 */