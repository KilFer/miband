package android.support.v4.widget;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.view.View;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;

final class B
{
  public static View a(Context paramContext)
  {
    return new SearchView(paramContext);
  }

  public static CharSequence a(View paramView)
  {
    return ((SearchView)paramView).getQuery();
  }

  public static Object a(m paramm)
  {
    return new D(paramm);
  }

  public static Object a(t paramt)
  {
    return new C(paramt);
  }

  public static void a(View paramView, int paramInt)
  {
    ((SearchView)paramView).setMaxWidth(paramInt);
  }

  public static void a(View paramView, ComponentName paramComponentName)
  {
    SearchView localSearchView = (SearchView)paramView;
    localSearchView.setSearchableInfo(((SearchManager)localSearchView.getContext().getSystemService("search")).getSearchableInfo(paramComponentName));
  }

  public static void a(View paramView, CharSequence paramCharSequence)
  {
    ((SearchView)paramView).setQueryHint(paramCharSequence);
  }

  public static void a(View paramView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    ((SearchView)paramView).setQuery(paramCharSequence, paramBoolean);
  }

  public static void a(View paramView, boolean paramBoolean)
  {
    ((SearchView)paramView).setIconified(paramBoolean);
  }

  public static void a(Object paramObject1, Object paramObject2)
  {
    ((SearchView)paramObject1).setOnQueryTextListener((SearchView.OnQueryTextListener)paramObject2);
  }

  public static void b(View paramView, boolean paramBoolean)
  {
    ((SearchView)paramView).setSubmitButtonEnabled(paramBoolean);
  }

  public static void b(Object paramObject1, Object paramObject2)
  {
    ((SearchView)paramObject1).setOnCloseListener((SearchView.OnCloseListener)paramObject2);
  }

  public static boolean b(View paramView)
  {
    return ((SearchView)paramView).isIconified();
  }

  public static void c(View paramView, boolean paramBoolean)
  {
    ((SearchView)paramView).setQueryRefinementEnabled(paramBoolean);
  }

  public static boolean c(View paramView)
  {
    return ((SearchView)paramView).isSubmitButtonEnabled();
  }

  public static boolean d(View paramView)
  {
    return ((SearchView)paramView).isQueryRefinementEnabled();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.B
 * JD-Core Version:    0.6.2
 */