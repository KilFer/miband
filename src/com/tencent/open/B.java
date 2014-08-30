package com.tencent.open;

import android.view.View;
import android.view.View.OnClickListener;

final class B
  implements View.OnClickListener
{
  private int a;

  public B(TaskGuide paramTaskGuide, int paramInt)
  {
    this.a = paramInt;
  }

  public final void onClick(View paramView)
  {
    if (TaskGuide.a(this.b, this.a) == z.d)
    {
      TaskGuide.b(this.b, this.a);
      TaskGuide.c(this.b, this.a);
    }
    TaskGuide.e(this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.B
 * JD-Core Version:    0.6.2
 */