package u.aly;

final class I extends di<aj>
{
  private void a(cy paramcy, aj paramaj)
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
        if (localct.b == 8)
        {
          paramaj.a = paramcy.w();
          paramaj.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 8)
          {
            paramaj.b = paramcy.w();
            paramaj.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 8)
            {
              paramaj.c = paramcy.w();
              paramaj.c(true);
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
    if (!paramaj.e())
      throw new cz("Required field 'successful_requests' was not found in serialized data! Struct: " + toString());
    if (!paramaj.i())
      throw new cz("Required field 'failed_requests' was not found in serialized data! Struct: " + toString());
    paramaj.m();
  }

  private static void b(cy paramcy, aj paramaj)
  {
    paramaj.m();
    paramcy.a(aj.n());
    paramcy.a(aj.o());
    paramcy.a(paramaj.a);
    paramcy.c();
    paramcy.a(aj.p());
    paramcy.a(paramaj.b);
    paramcy.c();
    if (paramaj.l())
    {
      paramcy.a(aj.q());
      paramcy.a(paramaj.c);
      paramcy.c();
    }
    paramcy.d();
    paramcy.b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.I
 * JD-Core Version:    0.6.2
 */