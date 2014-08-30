package cn.com.smartdevices.bracelet.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.health.R.styleable;

public class DimPanelBottomBar extends FrameLayout
{
  private static final String a = "dark";
  private final TextView b;
  private final TextView c;

  public DimPanelBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DimPanelBottomBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2130903065, this);
    this.c = ((TextView)findViewById(2131165332));
    this.b = ((TextView)findViewById(2131165334));
    View localView1 = findViewById(2131165331);
    View localView2 = findViewById(2131165333);
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DimPanelFragmentBottomBar);
    String str1 = localTypedArray.getString(0);
    String str2 = localTypedArray.getString(1);
    int i = localTypedArray.getColor(2, getResources().getColor(2131230736));
    int j = localTypedArray.getColor(3, getResources().getColor(2131230736));
    String str3 = localTypedArray.getString(4);
    Debug.i(getClass().getName(), "left:" + str1 + ", right:" + str2);
    int k = 2130837582;
    int m = 2130837583;
    int n = 2130837584;
    if ("dark".equals(str3))
    {
      k = 2130837581;
      m = 2130837585;
      n = 2130837586;
      localView2.setBackgroundResource(2131230725);
    }
    if (TextUtils.isEmpty(str1))
    {
      this.c.setVisibility(8);
      if (!TextUtils.isEmpty(str2))
        break label343;
      this.b.setVisibility(8);
      label243: if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
        break label372;
      localView2.setVisibility(0);
      localView1.setBackgroundResource(k);
      this.b.setBackgroundResource(n);
      this.c.setBackgroundResource(m);
    }
    while (true)
    {
      this.c.setTextColor(i);
      this.b.setTextColor(j);
      localTypedArray.recycle();
      return;
      this.c.setText(str1);
      this.c.setVisibility(0);
      this.c.setBackgroundResource(k);
      break;
      label343: this.b.setText(str2);
      this.b.setVisibility(0);
      this.b.setBackgroundResource(k);
      break label243;
      label372: localView2.setVisibility(8);
      localView1.setBackgroundResource(2131230755);
    }
  }

  public void setLeftButtonTextColor(int paramInt)
  {
    this.c.setTextColor(paramInt);
  }

  public void setRightButtonTextColor(int paramInt)
  {
    this.b.setTextColor(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.widget.DimPanelBottomBar
 * JD-Core Version:    0.6.2
 */