package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboParameters;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility
{
  private static final String DEFAULT_CHARSET = "UTF-8";
  private static final byte[] decodes = new byte[256];
  private static final char[] encodes = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

  private static boolean __createNewFile(File paramFile)
  {
    if (paramFile == null)
      return false;
    makesureParentExist(paramFile);
    if (paramFile.exists())
      delete(paramFile);
    try
    {
      boolean bool = paramFile.createNewFile();
      return bool;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return false;
  }

  private static void createNewFile(File paramFile)
  {
    if (paramFile == null);
    while (__createNewFile(paramFile))
      return;
    throw new RuntimeException(paramFile.getAbsolutePath() + " doesn't be created!");
  }

  public static byte[] decodeBase62(String paramString)
  {
    int i = 0;
    if (paramString == null)
      return null;
    char[] arrayOfChar = paramString.toCharArray();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramString.toCharArray().length);
    int j = 0;
    int k = 0;
    if (i >= arrayOfChar.length)
      return localByteArrayOutputStream.toByteArray();
    int m = arrayOfChar[i];
    int n;
    int i2;
    int i1;
    if (m == 105)
    {
      n = i + 1;
      i2 = arrayOfChar[n];
      if (i2 == 97)
        i1 = 105;
    }
    while (true)
    {
      label77: j = j << 6 | decodes[i1];
      k += 6;
      while (true)
      {
        if (k <= 7)
        {
          i = n + 1;
          break;
          if (i2 == 98)
          {
            i1 = 43;
            break label77;
          }
          if (i2 == 99)
          {
            i1 = 47;
            break label77;
          }
          n--;
          i1 = arrayOfChar[n];
          break label77;
        }
        k -= 8;
        localByteArrayOutputStream.write(j >> k);
        j &= -1 + (1 << k);
      }
      n = i;
      i1 = m;
    }
  }

  public static Bundle decodeUrl(String paramString)
  {
    Bundle localBundle = new Bundle();
    String[] arrayOfString1;
    int i;
    int j;
    if (paramString != null)
    {
      arrayOfString1 = paramString.split("&");
      i = arrayOfString1.length;
      j = 0;
    }
    while (true)
    {
      if (j >= i)
        return localBundle;
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      try
      {
        localBundle.putString(URLDecoder.decode(arrayOfString2[0], "UTF-8"), URLDecoder.decode(arrayOfString2[1], "UTF-8"));
        j++;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        while (true)
          localUnsupportedEncodingException.printStackTrace();
      }
    }
  }

  private static void delete(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()) && (!paramFile.delete()))
      throw new RuntimeException(paramFile.getAbsolutePath() + " doesn't be deleted!");
  }

  private static boolean deleteDependon(File paramFile, int paramInt)
  {
    int i = 1;
    if (paramInt <= 0)
      paramInt = 5;
    boolean bool = false;
    if (paramFile != null);
    while (true)
    {
      if ((bool) || (i > paramInt) || (!paramFile.isFile()) || (!paramFile.exists()))
        return bool;
      bool = paramFile.delete();
      if (!bool)
        i++;
    }
  }

  private static boolean deleteDependon(String paramString)
  {
    return deleteDependon(paramString, 0);
  }

  private static boolean deleteDependon(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    return deleteDependon(new File(paramString), paramInt);
  }

  private static boolean doesExisted(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists());
  }

  private static boolean doesExisted(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    return doesExisted(new File(paramString));
  }

  public static String encodeBase62(byte[] paramArrayOfByte)
  {
    int i = 0;
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length << 1);
    int j = 0;
    int k = 0;
    char c2;
    Object localObject2;
    if (i >= paramArrayOfByte.length)
      if (k > 0)
      {
        c2 = encodes[(j << 6 - k)];
        if (c2 != 'i')
          break label187;
        localObject2 = "ia";
      }
    while (true)
    {
      localStringBuffer.append(localObject2);
      return localStringBuffer.toString();
      j = j << 8 | 0xFF & paramArrayOfByte[i];
      k += 8;
      if (k <= 5)
      {
        i++;
        break;
      }
      char[] arrayOfChar = encodes;
      int m = k - 6;
      char c1 = arrayOfChar[(j >> m)];
      Object localObject1;
      if (c1 == 'i')
        localObject1 = "ia";
      while (true)
      {
        localStringBuffer.append(localObject1);
        j &= -1 + (1 << m);
        k = m;
        break;
        if (c1 == '+')
          localObject1 = "ib";
        else if (c1 == '/')
          localObject1 = "ic";
        else
          localObject1 = Character.valueOf(c1);
      }
      label187: if (c2 == '+')
        localObject2 = "ib";
      else if (c2 == '/')
        localObject2 = "ic";
      else
        localObject2 = Character.valueOf(c2);
    }
  }

  public static String encodeParameters(WeiboParameters paramWeiboParameters)
  {
    int i = 0;
    if ((paramWeiboParameters == null) || (isBundleEmpty(paramWeiboParameters)))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    while (true)
    {
      if (i >= paramWeiboParameters.size())
        return localStringBuilder.toString();
      String str = paramWeiboParameters.getKey(i);
      if (j != 0)
        localStringBuilder.append("&");
      try
      {
        localStringBuilder.append(URLEncoder.encode(str, "UTF-8")).append("=").append(URLEncoder.encode(paramWeiboParameters.getValue(str), "UTF-8"));
        label88: j++;
        i++;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label88;
      }
    }
  }

  public static String encodeUrl(WeiboParameters paramWeiboParameters)
  {
    if (paramWeiboParameters == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    int j = 0;
    if (j >= paramWeiboParameters.size())
      return localStringBuilder.toString();
    if (i != 0)
    {
      i = 0;
      label38: String str = paramWeiboParameters.getKey(j);
      if (paramWeiboParameters.getValue(str) != null)
        break label106;
      LogUtil.i("encodeUrl", "key:" + str + " 's value is null");
    }
    while (true)
    {
      LogUtil.i("encodeUrl", localStringBuilder.toString());
      j++;
      break;
      localStringBuilder.append("&");
      break label38;
      try
      {
        label106: localStringBuilder.append(URLEncoder.encode(paramWeiboParameters.getKey(j), "UTF-8") + "=" + URLEncoder.encode(paramWeiboParameters.getValue(j), "UTF-8"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }

  public static Bundle errorSAX(String paramString)
  {
    Bundle localBundle = new Bundle();
    if ((paramString != null) && (paramString.indexOf("{") >= 0));
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localBundle.putString("error", localJSONObject.optString("error"));
      localBundle.putString("error_code", localJSONObject.optString("error_code"));
      localBundle.putString("error_description", localJSONObject.optString("error_description"));
      return localBundle;
    }
    catch (JSONException localJSONException)
    {
      localBundle.putString("error", "JSONExceptionerror");
    }
    return localBundle;
  }

  public static Bundle formBundle(Oauth2AccessToken paramOauth2AccessToken)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("access_token", paramOauth2AccessToken.getToken());
    localBundle.putString("refresh_token", paramOauth2AccessToken.getRefreshToken());
    localBundle.putString("expires_in", paramOauth2AccessToken.getExpiresTime());
    return localBundle;
  }

  public static Bundle formErrorBundle(Exception paramException)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("error", paramException.getMessage());
    return localBundle;
  }

  public static String generateGUID()
  {
    return UUID.randomUUID().toString().replace("-", "");
  }

  public static String getSign(Context paramContext, String paramString)
  {
    while (true)
    {
      PackageInfo localPackageInfo;
      int i;
      try
      {
        localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 64);
        i = 0;
        if (i >= localPackageInfo.signatures.length)
          return null;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        return null;
      }
      byte[] arrayOfByte = localPackageInfo.signatures[i].toByteArray();
      if (arrayOfByte != null)
        return MD5.hexdigest(arrayOfByte);
      i++;
    }
  }

  private static boolean isBundleEmpty(WeiboParameters paramWeiboParameters)
  {
    return (paramWeiboParameters == null) || (paramWeiboParameters.size() == 0);
  }

  public static boolean isChineseLocale(Context paramContext)
  {
    try
    {
      Locale localLocale = paramContext.getResources().getConfiguration().locale;
      boolean bool;
      if ((!Locale.CHINA.equals(localLocale)) && (!Locale.CHINESE.equals(localLocale)) && (!Locale.SIMPLIFIED_CHINESE.equals(localLocale)))
        bool = Locale.TAIWAN.equals(localLocale);
      return bool;
    }
    catch (Exception localException)
    {
    }
    return true;
  }

  public static boolean isWifi(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.getType() == 1);
  }

  private static void makesureFileExist(File paramFile)
  {
    if (paramFile == null);
    while (paramFile.exists())
      return;
    makesureParentExist(paramFile);
    createNewFile(paramFile);
  }

  private static void makesureFileExist(String paramString)
  {
    if (paramString == null)
      return;
    makesureFileExist(new File(paramString));
  }

  private static void makesureParentExist(File paramFile)
  {
    if (paramFile == null);
    File localFile;
    do
    {
      return;
      localFile = paramFile.getParentFile();
    }
    while ((localFile == null) || (localFile.exists()));
    mkdirs(localFile);
  }

  private static void mkdirs(File paramFile)
  {
    if (paramFile == null);
    while ((paramFile.exists()) || (paramFile.mkdirs()))
      return;
    throw new RuntimeException("fail to make " + paramFile.getAbsolutePath());
  }

  public static String packUrl(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramHashMap.keySet().iterator();
    int i = 1;
    String str1;
    String str2;
    do
    {
      if (!localIterator.hasNext())
        return localStringBuilder.toString();
      str1 = (String)localIterator.next();
      str2 = (String)paramHashMap.get(str1);
    }
    while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
    if (i != 0)
      i = 0;
    while (true)
    {
      try
      {
        localStringBuilder.append(URLEncoder.encode(str1, "UTF-8")).append("=").append(URLEncoder.encode(str2, "UTF-8"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        int j = i;
        localUnsupportedEncodingException.printStackTrace();
        i = j;
      }
      break;
      localStringBuilder.append("&");
    }
  }

  public static Bundle parseUrl(String paramString)
  {
    try
    {
      URL localURL = new URL(paramString);
      Bundle localBundle = decodeUrl(localURL.getQuery());
      localBundle.putAll(decodeUrl(localURL.getRef()));
      return localBundle;
    }
    catch (MalformedURLException localMalformedURLException)
    {
    }
    return new Bundle();
  }

  public static void showToast(String paramString, Context paramContext)
  {
    Toast.makeText(paramContext, paramString, 1).show();
  }

  public static Bundle unpackUrl(String paramString)
  {
    Bundle localBundle = new Bundle();
    String[] arrayOfString1;
    int i;
    int j;
    if (paramString != null)
    {
      arrayOfString1 = paramString.split("&");
      i = arrayOfString1.length;
      j = 0;
    }
    while (true)
    {
      if (j >= i)
        return localBundle;
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      try
      {
        localBundle.putString(URLDecoder.decode(arrayOfString2[0], "UTF-8"), URLDecoder.decode(arrayOfString2[1], "UTF-8"));
        j++;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        while (true)
          localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.utils.Utility
 * JD-Core Version:    0.6.2
 */