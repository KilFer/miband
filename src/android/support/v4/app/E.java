package android.support.v4.app;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

final class E
  implements TabHost.TabContentFactory
{
  private final Context a;

  public E(Context paramContext)
  {
    this.a = paramContext;
  }

  public final View createTabContent(String paramString)
  {
    View localView = new View(this.a);
    localView.setMinimumWidth(0);
    localView.setMinimumHeight(0);
    return localView;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.E
 * JD-Core Version:    0.6.2
 */