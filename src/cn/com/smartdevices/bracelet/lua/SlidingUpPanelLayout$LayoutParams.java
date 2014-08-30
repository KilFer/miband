package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class SlidingUpPanelLayout$LayoutParams extends ViewGroup.MarginLayoutParams
{
  private static final int[] ATTRS = { 16843137 };
  Paint dimPaint;
  boolean dimWhenOffset;
  boolean slideable;

  public SlidingUpPanelLayout$LayoutParams()
  {
    super(-1, -1);
  }

  public SlidingUpPanelLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }

  public SlidingUpPanelLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS).recycle();
  }

  public SlidingUpPanelLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }

  public SlidingUpPanelLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }

  public SlidingUpPanelLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.LayoutParams
 * JD-Core Version:    0.6.2
 */