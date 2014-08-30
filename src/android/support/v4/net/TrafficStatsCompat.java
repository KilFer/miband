package android.support.v4.net;

import android.os.Build.VERSION;
import java.net.Socket;

public class TrafficStatsCompat
{
  private static final n a = new j();

  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new m();
      return;
    }
  }

  public static void clearThreadStatsTag()
  {
    a.a();
  }

  public static int getThreadStatsTag()
  {
    return a.b();
  }

  public static void incrementOperationCount(int paramInt)
  {
    a.a(paramInt);
  }

  public static void incrementOperationCount(int paramInt1, int paramInt2)
  {
    a.a(paramInt1, paramInt2);
  }

  public static void setThreadStatsTag(int paramInt)
  {
    a.b(paramInt);
  }

  public static void tagSocket(Socket paramSocket)
  {
    a.a(paramSocket);
  }

  public static void untagSocket(Socket paramSocket)
  {
    a.b(paramSocket);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.net.TrafficStatsCompat
 * JD-Core Version:    0.6.2
 */