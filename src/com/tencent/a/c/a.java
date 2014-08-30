package com.tencent.a.c;

import java.io.File;

public class a
{
  public static boolean a(File paramFile)
  {
    int i = 0;
    if (paramFile != null)
    {
      if (!paramFile.isFile())
        break label28;
      if (paramFile.delete())
        break label26;
      paramFile.deleteOnExit();
    }
    label26: label28: 
    while (!paramFile.isDirectory())
    {
      return false;
      return true;
    }
    File[] arrayOfFile = paramFile.listFiles();
    int j = arrayOfFile.length;
    while (i < j)
    {
      a(arrayOfFile[i]);
      i++;
    }
    return paramFile.delete();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.a.c.a
 * JD-Core Version:    0.6.2
 */