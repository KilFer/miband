package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

final class bw extends AsyncHttpResponseHandler
{
  bw(SettingFragment paramSettingFragment)
  {
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    Debug.i("SettingFragment", "updateProfile onFailed: " + paramInt);
  }

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    SettingFragment.b(this.a).clearNeedSyncServer();
    Keeper.keepPersonInfo(SettingFragment.b(this.a));
    Debug.i("SettingFragment", "send person info to server ok!");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bw
 * JD-Core Version:    0.6.2
 */