package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public class GestureDetectorCompat
{
  private final i a;

  public GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, null);
  }

  public GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT > 17)
    {
      this.a = new AccessibilityDelegateCompatIcs(paramContext, paramOnGestureListener, paramHandler);
      return;
    }
    this.a = new j(paramContext, paramOnGestureListener, paramHandler);
  }

  public boolean isLongpressEnabled()
  {
    return this.a.b();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.a(paramMotionEvent);
  }

  public void setIsLongpressEnabled(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }

  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.a.a(paramOnDoubleTapListener);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.GestureDetectorCompat
 * JD-Core Version:    0.6.2
 */