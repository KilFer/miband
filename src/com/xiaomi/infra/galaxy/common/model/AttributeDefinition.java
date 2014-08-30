package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.Constants;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AttributeDefinition
{
  private String attributeName;
  private String attributeType;

  public AttributeDefinition()
  {
  }

  public AttributeDefinition(String paramString, AttributeType paramAttributeType)
  {
    this.attributeName = paramString;
    this.attributeType = paramAttributeType.toString();
  }

  public AttributeDefinition(String paramString1, String paramString2)
  {
    setAttributeName(paramString1);
    setAttributeType(paramString2);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    AttributeDefinition localAttributeDefinition;
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
          bool2 = paramObject instanceof AttributeDefinition;
          bool1 = false;
        }
        while (!bool2);
        localAttributeDefinition = (AttributeDefinition)paramObject;
        if (localAttributeDefinition.getAttributeName() != null)
          break;
        i = 1;
        if (getAttributeName() != null)
          break label168;
        j = 1;
        k = i ^ j;
        bool1 = false;
      }
      while (k != 0);
      if (localAttributeDefinition.getAttributeName() == null)
        break;
      bool4 = localAttributeDefinition.getAttributeName().equals(getAttributeName());
      bool1 = false;
    }
    while (!bool4);
    int m;
    if (localAttributeDefinition.getAttributeType() == null)
    {
      m = 1;
      label107: if (getAttributeType() != null)
        break label180;
    }
    label168: label180: for (int n = 1; ; n = 0)
    {
      int i1 = m ^ n;
      bool1 = false;
      if (i1 != 0)
        break;
      if (localAttributeDefinition.getAttributeType() != null)
      {
        boolean bool3 = localAttributeDefinition.getAttributeType().equals(getAttributeType());
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

  public String getAttributeName()
  {
    return this.attributeName;
  }

  public String getAttributeType()
  {
    return this.attributeType;
  }

  public int hashCode()
  {
    int i;
    int j;
    int k;
    if (getAttributeName() == null)
    {
      i = 0;
      j = 31 * (i + 31);
      String str = getAttributeType();
      k = 0;
      if (str != null)
        break label45;
    }
    while (true)
    {
      return j + k;
      i = getAttributeName().hashCode();
      break;
      label45: k = getAttributeType().hashCode();
    }
  }

  public void setAttributeName(String paramString)
  {
    this.attributeName = paramString;
  }

  public void setAttributeType(String paramString)
  {
    this.attributeType = paramString;
  }

  public void validate()
  {
    if (StringUtils.isBlank(this.attributeName))
      throw new GalaxyClientException(ReturnCode.ATTRIBUTE_NAME_IS_BLANK);
    if (this.attributeName.length() > 255)
      throw new GalaxyClientException(ReturnCode.ATTRIBUTE_NAME_TOO_LONG, this.attributeName);
    if (!Constants.AttributeNamePattern.matcher(this.attributeName).matches())
      throw new GalaxyClientException(ReturnCode.ATTRIBUTE_NAME_IS_INVALID, this.attributeName);
    try
    {
      AttributeType.fromValue(this.attributeType);
      return;
    }
    catch (Exception localException)
    {
    }
    throw new GalaxyClientException(ReturnCode.ATTRIBUTE_TYPE_IS_INVALID, this.attributeName + "(" + this.attributeType + ")");
  }

  public AttributeDefinition withAttributeName(String paramString)
  {
    this.attributeName = paramString;
    return this;
  }

  public AttributeDefinition withAttributeType(AttributeType paramAttributeType)
  {
    this.attributeType = paramAttributeType.toString();
    return this;
  }

  public AttributeDefinition withAttributeType(String paramString)
  {
    this.attributeType = paramString;
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.AttributeDefinition
 * JD-Core Version:    0.6.2
 */