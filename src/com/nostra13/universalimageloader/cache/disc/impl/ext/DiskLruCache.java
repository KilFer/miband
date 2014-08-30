package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class DiskLruCache
  implements Closeable
{
  private static final OutputStream B = new b();
  private static String a = "journal";
  private static String b = "journal.tmp";
  private static String c = "journal.bkp";
  private static String d = "libcore.io.DiskLruCache";
  private static String e = "1";
  private static long f = -1L;
  private static Pattern g = Pattern.compile("[a-z0-9_-]{1,64}");
  private static final String h = "CLEAN";
  private static final String i = "DIRTY";
  private static final String j = "REMOVE";
  private static final String k = "READ";
  private final Callable<Void> A = new a(this);
  private final File l;
  private final File m;
  private final File n;
  private final File o;
  private final int p;
  private long q;
  private int r;
  private final int s;
  private long t = 0L;
  private int u = 0;
  private Writer v;
  private final LinkedHashMap<String, d> w = new LinkedHashMap(0, 0.75F, true);
  private int x;
  private long y = 0L;
  private ThreadPoolExecutor z = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());

  private DiskLruCache(File paramFile, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.l = paramFile;
    this.p = paramInt1;
    this.m = new File(paramFile, "journal");
    this.n = new File(paramFile, "journal.tmp");
    this.o = new File(paramFile, "journal.bkp");
    this.s = paramInt2;
    this.q = paramLong;
    this.r = paramInt3;
  }

  private DiskLruCache.Editor a(String paramString, long paramLong)
  {
    while (true)
    {
      d locald1;
      DiskLruCache.Editor localEditor2;
      d locald2;
      try
      {
        m();
        e(paramString);
        locald1 = (d)this.w.get(paramString);
        if (paramLong != -1L)
          if (locald1 != null)
          {
            long l1 = d.e(locald1);
            if (l1 == paramLong);
          }
          else
          {
            localEditor2 = null;
            return localEditor2;
          }
        if (locald1 == null)
        {
          d locald3 = new d(this, paramString, (byte)0);
          this.w.put(paramString, locald3);
          locald2 = locald3;
          localEditor2 = new DiskLruCache.Editor(this, locald2, (byte)0);
          d.a(locald2, localEditor2);
          this.v.write("DIRTY " + paramString + '\n');
          this.v.flush();
          continue;
        }
      }
      finally
      {
      }
      DiskLruCache.Editor localEditor1 = d.a(locald1);
      if (localEditor1 != null)
        localEditor2 = null;
      else
        locald2 = locald1;
    }
  }

  public static DiskLruCache a(File paramFile, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("maxSize <= 0");
    if (paramInt3 <= 0)
      throw new IllegalArgumentException("maxFileCount <= 0");
    File localFile1 = new File(paramFile, "journal.bkp");
    File localFile2;
    if (localFile1.exists())
    {
      localFile2 = new File(paramFile, "journal");
      if (!localFile2.exists())
        break label151;
      localFile1.delete();
    }
    while (true)
    {
      DiskLruCache localDiskLruCache1 = new DiskLruCache(paramFile, 1, 1, paramLong, paramInt3);
      if (localDiskLruCache1.m.exists())
        try
        {
          localDiskLruCache1.f();
          localDiskLruCache1.g();
          localDiskLruCache1.v = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(localDiskLruCache1.m, true), g.a));
          return localDiskLruCache1;
          label151: a(localFile1, localFile2, false);
        }
        catch (IOException localIOException)
        {
          System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
          localDiskLruCache1.d();
        }
    }
    paramFile.mkdirs();
    DiskLruCache localDiskLruCache2 = new DiskLruCache(paramFile, 1, 1, paramLong, paramInt3);
    localDiskLruCache2.h();
    return localDiskLruCache2;
  }

  private void a(long paramLong)
  {
    try
    {
      this.q = paramLong;
      this.z.submit(this.A);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void a(DiskLruCache.Editor paramEditor, boolean paramBoolean)
  {
    d locald;
    try
    {
      locald = DiskLruCache.Editor.a(paramEditor);
      if (d.a(locald) != paramEditor)
        throw new IllegalStateException();
    }
    finally
    {
    }
    int i1 = 0;
    if (paramBoolean)
    {
      boolean bool = d.d(locald);
      i1 = 0;
      if (!bool)
        for (int i2 = 0; ; i2++)
        {
          int i3 = this.s;
          i1 = 0;
          if (i2 >= i3)
            break;
          if (DiskLruCache.Editor.b(paramEditor)[i2] == 0)
          {
            paramEditor.abort();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
          }
          if (!locald.b(i2).exists())
          {
            paramEditor.abort();
            return;
          }
        }
    }
    while (true)
    {
      if (i1 < this.s)
      {
        File localFile1 = locald.b(i1);
        if (paramBoolean)
        {
          if (localFile1.exists())
          {
            File localFile2 = locald.a(i1);
            localFile1.renameTo(localFile2);
            long l2 = d.b(locald)[i1];
            long l3 = localFile2.length();
            d.b(locald)[i1] = l3;
            this.t = (l3 + (this.t - l2));
            this.u = (1 + this.u);
          }
        }
        else
          a(localFile1);
      }
      else
      {
        this.x = (1 + this.x);
        d.a(locald, null);
        if ((paramBoolean | d.d(locald)))
        {
          d.a(locald, true);
          this.v.write("CLEAN " + d.c(locald) + locald.a() + '\n');
          if (paramBoolean)
          {
            long l1 = this.y;
            this.y = (1L + l1);
            d.a(locald, l1);
          }
        }
        while (true)
        {
          this.v.flush();
          if ((this.t <= this.q) && (this.u <= this.r) && (!k()))
            break;
          this.z.submit(this.A);
          break;
          this.w.remove(d.c(locald));
          this.v.write("REMOVE " + d.c(locald) + '\n');
        }
      }
      i1++;
    }
  }

  private static void a(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete()))
      throw new IOException();
  }

  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean)
      a(paramFile2);
    if (!paramFile1.renameTo(paramFile2))
      throw new IOException();
  }

  private static String b(InputStream paramInputStream)
  {
    return g.a(new InputStreamReader(paramInputStream, g.b));
  }

  private void d(String paramString)
  {
    int i1 = paramString.indexOf(' ');
    if (i1 == -1)
      throw new IOException("unexpected journal line: " + paramString);
    int i2 = i1 + 1;
    int i3 = paramString.indexOf(' ', i2);
    String str2;
    if (i3 == -1)
    {
      str2 = paramString.substring(i2);
      if ((i1 != 6) || (!paramString.startsWith("REMOVE")))
        break label283;
      this.w.remove(str2);
    }
    label283: for (String str1 = paramString.substring(i2, i3); ; str1 = str2)
    {
      d locald = (d)this.w.get(str1);
      if (locald == null)
      {
        locald = new d(this, str1, (byte)0);
        this.w.put(str1, locald);
      }
      if ((i3 != -1) && (i1 == 5) && (paramString.startsWith("CLEAN")))
      {
        String[] arrayOfString = paramString.substring(i3 + 1).split(" ");
        d.a(locald, true);
        d.a(locald, null);
        d.a(locald, arrayOfString);
        return;
      }
      if ((i3 == -1) && (i1 == 5) && (paramString.startsWith("DIRTY")))
      {
        d.a(locald, new DiskLruCache.Editor(this, locald, (byte)0));
        return;
      }
      if ((i3 == -1) && (i1 == 4) && (paramString.startsWith("READ")))
        break;
      throw new IOException("unexpected journal line: " + paramString);
    }
  }

  private static void e(String paramString)
  {
    if (!g.matcher(paramString).matches())
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + paramString + "\"");
  }

  // ERROR //
  private void f()
  {
    // Byte code:
    //   0: new 427	com/nostra13/universalimageloader/cache/disc/impl/ext/e
    //   3: dup
    //   4: new 429	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 137	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:m	Ljava/io/File;
    //   12: invokespecial 431	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: getstatic 250	com/nostra13/universalimageloader/cache/disc/impl/ext/g:a	Ljava/nio/charset/Charset;
    //   18: invokespecial 432	com/nostra13/universalimageloader/cache/disc/impl/ext/e:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 433	com/nostra13/universalimageloader/cache/disc/impl/ext/e:a	()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_1
    //   28: invokevirtual 433	com/nostra13/universalimageloader/cache/disc/impl/ext/e:a	()Ljava/lang/String;
    //   31: astore 4
    //   33: aload_1
    //   34: invokevirtual 433	com/nostra13/universalimageloader/cache/disc/impl/ext/e:a	()Ljava/lang/String;
    //   37: astore 5
    //   39: aload_1
    //   40: invokevirtual 433	com/nostra13/universalimageloader/cache/disc/impl/ext/e:a	()Ljava/lang/String;
    //   43: astore 6
    //   45: aload_1
    //   46: invokevirtual 433	com/nostra13/universalimageloader/cache/disc/impl/ext/e:a	()Ljava/lang/String;
    //   49: astore 7
    //   51: ldc 21
    //   53: aload_3
    //   54: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +54 -> 111
    //   60: ldc 24
    //   62: aload 4
    //   64: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq +44 -> 111
    //   70: aload_0
    //   71: getfield 130	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:p	I
    //   74: invokestatic 441	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   77: aload 5
    //   79: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +29 -> 111
    //   85: aload_0
    //   86: getfield 143	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:s	I
    //   89: invokestatic 441	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   92: aload 6
    //   94: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +14 -> 111
    //   100: ldc_w 443
    //   103: aload 7
    //   105: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifne +74 -> 182
    //   111: new 216	java/io/IOException
    //   114: dup
    //   115: new 187	java/lang/StringBuilder
    //   118: dup
    //   119: ldc_w 445
    //   122: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload_3
    //   126: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 447
    //   132: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 4
    //   137: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 447
    //   143: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 6
    //   148: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc_w 447
    //   154: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 7
    //   159: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 449
    //   165: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokespecial 384	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   174: athrow
    //   175: astore_2
    //   176: aload_1
    //   177: invokestatic 452	com/nostra13/universalimageloader/cache/disc/impl/ext/g:a	(Ljava/io/Closeable;)V
    //   180: aload_2
    //   181: athrow
    //   182: iconst_0
    //   183: istore 8
    //   185: aload_1
    //   186: invokevirtual 433	com/nostra13/universalimageloader/cache/disc/impl/ext/e:a	()Ljava/lang/String;
    //   189: astore 10
    //   191: aload 10
    //   193: bipush 32
    //   195: invokevirtual 381	java/lang/String:indexOf	(I)I
    //   198: istore 11
    //   200: iload 11
    //   202: iconst_m1
    //   203: if_icmpne +50 -> 253
    //   206: new 216	java/io/IOException
    //   209: dup
    //   210: new 187	java/lang/StringBuilder
    //   213: dup
    //   214: ldc_w 383
    //   217: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   220: aload 10
    //   222: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokespecial 384	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   231: athrow
    //   232: astore 9
    //   234: aload_0
    //   235: iload 8
    //   237: aload_0
    //   238: getfield 99	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:w	Ljava/util/LinkedHashMap;
    //   241: invokevirtual 456	java/util/LinkedHashMap:size	()I
    //   244: isub
    //   245: putfield 150	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:x	I
    //   248: aload_1
    //   249: invokestatic 452	com/nostra13/universalimageloader/cache/disc/impl/ext/g:a	(Ljava/io/Closeable;)V
    //   252: return
    //   253: iload 11
    //   255: iconst_1
    //   256: iadd
    //   257: istore 12
    //   259: aload 10
    //   261: bipush 32
    //   263: iload 12
    //   265: invokevirtual 387	java/lang/String:indexOf	(II)I
    //   268: istore 13
    //   270: iload 13
    //   272: iconst_m1
    //   273: if_icmpne +42 -> 315
    //   276: aload 10
    //   278: iload 12
    //   280: invokevirtual 391	java/lang/String:substring	(I)Ljava/lang/String;
    //   283: astore 14
    //   285: iload 11
    //   287: bipush 6
    //   289: if_icmpne +234 -> 523
    //   292: aload 10
    //   294: ldc 39
    //   296: invokevirtual 395	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   299: ifeq +224 -> 523
    //   302: aload_0
    //   303: getfield 99	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:w	Ljava/util/LinkedHashMap;
    //   306: aload 14
    //   308: invokevirtual 365	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   311: pop
    //   312: goto +218 -> 530
    //   315: aload 10
    //   317: iload 12
    //   319: iload 13
    //   321: invokevirtual 398	java/lang/String:substring	(II)Ljava/lang/String;
    //   324: astore 15
    //   326: aload_0
    //   327: getfield 99	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:w	Ljava/util/LinkedHashMap;
    //   330: aload 15
    //   332: invokevirtual 163	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   335: checkcast 165	com/nostra13/universalimageloader/cache/disc/impl/ext/d
    //   338: astore 16
    //   340: aload 16
    //   342: ifnonnull +28 -> 370
    //   345: new 165	com/nostra13/universalimageloader/cache/disc/impl/ext/d
    //   348: dup
    //   349: aload_0
    //   350: aload 15
    //   352: iconst_0
    //   353: invokespecial 171	com/nostra13/universalimageloader/cache/disc/impl/ext/d:<init>	(Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache;Ljava/lang/String;B)V
    //   356: astore 16
    //   358: aload_0
    //   359: getfield 99	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:w	Ljava/util/LinkedHashMap;
    //   362: aload 15
    //   364: aload 16
    //   366: invokevirtual 175	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   369: pop
    //   370: iload 13
    //   372: iconst_m1
    //   373: if_icmpeq +60 -> 433
    //   376: iload 11
    //   378: iconst_5
    //   379: if_icmpne +54 -> 433
    //   382: aload 10
    //   384: ldc 33
    //   386: invokevirtual 395	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   389: ifeq +44 -> 433
    //   392: aload 10
    //   394: iload 13
    //   396: iconst_1
    //   397: iadd
    //   398: invokevirtual 391	java/lang/String:substring	(I)Ljava/lang/String;
    //   401: ldc_w 400
    //   404: invokevirtual 404	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   407: astore 19
    //   409: aload 16
    //   411: iconst_1
    //   412: invokestatic 350	com/nostra13/universalimageloader/cache/disc/impl/ext/d:a	(Lcom/nostra13/universalimageloader/cache/disc/impl/ext/d;Z)Z
    //   415: pop
    //   416: aload 16
    //   418: aconst_null
    //   419: invokestatic 183	com/nostra13/universalimageloader/cache/disc/impl/ext/d:a	(Lcom/nostra13/universalimageloader/cache/disc/impl/ext/d;Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Editor;)Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Editor;
    //   422: pop
    //   423: aload 16
    //   425: aload 19
    //   427: invokestatic 407	com/nostra13/universalimageloader/cache/disc/impl/ext/d:a	(Lcom/nostra13/universalimageloader/cache/disc/impl/ext/d;[Ljava/lang/String;)V
    //   430: goto +100 -> 530
    //   433: iload 13
    //   435: iconst_m1
    //   436: if_icmpne +39 -> 475
    //   439: iload 11
    //   441: iconst_5
    //   442: if_icmpne +33 -> 475
    //   445: aload 10
    //   447: ldc 36
    //   449: invokevirtual 395	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   452: ifeq +23 -> 475
    //   455: aload 16
    //   457: new 177	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Editor
    //   460: dup
    //   461: aload_0
    //   462: aload 16
    //   464: iconst_0
    //   465: invokespecial 180	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Editor:<init>	(Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache;Lcom/nostra13/universalimageloader/cache/disc/impl/ext/d;B)V
    //   468: invokestatic 183	com/nostra13/universalimageloader/cache/disc/impl/ext/d:a	(Lcom/nostra13/universalimageloader/cache/disc/impl/ext/d;Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Editor;)Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Editor;
    //   471: pop
    //   472: goto +58 -> 530
    //   475: iload 13
    //   477: iconst_m1
    //   478: if_icmpne +19 -> 497
    //   481: iload 11
    //   483: iconst_4
    //   484: if_icmpne +13 -> 497
    //   487: aload 10
    //   489: ldc 42
    //   491: invokevirtual 395	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   494: ifne +36 -> 530
    //   497: new 216	java/io/IOException
    //   500: dup
    //   501: new 187	java/lang/StringBuilder
    //   504: dup
    //   505: ldc_w 383
    //   508: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   511: aload 10
    //   513: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokespecial 384	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   522: athrow
    //   523: aload 14
    //   525: astore 15
    //   527: goto -201 -> 326
    //   530: iinc 8 1
    //   533: goto -348 -> 185
    //
    // Exception table:
    //   from	to	target	type
    //   22	111	175	finally
    //   111	175	175	finally
    //   185	200	175	finally
    //   206	232	175	finally
    //   234	248	175	finally
    //   259	270	175	finally
    //   276	285	175	finally
    //   292	312	175	finally
    //   315	326	175	finally
    //   326	340	175	finally
    //   345	370	175	finally
    //   382	430	175	finally
    //   445	472	175	finally
    //   487	497	175	finally
    //   497	523	175	finally
    //   185	200	232	java/io/EOFException
    //   206	232	232	java/io/EOFException
    //   259	270	232	java/io/EOFException
    //   276	285	232	java/io/EOFException
    //   292	312	232	java/io/EOFException
    //   315	326	232	java/io/EOFException
    //   326	340	232	java/io/EOFException
    //   345	370	232	java/io/EOFException
    //   382	430	232	java/io/EOFException
    //   445	472	232	java/io/EOFException
    //   487	497	232	java/io/EOFException
    //   497	523	232	java/io/EOFException
  }

  private void g()
  {
    a(this.n);
    Iterator localIterator = this.w.values().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (d.a(locald) == null)
      {
        for (int i2 = 0; i2 < this.s; i2++)
        {
          this.t += d.b(locald)[i2];
          this.u = (1 + this.u);
        }
      }
      else
      {
        d.a(locald, null);
        for (int i1 = 0; i1 < this.s; i1++)
        {
          a(locald.a(i1));
          a(locald.b(i1));
        }
        localIterator.remove();
      }
    }
  }

  private void h()
  {
    BufferedWriter localBufferedWriter;
    while (true)
    {
      d locald;
      try
      {
        if (this.v != null)
          this.v.close();
        localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.n), g.a));
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.p));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.s));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.w.values().iterator();
          if (!localIterator.hasNext())
            break;
          locald = (d)localIterator.next();
          if (d.a(locald) != null)
          {
            localBufferedWriter.write("DIRTY " + d.c(locald) + '\n');
            continue;
          }
        }
        finally
        {
          localBufferedWriter.close();
        }
      }
      finally
      {
      }
      localBufferedWriter.write("CLEAN " + d.c(locald) + locald.a() + '\n');
    }
    localBufferedWriter.close();
    if (this.m.exists())
      a(this.m, this.o, true);
    a(this.n, this.m, false);
    this.o.delete();
    this.v = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.m, true), g.a));
  }

  private long i()
  {
    try
    {
      long l1 = this.t;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private long j()
  {
    try
    {
      int i1 = this.u;
      long l1 = i1;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private boolean k()
  {
    return (this.x >= 2000) && (this.x >= this.w.size());
  }

  private boolean l()
  {
    try
    {
      Writer localWriter = this.v;
      if (localWriter == null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  private void m()
  {
    if (this.v == null)
      throw new IllegalStateException("cache is closed");
  }

  private void n()
  {
    try
    {
      m();
      o();
      p();
      this.v.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void o()
  {
    while (this.t > this.q)
      c((String)((Map.Entry)this.w.entrySet().iterator().next()).getKey());
  }

  private void p()
  {
    while (this.u > this.r)
      c((String)((Map.Entry)this.w.entrySet().iterator().next()).getKey());
  }

  public final DiskLruCache.Snapshot a(String paramString)
  {
    while (true)
    {
      try
      {
        m();
        e(paramString);
        d locald = (d)this.w.get(paramString);
        if (locald == null)
        {
          localSnapshot = null;
          return localSnapshot;
        }
        if (!d.d(locald))
        {
          localSnapshot = null;
          continue;
        }
        File[] arrayOfFile = new File[this.s];
        InputStream[] arrayOfInputStream = new InputStream[this.s];
        int i1 = 0;
        int i2;
        try
        {
          if (i1 >= this.s)
            continue;
          File localFile = locald.a(i1);
          arrayOfFile[i1] = localFile;
          arrayOfInputStream[i1] = new FileInputStream(localFile);
          i1++;
          continue;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          i2 = 0;
          if (i2 >= this.s)
            break label239;
        }
        if (arrayOfInputStream[i2] != null)
        {
          g.a(arrayOfInputStream[i2]);
          i2++;
          continue;
          this.x = (1 + this.x);
          this.v.append("READ " + paramString + '\n');
          if (k())
            this.z.submit(this.A);
          localSnapshot = new DiskLruCache.Snapshot(this, paramString, d.e(locald), arrayOfFile, arrayOfInputStream, d.b(locald), (byte)0);
          continue;
        }
      }
      finally
      {
      }
      label239: DiskLruCache.Snapshot localSnapshot = null;
    }
  }

  public final File a()
  {
    return this.l;
  }

  public final long b()
  {
    try
    {
      long l1 = this.q;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final DiskLruCache.Editor b(String paramString)
  {
    return a(paramString, -1L);
  }

  public final int c()
  {
    try
    {
      int i1 = this.r;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final boolean c(String paramString)
  {
    while (true)
    {
      try
      {
        m();
        e(paramString);
        d locald = (d)this.w.get(paramString);
        int i1;
        if (locald != null)
        {
          DiskLruCache.Editor localEditor = d.a(locald);
          i1 = 0;
          if (localEditor == null);
        }
        else
        {
          bool = false;
          return bool;
          this.t -= d.b(locald)[i1];
          this.u = (-1 + this.u);
          d.b(locald)[i1] = 0L;
          i1++;
        }
        if (i1 < this.s)
        {
          File localFile = locald.a(i1);
          if ((!localFile.exists()) || (localFile.delete()))
            continue;
          throw new IOException("failed to delete " + localFile);
        }
      }
      finally
      {
      }
      this.x = (1 + this.x);
      this.v.append("REMOVE " + paramString + '\n');
      this.w.remove(paramString);
      if (k())
        this.z.submit(this.A);
      boolean bool = true;
    }
  }

  public final void close()
  {
    while (true)
    {
      try
      {
        Writer localWriter = this.v;
        if (localWriter == null)
          return;
        Iterator localIterator = new ArrayList(this.w.values()).iterator();
        if (localIterator.hasNext())
        {
          d locald = (d)localIterator.next();
          if (d.a(locald) == null)
            continue;
          d.a(locald).abort();
          continue;
        }
      }
      finally
      {
      }
      o();
      p();
      this.v.close();
      this.v = null;
    }
  }

  public final void d()
  {
    close();
    g.a(this.l);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache
 * JD-Core Version:    0.6.2
 */