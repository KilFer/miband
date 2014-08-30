package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class AnimatorInflater
{
  private static final int[] a = { 16843490 };
  private static final int b = 0;
  private static final int[] c = { 16843489 };
  private static final int d = 0;
  private static final int[] e = { 16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488 };
  private static final int f = 0;
  private static final int g = 1;
  private static final int h = 2;
  private static final int i = 3;
  private static final int j = 4;
  private static final int k = 5;
  private static final int l = 6;
  private static final int m = 7;
  private static final int n;
  private static final int o;

  private static Animator a(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    return a(paramContext, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser), null, 0);
  }

  private static Animator a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt)
  {
    int i1 = 0;
    int i2 = paramXmlPullParser.getDepth();
    Object localObject1 = null;
    Object localObject2 = null;
    int i3;
    Animator[] arrayOfAnimator;
    Iterator localIterator;
    label74: 
    do
    {
      i3 = paramXmlPullParser.next();
      if (((i3 == 3) && (paramXmlPullParser.getDepth() <= i2)) || (i3 == 1))
      {
        if ((paramAnimatorSet != null) && (localObject1 != null))
        {
          arrayOfAnimator = new Animator[localObject1.size()];
          localIterator = localObject1.iterator();
          if (localIterator.hasNext())
            break;
          if (paramInt != 0)
            break label372;
          paramAnimatorSet.playTogether(arrayOfAnimator);
        }
        return localObject2;
      }
    }
    while (i3 != 2);
    String str = paramXmlPullParser.getName();
    if (str.equals("objectAnimator"))
    {
      localObject2 = new ObjectAnimator();
      a(paramContext, paramAttributeSet, (ValueAnimator)localObject2);
      TypedArray localTypedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, c);
      ((ObjectAnimator)localObject2).setPropertyName(localTypedArray1.getString(0));
      localTypedArray1.recycle();
      label165: if (paramAnimatorSet == null)
        break label303;
      if (localObject1 != null)
        break label381;
    }
    label303: label372: label381: for (Object localObject3 = new ArrayList(); ; localObject3 = localObject1)
    {
      ((ArrayList)localObject3).add(localObject2);
      localObject1 = localObject3;
      break;
      if (str.equals("animator"))
      {
        localObject2 = a(paramContext, paramAttributeSet, null);
        break label165;
      }
      if (str.equals("set"))
      {
        localObject2 = new AnimatorSet();
        TypedArray localTypedArray2 = paramContext.obtainStyledAttributes(paramAttributeSet, a);
        TypedValue localTypedValue = new TypedValue();
        localTypedArray2.getValue(0, localTypedValue);
        if (localTypedValue.type == 16);
        for (int i4 = localTypedValue.data; ; i4 = 0)
        {
          a(paramContext, paramXmlPullParser, paramAttributeSet, (AnimatorSet)localObject2, i4);
          localTypedArray2.recycle();
          break label165;
          break;
        }
      }
      throw new RuntimeException("Unknown animator name: " + paramXmlPullParser.getName());
      Animator localAnimator = (Animator)localIterator.next();
      int i5 = i1 + 1;
      arrayOfAnimator[i1] = localAnimator;
      i1 = i5;
      break label74;
      paramAnimatorSet.playSequentially(arrayOfAnimator);
      return localObject2;
    }
  }

  private static ObjectAnimator a(Context paramContext, AttributeSet paramAttributeSet)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    a(paramContext, paramAttributeSet, localObjectAnimator);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, c);
    localObjectAnimator.setPropertyName(localTypedArray.getString(0));
    localTypedArray.recycle();
    return localObjectAnimator;
  }

  private static ValueAnimator a(Context paramContext, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, e);
    long l1 = localTypedArray.getInt(1, 0);
    long l2 = localTypedArray.getInt(2, 0);
    int i1 = localTypedArray.getInt(7, 0);
    if (paramValueAnimator == null)
      paramValueAnimator = new ValueAnimator();
    int i2;
    int i3;
    label71: int i4;
    label83: int i5;
    label99: int i6;
    label111: float f2;
    label187: float f3;
    if (i1 == 0)
    {
      i2 = 1;
      TypedValue localTypedValue1 = localTypedArray.peekValue(5);
      if (localTypedValue1 == null)
        break label308;
      i3 = 1;
      if (i3 == 0)
        break label314;
      i4 = localTypedValue1.type;
      TypedValue localTypedValue2 = localTypedArray.peekValue(6);
      if (localTypedValue2 == null)
        break label320;
      i5 = 1;
      if (i5 == 0)
        break label326;
      i6 = localTypedValue2.type;
      if (((i3 != 0) && (i4 >= 28) && (i4 <= 31)) || ((i5 != 0) && (i6 >= 28) && (i6 <= 31)))
      {
        i2 = 0;
        paramValueAnimator.setEvaluator(new ArgbEvaluator());
      }
      if (i2 == 0)
        break label412;
      if (i3 == 0)
        break label370;
      if (i4 != 5)
        break label332;
      f2 = localTypedArray.getDimension(5, 0.0F);
      if (i5 == 0)
        break label355;
      if (i6 != 5)
        break label343;
      f3 = localTypedArray.getDimension(6, 0.0F);
      label207: paramValueAnimator.setFloatValues(new float[] { f2, f3 });
    }
    label308: label314: label320: label326: label332: label343: label355: label370: label509: 
    do
      while (true)
      {
        paramValueAnimator.setDuration(l1);
        paramValueAnimator.setStartDelay(l2);
        if (localTypedArray.hasValue(3))
          paramValueAnimator.setRepeatCount(localTypedArray.getInt(3, 0));
        if (localTypedArray.hasValue(4))
          paramValueAnimator.setRepeatMode(localTypedArray.getInt(4, 1));
        int i8 = localTypedArray.getResourceId(0, 0);
        if (i8 > 0)
          paramValueAnimator.setInterpolator(AnimationUtils.loadInterpolator(paramContext, i8));
        localTypedArray.recycle();
        return paramValueAnimator;
        i2 = 0;
        break;
        i3 = 0;
        break label71;
        i4 = 0;
        break label83;
        i5 = 0;
        break label99;
        i6 = 0;
        break label111;
        f2 = localTypedArray.getFloat(5, 0.0F);
        break label187;
        f3 = localTypedArray.getFloat(6, 0.0F);
        break label207;
        paramValueAnimator.setFloatValues(new float[] { f2 });
        continue;
        if (i6 == 5);
        for (float f1 = localTypedArray.getDimension(6, 0.0F); ; f1 = localTypedArray.getFloat(6, 0.0F))
        {
          paramValueAnimator.setFloatValues(new float[] { f1 });
          break;
        }
        if (i3 == 0)
          break label562;
        int i9;
        int i10;
        if (i4 == 5)
        {
          i9 = (int)localTypedArray.getDimension(5, 0.0F);
          if (i5 == 0)
            break label547;
          if (i6 != 5)
            break label509;
          i10 = (int)localTypedArray.getDimension(6, 0.0F);
        }
        while (true)
        {
          paramValueAnimator.setIntValues(new int[] { i9, i10 });
          break;
          if ((i4 >= 28) && (i4 <= 31))
          {
            i9 = localTypedArray.getColor(5, 0);
            break label432;
          }
          i9 = localTypedArray.getInt(5, 0);
          break label432;
          if ((i6 >= 28) && (i6 <= 31))
            i10 = localTypedArray.getColor(6, 0);
          else
            i10 = localTypedArray.getInt(6, 0);
        }
        paramValueAnimator.setIntValues(new int[] { i9 });
      }
    while (i5 == 0);
    label412: label432: label562: int i7;
    label547: if (i6 == 5)
      i7 = (int)localTypedArray.getDimension(6, 0.0F);
    while (true)
    {
      paramValueAnimator.setIntValues(new int[] { i7 });
      break;
      if ((i6 >= 28) && (i6 <= 31))
        i7 = localTypedArray.getColor(6, 0);
      else
        i7 = localTypedArray.getInt(6, 0);
    }
  }

  // ERROR //
  public static Animator loadAnimator(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 252	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6: iload_1
    //   7: invokevirtual 258	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   10: astore_2
    //   11: aload_0
    //   12: aload_2
    //   13: aload_2
    //   14: invokestatic 57	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   17: aconst_null
    //   18: iconst_0
    //   19: invokestatic 60	com/nineoldandroids/animation/AnimatorInflater:a	(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Lcom/nineoldandroids/animation/AnimatorSet;I)Lcom/nineoldandroids/animation/Animator;
    //   22: astore 10
    //   24: aload_2
    //   25: ifnull +9 -> 34
    //   28: aload_2
    //   29: invokeinterface 263 1 0
    //   34: aload 10
    //   36: areturn
    //   37: astore 7
    //   39: new 265	android/content/res/Resources$NotFoundException
    //   42: dup
    //   43: new 155	java/lang/StringBuilder
    //   46: dup
    //   47: ldc_w 267
    //   50: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: iload_1
    //   54: invokestatic 272	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   57: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokespecial 273	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   66: astore 8
    //   68: aload 8
    //   70: aload 7
    //   72: invokevirtual 277	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   75: pop
    //   76: aload 8
    //   78: athrow
    //   79: astore 6
    //   81: aload_2
    //   82: ifnull +9 -> 91
    //   85: aload_2
    //   86: invokeinterface 263 1 0
    //   91: aload 6
    //   93: athrow
    //   94: astore_3
    //   95: new 265	android/content/res/Resources$NotFoundException
    //   98: dup
    //   99: new 155	java/lang/StringBuilder
    //   102: dup
    //   103: ldc_w 267
    //   106: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: iload_1
    //   110: invokestatic 272	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   113: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 273	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   122: astore 4
    //   124: aload 4
    //   126: aload_3
    //   127: invokevirtual 277	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   130: pop
    //   131: aload 4
    //   133: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	24	37	org/xmlpull/v1/XmlPullParserException
    //   2	24	79	finally
    //   39	79	79	finally
    //   95	134	79	finally
    //   2	24	94	java/io/IOException
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorInflater
 * JD-Core Version:    0.6.2
 */