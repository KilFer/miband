package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import cn.com.smartdevices.bracelet.DaoManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.LazyList;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import de.greenrobot.daobracelet.LuaZipFile;
import de.greenrobot.daobracelet.LuaZipFileDao;
import de.greenrobot.daobracelet.LuaZipFileDao.Properties;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

public class LuaManager
{
  private static LuaManager __instance = null;
  private Context context = null;
  private LuaState mLuaState = null;

  private String getDBLuaFileByVersion(String paramString)
  {
    LuaZipFileDao localLuaZipFileDao = DaoManager.getInstance().getLuaZipFileDao();
    int i = (int)localLuaZipFileDao.count();
    Debug.i("chenee", "lzipDao.count:" + i);
    if (i > 0)
    {
      QueryBuilder localQueryBuilder = localLuaZipFileDao.queryBuilder();
      Property[] arrayOfProperty = new Property[1];
      arrayOfProperty[0] = LuaZipFileDao.Properties.Version;
      localQueryBuilder.orderDesc(arrayOfProperty);
      localQueryBuilder.where(LuaZipFileDao.Properties.Version.eq(paramString), new WhereCondition[0]);
      LuaZipFile localLuaZipFile = (LuaZipFile)localQueryBuilder.listLazy().get(0);
      String str = localLuaZipFile.getVersion();
      Debug.i("chenee", "luaZipFile.version:" + str);
      return unzip(localLuaZipFile.getZipFile());
    }
    Debug.e("chenee", "read DB zip failed,version:" + paramString);
    return null;
  }

  private String getDefaultLuaFileVersion()
  {
    InputStream localInputStream = this.context.getResources().openRawResource(2131099652);
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
    try
    {
      String str1;
      do
      {
        str1 = localBufferedReader.readLine();
        if (str1 == null)
        {
          localInputStream.close();
          return null;
        }
      }
      while (!str1.trim().startsWith("__luaVersion="));
      String str2 = str1.substring(13);
      localInputStream.close();
      String str3 = str2.trim();
      return str3;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      Debug.e("chenee", "read res/raw/luafile.lua version error!!");
    }
    return null;
  }

  public static LuaManager getInstance()
  {
    if (__instance == null)
      return null;
    return __instance;
  }

  public static LuaManager getInstance(Context paramContext)
  {
    if (__instance == null)
    {
      LuaManager localLuaManager = new LuaManager();
      localLuaManager.context = paramContext;
      localLuaManager.getLatestLuaZipFileWithVersionCheck();
      localLuaManager.resetLuaState();
      __instance = localLuaManager;
    }
    return __instance;
  }

  private String getLatestDBLuaFile()
  {
    LuaZipFileDao localLuaZipFileDao = DaoManager.getInstance().getLuaZipFileDao();
    int i = (int)localLuaZipFileDao.count();
    Debug.i("chenee", "lzipDao.count:" + i);
    if (i > 0)
    {
      QueryBuilder localQueryBuilder = localLuaZipFileDao.queryBuilder();
      Property[] arrayOfProperty = new Property[1];
      arrayOfProperty[0] = LuaZipFileDao.Properties.Version;
      localQueryBuilder.orderDesc(arrayOfProperty);
      LuaZipFile localLuaZipFile = (LuaZipFile)localQueryBuilder.listLazy().get(0);
      String str1 = localLuaZipFile.getVersion();
      String str2 = getDefaultLuaFileVersion();
      if (str1.compareTo(str2) <= 0)
      {
        Debug.e("chenee", "version compare failed: version:" + str1 + " default version is:" + str2);
        return null;
      }
      Debug.i("chenee", "use latest script, version:" + str1 + " (default version is:" + str2 + ")");
      return unzip(localLuaZipFile.getZipFile());
    }
    Debug.e("chenee", "read DB zip file failed");
    return null;
  }

  private void getLatestLuaZipFile()
  {
    WebAPI.getLuaScript(Keeper.readLoginData(), new i(this));
  }

  private void getLatestLuaZipFileWithVersionCheck()
  {
    WebAPI.getLuaScriptVersion(Keeper.readLoginData(), new h(this));
  }

  private String getSDCardLuaFile(String paramString)
  {
    String str1 = Environment.getExternalStorageDirectory().getPath() + paramString;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(str1);
      byte[] arrayOfByte = new byte[localFileInputStream.available()];
      localFileInputStream.read(arrayOfByte);
      localFileInputStream.close();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localByteArrayOutputStream.write(arrayOfByte);
      String str2 = localByteArrayOutputStream.toString();
      return str2;
    }
    catch (Exception localException)
    {
      Debug.e("chenee", "read failed: " + str1);
    }
    return null;
  }

  private String getSDCardZipLuaFile()
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(Environment.getExternalStorageDirectory().getPath() + "/cheneeispig_hm.zip");
      byte[] arrayOfByte = new byte[localFileInputStream.available()];
      localFileInputStream.read(arrayOfByte);
      localFileInputStream.close();
      String str = unzip(arrayOfByte);
      return str;
    }
    catch (Exception localException)
    {
      Debug.e("chenee", "read sdcard/strangeName.zip failed");
    }
    return null;
  }

  private void initLocalizationLua()
  {
    String str1 = getSDCardLuaFile("/localization_chinese.lua");
    String str2 = getSDCardLuaFile("/localization_english.lua");
    String str3 = getSDCardLuaFile("/localization_traditional_chinese.lua");
    String str4 = getSDCardLuaFile("/localization.lua");
    if ((str4 != null) && (str1 != null) && (str2 != null))
    {
      this.mLuaState.LdoString(str1);
      this.mLuaState.LdoString(str2);
      this.mLuaState.LdoString(str3);
      this.mLuaState.LdoString(str4);
    }
    while (true)
    {
      return;
      for (int k : new int[] { 2131099649, 2131099650, 2131099651, 2131099648 })
      {
        String str5 = readStream(this.context.getResources().openRawResource(k));
        this.mLuaState.LdoString(str5);
      }
    }
  }

  private void loadScriptFile()
  {
    String str = getSDCardZipLuaFile();
    if (str == null)
      str = getLatestDBLuaFile();
    initLocalizationLua();
    if (str == null)
      str = readStream(this.context.getResources().openRawResource(2131099652));
    this.mLuaState.LdoString(str);
    luaSendVersion();
  }

  private void luaSendVersion()
  {
    ConfigDynamicDataInfo localConfigDynamicDataInfo = ConfigDynamicDataInfo.getInstance();
    String str = Keeper.readApkVersion();
    this.mLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "setVersion");
    this.mLuaState.pushJavaObject(localConfigDynamicDataInfo);
    this.mLuaState.pushString(str);
    callLua(2, 0);
  }

  private String readStream(InputStream paramInputStream)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      int j;
      for (int i = paramInputStream.read(); ; i = j)
      {
        if (i == -1)
          return localByteArrayOutputStream.toString();
        localByteArrayOutputStream.write(i);
        j = paramInputStream.read();
      }
    }
    catch (IOException localIOException)
    {
      Debug.e("chenee", "read res/raw/luafile.lua failed");
    }
    return "";
  }

  public void callLua(int paramInt1, int paramInt2)
  {
    int i = this.mLuaState.pcall(paramInt1, paramInt2, 0);
    if (i != 0)
    {
      String str = this.mLuaState.toString(-1);
      Debug.e("chenee", "LuaERROR:(" + i + ") " + str);
    }
  }

  public LuaState getLuaState()
  {
    return this.mLuaState;
  }

  public void resetLuaState()
  {
    if (this.mLuaState != null)
      this.mLuaState.close();
    this.mLuaState = LuaStateFactory.newLuaState();
    this.mLuaState.openLibs();
    loadScriptFile();
  }

  public String unzip(byte[] paramArrayOfByte)
  {
    try
    {
      ZipInputStream localZipInputStream = new ZipInputStream(new ByteArrayInputStream(paramArrayOfByte));
      str = null;
      try
      {
        ZipEntry localZipEntry = localZipInputStream.getNextEntry();
        if (localZipEntry != null);
      }
      catch (IOException localIOException)
      {
        ByteArrayOutputStream localByteArrayOutputStream;
        int i;
        int j;
        Debug.e("chenee", localException1.getMessage());
        return str;
      }
      finally
      {
        localZipInputStream.close();
      }
    }
    catch (Exception localException2)
    {
      while (true)
      {
        Object localObject2 = localException2;
        String str = null;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.LuaManager
 * JD-Core Version:    0.6.2
 */