package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class ActionProvider
{
  private static final String a = "ActionProvider(support)";
  private final Context b;
  private ActionProvider.SubUiVisibilityListener c;
  private ActionProvider.VisibilityListener d;

  public ActionProvider(Context paramContext)
  {
    this.b = paramContext;
  }

  public Context getContext()
  {
    return this.b;
  }

  public boolean hasSubMenu()
  {
    return false;
  }

  public boolean isVisible()
  {
    return true;
  }

  public abstract View onCreateActionView();

  public View onCreateActionView(MenuItem paramMenuItem)
  {
    return onCreateActionView();
  }

  public boolean onPerformDefaultAction()
  {
    return false;
  }

  public void onPrepareSubMenu(SubMenu paramSubMenu)
  {
  }

  public boolean overridesItemVisibility()
  {
    return false;
  }

  public void refreshVisibility()
  {
    if ((this.d != null) && (overridesItemVisibility()))
      this.d.onActionProviderVisibilityChanged(isVisible());
  }

  public void setSubUiVisibilityListener(ActionProvider.SubUiVisibilityListener paramSubUiVisibilityListener)
  {
    this.c = paramSubUiVisibilityListener;
  }

  public void setVisibilityListener(ActionProvider.VisibilityListener paramVisibilityListener)
  {
    if ((this.d != null) && (paramVisibilityListener != null))
      Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
    this.d = paramVisibilityListener;
  }

  public void subUiVisibilityChanged(boolean paramBoolean)
  {
    if (this.c != null)
      this.c.onSubUiVisibilityChanged(paramBoolean);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ActionProvider
 * JD-Core Version:    0.6.2
 */