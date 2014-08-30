package com.google.zxing.oned;

public abstract class UPCEANWriter extends OneDimensionalCodeWriter
{
  protected UPCEANWriter()
  {
    super(UPCEANReader.b.length << 1);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.UPCEANWriter
 * JD-Core Version:    0.6.2
 */