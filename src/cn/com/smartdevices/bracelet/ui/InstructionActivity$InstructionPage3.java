package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextSwitcher;
import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.view.GifImageType;
import com.xiaomi.hm.view.GifView;
import java.io.IOException;
import java.io.InputStream;

public class InstructionActivity$InstructionPage3 extends InstructionActivity.InstructionBasePage
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Debug.i("DDDD", "Load Gif!!");
    InputStream localInputStream = getResources().openRawResource(2130837629);
    try
    {
      this.mGifFirst = InstructionActivity.a(localInputStream);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903044, paramViewGroup, false);
    initView(localView);
    this.mTip.setCurrentText(getString(2131493260));
    this.mGifView.setGifImageType(GifImageType.COVER);
    this.mGifView.setLoopAnimation();
    return localView;
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (this.mGifView == null)
      return;
    if (paramBoolean)
    {
      this.mGifView.setGifImage(this.mGifFirst);
      return;
    }
    this.mGifView.pauseGifAnimation();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.InstructionActivity.InstructionPage3
 * JD-Core Version:    0.6.2
 */