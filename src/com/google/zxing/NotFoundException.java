package com.google.zxing;

public final class NotFoundException extends ReaderException
{
  private static final NotFoundException a = new NotFoundException();

  public static NotFoundException getNotFoundInstance()
  {
    return a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.NotFoundException
 * JD-Core Version:    0.6.2
 */