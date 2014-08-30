package com.nineoldandroids.animation;

public class TimeAnimator extends ValueAnimator
{
  private TimeAnimator.TimeListener h;
  private long i = -1L;

  final void a()
  {
  }

  final void a(float paramFloat)
  {
  }

  final boolean a(long paramLong)
  {
    long l1 = 0L;
    long l2;
    if (this.d == 0)
    {
      this.d = 1;
      if (this.c < l1)
        this.b = paramLong;
    }
    else if (this.h != null)
    {
      l2 = paramLong - this.b;
      if (this.i >= l1)
        break label92;
    }
    while (true)
    {
      this.i = paramLong;
      this.h.onTimeUpdate(this, l2, l1);
      return false;
      this.b = (paramLong - this.c);
      this.c = -1L;
      break;
      label92: l1 = paramLong - this.i;
    }
  }

  public void setTimeListener(TimeAnimator.TimeListener paramTimeListener)
  {
    this.h = paramTimeListener;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.TimeAnimator
 * JD-Core Version:    0.6.2
 */