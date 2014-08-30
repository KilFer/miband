package com.nostra13.universalimageloader.core.assist;

public class FailReason
{
  private final FailReason.FailType a;
  private final Throwable b;

  public FailReason(FailReason.FailType paramFailType, Throwable paramThrowable)
  {
    this.a = paramFailType;
    this.b = paramThrowable;
  }

  public Throwable getCause()
  {
    return this.b;
  }

  public FailReason.FailType getType()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.FailReason
 * JD-Core Version:    0.6.2
 */