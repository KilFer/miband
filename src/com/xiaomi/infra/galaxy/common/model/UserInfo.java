package com.xiaomi.infra.galaxy.common.model;

public class UserInfo
{
  private int count;
  private String userId;

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        bool1 = false;
      }
      while (paramObject == null);
      bool2 = paramObject instanceof UserInfo;
      bool1 = false;
    }
    while (!bool2);
    UserInfo localUserInfo = (UserInfo)paramObject;
    int i;
    if (localUserInfo.getUserId() == null)
    {
      i = 1;
      label43: if (getUserId() != null)
        break label126;
    }
    label126: for (int j = 1; ; j = 0)
    {
      int k = i ^ j;
      bool1 = false;
      if (k != 0)
        break;
      if (localUserInfo.getUserId() != null)
      {
        boolean bool3 = localUserInfo.getUserId().equals(getUserId());
        bool1 = false;
        if (!bool3)
          break;
      }
      int m = localUserInfo.getCount();
      int n = getCount();
      bool1 = false;
      if (m != n)
        break;
      return true;
      i = 0;
      break label43;
    }
  }

  public int getCount()
  {
    return this.count;
  }

  public String getUserId()
  {
    return this.userId;
  }

  public int hashCode()
  {
    int i = 31 * super.hashCode();
    if (getUserId() == null);
    for (int j = 0; ; j = getUserId().hashCode())
      return 31 * (j + i) + getCount();
  }

  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.UserInfo
 * JD-Core Version:    0.6.2
 */