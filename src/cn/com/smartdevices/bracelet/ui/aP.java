package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

final class aP extends AsyncHttpResponseHandler
{
  aP(PersonInfoFragment paramPersonInfoFragment)
  {
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    String str = Utils.getStringFromBytes(paramArrayOfByte);
    Debug.i("WPJ", "onFailure statusCode:" + paramInt + ",content:" + str);
  }

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    String str = Utils.getStringFromBytes(paramArrayOfByte);
    Debug.i("PersonInfoFragment", "get person info onSuccess statusCode:" + paramInt + ",content:" + str);
    if (!WebRes.parseUserInfo(str, PersonInfoFragment.a(this.a)).success())
      return;
    Debug.i("PersonInfoFragment", "person info :" + PersonInfoFragment.a(this.a).toString());
    if (PersonInfoFragment.a(this.a).uid == Keeper.readLoginData().uid)
      Keeper.keepPersonInfo(PersonInfoFragment.a(this.a));
    PersonInfoFragment.b(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aP
 * JD-Core Version:    0.6.2
 */