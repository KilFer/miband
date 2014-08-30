package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;

public class ApkUpgradeFragment extends DimPanelFragment
{
  public static final String DOWNLOAD_ID_REF = "DOWNLOAD_ID_REF";
  public static final String UPDATE_DATE_REF = "UPDATE_DATE_REF";
  private static final String a = "ApkUpgradeFragment";
  private String b;
  private String c;
  private String d;

  protected int inflateLayout()
  {
    return 2130903061;
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    Debug.i("ApkUpgradeFragment", "onCancel();");
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    Bundle localBundle = getArguments();
    localBundle.getString("VERSION_NAME");
    this.c = localBundle.getString("APK_PATH");
    this.d = localBundle.getString("CHANGE_LOG");
    ((TextView)localView.findViewById(2131165321)).setText(this.d);
    return localView;
  }

  protected void onEmptyAreaClicked()
  {
    super.onEmptyAreaClicked();
    Debug.i("ApkUpgradeFragment", "onEmptyAreaClicked()");
  }

  protected void onLeftButtonClicked()
  {
    dismiss();
  }

  protected void onRightButtomClicked()
  {
    Toast.makeText(getActivity(), 2131493116, 1).show();
    DownloadManager.Request localRequest = new DownloadManager.Request(Uri.parse(this.c));
    localRequest.setAllowedNetworkTypes(3);
    localRequest.setAllowedOverRoaming(false);
    localRequest.setMimeType(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.c)));
    localRequest.setShowRunningNotification(true);
    localRequest.setVisibleInDownloadsUi(true);
    try
    {
      localRequest.setDestinationInExternalFilesDir(getActivity(), Environment.DIRECTORY_DOWNLOADS, "apk_upgrade.apk");
      localRequest.setTitle(getResources().getString(2131493113));
      Keeper.keepDownloadApkId(((DownloadManager)getActivity().getSystemService("download")).enqueue(localRequest));
      dismiss();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (true)
      {
        localIllegalStateException.printStackTrace();
        localRequest.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "apk_upgrade");
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.ApkUpgradeFragment
 * JD-Core Version:    0.6.2
 */