package com.umeng.analytics;

import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

final class k extends WebChromeClient
{
  private WebChromeClient a = null;
  private final String b;
  private final String c;

  public k(MobclickAgentJSInterface paramMobclickAgentJSInterface, WebChromeClient paramWebChromeClient)
  {
    if (paramWebChromeClient == null)
    {
      this.a = new WebChromeClient();
      return;
    }
    this.a = paramWebChromeClient;
  }

  public final void onCloseWindow(WebView paramWebView)
  {
    this.a.onCloseWindow(paramWebView);
  }

  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    return this.a.onCreateWindow(paramWebView, paramBoolean1, paramBoolean2, paramMessage);
  }

  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.a.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }

  public final boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.a.onJsBeforeUnload(paramWebView, paramString1, paramString2, paramJsResult);
  }

  public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.a.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
  }

  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if ("ekv".equals(paramString2));
    while (true)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject(paramString3);
        HashMap localHashMap = new HashMap();
        String str2 = (String)localJSONObject2.remove("id");
        int i;
        Iterator localIterator;
        if (localJSONObject2.isNull("duration"))
        {
          i = 0;
          localIterator = localJSONObject2.keys();
          if (!localIterator.hasNext())
          {
            MobclickAgent.getAgent().a(MobclickAgentJSInterface.a(this.d), str2, localHashMap, i);
            paramJsPromptResult.confirm();
            return true;
          }
        }
        else
        {
          i = ((Integer)localJSONObject2.remove("duration")).intValue();
          continue;
        }
        String str3 = (String)localIterator.next();
        localHashMap.put(str3, localJSONObject2.getString(str3));
        continue;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        continue;
      }
      if (!"event".equals(paramString2))
        break;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString3);
        String str1 = localJSONObject1.optString("label");
        if ("".equals(str1))
          str1 = null;
        MobclickAgent.getAgent().a(MobclickAgentJSInterface.a(this.d), localJSONObject1.getString("tag"), str1, localJSONObject1.optInt("duration"), 1);
      }
      catch (Exception localException1)
      {
      }
    }
    return this.a.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }

  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    this.a.onProgressChanged(paramWebView, paramInt);
  }

  public final void onReceivedIcon(WebView paramWebView, Bitmap paramBitmap)
  {
    this.a.onReceivedIcon(paramWebView, paramBitmap);
  }

  public final void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.a.onReceivedTitle(paramWebView, paramString);
  }

  public final void onRequestFocus(WebView paramWebView)
  {
    this.a.onRequestFocus(paramWebView);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.k
 * JD-Core Version:    0.6.2
 */