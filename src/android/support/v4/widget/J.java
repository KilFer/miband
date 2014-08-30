package android.support.v4.widget;

import android.view.View;

final class J extends ViewDragHelper.Callback
{
  private J(SlidingPaneLayout paramSlidingPaneLayout)
  {
  }

  public final int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
  {
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.d(this.a).getLayoutParams();
    int i = this.a.getPaddingLeft() + localLayoutParams.leftMargin;
    int j = i + SlidingPaneLayout.e(this.a);
    return Math.min(Math.max(paramInt1, i), j);
  }

  public final int getViewHorizontalDragRange(View paramView)
  {
    return SlidingPaneLayout.e(this.a);
  }

  public final void onEdgeDragStarted(int paramInt1, int paramInt2)
  {
    SlidingPaneLayout.b(this.a).captureChildView(SlidingPaneLayout.d(this.a), paramInt2);
  }

  public final void onViewCaptured(View paramView, int paramInt)
  {
    this.a.a();
  }

  public final void onViewDragStateChanged(int paramInt)
  {
    if (SlidingPaneLayout.b(this.a).getViewDragState() == 0)
    {
      if (SlidingPaneLayout.c(this.a) == 0.0F)
      {
        this.a.c(SlidingPaneLayout.d(this.a));
        this.a.b(SlidingPaneLayout.d(this.a));
        SlidingPaneLayout.a(this.a, false);
      }
    }
    else
      return;
    this.a.a(SlidingPaneLayout.d(this.a));
    SlidingPaneLayout.a(this.a, true);
  }

  public final void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SlidingPaneLayout.a(this.a, paramInt1);
    this.a.invalidate();
  }

  public final void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
  {
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    int i = this.a.getPaddingLeft() + localLayoutParams.leftMargin;
    if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SlidingPaneLayout.c(this.a) > 0.5F)))
      i += SlidingPaneLayout.e(this.a);
    SlidingPaneLayout.b(this.a).settleCapturedViewAt(i, paramView.getTop());
    this.a.invalidate();
  }

  public final boolean tryCaptureView(View paramView, int paramInt)
  {
    if (SlidingPaneLayout.a(this.a))
      return false;
    return ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.J
 * JD-Core Version:    0.6.2
 */