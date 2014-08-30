package org.keplerproject.luajava;

import java.util.ArrayList;
import java.util.List;

public final class LuaStateFactory
{
  private static final List states = new ArrayList();

  public static LuaState getExistingState(int paramInt)
  {
    try
    {
      LuaState localLuaState = (LuaState)states.get(paramInt);
      return localLuaState;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static int getNextStateIndex()
  {
    int i = 0;
    try
    {
      if (i < states.size())
      {
        Object localObject2 = states.get(i);
        if (localObject2 != null);
      }
      else
      {
        return i;
      }
      i++;
    }
    finally
    {
    }
  }

  public static int insertLuaState(LuaState paramLuaState)
  {
    int i = 0;
    try
    {
      while (true)
      {
        int j;
        if (i >= states.size())
        {
          j = getNextStateIndex();
          states.set(j, paramLuaState);
        }
        while (true)
        {
          return j;
          LuaState localLuaState = (LuaState)states.get(i);
          if (localLuaState == null)
            break;
          long l1 = localLuaState.getCPtrPeer();
          long l2 = paramLuaState.getCPtrPeer();
          if (l1 != l2)
            break;
          j = i;
        }
        i++;
      }
    }
    finally
    {
    }
  }

  public static LuaState newLuaState()
  {
    try
    {
      int i = getNextStateIndex();
      LuaState localLuaState = new LuaState(i);
      states.add(i, localLuaState);
      return localLuaState;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void removeLuaState(int paramInt)
  {
    try
    {
      states.add(paramInt, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.keplerproject.luajava.LuaStateFactory
 * JD-Core Version:    0.6.2
 */