package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import java.util.List;
import java.util.Set;

public class AlterTableRequest extends Request
{
  private List<AttributeDefinition> attributeDefinitions;
  private Set<String> grantedApps;
  private String tableName;
  private Set<String> unGrantedApps;

  public List<AttributeDefinition> getAttributeDefinitions()
  {
    return this.attributeDefinitions;
  }

  public Set<String> getGrantedApps()
  {
    return this.grantedApps;
  }

  public String getTableName()
  {
    return this.tableName;
  }

  public Set<String> getUnGrantedApps()
  {
    return this.unGrantedApps;
  }

  protected BasicGalaxyRequest internalGetGalaxyRequest(String paramString, APILevel paramAPILevel)
  {
    BasicGalaxyRequest localBasicGalaxyRequest = new BasicGalaxyRequest(this, "Galaxy");
    TargetAction localTargetAction = new TargetAction();
    localTargetAction.setApiVersion(GalaxyVersion.getVersion());
    localTargetAction.setLevel(APILevel.Developer);
    localTargetAction.setOperation(Operation.AlterTable);
    localTargetAction.setServiceName("Galaxy");
    localBasicGalaxyRequest.addHeader("X-XiaoMi-Action", localTargetAction.format());
    super.setRequestContent(localBasicGalaxyRequest, paramString);
    return localBasicGalaxyRequest;
  }

  public void setAttributeDefinitions(List<AttributeDefinition> paramList)
  {
    this.attributeDefinitions = paramList;
  }

  public void setGrantedApps(Set<String> paramSet)
  {
    this.grantedApps = paramSet;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }

  public void setUnGrantedApps(Set<String> paramSet)
  {
    this.unGrantedApps = paramSet;
  }

  public void validate()
  {
  }

  public AlterTableRequest withAttributeDefinitions(List<AttributeDefinition> paramList)
  {
    setAttributeDefinitions(paramList);
    return this;
  }

  public AlterTableRequest withGrantedApps(Set<String> paramSet)
  {
    setGrantedApps(paramSet);
    return this;
  }

  public AlterTableRequest withTableName(String paramString)
  {
    setTableName(paramString);
    return this;
  }

  public AlterTableRequest withUnGrantedApps(Set<String> paramSet)
  {
    setUnGrantedApps(paramSet);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.AlterTableRequest
 * JD-Core Version:    0.6.2
 */