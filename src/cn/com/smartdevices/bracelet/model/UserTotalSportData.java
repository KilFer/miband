package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Utils;
import com.google.gson.Gson;

public class UserTotalSportData
{
  public String averageSteps = "";
  public String calories = "";
  public String distance = "";
  public int iAverageSteps = 0;
  public int iCalories = 0;
  public int iDistance = 0;
  public int iPoints = 0;
  public int iSteps = 0;
  public int iTotalwearingdays = 0;
  public String points = "";
  public String steps = "";
  public String totalwearingdays = "";

  public static UserTotalSportData fromJsonStr(String paramString)
  {
    UserTotalSportData localUserTotalSportData = (UserTotalSportData)Utils.getGson().fromJson(paramString, UserTotalSportData.class);
    if (localUserTotalSportData == null)
      localUserTotalSportData = new UserTotalSportData();
    return localUserTotalSportData;
  }

  public boolean isValid()
  {
    return (!"".equals(this.averageSteps)) && (!"".equals(this.distance)) && (!"".equals(this.totalwearingdays));
  }

  public String toString()
  {
    String str = Utils.getGson().toJson(this);
    if (str == null)
      return null;
    return str.toString();
  }

  public void translate()
  {
    this.distance = this.iDistance;
    this.averageSteps = this.iAverageSteps;
    this.totalwearingdays = this.iTotalwearingdays;
    this.calories = this.iCalories;
    this.steps = this.iSteps;
    this.points = this.iPoints;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.UserTotalSportData
 * JD-Core Version:    0.6.2
 */