package com.xiaomi.hm.bleservice.gatt;

public enum IGattCallback$STATE
{
  static
  {
    DISCONNECTED = new STATE("DISCONNECTED", 1, 0);
    CONNECTING = new STATE("CONNECTING", 2, 1);
    CONNECTED = new STATE("CONNECTED", 3, 2);
    STATE[] arrayOfSTATE = new STATE[4];
    arrayOfSTATE[0] = DISCONNECTING;
    arrayOfSTATE[1] = DISCONNECTED;
    arrayOfSTATE[2] = CONNECTING;
    arrayOfSTATE[3] = CONNECTED;
  }

  private IGattCallback$STATE(int arg3)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.IGattCallback.STATE
 * JD-Core Version:    0.6.2
 */