package com.tencent.connect.avatar;

final class j
  implements Runnable
{
  j(b paramb)
  {
  }

  public final void run()
  {
    try
    {
      Thread.sleep(300L);
      this.a.post(new k(this));
      b.a(this.a, false);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        localInterruptedException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.avatar.j
 * JD-Core Version:    0.6.2
 */