package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;

public class DynamicView$FlowBgView extends View
{
  private Paint a = new Paint();
  private float b;
  private float c;
  private float d;
  private float e;

  public DynamicView$FlowBgView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public DynamicView$FlowBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DynamicView$FlowBgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.setColor(-14057287);
  }

  public Animator animFlow()
  {
    return AnimUtil.animFlow(new n(this));
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.c, this.d, this.e, this.a);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    this.b = j;
    this.e = this.b;
    this.c = (i / 2.0F);
    this.d = (0.4203719F * j);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.DynamicView.FlowBgView
 * JD-Core Version:    0.6.2
 */