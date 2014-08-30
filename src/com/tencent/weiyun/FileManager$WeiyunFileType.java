package com.tencent.weiyun;

public enum FileManager$WeiyunFileType
{
  private final int a;

  static
  {
    WeiyunFileType[] arrayOfWeiyunFileType = new WeiyunFileType[3];
    arrayOfWeiyunFileType[0] = ImageFile;
    arrayOfWeiyunFileType[1] = MusicFile;
    arrayOfWeiyunFileType[2] = VideoFile;
  }

  private FileManager$WeiyunFileType(int paramInt)
  {
    this.a = paramInt;
  }

  public final int value()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.weiyun.FileManager.WeiyunFileType
 * JD-Core Version:    0.6.2
 */