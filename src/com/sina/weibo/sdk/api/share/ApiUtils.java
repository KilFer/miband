package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import java.util.Iterator;
import java.util.List;

public class ApiUtils
{
  public static final int BUILD_INT = 10350;
  public static final int BUILD_INT_VER_2_2 = 10351;
  public static final int BUILD_INT_VER_2_3 = 10352;
  private static final String TAG = "ApiUtils";
  private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
  private static final Uri WEIBO_NAME_URI = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");
  private static final String WEIBO_SIGN = "18da2bf10352443a00a5e046d9fca6bd";

  public static boolean containSign(Signature[] paramArrayOfSignature, String paramString)
  {
    if ((paramArrayOfSignature == null) || (paramString == null));
    while (true)
    {
      return false;
      int i = paramArrayOfSignature.length;
      for (int j = 0; j < i; j++)
        if (paramString.equals(MD5.hexdigest(paramArrayOfSignature[j].toByteArray())))
        {
          LogUtil.d("ApiUtils", "check pass");
          return true;
        }
    }
  }

  public static boolean isWeiboAppSupportAPI(int paramInt)
  {
    return paramInt >= 10350;
  }

  public static ApiUtils.WeiboInfo queryWeiboInfo(Context paramContext)
  {
    ApiUtils.WeiboInfo localWeiboInfo = queryWeiboInfoByProvider(paramContext);
    if (localWeiboInfo == null)
      localWeiboInfo = queryWeiboInfoByFile(paramContext);
    return localWeiboInfo;
  }

  // ERROR //
  private static ApiUtils.WeiboInfo queryWeiboInfoByAsset(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +7 -> 12
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_2
    //   11: areturn
    //   12: aload_0
    //   13: aload_1
    //   14: iconst_2
    //   15: invokevirtual 92	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   18: astore 14
    //   20: sipush 1024
    //   23: newarray byte
    //   25: astore 15
    //   27: aload 14
    //   29: invokevirtual 96	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   32: ldc 98
    //   34: invokevirtual 104	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   37: astore 16
    //   39: aload 16
    //   41: astore 4
    //   43: new 106	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   50: astore 17
    //   52: aload 4
    //   54: aload 15
    //   56: iconst_0
    //   57: sipush 1024
    //   60: invokevirtual 113	java/io/InputStream:read	([BII)I
    //   63: istore 18
    //   65: iload 18
    //   67: iconst_m1
    //   68: if_icmpne +38 -> 106
    //   71: aload 17
    //   73: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +15 -> 94
    //   82: aload_0
    //   83: aload_1
    //   84: invokestatic 127	com/sina/weibo/sdk/api/share/ApiUtils:validateWeiboSign	(Landroid/content/Context;Ljava/lang/String;)Z
    //   87: istore 20
    //   89: iload 20
    //   91: ifne +53 -> 144
    //   94: aload 4
    //   96: ifnull +8 -> 104
    //   99: aload 4
    //   101: invokevirtual 130	java/io/InputStream:close	()V
    //   104: aconst_null
    //   105: areturn
    //   106: aload 17
    //   108: new 54	java/lang/String
    //   111: dup
    //   112: aload 15
    //   114: iconst_0
    //   115: iload 18
    //   117: invokespecial 133	java/lang/String:<init>	([BII)V
    //   120: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: goto -72 -> 52
    //   127: astore_3
    //   128: aload_3
    //   129: invokevirtual 140	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   132: aload 4
    //   134: ifnull +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 130	java/io/InputStream:close	()V
    //   142: aconst_null
    //   143: areturn
    //   144: new 142	org/json/JSONObject
    //   147: dup
    //   148: aload 17
    //   150: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokespecial 145	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   156: ldc 147
    //   158: iconst_m1
    //   159: invokevirtual 151	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   162: istore 21
    //   164: new 153	com/sina/weibo/sdk/api/share/ApiUtils$WeiboInfo
    //   167: dup
    //   168: invokespecial 154	com/sina/weibo/sdk/api/share/ApiUtils$WeiboInfo:<init>	()V
    //   171: astore_2
    //   172: aload_2
    //   173: aload_1
    //   174: putfield 157	com/sina/weibo/sdk/api/share/ApiUtils$WeiboInfo:packageName	Ljava/lang/String;
    //   177: aload_2
    //   178: iload 21
    //   180: putfield 160	com/sina/weibo/sdk/api/share/ApiUtils$WeiboInfo:supportApi	I
    //   183: aload 4
    //   185: ifnull -175 -> 10
    //   188: aload 4
    //   190: invokevirtual 130	java/io/InputStream:close	()V
    //   193: aload_2
    //   194: areturn
    //   195: astore 22
    //   197: aload_2
    //   198: areturn
    //   199: astore 12
    //   201: aconst_null
    //   202: astore 4
    //   204: aload 12
    //   206: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   209: aload 4
    //   211: ifnull -69 -> 142
    //   214: aload 4
    //   216: invokevirtual 130	java/io/InputStream:close	()V
    //   219: goto -77 -> 142
    //   222: astore 13
    //   224: goto -82 -> 142
    //   227: astore 10
    //   229: aconst_null
    //   230: astore 4
    //   232: aload 10
    //   234: invokevirtual 162	org/json/JSONException:printStackTrace	()V
    //   237: aload 4
    //   239: ifnull -97 -> 142
    //   242: aload 4
    //   244: invokevirtual 130	java/io/InputStream:close	()V
    //   247: goto -105 -> 142
    //   250: astore 11
    //   252: goto -110 -> 142
    //   255: astore 8
    //   257: aconst_null
    //   258: astore 4
    //   260: ldc 15
    //   262: aload 8
    //   264: invokevirtual 165	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   267: invokestatic 168	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload 4
    //   272: ifnull -130 -> 142
    //   275: aload 4
    //   277: invokevirtual 130	java/io/InputStream:close	()V
    //   280: goto -138 -> 142
    //   283: astore 9
    //   285: goto -143 -> 142
    //   288: astore 5
    //   290: aconst_null
    //   291: astore 4
    //   293: aload 4
    //   295: ifnull +8 -> 303
    //   298: aload 4
    //   300: invokevirtual 130	java/io/InputStream:close	()V
    //   303: aload 5
    //   305: athrow
    //   306: astore 19
    //   308: goto -204 -> 104
    //   311: astore 7
    //   313: goto -171 -> 142
    //   316: astore 6
    //   318: goto -15 -> 303
    //   321: astore 5
    //   323: goto -30 -> 293
    //   326: astore 8
    //   328: goto -68 -> 260
    //   331: astore 10
    //   333: goto -101 -> 232
    //   336: astore 12
    //   338: goto -134 -> 204
    //   341: astore_3
    //   342: aconst_null
    //   343: astore 4
    //   345: goto -217 -> 128
    //
    // Exception table:
    //   from	to	target	type
    //   43	52	127	android/content/pm/PackageManager$NameNotFoundException
    //   52	65	127	android/content/pm/PackageManager$NameNotFoundException
    //   71	89	127	android/content/pm/PackageManager$NameNotFoundException
    //   106	124	127	android/content/pm/PackageManager$NameNotFoundException
    //   144	183	127	android/content/pm/PackageManager$NameNotFoundException
    //   188	193	195	java/io/IOException
    //   12	39	199	java/io/IOException
    //   214	219	222	java/io/IOException
    //   12	39	227	org/json/JSONException
    //   242	247	250	java/io/IOException
    //   12	39	255	java/lang/Exception
    //   275	280	283	java/io/IOException
    //   12	39	288	finally
    //   99	104	306	java/io/IOException
    //   137	142	311	java/io/IOException
    //   298	303	316	java/io/IOException
    //   43	52	321	finally
    //   52	65	321	finally
    //   71	89	321	finally
    //   106	124	321	finally
    //   128	132	321	finally
    //   144	183	321	finally
    //   204	209	321	finally
    //   232	237	321	finally
    //   260	270	321	finally
    //   43	52	326	java/lang/Exception
    //   52	65	326	java/lang/Exception
    //   71	89	326	java/lang/Exception
    //   106	124	326	java/lang/Exception
    //   144	183	326	java/lang/Exception
    //   43	52	331	org/json/JSONException
    //   52	65	331	org/json/JSONException
    //   71	89	331	org/json/JSONException
    //   106	124	331	org/json/JSONException
    //   144	183	331	org/json/JSONException
    //   43	52	336	java/io/IOException
    //   52	65	336	java/io/IOException
    //   71	89	336	java/io/IOException
    //   106	124	336	java/io/IOException
    //   144	183	336	java/io/IOException
    //   12	39	341	android/content/pm/PackageManager$NameNotFoundException
  }

  private static ApiUtils.WeiboInfo queryWeiboInfoByFile(Context paramContext)
  {
    Intent localIntent = new Intent("com.sina.weibo.action.sdkidentity");
    localIntent.addCategory("android.intent.category.DEFAULT");
    List localList = paramContext.getPackageManager().queryIntentServices(localIntent, 0);
    if ((localList == null) || (localList.isEmpty()))
      return null;
    Iterator localIterator = localList.iterator();
    ApiUtils.WeiboInfo localWeiboInfo;
    do
    {
      ResolveInfo localResolveInfo;
      do
      {
        if (!localIterator.hasNext())
          return null;
        localResolveInfo = (ResolveInfo)localIterator.next();
      }
      while ((localResolveInfo.serviceInfo == null) || (localResolveInfo.serviceInfo.applicationInfo == null) || (localResolveInfo.serviceInfo.applicationInfo.packageName == null) || (localResolveInfo.serviceInfo.applicationInfo.packageName.length() == 0));
      localWeiboInfo = queryWeiboInfoByAsset(paramContext, localResolveInfo.serviceInfo.applicationInfo.packageName);
    }
    while (localWeiboInfo == null);
    return localWeiboInfo;
  }

  public static ApiUtils.WeiboInfo queryWeiboInfoByPackage(Context paramContext, String paramString)
  {
    ApiUtils.WeiboInfo localWeiboInfo;
    if ((paramContext == null) || (paramString == null))
      localWeiboInfo = null;
    do
    {
      do
      {
        return localWeiboInfo;
        localWeiboInfo = queryWeiboInfoByAsset(paramContext, paramString);
      }
      while (localWeiboInfo != null);
      localWeiboInfo = queryWeiboInfoByProvider(paramContext);
    }
    while ((localWeiboInfo != null) && (paramString.equals(localWeiboInfo.packageName)));
    return null;
  }

  // ERROR //
  private static ApiUtils.WeiboInfo queryWeiboInfoByProvider(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 233	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_1
    //   5: aload_1
    //   6: getstatic 35	com/sina/weibo/sdk/api/share/ApiUtils:WEIBO_NAME_URI	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 239	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 5
    //   18: aload 5
    //   20: astore_3
    //   21: aload_3
    //   22: ifnonnull +19 -> 41
    //   25: aload_3
    //   26: ifnull +9 -> 35
    //   29: aload_3
    //   30: invokeinterface 242 1 0
    //   35: aconst_null
    //   36: astore 12
    //   38: aload 12
    //   40: areturn
    //   41: aload_3
    //   42: ldc 147
    //   44: invokeinterface 246 2 0
    //   49: istore 6
    //   51: aload_3
    //   52: ldc 248
    //   54: invokeinterface 246 2 0
    //   59: istore 7
    //   61: aload_3
    //   62: invokeinterface 251 1 0
    //   67: ifeq +146 -> 213
    //   70: aload_3
    //   71: iload 6
    //   73: invokeinterface 255 2 0
    //   78: astore 8
    //   80: aload 8
    //   82: invokestatic 260	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   85: istore 13
    //   87: iload 13
    //   89: istore 10
    //   91: aload_3
    //   92: iload 7
    //   94: invokeinterface 255 2 0
    //   99: astore 11
    //   101: aload 11
    //   103: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifne +107 -> 213
    //   109: aload_0
    //   110: aload 11
    //   112: invokestatic 127	com/sina/weibo/sdk/api/share/ApiUtils:validateWeiboSign	(Landroid/content/Context;Ljava/lang/String;)Z
    //   115: ifeq +98 -> 213
    //   118: new 153	com/sina/weibo/sdk/api/share/ApiUtils$WeiboInfo
    //   121: dup
    //   122: invokespecial 154	com/sina/weibo/sdk/api/share/ApiUtils$WeiboInfo:<init>	()V
    //   125: astore 12
    //   127: aload 12
    //   129: aload 11
    //   131: putfield 157	com/sina/weibo/sdk/api/share/ApiUtils$WeiboInfo:packageName	Ljava/lang/String;
    //   134: aload 12
    //   136: iload 10
    //   138: putfield 160	com/sina/weibo/sdk/api/share/ApiUtils$WeiboInfo:supportApi	I
    //   141: aload_3
    //   142: ifnull -104 -> 38
    //   145: aload_3
    //   146: invokeinterface 242 1 0
    //   151: aload 12
    //   153: areturn
    //   154: astore 9
    //   156: aload 9
    //   158: invokevirtual 261	java/lang/NumberFormatException:printStackTrace	()V
    //   161: iconst_m1
    //   162: istore 10
    //   164: goto -73 -> 91
    //   167: astore 4
    //   169: aconst_null
    //   170: astore_3
    //   171: aload 4
    //   173: invokevirtual 262	java/lang/Exception:printStackTrace	()V
    //   176: ldc 15
    //   178: aload 4
    //   180: invokevirtual 165	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   183: invokestatic 168	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_3
    //   187: ifnull +9 -> 196
    //   190: aload_3
    //   191: invokeinterface 242 1 0
    //   196: aconst_null
    //   197: areturn
    //   198: astore_2
    //   199: aconst_null
    //   200: astore_3
    //   201: aload_3
    //   202: ifnull +9 -> 211
    //   205: aload_3
    //   206: invokeinterface 242 1 0
    //   211: aload_2
    //   212: athrow
    //   213: aload_3
    //   214: ifnull -18 -> 196
    //   217: aload_3
    //   218: invokeinterface 242 1 0
    //   223: goto -27 -> 196
    //   226: astore_2
    //   227: goto -26 -> 201
    //   230: astore 4
    //   232: goto -61 -> 171
    //
    // Exception table:
    //   from	to	target	type
    //   80	87	154	java/lang/NumberFormatException
    //   5	18	167	java/lang/Exception
    //   5	18	198	finally
    //   41	80	226	finally
    //   80	87	226	finally
    //   91	141	226	finally
    //   156	161	226	finally
    //   171	186	226	finally
    //   41	80	230	java/lang/Exception
    //   80	87	230	java/lang/Exception
    //   91	141	230	java/lang/Exception
    //   156	161	230	java/lang/Exception
  }

  public static boolean validateWeiboSign(Context paramContext, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      return containSign(localPackageInfo.signatures, "18da2bf10352443a00a5e046d9fca6bd");
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.share.ApiUtils
 * JD-Core Version:    0.6.2
 */