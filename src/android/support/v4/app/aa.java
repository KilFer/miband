package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

class aa extends Y
{
  public final void a(MenuItem paramMenuItem, ShareCompat.IntentBuilder paramIntentBuilder)
  {
    Activity localActivity = paramIntentBuilder.a();
    Intent localIntent = paramIntentBuilder.getIntent();
    ActionProvider localActionProvider = paramMenuItem.getActionProvider();
    if (!(localActionProvider instanceof ShareActionProvider));
    for (ShareActionProvider localShareActionProvider = new ShareActionProvider(localActivity); ; localShareActionProvider = (ShareActionProvider)localActionProvider)
    {
      localShareActionProvider.setShareHistoryFileName(".sharecompat_" + localActivity.getClass().getName());
      localShareActionProvider.setShareIntent(localIntent);
      paramMenuItem.setActionProvider(localShareActionProvider);
      if (a(paramMenuItem))
        paramMenuItem.setIntent(paramIntentBuilder.createChooserIntent());
      return;
    }
  }

  boolean a(MenuItem paramMenuItem)
  {
    return !paramMenuItem.hasSubMenu();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.aa
 * JD-Core Version:    0.6.2
 */