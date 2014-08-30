package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.HttpMethodName;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public abstract class Request
{
  public BasicGalaxyRequest getGalaxyRequest(String paramString, APILevel paramAPILevel)
  {
    validate();
    return internalGetGalaxyRequest(paramString, paramAPILevel);
  }

  protected abstract BasicGalaxyRequest internalGetGalaxyRequest(String paramString, APILevel paramAPILevel);

  public void setRequestContent(BasicGalaxyRequest paramBasicGalaxyRequest, String paramString)
  {
    paramBasicGalaxyRequest.addHeader("Content-Type", "application/x-xiaomi-json-1.0");
    paramBasicGalaxyRequest.setHttpMethod(HttpMethodName.POST);
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      paramBasicGalaxyRequest.setContent(new ByteArrayInputStream(arrayOfByte));
      paramBasicGalaxyRequest.addHeader("Content-Length", Integer.toString(arrayOfByte.length));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }

  public abstract void validate();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.Request
 * JD-Core Version:    0.6.2
 */