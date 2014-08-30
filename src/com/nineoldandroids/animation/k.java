package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

class k
{
  int a;
  Interpolator b;
  ArrayList<Keyframe> c;
  TypeEvaluator d;
  private Keyframe e;
  private Keyframe f;

  public k(Keyframe[] paramArrayOfKeyframe)
  {
    this.a = paramArrayOfKeyframe.length;
    this.c = new ArrayList();
    this.c.addAll(Arrays.asList(paramArrayOfKeyframe));
    this.e = ((Keyframe)this.c.get(0));
    this.f = ((Keyframe)this.c.get(-1 + this.a));
    this.b = this.f.getInterpolator();
  }

  public static k a(float[] paramArrayOfFloat)
  {
    int i = 1;
    int j = paramArrayOfFloat.length;
    h[] arrayOfh = new h[Math.max(j, 2)];
    if (j == i)
    {
      arrayOfh[0] = ((h)Keyframe.ofFloat(0.0F));
      arrayOfh[i] = ((h)Keyframe.ofFloat(1.0F, paramArrayOfFloat[0]));
    }
    while (true)
    {
      return new f(arrayOfh);
      arrayOfh[0] = ((h)Keyframe.ofFloat(0.0F, paramArrayOfFloat[0]));
      while (i < j)
      {
        arrayOfh[i] = ((h)Keyframe.ofFloat(i / (j - 1), paramArrayOfFloat[i]));
        i++;
      }
    }
  }

  public static k a(int[] paramArrayOfInt)
  {
    int i = 1;
    int j = paramArrayOfInt.length;
    i[] arrayOfi = new i[Math.max(j, 2)];
    if (j == i)
    {
      arrayOfi[0] = ((i)Keyframe.ofInt(0.0F));
      arrayOfi[i] = ((i)Keyframe.ofInt(1.0F, paramArrayOfInt[0]));
    }
    while (true)
    {
      return new g(arrayOfi);
      arrayOfi[0] = ((i)Keyframe.ofInt(0.0F, paramArrayOfInt[0]));
      while (i < j)
      {
        arrayOfi[i] = ((i)Keyframe.ofInt(i / (j - 1), paramArrayOfInt[i]));
        i++;
      }
    }
  }

  public static k a(Keyframe[] paramArrayOfKeyframe)
  {
    int i = 0;
    int j = paramArrayOfKeyframe.length;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    h[] arrayOfh;
    if (k >= j)
    {
      if ((i1 != 0) && (n == 0) && (m == 0))
        arrayOfh = new h[j];
    }
    else
      while (true)
      {
        if (i >= j)
        {
          return new f(arrayOfh);
          if ((paramArrayOfKeyframe[k] instanceof h))
            i1 = 1;
          while (true)
          {
            k++;
            break;
            if ((paramArrayOfKeyframe[k] instanceof i))
              n = 1;
            else
              m = 1;
          }
        }
        arrayOfh[i] = ((h)paramArrayOfKeyframe[i]);
        i++;
      }
    if ((n != 0) && (i1 == 0) && (m == 0))
    {
      i[] arrayOfi = new i[j];
      for (int i2 = 0; ; i2++)
      {
        if (i2 >= j)
          return new g(arrayOfi);
        arrayOfi[i2] = ((i)paramArrayOfKeyframe[i2]);
      }
    }
    return new k(paramArrayOfKeyframe);
  }

  public static k a(Object[] paramArrayOfObject)
  {
    int i = 1;
    int j = paramArrayOfObject.length;
    j[] arrayOfj = new j[Math.max(j, 2)];
    if (j == i)
    {
      arrayOfj[0] = ((j)Keyframe.ofObject(0.0F));
      arrayOfj[i] = ((j)Keyframe.ofObject(1.0F, paramArrayOfObject[0]));
    }
    while (true)
    {
      return new k(arrayOfj);
      arrayOfj[0] = ((j)Keyframe.ofObject(0.0F, paramArrayOfObject[0]));
      while (i < j)
      {
        arrayOfj[i] = ((j)Keyframe.ofObject(i / (j - 1), paramArrayOfObject[i]));
        i++;
      }
    }
  }

  public k a()
  {
    ArrayList localArrayList = this.c;
    int i = this.c.size();
    Keyframe[] arrayOfKeyframe = new Keyframe[i];
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return new k(arrayOfKeyframe);
      arrayOfKeyframe[j] = ((Keyframe)localArrayList.get(j)).clone();
    }
  }

  public Object a(float paramFloat)
  {
    if (this.a == 2)
    {
      if (this.b != null)
        paramFloat = this.b.getInterpolation(paramFloat);
      return this.d.evaluate(paramFloat, this.e.getValue(), this.f.getValue());
    }
    if (paramFloat <= 0.0F)
    {
      Keyframe localKeyframe3 = (Keyframe)this.c.get(1);
      Interpolator localInterpolator3 = localKeyframe3.getInterpolator();
      if (localInterpolator3 != null)
        paramFloat = localInterpolator3.getInterpolation(paramFloat);
      float f5 = this.e.getFraction();
      float f6 = (paramFloat - f5) / (localKeyframe3.getFraction() - f5);
      return this.d.evaluate(f6, this.e.getValue(), localKeyframe3.getValue());
    }
    if (paramFloat >= 1.0F)
    {
      Keyframe localKeyframe2 = (Keyframe)this.c.get(-2 + this.a);
      Interpolator localInterpolator2 = this.f.getInterpolator();
      if (localInterpolator2 != null)
        paramFloat = localInterpolator2.getInterpolation(paramFloat);
      float f3 = localKeyframe2.getFraction();
      float f4 = (paramFloat - f3) / (this.f.getFraction() - f3);
      return this.d.evaluate(f4, localKeyframe2.getValue(), this.f.getValue());
    }
    Object localObject = this.e;
    int i = 1;
    while (true)
    {
      if (i >= this.a)
        return this.f.getValue();
      Keyframe localKeyframe1 = (Keyframe)this.c.get(i);
      if (paramFloat < localKeyframe1.getFraction())
      {
        Interpolator localInterpolator1 = localKeyframe1.getInterpolator();
        if (localInterpolator1 != null)
          paramFloat = localInterpolator1.getInterpolation(paramFloat);
        float f1 = ((Keyframe)localObject).getFraction();
        float f2 = (paramFloat - f1) / (localKeyframe1.getFraction() - f1);
        return this.d.evaluate(f2, ((Keyframe)localObject).getValue(), localKeyframe1.getValue());
      }
      i++;
      localObject = localKeyframe1;
    }
  }

  public final void a(TypeEvaluator paramTypeEvaluator)
  {
    this.d = paramTypeEvaluator;
  }

  public String toString()
  {
    Object localObject = " ";
    int i = 0;
    while (true)
    {
      if (i >= this.a)
        return localObject;
      String str = localObject + ((Keyframe)this.c.get(i)).getValue() + "  ";
      i++;
      localObject = str;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.k
 * JD-Core Version:    0.6.2
 */