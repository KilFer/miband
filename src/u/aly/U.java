package u.aly;

final class U extends di<am>
{
  private void a(cy paramcy, am paramam)
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
        if (localct.b == 10)
        {
          paramam.a = paramcy.x();
          paramam.b(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 11)
          {
            paramam.b = paramcy.z();
            paramam.c(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 8)
            {
              paramam.c = an.a(paramcy.w());
              paramam.d(true);
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
    if (!paramam.e())
      throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
    paramam.m();
  }

  private static void b(cy paramcy, am paramam)
  {
    paramam.m();
    paramcy.a(am.n());
    paramcy.a(am.o());
    paramcy.a(paramam.a);
    paramcy.c();
    if (paramam.b != null)
    {
      paramcy.a(am.p());
      paramcy.a(paramam.b);
      paramcy.c();
    }
    if ((paramam.c != null) && (paramam.l()))
    {
      paramcy.a(am.q());
      paramcy.a(paramam.c.a());
      paramcy.c();
    }
    paramcy.d();
    paramcy.b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.U
 * JD-Core Version:    0.6.2
 */