package com.xiaomi.hm.bleservice.profile;

import java.text.DateFormat;
import java.util.Calendar;

public final class IMiLiProfile$BatteryInfo
{
  public int charges;
  public final Calendar lastCharge;
  public final int level;
  public final int status;

  public IMiLiProfile$BatteryInfo(int paramInt1, Calendar paramCalendar, int paramInt2, int paramInt3)
  {
    this.level = paramInt1;
    this.lastCharge = paramCalendar;
    this.charges = paramInt2;
    this.status = paramInt3;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("[[[ " + getClass().getSimpleName() + " ]]]");
    localStringBuilder.append("\n       level: " + this.level + "%");
    localStringBuilder.append("\n  lastCharge: " + DateFormat.getDateTimeInstance().format(this.lastCharge.getTime()));
    localStringBuilder.append("\n     charges: " + this.charges);
    localStringBuilder.append("\n      status: " + Integer.toHexString(this.status));
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo
 * JD-Core Version:    0.6.2
 */