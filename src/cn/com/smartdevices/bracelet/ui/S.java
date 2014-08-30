package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

final class S extends AsyncHttpResponseHandler
{
  S(DynamicDetailSleepModifyFragment paramDynamicDetailSleepModifyFragment)
  {
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    String str = Utils.getStringFromBytes(paramArrayOfByte);
    Debug.i("Dynamic.Detail.SleepModify", "Sync Summary To Server Failed : " + DynamicDetailSleepModifyFragment.a(this.a) + " \n " + str);
  }

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    String str = Utils.getStringFromBytes(paramArrayOfByte);
    WebRes.getWebStatus(str).success();
    Debug.i("Dynamic.Detail.SleepModify", "Sync Summary To Server Success : " + DynamicDetailSleepModifyFragment.a(this.a) + " \n " + str);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.S
 * JD-Core Version:    0.6.2
 */