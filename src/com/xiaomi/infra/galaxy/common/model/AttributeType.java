package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import java.util.HashMap;
import java.util.Map;

public enum AttributeType
{
  static final Map<String, AttributeType> lookupMap;
  private String value;

  static
  {
    int i = 0;
    BOOL = new AttributeType("BOOL", 0, "BOOL");
    INT8 = new AttributeType("INT8", 1, "INT8");
    INT16 = new AttributeType("INT16", 2, "INT16");
    INT32 = new AttributeType("INT32", 3, "INT32");
    INT64 = new AttributeType("INT64", 4, "INT64");
    FLOAT = new AttributeType("FLOAT", 5, "FLOAT");
    DOUBLE = new AttributeType("DOUBLE", 6, "DOUBLE");
    STRING = new AttributeType("STRING", 7, "STRING");
    BINARY = new AttributeType("BINARY", 8, "BINARY");
    AttributeType[] arrayOfAttributeType1 = new AttributeType[9];
    arrayOfAttributeType1[0] = BOOL;
    arrayOfAttributeType1[1] = INT8;
    arrayOfAttributeType1[2] = INT16;
    arrayOfAttributeType1[3] = INT32;
    arrayOfAttributeType1[4] = INT64;
    arrayOfAttributeType1[5] = FLOAT;
    arrayOfAttributeType1[6] = DOUBLE;
    arrayOfAttributeType1[7] = STRING;
    arrayOfAttributeType1[8] = BINARY;
    $VALUES = arrayOfAttributeType1;
    lookupMap = new HashMap();
    AttributeType[] arrayOfAttributeType2 = values();
    int j = arrayOfAttributeType2.length;
    while (i < j)
    {
      AttributeType localAttributeType = arrayOfAttributeType2[i];
      if (lookupMap.containsKey(localAttributeType.value))
        throw new RuntimeException("Duplicated enum value");
      lookupMap.put(localAttributeType.value, localAttributeType);
      i++;
    }
  }

  private AttributeType(String paramString)
  {
    this.value = paramString;
  }

  public static AttributeType fromValue(String paramString)
  {
    AttributeType localAttributeType = (AttributeType)lookupMap.get(paramString);
    if (localAttributeType == null)
    {
      if ((paramString == null) || ("".equals(paramString)))
        throw new GalaxyClientException(ReturnCode.ATTRIBUTE_TYPE_IS_BLANK);
      throw new GalaxyClientException(ReturnCode.ATTRIBUTE_TYPE_IS_INVALID, paramString);
    }
    return localAttributeType;
  }

  public final String toString()
  {
    return this.value;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.AttributeType
 * JD-Core Version:    0.6.2
 */