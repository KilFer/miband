package com.tencent.mm.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants.Resolver;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MMSharedPreferences
  implements SharedPreferences
{
  private final ContentResolver a;
  private final String[] b = { "_id", "key", "type", "value" };
  private final HashMap<String, Object> c = new HashMap();
  private a d = null;

  public MMSharedPreferences(Context paramContext)
  {
    this.a = paramContext.getContentResolver();
  }

  private Object a(String paramString)
  {
    while (true)
    {
      try
      {
        Cursor localCursor = this.a.query(MMPluginProviderConstants.SharedPref.CONTENT_URI, this.b, "key = ?", new String[] { paramString }, null);
        if (localCursor == null)
          return null;
        int i = localCursor.getColumnIndex("type");
        int j = localCursor.getColumnIndex("value");
        if (localCursor.moveToFirst())
        {
          localObject = MMPluginProviderConstants.Resolver.resolveObj(localCursor.getInt(i), localCursor.getString(j));
          localCursor.close();
          return localObject;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      Object localObject = null;
    }
  }

  public boolean contains(String paramString)
  {
    return a(paramString) != null;
  }

  public SharedPreferences.Editor edit()
  {
    if (this.d == null)
      this.d = new a(this.a);
    return this.d;
  }

  public Map<String, ?> getAll()
  {
    Cursor localCursor;
    try
    {
      localCursor = this.a.query(MMPluginProviderConstants.SharedPref.CONTENT_URI, this.b, null, null, null);
      if (localCursor == null)
        return null;
      int i = localCursor.getColumnIndex("key");
      int j = localCursor.getColumnIndex("type");
      int k = localCursor.getColumnIndex("value");
      while (localCursor.moveToNext())
      {
        Object localObject = MMPluginProviderConstants.Resolver.resolveObj(localCursor.getInt(j), localCursor.getString(k));
        this.c.put(localCursor.getString(i), localObject);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return this.c;
    }
    localCursor.close();
    HashMap localHashMap = this.c;
    return localHashMap;
  }

  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    Object localObject = a(paramString);
    if ((localObject != null) && ((localObject instanceof Boolean)))
      paramBoolean = ((Boolean)localObject).booleanValue();
    return paramBoolean;
  }

  public float getFloat(String paramString, float paramFloat)
  {
    Object localObject = a(paramString);
    if ((localObject != null) && ((localObject instanceof Float)))
      paramFloat = ((Float)localObject).floatValue();
    return paramFloat;
  }

  public int getInt(String paramString, int paramInt)
  {
    Object localObject = a(paramString);
    if ((localObject != null) && ((localObject instanceof Integer)))
      paramInt = ((Integer)localObject).intValue();
    return paramInt;
  }

  public long getLong(String paramString, long paramLong)
  {
    Object localObject = a(paramString);
    if ((localObject != null) && ((localObject instanceof Long)))
      paramLong = ((Long)localObject).longValue();
    return paramLong;
  }

  public String getString(String paramString1, String paramString2)
  {
    Object localObject = a(paramString1);
    if ((localObject != null) && ((localObject instanceof String)))
      return (String)localObject;
    return paramString2;
  }

  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return null;
  }

  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
  }

  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.MMSharedPreferences
 * JD-Core Version:    0.6.2
 */