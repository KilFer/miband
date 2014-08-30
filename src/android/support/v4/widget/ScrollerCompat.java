package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

public class ScrollerCompat
{
  private static p b = new q();
  private Object a;

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14)
    {
      b = new s();
      return;
    }
    if (i >= 9)
    {
      b = new r();
      return;
    }
  }

  private ScrollerCompat(Context paramContext, Interpolator paramInterpolator)
  {
    this.a = b.a(paramContext, paramInterpolator);
  }

  public static ScrollerCompat create(Context paramContext)
  {
    return create(paramContext, null);
  }

  public static ScrollerCompat create(Context paramContext, Interpolator paramInterpolator)
  {
    return new ScrollerCompat(paramContext, paramInterpolator);
  }

  public void abortAnimation()
  {
    b.f(this.a);
  }

  public boolean computeScrollOffset()
  {
    return b.e(this.a);
  }

  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    b.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }

  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    b.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }

  public float getCurrVelocity()
  {
    return b.d(this.a);
  }

  public int getCurrX()
  {
    return b.b(this.a);
  }

  public int getCurrY()
  {
    return b.c(this.a);
  }

  public int getFinalX()
  {
    return b.h(this.a);
  }

  public int getFinalY()
  {
    return b.i(this.a);
  }

  public boolean isFinished()
  {
    return b.a(this.a);
  }

  public boolean isOverScrolled()
  {
    return b.g(this.a);
  }

  public void notifyHorizontalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    b.a(this.a, paramInt1, paramInt2, paramInt3);
  }

  public void notifyVerticalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    b.b(this.a, paramInt1, paramInt2, paramInt3);
  }

  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    b.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ScrollerCompat
 * JD-Core Version:    0.6.2
 */