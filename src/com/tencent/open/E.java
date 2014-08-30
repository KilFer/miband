package com.tencent.open;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

final class E
{
  String a;
  A[] b;
  private String c;

  static E a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      return null;
    E localE = new E();
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject("task_info");
    localE.a = localJSONObject1.getString("task_id");
    localJSONObject1.getString("task_desc");
    JSONArray localJSONArray = localJSONObject1.getJSONArray("step_info");
    int i = localJSONArray.length();
    if (i > 0)
      localE.b = new A[i];
    for (int j = 0; j < i; j++)
    {
      JSONObject localJSONObject2 = localJSONArray.getJSONObject(j);
      int k = localJSONObject2.getInt("step_no");
      int m = localJSONObject2.getInt("status");
      A localA = new A(k, localJSONObject2.getString("step_desc"), localJSONObject2.getString("step_gift"), localJSONObject2.getLong("end_time"), m);
      localE.b[j] = localA;
    }
    return localE;
  }

  public final boolean a()
  {
    return (!TextUtils.isEmpty(this.a)) && (this.b != null) && (this.b.length > 0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.E
 * JD-Core Version:    0.6.2
 */