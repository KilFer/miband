package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DaySportData
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private ArrayList<SportData> analysisDatas = null;
  private ArrayList<SportData> datas = null;
  private ArrayList<SportIndex> indexs = new ArrayList();
  private SleepInfo mSleepInfo = null;
  private StepsInfo mStepsInfo = null;
  private boolean needPostProcess = true;
  private boolean needSyncToLocal = false;
  private boolean needSyncToServer = false;
  private ArrayList<IMiLiProfile.ActivityData> originDatas = null;
  private SportDay sDay = null;

  public DaySportData(int paramInt1, int paramInt2, int paramInt3)
  {
    this(new SportDay(paramInt1, paramInt2, paramInt3));
  }

  public DaySportData(SportDay paramSportDay)
  {
    this.sDay = paramSportDay;
    this.datas = new ArrayList(DataManager.INIT_INDEX_LIST);
    this.originDatas = new ArrayList(DataManager.INIT_ORIGIN_LIST);
  }

  public DaySportData(Calendar paramCalendar)
  {
    this(new SportDay(paramCalendar));
  }

  private void handleIndex(int paramInt, IMiLiProfile.ActivityData paramActivityData)
  {
    if (paramActivityData.category == 126)
      return;
    if (this.indexs.size() == 0)
    {
      this.indexs.add(new SportIndex(paramInt, paramInt));
      return;
    }
    SportIndex localSportIndex1 = (SportIndex)this.indexs.get(-1 + this.indexs.size());
    if (1 + localSportIndex1.stopIndex == paramInt)
    {
      localSportIndex1.stopIndex = paramInt;
      return;
    }
    SportIndex localSportIndex2 = new SportIndex(paramInt, paramInt);
    this.indexs.add(localSportIndex2);
  }

  public static DaySportData sFromBinaryData(SportDay paramSportDay, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    DaySportData localDaySportData = new DaySportData(paramSportDay);
    for (int j = 0; ; j += 3)
    {
      if (j >= i)
        return localDaySportData;
      IMiLiProfile.ActivityData localActivityData = new IMiLiProfile.ActivityData(paramArrayOfByte[(j + 1)], paramArrayOfByte[(j + 2)], paramArrayOfByte[j]);
      localDaySportData.add(j / 3, localActivityData);
    }
  }

  public void add(int paramInt, IMiLiProfile.ActivityData paramActivityData)
  {
    if (((SportData)this.datas.get(paramInt)).getSportMode() != 126)
      return;
    SportData localSportData = new SportData(paramInt, 0xFF & paramActivityData.category, 0xFF & paramActivityData.intensity, 0xFF & paramActivityData.steps);
    this.datas.set(paramInt, localSportData);
    this.originDatas.set(paramInt, paramActivityData);
    handleIndex(paramInt, paramActivityData);
  }

  public ArrayList<SportData> data()
  {
    return this.datas;
  }

  public void fromBinaryData(SportDay paramSportDay, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    for (int j = 0; ; j += 3)
    {
      if (j >= i)
        return;
      IMiLiProfile.ActivityData localActivityData = new IMiLiProfile.ActivityData(paramArrayOfByte[(j + 1)], paramArrayOfByte[(j + 2)], paramArrayOfByte[j]);
      add(j / 3, localActivityData);
    }
  }

  public ArrayList<SportData> getAnalysisData()
  {
    return this.analysisDatas;
  }

  public byte[] getBinaryData()
  {
    ArrayList localArrayList = this.originDatas;
    byte[] arrayOfByte = new byte[3 * localArrayList.size()];
    for (int i = 0; ; i++)
    {
      if (i >= localArrayList.size())
        return arrayOfByte;
      IMiLiProfile.ActivityData localActivityData = (IMiLiProfile.ActivityData)localArrayList.get(i);
      arrayOfByte[(i * 3)] = ((byte)localActivityData.category);
      arrayOfByte[(1 + i * 3)] = ((byte)localActivityData.intensity);
      arrayOfByte[(2 + i * 3)] = ((byte)localActivityData.steps);
    }
  }

  public int getDay()
  {
    return this.sDay.day;
  }

  public String getIndexS()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.indexs.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localJSONArray.toString();
      localJSONArray.put(((SportIndex)localIterator.next()).toJSONObject());
    }
  }

  public String getKey()
  {
    return this.sDay.getKey();
  }

  public int getMonth()
  {
    return this.sDay.mon;
  }

  public ArrayList<IMiLiProfile.ActivityData> getOriginData()
  {
    return this.originDatas;
  }

  public SleepInfo getSleepInfo()
  {
    return this.mSleepInfo;
  }

  public SportDay getSportDay()
  {
    return this.sDay;
  }

  public StepsInfo getStepsInfo()
  {
    return this.mStepsInfo;
  }

  public String getSummary()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("v", 3);
      if (this.mSleepInfo != null)
        localJSONObject.put(SleepInfo.KEY_SLEEP_INFO, this.mSleepInfo.getSummaryJson());
      if (this.mStepsInfo != null)
        localJSONObject.put(StepsInfo.KEY_STEP_INFO, this.mStepsInfo.getSummaryJson());
      localJSONObject.put("goal", Keeper.readPersonInfo().getDaySportGoalSteps());
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  public int getYear()
  {
    return this.sDay.year;
  }

  public boolean isLocalNeedSync()
  {
    return this.needSyncToLocal;
  }

  public boolean isNeedPostProcess()
  {
    return this.needPostProcess;
  }

  public void merge(DaySportData paramDaySportData)
  {
    ArrayList localArrayList = paramDaySportData.getOriginData();
    int i = localArrayList.size();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return;
      IMiLiProfile.ActivityData localActivityData = (IMiLiProfile.ActivityData)localArrayList.get(j);
      if ((localActivityData.category != 126) && (localActivityData.category != 127))
        add(j, localActivityData);
    }
  }

  public void setAnalysisData(ArrayList<SportData> paramArrayList)
  {
    this.analysisDatas = paramArrayList;
  }

  public void setLocalNeedSync(boolean paramBoolean)
  {
    this.needSyncToLocal = paramBoolean;
  }

  public void setNeedPostProcess(boolean paramBoolean)
  {
    this.needPostProcess = paramBoolean;
  }

  public void setNeedSync(boolean paramBoolean)
  {
    this.needSyncToLocal = paramBoolean;
    this.needSyncToServer = paramBoolean;
  }

  public void setSleepInfo(SleepInfo paramSleepInfo)
  {
    this.mSleepInfo = paramSleepInfo;
  }

  public void setStepsInfo(StepsInfo paramStepsInfo)
  {
    this.mStepsInfo = paramStepsInfo;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.DaySportData
 * JD-Core Version:    0.6.2
 */