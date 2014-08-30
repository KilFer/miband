package com.tencent.weiyun;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.utils.DataConvert;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class f
{
  private static final String b = "https://graph.qq.com/weiyun/upload_photo";
  private static final String c = "https://graph.qq.com/weiyun/upload_music";
  private static final String d = "https://graph.qq.com/weiyun/upload_video";
  private static final int e = 0;
  private static final int f = 1;
  private static final int g = 2;
  private final Context h;
  private final FileManager.WeiyunFileType i;
  private final String j;
  private final IUploadFileCallBack k;
  private final Handler l;
  private long m;
  private String n;
  private String o;
  private byte[] p;
  private String q;

  public f(FileManager paramFileManager, Context paramContext, FileManager.WeiyunFileType paramWeiyunFileType, String paramString, IUploadFileCallBack paramIUploadFileCallBack)
  {
    this.h = paramContext;
    this.i = paramWeiyunFileType;
    this.j = paramString;
    this.k = paramIUploadFileCallBack;
    this.l = new g(this, this.h.getMainLooper(), paramFileManager);
  }

  private static String a(FileManager.WeiyunFileType paramWeiyunFileType)
  {
    if (paramWeiyunFileType == FileManager.WeiyunFileType.ImageFile)
      return "https://graph.qq.com/weiyun/upload_photo";
    if (paramWeiyunFileType == FileManager.WeiyunFileType.MusicFile)
      return "https://graph.qq.com/weiyun/upload_music";
    return "https://graph.qq.com/weiyun/upload_video";
  }

  private byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte, 0, paramInt1);
      this.o = DataConvert.toHexString(localMessageDigest.digest());
      localMessageDigest.reset();
      int i1 = paramInt1 + 340;
      byte[] arrayOfByte = new byte[4 + (4 + (4 + (i1 + 4)))];
      int i2 = 0 + DataConvert.putInt2Bytes(-1412589450, arrayOfByte, 0);
      int i3 = i2 + DataConvert.putInt2Bytes(1000, arrayOfByte, i2);
      int i4 = i3 + DataConvert.putInt2Bytes(0, arrayOfByte, i3);
      int i5 = i4 + DataConvert.putInt2Bytes(i1, arrayOfByte, i4);
      int i6 = i5 + DataConvert.putShort2Bytes(304, arrayOfByte, i5);
      int i7 = i6 + DataConvert.putBytes2Bytes(this.p, arrayOfByte, i6);
      int i8 = i7 + DataConvert.putShort2Bytes(20, arrayOfByte, i7);
      int i9 = i8 + DataConvert.putString2Bytes(this.n, arrayOfByte, i8);
      int i10 = i9 + DataConvert.putInt2Bytes((int)this.m, arrayOfByte, i9);
      int i11 = i10 + DataConvert.putInt2Bytes(paramInt2, arrayOfByte, i10);
      DataConvert.putBytes2Bytes(paramArrayOfByte, paramInt1, arrayOfByte, i11 + DataConvert.putInt2Bytes(paramInt1, arrayOfByte, i11));
      return arrayOfByte;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      Message localMessage = this.l.obtainMessage();
      localMessage.what = -2;
      localMessage.obj = localNoSuchAlgorithmException.getMessage();
      this.l.sendMessage(localMessage);
    }
    return null;
  }

  private void b()
  {
    new h(this).start();
  }

  private void c()
  {
    new i(this).start();
  }

  // ERROR //
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/tencent/weiyun/f:j	Ljava/lang/String;
    //   4: ifnull +20 -> 24
    //   7: new 184	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: getfield 52	com/tencent/weiyun/f:j	Ljava/lang/String;
    //   15: invokespecial 187	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 191	java/io/File:exists	()Z
    //   21: ifne +40 -> 61
    //   24: aload_0
    //   25: getfield 67	com/tencent/weiyun/f:l	Landroid/os/Handler;
    //   28: invokevirtual 146	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   31: astore_1
    //   32: aload_1
    //   33: bipush 251
    //   35: putfield 151	android/os/Message:what	I
    //   38: aload_1
    //   39: new 193	java/lang/String
    //   42: dup
    //   43: ldc 195
    //   45: invokespecial 196	java/lang/String:<init>	(Ljava/lang/String;)V
    //   48: putfield 159	android/os/Message:obj	Ljava/lang/Object;
    //   51: aload_0
    //   52: getfield 67	com/tencent/weiyun/f:l	Landroid/os/Handler;
    //   55: aload_1
    //   56: invokevirtual 163	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   59: pop
    //   60: return
    //   61: aload_0
    //   62: getfield 54	com/tencent/weiyun/f:k	Lcom/tencent/weiyun/IUploadFileCallBack;
    //   65: invokeinterface 201 1 0
    //   70: new 184	java/io/File
    //   73: dup
    //   74: aload_0
    //   75: getfield 52	com/tencent/weiyun/f:j	Ljava/lang/String;
    //   78: invokespecial 187	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: astore_3
    //   82: aload_0
    //   83: aload_3
    //   84: invokevirtual 205	java/io/File:length	()J
    //   87: putfield 137	com/tencent/weiyun/f:m	J
    //   90: ldc 207
    //   92: invokestatic 98	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   95: astore 7
    //   97: new 209	java/io/FileInputStream
    //   100: dup
    //   101: aload_3
    //   102: invokespecial 212	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   105: astore 8
    //   107: new 214	java/security/DigestInputStream
    //   110: dup
    //   111: aload 8
    //   113: aload 7
    //   115: invokespecial 217	java/security/DigestInputStream:<init>	(Ljava/io/InputStream;Ljava/security/MessageDigest;)V
    //   118: astore 9
    //   120: ldc 218
    //   122: newarray byte
    //   124: astore 10
    //   126: aload 9
    //   128: aload 10
    //   130: invokevirtual 222	java/security/DigestInputStream:read	([B)I
    //   133: ifgt -7 -> 126
    //   136: aload 9
    //   138: invokevirtual 226	java/security/DigestInputStream:getMessageDigest	()Ljava/security/MessageDigest;
    //   141: astore 11
    //   143: aload_0
    //   144: aload 11
    //   146: invokevirtual 106	java/security/MessageDigest:digest	()[B
    //   149: invokestatic 112	com/tencent/utils/DataConvert:toHexString	([B)Ljava/lang/String;
    //   152: putfield 131	com/tencent/weiyun/f:n	Ljava/lang/String;
    //   155: aload 11
    //   157: invokevirtual 117	java/security/MessageDigest:reset	()V
    //   160: aload 8
    //   162: invokevirtual 229	java/io/FileInputStream:close	()V
    //   165: aload 9
    //   167: invokevirtual 230	java/security/DigestInputStream:close	()V
    //   170: ldc 92
    //   172: invokestatic 98	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   175: astore 15
    //   177: new 209	java/io/FileInputStream
    //   180: dup
    //   181: aload_3
    //   182: invokespecial 212	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   185: astore 16
    //   187: new 214	java/security/DigestInputStream
    //   190: dup
    //   191: aload 16
    //   193: aload 15
    //   195: invokespecial 217	java/security/DigestInputStream:<init>	(Ljava/io/InputStream;Ljava/security/MessageDigest;)V
    //   198: astore 17
    //   200: ldc 218
    //   202: newarray byte
    //   204: astore 18
    //   206: aload 17
    //   208: aload 18
    //   210: invokevirtual 222	java/security/DigestInputStream:read	([B)I
    //   213: ifgt -7 -> 206
    //   216: aload 17
    //   218: invokevirtual 226	java/security/DigestInputStream:getMessageDigest	()Ljava/security/MessageDigest;
    //   221: astore 19
    //   223: aload_0
    //   224: aload 19
    //   226: invokevirtual 106	java/security/MessageDigest:digest	()[B
    //   229: invokestatic 112	com/tencent/utils/DataConvert:toHexString	([B)Ljava/lang/String;
    //   232: putfield 114	com/tencent/weiyun/f:o	Ljava/lang/String;
    //   235: aload 19
    //   237: invokevirtual 117	java/security/MessageDigest:reset	()V
    //   240: aload 16
    //   242: invokevirtual 229	java/io/FileInputStream:close	()V
    //   245: aload 17
    //   247: invokevirtual 230	java/security/DigestInputStream:close	()V
    //   250: new 165	com/tencent/weiyun/h
    //   253: dup
    //   254: aload_0
    //   255: invokespecial 168	com/tencent/weiyun/h:<init>	(Lcom/tencent/weiyun/f;)V
    //   258: invokevirtual 171	com/tencent/weiyun/h:start	()V
    //   261: return
    //   262: astore 4
    //   264: aload_0
    //   265: getfield 67	com/tencent/weiyun/f:l	Landroid/os/Handler;
    //   268: invokevirtual 146	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   271: astore 5
    //   273: aload 5
    //   275: bipush 254
    //   277: putfield 151	android/os/Message:what	I
    //   280: aload 5
    //   282: new 193	java/lang/String
    //   285: dup
    //   286: ldc 195
    //   288: invokespecial 196	java/lang/String:<init>	(Ljava/lang/String;)V
    //   291: putfield 159	android/os/Message:obj	Ljava/lang/Object;
    //   294: aload_0
    //   295: getfield 67	com/tencent/weiyun/f:l	Landroid/os/Handler;
    //   298: aload 5
    //   300: invokevirtual 163	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   303: pop
    //   304: return
    //   305: astore 12
    //   307: aload_0
    //   308: getfield 67	com/tencent/weiyun/f:l	Landroid/os/Handler;
    //   311: invokevirtual 146	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   314: astore 13
    //   316: aload 13
    //   318: bipush 254
    //   320: putfield 151	android/os/Message:what	I
    //   323: aload 13
    //   325: new 193	java/lang/String
    //   328: dup
    //   329: ldc 195
    //   331: invokespecial 196	java/lang/String:<init>	(Ljava/lang/String;)V
    //   334: putfield 159	android/os/Message:obj	Ljava/lang/Object;
    //   337: aload_0
    //   338: getfield 67	com/tencent/weiyun/f:l	Landroid/os/Handler;
    //   341: aload 13
    //   343: invokevirtual 163	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   346: pop
    //   347: return
    //
    // Exception table:
    //   from	to	target	type
    //   90	126	262	java/lang/Exception
    //   126	170	262	java/lang/Exception
    //   170	206	305	java/lang/Exception
    //   206	250	305	java/lang/Exception
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.weiyun.f
 * JD-Core Version:    0.6.2
 */