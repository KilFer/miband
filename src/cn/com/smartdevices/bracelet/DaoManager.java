package cn.com.smartdevices.bracelet;

import android.content.Context;
import de.greenrobot.daobracelet.DaoMaster;
import de.greenrobot.daobracelet.DaoMaster.DevOpenHelper;
import de.greenrobot.daobracelet.DaoSession;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaZipFileDao;

public class DaoManager
{
  private static DaoManager a = null;
  private static Context b = null;
  private DaoSession c = null;

  private DaoManager(Context paramContext)
  {
    this.c = new DaoMaster(new DaoMaster.DevOpenHelper(paramContext, "user-db", null).getWritableDatabase()).newSession();
  }

  public static DaoManager getInstance()
  {
    if (a == null)
      a = new DaoManager(b);
    return a;
  }

  public static void init(Context paramContext)
  {
    b = paramContext;
  }

  public LuaListDao getLuaListDao()
  {
    return this.c.getLuaListDao();
  }

  public LuaZipFileDao getLuaZipFileDao()
  {
    return this.c.getLuaZipFileDao();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.DaoManager
 * JD-Core Version:    0.6.2
 */