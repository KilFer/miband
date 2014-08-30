package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.qrcode.detector.FinderPattern;
import java.io.Serializable;
import java.util.Comparator;

final class c
  implements Serializable, Comparator<FinderPattern>
{
  private static int a(FinderPattern paramFinderPattern1, FinderPattern paramFinderPattern2)
  {
    float f = paramFinderPattern2.getEstimatedModuleSize() - paramFinderPattern1.getEstimatedModuleSize();
    if (f < 0.0D)
      return -1;
    if (f > 0.0D)
      return 1;
    return 0;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.multi.qrcode.detector.c
 * JD-Core Version:    0.6.2
 */