package kankan.wheel.widget.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class AbstractWheelTextAdapter extends AbstractWheelAdapter
{
  public static final int DEFAULT_TEXT_COLOR = -15724528;
  public static final int DEFAULT_TEXT_SIZE = 20;
  public static final int LABEL_COLOR = -9437072;
  protected static final int NO_RESOURCE = 0;
  public static final int TEXT_VIEW_ITEM_RESOURCE = -1;
  private int a = -15724528;
  private int b = 20;
  protected Context context;
  protected int emptyItemResourceId;
  protected LayoutInflater inflater;
  protected int itemResourceId;
  protected int itemTextResourceId;

  protected AbstractWheelTextAdapter(Context paramContext)
  {
    this(paramContext, -1);
  }

  protected AbstractWheelTextAdapter(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 0);
  }

  protected AbstractWheelTextAdapter(Context paramContext, int paramInt1, int paramInt2)
  {
    this.context = paramContext;
    this.itemResourceId = paramInt1;
    this.itemTextResourceId = paramInt2;
    this.inflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }

  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (paramInt)
    {
    default:
      return this.inflater.inflate(paramInt, paramViewGroup, false);
    case 0:
      return null;
    case -1:
    }
    return new TextView(this.context);
  }

  private static TextView a(View paramView, int paramInt)
  {
    if (paramInt == 0);
    try
    {
      if ((paramView instanceof TextView))
        return (TextView)paramView;
      if (paramInt != 0)
      {
        TextView localTextView = (TextView)paramView.findViewById(paramInt);
        return localTextView;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      Log.e("AbstractWheelAdapter", "You must supply a resource ID for a TextView");
      throw new IllegalStateException("AbstractWheelAdapter requires the resource ID to be a TextView", localClassCastException);
    }
    return null;
  }

  protected void configureTextView(TextView paramTextView)
  {
    paramTextView.setGravity(17);
    paramTextView.setTextSize(this.b);
    paramTextView.setLines(1);
    paramTextView.setTypeface(Typeface.SANS_SERIF, 0);
    paramTextView.setPadding(0, 10, 0, 10);
  }

  public View getEmptyItem(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null);
    for (View localView = a(this.emptyItemResourceId, paramViewGroup); ; localView = paramView)
    {
      if ((this.emptyItemResourceId == -1) && ((localView instanceof TextView)))
        configureTextView((TextView)localView);
      return localView;
    }
  }

  public int getEmptyItemResource()
  {
    return this.emptyItemResourceId;
  }

  public View getItem(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      if (paramView == null)
        paramView = a(this.itemResourceId, paramViewGroup);
      TextView localTextView = a(paramView, this.itemTextResourceId);
      if (localTextView != null)
      {
        Object localObject = getItemText(paramInt);
        if (localObject == null)
          localObject = "";
        localTextView.setText((CharSequence)localObject);
        if (this.itemResourceId == -1)
          configureTextView(localTextView);
      }
      return paramView;
    }
    return null;
  }

  public int getItemResource()
  {
    return this.itemResourceId;
  }

  protected abstract CharSequence getItemText(int paramInt);

  public int getItemTextResource()
  {
    return this.itemTextResourceId;
  }

  public int getTextColor()
  {
    return this.a;
  }

  public int getTextSize()
  {
    return this.b;
  }

  public void setEmptyItemResource(int paramInt)
  {
    this.emptyItemResourceId = paramInt;
  }

  public void setItemResource(int paramInt)
  {
    this.itemResourceId = paramInt;
  }

  public void setItemTextResource(int paramInt)
  {
    this.itemTextResourceId = paramInt;
  }

  public void setTextColor(int paramInt)
  {
    this.a = paramInt;
  }

  public void setTextSize(int paramInt)
  {
    this.b = paramInt;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.adapters.AbstractWheelTextAdapter
 * JD-Core Version:    0.6.2
 */