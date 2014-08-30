package cn.com.smartdevices.bracelet.lua;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

final class i extends AsyncHttpResponseHandler
{
  i(LuaManager paramLuaManager)
  {
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    Debug.i("chenee", "getLuaZipFile onFailure=========================================");
  }

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    String str = Utils.getStringFromBytes(paramArrayOfByte);
    try
    {
      Utils.getGson().fromJson(str, j.class);
      Debug.i("chenee", "get latest luaZipFile error (message:" + null + ")");
      return;
    }
    catch (Exception localException)
    {
      Debug.e("chenee", "get latest lua gson error!:" + localException.getMessage());
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.i
 * JD-Core Version:    0.6.2
 */