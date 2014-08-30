package com.google.zxing;

import java.util.Map;

public abstract interface Reader
{
  public abstract Result decode(BinaryBitmap paramBinaryBitmap);

  public abstract Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap);

  public abstract void reset();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.Reader
 * JD-Core Version:    0.6.2
 */