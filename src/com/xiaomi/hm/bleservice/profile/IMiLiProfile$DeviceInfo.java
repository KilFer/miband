package com.xiaomi.hm.bleservice.profile;

public final class IMiLiProfile$DeviceInfo
{
  public static final byte STATUS_AUTHENTICATION_FAILED = 1;
  public static final byte STATUS_AUTHENTICATION_SUCCESS = 2;
  public final int appearance;
  public final String deviceID;
  public final int feature;
  public final int firmwareVersion;
  public final int hardwareVersion;
  public final int profileVersion;

  public IMiLiProfile$DeviceInfo(String paramString, int paramInt1, int paramInt2)
  {
    this.deviceID = paramString;
    this.feature = Integer.decode("0x" + paramString.substring(8, 10)).intValue();
    this.appearance = Integer.decode("0x" + paramString.substring(10, 12)).intValue();
    this.hardwareVersion = Integer.decode("0x" + paramString.substring(12, 14)).intValue();
    this.profileVersion = paramInt1;
    this.firmwareVersion = paramInt2;
  }

  public final int getFirmwareVersionBuild()
  {
    return 0xFF & this.firmwareVersion;
  }

  public final int getFirmwareVersionMajor()
  {
    return this.firmwareVersion >>> 24;
  }

  public final int getFirmwareVersionMinor()
  {
    return 0xFF & this.firmwareVersion >> 16;
  }

  public final int getFirmwareVersionRevision()
  {
    return 0xFF & this.firmwareVersion >> 8;
  }

  public final String getFirmwareVersionStr()
  {
    return getFirmwareVersionMajor() + "." + getFirmwareVersionMinor() + "." + getFirmwareVersionRevision() + "." + getFirmwareVersionBuild();
  }

  public final int getProfileVersionBuild()
  {
    return 0xFF & this.profileVersion;
  }

  public final int getProfileVersionMajor()
  {
    return this.profileVersion >>> 24;
  }

  public final int getProfileVersionMinor()
  {
    return 0xFF & this.profileVersion >> 16;
  }

  public final int getProfileVersionRevision()
  {
    return 0xFF & this.profileVersion >> 8;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    String str = getProfileVersionMajor() + "." + getProfileVersionMinor() + "." + getProfileVersionRevision() + "." + getProfileVersionBuild();
    localStringBuilder.append("[[[ " + getClass().getSimpleName() + " ]]]");
    localStringBuilder.append("\n         deviceID: " + this.deviceID);
    localStringBuilder.append("\n          feature: " + Integer.toHexString(this.feature));
    localStringBuilder.append("\n       appearance: " + Integer.toHexString(this.appearance));
    localStringBuilder.append("\n  hardwareVersion: " + Integer.toHexString(this.hardwareVersion));
    localStringBuilder.append("\n   profileVersion: " + str);
    localStringBuilder.append("\n  firmwareVersion: " + getFirmwareVersionStr());
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo
 * JD-Core Version:    0.6.2
 */