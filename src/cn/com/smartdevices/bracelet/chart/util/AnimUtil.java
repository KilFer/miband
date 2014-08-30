package cn.com.smartdevices.bracelet.chart.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import java.util.ArrayList;
import java.util.Iterator;

public class AnimUtil
{
  public static final int DURATION_CHART_SLEEP_SWITCH = 650;
  public static final int DURATION_CHART_STEP_SLEEP_SWITCH = 500;
  public static final int DURATION_CHART_STEP_SWITCH = 550;
  public static final int DURATION_DATE_SWITCH = 600;
  public static final int DURATION_FLOW_IN = 600;
  public static final int DURATION_LOADING = 3500;
  public static final int DURATION_NUM_SWITCH = 20;
  public static final int DURATION_PIE_CHART = 800;
  private static final String a = "Chart.AnimUtil";
  private static LayoutTransition b;
  private static LayoutTransition c;

  private static LayoutTransition a()
  {
    LayoutTransition localLayoutTransition = new LayoutTransition();
    localLayoutTransition.setDuration(90L);
    localLayoutTransition.setInterpolator(2, new AccelerateDecelerateInterpolator());
    localLayoutTransition.setInterpolator(3, new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(null, "rotationX", new float[] { 90.0F, 0.0F }).setDuration(localLayoutTransition.getDuration(2));
    localLayoutTransition.setAnimator(2, localObjectAnimator1);
    localObjectAnimator1.addListener(new d());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(null, "rotationX", new float[] { 0.0F, -90.0F }).setDuration(localLayoutTransition.getDuration(3));
    localLayoutTransition.setAnimator(3, localObjectAnimator2);
    localObjectAnimator2.addListener(new e());
    return localLayoutTransition;
  }

  private static String a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Debug.i("Chart.AnimUtil", "Change Digital Index : " + paramInt1 + " , " + paramInt2);
    int m;
    label62: String str1;
    if (paramString1.length() < paramString2.length())
    {
      int k = paramString2.length() - paramString1.length();
      m = 0;
      if (m >= k)
      {
        if (paramInt1 != 0)
          break label225;
        str1 = "";
        label70: if (paramInt1 != -1 + paramString1.length())
          break label244;
      }
    }
    label225: label244: for (String str2 = ""; ; str2 = paramString2.substring(0, -1 + (paramString1.length() - paramInt1)))
    {
      String str3 = Integer.valueOf(str2 + paramInt2 + str1).toString();
      Debug.i("Chart.AnimUtil", "Show Num : " + str3);
      return str3;
      paramString1 = '0' + paramString1;
      m++;
      break;
      if (paramString2.length() >= paramString1.length())
        break label62;
      int i = paramString1.length() - paramString2.length();
      for (int j = 0; j < i; j++)
        paramString2 = '0' + paramString2;
      break label62;
      str1 = paramString1.substring(paramString2.length() - paramInt1, paramString2.length());
      break label70;
    }
  }

  public static Animator animColorTrans(int paramInt1, int paramInt2, View[] paramArrayOfView)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i = Color.red(paramInt2);
    int j = Color.green(paramInt2);
    int k = Color.blue(paramInt2);
    localValueAnimator.addUpdateListener(new l(i, Color.red(paramInt1), j, Color.green(paramInt1), k, Color.blue(paramInt1), paramArrayOfView));
    localValueAnimator.setInterpolator(new AccelerateInterpolator());
    localValueAnimator.setDuration(500L);
    return localValueAnimator;
  }

  public static Animator animDateSwitch(String paramString1, String paramString2, TextView paramTextView1, TextView paramTextView2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addListener(new a(paramTextView1, paramString1, paramTextView2, paramString2));
    localValueAnimator.addUpdateListener(new f(paramTextView1, paramTextView2));
    localValueAnimator.setDuration(600L);
    return localValueAnimator;
  }

  public static Animator animFade(View paramView, float paramFloat1, float paramFloat2)
  {
    return ObjectAnimator.ofFloat(paramView, "alpha", new float[] { paramFloat1, paramFloat2 });
  }

  public static Animator animFadeIn(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.3F, 1.0F });
    localObjectAnimator.setInterpolator(new AccelerateInterpolator());
    return localObjectAnimator;
  }

  public static Animator animFlow(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateInterpolator());
    localValueAnimator.addUpdateListener(paramAnimatorUpdateListener);
    return localValueAnimator;
  }

  public static void animInfoSwitch(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    int i = 0;
    if (b == null)
      b = a();
    if (c == null)
      c = a();
    paramViewGroup1.setLayoutTransition(b);
    paramViewGroup2.setLayoutTransition(c);
    paramViewGroup2.setVisibility(0);
    int j = paramViewGroup1.getChildCount();
    int k = 0;
    int m = 0;
    int n;
    int i1;
    if (k >= j)
    {
      n = paramViewGroup2.getChildCount();
      i1 = 0;
    }
    while (true)
    {
      if (i >= n)
      {
        return;
        View localView1 = paramViewGroup1.getChildAt(k);
        if (k * (100 - k * 10) > m)
          m = k * (100 - k * 10);
        paramViewGroup1.postDelayed(new m(localView1), m);
        if (k == j - 1)
          paramViewGroup1.postDelayed(new b(paramViewGroup1), m + 90);
        k++;
        break;
      }
      View localView2 = paramViewGroup2.getChildAt(i);
      if (i * (100 - i * 10) > i1)
        i1 = i * (100 - i * 10);
      paramViewGroup2.postDelayed(new c(localView2), i1);
      i++;
    }
  }

  public static Animator animNumSwitch(int paramInt1, int paramInt2, TextView paramTextView)
  {
    int i = paramInt2 - paramInt1;
    String str = String.valueOf(Math.abs(i));
    int[] arrayOfInt = new int[str.length()];
    int j = 0;
    ArrayList localArrayList;
    int k;
    if (j >= str.length())
    {
      localArrayList = new ArrayList();
      localArrayList.add(formatNumStyle(paramInt1));
      k = 1;
    }
    Keyframe[] arrayOfKeyframe;
    int i2;
    int i1;
    for (int m = 0; ; m++)
    {
      if (m >= arrayOfInt.length)
      {
        localArrayList.add(formatNumStyle(paramInt2));
        arrayOfKeyframe = new Keyframe[1 + localArrayList.size()];
        i2 = 0;
        if (i2 <= localArrayList.size())
          break label266;
        ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("Text", arrayOfKeyframe) });
        localValueAnimator.setEvaluator(new g());
        localValueAnimator.addUpdateListener(new h(paramTextView));
        localValueAnimator.setDuration(20 * arrayOfKeyframe.length);
        return localValueAnimator;
        arrayOfInt[j] = ('￐' + str.charAt(-1 + (str.length() - j)));
        j++;
        break;
      }
      int n = Integer.valueOf(arrayOfInt[m]).intValue();
      i1 = 0;
      if (i1 < n)
        break label229;
      k *= 10;
    }
    label229: if (i > 0)
      paramInt1 += k;
    while (true)
    {
      localArrayList.add(formatNumStyle(paramInt1));
      i1++;
      break;
      if (i < 0)
        paramInt1 -= k;
    }
    label266: float f = 1.0F / localArrayList.size() * i2;
    if (i2 == 0);
    for (int i3 = 0; ; i3 = i2 - 1)
    {
      arrayOfKeyframe[i2] = Keyframe.ofObject(f, localArrayList.get(i3));
      i2++;
      break;
    }
  }

  public static Animator animNumSwitch1(int paramInt1, int paramInt2, TextView paramTextView)
  {
    String str1 = String.valueOf(paramInt1);
    int[] arrayOfInt1 = new int[str1.length()];
    int i = 0;
    String str2;
    int[] arrayOfInt2;
    int j;
    label43: ArrayList localArrayList;
    int k;
    Keyframe[] arrayOfKeyframe;
    Iterator localIterator;
    int i3;
    if (i >= str1.length())
    {
      str2 = String.valueOf(paramInt2);
      arrayOfInt2 = new int[str2.length()];
      j = 0;
      if (j < str2.length())
        break label231;
      localArrayList = new ArrayList();
      k = -1 + arrayOfInt2.length;
      if (k >= 0)
        break label294;
      arrayOfKeyframe = new Keyframe[1 + localArrayList.size()];
      localIterator = localArrayList.iterator();
      i3 = 0;
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        arrayOfKeyframe[0] = arrayOfKeyframe[1];
        ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("Text", arrayOfKeyframe) });
        localValueAnimator.setEvaluator(new i());
        localValueAnimator.addUpdateListener(new j(paramTextView));
        localValueAnimator.setDuration(20L);
        return localValueAnimator;
        arrayOfInt1[(-1 + (str1.length() - i))] = ('￐' + str1.charAt(i));
        Debug.i("Chart.AnimUtil", "Num : " + arrayOfInt1[(-1 + (str1.length() - i))]);
        i++;
        break;
        label231: arrayOfInt2[(-1 + (str2.length() - j))] = ('￐' + str2.charAt(j));
        Debug.i("Chart.AnimUtil", "Num : " + arrayOfInt2[(-1 + (str2.length() - j))]);
        j++;
        break label43;
        label294: int m = arrayOfInt2[k];
        int n;
        label316: int i2;
        if (arrayOfInt1.length > k)
        {
          n = arrayOfInt1[k];
          if (m <= n)
            break label375;
          i2 = 0;
          label326: if (i2 < 1 + (m - n))
            break label350;
        }
        while (true)
        {
          k--;
          break;
          n = 0;
          break label316;
          label350: localArrayList.add(a(str1, str2, k, n + i2));
          i2++;
          break label326;
          label375: if (m < n)
            for (int i1 = 0; i1 < 1 + (n - m); i1++)
              localArrayList.add(a(str1, str2, k, n - i1));
          else
            localArrayList.add(a(str1, str2, k, n));
        }
      }
      String str3 = (String)localIterator.next();
      i3++;
      arrayOfKeyframe[i3] = Keyframe.ofObject(1.0F / localArrayList.size() * i3, str3);
    }
  }

  public static Animator animNumSwitch2(int paramInt1, int paramInt2, TextView paramTextView)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new k(paramTextView));
    localValueAnimator.setDuration(500L);
    return localValueAnimator;
  }

  public static Animator animScaleX(View paramView, float paramFloat1, float paramFloat2)
  {
    return ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { paramFloat1, paramFloat2 });
  }

  public static Animator animSlideIn(int paramInt, View paramView)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramInt;
    arrayOfFloat[1] = 0.0F;
    return ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("translationY", arrayOfFloat), PropertyValuesHolder.ofFloat("alpha", new float[] { 0.3F, 1.0F }) });
  }

  public static Animator animSlideOut(int paramInt, View paramView)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = (-paramInt);
    return ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("translationY", arrayOfFloat), PropertyValuesHolder.ofFloat("alpha", new float[] { 0.7F, 0.0F }) });
  }

  public static void dismissChildren(ViewGroup paramViewGroup)
  {
    int i = paramViewGroup.getChildCount();
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        paramViewGroup.setVisibility(8);
        return;
      }
      paramViewGroup.getChildAt(j).setVisibility(4);
    }
  }

  public static String formatNum(int paramInt)
  {
    String str = String.valueOf(paramInt);
    if (paramInt == 0)
      str = "0000";
    while (str.length() >= 4)
      return str;
    switch (str.length())
    {
    default:
      return str;
    case 1:
      return "000" + str;
    case 2:
      return "00" + str;
    case 3:
    }
    return "0" + str;
  }

  public static CharSequence formatNumStyle(int paramInt)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-1711276033);
    String str1 = String.valueOf(paramInt);
    String str2 = "";
    if (paramInt == 0)
      str2 = "0000";
    SpannableString localSpannableString1;
    SpannableString localSpannableString2;
    while (true)
    {
      localSpannableString1 = new SpannableString(str2);
      localSpannableString1.setSpan(localForegroundColorSpan, 0, str2.length(), 33);
      localSpannableString2 = new SpannableString(str1);
      if (paramInt != 0)
        break;
      localSpannableStringBuilder.append(localSpannableString1);
      return localSpannableStringBuilder;
      if (str1.length() < 4)
        switch (str1.length())
        {
        default:
          break;
        case 1:
          str2 = "000";
          break;
        case 2:
          str2 = "00";
          break;
        case 3:
          str2 = "0";
        }
    }
    localSpannableStringBuilder.append(localSpannableString1).append(localSpannableString2);
    return localSpannableStringBuilder;
  }

  public static long getAnimDuration(AnimatorSet paramAnimatorSet)
  {
    Iterator localIterator = paramAnimatorSet.getChildAnimations().iterator();
    long l1 = 0L;
    while (true)
    {
      if (!localIterator.hasNext())
        return l1;
      Animator localAnimator = (Animator)localIterator.next();
      long l2 = localAnimator.getStartDelay() + localAnimator.getDuration();
      if (l2 > l1)
        l1 = l2;
    }
  }

  public static void infoSwitch(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    paramViewGroup1.setLayoutTransition(null);
    paramViewGroup2.setLayoutTransition(null);
    dismissChildren(paramViewGroup1);
    showChildren(paramViewGroup2);
  }

  public static void seekAnim(AnimatorSet paramAnimatorSet, long paramLong)
  {
    Iterator localIterator;
    if (paramAnimatorSet != null)
    {
      if (paramAnimatorSet.isStarted())
        paramAnimatorSet.end();
      localIterator = paramAnimatorSet.getChildAnimations().iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Animator localAnimator = (Animator)localIterator.next();
      long l = paramLong - localAnimator.getStartDelay();
      if (l < 0L)
        l = 0L;
      if ((localAnimator instanceof ValueAnimator))
        ((ValueAnimator)localAnimator).setCurrentPlayTime(l);
    }
  }

  public static void seekAnim(View paramView, AnimatorSet paramAnimatorSet, long paramLong)
  {
    seekAnim(paramAnimatorSet, paramLong);
    paramView.postInvalidateOnAnimation();
  }

  public static void showChildren(ViewGroup paramViewGroup)
  {
    int i = paramViewGroup.getChildCount();
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        paramViewGroup.setVisibility(0);
        return;
      }
      paramViewGroup.getChildAt(j).setVisibility(0);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.util.AnimUtil
 * JD-Core Version:    0.6.2
 */