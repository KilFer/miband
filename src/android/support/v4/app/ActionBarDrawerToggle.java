package android.support.v4.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.MenuItem;
import android.view.View;

public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private static final b a = new a((byte)0);
  private static final int b = 16908332;
  private final Activity c;
  private final ActionBarDrawerToggle.Delegate d;
  private final DrawerLayout e;
  private boolean f = true;
  private Drawable g;
  private Drawable h;
  private e i;
  private final int j;
  private final int k;
  private final int l;
  private Object m;

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new d((byte)0);
      return;
    }
  }

  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramActivity;
    this.e = paramDrawerLayout;
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramInt3;
    this.g = a();
    this.h = paramActivity.getResources().getDrawable(paramInt1);
    this.i = new e(this.h);
    this.i.b(0.3333333F);
    if ((paramActivity instanceof ActionBarDrawerToggle.DelegateProvider))
    {
      this.d = ((ActionBarDrawerToggle.DelegateProvider)paramActivity).getDrawerToggleDelegate();
      return;
    }
    this.d = null;
  }

  private Drawable a()
  {
    if (this.d != null)
      return this.d.getThemeUpIndicator();
    return a.a(this.c);
  }

  private void a(int paramInt)
  {
    if (this.d != null)
    {
      this.d.setActionBarDescription(paramInt);
      return;
    }
    this.m = a.a(this.m, this.c, paramInt);
  }

  private void a(Drawable paramDrawable, int paramInt)
  {
    if (this.d != null)
    {
      this.d.setActionBarUpIndicator(paramDrawable, paramInt);
      return;
    }
    this.m = a.a(this.m, this.c, paramDrawable, paramInt);
  }

  public boolean isDrawerIndicatorEnabled()
  {
    return this.f;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.g = a();
    this.h = this.c.getResources().getDrawable(this.j);
    syncState();
  }

  public void onDrawerClosed(View paramView)
  {
    this.i.a(0.0F);
    if (this.f)
      a(this.l);
  }

  public void onDrawerOpened(View paramView)
  {
    this.i.a(1.0F);
    if (this.f)
      a(this.k);
  }

  public void onDrawerSlide(View paramView, float paramFloat)
  {
    float f1 = this.i.a();
    if (paramFloat > 0.5F);
    for (float f2 = Math.max(f1, 2.0F * Math.max(0.0F, paramFloat - 0.5F)); ; f2 = Math.min(f1, paramFloat * 2.0F))
    {
      this.i.a(f2);
      return;
    }
  }

  public void onDrawerStateChanged(int paramInt)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (this.f))
    {
      if (this.e.isDrawerVisible(8388611))
        this.e.closeDrawer(8388611);
      while (true)
      {
        return true;
        this.e.openDrawer(8388611);
      }
    }
    return false;
  }

  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    int n;
    if (paramBoolean != this.f)
    {
      if (!paramBoolean)
        break label54;
      e locale = this.i;
      if (!this.e.isDrawerOpen(8388611))
        break label46;
      n = this.k;
      a(locale, n);
    }
    while (true)
    {
      this.f = paramBoolean;
      return;
      label46: n = this.l;
      break;
      label54: a(this.g, 0);
    }
  }

  public void syncState()
  {
    e locale;
    if (this.e.isDrawerOpen(8388611))
    {
      this.i.a(1.0F);
      if (this.f)
      {
        locale = this.i;
        if (!this.e.isDrawerOpen(8388611))
          break label67;
      }
    }
    label67: for (int n = this.k; ; n = this.l)
    {
      a(locale, n);
      return;
      this.i.a(0.0F);
      break;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActionBarDrawerToggle
 * JD-Core Version:    0.6.2
 */