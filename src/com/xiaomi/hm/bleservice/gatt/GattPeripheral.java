package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.hm.bleservice.util.Debug;
import com.xiaomi.hm.bleservice.util.Helper;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Iterator;
import java.util.List;

public class GattPeripheral extends AbsGattCallback
  implements IGattProfile
{
  private FileLock __android_bug_FileLock = null;
  private FileOutputStream __android_bug_FileOutputStream = null;
  private boolean m_AutoReconnect = true;
  private int m_AutoReconnectCount = -1;
  private final Handler m_Messenger;

  protected GattPeripheral(Context paramContext, BluetoothDevice paramBluetoothDevice, Handler paramHandler)
  {
    super(paramContext, paramBluetoothDevice);
    Debug.TRACE();
    this.m_Messenger = paramHandler;
  }

  private void __lockFile()
  {
    Debug.TRACE();
    try
    {
      this.__android_bug_FileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory() + "/Android/.btlock");
      this.__android_bug_FileLock = this.__android_bug_FileOutputStream.getChannel().lock();
      Debug.DEBUG("FileLock: " + this.__android_bug_FileLock.isValid());
      this.__android_bug_FileOutputStream.write(1);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  private void __releaseFile()
  {
    Debug.TRACE();
    if ((this.__android_bug_FileOutputStream != null) && (this.__android_bug_FileLock != null));
    try
    {
      this.__android_bug_FileOutputStream.write(0);
      this.__android_bug_FileLock.release();
      this.__android_bug_FileOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  protected void GattCB_onCharacteristicChanged(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    Debug.TRACE();
  }

  protected void GattCB_onCharacteristicRead(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    Debug.TRACE();
  }

  protected void GattCB_onCharacteristicWrite(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    Debug.TRACE();
  }

  protected void GattCB_onConnected()
  {
    Debug.TRACE();
    this.m_Messenger.obtainMessage(0, getDevice()).sendToTarget();
    __lockFile();
    getGatt().discoverServices();
  }

  protected void GattCB_onConnectionFailed()
  {
    Debug.TRACE();
    this.m_Messenger.obtainMessage(2, getDevice()).sendToTarget();
    cleanupInternal();
  }

  protected void GattCB_onDescriptorRead(BluetoothGattDescriptor paramBluetoothGattDescriptor)
  {
    Debug.TRACE();
  }

  protected void GattCB_onDescriptorWrite(BluetoothGattDescriptor paramBluetoothGattDescriptor)
  {
    Debug.TRACE();
  }

  protected void GattCB_onDisconnected()
  {
    Debug.TRACE();
    this.m_Messenger.obtainMessage(1, getDevice()).sendToTarget();
    cleanupInternal();
  }

  protected void GattCB_onReadRemoteRssi(int paramInt)
  {
    Debug.TRACE();
  }

  protected void GattCB_onServiceDiscovered()
  {
    Debug.TRACE();
    __releaseFile();
    Iterator localIterator1 = getGatt().getServices().iterator();
    if (!localIterator1.hasNext())
    {
      boolean bool = init();
      Debug.ASSERT_TRUE(bool);
      if (!bool)
        disconnectInternal();
      return;
    }
    BluetoothGattService localBluetoothGattService = (BluetoothGattService)localIterator1.next();
    if (localBluetoothGattService.getType() == 0);
    for (String str = "Primary"; ; str = "Secondary")
    {
      Debug.DEBUG(str + " service: " + Helper.parseUUID(localBluetoothGattService.getUuid()));
      Iterator localIterator2 = localBluetoothGattService.getCharacteristics().iterator();
      while (localIterator2.hasNext())
      {
        BluetoothGattCharacteristic localBluetoothGattCharacteristic = (BluetoothGattCharacteristic)localIterator2.next();
        Debug.DEBUG("  Characteristic: " + Helper.parseUUID(localBluetoothGattCharacteristic.getUuid()));
        Debug.DEBUG("    - Properties: " + Helper.parseProperties(localBluetoothGattCharacteristic.getProperties()));
        Iterator localIterator3 = localBluetoothGattCharacteristic.getDescriptors().iterator();
        while (localIterator3.hasNext())
        {
          BluetoothGattDescriptor localBluetoothGattDescriptor = (BluetoothGattDescriptor)localIterator3.next();
          Debug.DEBUG("    Descriptor: " + Helper.parseUUID(localBluetoothGattDescriptor.getUuid()));
        }
      }
    }
  }

  public void cleanup()
  {
    Debug.TRACE();
  }

  protected void cleanupInternal()
  {
    Debug.TRACE();
    cleanup();
    super.cleanupInternal();
    if (this.m_AutoReconnect)
    {
      if (this.m_AutoReconnectCount == -1)
        break label44;
      if (this.m_AutoReconnectCount != 0);
    }
    else
    {
      return;
    }
    this.m_AutoReconnectCount = (-1 + this.m_AutoReconnectCount);
    try
    {
      label44: Debug.DEBUG("Delay 1 second before reconnect...");
      Thread.sleep(5000L);
      label55: connectInternal();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label55;
    }
  }

  protected final void connectInternal()
  {
    Debug.TRACE();
    while (true)
      try
      {
        if (BluetoothAdapter.getDefaultAdapter().getState() == 12)
          break;
        Debug.DEBUG("BluetoothAdapter enable:" + BluetoothAdapter.getDefaultAdapter().isEnabled());
        Thread.sleep(1000L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    Debug.DEBUG("BluetoothAdapter enable:" + BluetoothAdapter.getDefaultAdapter().isEnabled());
    Thread.sleep(1000L);
    Debug.DEBUG("device:");
    Debug.DEBUG("         name: " + getDevice().getName());
    Debug.DEBUG("      address: " + getDevice().getAddress());
    switch (getDevice().getBondState())
    {
    default:
      switch (getDevice().getType())
      {
      default:
      case 2:
      case 1:
      case 3:
      case 0:
      }
      break;
    case 12:
    case 11:
    case 10:
    }
    while (true)
    {
      super.connectInternal();
      return;
      Debug.DEBUG("   bond state: BONDED");
      break;
      Debug.DEBUG("   bond state: BONDING");
      break;
      Debug.DEBUG("   bond state: NONE");
      break;
      Debug.DEBUG("         type: LE");
      continue;
      Debug.DEBUG("         type: CLASSIC");
      continue;
      Debug.DEBUG("         type: DUAL");
      continue;
      Debug.DEBUG("         type: UNKNOWN");
    }
  }

  protected final void disconnectInternal()
  {
    Debug.TRACE();
    super.disconnectInternal();
  }

  public final boolean getAutoReconnect()
  {
    return this.m_AutoReconnect;
  }

  public final int getAutoReconnectCount()
  {
    return this.m_AutoReconnectCount;
  }

  public boolean init()
  {
    Debug.TRACE();
    return true;
  }

  public byte[] read(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    Debug.TRACE();
    Debug.ASSERT_NOT_NULL(paramBluetoothGattCharacteristic);
    if (paramBluetoothGattCharacteristic == null)
      return null;
    int i = readCharacteristic(paramBluetoothGattCharacteristic);
    if (i == 0);
    for (boolean bool = true; ; bool = false)
    {
      Debug.ASSERT_TRUE(bool);
      if (i != 0)
        break;
      return paramBluetoothGattCharacteristic.getValue();
    }
    return null;
  }

  public final void setAutoReconnect(boolean paramBoolean)
  {
    Debug.TRACE();
    this.m_AutoReconnect = paramBoolean;
    this.m_AutoReconnectCount = -1;
  }

  public final void setAutoReconnect(boolean paramBoolean, int paramInt)
  {
    this.m_AutoReconnect = paramBoolean;
    this.m_AutoReconnectCount = paramInt;
  }

  public boolean write(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte)
  {
    Debug.TRACE();
    Debug.ASSERT_NOT_NULL(paramBluetoothGattCharacteristic);
    Debug.ASSERT_NOT_NULL(paramArrayOfByte);
    if ((paramBluetoothGattCharacteristic == null) || (paramArrayOfByte == null))
      return false;
    int i = writeCharacteristic(paramBluetoothGattCharacteristic, paramArrayOfByte);
    if (i == 0);
    for (boolean bool = true; ; bool = false)
    {
      Debug.ASSERT_TRUE(bool);
      if (i != 0)
        break;
      return true;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.GattPeripheral
 * JD-Core Version:    0.6.2
 */