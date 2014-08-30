package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher.ViewFactory;
import com.xiaomi.hm.view.GifView;

public class InstructionActivity$InstructionBasePage extends Fragment
  implements ViewSwitcher.ViewFactory
{
  protected byte[] mGifFirst;
  protected GifView mGifView;
  protected TextSwitcher mTip;

  protected void initView(View paramView)
  {
    View localView = paramView.findViewById(2131165235);
    if (localView != null)
      this.mGifView = ((GifView)localView);
    this.mTip = ((TextSwitcher)paramView.findViewById(2131165234));
    this.mTip.setFactory(this);
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(300L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(300L);
    this.mTip.setInAnimation(localAlphaAnimation1);
    this.mTip.setOutAnimation(localAlphaAnimation2);
  }

  public View makeView()
  {
    return LayoutInflater.from(getActivity()).inflate(2130903045, this.mTip, false);
  }

  public void onDestroy()
  {
    if (this.mGifView != null);
    try
    {
      this.mGifView.destroy();
      this.mGifView = null;
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public void onPageScrollIdle()
  {
    if (this.mGifView != null)
      this.mGifView.restartGifAnimation();
  }

  public void onPageScrolling()
  {
    if (this.mGifView != null)
      this.mGifView.pauseGifAnimation();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.InstructionActivity.InstructionBasePage
 * JD-Core Version:    0.6.2
 */