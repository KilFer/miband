package u.aly;

import android.os.AsyncTask;

final class cO extends AsyncTask<Integer, Integer, bn.a>
{
  private bm a;
  private bl.a b;

  public cO(bl parambl, bm parambm, bl.a parama)
  {
    this.a = parambm;
    this.b = parama;
  }

  private bn.a a()
  {
    return this.c.a(this.a);
  }

  private void a(bn.a parama)
  {
    if (this.b != null)
      this.b.a(parama);
  }

  protected final void onPreExecute()
  {
    if (this.b != null)
      this.b.a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.cO
 * JD-Core Version:    0.6.2
 */