package com.xiaomi.hm.view;

public abstract interface GifAction
{
  public static final int RETURN_CACHE_FINISH = 3;
  public static final int RETURN_ERROR = 4;
  public static final int RETURN_FINISH = 2;
  public static final int RETURN_FIRST = 1;

  public abstract void loopEnd();

  public abstract void parseReturn(int paramInt);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.view.GifAction
 * JD-Core Version:    0.6.2
 */