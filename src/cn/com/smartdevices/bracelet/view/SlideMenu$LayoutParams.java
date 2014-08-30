package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.xiaomi.hm.health.R.styleable;

public class SlideMenu$LayoutParams extends ViewGroup.MarginLayoutParams
{
  public static final int ROLE_CONTENT = 0;
  public static final int ROLE_PRIMARY_MENU = 1;
  public static final int ROLE_SECONDARY_MENU = 2;
  public int role;

  public SlideMenu$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }

  public SlideMenu$LayoutParams(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    this.role = paramInt3;
  }

  public SlideMenu$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SlideMenu_Layout, 0, 0);
    int i = localTypedArray.getIndexCount();
    int j = 0;
    if (j >= i);
    switch (this.role)
    {
    default:
      throw new IllegalArgumentException("You must specified a layout_role for this view");
      switch (localTypedArray.getIndex(j))
      {
      default:
      case 0:
      }
      while (true)
      {
        j++;
        break;
        this.role = localTypedArray.getInt(0, -1);
      }
    case 0:
      this.width = -1;
      this.height = -1;
    case 1:
    case 2:
    }
    localTypedArray.recycle();
  }

  public SlideMenu$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    if ((paramLayoutParams instanceof LayoutParams))
      this.role = ((LayoutParams)paramLayoutParams).role;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.SlideMenu.LayoutParams
 * JD-Core Version:    0.6.2
 */