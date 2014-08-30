package com.tencent.weiyun;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.utils.HttpUtils;
import com.tencent.utils.HttpUtils.HttpStatusException;
import com.tencent.utils.HttpUtils.NetworkUnavailableException;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

final class c extends Thread
{
  c(a parama)
  {
  }

  public final void run()
  {
    Bundle localBundle = FileManager.c(this.a.a);
    localBundle.putString("file_id", a.d(this.a).getFileId());
    if (!TextUtils.isEmpty(a.e(this.a)))
      localBundle.putString("thumb", a.e(this.a));
    try
    {
      JSONObject localJSONObject = HttpUtils.request(FileManager.d(this.a.a), a.f(this.a), a.a(this.a, a.g(this.a)), localBundle, "GET");
      Message localMessage6 = a.h(this.a).obtainMessage();
      localMessage6.what = 0;
      localMessage6.obj = localJSONObject;
      a.h(this.a).sendMessage(localMessage6);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Message localMessage5 = a.h(this.a).obtainMessage();
      localMessage5.what = -3;
      localMessage5.obj = localMalformedURLException.getMessage();
      a.h(this.a).sendMessage(localMessage5);
      return;
    }
    catch (IOException localIOException)
    {
      Message localMessage4 = a.h(this.a).obtainMessage();
      localMessage4.obj = localIOException.getMessage();
      localMessage4.what = -2;
      a.h(this.a).sendMessage(localMessage4);
      return;
    }
    catch (JSONException localJSONException)
    {
      Message localMessage3 = a.h(this.a).obtainMessage();
      localMessage3.obj = localJSONException.getMessage();
      localMessage3.what = -4;
      a.h(this.a).sendMessage(localMessage3);
      return;
    }
    catch (HttpUtils.NetworkUnavailableException localNetworkUnavailableException)
    {
      Message localMessage2 = a.h(this.a).obtainMessage();
      localMessage2.obj = localNetworkUnavailableException.getMessage();
      localMessage2.what = -10;
      a.h(this.a).sendMessage(localMessage2);
      return;
    }
    catch (HttpUtils.HttpStatusException localHttpStatusException)
    {
      Message localMessage1 = a.h(this.a).obtainMessage();
      localMessage1.obj = localHttpStatusException.getMessage();
      localMessage1.what = -9;
      a.h(this.a).sendMessage(localMessage1);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.weiyun.c
 * JD-Core Version:    0.6.2
 */