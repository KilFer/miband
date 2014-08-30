package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public class IntentCompat
{
  public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
  public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
  public static final String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
  public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
  public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
  public static final int FLAG_ACTIVITY_CLEAR_TASK = 32768;
  public static final int FLAG_ACTIVITY_TASK_ON_HOME = 16384;
  private static final f a = new f();

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 15)
    {
      a = new i();
      return;
    }
    if (i >= 11)
    {
      a = new h();
      return;
    }
  }

  public static Intent makeMainActivity(ComponentName paramComponentName)
  {
    return a.a(paramComponentName);
  }

  public static Intent makeMainSelectorActivity(String paramString1, String paramString2)
  {
    return a.a(paramString1, paramString2);
  }

  public static Intent makeRestartActivityTask(ComponentName paramComponentName)
  {
    return a.b(paramComponentName);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.IntentCompat
 * JD-Core Version:    0.6.2
 */