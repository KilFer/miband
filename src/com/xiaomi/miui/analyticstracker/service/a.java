package com.xiaomi.miui.analyticstracker.service;

import org.json.JSONArray;
import org.json.JSONException;

class a
  implements b
{
  private a(DispatcherHelper paramDispatcherHelper)
  {
  }

  public JSONArray a()
  {
    try
    {
      JSONArray localJSONArray = new JSONArray("[{\"app_name\": \"com.example.android_for_test\",\"servers\": [{\"server_name\": \"xiaomi\", \"app_id\": \"Example\"}],\"items\": [{\"id_regex\": \".*\", \"policy\": \"normal\"}]}]");
      return localJSONArray;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.service.a
 * JD-Core Version:    0.6.2
 */