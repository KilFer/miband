package com.tencent.mm.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants.Resolver;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class a
  implements SharedPreferences.Editor
{
  private Map<String, Object> a = new HashMap();
  private Set<String> b = new HashSet();
  private boolean c = false;
  private ContentResolver d;

  public a(ContentResolver paramContentResolver)
  {
    this.d = paramContentResolver;
  }

  public final void apply()
  {
  }

  public final SharedPreferences.Editor clear()
  {
    this.c = true;
    return this;
  }

  public final boolean commit()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.c)
    {
      this.d.delete(MMPluginProviderConstants.SharedPref.CONTENT_URI, null, null);
      this.c = false;
    }
    Iterator localIterator1 = this.b.iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      this.d.delete(MMPluginProviderConstants.SharedPref.CONTENT_URI, "key = ?", new String[] { str });
    }
    Iterator localIterator2 = this.a.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      if (MMPluginProviderConstants.Resolver.unresolveObj(localContentValues, localEntry.getValue()))
      {
        ContentResolver localContentResolver = this.d;
        Uri localUri = MMPluginProviderConstants.SharedPref.CONTENT_URI;
        String[] arrayOfString = new String[1];
        arrayOfString[0] = ((String)localEntry.getKey());
        localContentResolver.update(localUri, localContentValues, "key = ?", arrayOfString);
      }
    }
    return true;
  }

  public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    this.a.put(paramString, Boolean.valueOf(paramBoolean));
    this.b.remove(paramString);
    return this;
  }

  public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    this.a.put(paramString, Float.valueOf(paramFloat));
    this.b.remove(paramString);
    return this;
  }

  public final SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    this.a.put(paramString, Integer.valueOf(paramInt));
    this.b.remove(paramString);
    return this;
  }

  public final SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    this.a.put(paramString, Long.valueOf(paramLong));
    this.b.remove(paramString);
    return this;
  }

  public final SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    this.a.put(paramString1, paramString2);
    this.b.remove(paramString1);
    return this;
  }

  public final SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    return null;
  }

  public final SharedPreferences.Editor remove(String paramString)
  {
    this.b.add(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.a
 * JD-Core Version:    0.6.2
 */