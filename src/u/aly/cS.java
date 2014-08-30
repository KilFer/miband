package u.aly;

final class cS extends dj<cj>
{
  private static void a(cy paramcy, cj paramcj)
  {
    paramcj.c = null;
    paramcj.b = null;
    short s = paramcy.v();
    paramcj.b = paramcj.a(paramcy, s);
    if (paramcj.b != null)
      paramcj.c = paramcj.b(s);
  }

  private static void b(cy paramcy, cj paramcj)
  {
    if ((paramcj.j() == null) || (paramcj.k() == null))
      throw new cz("Cannot write a TUnion with no set value!");
    paramcy.a(paramcj.c.a());
    paramcj.d(paramcy);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.cS
 * JD-Core Version:    0.6.2
 */