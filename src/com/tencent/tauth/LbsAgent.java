package com.tencent.tauth;

import android.content.Context;
import com.tencent.b.a.a.a;

public class LbsAgent
{
  private static final String a = "OpenSdk";
  private static final String b = "WQMPF-XMH66-ISQXP-OIGMM-BNL7M";
  private SosoLocationListener c;

  public void removeUpdate()
  {
    a.a().b();
    this.c = null;
  }

  public void requestLocationUpdate(Context paramContext, LbsAgent.OnGetLocationListener paramOnGetLocationListener)
  {
    this.c = new SosoLocationListener(paramOnGetLocationListener);
    a.a().a(paramContext, this.c);
  }

  public boolean verifyRegCode()
  {
    return a.a().a("OpenSdk", "WQMPF-XMH66-ISQXP-OIGMM-BNL7M");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.tauth.LbsAgent
 * JD-Core Version:    0.6.2
 */