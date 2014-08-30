package com.xiaomi.hm.view;

public abstract interface GifListener
{
  public static final int FRAME_COUNT_ONLY = 2;
  public static final int LOOP_AND_FRAME_COUNT = 3;
  public static final int LOOP_ONLY = 1;

  public abstract void frameCount(int paramInt);

  public abstract void gifEnd(int paramInt);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.view.GifListener
 * JD-Core Version:    0.6.2
 */