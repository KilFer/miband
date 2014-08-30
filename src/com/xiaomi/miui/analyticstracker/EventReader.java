package com.xiaomi.miui.analyticstracker;

import android.content.Context;
import java.util.Collections;
import java.util.List;

public class EventReader
{
  private d a = new d();

  public void close()
  {
    if (this.a != null)
      this.a.a();
  }

  public void open(Context paramContext, String paramString)
  {
    this.a.a(paramContext, paramString);
  }

  public List<Event> readEvents(String paramString, List<Item> paramList)
  {
    if (this.a != null)
      return this.a.a(paramString, paramList);
    return Collections.emptyList();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.EventReader
 * JD-Core Version:    0.6.2
 */