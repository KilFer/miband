package kankan.wheel.widget;

import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedList;
import java.util.List;
import kankan.wheel.widget.adapters.WheelViewAdapter;

public class WheelRecycle
{
  private List<View> a;
  private List<View> b;
  private WheelView c;

  public WheelRecycle(WheelView paramWheelView)
  {
    this.c = paramWheelView;
  }

  private static View a(List<View> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      View localView = (View)paramList.get(0);
      paramList.remove(0);
      return localView;
    }
    return null;
  }

  private static List<View> a(View paramView, List<View> paramList)
  {
    if (paramList == null)
      paramList = new LinkedList();
    paramList.add(paramView);
    return paramList;
  }

  private void a(View paramView, int paramInt)
  {
    int i = this.c.getViewAdapter().getItemsCount();
    if (((paramInt < 0) || (paramInt >= i)) && (!this.c.isCyclic()))
    {
      this.b = a(paramView, this.b);
      return;
    }
    this.a = a(paramView, this.a);
  }

  public void clearAll()
  {
    if (this.a != null)
      this.a.clear();
    if (this.b != null)
      this.b.clear();
  }

  public View getEmptyItem()
  {
    return a(this.b);
  }

  public View getItem()
  {
    return a(this.a);
  }

  public int recycleItems(LinearLayout paramLinearLayout, int paramInt, ItemsRange paramItemsRange)
  {
    int i = 0;
    int j = paramInt;
    if (i >= paramLinearLayout.getChildCount())
      return j;
    View localView;
    if (!paramItemsRange.contains(paramInt))
    {
      localView = paramLinearLayout.getChildAt(i);
      int k = this.c.getViewAdapter().getItemsCount();
      if (((paramInt < 0) || (paramInt >= k)) && (!this.c.isCyclic()))
      {
        this.b = a(localView, this.b);
        label81: paramLinearLayout.removeViewAt(i);
        if (i == 0)
          j++;
      }
    }
    while (true)
    {
      paramInt++;
      break;
      this.a = a(localView, this.a);
      break label81;
      i++;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.WheelRecycle
 * JD-Core Version:    0.6.2
 */