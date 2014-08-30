package kankan.wheel.widget;

final class c
  implements WheelScroller.ScrollingListener
{
  c(WheelView paramWheelView)
  {
  }

  public final void onFinished()
  {
    if (WheelView.c(this.a))
    {
      this.a.notifyScrollingListenersAboutEnd();
      WheelView.a(this.a, false);
    }
    WheelView.b(this.a, 0);
    this.a.invalidate();
  }

  public final void onJustify()
  {
    if (Math.abs(WheelView.a(this.a)) > 1)
      WheelView.b(this.a).scroll(WheelView.a(this.a), 0);
  }

  public final void onScroll(int paramInt)
  {
    WheelView.a(this.a, paramInt);
    int i = this.a.getHeight();
    if (WheelView.a(this.a) > i)
    {
      WheelView.b(this.a, i);
      WheelView.b(this.a).stopScrolling();
    }
    while (WheelView.a(this.a) >= -i)
      return;
    WheelView.b(this.a, -i);
    WheelView.b(this.a).stopScrolling();
  }

  public final void onStarted()
  {
    WheelView.a(this.a, true);
    this.a.notifyScrollingListenersAboutStart();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.c
 * JD-Core Version:    0.6.2
 */