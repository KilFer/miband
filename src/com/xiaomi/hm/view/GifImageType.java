package com.xiaomi.hm.view;

public enum GifImageType
{
  private int a;

  static
  {
    SYNC_DECODER = new GifImageType("SYNC_DECODER", 1, 1);
    COVER = new GifImageType("COVER", 2, 2);
    GifImageType[] arrayOfGifImageType = new GifImageType[3];
    arrayOfGifImageType[0] = WAIT_FINISH;
    arrayOfGifImageType[1] = SYNC_DECODER;
    arrayOfGifImageType[2] = COVER;
  }

  private GifImageType(int arg3)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.view.GifImageType
 * JD-Core Version:    0.6.2
 */