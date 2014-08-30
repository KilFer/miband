package cn.com.smartdevices.bracelet.upgrade;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.preference.PreferenceManager;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class UpgradeUtil
{
  public static final String IS_NEED_CHECK = "NeedCheck";
  public static final String IS_NEED_UPLOAD_CONTACTS = "NeedUploadContacts";
  public static final String KEY_CHANGE_LOG = "ChangeLog";
  public static final String KEY_DOWN_URL = "DownUrl";
  public static final String KEY_NEW_VERSION = "NewVersion";
  public static final int MSG_GET_OTA_VERSION_FINISHED = 265;
  public static final int MSG_GET_WATCH_INFO_FINISHED = 264;
  public static final int MSG_UPDATE = 263;
  private static final boolean a;

  public static boolean checkState(Context paramContext, String paramString, int paramInt)
  {
    String str1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, "0");
    Date localDate = new Date();
    String str2 = new SimpleDateFormat("yyyyMMdd").format(localDate);
    try
    {
      int i = Integer.parseInt(str2);
      int j = Integer.parseInt(str1);
      int k = i - j;
      boolean bool = false;
      if (k > paramInt)
        bool = true;
      return bool;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return false;
  }

  public static boolean checkStateExist(Context paramContext, String paramString, int paramInt)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, "0").compareTo("0") != 0;
  }

  public static boolean downloadApkFile(Context paramContext, String paramString)
  {
    if (paramString == null)
      return false;
    performDownload(paramContext, paramString);
    return true;
  }

  public static int getApkVersionCode(Context paramContext, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 1);
      if (localPackageInfo == null)
        return 0;
      return localPackageInfo.versionCode;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return 0;
  }

  // ERROR //
  public static NewVersionInfo getNetVersionInfo(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 112	cn/com/smartdevices/bracelet/upgrade/NewVersionInfo
    //   3: dup
    //   4: invokespecial 113	cn/com/smartdevices/bracelet/upgrade/NewVersionInfo:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokestatic 119	cn/com/smartdevices/bracelet/upgrade/WebServiceClient:getInstance	(Landroid/content/Context;)Lcn/com/smartdevices/bracelet/upgrade/WebServiceClient;
    //   12: astore_3
    //   13: new 121	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 122	java/util/ArrayList:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: new 124	org/apache/http/message/BasicNameValuePair
    //   27: dup
    //   28: ldc 126
    //   30: ldc 128
    //   32: invokespecial 131	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   38: pop
    //   39: aload_3
    //   40: aload_1
    //   41: aload 4
    //   43: invokevirtual 139	cn/com/smartdevices/bracelet/upgrade/WebServiceClient:post	(Ljava/lang/String;Ljava/util/ArrayList;)Ljava/io/InputStream;
    //   46: astore 6
    //   48: aload 6
    //   50: ifnull +286 -> 336
    //   53: new 141	cn/com/smartdevices/bracelet/upgrade/WebServiceClient$DomXMLHandler
    //   56: dup
    //   57: invokespecial 142	cn/com/smartdevices/bracelet/upgrade/WebServiceClient$DomXMLHandler:<init>	()V
    //   60: aload 6
    //   62: invokevirtual 146	cn/com/smartdevices/bracelet/upgrade/WebServiceClient$DomXMLHandler:parseXml	(Ljava/io/InputStream;)Lorg/w3c/dom/Element;
    //   65: astore 9
    //   67: aload 6
    //   69: invokevirtual 151	java/io/InputStream:close	()V
    //   72: aload 9
    //   74: ifnull +262 -> 336
    //   77: aload 9
    //   79: ldc 153
    //   81: invokeinterface 159 2 0
    //   86: iconst_0
    //   87: invokeinterface 165 2 0
    //   92: invokeinterface 171 1 0
    //   97: invokeinterface 175 1 0
    //   102: astore 13
    //   104: aload 13
    //   106: ifnull +224 -> 330
    //   109: aload 13
    //   111: invokestatic 71	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   114: istore 7
    //   116: ldc 177
    //   118: astore 14
    //   120: aload 9
    //   122: ldc 179
    //   124: invokeinterface 159 2 0
    //   129: iconst_0
    //   130: invokeinterface 165 2 0
    //   135: invokeinterface 183 1 0
    //   140: astore 15
    //   142: iconst_0
    //   143: istore 16
    //   145: aload 15
    //   147: ifnull +15 -> 162
    //   150: iload 16
    //   152: aload 15
    //   154: invokeinterface 187 1 0
    //   159: if_icmplt +114 -> 273
    //   162: aload_2
    //   163: aload 14
    //   165: invokevirtual 190	cn/com/smartdevices/bracelet/upgrade/NewVersionInfo:setChangeLog	(Ljava/lang/String;)V
    //   168: aload_2
    //   169: aload 9
    //   171: ldc 192
    //   173: invokeinterface 159 2 0
    //   178: iconst_0
    //   179: invokeinterface 165 2 0
    //   184: invokeinterface 171 1 0
    //   189: invokeinterface 175 1 0
    //   194: invokevirtual 195	cn/com/smartdevices/bracelet/upgrade/NewVersionInfo:setFileUrl	(Ljava/lang/String;)V
    //   197: aload_2
    //   198: aload 9
    //   200: ldc 197
    //   202: invokeinterface 159 2 0
    //   207: iconst_0
    //   208: invokeinterface 165 2 0
    //   213: invokeinterface 171 1 0
    //   218: invokeinterface 175 1 0
    //   223: invokevirtual 200	cn/com/smartdevices/bracelet/upgrade/NewVersionInfo:setMd5	(Ljava/lang/String;)V
    //   226: aload_2
    //   227: iload 7
    //   229: invokevirtual 204	cn/com/smartdevices/bracelet/upgrade/NewVersionInfo:setVersionCode	(I)V
    //   232: aload_0
    //   233: invokestatic 43	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   236: invokeinterface 208 1 0
    //   241: ldc 20
    //   243: iload 7
    //   245: invokeinterface 214 3 0
    //   250: invokeinterface 218 1 0
    //   255: pop
    //   256: aload_2
    //   257: areturn
    //   258: astore 11
    //   260: aload 11
    //   262: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   265: goto -193 -> 72
    //   268: astore 10
    //   270: aload 10
    //   272: athrow
    //   273: new 223	java/lang/StringBuilder
    //   276: dup
    //   277: aload 14
    //   279: invokestatic 227	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   282: invokespecial 228	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   285: aload 15
    //   287: iload 16
    //   289: invokeinterface 165 2 0
    //   294: invokeinterface 175 1 0
    //   299: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: astore 17
    //   307: iinc 16 1
    //   310: aload 17
    //   312: astore 14
    //   314: goto -164 -> 150
    //   317: astore 12
    //   319: aload 12
    //   321: invokevirtual 236	java/lang/Exception:printStackTrace	()V
    //   324: iconst_m1
    //   325: istore 7
    //   327: goto -101 -> 226
    //   330: iconst_m1
    //   331: istore 7
    //   333: goto -217 -> 116
    //   336: iconst_m1
    //   337: istore 7
    //   339: goto -113 -> 226
    //
    // Exception table:
    //   from	to	target	type
    //   67	72	258	java/io/IOException
    //   67	72	268	finally
    //   260	265	268	finally
    //   77	104	317	java/lang/Exception
    //   109	116	317	java/lang/Exception
    //   120	142	317	java/lang/Exception
    //   150	162	317	java/lang/Exception
    //   162	226	317	java/lang/Exception
    //   273	307	317	java/lang/Exception
  }

  public static String getOtaUrl()
  {
    return "http://ota.app-xae.xiaomi.com/ota_testhm.php";
  }

  // ERROR //
  public static OtaVersionInfo getOtaVersionInfo(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 243	cn/com/smartdevices/bracelet/upgrade/OtaVersionInfo
    //   3: dup
    //   4: invokespecial 244	cn/com/smartdevices/bracelet/upgrade/OtaVersionInfo:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokestatic 119	cn/com/smartdevices/bracelet/upgrade/WebServiceClient:getInstance	(Landroid/content/Context;)Lcn/com/smartdevices/bracelet/upgrade/WebServiceClient;
    //   12: astore_3
    //   13: new 121	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 122	java/util/ArrayList:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: new 124	org/apache/http/message/BasicNameValuePair
    //   27: dup
    //   28: ldc 246
    //   30: ldc 248
    //   32: invokespecial 131	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   38: pop
    //   39: aload 4
    //   41: new 124	org/apache/http/message/BasicNameValuePair
    //   44: dup
    //   45: ldc 250
    //   47: ldc 177
    //   49: invokespecial 131	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   55: pop
    //   56: aload 4
    //   58: new 124	org/apache/http/message/BasicNameValuePair
    //   61: dup
    //   62: ldc 252
    //   64: new 223	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   71: aload_0
    //   72: aload_0
    //   73: invokevirtual 256	android/content/Context:getPackageName	()Ljava/lang/String;
    //   76: invokestatic 258	cn/com/smartdevices/bracelet/upgrade/UpgradeUtil:getApkVersionCode	(Landroid/content/Context;Ljava/lang/String;)I
    //   79: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 131	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: aload 4
    //   94: new 124	org/apache/http/message/BasicNameValuePair
    //   97: dup
    //   98: ldc_w 263
    //   101: ldc 177
    //   103: invokespecial 131	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   109: pop
    //   110: aload 4
    //   112: new 124	org/apache/http/message/BasicNameValuePair
    //   115: dup
    //   116: ldc_w 265
    //   119: new 223	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   126: invokestatic 271	java/lang/System:currentTimeMillis	()J
    //   129: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   132: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokespecial 131	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   141: pop
    //   142: aload_3
    //   143: aload_1
    //   144: aload 4
    //   146: invokevirtual 277	cn/com/smartdevices/bracelet/upgrade/WebServiceClient:get	(Ljava/lang/String;Ljava/util/ArrayList;)Ljava/io/InputStream;
    //   149: astore 10
    //   151: aload 10
    //   153: ifnull +236 -> 389
    //   156: new 141	cn/com/smartdevices/bracelet/upgrade/WebServiceClient$DomXMLHandler
    //   159: dup
    //   160: invokespecial 142	cn/com/smartdevices/bracelet/upgrade/WebServiceClient$DomXMLHandler:<init>	()V
    //   163: aload 10
    //   165: invokevirtual 146	cn/com/smartdevices/bracelet/upgrade/WebServiceClient$DomXMLHandler:parseXml	(Ljava/io/InputStream;)Lorg/w3c/dom/Element;
    //   168: astore 11
    //   170: aload 10
    //   172: invokevirtual 151	java/io/InputStream:close	()V
    //   175: aload 11
    //   177: ifnull +212 -> 389
    //   180: aload_2
    //   181: aload 11
    //   183: ldc_w 279
    //   186: invokeinterface 159 2 0
    //   191: iconst_0
    //   192: invokeinterface 165 2 0
    //   197: invokeinterface 171 1 0
    //   202: invokeinterface 175 1 0
    //   207: putfield 282	cn/com/smartdevices/bracelet/upgrade/OtaVersionInfo:firmwareUrl	Ljava/lang/String;
    //   210: aload 11
    //   212: ldc_w 284
    //   215: invokeinterface 159 2 0
    //   220: iconst_0
    //   221: invokeinterface 165 2 0
    //   226: invokeinterface 171 1 0
    //   231: invokeinterface 175 1 0
    //   236: astore 15
    //   238: aload 15
    //   240: ifnull +15 -> 255
    //   243: aload_2
    //   244: aload 15
    //   246: invokestatic 289	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   249: invokevirtual 293	java/lang/Float:floatValue	()F
    //   252: putfield 297	cn/com/smartdevices/bracelet/upgrade/OtaVersionInfo:firmwareVersionCode	F
    //   255: aload_2
    //   256: aload 11
    //   258: ldc_w 299
    //   261: invokeinterface 159 2 0
    //   266: iconst_0
    //   267: invokeinterface 165 2 0
    //   272: invokeinterface 171 1 0
    //   277: invokeinterface 175 1 0
    //   282: putfield 302	cn/com/smartdevices/bracelet/upgrade/OtaVersionInfo:firmwareVersion	Ljava/lang/String;
    //   285: aload_2
    //   286: aload 11
    //   288: ldc_w 304
    //   291: invokeinterface 159 2 0
    //   296: iconst_0
    //   297: invokeinterface 165 2 0
    //   302: invokeinterface 171 1 0
    //   307: invokeinterface 175 1 0
    //   312: putfield 307	cn/com/smartdevices/bracelet/upgrade/OtaVersionInfo:firmwareInfo	Ljava/lang/String;
    //   315: aload 11
    //   317: ldc_w 309
    //   320: invokeinterface 159 2 0
    //   325: iconst_0
    //   326: invokeinterface 165 2 0
    //   331: invokeinterface 171 1 0
    //   336: invokeinterface 175 1 0
    //   341: astore 16
    //   343: aload 16
    //   345: ifnull +15 -> 360
    //   348: aload_2
    //   349: aload 16
    //   351: invokestatic 312	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   354: invokevirtual 315	java/lang/Integer:intValue	()I
    //   357: putfield 318	cn/com/smartdevices/bracelet/upgrade/OtaVersionInfo:firmwareSize	I
    //   360: aload_2
    //   361: aload 11
    //   363: ldc 197
    //   365: invokeinterface 159 2 0
    //   370: iconst_0
    //   371: invokeinterface 165 2 0
    //   376: invokeinterface 171 1 0
    //   381: invokeinterface 175 1 0
    //   386: putfield 321	cn/com/smartdevices/bracelet/upgrade/OtaVersionInfo:firmwareMd5	Ljava/lang/String;
    //   389: aload_2
    //   390: areturn
    //   391: astore 13
    //   393: aload 13
    //   395: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   398: goto -223 -> 175
    //   401: astore 12
    //   403: aload 12
    //   405: athrow
    //   406: astore 14
    //   408: aload 14
    //   410: invokevirtual 236	java/lang/Exception:printStackTrace	()V
    //   413: aload_2
    //   414: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   170	175	391	java/io/IOException
    //   170	175	401	finally
    //   393	398	401	finally
    //   180	238	406	java/lang/Exception
    //   243	255	406	java/lang/Exception
    //   255	343	406	java/lang/Exception
    //   348	360	406	java/lang/Exception
    //   360	389	406	java/lang/Exception
  }

  public static String getUpgradeURL()
  {
    return "http://ota.app-xae.xiaomi.com/soft_testhm.php";
  }

  public static boolean isNeedCheck(Context paramContext)
  {
    String str = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("NeedCheck", "0");
    Date localDate = new Date();
    return new SimpleDateFormat("yyyyMMdd").format(localDate).compareTo(str) > 0;
  }

  public static void performDownload(Context paramContext, String paramString)
  {
    if (paramString != null);
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      localIntent.setFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void updateCheckState(Context paramContext)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    Date localDate = new Date();
    String str = new SimpleDateFormat("yyyyMMdd").format(localDate);
    localSharedPreferences.edit().putString("NeedCheck", str).commit();
  }

  public static void updateState(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    Date localDate = new Date();
    String str = new SimpleDateFormat("yyyyMMdd").format(localDate);
    localSharedPreferences.edit().putString(paramString, str).commit();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.upgrade.UpgradeUtil
 * JD-Core Version:    0.6.2
 */