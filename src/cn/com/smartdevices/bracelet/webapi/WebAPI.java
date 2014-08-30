package cn.com.smartdevices.bracelet.webapi;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.LoginInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SystemInfo;
import cn.com.smartdevices.bracelet.model.UserLocationData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class WebAPI
{
  public static String TAG = "WebAPI";

  public static void download(String paramString, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    BraceletHttpClient.client.get(paramString, paramAsyncHttpResponseHandler);
  }

  public static void getLuaScript(LoginData paramLoginData, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    String str = BraceletHttpClient.getUrl("huami.health.getluapackdata.json");
    BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
  }

  public static void getLuaScriptVersion(LoginData paramLoginData, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    String str = BraceletHttpClient.getUrl("huami.health.getlatestluaversion.json");
    BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
  }

  public static void getLuaScriptVersionList(LoginData paramLoginData, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    String str = BraceletHttpClient.getUrl("huami.health.getlatestluaversionlist.json");
    BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
  }

  public static void getUserInfo(LoginData paramLoginData, long paramLong, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    localRequestParams.put("uid", paramLong);
    String str = BraceletHttpClient.getUrl("huami.health.getUserInfo.json");
    BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
  }

  public static void getWeixinQR(LoginData paramLoginData, String paramString, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    localRequestParams.put("deviceid", paramString);
    String str = BraceletHttpClient.getUrl("huami.health.createwxqr.json");
    BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
  }

  public static void sendFeedback(LoginData paramLoginData, String paramString1, String paramString2, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    localRequestParams.put("message", paramString1);
    localRequestParams.put("email", paramString2);
    String str = BraceletHttpClient.getUrl("huami.health.report.json");
    BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
  }

  public static void sendLocation(LoginData paramLoginData, UserLocationData paramUserLocationData, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    try
    {
      localRequestParams.put("location", URLEncoder.encode(paramUserLocationData.toString(), "utf-8"));
      String str = BraceletHttpClient.getUrl("huami.health.backup.json");
      BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        localUnsupportedEncodingException.printStackTrace();
    }
  }

  public static void sendLoginResult(LoginInfo paramLoginInfo, String paramString, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("access_token", paramLoginInfo.accessToken);
    localRequestParams.put("expiresIn", paramLoginInfo.expiresIn);
    localRequestParams.put("mac_token", paramLoginInfo.macToken);
    localRequestParams.put("miid", paramLoginInfo.miid);
    localRequestParams.put("aliasNick", paramLoginInfo.aliasNick);
    localRequestParams.put("miliaoNick", paramLoginInfo.miliaoNick);
    if ((paramLoginInfo.miliaoIcon_320 != null) && (paramLoginInfo.miliaoIcon_320.length() > 0))
      localRequestParams.put("miliaoIcon", paramLoginInfo.miliaoIcon_320);
    while (true)
    {
      localRequestParams.put("friends", paramLoginInfo.friends);
      localRequestParams.put("deviceid", paramString);
      localRequestParams.put("devicetype", "0");
      String str = BraceletHttpClient.getUrl("huami.health.apklogin.json");
      Debug.i(TAG, "send login url= " + str);
      BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
      return;
      localRequestParams.put("miliaoIcon", paramLoginInfo.miliaoIcon);
    }
  }

  public static void statisticBracelet(LoginData paramLoginData, String paramString1, String paramString2, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    localRequestParams.put("deviceid", paramString1);
    localRequestParams.put("statistic_bracelet", paramString2);
    String str = BraceletHttpClient.getUrl("huami.health.uploadcollectdata.json");
    BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
  }

  public static void syncFromServerNew(LoginData paramLoginData, String paramString, int paramInt1, int paramInt2, int paramInt3, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    localRequestParams.put("deviceid", paramString);
    localRequestParams.put("data_type", paramInt1);
    localRequestParams.put("source", paramInt2);
    localRequestParams.put("days", paramInt3);
    String str = BraceletHttpClient.getUrl("huami.health.getDataNew.json");
    BraceletHttpClient.syncClient.post(str, localRequestParams, paramAsyncHttpResponseHandler);
  }

  public static void syncSummaryToServer(LoginData paramLoginData, String paramString1, int paramInt1, int paramInt2, String paramString2, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    localRequestParams.put("data_json", paramString2);
    localRequestParams.put("deviceid", paramString1);
    localRequestParams.put("data_type", paramInt1);
    localRequestParams.put("source", paramInt2);
    localRequestParams.put("data_len", paramString2.length());
    localRequestParams.put("uuid", Keeper.readUUID());
    String str = BraceletHttpClient.getUrl("huami.health.updateSummary.json");
    Debug.i(TAG, "Url : " + str);
    BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
  }

  public static void syncToServer(LoginData paramLoginData, String paramString1, int paramInt1, int paramInt2, String paramString2, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    localRequestParams.put("data_json", paramString2);
    localRequestParams.put("deviceid", paramString1);
    localRequestParams.put("data_type", paramInt1);
    localRequestParams.put("source", paramInt2);
    localRequestParams.put("data_len", paramString2.length());
    localRequestParams.put("uuid", Keeper.readUUID());
    String str = BraceletHttpClient.getUrl("huami.health.receiveData.json");
    BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
  }

  public static void updateProfile(LoginData paramLoginData, PersonInfo paramPersonInfo, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    localRequestParams.put("birthday", paramPersonInfo.birthday);
    localRequestParams.put("gender", paramPersonInfo.gender);
    localRequestParams.put("height", paramPersonInfo.height);
    localRequestParams.put("weight", paramPersonInfo.weight);
    localRequestParams.put("nick_name", paramPersonInfo.nickname);
    localRequestParams.put("icon_url", paramPersonInfo.avatarUrl);
    localRequestParams.put("person_signature", paramPersonInfo.personSignature);
    localRequestParams.put("person_sh", paramPersonInfo.sh);
    localRequestParams.put("age", paramPersonInfo.age);
    Gson localGson = new GsonBuilder().create();
    try
    {
      localRequestParams.put("location", Utils.checkNull(URLEncoder.encode(localGson.toJson(paramPersonInfo.location), "utf-8")));
      localRequestParams.put("alarm_clock", Utils.checkNull(URLEncoder.encode(localGson.toJson(paramPersonInfo.alarmClockItems), "utf-8")));
      localRequestParams.put("config", Utils.checkNull(URLEncoder.encode(localGson.toJson(paramPersonInfo.miliConfig), "utf-8")));
      str = BraceletHttpClient.getUrl("huami.health.bindProfile.json");
      if ((paramPersonInfo.avatarPath == null) || ((0x1 & paramPersonInfo.getNeedSyncServer()) == 0))
      {
        BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
        return;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      String str;
      while (true)
        localUnsupportedEncodingException.printStackTrace();
      try
      {
        localRequestParams.put("icon", new File(paramPersonInfo.avatarPath));
        BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
      }
    }
  }

  public static void updateProfile(LoginData paramLoginData, HashMap<String, String> paramHashMap, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    HashMap localHashMap = BraceletHttpClient.getSysHm(paramLoginData);
    localHashMap.putAll(paramHashMap);
    String str1 = BraceletHttpClient.getUrl("huami.health.bindProfile.json");
    String str2 = (String)paramHashMap.get("icon_path");
    localHashMap.remove("icon_path");
    RequestParams localRequestParams = new RequestParams();
    Iterator localIterator = localHashMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        if ((str2 != null) && (str2.length() > 0))
          break;
        BraceletHttpClient.client.post(str1, localRequestParams, paramAsyncHttpResponseHandler);
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localRequestParams.put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    try
    {
      localRequestParams.put("icon", new File(str2));
      BraceletHttpClient.client.post(str1, localRequestParams, paramAsyncHttpResponseHandler);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      BraceletHttpClient.client.post(str1, localRequestParams, paramAsyncHttpResponseHandler);
    }
  }

  public static void updateSystemInfo(LoginData paramLoginData, SystemInfo paramSystemInfo, int paramInt, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    localRequestParams.put("deviceid", paramSystemInfo.deviceId);
    localRequestParams.put("mac", URLEncoder.encode(paramSystemInfo.braceletMacAddress));
    localRequestParams.put("devicetype", paramInt);
    localRequestParams.put("miui_version_code", paramSystemInfo.miuiVersionCode);
    localRequestParams.put("miui_version_name", paramSystemInfo.miuiVersionName);
    localRequestParams.put("phone_brand", paramSystemInfo.phoneBrand);
    localRequestParams.put("phone_model", paramSystemInfo.phoneModel);
    localRequestParams.put("phone_system", paramSystemInfo.phoneSystem);
    localRequestParams.put("fwversion", paramSystemInfo.fwVersion);
    localRequestParams.put("softversion", paramSystemInfo.softVersion);
    String str = BraceletHttpClient.getUrl("huami.health.updatedevicedata.json");
    BraceletHttpClient.client.post(str, localRequestParams, paramAsyncHttpResponseHandler);
  }

  public static void uploadLogFileBlock(LoginData paramLoginData, File paramFile, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    RequestParams localRequestParams = BraceletHttpClient.getSysRp(paramLoginData);
    try
    {
      localRequestParams.put("log_file_name", paramFile.getName());
      localRequestParams.put("log_file", paramFile);
      label24: String str = BraceletHttpClient.getUrl("huami.health.uploadlogdata.json");
      BraceletHttpClient.syncClient.post(str, localRequestParams, paramAsyncHttpResponseHandler);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label24;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.webapi.WebAPI
 * JD-Core Version:    0.6.2
 */