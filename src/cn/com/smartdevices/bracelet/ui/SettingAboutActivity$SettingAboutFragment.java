package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SettingAboutActivity$SettingAboutFragment extends Fragment
  implements View.OnClickListener
{
  private static final String a = "SettingAboutActivity";
  private View b;
  private TextView c;
  private View d;
  private View e;
  private View f = null;
  private LinearLayout g;
  private TextView h;
  private TextView i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  private ProgressDialog n = null;
  private int o = 0;
  private Handler p = new bg(this);

  private void a()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    localBuilder.setTitle("上传调试日志");
    localBuilder.setMessage("请确保是wifi网络连接，否则会耗费您的数据流量，确定上传？");
    localBuilder.setPositiveButton("确定", new bi(this));
    localBuilder.setNegativeButton("取消", new bj(this));
    localBuilder.show();
  }

  private void a(View paramView)
  {
    this.b = paramView.findViewById(2131165230);
    this.b.setOnClickListener(this);
    paramView.findViewById(2131165440);
    this.d = paramView.findViewById(2131165448);
    this.e = paramView.findViewById(2131165445);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    paramView.findViewById(2131165447).setOnClickListener(this);
    paramView.findViewById(2131165441);
    paramView.findViewById(2131165442);
    this.i = ((TextView)paramView.findViewById(2131165438));
    paramView.findViewById(2131165443).setOnClickListener(this);
    paramView.findViewById(2131165443).setOnLongClickListener(new bh(this));
    this.f = paramView.findViewById(2131165436);
    this.f.setOnClickListener(this);
  }

  private void b()
  {
    new Thread(new bk(this)).start();
  }

  private void c()
  {
    while (true)
    {
      long l1;
      try
      {
        if (this.p != null)
          this.p.sendEmptyMessage(1);
        String str1 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        File localFile1 = new File(str2 + "/mili_log_" + str1 + ".zip");
        if (localFile1.exists())
          localFile1.delete();
        byte[] arrayOfByte = new byte[4096];
        File localFile2 = new File(str2 + "/mili_log.txt");
        FileInputStream localFileInputStream = new FileInputStream(localFile2);
        l1 = localFile2.length() - 52428800L;
        break label308;
        ZipEntry localZipEntry = new ZipEntry("mili_log_" + str1 + ".txt");
        ZipOutputStream localZipOutputStream = new ZipOutputStream(new FileOutputStream(localFile1));
        localZipOutputStream.putNextEntry(localZipEntry);
        int i1 = localFileInputStream.read(arrayOfByte, 0, arrayOfByte.length);
        if (i1 <= 0)
        {
          localZipOutputStream.closeEntry();
          localFileInputStream.close();
          localZipOutputStream.close();
          WebAPI.uploadLogFileBlock(Keeper.readLoginData(), localFile1, new bl(this, localFile1));
          return;
          long l2 = localFileInputStream.skip(l1);
          if (l2 == -1L)
            continue;
          l1 -= l2;
          break label308;
        }
        localZipOutputStream.write(arrayOfByte, 0, i1);
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label308: if (l1 > 0L);
    }
  }

  private void d()
  {
    if (Keeper.readFileDebugFlag())
    {
      Debug.enable(false);
      Keeper.keepDebugFlag(false);
      Keeper.keepFileDebugFlag(false);
      Toast.makeText(getActivity(), 2131493299, 0).show();
      return;
    }
    Debug.enable(true);
    Keeper.keepDebugFlag(true);
    Keeper.keepFileDebugFlag(true);
    Toast.makeText(getActivity(), 2131493298, 0).show();
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165230:
      getActivity().finish();
      return;
    case 2131165448:
      Utils.gotoWeb("file:///android_asset/useragreement.html", getString(2131493072), getActivity());
      return;
    case 2131165445:
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse("http://www.mi.com"));
      startActivity(localIntent);
      return;
    case 2131165447:
      if (Utils.isNetworkConnected(getActivity()))
      {
        Utils.checkApkUpgrade(getActivity(), true);
        return;
      }
      Toast.makeText(getActivity(), 2131493308, 0).show();
      return;
    case 2131165443:
      startActivity(new Intent(getActivity(), SettingFeedbackActivity.class));
      return;
    case 2131165436:
    }
    this.o = (1 + this.o);
    if (this.o == 5)
    {
      if (!Keeper.readFileDebugFlag())
        break label243;
      Debug.enable(false);
      Keeper.keepDebugFlag(false);
      Keeper.keepFileDebugFlag(false);
      Toast.makeText(getActivity(), 2131493299, 0).show();
    }
    while (true)
    {
      this.p.removeMessages(4);
      this.p.sendEmptyMessageDelayed(4, 300L);
      return;
      label243: Debug.enable(true);
      Keeper.keepDebugFlag(true);
      Keeper.keepFileDebugFlag(true);
      Toast.makeText(getActivity(), 2131493298, 0).show();
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903100, paramViewGroup, false);
    this.b = localView.findViewById(2131165230);
    this.b.setOnClickListener(this);
    localView.findViewById(2131165440);
    this.d = localView.findViewById(2131165448);
    this.e = localView.findViewById(2131165445);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    localView.findViewById(2131165447).setOnClickListener(this);
    localView.findViewById(2131165441);
    localView.findViewById(2131165442);
    this.i = ((TextView)localView.findViewById(2131165438));
    localView.findViewById(2131165443).setOnClickListener(this);
    localView.findViewById(2131165443).setOnLongClickListener(new bh(this));
    this.f = localView.findViewById(2131165436);
    this.f.setOnClickListener(this);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.p.removeCallbacksAndMessages(null);
    this.p = null;
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageAbout");
  }

  public void onResume()
  {
    super.onResume();
    Debug.i("SettingAboutActivity", "onResume() ");
    try
    {
      PackageInfo localPackageInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
      this.i.setText(localPackageInfo.versionName);
      UmengAnalytics.startPage("PageAbout");
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        localNameNotFoundException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SettingAboutActivity.SettingAboutFragment
 * JD-Core Version:    0.6.2
 */