package com.xiaomi.infra.galaxy.common.model;

import java.util.List;

public class ScanAppUserResult extends Result
{
  private List<UserInfo> items;
  private String lastUserId;
  private int scannedCount;
  private String tableName;

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    ScanAppUserResult localScanAppUserResult;
    int i;
    label47: int j;
    label57: int i1;
    label133: int i2;
    label143: boolean bool5;
    do
    {
      int i3;
      do
      {
        int m;
        int n;
        do
        {
          boolean bool6;
          do
          {
            int k;
            do
            {
              boolean bool3;
              do
              {
                do
                {
                  return bool2;
                  bool2 = false;
                }
                while (paramObject == null);
                bool3 = paramObject instanceof ScanAppUserResult;
                bool2 = false;
              }
              while (!bool3);
              localScanAppUserResult = (ScanAppUserResult)paramObject;
              if (localScanAppUserResult.getTableName() != null)
                break;
              i = bool1;
              if (getTableName() != null)
                break label258;
              j = bool1;
              k = i ^ j;
              bool2 = false;
            }
            while (k != 0);
            if (localScanAppUserResult.getTableName() == null)
              break;
            bool6 = localScanAppUserResult.getTableName().equals(getTableName());
            bool2 = false;
          }
          while (!bool6);
          m = localScanAppUserResult.getScannedCount();
          n = getScannedCount();
          bool2 = false;
        }
        while (m != n);
        if (localScanAppUserResult.getItems() != null)
          break label264;
        i1 = bool1;
        if (getItems() != null)
          break label270;
        i2 = bool1;
        i3 = i1 ^ i2;
        bool2 = false;
      }
      while (i3 != 0);
      if (localScanAppUserResult.getItems() == null)
        break;
      bool5 = localScanAppUserResult.getItems().equals(getItems());
      bool2 = false;
    }
    while (!bool5);
    int i4;
    if (localScanAppUserResult.getLastUserId() == null)
    {
      i4 = bool1;
      label197: if (getLastUserId() != null)
        break label282;
    }
    while (true)
    {
      int i5 = i4 ^ bool1;
      bool2 = false;
      if (i5 != 0)
        break;
      if (localScanAppUserResult.getLastUserId() != null)
      {
        boolean bool4 = localScanAppUserResult.getLastUserId().equals(getLastUserId());
        bool2 = false;
        if (!bool4)
          break;
      }
      return super.equals(paramObject);
      i = 0;
      break label47;
      label258: j = 0;
      break label57;
      label264: i1 = 0;
      break label133;
      label270: i2 = 0;
      break label143;
      i4 = 0;
      break label197;
      label282: bool1 = false;
    }
  }

  public List<UserInfo> getItems()
  {
    return this.items;
  }

  public String getLastUserId()
  {
    return this.lastUserId;
  }

  public int getScannedCount()
  {
    return this.scannedCount;
  }

  public String getTableName()
  {
    return this.tableName;
  }

  public int hashCode()
  {
    int i = 31 * super.hashCode();
    int j;
    int m;
    label42: int n;
    int i1;
    if (getTableName() == null)
    {
      j = 0;
      int k = 31 * (31 * (j + i) + getScannedCount());
      if (getItems() != null)
        break label82;
      m = 0;
      n = 31 * (m + k);
      String str = getLastUserId();
      i1 = 0;
      if (str != null)
        break label94;
    }
    while (true)
    {
      return n + i1;
      j = getTableName().hashCode();
      break;
      label82: m = getItems().hashCode();
      break label42;
      label94: i1 = getLastUserId().hashCode();
    }
  }

  public void setItems(List<UserInfo> paramList)
  {
    this.items = paramList;
  }

  public void setLastUserId(String paramString)
  {
    this.lastUserId = paramString;
  }

  public void setScannedCount(int paramInt)
  {
    this.scannedCount = paramInt;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }

  public ScanAppUserResult withItems(List<UserInfo> paramList)
  {
    setItems(paramList);
    return this;
  }

  public ScanAppUserResult withLastUserId(String paramString)
  {
    setLastUserId(paramString);
    return this;
  }

  public ScanAppUserResult withScannedCount(int paramInt)
  {
    setScannedCount(paramInt);
    return this;
  }

  public ScanAppUserResult withTableName(String paramString)
  {
    setTableName(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.ScanAppUserResult
 * JD-Core Version:    0.6.2
 */