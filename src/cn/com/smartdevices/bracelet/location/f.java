package cn.com.smartdevices.bracelet.location;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

final class f extends AsyncHttpResponseHandler
{
  f(LocationManager paramLocationManager)
  {
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    String str = Utils.getStringFromBytes(paramArrayOfByte);
    Debug.i("WPJ", "onFailure:" + paramInt + ",content:" + str);
  }

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    String str = Utils.getStringFromBytes(paramArrayOfByte);
    Debug.i("WPJ", "send location onSuccess:" + paramInt + ",content:" + str);
    if (!WebRes.getWebStatus(str).success());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.location.f
 * JD-Core Version:    0.6.2
 */