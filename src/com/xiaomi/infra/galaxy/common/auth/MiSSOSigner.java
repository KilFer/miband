package com.xiaomi.infra.galaxy.common.auth;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.HttpMethodName;
import com.xiaomi.infra.galaxy.common.util.Base64Utils;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class MiSSOSigner
  implements Signer
{
  private static final MiSSOSigner miSSOSigner = new MiSSOSigner();

  public static MiSSOSigner getInstance()
  {
    return miSSOSigner;
  }

  private String signature(String paramString1, String paramString2, TreeMap<String, String> paramTreeMap, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1.toUpperCase());
    if (StringUtils.isNotBlank(paramString2))
      localStringBuilder.append("&").append(paramString2);
    if ((paramTreeMap != null) && (!paramTreeMap.isEmpty()))
    {
      Iterator localIterator = paramTreeMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        String str3 = (String)paramTreeMap.get(str2);
        if (!StringUtils.isBlank(str3))
          localStringBuilder.append("&").append(str2).append("=").append(str3);
      }
    }
    if (StringUtils.isNotBlank(paramString3))
      localStringBuilder.append("&").append(paramString3);
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA");
      localMessageDigest.update(localStringBuilder.toString().getBytes());
      String str1 = Base64Utils.encode(localMessageDigest.digest());
      return str1;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return "";
  }

  public void sign(BasicGalaxyRequest paramBasicGalaxyRequest, GalaxyCredentials paramGalaxyCredentials)
  {
    if (StringUtils.isBlank(paramBasicGalaxyRequest.getResourcePath()));
    for (String str1 = "/"; ; str1 = paramBasicGalaxyRequest.getResourcePath())
    {
      String str2 = paramGalaxyCredentials.getGalaxySecretKey();
      TreeMap localTreeMap = new TreeMap();
      localTreeMap.putAll(paramBasicGalaxyRequest.getParameters());
      paramBasicGalaxyRequest.addParameter("signature", signature(paramBasicGalaxyRequest.getHttpMethod().name(), str1, localTreeMap, str2));
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.auth.MiSSOSigner
 * JD-Core Version:    0.6.2
 */