package u.aly;

final class bA extends di<aw>
{
  private void a(cy paramcy, aw paramaw)
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
      case 2:
      case 3:
      }
      while (true)
      {
        paramcy.m();
        break;
        if (localct.b == 4)
        {
          paramaw.a = paramcy.y();
          paramaw.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 4)
          {
            paramaw.b = paramcy.y();
            paramaw.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 10)
            {
              paramaw.c = paramcy.x();
              paramaw.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
            }
          }
        }
      }
    }
    paramcy.k();
    if (!paramaw.e())
      throw new cz("Required field 'lat' was not found in serialized data! Struct: " + toString());
    if (!paramaw.i())
      throw new cz("Required field 'lng' was not found in serialized data! Struct: " + toString());
    if (!paramaw.l())
      throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
    paramaw.m();
  }

  private static void b(cy paramcy, aw paramaw)
  {
    paramaw.m();
    paramcy.a(aw.n());
    paramcy.a(aw.o());
    paramcy.a(paramaw.a);
    paramcy.c();
    paramcy.a(aw.p());
    paramcy.a(paramaw.b);
    paramcy.c();
    paramcy.a(aw.q());
    paramcy.a(paramaw.c);
    paramcy.c();
    paramcy.d();
    paramcy.b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.bA
 * JD-Core Version:    0.6.2
 */