package com.xiaomi.market.sdk;

import android.text.TextUtils;
import android.util.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class b
{
  private static String a = "AES/CBC/PKCS5Padding";
  private static final String[] b = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

  private static String a(byte paramByte)
  {
    if (paramByte < 0)
      paramByte += 256;
    int i = paramByte / 16;
    int j = paramByte % 16;
    return b[i] + b[j];
  }

  // ERROR //
  static final String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: sipush 1024
    //   3: newarray byte
    //   5: astore_1
    //   6: new 76	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_2
    //   15: ldc 81
    //   17: invokestatic 87	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore 9
    //   22: aload_2
    //   23: aload_1
    //   24: invokevirtual 93	java/io/InputStream:read	([B)I
    //   27: istore 10
    //   29: iload 10
    //   31: ifgt +25 -> 56
    //   34: aload_2
    //   35: invokevirtual 96	java/io/InputStream:close	()V
    //   38: aload 9
    //   40: invokevirtual 100	java/security/MessageDigest:digest	()[B
    //   43: invokestatic 103	com/xiaomi/market/sdk/b:a	([B)Ljava/lang/String;
    //   46: areturn
    //   47: astore 12
    //   49: aload 12
    //   51: invokevirtual 106	java/io/FileNotFoundException:printStackTrace	()V
    //   54: aconst_null
    //   55: areturn
    //   56: aload 9
    //   58: aload_1
    //   59: iconst_0
    //   60: iload 10
    //   62: invokevirtual 110	java/security/MessageDigest:update	([BII)V
    //   65: goto -43 -> 22
    //   68: astore 7
    //   70: aload 7
    //   72: invokevirtual 111	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   75: aload_2
    //   76: invokevirtual 96	java/io/InputStream:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore 8
    //   83: aload 8
    //   85: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   88: aconst_null
    //   89: areturn
    //   90: astore 5
    //   92: aload 5
    //   94: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   97: aload_2
    //   98: invokevirtual 96	java/io/InputStream:close	()V
    //   101: aconst_null
    //   102: areturn
    //   103: astore 6
    //   105: aload 6
    //   107: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_3
    //   113: aload_2
    //   114: invokevirtual 96	java/io/InputStream:close	()V
    //   117: aload_3
    //   118: athrow
    //   119: astore 4
    //   121: aload 4
    //   123: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   126: goto -9 -> 117
    //   129: astore 11
    //   131: aload 11
    //   133: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   136: goto -98 -> 38
    //
    // Exception table:
    //   from	to	target	type
    //   6	15	47	java/io/FileNotFoundException
    //   15	22	68	java/security/NoSuchAlgorithmException
    //   22	29	68	java/security/NoSuchAlgorithmException
    //   56	65	68	java/security/NoSuchAlgorithmException
    //   75	79	81	java/io/IOException
    //   15	22	90	java/io/IOException
    //   22	29	90	java/io/IOException
    //   56	65	90	java/io/IOException
    //   97	101	103	java/io/IOException
    //   15	22	112	finally
    //   22	29	112	finally
    //   56	65	112	finally
    //   70	75	112	finally
    //   92	97	112	finally
    //   113	117	119	java/io/IOException
    //   34	38	129	java/io/IOException
  }

  static final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      return a(localMessageDigest.digest());
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return null;
  }

  private static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)));
    byte[] arrayOfByte;
    do
    {
      return null;
      arrayOfByte = Base64.decode(paramString2, 0);
    }
    while ((arrayOfByte == null) || (arrayOfByte.length != 16));
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte, "AES");
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, localSecretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
      String str = Base64.encodeToString(localCipher.doFinal(paramString1.getBytes()), 2);
      return str;
    }
    catch (BadPaddingException localBadPaddingException)
    {
      return null;
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      return null;
    }
    catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException)
    {
      return null;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      return null;
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      return null;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return null;
  }

  private static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfByte.length)
        return localStringBuffer.toString();
      int j = paramArrayOfByte[i];
      if (j < 0)
        j += 256;
      int k = j / 16;
      int m = j % 16;
      localStringBuffer.append(b[k] + b[m]);
    }
  }

  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA");
      localMessageDigest.update(paramString.getBytes());
      return a(localMessageDigest.digest());
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return null;
  }

  private static String b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)));
    while (true)
    {
      return null;
      byte[] arrayOfByte1 = Base64.decode(paramString2, 0);
      if ((arrayOfByte1 != null) && (arrayOfByte1.length == 16))
      {
        SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte1, "AES");
        try
        {
          Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
          localCipher.init(2, localSecretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
          byte[] arrayOfByte2 = Base64.decode(paramString1, 0);
          if (arrayOfByte2 != null)
          {
            String str = new String(localCipher.doFinal(arrayOfByte2));
            return str;
          }
        }
        catch (BadPaddingException localBadPaddingException)
        {
          return null;
        }
        catch (IllegalBlockSizeException localIllegalBlockSizeException)
        {
          return null;
        }
        catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException)
        {
          return null;
        }
        catch (InvalidKeyException localInvalidKeyException)
        {
          return null;
        }
        catch (NoSuchPaddingException localNoSuchPaddingException)
        {
          return null;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
        }
      }
    }
    return null;
  }

  private static String b(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 2);
  }

  private static byte[] c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA");
      localMessageDigest.update(paramString.getBytes());
      return localMessageDigest.digest();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return null;
  }

  private static String d(String paramString)
  {
    return Base64.encodeToString(paramString.getBytes(), 2);
  }

  private static byte[] e(String paramString)
  {
    return Base64.encode(paramString.getBytes(), 2);
  }

  private static String f(String paramString)
  {
    return new String(Base64.decode(paramString, 0));
  }

  private static byte[] g(String paramString)
  {
    return Base64.decode(paramString, 0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.b
 * JD-Core Version:    0.6.2
 */