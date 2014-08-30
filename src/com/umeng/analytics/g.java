package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.File;
import u.aly.bi;
import u.aly.bj;
import u.aly.bv;

public final class g
{
  private static g a = new g();
  private static Context b;
  private static String c;
  private static long d = 0L;
  private static long e = 0L;
  private static final String f = "age";
  private static final String g = "sex";
  private static final String h = "id";
  private static final String i = "url";
  private static final String j = "mobclick_agent_user_";
  private static final String k = "mobclick_agent_online_setting_";
  private static final String l = "mobclick_agent_header_";
  private static final String m = "mobclick_agent_update_";
  private static final String n = "mobclick_agent_state_";
  private static final String o = "mobclick_agent_cached_";
  private static final String p = "mobclick_agent_sealed_";

  public static g a(Context paramContext)
  {
    if (b == null)
      b = paramContext.getApplicationContext();
    if (c == null)
      c = paramContext.getPackageName();
    return a;
  }

  private static boolean a(File paramFile)
  {
    long l1 = paramFile.length();
    return (paramFile.exists()) && (l1 > e);
  }

  private static SharedPreferences k()
  {
    return b.getSharedPreferences("mobclick_agent_user_" + c, 0);
  }

  private static String l()
  {
    return "mobclick_agent_header_" + c;
  }

  private static String m()
  {
    return "mobclick_agent_cached_" + c + bi.c(b);
  }

  private static String n()
  {
    return "mobclick_agent_sealed_" + c;
  }

  public final void a(int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = a(b).g().edit();
    localEditor.putInt("umeng_net_report_policy", paramInt1);
    localEditor.putLong("umeng_net_report_interval", paramInt2);
    localEditor.commit();
  }

  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = k().edit();
    if (!TextUtils.isEmpty(paramString1))
      localEditor.putString("id", paramString1);
    if (!TextUtils.isEmpty(paramString2))
      localEditor.putString("url", paramString2);
    if (paramInt1 > 0)
      localEditor.putInt("age", paramInt1);
    localEditor.putInt("sex", paramInt2);
    localEditor.commit();
  }

  public final void a(byte[] paramArrayOfByte)
  {
    String str = m();
    try
    {
      bv.a(new File(b.getFilesDir(), str), paramArrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", localException.getMessage());
    }
  }

  public final int[] a()
  {
    SharedPreferences localSharedPreferences = g();
    int[] arrayOfInt = new int[2];
    if (localSharedPreferences.getInt("umeng_net_report_policy", -1) != -1)
    {
      arrayOfInt[0] = localSharedPreferences.getInt("umeng_net_report_policy", 1);
      arrayOfInt[1] = ((int)localSharedPreferences.getLong("umeng_net_report_interval", 0L));
      return arrayOfInt;
    }
    arrayOfInt[0] = localSharedPreferences.getInt("umeng_local_report_policy", 1);
    arrayOfInt[1] = ((int)localSharedPreferences.getLong("umeng_local_report_interval", 0L));
    return arrayOfInt;
  }

  public final void b(byte[] paramArrayOfByte)
  {
    try
    {
      bv.a(new File(b.getFilesDir(), n()), paramArrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  // ERROR //
  public final byte[] b()
  {
    // Byte code:
    //   0: invokestatic 154	com/umeng/analytics/g:m	()Ljava/lang/String;
    //   3: astore_1
    //   4: new 78	java/io/File
    //   7: dup
    //   8: getstatic 63	com/umeng/analytics/g:b	Landroid/content/Context;
    //   11: invokevirtual 158	android/content/Context:getFilesDir	()Ljava/io/File;
    //   14: aload_1
    //   15: invokespecial 161	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore_2
    //   19: aload_2
    //   20: invokevirtual 82	java/io/File:length	()J
    //   23: lstore_3
    //   24: aload_2
    //   25: invokevirtual 86	java/io/File:exists	()Z
    //   28: ifeq +26 -> 54
    //   31: lload_3
    //   32: getstatic 59	com/umeng/analytics/g:e	J
    //   35: lcmp
    //   36: ifle +18 -> 54
    //   39: iconst_1
    //   40: istore 5
    //   42: iload 5
    //   44: ifeq +16 -> 60
    //   47: aload_2
    //   48: invokevirtual 198	java/io/File:delete	()Z
    //   51: pop
    //   52: aconst_null
    //   53: areturn
    //   54: iconst_0
    //   55: istore 5
    //   57: goto -15 -> 42
    //   60: aload_2
    //   61: invokevirtual 86	java/io/File:exists	()Z
    //   64: ifeq -12 -> 52
    //   67: getstatic 63	com/umeng/analytics/g:b	Landroid/content/Context;
    //   70: aload_1
    //   71: invokevirtual 202	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   74: astore 10
    //   76: aload 10
    //   78: astore 7
    //   80: aload 7
    //   82: invokestatic 205	u/aly/bv:b	(Ljava/io/InputStream;)[B
    //   85: astore 11
    //   87: aload 7
    //   89: invokestatic 208	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   92: aload 11
    //   94: areturn
    //   95: astore 9
    //   97: aconst_null
    //   98: astore 7
    //   100: aload 9
    //   102: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   105: aload 7
    //   107: invokestatic 208	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 6
    //   114: aconst_null
    //   115: astore 7
    //   117: aload 6
    //   119: astore 8
    //   121: aload 7
    //   123: invokestatic 208	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   126: aload 8
    //   128: athrow
    //   129: astore 8
    //   131: goto -10 -> 121
    //   134: astore 9
    //   136: goto -36 -> 100
    //
    // Exception table:
    //   from	to	target	type
    //   67	76	95	java/lang/Exception
    //   67	76	112	finally
    //   80	87	129	finally
    //   100	105	129	finally
    //   80	87	134	java/lang/Exception
  }

  public final Object[] b(Context paramContext)
  {
    SharedPreferences localSharedPreferences = k();
    Object[] arrayOfObject = new Object[4];
    if (localSharedPreferences.contains("id"))
      arrayOfObject[0] = localSharedPreferences.getString("id", null);
    if (localSharedPreferences.contains("url"))
      arrayOfObject[1] = localSharedPreferences.getString("url", null);
    if (localSharedPreferences.contains("age"))
      arrayOfObject[2] = Integer.valueOf(localSharedPreferences.getInt("age", -1));
    if (localSharedPreferences.contains("sex"))
      arrayOfObject[3] = Integer.valueOf(localSharedPreferences.getInt("sex", -1));
    return arrayOfObject;
  }

  public final void c()
  {
    b.deleteFile("mobclick_agent_header_" + c);
    b.deleteFile(m());
  }

  // ERROR //
  public final byte[] d()
  {
    // Byte code:
    //   0: invokestatic 191	com/umeng/analytics/g:n	()Ljava/lang/String;
    //   3: astore_1
    //   4: new 78	java/io/File
    //   7: dup
    //   8: getstatic 63	com/umeng/analytics/g:b	Landroid/content/Context;
    //   11: invokevirtual 158	android/content/Context:getFilesDir	()Ljava/io/File;
    //   14: aload_1
    //   15: invokespecial 161	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore_2
    //   19: aload_2
    //   20: invokevirtual 86	java/io/File:exists	()Z
    //   23: ifeq +16 -> 39
    //   26: aload_2
    //   27: invokevirtual 82	java/io/File:length	()J
    //   30: lstore 5
    //   32: lload 5
    //   34: lconst_0
    //   35: lcmp
    //   36: ifgt +5 -> 41
    //   39: aconst_null
    //   40: areturn
    //   41: getstatic 63	com/umeng/analytics/g:b	Landroid/content/Context;
    //   44: aload_1
    //   45: invokevirtual 202	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   48: astore 10
    //   50: aload 10
    //   52: astore 8
    //   54: aload 8
    //   56: invokestatic 205	u/aly/bv:b	(Ljava/io/InputStream;)[B
    //   59: astore 11
    //   61: aload 8
    //   63: invokestatic 208	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   66: aload 11
    //   68: areturn
    //   69: astore_3
    //   70: aload_2
    //   71: invokevirtual 198	java/io/File:delete	()Z
    //   74: pop
    //   75: aload_3
    //   76: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore 9
    //   83: aconst_null
    //   84: astore 8
    //   86: aload 9
    //   88: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   91: aload 8
    //   93: invokestatic 208	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   96: goto -17 -> 79
    //   99: aload 8
    //   101: invokestatic 208	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   104: aload 7
    //   106: athrow
    //   107: astore 7
    //   109: goto -10 -> 99
    //   112: astore 9
    //   114: goto -28 -> 86
    //   117: astore 7
    //   119: aconst_null
    //   120: astore 8
    //   122: goto -23 -> 99
    //
    // Exception table:
    //   from	to	target	type
    //   19	32	69	java/lang/Exception
    //   61	66	69	java/lang/Exception
    //   91	96	69	java/lang/Exception
    //   99	107	69	java/lang/Exception
    //   41	50	81	java/lang/Exception
    //   54	61	107	finally
    //   86	91	107	finally
    //   54	61	112	java/lang/Exception
    //   41	50	117	finally
  }

  public final void e()
  {
    String str = n();
    boolean bool = b.deleteFile(str);
    bj.a("--->", "delete envelope:" + bool);
  }

  public final boolean f()
  {
    String str = n();
    File localFile = new File(b.getFilesDir(), str);
    return (localFile.exists()) && (localFile.length() > 0L);
  }

  public final SharedPreferences g()
  {
    return b.getSharedPreferences("mobclick_agent_online_setting_" + c, 0);
  }

  public final SharedPreferences h()
  {
    return b.getSharedPreferences("mobclick_agent_header_" + c, 0);
  }

  public final SharedPreferences i()
  {
    return b.getSharedPreferences("mobclick_agent_update_" + c, 0);
  }

  public final SharedPreferences j()
  {
    return b.getSharedPreferences("mobclick_agent_state_" + c, 0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.g
 * JD-Core Version:    0.6.2
 */