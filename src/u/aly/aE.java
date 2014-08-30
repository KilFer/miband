package u.aly;

import java.util.BitSet;

final class aE extends dj<aq>
{
  private static void a(cy paramcy, aq paramaq)
  {
    de localde = (de)paramcy;
    localde.a(paramaq.a);
    localde.a(paramaq.c);
    localde.a(paramaq.d);
    BitSet localBitSet = new BitSet();
    if (paramaq.i())
      localBitSet.set(0);
    localde.a(localBitSet, 1);
    if (paramaq.i())
      localde.a(paramaq.b);
  }

  private static void b(cy paramcy, aq paramaq)
  {
    de localde = (de)paramcy;
    paramaq.a = localde.z();
    paramaq.a(true);
    paramaq.c = localde.z();
    paramaq.c(true);
    paramaq.d = localde.x();
    paramaq.d(true);
    if (localde.b(1).get(0))
    {
      paramaq.b = localde.z();
      paramaq.b(true);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.aE
 * JD-Core Version:    0.6.2
 */