package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Constants;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteTableRequest extends Request
{
  private String tableName;

  public DeleteTableRequest()
  {
  }

  public DeleteTableRequest(String paramString)
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
      bool2 = paramObject instanceof DeleteTableRequest;
      bool1 = false;
    }
    while (!bool2);
    DeleteTableRequest localDeleteTableRequest = (DeleteTableRequest)paramObject;
    int i;
    if (localDeleteTableRequest.getTableName() == null)
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
      if (localDeleteTableRequest.getTableName() != null)
      {
        boolean bool3 = localDeleteTableRequest.getTableName().equals(getTableName());
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
    localTargetAction.setOperation(Operation.DeleteTable);
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
    if (StringUtils.isBlank(this.tableName))
      throw new GalaxyClientException(ReturnCode.TABLE_NAME_IS_BLANK);
    if (!Constants.TableNamePattern.matcher(this.tableName).matches())
      throw new GalaxyClientException(ReturnCode.TABLE_NAME_IS_INVALID, this.tableName);
  }

  public DeleteTableRequest withTableName(String paramString)
  {
    this.tableName = paramString;
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.DeleteTableRequest
 * JD-Core Version:    0.6.2
 */