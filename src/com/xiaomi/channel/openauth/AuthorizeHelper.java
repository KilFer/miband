package com.xiaomi.channel.openauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.text.TextUtils;
import com.xiaomi.channel.openauth.utils.Base64Coder;
import com.xiaomi.channel.openauth.utils.Network;
import java.net.URL;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class AuthorizeHelper
{
  public static final String ACTION_AUTH_ACTIVITY = "com.xiaomi.openauth.action.AUTH";
  public static final String AUTHORIZATION_CODE = "authorization_code";
  public static String AUTH_ACTIVITY_NAME = "com.xiaomi.channel.openauth.AuthorizeActivity";
  public static final String HEADER_FLAG = "&&&START&&&";
  public static final String OAUTH2_HOST = "https://account.xiaomi.com";
  public static final String REFRESH_TOKEN = "refresh_token";
  public static int REQUESTCODE_CODE = 0;
  public static int REQUESTCODE_TOKEN = 0;
  public static final String TOKEN_PATH = "https://account.xiaomi.com/oauth2/token";
  public static final String TYPE_CODE = "code";
  public static final String TYPE_TOKEN = "token";
  private static final String a = "HmacSHA1";
  private static final String b = "UTF-8";
  private static Random c = new Random();

  private static void a(Activity paramActivity, int paramInt, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("client id is error!!!");
    if (TextUtils.isEmpty(paramString1))
      throw new IllegalArgumentException("redirect url is empty!!!");
    if (TextUtils.isEmpty(paramString2))
      throw new IllegalArgumentException("responseType is empty!!!");
    IntentFilter localIntentFilter = new IntentFilter(APP2SDKReceiver.AUTH_ACTION_NAME);
    APP2SDKReceiver localAPP2SDKReceiver = new APP2SDKReceiver();
    paramActivity.registerReceiver(localAPP2SDKReceiver, localIntentFilter);
    Intent localIntent = new Intent(SDK2APPReceiver.AUTH_ACTION_NAME);
    if (!TextUtils.isEmpty(paramString5))
      localIntent.putExtra("user_id", paramString5);
    paramActivity.sendBroadcast(localIntent);
    new Handler().postDelayed(new b(paramActivity, localAPP2SDKReceiver, paramLong, paramString1, paramString2, paramString3, paramString4, paramInt), 100L);
  }

  private static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(SDK2APPReceiver.AUTH_ACTION_NAME);
    if (!TextUtils.isEmpty(paramString))
      localIntent.putExtra("user_id", paramString);
    paramActivity.sendBroadcast(localIntent);
  }

  private static boolean a(Context paramContext, Intent paramIntent)
  {
    return paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0;
  }

  private static Intent b(Context paramContext)
  {
    Iterator localIterator = APP2SDKReceiver.availableApp.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        Intent localIntent1 = new Intent();
        localIntent1.setClass(paramContext, AuthorizeActivity.class);
        return localIntent1;
      }
      String str = (String)localIterator.next();
      if (!TextUtils.isEmpty(str))
      {
        Intent localIntent2 = new Intent();
        localIntent2.setComponent(new ComponentName(str, AUTH_ACTIVITY_NAME));
        PackageManager localPackageManager = paramContext.getPackageManager();
        if ("com.xiaomi.channel".equals(str));
        try
        {
          int j = localPackageManager.getPackageInfo(str, 0).versionCode;
          if (j > 860)
          {
            if (paramContext.getPackageManager().queryIntentActivities(localIntent2, 65536).size() > 0);
            for (int i = 1; i != 0; i = 0)
              return localIntent2;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
        }
      }
    }
  }

  private static void b()
  {
    APP2SDKReceiver.availableApp.clear();
  }

  public static HashMap<String, String> buildMacRequestHead(String paramString1, String paramString2, String paramString3)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = URLEncoder.encode(paramString1, "UTF-8");
    arrayOfObject[1] = URLEncoder.encode(paramString2, "UTF-8");
    arrayOfObject[2] = URLEncoder.encode(paramString3, "UTF-8");
    String str = String.format("MAC access_token=\"%s\", nonce=\"%s\",mac=\"%s\"", arrayOfObject);
    HashMap localHashMap = new HashMap();
    localHashMap.put("Authorization", str);
    return localHashMap;
  }

  public static String encodeSign(byte[] paramArrayOfByte)
  {
    return new String(Base64Coder.encode(paramArrayOfByte));
  }

  public static byte[] encryptHMACSha1(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte2, "HmacSHA1");
    Mac localMac = Mac.getInstance("HmacSHA1");
    localMac.init(localSecretKeySpec);
    localMac.update(paramArrayOfByte1);
    return localMac.doFinal();
  }

  public static String generateNonce()
  {
    long l = c.nextLong();
    int i = (int)(System.currentTimeMillis() / 60000L);
    return l + ":" + i;
  }

  public static String generateUrl(String paramString, List<NameValuePair> paramList)
  {
    Uri.Builder localBuilder;
    Iterator localIterator;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localBuilder = Uri.parse(paramString).buildUpon();
      localIterator = paramList.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        paramString = localBuilder.build().toString();
        return paramString;
      }
      NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
      localBuilder.appendQueryParameter(localNameValuePair.getName(), localNameValuePair.getValue());
    }
  }

  public static String getAccessTokenByAuthorizationCode(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("client_id", String.valueOf(paramLong)));
    localArrayList.add(new BasicNameValuePair("grant_type", "authorization_code"));
    localArrayList.add(new BasicNameValuePair("client_secret", paramString2));
    localArrayList.add(new BasicNameValuePair("token_type", "mac"));
    localArrayList.add(new BasicNameValuePair("redirect_uri", paramString3));
    localArrayList.add(new BasicNameValuePair("code", paramString1));
    String str = Network.downloadXml(paramContext, new URL(generateUrl("https://account.xiaomi.com/oauth2/token", localArrayList)));
    if (!TextUtils.isEmpty(str))
      str = str.replace("&&&START&&&", "");
    return str;
  }

  public static String getAccessTokenByRefreshToken(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("client_id", String.valueOf(paramLong)));
    localArrayList.add(new BasicNameValuePair("grant_type", "refresh_token"));
    localArrayList.add(new BasicNameValuePair("client_secret", paramString2));
    localArrayList.add(new BasicNameValuePair("token_type", "mac"));
    localArrayList.add(new BasicNameValuePair("redirect_uri", paramString3));
    localArrayList.add(new BasicNameValuePair("refresh_token", paramString1));
    localArrayList.add(new BasicNameValuePair("token_type", paramString4));
    localArrayList.add(new BasicNameValuePair("mac_key", paramString5));
    localArrayList.add(new BasicNameValuePair("mac_algorithm", paramString6));
    String str = Network.downloadXml(paramContext, new URL(generateUrl("https://account.xiaomi.com/oauth2/token", localArrayList)));
    if (!TextUtils.isEmpty(str))
      str = str.replace("&&&START&&&", "");
    return str;
  }

  public static String getMacAccessTokenSignatureString(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if ("HmacSHA1".equalsIgnoreCase(paramString7))
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      localStringBuilder.append(paramString1 + "\n");
      localStringBuilder.append(paramString2.toUpperCase() + "\n");
      localStringBuilder.append(paramString3 + "\n");
      localStringBuilder.append(paramString4 + "\n");
      if (!TextUtils.isEmpty(paramString5))
      {
        StringBuffer localStringBuffer = new StringBuffer();
        ArrayList localArrayList = new ArrayList();
        URLEncodedUtils.parse(localArrayList, new Scanner(paramString5), "UTF-8");
        Collections.sort(localArrayList, new c());
        localStringBuffer.append(URLEncodedUtils.format(localArrayList, "UTF-8"));
        localStringBuilder.append(localStringBuffer.toString() + "\n");
      }
      return encodeSign(encryptHMACSha1(localStringBuilder.toString().getBytes("UTF-8"), paramString6.getBytes("UTF-8")));
    }
    throw new NoSuchAlgorithmException("error mac algorithm : " + paramString7);
  }

  public static void startAuthorizeActivityForResultByCodeType(Activity paramActivity, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, REQUESTCODE_CODE, paramLong, paramString1, "code", paramString2, paramString3, null);
  }

  public static void startAuthorizeActivityForResultByCodeType(Activity paramActivity, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramActivity, REQUESTCODE_CODE, paramLong, paramString1, "code", paramString2, paramString3, paramString4);
  }

  public static void startAuthorizeActivityForResultByTokenType(Activity paramActivity, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, REQUESTCODE_TOKEN, paramLong, paramString1, "token", paramString2, paramString3, null);
  }

  public static void startAuthorizeActivityForResultByTokenType(Activity paramActivity, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramActivity, REQUESTCODE_TOKEN, paramLong, paramString1, "token", paramString2, paramString3, paramString4);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.openauth.AuthorizeHelper
 * JD-Core Version:    0.6.2
 */