package com.nostra13.universalimageloader.utils;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public final class IoUtils
{
  public static final int CONTINUE_LOADING_PERCENTAGE = 75;
  public static final int DEFAULT_BUFFER_SIZE = 32768;

  private static boolean a(IoUtils.CopyListener paramCopyListener, int paramInt1, int paramInt2)
  {
    return (paramCopyListener != null) && (!paramCopyListener.onBytesCopied(paramInt1, paramInt2)) && (paramInt1 * 100 / paramInt2 < 75);
  }

  public static void closeSilently(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static boolean copyStream(InputStream paramInputStream, OutputStream paramOutputStream, IoUtils.CopyListener paramCopyListener)
  {
    return copyStream(paramInputStream, paramOutputStream, paramCopyListener, 32768);
  }

  public static boolean copyStream(InputStream paramInputStream, OutputStream paramOutputStream, IoUtils.CopyListener paramCopyListener, int paramInt)
  {
    int i = paramInputStream.available();
    byte[] arrayOfByte = new byte[paramInt];
    if (a(paramCopyListener, 0, i))
      return false;
    int j = 0;
    do
    {
      int k = paramInputStream.read(arrayOfByte, 0, paramInt);
      if (k == -1)
        break;
      paramOutputStream.write(arrayOfByte, 0, k);
      j += k;
    }
    while (!a(paramCopyListener, j, i));
    return false;
    paramOutputStream.flush();
    return true;
  }

  // ERROR //
  public static void readAndCloseStream(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 9
    //   2: newarray byte
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_0
    //   8: ldc 9
    //   10: invokevirtual 47	java/io/InputStream:read	([BII)I
    //   13: istore 4
    //   15: iload 4
    //   17: iconst_m1
    //   18: if_icmpne -13 -> 5
    //   21: aload_0
    //   22: invokestatic 62	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   25: return
    //   26: astore_3
    //   27: aload_0
    //   28: invokestatic 62	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   31: return
    //   32: astore_2
    //   33: aload_0
    //   34: invokestatic 62	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   37: aload_2
    //   38: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   5	15	26	java/io/IOException
    //   5	15	32	finally
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.IoUtils
 * JD-Core Version:    0.6.2
 */