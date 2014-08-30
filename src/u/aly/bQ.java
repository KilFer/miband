package u.aly;

final class bQ extends di<bb>
{
  private void a(cy paramcy, bb parambb)
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
          parambb.a = paramcy.w();
          parambb.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 11)
          {
            parambb.b = paramcy.z();
            parambb.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 12)
            {
              parambb.c = new at();
              parambb.c.a(paramcy);
              parambb.c(true);
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
    if (!parambb.e())
      throw new cz("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
    parambb.m();
  }

  private static void b(cy paramcy, bb parambb)
  {
    parambb.m();
    paramcy.a(bb.n());
    paramcy.a(bb.o());
    paramcy.a(parambb.a);
    paramcy.c();
    if ((parambb.b != null) && (parambb.i()))
    {
      paramcy.a(bb.p());
      paramcy.a(parambb.b);
      paramcy.c();
    }
    if ((parambb.c != null) && (parambb.l()))
    {
      paramcy.a(bb.q());
      parambb.c.b(paramcy);
      paramcy.c();
    }
    paramcy.d();
    paramcy.b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.bQ
 * JD-Core Version:    0.6.2
 */