package de.greenrobot.daobracelet;

public class LuaZipFile
{
  private String date;
  private Long id;
  private String version;
  private byte[] zipFile;

  public LuaZipFile()
  {
  }

  public LuaZipFile(Long paramLong)
  {
    this.id = paramLong;
  }

  public LuaZipFile(Long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.id = paramLong;
    this.version = paramString1;
    this.date = paramString2;
    this.zipFile = paramArrayOfByte;
  }

  public String getDate()
  {
    return this.date;
  }

  public Long getId()
  {
    return this.id;
  }

  public String getVersion()
  {
    return this.version;
  }

  public byte[] getZipFile()
  {
    return this.zipFile;
  }

  public void setDate(String paramString)
  {
    this.date = paramString;
  }

  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }

  public void setVersion(String paramString)
  {
    this.version = paramString;
  }

  public void setZipFile(byte[] paramArrayOfByte)
  {
    this.zipFile = paramArrayOfByte;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.daobracelet.LuaZipFile
 * JD-Core Version:    0.6.2
 */