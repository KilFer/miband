package com.tencent.b.b;

import android.content.Context;
import android.os.Message;
import android.telephony.TelephonyManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class A extends Thread
{
  private e.a a = null;
  private m.b b = null;
  private f.b c = null;

  A(n paramn, e.a parama, m.b paramb, f.b paramb1)
  {
    if (parama != null)
      this.a = ((e.a)parama.clone());
    if (paramb != null)
      this.b = ((m.b)paramb.clone());
    if (paramb1 != null)
      this.c = ((f.b)paramb1.clone());
  }

  public final void run()
  {
    if (!n.c());
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)n.l(this.d).getSystemService("phone");
      n.c(this.d, localTelephonyManager.getDeviceId());
      n.d(this.d, localTelephonyManager.getSubscriberId());
      n.e(this.d, localTelephonyManager.getLine1Number());
      Pattern localPattern = Pattern.compile("[0-9a-zA-Z+-]*");
      n localn5 = this.d;
      String str12;
      String str17;
      label135: label143: String str13;
      label163: String str16;
      label209: label217: String str14;
      label237: String str15;
      label283: label291: String str8;
      label315: String str9;
      label343: String str10;
      label371: String str11;
      label399: String str1;
      label429: String str2;
      String str3;
      if (n.m(this.d) == null)
      {
        str12 = "";
        n.c(localn5, str12);
        if (!localPattern.matcher(n.m(this.d)).matches())
          break label701;
        n localn10 = this.d;
        if (n.m(this.d) != null)
          break label689;
        str17 = "";
        n.c(localn10, str17);
        n localn6 = this.d;
        if (n.n(this.d) != null)
          break label714;
        str13 = "";
        n.d(localn6, str13);
        if (!localPattern.matcher(n.n(this.d)).matches())
          break label738;
        n localn9 = this.d;
        if (n.n(this.d) != null)
          break label726;
        str16 = "";
        n.d(localn9, str16);
        n localn7 = this.d;
        if (n.o(this.d) != null)
          break label751;
        str14 = "";
        n.e(localn7, str14);
        if (!localPattern.matcher(n.o(this.d)).matches())
          break label775;
        n localn8 = this.d;
        if (n.o(this.d) != null)
          break label763;
        str15 = "";
        n.e(localn8, str15);
        n.d();
        n localn1 = this.d;
        if (n.m(this.d) != null)
          break label788;
        str8 = "";
        n.c(localn1, str8);
        n localn2 = this.d;
        if (n.n(this.d) != null)
          break label800;
        str9 = "";
        n.d(localn2, str9);
        n localn3 = this.d;
        if (n.o(this.d) != null)
          break label812;
        str10 = "";
        n.e(localn3, str10);
        n localn4 = this.d;
        if (n.m(this.d) != null)
          break label824;
        str11 = "0123456789ABCDEF";
        n.f(localn4, r.a(str11));
        if (n.p(this.d) != 4)
          break label836;
        str1 = s.a(this.c);
        str2 = s.a(this.b, n.q(this.d).b());
        str3 = s.a(n.m(this.d), n.n(this.d), n.o(this.d), n.r(this.d), n.s(this.d));
        if ((this.a == null) || (!this.a.a()))
          break label842;
      }
      label689: label701: label836: label842: for (String str4 = s.a(this.a); ; str4 = "{}")
      {
        String str5 = "{\"version\":\"1.1.8\",\"address\":" + n.t(this.d);
        String str6 = str5 + ",\"source\":203,\"access_token\":\"" + n.u(this.d) + "\",\"app_name\":\"" + n.v(this.d) + "\",\"bearing\":1";
        String str7 = str6 + ",\"attribute\":" + str3 + ",\"location\":" + str4 + ",\"cells\":" + str2 + ",\"wifis\":" + str1 + "}";
        Message localMessage = n.d(this.d).obtainMessage(16, str7);
        n.d(this.d).sendMessage(localMessage);
        return;
        str12 = n.m(this.d);
        break;
        str17 = n.m(this.d);
        break label135;
        n.c(this.d, "");
        break label143;
        label714: str13 = n.n(this.d);
        break label163;
        label726: str16 = n.n(this.d);
        break label209;
        label738: n.d(this.d, "");
        break label217;
        label751: str14 = n.o(this.d);
        break label237;
        label763: str15 = n.o(this.d);
        break label283;
        n.e(this.d, "");
        break label291;
        str8 = n.m(this.d);
        break label315;
        str9 = n.n(this.d);
        break label343;
        str10 = n.o(this.d);
        break label371;
        str11 = n.m(this.d);
        break label399;
        str1 = "[]";
        break label429;
      }
    }
    catch (Exception localException)
    {
      label775: label788: label800: label812: label824: break label291;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.A
 * JD-Core Version:    0.6.2
 */