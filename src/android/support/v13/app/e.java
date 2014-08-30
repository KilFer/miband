package android.support.v13.app;

import android.app.Fragment;
import android.os.Bundle;

class e
{
  private final String a;
  private final Class<?> b;
  private final Bundle c;
  private Fragment d;

  e()
  {
  }

  e(String paramString, Class<?> paramClass, Bundle paramBundle)
  {
    this.a = paramString;
    this.b = paramClass;
    this.c = paramBundle;
  }

  public static void a(Fragment paramFragment, boolean paramBoolean)
  {
    paramFragment.setMenuVisibility(paramBoolean);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v13.app.e
 * JD-Core Version:    0.6.2
 */