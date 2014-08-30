package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;

public class BatchCellRequest
{
  private DeleteRequest delete;
  private GetRequest get;
  private SetRequest set;

  public DeleteRequest getDelete()
  {
    return this.delete;
  }

  public GetRequest getGet()
  {
    return this.get;
  }

  public SetRequest getSet()
  {
    return this.set;
  }

  public void setDelete(DeleteRequest paramDeleteRequest)
  {
    this.delete = paramDeleteRequest;
  }

  public void setGet(GetRequest paramGetRequest)
  {
    this.get = paramGetRequest;
  }

  public void setSet(SetRequest paramSetRequest)
  {
    this.set = paramSetRequest;
  }

  public void validate()
  {
    SetRequest localSetRequest = this.set;
    int i = 0;
    if (localSetRequest != null)
    {
      this.set.validate();
      i = 1;
    }
    if (this.delete != null)
    {
      this.delete.validate();
      i++;
    }
    if (this.get != null)
    {
      this.get.validate();
      i++;
    }
    if (i != 1)
      throw new GalaxyClientException(ReturnCode.BATCH_CELLS_IS_NOT_ONLY, "");
  }

  public BatchCellRequest withDelete(DeleteRequest paramDeleteRequest)
  {
    setDelete(paramDeleteRequest);
    return this;
  }

  public BatchCellRequest withGet(GetRequest paramGetRequest)
  {
    setGet(paramGetRequest);
    return this;
  }

  public BatchCellRequest withSet(SetRequest paramSetRequest)
  {
    setSet(paramSetRequest);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.BatchCellRequest
 * JD-Core Version:    0.6.2
 */