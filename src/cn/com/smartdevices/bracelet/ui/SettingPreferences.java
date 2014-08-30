package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.com.smartdevices.bracelet.Debug;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SettingPreferences
{
  private static final String a = "SettingPreferences";
  private static final String b = "SettingPreferences";
  private static SharedPreferences c;

  public static Object read(Context paramContext, String paramString)
  {
    if (c == null)
      c = paramContext.getSharedPreferences("SettingPreferences", 0);
    Map localMap = c.getAll();
    Iterator localIterator = localMap.keySet().iterator();
    if (!localIterator.hasNext());
    String str;
    for (Object localObject = null; ; localObject = localMap.get(str))
    {
      if (localObject == null)
        Debug.w("SettingPreferences", "Not Found Value For : " + paramString);
      Debug.i("SettingPreferences", "Read : " + paramString + "," + localObject);
      return localObject;
      str = (String)localIterator.next();
      if (!str.equals(paramString))
        break;
    }
  }

  public static Object read(Context paramContext, String paramString, Object paramObject)
  {
    Object localObject = read(paramContext, paramString);
    if (localObject == null)
      return paramObject;
    return localObject;
  }

  public static void save(Context paramContext, String paramString, Object paramObject)
  {
    if (c == null)
      c = paramContext.getSharedPreferences("SettingPreferences", 0);
    Debug.i("SettingPreferences", "Save : " + paramString + "," + paramObject);
    SharedPreferences.Editor localEditor = c.edit();
    if ((paramObject instanceof Boolean))
      localEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    while (true)
    {
      localEditor.commit();
      return;
      if ((paramObject instanceof Float))
        localEditor.putFloat(paramString, ((Float)paramObject).floatValue());
      else if ((paramObject instanceof Integer))
        localEditor.putInt(paramString, ((Integer)paramObject).intValue());
      else if ((paramObject instanceof Long))
        localEditor.putLong(paramString, ((Long)paramObject).longValue());
      else if ((paramObject instanceof String))
        localEditor.putString(paramString, (String)paramObject);
      else if ((paramObject instanceof Set))
        try
        {
          localEditor.putStringSet(paramString, (Set)paramObject);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          Debug.w("SettingPreferences", "Not Support Value Type : " + paramObject);
        }
      else
        Debug.w("SettingPreferences", "Not Support Value Type : " + paramObject);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SettingPreferences
 * JD-Core Version:    0.6.2
 */