package com.tencent.mm.sdk.channel;

import com.tencent.mm.algorithm.MD5;

final class a
{
  static byte[] a(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString1 != null)
      localStringBuffer.append(paramString1);
    localStringBuffer.append(553910273);
    localStringBuffer.append(paramString2);
    localStringBuffer.append("mMcShCsTr");
    return MD5.getMessageDigest(localStringBuffer.toString().substring(1, 9).getBytes()).getBytes();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.channel.a
 * JD-Core Version:    0.6.2
 */