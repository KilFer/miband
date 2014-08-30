package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

final class g extends AsyncHttpResponseHandler
{
  g(PersonInfo paramPersonInfo)
  {
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    Debug.i("Utils", "Sync person info to server fail : " + paramArrayOfByte + ", statusCode " + paramInt + ", error");
    paramThrowable.printStackTrace();
  }

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    String str1 = Utils.getStringFromBytes(paramArrayOfByte);
    Debug.i("Utils", "update person info onSuccess:" + paramInt + ",content:" + str1);
    String str2 = this.a.avatarUrl;
    if (WebRes.parseAvatar(str1, this.a).success())
    {
      Debug.i("Utils", "update avatar onSuccess:" + paramInt + ", avatarUrl=" + this.a.avatarUrl);
      BraceletImageLoader.getInstance().removeImageCache(str2);
    }
    this.a.clearNeedSyncServer();
    Keeper.keepPersonInfo(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.g
 * JD-Core Version:    0.6.2
 */