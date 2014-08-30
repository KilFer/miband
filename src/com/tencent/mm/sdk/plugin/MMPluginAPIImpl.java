package com.tencent.mm.sdk.plugin;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.mm.algorithm.Base64;
import com.tencent.mm.sdk.channel.MMessage.CallBack;
import com.tencent.mm.sdk.channel.MMessage.Receiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class MMPluginAPIImpl
  implements IMMPluginAPI
{
  private static final String[] d = { "key", "type", "value" };
  private final Context a;
  private MMessage.Receiver b;
  private String c;

  public MMPluginAPIImpl(Context paramContext)
  {
    this.a = paramContext;
    this.c = paramContext.getPackageName();
  }

  private Object a(String paramString)
  {
    Cursor localCursor = this.a.getContentResolver().query(MMPluginProviderConstants.PluginDB.CONTENT_URI, d, null, new String[] { paramString }, null);
    if (localCursor == null)
      return null;
    int i = localCursor.getColumnIndex("type");
    int j = localCursor.getColumnIndex("value");
    boolean bool = localCursor.moveToFirst();
    Object localObject = null;
    if (bool)
      localObject = MMPluginProviderConstants.Resolver.resolveObj(localCursor.getInt(i), localCursor.getString(j));
    localCursor.close();
    return localObject;
  }

  private void a(String paramString1, String paramString2, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramString2);
    localIntent.setClassName("com.tencent.mm", "com.tencent.mm.plugin.PluginProxyUI");
    if (paramIntent != null)
      localIntent.putExtras(paramIntent);
    localIntent.putExtra("com.tencent.mm.sdk.plugin.Intent.ACCESS_TOKEN", paramString1);
    this.a.startActivity(localIntent);
  }

  public boolean appendNetStat(int paramInt1, int paramInt2, int paramInt3)
  {
    return Util.nullAsFalse((Boolean)a("plugindb://" + this.c + "/action.appnetstat?recv=" + paramInt1 + "&send=" + paramInt2 + "&type=" + paramInt3));
  }

  public void createMsgController(String paramString)
  {
  }

  public void createQRCodeController(String paramString)
  {
    a(paramString, "qrcode", null);
  }

  public void createQRCodeController(String paramString, MMessage.CallBack paramCallBack)
  {
    createQRCodeController(paramString, paramCallBack, "*");
  }

  public void createQRCodeController(String paramString1, MMessage.CallBack paramCallBack, String paramString2)
  {
    a(paramString1, "qrcode", new Intent().putExtra("qrcode_pattern", paramString2));
  }

  public Profile getCurrentProfile(String paramString)
  {
    Cursor localCursor = this.a.getContentResolver().query(Profile.CONTENT_URI, Profile.columns, null, new String[] { paramString }, null);
    if (localCursor == null)
    {
      Log.e("MicroMsg.SDK.MMPluginMgrImpl", "get current profile failed");
      return null;
    }
    boolean bool = localCursor.moveToFirst();
    Profile localProfile = null;
    if (bool)
    {
      localProfile = new Profile();
      localProfile.convertFrom(localCursor);
    }
    localCursor.close();
    return localProfile;
  }

  public String getPluginKey(String paramString)
  {
    return (String)a("plugindb://" + paramString + "/comm.pluginkey");
  }

  public boolean installPlugin(String paramString)
  {
    return Util.nullAsFalse((Boolean)a("plugindb://" + paramString + "/action.install"));
  }

  public boolean isPluginInstalled(String paramString)
  {
    return Util.nullAsFalse((Boolean)a("plugindb://" + paramString + "/comm.installed"));
  }

  public void jumpToBindEmail(String paramString)
  {
    a(paramString, "bindemail", new Intent());
  }

  public void jumpToBindMobile(String paramString)
  {
    a(paramString, "bindmobile", new Intent());
  }

  public void jumpToBindQQ(String paramString)
  {
    a(paramString, "bindqq", new Intent());
  }

  public void jumpToChattingUI(String paramString1, String paramString2)
  {
    a(paramString1, "chatting", new Intent().putExtra("Contact_User", paramString2).setFlags(67108864));
  }

  public void jumpToSettingView(String paramString1, String paramString2)
  {
    a(paramString1, "profile", new Intent().putExtra("Contact_User", paramString2).setFlags(67108864));
  }

  public boolean registerAutoMsg(String paramString1, String paramString2)
  {
    return Util.nullAsFalse((Boolean)a("plugindb://" + this.c + "/action.automsg?pluginMsgUsername=" + paramString1 + "&pluginUsername=" + paramString2));
  }

  public boolean registerPattern(String paramString1, MMessage.CallBack paramCallBack, String paramString2)
  {
    return false;
  }

  public boolean registerQRCodePattern(String paramString1, MMessage.CallBack paramCallBack, String paramString2)
  {
    if (this.b != null)
      this.a.unregisterReceiver(this.b);
    this.b = new MMessage.Receiver(paramCallBack);
    this.a.registerReceiver(this.b, new IntentFilter("com.tencent.mm.sdk.plugin.Intent.ACTION_QRCODE_SCANNED"));
    return Util.nullAsFalse((Boolean)a("plugindb://" + paramString1 + "/action.register_qrcode_result?pattern=" + paramString2));
  }

  public void release()
  {
    Log.d("MicroMsg.SDK.MMPluginMgrImpl", "release plugin mgr implemetation");
    if (this.b != null)
    {
      this.a.unregisterReceiver(this.b);
      Log.d("MicroMsg.SDK.MMPluginMgrImpl", "unregister qrcode scan result receiver");
    }
  }

  public boolean sendMsgNotify(String paramString1, String paramString2, int paramInt, String paramString3, Class<?> paramClass)
  {
    if (paramClass == null)
      return false;
    return Util.nullAsFalse((Boolean)a("plugindb://" + this.c + "/action.msgnotify?username=" + paramString1 + "&msgContent=" + paramString2 + "&msgType=" + paramInt + "&customNotify=" + paramString3 + "&intentUri=" + Base64.encodeToString(new Intent(this.a, paramClass).toUri(0).getBytes(), false)));
  }

  public boolean unregisterAutoMsg(String paramString1, String paramString2)
  {
    return Util.nullAsFalse((Boolean)a("plugindb://" + this.c + "/action.unautomsg?pluginMsgUsername=" + paramString1 + "&pluginUsername=" + paramString2));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginAPIImpl
 * JD-Core Version:    0.6.2
 */