package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleBindWeixinTask;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import de.greenrobot.event.EventBus;
import java.io.File;

public class BindWeixinActivity extends Activity
  implements View.OnClickListener
{
  private static final int a = 0;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  private static final int f = 5;
  private static final int g = 500;
  private static final int h = 500;
  private static final int i = 1;
  private static final int j = 0;
  private static final String k = "BindWeixinActivity";
  private Button l = null;
  private TextView m = null;
  private Handler n = null;
  private String o = "";
  private MediaScannerConnection p = null;
  private String q = null;
  private Button r;
  private View s;

  private Intent a(String paramString)
  {
    return getPackageManager().getLaunchIntentForPackage(paramString);
  }

  private void a()
  {
    IWXAPI localIWXAPI = WXAPIFactory.createWXAPI(this, "wx28e2610e92fbe111");
    localIWXAPI.registerApp("wx28e2610e92fbe111");
    if (localIWXAPI.isWXAppInstalled())
      localIWXAPI.openWXApp();
  }

  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      a(this.l, false);
      a(this.r, true);
    }
    while (true)
    {
      if (getPackageManager().getLaunchIntentForPackage("com.tencent.mm") == null)
      {
        a(this.r, false);
        this.r.setText(2131493161);
      }
      return;
      a(this.l, true);
      a(this.r, false);
    }
  }

  private void a(Button paramButton, boolean paramBoolean)
  {
    paramButton.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      paramButton.setTextColor(getResources().getColor(2131230737));
      return;
    }
    paramButton.setTextColor(getResources().getColor(2131230723));
  }

  private void b()
  {
    new BleBindWeixinTask(new x(this)).work();
  }

  // ERROR //
  private boolean b(String paramString)
  {
    // Byte code:
    //   0: new 177	java/util/Hashtable
    //   3: dup
    //   4: invokespecial 178	java/util/Hashtable:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getstatic 184	com/google/zxing/EncodeHintType:CHARACTER_SET	Lcom/google/zxing/EncodeHintType;
    //   12: ldc 186
    //   14: invokevirtual 190	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   17: pop
    //   18: new 192	com/google/zxing/qrcode/QRCodeWriter
    //   21: dup
    //   22: invokespecial 193	com/google/zxing/qrcode/QRCodeWriter:<init>	()V
    //   25: aload_1
    //   26: getstatic 199	com/google/zxing/BarcodeFormat:QR_CODE	Lcom/google/zxing/BarcodeFormat;
    //   29: sipush 500
    //   32: sipush 500
    //   35: aload_2
    //   36: invokevirtual 203	com/google/zxing/qrcode/QRCodeWriter:encode	(Ljava/lang/String;Lcom/google/zxing/BarcodeFormat;IILjava/util/Map;)Lcom/google/zxing/common/BitMatrix;
    //   39: astore 7
    //   41: ldc 204
    //   43: newarray int
    //   45: astore 8
    //   47: iconst_0
    //   48: istore 9
    //   50: iload 9
    //   52: sipush 500
    //   55: if_icmplt +82 -> 137
    //   58: sipush 500
    //   61: sipush 500
    //   64: getstatic 210	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   67: invokestatic 216	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   70: astore 10
    //   72: aload 10
    //   74: aload 8
    //   76: iconst_0
    //   77: sipush 500
    //   80: iconst_0
    //   81: iconst_0
    //   82: sipush 500
    //   85: sipush 500
    //   88: invokevirtual 220	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   91: new 222	java/io/FileOutputStream
    //   94: dup
    //   95: new 224	java/io/File
    //   98: dup
    //   99: aload_0
    //   100: getfield 59	cn/com/smartdevices/bracelet/ui/BindWeixinActivity:q	Ljava/lang/String;
    //   103: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: invokespecial 230	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   109: astore 11
    //   111: aload 10
    //   113: getstatic 236	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   116: bipush 100
    //   118: aload 11
    //   120: invokevirtual 240	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   123: istore 12
    //   125: iload 12
    //   127: istore 5
    //   129: aload 11
    //   131: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   134: iload 5
    //   136: ireturn
    //   137: iconst_0
    //   138: istore 13
    //   140: iload 13
    //   142: sipush 500
    //   145: if_icmplt +9 -> 154
    //   148: iinc 9 1
    //   151: goto -101 -> 50
    //   154: aload 7
    //   156: iload 13
    //   158: iload 9
    //   160: invokevirtual 249	com/google/zxing/common/BitMatrix:get	(II)Z
    //   163: ifeq +20 -> 183
    //   166: aload 8
    //   168: iload 13
    //   170: iload 9
    //   172: sipush 500
    //   175: imul
    //   176: iadd
    //   177: ldc 250
    //   179: iastore
    //   180: goto +39 -> 219
    //   183: aload 8
    //   185: iload 13
    //   187: iload 9
    //   189: sipush 500
    //   192: imul
    //   193: iadd
    //   194: iconst_m1
    //   195: iastore
    //   196: goto +23 -> 219
    //   199: astore_3
    //   200: aload_3
    //   201: astore 4
    //   203: iconst_0
    //   204: istore 5
    //   206: aload 4
    //   208: invokevirtual 253	java/lang/Exception:printStackTrace	()V
    //   211: iload 5
    //   213: ireturn
    //   214: astore 4
    //   216: goto -10 -> 206
    //   219: iinc 13 1
    //   222: goto -82 -> 140
    //
    // Exception table:
    //   from	to	target	type
    //   0	47	199	java/lang/Exception
    //   58	125	199	java/lang/Exception
    //   154	180	199	java/lang/Exception
    //   183	196	199	java/lang/Exception
    //   129	134	214	java/lang/Exception
  }

  private void c()
  {
    this.n.sendEmptyMessage(2);
  }

  private void d()
  {
    this.n.sendEmptyMessage(3);
  }

  private void e()
  {
    WebAPI.getWeixinQR(Keeper.readLoginData(), Keeper.readDeviceId(), new y(this));
  }

  private void f()
  {
    new Thread(new z(this)).start();
  }

  private void g()
  {
    if ((this.p != null) && (this.p.isConnected()))
      this.p.disconnect();
    this.p = new MediaScannerConnection(this, new A(this));
    this.p.connect();
  }

  private void h()
  {
    Utils.showProgressDialog(this, 2131493236);
  }

  private void i()
  {
    Utils.hideProgressDialog(this);
  }

  public void onBleStatusChanged(BaseSCActivity.ConnStatus paramConnStatus)
  {
    Debug.i("BindWeixinActivity", "onBleStatusChanged, status = " + paramConnStatus);
    if (paramConnStatus.a == 8)
      this.s.setVisibility(8);
    while (paramConnStatus.a >= 8)
      return;
    this.s.setVisibility(0);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165221:
    case 2131165222:
    case 2131165223:
    default:
      return;
    case 2131165225:
      if (Utils.isNetworkConnected(this))
      {
        new BleBindWeixinTask(new x(this)).work();
        return;
      }
      Toast.makeText(this, 2131493308, 0).show();
      return;
    case 2131165224:
      a();
      return;
    case 2131165220:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getString(2131492870));
    if (!localFile.exists())
      localFile.mkdirs();
    this.q = (localFile.getAbsolutePath() + "/" + getString(2131493292) + ".jpg");
    this.l = ((Button)findViewById(2131165225));
    this.l.setOnClickListener(this);
    this.r = ((Button)findViewById(2131165224));
    this.r.setOnClickListener(this);
    this.s = findViewById(2131165226);
    this.m = ((TextView)findViewById(2131165220));
    this.m.setOnClickListener(this);
    this.n = new w(this);
    a(0);
    EventBus.getDefault().register(this, "onBleStatusChanged", BaseSCActivity.ConnStatus.class, new Class[0]);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.p != null) && (this.p.isConnected()))
      this.p.disconnect();
    this.n.removeCallbacksAndMessages(null);
    this.n = null;
    EventBus.getDefault().unregister(this);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageBindWeChat");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageBindWeChat");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.BindWeixinActivity
 * JD-Core Version:    0.6.2
 */