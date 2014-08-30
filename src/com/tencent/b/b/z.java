package com.tencent.b.b;

import android.os.Message;

final class z extends Thread
{
  private String a = null;
  private String b = null;
  private String c = null;

  public z(n paramn, String paramString)
  {
    this.a = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    if (n.i(paramn) == 0);
    for (String str = "http://lstest.map.soso.com/loc?c=1"; ; str = "http://lbs.map.qq.com/loc?c=1")
    {
      this.b = (str + "&mars=" + n.j(paramn));
      return;
    }
  }

  private String a(byte[] paramArrayOfByte, String paramString)
  {
    n.a(this.d, System.currentTimeMillis());
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      localStringBuffer.append(new String(paramArrayOfByte, paramString));
      return localStringBuffer.toString();
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public final void run()
  {
    Message localMessage = new Message();
    localMessage.what = 8;
    int i;
    try
    {
      byte[] arrayOfByte2 = r.a(this.a.getBytes());
      n.a(this.d, true);
      u localu2 = b.a(this.b, "SOSO MAP LBS SDK", arrayOfByte2);
      n.a(this.d, false);
      this.c = a(r.b(localu2.a), localu2.b);
      if (this.c != null)
      {
        localMessage.arg1 = 0;
        localMessage.obj = this.c;
      }
      while (true)
      {
        n.k(this.d);
        n.d(this.d).sendMessage(localMessage);
        return;
        localMessage.arg1 = 1;
      }
    }
    catch (Exception localException1)
    {
      i = 0;
    }
    while (true)
      while (true)
      {
        i++;
        if (i <= 3);
        try
        {
          sleep(1000L);
          byte[] arrayOfByte1 = r.a(this.a.getBytes());
          n.a(this.d, true);
          u localu1 = b.a(this.b, "SOSO MAP LBS SDK", arrayOfByte1);
          n.a(this.d, false);
          this.c = a(r.b(localu1.a), localu1.b);
          if (this.c != null)
          {
            localMessage.arg1 = 0;
            localMessage.obj = this.c;
          }
          else
          {
            localMessage.arg1 = 1;
            continue;
            n.a(this.d, false);
            localMessage.arg1 = 1;
          }
        }
        catch (Exception localException2)
        {
        }
      }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.z
 * JD-Core Version:    0.6.2
 */