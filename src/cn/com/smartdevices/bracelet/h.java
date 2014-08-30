package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.eventbus.EventApkupgrade;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import de.greenrobot.event.EventBus;
import org.apache.http.Header;

final class h extends AsyncHttpResponseHandler
{
  h(boolean paramBoolean)
  {
  }

  // ERROR //
  private static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 18
    //   2: astore_1
    //   3: new 20	org/json/JSONObject
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 23	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: ldc 25
    //   13: invokevirtual 29	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull +46 -> 64
    //   21: aload_3
    //   22: ldc 31
    //   24: invokevirtual 34	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 4
    //   29: aload 4
    //   31: ldc 36
    //   33: ldc 38
    //   35: invokevirtual 44	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   38: astore 6
    //   40: aload 6
    //   42: astore_1
    //   43: ldc 46
    //   45: new 48	java/lang/StringBuilder
    //   48: dup
    //   49: ldc 50
    //   51: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: aload_1
    //   55: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 65	cn/com/smartdevices/bracelet/Debug:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_1
    //   65: areturn
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 68	org/json/JSONException:printStackTrace	()V
    //   71: aload_1
    //   72: areturn
    //   73: astore 5
    //   75: aload 4
    //   77: astore_1
    //   78: aload 5
    //   80: astore_2
    //   81: goto -14 -> 67
    //
    // Exception table:
    //   from	to	target	type
    //   3	17	66	org/json/JSONException
    //   21	29	66	org/json/JSONException
    //   43	64	66	org/json/JSONException
    //   29	40	73	org/json/JSONException
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
  }

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    Debug.i("Utils", "get changelog onSuccess: " + new String(paramArrayOfByte));
    String str1 = new String(paramArrayOfByte);
    if (WebRes.getWebStatus(str1).success())
    {
      String str2 = a(str1);
      EventBus.getDefault().post(new EventApkupgrade(this.a, str2));
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.h
 * JD-Core Version:    0.6.2
 */