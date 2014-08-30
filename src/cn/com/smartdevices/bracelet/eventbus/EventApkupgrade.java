package cn.com.smartdevices.bracelet.eventbus;

public class EventApkupgrade
{
  private String changeLog;
  private boolean forceCheck;

  public EventApkupgrade(boolean paramBoolean, String paramString)
  {
    this.forceCheck = paramBoolean;
    this.changeLog = paramString;
  }

  public String getChangeLog()
  {
    return this.changeLog;
  }

  public boolean isForceCheck()
  {
    return this.forceCheck;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.eventbus.EventApkupgrade
 * JD-Core Version:    0.6.2
 */