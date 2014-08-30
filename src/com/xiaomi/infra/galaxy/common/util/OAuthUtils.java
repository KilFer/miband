package com.xiaomi.infra.galaxy.common.util;

import com.xiaomi.infra.galaxy.common.model.OAuthProvider;

public class OAuthUtils
{
  public static String getOauthUserId(OAuthProvider paramOAuthProvider, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramOAuthProvider.name()).append(":").append(paramString);
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.util.OAuthUtils
 * JD-Core Version:    0.6.2
 */