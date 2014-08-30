package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SetRequest extends Request
{
  private String action;
  private Map<String, AttributeValue> attributeValues;
  private ComplexCondition condition;
  private Map<String, AttributeValue> key;
  private String tableName;
  private String userId;

  public SetRequest addAttributeValue(String paramString, Object paramObject)
  {
    if (this.attributeValues == null)
      this.attributeValues = new HashMap();
    AttributeValue.putAttributeValueInMap(this.attributeValues, paramString, paramObject);
    return this;
  }

  public SetRequest addKey(String paramString, Object paramObject)
  {
    if (this.key == null)
      this.key = new HashMap();
    AttributeValue.putAttributeValueInMap(this.key, paramString, paramObject);
    return this;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    SetRequest localSetRequest;
    int i;
    label43: int j;
    label53: int m;
    label107: int n;
    label117: int i2;
    label171: int i3;
    label181: int i5;
    label235: int i6;
    label245: boolean bool4;
    do
    {
      int i7;
      do
      {
        boolean bool5;
        do
        {
          int i4;
          do
          {
            boolean bool6;
            do
            {
              int i1;
              do
              {
                boolean bool7;
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
                      bool2 = paramObject instanceof SetRequest;
                      bool1 = false;
                    }
                    while (!bool2);
                    localSetRequest = (SetRequest)paramObject;
                    if (localSetRequest.getTableName() != null)
                      break;
                    i = 1;
                    if (getTableName() != null)
                      break label360;
                    j = 1;
                    k = i ^ j;
                    bool1 = false;
                  }
                  while (k != 0);
                  if (localSetRequest.getTableName() == null)
                    break;
                  bool7 = localSetRequest.getTableName().equals(getTableName());
                  bool1 = false;
                }
                while (!bool7);
                if (localSetRequest.getAction() != null)
                  break label366;
                m = 1;
                if (getAction() != null)
                  break label372;
                n = 1;
                i1 = m ^ n;
                bool1 = false;
              }
              while (i1 != 0);
              if (localSetRequest.getAction() == null)
                break;
              bool6 = localSetRequest.getAction().equals(getAction());
              bool1 = false;
            }
            while (!bool6);
            if (localSetRequest.getAttributeValues() != null)
              break label378;
            i2 = 1;
            if (getAttributeValues() != null)
              break label384;
            i3 = 1;
            i4 = i2 ^ i3;
            bool1 = false;
          }
          while (i4 != 0);
          if (localSetRequest.getAttributeValues() == null)
            break;
          bool5 = localSetRequest.getAttributeValues().equals(getAttributeValues());
          bool1 = false;
        }
        while (!bool5);
        if (localSetRequest.getCondition() != null)
          break label390;
        i5 = 1;
        if (getCondition() != null)
          break label396;
        i6 = 1;
        i7 = i5 ^ i6;
        bool1 = false;
      }
      while (i7 != 0);
      if (localSetRequest.getCondition() == null)
        break;
      bool4 = localSetRequest.getCondition().equals(getCondition());
      bool1 = false;
    }
    while (!bool4);
    int i8;
    if (localSetRequest.getKey() == null)
    {
      i8 = 1;
      label299: if (getKey() != null)
        break label408;
    }
    label384: label390: label396: label408: for (int i9 = 1; ; i9 = 0)
    {
      int i10 = i8 ^ i9;
      bool1 = false;
      if (i10 != 0)
        break;
      if (localSetRequest.getKey() != null)
      {
        boolean bool3 = localSetRequest.getKey().equals(getKey());
        bool1 = false;
        if (!bool3)
          break;
      }
      return true;
      i = 0;
      break label43;
      label360: j = 0;
      break label53;
      label366: m = 0;
      break label107;
      label372: n = 0;
      break label117;
      label378: i2 = 0;
      break label171;
      i3 = 0;
      break label181;
      i5 = 0;
      break label235;
      i6 = 0;
      break label245;
      i8 = 0;
      break label299;
    }
  }

  public String getAction()
  {
    return this.action;
  }

  public Map<String, AttributeValue> getAttributeValues()
  {
    return this.attributeValues;
  }

  public ComplexCondition getCondition()
  {
    return this.condition;
  }

  public Map<String, AttributeValue> getKey()
  {
    return this.key;
  }

  public String getTableName()
  {
    return this.tableName;
  }

  public String getUserId()
  {
    return this.userId;
  }

  public int hashCode()
  {
    int i;
    int k;
    label26: int n;
    label44: int i2;
    label64: int i3;
    int i4;
    if (getTableName() == null)
    {
      i = 0;
      int j = 31 * (i + 31);
      if (getAction() != null)
        break label105;
      k = 0;
      int m = 31 * (k + j);
      if (getAttributeValues() != null)
        break label116;
      n = 0;
      int i1 = 31 * (n + m);
      if (getCondition() != null)
        break label128;
      i2 = 0;
      i3 = 31 * (i2 + i1);
      Map localMap = getKey();
      i4 = 0;
      if (localMap != null)
        break label140;
    }
    while (true)
    {
      return i3 + i4;
      i = getTableName().hashCode();
      break;
      label105: k = getAction().hashCode();
      break label26;
      label116: n = getAttributeValues().hashCode();
      break label44;
      label128: i2 = getCondition().hashCode();
      break label64;
      label140: i4 = getKey().hashCode();
    }
  }

  public BasicGalaxyRequest internalGetGalaxyRequest(String paramString, APILevel paramAPILevel)
  {
    BasicGalaxyRequest localBasicGalaxyRequest = new BasicGalaxyRequest(this, "Galaxy");
    TargetAction localTargetAction = new TargetAction();
    localTargetAction.setApiVersion(GalaxyVersion.getVersion());
    localTargetAction.setLevel(paramAPILevel);
    localTargetAction.setOperation(Operation.Set);
    localTargetAction.setServiceName("Galaxy");
    localBasicGalaxyRequest.addHeader("X-XiaoMi-Action", localTargetAction.format());
    super.setRequestContent(localBasicGalaxyRequest, paramString);
    return localBasicGalaxyRequest;
  }

  public void setAction(String paramString)
  {
    this.action = paramString;
  }

  public void setAttributeValues(Map<String, AttributeValue> paramMap)
  {
    this.attributeValues = paramMap;
  }

  public void setCondition(ComplexCondition paramComplexCondition)
  {
    this.condition = paramComplexCondition;
  }

  public void setKey(Map<String, AttributeValue> paramMap)
  {
    this.key = paramMap;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }

  public void validate()
  {
    Verifier.validateTableName(this.tableName, false);
    Verifier.validateKeyValues(this.key, false);
    Action localAction;
    try
    {
      localAction = Action.fromValue(this.action);
      if ((this.attributeValues != null) && (!this.attributeValues.isEmpty()))
      {
        Iterator localIterator = this.attributeValues.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str = (String)localEntry.getKey();
          AttributeValue localAttributeValue = (AttributeValue)localEntry.getValue();
          Verifier.validateAttributeValue(str, localAttributeValue, false);
          if (localAction == Action.ADD)
          {
            AttributeType localAttributeType = AttributeType.fromValue(localAttributeValue.getType());
            switch (SetRequest.1.$SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[localAttributeType.ordinal()])
            {
            case 1:
            case 2:
            case 3:
            case 4:
            }
            throw new GalaxyClientException(ReturnCode.NEED_INTEGER_ATTRIBUTE_VALUE, str + "(" + localAttributeType + ")");
          }
        }
      }
    }
    catch (GalaxyClientException localGalaxyClientException)
    {
      throw localGalaxyClientException;
    }
    if (this.condition != null)
    {
      if (localAction != Action.PUT)
        break label371;
      if (this.condition.getComplexConditions() != null)
        throw new GalaxyClientException(ReturnCode.COMPLEX_CONDITION_NOT_SUPPORTED, "put action expected 0 or 1 simple condition");
      if ((this.condition.getConditions() != null) && (this.condition.getConditions().size() != 1))
        throw new GalaxyClientException(ReturnCode.UNEXPECTED_NUMBER_OF_SIMPLE_CONDITIONS, "put action expected 0 or 1, but got " + this.condition.getConditions().size() + " condition");
      if ((this.condition.getConditions() != null) && (!this.condition.getConditions().isEmpty()))
      {
        localCondition = (Condition)this.condition.getConditions().get(0);
        if (localCondition != null)
          localCondition.validate();
      }
    }
    label371: 
    while (localAction != Action.ADD)
    {
      Condition localCondition;
      return;
    }
    throw new GalaxyClientException(ReturnCode.CONDITION_NOT_SUPPORTED, "add action not use condition");
  }

  public SetRequest withAction(Action paramAction)
  {
    setAction(paramAction.name());
    return this;
  }

  public SetRequest withAttributeValues(Map<String, AttributeValue> paramMap)
  {
    setAttributeValues(paramMap);
    return this;
  }

  public SetRequest withCondition(ComplexCondition paramComplexCondition)
  {
    setCondition(paramComplexCondition);
    return this;
  }

  public SetRequest withKey(Map<String, AttributeValue> paramMap)
  {
    setKey(paramMap);
    return this;
  }

  public SetRequest withTableName(String paramString)
  {
    setTableName(paramString);
    return this;
  }

  public SetRequest withUserId(String paramString)
  {
    setUserId(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.SetRequest
 * JD-Core Version:    0.6.2
 */