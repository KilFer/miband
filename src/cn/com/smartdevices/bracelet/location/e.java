package cn.com.smartdevices.bracelet.location;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.PersonInfo;

final class e extends Handler
{
  e(LocationManager paramLocationManager)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return;
    case 1:
    }
    Debug.i("LocationManager", "update location");
    PersonInfo localPersonInfo = (PersonInfo)paramMessage.obj;
    LocationManager.a(this.a, localPersonInfo);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.location.e
 * JD-Core Version:    0.6.2
 */