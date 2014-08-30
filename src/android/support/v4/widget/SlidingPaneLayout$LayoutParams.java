package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class SlidingPaneLayout$LayoutParams extends ViewGroup.MarginLayoutParams
{
  private static final int[] d = { 16843137 };
  boolean a;
  boolean b;
  Paint c;
  public float weight = 0.0F;

  public SlidingPaneLayout$LayoutParams()
  {
    super(-1, -1);
  }

  public SlidingPaneLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }

  public SlidingPaneLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, d);
    this.weight = localTypedArray.getFloat(0, 0.0F);
    localTypedArray.recycle();
  }

  public SlidingPaneLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.weight = paramLayoutParams.weight;
  }

  public SlidingPaneLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }

  public SlidingPaneLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout.LayoutParams
 * JD-Core Version:    0.6.2
 */