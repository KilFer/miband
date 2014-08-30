package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import cn.com.smartdevices.bracelet.DaoManager;
import de.greenrobot.daobracelet.LuaListDao;
import org.keplerproject.luajava.LuaState;

public class LuaEventMsgs
{
  private static LuaEventMsgs __instance = null;
  private Context context = null;
  private LuaListDao listDao = DaoManager.getInstance().getLuaListDao();

  public static LuaEventMsgs getInstance(Context paramContext)
  {
    if (__instance == null)
    {
      LuaEventMsgs localLuaEventMsgs = new LuaEventMsgs();
      localLuaEventMsgs.context = paramContext;
      LuaManager.getInstance(paramContext);
      __instance = localLuaEventMsgs;
    }
    return __instance;
  }

  public void luaEventAchievementMsg(ConfigDynamicDataInfo paramConfigDynamicDataInfo)
  {
    LuaManager localLuaManager = LuaManager.getInstance();
    LuaState localLuaState = localLuaManager.getLuaState();
    localLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getAchievementMsgs");
    localLuaState.pushJavaObject(this.listDao);
    localLuaState.pushJavaObject(paramConfigDynamicDataInfo);
    localLuaManager.callLua(2, 0);
  }

  public void luaEventActivityMsg(ConfigDynamicDataInfo paramConfigDynamicDataInfo)
  {
    LuaManager localLuaManager = LuaManager.getInstance();
    LuaState localLuaState = localLuaManager.getLuaState();
    localLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getActivityMsgs");
    localLuaState.pushJavaObject(this.listDao);
    localLuaState.pushJavaObject(paramConfigDynamicDataInfo);
    localLuaManager.callLua(2, 0);
  }

  public void luaEventDefaultMsg(ConfigDynamicDataInfo paramConfigDynamicDataInfo)
  {
    LuaManager localLuaManager = LuaManager.getInstance();
    LuaState localLuaState = localLuaManager.getLuaState();
    localLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getDefaultMsgs");
    localLuaState.pushJavaObject(this.listDao);
    localLuaState.pushJavaObject(paramConfigDynamicDataInfo);
    localLuaManager.callLua(2, 0);
  }

  public void luaEventSleepMsg(ConfigDynamicDataInfo paramConfigDynamicDataInfo)
  {
    LuaManager localLuaManager = LuaManager.getInstance();
    LuaState localLuaState = localLuaManager.getLuaState();
    localLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getSleepMsgs");
    localLuaState.pushJavaObject(this.listDao);
    localLuaState.pushJavaObject(paramConfigDynamicDataInfo);
    localLuaManager.callLua(2, 0);
  }

  public void luaEventSysInfoMsg(ConfigDynamicDataInfo paramConfigDynamicDataInfo)
  {
    LuaManager localLuaManager = LuaManager.getInstance();
    LuaState localLuaState = localLuaManager.getLuaState();
    localLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getSysInfoMsgs");
    localLuaState.pushJavaObject(this.listDao);
    localLuaState.pushJavaObject(paramConfigDynamicDataInfo);
    localLuaManager.callLua(2, 0);
  }

  public void testLuaImp(int paramInt, ConfigDynamicDataInfo paramConfigDynamicDataInfo)
  {
    LuaManager localLuaManager = LuaManager.getInstance();
    LuaState localLuaState = localLuaManager.getLuaState();
    localLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getEventMsgs");
    localLuaState.pushJavaObject(this.listDao);
    localLuaState.pushJavaObject(paramConfigDynamicDataInfo);
    localLuaState.pushInteger(paramInt);
    localLuaManager.callLua(3, 0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.LuaEventMsgs
 * JD-Core Version:    0.6.2
 */