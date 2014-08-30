package cn.com.smartdevices.bracelet.location;

import android.location.Location;
import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.Debug;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

final class b extends AsyncTask<Location, Void, String>
{
  b(GetLocationHelper paramGetLocationHelper)
  {
  }

  private String a(Location[] paramArrayOfLocation)
  {
    Location localLocation = paramArrayOfLocation[0];
    GetLocationHelper.a(this.a, localLocation.getLatitude());
    GetLocationHelper.b(this.a, localLocation.getLongitude());
    String str1 = "http://api.map.baidu.com/geocoder?location=" + GetLocationHelper.a(this.a) + "," + GetLocationHelper.b(this.a) + "&output=json&key=1ab613f0f0f131440ea55220ad3aa251";
    Debug.i("GetLocationHelper", "request Str =" + str1);
    HttpPost localHttpPost = new HttpPost(str1);
    try
    {
      HttpResponse localHttpResponse = new DefaultHttpClient().execute(localHttpPost);
      int i = localHttpResponse.getStatusLine().getStatusCode();
      Object localObject = null;
      if (i == 200)
      {
        String str2 = EntityUtils.toString(localHttpResponse.getEntity());
        localObject = str2;
      }
      return localObject;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      localClientProtocolException.printStackTrace();
      return null;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  private void a(String paramString)
  {
    String str = GetLocationHelper.a(this.a, paramString);
    Debug.i("GetLocationHelper", "get city:" + str);
    GetLocationHelper.c(this.a).onLocationGet(str, GetLocationHelper.b(this.a), GetLocationHelper.a(this.a));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.location.b
 * JD-Core Version:    0.6.2
 */