package com.google.zxing.common;

import java.util.List;

public final class DecoderResult
{
  private final byte[] a;
  private final String b;
  private final List<byte[]> c;
  private final String d;

  public DecoderResult(byte[] paramArrayOfByte, String paramString1, List<byte[]> paramList, String paramString2)
  {
    this.a = paramArrayOfByte;
    this.b = paramString1;
    this.c = paramList;
    this.d = paramString2;
  }

  public final List<byte[]> getByteSegments()
  {
    return this.c;
  }

  public final String getECLevel()
  {
    return this.d;
  }

  public final byte[] getRawBytes()
  {
    return this.a;
  }

  public final String getText()
  {
    return this.b;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.DecoderResult
 * JD-Core Version:    0.6.2
 */