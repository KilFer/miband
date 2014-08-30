package u.aly;

final class A extends di<ah>
{
  private void a(cy paramcy, ah paramah)
  {
    paramcy.j();
    ct localct = paramcy.l();
    if (localct.b != 0)
    {
      switch (localct.c)
      {
      default:
        db.a(paramcy, localct.b);
      case 1:
      }
      while (true)
      {
        paramcy.m();
        break;
        if (localct.b == 10)
        {
          paramah.a = paramcy.x();
          paramah.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
        }
      }
    }
    paramcy.k();
    if (!paramah.e())
      throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
    paramah.f();
  }

  private static void b(cy paramcy, ah paramah)
  {
    paramah.f();
    paramcy.a(ah.h());
    paramcy.a(ah.i());
    paramcy.a(paramah.a);
    paramcy.c();
    paramcy.d();
    paramcy.b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.A
 * JD-Core Version:    0.6.2
 */