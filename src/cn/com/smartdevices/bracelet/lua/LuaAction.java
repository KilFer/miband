package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.DaoManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.DeleteQuery;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import de.greenrobot.daobracelet.LuaList;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaListDao.Properties;
import java.util.List;
import org.keplerproject.luajava.LuaState;

public class LuaAction
{
  private static LuaAction __instance = null;
  private Context context = null;

  public LuaAction(Context paramContext)
  {
    this.context = paramContext;
  }

  public static LuaAction getInstance()
  {
    if (__instance == null)
      return null;
    return __instance;
  }

  public static LuaAction getInstance(Context paramContext)
  {
    if (__instance == null)
    {
      LuaAction localLuaAction = new LuaAction(paramContext);
      localLuaAction.context = paramContext;
      __instance = localLuaAction;
    }
    return __instance;
  }

  public void clearDB()
  {
    DaoManager.getInstance().getLuaListDao().deleteAll();
  }

  public void delMsg(WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2)
  {
    QueryBuilder localQueryBuilder = DaoManager.getInstance().getLuaListDao().queryBuilder();
    localQueryBuilder.where(paramWhereCondition1, new WhereCondition[0]);
    if (paramWhereCondition2 != null)
      localQueryBuilder.where(paramWhereCondition2, new WhereCondition[0]);
    localQueryBuilder.buildDelete().executeDeleteWithoutDetachingEntities();
  }

  public void delMsg4(WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition paramWhereCondition3, WhereCondition paramWhereCondition4)
  {
    QueryBuilder localQueryBuilder = DaoManager.getInstance().getLuaListDao().queryBuilder();
    localQueryBuilder.where(paramWhereCondition1, new WhereCondition[0]);
    if (paramWhereCondition2 != null)
      localQueryBuilder.where(paramWhereCondition2, new WhereCondition[0]);
    if (paramWhereCondition3 != null)
      localQueryBuilder.where(paramWhereCondition3, new WhereCondition[0]);
    if (paramWhereCondition4 != null)
      localQueryBuilder.where(paramWhereCondition4, new WhereCondition[0]);
    localQueryBuilder.buildDelete().executeDeleteWithoutDetachingEntities();
  }

  public void doLuaAction(String paramString)
  {
    Debug.i("chenee", "-------------\n" + paramString);
    Debug.i("chenee", "--------------------\n");
    LuaManager localLuaManager = LuaManager.getInstance();
    LuaState localLuaState = LuaManager.getInstance().getLuaState();
    localLuaState.LdoString(paramString);
    localLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "doAction");
    localLuaState.pushJavaObject(this.context);
    localLuaState.pushJavaObject(__instance);
    localLuaManager.callLua(2, 0);
  }

  public ConfigDynamicDataInfo getConfigInfo()
  {
    return ConfigDynamicDataInfo.getInstance();
  }

  public int getCount(WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2)
  {
    QueryBuilder localQueryBuilder = DaoManager.getInstance().getLuaListDao().queryBuilder();
    localQueryBuilder.where(paramWhereCondition1, new WhereCondition[0]);
    if (paramWhereCondition2 != null)
      localQueryBuilder.where(paramWhereCondition2, new WhereCondition[0]);
    return (int)localQueryBuilder.count();
  }

  public int getCount4(WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition paramWhereCondition3, WhereCondition paramWhereCondition4)
  {
    QueryBuilder localQueryBuilder = DaoManager.getInstance().getLuaListDao().queryBuilder();
    localQueryBuilder.where(paramWhereCondition1, new WhereCondition[0]);
    if (paramWhereCondition2 != null)
      localQueryBuilder.where(paramWhereCondition2, new WhereCondition[0]);
    if (paramWhereCondition3 != null)
      localQueryBuilder.where(paramWhereCondition3, new WhereCondition[0]);
    if (paramWhereCondition3 != null)
      localQueryBuilder.where(paramWhereCondition3, new WhereCondition[0]);
    return (int)localQueryBuilder.count();
  }

  public LuaListDao getDao()
  {
    return DaoManager.getInstance().getLuaListDao();
  }

  public Intent getIntentFromString(String paramString)
  {
    Debug.i("chenee", "luaAction,classname is: " + paramString);
    Object localObject = null;
    if (paramString != null);
    try
    {
      Class localClass = Class.forName(paramString);
      localObject = localClass;
      return new Intent(this.context, localObject);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      Debug.i("chenee", localClassNotFoundException.getMessage());
    }
    return null;
  }

  public Boolean getIsBind()
  {
    return Boolean.valueOf(Utils.isBinded());
  }

  public void putExtra(Intent paramIntent, String paramString, Object paramObject)
  {
    if ((paramObject instanceof String))
      paramIntent.putExtra(paramString, (String)paramObject);
    do
    {
      return;
      if ((paramObject instanceof Byte))
      {
        paramIntent.putExtra(paramString, (Byte)paramObject);
        return;
      }
    }
    while (!(paramObject instanceof Integer));
    paramIntent.putExtra(paramString, ((Integer)paramObject).intValue());
  }

  public int queryCount(QueryBuilder<LuaList> paramQueryBuilder)
  {
    return (int)paramQueryBuilder.count();
  }

  public void queryDel(QueryBuilder<LuaList> paramQueryBuilder)
  {
    paramQueryBuilder.buildDelete().executeDeleteWithoutDetachingEntities();
  }

  public LuaList queryLastItem(QueryBuilder<LuaList> paramQueryBuilder)
  {
    Property[] arrayOfProperty = new Property[1];
    arrayOfProperty[0] = LuaListDao.Properties.Id;
    paramQueryBuilder.orderDesc(arrayOfProperty);
    List localList = paramQueryBuilder.list();
    if (localList.size() > 0)
      return (LuaList)localList.get(0);
    return null;
  }

  public void queryWhere(QueryBuilder<LuaList> paramQueryBuilder, WhereCondition paramWhereCondition)
  {
    paramQueryBuilder.where(paramWhereCondition, new WhereCondition[0]);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.LuaAction
 * JD-Core Version:    0.6.2
 */