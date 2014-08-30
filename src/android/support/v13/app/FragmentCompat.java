package android.support.v13.app;

import android.app.Fragment;
import android.os.Build.VERSION;

public class FragmentCompat
{
  private static b a = new b();

  static
  {
    if (Build.VERSION.SDK_INT >= 15)
    {
      a = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new c();
      return;
    }
  }

  public static void setMenuVisibility(Fragment paramFragment, boolean paramBoolean)
  {
    a.c(paramFragment, paramBoolean);
  }

  public static void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean)
  {
    a.d(paramFragment, paramBoolean);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v13.app.FragmentCompat
 * JD-Core Version:    0.6.2
 */