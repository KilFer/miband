package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;

public class DescribeTableRequest extends Request
{
  private String tableName;

  public DescribeTableRequest()
  {
  }

  public DescribeTableRequest(String paramString)
  {
    setTableName(paramString);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        bool1 = false;
      }
      while (paramObject == null);
      bool2 = paramObject instanceof DescribeTableRequest;
      bool1 = false;
    }
    while (!bool2);
    DescribeTableRequest localDescribeTableRequest = (DescribeTableRequest)paramObject;
    int i;
    if (localDescribeTableRequest.getTableName() == null)
    {
      i = 1;
      label43: if (getTableName() != null)
        break label104;
    }
    label104: for (int j = 1; ; j = 0)
    {
      int k = i ^ j;
      bool1 = false;
      if (k != 0)
        break;
      if (localDescribeTableRequest.getTableName() != null)
      {
        boolean bool3 = localDescribeTableRequest.getTableName().equals(getTableName());
        bool1 = false;
        if (!bool3)
          break;
      }
      return true;
      i = 0;
      break label43;
    }
  }

  public String getTableName()
  {
    return this.tableName;
  }

  public int hashCode()
  {
    if (getTableName() == null);
    for (int i = 0; ; i = getTableName().hashCode())
      return i + 31;
  }

  public BasicGalaxyRequest internalGetGalaxyRequest(String paramString, APILevel paramAPILevel)
  {
    BasicGalaxyRequest localBasicGalaxyRequest = new BasicGalaxyRequest(this, "Galaxy");
    TargetAction localTargetAction = new TargetAction();
    localTargetAction.setApiVersion(GalaxyVersion.getVersion());
    localTargetAction.setLevel(APILevel.Developer);
    localTargetAction.setOperation(Operation.DescribeTable);
    localTargetAction.setServiceName("Galaxy");
    localBasicGalaxyRequest.addHeader("X-XiaoMi-Action", localTargetAction.format());
    super.setRequestContent(localBasicGalaxyRequest, paramString);
    return localBasicGalaxyRequest;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }

  public void validate()
  {
    Verifier.validateTableName(this.tableName);
  }

  public DescribeTableRequest withTableName(String paramString)
  {
    this.tableName = paramString;
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.DescribeTableRequest
 * JD-Core Version:    0.6.2
 */