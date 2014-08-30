package com.xiaomi.market.sdk;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.File;

final class o
  implements Runnable
{
  o(n paramn)
  {
  }

  public final void run()
  {
    if (!s.a(true))
      Toast.makeText(m.a(n.a(this.a)), s.a(m.a(n.a(this.a)).getPackageName(), "string", "xiaomi_external_storage_unavailable"), 0).show();
    while (m.b(n.a(this.a)) == null)
      return;
    if (TextUtils.isEmpty(m.c(n.a(this.a)).i));
    for (String str = c.c(m.c(n.a(this.a)).a, m.c(n.a(this.a)).f); ; str = c.c(m.c(n.a(this.a)).a, m.c(n.a(this.a)).i))
    {
      Uri localUri1 = Uri.parse(str);
      File localFile = new File(m.a(n.a(this.a)).getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/updates");
      if (!localFile.exists())
        localFile.mkdirs();
      m.a(n.a(this.a), new File(localFile.getAbsolutePath() + "/" + m.d(n.a(this.a)).packageName + m.c(n.a(this.a)).d));
      if (m.e(n.a(this.a)).exists())
        m.e(n.a(this.a)).delete();
      Uri localUri2 = Uri.parse("file://" + m.e(n.a(this.a)).getAbsolutePath());
      DownloadManager.Request localRequest = new DownloadManager.Request(localUri1);
      localRequest.setMimeType("application/apk-ota");
      localRequest.setTitle(m.d(n.a(this.a)).aU);
      localRequest.setDestinationUri(localUri2);
      m.a(n.a(this.a), m.b(n.a(this.a)).enqueue(localRequest));
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("package_name", m.d(n.a(this.a)).packageName);
      localContentValues.put("download_id", Long.valueOf(m.f(n.a(this.a))));
      localContentValues.put("version_code", Integer.valueOf(m.c(n.a(this.a)).d));
      localContentValues.put("apk_url", m.c(n.a(this.a)).f);
      localContentValues.put("apk_hash", m.c(n.a(this.a)).g);
      localContentValues.put("diff_url", m.c(n.a(this.a)).i);
      localContentValues.put("diff_hash", m.c(n.a(this.a)).j);
      localContentValues.put("apk_path", m.e(n.a(this.a)).getAbsolutePath());
      r.j(m.a(n.a(this.a))).a(localContentValues);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.o
 * JD-Core Version:    0.6.2
 */