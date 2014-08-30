package com.google.zxing;

public class ResultPoint
{
  private final float a;
  private final float b;

  public ResultPoint(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }

  private static float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3)
  {
    float f1 = paramResultPoint2.a;
    float f2 = paramResultPoint2.b;
    return (paramResultPoint3.a - f1) * (paramResultPoint1.b - f2) - (paramResultPoint3.b - f2) * (paramResultPoint1.a - f1);
  }

  public static float distance(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    float f1 = paramResultPoint1.a - paramResultPoint2.a;
    float f2 = paramResultPoint1.b - paramResultPoint2.b;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }

  public static void orderBestPatterns(ResultPoint[] paramArrayOfResultPoint)
  {
    float f1 = distance(paramArrayOfResultPoint[0], paramArrayOfResultPoint[1]);
    float f2 = distance(paramArrayOfResultPoint[1], paramArrayOfResultPoint[2]);
    float f3 = distance(paramArrayOfResultPoint[0], paramArrayOfResultPoint[2]);
    ResultPoint localResultPoint;
    Object localObject1;
    Object localObject2;
    if ((f2 >= f1) && (f2 >= f3))
    {
      localResultPoint = paramArrayOfResultPoint[0];
      localObject1 = paramArrayOfResultPoint[1];
      localObject2 = paramArrayOfResultPoint[2];
      float f4 = localResultPoint.a;
      float f5 = localResultPoint.b;
      if ((((ResultPoint)localObject2).a - f4) * (((ResultPoint)localObject1).b - f5) - (((ResultPoint)localObject2).b - f5) * (((ResultPoint)localObject1).a - f4) >= 0.0F)
        break label175;
    }
    while (true)
    {
      paramArrayOfResultPoint[0] = localObject2;
      paramArrayOfResultPoint[1] = localResultPoint;
      paramArrayOfResultPoint[2] = localObject1;
      return;
      if ((f3 >= f2) && (f3 >= f1))
      {
        localResultPoint = paramArrayOfResultPoint[1];
        localObject1 = paramArrayOfResultPoint[0];
        localObject2 = paramArrayOfResultPoint[2];
        break;
      }
      localResultPoint = paramArrayOfResultPoint[2];
      localObject1 = paramArrayOfResultPoint[0];
      localObject2 = paramArrayOfResultPoint[1];
      break;
      label175: Object localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ResultPoint;
    boolean bool2 = false;
    if (bool1)
    {
      ResultPoint localResultPoint = (ResultPoint)paramObject;
      boolean bool3 = this.a < localResultPoint.a;
      bool2 = false;
      if (!bool3)
      {
        boolean bool4 = this.b < localResultPoint.b;
        bool2 = false;
        if (!bool4)
          bool2 = true;
      }
    }
    return bool2;
  }

  public final float getX()
  {
    return this.a;
  }

  public final float getY()
  {
    return this.b;
  }

  public int hashCode()
  {
    return 31 * Float.floatToIntBits(this.a) + Float.floatToIntBits(this.b);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(25);
    localStringBuilder.append('(');
    localStringBuilder.append(this.a);
    localStringBuilder.append(',');
    localStringBuilder.append(this.b);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.ResultPoint
 * JD-Core Version:    0.6.2
 */