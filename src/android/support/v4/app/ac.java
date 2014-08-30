package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

final class ac
{
  private static final String a = ".sharecompat_";

  public static void a(MenuItem paramMenuItem, Activity paramActivity, Intent paramIntent)
  {
    ActionProvider localActionProvider = paramMenuItem.getActionProvider();
    if (!(localActionProvider instanceof ShareActionProvider));
    for (ShareActionProvider localShareActionProvider = new ShareActionProvider(paramActivity); ; localShareActionProvider = (ShareActionProvider)localActionProvider)
    {
      localShareActionProvider.setShareHistoryFileName(".sharecompat_" + paramActivity.getClass().getName());
      localShareActionProvider.setShareIntent(paramIntent);
      paramMenuItem.setActionProvider(localShareActionProvider);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ac
 * JD-Core Version:    0.6.2
 */