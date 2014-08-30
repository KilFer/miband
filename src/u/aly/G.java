package u.aly;

import java.util.BitSet;

final class G extends dj<ai>
{
  private static void a(cy paramcy, ai paramai)
  {
    de localde = (de)paramcy;
    localde.a(paramai.a);
    localde.a(paramai.e.a());
    localde.a(paramai.f);
    localde.a(paramai.g);
    BitSet localBitSet = new BitSet();
    if (paramai.i())
      localBitSet.set(0);
    if (paramai.l())
      localBitSet.set(1);
    if (paramai.o())
      localBitSet.set(2);
    if (paramai.A())
      localBitSet.set(3);
    if (paramai.D())
      localBitSet.set(4);
    if (paramai.G())
      localBitSet.set(5);
    localde.a(localBitSet, 6);
    if (paramai.i())
      localde.a(paramai.b);
    if (paramai.l())
      localde.a(paramai.c);
    if (paramai.o())
      localde.a(paramai.d);
    if (paramai.A())
      localde.a(paramai.h);
    if (paramai.D())
      localde.a(paramai.i);
    if (paramai.G())
      localde.a(paramai.j);
  }

  private static void b(cy paramcy, ai paramai)
  {
    de localde = (de)paramcy;
    paramai.a = localde.z();
    paramai.a(true);
    paramai.e = bc.a(localde.w());
    paramai.e(true);
    paramai.f = localde.z();
    paramai.f(true);
    paramai.g = localde.z();
    paramai.g(true);
    BitSet localBitSet = localde.b(6);
    if (localBitSet.get(0))
    {
      paramai.b = localde.z();
      paramai.b(true);
    }
    if (localBitSet.get(1))
    {
      paramai.c = localde.w();
      paramai.c(true);
    }
    if (localBitSet.get(2))
    {
      paramai.d = localde.z();
      paramai.d(true);
    }
    if (localBitSet.get(3))
    {
      paramai.h = localde.z();
      paramai.h(true);
    }
    if (localBitSet.get(4))
    {
      paramai.i = localde.z();
      paramai.i(true);
    }
    if (localBitSet.get(5))
    {
      paramai.j = localde.w();
      paramai.j(true);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.G
 * JD-Core Version:    0.6.2
 */