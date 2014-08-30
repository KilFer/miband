package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public class EdgeEffectCompat
{
  private static final l b = new a();
  private Object a;

  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      b = new k();
      return;
    }
  }

  public EdgeEffectCompat(Context paramContext)
  {
    this.a = b.a(paramContext);
  }

  public boolean draw(Canvas paramCanvas)
  {
    return b.a(this.a, paramCanvas);
  }

  public void finish()
  {
    b.b(this.a);
  }

  public boolean isFinished()
  {
    return b.a(this.a);
  }

  public boolean onAbsorb(int paramInt)
  {
    return b.a(this.a, paramInt);
  }

  public boolean onPull(float paramFloat)
  {
    return b.a(this.a, paramFloat);
  }

  public boolean onRelease()
  {
    return b.c(this.a);
  }

  public void setSize(int paramInt1, int paramInt2)
  {
    b.a(this.a, paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.EdgeEffectCompat
 * JD-Core Version:    0.6.2
 */