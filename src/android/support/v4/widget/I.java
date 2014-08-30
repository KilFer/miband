package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.ArrayList;

final class I
  implements Runnable
{
  private View a;

  I(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    this.a = paramView;
  }

  public final void run()
  {
    if (this.a.getParent() == this.b)
    {
      ViewCompat.setLayerType(this.a, 0, null);
      SlidingPaneLayout.a(this.b, this.a);
    }
    SlidingPaneLayout.f(this.b).remove(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.I
 * JD-Core Version:    0.6.2
 */