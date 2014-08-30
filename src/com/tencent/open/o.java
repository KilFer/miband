package com.tencent.open;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.open.a.b;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.Util;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

final class o
  implements IUiListener
{
  private WeakReference<Context> a;
  private String b;
  private String c;
  private String d;
  private IUiListener e;

  public o(Context paramContext, String paramString1, String paramString2, String paramString3, IUiListener paramIUiListener)
  {
    this.a = new WeakReference(paramContext);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramIUiListener;
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
    if (this.e != null)
    {
      this.e.onCancel();
      this.e = null;
    }
  }

  public final void onComplete(Object paramObject)
  {
    JSONObject localJSONObject = (JSONObject)paramObject;
    b.a().a((Context)this.a.get(), this.b + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, localJSONObject.optInt("ret", -6), this.d, this.c, "1000067");
    if (this.e != null)
    {
      this.e.onComplete(localJSONObject);
      this.e = null;
    }
  }

  public final void onError(UiError paramUiError)
  {
    if (paramUiError.errorMessage != null);
    for (String str = paramUiError.errorMessage + this.c; ; str = this.c)
    {
      b.a().a((Context)this.a.get(), this.b + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, paramUiError.errorCode, this.d, str, "1000067");
      if (this.e != null)
      {
        this.e.onError(paramUiError);
        this.e = null;
      }
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.o
 * JD-Core Version:    0.6.2
 */