package com.xiaomi.account.openauth.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.OutputStream;

final class c extends AsyncTask<Void, Void, Boolean>
{
  private String a;
  private OutputStream b;
  private Network.PostDownloadHandler c;
  private boolean d;
  private Context e;

  public c(String paramString, OutputStream paramOutputStream, Network.PostDownloadHandler paramPostDownloadHandler)
  {
    this(paramString, paramOutputStream, paramPostDownloadHandler, false, null);
  }

  public c(String paramString, OutputStream paramOutputStream, Network.PostDownloadHandler paramPostDownloadHandler, boolean paramBoolean, Context paramContext)
  {
    this.a = paramString;
    this.b = paramOutputStream;
    this.c = paramPostDownloadHandler;
    this.d = paramBoolean;
    this.e = paramContext;
  }

  private Boolean a()
  {
    return Boolean.valueOf(Network.downloadFile(this.a, this.b, this.d, this.e));
  }

  private void a(Boolean paramBoolean)
  {
    this.c.OnPostDownload(paramBoolean.booleanValue());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.account.openauth.utils.c
 * JD-Core Version:    0.6.2
 */