package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.Base64Utils;
import java.util.List;
import java.util.Map;

public class AttributeValue
{
  private String type;
  private String value;

  public static AttributeValue createAttributeValue(Object paramObject)
  {
    if (paramObject == null)
      throw new GalaxyClientException(ReturnCode.PARAMETER_IS_NULL);
    AttributeValue localAttributeValue = new AttributeValue();
    if ((paramObject instanceof Boolean))
    {
      localAttributeValue.withType(AttributeType.BOOL).withValue(paramObject.toString());
      return localAttributeValue;
    }
    if ((paramObject instanceof Byte))
    {
      localAttributeValue.withType(AttributeType.INT8).withValue(paramObject.toString());
      return localAttributeValue;
    }
    if ((paramObject instanceof Short))
    {
      localAttributeValue.withType(AttributeType.INT16).withValue(paramObject.toString());
      return localAttributeValue;
    }
    if ((paramObject instanceof Integer))
    {
      localAttributeValue.withType(AttributeType.INT32).withValue(paramObject.toString());
      return localAttributeValue;
    }
    if ((paramObject instanceof Long))
    {
      localAttributeValue.withType(AttributeType.INT64).withValue(paramObject.toString());
      return localAttributeValue;
    }
    if ((paramObject instanceof Float))
    {
      localAttributeValue.withType(AttributeType.FLOAT).withValue(paramObject.toString());
      return localAttributeValue;
    }
    if ((paramObject instanceof Double))
    {
      localAttributeValue.withType(AttributeType.DOUBLE).withValue(paramObject.toString());
      return localAttributeValue;
    }
    if ((paramObject instanceof String))
    {
      localAttributeValue.withType(AttributeType.STRING).withValue((String)paramObject);
      return localAttributeValue;
    }
    if ((paramObject instanceof byte[]))
    {
      localAttributeValue.withType(AttributeType.BINARY).withValue(Base64Utils.encode((byte[])paramObject));
      return localAttributeValue;
    }
    throw new GalaxyClientException(ReturnCode.PARAMETER_TYPE_ERROR);
  }

  protected static void putAttributeValueInList(List<AttributeValue> paramList, Object paramObject)
  {
    paramList.add(createAttributeValue(paramObject));
  }

  protected static void putAttributeValueInMap(Map<String, AttributeValue> paramMap, String paramString, Object paramObject)
  {
    paramMap.put(paramString, createAttributeValue(paramObject));
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    AttributeValue localAttributeValue;
    int i;
    label43: int j;
    label53: boolean bool4;
    do
    {
      int k;
      do
      {
        boolean bool2;
        do
        {
          do
          {
            return bool1;
            bool1 = false;
          }
          while (paramObject == null);
          bool2 = paramObject instanceof AttributeValue;
          bool1 = false;
        }
        while (!bool2);
        localAttributeValue = (AttributeValue)paramObject;
        if (localAttributeValue.getType() != null)
          break;
        i = 1;
        if (getType() != null)
          break label168;
        j = 1;
        k = i ^ j;
        bool1 = false;
      }
      while (k != 0);
      if (localAttributeValue.getType() == null)
        break;
      bool4 = localAttributeValue.getType().equals(getType());
      bool1 = false;
    }
    while (!bool4);
    int m;
    if (localAttributeValue.getValue() == null)
    {
      m = 1;
      label107: if (getValue() != null)
        break label180;
    }
    label168: label180: for (int n = 1; ; n = 0)
    {
      int i1 = m ^ n;
      bool1 = false;
      if (i1 != 0)
        break;
      if (localAttributeValue.getValue() != null)
      {
        boolean bool3 = localAttributeValue.getValue().equals(getValue());
        bool1 = false;
        if (!bool3)
          break;
      }
      return true;
      i = 0;
      break label43;
      j = 0;
      break label53;
      m = 0;
      break label107;
    }
  }

  public String getType()
  {
    return this.type;
  }

  public String getValue()
  {
    return this.value;
  }

  public int hashCode()
  {
    int i;
    int j;
    int k;
    if (getType() == null)
    {
      i = 0;
      j = 31 * (i + 31);
      String str = getValue();
      k = 0;
      if (str != null)
        break label45;
    }
    while (true)
    {
      return j + k;
      i = getType().hashCode();
      break;
      label45: k = getValue().hashCode();
    }
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public void setValue(String paramString)
  {
    this.value = paramString;
  }

  public String toString()
  {
    return "AttributeValue [type=" + this.type + ", value=" + this.value + "]";
  }

  public AttributeValue withType(AttributeType paramAttributeType)
  {
    setType(paramAttributeType.name());
    return this;
  }

  public AttributeValue withValue(String paramString)
  {
    setValue(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.AttributeValue
 * JD-Core Version:    0.6.2
 */