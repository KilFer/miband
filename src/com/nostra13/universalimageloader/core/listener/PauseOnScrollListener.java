package com.nostra13.universalimageloader.core.listener;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.nostra13.universalimageloader.core.ImageLoader;

public class PauseOnScrollListener
  implements AbsListView.OnScrollListener
{
  private ImageLoader a;
  private final boolean b;
  private final boolean c;
  private final AbsListView.OnScrollListener d;

  public PauseOnScrollListener(ImageLoader paramImageLoader, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramImageLoader, paramBoolean1, paramBoolean2, null);
  }

  public PauseOnScrollListener(ImageLoader paramImageLoader, boolean paramBoolean1, boolean paramBoolean2, AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a = paramImageLoader;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramOnScrollListener;
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.d != null)
      this.d.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      if (this.d != null)
        this.d.onScrollStateChanged(paramAbsListView, paramInt);
      return;
      this.a.resume();
      continue;
      if (this.b)
      {
        this.a.pause();
        continue;
        if (this.c)
          this.a.pause();
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.listener.PauseOnScrollListener
 * JD-Core Version:    0.6.2
 */