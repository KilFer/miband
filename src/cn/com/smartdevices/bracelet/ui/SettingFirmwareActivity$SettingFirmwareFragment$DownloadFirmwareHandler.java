package cn.com.smartdevices.bracelet.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.upgrade.OtaVersionInfo;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import org.apache.http.Header;

public class SettingFirmwareActivity$SettingFirmwareFragment$DownloadFirmwareHandler extends FileAsyncHttpResponseHandler
{
  private static final char[] g = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private SettingFirmwareActivity.SettingFirmwareFragment a;
  private Context b;
  private File c;
  private OtaVersionInfo d;
  private boolean e;
  private ProgressDialog f;

  public SettingFirmwareActivity$SettingFirmwareFragment$DownloadFirmwareHandler(SettingFirmwareActivity.SettingFirmwareFragment paramSettingFirmwareFragment, Context paramContext, File paramFile, OtaVersionInfo paramOtaVersionInfo)
  {
    super(paramFile);
    this.a = paramSettingFirmwareFragment;
    this.b = paramContext;
    this.c = paramFile;
    this.d = paramOtaVersionInfo;
    if (this.f == null)
    {
      this.f = new ProgressDialog(paramContext);
      this.f.setMax(100);
      this.f.setProgress(0);
      this.f.setTitle("固件下载");
      this.f.setMessage("下载进度");
      this.f.setProgressStyle(1);
      this.f.setIndeterminate(false);
      this.f.setCancelable(true);
      this.f.setOnCancelListener(new bu(this));
    }
  }

  private void a()
  {
    if (this.f != null)
      this.f.show();
  }

  private void a(int paramInt)
  {
    if (this.f != null)
      this.f.setProgress(paramInt);
  }

  private void a(Context paramContext)
  {
    if (this.f == null)
    {
      this.f = new ProgressDialog(paramContext);
      this.f.setMax(100);
      this.f.setProgress(0);
      this.f.setTitle("固件下载");
      this.f.setMessage("下载进度");
      this.f.setProgressStyle(1);
      this.f.setIndeterminate(false);
      this.f.setCancelable(true);
      this.f.setOnCancelListener(new bu(this));
    }
  }

  private void b()
  {
    if (this.f != null)
      this.f.dismiss();
  }

  public static String md5sum(File paramFile)
  {
    if (!paramFile.isFile())
      return null;
    byte[] arrayOfByte = new byte[1024];
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      while (true)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i <= 0)
        {
          localFileInputStream.close();
          return toHexString(localMessageDigest.digest());
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length << 1);
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfByte.length)
        return localStringBuilder.toString();
      localStringBuilder.append(g[((0xF0 & paramArrayOfByte[i]) >>> 4)]);
      localStringBuilder.append(g[(0xF & paramArrayOfByte[i])]);
    }
  }

  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, File paramFile)
  {
    Debug.w("Setting.Firmware", "Download On Failure : " + this.c.getPath());
    Debug.w("Setting.Firmware", paramThrowable.toString());
    int i;
    if (paramArrayOfHeader != null)
      i = paramArrayOfHeader.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        if (!this.e)
          break;
        return;
      }
      Header localHeader = paramArrayOfHeader[j];
      Debug.i("Setting.Firmware", localHeader.getName() + " : " + localHeader.getValue());
    }
    b();
    Toast.makeText(this.b, "下载固件失败，请重试", 0).show();
  }

  public void onFinish()
  {
    Debug.i("Setting.Firmware", "Download On Finish!!");
    if (this.c.exists())
      this.c.delete();
    b();
  }

  public void onProgress(int paramInt1, int paramInt2)
  {
    Debug.i("Setting.Firmware", "Download On Progress : " + paramInt1 + " Total : " + paramInt2);
    int i = (int)(100.0F * (paramInt1 / paramInt2));
    if (this.f != null)
      this.f.setProgress(i);
  }

  public void onStart()
  {
    super.onStart();
    Debug.i("Setting.Firmware", "Download On Start!!");
    if (this.f != null)
      this.f.show();
  }

  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, File paramFile)
  {
    Debug.i("Setting.Firmware", "Download On Success!!");
    int i;
    if (paramArrayOfHeader != null)
      i = paramArrayOfHeader.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        if (!this.e)
          break;
        return;
      }
      Header localHeader = paramArrayOfHeader[j];
      Debug.i("Setting.Firmware", localHeader.getName() + " : " + localHeader.getValue());
    }
    String str1 = this.c.getPath();
    File localFile = new File(str1.substring(0, -4 + str1.length()));
    if (localFile.exists())
      localFile.delete();
    this.c.renameTo(localFile);
    Debug.i("Setting.Firmware", "FirmwareFile : " + localFile + " , " + localFile.exists() + " , " + localFile.length());
    String str2 = md5sum(localFile);
    Debug.i("Setting.Firmware", "FirmwareMd5 : " + str2);
    if (str2.equalsIgnoreCase(this.d.firmwareMd5))
    {
      this.a.confirmFwUpgrade();
      return;
    }
    Toast.makeText(this.b, "固件校验失败，请重试", 0).show();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SettingFirmwareActivity.SettingFirmwareFragment.DownloadFirmwareHandler
 * JD-Core Version:    0.6.2
 */