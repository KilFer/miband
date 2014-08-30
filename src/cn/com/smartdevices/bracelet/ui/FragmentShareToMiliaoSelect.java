package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class FragmentShareToMiliaoSelect extends DimPanelFragment
  implements View.OnClickListener
{
  protected int inflateLayout()
  {
    return 2130903107;
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165459:
      ((ShareActivity)getActivity()).shareToMiliao(100201);
      dismiss();
      return;
    case 2131165457:
      ((ShareActivity)getActivity()).shareToMiliao(100200);
      dismiss();
      return;
    case 2131165458:
    }
    ((ShareActivity)getActivity()).shareToMiliao(100202);
    dismiss();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    localView.findViewById(2131165459).setOnClickListener(this);
    localView.findViewById(2131165457).setOnClickListener(this);
    localView.findViewById(2131165458).setOnClickListener(this);
    return localView;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.FragmentShareToMiliaoSelect
 * JD-Core Version:    0.6.2
 */