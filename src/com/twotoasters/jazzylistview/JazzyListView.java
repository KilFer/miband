package com.twotoasters.jazzylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public class JazzyListView extends ListView
{
  private final JazzyHelper a;

  public JazzyListView(Context paramContext)
  {
    super(paramContext);
    this.a = a(paramContext, null);
  }

  public JazzyListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = a(paramContext, paramAttributeSet);
  }

  public JazzyListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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

  public void setMaxAnimationVelocity(int paramInt)
  {
    this.a.setMaxAnimationVelocity(paramInt);
  }

  public final void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.setOnScrollListener(paramOnScrollListener);
  }

  public void setShouldOnlyAnimateFling(boolean paramBoolean)
  {
    this.a.setShouldOnlyAnimateFling(paramBoolean);
  }

  public void setShouldOnlyAnimateNewItems(boolean paramBoolean)
  {
    this.a.setShouldOnlyAnimateNewItems(paramBoolean);
  }

  public void setSimulateGridWithList(boolean paramBoolean)
  {
    this.a.setSimulateGridWithList(paramBoolean);
    if (paramBoolean);
    for (boolean bool = false; ; bool = true)
    {
      setClipChildren(bool);
      return;
    }
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
 * Qualified Name:     com.twotoasters.jazzylistview.JazzyListView
 * JD-Core Version:    0.6.2
 */