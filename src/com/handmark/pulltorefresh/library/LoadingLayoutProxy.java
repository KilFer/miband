package com.handmark.pulltorefresh.library;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import java.util.HashSet;
import java.util.Iterator;

public class LoadingLayoutProxy
  implements ILoadingLayout
{
  private final HashSet<LoadingLayout> a = new HashSet();

  public void addLayout(LoadingLayout paramLoadingLayout)
  {
    if (paramLoadingLayout != null)
      this.a.add(paramLoadingLayout);
  }

  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((LoadingLayout)localIterator.next()).setLastUpdatedLabel(paramCharSequence);
    }
  }

  public void setLoadingDrawable(Drawable paramDrawable)
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((LoadingLayout)localIterator.next()).setLoadingDrawable(paramDrawable);
    }
  }

  public void setPullLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((LoadingLayout)localIterator.next()).setPullLabel(paramCharSequence);
    }
  }

  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((LoadingLayout)localIterator.next()).setRefreshingLabel(paramCharSequence);
    }
  }

  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((LoadingLayout)localIterator.next()).setReleaseLabel(paramCharSequence);
    }
  }

  public void setTextTypeface(Typeface paramTypeface)
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((LoadingLayout)localIterator.next()).setTextTypeface(paramTypeface);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.LoadingLayoutProxy
 * JD-Core Version:    0.6.2
 */