package cn.com.smartdevices.bracelet;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.FragmentManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleSetPersonalInfoTask;
import cn.com.smartdevices.bracelet.activity.WebActivity;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.model.SwitchOperator;
import cn.com.smartdevices.bracelet.ui.ApkUpgradeFragment;
import cn.com.smartdevices.bracelet.ui.DimPanelFragment;
import cn.com.smartdevices.bracelet.ui.ProgressBarFragment;
import cn.com.smartdevices.bracelet.view.Util;
import cn.com.smartdevices.bracelet.webapi.BraceletHttpClient;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.gatt.IGattCallback.STATE;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import com.xiaomi.market.sdk.UpdateResponse;
import com.xiaomi.market.sdk.XiaomiUpdateAgent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Utils
{
  public static final String APK_PATH = "APK_PATH";
  public static final String CHANGE_LOG = "CHANGE_LOG";
  public static final boolean DEBUG = true;
  public static final String DEVICE_TYPE = "0";
  public static final boolean DISABLE_BAIDU_LOCATION = true;
  public static final boolean USE_MILIAO_ICON = true;
  public static final boolean USE_MILIAO_NICKNAME = true;
  public static final String VERSION_NAME = "VERSION_NAME";
  private static final String a = "Utils";
  private static Gson b;
  private static final String[] c = { "MI 3W", "MI 2", "MI 2S" };
  private static final String[] d = { "jt>", "aku", "blv", "cmw", "dnx", "eoy", "fpz", "gq!", "hr(", "is)" };

  public static String URLDecodeStr(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "utf-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return paramString;
  }

  private static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int k = 1;
    int m;
    int n;
    if ((i > paramInt2) || (j > paramInt1))
    {
      m = i / 2;
      n = j / 2;
    }
    while (true)
    {
      if ((m / k <= paramInt2) || (n / k <= paramInt1))
        return k;
      k <<= 1;
    }
  }

  private static String a(Context paramContext, int paramInt)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("#.#");
    float f1 = paramInt / 42000.0F;
    float f2 = Math.round(f1);
    if (f2 > f1)
      f2 -= 0.5F;
    String str3;
    String str2;
    if (paramInt > 42000.0F)
    {
      str3 = localDecimalFormat.format(f2);
      if (Math.abs(f2 - f1) < 0.1D)
        str2 = paramContext.getString(2131493212, new Object[] { str3 });
    }
    while (true)
    {
      Debug.i("Utils", "maraton:" + paramInt + ", str=" + str2);
      if ((str2 != "") && (str2 != null))
        str2 = ", " + str2;
      return str2;
      str2 = paramContext.getString(2131493213, new Object[] { str3 });
      continue;
      if (Math.abs(paramInt - 21000) < 500)
      {
        str2 = paramContext.getString(2131493214, new Object[] { "1" });
      }
      else if (paramInt > 21000)
      {
        str2 = paramContext.getString(2131493215, new Object[] { "1" });
      }
      else
      {
        float f3 = paramInt / 400.0F;
        float f4 = Math.round(f3);
        if (f4 > f3)
          f4 -= 0.5F;
        String str1 = localDecimalFormat.format(f4);
        if (f4 == 0.0F)
          str2 = "";
        else
          str2 = paramContext.getString(2131493210, new Object[] { str1 });
      }
    }
  }

  private static String b(Context paramContext, int paramInt)
  {
    int i = paramInt / 9;
    String str;
    if (i == 0)
      str = "";
    DecimalFormat localDecimalFormat;
    do
    {
      return str;
      localDecimalFormat = new DecimalFormat("#.#");
      str = i + paramContext.getString(2131493265);
    }
    while (i < 1000);
    return localDecimalFormat.format(i / 1000.0D) + paramContext.getString(2131493266);
  }

  private static void b(UpdateResponse paramUpdateResponse, Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (paramUpdateResponse == null))
    {
      Debug.i("Utils", "showUpdateDlg return with NULL pointer!");
      return;
    }
    if (!TextUtils.isEmpty(paramUpdateResponse.updateLog))
    {
      Debug.i("Utils", "mi shop updateLog=" + paramUpdateResponse.updateLog);
      paramString = paramUpdateResponse.updateLog;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("VERSION_NAME", paramUpdateResponse.versionName);
    localBundle.putString("CHANGE_LOG", paramString);
    localBundle.putString("APK_PATH", paramUpdateResponse.path);
    DimPanelFragment.showPanel(paramActivity, ApkUpgradeFragment.class, localBundle);
  }

  public static void bytesToDayDataTest(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    Debug.i(paramString1, "=============================" + paramString2 + "============================i");
    for (int j = 0; ; j += 3)
    {
      if (j >= i)
      {
        Debug.i(paramString1, "=============================" + paramString2 + "============================o");
        return;
      }
      IMiLiProfile.ActivityData localActivityData = new IMiLiProfile.ActivityData(paramArrayOfByte[(j + 1)], paramArrayOfByte[(j + 2)], paramArrayOfByte[j]);
      Debug.i(paramString1, new SportData(j / 3, 0xFF & localActivityData.category, 0xFF & localActivityData.intensity, 0xFF & localActivityData.steps).toString());
    }
  }

  public static int calculateInSampleSize1(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int k = 1;
    int m;
    if ((i > paramInt2) || (j > paramInt1))
    {
      k = Math.round(i / paramInt2);
      m = Math.round(j / paramInt1);
      if (k <= m);
    }
    else
    {
      return k;
    }
    return m;
  }

  public static void checkApkUpgrade(Activity paramActivity, boolean paramBoolean)
  {
    Calendar localCalendar = Calendar.getInstance();
    if ((!compaireDateCalendarA_before_B(Keeper.readLastCheckUpdateDate(), localCalendar)) && (!paramBoolean))
    {
      Debug.i("Utils", "Today has checked upgrade.");
      return;
    }
    Keeper.keepCheckUpdateApkDate();
    if (paramBoolean)
      Toast.makeText(paramActivity, 2131493127, 0).show();
    BraceletHttpClient.client.get("https://hm.xiaomi.com/huami.health.changelog.json", new h(paramBoolean));
  }

  public static boolean checkDeviceCompatible()
  {
    String str = Build.MODEL;
    String[] arrayOfString = c;
    int i = arrayOfString.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return false;
      if (arrayOfString[j].equals(str))
        return true;
    }
  }

  public static boolean checkInputText(String paramString)
  {
    if (paramString == null);
    while ((paramString.length() <= 0) || (paramString.length() > 20))
      return false;
    return true;
  }

  public static String checkNull(String paramString)
  {
    if ((paramString == null) || (paramString.equals("null")))
      paramString = "";
    return paramString;
  }

  public static final boolean checkSystemRequirement()
  {
    Debug.i("Utils", "Sdk : " + Build.VERSION.SDK_INT + " model:" + Build.MODEL);
    return Build.VERSION.SDK_INT >= 18;
  }

  public static void checkXiaomiApkUpdate(Activity paramActivity, boolean paramBoolean, String paramString)
  {
    Debug.i("Utils", "checkXiaomiApkUpdate");
    XiaomiUpdateAgent.setUpdateAutoPopup(false);
    XiaomiUpdateAgent.setUpdateListener(new i(paramActivity, paramString, paramBoolean));
    XiaomiUpdateAgent.update(paramActivity);
  }

  public static boolean compaireDateCalendarA_before_B(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if ((paramCalendar1 == null) || (paramCalendar2 == null));
    int n;
    int i1;
    do
    {
      return true;
      int i = paramCalendar1.get(1);
      int j = paramCalendar2.get(1);
      int k = paramCalendar1.get(6);
      int m = paramCalendar2.get(6);
      n = k + i * 365;
      i1 = m + j * 365;
      Debug.i("Utils", "totalA =" + n + ", totalB=" + i1);
    }
    while (n < i1);
    return false;
  }

  public static void connect(BluetoothDevice paramBluetoothDevice, boolean paramBoolean)
  {
    Debug.i("Utils", "connect device=" + paramBluetoothDevice.getAddress() + ",  " + paramBluetoothDevice.getName());
    Debug.f("Utils", "connect device=" + paramBluetoothDevice.getAddress() + ",  " + paramBluetoothDevice.getName());
    BraceletApp.BLEService.stopScan();
    MiLiProfile localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.newConnection(paramBluetoothDevice, MiLiProfile.class);
    localMiLiProfile.setAutoReconnect(paramBoolean);
    localMiLiProfile.connect();
  }

  public static float convertDpToPixel(float paramFloat, Context paramContext)
  {
    return paramFloat * (paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F);
  }

  public static float convertPixelsToDp(float paramFloat, Context paramContext)
  {
    return paramFloat / (paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F);
  }

  public static ArrayList<SportData> copy(ArrayList<SportData> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    try
    {
      Iterator localIterator = paramArrayList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return localArrayList;
        localArrayList.add(((SportData)localIterator.next()).copy());
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
      localArrayList.clear();
    }
    return localArrayList;
  }

  public static ArrayList<SportData> copyBySerialize(ArrayList<SportData> paramArrayList)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramArrayList);
      ArrayList localArrayList = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(localByteArrayOutputStream.toByteArray())).readObject();
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Debug.i("WPJ", localException.getMessage());
    }
    return new ArrayList();
  }

  public static Bitmap createImageSafely(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSize1(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    try
    {
      Bitmap localBitmap2 = BitmapFactory.decodeFile(paramString, localOptions);
      localBitmap1 = localBitmap2;
      Debug.i("WPJ", "createImageSafely:" + localBitmap1.getWidth() + "," + localBitmap1.getHeight() + "==" + localOptions.inSampleSize);
      return localBitmap1;
    }
    catch (Exception localException)
    {
      while (true)
        Bitmap localBitmap1 = null;
    }
  }

  public static String encodeTel(String paramString)
  {
    String str1 = paramString.replace("+", "");
    if (str1.startsWith("86"))
      str1 = str1.substring(2, str1.length());
    Object localObject = "";
    int i = 0;
    try
    {
      while (true)
      {
        if (i >= str1.length())
          return localObject;
        int j = Integer.valueOf(str1.charAt(i)).intValue();
        int k = (int)(3.0D * Math.random());
        char c1 = d[j].charAt(k);
        String str2 = localObject + c1;
        localObject = str2;
        i++;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localObject;
  }

  public static String getContinueReachGoalShareTips(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str1 = a(paramContext, paramInt2);
    int i = paramInt3 / 9;
    if (i == 0);
    while (true)
    {
      String[] arrayOfString = ChartData.formatDistance(paramContext, paramInt2);
      String str2 = arrayOfString[0] + arrayOfString[1];
      String str3 = paramInt1 / paramInt4;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      arrayOfObject[1] = str3;
      arrayOfObject[2] = str2;
      arrayOfObject[3] = str1;
      return paramContext.getString(2131493216, arrayOfObject);
      DecimalFormat localDecimalFormat = new DecimalFormat("#.#");
      new StringBuilder(String.valueOf(i)).append(paramContext.getString(2131493265)).toString();
      if (i >= 1000)
        new StringBuilder(String.valueOf(localDecimalFormat.format(i / 1000.0D))).append(paramContext.getString(2131493266)).toString();
    }
  }

  public static String getDateStringFromMillisecond(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null)
      paramString1 = "MM/dd HH:mm";
    if (paramString2 == null)
      return paramContext.getString(2131493080);
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString1);
      Long localLong1 = Long.valueOf(System.currentTimeMillis());
      Long.valueOf(0L);
      if (paramString2.length() < 13);
      Long localLong3;
      for (Long localLong2 = Long.valueOf(1000L * Long.parseLong(paramString2)); ; localLong2 = Long.valueOf(Long.parseLong(paramString2)))
      {
        localLong3 = Long.valueOf(Long.valueOf(localLong1.longValue() - localLong2.longValue()).longValue() / 60000L);
        if (localLong3.longValue() != 0L)
          break;
        return paramContext.getString(2131493080);
      }
      if ((localLong3.longValue() > 0L) && (localLong3.longValue() < 60L))
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localLong3;
        return paramContext.getString(2131493081, arrayOfObject);
      }
      Date localDate = new Date(localLong2.longValue());
      if ((localLong3.longValue() > 60L) && (localLong3.longValue() < 1440L))
      {
        String str2 = localSimpleDateFormat.format(localDate);
        int i = str2.length();
        return paramContext.getString(2131493082) + " " + str2.substring(i - 5, i);
      }
      String str1 = localSimpleDateFormat.format(localDate);
      return str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public static int getFwVersion(byte[] paramArrayOfByte)
  {
    return (0xFF & paramArrayOfByte[1059]) << 24 | (0xFF & paramArrayOfByte[1058]) << 16 | (0xFF & paramArrayOfByte[1057]) << 8 | 0xFF & paramArrayOfByte[1056];
  }

  public static Gson getGson()
  {
    if (b == null)
      b = new Gson();
    return b;
  }

  public static String getMiuiBuildTimestamp(Context paramContext)
  {
    return getSystemProperties(paramContext, "ro.build.date.utc");
  }

  public static String getMiuiBuildVersion(Context paramContext)
  {
    return getSystemProperties(paramContext, "ro.build.version.incremental");
  }

  public static String getMiuiVersionCode(Context paramContext)
  {
    return getSystemProperties(paramContext, "ro.miui.ui.version.code");
  }

  public static String getMiuiVersionName(Context paramContext)
  {
    return getSystemProperties(paramContext, "ro.miui.ui.version.name");
  }

  public static String getMonthShareTips(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    String[] arrayOfString = ChartData.formatDistance(paramContext, paramInt2);
    String str1 = arrayOfString[0] + arrayOfString[1];
    String str2 = new DecimalFormat("#.#").format(1.0E-004F * paramInt2);
    String str3 = a(paramContext, paramInt2);
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = str1;
    arrayOfObject[1] = str3;
    arrayOfObject[2] = Integer.valueOf(paramInt3);
    arrayOfObject[3] = str2;
    arrayOfObject[4] = paramString;
    arrayOfObject[5] = paramInt4;
    return paramContext.getString(2131493211, arrayOfObject);
  }

  public static String getPhoneNum(Context paramContext)
  {
    String str = ((TelephonyManager)paramContext.getSystemService("phone")).getLine1Number();
    Debug.i("Utils", "get tel =" + str);
    if (str == null)
      str = "";
    return str;
  }

  public static String getStringFromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return "";
    try
    {
      String str = new String(paramArrayOfByte);
      return str;
    }
    catch (Exception localException)
    {
      Debug.i("chenee", "Utils.java getStringFromBytes error:" + localException.getMessage());
    }
    return "";
  }

  public static String getSyncTime(Context paramContext)
  {
    long l = Keeper.readSyncTime();
    if (!isToday(l))
      return paramContext.getString(2131493282);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
    Date localDate = new Date(l);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = localSimpleDateFormat.format(localDate);
    return paramContext.getString(2131493150, arrayOfObject);
  }

  public static String getSystemProperties(Context paramContext, String paramString)
  {
    try
    {
      Class localClass = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      Method localMethod = localClass.getMethod("get", new Class[] { String.class });
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = new String(paramString);
      String str = (String)localMethod.invoke(localClass, arrayOfObject);
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw localIllegalArgumentException;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static String getWeekShareTips(Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    String[] arrayOfString = ChartData.formatDistance(paramContext, paramInt1);
    String str1 = arrayOfString[0] + arrayOfString[1];
    String str2 = a(paramContext, paramInt1);
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = str1;
    arrayOfObject[1] = str2;
    arrayOfObject[2] = Integer.valueOf(paramInt2);
    arrayOfObject[3] = paramString;
    arrayOfObject[4] = paramInt3;
    return paramContext.getString(2131493209, arrayOfObject);
  }

  public static void gotoWeb(String paramString1, String paramString2, Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, WebActivity.class);
    localIntent.putExtra("web_type", 2);
    localIntent.putExtra("web_url", paramString1);
    localIntent.putExtra("Label", paramString2);
    paramActivity.startActivity(localIntent);
  }

  public static void hideProgressDialog(Activity paramActivity)
  {
    if (paramActivity == null);
    DialogFragment localDialogFragment;
    do
    {
      return;
      localDialogFragment = (DialogFragment)paramActivity.getFragmentManager().findFragmentByTag(ProgressBarFragment.class.getName());
    }
    while (localDialogFragment == null);
    localDialogFragment.dismiss();
  }

  public static boolean isBinded()
  {
    BraceletBtInfo localBraceletBtInfo = Keeper.readBraceletBtInfo();
    return (localBraceletBtInfo != null) && (BluetoothAdapter.checkBluetoothAddress(localBraceletBtInfo.address));
  }

  public static boolean isBraceletConnected()
  {
    if (BraceletApp.BLEService == null)
      return false;
    MiLiProfile localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
    return (localMiLiProfile != null) && (localMiLiProfile.getProfileState() == 1) && (localMiLiProfile.getState() == IGattCallback.STATE.CONNECTED);
  }

  public static boolean isNetworkConnected(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager.getActiveNetworkInfo() != null)
      return localConnectivityManager.getActiveNetworkInfo().isConnected();
    return false;
  }

  public static boolean isSupportBle(Context paramContext)
  {
    boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    Debug.i("Utils", "isSupportBle:" + bool);
    return bool;
  }

  public static boolean isSupportMiuiUnlock(Context paramContext)
  {
    String str = getSystemProperties(paramContext, "sys.keyguard.bleunlock");
    Debug.i("Utils", "unlock:" + str);
    return (str != null) && (str.equals("true"));
  }

  public static boolean isSupportUnlockScreenByBracelet(Context paramContext)
  {
    if (!isSupportBle(paramContext));
    String str1;
    String str2;
    do
    {
      return false;
      str1 = getSystemProperties(paramContext, "ro.miui.ui.version.name");
      str2 = getSystemProperties(paramContext, "ro.miui.ui.version.code");
      Debug.i("Utils", "isSupportUnlockScreenByBracelet:miui version name=" + str1 + ",miui version code=" + str2);
    }
    while ((str2 == null) || (str2.length() == 0) || (str1 == null) || (str1.length() == 0) || (Integer.valueOf(str2).intValue() < 3));
    return true;
  }

  public static boolean isToday(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    int i = localTime.year;
    int j = localTime.month;
    int k = localTime.monthDay;
    localTime.set(System.currentTimeMillis());
    return (i == localTime.year) && (j == localTime.month) && (k == localTime.monthDay);
  }

  public static boolean isUseUnlockByBracelet(Context paramContext)
  {
    try
    {
      int i = Settings.Secure.getInt(paramContext.getContentResolver(), "bluetooth_unlock_status");
      return i == 1;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      localSettingNotFoundException.printStackTrace();
    }
    return false;
  }

  public static boolean isViewContains(View paramView, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[bool];
    int k = paramView.getWidth();
    int m = paramView.getHeight();
    if ((paramInt1 < i) || (paramInt1 > i + k) || (paramInt2 < j) || (paramInt2 > j + m))
      bool = false;
    return bool;
  }

  public static String purgeJson(String paramString)
  {
    Debug.i("Utils", "\n====>         before purge json :" + paramString);
    String str = paramString.replace("\"[", "[").replace("]\"", "]").replace("}\"", "}").replace("\"{", "{").replace("\\\"", "\"").replace("\\/", "/");
    Debug.i("Utils", "\n====>         after purge json([], {},\\\", \\/) :" + str);
    return str;
  }

  public static void queryDownloadStatus(Activity paramActivity)
  {
    DownloadManager localDownloadManager = (DownloadManager)paramActivity.getSystemService("download");
    DownloadManager.Query localQuery = new DownloadManager.Query();
    long l = Keeper.readDownloadApkId();
    localQuery.setFilterById(new long[] { l });
    Cursor localCursor = localDownloadManager.query(localQuery);
    if (localCursor.moveToFirst());
    switch (localCursor.getInt(localCursor.getColumnIndex("status")))
    {
    default:
      return;
    case 4:
      Debug.i("Utils", "STATUS_PAUSED");
    case 1:
      Debug.i("Utils", "STATUS_PENDING");
    case 2:
      Debug.i("Utils", "STATUS_RUNNING");
      return;
    case 8:
      Debug.i("Utils", "STATUS_SUCCESSFUL download_id=" + l);
      Uri localUri = localDownloadManager.getUriForDownloadedFile(l);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(localUri, "application/vnd.android.package-archive");
      localIntent.setFlags(268435456);
      paramActivity.startActivity(localIntent);
      Toast.makeText(paramActivity, 2131493117, 1).show();
      Keeper.keepDownloadApkId(-1L);
      return;
    case 16:
    }
    Debug.i("Utils", "STATUS_FAILED");
    long[] arrayOfLong = new long[1];
    arrayOfLong[0] = Keeper.readDownloadApkId();
    localDownloadManager.remove(arrayOfLong);
    Keeper.keepDownloadApkId(-1L);
    Toast.makeText(paramActivity, 2131493115, 1).show();
  }

  public static boolean removeBond(Class<BluetoothDevice> paramClass, BluetoothDevice paramBluetoothDevice)
  {
    try
    {
      boolean bool = ((Boolean)paramClass.getMethod("removeBond", new Class[0]).invoke(paramBluetoothDevice, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public static String saveBitmapToFile(Bitmap paramBitmap)
  {
    return saveBitmapToFile(paramBitmap, 100);
  }

  public static String saveBitmapToFile(Bitmap paramBitmap, int paramInt)
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tmp.jpg";
    saveBitmapToFile(str, paramBitmap, paramInt);
    return str;
  }

  public static void saveBitmapToFile(String paramString, Bitmap paramBitmap)
  {
    saveBitmapToFile(paramString, paramBitmap, 100);
  }

  public static void saveBitmapToFile(String paramString, Bitmap paramBitmap, int paramInt)
  {
    File localFile = new File(paramString);
    if (localFile.exists())
      localFile.delete();
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localFileOutputStream);
      localFileOutputStream.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void sendUserInfo2Mili()
  {
    PersonInfo localPersonInfo = Keeper.readPersonInfo();
    if (!localPersonInfo.isValid())
      Debug.i("Utils", "                 sendUserInfo2Mili, Person info InValid =" + localPersonInfo + "\n");
    new BleSetPersonalInfoTask(localPersonInfo, new f()).work();
  }

  public static void setAutoReconnect(boolean paramBoolean)
  {
    if (BraceletApp.BLEService != null)
    {
      MiLiProfile localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
      if (localMiLiProfile != null)
      {
        Debug.i("Utils", "Set auto reconnect :" + paramBoolean);
        localMiLiProfile.setAutoReconnect(paramBoolean);
        return;
      }
    }
    Debug.i("Utils", "Set auto reconnect fail");
  }

  public static void showProgressDialog(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null)
      return;
    hideProgressDialog(paramActivity);
    Bundle localBundle = new Bundle();
    localBundle.putString("REF_PROGRESS_INFO", paramActivity.getString(paramInt));
    DimPanelFragment.showPanel(paramActivity, ProgressBarFragment.class, localBundle);
  }

  public static void switchBracelet(Context paramContext, int paramInt)
  {
    SwitchOperator localSwitchOperator = new SwitchOperator();
    localSwitchOperator.type = paramInt;
    boolean bool1;
    if (paramInt == 0)
    {
      bool1 = true;
      localSwitchOperator.enableClearData = bool1;
      if (paramInt != 0)
        break label186;
    }
    label186: for (boolean bool2 = true; ; bool2 = false)
    {
      localSwitchOperator.enableSteps = bool2;
      if (paramInt == 1)
      {
        localSwitchOperator.lastUid = Keeper.readLoginData().uid;
        localSwitchOperator.lastMacAddress = Keeper.readBraceletBtInfo().address;
      }
      localSwitchOperator.date = new SportDay().getKey();
      DataManager localDataManager = DataManager.getInstance();
      DaySportData localDaySportData = localDataManager.get(localDataManager.getStopDay());
      if (localDaySportData != null)
      {
        StepsInfo localStepsInfo = localDaySportData.getStepsInfo();
        if (localStepsInfo != null)
          localSwitchOperator.steps = localStepsInfo.getStepsCount();
      }
      Keeper.keepSwitchOperator(localSwitchOperator);
      if (BraceletApp.BLEService != null)
      {
        MiLiProfile localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
        if (localMiLiProfile != null)
        {
          localMiLiProfile.setAutoReconnect(false);
          localMiLiProfile.disconnect();
        }
      }
      Intent localIntent = new Intent();
      localIntent.setAction("com.xiaomi.hm.health.ACTION_DEVICE_UNBIND_APPLICATION");
      paramContext.sendBroadcast(localIntent);
      return;
      bool1 = false;
      break;
    }
  }

  public static void updateAvatarUI(PersonInfo paramPersonInfo, ImageView paramImageView)
  {
    String str = paramPersonInfo.avatarPath;
    Bitmap localBitmap = null;
    if (str != null)
    {
      boolean bool = paramPersonInfo.avatarPath.equals("");
      localBitmap = null;
      if (!bool)
      {
        Uri localUri = Uri.fromFile(new File(paramPersonInfo.avatarPath));
        localBitmap = BraceletImageLoader.getInstance().loadImageSync(localUri.toString());
        Debug.i("Utils", "path=" + paramPersonInfo.avatarPath + " avatarBitmap=" + localBitmap);
        if (localBitmap != null)
          paramImageView.setBackground(new BitmapDrawable(Util.clipToRoundBitmap(localBitmap)));
      }
    }
    if (localBitmap == null)
    {
      Debug.i("Utils", "avatar Url =" + paramPersonInfo.avatarUrl);
      BraceletImageLoader.getInstance().displayRoundImage(paramPersonInfo.avatarUrl, paramImageView);
    }
  }

  public static void updateProfile(PersonInfo paramPersonInfo)
  {
    if (!paramPersonInfo.isValid())
    {
      Debug.i("Utils", "personInfo is inValid!");
      return;
    }
    WebAPI.updateProfile(Keeper.readLoginData(), paramPersonInfo, new g(paramPersonInfo));
  }

  public static void updateProfile(PersonInfo paramPersonInfo, HashMap<String, String> paramHashMap, Utils.OperationCallback paramOperationCallback)
  {
    WebAPI.updateProfile(Keeper.readLoginData(), paramHashMap, new e(paramOperationCallback, paramPersonInfo));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.Utils
 * JD-Core Version:    0.6.2
 */