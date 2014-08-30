package com.tencent.weiyun;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.io.File;

final class a
{
  private static final String b = "https://graph.qq.com/weiyun/download_photo";
  private static final String c = "https://graph.qq.com/weiyun/get_photo_thumb";
  private static final String d = "https://graph.qq.com/weiyun/download_music";
  private static final String e = "https://graph.qq.com/weiyun/download_video";
  private static final String f = "dl_encrypt_url";
  private static final String g = "dl_cookie_name";
  private static final String h = "dl_cookie_value";
  private static final String i = "dl_svr_host";
  private static final String j = "dl_svr_port";
  private static final String k = "dl_thumb_size";
  private static final int l = 10;
  private static final int m = 0;
  private static final int n = 1;
  private static final int o = 2;
  private int A;
  private String B;
  private String C;
  private Context p;
  private FileManager.WeiyunFileType q;
  private WeiyunFile r;
  private String s;
  private IDownLoadFileCallBack t;
  private Handler u;
  private File v;
  private String w;
  private String x;
  private String y;
  private String z;

  public a(FileManager paramFileManager, Context paramContext, FileManager.WeiyunFileType paramWeiyunFileType, WeiyunFile paramWeiyunFile, String paramString, IDownLoadFileCallBack paramIDownLoadFileCallBack)
  {
    this.p = paramContext;
    this.q = paramWeiyunFileType;
    this.r = paramWeiyunFile;
    this.s = paramString;
    this.t = paramIDownLoadFileCallBack;
    this.u = new b(this, this.p.getMainLooper(), paramFileManager);
  }

  private String a(FileManager.WeiyunFileType paramWeiyunFileType)
  {
    if (paramWeiyunFileType == FileManager.WeiyunFileType.ImageFile)
    {
      if (this.C != null)
        return "https://graph.qq.com/weiyun/get_photo_thumb";
      return "https://graph.qq.com/weiyun/download_photo";
    }
    if (paramWeiyunFileType == FileManager.WeiyunFileType.MusicFile)
      return "https://graph.qq.com/weiyun/download_music";
    if (paramWeiyunFileType == FileManager.WeiyunFileType.VideoFile)
      return "https://graph.qq.com/weiyun/download_video";
    return "https://graph.qq.com/weiyun/download_photo";
  }

  private void b()
  {
    new c(this).start();
  }

  private void c()
  {
    new d(this).start();
  }

  public final void a()
  {
    if ((this.s == null) || (this.q == null) || (this.r == null) || (this.r.getFileId() == null))
    {
      Message localMessage1 = this.u.obtainMessage();
      localMessage1.what = -5;
      localMessage1.obj = new String("");
      this.u.sendMessage(localMessage1);
      return;
    }
    this.v = new File(this.s);
    if (this.v.exists())
    {
      Message localMessage2 = this.u.obtainMessage();
      localMessage2.what = -11;
      localMessage2.obj = new String("");
      this.u.sendMessage(localMessage2);
      return;
    }
    this.t.onPrepareStart();
    new c(this).start();
  }

  public final void a(String paramString)
  {
    this.C = paramString;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.weiyun.a
 * JD-Core Version:    0.6.2
 */