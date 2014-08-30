package org.keplerproject.luajava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Console
{
  public static void main(String[] paramArrayOfString)
  {
    LuaState localLuaState;
    while (true)
    {
      int i;
      try
      {
        localLuaState = LuaStateFactory.newLuaState();
        localLuaState.openLibs();
        if (paramArrayOfString.length <= 0)
          break;
        i = 0;
        if (i >= paramArrayOfString.length)
          return;
        int j = localLuaState.LloadFile(paramArrayOfString[i]);
        if (j == 0)
          j = localLuaState.pcall(0, 0, 0);
        if (j != 0)
          throw new LuaException("Error on file: " + paramArrayOfString[i] + ". " + localLuaState.toString(-1));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      i++;
    }
    System.out.println("API Lua Java - console mode.");
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(System.in));
    while (true)
    {
      System.out.print("> ");
      String str = localBufferedReader.readLine();
      if ((str == null) || (str.equals("exit")))
      {
        localLuaState.close();
        return;
      }
      int k = localLuaState.LloadBuffer(str.getBytes(), "from console");
      if (k == 0)
        k = localLuaState.pcall(0, 0, 0);
      if (k != 0)
      {
        System.err.println("Error on line: " + str);
        System.err.println(localLuaState.toString(-1));
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.keplerproject.luajava.Console
 * JD-Core Version:    0.6.2
 */