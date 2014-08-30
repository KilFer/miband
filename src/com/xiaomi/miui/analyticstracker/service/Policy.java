package com.xiaomi.miui.analyticstracker.service;

import com.xiaomi.miui.analyticstracker.Event;

public abstract class Policy
{
  protected String mParam;

  public abstract void end();

  public abstract void execute(Event paramEvent);

  public abstract void prepare();

  public void setParam(String paramString)
  {
    this.mParam = paramString;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.service.Policy
 * JD-Core Version:    0.6.2
 */