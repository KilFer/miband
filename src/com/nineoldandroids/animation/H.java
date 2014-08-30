package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

final class H extends Handler
{
  public final void handleMessage(Message paramMessage)
  {
    ArrayList localArrayList1 = (ArrayList)ValueAnimator.b().get();
    ArrayList localArrayList2 = (ArrayList)ValueAnimator.c().get();
    ArrayList localArrayList5;
    int i;
    switch (paramMessage.what)
    {
    default:
      return;
    case 0:
      localArrayList5 = (ArrayList)ValueAnimator.d().get();
      if ((localArrayList1.size() > 0) || (localArrayList2.size() > 0))
      {
        i = 0;
        label77: if (localArrayList5.size() > 0)
          break;
      }
      break;
    case 1:
    }
    while (true)
    {
      long l = AnimationUtils.currentAnimationTimeMillis();
      ArrayList localArrayList3 = (ArrayList)ValueAnimator.e().get();
      ArrayList localArrayList4 = (ArrayList)ValueAnimator.f().get();
      int j = localArrayList2.size();
      int k = 0;
      label121: int i4;
      label143: int i1;
      int i2;
      if (k >= j)
      {
        int m = localArrayList3.size();
        if (m > 0)
        {
          i4 = 0;
          if (i4 < m)
            break label351;
          localArrayList3.clear();
        }
        int n = localArrayList1.size();
        i1 = 0;
        i2 = n;
        label168: if (i1 < i2)
          break label387;
        if (localArrayList4.size() <= 0);
      }
      for (int i3 = 0; ; i3++)
      {
        if (i3 >= localArrayList4.size())
        {
          localArrayList4.clear();
          if ((i == 0) || ((localArrayList1.isEmpty()) && (localArrayList2.isEmpty())))
            break;
          sendEmptyMessageDelayed(1, Math.max(0L, ValueAnimator.g() - (AnimationUtils.currentAnimationTimeMillis() - l)));
          return;
          ArrayList localArrayList6 = (ArrayList)localArrayList5.clone();
          localArrayList5.clear();
          int i5 = localArrayList6.size();
          int i6 = 0;
          if (i6 >= i5)
            break label77;
          ValueAnimator localValueAnimator4 = (ValueAnimator)localArrayList6.get(i6);
          if (ValueAnimator.a(localValueAnimator4) == 0L)
            ValueAnimator.b(localValueAnimator4);
          while (true)
          {
            i6++;
            break;
            localArrayList2.add(localValueAnimator4);
          }
          ValueAnimator localValueAnimator1 = (ValueAnimator)localArrayList2.get(k);
          if (ValueAnimator.a(localValueAnimator1, l))
            localArrayList3.add(localValueAnimator1);
          k++;
          break label121;
          label351: ValueAnimator localValueAnimator3 = (ValueAnimator)localArrayList3.get(i4);
          ValueAnimator.b(localValueAnimator3);
          ValueAnimator.a(localValueAnimator3, true);
          localArrayList2.remove(localValueAnimator3);
          i4++;
          break label143;
          label387: ValueAnimator localValueAnimator2 = (ValueAnimator)localArrayList1.get(i1);
          if (localValueAnimator2.a(l))
            localArrayList4.add(localValueAnimator2);
          if (localArrayList1.size() == i2)
          {
            i1++;
            break label168;
          }
          i2--;
          localArrayList4.remove(localValueAnimator2);
          break label168;
        }
        ValueAnimator.c((ValueAnimator)localArrayList4.get(i3));
      }
      i = 1;
      break label77;
      i = 1;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.H
 * JD-Core Version:    0.6.2
 */