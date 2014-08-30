package com.handmark.pulltorefresh.library;

public enum PullToRefreshBase$State
{
  private int a;

  static
  {
    PULL_TO_REFRESH = new State("PULL_TO_REFRESH", 1, 1);
    RELEASE_TO_REFRESH = new State("RELEASE_TO_REFRESH", 2, 2);
    REFRESHING = new State("REFRESHING", 3, 8);
    MANUAL_REFRESHING = new State("MANUAL_REFRESHING", 4, 9);
    OVERSCROLLING = new State("OVERSCROLLING", 5, 16);
    State[] arrayOfState = new State[6];
    arrayOfState[0] = RESET;
    arrayOfState[1] = PULL_TO_REFRESH;
    arrayOfState[2] = RELEASE_TO_REFRESH;
    arrayOfState[3] = REFRESHING;
    arrayOfState[4] = MANUAL_REFRESHING;
    arrayOfState[5] = OVERSCROLLING;
  }

  private PullToRefreshBase$State(int arg3)
  {
    int j;
    this.a = j;
  }

  static State a(int paramInt)
  {
    State[] arrayOfState = values();
    int i = arrayOfState.length;
    for (int j = 0; ; j++)
    {
      State localState;
      if (j >= i)
        localState = RESET;
      do
      {
        return localState;
        localState = arrayOfState[j];
      }
      while (paramInt == localState.a);
    }
  }

  final int a()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshBase.State
 * JD-Core Version:    0.6.2
 */