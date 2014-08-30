package cn.com.smartdevices.bracelet.ui.person;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

final class a extends AsyncHttpResponseHandler
{
  a(PersonInfoSetSportGoalActivity paramPersonInfoSetSportGoalActivity, PersonInfo paramPersonInfo)
  {
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    String str = Utils.getStringFromBytes(paramArrayOfByte);
    Debug.i("PersonInfoSetSportGoalActivity", "statusCode=" + paramInt + ", content=" + str);
  }

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    String str = Utils.getStringFromBytes(paramArrayOfByte);
    if (WebRes.getWebStatus(str).success())
    {
      this.b.clearNeedSyncServer();
      Keeper.keepPersonInfo(this.b);
      return;
    }
    Debug.i("PersonInfoSetSportGoalActivity", "statusCode=" + paramInt + ", content=" + str);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.person.a
 * JD-Core Version:    0.6.2
 */