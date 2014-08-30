package com.tencent.mm.algorithm;

public class LRUMap$TimeVal<OO>
{
  public OO obj;
  public Long t;

  public LRUMap$TimeVal(OO paramOO)
  {
    Object localObject;
    this.obj = localObject;
    UpTime();
  }

  public void UpTime()
  {
    this.t = Long.valueOf(System.currentTimeMillis());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.algorithm.LRUMap.TimeVal
 * JD-Core Version:    0.6.2
 */