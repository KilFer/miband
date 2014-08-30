package cn.com.smartdevices.bracelet.upgrade;

public class NewVersionInfo
{
  private int a;
  private String b;
  private String c;
  private String d;
  private String e;

  public String getChangeLog()
  {
    return this.c;
  }

  public String getFileUrl()
  {
    return this.d;
  }

  public String getMd5()
  {
    return this.e;
  }

  public int getVersionCode()
  {
    return this.a;
  }

  public String getVersionName()
  {
    return this.b;
  }

  public void setChangeLog(String paramString)
  {
    this.c = paramString;
  }

  public void setFileUrl(String paramString)
  {
    this.d = paramString;
  }

  public void setMd5(String paramString)
  {
    this.e = paramString;
  }

  public void setVersionCode(int paramInt)
  {
    this.a = paramInt;
  }

  public void setVersionName(String paramString)
  {
    this.b = paramString;
  }

  public String toString()
  {
    return this.a + ";" + this.b + ";" + this.d + ";" + this.e + ";" + this.c;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.upgrade.NewVersionInfo
 * JD-Core Version:    0.6.2
 */