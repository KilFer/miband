package com.xiaomi.market.sdk;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.Context;
import android.database.Cursor;
import android.os.HandlerThread;
import java.io.File;

public class m
{
  public static m aK;
  private Context a;
  private w b;
  private q c;
  private long d = -1L;
  private File e;
  private DownloadManager f;
  private HandlerThread g;
  private n h;

  private m(Context paramContext)
  {
    this.a = paramContext;
    this.f = ((DownloadManager)this.a.getSystemService("download"));
    this.g = new HandlerThread("Worker Thread");
    this.g.start();
    this.h = new n(this, this.g.getLooper());
  }

  public static m i(Context paramContext)
  {
    if (aK == null)
      aK = new m(paramContext);
    return aK;
  }

  public void a(long paramLong)
  {
    if ((this.d > 0L) && (this.d != paramLong))
      return;
    this.h.m();
  }

  public void a(q paramq, w paramw)
  {
    if ((paramw == null) || (paramq == null))
      return;
    this.b = paramw;
    this.c = paramq;
    this.h.l();
  }

  public boolean a(q paramq)
  {
    r localr = r.j(this.a);
    String[] arrayOfString1 = l.aJ;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = paramq.packageName;
    Cursor localCursor1 = localr.query("update_download", arrayOfString1, "package_name=?", arrayOfString2, null, null, null);
    if (localCursor1 != null);
    while (true)
    {
      try
      {
        if (!localCursor1.moveToFirst())
          break label268;
        long l2 = localCursor1.getLong(localCursor1.getColumnIndex("download_id"));
        l1 = l2;
        if (l1 == -1L)
          return false;
      }
      finally
      {
        if (localCursor1 != null)
          localCursor1.close();
      }
      if (localCursor1 != null)
        localCursor1.close();
      DownloadManager.Query localQuery = new DownloadManager.Query();
      localQuery.setFilterById(new long[] { l1 });
      Cursor localCursor2 = this.f.query(localQuery);
      int i = -1;
      if (localCursor2 != null);
      try
      {
        if (localCursor2.moveToFirst())
        {
          int j = localCursor2.getInt(localCursor2.getColumnIndexOrThrow("status"));
          i = j;
        }
        if ((i != 4) && (i != 1) && (i != 2))
          return false;
      }
      finally
      {
        if (localCursor2 != null)
          localCursor2.close();
      }
      if (localCursor2 != null)
        localCursor2.close();
      return true;
      label268: long l1 = -1L;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.m
 * JD-Core Version:    0.6.2
 */