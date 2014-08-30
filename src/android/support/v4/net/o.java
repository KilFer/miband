package android.support.v4.net;

import android.net.TrafficStats;
import java.net.Socket;

final class o
{
  public static void a()
  {
    TrafficStats.clearThreadStatsTag();
  }

  public static void a(int paramInt)
  {
    TrafficStats.incrementOperationCount(paramInt);
  }

  public static void a(int paramInt1, int paramInt2)
  {
    TrafficStats.incrementOperationCount(paramInt1, paramInt2);
  }

  public static void a(Socket paramSocket)
  {
    TrafficStats.tagSocket(paramSocket);
  }

  public static int b()
  {
    return TrafficStats.getThreadStatsTag();
  }

  public static void b(int paramInt)
  {
    TrafficStats.setThreadStatsTag(paramInt);
  }

  public static void b(Socket paramSocket)
  {
    TrafficStats.untagSocket(paramSocket);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.net.o
 * JD-Core Version:    0.6.2
 */