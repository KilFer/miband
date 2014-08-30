package u.aly;

import java.util.BitSet;

final class bS extends dj<bb>
{
  private static void a(cy paramcy, bb parambb)
  {
    de localde = (de)paramcy;
    localde.a(parambb.a);
    BitSet localBitSet = new BitSet();
    if (parambb.i())
      localBitSet.set(0);
    if (parambb.l())
      localBitSet.set(1);
    localde.a(localBitSet, 2);
    if (parambb.i())
      localde.a(parambb.b);
    if (parambb.l())
      parambb.c.b(localde);
  }

  private static void b(cy paramcy, bb parambb)
  {
    de localde = (de)paramcy;
    parambb.a = localde.w();
    parambb.a(true);
    BitSet localBitSet = localde.b(2);
    if (localBitSet.get(0))
    {
      parambb.b = localde.z();
      parambb.b(true);
    }
    if (localBitSet.get(1))
    {
      parambb.c = new at();
      parambb.c.a(localde);
      parambb.c(true);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.bS
 * JD-Core Version:    0.6.2
 */