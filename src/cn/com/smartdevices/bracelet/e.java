package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.view.Util;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

final class e extends AsyncHttpResponseHandler
{
  e(Utils.OperationCallback paramOperationCallback, PersonInfo paramPersonInfo)
  {
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    String str = Utils.getStringFromBytes(paramArrayOfByte);
    Debug.i("WPJ", "onFailure:" + paramInt + ",content:" + str);
    Util.hideProgressDialog();
    if (this.a != null)
      this.a.onFailure();
  }

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    String str = Utils.getStringFromBytes(paramArrayOfByte);
    Debug.i("Utils", "update Profile onSuccess:" + paramInt + ",content:" + str);
    WebStatus localWebStatus = WebRes.getWebStatus(str);
    Util.hideProgressDialog();
    if (!localWebStatus.success())
      if (this.a != null)
        this.a.onFailure();
    do
    {
      return;
      Keeper.keepPersonInfo(this.b);
    }
    while (this.a == null);
    this.a.onSuccess();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.e
 * JD-Core Version:    0.6.2
 */