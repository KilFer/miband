package com.xiaomi.hm.bleservice.util;

import android.util.Log;

public final class Debug
{
  private static boolean a = false;
  private static final boolean b = true;
  private static final boolean c = true;
  private static final boolean d = true;
  private static final boolean e = true;
  private static final boolean f = true;
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  private static final boolean j = true;
  private static final boolean k = false;
  private static final String l = "DEBUG";

  public static void ASSERT_NOT_NULL(Object paramObject)
  {
    if ((h) && (paramObject == null))
      a("DEBUG", ">>> `NOT NULL` ASSERTION FAILED <<<", 0, 'e');
  }

  public static void ASSERT_NULL(Object paramObject)
  {
    if ((h) && (paramObject != null))
      a("DEBUG", ">>> `NULL` ASSERTION FAILED <<<", 0, 'e');
  }

  public static void ASSERT_RUN_ON_THREAD(Thread paramThread)
  {
    if ((h) && (paramThread != null) && (Thread.currentThread().getId() != paramThread.getId()))
      a("DEBUG", ">>> `RUN ON THREAD` ASSERTION FAILED <<<", 0, 'e');
  }

  public static void ASSERT_TRUE(boolean paramBoolean)
  {
    if ((h) && (!paramBoolean))
      a("DEBUG", ">>> `TRUE` ASSERTION FAILED <<<", 0, 'e');
  }

  public static void DEBUG(String paramString)
  {
    a("DEBUG", paramString, 0, 'd');
  }

  public static void DEBUG_LOCK(String paramString)
  {
    if (i)
      a("DEBUG", "LOCK#" + paramString, 0, 'v');
  }

  public static void ENABLE(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a = true;
    g = paramBoolean1;
    h = paramBoolean2;
    i = paramBoolean3;
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MM.:  .:'   `:::  .:`MMMMMMMMMMM|`MMM'|MMMMMMMMMMM':  .:'   `:::  .:'.MM");
    INFO("MMMM.     :          `MMMMMMMMMM  :*'  MMMMMMMMMM'        :        .MMMM");
    INFO("MMMMM.    ::    .     `MMMMMMMM'  ::   `MMMMMMMM'   .     ::   .  .MMMMM");
    INFO("MMMMMM. :   :: ::'  :   :: ::'  :   :: ::'      :: ::'  :   :: ::.MMMMMM");
    INFO("MMMMMMM    ;::         ;::         ;::         ;::         ;::   MMMMMMM");
    INFO("MMMMMMM .:'   `:::  .:'   `:::  .:'   `:::  .:'   `:::  .:'   `::MMMMMMM");
    INFO("MMMMMM'     :           :           :           :           :    `MMMMMM");
    INFO("MMMMM'______::____      ::    .     ::    .     ::     ___._::____`MMMMM");
    INFO("MMMMMMMMMMMMMMMMMMM`---._ :: ::'  :   :: ::'  _.--::MMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMM::.         ::  .--MMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM-.     ;::-MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM. .:' .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM.   .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\\ /MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMVMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM .:ZylvanaS:. MM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("         ENABLE_VERBOSE: TRUE");
    INFO("           ENABLE_DEBUG: TRUE");
    INFO("            ENABLE_INFO: TRUE");
    INFO("            ENABLE_WARN: TRUE");
    INFO("           ENABLE_ERROR: TRUE");
    StringBuilder localStringBuilder1 = new StringBuilder("           ENABLE_TRACE: ");
    String str1;
    String str2;
    label194: StringBuilder localStringBuilder3;
    if (g)
    {
      str1 = "TRUE";
      INFO(str1);
      StringBuilder localStringBuilder2 = new StringBuilder("          ENABLE_ASSERT: ");
      if (!h)
        break label259;
      str2 = "TRUE";
      INFO(str2);
      localStringBuilder3 = new StringBuilder("      ENABLE_DEBUG_LOCK: ");
      if (!i)
        break label266;
    }
    label259: label266: for (String str3 = "TRUE"; ; str3 = "FALSE")
    {
      INFO(str3);
      INFO("        ENABLE_LOG_META: TRUE");
      INFO("  ENABLE_LOG_TRACE_INFO: FALSE");
      return;
      str1 = "FALSE";
      break;
      str2 = "FALSE";
      break label194;
    }
  }

  public static void ERROR(String paramString)
  {
    a("DEBUG", paramString, 0, 'e');
  }

  public static void INFO(String paramString)
  {
    a("DEBUG", paramString, 0, 'i');
  }

  public static void TRACE()
  {
    if (g)
      a("DEBUG", "<<<<====", 0, 'v');
  }

  public static void VERBOSE(String paramString)
  {
    a("DEBUG", paramString, 0, 'v');
  }

  public static void WARN(String paramString)
  {
    a("DEBUG", paramString, 0, 'w');
  }

  private static void a()
  {
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MM.:  .:'   `:::  .:`MMMMMMMMMMM|`MMM'|MMMMMMMMMMM':  .:'   `:::  .:'.MM");
    INFO("MMMM.     :          `MMMMMMMMMM  :*'  MMMMMMMMMM'        :        .MMMM");
    INFO("MMMMM.    ::    .     `MMMMMMMM'  ::   `MMMMMMMM'   .     ::   .  .MMMMM");
    INFO("MMMMMM. :   :: ::'  :   :: ::'  :   :: ::'      :: ::'  :   :: ::.MMMMMM");
    INFO("MMMMMMM    ;::         ;::         ;::         ;::         ;::   MMMMMMM");
    INFO("MMMMMMM .:'   `:::  .:'   `:::  .:'   `:::  .:'   `:::  .:'   `::MMMMMMM");
    INFO("MMMMMM'     :           :           :           :           :    `MMMMMM");
    INFO("MMMMM'______::____      ::    .     ::    .     ::     ___._::____`MMMMM");
    INFO("MMMMMMMMMMMMMMMMMMM`---._ :: ::'  :   :: ::'  _.--::MMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMM::.         ::  .--MMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM-.     ;::-MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM. .:' .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM.   .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\\ /MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMVMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM .:ZylvanaS:. MM");
    INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
  }

  private static void a(String paramString1, String paramString2, int paramInt, char paramChar)
  {
    if (!a)
      return;
    String str1 = Thread.currentThread().getName();
    StackTraceElement localStackTraceElement = Thread.currentThread().getStackTrace()[4];
    String str2 = localStackTraceElement.getClassName();
    String str3 = str2.substring(1 + str2.lastIndexOf('.'));
    String str4 = localStackTraceElement.getMethodName();
    int m = localStackTraceElement.getLineNumber();
    String str5 = "[" + str1 + "]<" + str3 + ":" + str4 + ":" + m + "> ";
    switch (paramChar)
    {
    default:
      return;
    case 'd':
      Log.d(paramString1, str5 + paramString2 + "");
      return;
    case 'v':
      Log.v(paramString1, str5 + paramString2 + "");
      return;
    case 'i':
      Log.i(paramString1, str5 + paramString2 + "");
      return;
    case 'w':
      Log.w(paramString1, str5 + paramString2 + "");
      return;
    case 'e':
    }
    Log.e(paramString1, str5 + paramString2 + "");
  }

  public static void enable(boolean paramBoolean)
  {
    a = paramBoolean;
    g = paramBoolean;
    h = paramBoolean;
    i = paramBoolean;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.util.Debug
 * JD-Core Version:    0.6.2
 */