package u.aly;

final class aS extends di<au>
{
  private void a(cy paramcy, au paramau)
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
          paramau.a = paramcy.z();
          paramau.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 10)
          {
            paramau.b = paramcy.x();
            paramau.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 11)
            {
              paramau.c = paramcy.z();
              paramau.c(true);
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
    if (!paramau.i())
      throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
    paramau.m();
  }

  private static void b(cy paramcy, au paramau)
  {
    paramau.m();
    paramcy.a(au.n());
    if ((paramau.a != null) && (paramau.e()))
    {
      paramcy.a(au.o());
      paramcy.a(paramau.a);
      paramcy.c();
    }
    paramcy.a(au.p());
    paramcy.a(paramau.b);
    paramcy.c();
    if (paramau.c != null)
    {
      paramcy.a(au.q());
      paramcy.a(paramau.c);
      paramcy.c();
    }
    paramcy.d();
    paramcy.b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.aS
 * JD-Core Version:    0.6.2
 */