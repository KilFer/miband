package com.umeng.analytics.social;

import android.os.AsyncTask;
import android.text.TextUtils;
import org.json.JSONObject;

final class q extends AsyncTask<Void, Void, d>
{
  private String a = paramArrayOfString[0];
  private String b = paramArrayOfString[1];
  private UMSocialService.b c;
  private UMPlatformData[] d;

  public q(String[] paramArrayOfString, UMSocialService.b paramb, UMPlatformData[] paramArrayOfUMPlatformData)
  {
    this.c = paramb;
    this.d = paramArrayOfUMPlatformData;
  }

  private d a()
  {
    String str1;
    if (TextUtils.isEmpty(this.b))
      str1 = c.a(this.a);
    while (true)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(str1);
        i = localJSONObject.optInt("st");
        if (i == 0)
        {
          j = -404;
          d locald = new d(j);
          String str2 = localJSONObject.optString("msg");
          if (!TextUtils.isEmpty(str2))
            locald.a(str2);
          String str3 = localJSONObject.optString("data");
          if (!TextUtils.isEmpty(str3))
            locald.b(str3);
          return locald;
          str1 = c.a(this.a, this.b);
          continue;
        }
      }
      catch (Exception localException)
      {
        return new d(-99, localException);
      }
      int j = i;
    }
  }

  private void a(d paramd)
  {
    if (this.c != null)
      this.c.a(paramd, this.d);
  }

  protected final void onPreExecute()
  {
    if (this.c != null)
      this.c.a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.social.q
 * JD-Core Version:    0.6.2
 */