package cn.com.smartdevices.bracelet.lua;

import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.View;

final class l extends ViewDragHelper.Callback
{
  private l(SlidingUpPanelLayout paramSlidingUpPanelLayout)
  {
  }

  public final int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
  {
    int j;
    int i;
    if (SlidingUpPanelLayout.access$10(this.a))
    {
      j = SlidingUpPanelLayout.access$11(this.a);
      i = j + SlidingUpPanelLayout.access$2(this.a);
    }
    while (true)
    {
      return Math.min(Math.max(paramInt1, j), i + this.a.getPullDownDistance());
      i = this.a.getPaddingTop();
      j = i - SlidingUpPanelLayout.access$2(this.a);
    }
  }

  public final int getViewVerticalDragRange(View paramView)
  {
    return SlidingUpPanelLayout.access$2(this.a);
  }

  public final void onViewCaptured(View paramView, int paramInt)
  {
    this.a.setAllChildrenVisible();
    SlidingUpPanelLayout.access$8(this.a, Boolean.valueOf(true));
  }

  public final void onViewDragStateChanged(int paramInt)
  {
    int i = (int)(SlidingUpPanelLayout.access$1(this.a) * SlidingUpPanelLayout.access$2(this.a));
    if (SlidingUpPanelLayout.access$3(this.a).getViewDragState() == 0)
    {
      if (SlidingUpPanelLayout.access$4(this.a) != 0.0F)
        break label88;
      if (SlidingUpPanelLayout.access$5(this.a) != n.a)
      {
        this.a.updateObscuredViewVisibility();
        this.a.dispatchOnPanelExpanded(SlidingUpPanelLayout.access$6(this.a));
        SlidingUpPanelLayout.access$7(this.a, n.a);
      }
    }
    label88: 
    do
    {
      do
      {
        return;
        if (SlidingUpPanelLayout.access$4(this.a) != i / SlidingUpPanelLayout.access$2(this.a))
          break;
      }
      while (SlidingUpPanelLayout.access$5(this.a) == n.c);
      this.a.updateObscuredViewVisibility();
      this.a.dispatchOnPanelAnchored(SlidingUpPanelLayout.access$6(this.a));
      SlidingUpPanelLayout.access$7(this.a, n.c);
      return;
    }
    while (SlidingUpPanelLayout.access$5(this.a) == n.b);
    this.a.dispatchOnPanelCollapsed(SlidingUpPanelLayout.access$6(this.a));
    SlidingUpPanelLayout.access$7(this.a, n.b);
  }

  public final void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SlidingUpPanelLayout.access$9(this.a, paramInt2);
    this.a.invalidate();
  }

  public final void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
  {
    SlidingUpPanelLayout.access$8(this.a, Boolean.valueOf(false));
    int i;
    float f3;
    if (SlidingUpPanelLayout.access$10(this.a))
    {
      i = SlidingUpPanelLayout.access$11(this.a);
      if (SlidingUpPanelLayout.access$1(this.a) == 0.0F)
        break label296;
      if (!SlidingUpPanelLayout.access$10(this.a))
        break label180;
      f3 = (int)(SlidingUpPanelLayout.access$1(this.a) * SlidingUpPanelLayout.access$2(this.a)) / SlidingUpPanelLayout.access$2(this.a);
      label81: if ((paramFloat2 <= 0.0F) && ((paramFloat2 != 0.0F) || (SlidingUpPanelLayout.access$4(this.a) < (f3 + 1.0F) / 2.0F)))
        break label232;
      i += SlidingUpPanelLayout.access$2(this.a);
    }
    label296: 
    while (true)
    {
      if (this.a.getPullDownDockEnable().booleanValue())
        break label336;
      SlidingUpPanelLayout.access$3(this.a).settleCapturedViewAt(paramView.getLeft(), i);
      this.a.invalidate();
      return;
      i = SlidingUpPanelLayout.access$11(this.a) - SlidingUpPanelLayout.access$2(this.a);
      break;
      label180: int j = SlidingUpPanelLayout.access$12(this.a) - (int)(SlidingUpPanelLayout.access$1(this.a) * SlidingUpPanelLayout.access$2(this.a));
      f3 = (SlidingUpPanelLayout.access$12(this.a) - j) / SlidingUpPanelLayout.access$2(this.a);
      break label81;
      label232: if ((paramFloat2 == 0.0F) && (SlidingUpPanelLayout.access$4(this.a) < (f3 + 1.0F) / 2.0F) && (SlidingUpPanelLayout.access$4(this.a) >= f3 / 2.0F))
      {
        i = (int)(i + SlidingUpPanelLayout.access$2(this.a) * SlidingUpPanelLayout.access$1(this.a));
        continue;
        if ((paramFloat2 > 0.0F) || ((paramFloat2 == 0.0F) && (SlidingUpPanelLayout.access$4(this.a) > 0.5F)))
          i += SlidingUpPanelLayout.access$2(this.a);
      }
    }
    label336: float f1 = this.a.getSlideThreshhold();
    float f2 = this.a.getSlideThreshhold2();
    if ((0.0F != f1) && (SlidingUpPanelLayout.access$4(this.a) > f1))
      SlidingUpPanelLayout.access$3(this.a).settleCapturedViewAt(paramView.getLeft(), (int)(i - SlidingUpPanelLayout.access$2(this.a) + f2 * SlidingUpPanelLayout.access$2(this.a)));
    while (true)
    {
      this.a.invalidate();
      return;
      SlidingUpPanelLayout.access$3(this.a).settleCapturedViewAt(paramView.getLeft(), i);
    }
  }

  public final boolean tryCaptureView(View paramView, int paramInt)
  {
    if (SlidingUpPanelLayout.access$0(this.a))
      return false;
    return ((SlidingUpPanelLayout.LayoutParams)paramView.getLayoutParams()).slideable;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.l
 * JD-Core Version:    0.6.2
 */