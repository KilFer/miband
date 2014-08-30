package android.support.v4.widget;

import android.content.Context;
import android.view.View;
import android.widget.SearchView;

final class y extends v
{
  public final View a(Context paramContext)
  {
    return new SearchViewCompatIcs.MySearchView(paramContext);
  }

  public final void b(View paramView, int paramInt)
  {
    ((SearchView)paramView).setImeOptions(paramInt);
  }

  public final void c(View paramView, int paramInt)
  {
    ((SearchView)paramView).setInputType(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.y
 * JD-Core Version:    0.6.2
 */