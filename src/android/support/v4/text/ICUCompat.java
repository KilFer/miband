package android.support.v4.text;

import android.os.Build.VERSION;

public class ICUCompat
{
  private static final c a = new a();

  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new e();
      return;
    }
  }

  public static String addLikelySubtags(String paramString)
  {
    return a.b(paramString);
  }

  public static String getScript(String paramString)
  {
    return a.a(paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.ICUCompat
 * JD-Core Version:    0.6.2
 */