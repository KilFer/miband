package com.xiaomi.infra.galaxy.common.auth;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.HttpMethodName;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.BinaryUtils;
import com.xiaomi.infra.galaxy.common.util.HttpUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Galaxy4Signer extends AbstractGalaxySigner
{
  protected static final String ALGORITHM = "Galaxy-HMAC-SHA256";
  protected static final String TERMINATOR = "galaxy_request";
  protected static final Log log = LogFactory.getLog(Galaxy4Signer.class);
  protected ThreadLocal<SimpleDateFormat> dateStampFormat = new Galaxy4Signer.2(this);
  protected ThreadLocal<SimpleDateFormat> dateTimeFormat = new Galaxy4Signer.1(this);
  protected Date overriddenDate;
  protected String serviceName;

  protected void addHostHeader(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    String str = paramBasicGalaxyRequest.getEndpoint().getHost();
    if (HttpUtils.isUsingNonDefaultPort(paramBasicGalaxyRequest.getEndpoint()))
      str = str + ":" + paramBasicGalaxyRequest.getEndpoint().getPort();
    paramBasicGalaxyRequest.addHeader("Host", str);
  }

  protected String calculateContentHash(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    InputStream localInputStream = getBinaryRequestPayloadStream(paramBasicGalaxyRequest);
    localInputStream.mark(-1);
    String str = BinaryUtils.toHex(hash(localInputStream));
    try
    {
      localInputStream.reset();
      return str;
    }
    catch (IOException localIOException)
    {
      throw new GalaxyClientException(ReturnCode.SIGNATURE_FAILED, "Unable to reset stream after calculating galaxy signature", localIOException);
    }
  }

  protected Galaxy4Signer.HeaderSigningResult computeSignature(BasicGalaxyRequest paramBasicGalaxyRequest, Date paramDate, String paramString1, String paramString2, GalaxyCredentials paramGalaxyCredentials)
  {
    String str1 = getDateTimeStamp(paramDate);
    String str2 = getDateStamp(paramDate);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(str2).append("/").append("Galaxy").append("/galaxy_request");
    StringBuilder localStringBuilder2 = getStringToSign(paramString1, str1, localStringBuilder1, getCanonicalRequest(paramBasicGalaxyRequest, paramString2));
    StringBuilder localStringBuilder3 = new StringBuilder();
    localStringBuilder3.append("Galaxy").append(paramGalaxyCredentials.getGalaxySecretKey());
    byte[] arrayOfByte1 = sign("galaxy_request", sign("Galaxy", sign(str2, localStringBuilder3.toString().getBytes(), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256);
    byte[] arrayOfByte2 = sign(localStringBuilder2.toString().getBytes(), arrayOfByte1, SigningAlgorithm.HmacSHA256);
    return new Galaxy4Signer.HeaderSigningResult(this, str1, localStringBuilder1.toString(), arrayOfByte1, arrayOfByte2);
  }

  protected StringBuilder getCanonicalRequest(BasicGalaxyRequest paramBasicGalaxyRequest, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBasicGalaxyRequest.getHttpMethod().toString()).append("\n").append(getCanonicalizedResourcePath(paramBasicGalaxyRequest.getResourcePath())).append("\n").append(getCanonicalizedQueryString(paramBasicGalaxyRequest)).append("\n").append(getCanonicalizedHeaderString(paramBasicGalaxyRequest)).append("\n").append(getSignedHeadersString(paramBasicGalaxyRequest)).append("\n").append(paramString);
    if (log.isDebugEnabled())
      log.debug("Galaxy Canonical Request: '\"" + localStringBuilder + "\"");
    return localStringBuilder;
  }

  protected String getCanonicalizedHeaderString(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramBasicGalaxyRequest.getHeaders().keySet());
    Collections.sort(localArrayList, String.CASE_INSENSITIVE_ORDER);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str.toLowerCase().replaceAll("\\s+", " ") + ":" + ((String)paramBasicGalaxyRequest.getHeaders().get(str)).replaceAll("\\s+", " "));
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }

  protected String getDateStamp(Date paramDate)
  {
    return ((SimpleDateFormat)this.dateStampFormat.get()).format(paramDate);
  }

  protected String getDateTimeStamp(Date paramDate)
  {
    return ((SimpleDateFormat)this.dateTimeFormat.get()).format(paramDate);
  }

  protected StringBuilder getScope(BasicGalaxyRequest paramBasicGalaxyRequest, Date paramDate)
  {
    String str = getDateStamp(paramDate);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str).append("/").append(this.serviceName).append("/galaxy_request");
    return localStringBuilder;
  }

  protected StringBuilder getSignedHeadersString(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramBasicGalaxyRequest.getHeaders().keySet());
    Collections.sort(localArrayList, String.CASE_INSENSITIVE_ORDER);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(";");
      localStringBuilder.append(str.toLowerCase());
    }
    return localStringBuilder;
  }

  protected StringBuilder getStringToSign(String paramString1, String paramString2, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("\n").append(paramString2).append("\n").append(paramCharSequence1).append("\n").append(BinaryUtils.toHex(hash(paramCharSequence2.toString())));
    if (log.isDebugEnabled())
      log.debug("Galaxy String to Sign: '\"" + localStringBuilder + "\"");
    return localStringBuilder;
  }

  void overrideDate(Date paramDate)
  {
    this.overriddenDate = paramDate;
  }

  protected void processRequestPayload(BasicGalaxyRequest paramBasicGalaxyRequest, Galaxy4Signer.HeaderSigningResult paramHeaderSigningResult)
  {
  }

  public void setServiceName(String paramString)
  {
    this.serviceName = paramString;
  }

  public void sign(BasicGalaxyRequest paramBasicGalaxyRequest, GalaxyCredentials paramGalaxyCredentials)
  {
    if ((paramGalaxyCredentials instanceof AnonymousGalaxyCredentials))
    {
      paramBasicGalaxyRequest.addHeader("X-XiaoMi-Access-Method", "anonymous");
      return;
    }
    if ((paramGalaxyCredentials instanceof AppSecretCredentials))
    {
      paramBasicGalaxyRequest.addHeader("X-XiaoMi-Access-Method", "appsecrettoken");
      paramBasicGalaxyRequest.addHeader("X-XiaoMi-Token", paramGalaxyCredentials.getGalaxySecretKey());
    }
    GalaxyCredentials localGalaxyCredentials = sanitizeCredentials(paramGalaxyCredentials);
    if ((paramGalaxyCredentials instanceof SessionCredentials))
      paramBasicGalaxyRequest.addHeader("X-XiaoMi-Token", paramGalaxyCredentials.getGalaxySecretKey());
    addHostHeader(paramBasicGalaxyRequest);
    Date localDate = new Date();
    StringBuilder localStringBuilder1 = getScope(paramBasicGalaxyRequest, localDate);
    String str = calculateContentHash(paramBasicGalaxyRequest);
    paramBasicGalaxyRequest.addHeader("X-XiaoMi-Date", getDateTimeStamp(localDate));
    if ((paramBasicGalaxyRequest.getHeaders().get("X-XiaoMi-Content-Sha256") != null) && (((String)paramBasicGalaxyRequest.getHeaders().get("X-XiaoMi-Content-Sha256")).equals("required")))
      paramBasicGalaxyRequest.addHeader("X-XiaoMi-Content-Sha256", str);
    paramBasicGalaxyRequest.addHeader("X-XiaoMi-Content-Sha256", str);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(localGalaxyCredentials.getGalaxyAppId()).append("/").append(localStringBuilder1);
    Galaxy4Signer.HeaderSigningResult localHeaderSigningResult = computeSignature(paramBasicGalaxyRequest, localDate, "Galaxy-HMAC-SHA256", str, localGalaxyCredentials);
    StringBuilder localStringBuilder3 = new StringBuilder();
    localStringBuilder3.append("Credential=").append(localStringBuilder2);
    StringBuilder localStringBuilder4 = new StringBuilder();
    localStringBuilder4.append("SignedHeaders=").append(getSignedHeadersString(paramBasicGalaxyRequest));
    StringBuilder localStringBuilder5 = new StringBuilder();
    localStringBuilder5.append("Signature=").append(BinaryUtils.toHex(localHeaderSigningResult.getSignature()));
    StringBuilder localStringBuilder6 = new StringBuilder();
    localStringBuilder6.append("Galaxy-HMAC-SHA256 ").append(localStringBuilder3).append(", ").append(localStringBuilder4).append(", ").append(localStringBuilder5);
    paramBasicGalaxyRequest.addHeader("Authorization", localStringBuilder6.toString());
    processRequestPayload(paramBasicGalaxyRequest, localHeaderSigningResult);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.auth.Galaxy4Signer
 * JD-Core Version:    0.6.2
 */