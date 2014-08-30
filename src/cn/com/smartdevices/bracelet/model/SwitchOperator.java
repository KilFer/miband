package cn.com.smartdevices.bracelet.model;

public class SwitchOperator
{
  public static final int SWITCH_BIND_NEW = 0;
  public static final int SWITCH_EXIT_LOGIN = 1;
  public static final int SWITCH_NONE = -1;
  public String date = "";
  public boolean enableClearData = false;
  public boolean enableSteps = false;
  public String lastMacAddress = "";
  public long lastUid = -1L;
  public int steps = 0;
  public int type = -1;
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.SwitchOperator
 * JD-Core Version:    0.6.2
 */