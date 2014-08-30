package com.xiaomi.infra.galaxy.common.model;

public class StorageAccessTokenResult extends Result
{
  private long expiresIn;
  private String storageAccessToken;

  public StorageAccessTokenResult()
  {
  }

  public StorageAccessTokenResult(String paramString, long paramLong)
  {
    setStorageAccessToken(paramString);
    setExpiresIn(paramLong);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    boolean bool3;
    do
    {
      do
      {
        return bool2;
        bool2 = false;
      }
      while (paramObject == null);
      bool3 = paramObject instanceof StorageAccessTokenResult;
      bool2 = false;
    }
    while (!bool3);
    StorageAccessTokenResult localStorageAccessTokenResult = (StorageAccessTokenResult)paramObject;
    int i;
    if (localStorageAccessTokenResult.getStorageAccessToken() == null)
    {
      i = bool1;
      label47: if (getStorageAccessToken() != null)
        break label127;
    }
    while (true)
    {
      int j = i ^ bool1;
      bool2 = false;
      if (j != 0)
        break;
      if (localStorageAccessTokenResult.getStorageAccessToken() != null)
      {
        boolean bool5 = localStorageAccessTokenResult.getStorageAccessToken().equals(getStorageAccessToken());
        bool2 = false;
        if (!bool5)
          break;
      }
      boolean bool4 = localStorageAccessTokenResult.getExpiresIn() < getExpiresIn();
      bool2 = false;
      if (bool4)
        break;
      return super.equals(paramObject);
      i = 0;
      break label47;
      label127: bool1 = false;
    }
  }

  public long getExpiresIn()
  {
    return this.expiresIn;
  }

  public String getStorageAccessToken()
  {
    return this.storageAccessToken;
  }

  public int hashCode()
  {
    int i = 31 * super.hashCode();
    int j;
    int k;
    int m;
    if (getStorageAccessToken() == null)
    {
      j = 0;
      k = 31 * (j + i);
      boolean bool = getExpiresIn() < 0L;
      m = 0;
      if (bool)
        break label56;
    }
    while (true)
    {
      return k + m;
      j = getStorageAccessToken().hashCode();
      break;
      label56: m = (int)getExpiresIn();
    }
  }

  public void setExpiresIn(long paramLong)
  {
    this.expiresIn = paramLong;
  }

  public void setStorageAccessToken(String paramString)
  {
    this.storageAccessToken = paramString;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.StorageAccessTokenResult
 * JD-Core Version:    0.6.2
 */