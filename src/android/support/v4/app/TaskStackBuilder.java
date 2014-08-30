package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskStackBuilder
  implements Iterable<Intent>
{
  private static final String a = "TaskStackBuilder";
  private static final af b = new ag();
  private final ArrayList<Intent> c = new ArrayList();
  private final Context d;

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      b = new ah();
      return;
    }
  }

  private TaskStackBuilder(Context paramContext)
  {
    this.d = paramContext;
  }

  public static TaskStackBuilder create(Context paramContext)
  {
    return new TaskStackBuilder(paramContext);
  }

  public static TaskStackBuilder from(Context paramContext)
  {
    return create(paramContext);
  }

  public TaskStackBuilder addNextIntent(Intent paramIntent)
  {
    this.c.add(paramIntent);
    return this;
  }

  public TaskStackBuilder addNextIntentWithParentStack(Intent paramIntent)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName == null)
      localComponentName = paramIntent.resolveActivity(this.d.getPackageManager());
    if (localComponentName != null)
      addParentStack(localComponentName);
    addNextIntent(paramIntent);
    return this;
  }

  public TaskStackBuilder addParentStack(Activity paramActivity)
  {
    boolean bool = paramActivity instanceof TaskStackBuilder.SupportParentable;
    Intent localIntent1 = null;
    if (bool)
      localIntent1 = ((TaskStackBuilder.SupportParentable)paramActivity).getSupportParentActivityIntent();
    if (localIntent1 == null);
    for (Intent localIntent2 = NavUtils.getParentActivityIntent(paramActivity); ; localIntent2 = localIntent1)
    {
      if (localIntent2 != null)
      {
        ComponentName localComponentName = localIntent2.getComponent();
        if (localComponentName == null)
          localComponentName = localIntent2.resolveActivity(this.d.getPackageManager());
        addParentStack(localComponentName);
        addNextIntent(localIntent2);
      }
      return this;
    }
  }

  public TaskStackBuilder addParentStack(ComponentName paramComponentName)
  {
    int i = this.c.size();
    try
    {
      Intent localIntent;
      for (Object localObject = NavUtils.getParentActivityIntent(this.d, paramComponentName); localObject != null; localObject = localIntent)
      {
        this.c.add(i, localObject);
        localIntent = NavUtils.getParentActivityIntent(this.d, ((Intent)localObject).getComponent());
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
      throw new IllegalArgumentException(localNameNotFoundException);
    }
    return this;
  }

  public TaskStackBuilder addParentStack(Class<?> paramClass)
  {
    return addParentStack(new ComponentName(this.d, paramClass));
  }

  public Intent editIntentAt(int paramInt)
  {
    return (Intent)this.c.get(paramInt);
  }

  public Intent getIntent(int paramInt)
  {
    return editIntentAt(paramInt);
  }

  public int getIntentCount()
  {
    return this.c.size();
  }

  public Intent[] getIntents()
  {
    Intent[] arrayOfIntent = new Intent[this.c.size()];
    if (arrayOfIntent.length == 0)
      return arrayOfIntent;
    arrayOfIntent[0] = new Intent((Intent)this.c.get(0)).addFlags(268484608);
    for (int i = 1; i < arrayOfIntent.length; i++)
      arrayOfIntent[i] = new Intent((Intent)this.c.get(i));
    return arrayOfIntent;
  }

  public PendingIntent getPendingIntent(int paramInt1, int paramInt2)
  {
    return getPendingIntent(paramInt1, paramInt2, null);
  }

  public PendingIntent getPendingIntent(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (this.c.isEmpty())
      throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    Intent[] arrayOfIntent = (Intent[])this.c.toArray(new Intent[this.c.size()]);
    arrayOfIntent[0] = new Intent(arrayOfIntent[0]).addFlags(268484608);
    return b.a(this.d, arrayOfIntent, paramInt1, paramInt2, paramBundle);
  }

  public Iterator<Intent> iterator()
  {
    return this.c.iterator();
  }

  public void startActivities()
  {
    startActivities(null);
  }

  public void startActivities(Bundle paramBundle)
  {
    if (this.c.isEmpty())
      throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    Intent[] arrayOfIntent = (Intent[])this.c.toArray(new Intent[this.c.size()]);
    arrayOfIntent[0] = new Intent(arrayOfIntent[0]).addFlags(268484608);
    if (!ContextCompat.startActivities(this.d, arrayOfIntent, paramBundle))
    {
      Intent localIntent = new Intent(arrayOfIntent[(-1 + arrayOfIntent.length)]);
      localIntent.addFlags(268435456);
      this.d.startActivity(localIntent);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.TaskStackBuilder
 * JD-Core Version:    0.6.2
 */