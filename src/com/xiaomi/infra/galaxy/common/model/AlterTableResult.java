package com.xiaomi.infra.galaxy.common.model;

public class AlterTableResult extends Result
{
  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        bool1 = false;
      }
      while (paramObject == null);
      bool2 = paramObject instanceof AlterTableResult;
      bool1 = false;
    }
    while (!bool2);
    return super.equals(paramObject);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.AlterTableResult
 * JD-Core Version:    0.6.2
 */