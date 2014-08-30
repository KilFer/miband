package com.xiaomi.hm.bleservice.profile;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public final class IMiLiProfile$ActivityDataFragment
{
  public final List<IMiLiProfile.ActivityData> data;
  public final Calendar timestamp;

  public IMiLiProfile$ActivityDataFragment(Calendar paramCalendar, List<IMiLiProfile.ActivityData> paramList)
  {
    this.timestamp = paramCalendar;
    this.data = paramList;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("[[[ " + getClass().getSimpleName() + " ]]]");
    localStringBuilder.append("\n    timestamp: " + DateFormat.getDateTimeInstance().format(this.timestamp.getTime()));
    localStringBuilder.append("\n  data.size(): " + this.data.size());
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityDataFragment
 * JD-Core Version:    0.6.2
 */