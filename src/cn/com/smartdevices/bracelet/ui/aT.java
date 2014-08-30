package cn.com.smartdevices.bracelet.ui;

import android.app.DialogFragment;

final class aT
  implements DimPanelFragment.OpClickListener
{
  aT(PersonInfoFragment paramPersonInfoFragment)
  {
  }

  public final void onEmptyAreaClicked(DialogFragment paramDialogFragment)
  {
  }

  public final void onLeftClicked(DialogFragment paramDialogFragment)
  {
    paramDialogFragment.dismiss();
    PersonInfoFragment.d(this.a);
  }

  public final void onRightClicked(DialogFragment paramDialogFragment)
  {
    paramDialogFragment.dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aT
 * JD-Core Version:    0.6.2
 */