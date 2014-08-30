package com.xiaomi.infra.galaxy.common.model;

import java.util.HashMap;
import java.util.Map;

public class RowKey
{
  public static final String BEGIN_USER_ID = "";
  public static final String END_USER_ID = "";
  private Map<String, AttributeValue> key = null;
  private String userId = null;

  public static RowKey getBeginRowKey()
  {
    RowKey localRowKey = new RowKey();
    localRowKey.withUserId("");
    return localRowKey;
  }

  public static RowKey getEndRowKey()
  {
    RowKey localRowKey = new RowKey();
    localRowKey.withUserId("");
    return localRowKey;
  }

  public RowKey addKey(String paramString, Object paramObject)
  {
    if (this.key == null)
      this.key = new HashMap();
    AttributeValue.putAttributeValueInMap(this.key, paramString, paramObject);
    return this;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    RowKey localRowKey;
    do
    {
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localRowKey = (RowKey)paramObject;
        if (this.key == null)
        {
          if (localRowKey.key != null)
            return false;
        }
        else if (!this.key.equals(localRowKey.key))
          return false;
        if (this.userId != null)
          break;
      }
      while (localRowKey.userId == null);
      return false;
    }
    while (this.userId.equals(localRowKey.userId));
    return false;
  }

  public Map<String, AttributeValue> getKey()
  {
    return this.key;
  }

  public String getUserId()
  {
    return this.userId;
  }

  public int hashCode()
  {
    int i;
    int j;
    int k;
    if (this.key == null)
    {
      i = 0;
      j = 31 * (i + 31);
      String str = this.userId;
      k = 0;
      if (str != null)
        break label45;
    }
    while (true)
    {
      return j + k;
      i = this.key.hashCode();
      break;
      label45: k = this.userId.hashCode();
    }
  }

  public void setKey(Map<String, AttributeValue> paramMap)
  {
    this.key = paramMap;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }

  public RowKey withKey(Map<String, AttributeValue> paramMap)
  {
    setKey(paramMap);
    return this;
  }

  public RowKey withUserId(String paramString)
  {
    setUserId(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.RowKey
 * JD-Core Version:    0.6.2
 */