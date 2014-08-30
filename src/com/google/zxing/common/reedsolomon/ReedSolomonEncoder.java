package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

public final class ReedSolomonEncoder
{
  private final GenericGF a;
  private final List<a> b;

  public ReedSolomonEncoder(GenericGF paramGenericGF)
  {
    if (!GenericGF.QR_CODE_FIELD_256.equals(paramGenericGF))
      throw new IllegalArgumentException("Only QR Code is supported at this time");
    this.a = paramGenericGF;
    this.b = new ArrayList();
    this.b.add(new a(paramGenericGF, new int[] { 1 }));
  }

  private a a(int paramInt)
  {
    if (paramInt >= this.b.size())
    {
      a locala1 = (a)this.b.get(-1 + this.b.size());
      int i = this.b.size();
      a locala2 = locala1;
      for (int j = i; j <= paramInt; j++)
      {
        GenericGF localGenericGF = this.a;
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = 1;
        arrayOfInt[1] = this.a.a(j - 1);
        locala2 = locala2.b(new a(localGenericGF, arrayOfInt));
        this.b.add(locala2);
      }
    }
    return (a)this.b.get(paramInt);
  }

  public final void encode(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt == 0)
      throw new IllegalArgumentException("No error correction bytes");
    int i = paramArrayOfInt.length - paramInt;
    if (i <= 0)
      throw new IllegalArgumentException("No data bytes provided");
    a locala = a(paramInt);
    int[] arrayOfInt1 = new int[i];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt1, 0, i);
    int[] arrayOfInt2 = new a(this.a, arrayOfInt1).a(paramInt, 1).c(locala)[1].a();
    int j = paramInt - arrayOfInt2.length;
    for (int k = 0; k < j; k++)
      paramArrayOfInt[(i + k)] = 0;
    System.arraycopy(arrayOfInt2, 0, paramArrayOfInt, i + j, arrayOfInt2.length);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.ReedSolomonEncoder
 * JD-Core Version:    0.6.2
 */