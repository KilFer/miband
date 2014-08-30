package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;

public class KeyEventCompat
{
  private static t a = new t();

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new s();
      return;
    }
  }

  public static boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2)
  {
    return a.a(paramKeyEvent, paramCallback, paramObject1, paramObject2);
  }

  public static Object getKeyDispatcherState(View paramView)
  {
    return a.a(paramView);
  }

  public static boolean hasModifiers(KeyEvent paramKeyEvent, int paramInt)
  {
    return a.a(paramKeyEvent.getMetaState(), paramInt);
  }

  public static boolean hasNoModifiers(KeyEvent paramKeyEvent)
  {
    return a.b(paramKeyEvent.getMetaState());
  }

  public static boolean isTracking(KeyEvent paramKeyEvent)
  {
    return a.b(paramKeyEvent);
  }

  public static boolean metaStateHasModifiers(int paramInt1, int paramInt2)
  {
    return a.a(paramInt1, paramInt2);
  }

  public static boolean metaStateHasNoModifiers(int paramInt)
  {
    return a.b(paramInt);
  }

  public static int normalizeMetaState(int paramInt)
  {
    return a.a(paramInt);
  }

  public static void startTracking(KeyEvent paramKeyEvent)
  {
    a.a(paramKeyEvent);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.KeyEventCompat
 * JD-Core Version:    0.6.2
 */