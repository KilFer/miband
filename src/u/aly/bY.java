package u.aly;

final class bY extends di<be>
{
  private void a(cy paramcy, be parambe)
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
          parambe.a = paramcy.w();
          parambe.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 8)
          {
            parambe.b = paramcy.w();
            parambe.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
          }
        }
      }
    }
    paramcy.k();
    if (!parambe.e())
      throw new cz("Required field 'upload_traffic' was not found in serialized data! Struct: " + toString());
    if (!parambe.i())
      throw new cz("Required field 'download_traffic' was not found in serialized data! Struct: " + toString());
    parambe.j();
  }

  private static void b(cy paramcy, be parambe)
  {
    parambe.j();
    paramcy.a(be.k());
    paramcy.a(be.l());
    paramcy.a(parambe.a);
    paramcy.c();
    paramcy.a(be.m());
    paramcy.a(parambe.b);
    paramcy.c();
    paramcy.d();
    paramcy.b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.bY
 * JD-Core Version:    0.6.2
 */