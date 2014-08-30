package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

public class PersonPageUserInfoView extends FrameLayout
{
  private static final String a = "PersonPageUserInfoView";
  private LayoutInflater b;
  private String c;

  public PersonPageUserInfoView(Context paramContext)
  {
    super(paramContext);
    this.b = LayoutInflater.from(paramContext);
    this.b.inflate(2130903122, this);
  }

  public PersonPageUserInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext);
  }

  public PersonPageUserInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.PersonPageUserInfoView
 * JD-Core Version:    0.6.2
 */