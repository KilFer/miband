package u.aly;

import java.util.BitSet;

final class aU extends dj<au>
{
  private static void a(cy paramcy, au paramau)
  {
    de localde = (de)paramcy;
    localde.a(paramau.b);
    localde.a(paramau.c);
    BitSet localBitSet = new BitSet();
    if (paramau.e())
      localBitSet.set(0);
    localde.a(localBitSet, 1);
    if (paramau.e())
      localde.a(paramau.a);
  }

  private static void b(cy paramcy, au paramau)
  {
    de localde = (de)paramcy;
    paramau.b = localde.x();
    paramau.b(true);
    paramau.c = localde.z();
    paramau.c(true);
    if (localde.b(1).get(0))
    {
      paramau.a = localde.z();
      paramau.a(true);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.aU
 * JD-Core Version:    0.6.2
 */