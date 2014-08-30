package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteRequest extends Request
{
  private ComplexCondition condition;
  private Map<String, AttributeValue> key;
  private String tableName;
  private String userId;

  public DeleteRequest addKey(String paramString, Object paramObject)
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
    DeleteRequest localDeleteRequest;
    int i;
    label43: int j;
    label53: int m;
    label107: int n;
    label117: boolean bool4;
    do
    {
      int i1;
      do
      {
        boolean bool5;
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
              bool2 = paramObject instanceof DeleteRequest;
              bool1 = false;
            }
            while (!bool2);
            localDeleteRequest = (DeleteRequest)paramObject;
            if (localDeleteRequest.getTableName() != null)
              break;
            i = 1;
            if (getTableName() != null)
              break label232;
            j = 1;
            k = i ^ j;
            bool1 = false;
          }
          while (k != 0);
          if (localDeleteRequest.getTableName() == null)
            break;
          bool5 = localDeleteRequest.getTableName().equals(getTableName());
          bool1 = false;
        }
        while (!bool5);
        if (localDeleteRequest.getCondition() != null)
          break label238;
        m = 1;
        if (getCondition() != null)
          break label244;
        n = 1;
        i1 = m ^ n;
        bool1 = false;
      }
      while (i1 != 0);
      if (localDeleteRequest.getCondition() == null)
        break;
      bool4 = localDeleteRequest.getCondition().equals(getCondition());
      bool1 = false;
    }
    while (!bool4);
    int i2;
    if (localDeleteRequest.getKey() == null)
    {
      i2 = 1;
      label171: if (getKey() != null)
        break label256;
    }
    label256: for (int i3 = 1; ; i3 = 0)
    {
      int i4 = i2 ^ i3;
      bool1 = false;
      if (i4 != 0)
        break;
      if (localDeleteRequest.getKey() != null)
      {
        boolean bool3 = localDeleteRequest.getKey().equals(getKey());
        bool1 = false;
        if (!bool3)
          break;
      }
      return true;
      i = 0;
      break label43;
      label232: j = 0;
      break label53;
      label238: m = 0;
      break label107;
      label244: n = 0;
      break label117;
      i2 = 0;
      break label171;
    }
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
    label26: int m;
    int n;
    if (getTableName() == null)
    {
      i = 0;
      int j = 31 * (i + 31);
      if (getCondition() != null)
        break label65;
      k = 0;
      m = 31 * (k + j);
      Map localMap = getKey();
      n = 0;
      if (localMap != null)
        break label76;
    }
    while (true)
    {
      return m + n;
      i = getTableName().hashCode();
      break;
      label65: k = getCondition().hashCode();
      break label26;
      label76: n = getKey().hashCode();
    }
  }

  public BasicGalaxyRequest internalGetGalaxyRequest(String paramString, APILevel paramAPILevel)
  {
    BasicGalaxyRequest localBasicGalaxyRequest = new BasicGalaxyRequest(this, "Galaxy");
    TargetAction localTargetAction = new TargetAction();
    localTargetAction.setApiVersion(GalaxyVersion.getVersion());
    localTargetAction.setLevel(paramAPILevel);
    localTargetAction.setOperation(Operation.Delete);
    localTargetAction.setServiceName("Galaxy");
    localBasicGalaxyRequest.addHeader("X-XiaoMi-Action", localTargetAction.format());
    super.setRequestContent(localBasicGalaxyRequest, paramString);
    return localBasicGalaxyRequest;
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
    Verifier.validateTableName(this.tableName);
    if ((this.key == null) || (this.key.isEmpty()))
      throw new GalaxyClientException(ReturnCode.KEY_VALUES_IS_EMPTY);
    Verifier.validateKeyValues(this.key, false);
    if (this.condition != null)
    {
      if (this.condition.getComplexConditions() != null)
        throw new GalaxyClientException(ReturnCode.COMPLEX_CONDITION_NOT_SUPPORTED, "delete action expected 0 or 1 simple condition");
      if ((this.condition.getConditions() != null) && (this.condition.getConditions().size() != 1))
        throw new GalaxyClientException(ReturnCode.UNEXPECTED_NUMBER_OF_SIMPLE_CONDITIONS, "delete action expected 0 or 1, but got " + this.condition.getConditions().size() + " simple condition");
      ((Condition)this.condition.getConditions().get(0)).validate();
    }
  }

  public DeleteRequest withCondition(ComplexCondition paramComplexCondition)
  {
    setCondition(paramComplexCondition);
    return this;
  }

  public DeleteRequest withKey(Map<String, AttributeValue> paramMap)
  {
    setKey(paramMap);
    return this;
  }

  public DeleteRequest withTableName(String paramString)
  {
    setTableName(paramString);
    return this;
  }

  public DeleteRequest withUserId(String paramString)
  {
    setUserId(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.DeleteRequest
 * JD-Core Version:    0.6.2
 */