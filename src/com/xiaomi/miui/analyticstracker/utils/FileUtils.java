package com.xiaomi.miui.analyticstracker.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class FileUtils
{
  public static boolean expired(File paramFile)
  {
    return (paramFile == null) || (System.currentTimeMillis() - paramFile.lastModified() >= 86400000L);
  }

  public static File getFileByName(Context paramContext, String paramString, boolean paramBoolean)
  {
    File localFile = new File(paramContext.getFilesDir() + "/", paramString);
    if ((paramBoolean) && (!localFile.exists()))
      localFile.createNewFile();
    return localFile;
  }

  public static String getFileContent(File paramFile)
  {
    if (paramFile != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(paramFile)));
      for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine())
        localStringBuilder.append(str).append("\n");
      localBufferedReader.close();
      return localStringBuilder.toString();
    }
    return "";
  }

  public static void writeFile(File paramFile, String paramString)
  {
    if (paramFile != null)
    {
      PrintStream localPrintStream = new PrintStream(paramFile);
      localPrintStream.println(paramString);
      localPrintStream.close();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.utils.FileUtils
 * JD-Core Version:    0.6.2
 */