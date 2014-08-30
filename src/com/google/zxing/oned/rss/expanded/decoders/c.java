package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class c extends h
{
  private static final int a = 8;
  private static final int b = 2;

  c(BitArray paramBitArray)
  {
    super(paramBitArray);
  }

  public final String parseInformation()
  {
    if (getInformation().getSize() < 48)
      throw NotFoundException.getNotFoundInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, 8);
    int i = getGeneralDecoder().a(48, 2);
    localStringBuilder.append("(392");
    localStringBuilder.append(i);
    localStringBuilder.append(')');
    localStringBuilder.append(getGeneralDecoder().a(50, null).a());
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.c
 * JD-Core Version:    0.6.2
 */