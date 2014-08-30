package com.xiaomi.miui.analyticstracker.service;

import com.xiaomi.miui.analyticstracker.Event;

public class NormalPolicy extends Policy
{
  public static final String TAG = "normal";

  public void end()
  {
  }

  public void execute(Event paramEvent)
  {
    paramEvent.dispatch();
  }

  public void prepare()
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.service.NormalPolicy
 * JD-Core Version:    0.6.2
 */