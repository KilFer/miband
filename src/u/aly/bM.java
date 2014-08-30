package u.aly;

final class bM extends di<ba>
{
  private void a(cy paramcy, ba paramba)
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
      }
      while (true)
      {
        paramcy.m();
        break;
        if (localct.b == 8)
        {
          paramba.a = paramcy.w();
          paramba.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 8)
          {
            paramba.b = paramcy.w();
            paramba.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
          }
        }
      }
    }
    paramcy.k();
    if (!paramba.e())
      throw new cz("Required field 'height' was not found in serialized data! Struct: " + toString());
    if (!paramba.i())
      throw new cz("Required field 'width' was not found in serialized data! Struct: " + toString());
    paramba.j();
  }

  private static void b(cy paramcy, ba paramba)
  {
    paramba.j();
    paramcy.a(ba.k());
    paramcy.a(ba.l());
    paramcy.a(paramba.a);
    paramcy.c();
    paramcy.a(ba.m());
    paramcy.a(paramba.b);
    paramcy.c();
    paramcy.d();
    paramcy.b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.bM
 * JD-Core Version:    0.6.2
 */