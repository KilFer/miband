package com.xiaomi.infra.galaxy.common.model;

import java.util.List;

public class ScanResult extends Result
{
  private List<Record> items;
  private RowKey lastEvaluatedKey;
  private int scannedCount;
  private String tableName;

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    ScanResult localScanResult;
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
                bool3 = paramObject instanceof ScanResult;
                bool2 = false;
              }
              while (!bool3);
              localScanResult = (ScanResult)paramObject;
              if (localScanResult.getTableName() != null)
                break;
              i = bool1;
              if (getTableName() != null)
                break label258;
              j = bool1;
              k = i ^ j;
              bool2 = false;
            }
            while (k != 0);
            if (localScanResult.getTableName() == null)
              break;
            bool6 = localScanResult.getTableName().equals(getTableName());
            bool2 = false;
          }
          while (!bool6);
          m = localScanResult.getScannedCount();
          n = getScannedCount();
          bool2 = false;
        }
        while (m != n);
        if (localScanResult.getItems() != null)
          break label264;
        i1 = bool1;
        if (getItems() != null)
          break label270;
        i2 = bool1;
        i3 = i1 ^ i2;
        bool2 = false;
      }
      while (i3 != 0);
      if (localScanResult.getItems() == null)
        break;
      bool5 = localScanResult.getItems().equals(getItems());
      bool2 = false;
    }
    while (!bool5);
    int i4;
    if (localScanResult.getLastEvaluatedKey() == null)
    {
      i4 = bool1;
      label197: if (getLastEvaluatedKey() != null)
        break label282;
    }
    while (true)
    {
      int i5 = i4 ^ bool1;
      bool2 = false;
      if (i5 != 0)
        break;
      if (localScanResult.getLastEvaluatedKey() != null)
      {
        boolean bool4 = localScanResult.getLastEvaluatedKey().equals(getLastEvaluatedKey());
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

  public List<Record> getItems()
  {
    return this.items;
  }

  public RowKey getLastEvaluatedKey()
  {
    return this.lastEvaluatedKey;
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
      RowKey localRowKey = getLastEvaluatedKey();
      i1 = 0;
      if (localRowKey != null)
        break label94;
    }
    while (true)
    {
      return n + i1;
      j = getTableName().hashCode();
      break;
      label82: m = getItems().hashCode();
      break label42;
      label94: i1 = getLastEvaluatedKey().hashCode();
    }
  }

  public void setItems(List<Record> paramList)
  {
    this.items = paramList;
  }

  public void setLastEvaluatedKey(RowKey paramRowKey)
  {
    this.lastEvaluatedKey = paramRowKey;
  }

  public void setScannedCount(int paramInt)
  {
    this.scannedCount = paramInt;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }

  public ScanResult withItems(List<Record> paramList)
  {
    setItems(paramList);
    return this;
  }

  public ScanResult withLastEvaluatedKey(RowKey paramRowKey)
  {
    setLastEvaluatedKey(paramRowKey);
    return this;
  }

  public ScanResult withScannedCount(int paramInt)
  {
    setScannedCount(paramInt);
    return this;
  }

  public ScanResult withTableName(String paramString)
  {
    setTableName(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.ScanResult
 * JD-Core Version:    0.6.2
 */