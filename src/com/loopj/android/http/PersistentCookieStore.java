package com.loopj.android.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

public class PersistentCookieStore
  implements CookieStore
{
  private static final String a = "PersistentCookieStore";
  private static final String b = "CookiePrefsFile";
  private static final String c = "names";
  private static final String d = "cookie_";
  private boolean e = false;
  private final ConcurrentHashMap<String, Cookie> f;
  private final SharedPreferences g;

  public PersistentCookieStore(Context paramContext)
  {
    this.g = paramContext.getSharedPreferences("CookiePrefsFile", 0);
    this.f = new ConcurrentHashMap();
    String str1 = this.g.getString("names", null);
    String[] arrayOfString;
    int j;
    if (str1 != null)
    {
      arrayOfString = TextUtils.split(str1, ",");
      j = arrayOfString.length;
    }
    while (true)
    {
      if (i >= j)
      {
        clearExpired(new Date());
        return;
      }
      String str2 = arrayOfString[i];
      String str3 = this.g.getString("cookie_" + str2, null);
      if (str3 != null)
      {
        Cookie localCookie = decodeCookie(str3);
        if (localCookie != null)
          this.f.put(str2, localCookie);
      }
      i++;
    }
  }

  public void addCookie(Cookie paramCookie)
  {
    if ((this.e) && (!paramCookie.isPersistent()))
      return;
    String str = paramCookie.getName() + paramCookie.getDomain();
    if (!paramCookie.isExpired(new Date()))
      this.f.put(str, paramCookie);
    while (true)
    {
      SharedPreferences.Editor localEditor = this.g.edit();
      localEditor.putString("names", TextUtils.join(",", this.f.keySet()));
      localEditor.putString("cookie_" + str, encodeCookie(new SerializableCookie(paramCookie)));
      localEditor.commit();
      return;
      this.f.remove(str);
    }
  }

  protected String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length << 1);
    int i = paramArrayOfByte.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return localStringBuilder.toString().toUpperCase(Locale.US);
      int k = 0xFF & paramArrayOfByte[j];
      if (k < 16)
        localStringBuilder.append('0');
      localStringBuilder.append(Integer.toHexString(k));
    }
  }

  public void clear()
  {
    SharedPreferences.Editor localEditor = this.g.edit();
    Iterator localIterator = this.f.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localEditor.remove("names");
        localEditor.commit();
        this.f.clear();
        return;
      }
      String str = (String)localIterator.next();
      localEditor.remove("cookie_" + str);
    }
  }

  public boolean clearExpired(Date paramDate)
  {
    SharedPreferences.Editor localEditor = this.g.edit();
    Iterator localIterator = this.f.entrySet().iterator();
    boolean bool = false;
    while (true)
    {
      if (!localIterator.hasNext())
      {
        if (bool)
          localEditor.putString("names", TextUtils.join(",", this.f.keySet()));
        localEditor.commit();
        return bool;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (((Cookie)localEntry.getValue()).isExpired(paramDate))
      {
        this.f.remove(str);
        localEditor.remove("cookie_" + str);
        bool = true;
      }
    }
  }

  protected Cookie decodeCookie(String paramString)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(hexStringToByteArray(paramString));
    try
    {
      Cookie localCookie = ((SerializableCookie)new ObjectInputStream(localByteArrayInputStream).readObject()).getCookie();
      return localCookie;
    }
    catch (Exception localException)
    {
      Log.d("PersistentCookieStore", "decodeCookie failed", localException);
    }
    return null;
  }

  public void deleteCookie(Cookie paramCookie)
  {
    String str = paramCookie.getName();
    this.f.remove(str);
    SharedPreferences.Editor localEditor = this.g.edit();
    localEditor.remove("cookie_" + str);
    localEditor.commit();
  }

  protected String encodeCookie(SerializableCookie paramSerializableCookie)
  {
    if (paramSerializableCookie == null)
      return null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramSerializableCookie);
      return byteArrayToHexString(localByteArrayOutputStream.toByteArray());
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public List<Cookie> getCookies()
  {
    return new ArrayList(this.f.values());
  }

  protected byte[] hexStringToByteArray(String paramString)
  {
    int i = paramString.length();
    byte[] arrayOfByte = new byte[i / 2];
    for (int j = 0; ; j += 2)
    {
      if (j >= i)
        return arrayOfByte;
      arrayOfByte[(j / 2)] = ((byte)((Character.digit(paramString.charAt(j), 16) << 4) + Character.digit(paramString.charAt(j + 1), 16)));
    }
  }

  public void setOmitNonPersistentCookies(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.PersistentCookieStore
 * JD-Core Version:    0.6.2
 */