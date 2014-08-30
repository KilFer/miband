package u.aly;

import java.util.BitSet;

final class cI extends dj<bg>
{
  private static void a(cy paramcy, bg parambg)
  {
    de localde = (de)paramcy;
    BitSet localBitSet = new BitSet();
    if (parambg.e())
      localBitSet.set(0);
    if (parambg.i())
      localBitSet.set(1);
    if (parambg.l())
      localBitSet.set(2);
    if (parambg.o())
      localBitSet.set(3);
    localde.a(localBitSet, 4);
    if (parambg.e())
      localde.a(parambg.a.a());
    if (parambg.i())
      localde.a(parambg.b);
    if (parambg.l())
      localde.a(parambg.c);
    if (parambg.o())
      localde.a(parambg.d);
  }

  private static void b(cy paramcy, bg parambg)
  {
    de localde = (de)paramcy;
    BitSet localBitSet = localde.b(4);
    if (localBitSet.get(0))
    {
      parambg.a = ap.a(localde.w());
      parambg.a(true);
    }
    if (localBitSet.get(1))
    {
      parambg.b = localde.w();
      parambg.b(true);
    }
    if (localBitSet.get(2))
    {
      parambg.c = localde.z();
      parambg.c(true);
    }
    if (localBitSet.get(3))
    {
      parambg.d = localde.z();
      parambg.d(true);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.cI
 * JD-Core Version:    0.6.2
 */