package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import java.util.ArrayList;
import java.util.List;

public class Condition
{
  private String attributeName;
  private List<AttributeValue> attributeValues;
  private String comparator;

  public Condition addAttributeValue(Object paramObject)
  {
    if (this.attributeValues == null)
      this.attributeValues = new ArrayList();
    AttributeValue.putAttributeValueInList(this.attributeValues, paramObject);
    return this;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    Condition localCondition;
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
          bool2 = paramObject instanceof Condition;
          bool1 = false;
        }
        while (!bool2);
        localCondition = (Condition)paramObject;
        if (localCondition.getComparator() != null)
          break;
        i = 1;
        if (getComparator() != null)
          break label168;
        j = 1;
        k = i ^ j;
        bool1 = false;
      }
      while (k != 0);
      if (localCondition.getComparator() == null)
        break;
      bool4 = localCondition.getComparator().equals(getComparator());
      bool1 = false;
    }
    while (!bool4);
    int m;
    if (localCondition.getAttributeValues() == null)
    {
      m = 1;
      label107: if (getAttributeValues() != null)
        break label180;
    }
    label168: label180: for (int n = 1; ; n = 0)
    {
      int i1 = m ^ n;
      bool1 = false;
      if (i1 != 0)
        break;
      if (localCondition.getAttributeValues() != null)
      {
        boolean bool3 = localCondition.getAttributeValues().equals(getAttributeValues());
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

  public List<AttributeValue> getAttributeValues()
  {
    return this.attributeValues;
  }

  public String getComparator()
  {
    return this.comparator;
  }

  public int hashCode()
  {
    int i;
    int j;
    int k;
    if (getComparator() == null)
    {
      i = 0;
      j = 31 * (i + 31);
      List localList = getAttributeValues();
      k = 0;
      if (localList != null)
        break label45;
    }
    while (true)
    {
      return j + k;
      i = getComparator().hashCode();
      break;
      label45: k = getAttributeValues().hashCode();
    }
  }

  public void setAttributeName(String paramString)
  {
    this.attributeName = paramString;
  }

  public void setAttributeValues(List<AttributeValue> paramList)
  {
    this.attributeValues = paramList;
  }

  public void setComparator(String paramString)
  {
    this.comparator = paramString;
  }

  public void validate()
  {
    Comparator localComparator = Comparator.fromValue(this.comparator);
    if ((this.attributeValues == null) || (this.attributeValues.size() != 1))
      throw new GalaxyClientException(ReturnCode.UNEXPECTED_NUMBER_OF_OPERANDS, "comparator can only use one attribute value");
    AttributeType localAttributeType = AttributeType.fromValue(((AttributeValue)this.attributeValues.get(0)).getType());
    Verifier.validateAttributeValue(this.attributeName, (AttributeValue)this.attributeValues.get(0), false);
    switch (Condition.1.$SwitchMap$com$xiaomi$infra$galaxy$common$model$Comparator[localComparator.ordinal()])
    {
    default:
    case 3:
    case 1:
    case 2:
    case 4:
    case 5:
    case 6:
    }
    do
    {
      do
        throw new GalaxyClientException(ReturnCode.UNEXPECTED_OPERAND_TYPE, localAttributeType.name() + "(comparator:" + localComparator + " ,attributeType" + localAttributeType + ")");
      while ((AttributeType.BINARY != localAttributeType) && (AttributeType.STRING != localAttributeType) && (AttributeType.INT8 != localAttributeType) && (AttributeType.INT16 != localAttributeType) && (AttributeType.INT32 != localAttributeType) && (AttributeType.INT64 != localAttributeType));
      do
      {
        do
        {
          do
            return;
          while ((AttributeType.BINARY == localAttributeType) || (AttributeType.STRING == localAttributeType) || (AttributeType.INT8 == localAttributeType) || (AttributeType.INT16 == localAttributeType) || (AttributeType.INT32 == localAttributeType));
          if (AttributeType.INT64 != localAttributeType)
            break;
          return;
        }
        while ((AttributeType.BINARY == localAttributeType) || (AttributeType.STRING == localAttributeType) || (AttributeType.INT8 == localAttributeType) || (AttributeType.INT16 == localAttributeType) || (AttributeType.INT32 == localAttributeType));
        if (AttributeType.INT64 != localAttributeType)
          break;
        return;
      }
      while ((AttributeType.BINARY == localAttributeType) || (AttributeType.STRING == localAttributeType) || (AttributeType.INT8 == localAttributeType) || (AttributeType.INT16 == localAttributeType) || (AttributeType.INT32 == localAttributeType));
    }
    while (AttributeType.INT64 != localAttributeType);
  }

  public Condition withAttributeValues(List<AttributeValue> paramList)
  {
    setAttributeValues(paramList);
    return this;
  }

  public Condition withComparator(Comparator paramComparator)
  {
    setComparator(paramComparator.name());
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.Condition
 * JD-Core Version:    0.6.2
 */