package u.aly;

import java.util.BitSet;

final class K extends dj<aj>
{
  private static void a(cy paramcy, aj paramaj)
  {
    de localde = (de)paramcy;
    localde.a(paramaj.a);
    localde.a(paramaj.b);
    BitSet localBitSet = new BitSet();
    if (paramaj.l())
      localBitSet.set(0);
    localde.a(localBitSet, 1);
    if (paramaj.l())
      localde.a(paramaj.c);
  }

  private static void b(cy paramcy, aj paramaj)
  {
    de localde = (de)paramcy;
    paramaj.a = localde.w();
    paramaj.a(true);
    paramaj.b = localde.w();
    paramaj.b(true);
    if (localde.b(1).get(0))
    {
      paramaj.c = localde.w();
      paramaj.c(true);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.K
 * JD-Core Version:    0.6.2
 */