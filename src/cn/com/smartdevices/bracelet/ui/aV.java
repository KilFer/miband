package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

final class aV extends AsyncHttpResponseHandler
{
  aV(PersonInfoFragment paramPersonInfoFragment)
  {
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    PersonInfoFragment.a(this.a, false);
  }

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    WebStatus localWebStatus = WebRes.getWebStatus(Utils.getStringFromBytes(paramArrayOfByte));
    PersonInfoFragment.a(this.a, localWebStatus.success());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aV
 * JD-Core Version:    0.6.2
 */