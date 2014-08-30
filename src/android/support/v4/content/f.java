package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

class f
{
  public Intent a(ComponentName paramComponentName)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setComponent(paramComponentName);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    return localIntent;
  }

  public Intent a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramString1);
    localIntent.addCategory(paramString2);
    return localIntent;
  }

  public Intent b(ComponentName paramComponentName)
  {
    Intent localIntent = a(paramComponentName);
    localIntent.addFlags(268468224);
    return localIntent;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.f
 * JD-Core Version:    0.6.2
 */