package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class j extends AbstractExpandedDecoder
{
  private static final int a = 5;

  j(BitArray paramBitArray)
  {
    super(paramBitArray);
  }

  public final String parseInformation()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    return getGeneralDecoder().a(localStringBuilder, 5);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.j
 * JD-Core Version:    0.6.2
 */