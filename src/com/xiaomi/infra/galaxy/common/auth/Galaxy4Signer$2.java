package com.xiaomi.infra.galaxy.common.auth;

import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

class Galaxy4Signer$2 extends ThreadLocal<SimpleDateFormat>
{
  Galaxy4Signer$2(Galaxy4Signer paramGalaxy4Signer)
  {
  }

  protected SimpleDateFormat initialValue()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "UTC"));
    return localSimpleDateFormat;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.auth.Galaxy4Signer.2
 * JD-Core Version:    0.6.2
 */