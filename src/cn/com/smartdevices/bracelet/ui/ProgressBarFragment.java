package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProgressBarFragment extends DimPanelFragment
{
  protected int inflateLayout()
  {
    return 2130903097;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    Bundle localBundle = getArguments();
    TextView localTextView = (TextView)localView.findViewById(2131165432);
    if (localBundle != null)
      localTextView.setText(localBundle.getString("REF_PROGRESS_INFO", "..."));
    return localView;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.ProgressBarFragment
 * JD-Core Version:    0.6.2
 */