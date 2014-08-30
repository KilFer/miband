package com.xiaomi.infra.galaxy.common.model;

import java.util.HashMap;
import java.util.Map;

public class Record
{
  private Map<String, AttributeValue> attributes;
  private Map<String, AttributeValue> key;
  private String userId;

  public Record addAttributeValue(String paramString, Object paramObject)
  {
    if (this.attributes == null)
      this.attributes = new HashMap();
    AttributeValue.putAttributeValueInMap(this.attributes, paramString, paramObject);
    return this;
  }

  public Record addKey(String paramString, Object paramObject)
  {
    if (this.key == null)
      this.key = new HashMap();
    AttributeValue.putAttributeValueInMap(this.key, paramString, paramObject);
    return this;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    Record localRecord;
    int i;
    label47: int j;
    label57: int m;
    label111: int n;
    label121: boolean bool5;
    do
    {
      int i1;
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
              bool3 = paramObject instanceof Record;
              bool2 = false;
            }
            while (!bool3);
            localRecord = (Record)paramObject;
            if (localRecord.getUserId() != null)
              break;
            i = bool1;
            if (getUserId() != null)
              break label236;
            j = bool1;
            k = i ^ j;
            bool2 = false;
          }
          while (k != 0);
          if (localRecord.getUserId() == null)
            break;
          bool6 = localRecord.getUserId().equals(getUserId());
          bool2 = false;
        }
        while (!bool6);
        if (localRecord.getAttributes() != null)
          break label242;
        m = bool1;
        if (getAttributes() != null)
          break label248;
        n = bool1;
        i1 = m ^ n;
        bool2 = false;
      }
      while (i1 != 0);
      if (localRecord.getAttributes() == null)
        break;
      bool5 = localRecord.getAttributes().equals(getAttributes());
      bool2 = false;
    }
    while (!bool5);
    int i2;
    if (localRecord.getKey() == null)
    {
      i2 = bool1;
      label175: if (getKey() != null)
        break label260;
    }
    while (true)
    {
      int i3 = i2 ^ bool1;
      bool2 = false;
      if (i3 != 0)
        break;
      if (localRecord.getKey() != null)
      {
        boolean bool4 = localRecord.getKey().equals(getKey());
        bool2 = false;
        if (!bool4)
          break;
      }
      return super.equals(paramObject);
      i = 0;
      break label47;
      label236: j = 0;
      break label57;
      label242: m = 0;
      break label111;
      label248: n = 0;
      break label121;
      i2 = 0;
      break label175;
      label260: bool1 = false;
    }
  }

  public Map<String, AttributeValue> getAttributes()
  {
    return this.attributes;
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
    int i = 31 * super.hashCode();
    int j;
    int k;
    int m;
    if (getAttributes() == null)
    {
      j = 0;
      k = 31 * (j + i);
      String str = getUserId();
      m = 0;
      if (str != null)
        break label54;
    }
    while (true)
    {
      return k + m;
      j = getAttributes().hashCode();
      break;
      label54: m = getUserId().hashCode();
    }
  }

  public void setAttributes(Map<String, AttributeValue> paramMap)
  {
    this.attributes = paramMap;
  }

  public void setKey(Map<String, AttributeValue> paramMap)
  {
    this.key = paramMap;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }

  public Record withAttributes(Map<String, AttributeValue> paramMap)
  {
    setAttributes(paramMap);
    return this;
  }

  public Record withKey(Map<String, AttributeValue> paramMap)
  {
    setKey(paramMap);
    return this;
  }

  public Record withUserId(String paramString)
  {
    setUserId(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.Record
 * JD-Core Version:    0.6.2
 */