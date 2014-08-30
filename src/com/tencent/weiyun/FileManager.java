package com.tencent.weiyun;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.BaseApi.TempRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.HttpUtils;

public class FileManager extends BaseApi
{
  private static final String[] a = { "https://graph.qq.com/weiyun/get_photo_list", "https://graph.qq.com/weiyun/get_music_list", "https://graph.qq.com/weiyun/get_video_list" };
  private static final String[] b = { "https://graph.qq.com/weiyun/delete_photo", "https://graph.qq.com/weiyun/delete_music", "https://graph.qq.com/weiyun/delete_video" };

  public FileManager(Context paramContext, QQAuth paramQQAuth, QQToken paramQQToken)
  {
    super(paramContext, paramQQAuth, paramQQToken);
  }

  public FileManager(Context paramContext, QQToken paramQQToken)
  {
    super(paramContext, paramQQToken);
  }

  public void deleteFile(FileManager.WeiyunFileType paramWeiyunFileType, String paramString, IUiListener paramIUiListener)
  {
    String str = b[paramWeiyunFileType.value()];
    Bundle localBundle = composeCGIParams();
    localBundle.putString("file_id", paramString);
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, paramIUiListener);
    HttpUtils.requestAsync(this.mToken, this.mContext, str, localBundle, "GET", localTempRequestListener);
  }

  public void downLoadFile(FileManager.WeiyunFileType paramWeiyunFileType, WeiyunFile paramWeiyunFile, String paramString, IDownLoadFileCallBack paramIDownLoadFileCallBack)
  {
    new a(this, this.mContext, paramWeiyunFileType, paramWeiyunFile, paramString, paramIDownLoadFileCallBack).a();
  }

  public void downLoadThumb(WeiyunFile paramWeiyunFile, String paramString1, String paramString2, IDownLoadFileCallBack paramIDownLoadFileCallBack)
  {
    a locala = new a(this, this.mContext, FileManager.WeiyunFileType.ImageFile, paramWeiyunFile, paramString1, paramIDownLoadFileCallBack);
    locala.a(paramString2);
    locala.a();
  }

  public void getFileList(FileManager.WeiyunFileType paramWeiyunFileType, IGetFileListListener paramIGetFileListListener)
  {
    String str = a[paramWeiyunFileType.value()];
    Bundle localBundle = composeCGIParams();
    localBundle.putString("offset", "0");
    localBundle.putString("number", "100");
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, new e(this, paramIGetFileListListener));
    HttpUtils.requestAsync(this.mToken, this.mContext, str, localBundle, "GET", localTempRequestListener);
  }

  public void uploadFile(FileManager.WeiyunFileType paramWeiyunFileType, String paramString, IUploadFileCallBack paramIUploadFileCallBack)
  {
    new f(this, this.mContext, paramWeiyunFileType, paramString, paramIUploadFileCallBack).a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.weiyun.FileManager
 * JD-Core Version:    0.6.2
 */