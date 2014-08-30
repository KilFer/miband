package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class f
{
  private static final String a = "ICUCompatIcs";
  private static Method b;
  private static Method c;

  static
  {
    try
    {
      Class localClass = Class.forName("libcore.icu.ICU");
      if (localClass != null)
      {
        b = localClass.getMethod("getScript", new Class[] { String.class });
        c = localClass.getMethod("addLikelySubtags", new Class[] { String.class });
      }
      return;
    }
    catch (Exception localException)
    {
      Log.w("ICUCompatIcs", localException);
    }
  }

  public static String a(String paramString)
  {
    try
    {
      if (b != null)
      {
        Object[] arrayOfObject = { paramString };
        String str = (String)b.invoke(null, arrayOfObject);
        return str;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.w("ICUCompatIcs", localIllegalAccessException);
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        Log.w("ICUCompatIcs", localInvocationTargetException);
    }
  }

  public static String b(String paramString)
  {
    try
    {
      if (c != null)
      {
        Object[] arrayOfObject = { paramString };
        String str = (String)c.invoke(null, arrayOfObject);
        return str;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.w("ICUCompatIcs", localIllegalAccessException);
      return paramString;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        Log.w("ICUCompatIcs", localInvocationTargetException);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.f
 * JD-Core Version:    0.6.2
 */