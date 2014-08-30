package android.support.v4.widget;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.view.View;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;

class v extends z
{
  public View a(Context paramContext)
  {
    return new SearchView(paramContext);
  }

  public final CharSequence a(View paramView)
  {
    return ((SearchView)paramView).getQuery();
  }

  public final Object a(SearchViewCompat.OnCloseListenerCompat paramOnCloseListenerCompat)
  {
    return new D(new m(this, paramOnCloseListenerCompat));
  }

  public final Object a(SearchViewCompat.OnQueryTextListenerCompat paramOnQueryTextListenerCompat)
  {
    return new C(new t(this, paramOnQueryTextListenerCompat));
  }

  public final void a(View paramView, int paramInt)
  {
    ((SearchView)paramView).setMaxWidth(paramInt);
  }

  public final void a(View paramView, ComponentName paramComponentName)
  {
    SearchView localSearchView = (SearchView)paramView;
    localSearchView.setSearchableInfo(((SearchManager)localSearchView.getContext().getSystemService("search")).getSearchableInfo(paramComponentName));
  }

  public final void a(View paramView, CharSequence paramCharSequence)
  {
    ((SearchView)paramView).setQueryHint(paramCharSequence);
  }

  public final void a(View paramView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    ((SearchView)paramView).setQuery(paramCharSequence, paramBoolean);
  }

  public final void a(View paramView, boolean paramBoolean)
  {
    ((SearchView)paramView).setIconified(paramBoolean);
  }

  public final void a(Object paramObject1, Object paramObject2)
  {
    ((SearchView)paramObject1).setOnQueryTextListener((SearchView.OnQueryTextListener)paramObject2);
  }

  public final void b(View paramView, boolean paramBoolean)
  {
    ((SearchView)paramView).setSubmitButtonEnabled(paramBoolean);
  }

  public final void b(Object paramObject1, Object paramObject2)
  {
    ((SearchView)paramObject1).setOnCloseListener((SearchView.OnCloseListener)paramObject2);
  }

  public final boolean b(View paramView)
  {
    return ((SearchView)paramView).isIconified();
  }

  public final void c(View paramView, boolean paramBoolean)
  {
    ((SearchView)paramView).setQueryRefinementEnabled(paramBoolean);
  }

  public final boolean c(View paramView)
  {
    return ((SearchView)paramView).isSubmitButtonEnabled();
  }

  public final boolean d(View paramView)
  {
    return ((SearchView)paramView).isQueryRefinementEnabled();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.v
 * JD-Core Version:    0.6.2
 */