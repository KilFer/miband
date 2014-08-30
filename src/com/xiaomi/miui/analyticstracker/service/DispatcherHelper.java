package com.xiaomi.miui.analyticstracker.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.miui.analyticstracker.Item;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DispatcherHelper
{
  private static final String a = "servers";
  private static final String b = "server_name";
  private static final String c = "app_name";
  private static final String d = "probability";
  private static final String e = "version";
  private static final String f = "app_id";
  private static final String g = "items";
  private static final String h = "id_regex";
  private static final String i = "policy";
  private static final String j = "version_regex";
  private static final String k = "DispatcherHelper";
  private static final String l = "http://tracking.miui.com/danfa_log_config.json";
  private static final String m = "log_config.json";
  private static final long n = 100L;
  private static final String o = ".*";
  private static final String p = ".*";
  private static final String q = "normal";
  private DispatcherManager r;
  private b s;
  private Context t;

  public DispatcherHelper(Context paramContext)
  {
    this.t = paramContext;
    this.s = new d(this, (byte)0);
    this.r = new DispatcherManager(this.t);
  }

  private static List<Item> a(JSONArray paramJSONArray, String paramString1, String paramString2, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = paramJSONArray.length();
    int i2 = 0;
    while (true)
    {
      if (i2 < i1);
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i2);
        localArrayList.add(new Item(localJSONObject.getString("id_regex"), localJSONObject.getString("policy"), localJSONObject.optString("version_regex", paramString2), localJSONObject.optLong("probability", paramLong)));
        i2++;
      }
      catch (PatternSyntaxException localPatternSyntaxException)
      {
        Log.e("DispatcherHelper", "Failed to compile items regex for app: " + paramString1, localPatternSyntaxException);
        return localArrayList;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localArrayList;
  }

  private static Map<String, String> a(JSONArray paramJSONArray)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int i1 = paramJSONArray.length();
    int i2 = 0;
    while (true)
      if (i2 < i1)
        try
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i2);
          localLinkedHashMap.put(localJSONObject.getString("server_name"), localJSONObject.getString("app_id"));
          i2++;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
    return localLinkedHashMap;
  }

  // ERROR //
  public void dispatch()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/xiaomi/miui/analyticstracker/service/DispatcherHelper:t	Landroid/content/Context;
    //   4: invokestatic 165	com/xiaomi/miui/analyticstracker/utils/SysUtils:isWifiConnected	(Landroid/content/Context;)Z
    //   7: ifeq +247 -> 254
    //   10: aload_0
    //   11: getfield 68	com/xiaomi/miui/analyticstracker/service/DispatcherHelper:t	Landroid/content/Context;
    //   14: invokestatic 170	com/xiaomi/miui/analyticstracker/utils/EventUtils:enableWrite	(Landroid/content/Context;)Z
    //   17: ifeq +237 -> 254
    //   20: aload_0
    //   21: getfield 75	com/xiaomi/miui/analyticstracker/service/DispatcherHelper:s	Lcom/xiaomi/miui/analyticstracker/service/b;
    //   24: invokeinterface 175 1 0
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +223 -> 254
    //   34: aload_1
    //   35: invokevirtual 96	org/json/JSONArray:length	()I
    //   38: istore_2
    //   39: iconst_0
    //   40: istore_3
    //   41: iload_3
    //   42: iload_2
    //   43: if_icmpge +211 -> 254
    //   46: aload_0
    //   47: getfield 68	com/xiaomi/miui/analyticstracker/service/DispatcherHelper:t	Landroid/content/Context;
    //   50: invokestatic 165	com/xiaomi/miui/analyticstracker/utils/SysUtils:isWifiConnected	(Landroid/content/Context;)Z
    //   53: ifeq +201 -> 254
    //   56: aload_0
    //   57: getfield 68	com/xiaomi/miui/analyticstracker/service/DispatcherHelper:t	Landroid/content/Context;
    //   60: invokestatic 170	com/xiaomi/miui/analyticstracker/utils/EventUtils:enableWrite	(Landroid/content/Context;)Z
    //   63: ifeq +191 -> 254
    //   66: aload_1
    //   67: iload_3
    //   68: invokevirtual 100	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   71: astore 5
    //   73: aload 5
    //   75: ldc 14
    //   77: invokevirtual 108	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore 6
    //   82: aload 6
    //   84: aload_0
    //   85: getfield 68	com/xiaomi/miui/analyticstracker/service/DispatcherHelper:t	Landroid/content/Context;
    //   88: invokevirtual 180	android/content/Context:getPackageName	()Ljava/lang/String;
    //   91: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   94: ifne +6 -> 100
    //   97: goto +168 -> 265
    //   100: ldc2_w 47
    //   103: lstore 7
    //   105: ldc 51
    //   107: astore 9
    //   109: aload 5
    //   111: ldc 17
    //   113: invokevirtual 189	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   116: lstore 18
    //   118: lload 18
    //   120: lstore 7
    //   122: aload 5
    //   124: ldc 20
    //   126: invokevirtual 108	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore 17
    //   131: aload 17
    //   133: astore 9
    //   135: aload 9
    //   137: invokestatic 195	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   140: getstatic 200	android/os/Build$VERSION:INCREMENTAL	Ljava/lang/String;
    //   143: invokevirtual 204	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   146: invokevirtual 210	java/util/regex/Matcher:matches	()Z
    //   149: ifeq +116 -> 265
    //   152: aload_0
    //   153: getfield 81	com/xiaomi/miui/analyticstracker/service/DispatcherHelper:r	Lcom/xiaomi/miui/analyticstracker/service/DispatcherManager;
    //   156: aload 5
    //   158: ldc 8
    //   160: invokevirtual 214	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   163: invokestatic 216	com/xiaomi/miui/analyticstracker/service/DispatcherHelper:a	(Lorg/json/JSONArray;)Ljava/util/Map;
    //   166: invokevirtual 220	com/xiaomi/miui/analyticstracker/service/DispatcherManager:switchDispatcher	(Ljava/util/Map;)V
    //   169: aload 5
    //   171: ldc 26
    //   173: invokevirtual 214	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   176: aload 6
    //   178: aload 9
    //   180: lload 7
    //   182: invokestatic 222	com/xiaomi/miui/analyticstracker/service/DispatcherHelper:a	(Lorg/json/JSONArray;Ljava/lang/String;Ljava/lang/String;J)Ljava/util/List;
    //   185: astore 16
    //   187: aload 16
    //   189: astore 15
    //   191: aload_0
    //   192: getfield 81	com/xiaomi/miui/analyticstracker/service/DispatcherHelper:r	Lcom/xiaomi/miui/analyticstracker/service/DispatcherManager;
    //   195: aload 15
    //   197: invokevirtual 225	com/xiaomi/miui/analyticstracker/service/DispatcherManager:dispatch	(Ljava/util/List;)V
    //   200: goto +65 -> 265
    //   203: astore 4
    //   205: aload 4
    //   207: invokevirtual 148	org/json/JSONException:printStackTrace	()V
    //   210: goto +55 -> 265
    //   213: astore 12
    //   215: new 89	java/util/ArrayList
    //   218: dup
    //   219: invokespecial 90	java/util/ArrayList:<init>	()V
    //   222: astore 13
    //   224: aload 13
    //   226: new 102	com/xiaomi/miui/analyticstracker/Item
    //   229: dup
    //   230: ldc 51
    //   232: ldc 55
    //   234: aload 9
    //   236: lload 7
    //   238: invokespecial 119	com/xiaomi/miui/analyticstracker/Item:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   241: invokeinterface 125 2 0
    //   246: pop
    //   247: aload 13
    //   249: astore 15
    //   251: goto -60 -> 191
    //   254: return
    //   255: astore 11
    //   257: goto -122 -> 135
    //   260: astore 10
    //   262: goto -140 -> 122
    //   265: iinc 3 1
    //   268: goto -227 -> 41
    //
    // Exception table:
    //   from	to	target	type
    //   66	97	203	org/json/JSONException
    //   135	169	203	org/json/JSONException
    //   191	200	203	org/json/JSONException
    //   215	247	203	org/json/JSONException
    //   169	187	213	org/json/JSONException
    //   122	131	255	org/json/JSONException
    //   109	118	260	org/json/JSONException
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.service.DispatcherHelper
 * JD-Core Version:    0.6.2
 */