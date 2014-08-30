package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

class c
{
  final Intent a;
  final ArrayList<n> b;

  c()
  {
  }

  c(Intent paramIntent, ArrayList<n> paramArrayList)
  {
    this.a = paramIntent;
    this.b = paramArrayList;
  }

  public static void a(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    paramContext.startActivities(paramArrayOfIntent, paramBundle);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.c
 * JD-Core Version:    0.6.2
 */