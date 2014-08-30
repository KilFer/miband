package com.xiaomi.account.openauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.account.openauth.utils.Base64Coder;
import com.xiaomi.account.openauth.utils.Network;
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
  protected static final String ACTION_AUTH_ACTIVITY = "com.xiaomi.account.openauth.action.AUTH";
  protected static final String AUTHORIZATION_CODE = "authorization_code";
  public static String AUTH_ACTIVITY_NAME = "com.xiaomi.account.openauth.AuthorizeActivity";
  protected static final String HEADER_FLAG = "&&&START&&&";
  public static final String OAUTH2_HOST = "https://account.xiaomi.com";
  protected static final String REFRESH_TOKEN = "refresh_token";
  protected static final String TOKEN_PATH = "https://account.xiaomi.com/oauth2/token";
  private static final String a = "HmacSHA1";
  private static final String b = "UTF-8";
  private static Random c = new Random();

  private static Intent a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, AuthorizeActivity.class);
    return localIntent;
  }

  protected static HashMap<String, String> buildMacRequestHead(String paramString1, String paramString2, String paramString3)
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

  protected static String encodeSign(byte[] paramArrayOfByte)
  {
    return new String(Base64Coder.encode(paramArrayOfByte));
  }

  protected static byte[] encryptHMACSha1(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte2, "HmacSHA1");
    Mac localMac = Mac.getInstance("HmacSHA1");
    localMac.init(localSecretKeySpec);
    localMac.update(paramArrayOfByte1);
    return localMac.doFinal();
  }

  protected static String generateNonce()
  {
    long l = c.nextLong();
    int i = (int)(System.currentTimeMillis() / 60000L);
    return l + ":" + i;
  }

  protected static String generateUrl(String paramString, List<NameValuePair> paramList)
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

  protected static String getAccessTokenByAuthorizationCode(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3)
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

  protected static String getAccessTokenByRefreshToken(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
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

  protected static String getMacAccessTokenSignatureString(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
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
        Collections.sort(localArrayList, new b());
        localStringBuffer.append(URLEncodedUtils.format(localArrayList, "UTF-8"));
        localStringBuilder.append(localStringBuffer.toString() + "\n");
      }
      return encodeSign(encryptHMACSha1(localStringBuilder.toString().getBytes("UTF-8"), paramString6.getBytes("UTF-8")));
    }
    throw new NoSuchAlgorithmException("error mac algorithm : " + paramString7);
  }

  protected static void startAuthorizeActivityForResult(Activity paramActivity, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("client id is error!!!");
    if (TextUtils.isEmpty(paramString1))
      throw new IllegalArgumentException("redirect url is empty!!!");
    if (TextUtils.isEmpty(paramString2))
      throw new IllegalArgumentException("responseType is empty!!!");
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, AuthorizeActivity.class);
    localIntent.setPackage(paramActivity.getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putString("client_id", String.valueOf(paramLong));
    localBundle.putString("redirect_uri", paramString1);
    localBundle.putString("response_type", paramString2);
    localBundle.putString("scope", paramString3);
    localBundle.putString("state", paramString4);
    localIntent.putExtra("url_param", localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.account.openauth.AuthorizeHelper
 * JD-Core Version:    0.6.2
 */