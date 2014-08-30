package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.User;
import com.tencent.stat.event.Event;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class StatStore
{
  private static StatLogger e = StatCommonHelper.getLogger();
  private static StatStore f = null;
  volatile int a = 0;
  private s b;
  private Handler c = null;
  private User d = null;
  private HashMap<String, String> g = new HashMap();

  private StatStore(Context paramContext)
  {
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("StatStore");
      localHandlerThread.start();
      e.w("Launch store thread:" + localHandlerThread);
      this.c = new Handler(localHandlerThread.getLooper());
      Context localContext = paramContext.getApplicationContext();
      this.b = new s(localContext);
      this.b.getWritableDatabase();
      this.b.getReadableDatabase();
      getUser(localContext);
      this.c.post(new p(this));
      d();
      this.c.post(new k(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      e.e(localThrowable);
    }
  }

  private void b()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(1));
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(2L);
    localSQLiteDatabase.update("events", localContentValues, "status=?", arrayOfString);
    this.a = ((int)DatabaseUtils.queryNumEntries(this.b.getReadableDatabase(), "events"));
    e.i("Total " + this.a + " unsent events.");
  }

  private void b(List<t> paramList)
  {
    e.i("Delete " + paramList.size() + " sent events in thread:" + Thread.currentThread());
    try
    {
      this.b.getWritableDatabase().beginTransaction();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        t localt = (t)localIterator.next();
        int i = this.a;
        SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = Long.toString(localt.a);
        this.a = (i - localSQLiteDatabase.delete("events", "event_id = ?", arrayOfString));
      }
    }
    catch (SQLiteException localSQLiteException2)
    {
      localSQLiteException2 = localSQLiteException2;
      e.e(localSQLiteException2);
      try
      {
        this.b.getWritableDatabase().endTransaction();
        return;
        this.b.getWritableDatabase().setTransactionSuccessful();
        this.a = ((int)DatabaseUtils.queryNumEntries(this.b.getReadableDatabase(), "events"));
        try
        {
          this.b.getWritableDatabase().endTransaction();
          return;
        }
        catch (SQLiteException localSQLiteException4)
        {
          e.e(localSQLiteException4);
          return;
        }
      }
      catch (SQLiteException localSQLiteException3)
      {
        e.e(localSQLiteException3);
        return;
      }
    }
    finally
    {
    }
    try
    {
      this.b.getWritableDatabase().endTransaction();
      throw localObject;
    }
    catch (SQLiteException localSQLiteException1)
    {
      while (true)
        e.e(localSQLiteException1);
    }
  }

  // ERROR //
  private void b(List<t> paramList, int paramInt)
  {
    // Byte code:
    //   0: getstatic 29	com/tencent/stat/StatStore:e	Lcom/tencent/stat/common/StatLogger;
    //   3: new 60	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 283
    //   10: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_1
    //   14: invokeinterface 242 1 0
    //   19: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc_w 285
    //   25: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_2
    //   29: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc_w 287
    //   35: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokestatic 250	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   41: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 178	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   50: new 127	android/content/ContentValues
    //   53: dup
    //   54: invokespecial 128	android/content/ContentValues:<init>	()V
    //   57: astore_3
    //   58: aload_3
    //   59: ldc 130
    //   61: iload_2
    //   62: invokestatic 192	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   65: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   72: invokevirtual 102	com/tencent/stat/s:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   75: invokevirtual 253	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   78: aload_1
    //   79: invokeinterface 257 1 0
    //   84: astore 8
    //   86: aload 8
    //   88: invokeinterface 262 1 0
    //   93: ifeq +250 -> 343
    //   96: aload 8
    //   98: invokeinterface 266 1 0
    //   103: checkcast 206	com/tencent/stat/t
    //   106: astore 10
    //   108: iconst_1
    //   109: aload 10
    //   111: getfield 292	com/tencent/stat/t:c	I
    //   114: iadd
    //   115: invokestatic 297	com/tencent/stat/StatConfig:getMaxSendRetryCount	()I
    //   118: if_icmple +79 -> 197
    //   121: aload_0
    //   122: getfield 41	com/tencent/stat/StatStore:a	I
    //   125: istore 14
    //   127: aload_0
    //   128: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   131: invokevirtual 102	com/tencent/stat/s:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   134: astore 15
    //   136: iconst_1
    //   137: anewarray 142	java/lang/String
    //   140: astore 16
    //   142: aload 16
    //   144: iconst_0
    //   145: aload 10
    //   147: getfield 269	com/tencent/stat/t:a	J
    //   150: invokestatic 149	java/lang/Long:toString	(J)Ljava/lang/String;
    //   153: aastore
    //   154: aload_0
    //   155: iload 14
    //   157: aload 15
    //   159: ldc 151
    //   161: ldc_w 299
    //   164: aload 16
    //   166: invokevirtual 275	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   169: isub
    //   170: putfield 41	com/tencent/stat/StatStore:a	I
    //   173: goto -87 -> 86
    //   176: astore 6
    //   178: getstatic 29	com/tencent/stat/StatStore:e	Lcom/tencent/stat/common/StatLogger;
    //   181: aload 6
    //   183: invokevirtual 233	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Exception;)V
    //   186: aload_0
    //   187: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   190: invokevirtual 102	com/tencent/stat/s:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   193: invokevirtual 278	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   196: return
    //   197: aload_3
    //   198: ldc_w 301
    //   201: iconst_1
    //   202: aload 10
    //   204: getfield 292	com/tencent/stat/t:c	I
    //   207: iadd
    //   208: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: invokevirtual 140	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   214: getstatic 29	com/tencent/stat/StatStore:e	Lcom/tencent/stat/common/StatLogger;
    //   217: new 60	java/lang/StringBuilder
    //   220: dup
    //   221: ldc_w 303
    //   224: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   227: aload 10
    //   229: getfield 269	com/tencent/stat/t:a	J
    //   232: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   235: ldc_w 308
    //   238: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_3
    //   242: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokevirtual 178	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   251: aload_0
    //   252: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   255: invokevirtual 102	com/tencent/stat/s:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   258: astore 11
    //   260: iconst_1
    //   261: anewarray 142	java/lang/String
    //   264: astore 12
    //   266: aload 12
    //   268: iconst_0
    //   269: aload 10
    //   271: getfield 269	com/tencent/stat/t:a	J
    //   274: invokestatic 149	java/lang/Long:toString	(J)Ljava/lang/String;
    //   277: aastore
    //   278: aload 11
    //   280: ldc 151
    //   282: aload_3
    //   283: ldc_w 299
    //   286: aload 12
    //   288: invokevirtual 159	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   291: istore 13
    //   293: iload 13
    //   295: ifgt -209 -> 86
    //   298: getstatic 29	com/tencent/stat/StatStore:e	Lcom/tencent/stat/common/StatLogger;
    //   301: new 60	java/lang/StringBuilder
    //   304: dup
    //   305: ldc_w 310
    //   308: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: iload 13
    //   313: invokestatic 192	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   316: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokevirtual 125	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   325: goto -239 -> 86
    //   328: astore 4
    //   330: aload_0
    //   331: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   334: invokevirtual 102	com/tencent/stat/s:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   337: invokevirtual 278	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   340: aload 4
    //   342: athrow
    //   343: aload_0
    //   344: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   347: invokevirtual 102	com/tencent/stat/s:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   350: invokevirtual 281	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   353: aload_0
    //   354: aload_0
    //   355: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   358: invokevirtual 105	com/tencent/stat/s:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   361: ldc 151
    //   363: invokestatic 165	android/database/DatabaseUtils:queryNumEntries	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)J
    //   366: l2i
    //   367: putfield 41	com/tencent/stat/StatStore:a	I
    //   370: aload_0
    //   371: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   374: invokevirtual 102	com/tencent/stat/s:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   377: invokevirtual 278	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   380: return
    //   381: astore 9
    //   383: getstatic 29	com/tencent/stat/StatStore:e	Lcom/tencent/stat/common/StatLogger;
    //   386: aload 9
    //   388: invokevirtual 233	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Exception;)V
    //   391: return
    //   392: astore 7
    //   394: getstatic 29	com/tencent/stat/StatStore:e	Lcom/tencent/stat/common/StatLogger;
    //   397: aload 7
    //   399: invokevirtual 233	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Exception;)V
    //   402: return
    //   403: astore 5
    //   405: getstatic 29	com/tencent/stat/StatStore:e	Lcom/tencent/stat/common/StatLogger;
    //   408: aload 5
    //   410: invokevirtual 233	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Exception;)V
    //   413: goto -73 -> 340
    //
    // Exception table:
    //   from	to	target	type
    //   50	86	176	android/database/sqlite/SQLiteException
    //   86	173	176	android/database/sqlite/SQLiteException
    //   197	293	176	android/database/sqlite/SQLiteException
    //   298	325	176	android/database/sqlite/SQLiteException
    //   343	370	176	android/database/sqlite/SQLiteException
    //   50	86	328	finally
    //   86	173	328	finally
    //   178	186	328	finally
    //   197	293	328	finally
    //   298	325	328	finally
    //   343	370	328	finally
    //   370	380	381	android/database/sqlite/SQLiteException
    //   186	196	392	android/database/sqlite/SQLiteException
    //   330	340	403	android/database/sqlite/SQLiteException
  }

  private void c()
  {
    this.c.post(new p(this));
  }

  // ERROR //
  private void c(List<t> paramList, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   6: invokevirtual 105	com/tencent/stat/s:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore 7
    //   11: iconst_1
    //   12: anewarray 142	java/lang/String
    //   15: astore 8
    //   17: aload 8
    //   19: iconst_0
    //   20: iconst_1
    //   21: invokestatic 192	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   24: aastore
    //   25: aload 7
    //   27: ldc 151
    //   29: aconst_null
    //   30: ldc 153
    //   32: aload 8
    //   34: aconst_null
    //   35: aconst_null
    //   36: ldc 194
    //   38: iload_2
    //   39: invokestatic 192	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   42: invokevirtual 198	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore 9
    //   47: aload 9
    //   49: invokeinterface 204 1 0
    //   54: ifeq +82 -> 136
    //   57: aload_1
    //   58: new 206	com/tencent/stat/t
    //   61: dup
    //   62: aload 9
    //   64: iconst_0
    //   65: invokeinterface 210 2 0
    //   70: aload 9
    //   72: iconst_1
    //   73: invokeinterface 213 2 0
    //   78: invokestatic 217	com/tencent/stat/common/StatCommonHelper:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   81: aload 9
    //   83: iconst_2
    //   84: invokeinterface 221 2 0
    //   89: aload 9
    //   91: iconst_3
    //   92: invokeinterface 221 2 0
    //   97: invokespecial 224	com/tencent/stat/t:<init>	(JLjava/lang/String;II)V
    //   100: invokeinterface 230 2 0
    //   105: pop
    //   106: goto -59 -> 47
    //   109: astore 4
    //   111: aload 9
    //   113: astore 5
    //   115: getstatic 29	com/tencent/stat/StatStore:e	Lcom/tencent/stat/common/StatLogger;
    //   118: aload 4
    //   120: invokevirtual 233	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Exception;)V
    //   123: aload 5
    //   125: ifnull +10 -> 135
    //   128: aload 5
    //   130: invokeinterface 236 1 0
    //   135: return
    //   136: aload 9
    //   138: ifnull -3 -> 135
    //   141: aload 9
    //   143: invokeinterface 236 1 0
    //   148: return
    //   149: astore 6
    //   151: aload_3
    //   152: ifnull +9 -> 161
    //   155: aload_3
    //   156: invokeinterface 236 1 0
    //   161: aload 6
    //   163: athrow
    //   164: astore 6
    //   166: aload 9
    //   168: astore_3
    //   169: goto -18 -> 151
    //   172: astore 6
    //   174: aload 5
    //   176: astore_3
    //   177: goto -26 -> 151
    //   180: astore 4
    //   182: aconst_null
    //   183: astore 5
    //   185: goto -70 -> 115
    //
    // Exception table:
    //   from	to	target	type
    //   47	106	109	android/database/sqlite/SQLiteException
    //   2	47	149	finally
    //   47	106	164	finally
    //   115	123	172	finally
    //   2	47	180	android/database/sqlite/SQLiteException
  }

  // ERROR //
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   4: invokevirtual 105	com/tencent/stat/s:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc_w 312
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 315	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 4
    //   21: aload 4
    //   23: astore_2
    //   24: aload_2
    //   25: invokeinterface 204 1 0
    //   30: ifeq +47 -> 77
    //   33: aload_0
    //   34: getfield 48	com/tencent/stat/StatStore:g	Ljava/util/HashMap;
    //   37: aload_2
    //   38: iconst_0
    //   39: invokeinterface 213 2 0
    //   44: aload_2
    //   45: iconst_1
    //   46: invokeinterface 213 2 0
    //   51: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: goto -31 -> 24
    //   58: astore_1
    //   59: getstatic 29	com/tencent/stat/StatStore:e	Lcom/tencent/stat/common/StatLogger;
    //   62: aload_1
    //   63: invokevirtual 233	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Exception;)V
    //   66: aload_2
    //   67: ifnull +9 -> 76
    //   70: aload_2
    //   71: invokeinterface 236 1 0
    //   76: return
    //   77: aload_2
    //   78: ifnull -2 -> 76
    //   81: aload_2
    //   82: invokeinterface 236 1 0
    //   87: return
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull +9 -> 101
    //   95: aload_2
    //   96: invokeinterface 236 1 0
    //   101: aload_3
    //   102: athrow
    //   103: astore_3
    //   104: goto -13 -> 91
    //   107: astore_1
    //   108: aconst_null
    //   109: astore_2
    //   110: goto -51 -> 59
    //
    // Exception table:
    //   from	to	target	type
    //   24	55	58	android/database/sqlite/SQLiteException
    //   0	21	88	finally
    //   24	55	103	finally
    //   59	66	103	finally
    //   0	21	107	android/database/sqlite/SQLiteException
  }

  public static StatStore getInstance()
  {
    return f;
  }

  public static StatStore getInstance(Context paramContext)
  {
    if (f == null)
      f = new StatStore(paramContext);
    return f;
  }

  final void a(int paramInt)
  {
    this.c.post(new q(this, paramInt));
  }

  final void a(a parama)
  {
    if (parama == null)
      return;
    try
    {
      this.c.post(new o(this, parama));
      return;
    }
    catch (Exception localException)
    {
      e.e(localException);
    }
  }

  final void a(Event paramEvent, b paramb)
  {
    if (StatConfig.getMaxStoreEventCount() <= 0);
    do
    {
      return;
      if (this.a > StatConfig.getMaxStoreEventCount())
      {
        e.warn("Too many events stored in db.");
        this.a -= this.b.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
      }
      ContentValues localContentValues = new ContentValues();
      String str = StatCommonHelper.encode(paramEvent.toJsonString());
      localContentValues.put("content", str);
      localContentValues.put("send_count", "0");
      localContentValues.put("status", Integer.toString(1));
      localContentValues.put("timestamp", Long.valueOf(paramEvent.getTimestamp()));
      if (this.b.getWritableDatabase().insert("events", null, localContentValues) == -1L)
      {
        e.error("Failed to store event:" + str);
        return;
      }
      this.a = (1 + this.a);
    }
    while (paramb == null);
    paramb.a();
  }

  final void a(List<t> paramList)
  {
    try
    {
      if (Thread.currentThread().getId() == this.c.getLooper().getThread().getId())
      {
        b(paramList);
        return;
      }
      this.c.post(new m(this, paramList));
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      e.e(localSQLiteException);
    }
  }

  final void a(List<t> paramList, int paramInt)
  {
    try
    {
      if (Thread.currentThread().getId() == this.c.getLooper().getThread().getId())
      {
        b(paramList, 1);
        return;
      }
      this.c.post(new l(this, paramList, 1));
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      e.e(localSQLiteException);
    }
  }

  final void b(Event paramEvent, b paramb)
  {
    if (!StatConfig.isEnableStatService())
      return;
    try
    {
      if (Thread.currentThread().getId() == this.c.getLooper().getThread().getId())
      {
        a(paramEvent, paramb);
        return;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      e.e(localSQLiteException);
      return;
    }
    this.c.post(new n(this, paramEvent, paramb));
  }

  public int getNumStoredEvents()
  {
    return this.a;
  }

  // ERROR //
  public User getUser(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/tencent/stat/StatStore:d	Lcom/tencent/stat/common/User;
    //   4: ifnull +8 -> 12
    //   7: aload_0
    //   8: getfield 43	com/tencent/stat/StatStore:d	Lcom/tencent/stat/common/User;
    //   11: areturn
    //   12: aload_0
    //   13: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   16: invokevirtual 105	com/tencent/stat/s:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: ldc_w 416
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 198	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 6
    //   34: aload 6
    //   36: astore_3
    //   37: aload_3
    //   38: invokeinterface 204 1 0
    //   43: istore 7
    //   45: iconst_0
    //   46: istore 8
    //   48: iload 7
    //   50: ifeq +358 -> 408
    //   53: aload_3
    //   54: iconst_0
    //   55: invokeinterface 213 2 0
    //   60: astore 9
    //   62: aload 9
    //   64: invokestatic 217	com/tencent/stat/common/StatCommonHelper:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 10
    //   69: aload_3
    //   70: iconst_1
    //   71: invokeinterface 221 2 0
    //   76: istore 11
    //   78: aload_3
    //   79: iconst_2
    //   80: invokeinterface 213 2 0
    //   85: astore 12
    //   87: aload_3
    //   88: iconst_3
    //   89: invokeinterface 210 2 0
    //   94: lstore 13
    //   96: invokestatic 421	java/lang/System:currentTimeMillis	()J
    //   99: ldc2_w 422
    //   102: ldiv
    //   103: lstore 15
    //   105: iload 11
    //   107: iconst_1
    //   108: if_icmpeq +651 -> 759
    //   111: lload 13
    //   113: ldc2_w 422
    //   116: lmul
    //   117: invokestatic 426	com/tencent/stat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   120: ldc2_w 422
    //   123: lload 15
    //   125: lmul
    //   126: invokestatic 426	com/tencent/stat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   129: invokevirtual 429	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   132: ifne +627 -> 759
    //   135: iconst_1
    //   136: istore 17
    //   138: aload 12
    //   140: aload_1
    //   141: invokestatic 433	com/tencent/stat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   144: invokevirtual 429	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   147: ifne +605 -> 752
    //   150: iload 17
    //   152: iconst_2
    //   153: ior
    //   154: istore 18
    //   156: aload 10
    //   158: ldc_w 435
    //   161: invokevirtual 439	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   164: astore 19
    //   166: aload 19
    //   168: ifnull +418 -> 586
    //   171: aload 19
    //   173: arraylength
    //   174: ifle +412 -> 586
    //   177: aload 19
    //   179: iconst_0
    //   180: aaload
    //   181: astore 38
    //   183: aload 38
    //   185: ifnull +13 -> 198
    //   188: aload 38
    //   190: invokevirtual 442	java/lang/String:length	()I
    //   193: bipush 11
    //   195: if_icmpge +543 -> 738
    //   198: aload_1
    //   199: invokestatic 445	com/tencent/stat/common/StatCommonHelper:getDeviceID	(Landroid/content/Context;)Ljava/lang/String;
    //   202: astore 39
    //   204: aload 39
    //   206: ifnull +522 -> 728
    //   209: aload 39
    //   211: invokevirtual 442	java/lang/String:length	()I
    //   214: bipush 10
    //   216: if_icmple +512 -> 728
    //   219: iconst_1
    //   220: istore 21
    //   222: goto +544 -> 766
    //   225: aload 19
    //   227: ifnull +375 -> 602
    //   230: aload 19
    //   232: arraylength
    //   233: iconst_2
    //   234: if_icmplt +368 -> 602
    //   237: aload 19
    //   239: iconst_1
    //   240: aaload
    //   241: astore 23
    //   243: new 60	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 446	java/lang/StringBuilder:<init>	()V
    //   250: aload 22
    //   252: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc_w 435
    //   258: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 23
    //   263: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: astore 20
    //   271: aload_0
    //   272: new 448	com/tencent/stat/common/User
    //   275: dup
    //   276: aload 22
    //   278: aload 23
    //   280: iload 18
    //   282: invokespecial 451	com/tencent/stat/common/User:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   285: putfield 43	com/tencent/stat/StatStore:d	Lcom/tencent/stat/common/User;
    //   288: new 127	android/content/ContentValues
    //   291: dup
    //   292: invokespecial 128	android/content/ContentValues:<init>	()V
    //   295: astore 25
    //   297: aload 25
    //   299: ldc_w 453
    //   302: aload 20
    //   304: invokestatic 355	com/tencent/stat/common/StatCommonHelper:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   307: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload 25
    //   312: ldc_w 455
    //   315: iload 18
    //   317: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   320: invokevirtual 140	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   323: aload 25
    //   325: ldc_w 457
    //   328: aload_1
    //   329: invokestatic 433	com/tencent/stat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   332: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: aload 25
    //   337: ldc_w 459
    //   340: lload 15
    //   342: invokestatic 368	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   345: invokevirtual 371	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   348: iload 21
    //   350: ifeq +31 -> 381
    //   353: aload_0
    //   354: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   357: invokevirtual 102	com/tencent/stat/s:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   360: ldc_w 416
    //   363: aload 25
    //   365: ldc_w 461
    //   368: iconst_1
    //   369: anewarray 142	java/lang/String
    //   372: dup
    //   373: iconst_0
    //   374: aload 9
    //   376: aastore
    //   377: invokevirtual 159	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   380: pop
    //   381: iload 18
    //   383: iload 11
    //   385: if_icmpeq +392 -> 777
    //   388: aload_0
    //   389: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   392: invokevirtual 102	com/tencent/stat/s:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   395: ldc_w 416
    //   398: aconst_null
    //   399: aload 25
    //   401: invokevirtual 464	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   404: pop2
    //   405: goto +372 -> 777
    //   408: iload 8
    //   410: ifne +161 -> 571
    //   413: aload_1
    //   414: invokestatic 467	com/tencent/stat/common/StatCommonHelper:getUserID	(Landroid/content/Context;)Ljava/lang/String;
    //   417: astore 29
    //   419: aload_1
    //   420: invokestatic 470	com/tencent/stat/common/StatCommonHelper:getMacId	(Landroid/content/Context;)Ljava/lang/String;
    //   423: astore 30
    //   425: aload 30
    //   427: ifnull +294 -> 721
    //   430: aload 30
    //   432: invokevirtual 442	java/lang/String:length	()I
    //   435: ifle +286 -> 721
    //   438: new 60	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 446	java/lang/StringBuilder:<init>	()V
    //   445: aload 29
    //   447: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: ldc_w 435
    //   453: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload 30
    //   458: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: astore 31
    //   466: invokestatic 421	java/lang/System:currentTimeMillis	()J
    //   469: ldc2_w 422
    //   472: ldiv
    //   473: lstore 32
    //   475: aload_1
    //   476: invokestatic 433	com/tencent/stat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   479: astore 34
    //   481: new 127	android/content/ContentValues
    //   484: dup
    //   485: invokespecial 128	android/content/ContentValues:<init>	()V
    //   488: astore 35
    //   490: aload 35
    //   492: ldc_w 453
    //   495: aload 31
    //   497: invokestatic 355	com/tencent/stat/common/StatCommonHelper:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   500: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: aload 35
    //   505: ldc_w 455
    //   508: iconst_0
    //   509: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   512: invokevirtual 140	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   515: aload 35
    //   517: ldc_w 457
    //   520: aload 34
    //   522: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload 35
    //   527: ldc_w 459
    //   530: lload 32
    //   532: invokestatic 368	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   535: invokevirtual 371	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   538: aload_0
    //   539: getfield 98	com/tencent/stat/StatStore:b	Lcom/tencent/stat/s;
    //   542: invokevirtual 102	com/tencent/stat/s:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   545: ldc_w 416
    //   548: aconst_null
    //   549: aload 35
    //   551: invokevirtual 375	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   554: pop2
    //   555: aload_0
    //   556: new 448	com/tencent/stat/common/User
    //   559: dup
    //   560: aload 29
    //   562: aload 30
    //   564: iconst_0
    //   565: invokespecial 451	com/tencent/stat/common/User:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   568: putfield 43	com/tencent/stat/StatStore:d	Lcom/tencent/stat/common/User;
    //   571: aload_3
    //   572: ifnull +9 -> 581
    //   575: aload_3
    //   576: invokeinterface 236 1 0
    //   581: aload_0
    //   582: getfield 43	com/tencent/stat/StatStore:d	Lcom/tencent/stat/common/User;
    //   585: areturn
    //   586: aload_1
    //   587: invokestatic 467	com/tencent/stat/common/StatCommonHelper:getUserID	(Landroid/content/Context;)Ljava/lang/String;
    //   590: astore 20
    //   592: iconst_1
    //   593: istore 21
    //   595: aload 20
    //   597: astore 22
    //   599: goto -374 -> 225
    //   602: aload_1
    //   603: invokestatic 470	com/tencent/stat/common/StatCommonHelper:getMacId	(Landroid/content/Context;)Ljava/lang/String;
    //   606: astore 23
    //   608: aload 23
    //   610: ifnull -339 -> 271
    //   613: aload 23
    //   615: invokevirtual 442	java/lang/String:length	()I
    //   618: ifle -347 -> 271
    //   621: new 60	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 446	java/lang/StringBuilder:<init>	()V
    //   628: aload 22
    //   630: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: ldc_w 435
    //   636: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: aload 23
    //   641: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: astore 24
    //   649: aload 24
    //   651: astore 20
    //   653: iconst_1
    //   654: istore 21
    //   656: goto -385 -> 271
    //   659: astore 4
    //   661: aconst_null
    //   662: astore 5
    //   664: getstatic 29	com/tencent/stat/StatStore:e	Lcom/tencent/stat/common/StatLogger;
    //   667: aload 4
    //   669: invokevirtual 125	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   672: aload 5
    //   674: ifnull -93 -> 581
    //   677: aload 5
    //   679: invokeinterface 236 1 0
    //   684: goto -103 -> 581
    //   687: astore_2
    //   688: aconst_null
    //   689: astore_3
    //   690: aload_3
    //   691: ifnull +9 -> 700
    //   694: aload_3
    //   695: invokeinterface 236 1 0
    //   700: aload_2
    //   701: athrow
    //   702: astore_2
    //   703: goto -13 -> 690
    //   706: astore_2
    //   707: aload 5
    //   709: astore_3
    //   710: goto -20 -> 690
    //   713: astore 4
    //   715: aload_3
    //   716: astore 5
    //   718: goto -54 -> 664
    //   721: aload 29
    //   723: astore 31
    //   725: goto -259 -> 466
    //   728: aload 38
    //   730: astore 39
    //   732: iconst_0
    //   733: istore 21
    //   735: goto +31 -> 766
    //   738: aload 10
    //   740: astore 20
    //   742: aload 38
    //   744: astore 22
    //   746: iconst_0
    //   747: istore 21
    //   749: goto -524 -> 225
    //   752: iload 17
    //   754: istore 18
    //   756: goto -600 -> 156
    //   759: iload 11
    //   761: istore 17
    //   763: goto -625 -> 138
    //   766: aload 10
    //   768: astore 20
    //   770: aload 39
    //   772: astore 22
    //   774: goto -549 -> 225
    //   777: iconst_1
    //   778: istore 8
    //   780: goto -372 -> 408
    //
    // Exception table:
    //   from	to	target	type
    //   12	34	659	java/lang/Throwable
    //   12	34	687	finally
    //   37	45	702	finally
    //   53	105	702	finally
    //   111	135	702	finally
    //   138	150	702	finally
    //   156	166	702	finally
    //   171	183	702	finally
    //   188	198	702	finally
    //   198	204	702	finally
    //   209	219	702	finally
    //   230	271	702	finally
    //   271	348	702	finally
    //   353	381	702	finally
    //   388	405	702	finally
    //   413	425	702	finally
    //   430	466	702	finally
    //   466	571	702	finally
    //   586	592	702	finally
    //   602	608	702	finally
    //   613	649	702	finally
    //   664	672	706	finally
    //   37	45	713	java/lang/Throwable
    //   53	105	713	java/lang/Throwable
    //   111	135	713	java/lang/Throwable
    //   138	150	713	java/lang/Throwable
    //   156	166	713	java/lang/Throwable
    //   171	183	713	java/lang/Throwable
    //   188	198	713	java/lang/Throwable
    //   198	204	713	java/lang/Throwable
    //   209	219	713	java/lang/Throwable
    //   230	271	713	java/lang/Throwable
    //   271	348	713	java/lang/Throwable
    //   353	381	713	java/lang/Throwable
    //   388	405	713	java/lang/Throwable
    //   413	425	713	java/lang/Throwable
    //   430	466	713	java/lang/Throwable
    //   466	571	713	java/lang/Throwable
    //   586	592	713	java/lang/Throwable
    //   602	608	713	java/lang/Throwable
    //   613	649	713	java/lang/Throwable
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.StatStore
 * JD-Core Version:    0.6.2
 */