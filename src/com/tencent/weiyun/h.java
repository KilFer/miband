package com.tencent.weiyun;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.utils.HttpUtils;
import com.tencent.utils.HttpUtils.HttpStatusException;
import com.tencent.utils.HttpUtils.NetworkUnavailableException;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

final class h extends Thread
{
  h(f paramf)
  {
  }

  public final void run()
  {
    Uri localUri = Uri.parse(f.c(this.a));
    String str = SystemClock.elapsedRealtime() + "__" + localUri.getLastPathSegment();
    Bundle localBundle = FileManager.a(this.a.a);
    localBundle.putString("sha", f.d(this.a));
    localBundle.putString("md5", f.e(this.a));
    localBundle.putString("size", f.f(this.a));
    localBundle.putString("name", str);
    localBundle.putString("upload_type", "control");
    try
    {
      JSONObject localJSONObject = HttpUtils.request(FileManager.b(this.a.a), f.g(this.a), f.a(this.a, f.h(this.a)), localBundle, "GET");
      Message localMessage6 = f.i(this.a).obtainMessage();
      localMessage6.what = 0;
      localMessage6.obj = localJSONObject;
      f.i(this.a).sendMessage(localMessage6);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Message localMessage5 = f.i(this.a).obtainMessage();
      localMessage5.what = -3;
      localMessage5.obj = localMalformedURLException.getMessage();
      f.i(this.a).sendMessage(localMessage5);
      return;
    }
    catch (IOException localIOException)
    {
      Message localMessage4 = f.i(this.a).obtainMessage();
      localMessage4.obj = localIOException.getMessage();
      localMessage4.what = -2;
      f.i(this.a).sendMessage(localMessage4);
      return;
    }
    catch (JSONException localJSONException)
    {
      Message localMessage3 = f.i(this.a).obtainMessage();
      localMessage3.obj = localJSONException.getMessage();
      localMessage3.what = -4;
      f.i(this.a).sendMessage(localMessage3);
      return;
    }
    catch (HttpUtils.NetworkUnavailableException localNetworkUnavailableException)
    {
      Message localMessage2 = f.i(this.a).obtainMessage();
      localMessage2.obj = localNetworkUnavailableException.getMessage();
      localMessage2.what = -10;
      f.i(this.a).sendMessage(localMessage2);
      return;
    }
    catch (HttpUtils.HttpStatusException localHttpStatusException)
    {
      Message localMessage1 = f.i(this.a).obtainMessage();
      localMessage1.obj = localHttpStatusException.getMessage();
      localMessage1.what = -9;
      f.i(this.a).sendMessage(localMessage1);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.weiyun.h
 * JD-Core Version:    0.6.2
 */