package u.aly;

import java.util.BitSet;

final class bG extends dj<ax>
{
  private static void a(cy paramcy, ax paramax)
  {
    de localde = (de)paramcy;
    BitSet localBitSet = new BitSet();
    if (paramax.e())
      localBitSet.set(0);
    if (paramax.i())
      localBitSet.set(1);
    if (paramax.l())
      localBitSet.set(2);
    if (paramax.o())
      localBitSet.set(3);
    if (paramax.r())
      localBitSet.set(4);
    if (paramax.u())
      localBitSet.set(5);
    if (paramax.x())
      localBitSet.set(6);
    if (paramax.A())
      localBitSet.set(7);
    if (paramax.D())
      localBitSet.set(8);
    if (paramax.G())
      localBitSet.set(9);
    if (paramax.J())
      localBitSet.set(10);
    localde.a(localBitSet, 11);
    if (paramax.e())
      localde.a(paramax.a);
    if (paramax.i())
      localde.a(paramax.b);
    if (paramax.l())
      localde.a(paramax.c);
    if (paramax.o())
      localde.a(paramax.d);
    if (paramax.r())
      localde.a(paramax.e);
    if (paramax.u())
      localde.a(paramax.f);
    if (paramax.x())
      localde.a(paramax.g);
    if (paramax.A())
      localde.a(paramax.h);
    if (paramax.D())
      localde.a(paramax.i.a());
    if (paramax.G())
      localde.a(paramax.j);
    if (paramax.J())
      paramax.k.b(localde);
  }

  private static void b(cy paramcy, ax paramax)
  {
    de localde = (de)paramcy;
    BitSet localBitSet = localde.b(11);
    if (localBitSet.get(0))
    {
      paramax.a = localde.w();
      paramax.a(true);
    }
    if (localBitSet.get(1))
    {
      paramax.b = localde.z();
      paramax.b(true);
    }
    if (localBitSet.get(2))
    {
      paramax.c = localde.z();
      paramax.c(true);
    }
    if (localBitSet.get(3))
    {
      paramax.d = localde.y();
      paramax.d(true);
    }
    if (localBitSet.get(4))
    {
      paramax.e = localde.y();
      paramax.e(true);
    }
    if (localBitSet.get(5))
    {
      paramax.f = localde.z();
      paramax.f(true);
    }
    if (localBitSet.get(6))
    {
      paramax.g = localde.w();
      paramax.g(true);
    }
    if (localBitSet.get(7))
    {
      paramax.h = localde.z();
      paramax.h(true);
    }
    if (localBitSet.get(8))
    {
      paramax.i = ag.a(localde.w());
      paramax.i(true);
    }
    if (localBitSet.get(9))
    {
      paramax.j = localde.z();
      paramax.j(true);
    }
    if (localBitSet.get(10))
    {
      paramax.k = new bg();
      paramax.k.a(localde);
      paramax.k(true);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.bG
 * JD-Core Version:    0.6.2
 */