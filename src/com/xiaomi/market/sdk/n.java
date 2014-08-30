package com.xiaomi.market.sdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.File;

public class n extends Handler
{
  public n(m paramm, Looper paramLooper)
  {
    super(paramLooper);
  }

  private String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.equals(b.a(new File(paramString1)), paramString2)));
    String str;
    do
    {
      return null;
      str = m.e(this.a).getAbsolutePath();
    }
    while ((m.d(this.a) == null) || (TextUtils.isEmpty(m.d(this.a).sourceDir)));
    Patcher.a(m.d(this.a).sourceDir, str, paramString1);
    return str;
  }

  public void l()
  {
    post(new o(this));
  }

  public void m()
  {
    post(new p(this));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.n
 * JD-Core Version:    0.6.2
 */