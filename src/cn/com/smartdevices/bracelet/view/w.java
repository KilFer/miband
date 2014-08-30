package cn.com.smartdevices.bracelet.view;

import android.view.View;
import android.widget.HorizontalScrollView;

final class w
  implements ScrollDetectors.ScrollDetector
{
  public final boolean canScrollHorizontal(View paramView, int paramInt)
  {
    HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)paramView;
    int i = localHorizontalScrollView.getScrollX();
    if (localHorizontalScrollView.getChildCount() == 0);
    while (((paramInt >= 0) || (i >= localHorizontalScrollView.getChildAt(0).getWidth() - localHorizontalScrollView.getWidth())) && ((paramInt <= 0) || (i <= 0)))
      return false;
    return true;
  }

  public final boolean canScrollVertical(View paramView, int paramInt)
  {
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.w
 * JD-Core Version:    0.6.2
 */