package org.keplerproject.luajava;

import java.io.PrintStream;
import java.lang.reflect.Proxy;
import java.util.StringTokenizer;

public class LuaObject
{
  protected LuaState L;
  protected Integer ref;

  protected LuaObject(LuaObject paramLuaObject, Number paramNumber)
  {
    synchronized (paramLuaObject.getLuaState())
    {
      this.L = paramLuaObject.getLuaState();
      if ((!paramLuaObject.isTable()) && (!paramLuaObject.isUserdata()))
        throw new LuaException("Object parent should be a table or userdata .");
    }
    paramLuaObject.push();
    this.L.pushNumber(paramNumber.doubleValue());
    this.L.getTable(-2);
    this.L.remove(-2);
    registerValue(-1);
    this.L.pop(1);
  }

  protected LuaObject(LuaObject paramLuaObject, String paramString)
  {
    synchronized (paramLuaObject.getLuaState())
    {
      this.L = paramLuaObject.getLuaState();
      if ((!paramLuaObject.isTable()) && (!paramLuaObject.isUserdata()))
        throw new LuaException("Object parent should be a table or userdata .");
    }
    paramLuaObject.push();
    this.L.pushString(paramString);
    this.L.getTable(-2);
    this.L.remove(-2);
    registerValue(-1);
    this.L.pop(1);
  }

  protected LuaObject(LuaObject paramLuaObject1, LuaObject paramLuaObject2)
  {
    if (paramLuaObject1.getLuaState() != paramLuaObject2.getLuaState())
      throw new LuaException("LuaStates must be the same!");
    synchronized (paramLuaObject1.getLuaState())
    {
      if ((!paramLuaObject1.isTable()) && (!paramLuaObject1.isUserdata()))
        throw new LuaException("Object parent should be a table or userdata .");
    }
    this.L = paramLuaObject1.getLuaState();
    paramLuaObject1.push();
    paramLuaObject2.push();
    this.L.getTable(-2);
    this.L.remove(-2);
    registerValue(-1);
    this.L.pop(1);
  }

  protected LuaObject(LuaState paramLuaState, int paramInt)
  {
    try
    {
      this.L = paramLuaState;
      registerValue(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected LuaObject(LuaState paramLuaState, String paramString)
  {
    try
    {
      this.L = paramLuaState;
      paramLuaState.getGlobal(paramString);
      registerValue(-1);
      paramLuaState.pop(1);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void registerValue(int paramInt)
  {
    synchronized (this.L)
    {
      this.L.pushValue(paramInt);
      this.ref = new Integer(this.L.Lref(LuaState.LUA_REGISTRYINDEX.intValue()));
      return;
    }
  }

  public Object call(Object[] paramArrayOfObject)
  {
    return call(paramArrayOfObject, 1)[0];
  }

  public Object[] call(Object[] paramArrayOfObject, int paramInt)
  {
    synchronized (this.L)
    {
      if ((!isFunction()) && (!isTable()) && (!isUserdata()))
        throw new LuaException("Invalid object. Not a function, table or userdata .");
    }
    int i = this.L.getTop();
    push();
    int j;
    int k;
    int m;
    String str1;
    if (paramArrayOfObject != null)
    {
      j = paramArrayOfObject.length;
      k = 0;
      break label377;
      m = this.L.pcall(j, paramInt, 0);
      if (m != 0)
      {
        if (!this.L.isString(-1))
          break label393;
        str1 = this.L.toString(-1);
        this.L.pop(1);
      }
    }
    while (true)
    {
      String str2;
      if (m == LuaState.LUA_ERRRUN.intValue())
      {
        str2 = "Runtime error. " + str1;
        throw new LuaException(str2);
      }
      label377: 
      do
      {
        Object localObject2 = paramArrayOfObject[k];
        this.L.pushObjectValue(localObject2);
        k++;
        continue;
        if (m == LuaState.LUA_ERRMEM.intValue())
        {
          str2 = "Memory allocation error. " + str1;
          break;
        }
        if (m == LuaState.LUA_ERRERR.intValue())
        {
          str2 = "Error while running the error handler function. " + str1;
          break;
        }
        str2 = "Lua Error code " + m + ". " + str1;
        break;
        if (paramInt == LuaState.LUA_MULTRET.intValue());
        for (int n = this.L.getTop() - i; ; n = paramInt)
        {
          if (this.L.getTop() - i < n)
            throw new LuaException("Invalid Number of Results .");
          Object[] arrayOfObject = new Object[n];
          while (true)
          {
            if (n <= 0)
              return arrayOfObject;
            arrayOfObject[(n - 1)] = this.L.toJavaObject(-1);
            this.L.pop(1);
            n--;
          }
        }
      }
      while (k < j);
      break;
      j = 0;
      break;
      label393: str1 = "";
    }
  }

  public Object createProxy(String paramString)
  {
    synchronized (this.L)
    {
      if (!isTable())
        throw new LuaException("Invalid Object. Must be Table.");
    }
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    Class[] arrayOfClass = new Class[localStringTokenizer.countTokens()];
    for (int i = 0; ; i++)
    {
      if (!localStringTokenizer.hasMoreTokens())
      {
        LuaInvocationHandler localLuaInvocationHandler = new LuaInvocationHandler(this);
        Object localObject2 = Proxy.newProxyInstance(getClass().getClassLoader(), arrayOfClass, localLuaInvocationHandler);
        return localObject2;
      }
      arrayOfClass[i] = Class.forName(localStringTokenizer.nextToken());
    }
  }

  protected void finalize()
  {
    try
    {
      synchronized (this.L)
      {
        if (this.L.getCPtrPeer() != 0L)
          this.L.LunRef(LuaState.LUA_REGISTRYINDEX.intValue(), this.ref.intValue());
        return;
      }
    }
    catch (Exception localException)
    {
      System.err.println("Unable to release object " + this.ref);
    }
  }

  public boolean getBoolean()
  {
    synchronized (this.L)
    {
      push();
      boolean bool = this.L.toBoolean(-1);
      this.L.pop(1);
      return bool;
    }
  }

  public LuaObject getField(String paramString)
  {
    return this.L.getLuaObject(this, paramString);
  }

  public LuaState getLuaState()
  {
    return this.L;
  }

  public double getNumber()
  {
    synchronized (this.L)
    {
      push();
      double d = this.L.toNumber(-1);
      this.L.pop(1);
      return d;
    }
  }

  public Object getObject()
  {
    synchronized (this.L)
    {
      push();
      Object localObject2 = this.L.getObjectFromUserdata(-1);
      this.L.pop(1);
      return localObject2;
    }
  }

  public String getString()
  {
    synchronized (this.L)
    {
      push();
      String str = this.L.toString(-1);
      this.L.pop(1);
      return str;
    }
  }

  public boolean isBoolean()
  {
    synchronized (this.L)
    {
      push();
      boolean bool = this.L.isBoolean(-1);
      this.L.pop(1);
      return bool;
    }
  }

  public boolean isFunction()
  {
    synchronized (this.L)
    {
      push();
      boolean bool = this.L.isFunction(-1);
      this.L.pop(1);
      return bool;
    }
  }

  public boolean isJavaFunction()
  {
    synchronized (this.L)
    {
      push();
      boolean bool = this.L.isJavaFunction(-1);
      this.L.pop(1);
      return bool;
    }
  }

  public boolean isJavaObject()
  {
    synchronized (this.L)
    {
      push();
      boolean bool = this.L.isObject(-1);
      this.L.pop(1);
      return bool;
    }
  }

  public boolean isNil()
  {
    synchronized (this.L)
    {
      push();
      boolean bool = this.L.isNil(-1);
      this.L.pop(1);
      return bool;
    }
  }

  public boolean isNumber()
  {
    synchronized (this.L)
    {
      push();
      boolean bool = this.L.isNumber(-1);
      this.L.pop(1);
      return bool;
    }
  }

  public boolean isString()
  {
    synchronized (this.L)
    {
      push();
      boolean bool = this.L.isString(-1);
      this.L.pop(1);
      return bool;
    }
  }

  public boolean isTable()
  {
    synchronized (this.L)
    {
      push();
      boolean bool = this.L.isTable(-1);
      this.L.pop(1);
      return bool;
    }
  }

  public boolean isUserdata()
  {
    synchronized (this.L)
    {
      push();
      boolean bool = this.L.isUserdata(-1);
      this.L.pop(1);
      return bool;
    }
  }

  public void push()
  {
    this.L.rawGetI(LuaState.LUA_REGISTRYINDEX.intValue(), this.ref.intValue());
  }

  public String toString()
  {
    try
    {
      synchronized (this.L)
      {
        boolean bool1 = isNil();
        if (bool1)
          return "nil";
        if (isBoolean())
        {
          String str4 = String.valueOf(getBoolean());
          return str4;
        }
      }
      if (isNumber())
      {
        String str3 = String.valueOf(getNumber());
        return str3;
      }
      if (isString())
      {
        String str2 = getString();
        return str2;
      }
      boolean bool2 = isFunction();
      if (bool2)
        return "Lua Function";
      if (isJavaObject())
      {
        String str1 = getObject().toString();
        return str1;
      }
      boolean bool3 = isUserdata();
      if (bool3)
        return "Userdata";
      boolean bool4 = isTable();
      if (bool4)
        return "Lua Table";
      boolean bool5 = isJavaFunction();
      if (bool5)
        return "Java Function";
      return null;
    }
    catch (LuaException localLuaException)
    {
    }
    return null;
  }

  public int type()
  {
    synchronized (this.L)
    {
      push();
      int i = this.L.type(-1);
      this.L.pop(1);
      return i;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.keplerproject.luajava.LuaObject
 * JD-Core Version:    0.6.2
 */