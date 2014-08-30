package cn.com.smartdevices.bracelet.ui;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.view.Util;
import com.xiaomi.hm.bleservice.BLEService;
import java.util.ArrayList;

final class aZ extends Handler
{
  aZ(SearchSingleBraceletActivity paramSearchSingleBraceletActivity)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    StringBuilder localStringBuilder = new StringBuilder("search bracelet message:");
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(i);
    Debug.i("WPJ", String.format("0x%x", arrayOfObject));
    switch (i)
    {
    default:
    case 4115:
    case 4097:
    case 4100:
    case 4117:
    case 4103:
    }
    do
    {
      do
      {
        return;
        Util.hideProgressDialog();
        Debug.i("SearchSingleBraceletActivity", " connection failed");
        SearchSingleBraceletActivity.c(this.a);
        return;
      }
      while (!this.a.mDevMode);
      Toast.makeText(SearchSingleBraceletActivity.b(this.a), 2131492879, 1).show();
      return;
      SearchSingleBraceletActivity localSearchSingleBraceletActivity = this.a;
      SearchSingleBraceletActivity.a(localSearchSingleBraceletActivity, 1 + SearchSingleBraceletActivity.d(localSearchSingleBraceletActivity));
      if (SearchSingleBraceletActivity.d(this.a) <= 3)
      {
        SearchSingleBraceletActivity.e(this.a);
        return;
      }
      Toast.makeText(SearchSingleBraceletActivity.b(this.a), "通讯服务有问题，请重启程序！", 0).show();
      System.exit(-1);
      return;
      Debug.i("SearchSingleBraceletActivity", "MSG_FIRST_TIMEOUT_SCAN_BRACELET");
      SearchSingleBraceletActivity.a(this.a, true);
      removeMessages(4103);
      sendEmptyMessageDelayed(4103, 1000L);
      return;
      Debug.i("SearchSingleBraceletActivity", "STOP_SCAN_BRACELET");
      removeMessages(4103);
      if (BraceletApp.BLEService != null)
        BraceletApp.BLEService.stopScan();
      if (SearchSingleBraceletActivity.a(this.a).size() <= 0)
      {
        if (this.a.mDevMode)
          Toast.makeText(SearchSingleBraceletActivity.b(this.a), "未扫描到设备！", 0).show();
        SearchSingleBraceletActivity.f(this.a);
        return;
      }
    }
    while ((SearchSingleBraceletActivity.g(this.a) == null) || (this.a.mDevMode));
    if (this.a.mDevMode)
      Toast.makeText(SearchSingleBraceletActivity.b(this.a), 2131492942, 1).show();
    Debug.i("SearchSingleBraceletActivity", "Connect device,Found:" + SearchSingleBraceletActivity.g(this.a).a.getAddress() + ", signal= " + SearchSingleBraceletActivity.g(this.a).b);
    SearchSingleBraceletActivity.a(this.a, SearchSingleBraceletActivity.g(this.a).a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aZ
 * JD-Core Version:    0.6.2
 */