package cn.com.smartdevices.bracelet.view;

import android.view.View;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class y
  implements ScrollDetectors.ScrollDetector
{
  public final boolean canScrollHorizontal(View paramView, int paramInt)
  {
    try
    {
      Method localMethod1 = WebView.class.getDeclaredMethod("computeHorizontalScrollOffset", new Class[0]);
      Method localMethod2 = WebView.class.getDeclaredMethod("computeHorizontalScrollRange", new Class[0]);
      localMethod1.setAccessible(true);
      localMethod2.setAccessible(true);
      int i = ((Integer)localMethod1.invoke(paramView, new Object[0])).intValue();
      int j = ((Integer)localMethod2.invoke(paramView, new Object[0])).intValue();
      if ((paramInt <= 0) || (paramView.getScrollX() <= 0))
        if (paramInt < 0)
        {
          int k = paramView.getWidth();
          if (i < j - k);
        }
        else
        {
          return false;
        }
      return true;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return false;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        localIllegalArgumentException.printStackTrace();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        localIllegalAccessException.printStackTrace();
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        localInvocationTargetException.printStackTrace();
    }
  }

  public final boolean canScrollVertical(View paramView, int paramInt)
  {
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.y
 * JD-Core Version:    0.6.2
 */