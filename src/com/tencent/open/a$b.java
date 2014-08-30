package com.tencent.open;

import android.webkit.WebView;
import java.lang.ref.WeakReference;

public class a$b
{
  private WeakReference<WebView> a;
  private long b;
  private String c;

  public a$b(WebView paramWebView, long paramLong, String paramString)
  {
    this.a = new WeakReference(paramWebView);
    this.b = paramLong;
  }

  public void a()
  {
    WebView localWebView = (WebView)this.a.get();
    if (localWebView == null)
      return;
    localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':1,'result':'no such method'})");
  }

  public void a(Object paramObject)
  {
    WebView localWebView = (WebView)this.a.get();
    if (localWebView == null)
      return;
    String str1 = "'undefined'";
    if ((paramObject instanceof String))
    {
      String str2 = ((String)paramObject).replace("\\", "\\\\").replace("'", "\\'");
      str1 = "'" + str2 + "'";
    }
    while (true)
    {
      localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':0,'result':" + str1 + "});");
      return;
      if (((paramObject instanceof Number)) || ((paramObject instanceof Long)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Double)) || ((paramObject instanceof Float)))
        str1 = paramObject.toString();
      else if ((paramObject instanceof Boolean))
        str1 = paramObject.toString();
    }
  }

  public void a(String paramString)
  {
    WebView localWebView = (WebView)this.a.get();
    if (localWebView != null)
      localWebView.loadUrl("javascript:" + paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.a.b
 * JD-Core Version:    0.6.2
 */