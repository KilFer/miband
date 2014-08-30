package com.xiaomi.miui.analyticstracker.utils;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  private static final String a = "MD5";

  public static String calculateMD5(File paramFile)
  {
    String str = null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      byte[] arrayOfByte = new byte[8192];
      while (true)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i <= 0)
          break;
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      BigInteger localBigInteger = new BigInteger(1, localMessageDigest.digest());
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localBigInteger.toString(16);
      str = String.format("%32s", arrayOfObject).replace(' ', '0');
      localFileInputStream.close();
      return str;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      return str;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Unable to process file for MD5", localIOException);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return str;
  }

  public static boolean checkMD5(String paramString, File paramFile)
  {
    boolean bool = false;
    if ((TextUtils.isEmpty(paramString)) || (paramFile == null) || (!paramFile.exists()));
    while (true)
    {
      return false;
      Log.d("Update file server md5:", paramString);
      try
      {
        String str = calculateMD5(paramFile);
        bool = false;
        if (str != null)
        {
          bool = str.equalsIgnoreCase(paramString);
          Log.d("Update file local md5:", str);
          return bool;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        localRuntimeException.printStackTrace();
      }
    }
    return bool;
  }

  public static String getMd5Digest(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      String str = String.format("%1$032X", new Object[] { new BigInteger(1, localMessageDigest.digest()) });
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return "";
  }

  public static String getRecoveryMD5()
  {
    try
    {
      Process localProcess = Runtime.getRuntime().exec("su");
      OutputStream localOutputStream = localProcess.getOutputStream();
      localOutputStream.write(("md5sum " + "/dev/mtd/mtd1").getBytes());
      localOutputStream.flush();
      localOutputStream.close();
      InputStream localInputStream = localProcess.getInputStream();
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
      String str = localBufferedReader.readLine().split("  ")[0].trim();
      localInputStream.close();
      localBufferedReader.close();
      localProcess.destroy();
      Log.i("MD5", "Recovery MD5: " + str);
      return str;
    }
    catch (Exception localException)
    {
      Log.e("MD5", "Exception on getting Recovery MD5", localException);
    }
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.utils.MD5
 * JD-Core Version:    0.6.2
 */