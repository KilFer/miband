package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class d extends h
{
  private static final int a = 8;
  private static final int b = 2;
  private static final int c = 10;

  d(BitArray paramBitArray)
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
    localStringBuilder.append("(393");
    localStringBuilder.append(i);
    localStringBuilder.append(')');
    int j = getGeneralDecoder().a(50, 10);
    if (j / 100 == 0)
      localStringBuilder.append('0');
    if (j / 10 == 0)
      localStringBuilder.append('0');
    localStringBuilder.append(j);
    localStringBuilder.append(getGeneralDecoder().a(60, null).a());
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.d
 * JD-Core Version:    0.6.2
 */