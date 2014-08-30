package android.support.v4.net;

import java.net.Socket;

final class j
  implements n
{
  private ThreadLocal<l> a = new k(this);

  public final void a()
  {
    ((l)this.a.get()).a = -1;
  }

  public final void a(int paramInt)
  {
  }

  public final void a(int paramInt1, int paramInt2)
  {
  }

  public final void a(Socket paramSocket)
  {
  }

  public final int b()
  {
    return ((l)this.a.get()).a;
  }

  public final void b(int paramInt)
  {
    ((l)this.a.get()).a = paramInt;
  }

  public final void b(Socket paramSocket)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.net.j
 * JD-Core Version:    0.6.2
 */