package com.tencent.open;

import android.view.ViewGroup;

final class t
  implements Runnable
{
  t(TaskGuide paramTaskGuide, int paramInt)
  {
  }

  public final void run()
  {
    if (TaskGuide.a(this.b))
    {
      if (this.a != 0)
        break label42;
      ((D)TaskGuide.b(this.b).findViewById(1)).a(TaskGuide.c(this.b));
    }
    label42: 
    do
    {
      do
      {
        return;
        if (this.a == 1)
        {
          ((D)TaskGuide.b(this.b).findViewById(2)).a(TaskGuide.d(this.b));
          return;
        }
      }
      while (this.a != 2);
      ((D)TaskGuide.b(this.b).findViewById(1)).a(TaskGuide.c(this.b));
    }
    while (TaskGuide.b(this.b).getChildCount() <= 1);
    ((D)TaskGuide.b(this.b).findViewById(2)).a(TaskGuide.d(this.b));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.t
 * JD-Core Version:    0.6.2
 */