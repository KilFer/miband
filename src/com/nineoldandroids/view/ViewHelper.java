package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.view.animation.AnimatorProxy;

public final class ViewHelper
{
  public static float getAlpha(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getAlpha();
    return paramView.getAlpha();
  }

  public static float getPivotX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getPivotX();
    return paramView.getPivotX();
  }

  public static float getPivotY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getPivotY();
    return paramView.getPivotY();
  }

  public static float getRotation(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getRotation();
    return paramView.getRotation();
  }

  public static float getRotationX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getRotationX();
    return paramView.getRotationX();
  }

  public static float getRotationY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getRotationY();
    return paramView.getRotationY();
  }

  public static float getScaleX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getScaleX();
    return paramView.getScaleX();
  }

  public static float getScaleY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getScaleY();
    return paramView.getScaleY();
  }

  public static float getScrollX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getScrollX();
    return paramView.getScrollX();
  }

  public static float getScrollY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getScrollY();
    return paramView.getScrollY();
  }

  public static float getTranslationX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getTranslationX();
    return paramView.getTranslationX();
  }

  public static float getTranslationY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getTranslationY();
    return paramView.getTranslationY();
  }

  public static float getX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getX();
    return paramView.getX();
  }

  public static float getY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      return AnimatorProxy.wrap(paramView).getY();
    return paramView.getY();
  }

  public static void setAlpha(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setAlpha(paramFloat);
      return;
    }
    paramView.setAlpha(paramFloat);
  }

  public static void setPivotX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setPivotX(paramFloat);
      return;
    }
    paramView.setPivotX(paramFloat);
  }

  public static void setPivotY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setPivotY(paramFloat);
      return;
    }
    paramView.setPivotY(paramFloat);
  }

  public static void setRotation(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setRotation(paramFloat);
      return;
    }
    paramView.setRotation(paramFloat);
  }

  public static void setRotationX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setRotationX(paramFloat);
      return;
    }
    paramView.setRotationX(paramFloat);
  }

  public static void setRotationY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setRotationY(paramFloat);
      return;
    }
    paramView.setRotationY(paramFloat);
  }

  public static void setScaleX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setScaleX(paramFloat);
      return;
    }
    paramView.setScaleX(paramFloat);
  }

  public static void setScaleY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setScaleY(paramFloat);
      return;
    }
    paramView.setScaleY(paramFloat);
  }

  public static void setScrollX(View paramView, int paramInt)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setScrollX(paramInt);
      return;
    }
    paramView.setScrollX(paramInt);
  }

  public static void setScrollY(View paramView, int paramInt)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setScrollY(paramInt);
      return;
    }
    paramView.setScrollY(paramInt);
  }

  public static void setTranslationX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setTranslationX(paramFloat);
      return;
    }
    paramView.setTranslationX(paramFloat);
  }

  public static void setTranslationY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setTranslationY(paramFloat);
      return;
    }
    paramView.setTranslationY(paramFloat);
  }

  public static void setX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setX(paramFloat);
      return;
    }
    paramView.setX(paramFloat);
  }

  public static void setY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setY(paramFloat);
      return;
    }
    paramView.setY(paramFloat);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.ViewHelper
 * JD-Core Version:    0.6.2
 */