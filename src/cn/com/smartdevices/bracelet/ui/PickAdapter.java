package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.eventbus.Event12HourUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventAmPmUpdate;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.WheelViewAdapter;

public class PickAdapter
  implements WheelViewAdapter
{
  public static final int MIDDLE_LARGE_NUM = 8388607;
  public static final String STYLE_MI_UI = "miui";
  public static final String STYLE_NORMAL = "normal";
  private static final String a = "PickAdapter";
  private static final int b = 16777215;
  private float c;
  private float d;
  private float e;
  private int f;
  private float g;
  private int h = 0;
  private int i;
  private boolean j;
  private int k;
  private int l;
  private int m;
  private int n;
  private WheelView o;
  private LayoutInflater p;
  private Context q;
  private int r = 1;
  private int s;
  private String t;

  public PickAdapter(Context paramContext, int paramInt1, int paramInt2, WheelView paramWheelView, int paramInt3, int paramInt4)
  {
    this(paramContext, paramInt1, paramInt2, paramWheelView, paramInt3, paramInt4, false);
  }

  public PickAdapter(Context paramContext, int paramInt1, int paramInt2, WheelView paramWheelView, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this(paramContext, paramInt1, paramInt2, paramWheelView, paramInt3, paramInt4, paramInt5, paramBoolean, paramInt6, paramInt7, paramInt8, paramInt9, 1);
  }

  public PickAdapter(Context paramContext, int paramInt1, int paramInt2, WheelView paramWheelView, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    this.q = paramContext;
    this.n = paramInt1;
    this.m = paramInt2;
    this.o = paramWheelView;
    this.p = LayoutInflater.from(paramContext);
    this.k = paramInt3;
    this.l = paramInt4;
    this.f = paramInt5;
    this.j = paramBoolean;
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    this.g = TypedValue.applyDimension(1, paramInt6, localDisplayMetrics);
    this.c = TypedValue.applyDimension(1, paramInt7, localDisplayMetrics);
    this.d = TypedValue.applyDimension(1, paramInt8, localDisplayMetrics);
    this.e = TypedValue.applyDimension(1, paramInt9, localDisplayMetrics);
    setValueGap(paramInt10);
    this.h = (1 + (this.m - this.n));
    this.i = (this.h * (8388607 / this.h));
  }

  public PickAdapter(Context paramContext, int paramInt1, int paramInt2, WheelView paramWheelView, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this(paramContext, paramInt1, paramInt2, paramWheelView, paramInt3, paramInt4, -2003199591, paramBoolean, 32, 11, 10, 9, 1);
  }

  public int getBASE_BUNDLE()
  {
    return this.h;
  }

  public View getEmptyItem(View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }

  public int getInitLoopBase()
  {
    return this.i;
  }

  public View getItem(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramView;
    int i1 = paramInt % this.h;
    RelativeLayout localRelativeLayout2;
    if (localRelativeLayout1 == null)
      if ("normal".equals(this.t))
      {
        localRelativeLayout2 = (RelativeLayout)this.p.inflate(2130903145, null);
        aX localaX = new aX(this, (byte)0);
        localaX.a = ((TextView)localRelativeLayout2.findViewById(2131165681));
        localaX.a.getLayoutParams().height = ((int)this.g);
        localRelativeLayout2.setTag(localaX);
      }
    while (true)
    {
      TextView localTextView = ((aX)localRelativeLayout2.getTag()).a;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf((i1 + this.n) * this.r);
      localTextView.setText(String.format("%02d", arrayOfObject1));
      int i2 = this.o.getRealCurrentItem();
      Debug.i("PickAdapter", "realCurIndex =" + i2 + ", pos=" + i1);
      label224: int i4;
      switch (this.s)
      {
      default:
        i4 = (int)this.c;
        if (paramInt == i2)
          localTextView.setTextColor(this.k);
        break;
      case 17:
      case 16:
      case 9:
      }
      while (true)
      {
        localTextView.setTextSize(i4);
        return localRelativeLayout2;
        localRelativeLayout2 = (RelativeLayout)this.p.inflate(2130903144, null);
        break;
        if (i1 == 0)
          localTextView.setText(this.q.getString(2131493187));
        while (paramInt == i2)
        {
          EventBus.getDefault().post(new EventAmPmUpdate(i1));
          break;
          localTextView.setText(this.q.getString(2131493188));
        }
        int i5 = i1 + this.n;
        if (i5 == 0)
          localTextView.setText("12");
        while (i2 == paramInt)
        {
          EventBus.getDefault().post(new Event12HourUpdate(i5));
          break;
          if (i5 > 12)
          {
            int i6 = i5 - 12;
            Object[] arrayOfObject3 = new Object[1];
            arrayOfObject3[0] = Integer.valueOf(i6);
            localTextView.setText(String.format("%02d", arrayOfObject3));
          }
        }
        int i3 = i1 + this.n;
        if (i3 < 0)
          i3 += 24;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(i3);
        localTextView.setText(String.format("%02d", arrayOfObject2));
        break label224;
        if ((paramInt == i2 - 1) || (paramInt == i2 + 1))
        {
          i4 = (int)this.d;
          localTextView.setTextColor(this.l);
        }
        else
        {
          i4 = (int)this.e;
          localTextView.setTextColor(this.f);
        }
      }
      localRelativeLayout2 = localRelativeLayout1;
    }
  }

  public int getItemsCount()
  {
    if (this.j)
      return 16777215;
    return this.h;
  }

  public boolean isNeedLoop()
  {
    return this.j;
  }

  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
  }

  public void setMode(int paramInt)
  {
    this.s = paramInt;
  }

  public void setUIStyle(String paramString)
  {
    this.t = paramString;
  }

  public void setValueGap(int paramInt)
  {
    this.r = paramInt;
  }

  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.PickAdapter
 * JD-Core Version:    0.6.2
 */