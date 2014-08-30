package com.xiaomi.infra.galaxy.common.auth;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.Base64Utils;
import com.xiaomi.infra.galaxy.common.util.HttpUtils;
import com.xiaomi.infra.galaxy.common.util.StringInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public abstract class AbstractGalaxySigner
  implements Signer
{
  protected static final String DEFAULT_ENCODING = "UTF-8";

  protected byte[] getBinaryRequestPayload(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    if (HttpUtils.usePayloadForQueryParameters(paramBasicGalaxyRequest))
    {
      String str = HttpUtils.encodeParameters(paramBasicGalaxyRequest);
      if (str == null)
        return new byte[0];
      try
      {
        byte[] arrayOfByte = str.getBytes("UTF-8");
        return arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to encode string into bytes");
      }
    }
    return getBinaryRequestPayloadWithoutQueryParams(paramBasicGalaxyRequest);
  }

  protected InputStream getBinaryRequestPayloadStream(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    if (HttpUtils.usePayloadForQueryParameters(paramBasicGalaxyRequest))
    {
      String str = HttpUtils.encodeParameters(paramBasicGalaxyRequest);
      if (str == null)
        return new ByteArrayInputStream(new byte[0]);
      try
      {
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
        return localByteArrayInputStream;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to encode string into bytes");
      }
    }
    return getBinaryRequestPayloadStreamWithoutQueryParams(paramBasicGalaxyRequest);
  }

  protected InputStream getBinaryRequestPayloadStreamWithoutQueryParams(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    try
    {
      localObject = paramBasicGalaxyRequest.getContent();
      if (localObject == null)
        return new ByteArrayInputStream(new byte[0]);
      if ((localObject instanceof StringInputStream))
        break label88;
      if (!((InputStream)localObject).markSupported())
        throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to read request payload to sign request.");
    }
    catch (Exception localException)
    {
      throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to read request payload to sign request: " + localException.getMessage(), localException);
    }
    InputStream localInputStream = paramBasicGalaxyRequest.getContent();
    Object localObject = localInputStream;
    label88: return localObject;
  }

  protected byte[] getBinaryRequestPayloadWithoutQueryParams(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    InputStream localInputStream = getBinaryRequestPayloadStreamWithoutQueryParams(paramBasicGalaxyRequest);
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      localInputStream.mark(-1);
      localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte1 = new byte[5120];
      while (true)
      {
        int i = localInputStream.read(arrayOfByte1);
        if (i == -1)
          break;
        localByteArrayOutputStream.write(arrayOfByte1, 0, i);
      }
    }
    catch (Exception localException)
    {
      throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to read request payload to sign request: " + localException.getMessage(), localException);
    }
    localByteArrayOutputStream.close();
    localInputStream.reset();
    byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
    return arrayOfByte2;
  }

  protected String getCanonicalizedEndpoint(URI paramURI)
  {
    String str = paramURI.getHost().toLowerCase();
    if (HttpUtils.isUsingNonDefaultPort(paramURI))
      str = str + ":" + paramURI.getPort();
    return str;
  }

  protected String getCanonicalizedQueryString(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    if (HttpUtils.usePayloadForQueryParameters(paramBasicGalaxyRequest))
      return "";
    return getCanonicalizedQueryString(paramBasicGalaxyRequest.getParameters());
  }

  protected String getCanonicalizedQueryString(Map<String, String> paramMap)
  {
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
      String str1 = (String)localEntry2.getKey();
      String str2 = (String)localEntry2.getValue();
      localTreeMap.put(HttpUtils.urlEncode(str1, false), HttpUtils.urlEncode(str2, false));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator2 = localTreeMap.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
      localStringBuilder.append((String)localEntry1.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry1.getValue());
      if (localIterator2.hasNext())
        localStringBuilder.append("&");
    }
    return localStringBuilder.toString();
  }

  protected String getCanonicalizedResourcePath(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() == 0))
      str = "/";
    do
    {
      return str;
      str = HttpUtils.urlEncode(paramString, true);
    }
    while (str.startsWith("/"));
    return "/".concat(str);
  }

  protected String getRequestPayload(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    return newString(getBinaryRequestPayload(paramBasicGalaxyRequest));
  }

  protected String getRequestPayloadWithoutQueryParams(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    return newString(getBinaryRequestPayloadWithoutQueryParams(paramBasicGalaxyRequest));
  }

  protected byte[] hash(InputStream paramInputStream)
  {
    try
    {
      DigestInputStream localDigestInputStream = new DigestInputStream(paramInputStream, MessageDigest.getInstance("SHA-256"));
      byte[] arrayOfByte1 = new byte[1024];
      while (localDigestInputStream.read(arrayOfByte1) >= 0);
      byte[] arrayOfByte2 = localDigestInputStream.getMessageDigest().digest();
      return arrayOfByte2;
    }
    catch (Exception localException)
    {
      throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to compute hash while signing request: " + localException.getMessage(), localException);
    }
  }

  public byte[] hash(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      byte[] arrayOfByte = localMessageDigest.digest();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to compute hash while signing request: " + localException.getMessage(), localException);
    }
  }

  public byte[] hash(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramArrayOfByte);
      byte[] arrayOfByte = localMessageDigest.digest();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to compute hash while signing request: " + localException.getMessage(), localException);
    }
  }

  protected String newString(byte[] paramArrayOfByte)
  {
    try
    {
      String str = new String(paramArrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to encode bytes to String", localUnsupportedEncodingException);
    }
  }

  protected GalaxyCredentials sanitizeCredentials(GalaxyCredentials paramGalaxyCredentials)
  {
    try
    {
      String str1 = paramGalaxyCredentials.getGalaxyAppId();
      String str2 = paramGalaxyCredentials.getGalaxySecretKey();
      if (str2 != null)
        str2 = str2.trim();
      if (str1 != null)
        str1 = str1.trim();
      return new BasicGalaxyCredentials(str1, str2);
    }
    finally
    {
    }
  }

  public byte[] sign(String paramString, byte[] paramArrayOfByte, SigningAlgorithm paramSigningAlgorithm)
  {
    try
    {
      byte[] arrayOfByte = sign(paramString.getBytes("UTF-8"), paramArrayOfByte, paramSigningAlgorithm);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to calculate a request signature: " + localException.getMessage(), localException);
    }
  }

  protected byte[] sign(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, SigningAlgorithm paramSigningAlgorithm)
  {
    try
    {
      Mac localMac = Mac.getInstance(paramSigningAlgorithm.toString());
      localMac.init(new SecretKeySpec(paramArrayOfByte2, paramSigningAlgorithm.toString()));
      byte[] arrayOfByte = localMac.doFinal(paramArrayOfByte1);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to calculate a request signature: " + localException.getMessage(), localException);
    }
  }

  protected String signAndBase64Encode(String paramString1, String paramString2, SigningAlgorithm paramSigningAlgorithm)
  {
    try
    {
      String str = signAndBase64Encode(paramString1.getBytes("UTF-8"), paramString2, paramSigningAlgorithm);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to calculate a request signature: " + localUnsupportedEncodingException.getMessage(), localUnsupportedEncodingException);
    }
  }

  protected String signAndBase64Encode(byte[] paramArrayOfByte, String paramString, SigningAlgorithm paramSigningAlgorithm)
  {
    try
    {
      String str = new String(Base64Utils.encode(sign(paramArrayOfByte, paramString.getBytes("UTF-8"), paramSigningAlgorithm)));
      return str;
    }
    catch (Exception localException)
    {
      throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to calculate a request signature: " + localException.getMessage(), localException);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.auth.AbstractGalaxySigner
 * JD-Core Version:    0.6.2
 */