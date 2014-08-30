package android.support.v4.widget;

import android.widget.SearchView.OnQueryTextListener;

final class C
  implements SearchView.OnQueryTextListener
{
  C(t paramt)
  {
  }

  public final boolean onQueryTextChange(String paramString)
  {
    return this.a.b(paramString);
  }

  public final boolean onQueryTextSubmit(String paramString)
  {
    return this.a.a(paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.C
 * JD-Core Version:    0.6.2
 */