package com.tencent.open;

import android.widget.Toast;

final class r
  implements Runnable
{
  r(TaskGuide paramTaskGuide, String paramString)
  {
  }

  public final void run()
  {
    Toast.makeText(TaskGuide.z(this.b), "失败：" + this.a, 1).show();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.r
 * JD-Core Version:    0.6.2
 */