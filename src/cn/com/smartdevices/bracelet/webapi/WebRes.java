package cn.com.smartdevices.bracelet.webapi;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.activity.LoginActivity;
import cn.com.smartdevices.bracelet.model.BasePushItem;
import cn.com.smartdevices.bracelet.model.CommentItem;
import cn.com.smartdevices.bracelet.model.DataStatusPushItem;
import cn.com.smartdevices.bracelet.model.LoginInfo;
import cn.com.smartdevices.bracelet.model.MicroBlogItem;
import cn.com.smartdevices.bracelet.model.MiliConfig;
import cn.com.smartdevices.bracelet.model.NetDataInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.PicUrl;
import cn.com.smartdevices.bracelet.model.ShareBackgroundItem;
import cn.com.smartdevices.bracelet.model.ShareContent;
import cn.com.smartdevices.bracelet.model.ShareSportData;
import cn.com.smartdevices.bracelet.model.SystemStatusPushItem;
import cn.com.smartdevices.bracelet.model.UploadData;
import cn.com.smartdevices.bracelet.model.UserLocationData;
import cn.com.smartdevices.bracelet.model.UserStatusPushItem;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebRes
{
  private static String a = "WebRes";
  private static Context b = null;
  private static WebStatus c = new WebStatus();

  private static ShareSportData a(String paramString)
  {
    ShareSportData localShareSportData = new ShareSportData();
    try
    {
      localShareSportData.fromString(paramString);
      return localShareSportData;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localShareSportData;
  }

  private static UploadData a(JSONObject paramJSONObject)
  {
    UploadData localUploadData = new UploadData();
    localUploadData.date = paramJSONObject.getString("date");
    localUploadData.summary = paramJSONObject.getString("summary");
    if (!paramJSONObject.isNull("data"))
      localUploadData.data = Base64.decode(paramJSONObject.getString("data"), 2);
    return localUploadData;
  }

  private static void a(JSONObject paramJSONObject, PersonInfo paramPersonInfo)
  {
    UserTotalSportData localUserTotalSportData = new UserTotalSportData();
    localUserTotalSportData.steps = paramJSONObject.optString("steps");
    localUserTotalSportData.distance = paramJSONObject.optString("distance");
    localUserTotalSportData.calories = paramJSONObject.optString("calories");
    localUserTotalSportData.averageSteps = paramJSONObject.optString("averagesteps");
    localUserTotalSportData.totalwearingdays = paramJSONObject.optString("totalwearingdays");
    paramPersonInfo.totalSportData = localUserTotalSportData;
  }

  private static PersonInfo b(JSONObject paramJSONObject)
  {
    PersonInfo localPersonInfo = new PersonInfo();
    if ((paramJSONObject.has("uid")) && (paramJSONObject.getString("uid").length() > 0))
      localPersonInfo.uid = paramJSONObject.getLong("uid");
    localPersonInfo.nickname = paramJSONObject.getString("username");
    if ((paramJSONObject.has("gender")) && (paramJSONObject.getString("gender").length() > 0))
      localPersonInfo.gender = paramJSONObject.getInt("gender");
    if ((paramJSONObject.has("height")) && (paramJSONObject.getString("height").length() > 0))
      localPersonInfo.height = paramJSONObject.getInt("height");
    if ((paramJSONObject.has("weight")) && (paramJSONObject.getString("weight").length() > 0))
      localPersonInfo.weight = paramJSONObject.getInt("weight");
    localPersonInfo.avatarUrl = paramJSONObject.getString("avatar");
    localPersonInfo.birthday = paramJSONObject.getString("birthday");
    String[] arrayOfString = localPersonInfo.birthday.split("-");
    int i = Calendar.getInstance().get(1);
    if ((arrayOfString[0] != null) && (arrayOfString[0].length() > 0))
      localPersonInfo.age = (i - Integer.parseInt(arrayOfString[0]));
    localPersonInfo.location = UserLocationData.fromJsonStr(paramJSONObject.optString("location"));
    localPersonInfo.source = paramJSONObject.getString("source");
    if ((paramJSONObject.has("status")) && (paramJSONObject.getString("status").length() > 0))
      localPersonInfo.state = paramJSONObject.getInt("status");
    if ((paramJSONObject.has("gid")) && (paramJSONObject.getString("gid").length() > 0))
      localPersonInfo.gid = paramJSONObject.getInt("gid");
    localPersonInfo.personSignature = paramJSONObject.getString("signature");
    localPersonInfo.pinyin = "";
    return localPersonInfo;
  }

  private static void b(JSONObject paramJSONObject, PersonInfo paramPersonInfo)
  {
    Debug.i(a, "parseUserInfo dataObj:" + paramJSONObject.toString());
    if (paramJSONObject.length() == 0)
    {
      Debug.i(a, "parseUserInfo dataObj is null");
      return;
    }
    if ((paramJSONObject.has("uid")) && (paramJSONObject.getString("uid").length() > 0))
      paramPersonInfo.uid = paramJSONObject.getLong("uid");
    if (paramPersonInfo.getNeedSyncServer() != 0)
    {
      Debug.i(a, "\n Person info not synced to server, so we skip parse from server! \n");
      return;
    }
    if ((paramJSONObject.has("height")) && (paramJSONObject.getString("height").length() > 0))
      paramPersonInfo.height = paramJSONObject.getInt("height");
    if ((paramJSONObject.has("weight")) && (paramJSONObject.getString("weight").length() > 0))
      paramPersonInfo.weight = paramJSONObject.getInt("weight");
    if ((paramJSONObject.has("gender")) && (paramJSONObject.getString("gender").length() > 0))
      paramPersonInfo.gender = paramJSONObject.getInt("gender");
    paramPersonInfo.lastLoginTime = paramJSONObject.getString("last_login_time");
    paramPersonInfo.createTime = paramJSONObject.getString("creat_time");
    paramPersonInfo.birthday = paramJSONObject.getString("birthday");
    paramPersonInfo.avatarUrl = paramJSONObject.getString("avatar");
    UserLocationData localUserLocationData = UserLocationData.fromJsonStr(paramJSONObject.optString("location"));
    if ((localUserLocationData != null) && (localUserLocationData.isValid()))
      paramPersonInfo.location = localUserLocationData;
    MiliConfig localMiliConfig = MiliConfig.fromJsonStr(Utils.URLDecodeStr(paramJSONObject.optString("config")));
    if ((localMiliConfig != null) && (localMiliConfig.isValid()))
    {
      paramPersonInfo.setMiliConfig(localMiliConfig);
      Debug.i(a, "miliConfig=" + localMiliConfig);
    }
    ArrayList localArrayList = PersonInfo.parseAlarmClockItems(Utils.URLDecodeStr(paramJSONObject.optString("alarm_clock")));
    if (localArrayList != null)
      paramPersonInfo.alarmClockItems = localArrayList;
    paramPersonInfo.age = paramJSONObject.optInt("age");
    paramPersonInfo.personSignature = paramJSONObject.getString("signature");
  }

  private static WebStatus c(JSONObject paramJSONObject)
  {
    Debug.i(a, "getWebStatus:" + paramJSONObject.toString());
    WebStatus localWebStatus = new WebStatus();
    try
    {
      localWebStatus.code = paramJSONObject.getInt("code");
      localWebStatus.message = paramJSONObject.getString("message");
      if ((localWebStatus.isAuthInvalid()) && (!c.equals(localWebStatus)))
      {
        Intent localIntent = new Intent();
        localIntent.setClass(b, LoginActivity.class);
        localIntent.setFlags(268468224);
        b.startActivity(localIntent);
      }
      c = localWebStatus;
      return localWebStatus;
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        localWebStatus.code = 2;
        Debug.i(a, localJSONException.getMessage());
      }
    }
  }

  private static MicroBlogItem d(JSONObject paramJSONObject)
  {
    int i = 0;
    Debug.l(a, "parseMicroBlog:" + paramJSONObject.toString());
    MicroBlogItem localMicroBlogItem = new MicroBlogItem();
    localMicroBlogItem.postid = paramJSONObject.getLong("postid");
    if (!paramJSONObject.isNull("visible"))
      localMicroBlogItem.visible = paramJSONObject.getInt("visible");
    if (!paramJSONObject.isNull("issystem"))
      localMicroBlogItem.systemFlag = paramJSONObject.getInt("issystem");
    if (!paramJSONObject.isNull("web_url"))
      localMicroBlogItem.webUrl = paramJSONObject.getString("web_url");
    b(paramJSONObject.getJSONObject("user"), localMicroBlogItem.info);
    localMicroBlogItem.shareContent.message = paramJSONObject.getString("message");
    localMicroBlogItem.shareContent.shareType = paramJSONObject.getInt("share_type");
    JSONArray localJSONArray2;
    int k;
    label297: JSONArray localJSONArray3;
    if (localMicroBlogItem.shareContent.shareType == 1)
    {
      if (paramJSONObject.has("share_sport_data"))
      {
        String str = paramJSONObject.getString("share_sport_data");
        if ((str != null) && (str.length() > 0))
          localMicroBlogItem.shareContent.shareSportData = a(str);
      }
      if ((paramJSONObject.has("data")) && (paramJSONObject.getJSONObject("data").length() >= 3))
        localMicroBlogItem.data = a(paramJSONObject.getJSONObject("data"));
      localMicroBlogItem.source = paramJSONObject.getString("source");
      localMicroBlogItem.createTime = paramJSONObject.getString("create_time");
      localMicroBlogItem.likeNum = paramJSONObject.getInt("likenum");
      localMicroBlogItem.commentsNum = paramJSONObject.getInt("commentsnum");
      localJSONArray2 = paramJSONObject.getJSONArray("comments");
      k = 0;
      if (k < localJSONArray2.length())
        break label453;
      localJSONArray3 = paramJSONObject.getJSONArray("likeuserlist");
      if ((localJSONArray3 != null) && (localJSONArray3.length() > 0))
      {
        if (localMicroBlogItem.likePersons != null)
          break label593;
        localMicroBlogItem.likePersons = new ArrayList(8);
      }
    }
    while (true)
    {
      if (i >= localJSONArray3.length())
      {
        return localMicroBlogItem;
        if (localMicroBlogItem.shareContent.shareType != 2)
          break;
        JSONArray localJSONArray1 = paramJSONObject.getJSONArray("picurl");
        for (int j = 0; j < localJSONArray1.length(); j++)
        {
          JSONObject localJSONObject1 = localJSONArray1.getJSONObject(j);
          PicUrl localPicUrl = new PicUrl();
          localPicUrl.originUrl = localJSONObject1.getString("original_pic");
          localPicUrl.thumbUrl = localJSONObject1.getString("thumb_pic");
          localMicroBlogItem.shareContent.pics.add(localPicUrl);
        }
        break;
        label453: JSONObject localJSONObject2 = localJSONArray2.getJSONObject(k);
        Debug.l(a, "parseComment:" + localJSONObject2.toString());
        CommentItem localCommentItem = new CommentItem();
        localCommentItem.cid = localJSONObject2.getLong("cid");
        b(localJSONObject2.getJSONObject("user"), localCommentItem.userInfo);
        localCommentItem.createTime = localJSONObject2.getLong("create_time");
        localCommentItem.message = localJSONObject2.getString("message");
        localCommentItem.source = localJSONObject2.getString("source");
        localCommentItem.status = localJSONObject2.getInt("status");
        localMicroBlogItem.comments.add(localCommentItem);
        k++;
        break label297;
        label593: localMicroBlogItem.likePersons.clear();
        i = 0;
        continue;
      }
      PersonInfo localPersonInfo = new PersonInfo();
      b(localJSONArray3.getJSONObject(i), localPersonInfo);
      localMicroBlogItem.likePersons.add(localPersonInfo);
      Debug.i(a, "Add like relation: " + localPersonInfo.nickname + " like " + localMicroBlogItem.info.nickname);
      i++;
    }
  }

  private static CommentItem e(JSONObject paramJSONObject)
  {
    Debug.l(a, "parseComment:" + paramJSONObject.toString());
    CommentItem localCommentItem = new CommentItem();
    localCommentItem.cid = paramJSONObject.getLong("cid");
    b(paramJSONObject.getJSONObject("user"), localCommentItem.userInfo);
    localCommentItem.createTime = paramJSONObject.getLong("create_time");
    localCommentItem.message = paramJSONObject.getString("message");
    localCommentItem.source = paramJSONObject.getString("source");
    localCommentItem.status = paramJSONObject.getInt("status");
    return localCommentItem;
  }

  public static WebStatus getWebStatus(String paramString)
  {
    Debug.i(a, "getWebStatus:" + paramString);
    WebStatus localWebStatus = new WebStatus();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localWebStatus.code = localJSONObject.getInt("code");
      localWebStatus.message = localJSONObject.getString("message");
      if ((localWebStatus.isAuthInvalid()) && (!c.equals(localWebStatus)))
      {
        Intent localIntent = new Intent();
        localIntent.setClass(b, LoginActivity.class);
        localIntent.setFlags(268468224);
        b.startActivity(localIntent);
      }
      c = localWebStatus;
      return localWebStatus;
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        localWebStatus.code = 2;
        localJSONException.printStackTrace();
        Debug.i(a, localJSONException.getMessage());
      }
    }
  }

  public static void init(Context paramContext)
  {
    b = paramContext;
  }

  public static WebStatus parseAvatar(String paramString, PersonInfo paramPersonInfo)
  {
    WebStatus localWebStatus1 = new WebStatus();
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      WebStatus localWebStatus3 = c(localJSONObject1);
      localWebStatus2 = localWebStatus3;
      try
      {
        if (!localWebStatus2.success())
          return localWebStatus2;
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
        if (localJSONObject2 == null)
          break label123;
        String str = localJSONObject2.optString("avatar");
        if (str.length() > 0)
          paramPersonInfo.avatarUrl = str;
        Debug.i(a, "get avatar Url: " + str);
        return localWebStatus2;
      }
      catch (JSONException localJSONException2)
      {
      }
      localWebStatus2.code = 2;
      Debug.i(a, localJSONException2.getMessage());
      return localWebStatus2;
      label123: localWebStatus2.code = 2;
      return localWebStatus2;
    }
    catch (JSONException localJSONException1)
    {
      while (true)
      {
        WebStatus localWebStatus2 = localWebStatus1;
        Object localObject = localJSONException1;
      }
    }
  }

  public static PersonInfo parseBindedUserInfo(String paramString, PersonInfo paramPersonInfo)
  {
    String str = Utils.purgeJson(paramString);
    try
    {
      b(new JSONObject(str), paramPersonInfo);
      return paramPersonInfo;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramPersonInfo;
  }

  public static WebStatus parseDownload(String paramString, ArrayList<UploadData> paramArrayList)
  {
    WebStatus localWebStatus1 = new WebStatus();
    WebStatus localWebStatus2;
    try
    {
      Debug.l(a, "parseDownload:\n" + paramString);
      Debug.f(a, paramString);
      JSONObject localJSONObject1 = new JSONObject(paramString);
      WebStatus localWebStatus3 = c(localJSONObject1);
      localWebStatus2 = localWebStatus3;
      JSONArray localJSONArray1;
      while (true)
      {
        NetDataInfo localNetDataInfo2;
        try
        {
          if (!localWebStatus2.success())
            return localWebStatus2;
          JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
          int i = localJSONObject2.getInt("data_len");
          if (!localJSONObject2.isNull("dates"))
          {
            JSONArray localJSONArray2 = localJSONObject2.getJSONArray("dates");
            localNetDataInfo2 = new NetDataInfo();
            if (localJSONArray2.length() == 2)
            {
              localNetDataInfo2.dataState = 2;
              localNetDataInfo2.startDate = localJSONArray2.getString(0);
              localNetDataInfo2.stopDate = localJSONArray2.getString(1);
              Keeper.keepNetInfo(localNetDataInfo2);
            }
          }
          else
          {
            localJSONArray1 = localJSONObject2.getJSONArray("list");
            if (localJSONArray1.toString().length() == i)
              break;
            Debug.i(a, "size error!");
            return localWebStatus2;
          }
        }
        catch (JSONException localJSONException2)
        {
          localWebStatus2.code = 2;
          Debug.i(a, "parseDownload:" + localJSONException2.getMessage());
          Debug.l(a, localJSONException2.getMessage());
          return localWebStatus2;
        }
        localNetDataInfo2.dataState = 1;
      }
      int j = localJSONArray1.length();
      Debug.i(a, "list Size:" + j);
      NetDataInfo localNetDataInfo1 = new NetDataInfo();
      if (j > 0)
      {
        localNetDataInfo1.dataState = 2;
        localNetDataInfo1.startDate = localJSONArray1.getJSONObject(0).getString("date");
        localNetDataInfo1.stopDate = localJSONArray1.getJSONObject(j - 1).getString("date");
      }
      while (true)
      {
        Keeper.keepNetInfo(localNetDataInfo1);
        paramArrayList.ensureCapacity(j);
        for (int k = 0; k < j; k++)
          paramArrayList.add(a(localJSONArray1.getJSONObject(k)));
        localNetDataInfo1.dataState = 1;
      }
    }
    catch (JSONException localJSONException1)
    {
      while (true)
      {
        localWebStatus2 = localWebStatus1;
        Object localObject = localJSONException1;
      }
    }
    return localWebStatus2;
  }

  // ERROR //
  public static WebStatus parseFriendList(String paramString, ArrayList<PersonInfo> paramArrayList)
  {
    // Byte code:
    //   0: getstatic 16	cn/com/smartdevices/bracelet/webapi/WebRes:a	Ljava/lang/String;
    //   3: new 217	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 558
    //   10: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokestatic 344	cn/com/smartdevices/bracelet/Debug:l	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: new 20	cn/com/smartdevices/bracelet/webapi/WebStatus
    //   26: dup
    //   27: invokespecial 23	cn/com/smartdevices/bracelet/webapi/WebStatus:<init>	()V
    //   30: astore_2
    //   31: new 47	org/json/JSONObject
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 491	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   39: astore_3
    //   40: aload_3
    //   41: invokestatic 498	cn/com/smartdevices/bracelet/webapi/WebRes:c	(Lorg/json/JSONObject;)Lcn/com/smartdevices/bracelet/webapi/WebStatus;
    //   44: astore 7
    //   46: aload 7
    //   48: astore 5
    //   50: aload 5
    //   52: invokevirtual 501	cn/com/smartdevices/bracelet/webapi/WebStatus:success	()Z
    //   55: ifne +6 -> 61
    //   58: aload 5
    //   60: areturn
    //   61: aload_3
    //   62: ldc 59
    //   64: invokevirtual 371	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   67: ldc_w 542
    //   70: invokevirtual 422	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   73: astore 8
    //   75: aload 8
    //   77: invokevirtual 425	org/json/JSONArray:length	()I
    //   80: istore 9
    //   82: aload_1
    //   83: iload 9
    //   85: invokevirtual 555	java/util/ArrayList:ensureCapacity	(I)V
    //   88: iconst_0
    //   89: istore 10
    //   91: iload 10
    //   93: iload 9
    //   95: if_icmpge +424 -> 519
    //   98: aload 8
    //   100: iload 10
    //   102: invokevirtual 440	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   105: astore 11
    //   107: new 102	cn/com/smartdevices/bracelet/model/PersonInfo
    //   110: dup
    //   111: invokespecial 108	cn/com/smartdevices/bracelet/model/PersonInfo:<init>	()V
    //   114: astore 12
    //   116: aload 11
    //   118: ldc 110
    //   120: invokevirtual 113	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   123: ifeq +28 -> 151
    //   126: aload 11
    //   128: ldc 110
    //   130: invokevirtual 51	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokevirtual 119	java/lang/String:length	()I
    //   136: ifle +15 -> 151
    //   139: aload 12
    //   141: aload 11
    //   143: ldc 110
    //   145: invokevirtual 123	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   148: putfield 126	cn/com/smartdevices/bracelet/model/PersonInfo:uid	J
    //   151: aload 12
    //   153: aload 11
    //   155: ldc 128
    //   157: invokevirtual 51	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   160: putfield 131	cn/com/smartdevices/bracelet/model/PersonInfo:nickname	Ljava/lang/String;
    //   163: aload 11
    //   165: ldc 133
    //   167: invokevirtual 113	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   170: ifeq +28 -> 198
    //   173: aload 11
    //   175: ldc 133
    //   177: invokevirtual 51	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   180: invokevirtual 119	java/lang/String:length	()I
    //   183: ifle +15 -> 198
    //   186: aload 12
    //   188: aload 11
    //   190: ldc 133
    //   192: invokevirtual 137	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   195: putfield 140	cn/com/smartdevices/bracelet/model/PersonInfo:gender	I
    //   198: aload 11
    //   200: ldc 142
    //   202: invokevirtual 113	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   205: ifeq +28 -> 233
    //   208: aload 11
    //   210: ldc 142
    //   212: invokevirtual 51	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   215: invokevirtual 119	java/lang/String:length	()I
    //   218: ifle +15 -> 233
    //   221: aload 12
    //   223: aload 11
    //   225: ldc 142
    //   227: invokevirtual 137	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   230: putfield 144	cn/com/smartdevices/bracelet/model/PersonInfo:height	I
    //   233: aload 11
    //   235: ldc 146
    //   237: invokevirtual 113	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   240: ifeq +28 -> 268
    //   243: aload 11
    //   245: ldc 146
    //   247: invokevirtual 51	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   250: invokevirtual 119	java/lang/String:length	()I
    //   253: ifle +15 -> 268
    //   256: aload 12
    //   258: aload 11
    //   260: ldc 146
    //   262: invokevirtual 137	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   265: putfield 148	cn/com/smartdevices/bracelet/model/PersonInfo:weight	I
    //   268: aload 12
    //   270: aload 11
    //   272: ldc 150
    //   274: invokevirtual 51	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   277: putfield 153	cn/com/smartdevices/bracelet/model/PersonInfo:avatarUrl	Ljava/lang/String;
    //   280: aload 12
    //   282: aload 11
    //   284: ldc 155
    //   286: invokevirtual 51	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   289: putfield 157	cn/com/smartdevices/bracelet/model/PersonInfo:birthday	Ljava/lang/String;
    //   292: aload 12
    //   294: getfield 157	cn/com/smartdevices/bracelet/model/PersonInfo:birthday	Ljava/lang/String;
    //   297: ldc 159
    //   299: invokevirtual 163	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   302: astore 13
    //   304: invokestatic 169	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   307: iconst_1
    //   308: invokevirtual 173	java/util/Calendar:get	(I)I
    //   311: istore 14
    //   313: aload 13
    //   315: iconst_0
    //   316: aaload
    //   317: ifnull +28 -> 345
    //   320: aload 13
    //   322: iconst_0
    //   323: aaload
    //   324: invokevirtual 119	java/lang/String:length	()I
    //   327: ifle +18 -> 345
    //   330: aload 12
    //   332: iload 14
    //   334: aload 13
    //   336: iconst_0
    //   337: aaload
    //   338: invokestatic 178	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   341: isub
    //   342: putfield 181	cn/com/smartdevices/bracelet/model/PersonInfo:age	I
    //   345: aload 12
    //   347: aload 11
    //   349: ldc 183
    //   351: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   354: invokestatic 189	cn/com/smartdevices/bracelet/model/UserLocationData:fromJsonStr	(Ljava/lang/String;)Lcn/com/smartdevices/bracelet/model/UserLocationData;
    //   357: putfield 192	cn/com/smartdevices/bracelet/model/PersonInfo:location	Lcn/com/smartdevices/bracelet/model/UserLocationData;
    //   360: aload 12
    //   362: aload 11
    //   364: ldc 194
    //   366: invokevirtual 51	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   369: putfield 196	cn/com/smartdevices/bracelet/model/PersonInfo:source	Ljava/lang/String;
    //   372: aload 11
    //   374: ldc 198
    //   376: invokevirtual 113	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   379: ifeq +28 -> 407
    //   382: aload 11
    //   384: ldc 198
    //   386: invokevirtual 51	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   389: invokevirtual 119	java/lang/String:length	()I
    //   392: ifle +15 -> 407
    //   395: aload 12
    //   397: aload 11
    //   399: ldc 198
    //   401: invokevirtual 137	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   404: putfield 201	cn/com/smartdevices/bracelet/model/PersonInfo:state	I
    //   407: aload 11
    //   409: ldc 203
    //   411: invokevirtual 113	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   414: ifeq +28 -> 442
    //   417: aload 11
    //   419: ldc 203
    //   421: invokevirtual 51	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   424: invokevirtual 119	java/lang/String:length	()I
    //   427: ifle +15 -> 442
    //   430: aload 12
    //   432: aload 11
    //   434: ldc 203
    //   436: invokevirtual 137	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   439: putfield 205	cn/com/smartdevices/bracelet/model/PersonInfo:gid	I
    //   442: aload 12
    //   444: aload 11
    //   446: ldc 207
    //   448: invokevirtual 51	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   451: putfield 210	cn/com/smartdevices/bracelet/model/PersonInfo:personSignature	Ljava/lang/String;
    //   454: aload 12
    //   456: ldc 212
    //   458: putfield 215	cn/com/smartdevices/bracelet/model/PersonInfo:pinyin	Ljava/lang/String;
    //   461: aload_1
    //   462: aload 12
    //   464: invokevirtual 459	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   467: pop
    //   468: getstatic 16	cn/com/smartdevices/bracelet/webapi/WebRes:a	Ljava/lang/String;
    //   471: aload 12
    //   473: invokevirtual 559	cn/com/smartdevices/bracelet/model/PersonInfo:toString	()Ljava/lang/String;
    //   476: invokestatic 236	cn/com/smartdevices/bracelet/Debug:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: iinc 10 1
    //   482: goto -391 -> 91
    //   485: astore 4
    //   487: aload_2
    //   488: astore 5
    //   490: aload 4
    //   492: astore 6
    //   494: aload 5
    //   496: iconst_2
    //   497: putfield 303	cn/com/smartdevices/bracelet/webapi/WebStatus:code	I
    //   500: getstatic 16	cn/com/smartdevices/bracelet/webapi/WebRes:a	Ljava/lang/String;
    //   503: aload 6
    //   505: invokevirtual 560	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   508: invokestatic 236	cn/com/smartdevices/bracelet/Debug:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: aload 5
    //   513: areturn
    //   514: astore 6
    //   516: goto -22 -> 494
    //   519: aload 5
    //   521: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   31	46	485	java/lang/Exception
    //   50	58	514	java/lang/Exception
    //   61	88	514	java/lang/Exception
    //   98	151	514	java/lang/Exception
    //   151	198	514	java/lang/Exception
    //   198	233	514	java/lang/Exception
    //   233	268	514	java/lang/Exception
    //   268	345	514	java/lang/Exception
    //   345	407	514	java/lang/Exception
    //   407	442	514	java/lang/Exception
    //   442	479	514	java/lang/Exception
  }

  // ERROR //
  public static WebStatus parseMicroBlogs(String paramString, ArrayList<MicroBlogItem> paramArrayList)
  {
    // Byte code:
    //   0: getstatic 16	cn/com/smartdevices/bracelet/webapi/WebRes:a	Ljava/lang/String;
    //   3: new 217	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 563
    //   10: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokestatic 344	cn/com/smartdevices/bracelet/Debug:l	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: new 20	cn/com/smartdevices/bracelet/webapi/WebStatus
    //   26: dup
    //   27: invokespecial 23	cn/com/smartdevices/bracelet/webapi/WebStatus:<init>	()V
    //   30: astore_2
    //   31: new 47	org/json/JSONObject
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 491	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   39: astore_3
    //   40: aload_3
    //   41: invokestatic 498	cn/com/smartdevices/bracelet/webapi/WebRes:c	(Lorg/json/JSONObject;)Lcn/com/smartdevices/bracelet/webapi/WebStatus;
    //   44: astore 7
    //   46: aload 7
    //   48: astore 5
    //   50: aload 5
    //   52: invokevirtual 501	cn/com/smartdevices/bracelet/webapi/WebStatus:success	()Z
    //   55: ifne +6 -> 61
    //   58: aload 5
    //   60: areturn
    //   61: aload_3
    //   62: ldc 59
    //   64: invokevirtual 371	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   67: ldc_w 542
    //   70: invokevirtual 422	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   73: astore 8
    //   75: aload 8
    //   77: invokevirtual 425	org/json/JSONArray:length	()I
    //   80: istore 9
    //   82: iconst_0
    //   83: istore 10
    //   85: iload 10
    //   87: iload 9
    //   89: if_icmpge +58 -> 147
    //   92: aload_1
    //   93: aload 8
    //   95: iload 10
    //   97: invokevirtual 440	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   100: invokestatic 565	cn/com/smartdevices/bracelet/webapi/WebRes:d	(Lorg/json/JSONObject;)Lcn/com/smartdevices/bracelet/model/MicroBlogItem;
    //   103: invokevirtual 459	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   106: pop
    //   107: iinc 10 1
    //   110: goto -25 -> 85
    //   113: astore 4
    //   115: aload_2
    //   116: astore 5
    //   118: aload 4
    //   120: astore 6
    //   122: aload 5
    //   124: iconst_2
    //   125: putfield 303	cn/com/smartdevices/bracelet/webapi/WebStatus:code	I
    //   128: getstatic 16	cn/com/smartdevices/bracelet/webapi/WebRes:a	Ljava/lang/String;
    //   131: aload 6
    //   133: invokevirtual 337	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   136: invokestatic 236	cn/com/smartdevices/bracelet/Debug:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload 5
    //   141: areturn
    //   142: astore 6
    //   144: goto -22 -> 122
    //   147: aload 5
    //   149: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   31	46	113	org/json/JSONException
    //   50	58	142	org/json/JSONException
    //   61	82	142	org/json/JSONException
    //   92	107	142	org/json/JSONException
  }

  public static BasePushItem parsePushMessage(String paramString)
  {
    Debug.i(a, "parsePushMessage:" + paramString);
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      int i = localJSONObject1.getInt("type");
      localJSONObject2 = localJSONObject1.getJSONObject("data");
      switch (i)
      {
      case 1:
        DataStatusPushItem localDataStatusPushItem = new DataStatusPushItem();
        localDataStatusPushItem.dates = localJSONObject2.getJSONArray("dates");
        localDataStatusPushItem.timeStamp = localJSONObject2.getLong("timeStamp");
        localDataStatusPushItem.uuid = localJSONObject2.getString("uuid");
        return localDataStatusPushItem;
      case 0:
      case 2:
      }
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject2;
      Debug.i(a, localJSONException.getMessage());
      break label235;
      UserStatusPushItem localUserStatusPushItem = new UserStatusPushItem();
      localUserStatusPushItem.status = localJSONObject2.getInt("status");
      b(localJSONObject2.getJSONObject("userinfo"), localUserStatusPushItem.userInfo);
      localUserStatusPushItem.content = localJSONObject2.getString("content");
      localUserStatusPushItem.timeStamp = localJSONObject2.getLong("timeStamp");
      return localUserStatusPushItem;
      SystemStatusPushItem localSystemStatusPushItem = new SystemStatusPushItem();
      localSystemStatusPushItem.item = d(localJSONObject2.getJSONObject("microblog"));
      return localSystemStatusPushItem;
    }
    label235: return null;
  }

  public static WebStatus parseShareBackground(String paramString, ShareBackgroundItem paramShareBackgroundItem)
  {
    Debug.l(a, "parseShareBackground:" + paramString);
    WebStatus localWebStatus1 = new WebStatus();
    WebStatus localWebStatus2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      WebStatus localWebStatus3 = c(localJSONObject1);
      localWebStatus2 = localWebStatus3;
      try
      {
        if (!localWebStatus2.success())
          return localWebStatus2;
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
        if (localJSONObject2 != null)
        {
          JSONObject localJSONObject3 = localJSONObject2.getJSONObject("list");
          if (localJSONObject3 != null)
          {
            paramShareBackgroundItem.reachedBgUrl = localJSONObject3.getString("reach");
            paramShareBackgroundItem.unReachedBgUrl = localJSONObject3.getString("unreach");
            return localWebStatus2;
          }
        }
      }
      catch (JSONException localJSONException2)
      {
        localWebStatus2.code = 2;
        Debug.i(a, localJSONException2.getMessage());
        return localWebStatus2;
      }
    }
    catch (JSONException localJSONException1)
    {
      while (true)
      {
        localWebStatus2 = localWebStatus1;
        Object localObject = localJSONException1;
      }
    }
    return localWebStatus2;
  }

  public static WebStatus parseUserInfo(String paramString, PersonInfo paramPersonInfo)
  {
    Debug.i(a, "parseUserInfo :" + paramString);
    String str = Utils.purgeJson(paramString);
    WebStatus localWebStatus1 = new WebStatus();
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      WebStatus localWebStatus3 = c(localJSONObject);
      localWebStatus2 = localWebStatus3;
      try
      {
        if (!localWebStatus2.success())
          return localWebStatus2;
        b(localJSONObject.getJSONObject("data"), paramPersonInfo);
        return localWebStatus2;
      }
      catch (JSONException localJSONException2)
      {
      }
      localWebStatus2.code = 2;
      Debug.i(a, localJSONException2.getMessage());
      return localWebStatus2;
    }
    catch (JSONException localJSONException1)
    {
      while (true)
      {
        WebStatus localWebStatus2 = localWebStatus1;
        Object localObject = localJSONException1;
      }
    }
  }

  public static WebStatus parseUserTotalSportData(String paramString, PersonInfo paramPersonInfo)
  {
    WebStatus localWebStatus1 = new WebStatus();
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      WebStatus localWebStatus3 = c(localJSONObject1);
      localWebStatus2 = localWebStatus3;
      try
      {
        if (!localWebStatus2.success())
          return localWebStatus2;
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
        UserTotalSportData localUserTotalSportData = new UserTotalSportData();
        localUserTotalSportData.steps = localJSONObject2.optString("steps");
        localUserTotalSportData.distance = localJSONObject2.optString("distance");
        localUserTotalSportData.calories = localJSONObject2.optString("calories");
        localUserTotalSportData.averageSteps = localJSONObject2.optString("averagesteps");
        localUserTotalSportData.totalwearingdays = localJSONObject2.optString("totalwearingdays");
        paramPersonInfo.totalSportData = localUserTotalSportData;
        return localWebStatus2;
      }
      catch (JSONException localJSONException2)
      {
      }
      localWebStatus2.code = 2;
      Debug.i(a, localJSONException2.getMessage());
      return localWebStatus2;
    }
    catch (JSONException localJSONException1)
    {
      while (true)
      {
        WebStatus localWebStatus2 = localWebStatus1;
        Object localObject = localJSONException1;
      }
    }
  }

  public static String parseWeixinQR(String paramString)
  {
    Debug.l(a, "parseWeixinQR:" + paramString);
    WebStatus localWebStatus = new WebStatus();
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      localWebStatus = c(localJSONObject1);
      if (!localWebStatus.success())
        return null;
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
      if (localJSONObject2 != null)
      {
        String str = localJSONObject2.getString("list");
        return str;
      }
    }
    catch (JSONException localJSONException)
    {
      localWebStatus.code = 2;
      Debug.i(a, localJSONException.getMessage());
    }
    return null;
  }

  public static String parseXiaoMiUserPhone(String paramString)
  {
    if (paramString == null)
      return "";
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      boolean bool = localJSONObject1.optString("result").equals("ok");
      if (!bool)
        return "";
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("data");
      if (localJSONObject2 != null)
      {
        String str = localJSONObject2.optString("phone");
        return str;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }

  public static LoginInfo parseXiaoMiUserProfile(LoginInfo paramLoginInfo, String paramString)
  {
    if (paramLoginInfo == null);
    for (LoginInfo localLoginInfo = new LoginInfo(); ; localLoginInfo = paramLoginInfo)
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        if (!localJSONObject1.optString("result").equals("ok"))
          return localLoginInfo;
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("data");
        if (localJSONObject2 == null)
          break;
        localLoginInfo.aliasNick = localJSONObject2.optString("aliasNick");
        localLoginInfo.miliaoNick = localJSONObject2.optString("miliaoNick");
        localLoginInfo.miid = localJSONObject2.optString("userId");
        localLoginInfo.miliaoIcon = localJSONObject2.optString("miliaoIcon");
        localLoginInfo.miliaoIcon_320 = localJSONObject2.optString("miliaoIcon_320");
        return localLoginInfo;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localLoginInfo;
      }
    return localLoginInfo;
  }

  public static LoginInfo parseXiaoMiUserRelation(LoginInfo paramLoginInfo, String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (!localJSONObject1.optString("result").equals("ok"))
        return paramLoginInfo;
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("data");
      if (localJSONObject2 != null)
      {
        paramLoginInfo.friends = localJSONObject2.optString("friends");
        return paramLoginInfo;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramLoginInfo;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.webapi.WebRes
 * JD-Core Version:    0.6.2
 */