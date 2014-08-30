package u.aly;

final class aC extends di<aq>
{
  private void a(cy paramcy, aq paramaq)
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
      }
      while (true)
      {
        paramcy.m();
        break;
        if (localct.b == 11)
        {
          paramaq.a = paramcy.z();
          paramaq.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 11)
          {
            paramaq.b = paramcy.z();
            paramaq.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 11)
            {
              paramaq.c = paramcy.z();
              paramaq.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
              continue;
              if (localct.b == 10)
              {
                paramaq.d = paramcy.x();
                paramaq.d(true);
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
    paramcy.k();
    if (!paramaq.o())
      throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
    paramaq.p();
  }

  private static void b(cy paramcy, aq paramaq)
  {
    paramaq.p();
    paramcy.a(aq.q());
    if (paramaq.a != null)
    {
      paramcy.a(aq.r());
      paramcy.a(paramaq.a);
      paramcy.c();
    }
    if ((paramaq.b != null) && (paramaq.i()))
    {
      paramcy.a(aq.s());
      paramcy.a(paramaq.b);
      paramcy.c();
    }
    if (paramaq.c != null)
    {
      paramcy.a(aq.t());
      paramcy.a(paramaq.c);
      paramcy.c();
    }
    paramcy.a(aq.u());
    paramcy.a(paramaq.d);
    paramcy.c();
    paramcy.d();
    paramcy.b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.aC
 * JD-Core Version:    0.6.2
 */