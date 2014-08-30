package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

final class aC extends Handler
{
  aC(MainUIActivity paramMainUIActivity)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 263:
    case 272:
    case 273:
      do
      {
        return;
        Bundle localBundle = paramMessage.getData();
        String str1 = localBundle.getString("ChangeLog");
        String str2 = localBundle.getString("DownUrl");
        MainUIActivity.a(this.a, str1, str2);
        return;
        this.a.pullDownMsgList(this.a.getString(2131493280), this.a.getString(2131493281), 2, 0.0F);
        MainUIActivity.c(this.a, true);
        return;
      }
      while ((MainUIActivity.d(this.a).a == -1) || (MainUIActivity.d(this.a).a == 11));
      this.a.onBleStatusChanged(MainUIActivity.d(this.a));
      return;
    case 274:
    }
    this.a.restoreDownMsgList();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aC
 * JD-Core Version:    0.6.2
 */