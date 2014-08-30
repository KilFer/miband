package cn.com.smartdevices.bracelet.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.webkit.WebView;
import android.widget.HorizontalScrollView;
import java.util.WeakHashMap;

public class ScrollDetectors
{
  private static final WeakHashMap<Class<? extends View>, ScrollDetectors.ScrollDetector> a = new WeakHashMap();
  private static ScrollDetectorFactory b;

  private static ScrollDetectors.ScrollDetector a(View paramView)
  {
    Class localClass = paramView.getClass();
    ScrollDetectors.ScrollDetector localScrollDetector = (ScrollDetectors.ScrollDetector)a.get(localClass);
    if (localScrollDetector != null)
      return localScrollDetector;
    Object localObject;
    if ((paramView instanceof ViewPager))
      localObject = new x((byte)0);
    while (true)
    {
      a.put(localClass, localObject);
      return localObject;
      if ((paramView instanceof HorizontalScrollView))
      {
        localObject = new w((byte)0);
      }
      else if ((paramView instanceof WebView))
      {
        localObject = new y((byte)0);
      }
      else
      {
        if (b == null)
          break;
        localObject = b.newScrollDetector(paramView);
      }
    }
    return null;
  }

  public static boolean canScrollHorizontal(View paramView, int paramInt)
  {
    ScrollDetectors.ScrollDetector localScrollDetector = a(paramView);
    if (localScrollDetector == null)
      return false;
    return localScrollDetector.canScrollHorizontal(paramView, paramInt);
  }

  public static boolean canScrollVertical(View paramView, int paramInt)
  {
    ScrollDetectors.ScrollDetector localScrollDetector = a(paramView);
    if (localScrollDetector == null)
      return false;
    return localScrollDetector.canScrollVertical(paramView, paramInt);
  }

  public static void setScrollDetectorFactory(ScrollDetectorFactory paramScrollDetectorFactory)
  {
    b = paramScrollDetectorFactory;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.ScrollDetectors
 * JD-Core Version:    0.6.2
 */