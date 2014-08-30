package cn.com.smartdevices.bracelet.chart.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import java.util.ArrayList;
import java.util.Iterator;

public class AnimUtil$AnimSetBuilder
{
  private static Animator a;
  private static ArrayList<Animator> b = new ArrayList();

  private static void a()
  {
    a = null;
    b.clear();
  }

  public static void addAnim(Animator paramAnimator)
  {
    b.add(paramAnimator);
  }

  public static void addAnim(Animator paramAnimator, long paramLong)
  {
    paramAnimator.setDuration(paramLong);
    b.add(paramAnimator);
  }

  public static void addAnim(Animator paramAnimator, long paramLong1, long paramLong2)
  {
    paramAnimator.setStartDelay(paramLong2);
    if (paramLong1 > 0L)
      paramAnimator.setDuration(paramLong1);
    b.add(paramAnimator);
  }

  public static AnimatorSet build()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    AnimatorSet.Builder localBuilder = localAnimatorSet.play(a);
    Iterator localIterator = b.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        a = null;
        b.clear();
        return localAnimatorSet;
      }
      localBuilder.with((Animator)localIterator.next());
    }
  }

  public static void setFirstAnim(Animator paramAnimator)
  {
    a = paramAnimator;
  }

  public static void setFirstAnim(Animator paramAnimator, long paramLong)
  {
    paramAnimator.setDuration(paramLong);
    a = paramAnimator;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder
 * JD-Core Version:    0.6.2
 */