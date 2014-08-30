package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetRequest extends Request
{
  private List<String> attributes;
  private Map<String, AttributeValue> key;
  private String tableName;
  private String userId;

  public void addAttribute(String paramString)
  {
    if (this.attributes == null)
      this.attributes = new ArrayList();
    this.attributes.add(paramString);
  }

  public GetRequest addKey(String paramString, Object paramObject)
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
    GetRequest localGetRequest;
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
              bool2 = paramObject instanceof GetRequest;
              bool1 = false;
            }
            while (!bool2);
            localGetRequest = (GetRequest)paramObject;
            if (localGetRequest.getTableName() != null)
              break;
            i = 1;
            if (getTableName() != null)
              break label232;
            j = 1;
            k = i ^ j;
            bool1 = false;
          }
          while (k != 0);
          if (localGetRequest.getTableName() == null)
            break;
          bool5 = localGetRequest.getTableName().equals(getTableName());
          bool1 = false;
        }
        while (!bool5);
        if (localGetRequest.getKey() != null)
          break label238;
        m = 1;
        if (getKey() != null)
          break label244;
        n = 1;
        i1 = m ^ n;
        bool1 = false;
      }
      while (i1 != 0);
      if (localGetRequest.getKey() == null)
        break;
      bool4 = localGetRequest.getKey().equals(getKey());
      bool1 = false;
    }
    while (!bool4);
    int i2;
    if (localGetRequest.getAttributes() == null)
    {
      i2 = 1;
      label171: if (getAttributes() != null)
        break label256;
    }
    label256: for (int i3 = 1; ; i3 = 0)
    {
      int i4 = i2 ^ i3;
      bool1 = false;
      if (i4 != 0)
        break;
      if (localGetRequest.getAttributes() != null)
      {
        boolean bool3 = localGetRequest.getAttributes().equals(getAttributes());
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

  public List<String> getAttributes()
  {
    return this.attributes;
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
      if (getKey() != null)
        break label65;
      k = 0;
      m = 31 * (k + j);
      List localList = getAttributes();
      n = 0;
      if (localList != null)
        break label76;
    }
    while (true)
    {
      return m + n;
      i = getTableName().hashCode();
      break;
      label65: k = getKey().hashCode();
      break label26;
      label76: n = getAttributes().hashCode();
    }
  }

  public BasicGalaxyRequest internalGetGalaxyRequest(String paramString, APILevel paramAPILevel)
  {
    BasicGalaxyRequest localBasicGalaxyRequest = new BasicGalaxyRequest(this, "Galaxy");
    TargetAction localTargetAction = new TargetAction();
    localTargetAction.setApiVersion(GalaxyVersion.getVersion());
    localTargetAction.setLevel(paramAPILevel);
    localTargetAction.setOperation(Operation.Get);
    localTargetAction.setServiceName("Galaxy");
    localBasicGalaxyRequest.addHeader("X-XiaoMi-Action", localTargetAction.format());
    super.setRequestContent(localBasicGalaxyRequest, paramString);
    return localBasicGalaxyRequest;
  }

  public void setAttributes(List<String> paramList)
  {
    this.attributes = paramList;
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
    if ((this.key == null) || (this.key.isEmpty()))
      throw new GalaxyClientException(ReturnCode.KEY_VALUES_IS_EMPTY);
    Verifier.validateKeyValues(this.key, false);
    Verifier.validateAttributeNames(this.attributes, false);
  }

  public GetRequest withAttributes(List<String> paramList)
  {
    setAttributes(paramList);
    return this;
  }

  public GetRequest withKey(Map<String, AttributeValue> paramMap)
  {
    this.key = paramMap;
    return this;
  }

  public GetRequest withTableName(String paramString)
  {
    setTableName(paramString);
    return this;
  }

  public GetRequest withUserId(String paramString)
  {
    setUserId(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.GetRequest
 * JD-Core Version:    0.6.2
 */