package android.support.v4.net;

import android.net.TrafficStats;
import java.net.Socket;

final class m
  implements n
{
  public final void a()
  {
    TrafficStats.clearThreadStatsTag();
  }

  public final void a(int paramInt)
  {
    TrafficStats.incrementOperationCount(paramInt);
  }

  public final void a(int paramInt1, int paramInt2)
  {
    TrafficStats.incrementOperationCount(paramInt1, paramInt2);
  }

  public final void a(Socket paramSocket)
  {
    TrafficStats.tagSocket(paramSocket);
  }

  public final int b()
  {
    return TrafficStats.getThreadStatsTag();
  }

  public final void b(int paramInt)
  {
    TrafficStats.setThreadStatsTag(paramInt);
  }

  public final void b(Socket paramSocket)
  {
    TrafficStats.untagSocket(paramSocket);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.net.m
 * JD-Core Version:    0.6.2
 */