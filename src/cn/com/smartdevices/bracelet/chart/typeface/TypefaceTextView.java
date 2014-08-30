package cn.com.smartdevices.bracelet.chart.typeface;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TypefaceTextView extends TextView
{
  public TypefaceTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypefaceManager.getInstance().applyTypeface(this, paramContext, paramAttributeSet);
  }

  public void setTextStyle(TypefaceManager.TextStyle paramTextStyle)
  {
    TypefaceManager.getInstance().applyTypeface(this, paramTextStyle);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.typeface.TypefaceTextView
 * JD-Core Version:    0.6.2
 */