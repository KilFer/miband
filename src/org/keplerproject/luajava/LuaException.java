package org.keplerproject.luajava;

public class LuaException extends Exception
{
  private static final long serialVersionUID = 1L;

  public LuaException(Exception paramException)
  {
    super(paramException);
  }

  public LuaException(String paramString)
  {
    super(paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.keplerproject.luajava.LuaException
 * JD-Core Version:    0.6.2
 */