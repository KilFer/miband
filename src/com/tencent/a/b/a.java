package com.tencent.a.b;

import android.content.Context;
import java.io.File;

public final class a
{
  private static Context a;

  public static final Context a()
  {
    if (a == null)
      return null;
    return a;
  }

  public static final void a(Context paramContext)
  {
    a = paramContext;
  }

  public static final String b()
  {
    return a().getPackageName();
  }

  public static final File c()
  {
    return a().getFilesDir();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.a.b.a
 * JD-Core Version:    0.6.2
 */