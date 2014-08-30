package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.xiaomi.hm.bleservice.util.Debug;
import com.xiaomi.hm.bleservice.util.Helper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

abstract class AbsGattCallback extends BluetoothGattCallback
  implements IGattCallback
{
  private static final String CALLBACK_QUEUE_THREAD_NAME;
  private static final String CLASS_NAME = AbsGattCallback.class.getSimpleName();
  private static final long GATT_OPERATION_TIMEOUT = 30L;
  private static final String GATT_QUEUE_THREAD_NAME = CLASS_NAME + "*";
  private static final ReentrantLock c_GattOperationLock;
  private static final Handler c_GattQueue = new Handler(c_GattQueueThread.getLooper());
  private static final HandlerThread c_GattQueueThread;
  private static int c_RSSI;
  private static final Object c_RSSILock;
  private static int c_RSSIStatus;
  private static int c_ReturnValue;
  private static final Condition c_condGattOperationComplete;
  private static boolean c_isGattOperationLocking;
  private static boolean c_isRSSILocking;
  private final Context m_Context;
  private final BluetoothDevice m_Device;
  private final ExecutorService m_Executor = Executors.newSingleThreadExecutor(new AbsGattCallback.1(this));
  private BluetoothGatt m_Gatt = null;
  private final Map<BluetoothGattCharacteristic, IGattCallback.INotifyCallback> m_NotifyCBs = new HashMap();
  private IGattCallback.STATE m_State = IGattCallback.STATE.DISCONNECTED;
  private Field m_field_BluetoothGatt_mClientIf = null;
  private boolean m_isClean = true;

  static
  {
    CALLBACK_QUEUE_THREAD_NAME = CLASS_NAME;
    ReentrantLock localReentrantLock = new ReentrantLock();
    c_GattOperationLock = localReentrantLock;
    c_condGattOperationComplete = localReentrantLock.newCondition();
    c_isGattOperationLocking = false;
    c_ReturnValue = 65534;
    c_RSSILock = new Object();
    c_isRSSILocking = false;
    c_RSSI = 0;
    c_RSSIStatus = 65534;
    Debug.TRACE();
    c_GattQueueThread = new HandlerThread(GATT_QUEUE_THREAD_NAME);
    Debug.INFO("********************************");
    Debug.INFO("NEW THREAD: " + GATT_QUEUE_THREAD_NAME);
    Debug.INFO("********************************");
    c_GattQueueThread.setUncaughtExceptionHandler(new AbsGattCallback.2());
    c_GattQueueThread.start();
  }

  protected AbsGattCallback(Context paramContext, BluetoothDevice paramBluetoothDevice)
  {
    Debug.TRACE();
    this.m_Context = paramContext;
    this.m_Device = paramBluetoothDevice;
  }

  private static boolean isConnected(BluetoothGatt paramBluetoothGatt)
  {
    return paramBluetoothGatt != null;
  }

  // ERROR //
  private void printClientIf(BluetoothGatt paramBluetoothGatt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 181	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:m_field_BluetoothGatt_mClientIf	Ljava/lang/reflect/Field;
    //   4: ifnonnull +22 -> 26
    //   7: aload_0
    //   8: ldc 209
    //   10: ldc 211
    //   12: invokevirtual 215	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   15: putfield 181	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:m_field_BluetoothGatt_mClientIf	Ljava/lang/reflect/Field;
    //   18: aload_0
    //   19: getfield 181	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:m_field_BluetoothGatt_mClientIf	Ljava/lang/reflect/Field;
    //   22: iconst_1
    //   23: invokevirtual 220	java/lang/reflect/Field:setAccessible	(Z)V
    //   26: aload_0
    //   27: getfield 181	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:m_field_BluetoothGatt_mClientIf	Ljava/lang/reflect/Field;
    //   30: aload_1
    //   31: invokevirtual 224	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   34: istore 4
    //   36: new 59	java/lang/StringBuilder
    //   39: dup
    //   40: ldc 226
    //   42: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: iload 4
    //   47: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 232	com/xiaomi/hm/bleservice/util/Debug:DEBUG	(Ljava/lang/String;)V
    //   56: return
    //   57: astore 5
    //   59: aload 5
    //   61: invokevirtual 235	java/lang/NoSuchFieldException:printStackTrace	()V
    //   64: goto -38 -> 26
    //   67: astore_3
    //   68: aload_3
    //   69: invokevirtual 236	java/lang/IllegalAccessException:printStackTrace	()V
    //   72: return
    //   73: astore_2
    //   74: aload_2
    //   75: invokevirtual 237	java/lang/IllegalArgumentException:printStackTrace	()V
    //   78: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	26	57	java/lang/NoSuchFieldException
    //   26	56	67	java/lang/IllegalAccessException
    //   26	56	73	java/lang/IllegalArgumentException
  }

  // ERROR //
  private static int synchronizedReadCharacteristic(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 115	com/xiaomi/hm/bleservice/util/Debug:TRACE	()V
    //   6: new 59	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 243
    //   12: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: ldc 248
    //   21: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 232	com/xiaomi/hm/bleservice/util/Debug:DEBUG	(Ljava/lang/String;)V
    //   34: aload_0
    //   35: invokestatic 252	com/xiaomi/hm/bleservice/util/Debug:ASSERT_NOT_NULL	(Ljava/lang/Object;)V
    //   38: aload_1
    //   39: invokestatic 252	com/xiaomi/hm/bleservice/util/Debug:ASSERT_NOT_NULL	(Ljava/lang/Object;)V
    //   42: new 254	com/xiaomi/hm/bleservice/gatt/AbsGattCallback$16
    //   45: dup
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 257	com/xiaomi/hm/bleservice/gatt/AbsGattCallback$16:<init>	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;)V
    //   51: astore_3
    //   52: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   55: invokevirtual 260	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   58: iconst_1
    //   59: putstatic 96	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isGattOperationLocking	Z
    //   62: getstatic 148	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattQueue	Landroid/os/Handler;
    //   65: aload_3
    //   66: invokevirtual 264	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   69: pop
    //   70: getstatic 96	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isGattOperationLocking	Z
    //   73: istore 8
    //   75: iload 8
    //   77: ifne +20 -> 97
    //   80: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   83: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   86: getstatic 99	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_ReturnValue	I
    //   89: istore 6
    //   91: ldc 2
    //   93: monitorexit
    //   94: iload 6
    //   96: ireturn
    //   97: aload_0
    //   98: invokestatic 269	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:isConnected	(Landroid/bluetooth/BluetoothGatt;)Z
    //   101: ifeq +147 -> 248
    //   104: new 59	java/lang/StringBuilder
    //   107: dup
    //   108: ldc_w 271
    //   111: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload_1
    //   115: invokevirtual 277	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   118: invokestatic 283	com/xiaomi/hm/bleservice/util/Helper:parseUUID	(Ljava/util/UUID;)Ljava/lang/String;
    //   121: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   130: getstatic 94	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_condGattOperationComplete	Ljava/util/concurrent/locks/Condition;
    //   133: ldc2_w 12
    //   136: getstatic 292	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   139: invokeinterface 298 4 0
    //   144: pop
    //   145: getstatic 96	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isGattOperationLocking	Z
    //   148: ifeq +60 -> 208
    //   151: ldc_w 300
    //   154: invokestatic 303	com/xiaomi/hm/bleservice/util/Debug:WARN	(Ljava/lang/String;)V
    //   157: new 59	java/lang/StringBuilder
    //   160: dup
    //   161: ldc_w 305
    //   164: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload_1
    //   168: invokevirtual 277	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   171: invokestatic 283	com/xiaomi/hm/bleservice/util/Helper:parseUUID	(Ljava/util/UUID;)Ljava/lang/String;
    //   174: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   183: goto -103 -> 80
    //   186: astore 5
    //   188: aload 5
    //   190: invokevirtual 306	java/lang/InterruptedException:printStackTrace	()V
    //   193: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   196: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   199: goto -113 -> 86
    //   202: astore_2
    //   203: ldc 2
    //   205: monitorexit
    //   206: aload_2
    //   207: athrow
    //   208: new 59	java/lang/StringBuilder
    //   211: dup
    //   212: ldc_w 305
    //   215: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   218: aload_1
    //   219: invokevirtual 277	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   222: invokestatic 283	com/xiaomi/hm/bleservice/util/Helper:parseUUID	(Ljava/util/UUID;)Ljava/lang/String;
    //   225: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   234: goto -164 -> 70
    //   237: astore 4
    //   239: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   242: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   245: aload 4
    //   247: athrow
    //   248: ldc_w 308
    //   251: invokestatic 303	com/xiaomi/hm/bleservice/util/Debug:WARN	(Ljava/lang/String;)V
    //   254: goto -174 -> 80
    //
    // Exception table:
    //   from	to	target	type
    //   58	70	186	java/lang/InterruptedException
    //   70	75	186	java/lang/InterruptedException
    //   97	183	186	java/lang/InterruptedException
    //   208	234	186	java/lang/InterruptedException
    //   248	254	186	java/lang/InterruptedException
    //   3	58	202	finally
    //   80	86	202	finally
    //   86	91	202	finally
    //   193	199	202	finally
    //   239	248	202	finally
    //   58	70	237	finally
    //   70	75	237	finally
    //   97	183	237	finally
    //   188	193	237	finally
    //   208	234	237	finally
    //   248	254	237	finally
  }

  // ERROR //
  private static int synchronizedReadDescriptor(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 115	com/xiaomi/hm/bleservice/util/Debug:TRACE	()V
    //   6: new 59	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 243
    //   12: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: ldc 248
    //   21: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 232	com/xiaomi/hm/bleservice/util/Debug:DEBUG	(Ljava/lang/String;)V
    //   34: aload_0
    //   35: invokestatic 252	com/xiaomi/hm/bleservice/util/Debug:ASSERT_NOT_NULL	(Ljava/lang/Object;)V
    //   38: aload_1
    //   39: invokestatic 252	com/xiaomi/hm/bleservice/util/Debug:ASSERT_NOT_NULL	(Ljava/lang/Object;)V
    //   42: new 312	com/xiaomi/hm/bleservice/gatt/AbsGattCallback$18
    //   45: dup
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 315	com/xiaomi/hm/bleservice/gatt/AbsGattCallback$18:<init>	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattDescriptor;)V
    //   51: astore_3
    //   52: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   55: invokevirtual 260	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   58: iconst_1
    //   59: putstatic 96	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isGattOperationLocking	Z
    //   62: getstatic 148	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattQueue	Landroid/os/Handler;
    //   65: aload_3
    //   66: invokevirtual 264	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   69: pop
    //   70: getstatic 96	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isGattOperationLocking	Z
    //   73: istore 8
    //   75: iload 8
    //   77: ifne +20 -> 97
    //   80: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   83: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   86: getstatic 99	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_ReturnValue	I
    //   89: istore 6
    //   91: ldc 2
    //   93: monitorexit
    //   94: iload 6
    //   96: ireturn
    //   97: aload_0
    //   98: invokestatic 269	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:isConnected	(Landroid/bluetooth/BluetoothGatt;)Z
    //   101: ifeq +147 -> 248
    //   104: new 59	java/lang/StringBuilder
    //   107: dup
    //   108: ldc_w 317
    //   111: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload_1
    //   115: invokevirtual 320	android/bluetooth/BluetoothGattDescriptor:getUuid	()Ljava/util/UUID;
    //   118: invokestatic 283	com/xiaomi/hm/bleservice/util/Helper:parseUUID	(Ljava/util/UUID;)Ljava/lang/String;
    //   121: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   130: getstatic 94	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_condGattOperationComplete	Ljava/util/concurrent/locks/Condition;
    //   133: ldc2_w 12
    //   136: getstatic 292	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   139: invokeinterface 298 4 0
    //   144: pop
    //   145: getstatic 96	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isGattOperationLocking	Z
    //   148: ifeq +60 -> 208
    //   151: ldc_w 300
    //   154: invokestatic 303	com/xiaomi/hm/bleservice/util/Debug:WARN	(Ljava/lang/String;)V
    //   157: new 59	java/lang/StringBuilder
    //   160: dup
    //   161: ldc_w 322
    //   164: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload_1
    //   168: invokevirtual 320	android/bluetooth/BluetoothGattDescriptor:getUuid	()Ljava/util/UUID;
    //   171: invokestatic 283	com/xiaomi/hm/bleservice/util/Helper:parseUUID	(Ljava/util/UUID;)Ljava/lang/String;
    //   174: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   183: goto -103 -> 80
    //   186: astore 5
    //   188: aload 5
    //   190: invokevirtual 306	java/lang/InterruptedException:printStackTrace	()V
    //   193: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   196: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   199: goto -113 -> 86
    //   202: astore_2
    //   203: ldc 2
    //   205: monitorexit
    //   206: aload_2
    //   207: athrow
    //   208: new 59	java/lang/StringBuilder
    //   211: dup
    //   212: ldc_w 322
    //   215: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   218: aload_1
    //   219: invokevirtual 320	android/bluetooth/BluetoothGattDescriptor:getUuid	()Ljava/util/UUID;
    //   222: invokestatic 283	com/xiaomi/hm/bleservice/util/Helper:parseUUID	(Ljava/util/UUID;)Ljava/lang/String;
    //   225: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   234: goto -164 -> 70
    //   237: astore 4
    //   239: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   242: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   245: aload 4
    //   247: athrow
    //   248: ldc_w 308
    //   251: invokestatic 303	com/xiaomi/hm/bleservice/util/Debug:WARN	(Ljava/lang/String;)V
    //   254: goto -174 -> 80
    //
    // Exception table:
    //   from	to	target	type
    //   58	70	186	java/lang/InterruptedException
    //   70	75	186	java/lang/InterruptedException
    //   97	183	186	java/lang/InterruptedException
    //   208	234	186	java/lang/InterruptedException
    //   248	254	186	java/lang/InterruptedException
    //   3	58	202	finally
    //   80	86	202	finally
    //   86	91	202	finally
    //   193	199	202	finally
    //   239	248	202	finally
    //   58	70	237	finally
    //   70	75	237	finally
    //   97	183	237	finally
    //   188	193	237	finally
    //   208	234	237	finally
    //   248	254	237	finally
  }

  // ERROR //
  private static int synchronizedWriteCharacteristic(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 115	com/xiaomi/hm/bleservice/util/Debug:TRACE	()V
    //   6: new 59	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 243
    //   12: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: ldc 248
    //   21: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: ldc_w 326
    //   31: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 232	com/xiaomi/hm/bleservice/util/Debug:DEBUG	(Ljava/lang/String;)V
    //   44: aload_0
    //   45: invokestatic 252	com/xiaomi/hm/bleservice/util/Debug:ASSERT_NOT_NULL	(Ljava/lang/Object;)V
    //   48: aload_1
    //   49: invokestatic 252	com/xiaomi/hm/bleservice/util/Debug:ASSERT_NOT_NULL	(Ljava/lang/Object;)V
    //   52: aload_2
    //   53: invokestatic 252	com/xiaomi/hm/bleservice/util/Debug:ASSERT_NOT_NULL	(Ljava/lang/Object;)V
    //   56: new 328	com/xiaomi/hm/bleservice/gatt/AbsGattCallback$17
    //   59: dup
    //   60: aload_0
    //   61: aload_1
    //   62: aload_2
    //   63: invokespecial 331	com/xiaomi/hm/bleservice/gatt/AbsGattCallback$17:<init>	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;[B)V
    //   66: astore 4
    //   68: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   71: invokevirtual 260	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   74: iconst_1
    //   75: putstatic 96	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isGattOperationLocking	Z
    //   78: getstatic 148	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattQueue	Landroid/os/Handler;
    //   81: aload 4
    //   83: invokevirtual 264	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   86: pop
    //   87: getstatic 96	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isGattOperationLocking	Z
    //   90: istore 9
    //   92: iload 9
    //   94: ifne +20 -> 114
    //   97: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   100: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   103: getstatic 99	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_ReturnValue	I
    //   106: istore 7
    //   108: ldc 2
    //   110: monitorexit
    //   111: iload 7
    //   113: ireturn
    //   114: aload_0
    //   115: invokestatic 269	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:isConnected	(Landroid/bluetooth/BluetoothGatt;)Z
    //   118: ifeq +147 -> 265
    //   121: new 59	java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w 333
    //   128: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload_1
    //   132: invokevirtual 277	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   135: invokestatic 283	com/xiaomi/hm/bleservice/util/Helper:parseUUID	(Ljava/util/UUID;)Ljava/lang/String;
    //   138: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   147: getstatic 94	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_condGattOperationComplete	Ljava/util/concurrent/locks/Condition;
    //   150: ldc2_w 12
    //   153: getstatic 292	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   156: invokeinterface 298 4 0
    //   161: pop
    //   162: getstatic 96	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isGattOperationLocking	Z
    //   165: ifeq +60 -> 225
    //   168: ldc_w 300
    //   171: invokestatic 303	com/xiaomi/hm/bleservice/util/Debug:WARN	(Ljava/lang/String;)V
    //   174: new 59	java/lang/StringBuilder
    //   177: dup
    //   178: ldc_w 335
    //   181: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload_1
    //   185: invokevirtual 277	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   188: invokestatic 283	com/xiaomi/hm/bleservice/util/Helper:parseUUID	(Ljava/util/UUID;)Ljava/lang/String;
    //   191: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   200: goto -103 -> 97
    //   203: astore 6
    //   205: aload 6
    //   207: invokevirtual 306	java/lang/InterruptedException:printStackTrace	()V
    //   210: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   213: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   216: goto -113 -> 103
    //   219: astore_3
    //   220: ldc 2
    //   222: monitorexit
    //   223: aload_3
    //   224: athrow
    //   225: new 59	java/lang/StringBuilder
    //   228: dup
    //   229: ldc_w 335
    //   232: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   235: aload_1
    //   236: invokevirtual 277	android/bluetooth/BluetoothGattCharacteristic:getUuid	()Ljava/util/UUID;
    //   239: invokestatic 283	com/xiaomi/hm/bleservice/util/Helper:parseUUID	(Ljava/util/UUID;)Ljava/lang/String;
    //   242: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   251: goto -164 -> 87
    //   254: astore 5
    //   256: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   259: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   262: aload 5
    //   264: athrow
    //   265: ldc_w 308
    //   268: invokestatic 303	com/xiaomi/hm/bleservice/util/Debug:WARN	(Ljava/lang/String;)V
    //   271: goto -174 -> 97
    //
    // Exception table:
    //   from	to	target	type
    //   74	87	203	java/lang/InterruptedException
    //   87	92	203	java/lang/InterruptedException
    //   114	200	203	java/lang/InterruptedException
    //   225	251	203	java/lang/InterruptedException
    //   265	271	203	java/lang/InterruptedException
    //   3	74	219	finally
    //   97	103	219	finally
    //   103	108	219	finally
    //   210	216	219	finally
    //   256	265	219	finally
    //   74	87	254	finally
    //   87	92	254	finally
    //   114	200	254	finally
    //   205	210	254	finally
    //   225	251	254	finally
    //   265	271	254	finally
  }

  // ERROR //
  private static int synchronizedWriteDescriptor(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 115	com/xiaomi/hm/bleservice/util/Debug:TRACE	()V
    //   6: new 59	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 243
    //   12: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: ldc 248
    //   21: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: ldc_w 326
    //   31: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 232	com/xiaomi/hm/bleservice/util/Debug:DEBUG	(Ljava/lang/String;)V
    //   44: aload_0
    //   45: invokestatic 252	com/xiaomi/hm/bleservice/util/Debug:ASSERT_NOT_NULL	(Ljava/lang/Object;)V
    //   48: aload_1
    //   49: invokestatic 252	com/xiaomi/hm/bleservice/util/Debug:ASSERT_NOT_NULL	(Ljava/lang/Object;)V
    //   52: aload_2
    //   53: invokestatic 252	com/xiaomi/hm/bleservice/util/Debug:ASSERT_NOT_NULL	(Ljava/lang/Object;)V
    //   56: new 339	com/xiaomi/hm/bleservice/gatt/AbsGattCallback$19
    //   59: dup
    //   60: aload_0
    //   61: aload_1
    //   62: aload_2
    //   63: invokespecial 342	com/xiaomi/hm/bleservice/gatt/AbsGattCallback$19:<init>	(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattDescriptor;[B)V
    //   66: astore 4
    //   68: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   71: invokevirtual 260	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   74: iconst_1
    //   75: putstatic 96	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isGattOperationLocking	Z
    //   78: getstatic 148	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattQueue	Landroid/os/Handler;
    //   81: aload 4
    //   83: invokevirtual 264	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   86: pop
    //   87: getstatic 96	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isGattOperationLocking	Z
    //   90: istore 9
    //   92: iload 9
    //   94: ifne +20 -> 114
    //   97: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   100: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   103: getstatic 99	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_ReturnValue	I
    //   106: istore 7
    //   108: ldc 2
    //   110: monitorexit
    //   111: iload 7
    //   113: ireturn
    //   114: aload_0
    //   115: invokestatic 269	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:isConnected	(Landroid/bluetooth/BluetoothGatt;)Z
    //   118: ifeq +147 -> 265
    //   121: new 59	java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w 344
    //   128: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload_1
    //   132: invokevirtual 320	android/bluetooth/BluetoothGattDescriptor:getUuid	()Ljava/util/UUID;
    //   135: invokestatic 283	com/xiaomi/hm/bleservice/util/Helper:parseUUID	(Ljava/util/UUID;)Ljava/lang/String;
    //   138: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   147: getstatic 94	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_condGattOperationComplete	Ljava/util/concurrent/locks/Condition;
    //   150: ldc2_w 12
    //   153: getstatic 292	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   156: invokeinterface 298 4 0
    //   161: pop
    //   162: getstatic 96	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isGattOperationLocking	Z
    //   165: ifeq +60 -> 225
    //   168: ldc_w 300
    //   171: invokestatic 303	com/xiaomi/hm/bleservice/util/Debug:WARN	(Ljava/lang/String;)V
    //   174: new 59	java/lang/StringBuilder
    //   177: dup
    //   178: ldc_w 346
    //   181: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload_1
    //   185: invokevirtual 320	android/bluetooth/BluetoothGattDescriptor:getUuid	()Ljava/util/UUID;
    //   188: invokestatic 283	com/xiaomi/hm/bleservice/util/Helper:parseUUID	(Ljava/util/UUID;)Ljava/lang/String;
    //   191: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   200: goto -103 -> 97
    //   203: astore 6
    //   205: aload 6
    //   207: invokevirtual 306	java/lang/InterruptedException:printStackTrace	()V
    //   210: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   213: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   216: goto -113 -> 103
    //   219: astore_3
    //   220: ldc 2
    //   222: monitorexit
    //   223: aload_3
    //   224: athrow
    //   225: new 59	java/lang/StringBuilder
    //   228: dup
    //   229: ldc_w 346
    //   232: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   235: aload_1
    //   236: invokevirtual 320	android/bluetooth/BluetoothGattDescriptor:getUuid	()Ljava/util/UUID;
    //   239: invokestatic 283	com/xiaomi/hm/bleservice/util/Helper:parseUUID	(Ljava/util/UUID;)Ljava/lang/String;
    //   242: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   251: goto -164 -> 87
    //   254: astore 5
    //   256: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   259: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   262: aload 5
    //   264: athrow
    //   265: ldc_w 308
    //   268: invokestatic 303	com/xiaomi/hm/bleservice/util/Debug:WARN	(Ljava/lang/String;)V
    //   271: goto -174 -> 97
    //
    // Exception table:
    //   from	to	target	type
    //   74	87	203	java/lang/InterruptedException
    //   87	92	203	java/lang/InterruptedException
    //   114	200	203	java/lang/InterruptedException
    //   225	251	203	java/lang/InterruptedException
    //   265	271	203	java/lang/InterruptedException
    //   3	74	219	finally
    //   97	103	219	finally
    //   103	108	219	finally
    //   210	216	219	finally
    //   256	265	219	finally
    //   74	87	254	finally
    //   87	92	254	finally
    //   114	200	254	finally
    //   205	210	254	finally
    //   225	251	254	finally
    //   265	271	254	finally
  }

  protected abstract void GattCB_onCharacteristicChanged(BluetoothGattCharacteristic paramBluetoothGattCharacteristic);

  protected abstract void GattCB_onCharacteristicRead(BluetoothGattCharacteristic paramBluetoothGattCharacteristic);

  protected abstract void GattCB_onCharacteristicWrite(BluetoothGattCharacteristic paramBluetoothGattCharacteristic);

  protected abstract void GattCB_onConnected();

  protected abstract void GattCB_onConnectionFailed();

  protected abstract void GattCB_onDescriptorRead(BluetoothGattDescriptor paramBluetoothGattDescriptor);

  protected abstract void GattCB_onDescriptorWrite(BluetoothGattDescriptor paramBluetoothGattDescriptor);

  protected abstract void GattCB_onDisconnected();

  protected abstract void GattCB_onReadRemoteRssi(int paramInt);

  protected abstract void GattCB_onServiceDiscovered();

  // ERROR //
  protected void cleanupInternal()
  {
    // Byte code:
    //   0: invokestatic 115	com/xiaomi/hm/bleservice/util/Debug:TRACE	()V
    //   3: new 59	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 361
    //   10: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 172	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:m_State	Lcom/xiaomi/hm/bleservice/gatt/IGattCallback$STATE;
    //   17: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 232	com/xiaomi/hm/bleservice/util/Debug:DEBUG	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 172	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:m_State	Lcom/xiaomi/hm/bleservice/gatt/IGattCallback$STATE;
    //   30: getstatic 170	com/xiaomi/hm/bleservice/gatt/IGattCallback$STATE:DISCONNECTED	Lcom/xiaomi/hm/bleservice/gatt/IGattCallback$STATE;
    //   33: if_acmpeq +27 -> 60
    //   36: new 59	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 363
    //   43: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 172	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:m_State	Lcom/xiaomi/hm/bleservice/gatt/IGattCallback$STATE;
    //   50: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 303	com/xiaomi/hm/bleservice/util/Debug:WARN	(Ljava/lang/String;)V
    //   59: return
    //   60: aload_0
    //   61: getfield 177	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:m_NotifyCBs	Ljava/util/Map;
    //   64: invokeinterface 368 1 0
    //   69: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   72: invokevirtual 260	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   75: iconst_0
    //   76: putstatic 96	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isGattOperationLocking	Z
    //   79: ldc 97
    //   81: putstatic 99	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_ReturnValue	I
    //   84: ldc_w 370
    //   87: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   90: getstatic 94	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_condGattOperationComplete	Ljava/util/concurrent/locks/Condition;
    //   93: invokeinterface 373 1 0
    //   98: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   101: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   104: getstatic 104	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_RSSILock	Ljava/lang/Object;
    //   107: astore_2
    //   108: aload_2
    //   109: monitorenter
    //   110: iconst_0
    //   111: putstatic 106	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_isRSSILocking	Z
    //   114: iconst_0
    //   115: putstatic 108	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_RSSI	I
    //   118: ldc 97
    //   120: putstatic 110	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_RSSIStatus	I
    //   123: ldc_w 375
    //   126: invokestatic 286	com/xiaomi/hm/bleservice/util/Debug:DEBUG_LOCK	(Ljava/lang/String;)V
    //   129: getstatic 104	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_RSSILock	Ljava/lang/Object;
    //   132: invokevirtual 378	java/lang/Object:notifyAll	()V
    //   135: aload_2
    //   136: monitorexit
    //   137: aload_0
    //   138: getfield 165	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:m_Gatt	Landroid/bluetooth/BluetoothGatt;
    //   141: invokevirtual 381	android/bluetooth/BluetoothGatt:close	()V
    //   144: aload_0
    //   145: aconst_null
    //   146: putfield 165	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:m_Gatt	Landroid/bluetooth/BluetoothGatt;
    //   149: aload_0
    //   150: iconst_1
    //   151: putfield 179	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:m_isClean	Z
    //   154: return
    //   155: astore_1
    //   156: getstatic 88	com/xiaomi/hm/bleservice/gatt/AbsGattCallback:c_GattOperationLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   159: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   162: aload_1
    //   163: athrow
    //   164: astore_3
    //   165: aload_2
    //   166: monitorexit
    //   167: aload_3
    //   168: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   75	98	155	finally
    //   110	137	164	finally
  }

  public final void connect()
  {
    Debug.TRACE();
    this.m_Executor.execute(new AbsGattCallback.3(this));
  }

  protected void connectInternal()
  {
    Debug.TRACE();
    Debug.DEBUG("m_State: " + this.m_State);
    if (this.m_State != IGattCallback.STATE.DISCONNECTED)
      Debug.WARN("Illegal state: m_State = " + this.m_State);
    this.m_State = IGattCallback.STATE.CONNECTING;
    if (this.m_Gatt != null)
      Debug.DEBUG("connect back...");
    this.m_isClean = false;
    this.m_Gatt = this.m_Device.connectGatt(this.m_Context, false, this);
    Debug.ASSERT_NOT_NULL(this.m_Gatt);
  }

  public final void disconnect()
  {
    Debug.TRACE();
    this.m_Executor.execute(new AbsGattCallback.4(this));
  }

  protected void disconnectInternal()
  {
    Debug.TRACE();
    Debug.DEBUG("m_State: " + this.m_State);
    if ((this.m_State != IGattCallback.STATE.CONNECTING) && (this.m_State != IGattCallback.STATE.CONNECTED))
    {
      Debug.WARN("Illegal state: m_State != STATE_CONNECTING && m_State != STATE_CONNECTED");
      return;
    }
    Debug.ASSERT_NOT_NULL(this.m_Gatt);
    this.m_State = IGattCallback.STATE.DISCONNECTING;
    this.m_Gatt.disconnect();
  }

  public final BluetoothDevice getDevice()
  {
    return this.m_Device;
  }

  protected final BluetoothGatt getGatt()
  {
    return this.m_Gatt;
  }

  public final BluetoothGattService getService(UUID paramUUID)
  {
    Debug.TRACE();
    Debug.ASSERT_NOT_NULL(this.m_Gatt);
    if (this.m_Gatt == null)
      return null;
    return this.m_Gatt.getService(paramUUID);
  }

  public final List<BluetoothGattService> getServices()
  {
    Debug.TRACE();
    Debug.ASSERT_NOT_NULL(this.m_Gatt);
    if (this.m_Gatt == null)
      return null;
    return this.m_Gatt.getServices();
  }

  public final IGattCallback.STATE getState()
  {
    return this.m_State;
  }

  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    Debug.TRACE();
    if (this.m_Gatt == paramBluetoothGatt);
    for (boolean bool = true; ; bool = false)
    {
      Debug.ASSERT_TRUE(bool);
      byte[] arrayOfByte = paramBluetoothGattCharacteristic.getValue();
      Debug.DEBUG("Characteristic Changed: " + Helper.bytesToHexString(arrayOfByte));
      IGattCallback.INotifyCallback localINotifyCallback = (IGattCallback.INotifyCallback)this.m_NotifyCBs.get(paramBluetoothGattCharacteristic);
      Debug.ASSERT_NOT_NULL(localINotifyCallback);
      this.m_Executor.execute(new AbsGattCallback.11(this, localINotifyCallback, arrayOfByte));
      this.m_Executor.execute(new AbsGattCallback.12(this, paramBluetoothGattCharacteristic));
      return;
    }
  }

  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    boolean bool1 = true;
    Debug.TRACE();
    boolean bool2;
    if (paramInt == 0)
      bool2 = bool1;
    while (true)
    {
      Debug.ASSERT_TRUE(bool2);
      if (this.m_Gatt == paramBluetoothGatt)
      {
        Debug.ASSERT_TRUE(bool1);
        Debug.DEBUG("Characteristic Read: " + Helper.bytesToHexString(paramBluetoothGattCharacteristic.getValue()));
        c_GattOperationLock.lock();
      }
      try
      {
        c_ReturnValue = paramInt;
        Debug.DEBUG_LOCK("NOTIFY: onCharacteristicRead(): " + c_ReturnValue);
        c_isGattOperationLocking = false;
        c_condGattOperationComplete.signal();
        c_GattOperationLock.unlock();
        if (paramInt == 0);
        return;
        bool2 = false;
        continue;
        bool1 = false;
      }
      finally
      {
        c_GattOperationLock.unlock();
      }
    }
  }

  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    boolean bool1 = true;
    Debug.TRACE();
    boolean bool2;
    if (paramInt == 0)
      bool2 = bool1;
    while (true)
    {
      Debug.ASSERT_TRUE(bool2);
      if (this.m_Gatt == paramBluetoothGatt)
      {
        Debug.ASSERT_TRUE(bool1);
        Debug.DEBUG("Characteristic Write: " + Helper.bytesToHexString(paramBluetoothGattCharacteristic.getValue()));
        c_GattOperationLock.lock();
      }
      try
      {
        c_ReturnValue = paramInt;
        Debug.DEBUG_LOCK("NOTIFY: onCharacteristicWrite(): " + c_ReturnValue);
        c_isGattOperationLocking = false;
        c_condGattOperationComplete.signal();
        c_GattOperationLock.unlock();
        if (paramInt == 0);
        return;
        bool2 = false;
        continue;
        bool1 = false;
      }
      finally
      {
        c_GattOperationLock.unlock();
      }
    }
  }

  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    Debug.TRACE();
    boolean bool;
    label10: Object localObject3;
    label101: StringBuilder localStringBuilder4;
    if (paramInt1 == 0)
    {
      bool = true;
      Debug.ASSERT_TRUE(bool);
      if (this.m_Gatt != paramBluetoothGatt)
      {
        Debug.WARN("m_Gatt: " + this.m_Gatt);
        Debug.WARN("  gatt: " + paramBluetoothGatt);
        if (this.m_Gatt != null)
        {
          StringBuilder localStringBuilder3 = new StringBuilder("m_Gatt.getDevice(): ");
          if (this.m_Gatt == null)
            break label217;
          localObject3 = this.m_Gatt.getDevice();
          Debug.WARN(localObject3);
          printClientIf(this.m_Gatt);
        }
        if (paramBluetoothGatt != null)
        {
          localStringBuilder4 = new StringBuilder("  gatt.getDevice(): ");
          if (paramBluetoothGatt == null)
            break label225;
        }
      }
    }
    label217: label225: for (Object localObject4 = paramBluetoothGatt.getDevice(); ; localObject4 = "")
    {
      Debug.WARN(localObject4);
      printClientIf(paramBluetoothGatt);
      this.m_Gatt = paramBluetoothGatt;
      if (paramInt1 != 0)
        break label327;
      switch (paramInt2)
      {
      case 1:
      default:
        Debug.WARN(">>> UNEXPECTED <<<");
        return;
        bool = false;
        break label10;
        localObject3 = "";
        break label101;
      case 2:
      case 0:
      }
    }
    this.m_State = IGattCallback.STATE.CONNECTED;
    Debug.INFO("=================================================");
    Debug.INFO("=================== CONNECTED ===================");
    Debug.INFO("=================================================");
    printClientIf(this.m_Gatt);
    this.m_Executor.execute(new AbsGattCallback.5(this));
    return;
    this.m_State = IGattCallback.STATE.DISCONNECTED;
    Debug.INFO("=================================================");
    Debug.INFO("================== DISCONNECTED =================");
    Debug.INFO("=================================================");
    this.m_Executor.execute(new AbsGattCallback.6(this));
    return;
    label327: if (paramInt1 != 133)
      throw new RuntimeException("status: " + paramInt1);
    Debug.WARN("m_Gatt: " + this.m_Gatt);
    Debug.WARN("  gatt: " + paramBluetoothGatt);
    Object localObject1;
    StringBuilder localStringBuilder2;
    if (this.m_Gatt != null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder("m_Gatt.getDevice(): ");
      if (this.m_Gatt != null)
      {
        localObject1 = this.m_Gatt.getDevice();
        Debug.WARN(localObject1);
        printClientIf(this.m_Gatt);
      }
    }
    else if (paramBluetoothGatt != null)
    {
      localStringBuilder2 = new StringBuilder("  gatt.getDevice(): ");
      if (paramBluetoothGatt == null)
        break label553;
    }
    label553: for (Object localObject2 = paramBluetoothGatt.getDevice(); ; localObject2 = "")
    {
      Debug.WARN(localObject2);
      printClientIf(paramBluetoothGatt);
      this.m_State = IGattCallback.STATE.DISCONNECTED;
      Debug.ERROR("=================================================");
      Debug.ERROR("=============== CONNECTION FAILED ===============");
      Debug.ERROR("=================================================");
      this.m_Executor.execute(new AbsGattCallback.7(this));
      return;
      localObject1 = "";
      break;
    }
  }

  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    boolean bool1 = true;
    Debug.TRACE();
    boolean bool2;
    if (paramInt == 0)
      bool2 = bool1;
    while (true)
    {
      Debug.ASSERT_TRUE(bool2);
      if (this.m_Gatt == paramBluetoothGatt)
      {
        Debug.ASSERT_TRUE(bool1);
        Debug.DEBUG("Descriptor Read: " + Helper.bytesToHexString(paramBluetoothGattDescriptor.getValue()));
        c_GattOperationLock.lock();
      }
      try
      {
        c_ReturnValue = paramInt;
        Debug.DEBUG_LOCK("NOTIFY: onDescriptorRead(): " + c_ReturnValue);
        c_isGattOperationLocking = false;
        c_condGattOperationComplete.signal();
        c_GattOperationLock.unlock();
        if (paramInt == 0);
        return;
        bool2 = false;
        continue;
        bool1 = false;
      }
      finally
      {
        c_GattOperationLock.unlock();
      }
    }
  }

  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    boolean bool1 = true;
    Debug.TRACE();
    boolean bool2;
    if (paramInt == 0)
      bool2 = bool1;
    while (true)
    {
      Debug.ASSERT_TRUE(bool2);
      if (this.m_Gatt == paramBluetoothGatt)
      {
        Debug.ASSERT_TRUE(bool1);
        Debug.DEBUG("Descriptor Write: " + Helper.bytesToHexString(paramBluetoothGattDescriptor.getValue()));
        c_GattOperationLock.lock();
      }
      try
      {
        c_ReturnValue = paramInt;
        Debug.DEBUG_LOCK("NOTIFY: onDescriptorWrite(): " + c_ReturnValue);
        c_isGattOperationLocking = false;
        c_condGattOperationComplete.signal();
        c_GattOperationLock.unlock();
        if (paramInt == 0);
        return;
        bool2 = false;
        continue;
        bool1 = false;
      }
      finally
      {
        c_GattOperationLock.unlock();
      }
    }
  }

  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    Debug.TRACE();
    boolean bool2;
    if (paramInt2 == 0)
      bool2 = bool1;
    while (true)
    {
      Debug.ASSERT_TRUE(bool2);
      if (this.m_Gatt == paramBluetoothGatt)
      {
        Debug.ASSERT_TRUE(bool1);
        Debug.DEBUG("RSSI: " + paramInt1);
      }
      synchronized (c_RSSILock)
      {
        c_RSSI = paramInt1;
        c_RSSIStatus = paramInt2;
        Debug.DEBUG_LOCK("NOTIFY: onReadRemoteRssi(): " + c_RSSIStatus);
        c_isRSSILocking = false;
        c_RSSILock.notify();
        if (paramInt2 == 0)
          this.m_Executor.execute(new AbsGattCallback.15(this, paramInt1));
        return;
        bool2 = false;
        continue;
        bool1 = false;
      }
    }
  }

  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    boolean bool1 = true;
    Debug.TRACE();
    boolean bool2;
    if (paramInt == 0)
    {
      bool2 = bool1;
      Debug.ASSERT_TRUE(bool2);
      if (this.m_Gatt != paramBluetoothGatt)
        break label42;
    }
    while (true)
    {
      Debug.ASSERT_TRUE(bool1);
      Debug.WARN(">>> UNEXPECTED <<<");
      return;
      bool2 = false;
      break;
      label42: bool1 = false;
    }
  }

  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    boolean bool1 = true;
    Debug.TRACE();
    boolean bool2;
    if (paramInt == 0)
    {
      bool2 = bool1;
      Debug.ASSERT_TRUE(bool2);
      if (this.m_Gatt != paramBluetoothGatt)
        break label57;
    }
    while (true)
    {
      Debug.ASSERT_TRUE(bool1);
      if (paramInt != 0)
        break label62;
      this.m_Executor.execute(new AbsGattCallback.8(this));
      return;
      bool2 = false;
      break;
      label57: bool1 = false;
    }
    label62: disconnectInternal();
  }

  public final int readCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    return synchronizedReadCharacteristic(this.m_Gatt, paramBluetoothGattCharacteristic);
  }

  public final int readRemoteRSSI()
  {
    Debug.TRACE();
    c_isRSSILocking = true;
    Debug.ASSERT_NOT_NULL(this.m_Gatt);
    if (this.m_Gatt == null)
    {
      c_isRSSILocking = false;
      return 0;
    }
    if (!this.m_Gatt.readRemoteRssi())
    {
      c_isRSSILocking = false;
      return 0;
    }
    while (true)
      try
      {
        synchronized (c_RSSILock)
        {
          boolean bool = c_isRSSILocking;
          if (!bool)
          {
            if (c_RSSIStatus == 0)
              break;
            return 0;
          }
        }
        Debug.DEBUG_LOCK("WAIT: readRemoteRSSI()");
        c_RSSILock.wait(30L);
        if (c_isRSSILocking)
        {
          Debug.WARN("GATT OPERATION TIMEOUT");
          Debug.DEBUG_LOCK("CONTINUE: readRemoteRSSI()");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
        Debug.DEBUG_LOCK("CONTINUE: readRemoteRSSI()");
      }
    int i = c_RSSI;
    return i;
  }

  public void refreshGatt()
  {
    try
    {
      BluetoothGatt.class.getDeclaredMethod("refresh", null).invoke(this.m_Gatt, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public final boolean registerNotification(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, IGattCallback.INotifyCallback paramINotifyCallback)
  {
    Debug.TRACE();
    Debug.ASSERT_NOT_NULL(paramINotifyCallback);
    this.m_NotifyCBs.put(paramBluetoothGattCharacteristic, paramINotifyCallback);
    boolean bool = this.m_Gatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, true);
    Debug.ASSERT_TRUE(bool);
    if (!bool);
    BluetoothGattDescriptor localBluetoothGattDescriptor;
    do
    {
      do
      {
        do
        {
          return false;
          localBluetoothGattDescriptor = paramBluetoothGattCharacteristic.getDescriptor(Helper.UUID_DESCRIPTOR_CLIENT_CHARACTERISTIC_CONFIGURATION);
          Debug.ASSERT_NOT_NULL(localBluetoothGattDescriptor);
        }
        while (localBluetoothGattDescriptor == null);
        if ((0x10 & paramBluetoothGattCharacteristic.getProperties()) <= 0)
          break;
      }
      while (synchronizedWriteDescriptor(this.m_Gatt, localBluetoothGattDescriptor, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) != 0);
      return true;
    }
    while (((0x20 & paramBluetoothGattCharacteristic.getProperties()) <= 0) || (synchronizedWriteDescriptor(this.m_Gatt, localBluetoothGattDescriptor, BluetoothGattDescriptor.ENABLE_INDICATION_VALUE) != 0));
    return true;
  }

  public final boolean unregisterNotification(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    Debug.TRACE();
    this.m_NotifyCBs.remove(paramBluetoothGattCharacteristic);
    if (this.m_State != IGattCallback.STATE.CONNECTED)
    {
      Debug.DEBUG("m_State != STATE_CONNECTED");
      if (this.m_Gatt != null)
      {
        Debug.DEBUG("m_Gatt != null, trying to unregister locally...");
        boolean bool2 = this.m_Gatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, false);
        Debug.ASSERT_TRUE(bool2);
        if (bool2);
      }
    }
    BluetoothGattDescriptor localBluetoothGattDescriptor;
    do
    {
      boolean bool1;
      do
      {
        return false;
        return true;
        Debug.ASSERT_NOT_NULL(this.m_Gatt);
        bool1 = this.m_Gatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, false);
        Debug.ASSERT_TRUE(bool1);
      }
      while (!bool1);
      localBluetoothGattDescriptor = paramBluetoothGattCharacteristic.getDescriptor(Helper.UUID_DESCRIPTOR_CLIENT_CHARACTERISTIC_CONFIGURATION);
      Debug.ASSERT_NOT_NULL(localBluetoothGattDescriptor);
    }
    while ((localBluetoothGattDescriptor == null) || (synchronizedWriteDescriptor(this.m_Gatt, localBluetoothGattDescriptor, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE) != 0));
    return true;
  }

  public final int writeCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte)
  {
    return synchronizedWriteCharacteristic(this.m_Gatt, paramBluetoothGattCharacteristic, paramArrayOfByte);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.AbsGattCallback
 * JD-Core Version:    0.6.2
 */