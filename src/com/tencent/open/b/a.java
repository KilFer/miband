package com.tencent.open.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class a extends RelativeLayout
{
  private static final String a;
  private Rect b = null;
  private boolean c;
  private a.a d = null;

  static
  {
    a.class.getName();
  }

  public a(Context paramContext)
  {
    super(paramContext);
    if (this.b == null)
      this.b = new Rect();
  }

  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (this.b == null)
      this.b = new Rect();
  }

  public void a(a.a parama)
  {
    this.d = parama;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt2);
    Activity localActivity = (Activity)getContext();
    localActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
    int j = this.b.top;
    int k = localActivity.getWindowManager().getDefaultDisplay().getHeight() - j - i;
    if ((this.d != null) && (i != 0))
    {
      if (k <= 100)
        break label112;
      this.d.onKeyboardShown(Math.abs(this.b.height()) - getPaddingBottom() - getPaddingTop());
    }
    while (true)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      label112: this.d.onKeyboardHidden();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.b.a
 * JD-Core Version:    0.6.2
 */