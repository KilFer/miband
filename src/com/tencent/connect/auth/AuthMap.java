package com.tencent.connect.auth;

import java.util.HashMap;

public class AuthMap
{
  private static int a;
  public static AuthMap sInstance;
  public final String KEY_CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  public HashMap<String, AuthMap.Auth> authMap = new HashMap();

  static
  {
    if (!AuthMap.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      b = bool;
      a = 0;
      return;
    }
  }

  private static String a(String paramString1, String paramString2)
  {
    int i = 0;
    if ((!b) && (paramString1.length() % 2 != 0))
      throw new AssertionError();
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString2.length();
    int k = paramString1.length() / 2;
    int m = 0;
    while (i < k)
    {
      localStringBuilder.append((char)(Integer.parseInt(paramString1.substring(i << 1, 2 + (i << 1)), 16) ^ paramString2.charAt(m)));
      m = (m + 1) % j;
      i++;
    }
    return localStringBuilder.toString();
  }

  public static AuthMap getInstance()
  {
    if (sInstance == null)
      sInstance = new AuthMap();
    return sInstance;
  }

  public static int getSerial()
  {
    int i = 1 + a;
    a = i;
    return i;
  }

  public String decode(String paramString1, String paramString2)
  {
    int i = 0;
    if ((!b) && (paramString1.length() % 2 != 0))
      throw new AssertionError();
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString2.length();
    int k = paramString1.length() / 2;
    int m = 0;
    while (i < k)
    {
      localStringBuilder.append((char)(Integer.parseInt(paramString1.substring(i << 1, 2 + (i << 1)), 16) ^ paramString2.charAt(m)));
      m = (m + 1) % j;
      i++;
    }
    return localStringBuilder.toString();
  }

  public AuthMap.Auth get(String paramString)
  {
    return (AuthMap.Auth)this.authMap.get(paramString);
  }

  public String makeKey()
  {
    int i = (int)Math.ceil(3.0D + 20.0D * Math.random());
    char[] arrayOfChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    int j = arrayOfChar.length;
    StringBuffer localStringBuffer = new StringBuffer();
    for (int k = 0; k < i; k++)
      localStringBuffer.append(arrayOfChar[((int)(Math.random() * j))]);
    return localStringBuffer.toString();
  }

  public void remove(String paramString)
  {
    this.authMap.remove(paramString);
  }

  public String set(AuthMap.Auth paramAuth)
  {
    int i = getSerial();
    try
    {
      this.authMap.put(i, paramAuth);
      return i;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        localThrowable.printStackTrace();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.AuthMap
 * JD-Core Version:    0.6.2
 */