package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;

public class ResourceManager
{
  private static final String DIALOG_BACKGROUND_IMAGE_NAME = "weibosdk_dialog_bg.9.png";
  public static final int DIALOG_BOTTOM_MARGIN = 10;
  private static final String DIALOG_CLOSE_BUTTON_IMAGE_NAME = "ic_com_sina_weibo_sdk_close.png";
  public static final int DIALOG_LEFT_MARGIN = 10;
  public static final int DIALOG_RIGHT_MARGIN = 10;
  public static final int DIALOG_TOP_MARGIN = 30;
  private static final String DRAWABLE = "drawable";
  private static final String DRAWABLE_HDPI = "drawable-hdpi";
  private static final String DRAWABLE_LDPI = "drawable-ldpi";
  private static final String DRAWABLE_MDPI = "drawable-mdpi";
  private static final String DRAWABLE_XHDPI = "drawable-xhdpi";
  private static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
  private static final String LOADING_EN = "Loading...";
  private static final String LOADING_ZH_CN = "加载中...";
  private static final String LOADING_ZH_TW = "載入中...";
  private static final String NETWORK_NOT_AVAILABLE_EN = "Network is not available";
  private static final String NETWORK_NOT_AVAILABLE_ZH_CN = "无法连接到网络，请检查网络配置";
  private static final String NETWORK_NOT_AVAILABLE_ZH_TW = "無法連接到網络，請檢查網络配置";
  private static final String[] PRE_INSTALL_DRAWBLE_PATHS;
  private static final String TAG = ResourceManager.class.getName();
  public static final int dimen_dialog_bottom_margin = 4;
  public static final int dimen_dialog_left_margin = 1;
  public static final int dimen_dialog_right_margin = 3;
  public static final int dimen_dialog_top_margin = 2;
  public static final int drawable_dialog_background = 1;
  public static final int drawable_dialog_close_button = 2;
  private static final SparseArray<String> sDrawableMap;
  private static final HashMap<Locale, SparseArray<String>> sLanguageMap;
  private static final SparseIntArray sLayoutMap;
  public static final int string_loading = 1;
  public static final int string_network_not_available = 2;

  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    sLayoutMap = localSparseIntArray;
    localSparseIntArray.put(1, 10);
    sLayoutMap.put(2, 30);
    sLayoutMap.put(3, 10);
    sLayoutMap.put(4, 10);
    PRE_INSTALL_DRAWBLE_PATHS = new String[] { "drawable-xxhdpi", "drawable-xhdpi", "drawable-hdpi", "drawable-mdpi", "drawable-ldpi", "drawable" };
    SparseArray localSparseArray1 = new SparseArray();
    sDrawableMap = localSparseArray1;
    localSparseArray1.put(1, "weibosdk_dialog_bg.9.png");
    sDrawableMap.put(2, "ic_com_sina_weibo_sdk_close.png");
    sLanguageMap = new HashMap();
    SparseArray localSparseArray2 = new SparseArray();
    localSparseArray2.put(1, "加载中...");
    localSparseArray2.put(2, "无法连接到网络，请检查网络配置");
    sLanguageMap.put(Locale.SIMPLIFIED_CHINESE, localSparseArray2);
    SparseArray localSparseArray3 = new SparseArray();
    localSparseArray3.put(1, "載入中...");
    localSparseArray3.put(2, "無法連接到網络，請檢查網络配置");
    sLanguageMap.put(Locale.TRADITIONAL_CHINESE, localSparseArray3);
    SparseArray localSparseArray4 = new SparseArray();
    localSparseArray4.put(1, "Loading...");
    localSparseArray4.put(2, "Network is not available");
    sLanguageMap.put(Locale.ENGLISH, localSparseArray4);
  }

  private static Drawable extractDrawable(Context paramContext, String paramString)
  {
    InputStream localInputStream = paramContext.getAssets().open(paramString);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    TypedValue localTypedValue = new TypedValue();
    localTypedValue.density = localDisplayMetrics.densityDpi;
    Drawable localDrawable = Drawable.createFromResourceStream(paramContext.getResources(), localTypedValue, localInputStream, paramString);
    localInputStream.close();
    return localDrawable;
  }

  private static View extractView(Context paramContext, String paramString, ViewGroup paramViewGroup)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getAssets().openXmlResourceParser(paramString);
    return ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(localXmlResourceParser, paramViewGroup);
  }

  public static String getAppropriatePathOfDrawable(Context paramContext, String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString))
    {
      LogUtil.e(TAG, "id is NOT correct!");
      return null;
    }
    String str1 = getCurrentDpiFolder(paramContext);
    String str2 = str1 + "/" + paramString;
    LogUtil.i(TAG, "Maybe the appropriate path: " + str2);
    if (isFileExisted(paramContext, str2))
      return str2;
    LogUtil.d(TAG, "Not the correct path, we need to find one...");
    int j = 0;
    if (j >= PRE_INSTALL_DRAWBLE_PATHS.length)
    {
      LogUtil.e(TAG, "Not find the appropriate path for drawable");
      return null;
    }
    if (i == 0)
      if (str1.equals(PRE_INSTALL_DRAWBLE_PATHS[j]))
      {
        i = 1;
        LogUtil.i(TAG, "Have Find index: " + j + ", " + PRE_INSTALL_DRAWBLE_PATHS[j]);
      }
    String str3;
    do
    {
      j++;
      break;
      str3 = PRE_INSTALL_DRAWBLE_PATHS[j] + "/" + paramString;
    }
    while (!isFileExisted(paramContext, str3));
    return str3;
  }

  private static String getCurrentDpiFolder(Context paramContext)
  {
    int i = paramContext.getResources().getDisplayMetrics().densityDpi;
    if (i <= 120)
      return "drawable-ldpi";
    if ((i > 120) && (i <= 160))
      return "drawable-mdpi";
    if ((i > 160) && (i <= 240))
      return "drawable-hdpi";
    if ((i > 240) && (i <= 320))
      return "drawable-xhdpi";
    return "drawable-xxhdpi";
  }

  public static int getDimensionPixelSize(int paramInt)
  {
    return sLayoutMap.get(paramInt, 0);
  }

  public static Drawable getDrawable(Context paramContext, int paramInt)
  {
    return getDrawableFromAssert(paramContext, getAppropriatePathOfDrawable(paramContext, (String)sDrawableMap.get(paramInt, "")), false);
  }

  // ERROR //
  public static Drawable getDrawableFromAssert(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 139	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore_3
    //   5: aload_3
    //   6: aload_1
    //   7: invokevirtual 145	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore 10
    //   12: aload 10
    //   14: astore 7
    //   16: aload 7
    //   18: ifnull +210 -> 228
    //   21: aload 7
    //   23: invokestatic 287	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   26: astore 13
    //   28: aload_0
    //   29: invokevirtual 149	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   32: invokevirtual 155	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   35: astore 14
    //   37: iload_2
    //   38: ifeq +68 -> 106
    //   41: aload_0
    //   42: invokevirtual 149	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   45: invokevirtual 291	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   48: astore 15
    //   50: new 293	android/graphics/drawable/NinePatchDrawable
    //   53: dup
    //   54: new 151	android/content/res/Resources
    //   57: dup
    //   58: aload_0
    //   59: invokevirtual 139	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   62: aload 14
    //   64: aload 15
    //   66: invokespecial 296	android/content/res/Resources:<init>	(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V
    //   69: aload 13
    //   71: aload 13
    //   73: invokevirtual 302	android/graphics/Bitmap:getNinePatchChunk	()[B
    //   76: new 304	android/graphics/Rect
    //   79: dup
    //   80: iconst_0
    //   81: iconst_0
    //   82: iconst_0
    //   83: iconst_0
    //   84: invokespecial 307	android/graphics/Rect:<init>	(IIII)V
    //   87: aconst_null
    //   88: invokespecial 310	android/graphics/drawable/NinePatchDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;[BLandroid/graphics/Rect;Ljava/lang/String;)V
    //   91: astore 11
    //   93: aload 7
    //   95: ifnull +8 -> 103
    //   98: aload 7
    //   100: invokevirtual 177	java/io/InputStream:close	()V
    //   103: aload 11
    //   105: areturn
    //   106: aload 13
    //   108: aload 14
    //   110: getfield 163	android/util/DisplayMetrics:densityDpi	I
    //   113: invokevirtual 314	android/graphics/Bitmap:setDensity	(I)V
    //   116: new 316	android/graphics/drawable/BitmapDrawable
    //   119: dup
    //   120: aload_0
    //   121: invokevirtual 149	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   124: aload 13
    //   126: invokespecial 319	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   129: astore 11
    //   131: goto -38 -> 93
    //   134: astore 4
    //   136: aload 7
    //   138: astore 5
    //   140: aload 4
    //   142: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   145: aload 5
    //   147: ifnull +79 -> 226
    //   150: aload 5
    //   152: invokevirtual 177	java/io/InputStream:close	()V
    //   155: aconst_null
    //   156: areturn
    //   157: astore 9
    //   159: aload 9
    //   161: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   164: aconst_null
    //   165: areturn
    //   166: astore 6
    //   168: aconst_null
    //   169: astore 7
    //   171: aload 7
    //   173: ifnull +8 -> 181
    //   176: aload 7
    //   178: invokevirtual 177	java/io/InputStream:close	()V
    //   181: aload 6
    //   183: athrow
    //   184: astore 8
    //   186: aload 8
    //   188: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   191: goto -10 -> 181
    //   194: astore 12
    //   196: aload 12
    //   198: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   201: aload 11
    //   203: areturn
    //   204: astore 6
    //   206: goto -35 -> 171
    //   209: astore 6
    //   211: aload 5
    //   213: astore 7
    //   215: goto -44 -> 171
    //   218: astore 4
    //   220: aconst_null
    //   221: astore 5
    //   223: goto -83 -> 140
    //   226: aconst_null
    //   227: areturn
    //   228: aconst_null
    //   229: astore 11
    //   231: goto -138 -> 93
    //
    // Exception table:
    //   from	to	target	type
    //   21	37	134	java/io/IOException
    //   41	93	134	java/io/IOException
    //   106	131	134	java/io/IOException
    //   150	155	157	java/io/IOException
    //   5	12	166	finally
    //   176	181	184	java/io/IOException
    //   98	103	194	java/io/IOException
    //   21	37	204	finally
    //   41	93	204	finally
    //   106	131	204	finally
    //   140	145	209	finally
    //   5	12	218	java/io/IOException
  }

  public static Locale getLanguage()
  {
    Locale localLocale = Locale.getDefault();
    if ((Locale.SIMPLIFIED_CHINESE.equals(localLocale)) || (Locale.TRADITIONAL_CHINESE.equals(localLocale)))
      return localLocale;
    return Locale.ENGLISH;
  }

  public static Drawable getNinePatchDrawable(Context paramContext, int paramInt)
  {
    return getDrawableFromAssert(paramContext, getAppropriatePathOfDrawable(paramContext, (String)sDrawableMap.get(paramInt, "")), true);
  }

  public static String getString(Context paramContext, int paramInt)
  {
    Locale localLocale = getLanguage();
    return (String)((SparseArray)sLanguageMap.get(localLocale)).get(paramInt, "");
  }

  private static boolean isFileExisted(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)));
    InputStream localInputStream;
    while (true)
    {
      return false;
      AssetManager localAssetManager = paramContext.getAssets();
      localInputStream = null;
      try
      {
        localInputStream = localAssetManager.open(paramString);
        LogUtil.d(TAG, "file [" + paramString + "] existed");
        if (localInputStream != null);
        try
        {
          localInputStream.close();
          return true;
        }
        catch (IOException localIOException4)
        {
          while (true)
            localIOException4.printStackTrace();
        }
      }
      catch (IOException localIOException2)
      {
        LogUtil.d(TAG, "file [" + paramString + "] NOT existed");
        if (localInputStream != null)
          try
          {
            localInputStream.close();
            return false;
          }
          catch (IOException localIOException3)
          {
            localIOException3.printStackTrace();
            return false;
          }
      }
      finally
      {
        if (localInputStream == null);
      }
    }
    try
    {
      localInputStream.close();
      throw localObject;
    }
    catch (IOException localIOException1)
    {
      while (true)
        localIOException1.printStackTrace();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.utils.ResourceManager
 * JD-Core Version:    0.6.2
 */