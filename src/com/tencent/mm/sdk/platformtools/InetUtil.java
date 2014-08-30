package com.tencent.mm.sdk.platformtools;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InetUtil
{
  private static final Pattern a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
  private static final Pattern b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
  private static final Pattern c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

  public static InetAddress getByDottedAddress(String paramString)
  {
    if (isIPv4Address(paramString))
      return InetAddress.getByName(paramString);
    if (isIPv6Address(paramString))
      return InetAddress.getByName(paramString);
    throw new UnknownHostException("invalid ipv4 or ipv6 dotted string");
  }

  public static boolean isIPv4Address(String paramString)
  {
    return a.matcher(paramString).matches();
  }

  public static boolean isIPv6Address(String paramString)
  {
    return (isIPv6StdAddress(paramString)) || (isIPv6HexCompressedAddress(paramString));
  }

  public static boolean isIPv6HexCompressedAddress(String paramString)
  {
    return c.matcher(paramString).matches();
  }

  public static boolean isIPv6StdAddress(String paramString)
  {
    return b.matcher(paramString).matches();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.InetUtil
 * JD-Core Version:    0.6.2
 */