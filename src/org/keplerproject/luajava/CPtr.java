package org.keplerproject.luajava;

public class CPtr
{
  private long peer;

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
    {
      return false;
      if (paramObject == this)
        return true;
    }
    while ((CPtr.class != paramObject.getClass()) || (this.peer != ((CPtr)paramObject).peer));
    return true;
  }

  protected long getPeer()
  {
    return this.peer;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.keplerproject.luajava.CPtr
 * JD-Core Version:    0.6.2
 */