package u.aly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class aW extends di<av>
{
  private static void a(cy paramcy, av paramav)
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
          paramav.a = paramcy.z();
          paramav.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 15)
          {
            cu localcu3 = paramcy.p();
            paramav.b = new ArrayList(localcu3.b);
            for (int k = 0; ; k++)
            {
              if (k >= localcu3.b)
              {
                paramcy.q();
                paramav.b(true);
                break;
              }
              am localam = new am();
              localam.a(paramcy);
              paramav.b.add(localam);
            }
          }
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 15)
          {
            cu localcu2 = paramcy.p();
            paramav.c = new ArrayList(localcu2.b);
            for (int j = 0; ; j++)
            {
              if (j >= localcu2.b)
              {
                paramcy.q();
                paramav.c(true);
                break;
              }
              ao localao2 = new ao();
              localao2.a(paramcy);
              paramav.c.add(localao2);
            }
          }
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 15)
          {
            cu localcu1 = paramcy.p();
            paramav.d = new ArrayList(localcu1.b);
            for (int i = 0; ; i++)
            {
              if (i >= localcu1.b)
              {
                paramcy.q();
                paramav.d(true);
                break;
              }
              ao localao1 = new ao();
              localao1.a(paramcy);
              paramav.d.add(localao1);
            }
          }
          db.a(paramcy, localct.b);
        }
      }
    }
    paramcy.k();
    paramav.v();
  }

  private static void b(cy paramcy, av paramav)
  {
    paramav.v();
    paramcy.a(av.w());
    if (paramav.a != null)
    {
      paramcy.a(av.x());
      paramcy.a(paramav.a);
      paramcy.c();
    }
    Iterator localIterator3;
    Iterator localIterator2;
    label162: Iterator localIterator1;
    if ((paramav.b != null) && (paramav.k()))
    {
      paramcy.a(av.y());
      paramcy.a(new cu((byte)12, paramav.b.size()));
      localIterator3 = paramav.b.iterator();
      if (!localIterator3.hasNext())
      {
        paramcy.f();
        paramcy.c();
      }
    }
    else
    {
      if ((paramav.c != null) && (paramav.p()))
      {
        paramcy.a(av.z());
        paramcy.a(new cu((byte)12, paramav.c.size()));
        localIterator2 = paramav.c.iterator();
        if (localIterator2.hasNext())
          break label275;
        paramcy.f();
        paramcy.c();
      }
      if ((paramav.d != null) && (paramav.u()))
      {
        paramcy.a(av.A());
        paramcy.a(new cu((byte)12, paramav.d.size()));
        localIterator1 = paramav.d.iterator();
      }
    }
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        paramcy.f();
        paramcy.c();
        paramcy.d();
        paramcy.b();
        return;
        ((am)localIterator3.next()).b(paramcy);
        break;
        label275: ((ao)localIterator2.next()).b(paramcy);
        break label162;
      }
      ((ao)localIterator1.next()).b(paramcy);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.aW
 * JD-Core Version:    0.6.2
 */