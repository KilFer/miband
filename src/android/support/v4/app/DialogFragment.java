package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public class DialogFragment extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  private static final String N = "android:savedDialogState";
  private static final String O = "android:style";
  private static final String P = "android:theme";
  private static final String Q = "android:cancelable";
  private static final String R = "android:showsDialog";
  private static final String S = "android:backStackId";
  public static final int STYLE_NORMAL = 0;
  public static final int STYLE_NO_FRAME = 2;
  public static final int STYLE_NO_INPUT = 3;
  public static final int STYLE_NO_TITLE = 1;
  private int T = 0;
  private int U = 0;
  private boolean V = true;
  private boolean W = true;
  private int X = -1;
  private Dialog Y;
  private boolean Z;
  private boolean aa;
  private boolean ab;

  private void a(boolean paramBoolean)
  {
    if (this.aa)
      return;
    this.aa = true;
    this.ab = false;
    if (this.Y != null)
    {
      this.Y.dismiss();
      this.Y = null;
    }
    this.Z = true;
    if (this.X >= 0)
    {
      getFragmentManager().popBackStack(this.X, 1);
      this.X = -1;
      return;
    }
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    localFragmentTransaction.remove(this);
    if (paramBoolean)
    {
      localFragmentTransaction.commitAllowingStateLoss();
      return;
    }
    localFragmentTransaction.commit();
  }

  public void dismiss()
  {
    a(false);
  }

  public void dismissAllowingStateLoss()
  {
    a(true);
  }

  public Dialog getDialog()
  {
    return this.Y;
  }

  public LayoutInflater getLayoutInflater(Bundle paramBundle)
  {
    if (!this.W)
      return super.getLayoutInflater(paramBundle);
    this.Y = onCreateDialog(paramBundle);
    switch (this.T)
    {
    default:
    case 3:
    case 1:
    case 2:
    }
    while (this.Y != null)
    {
      return (LayoutInflater)this.Y.getContext().getSystemService("layout_inflater");
      this.Y.getWindow().addFlags(24);
      this.Y.requestWindowFeature(1);
    }
    return (LayoutInflater)this.t.getSystemService("layout_inflater");
  }

  public boolean getShowsDialog()
  {
    return this.W;
  }

  public int getTheme()
  {
    return this.U;
  }

  public boolean isCancelable()
  {
    return this.V;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (!this.W);
    Bundle localBundle;
    do
    {
      do
      {
        return;
        View localView = getView();
        if (localView != null)
        {
          if (localView.getParent() != null)
            throw new IllegalStateException("DialogFragment can not be attached to a container view");
          this.Y.setContentView(localView);
        }
        this.Y.setOwnerActivity(getActivity());
        this.Y.setCancelable(this.V);
        this.Y.setOnCancelListener(this);
        this.Y.setOnDismissListener(this);
      }
      while (paramBundle == null);
      localBundle = paramBundle.getBundle("android:savedDialogState");
    }
    while (localBundle == null);
    this.Y.onRestoreInstanceState(localBundle);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (!this.ab)
      this.aa = false;
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.x == 0);
    for (boolean bool = true; ; bool = false)
    {
      this.W = bool;
      if (paramBundle != null)
      {
        this.T = paramBundle.getInt("android:style", 0);
        this.U = paramBundle.getInt("android:theme", 0);
        this.V = paramBundle.getBoolean("android:cancelable", true);
        this.W = paramBundle.getBoolean("android:showsDialog", this.W);
        this.X = paramBundle.getInt("android:backStackId", -1);
      }
      return;
    }
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return new Dialog(getActivity(), getTheme());
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.Y != null)
    {
      this.Z = true;
      this.Y.dismiss();
      this.Y = null;
    }
  }

  public void onDetach()
  {
    super.onDetach();
    if ((!this.ab) && (!this.aa))
      this.aa = true;
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.Z)
      a(true);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.Y != null)
    {
      Bundle localBundle = this.Y.onSaveInstanceState();
      if (localBundle != null)
        paramBundle.putBundle("android:savedDialogState", localBundle);
    }
    if (this.T != 0)
      paramBundle.putInt("android:style", this.T);
    if (this.U != 0)
      paramBundle.putInt("android:theme", this.U);
    if (!this.V)
      paramBundle.putBoolean("android:cancelable", this.V);
    if (!this.W)
      paramBundle.putBoolean("android:showsDialog", this.W);
    if (this.X != -1)
      paramBundle.putInt("android:backStackId", this.X);
  }

  public void onStart()
  {
    super.onStart();
    if (this.Y != null)
    {
      this.Z = false;
      this.Y.show();
    }
  }

  public void onStop()
  {
    super.onStop();
    if (this.Y != null)
      this.Y.hide();
  }

  public void setCancelable(boolean paramBoolean)
  {
    this.V = paramBoolean;
    if (this.Y != null)
      this.Y.setCancelable(paramBoolean);
  }

  public void setShowsDialog(boolean paramBoolean)
  {
    this.W = paramBoolean;
  }

  public void setStyle(int paramInt1, int paramInt2)
  {
    this.T = paramInt1;
    if ((this.T == 2) || (this.T == 3))
      this.U = 16973913;
    if (paramInt2 != 0)
      this.U = paramInt2;
  }

  public int show(FragmentTransaction paramFragmentTransaction, String paramString)
  {
    this.aa = false;
    this.ab = true;
    paramFragmentTransaction.add(this, paramString);
    this.Z = false;
    this.X = paramFragmentTransaction.commit();
    return this.X;
  }

  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    this.aa = false;
    this.ab = true;
    FragmentTransaction localFragmentTransaction = paramFragmentManager.beginTransaction();
    localFragmentTransaction.add(this, paramString);
    localFragmentTransaction.commit();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.DialogFragment
 * JD-Core Version:    0.6.2
 */