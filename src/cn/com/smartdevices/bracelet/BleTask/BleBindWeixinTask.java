package cn.com.smartdevices.bracelet.BleTask;

public class BleBindWeixinTask extends BleTask
{
  public BleBindWeixinTask(BleCallBack paramBleCallBack)
  {
    super(paramBleCallBack);
  }

  // ERROR //
  public void doWork(BleCallBack paramBleCallBack)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: ifnull +7 -> 10
    //   6: aload_1
    //   7: invokevirtual 17	cn/com/smartdevices/bracelet/BleTask/BleCallBack:sendOnStartMessage	()V
    //   10: aload_0
    //   11: getfield 21	cn/com/smartdevices/bracelet/BleTask/BleBindWeixinTask:gattPeripheral	Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;
    //   14: invokevirtual 27	com/xiaomi/hm/bleservice/profile/MiLiProfile:getDeviceInfo	()Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$DeviceInfo;
    //   17: astore_3
    //   18: aload_3
    //   19: ifnonnull +15 -> 34
    //   22: aload_1
    //   23: ifnull +11 -> 34
    //   26: aload_1
    //   27: iconst_0
    //   28: invokestatic 33	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: invokevirtual 37	cn/com/smartdevices/bracelet/BleTask/BleCallBack:sendOnFinishMessage	(Ljava/lang/Object;)V
    //   34: new 39	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 41
    //   40: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: aload_3
    //   44: getfield 50	com/xiaomi/hm/bleservice/profile/IMiLiProfile$DeviceInfo:deviceID	Ljava/lang/String;
    //   47: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore 4
    //   55: ldc 60
    //   57: invokestatic 66	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   60: aload 4
    //   62: invokevirtual 72	java/lang/String:getBytes	()[B
    //   65: invokevirtual 76	java/security/MessageDigest:digest	([B)[B
    //   68: astore 7
    //   70: aload_0
    //   71: getfield 21	cn/com/smartdevices/bracelet/BleTask/BleBindWeixinTask:gattPeripheral	Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;
    //   74: aload 7
    //   76: invokevirtual 80	com/xiaomi/hm/bleservice/profile/MiLiProfile:_wirteMD5	([B)Z
    //   79: istore 8
    //   81: iload 8
    //   83: istore 6
    //   85: new 39	java/lang/StringBuilder
    //   88: dup
    //   89: aload 7
    //   91: arraylength
    //   92: iconst_1
    //   93: ishl
    //   94: invokespecial 83	java/lang/StringBuilder:<init>	(I)V
    //   97: astore 9
    //   99: aload 7
    //   101: arraylength
    //   102: istore 10
    //   104: iload_2
    //   105: iload 10
    //   107: if_icmplt +53 -> 160
    //   110: getstatic 86	cn/com/smartdevices/bracelet/BleTask/BleBindWeixinTask:TAG	Ljava/lang/String;
    //   113: new 39	java/lang/StringBuilder
    //   116: dup
    //   117: ldc 88
    //   119: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload 4
    //   124: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 90
    //   129: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 9
    //   134: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 96	cn/com/smartdevices/bracelet/Debug:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_1
    //   147: ifnull +12 -> 159
    //   150: aload_1
    //   151: iload 6
    //   153: invokestatic 33	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   156: invokevirtual 37	cn/com/smartdevices/bracelet/BleTask/BleCallBack:sendOnFinishMessage	(Ljava/lang/Object;)V
    //   159: return
    //   160: aload 7
    //   162: iload_2
    //   163: baload
    //   164: istore 11
    //   166: iload 11
    //   168: sipush 255
    //   171: iand
    //   172: bipush 16
    //   174: if_icmpge +11 -> 185
    //   177: aload 9
    //   179: ldc 98
    //   181: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 9
    //   187: iload 11
    //   189: sipush 255
    //   192: iand
    //   193: invokestatic 104	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   196: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: iinc 2 1
    //   203: goto -99 -> 104
    //   206: astore 5
    //   208: iconst_0
    //   209: istore 6
    //   211: aload 5
    //   213: invokevirtual 107	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   216: goto -70 -> 146
    //   219: astore 5
    //   221: goto -10 -> 211
    //
    // Exception table:
    //   from	to	target	type
    //   55	81	206	java/security/NoSuchAlgorithmException
    //   85	104	219	java/security/NoSuchAlgorithmException
    //   110	146	219	java/security/NoSuchAlgorithmException
    //   160	166	219	java/security/NoSuchAlgorithmException
    //   177	185	219	java/security/NoSuchAlgorithmException
    //   185	200	219	java/security/NoSuchAlgorithmException
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleBindWeixinTask
 * JD-Core Version:    0.6.2
 */