package android.support.v4.widget;

import android.content.Context;
import android.widget.SearchView;

public class SearchViewCompatIcs$MySearchView extends SearchView
{
  public SearchViewCompatIcs$MySearchView(Context paramContext)
  {
    super(paramContext);
  }

  public void onActionViewCollapsed()
  {
    setQuery("", false);
    super.onActionViewCollapsed();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SearchViewCompatIcs.MySearchView
 * JD-Core Version:    0.6.2
 */