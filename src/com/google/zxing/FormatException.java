package com.google.zxing;

public final class FormatException extends ReaderException
{
  private static final FormatException a = new FormatException();

  public static FormatException getFormatInstance()
  {
    return a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.FormatException
 * JD-Core Version:    0.6.2
 */