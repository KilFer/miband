package com.xiaomi.infra.galaxy.common.model;

import java.util.List;

public class ShowTablesResult extends Result
{
  private List<TableDescription> tables;
  private List<TableDescription> unusedTables;

  public List<TableDescription> getTables()
  {
    return this.tables;
  }

  public List<TableDescription> getUnusedTables()
  {
    return this.unusedTables;
  }

  public void setTables(List<TableDescription> paramList)
  {
    this.tables = paramList;
  }

  public void setUnusedTables(List<TableDescription> paramList)
  {
    this.unusedTables = paramList;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.ShowTablesResult
 * JD-Core Version:    0.6.2
 */