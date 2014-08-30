package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.List;

public final class PhoneUtil
{
  public static final String CELL_CDMA = "cdma";
  public static final String CELL_GSM = "gsm";
  private static final int a = 17;

  public static List<PhoneUtil.CellInfo> getCellInfoList(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 5)
    {
      new s();
      return s.b(paramContext);
    }
    new q();
    return q.b(paramContext);
  }

  public static String getCellXml(List<PhoneUtil.CellInfo> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() <= 0))
      localObject = "";
    while (true)
    {
      return localObject;
      localObject = "";
      int i = 0;
      while (i < paramList.size())
      {
        String str1 = (String)localObject + "<cell ";
        String str2 = str1 + "mcc=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).mcc + "\" ";
        String str3 = str2 + "mnc=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).mnc + "\" ";
        String str4 = str3 + "lac=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).lac + "\" ";
        String str5 = str4 + "type=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).type + "\" ";
        String str6 = str5 + "stationId=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).stationId + "\" ";
        String str7 = str6 + "networkId=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).networkId + "\" ";
        String str8 = str7 + "systemId=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).systemId + "\" ";
        String str9 = str8 + "dbm=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).dbm + "\" ";
        String str10 = str9 + " >";
        String str11 = str10 + ((PhoneUtil.CellInfo)paramList.get(i)).cellid;
        String str12 = str11 + "</cell>";
        i++;
        localObject = str12;
      }
    }
  }

  public static String getMacXml(List<PhoneUtil.MacInfo> paramList)
  {
    Object localObject1 = "";
    if ((paramList == null) || (paramList.size() <= 0))
    {
      localObject1 = "";
      return localObject1;
    }
    int i = 0;
    label23: String str4;
    if (i < paramList.size())
    {
      if ((paramList.get(i) == null) || (((PhoneUtil.MacInfo)paramList.get(i)).mac.length() != 17))
        break label212;
      String str1 = (String)localObject1 + "<mac ";
      String str2 = str1 + "macDbm=\"" + ((PhoneUtil.MacInfo)paramList.get(i)).dbm + "\"";
      String str3 = str2 + ">";
      str4 = str3 + ((PhoneUtil.MacInfo)paramList.get(i)).mac;
    }
    label212: for (Object localObject2 = str4 + "</mac>"; ; localObject2 = localObject1)
    {
      i++;
      localObject1 = localObject2;
      break label23;
      break;
    }
  }

  public static void getSignalStrength(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 5)
    {
      new s().a(paramContext);
      return;
    }
    new q().a(paramContext);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PhoneUtil
 * JD-Core Version:    0.6.2
 */