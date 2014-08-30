package cn.com.smartdevices.bracelet.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.ui.ShareActivity;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShareListDelegateActivity extends Activity
{
  private static final String REF_REPORT_DATA = "REF_REPORT_DATA";
  public static final String SHARE_TYPE_CONTIUE_REACH_GOAL = "SHARE_TYPE_CONTIUE_REACH_GOAL";
  public static final String SHARE_TYPE_LAST_MONTH = "SHARE_TYPE_LAST_MONTH";
  public static final String SHARE_TYPE_LAST_WEEK = "SHARE_TYPE_LAST_WEEK";
  public static final String SHARE_TYPE_NEW_RECORD = "SHARE_TYPE_NEW_RECORD";
  private static final String TAG = "ShareListDelegateActivity";
  private int mNewRecordSteps;
  private ReportData mReportData;
  private String mShareType;

  private SportDay getSportDayFromDateStr(String paramString)
  {
    String[] arrayOfString = paramString.split("-");
    try
    {
      int i = Integer.valueOf(arrayOfString[0]).intValue();
      int j = Integer.valueOf(arrayOfString[1]).intValue();
      int k = Integer.valueOf(arrayOfString[2]).intValue();
      SportDay localSportDay = new SportDay(i, j - 1, k);
      return localSportDay;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent1 = getIntent();
    String str1 = "";
    SportDay localSportDay2;
    SportDay localSportDay3;
    SportDay localSportDay1;
    Object localObject;
    if (localIntent1 != null)
    {
      String str2 = localIntent1.getStringExtra("REF_REPORT_DATA");
      if (str2 != null)
      {
        this.mReportData = ReportData.fromJsonStr(str2);
        if (this.mReportData == null)
          finish();
      }
      else
      {
        Debug.i("ShareListDelegateActivity", "intent of mReportData is null");
        finish();
        return;
      }
      Debug.i("ShareListDelegateActivity", "mReportData = " + this.mReportData.type);
      this.mShareType = this.mReportData.type;
      if (("SHARE_TYPE_LAST_WEEK".equals(this.mShareType)) || ("SHARE_TYPE_LAST_MONTH".equals(this.mShareType)))
      {
        localSportDay2 = getSportDayFromDateStr(this.mReportData.timeFrom);
        localSportDay3 = getSportDayFromDateStr(this.mReportData.timeTo);
        SportDay localSportDay4 = getSportDayFromDateStr(this.mReportData.maxDateStr);
        str1 = "";
        if (localSportDay4 == null)
          break label966;
        str1 = localSportDay4.formatStringDay(this);
        localSportDay1 = localSportDay3;
        localObject = localSportDay2;
      }
    }
    while (true)
    {
      ShareData localShareData = new ShareData();
      int i;
      if ("SHARE_TYPE_LAST_MONTH".equals(this.mShareType))
      {
        Date localDate = new Date();
        localDate.setMonth(((SportDay)localObject).mon);
        localShareData.title = (new SimpleDateFormat("MMMM, ").format(localDate) + getString(2131493242));
        localShareData.setType(6);
        localShareData.description = Utils.getMonthShareTips(this, this.mReportData.steps, this.mReportData.distance, this.mReportData.calories, str1, this.mReportData.maxDateStep);
        i = this.mReportData.steps;
        localShareData.contentUnit = getString(2131492927);
        localShareData.time = (((SportDay)localObject).formatStringDayShort() + "-" + localSportDay1.formatStringDayShort());
      }
      while (true)
      {
        localShareData.content = i;
        Intent localIntent2 = new Intent();
        localIntent2.setClass(this, ShareActivity.class);
        localIntent2.putExtra("share_data", localShareData);
        startActivity(localIntent2);
        finish();
        return;
        if ("SHARE_TYPE_NEW_RECORD".equals(this.mShareType))
        {
          this.mNewRecordSteps = this.mReportData.getSteps();
          localSportDay1 = null;
          localObject = null;
          break;
        }
        if (!"SHARE_TYPE_CONTIUE_REACH_GOAL".equals(this.mShareType))
          break label957;
        SportDay localSportDay5 = getSportDayFromDateStr(this.mReportData.timeFrom);
        localSportDay1 = getSportDayFromDateStr(this.mReportData.timeTo);
        localObject = localSportDay5;
        break;
        if ("SHARE_TYPE_LAST_WEEK".equals(this.mShareType))
        {
          localShareData.title = (getString(2131493243) + getString(2131493242));
          localShareData.setType(7);
          localShareData.description = Utils.getWeekShareTips(this, this.mReportData.distance, this.mReportData.calories, str1, this.mReportData.maxDateStep);
          i = this.mReportData.steps;
          localShareData.contentUnit = getString(2131492927);
          localShareData.time = (((SportDay)localObject).formatStringDayShort() + "-" + localSportDay1.formatStringDayShort());
        }
        else if ("SHARE_TYPE_NEW_RECORD".equals(this.mShareType))
        {
          localShareData.setType(5);
          localShareData.title = getString(2131493261);
          i = this.mNewRecordSteps;
          localShareData.contentUnit = getString(2131492927);
          localShareData.time = new SportDay().formatString();
          String[] arrayOfString = ChartData.formatDistance(this, this.mReportData.getDistance());
          localShareData.description = getString(2131493262, new Object[] { arrayOfString[0] + arrayOfString[1], this.mReportData.getCalories() });
        }
        else if ("SHARE_TYPE_CONTIUE_REACH_GOAL".equals(this.mShareType))
        {
          localShareData.setType(8);
          localShareData.title = getString(2131493263);
          i = this.mReportData.continueDays;
          localShareData.contentUnit = getString(2131493079);
          localShareData.time = (((SportDay)localObject).formatStringDayShort() + "-" + localSportDay1.formatStringDayShort());
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(this.mReportData.maxContinueDays);
          localShareData.time_tips = getString(2131493264, arrayOfObject);
          localShareData.description = Utils.getContinueReachGoalShareTips(this, this.mReportData.getSteps(), this.mReportData.getDistance(), this.mReportData.getCalories(), this.mReportData.getContinueDays());
        }
        else
        {
          i = 0;
        }
      }
      label957: localSportDay1 = null;
      localObject = null;
      continue;
      label966: localSportDay1 = localSportDay3;
      localObject = localSportDay2;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.ShareListDelegateActivity
 * JD-Core Version:    0.6.2
 */