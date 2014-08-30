package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

public abstract class AbstractExpandedDecoder
{
  private final BitArray a;
  private final s b;

  AbstractExpandedDecoder(BitArray paramBitArray)
  {
    this.a = paramBitArray;
    this.b = new s(paramBitArray);
  }

  public static AbstractExpandedDecoder createDecoder(BitArray paramBitArray)
  {
    if (paramBitArray.get(1))
      return new g(paramBitArray);
    if (!paramBitArray.get(2))
      return new j(paramBitArray);
    switch (s.a(paramBitArray, 1, 4))
    {
    default:
      switch (s.a(paramBitArray, 1, 5))
      {
      default:
        switch (s.a(paramBitArray, 1, 7))
        {
        default:
          throw new IllegalStateException("unknown decoder: " + paramBitArray);
        case 56:
        case 57:
        case 58:
        case 59:
        case 60:
        case 61:
        case 62:
        case 63:
        }
        break;
      case 12:
      case 13:
      }
    case 4:
      return new a(paramBitArray);
    case 5:
    }
    return new b(paramBitArray);
    return new c(paramBitArray);
    return new d(paramBitArray);
    return new e(paramBitArray, "310", "11");
    return new e(paramBitArray, "320", "11");
    return new e(paramBitArray, "310", "13");
    return new e(paramBitArray, "320", "13");
    return new e(paramBitArray, "310", "15");
    return new e(paramBitArray, "320", "15");
    return new e(paramBitArray, "310", "17");
    return new e(paramBitArray, "320", "17");
  }

  protected s getGeneralDecoder()
  {
    return this.b;
  }

  protected BitArray getInformation()
  {
    return this.a;
  }

  public abstract String parseInformation();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
 * JD-Core Version:    0.6.2
 */