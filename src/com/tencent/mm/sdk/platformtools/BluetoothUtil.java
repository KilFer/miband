package com.tencent.mm.sdk.platformtools;

import android.media.AudioManager;
import android.os.Build.VERSION;

public class BluetoothUtil
{
  public static boolean startBluetooth(AudioManager paramAudioManager)
  {
    if (Integer.valueOf(Build.VERSION.SDK).intValue() >= 8)
    {
      if ((!paramAudioManager.isBluetoothScoAvailableOffCall()) || (PhoneStatusWatcher.isCalling()))
        return false;
      paramAudioManager.startBluetoothSco();
      paramAudioManager.setBluetoothScoOn(true);
      return true;
    }
    return false;
  }

  public static void stopBluetooth(AudioManager paramAudioManager)
  {
    if ((Integer.valueOf(Build.VERSION.SDK).intValue() >= 8) && (!PhoneStatusWatcher.isCalling()))
      paramAudioManager.stopBluetoothSco();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BluetoothUtil
 * JD-Core Version:    0.6.2
 */