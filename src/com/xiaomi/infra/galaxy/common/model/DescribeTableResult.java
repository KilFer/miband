package com.xiaomi.infra.galaxy.common.model;

public class DescribeTableResult extends Result
{
  private TableDescription table;

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    boolean bool3;
    do
    {
      do
      {
        return bool2;
        bool2 = false;
      }
      while (paramObject == null);
      bool3 = paramObject instanceof DescribeTableResult;
      bool2 = false;
    }
    while (!bool3);
    DescribeTableResult localDescribeTableResult = (DescribeTableResult)paramObject;
    int i;
    if (localDescribeTableResult.getTable() == null)
    {
      i = bool1;
      label47: if (getTable() != null)
        break label108;
    }
    while (true)
    {
      int j = i ^ bool1;
      bool2 = false;
      if (j != 0)
        break;
      if (localDescribeTableResult.getTable() != null)
      {
        boolean bool4 = localDescribeTableResult.getTable().equals(getTable());
        bool2 = false;
        if (!bool4)
          break;
      }
      return super.equals(paramObject);
      i = 0;
      break label47;
      label108: bool1 = false;
    }
  }

  public TableDescription getTable()
  {
    return this.table;
  }

  public int hashCode()
  {
    int i = 31 * super.hashCode();
    if (getTable() == null);
    for (int j = 0; ; j = getTable().hashCode())
      return j + i;
  }

  public void setTable(TableDescription paramTableDescription)
  {
    this.table = paramTableDescription;
  }

  public DescribeTableResult withTable(TableDescription paramTableDescription)
  {
    this.table = paramTableDescription;
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.DescribeTableResult
 * JD-Core Version:    0.6.2
 */