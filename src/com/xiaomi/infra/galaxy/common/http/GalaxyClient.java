package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.SessionExpiredException;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.model.BatchRequest;
import com.xiaomi.infra.galaxy.common.model.BatchResult;
import com.xiaomi.infra.galaxy.common.model.DeleteRequest;
import com.xiaomi.infra.galaxy.common.model.DeleteResult;
import com.xiaomi.infra.galaxy.common.model.GalaxyMarshaller;
import com.xiaomi.infra.galaxy.common.model.GetRequest;
import com.xiaomi.infra.galaxy.common.model.GetResult;
import com.xiaomi.infra.galaxy.common.model.ScanRequest;
import com.xiaomi.infra.galaxy.common.model.ScanResult;
import com.xiaomi.infra.galaxy.common.model.SetRequest;
import com.xiaomi.infra.galaxy.common.model.SetResult;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class GalaxyClient
{
  private static final Log log = LogFactory.getLog(GalaxyClient.class);
  protected ClientConfiguration clientConfiguration;
  protected GalaxyMarshaller marshaller;
  protected GalaxyServiceClient serviceClient;

  public GalaxyClient(ClientConfiguration paramClientConfiguration, GalaxyServiceClient paramGalaxyServiceClient, GalaxyMarshaller paramGalaxyMarshaller)
  {
    this.clientConfiguration = paramClientConfiguration;
    this.serviceClient = paramGalaxyServiceClient;
    this.marshaller = paramGalaxyMarshaller;
    if (StringUtils.isBlank(this.clientConfiguration.getAppId()))
      throw new GalaxyClientException(ReturnCode.APP_ID_IS_BLANK, "appId is empty");
  }

  public BatchResult batch(BatchRequest paramBatchRequest)
  {
    try
    {
      BatchResult localBatchResult4 = (BatchResult)invoke(paramBatchRequest.getGalaxyRequest(this.marshaller.marshall(paramBatchRequest), APILevel.User), BatchResult.class);
      return localBatchResult4;
    }
    catch (SessionExpiredException localSessionExpiredException)
    {
      log.error(localSessionExpiredException);
      BatchResult localBatchResult3 = new BatchResult();
      localBatchResult3.setResult(localSessionExpiredException.getReturnCode().getResult());
      return localBatchResult3;
    }
    catch (GalaxyClientException localGalaxyClientException)
    {
      log.error(localGalaxyClientException);
      BatchResult localBatchResult2 = new BatchResult();
      localBatchResult2.setResult(localGalaxyClientException.getReturnCode().getResult());
      return localBatchResult2;
    }
    catch (Exception localException)
    {
      log.error("operation failed", localException);
      BatchResult localBatchResult1 = new BatchResult();
      localBatchResult1.setResult(ReturnCode.OPERATION_FAILED.getResult());
      return localBatchResult1;
    }
  }

  public DeleteResult delete(DeleteRequest paramDeleteRequest)
  {
    try
    {
      if (StringUtils.isNotBlank(paramDeleteRequest.getUserId()))
      {
        DeleteResult localDeleteResult4 = new DeleteResult();
        localDeleteResult4.setResult(ReturnCode.USER_ID_IS_UNNECESSARY.getResult());
        return localDeleteResult4;
      }
      DeleteResult localDeleteResult5 = (DeleteResult)invoke(paramDeleteRequest.getGalaxyRequest(this.marshaller.marshall(paramDeleteRequest), APILevel.User), DeleteResult.class);
      return localDeleteResult5;
    }
    catch (SessionExpiredException localSessionExpiredException)
    {
      log.error(localSessionExpiredException);
      DeleteResult localDeleteResult3 = new DeleteResult();
      localDeleteResult3.setResult(localSessionExpiredException.getReturnCode().getResult());
      return localDeleteResult3;
    }
    catch (GalaxyClientException localGalaxyClientException)
    {
      log.error(localGalaxyClientException);
      DeleteResult localDeleteResult2 = new DeleteResult();
      localDeleteResult2.setResult(localGalaxyClientException.getReturnCode().getResult());
      return localDeleteResult2;
    }
    catch (Exception localException)
    {
      log.error("operation failed", localException);
      DeleteResult localDeleteResult1 = new DeleteResult();
      localDeleteResult1.setResult(ReturnCode.OPERATION_FAILED.getResult());
      return localDeleteResult1;
    }
  }

  public GetResult get(GetRequest paramGetRequest)
  {
    try
    {
      if (StringUtils.isNotBlank(paramGetRequest.getUserId()))
      {
        GetResult localGetResult4 = new GetResult();
        localGetResult4.setResult(ReturnCode.USER_ID_IS_UNNECESSARY.getResult());
        return localGetResult4;
      }
      GetResult localGetResult5 = (GetResult)invoke(paramGetRequest.getGalaxyRequest(this.marshaller.marshall(paramGetRequest), APILevel.User), GetResult.class);
      return localGetResult5;
    }
    catch (SessionExpiredException localSessionExpiredException)
    {
      log.error(localSessionExpiredException);
      GetResult localGetResult3 = new GetResult();
      localGetResult3.setResult(localSessionExpiredException.getReturnCode().getResult());
      return localGetResult3;
    }
    catch (GalaxyClientException localGalaxyClientException)
    {
      log.error(localGalaxyClientException);
      GetResult localGetResult2 = new GetResult();
      localGetResult2.setResult(localGalaxyClientException.getReturnCode().getResult());
      return localGetResult2;
    }
    catch (Exception localException)
    {
      log.error("operation failed", localException);
      GetResult localGetResult1 = new GetResult();
      localGetResult1.setResult(ReturnCode.OPERATION_FAILED.getResult());
      return localGetResult1;
    }
  }

  protected abstract <X> X invoke(BasicGalaxyRequest paramBasicGalaxyRequest, Class<X> paramClass);

  public ScanResult scan(ScanRequest paramScanRequest)
  {
    try
    {
      if (StringUtils.isNotBlank(paramScanRequest.getUserId()))
      {
        ScanResult localScanResult4 = new ScanResult();
        localScanResult4.setResult(ReturnCode.USER_ID_IS_UNNECESSARY.getResult());
        return localScanResult4;
      }
      ScanResult localScanResult5 = (ScanResult)invoke(paramScanRequest.getGalaxyRequest(this.marshaller.marshall(paramScanRequest), APILevel.User), ScanResult.class);
      return localScanResult5;
    }
    catch (SessionExpiredException localSessionExpiredException)
    {
      log.error(localSessionExpiredException);
      ScanResult localScanResult3 = new ScanResult();
      localScanResult3.setResult(localSessionExpiredException.getReturnCode().getResult());
      return localScanResult3;
    }
    catch (GalaxyClientException localGalaxyClientException)
    {
      log.error(localGalaxyClientException);
      ScanResult localScanResult2 = new ScanResult();
      localScanResult2.setResult(localGalaxyClientException.getReturnCode().getResult());
      return localScanResult2;
    }
    catch (Exception localException)
    {
      log.error("operation failed", localException);
      ScanResult localScanResult1 = new ScanResult();
      localScanResult1.setResult(ReturnCode.OPERATION_FAILED.getResult());
      return localScanResult1;
    }
  }

  public SetResult set(SetRequest paramSetRequest)
  {
    try
    {
      if (StringUtils.isNotBlank(paramSetRequest.getUserId()))
      {
        SetResult localSetResult4 = new SetResult();
        localSetResult4.setResult(ReturnCode.USER_ID_IS_UNNECESSARY.getResult());
        return localSetResult4;
      }
      SetResult localSetResult5 = (SetResult)invoke(paramSetRequest.getGalaxyRequest(this.marshaller.marshall(paramSetRequest), APILevel.User), SetResult.class);
      return localSetResult5;
    }
    catch (SessionExpiredException localSessionExpiredException)
    {
      log.error(localSessionExpiredException);
      SetResult localSetResult3 = new SetResult();
      localSetResult3.setResult(localSessionExpiredException.getReturnCode().getResult());
      return localSetResult3;
    }
    catch (GalaxyClientException localGalaxyClientException)
    {
      log.error(localGalaxyClientException);
      SetResult localSetResult2 = new SetResult();
      localSetResult2.setResult(localGalaxyClientException.getReturnCode().getResult());
      return localSetResult2;
    }
    catch (Exception localException)
    {
      log.error("operation failed", localException);
      SetResult localSetResult1 = new SetResult();
      localSetResult1.setResult(ReturnCode.OPERATION_FAILED.getResult());
      return localSetResult1;
    }
  }

  public void shutdown()
  {
    if (this.serviceClient != null)
      this.serviceClient.shutdown();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.http.GalaxyClient
 * JD-Core Version:    0.6.2
 */