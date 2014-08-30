package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;

public class ScanAppUserRequest extends Request
{
  private int limit;
  private String startUserId;
  private String stopUserId;
  private String tableName;

  public int getLimit()
  {
    return this.limit;
  }

  public String getStartUserId()
  {
    return this.startUserId;
  }

  public String getStopUserId()
  {
    return this.stopUserId;
  }

  public String getTableName()
  {
    return this.tableName;
  }

  protected BasicGalaxyRequest internalGetGalaxyRequest(String paramString, APILevel paramAPILevel)
  {
    BasicGalaxyRequest localBasicGalaxyRequest = new BasicGalaxyRequest(this, "Galaxy");
    TargetAction localTargetAction = new TargetAction();
    localTargetAction.setApiVersion(GalaxyVersion.getVersion());
    localTargetAction.setLevel(paramAPILevel);
    localTargetAction.setOperation(Operation.ScanAppUser);
    localTargetAction.setServiceName("Galaxy");
    localBasicGalaxyRequest.addHeader("X-XiaoMi-Action", localTargetAction.format());
    super.setRequestContent(localBasicGalaxyRequest, paramString);
    return localBasicGalaxyRequest;
  }

  public void setLimit(int paramInt)
  {
    this.limit = paramInt;
  }

  public void setStartUserId(String paramString)
  {
    this.startUserId = paramString;
  }

  public void setStopUserId(String paramString)
  {
    this.stopUserId = paramString;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }

  public void validate()
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.ScanAppUserRequest
 * JD-Core Version:    0.6.2
 */