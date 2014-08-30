package com.xiaomi.infra.galaxy.common.model;

import java.util.Map;

public class GetResult extends Result
{
  private Map<String, AttributeValue> attributes;
  private String tableName;

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    GetResult localGetResult;
    int i;
    label47: int j;
    label57: boolean bool5;
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
          bool3 = paramObject instanceof GetResult;
          bool2 = false;
        }
        while (!bool3);
        localGetResult = (GetResult)paramObject;
        if (localGetResult.getTableName() != null)
          break;
        i = bool1;
        if (getTableName() != null)
          break label172;
        j = bool1;
        k = i ^ j;
        bool2 = false;
      }
      while (k != 0);
      if (localGetResult.getTableName() == null)
        break;
      bool5 = localGetResult.getTableName().equals(getTableName());
      bool2 = false;
    }
    while (!bool5);
    int m;
    if (localGetResult.getAttributes() == null)
    {
      m = bool1;
      label111: if (getAttributes() != null)
        break label184;
    }
    while (true)
    {
      int n = m ^ bool1;
      bool2 = false;
      if (n != 0)
        break;
      if (localGetResult.getAttributes() != null)
      {
        boolean bool4 = localGetResult.getAttributes().equals(getAttributes());
        bool2 = false;
        if (!bool4)
          break;
      }
      return super.equals(paramObject);
      i = 0;
      break label47;
      label172: j = 0;
      break label57;
      m = 0;
      break label111;
      label184: bool1 = false;
    }
  }

  public Map<String, AttributeValue> getAttributes()
  {
    return this.attributes;
  }

  public String getTableName()
  {
    return this.tableName;
  }

  public int hashCode()
  {
    int i = 31 * super.hashCode();
    int j;
    int k;
    int m;
    if (getTableName() == null)
    {
      j = 0;
      k = 31 * (j + i);
      Map localMap = getAttributes();
      m = 0;
      if (localMap != null)
        break label54;
    }
    while (true)
    {
      return k + m;
      j = getTableName().hashCode();
      break;
      label54: m = getAttributes().hashCode();
    }
  }

  public void setAttributes(Map<String, AttributeValue> paramMap)
  {
    this.attributes = paramMap;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }

  public GetResult withAttributes(Map<String, AttributeValue> paramMap)
  {
    setAttributes(paramMap);
    return this;
  }

  public GetResult withTableName(String paramString)
  {
    setTableName(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.GetResult
 * JD-Core Version:    0.6.2
 */