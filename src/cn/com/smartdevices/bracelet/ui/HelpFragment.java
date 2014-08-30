package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class HelpFragment extends Fragment
{
  private String a;
  private WebView b;
  private ProgressBar c;
  private WebViewClient d = new ak(this);
  private WebChromeClient e = new al(this);

  public static HelpFragment newInstance()
  {
    HelpFragment localHelpFragment = new HelpFragment();
    localHelpFragment.setArguments(new Bundle());
    return localHelpFragment;
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903082, null);
    this.a = "http://ota.app-xae.xiaomi.net/help.html";
    this.b = ((WebView)localView.findViewById(2131165218));
    this.c = ((ProgressBar)localView.findViewById(2131165393));
    this.b.setWebViewClient(this.d);
    this.b.setWebChromeClient(this.e);
    this.b.loadUrl(this.a);
    setHasOptionsMenu(true);
    return localView;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.HelpFragment
 * JD-Core Version:    0.6.2
 */