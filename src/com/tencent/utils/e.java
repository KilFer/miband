package com.tencent.utils;

import android.content.Context;
import android.os.Bundle;

final class e extends Thread
{
  e(Context paramContext, Bundle paramBundle)
  {
  }

  public final void run()
  {
    try
    {
      HttpUtils.openUrl2(this.a, "http://cgi.qplus.com/report/report", "GET", this.b);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.utils.e
 * JD-Core Version:    0.6.2
 */