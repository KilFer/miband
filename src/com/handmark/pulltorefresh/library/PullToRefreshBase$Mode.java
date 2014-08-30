package com.handmark.pulltorefresh.library;

public enum PullToRefreshBase$Mode
{
  public static Mode PULL_DOWN_TO_REFRESH = PULL_FROM_START;
  public static Mode PULL_UP_TO_REFRESH = PULL_FROM_END;
  private int a;

  static
  {
    PULL_FROM_END = new Mode("PULL_FROM_END", 2, 2);
    BOTH = new Mode("BOTH", 3, 3);
    MANUAL_REFRESH_ONLY = new Mode("MANUAL_REFRESH_ONLY", 4, 4);
    Mode[] arrayOfMode = new Mode[5];
    arrayOfMode[0] = DISABLED;
    arrayOfMode[1] = PULL_FROM_START;
    arrayOfMode[2] = PULL_FROM_END;
    arrayOfMode[3] = BOTH;
    arrayOfMode[4] = MANUAL_REFRESH_ONLY;
    b = arrayOfMode;
  }

  private PullToRefreshBase$Mode(int arg3)
  {
    int j;
    this.a = j;
  }

  static Mode a()
  {
    return PULL_FROM_START;
  }

  static Mode a(int paramInt)
  {
    Mode[] arrayOfMode = values();
    int i = arrayOfMode.length;
    for (int j = 0; ; j++)
    {
      Mode localMode;
      if (j >= i)
        localMode = PULL_FROM_START;
      do
      {
        return localMode;
        localMode = arrayOfMode[j];
      }
      while (paramInt == localMode.a);
    }
  }

  final boolean b()
  {
    return (this != DISABLED) && (this != MANUAL_REFRESH_ONLY);
  }

  final int c()
  {
    return this.a;
  }

  public final boolean showFooterLoadingLayout()
  {
    return (this == PULL_FROM_END) || (this == BOTH) || (this == MANUAL_REFRESH_ONLY);
  }

  public final boolean showHeaderLoadingLayout()
  {
    return (this == PULL_FROM_START) || (this == BOTH);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshBase.Mode
 * JD-Core Version:    0.6.2
 */