package android.support.v4.widget;

import android.content.Context;
import android.view.View;
import android.widget.SearchView;

final class SearchViewCompatIcs
{
  public static View a(Context paramContext)
  {
    return new SearchViewCompatIcs.MySearchView(paramContext);
  }

  public static void a(View paramView, int paramInt)
  {
    ((SearchView)paramView).setImeOptions(paramInt);
  }

  public static void b(View paramView, int paramInt)
  {
    ((SearchView)paramView).setInputType(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SearchViewCompatIcs
 * JD-Core Version:    0.6.2
 */