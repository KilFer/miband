package org.keplerproject.luajava;

public abstract class JavaFunction
{
  protected LuaState L;

  public JavaFunction(LuaState paramLuaState)
  {
    this.L = paramLuaState;
  }

  public abstract int execute();

  public LuaObject getParam(int paramInt)
  {
    return this.L.getLuaObject(paramInt);
  }

  public void register(String paramString)
  {
    synchronized (this.L)
    {
      this.L.pushJavaFunction(this);
      this.L.setGlobal(paramString);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.keplerproject.luajava.JavaFunction
 * JD-Core Version:    0.6.2
 */