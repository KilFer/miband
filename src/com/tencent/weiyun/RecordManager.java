package com.tencent.weiyun;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.BaseApi.TempRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.HttpUtils;
import com.tencent.utils.Util;

public class RecordManager extends BaseApi
{
  public RecordManager(Context paramContext, QQAuth paramQQAuth, QQToken paramQQToken)
  {
    super(paramContext, paramQQAuth, paramQQToken);
  }

  public RecordManager(Context paramContext, QQToken paramQQToken)
  {
    super(paramContext, paramQQToken);
  }

  public void checkRecord(String paramString, IUiListener paramIUiListener)
  {
    Bundle localBundle = composeCGIParams();
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, new o(this, paramIUiListener));
    localBundle.putString("key", Util.toHexString(paramString));
    HttpUtils.requestAsync(this.mToken, this.mContext, "https://graph.qq.com/weiyun/check_record", localBundle, "GET", localTempRequestListener);
  }

  public void createRecord(String paramString1, String paramString2, IUiListener paramIUiListener)
  {
    Bundle localBundle = composeCGIParams();
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, new j(this, paramIUiListener));
    localBundle.putString("key", Util.toHexString(paramString1));
    localBundle.putByteArray("value", Util.toHexString(paramString2).getBytes());
    HttpUtils.requestAsync(this.mToken, this.mContext, "https://graph.qq.com/weiyun/create_record", localBundle, "POST", localTempRequestListener);
  }

  public void deleteRecord(String paramString, IUiListener paramIUiListener)
  {
    Bundle localBundle = composeCGIParams();
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, new k(this, paramIUiListener));
    localBundle.putString("key", Util.toHexString(paramString));
    HttpUtils.requestAsync(this.mToken, this.mContext, "https://graph.qq.com/weiyun/delete_record", localBundle, "GET", localTempRequestListener);
  }

  public void getRecord(String paramString, IUiListener paramIUiListener)
  {
    Bundle localBundle = composeCGIParams();
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, new l(this, paramIUiListener));
    localBundle.putString("key", Util.toHexString(paramString));
    HttpUtils.requestAsync(this.mToken, this.mContext, "https://graph.qq.com/weiyun/get_record", localBundle, "GET", localTempRequestListener);
  }

  public void modifyRecord(String paramString1, String paramString2, IUiListener paramIUiListener)
  {
    Bundle localBundle = composeCGIParams();
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, new m(this, paramIUiListener));
    localBundle.putString("key", Util.toHexString(paramString1));
    localBundle.putByteArray("value", Util.toHexString(paramString2).getBytes());
    HttpUtils.requestAsync(this.mToken, this.mContext, "https://graph.qq.com/weiyun/modify_record", localBundle, "POST", localTempRequestListener);
  }

  public void queryAllRecord(IUiListener paramIUiListener)
  {
    Bundle localBundle = composeCGIParams();
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, new n(this, paramIUiListener));
    HttpUtils.requestAsync(this.mToken, this.mContext, "https://graph.qq.com/weiyun/query_all_record", localBundle, "GET", localTempRequestListener);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.weiyun.RecordManager
 * JD-Core Version:    0.6.2
 */