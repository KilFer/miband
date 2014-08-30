package com.xiaomi.infra.galaxy.common.model;

import java.util.List;

public class BatchResult extends Result
{
  private List<BatchCellResult> batchCells;

  public List<BatchCellResult> getBatchCells()
  {
    return this.batchCells;
  }

  public void setBatchCells(List<BatchCellResult> paramList)
  {
    this.batchCells = paramList;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.BatchResult
 * JD-Core Version:    0.6.2
 */