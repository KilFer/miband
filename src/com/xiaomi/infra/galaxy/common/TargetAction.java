package com.xiaomi.infra.galaxy.common;

import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import com.xiaomi.infra.galaxy.common.util.StringUtils;

public class TargetAction
{
  private static final String REGULAR_UNDERSCORE = "[_]";
  private static final String UNDERSCORE = "_";
  private String apiVersion;
  private APILevel level;
  private Operation operation;
  private String serviceName;

  public TargetAction()
  {
  }

  public TargetAction(String paramString)
  {
    StringUtils.isBlank(paramString);
    String[] arrayOfString = paramString.split("[_]");
    this.serviceName = arrayOfString[0];
    this.apiVersion = arrayOfString[1];
    this.level = APILevel.fromValue(arrayOfString[2]);
    this.operation = Operation.fromValue(arrayOfString[3]);
    if ((this.level == APILevel.User) && (this.operation != Operation.Batch) && (this.operation != Operation.Get) && (this.operation != Operation.Set) && (this.operation != Operation.Scan));
  }

  public String format()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.serviceName).append("_").append(this.apiVersion).append("_").append(this.level.name()).append("_").append(this.operation.name());
    return localStringBuilder.toString();
  }

  public String getApiVersion()
  {
    return this.apiVersion;
  }

  public APILevel getLevel()
  {
    return this.level;
  }

  public Operation getOperation()
  {
    return this.operation;
  }

  public String getServiceName()
  {
    return this.serviceName;
  }

  public void setApiVersion(String paramString)
  {
    this.apiVersion = paramString;
  }

  public void setLevel(APILevel paramAPILevel)
  {
    this.level = paramAPILevel;
  }

  public void setOperation(Operation paramOperation)
  {
    this.operation = paramOperation;
  }

  public void setServiceName(String paramString)
  {
    this.serviceName = paramString;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.serviceName).append("_").append(this.apiVersion).append("_").append(this.level.name()).append("_").append(this.operation.name());
    return localStringBuilder.toString();
  }

  public void withAPILevel(String paramString)
  {
    this.level = APILevel.fromValue(paramString);
  }

  public void withOperation(String paramString)
  {
    this.operation = Operation.fromValue(paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.TargetAction
 * JD-Core Version:    0.6.2
 */