package cn.com.smartdevices.bracelet;

public abstract interface MainListener
{
  public abstract void onBraceletConnectedFailed();

  public abstract void onBraceletConnectedSucc();

  public abstract void onBraceletConnecting();

  public abstract void onBraceletDisconnected();

  public abstract void onBraceletSearchedFailed();

  public abstract void onBraceletSearching();

  public abstract void onFwUpgradeProgress(int paramInt);

  public abstract void onFwUpgradeStart(int paramInt);

  public abstract void onFwUpgradeStop(int paramInt);

  public abstract void onLoadLocalDataComplete();

  public abstract void onSyncDataProgress(int paramInt);

  public abstract void onSyncDataStart();

  public abstract void onSyncDataStop(boolean paramBoolean);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.MainListener
 * JD-Core Version:    0.6.2
 */