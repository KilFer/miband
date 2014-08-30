package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

final class l
{
  private final GestureDetector a;

  public l(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    this.a = new GestureDetector(paramContext, paramOnGestureListener, paramHandler);
  }

  public final void a(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.a.setOnDoubleTapListener(paramOnDoubleTapListener);
  }

  public final void a(boolean paramBoolean)
  {
    this.a.setIsLongpressEnabled(paramBoolean);
  }

  public final boolean a()
  {
    return this.a.isLongpressEnabled();
  }

  public final boolean a(MotionEvent paramMotionEvent)
  {
    return this.a.onTouchEvent(paramMotionEvent);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.l
 * JD-Core Version:    0.6.2
 */