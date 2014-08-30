package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Blur;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData;

public class MainMenuFragment extends DialogFragment
  implements View.OnClickListener
{
  private static final String a = "MainMenuFragment";
  private TextView b = null;
  private TextView c = null;
  private TextView d = null;
  private TextView e = null;
  private TextView f = null;
  private TextView g = null;
  private LinearLayout h = null;
  private ImageButton i = null;
  private Bitmap j = null;
  private Bitmap k = null;
  private View l = null;
  private View m = null;
  private boolean n = false;
  private ImageView o = null;
  private View p = null;
  private MainMenuFragment.MenuListener q = null;

  private Animation a(int paramInt, long paramLong)
  {
    return a(this.l.findViewById(paramInt), 2130968585, paramLong, Boolean.valueOf(true));
  }

  private Animation a(View paramView, int paramInt, long paramLong, Boolean paramBoolean)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(getActivity(), paramInt);
    localAnimation.setStartOffset(paramLong);
    localAnimation.setAnimationListener(new ar(this, paramBoolean, paramView));
    if (!paramBoolean.booleanValue());
    for (Object localObject = new AccelerateInterpolator(3.0F); ; localObject = new DecelerateInterpolator(3.0F))
    {
      localAnimation.setInterpolator((Interpolator)localObject);
      return localAnimation;
    }
  }

  private void a()
  {
    if (this.n);
    int i1;
    int i2;
    do
    {
      return;
      this.n = true;
      Debug.i("MainMenuFragment", "in onMenuPredraw");
      i1 = this.l.getWidth();
      i2 = this.l.getHeight();
      Debug.i("MainMenuFragment", "w=" + i1 + ",h=" + i2);
    }
    while ((this.j == null) || (this.j.isRecycled()));
    Debug.i("MainMenuFragment", "myBackgroundImg w=" + this.j.getWidth() + ",myBackgroundImg h=" + this.j.getHeight());
    Bitmap localBitmap1 = Bitmap.createScaledBitmap(this.j, this.j.getWidth() / 10, this.j.getHeight() / 10, true);
    Debug.i("MainMenuFragment", "scaleBmp w=" + localBitmap1.getWidth() + ",scaleBmp h=" + localBitmap1.getHeight());
    Bitmap localBitmap2 = Blur.fastblur(getActivity(), localBitmap1, 15);
    Debug.i("MainMenuFragment", "outBmp w=" + localBitmap2.getWidth() + ",outBmp h=" + localBitmap2.getHeight());
    localBitmap1.recycle();
    Bitmap localBitmap3 = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getWidth(), i2 * localBitmap2.getWidth() / i1);
    Debug.i("MainMenuFragment", "cropBmp w=" + localBitmap3.getWidth() + ",cropBmp h=" + localBitmap3.getHeight());
    localBitmap2.recycle();
    this.k = Bitmap.createScaledBitmap(localBitmap3, i1, i2, true);
    Debug.i("MainMenuFragment", "myGaussianBlurImg w=" + this.k.getWidth() + ",myGaussianBlurImg h=" + this.k.getHeight());
    localBitmap3.recycle();
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(getResources(), this.k);
    this.o.setBackground(localBitmapDrawable);
    Debug.i("MainMenuFragment", "out onMenuPredraw");
  }

  private void a(View paramView)
  {
    this.g = ((TextView)paramView.findViewById(2131165675));
    this.g.setOnClickListener(this);
    this.i = ((ImageButton)paramView.findViewById(2131165663));
    this.i.setOnClickListener(this);
    this.b = ((TextView)paramView.findViewById(2131165665));
    this.b.setOnClickListener(this);
    this.c = ((TextView)paramView.findViewById(2131165667));
    this.c.setOnClickListener(this);
    this.d = ((TextView)paramView.findViewById(2131165669));
    this.d.setOnClickListener(this);
    this.e = ((TextView)paramView.findViewById(2131165672));
    this.e.setOnClickListener(this);
    this.f = ((TextView)paramView.findViewById(2131165673));
    this.f.setOnClickListener(this);
    this.h = ((LinearLayout)paramView.findViewById(2131165671));
    if (!Utils.isSupportUnlockScreenByBracelet(getActivity()))
      this.h.setVisibility(8);
    this.o = ((ImageView)paramView.findViewById(2131165661));
    menuEnterAnimation();
  }

  private void b(int paramInt, long paramLong)
  {
    this.l.findViewById(paramInt).startAnimation(a(this.l.findViewById(paramInt), 2130968585, paramLong, Boolean.valueOf(true)));
  }

  private Animation c(int paramInt, long paramLong)
  {
    return a(this.l.findViewById(paramInt), 2130968586, paramLong, Boolean.valueOf(false));
  }

  private void d(int paramInt, long paramLong)
  {
    this.l.findViewById(paramInt).startAnimation(a(this.l.findViewById(paramInt), 2130968586, paramLong, Boolean.valueOf(false)));
  }

  public void menuEnterAnimation()
  {
    Animation localAnimation = a(this.o, 2130968585, 0L, Boolean.valueOf(true));
    this.o.startAnimation(localAnimation);
    b(2131165677, 0L);
    b(2131165676, 0L);
    b(2131165675, 0L);
    b(2131165674, 0L);
    b(2131165673, 50L);
    b(2131165670, 100L);
    b(2131165669, 150L);
    b(2131165668, 200L);
    b(2131165667, 250L);
    b(2131165666, 300L);
    b(2131165665, 350L);
    b(2131165664, 400L);
    b(2131165663, 450L);
  }

  public void menuExitAnimation()
  {
    d(2131165663, 0L);
    d(2131165664, 50L);
    d(2131165665, 100L);
    d(2131165666, 150L);
    d(2131165667, 200L);
    d(2131165668, 250L);
    View localView = getView().findViewById(2131165669);
    Animation localAnimation1 = a(localView, 2130968586, 300L, Boolean.valueOf(false));
    localAnimation1.setAnimationListener(new as(this));
    localView.startAnimation(localAnimation1);
    d(2131165670, 350L);
    d(2131165673, 400L);
    d(2131165674, 450L);
    d(2131165675, 500L);
    d(2131165676, 500L);
    d(2131165677, 500L);
    Animation localAnimation2 = a(this.o, 2130968586, 500L, Boolean.valueOf(false));
    this.o.startAnimation(localAnimation2);
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    switch (paramView.getId())
    {
    case 2131165664:
    case 2131165666:
    case 2131165668:
    case 2131165670:
    case 2131165671:
    case 2131165674:
    default:
      return;
    case 2131165675:
      localIntent.setClass(getActivity(), SettingAboutActivity.class);
      getActivity().startActivity(localIntent);
      dismiss();
      return;
    case 2131165663:
      menuExitAnimation();
      return;
    case 2131165665:
      localIntent.setClass(getActivity(), SettingActivity.class);
      getActivity().startActivity(localIntent);
      dismiss();
      return;
    case 2131165669:
      localIntent.setClass(getActivity(), PersonInfoActivity.class);
      getActivity().startActivity(localIntent);
      dismiss();
      return;
    case 2131165667:
      localIntent.setClass(getActivity(), AlarmActivity.class);
      getActivity().startActivity(localIntent);
      dismiss();
      return;
    case 2131165672:
      localIntent.setClass(getActivity(), UnlockScreenHelperActivity.class);
      getActivity().startActivity(localIntent);
      dismiss();
      return;
    case 2131165673:
    }
    localIntent.setClass(getActivity(), DynamicDetailActivity.class);
    localIntent.putExtra("Mode", ChartData.getDynamicData().getCurrentMode());
    localIntent.putExtra("Action", "RefCompleteGoal");
    getActivity().startActivity(localIntent);
    dismiss();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStyle(0, 2131623945);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903141, null);
    this.l = localView.findViewById(2131165662);
    this.m = localView.findViewById(2131165660);
    this.m.setVisibility(0);
    this.l.getViewTreeObserver().addOnPreDrawListener(new ap(this));
    this.g = ((TextView)localView.findViewById(2131165675));
    this.g.setOnClickListener(this);
    this.i = ((ImageButton)localView.findViewById(2131165663));
    this.i.setOnClickListener(this);
    this.b = ((TextView)localView.findViewById(2131165665));
    this.b.setOnClickListener(this);
    this.c = ((TextView)localView.findViewById(2131165667));
    this.c.setOnClickListener(this);
    this.d = ((TextView)localView.findViewById(2131165669));
    this.d.setOnClickListener(this);
    this.e = ((TextView)localView.findViewById(2131165672));
    this.e.setOnClickListener(this);
    this.f = ((TextView)localView.findViewById(2131165673));
    this.f.setOnClickListener(this);
    this.h = ((LinearLayout)localView.findViewById(2131165671));
    if (!Utils.isSupportUnlockScreenByBracelet(getActivity()))
      this.h.setVisibility(8);
    this.o = ((ImageView)localView.findViewById(2131165661));
    menuEnterAnimation();
    getDialog().setCanceledOnTouchOutside(true);
    this.p = localView.findViewById(2131165335);
    if (this.p != null)
      this.p.setOnClickListener(new aq(this));
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.k != null)
    {
      this.k.recycle();
      this.k = null;
    }
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (this.q != null)
      this.q.onDismiss();
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageMainMenu");
  }

  public void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageMainMenu");
  }

  public void setBackground(Bitmap paramBitmap)
  {
    this.j = paramBitmap;
  }

  public void setListener(MainMenuFragment.MenuListener paramMenuListener)
  {
    this.q = paramMenuListener;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.MainMenuFragment
 * JD-Core Version:    0.6.2
 */