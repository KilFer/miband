package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;

public class HoriRulerView extends FrameLayout
{
  private static final String a = "HoriRulerView";
  private RulerScrollView b;
  private View c;
  private LayoutInflater d;
  private String e;
  private int f = 50;
  private int g = 80;

  public HoriRulerView(Context paramContext)
  {
    super(paramContext);
  }

  public HoriRulerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = LayoutInflater.from(paramContext);
    this.d.inflate(2130903125, this);
    this.b = ((RulerScrollView)findViewById(2131165573));
    this.c = findViewById(2131165574);
    this.b.setIndicatorView(this.c);
  }

  public HoriRulerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void addView(View paramView)
  {
    this.b.addView(paramView);
  }

  public float getCurValue()
  {
    return this.b.getCurValue();
  }

  public int getScrollLeft()
  {
    return this.b.getScrollLeft();
  }

  public void initRuler(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    while (true)
    {
      if (paramInt1 >= paramInt2)
      {
        Debug.i("HoriRulerView", "initRuler");
        this.b.setStartEnd(this.f, this.g, paramString);
        return;
      }
      View localView = this.d.inflate(2130903126, null);
      ((TextView)localView.findViewById(2131165578)).setText(paramInt1);
      addView(localView);
      paramInt1 += paramInt3;
    }
  }

  public void setScroll(int paramInt)
  {
    this.b.setScroll(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.HoriRulerView
 * JD-Core Version:    0.6.2
 */