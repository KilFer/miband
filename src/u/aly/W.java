package u.aly;

import java.util.BitSet;

final class W extends dj<am>
{
  private static void a(cy paramcy, am paramam)
  {
    de localde = (de)paramcy;
    localde.a(paramam.a);
    localde.a(paramam.b);
    BitSet localBitSet = new BitSet();
    if (paramam.l())
      localBitSet.set(0);
    localde.a(localBitSet, 1);
    if (paramam.l())
      localde.a(paramam.c.a());
  }

  private static void b(cy paramcy, am paramam)
  {
    de localde = (de)paramcy;
    paramam.a = localde.x();
    paramam.b(true);
    paramam.b = localde.z();
    paramam.c(true);
    if (localde.b(1).get(0))
    {
      paramam.c = an.a(localde.w());
      paramam.d(true);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.W
 * JD-Core Version:    0.6.2
 */