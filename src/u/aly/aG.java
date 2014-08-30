package u.aly;

final class aG extends di<ar>
{
  private void a(cy paramcy, ar paramar)
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
        if (localct.b == 11)
        {
          paramar.a = paramcy.z();
          paramar.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 10)
          {
            paramar.b = paramcy.x();
            paramar.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 8)
            {
              paramar.c = paramcy.w();
              paramar.c(true);
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
    if (!paramar.i())
      throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
    if (!paramar.l())
      throw new cz("Required field 'version' was not found in serialized data! Struct: " + toString());
    paramar.m();
  }

  private static void b(cy paramcy, ar paramar)
  {
    paramar.m();
    paramcy.a(ar.n());
    if (paramar.a != null)
    {
      paramcy.a(ar.o());
      paramcy.a(paramar.a);
      paramcy.c();
    }
    paramcy.a(ar.p());
    paramcy.a(paramar.b);
    paramcy.c();
    paramcy.a(ar.q());
    paramcy.a(paramar.c);
    paramcy.c();
    paramcy.d();
    paramcy.b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.aG
 * JD-Core Version:    0.6.2
 */