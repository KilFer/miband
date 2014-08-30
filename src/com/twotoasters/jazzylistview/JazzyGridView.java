package com.twotoasters.jazzylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView.OnScrollListener;
import android.widget.GridView;

public class JazzyGridView extends GridView
{
  private final JazzyHelper a;

  public JazzyGridView(Context paramContext)
  {
    super(paramContext);
    this.a = a(paramContext, null);
  }

  public JazzyGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = a(paramContext, paramAttributeSet);
  }

  public JazzyGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = a(paramContext, paramAttributeSet);
  }

  private JazzyHelper a(Context paramContext, AttributeSet paramAttributeSet)
  {
    JazzyHelper localJazzyHelper = new JazzyHelper(paramContext, paramAttributeSet);
    super.setOnScrollListener(localJazzyHelper);
    return localJazzyHelper;
  }

  public final void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.setOnScrollListener(paramOnScrollListener);
  }

  public void setShouldOnlyAnimateNewItems(boolean paramBoolean)
  {
    this.a.setShouldOnlyAnimateNewItems(paramBoolean);
  }

  public void setTransitionEffect(int paramInt)
  {
    this.a.setTransitionEffect(paramInt);
  }

  public void setTransitionEffect(JazzyEffect paramJazzyEffect)
  {
    this.a.setTransitionEffect(paramJazzyEffect);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.twotoasters.jazzylistview.JazzyGridView
 * JD-Core Version:    0.6.2
 */