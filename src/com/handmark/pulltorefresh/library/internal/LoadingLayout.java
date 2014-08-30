package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;

public abstract class LoadingLayout extends FrameLayout
  implements ILoadingLayout
{
  static final Interpolator a = new LinearInterpolator();
  private static String b = "PullToRefresh-LoadingLayout";
  private FrameLayout c;
  private boolean d;
  private final TextView e;
  private final TextView f;
  private CharSequence g;
  private CharSequence h;
  private CharSequence i;
  protected final ImageView mHeaderImage;
  protected final ProgressBar mHeaderProgress;
  protected final PullToRefreshBase.Mode mMode;
  protected final PullToRefreshBase.Orientation mScrollDirection;

  public LoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.mMode = paramMode;
    this.mScrollDirection = paramOrientation;
    FrameLayout.LayoutParams localLayoutParams;
    int i2;
    label179: Drawable localDrawable1;
    switch (a()[paramOrientation.ordinal()])
    {
    default:
      LayoutInflater.from(paramContext).inflate(2130903124, this);
      this.c = ((FrameLayout)findViewById(2131165568));
      this.e = ((TextView)this.c.findViewById(2131165571));
      this.mHeaderProgress = ((ProgressBar)this.c.findViewById(2131165570));
      this.f = ((TextView)this.c.findViewById(2131165572));
      this.mHeaderImage = ((ImageView)this.c.findViewById(2131165569));
      localLayoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
      switch (b()[paramMode.ordinal()])
      {
      default:
        if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL)
        {
          i2 = 80;
          localLayoutParams.gravity = i2;
          this.g = paramContext.getString(2131492864);
          this.h = paramContext.getString(2131492866);
          this.i = paramContext.getString(2131492865);
          if (paramTypedArray.hasValue(1))
          {
            Drawable localDrawable2 = paramTypedArray.getDrawable(1);
            if (localDrawable2 != null)
              ViewCompat.setBackground(this, localDrawable2);
          }
          if (paramTypedArray.hasValue(10))
          {
            TypedValue localTypedValue1 = new TypedValue();
            paramTypedArray.getValue(10, localTypedValue1);
            int n = localTypedValue1.data;
            if (this.e != null)
              this.e.setTextAppearance(getContext(), n);
            if (this.f != null)
              this.f.setTextAppearance(getContext(), n);
          }
          if (paramTypedArray.hasValue(11))
          {
            TypedValue localTypedValue2 = new TypedValue();
            paramTypedArray.getValue(11, localTypedValue2);
            int i1 = localTypedValue2.data;
            if (this.f != null)
              this.f.setTextAppearance(getContext(), i1);
          }
          if (paramTypedArray.hasValue(2))
          {
            ColorStateList localColorStateList2 = paramTypedArray.getColorStateList(2);
            if (localColorStateList2 != null)
            {
              if (this.e != null)
                this.e.setTextColor(localColorStateList2);
              if (this.f != null)
                this.f.setTextColor(localColorStateList2);
            }
          }
          if (paramTypedArray.hasValue(3))
          {
            ColorStateList localColorStateList1 = paramTypedArray.getColorStateList(3);
            if ((localColorStateList1 != null) && (this.f != null))
              this.f.setTextColor(localColorStateList1);
          }
          boolean bool = paramTypedArray.hasValue(6);
          localDrawable1 = null;
          if (bool)
            localDrawable1 = paramTypedArray.getDrawable(6);
          switch (b()[paramMode.ordinal()])
          {
          default:
            if (paramTypedArray.hasValue(7))
              localDrawable1 = paramTypedArray.getDrawable(7);
            break;
          case 3:
          }
        }
        break;
      case 3:
      }
      break;
    case 2:
    }
    while (true)
    {
      if (localDrawable1 == null)
        localDrawable1 = paramContext.getResources().getDrawable(getDefaultDrawableResId());
      setLoadingDrawable(localDrawable1);
      reset();
      return;
      LayoutInflater.from(paramContext).inflate(2130903123, this);
      break;
      if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL);
      for (int m = 48; ; m = 3)
      {
        localLayoutParams.gravity = m;
        this.g = paramContext.getString(2131492867);
        this.h = paramContext.getString(2131492869);
        this.i = paramContext.getString(2131492868);
        break;
      }
      i2 = 5;
      break label179;
      if (paramTypedArray.hasValue(17))
      {
        Utils.warnDeprecation("ptrDrawableTop", "ptrDrawableStart");
        localDrawable1 = paramTypedArray.getDrawable(17);
        continue;
        if (paramTypedArray.hasValue(8))
        {
          localDrawable1 = paramTypedArray.getDrawable(8);
        }
        else if (paramTypedArray.hasValue(18))
        {
          Utils.warnDeprecation("ptrDrawableBottom", "ptrDrawableEnd");
          localDrawable1 = paramTypedArray.getDrawable(18);
        }
      }
    }
  }

  private void a(int paramInt)
  {
    if (this.f != null)
      this.f.setTextAppearance(getContext(), paramInt);
  }

  private void a(ColorStateList paramColorStateList)
  {
    if (this.f != null)
      this.f.setTextColor(paramColorStateList);
  }

  private void a(CharSequence paramCharSequence)
  {
    if (this.f != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
        break label24;
      this.f.setVisibility(8);
    }
    label24: 
    do
    {
      return;
      this.f.setText(paramCharSequence);
    }
    while (8 != this.f.getVisibility());
    this.f.setVisibility(0);
  }

  private void b(int paramInt)
  {
    if (this.e != null)
      this.e.setTextAppearance(getContext(), paramInt);
    if (this.f != null)
      this.f.setTextAppearance(getContext(), paramInt);
  }

  private void b(ColorStateList paramColorStateList)
  {
    if (this.e != null)
      this.e.setTextColor(paramColorStateList);
    if (this.f != null)
      this.f.setTextColor(paramColorStateList);
  }

  public final int getContentSize()
  {
    switch (a()[this.mScrollDirection.ordinal()])
    {
    default:
      return this.c.getHeight();
    case 2:
    }
    return this.c.getWidth();
  }

  protected abstract int getDefaultDrawableResId();

  public final void hideAllViews()
  {
    if (this.e.getVisibility() == 0)
      this.e.setVisibility(4);
    if (this.mHeaderProgress.getVisibility() == 0)
      this.mHeaderProgress.setVisibility(4);
    if (this.mHeaderImage.getVisibility() == 0)
      this.mHeaderImage.setVisibility(4);
    if (this.f.getVisibility() == 0)
      this.f.setVisibility(4);
  }

  protected abstract void onLoadingDrawableSet(Drawable paramDrawable);

  public final void onPull(float paramFloat)
  {
    if (!this.d)
      onPullImpl(paramFloat);
  }

  protected abstract void onPullImpl(float paramFloat);

  public final void pullToRefresh()
  {
    if (this.e != null)
      this.e.setText(this.g);
    pullToRefreshImpl();
  }

  protected abstract void pullToRefreshImpl();

  public final void refreshing()
  {
    if (this.e != null)
      this.e.setText(this.h);
    if (this.d)
      ((AnimationDrawable)this.mHeaderImage.getDrawable()).start();
    while (true)
    {
      if (this.f != null)
        this.f.setVisibility(8);
      return;
      refreshingImpl();
    }
  }

  protected abstract void refreshingImpl();

  public final void releaseToRefresh()
  {
    if (this.e != null)
      this.e.setText(this.i);
    releaseToRefreshImpl();
  }

  protected abstract void releaseToRefreshImpl();

  public final void reset()
  {
    if (this.e != null)
      this.e.setText(this.g);
    this.mHeaderImage.setVisibility(0);
    if (this.d)
      ((AnimationDrawable)this.mHeaderImage.getDrawable()).stop();
    while (true)
    {
      if (this.f != null)
      {
        if (!TextUtils.isEmpty(this.f.getText()))
          break;
        this.f.setVisibility(8);
      }
      return;
      resetImpl();
    }
    this.f.setVisibility(0);
  }

  protected abstract void resetImpl();

  public final void setHeight(int paramInt)
  {
    getLayoutParams().height = paramInt;
    requestLayout();
  }

  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    if (this.f != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
        break label24;
      this.f.setVisibility(8);
    }
    label24: 
    do
    {
      return;
      this.f.setText(paramCharSequence);
    }
    while (8 != this.f.getVisibility());
    this.f.setVisibility(0);
  }

  public final void setLoadingDrawable(Drawable paramDrawable)
  {
    this.mHeaderImage.setImageDrawable(paramDrawable);
    this.d = (paramDrawable instanceof AnimationDrawable);
    onLoadingDrawableSet(paramDrawable);
  }

  public void setPullLabel(CharSequence paramCharSequence)
  {
    this.g = paramCharSequence;
  }

  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    this.h = paramCharSequence;
  }

  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    this.i = paramCharSequence;
  }

  public void setTextTypeface(Typeface paramTypeface)
  {
    this.e.setTypeface(paramTypeface);
  }

  public final void setWidth(int paramInt)
  {
    getLayoutParams().width = paramInt;
    requestLayout();
  }

  public final void showInvisibleViews()
  {
    if (4 == this.e.getVisibility())
      this.e.setVisibility(0);
    if (4 == this.mHeaderProgress.getVisibility())
      this.mHeaderProgress.setVisibility(0);
    if (4 == this.mHeaderImage.getVisibility())
      this.mHeaderImage.setVisibility(0);
    if (4 == this.f.getVisibility())
      this.f.setVisibility(0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.internal.LoadingLayout
 * JD-Core Version:    0.6.2
 */