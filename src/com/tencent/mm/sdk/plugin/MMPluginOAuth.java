package com.tencent.mm.sdk.plugin;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Log;

public class MMPluginOAuth
{
  private final MMPluginOAuth.IResult a;
  private final Context b;
  private String c;
  private String d;
  private Handler e;

  public MMPluginOAuth(Context paramContext, MMPluginOAuth.IResult paramIResult)
  {
    this.b = paramContext;
    this.a = paramIResult;
  }

  public String getAccessToken()
  {
    return this.c;
  }

  public String getRequestToken()
  {
    return this.d;
  }

  public void start()
  {
    start(null);
  }

  public boolean start(Handler paramHandler)
  {
    if (paramHandler == null)
      paramHandler = new Handler();
    this.e = paramHandler;
    ContentResolver localContentResolver = this.b.getContentResolver();
    Uri localUri = MMPluginProviderConstants.OAuth.CONTENT_URI;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = this.b.getPackageName();
    arrayOfString[1] = "request_token";
    Cursor localCursor = localContentResolver.query(localUri, null, null, arrayOfString, null);
    if (localCursor != null)
    {
      if ((localCursor.moveToFirst()) && (localCursor.getColumnCount() >= 2))
      {
        this.d = localCursor.getString(0);
        this.c = localCursor.getString(1);
      }
      localCursor.close();
    }
    Log.i("MicroMsg.SDK.MMPluginOAuth", "request token = " + this.d);
    if (this.d == null)
    {
      Log.e("MicroMsg.SDK.MMPluginOAuth", "request token failed");
      return false;
    }
    if (this.c != null)
    {
      this.e.post(new a(this));
      return true;
    }
    Log.d("MicroMsg.SDK.MMPluginOAuth", "begin to show user oauth page");
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mm", "com.tencent.mm.plugin.PluginOAuthUI");
    localIntent.putExtra("com.tencent.mm.sdk.plugin.Intent.REQUEST_TOKEN", this.d);
    localIntent.putExtra("com.tencent.mm.sdk.plugin.Intent.PACKAGE", this.b.getPackageName());
    if (this.b.getPackageManager().resolveActivity(localIntent, 65536) == null)
      Log.e("MicroMsg.SDK.MMPluginOAuth", "show oauth page failed, activity not found");
    for (int i = 0; i != 0; i = 1)
    {
      MMPluginOAuth.Receiver.register(this.d, this);
      return true;
      if (!(this.b instanceof Activity))
        localIntent.setFlags(268435456);
      this.b.startActivity(localIntent);
    }
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginOAuth
 * JD-Core Version:    0.6.2
 */