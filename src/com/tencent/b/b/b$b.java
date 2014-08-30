package com.tencent.b.b;

public final class b$b extends Thread
{
  public b$b(b paramb)
  {
  }

  public final void run()
  {
    try
    {
      byte[] arrayOfByte2 = r.a(this.a.a.getBytes());
      b.a(this.a, true);
      u localu2 = b.a("http://ls.map.soso.com/deflect?c=1", "SOSO MAP LBS SDK", arrayOfByte2);
      b.a(this.a, false);
      byte[] arrayOfByte3 = r.b(localu2.a);
      b.a(this.a, arrayOfByte3, localu2.b);
      return;
    }
    catch (Exception localException1)
    {
      do
      {
        int i = 0;
        while (true)
        {
          i++;
          if (i > 3)
            break;
          try
          {
            sleep(2000L);
            u localu1 = b.a("http://ls.map.soso.com/deflect?c=1", "SOSO MAP LBS SDK", r.a(this.a.a.getBytes()));
            b.a(this.a, false);
            byte[] arrayOfByte1 = r.b(localu1.a);
            b.a(this.a, arrayOfByte1, localu1.b);
            return;
          }
          catch (Exception localException2)
          {
          }
        }
        b.a(this.a, false);
      }
      while (b.a(this.a) == null);
      b.a(this.a).a(360.0D, 360.0D);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.b.b
 * JD-Core Version:    0.6.2
 */