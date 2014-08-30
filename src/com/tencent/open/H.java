package com.tencent.open;

import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

final class H extends WebChromeClient
{
  H(d paramd)
  {
  }

  public final void onConsoleMessage(String paramString1, int paramInt, String paramString2)
  {
    Log.i("WebConsole", paramString1 + " -- From 222 line " + paramInt + " of " + paramString2);
    if (Build.VERSION.SDK_INT == 7)
      this.a.onConsoleMessage(paramString1);
  }

  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    Log.i("WebConsole", paramConsoleMessage.message() + " -- From  111 line " + paramConsoleMessage.lineNumber() + " of " + paramConsoleMessage.sourceId());
    d locald;
    if (Build.VERSION.SDK_INT > 7)
    {
      locald = this.a;
      if (paramConsoleMessage != null)
        break label76;
    }
    label76: for (String str = ""; ; str = paramConsoleMessage.message())
    {
      locald.onConsoleMessage(str);
      return true;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.H
 * JD-Core Version:    0.6.2
 */