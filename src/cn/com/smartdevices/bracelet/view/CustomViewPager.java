package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.xiaomi.hm.health.R.styleable;

public class CustomViewPager extends ViewPager
{
  private boolean a;

  public CustomViewPager(Context paramContext)
  {
    super(paramContext);
  }

  public CustomViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CustomViewPager);
    try
    {
      this.a = localTypedArray.getBoolean(0, true);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public boolean isSwipeable()
  {
    return this.a;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a)
      return super.onInterceptTouchEvent(paramMotionEvent);
    return false;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a)
      return super.onTouchEvent(paramMotionEvent);
    return false;
  }

  public void setSwipeable(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.CustomViewPager
 * JD-Core Version:    0.6.2
 */