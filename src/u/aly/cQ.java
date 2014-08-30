package u.aly;

final class cQ extends di<cj>
{
  private static void a(cy paramcy, cj paramcj)
  {
    paramcj.c = null;
    paramcj.b = null;
    paramcy.j();
    ct localct = paramcy.l();
    paramcj.b = paramcj.a(paramcy, localct);
    if (paramcj.b != null)
      paramcj.c = paramcj.b(localct.c);
    paramcy.m();
    paramcy.l();
    paramcy.k();
  }

  private static void b(cy paramcy, cj paramcj)
  {
    if ((paramcj.j() == null) || (paramcj.k() == null))
      throw new cz("Cannot write a TUnion with no set value!");
    paramcy.a(paramcj.c());
    paramcy.a(paramcj.a(paramcj.c));
    paramcj.c(paramcy);
    paramcy.c();
    paramcy.d();
    paramcy.b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.cQ
 * JD-Core Version:    0.6.2
 */