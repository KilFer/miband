package u.aly;

final class cK extends di<bh>
{
  private void a(cy paramcy, bh parambh)
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
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      }
      while (true)
      {
        paramcy.m();
        break;
        if (localct.b == 11)
        {
          parambh.a = paramcy.z();
          parambh.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 11)
          {
            parambh.b = paramcy.z();
            parambh.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 11)
            {
              parambh.c = paramcy.z();
              parambh.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
              continue;
              if (localct.b == 8)
              {
                parambh.d = paramcy.w();
                parambh.d(true);
              }
              else
              {
                db.a(paramcy, localct.b);
                continue;
                if (localct.b == 8)
                {
                  parambh.e = paramcy.w();
                  parambh.e(true);
                }
                else
                {
                  db.a(paramcy, localct.b);
                  continue;
                  if (localct.b == 8)
                  {
                    parambh.f = paramcy.w();
                    parambh.f(true);
                  }
                  else
                  {
                    db.a(paramcy, localct.b);
                    continue;
                    if (localct.b == 11)
                    {
                      parambh.g = paramcy.A();
                      parambh.g(true);
                    }
                    else
                    {
                      db.a(paramcy, localct.b);
                      continue;
                      if (localct.b == 11)
                      {
                        parambh.h = paramcy.z();
                        parambh.h(true);
                      }
                      else
                      {
                        db.a(paramcy, localct.b);
                        continue;
                        if (localct.b == 11)
                        {
                          parambh.i = paramcy.z();
                          parambh.i(true);
                        }
                        else
                        {
                          db.a(paramcy, localct.b);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    paramcy.k();
    if (!parambh.o())
      throw new cz("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
    if (!parambh.r())
      throw new cz("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
    if (!parambh.u())
      throw new cz("Required field 'length' was not found in serialized data! Struct: " + toString());
    parambh.F();
  }

  private static void b(cy paramcy, bh parambh)
  {
    parambh.F();
    paramcy.a(bh.G());
    if (parambh.a != null)
    {
      paramcy.a(bh.H());
      paramcy.a(parambh.a);
      paramcy.c();
    }
    if (parambh.b != null)
    {
      paramcy.a(bh.I());
      paramcy.a(parambh.b);
      paramcy.c();
    }
    if (parambh.c != null)
    {
      paramcy.a(bh.J());
      paramcy.a(parambh.c);
      paramcy.c();
    }
    paramcy.a(bh.K());
    paramcy.a(parambh.d);
    paramcy.c();
    paramcy.a(bh.L());
    paramcy.a(parambh.e);
    paramcy.c();
    paramcy.a(bh.M());
    paramcy.a(parambh.f);
    paramcy.c();
    if (parambh.g != null)
    {
      paramcy.a(bh.N());
      paramcy.a(parambh.g);
      paramcy.c();
    }
    if (parambh.h != null)
    {
      paramcy.a(bh.O());
      paramcy.a(parambh.h);
      paramcy.c();
    }
    if (parambh.i != null)
    {
      paramcy.a(bh.P());
      paramcy.a(parambh.i);
      paramcy.c();
    }
    paramcy.d();
    paramcy.b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.cK
 * JD-Core Version:    0.6.2
 */