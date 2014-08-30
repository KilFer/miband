package com.nineoldandroids.animation;

import java.util.ArrayList;

final class G extends ThreadLocal<ArrayList<ValueAnimator>>
{
  private static ArrayList<ValueAnimator> a()
  {
    return new ArrayList();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.G
 * JD-Core Version:    0.6.2
 */