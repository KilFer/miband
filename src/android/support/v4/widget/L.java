package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

class L
{
  public void a(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    ViewCompat.postInvalidateOnAnimation(paramSlidingPaneLayout, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.L
 * JD-Core Version:    0.6.2
 */