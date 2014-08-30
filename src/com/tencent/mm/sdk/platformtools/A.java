package com.tencent.mm.sdk.platformtools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class A
  implements View.OnTouchListener
{
  A(View paramView1, View paramView2)
  {
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
      return false;
    case 0:
      this.a.setSelected(true);
      return false;
    case 1:
    case 3:
    case 4:
      this.a.setSelected(false);
      return false;
    case 2:
    }
    this.a.setSelected(this.b.isPressed());
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.A
 * JD-Core Version:    0.6.2
 */