package android.support.v4.view;

import android.view.ViewGroup.MarginLayoutParams;

final class y
  implements w
{
  public final int a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return paramMarginLayoutParams.getMarginStart();
  }

  public final void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    paramMarginLayoutParams.setMarginStart(paramInt);
  }

  public final int b(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return paramMarginLayoutParams.getMarginEnd();
  }

  public final void b(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    paramMarginLayoutParams.setMarginEnd(paramInt);
  }

  public final void c(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    paramMarginLayoutParams.setLayoutDirection(paramInt);
  }

  public final boolean c(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return paramMarginLayoutParams.isMarginRelative();
  }

  public final int d(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return paramMarginLayoutParams.getLayoutDirection();
  }

  public final void d(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    paramMarginLayoutParams.resolveLayoutDirection(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.y
 * JD-Core Version:    0.6.2
 */