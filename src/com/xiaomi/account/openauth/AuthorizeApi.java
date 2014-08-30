package com.xiaomi.account.openauth;

import android.content.Context;
import com.xiaomi.account.openauth.utils.Network;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class AuthorizeApi
{
  private static final String a = "UTF-8";
  private static String b = "GET";
  private static String c = "POST";
  private static String d = "open.account.xiaomi.com";
  private static String e = "https://";

  public static String doHttpGet(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("clientId", String.valueOf(paramLong)));
    localArrayList.add(new BasicNameValuePair("token", paramString2));
    String str1 = AuthorizeHelper.generateNonce();
    try
    {
      String str2 = AuthorizeHelper.getMacAccessTokenSignatureString(str1, b, d, paramString1, URLEncodedUtils.format(localArrayList, "UTF-8"), paramString3, paramString4);
      String str3 = Network.downloadXml(paramContext, new URL(AuthorizeHelper.generateUrl(e + d + paramString1, localArrayList)), null, null, AuthorizeHelper.buildMacRequestHead(paramString2, str1, str2), null);
      return str3;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      throw new XMAuthericationException(localInvalidKeyException);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new XMAuthericationException(localNoSuchAlgorithmException);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new XMAuthericationException(localUnsupportedEncodingException);
    }
    catch (IOException localIOException)
    {
      throw new XMAuthericationException(localIOException);
    }
  }

  public static String doHttpPost(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("clientId", String.valueOf(paramLong)));
    localArrayList.add(new BasicNameValuePair("token", paramString2));
    String str1 = AuthorizeHelper.generateNonce();
    try
    {
      String str2 = AuthorizeHelper.getMacAccessTokenSignatureString(str1, c, d, paramString1, URLEncodedUtils.format(localArrayList, "UTF-8"), paramString3, paramString4);
      String str3 = Network.doHttpPost(paramContext, e + d + paramString1, localArrayList, AuthorizeHelper.buildMacRequestHead(paramString2, str1, str2), null, null, null);
      return str3;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      throw new XMAuthericationException(localInvalidKeyException);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new XMAuthericationException(localNoSuchAlgorithmException);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new XMAuthericationException(localUnsupportedEncodingException);
    }
    catch (IOException localIOException)
    {
      throw new XMAuthericationException(localIOException);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.account.openauth.AuthorizeApi
 * JD-Core Version:    0.6.2
 */