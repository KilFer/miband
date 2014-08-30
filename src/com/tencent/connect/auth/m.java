package com.tencent.connect.auth;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.open.a.b;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.Util;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

final class m
  implements IUiListener
{
  private String a;
  private String b;
  private String c;
  private IUiListener d;

  public m(AuthDialog paramAuthDialog, String paramString1, String paramString2, String paramString3, IUiListener paramIUiListener)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramIUiListener;
  }

  private void a(String paramString)
  {
    try
    {
      onComplete(Util.parseJson(paramString));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      onError(new UiError(-4, "服务器返回数据格式有误!", paramString));
    }
  }

  public final void onCancel()
  {
    if (this.d != null)
    {
      this.d.onCancel();
      this.d = null;
    }
  }

  public final void onComplete(Object paramObject)
  {
    JSONObject localJSONObject = (JSONObject)paramObject;
    b.a().a((Context)AuthDialog.a().get(), this.a + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, localJSONObject.optInt("ret", -6), this.c, this.b, "1000067");
    if (this.d != null)
    {
      this.d.onComplete(localJSONObject);
      this.d = null;
    }
  }

  public final void onError(UiError paramUiError)
  {
    if (paramUiError.errorMessage != null);
    for (String str = paramUiError.errorMessage + this.b; ; str = this.b)
    {
      b.a().a((Context)AuthDialog.a().get(), this.a + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, paramUiError.errorCode, this.c, str, "1000067");
      if (this.d != null)
      {
        this.d.onError(paramUiError);
        this.d = null;
      }
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.m
 * JD-Core Version:    0.6.2
 */