package com.xiaomi.market.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class a
{
  static int a;
  static int b;
  static String c;
  static int d;
  static int e;
  static String f;
  static ArrayList g;
  static ArrayList h;
  static ArrayList i;
  static int j;
  static String k;
  static String l;
  static String m;
  static String n;
  static String o;
  static String p;
  private static int q;
  private static final Object r = new Object();

  private static void a()
  {
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay1 = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    EGLDisplay localEGLDisplay2 = EGL10.EGL_NO_DISPLAY;
    Object localObject1 = null;
    EGLConfig localEGLConfig;
    EGLContext localEGLContext;
    EGLSurface localEGLSurface1;
    if (localEGLDisplay1 != localEGLDisplay2)
    {
      boolean bool1 = localEGL10.eglInitialize(localEGLDisplay1, new int[2]);
      localObject1 = null;
      if (bool1)
      {
        int[] arrayOfInt = new int[1];
        EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
        boolean bool2 = localEGL10.eglChooseConfig(localEGLDisplay1, new int[] { 12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, arrayOfEGLConfig, 1, arrayOfInt);
        localObject1 = null;
        if (bool2)
        {
          if (arrayOfInt[0] <= 0)
            break label431;
          localEGLConfig = arrayOfEGLConfig[0];
          localEGLContext = localEGL10.eglCreateContext(localEGLDisplay1, localEGLConfig, EGL10.EGL_NO_CONTEXT, null);
          localEGLSurface1 = localEGL10.eglCreatePbufferSurface(localEGLDisplay1, localEGLConfig, new int[] { 12375, 480, 12374, 800, 12344 });
          localObject1 = null;
          if (localEGLSurface1 != null)
          {
            EGLSurface localEGLSurface2 = EGL10.EGL_NO_SURFACE;
            localObject1 = null;
            if (localEGLSurface1 != localEGLSurface2)
              break label295;
          }
        }
      }
    }
    while (true)
    {
      int i1;
      int i2;
      synchronized (r)
      {
        i = new ArrayList();
        String[] arrayOfString;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          arrayOfString = TextUtils.split((String)localObject1, " ");
          i1 = arrayOfString.length;
          i2 = 0;
        }
        else
        {
          Collections.sort(i);
          return;
          label295: localEGL10.eglMakeCurrent(localEGLDisplay1, localEGLSurface1, localEGLSurface1, localEGLContext);
          boolean bool3 = localEGL10.eglMakeCurrent(localEGLDisplay1, localEGLSurface1, localEGLSurface1, localEGLContext);
          localObject1 = null;
          if (!bool3)
            continue;
          String str2 = ((GL10)localEGLContext.getGL()).glGetString(7939);
          localEGL10.eglDestroySurface(localEGLDisplay1, localEGLSurface1);
          localEGL10.eglDestroyContext(localEGLDisplay1, localEGLContext);
          localEGL10.eglTerminate(localEGLDisplay1);
          localObject1 = null;
          if (str2 == null)
            continue;
          localObject1 = str2.trim();
          continue;
          String str1 = arrayOfString[i2];
          if (!TextUtils.isEmpty(str1))
            i.add(str1);
          i2++;
        }
      }
      label431: localEGLConfig = null;
      break;
      if (i2 < i1);
    }
  }

  static void a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    b = localDisplayMetrics.heightPixels;
    a = localDisplayMetrics.widthPixels;
    c = b + "*" + a;
    d = localDisplayMetrics.densityDpi;
    ConfigurationInfo localConfigurationInfo = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
    e = localConfigurationInfo.reqTouchScreen;
    f = localConfigurationInfo.getGlEsVersion();
    d(paramContext);
    e(paramContext);
    a();
    l = Build.VERSION.RELEASE;
    k = Build.VERSION.INCREMENTAL;
    j = Build.VERSION.SDK_INT;
    p = Locale.getDefault().getCountry();
    o = Locale.getDefault().getLanguage();
    String str1 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    if (TextUtils.isEmpty(str1));
    for (String str2 = ""; ; str2 = str1)
    {
      m = str2;
      String str3 = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      StringBuffer localStringBuffer = new StringBuffer();
      if (!TextUtils.isEmpty(str2))
        localStringBuffer.append(str2);
      if (!TextUtils.isEmpty(str3))
      {
        localStringBuffer.append("_");
        localStringBuffer.append(str3);
      }
      n = b.a(localStringBuffer.toString());
      return;
    }
  }

  private static void b()
  {
    l = Build.VERSION.RELEASE;
    k = Build.VERSION.INCREMENTAL;
    j = Build.VERSION.SDK_INT;
  }

  private static void b(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    b = localDisplayMetrics.heightPixels;
    a = localDisplayMetrics.widthPixels;
    c = b + "*" + a;
    d = localDisplayMetrics.densityDpi;
  }

  private static void c()
  {
    p = Locale.getDefault().getCountry();
    o = Locale.getDefault().getLanguage();
  }

  private static void c(Context paramContext)
  {
    ConfigurationInfo localConfigurationInfo = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
    e = localConfigurationInfo.reqTouchScreen;
    f = localConfigurationInfo.getGlEsVersion();
  }

  private static String d()
  {
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (localEGLDisplay == EGL10.EGL_NO_DISPLAY);
    int[] arrayOfInt;
    EGLConfig[] arrayOfEGLConfig;
    do
    {
      do
        return null;
      while (!localEGL10.eglInitialize(localEGLDisplay, new int[2]));
      arrayOfInt = new int[1];
      arrayOfEGLConfig = new EGLConfig[1];
    }
    while (!localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, arrayOfEGLConfig, 1, arrayOfInt));
    if (arrayOfInt[0] > 0);
    for (EGLConfig localEGLConfig = arrayOfEGLConfig[0]; ; localEGLConfig = null)
    {
      EGLContext localEGLContext = localEGL10.eglCreateContext(localEGLDisplay, localEGLConfig, EGL10.EGL_NO_CONTEXT, null);
      EGLSurface localEGLSurface = localEGL10.eglCreatePbufferSurface(localEGLDisplay, localEGLConfig, new int[] { 12375, 480, 12374, 800, 12344 });
      if ((localEGLSurface == null) || (localEGLSurface == EGL10.EGL_NO_SURFACE))
        break;
      localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, localEGLContext);
      if (!localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, localEGLContext))
        break;
      String str = ((GL10)localEGLContext.getGL()).glGetString(7939);
      localEGL10.eglDestroySurface(localEGLDisplay, localEGLSurface);
      localEGL10.eglDestroyContext(localEGLDisplay, localEGLContext);
      localEGL10.eglTerminate(localEGLDisplay);
      if (str == null)
        break;
      return str.trim();
    }
  }

  private static void d(Context paramContext)
  {
    FeatureInfo[] arrayOfFeatureInfo = paramContext.getPackageManager().getSystemAvailableFeatures();
    while (true)
    {
      int i1;
      int i2;
      synchronized (r)
      {
        g = new ArrayList();
        if (arrayOfFeatureInfo != null)
        {
          i1 = arrayOfFeatureInfo.length;
          i2 = 0;
        }
        else
        {
          Collections.sort(g);
          return;
          FeatureInfo localFeatureInfo = arrayOfFeatureInfo[i2];
          if (!TextUtils.isEmpty(localFeatureInfo.name))
            g.add(localFeatureInfo.name);
          i2++;
        }
      }
      if (i2 < i1);
    }
  }

  private static void e(Context paramContext)
  {
    String[] arrayOfString = paramContext.getPackageManager().getSystemSharedLibraryNames();
    while (true)
    {
      int i1;
      int i2;
      synchronized (r)
      {
        h = new ArrayList();
        if (arrayOfString != null)
        {
          i1 = arrayOfString.length;
          i2 = 0;
        }
        else
        {
          Collections.sort(h);
          return;
          String str = arrayOfString[i2];
          if (!TextUtils.isEmpty(str))
            h.add(str);
          i2++;
        }
      }
      if (i2 < i1);
    }
  }

  private static boolean e()
  {
    return j >= 13;
  }

  private static void f(Context paramContext)
  {
    String str1 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    if (TextUtils.isEmpty(str1));
    for (String str2 = ""; ; str2 = str1)
    {
      m = str2;
      String str3 = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      StringBuffer localStringBuffer = new StringBuffer();
      if (!TextUtils.isEmpty(str2))
        localStringBuffer.append(str2);
      if (!TextUtils.isEmpty(str3))
      {
        localStringBuffer.append("_");
        localStringBuffer.append(str3);
      }
      n = b.a(localStringBuffer.toString());
      return;
    }
  }

  private static boolean f()
  {
    return j >= 11;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.a
 * JD-Core Version:    0.6.2
 */