package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

final class n
{
  final IntentFilter a;
  final BroadcastReceiver b;
  boolean c;

  n(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
  {
    this.a = paramIntentFilter;
    this.b = paramBroadcastReceiver;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("Receiver{");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" filter=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.n
 * JD-Core Version:    0.6.2
 */