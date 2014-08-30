package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.UmengAnalytics;

public class SelectImageQuestionFragment extends DimPanelFragment
{
  protected int inflateLayout()
  {
    return 2130903099;
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
    case 2131165434:
    case 2131165435:
    }
    while (true)
    {
      dismiss();
      return;
      Intent localIntent2 = new Intent("android.media.action.IMAGE_CAPTURE");
      getActivity().startActivityForResult(localIntent2, 18);
      continue;
      Intent localIntent1 = new Intent(getActivity(), CropImageActivity.class);
      getActivity().startActivityForResult(localIntent1, 17);
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    localView.findViewById(2131165434).setOnClickListener(this);
    localView.findViewById(2131165435).setOnClickListener(this);
    return localView;
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PagePersonInfoAvatarSelection");
  }

  public void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PagePersonInfoAvatarSelection");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SelectImageQuestionFragment
 * JD-Core Version:    0.6.2
 */