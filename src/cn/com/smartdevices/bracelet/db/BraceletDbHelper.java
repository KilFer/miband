package cn.com.smartdevices.bracelet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.UploadData;
import java.util.ArrayList;
import java.util.Iterator;

public class BraceletDbHelper extends SQLiteOpenHelper
{
  private static BraceletDbHelper a = null;
  private static final String b = "origin_db";
  private static final int c = 1;
  private static final String d = "date_data";
  private static final String e = "id";
  private static final String f = "date";
  private static final String g = "type";
  private static final String h = "source";
  private static final String i = "data";
  private static final String j = "summary";
  private static final String k = "sync";
  private static final String l = "indexs";

  public BraceletDbHelper(Context paramContext)
  {
    super(paramContext, "origin_db", null, 1);
  }

  public static void create(Context paramContext)
  {
    if (a == null)
      a = new BraceletDbHelper(paramContext);
  }

  public static BraceletDbHelper getInstance()
  {
    return a;
  }

  public String[] dateOfStartAndStop()
  {
    Cursor localCursor = getReadableDatabase().query("date_data", null, null, null, null, null, "date ASC");
    String[] arrayOfString = null;
    if (localCursor != null)
    {
      int m = localCursor.getCount();
      arrayOfString = null;
      if (m > 0)
      {
        arrayOfString = new String[2];
        localCursor.moveToFirst();
        arrayOfString[0] = localCursor.getString(localCursor.getColumnIndex("date"));
        localCursor.moveToLast();
        arrayOfString[1] = localCursor.getString(localCursor.getColumnIndex("date"));
      }
    }
    if (localCursor != null)
      localCursor.close();
    return arrayOfString;
  }

  public void dropAllDatas()
  {
    getWritableDatabase().execSQL("DELETE FROM date_data");
  }

  public int getCount()
  {
    Cursor localCursor = getReadableDatabase().query("date_data", null, null, null, null, null, null);
    if (localCursor != null)
    {
      int m = localCursor.getCount();
      localCursor.close();
      return m;
    }
    return 0;
  }

  public void insertDatas(ArrayList<UploadData> paramArrayList, int paramInt)
  {
    insertDatas(paramArrayList, paramInt, 0, 0);
  }

  public void insertDatas(ArrayList<UploadData> paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
      return;
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    Iterator localIterator = paramArrayList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        return;
      }
      UploadData localUploadData = (UploadData)localIterator.next();
      write(localSQLiteDatabase, localUploadData.date, localUploadData.data, paramInt2, paramInt3, paramInt1, localUploadData.summary, localUploadData.indexs);
    }
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE date_data(id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,source INTEGER,date TEXT,summary TEXT,indexs TEXT,data BLOB,sync INTEGER);");
  }

  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL(" DROP TABLE IF EXISTS date_data");
    onCreate(paramSQLiteDatabase);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL(" DROP TABLE IF EXISTS date_data");
    onCreate(paramSQLiteDatabase);
  }

  public ArrayList<UploadData> readNotSyncDatas()
  {
    return readNotSyncDatas(0, 0);
  }

  public ArrayList<UploadData> readNotSyncDatas(int paramInt1, int paramInt2)
  {
    String[] arrayOfString1 = { "date", "data", "summary", "indexs" };
    String[] arrayOfString2 = new String[3];
    arrayOfString2[0] = paramInt1;
    arrayOfString2[1] = paramInt2;
    arrayOfString2[2] = "0";
    Cursor localCursor = getReadableDatabase().query("date_data", arrayOfString1, "type=? AND source=? AND sync=?", arrayOfString2, null, null, "date ASC");
    if ((localCursor == null) || (localCursor.getCount() == 0))
    {
      if (localCursor != null)
        localCursor.close();
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.ensureCapacity(localCursor.getCount());
    localCursor.moveToFirst();
    while (true)
    {
      if (localCursor.isAfterLast())
      {
        localCursor.close();
        return localArrayList;
      }
      UploadData localUploadData = new UploadData();
      localUploadData.date = localCursor.getString(localCursor.getColumnIndex("date"));
      localUploadData.data = localCursor.getBlob(localCursor.getColumnIndex("data"));
      localUploadData.summary = localCursor.getString(localCursor.getColumnIndex("summary"));
      localUploadData.indexs = localCursor.getString(localCursor.getColumnIndex("indexs"));
      Debug.i("WPJ", "not sync data:" + localUploadData.date + ",size:" + localUploadData.data.length);
      localArrayList.add(localUploadData);
      localCursor.moveToNext();
    }
  }

  public byte[] readOriginData(String paramString)
  {
    return readOriginData(paramString, 0, 0);
  }

  public byte[] readOriginData(String paramString, int paramInt1, int paramInt2)
  {
    String[] arrayOfString1 = { "data" };
    String[] arrayOfString2 = new String[3];
    arrayOfString2[0] = paramString;
    arrayOfString2[1] = paramInt1;
    arrayOfString2[2] = paramInt2;
    Cursor localCursor = getReadableDatabase().query("date_data", arrayOfString1, "date=? AND type=? AND source=?", arrayOfString2, null, null, null);
    byte[] arrayOfByte = null;
    if (localCursor != null)
    {
      int m = localCursor.getCount();
      arrayOfByte = null;
      if (m != 0)
      {
        localCursor.moveToFirst();
        arrayOfByte = localCursor.getBlob(localCursor.getColumnIndex("data"));
      }
    }
    if (localCursor != null)
      localCursor.close();
    return arrayOfByte;
  }

  public String readSummary(String paramString)
  {
    String[] arrayOfString1 = { "summary" };
    String[] arrayOfString2 = { paramString };
    Cursor localCursor = getReadableDatabase().query("date_data", arrayOfString1, "date=?", arrayOfString2, null, null, null);
    String str = null;
    if (localCursor != null)
    {
      int m = localCursor.getCount();
      str = null;
      if (m > 0)
      {
        localCursor.moveToFirst();
        str = localCursor.getString(0);
      }
      localCursor.close();
    }
    return str;
  }

  public void updateSyncState(ArrayList<UploadData> paramArrayList, int paramInt)
  {
    updateSyncState(paramArrayList, paramInt, 0, 0);
  }

  public void updateSyncState(ArrayList<UploadData> paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
      return;
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    Iterator localIterator = paramArrayList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        return;
      }
      UploadData localUploadData = (UploadData)localIterator.next();
      String str = "update date_data set sync = " + paramInt1 + " where date" + " = '" + localUploadData.date + "' and " + "type = " + paramInt2 + " and source" + " = " + paramInt3 + ";";
      Debug.i("WPJ", "update sync state:" + str);
      localSQLiteDatabase.execSQL(str);
    }
  }

  public void write(SQLiteDatabase paramSQLiteDatabase, String paramString1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    Debug.i("BraceletDbHelper", "1======write......" + paramString1);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("type", Integer.valueOf(paramInt1));
    localContentValues.put("source", Integer.valueOf(paramInt2));
    localContentValues.put("date", paramString1);
    localContentValues.put("summary", paramString2);
    localContentValues.put("indexs", paramString3);
    localContentValues.put("data", paramArrayOfByte);
    localContentValues.put("sync", Integer.valueOf(paramInt3));
    String[] arrayOfString = new String[3];
    arrayOfString[0] = paramString1;
    arrayOfString[1] = paramInt1;
    arrayOfString[2] = paramInt2;
    Cursor localCursor = paramSQLiteDatabase.query("date_data", null, "date=? AND type=? AND source=?", arrayOfString, null, null, null);
    if ((localCursor != null) && (localCursor.getCount() > 0))
      paramSQLiteDatabase.update("date_data", localContentValues, "date=? AND type=? AND source=?", arrayOfString);
    while (true)
    {
      if (localCursor != null)
        localCursor.close();
      return;
      paramSQLiteDatabase.insert("date_data", null, localContentValues);
    }
  }

  public void write(String paramString1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    Debug.i("BraceletDbHelper", "0======write......" + paramString1);
    Debug.f("BraceletDbHelper", "date:" + paramString1 + ",data len:" + paramArrayOfByte.length + ",summary:" + paramString2 + ",indexs:" + paramString3);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("type", Integer.valueOf(paramInt1));
    localContentValues.put("source", Integer.valueOf(paramInt2));
    localContentValues.put("date", paramString1);
    localContentValues.put("summary", paramString2);
    localContentValues.put("indexs", paramString3);
    localContentValues.put("data", paramArrayOfByte);
    localContentValues.put("sync", Integer.valueOf(0));
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = paramString1;
    arrayOfString[1] = paramInt1;
    arrayOfString[2] = paramInt2;
    Cursor localCursor = localSQLiteDatabase.query("date_data", null, "date=? AND type=? AND source=?", arrayOfString, null, null, null);
    if ((localCursor != null) && (localCursor.getCount() > 0))
      localSQLiteDatabase.update("date_data", localContentValues, "date=? AND type=? AND source=?", arrayOfString);
    while (true)
    {
      if (localCursor != null)
        localCursor.close();
      return;
      localSQLiteDatabase.insert("date_data", null, localContentValues);
    }
  }

  public void write(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    write(paramString1, paramArrayOfByte, 0, 0, paramString2, paramString3);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.db.BraceletDbHelper
 * JD-Core Version:    0.6.2
 */