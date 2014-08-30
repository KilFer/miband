package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

final class aH
  implements Comparator<View>
{
  private static int a(View paramView1, View paramView2)
  {
    ViewPager.LayoutParams localLayoutParams1 = (ViewPager.LayoutParams)paramView1.getLayoutParams();
    ViewPager.LayoutParams localLayoutParams2 = (ViewPager.LayoutParams)paramView2.getLayoutParams();
    if (localLayoutParams1.isDecor != localLayoutParams2.isDecor)
    {
      if (localLayoutParams1.isDecor)
        return 1;
      return -1;
    }
    return localLayoutParams1.c - localLayoutParams2.c;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.aH
 * JD-Core Version:    0.6.2
 */