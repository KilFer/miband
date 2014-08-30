package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

abstract class f extends i
{
  private static final int a = 5;
  private static final int b = 15;

  f(BitArray paramBitArray)
  {
    super(paramBitArray);
  }

  public String parseInformation()
  {
    if (getInformation().getSize() != 60)
      throw NotFoundException.getNotFoundInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, 5);
    b(localStringBuilder, 45, 15);
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.f
 * JD-Core Version:    0.6.2
 */