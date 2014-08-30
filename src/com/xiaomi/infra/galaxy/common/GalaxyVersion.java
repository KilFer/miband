package com.xiaomi.infra.galaxy.common;

public class GalaxyVersion
{
  private static String platform = "java";
  private static String userAgent = getUserAgent();
  private static String version = "0.0.1";

  public static String getPlatform()
  {
    return platform;
  }

  public static String getUserAgent()
  {
    if (userAgent == null)
      initializeUserAgent();
    return userAgent;
  }

  public static String getVersion()
  {
    return version;
  }

  private static void initializeUserAgent()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("galaxy-sdk-" + getPlatform().toLowerCase() + "/");
    localStringBuilder.append(getVersion());
    localStringBuilder.append(" ");
    localStringBuilder.append(System.getProperty("os.name").replace(' ', '_') + "/" + System.getProperty("os.version").replace(' ', '_'));
    localStringBuilder.append(" ");
    localStringBuilder.append(System.getProperty("java.vm.name").replace(' ', '_') + "/" + System.getProperty("java.vm.version").replace(' ', '_'));
    Object localObject = "";
    try
    {
      String str = " " + System.getProperty("user.language").replace(' ', '_') + "_" + System.getProperty("user.region").replace(' ', '_');
      localObject = str;
      label221: localStringBuilder.append((String)localObject);
      userAgent = localStringBuilder.toString();
      return;
    }
    catch (Exception localException)
    {
      break label221;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.GalaxyVersion
 * JD-Core Version:    0.6.2
 */