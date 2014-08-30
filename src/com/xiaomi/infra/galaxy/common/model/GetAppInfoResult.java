package com.xiaomi.infra.galaxy.common.model;

import java.util.List;
import java.util.Map;

public class GetAppInfoResult extends Result
{
  private String appId;
  private Map<String, String> authMethods;
  private List<TableDescription> unusedTables;
  private List<TableDescription> usedTables;

  public String getAppId()
  {
    return this.appId;
  }

  public Map<String, String> getAuthMethods()
  {
    return this.authMethods;
  }

  public List<TableDescription> getUnusedTables()
  {
    return this.unusedTables;
  }

  public List<TableDescription> getUsedTables()
  {
    return this.usedTables;
  }

  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }

  public void setAuthMethods(Map<String, String> paramMap)
  {
    this.authMethods = paramMap;
  }

  public void setUnusedTables(List<TableDescription> paramList)
  {
    this.unusedTables = paramList;
  }

  public void setUsedTables(List<TableDescription> paramList)
  {
    this.usedTables = paramList;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.GetAppInfoResult
 * JD-Core Version:    0.6.2
 */