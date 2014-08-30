package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import org.apache.http.Header;

final class b extends AsyncHttpResponseHandler
{
  b(DataManager paramDataManager)
  {
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    Utils.getStringFromBytes(paramArrayOfByte);
    Debug.i("DataManager", "loadNetData onFailure:" + paramInt);
  }

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    WebStatus localWebStatus = WebRes.parseDownload(new String(paramArrayOfByte), localArrayList);
    if (localWebStatus.success())
      DataManager.getInstance().insertDatas(localArrayList, 1);
    Debug.i("DataManager", "loadNetData onSuccess:" + localWebStatus.code);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.b
 * JD-Core Version:    0.6.2
 */