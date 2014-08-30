package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

public final class Result
{
  private final String a;
  private final byte[] b;
  private ResultPoint[] c;
  private final BarcodeFormat d;
  private Map<ResultMetadataType, Object> e;
  private final long f;

  public Result(String paramString, byte[] paramArrayOfByte, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat)
  {
    this(paramString, paramArrayOfByte, paramArrayOfResultPoint, paramBarcodeFormat, System.currentTimeMillis());
  }

  public Result(String paramString, byte[] paramArrayOfByte, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat, long paramLong)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.c = paramArrayOfResultPoint;
    this.d = paramBarcodeFormat;
    this.e = null;
    this.f = paramLong;
  }

  public final void addResultPoints(ResultPoint[] paramArrayOfResultPoint)
  {
    ResultPoint[] arrayOfResultPoint1 = this.c;
    if (arrayOfResultPoint1 == null)
      this.c = paramArrayOfResultPoint;
    while ((paramArrayOfResultPoint == null) || (paramArrayOfResultPoint.length <= 0))
      return;
    ResultPoint[] arrayOfResultPoint2 = new ResultPoint[arrayOfResultPoint1.length + paramArrayOfResultPoint.length];
    System.arraycopy(arrayOfResultPoint1, 0, arrayOfResultPoint2, 0, arrayOfResultPoint1.length);
    System.arraycopy(paramArrayOfResultPoint, 0, arrayOfResultPoint2, arrayOfResultPoint1.length, paramArrayOfResultPoint.length);
    this.c = arrayOfResultPoint2;
  }

  public final BarcodeFormat getBarcodeFormat()
  {
    return this.d;
  }

  public final byte[] getRawBytes()
  {
    return this.b;
  }

  public final Map<ResultMetadataType, Object> getResultMetadata()
  {
    return this.e;
  }

  public final ResultPoint[] getResultPoints()
  {
    return this.c;
  }

  public final String getText()
  {
    return this.a;
  }

  public final long getTimestamp()
  {
    return this.f;
  }

  public final void putAllMetadata(Map<ResultMetadataType, Object> paramMap)
  {
    if (paramMap != null)
    {
      if (this.e == null)
        this.e = paramMap;
    }
    else
      return;
    this.e.putAll(paramMap);
  }

  public final void putMetadata(ResultMetadataType paramResultMetadataType, Object paramObject)
  {
    if (this.e == null)
      this.e = new EnumMap(ResultMetadataType.class);
    this.e.put(paramResultMetadataType, paramObject);
  }

  public final String toString()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.Result
 * JD-Core Version:    0.6.2
 */