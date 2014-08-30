package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextSwitcher;
import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.view.GifImageType;
import com.xiaomi.hm.view.GifListener;
import com.xiaomi.hm.view.GifView;
import java.io.IOException;
import java.io.InputStream;

public class InstructionActivity$InstructionPage2 extends InstructionActivity.InstructionBasePage
  implements GifListener
{
  private static int a = 4;
  private int b;

  public void frameCount(int paramInt)
  {
  }

  public void gifEnd(int paramInt)
  {
    if (paramInt < a)
      return;
    this.mGifView.post(new ao(this, (byte)0));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Debug.i("DDDD", "Load Gif!!");
    InputStream localInputStream = getResources().openRawResource(2130837624);
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
    this.mTip.setCurrentText(getString(2131493255));
    this.mGifView.setGifImageType(GifImageType.COVER);
    this.mGifView.setLoopNumber(a);
    this.mGifView.setListener(this, 1);
    return localView;
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (this.mGifView == null)
      return;
    if (paramBoolean)
    {
      this.mTip.setCurrentText(getString(2131493255));
      this.mGifView.setGifImage(this.mGifFirst);
      this.b = 1;
      return;
    }
    this.mGifView.pauseGifAnimation();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.InstructionActivity.InstructionPage2
 * JD-Core Version:    0.6.2
 */