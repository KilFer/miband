package com.google.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

final class d
  implements Serializable, Comparator<FinderPattern>
{
  private final float a;

  private d(float paramFloat)
  {
    this.a = paramFloat;
  }

  private int a(FinderPattern paramFinderPattern1, FinderPattern paramFinderPattern2)
  {
    float f1 = Math.abs(paramFinderPattern2.getEstimatedModuleSize() - this.a);
    float f2 = Math.abs(paramFinderPattern1.getEstimatedModuleSize() - this.a);
    if (f1 < f2)
      return -1;
    if (f1 == f2)
      return 0;
    return 1;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.d
 * JD-Core Version:    0.6.2
 */