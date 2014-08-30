package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class VerticalViewPager$LayoutParams extends ViewGroup.LayoutParams
{
  public int gravity;
  public boolean isDecor;

  public VerticalViewPager$LayoutParams()
  {
    super(-1, -1);
  }

  public VerticalViewPager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, VerticalViewPager.b());
    this.gravity = localTypedArray.getInteger(0, 0);
    localTypedArray.recycle();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.VerticalViewPager.LayoutParams
 * JD-Core Version:    0.6.2
 */