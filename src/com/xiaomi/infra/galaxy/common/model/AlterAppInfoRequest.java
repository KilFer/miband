package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import java.util.Map;

public class AlterAppInfoRequest extends Request
{
  private String appId;
  private Map<String, String> authMethods;

  public String getAppId()
  {
    return this.appId;
  }

  public Map<String, String> getAuthMethods()
  {
    return this.authMethods;
  }

  protected BasicGalaxyRequest internalGetGalaxyRequest(String paramString, APILevel paramAPILevel)
  {
    BasicGalaxyRequest localBasicGalaxyRequest = new BasicGalaxyRequest(this, "Galaxy");
    TargetAction localTargetAction = new TargetAction();
    localTargetAction.setApiVersion(GalaxyVersion.getVersion());
    localTargetAction.setLevel(APILevel.Developer);
    localTargetAction.setOperation(Operation.AlterAppInfo);
    localTargetAction.setServiceName("Galaxy");
    localBasicGalaxyRequest.addHeader("X-XiaoMi-Action", localTargetAction.format());
    super.setRequestContent(localBasicGalaxyRequest, paramString);
    return localBasicGalaxyRequest;
  }

  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }

  public void setAuthMethods(Map<String, String> paramMap)
  {
    this.authMethods = paramMap;
  }

  public void validate()
  {
    if ((this.appId == null) || ("".equals(this.appId.trim())))
      throw new GalaxyClientException(ReturnCode.APP_ID_IS_BLANK);
  }

  public AlterAppInfoRequest withAppId(String paramString)
  {
    setAppId(paramString);
    return this;
  }

  public AlterAppInfoRequest withAuthMethods(Map<String, String> paramMap)
  {
    setAuthMethods(paramMap);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.AlterAppInfoRequest
 * JD-Core Version:    0.6.2
 */