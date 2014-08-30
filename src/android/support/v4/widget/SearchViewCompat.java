package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;

public class SearchViewCompat
{
  private static final z a = new z();

  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new y();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new v();
      return;
    }
  }

  public static CharSequence getQuery(View paramView)
  {
    return a.a(paramView);
  }

  public static boolean isIconified(View paramView)
  {
    return a.b(paramView);
  }

  public static boolean isQueryRefinementEnabled(View paramView)
  {
    return a.d(paramView);
  }

  public static boolean isSubmitButtonEnabled(View paramView)
  {
    return a.c(paramView);
  }

  public static View newSearchView(Context paramContext)
  {
    return a.a(paramContext);
  }

  public static void setIconified(View paramView, boolean paramBoolean)
  {
    a.a(paramView, paramBoolean);
  }

  public static void setImeOptions(View paramView, int paramInt)
  {
    a.b(paramView, paramInt);
  }

  public static void setInputType(View paramView, int paramInt)
  {
    a.c(paramView, paramInt);
  }

  public static void setMaxWidth(View paramView, int paramInt)
  {
    a.a(paramView, paramInt);
  }

  public static void setOnCloseListener(View paramView, SearchViewCompat.OnCloseListenerCompat paramOnCloseListenerCompat)
  {
    a.b(paramView, paramOnCloseListenerCompat.a);
  }

  public static void setOnQueryTextListener(View paramView, SearchViewCompat.OnQueryTextListenerCompat paramOnQueryTextListenerCompat)
  {
    a.a(paramView, paramOnQueryTextListenerCompat.a);
  }

  public static void setQuery(View paramView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a.a(paramView, paramCharSequence, paramBoolean);
  }

  public static void setQueryHint(View paramView, CharSequence paramCharSequence)
  {
    a.a(paramView, paramCharSequence);
  }

  public static void setQueryRefinementEnabled(View paramView, boolean paramBoolean)
  {
    a.c(paramView, paramBoolean);
  }

  public static void setSearchableInfo(View paramView, ComponentName paramComponentName)
  {
    a.a(paramView, paramComponentName);
  }

  public static void setSubmitButtonEnabled(View paramView, boolean paramBoolean)
  {
    a.b(paramView, paramBoolean);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SearchViewCompat
 * JD-Core Version:    0.6.2
 */