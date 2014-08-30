package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class DimPanelFragment extends DialogFragment
  implements View.OnClickListener
{
  private DimPanelFragment.OpClickListener a = null;
  protected View mLeftButton;
  protected View mRightButton;

  public static void showPanel(Activity paramActivity, DialogFragment paramDialogFragment)
  {
    paramDialogFragment.show(paramActivity.getFragmentManager().beginTransaction(), null);
  }

  public static void showPanel(Activity paramActivity, Class<? extends DialogFragment> paramClass)
  {
    FragmentTransaction localFragmentTransaction = paramActivity.getFragmentManager().beginTransaction();
    ((DialogFragment)Fragment.instantiate(paramActivity, paramClass.getName())).show(localFragmentTransaction, paramClass.getName());
  }

  public static void showPanel(Activity paramActivity, Class<? extends DialogFragment> paramClass, Bundle paramBundle)
  {
    FragmentTransaction localFragmentTransaction = paramActivity.getFragmentManager().beginTransaction();
    ((DialogFragment)Fragment.instantiate(paramActivity, paramClass.getName(), paramBundle)).show(localFragmentTransaction, paramClass.getName());
  }

  protected int inflateLayout()
  {
    return 0;
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165333:
    default:
      return;
    case 2131165332:
      onLeftButtonClicked();
      return;
    case 2131165334:
    }
    onRightButtomClicked();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStyle(0, 2131623940);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(inflateLayout(), paramViewGroup, false);
    this.mLeftButton = localView1.findViewById(2131165332);
    this.mRightButton = localView1.findViewById(2131165334);
    if (this.mLeftButton != null)
      this.mLeftButton.setOnClickListener(this);
    if (this.mRightButton != null)
      this.mRightButton.setOnClickListener(this);
    getDialog().setCanceledOnTouchOutside(true);
    View localView2 = localView1.findViewById(2131165335);
    if (localView2 != null)
      localView2.setOnClickListener(new K(this));
    return localView1;
  }

  protected void onEmptyAreaClicked()
  {
    if (this.a != null)
      this.a.onEmptyAreaClicked(this);
    dismiss();
  }

  protected void onLeftButtonClicked()
  {
    if (this.a != null)
    {
      this.a.onLeftClicked(this);
      return;
    }
    dismiss();
  }

  protected void onRightButtomClicked()
  {
    if (this.a != null)
      this.a.onRightClicked(this);
  }

  protected void setOpClickListener(DimPanelFragment.OpClickListener paramOpClickListener)
  {
    this.a = paramOpClickListener;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.DimPanelFragment
 * JD-Core Version:    0.6.2
 */