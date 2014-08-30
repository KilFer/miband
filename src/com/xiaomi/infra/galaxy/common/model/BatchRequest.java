package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import java.util.Iterator;
import java.util.List;

public class BatchRequest extends Request
{
  private List<BatchCellRequest> batchCells;

  public List<BatchCellRequest> getBatchCells()
  {
    return this.batchCells;
  }

  protected BasicGalaxyRequest internalGetGalaxyRequest(String paramString, APILevel paramAPILevel)
  {
    BasicGalaxyRequest localBasicGalaxyRequest = new BasicGalaxyRequest(this, "Galaxy");
    TargetAction localTargetAction = new TargetAction();
    localTargetAction.setApiVersion(GalaxyVersion.getVersion());
    localTargetAction.setLevel(paramAPILevel);
    localTargetAction.setOperation(Operation.Batch);
    localTargetAction.setServiceName("Galaxy");
    localBasicGalaxyRequest.addHeader("X-XiaoMi-Action", localTargetAction.format());
    super.setRequestContent(localBasicGalaxyRequest, paramString);
    return localBasicGalaxyRequest;
  }

  public void setBatchCells(List<BatchCellRequest> paramList)
  {
    this.batchCells = paramList;
  }

  public void validate()
  {
    if ((this.batchCells == null) || (this.batchCells.isEmpty()))
      throw new GalaxyClientException(ReturnCode.BATCH_CELLS_IS_EMPTY);
    Iterator localIterator = this.batchCells.iterator();
    while (localIterator.hasNext())
      ((BatchCellRequest)localIterator.next()).validate();
  }

  public BatchRequest withBatchCells(List<BatchCellRequest> paramList)
  {
    setBatchCells(paramList);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.BatchRequest
 * JD-Core Version:    0.6.2
 */