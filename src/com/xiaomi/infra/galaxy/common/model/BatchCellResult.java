package com.xiaomi.infra.galaxy.common.model;

public class BatchCellResult
{
  private DeleteResult delete;
  private GetResult get;
  private SetResult set;

  public DeleteResult getDelete()
  {
    return this.delete;
  }

  public GetResult getGet()
  {
    return this.get;
  }

  public SetResult getSet()
  {
    return this.set;
  }

  public void setDelete(DeleteResult paramDeleteResult)
  {
    this.delete = paramDeleteResult;
  }

  public void setGet(GetResult paramGetResult)
  {
    this.get = paramGetResult;
  }

  public void setSet(SetResult paramSetResult)
  {
    this.set = paramSetResult;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.BatchCellResult
 * JD-Core Version:    0.6.2
 */