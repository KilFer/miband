package cn.com.smartdevices.bracelet.analysis;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData;
import cn.com.smartdevices.bracelet.chart.util.ChartData.UserSleepModify;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SportData;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class DataAnalysis
{
  private static boolean a = false;
  private static final int b = 30;
  private static final int c = 3;
  private static final int d = 5;
  private static final int e = 10;
  private static final int f = 30;
  private static final int g = 15;
  private static final int h = 20;
  private static final double i = 0.42D;
  private static final double[][] j = { { 2.0D, 2.0D }, { 2.5D, 2.2D }, { 3.0D, 2.5D }, { 3.5D, 3.0D }, { 5.0D, 4.0D }, { 6.3D, 4.5D }, { 8.0D, 5.0D }, { 10.0D, 6.0D }, { 13.0D, 7.0D }, { 15.5D, 8.0D }, { 18.0D, 9.0D } };
  private static final double[][] k = { { 40.232999999999997D, 0.95D }, { 53.645000000000003D, 1.19D }, { 67.055999999999997D, 1.41D }, { 80.466999999999999D, 1.57D }, { 93.878D, 1.78D }, { 107.29000000000001D, 2.36D }, { 120.7D, 2.97D }, { 134.11000000000001D, 3.79D }, { 160.94D, 4.67D }, { 187.75999999999999D, 5.24D }, { 214.58000000000001D, 5.62D }, { 241.40000000000001D, 6.1D }, { 268.23000000000002D, 6.91D }, { 295.05000000000001D, 7.62D }, { 321.87D, 9.050000000000001D }, { 348.69D, 9.43D }, { 375.51999999999998D, 10.949999999999999D } };

  private static b a(ArrayList<SportData> paramArrayList, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, ChartData.UserSleepModify paramUserSleepModify, int paramInt4)
  {
    ArrayList localArrayList1 = new ArrayList();
    int m;
    int n;
    int i1;
    int i173;
    label92: int i2;
    if (paramBoolean2)
    {
      m = 1440;
      n = 0;
      i1 = 0;
      if (paramUserSleepModify == null)
        break label6274;
      int i171 = paramUserSleepModify.sleepStart;
      n = 0;
      i1 = 0;
      if (i171 >= -1440)
      {
        int i172 = paramUserSleepModify.sleepStart;
        n = 0;
        i1 = 0;
        if (i172 <= 1440)
        {
          if (!paramBoolean2)
            break label1758;
          if (paramUserSleepModify.sleepStart < 0)
            break label1752;
          i173 = paramUserSleepModify.sleepStart;
          i1 = i173;
          n = 1;
        }
      }
      if ((paramUserSleepModify.sleepEnd < -1440) || (paramUserSleepModify.sleepEnd > 1440))
        break label6274;
      if (!paramBoolean2)
        break label1782;
      if (paramUserSleepModify.sleepEnd >= paramArrayList.size())
        break label1771;
      m = paramUserSleepModify.sleepEnd;
      label145: n += 2;
      if (m <= 0)
        break label6274;
      m--;
      i2 = i1;
    }
    label301: label559: label1082: label3131: label5567: for (int i3 = n; ; i3 = n)
    {
      if (a)
        Debug.i("sleepanalyze", "form " + paramInt1 + "->" + paramInt2);
      int i4 = Math.min(paramInt2, paramArrayList.size());
      int i6;
      int i7;
      int i8;
      int i9;
      int i14;
      int i168;
      int i169;
      int i170;
      int i15;
      int i16;
      label335: int i47;
      int i48;
      int i50;
      int i51;
      label505: int i52;
      int i65;
      ArrayList localArrayList2;
      int i66;
      int i166;
      int i131;
      int i132;
      int i133;
      int i159;
      int i160;
      int i161;
      int i138;
      int i139;
      int i140;
      int i149;
      int i150;
      int i158;
      label748: int i98;
      int i99;
      label759: int i101;
      label837: int i107;
      int i105;
      int i106;
      int i104;
      int i103;
      int i124;
      label989: int i108;
      int i109;
      int i110;
      int i113;
      label1116: int i114;
      int i115;
      int i117;
      int i118;
      int i119;
      int i31;
      int i34;
      int i32;
      int i33;
      int i35;
      label1359: int i45;
      label1472: label1520: label1526: int i43;
      int i46;
      int i42;
      int i37;
      int i36;
      label1599: int i38;
      int i39;
      label1606: int i40;
      int i41;
      for (int i5 = i4 - 1; ; i5--)
      {
        if (i5 <= paramInt1);
        label1752: label1758: label1771: label1782: 
        while (((SportData)paramArrayList.get(i5)).getSportMode() != 126)
        {
          i6 = 0;
          i7 = paramInt1;
          i8 = 0;
          i9 = paramInt1;
          if (i9 < i5)
            break label1818;
          if (i8 <= 9)
            break label1985;
          b(paramArrayList, i7, -1 + (i9 - i8));
          a(paramArrayList, i9 - i8, i9 - 1);
          i14 = i9;
          if (paramBoolean1)
          {
            i168 = 0;
            i169 = i14;
            if (i169 < i5)
              break label2023;
            i170 = i168;
            if (i170 <= 9)
              b(paramArrayList, i14, i5);
          }
          if (a)
            Debug.i("sleepAnalyze", "do Analyze");
          i15 = paramInt1;
          i16 = paramInt1;
          i16++;
          if (i16 < i4)
            break label2098;
          if (a)
            Debug.i("sleepAnalyze", "Sleep sections=" + localArrayList1.size());
          if (localArrayList1.size() <= 0)
            break label6231;
          i47 = paramInt3 + 1920;
          i48 = paramInt3 + 1380;
          int i49 = paramInt3 + 1440;
          if (i48 >= 0)
            break label6224;
          i50 = 0;
          if (a)
            Debug.i("sleepAnalyze", "Use Ref: " + i2 + "->" + m);
          Log.i("sleepAnalyze", "Use Ref: " + i2 + "->" + m + ", hasRef=0");
          if (localArrayList1.size() >= 2)
            break label2634;
          i51 = localArrayList1.size();
          i52 = 0;
          if (i52 < i51)
            break label2640;
          i65 = 85;
          if (a)
            Debug.i("sleepAnalyze", "quality ref=" + i65);
          localArrayList2 = new ArrayList();
          i66 = 0;
          if (i66 < localArrayList1.size())
            break label3033;
          if (localArrayList2.size() > 0)
          {
            i166 = -1 + localArrayList2.size();
            if (i166 >= 0)
              break label4610;
          }
          int i97 = localArrayList1.size();
          if (i97 > 1)
          {
            i131 = 0;
            i132 = 0;
            i133 = 0;
            if (i133 < i97)
              break label4681;
            if (Integer.parseInt(((HashMap)localArrayList1.get(i132)).get("start").toString()) > i47)
            {
              i159 = 0;
              i160 = 0;
              i161 = 0;
              if (i161 < i97)
                break label4757;
              if (i159 > 0)
                i132 = i160;
            }
            i138 = Integer.parseInt(((HashMap)localArrayList1.get(i132)).get("stop").toString());
            i139 = 0;
            i140 = i132 + 1;
            if (i140 < i97)
              break label4840;
            i149 = Integer.parseInt(((HashMap)localArrayList1.get(i132)).get("start").toString());
            i150 = i132 - 1;
            if (i150 >= 0)
              break label5033;
            i158 = 31;
            if (i158 >= 0)
              break label5219;
          }
          i98 = 0;
          i99 = 0;
          if (i99 < localArrayList1.size())
            break label5272;
          if ((i98 <= 90) || ((i98 <= 150) && (Integer.parseInt(((HashMap)localArrayList1.get(-1 + localArrayList1.size())).get("stop").toString()) < i49)))
          {
            if (a)
              Debug.i("sleepAnalyze", "totalSize too small, so clear");
            i101 = -1 + localArrayList1.size();
            if (i101 >= 0)
              break label5328;
          }
          int i102 = localArrayList1.size();
          if (a)
            Debug.i("sleepAnalyze", "now sleeplist=" + i102);
          if (i102 <= 0)
            break label6126;
          i107 = Integer.parseInt(((HashMap)localArrayList1.get(0)).get("start").toString());
          i105 = Integer.parseInt(((HashMap)localArrayList1.get(i102 - 1)).get("stop").toString());
          i106 = Integer.parseInt(((HashMap)localArrayList1.get(0)).get("startBed").toString());
          i104 = Integer.parseInt(((HashMap)localArrayList1.get(i102 - 1)).get("stopBed").toString());
          i103 = 0;
          i124 = 1;
          if (i124 < i102)
            break label5384;
          if (a)
            Debug.i("sleepAnalyze", "sleepanalyze " + i107 + "->" + i105 + ", OnBed=" + i106 + "->" + i104);
          if (i107 >= i105)
            break label6098;
          if (i107 <= 30)
            break label5567;
          i108 = i107 - 30;
          if (i107 <= 15)
            break label5573;
          i109 = i107 - 15;
          i110 = i107 - 1;
          int i111 = Math.max(i106, i108);
          int i112 = Math.max(i106, i109);
          i113 = 1;
          if (i110 >= i112)
            break label5579;
          i114 = i110 + 1;
          if (a)
            Debug.i("DataAnalysis", "k=" + i110 + ",start=" + i107);
          if (1 + (i107 - i114) < 15)
            break label5621;
          a(paramArrayList, i114, i107, 5);
          i115 = 1;
          if (i110 >= i111)
            break label5633;
          int i116 = i110 + 1;
          if (a)
            Debug.i("DataAnalysis", "k=" + i110 + ",start=" + i107 + ",startNREM=" + i114);
          a(paramArrayList, i116, i114 - 1, 4);
          if (a)
            Debug.i("sleepAnalyze", "prev stop at " + i105);
          i117 = i105 + 1;
          i118 = i105;
          i119 = 0;
          if (i117 <= i104)
            break label5690;
          if (a)
            Debug.i("sleepAnalyze", "now stop at " + i118);
          i31 = i106;
          i34 = i116;
          int i121 = i103;
          i32 = i104;
          i33 = i118;
          i35 = i121;
          boolean bool = false;
          if (i34 < i33)
            bool = true;
          Log.i("sleepM", ">>>>>>analyze: " + i34 + "->" + i33);
          if (1 != i3)
            break label5839;
          m = i33;
          if (i3 == 0)
            break label6065;
          Log.i("sleepM", ">>>>>>>>now ref=" + i2 + "->" + m);
          if (bool)
            break label5852;
          a(paramArrayList, i2, m, 100);
          if (bool)
          {
            if (i34 < i2)
              a(paramArrayList, i34, i2 - 1);
            if (i33 > m)
              a(paramArrayList, m + 1, i33);
          }
          if (!bool)
            break label6054;
          i45 = i2;
          if (i45 >= paramInt1)
            break label5879;
          i43 = i45 + 1;
          i46 = m;
          if (i46 <= paramInt2)
            break label5934;
          i42 = i46 - 1;
          Log.i("sleepM", ">>>>>onbed: " + i43 + "->" + i42);
          i32 = i42;
          int i44 = i43;
          i37 = i2;
          i36 = i44;
          i38 = 0;
          i39 = i37;
          if (i39 <= m)
            break label5989;
          if (a)
            Debug.i("DataAnalyze", "total=" + i38 + ",sleep=" + i37 + "->" + m + "," + i38 / (1 + (m - i37)));
          if (i37 < m)
          {
            i40 = i36;
            if (i40 < i37)
              break label6014;
            i41 = m + 1;
            if (i41 <= i32)
              break label6034;
          }
          return new b(i37, m, i36, i32, i38, localArrayList1.size(), 0, i35, bool);
          m = 2880;
          break;
          i173 = 0;
          break label92;
          i173 = paramInt4 + paramUserSleepModify.sleepStart;
          break label92;
          m = -1 + paramArrayList.size();
          break label145;
          m = paramInt4 + paramUserSleepModify.sleepEnd;
          break label145;
        }
      }
      SportData localSportData1 = (SportData)paramArrayList.get(i9);
      int i13;
      if ((localSportData1.getStep() > 0) && (localSportData1.getActivity() >= 60))
      {
        i13 = i8 + 1;
        i6 = i9;
      }
      while (true)
      {
        label1857: i9++;
        i8 = i13;
        break;
        if (localSportData1.getActivity() < 6)
          break label1886;
        i13 = i8 + 1;
      }
      label1886: int i11;
      int i10;
      if (i8 > 9)
      {
        b(paramArrayList, i7, -1 + (i9 - i8));
        a(paramArrayList, i9 - i8, i9 - 1);
        i11 = 0;
        i10 = i9;
      }
      label1985: label4545: label5573: 
      while (true)
      {
        int i12 = i10;
        i6 = i11;
        i7 = i12;
        i13 = 0;
        break label1857;
        label2634: label2640: label3026: label4567: if (i6 > 0)
        {
          b(paramArrayList, i7, -1 + (i9 - i8));
          a(paramArrayList, i9 - i8, i9 - 1);
          i10 = i9;
          i11 = 0;
          continue;
          label2266: label3679: label5219: label5989: if (i6 > 0)
          {
            b(paramArrayList, i7, -1 + (i9 - i8));
            a(paramArrayList, i9 - i8, i9 - 1);
            i14 = i9;
            break;
            label2023: SportData localSportData2 = (SportData)paramArrayList.get(i169);
            if ((localSportData2.getStep() > 0) && (localSportData2.getActivity() >= 60))
            {
              i170 = 10;
              break label301;
            }
            if (localSportData2.getActivity() >= 6)
            {
              i170 = i168 + 1;
              if (i170 > 9)
                break label301;
            }
            while (true)
            {
              i169++;
              i168 = i170;
              break;
              i170 = 0;
            }
            int i17 = ((SportData)paramArrayList.get(i16 - 1)).getSportMode();
            int i18 = ((SportData)paramArrayList.get(i16)).getSportMode();
            if ((i17 != 5) && (i17 != 4) && ((i18 == 5) || (i18 == 4)))
            {
              i15 = i16;
              break label335;
            }
            if (((i17 != 5) && (i17 != 4)) || (i18 == 4) || (i18 == 5))
              break label335;
            int i19 = 0;
            int i20 = i15;
            int i21;
            int i22;
            if (i20 >= i16 - 1)
            {
              i21 = i19;
              i22 = 1 + (i20 - i21);
              if (i22 >= 0)
                break label6249;
            }
            label4840: label6249: for (int i23 = 0; ; i23 = i22)
            {
              a(paramArrayList, i15, i23 - 1);
              int i24 = i16 - 1;
              int i28;
              int i29;
              int i30;
              int i25;
              HashMap localHashMap1;
              int i26;
              if (1 + (i24 - i23) >= 120)
              {
                i28 = 0;
                i29 = i24;
                if (i29 < i23)
                {
                  i30 = i28;
                  i24 = -1 + (i30 + i29);
                  a(paramArrayList, i24 + 1, i16 - 1);
                }
              }
              else
              {
                i25 = i24;
                if (i25 - i23 < 15)
                  break label2615;
                localHashMap1 = new HashMap();
                localHashMap1.put("start", Integer.valueOf(i23));
                localHashMap1.put("stop", Integer.valueOf(i25));
                localHashMap1.put("reset", Integer.valueOf(0));
                i26 = i15;
                if (i26 >= paramInt1)
                  break label2539;
                localHashMap1.put("startBed", Integer.valueOf(i26 + 1));
              }
              for (int i27 = i16; ; i27++)
              {
                if (i27 > paramInt2);
                label2539: 
                while ((((SportData)paramArrayList.get(i27)).getStep() > 0) || (((SportData)paramArrayList.get(i27)).getSportMode() == 126))
                {
                  localHashMap1.put("stopBed", Integer.valueOf(i27 - 1));
                  localArrayList1.add(localHashMap1);
                  if (!a)
                    break;
                  Debug.i("sleepAnalyze", "item:" + i23 + "->" + i25);
                  break;
                  if (((SportData)paramArrayList.get(i20)).getActivity() < 6)
                  {
                    i21 = i19 + 1;
                    if (i21 >= 5)
                      break label2203;
                  }
                  while (true)
                  {
                    i20++;
                    i19 = i21;
                    break;
                    i21 = 0;
                  }
                  if (((SportData)paramArrayList.get(i29)).getActivity() < 6)
                  {
                    i30 = i28 + 1;
                    if (i30 >= 5)
                      break label2266;
                  }
                  while (true)
                  {
                    i29--;
                    i28 = i30;
                    break;
                    i30 = 0;
                  }
                  if ((((SportData)paramArrayList.get(i26)).getStep() > 0) || (((SportData)paramArrayList.get(i26)).getSportMode() == 126))
                    break label2359;
                  i26--;
                  break label2353;
                }
              }
              if (i25 - i23 < 0)
                break;
              a(paramArrayList, i23, i25);
              break;
              i51 = 2;
              break label505;
              int i53 = 0;
              int i54 = 0;
              int i55 = 0;
              int i59;
              int i60;
              int i61;
              int i62;
              int i64;
              if (i55 >= localArrayList1.size())
              {
                i59 = 0;
                if (a)
                  Debug.i("sleepAnalyze", "maxSec=" + i53 + ",maxS=" + i54);
                i60 = Integer.parseInt(((HashMap)localArrayList1.get(i53)).get("start").toString());
                i61 = Integer.parseInt(((HashMap)localArrayList1.get(i53)).get("stop").toString());
                i62 = i60;
                if (i62 <= i61)
                  break label2943;
                if (a)
                  Debug.i("sleepAnalyze", "maxSec:" + i60 + "->" + i61 + ",nrem=" + i59);
                if (((i59 >= 0.98D * i54) || (i59 <= 0.65D * i54)) && (i54 > 0))
                  break label2975;
                if (i54 <= 0)
                  break label3026;
                i64 = i59 * 100 / i54;
                i65 = i64;
                break label519;
              }
              HashMap localHashMap2 = (HashMap)localArrayList1.get(i55);
              int i56 = Integer.parseInt(localHashMap2.get("start").toString());
              int i57 = 1 + (Integer.parseInt(localHashMap2.get("stop").toString()) - i56);
              if ((i57 > i54) && (i56 < i47));
              for (int i58 = i55; ; i58 = i53)
              {
                i55++;
                i53 = i58;
                i54 = i57;
                break label2649;
                label2943: if (((SportData)paramArrayList.get(i62)).getSportMode() == 5);
                for (int i63 = i59 + 1; ; i63 = i59)
                {
                  i62++;
                  i59 = i63;
                  break label2752;
                  if (a)
                    Debug.i("sleepAnalyze", "del MAX " + i53);
                  a(paramArrayList, i60, i61);
                  localArrayList1.remove(i53);
                  i52++;
                  break;
                  i64 = 85;
                  break label2857;
                  HashMap localHashMap3 = (HashMap)localArrayList1.get(i66);
                  int i67 = Integer.parseInt(localHashMap3.get("start").toString());
                  int i68 = Integer.parseInt(localHashMap3.get("stop").toString());
                  int i69 = 1 + (i68 - i67);
                  if (i69 < 15)
                  {
                    if (a)
                      Debug.i("sleepAnalyze", "del " + i66);
                    localArrayList2.add(Integer.valueOf(i66));
                    i66++;
                    break label559;
                  }
                  ((HashMap)localArrayList1.get(i66)).put("refmode", Integer.valueOf(0));
                  Debug.i("sleepAnalyze", "hasRef=0" + ",refMode=0");
                  Log.i("sleepAnalyze", i67 + "->" + i68 + ",hasRef=0" + ",refMode=0");
                  int i70 = 0;
                  int i71 = 0;
                  int i72 = i67;
                  if (i72 > i68)
                  {
                    if (a)
                      Debug.i("sleepAnalyze", "Sec" + i66 + ":" + i67 + "->" + i68 + " nrem=" + i71 + " quality=" + i71 * 100 / i69 + ",activeNum=" + i70);
                    if (i65 >= 85)
                      break label3501;
                  }
                  int i75;
                  int i73;
                  for (int i74 = 70; ; i74 = i65 - 15)
                  {
                    i75 = i71 * 100 / i69;
                    if (((i69 < 100) || ((i75 >= i74) && (i75 < 98))) && ((i69 >= 100) || ((i75 >= i74) && (i75 < 98)) || (i66 == -1 + localArrayList1.size())))
                      break label3511;
                    if (a)
                      Debug.i("sleepAnalyze", "del " + i66);
                    localArrayList2.add(Integer.valueOf(i66));
                    break;
                    if (((SportData)paramArrayList.get(i72)).getSportMode() == 5)
                      i71++;
                    if (((SportData)paramArrayList.get(i72)).getActivity() < 15)
                      break label6173;
                    i73 = i70 + 1;
                    i72++;
                    i70 = i73;
                    break label3235;
                  }
                  ArrayList localArrayList3 = new ArrayList();
                  int i76 = i67 + 1;
                  int i77 = i67;
                  int i81;
                  int i82;
                  if (i76 > i68)
                  {
                    int i80 = ((SportData)paramArrayList.get(i77)).getSportMode();
                    if ((i80 == 5) && (i68 + 1 - i77 < 10))
                    {
                      i80 = 4;
                      a(paramArrayList, i77, i68, 4);
                    }
                    HashMap localHashMap5 = new HashMap();
                    localHashMap5.put("start", Integer.valueOf(i77));
                    localHashMap5.put("stop", Integer.valueOf(i68));
                    localHashMap5.put("mode", Integer.valueOf(i80));
                    localArrayList3.add(localHashMap5);
                    i81 = 0;
                    i82 = 0;
                  }
                  ArrayList localArrayList4;
                  int i83;
                  int i84;
                  int i85;
                  int i86;
                  int i78;
                  while (true)
                  {
                    if (i82 >= localArrayList3.size())
                    {
                      localArrayList4 = new ArrayList();
                      i83 = 0;
                      i84 = 0;
                      i85 = i67 + 1;
                      i86 = i67;
                      if (i85 <= i68)
                        break label4407;
                      HashMap localHashMap6 = new HashMap();
                      localHashMap6.put("start", Integer.valueOf(i86));
                      localHashMap6.put("stop", Integer.valueOf(i68));
                      localHashMap6.put("mode", Integer.valueOf(((SportData)paramArrayList.get(i86)).getSportMode()));
                      localArrayList4.add(localHashMap6);
                      if (((SportData)paramArrayList.get(i86)).getSportMode() == 5)
                      {
                        i83++;
                        if (1 + (i68 - i86) > i84)
                          i84 = 1 + (i68 - i86);
                      }
                      if (a)
                        Debug.i("sleepAnalyze", "total=" + localArrayList4.size() + ",maxnrem=" + i81 + ",nremNum=" + i83 + ",size=" + i69 + ",quality=" + i75 + ",maxnrem2=" + i84);
                      if ((localArrayList4.size() > 1) && (i81 <= 150) && ((i81 <= 120) || (i83 > 1)) && ((i83 > 1) || (i69 < 120) || (i75 <= 95)) && ((i83 <= i69 / 20) || (i69 < 60)) && (i70 * 100 / i69 < 40) && ((i70 * 100 / i69 > 1) || (i69 < 60)))
                        break;
                      if ((i66 != -1 + localArrayList1.size()) || (i69 >= 120) || (i75 <= 60) || (i67 >= i47))
                        break label4567;
                      if (!a)
                        break;
                      Debug.i("sleepAnalyze", "not del last");
                      break;
                      if (((SportData)paramArrayList.get(i76)).getSportMode() == ((SportData)paramArrayList.get(i76 - 1)).getSportMode())
                        break label6166;
                      int i79 = ((SportData)paramArrayList.get(i77)).getSportMode();
                      if ((i79 == 5) && (i76 - i77 < 10))
                      {
                        i79 = 4;
                        a(paramArrayList, i77, i76 - 1, 4);
                      }
                      HashMap localHashMap4 = new HashMap();
                      localHashMap4.put("start", Integer.valueOf(i77));
                      localHashMap4.put("stop", Integer.valueOf(i76 - 1));
                      localHashMap4.put("mode", Integer.valueOf(i79));
                      localArrayList3.add(localHashMap4);
                      i78 = i76;
                      i76++;
                      i77 = i78;
                      break label3530;
                    }
                    int i90 = ((Integer)((HashMap)localArrayList3.get(i82)).get("start")).intValue();
                    int i91 = ((Integer)((HashMap)localArrayList3.get(i82)).get("stop")).intValue();
                    int i92 = ((Integer)((HashMap)localArrayList3.get(i82)).get("mode")).intValue();
                    int i93 = 1 + (i91 - i90);
                    if (i92 != 7)
                    {
                      if ((i92 == 5) && (i93 > i81))
                        i81 = i93;
                      if (((i92 == 4) || (i92 == 5)) && (i92 == 4) && (i93 < 10) && (i82 > 0) && (i82 < -1 + localArrayList3.size()))
                      {
                        int i95 = ((Integer)((HashMap)localArrayList3.get(i82 - 1)).get("mode")).intValue();
                        int i96 = ((Integer)((HashMap)localArrayList3.get(i82 + 1)).get("mode")).intValue();
                        if ((i95 == 5) && (i96 == 5))
                          a(paramArrayList, i90, i91, 5);
                      }
                    }
                    int i94 = i81;
                    i82++;
                    i81 = i94;
                  }
                  int i87;
                  int i88;
                  if (((SportData)paramArrayList.get(i85)).getSportMode() != ((SportData)paramArrayList.get(i85 - 1)).getSportMode())
                  {
                    HashMap localHashMap7 = new HashMap();
                    localHashMap7.put("start", Integer.valueOf(i86));
                    localHashMap7.put("stop", Integer.valueOf(i85 - 1));
                    localHashMap7.put("mode", Integer.valueOf(((SportData)paramArrayList.get(i86)).getSportMode()));
                    localArrayList4.add(localHashMap7);
                    if (((SportData)paramArrayList.get(i86)).getSportMode() == 5)
                    {
                      i83++;
                      if (i85 - i86 > i84)
                      {
                        i87 = i85 - i86;
                        i88 = i83;
                      }
                    }
                  }
                  for (int i89 = i85; ; i89 = i86)
                  {
                    i85++;
                    i86 = i89;
                    i83 = i88;
                    i84 = i87;
                    break label3679;
                    if (a)
                      Debug.i("sleepAnalyze", "del " + i66);
                    localArrayList2.add(Integer.valueOf(i66));
                    break label3131;
                    int i167 = Integer.parseInt(localArrayList2.get(i166).toString());
                    HashMap localHashMap14 = (HashMap)localArrayList1.get(i167);
                    a(paramArrayList, Integer.parseInt(localHashMap14.get("start").toString()), Integer.parseInt(localHashMap14.get("stop").toString()));
                    localArrayList1.remove(i167);
                    i166--;
                    break;
                    HashMap localHashMap10 = (HashMap)localArrayList1.get(i133);
                    int i134 = Integer.parseInt(localHashMap10.get("start").toString());
                    int i135 = 1 + (Integer.parseInt(localHashMap10.get("stop").toString()) - i134);
                    int i137;
                    int i136;
                    if (i135 > i131)
                    {
                      i137 = i135;
                      i136 = i133;
                    }
                    while (true)
                    {
                      i133++;
                      i131 = i137;
                      i132 = i136;
                      break;
                      HashMap localHashMap13 = (HashMap)localArrayList1.get(i161);
                      int i162 = Integer.parseInt(localHashMap13.get("start").toString());
                      int i163 = 1 + (Integer.parseInt(localHashMap13.get("stop").toString()) - i162);
                      int i165;
                      int i164;
                      if ((i163 > i159) && (i162 < i47))
                      {
                        i165 = i163;
                        i164 = i161;
                      }
                      while (true)
                      {
                        i161++;
                        i159 = i165;
                        i160 = i164;
                        break;
                        HashMap localHashMap11 = (HashMap)localArrayList1.get(i140);
                        int i141 = Integer.parseInt(localHashMap11.get("start").toString());
                        int i142 = Integer.parseInt(localHashMap11.get("stop").toString());
                        int i143 = Integer.parseInt(localHashMap11.get("refmode").toString());
                        int i144 = 1 + (i141 - i138);
                        int i145 = 1 + (i142 - i141);
                        int i146;
                        if (((i144 > i145) && ((i142 >= i47) || (i141 <= i50))) || ((i144 >= i145 * 2) && (i143 == 0)))
                        {
                          if (a)
                            Debug.i("sleepAnalyze", "delta > size, del " + i140);
                          a(paramArrayList, i141, i142);
                          i146 = i139 | 1 << i140;
                        }
                        for (int i147 = i138; ; i147 = i142)
                        {
                          int i148 = i140 + 1;
                          i138 = i147;
                          i140 = i148;
                          i139 = i146;
                          break;
                          i146 = i139;
                        }
                        HashMap localHashMap12 = (HashMap)localArrayList1.get(i150);
                        int i151 = Integer.parseInt(localHashMap12.get("start").toString());
                        int i152 = Integer.parseInt(localHashMap12.get("stop").toString());
                        int i153 = Integer.parseInt(localHashMap12.get("refmode").toString());
                        int i154 = i149 + 1 - i152;
                        int i155 = 1 + (i152 - i151);
                        int i156;
                        if (((i154 > i155) && ((i152 >= i47) || (i151 <= i50))) || ((i154 >= i155 * 2) && (i153 == 0)))
                        {
                          if (a)
                            Debug.i("sleepAnalyze", "delta2 > size, del " + i150);
                          a(paramArrayList, i151, i152);
                          i156 = i139 | 1 << i150;
                        }
                        for (int i157 = i149; ; i157 = i151)
                        {
                          i150--;
                          i149 = i157;
                          i139 = i156;
                          break;
                          i156 = i139;
                        }
                        if ((i139 & 1 << i158) != 0)
                        {
                          if (a)
                            Debug.i("sleepAnalyze", "del " + i158);
                          localArrayList1.remove(i158);
                        }
                        i158--;
                        break label748;
                        HashMap localHashMap8 = (HashMap)localArrayList1.get(i99);
                        int i100 = Integer.parseInt(localHashMap8.get("start").toString());
                        i98 += 1 + (Integer.parseInt(localHashMap8.get("stop").toString()) - i100);
                        i99++;
                        break label759;
                        HashMap localHashMap9 = (HashMap)localArrayList1.get(i101);
                        a(paramArrayList, Integer.parseInt(localHashMap9.get("start").toString()), Integer.parseInt(localHashMap9.get("stop").toString()));
                        localArrayList1.remove(i101);
                        i101--;
                        break label837;
                        int i125 = Integer.parseInt(((HashMap)localArrayList1.get(i124 - 1)).get("stop").toString());
                        int i126 = Integer.parseInt(((HashMap)localArrayList1.get(i124)).get("start").toString());
                        int i127 = Integer.parseInt(((HashMap)localArrayList1.get(i124)).get("startBed").toString());
                        int i128;
                        if (i127 > i125)
                        {
                          int i130 = -1 + (i127 - i125);
                          if (i130 <= 30)
                            a(paramArrayList, i125 + 1, i127 - 1, 7);
                          i128 = i130 + i103;
                          a(paramArrayList, i127, i126 - 1, 4);
                        }
                        while (true)
                        {
                          i124++;
                          i103 = i128;
                          break;
                          if (i126 > i125)
                          {
                            int i129 = -1 + (i126 - i125);
                            if (i129 <= 30)
                              a(paramArrayList, i125 + 1, i126 - 1, 7);
                            i128 = i129 + i103;
                            continue;
                            i108 = 0;
                            break label1068;
                            i109 = 0;
                            break label1082;
                            if ((i113 != 0) && (((SportData)paramArrayList.get(i110)).getActivity() < 6));
                            for (i113 = 1; ; i113 = 0)
                            {
                              if (i113 == 0)
                                break label5619;
                              i110--;
                              break;
                            }
                            label5619: break label1116;
                            label5621: a(paramArrayList, i114, i107, 4);
                            break label1181;
                            if ((i115 != 0) && (((SportData)paramArrayList.get(i110)).getActivity() < 30) && (((SportData)paramArrayList.get(i110)).getStep() == 0));
                            for (i115 = 1; ; i115 = 0)
                            {
                              if (i115 == 0)
                                break label5688;
                              i110--;
                              break;
                            }
                            break label1191;
                            int i120 = ((SportData)paramArrayList.get(i117)).getSportMode();
                            if ((i120 == 2) || (i120 == 1) || (i120 == 126))
                            {
                              i118 = i117 - 1;
                              break label1306;
                            }
                            int i122;
                            int i123;
                            if ((i120 == 0) || (i120 == 3))
                              if (((SportData)paramArrayList.get(i117)).getActivity() < 6)
                              {
                                ((SportData)paramArrayList.get(i117)).setMode(4);
                                i122 = 0;
                                i123 = i117;
                              }
                            while (true)
                            {
                              i117++;
                              i118 = i123;
                              i119 = i122;
                              break;
                              ((SportData)paramArrayList.get(i117)).setMode(4);
                              i122 = i119 + 1;
                              if (i119 >= 4)
                              {
                                i118 = i117 - 4;
                                a(paramArrayList, i117 - 3, i117, 0);
                                break label1306;
                                if (2 != i3)
                                  break label1417;
                                i2 = i34;
                                break label1417;
                                if ((i34 == i2) && (i33 == m))
                                  break label1472;
                                i35 = c(paramArrayList, i2, m);
                                break label1472;
                                label5879: if ((((SportData)paramArrayList.get(i45)).getStep() > 0) || (((SportData)paramArrayList.get(i45)).getSportMode() == 126) || (((SportData)paramArrayList.get(i45)).getSportMode() == 6))
                                  break label1526;
                                i45--;
                                break label1520;
                                if ((((SportData)paramArrayList.get(i46)).getStep() > 0) || (((SportData)paramArrayList.get(i46)).getSportMode() == 126) || (((SportData)paramArrayList.get(i46)).getSportMode() == 6))
                                  break label1542;
                                i46++;
                                break label1536;
                                if (4 != ((SportData)paramArrayList.get(i39)).getSportMode())
                                  i38++;
                                i39++;
                                break label1606;
                                label6014: ((SportData)paramArrayList.get(i40)).setMode(7);
                                i40++;
                                break label1696;
                                ((SportData)paramArrayList.get(i41)).setMode(7);
                                i41++;
                                break label1709;
                                i42 = m;
                                i43 = i2;
                                break label1548;
                                i36 = i31;
                                m = i33;
                                i37 = i34;
                                break label1599;
                              }
                              i123 = i118;
                              continue;
                              i122 = i119;
                              i123 = i118;
                            }
                            i33 = i105;
                            i34 = i107;
                            i35 = i103;
                            i31 = 0;
                            i32 = 0;
                            break label1359;
                          }
                          i128 = i103;
                        }
                        label6126: i103 = 0;
                        i104 = 0;
                        i105 = 0;
                        i106 = 0;
                        i107 = 0;
                        break label989;
                        i164 = i160;
                        i165 = i159;
                      }
                      i136 = i132;
                      i137 = i131;
                    }
                    i78 = i77;
                    break label4165;
                    i73 = i70;
                    break label3491;
                    i87 = i84;
                    i88 = i83;
                    break label4545;
                    i87 = i84;
                    i88 = i83;
                  }
                }
                i57 = i54;
              }
              i50 = i48;
              break label413;
              i31 = 0;
              i32 = 0;
              i33 = 0;
              i34 = 0;
              i35 = 0;
              break label1359;
            }
          }
          label2649: label5852: i14 = i7;
          label3033: break;
        }
        label3530: label5328: label6098: label6231: i10 = i7;
        label4165: label4681: label5579: label5839: label6224: i11 = i6;
      }
      label2752: i2 = i1;
    }
  }

  private static void a(SharedPreferences paramSharedPreferences, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
    if (paramSharedPreferences == null)
      return;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    if (paramBoolean)
    {
      m = (paramInt1 + paramSharedPreferences.getInt("start1", 1440)) / 2;
      n = (paramInt2 + paramSharedPreferences.getInt("stop1", 1920)) / 2;
      i1 = (paramInt3 * 100 / (1 + (paramInt2 - paramInt1)) + paramSharedPreferences.getInt("quality1", 85)) / 2;
      i2 = (paramInt4 + paramSharedPreferences.getInt("wakecnt1", 1)) / 2;
      i3 = (paramInt5 + paramSharedPreferences.getInt("maxnrem", 60)) / 2;
      localEditor.putInt("start1", m);
      localEditor.putInt("stop1", n);
      localEditor.putInt("quality1", i1);
      localEditor.putInt("wakecnt1", i2);
      localEditor.putInt("maxnrem", i3);
    }
    while (true)
    {
      if (a)
        Debug.i("sleepAnalyze", "storeRef: " + m + "->" + n + ",quality=" + i1 + ",wakecnt=" + i2 + ",maxnrem=" + i3 + ",store1=" + paramBoolean);
      localEditor.commit();
      return;
      m = (paramInt1 + paramSharedPreferences.getInt("start2", 1440)) / 2;
      n = (paramInt2 + paramSharedPreferences.getInt("stop2", 1920)) / 2;
      i1 = (paramInt3 * 100 / (1 + (paramInt2 - paramInt1)) + paramSharedPreferences.getInt("quality2", 85)) / 2;
      i2 = (paramInt4 + paramSharedPreferences.getInt("wakecnt2", 1)) / 2;
      i3 = (paramInt5 + paramSharedPreferences.getInt("maxnrem", 60)) / 2;
      localEditor.putInt("start2", m);
      localEditor.putInt("stop2", n);
      localEditor.putInt("quality2", i1);
      localEditor.putInt("wakecnt2", i2);
      localEditor.putInt("maxnrem", i3);
    }
  }

  private static void a(ArrayList<SportData> paramArrayList, int paramInt1, int paramInt2)
  {
    int m = paramArrayList.size();
    if ((m == 0) || (paramInt1 >= m) || (paramInt2 >= m) || (paramInt1 > paramInt2))
      return;
    if (a)
      Debug.i("sleepAnalyze", ">>>resetData[" + paramInt1 + "->" + paramInt2 + "]");
    label68: int n;
    int i1;
    if (paramInt1 <= paramInt2)
    {
      n = ((SportData)paramArrayList.get(paramInt1)).getActivity();
      i1 = ((SportData)paramArrayList.get(paramInt1)).getStep();
      if ((((SportData)paramArrayList.get(paramInt1)).getSportMode() == 4) || (((SportData)paramArrayList.get(paramInt1)).getSportMode() == 5))
      {
        if (i1 < 130)
          break label155;
        ((SportData)paramArrayList.get(paramInt1)).setMode(2);
      }
    }
    while (true)
    {
      paramInt1++;
      break label68;
      break;
      label155: if (i1 > 15)
        ((SportData)paramArrayList.get(paramInt1)).setMode(1);
      else if (n <= 1)
        ((SportData)paramArrayList.get(paramInt1)).setMode(3);
      else
        ((SportData)paramArrayList.get(paramInt1)).setMode(0);
    }
  }

  private static void a(ArrayList<SportData> paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = paramArrayList.size();
    if ((m == 0) || (paramInt1 >= m) || (paramInt2 >= m) || (paramInt1 > paramInt2));
    while (true)
    {
      return;
      if (a)
        Debug.i("DataAnalysis", ">>>modifyData[" + paramInt1 + "->" + paramInt2 + "] from " + ((SportData)paramArrayList.get(paramInt1)).getSportMode() + " to " + paramInt3);
      while (paramInt1 <= paramInt2)
      {
        if (((SportData)paramArrayList.get(paramInt1)).getSportMode() != 6)
          ((SportData)paramArrayList.get(paramInt1)).setMode(paramInt3);
        paramInt1++;
      }
    }
  }

  private static void a(ArrayList<SportData> paramArrayList, int paramInt1, int paramInt2, ArrayList<ActiveItem> paramArrayList1, boolean paramBoolean)
  {
    if (paramInt1 <= paramInt2)
    {
      int m = paramArrayList.size();
      if (paramInt1 < m)
      {
        int n = paramArrayList.size();
        if (paramInt2 < n)
          break label30;
      }
    }
    label30: ArrayList localArrayList;
    int i1;
    int i2;
    int i23;
    label213: 
    do
    {
      return;
      if (a)
        Debug.i("dataAnalysis", "filterData " + paramInt1 + "->" + paramInt2);
      localArrayList = new ArrayList();
      i1 = paramInt1 + 1;
      i2 = paramInt1;
      if (i1 <= paramInt2)
        break;
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put("start", Integer.valueOf(i2));
      localHashMap1.put("stop", Integer.valueOf(paramInt2));
      localHashMap1.put("mode", Integer.valueOf(((SportData)paramArrayList.get(i2)).getSportMode()));
      localArrayList.add(localHashMap1);
      int i3 = 1 + (paramInt2 - paramInt1);
      if (localArrayList.size() != 1)
        break label424;
      int i30 = ((SportData)paramArrayList.get(paramInt1)).getSportMode();
      if (((i30 != 1) || (i3 < 5)) && ((i30 != 2) || (i3 < 3)))
        break label1368;
      i23 = 1;
      if (i23 != 0)
      {
        if (a)
          Debug.i("dataAnalysis", "section " + paramInt1 + "->" + paramInt2);
        ActiveItem localActiveItem2 = new ActiveItem();
        localActiveItem2.start = paramInt1;
        localActiveItem2.stop = paramInt2;
        paramArrayList1.add(localActiveItem2);
      }
    }
    while (!paramBoolean);
    ActiveItem localActiveItem1 = new ActiveItem();
    localActiveItem1.flag = 1;
    paramArrayList1.add(localActiveItem1);
    return;
    if (((SportData)paramArrayList.get(i1)).getSportMode() != ((SportData)paramArrayList.get(i1 - 1)).getSportMode())
    {
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("start", Integer.valueOf(i2));
      localHashMap2.put("stop", Integer.valueOf(i1 - 1));
      localHashMap2.put("mode", Integer.valueOf(((SportData)paramArrayList.get(i2)).getSportMode()));
      localArrayList.add(localHashMap2);
    }
    for (int i31 = i1; ; i31 = i2)
    {
      i1++;
      i2 = i31;
      break;
      label424: int i4 = 0;
      int i5 = localArrayList.size();
      int i6 = 0;
      int i7 = paramInt2;
      int i8 = paramInt1;
      label443: int i24;
      int i25;
      if (i6 >= i5)
      {
        if (i4 != 0)
          break label1334;
        if (1 + (i7 - i8) < 10)
          break label1322;
        i24 = 0;
        i23 = 1;
        i25 = i8;
        if (i25 <= i7)
          break label1249;
        paramInt2 = i7;
        paramInt1 = i8;
        break label213;
      }
      int i12;
      int i9;
      int i10;
      int i11;
      if (((Integer)((HashMap)localArrayList.get(i6)).get("mode")).intValue() == 0)
      {
        i12 = 1 + (((Integer)((HashMap)localArrayList.get(i6)).get("stop")).intValue() - ((Integer)((HashMap)localArrayList.get(i6)).get("start")).intValue());
        if ((i12 <= 1) && (i6 > 0) && (i6 < i5 - 1))
        {
          int i19 = ((Integer)((HashMap)localArrayList.get(i6 - 1)).get("mode")).intValue();
          int i20 = ((Integer)((HashMap)localArrayList.get(i6 + 1)).get("mode")).intValue();
          int i21 = 1 + (((Integer)((HashMap)localArrayList.get(i6 - 1)).get("stop")).intValue() - ((Integer)((HashMap)localArrayList.get(i6 - 1)).get("start")).intValue());
          int i22 = 1 + (((Integer)((HashMap)localArrayList.get(i6 + 1)).get("stop")).intValue() - ((Integer)((HashMap)localArrayList.get(i6 + 1)).get("start")).intValue());
          if ((i21 < 3) && (i22 < 3) && (i22 + i21 < 5))
            break label1353;
          if (i19 == i20)
          {
            a(paramArrayList, ((Integer)((HashMap)localArrayList.get(i6)).get("start")).intValue(), ((Integer)((HashMap)localArrayList.get(i6)).get("start")).intValue(), i19);
            i9 = i7;
            i10 = i8;
            i11 = 1;
          }
        }
      }
      while (true)
      {
        i6++;
        i4 = i11;
        i8 = i10;
        i7 = i9;
        break label443;
        a(paramArrayList, ((Integer)((HashMap)localArrayList.get(i6)).get("start")).intValue(), ((Integer)((HashMap)localArrayList.get(i6)).get("start")).intValue(), 1);
        i9 = i7;
        i10 = i8;
        i11 = 1;
        continue;
        if ((i12 > 1) && (i6 > 0) && (i6 < i5 - 1))
        {
          int i14 = ((Integer)((HashMap)localArrayList.get(i6 - 1)).get("mode")).intValue();
          int i15 = ((Integer)((HashMap)localArrayList.get(i6 + 1)).get("mode")).intValue();
          int i16 = 1 + (((Integer)((HashMap)localArrayList.get(i6 - 1)).get("stop")).intValue() - ((Integer)((HashMap)localArrayList.get(i6 - 1)).get("start")).intValue());
          int i17 = 1 + (((Integer)((HashMap)localArrayList.get(i6 + 1)).get("stop")).intValue() - ((Integer)((HashMap)localArrayList.get(i6 + 1)).get("start")).intValue());
          if (((i16 >= 3) && (i14 == 2)) || ((i14 == 1) && (i16 >= 4)) || ((i15 == 2) && (i17 >= 3)) || ((i15 == 1) && (i17 >= 4)))
          {
            int i18 = i7;
            i10 = i8;
            i11 = 1;
            i9 = i18;
          }
        }
        else if ((i6 == i5 - 1) && (i6 > 0))
        {
          i9 = ((Integer)((HashMap)localArrayList.get(i6 - 1)).get("stop")).intValue();
          i10 = i8;
          i11 = i4;
        }
        else if ((i6 == 0) && (i6 + 1 < i5))
        {
          int i13 = ((Integer)((HashMap)localArrayList.get(i6 + 1)).get("start")).intValue();
          i11 = i4;
          i9 = i7;
          i10 = i13;
          continue;
          label1249: int i26 = ((SportData)paramArrayList.get(i25)).getSportMode();
          if ((i26 == 1) || (i26 == 2));
          for (int i27 = i24 + 1; ; i27 = i24)
          {
            if (i27 >= (1 + (i7 - i8)) / 2);
            for (int i28 = 1; ; i28 = 0)
            {
              i25++;
              int i29 = i27;
              i23 = i28;
              i24 = i29;
              break;
            }
            label1322: paramInt2 = i7;
            paramInt1 = i8;
            i23 = 0;
            break;
            label1334: i23 = 1;
            paramInt2 = i7;
            paramInt1 = i8;
            break;
          }
        }
        else
        {
          label1353: i9 = i7;
          i10 = i8;
          i11 = i4;
        }
      }
      label1368: i23 = 0;
      break label213;
    }
  }

  private static void b(ArrayList<SportData> paramArrayList, int paramInt1, int paramInt2)
  {
    int m = paramArrayList.size();
    if ((m == 0) || (paramInt1 >= m) || (paramInt2 >= m) || (paramInt1 > paramInt2))
      return;
    if (a)
      Debug.i("sleepAnalyze", ">>>setSleep[" + paramInt1 + "->" + paramInt2 + "]");
    label68: if (paramInt1 <= paramInt2)
    {
      int n = ((SportData)paramArrayList.get(paramInt1)).getActivity();
      if ((((SportData)paramArrayList.get(paramInt1)).getSportMode() != 6) && (((SportData)paramArrayList.get(paramInt1)).getSportMode() != 126))
      {
        if (n >= 6)
          break label143;
        ((SportData)paramArrayList.get(paramInt1)).setMode(5);
      }
    }
    while (true)
    {
      paramInt1++;
      break label68;
      break;
      label143: ((SportData)paramArrayList.get(paramInt1)).setMode(4);
    }
  }

  private static int c(ArrayList<SportData> paramArrayList, int paramInt1, int paramInt2)
  {
    int m = 0;
    int n = paramArrayList.size();
    int i1;
    if ((n == 0) || (paramInt1 >= n) || (paramInt2 >= n) || (paramInt1 > paramInt2))
      i1 = 0;
    int i2;
    ArrayList localArrayList1;
    int i3;
    int i4;
    int i8;
    label113: int i9;
    label172: ArrayList localArrayList2;
    int i10;
    int i11;
    int i15;
    int i16;
    int i18;
    int i20;
    int i21;
    int i19;
    while (true)
    {
      return i1;
      i2 = paramInt1;
      if (i2 <= paramInt2)
        break;
      localArrayList1 = new ArrayList();
      i3 = paramInt1 + 1;
      i4 = paramInt1;
      i1 = 0;
      if (i3 <= paramInt2)
        break label625;
      i8 = ((SportData)paramArrayList.get(i4)).getSportMode();
      if ((i8 != 5) || (paramInt2 + 1 - i4 >= 10))
        break label840;
      a(paramArrayList, i4, paramInt2, 4);
      i8 = 4;
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("start", Integer.valueOf(i4));
      localHashMap2.put("stop", Integer.valueOf(paramInt2));
      localHashMap2.put("mode", Integer.valueOf(i8));
      localArrayList1.add(localHashMap2);
      i9 = 0;
      if (i9 < localArrayList1.size())
        break label905;
      localArrayList2 = new ArrayList();
      i10 = paramInt1 + 1;
      i11 = paramInt1;
      if (i10 <= paramInt2)
        break label1112;
      int i14 = ((SportData)paramArrayList.get(i11)).getSportMode();
      HashMap localHashMap4 = new HashMap();
      localHashMap4.put("start", Integer.valueOf(i11));
      localHashMap4.put("stop", Integer.valueOf(paramInt2));
      localHashMap4.put("mode", Integer.valueOf(i14));
      localArrayList2.add(localHashMap4);
      while (m < localArrayList2.size())
      {
        i15 = ((Integer)((HashMap)localArrayList2.get(m)).get("start")).intValue();
        i16 = ((Integer)((HashMap)localArrayList2.get(m)).get("stop")).intValue();
        int i17 = ((Integer)((HashMap)localArrayList2.get(m)).get("mode")).intValue();
        i18 = 1 + (i16 - i15);
        if ((i17 != 4) || (i18 >= 10) || (m <= 0) || (m >= -1 + localArrayList2.size()))
          break label1262;
        i20 = ((Integer)((HashMap)localArrayList2.get(m - 1)).get("mode")).intValue();
        i21 = ((Integer)((HashMap)localArrayList2.get(m + 1)).get("mode")).intValue();
        if (i20 != i21)
          break label1228;
        a(paramArrayList, i15, i16, i20);
        if (i20 != 7)
          break label1262;
        i19 = i1 + i18;
        label469: m++;
        i1 = i19;
      }
    }
    int i28 = ((SportData)paramArrayList.get(i2)).getActivity();
    if (((SportData)paramArrayList.get(i2)).getSportMode() != 6)
    {
      if (((SportData)paramArrayList.get(i2)).getSportMode() != 126)
        break label547;
      ((SportData)paramArrayList.get(i2)).setMode(100);
    }
    while (true)
    {
      i2++;
      break;
      label547: if ((((SportData)paramArrayList.get(i2)).getStep() > 0) && (i28 >= 60))
        ((SportData)paramArrayList.get(i2)).setMode(7);
      else if (i28 < 6)
        ((SportData)paramArrayList.get(i2)).setMode(5);
      else
        ((SportData)paramArrayList.get(i2)).setMode(4);
    }
    label625: int i6;
    if (((SportData)paramArrayList.get(i3)).getSportMode() != ((SportData)paramArrayList.get(i3 - 1)).getSportMode())
    {
      i6 = ((SportData)paramArrayList.get(i4)).getSportMode();
      if ((i6 == 5) && (i3 - i4 < 10))
      {
        a(paramArrayList, i4, i3 - 1, 4);
        i6 = 4;
        label698: HashMap localHashMap1 = new HashMap();
        localHashMap1.put("start", Integer.valueOf(i4));
        localHashMap1.put("stop", Integer.valueOf(i3 - 1));
        localHashMap1.put("mode", Integer.valueOf(i6));
        localArrayList1.add(localHashMap1);
      }
    }
    for (int i5 = i3; ; i5 = i4)
    {
      i3++;
      i4 = i5;
      break;
      if ((i6 == 4) && (i3 - i4 >= 10))
      {
        int i7 = i1 + (i3 - i4);
        a(paramArrayList, i4, i3 - 1, 7);
        i1 = i7;
        i6 = 7;
        break label698;
      }
      if (i6 != 7)
        break label698;
      i1 += i3 - i4;
      break label698;
      label840: if ((i8 == 4) && (paramInt2 + 1 - i4 >= 10))
      {
        i1 += paramInt2 + 1 - i4;
        a(paramArrayList, i4, paramInt2, 7);
        i8 = 7;
        break label113;
      }
      if (i8 != 7)
        break label113;
      i1 += paramInt2 + 1 - i4;
      break label113;
      label905: int i22 = ((Integer)((HashMap)localArrayList1.get(i9)).get("start")).intValue();
      int i23 = ((Integer)((HashMap)localArrayList1.get(i9)).get("stop")).intValue();
      int i24 = ((Integer)((HashMap)localArrayList1.get(i9)).get("mode")).intValue();
      int i25 = 1 + (i23 - i22);
      if ((i24 != 7) && ((i24 == 4) || (i24 == 5)) && (i24 == 4) && (i25 < 10) && (i9 > 0) && (i9 < -1 + localArrayList1.size()))
      {
        int i26 = ((Integer)((HashMap)localArrayList1.get(i9 - 1)).get("mode")).intValue();
        int i27 = ((Integer)((HashMap)localArrayList1.get(i9 + 1)).get("mode")).intValue();
        if ((i26 == 5) && (i27 == 5))
          a(paramArrayList, i22, i23, 5);
      }
      i9++;
      break label172;
      label1112: if (((SportData)paramArrayList.get(i10)).getSportMode() != ((SportData)paramArrayList.get(i10 - 1)).getSportMode())
      {
        int i13 = ((SportData)paramArrayList.get(i11)).getSportMode();
        HashMap localHashMap3 = new HashMap();
        localHashMap3.put("start", Integer.valueOf(i11));
        localHashMap3.put("stop", Integer.valueOf(i10 - 1));
        localHashMap3.put("mode", Integer.valueOf(i13));
        localArrayList2.add(localHashMap3);
      }
      for (int i12 = i10; ; i12 = i11)
      {
        i10++;
        i11 = i12;
        break;
        label1228: if ((i20 == 7) || (i21 == 7))
        {
          a(paramArrayList, i15, i16, 7);
          i19 = i1 + i18;
          break label469;
        }
        label1262: i19 = i1;
        break label469;
      }
    }
  }

  public static void dataPostProcess(Context paramContext, DaySportData paramDaySportData1, DaySportData paramDaySportData2, DaySportData paramDaySportData3)
  {
    int m = 0;
    int n = 0;
    double d1 = 0.0D;
    int[] arrayOfInt = { j.length, 3 };
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, arrayOfInt);
    double d2 = 0.0D;
    long l = System.currentTimeMillis();
    if (paramDaySportData1 != null);
    for (ArrayList localArrayList1 = Utils.copy(paramDaySportData1.data()); ; localArrayList1 = null)
    {
      if (paramDaySportData2 != null);
      for (ArrayList localArrayList2 = Utils.copy(paramDaySportData2.data()); ; localArrayList2 = null)
      {
        ArrayList localArrayList3 = null;
        if (paramDaySportData3 != null)
          localArrayList3 = Utils.copy(paramDaySportData3.data());
        if ((localArrayList2 == null) || (localArrayList2.size() <= 0))
          return;
        boolean bool1;
        ArrayList localArrayList4;
        if ((localArrayList1 == null) || (localArrayList1.size() <= 0))
        {
          bool1 = true;
          localArrayList4 = new ArrayList();
        }
        while (true)
        {
          localArrayList4.addAll(localArrayList2);
          if ((localArrayList3 == null) || (localArrayList3.size() <= 0));
          ChartData.UserSleepModify localUserSleepModify1;
          ChartData.UserSleepModify localUserSleepModify2;
          ArrayList localArrayList5;
          PersonInfo localPersonInfo;
          for (boolean bool2 = true; ; bool2 = false)
          {
            localUserSleepModify1 = ChartData.getDynamicData().getUserSleepModify(paramDaySportData2.getSportDay());
            if (localUserSleepModify1 != null)
            {
              Log.i("sleepM", "####ref=" + localUserSleepModify1.sleepStart + ", " + localUserSleepModify1.sleepEnd);
              if (((localUserSleepModify1.sleepStart < -1440) || (localUserSleepModify1.sleepStart >= 1440)) && ((localUserSleepModify1.sleepEnd < -1440) || (localUserSleepModify1.sleepEnd >= 1440)))
              {
                Debug.i("sleepAnalyze", "sleepReference not valid!!!");
                localUserSleepModify1 = null;
              }
            }
            localUserSleepModify2 = null;
            if (!bool2)
            {
              localUserSleepModify2 = ChartData.getDynamicData().getUserSleepModify(paramDaySportData3.getSportDay());
              if (localUserSleepModify2 != null)
              {
                Log.i("sleepM", "####ref2=" + localUserSleepModify2.sleepStart + ", " + localUserSleepModify2.sleepEnd);
                if (((localUserSleepModify2.sleepStart < -1440) || (localUserSleepModify2.sleepStart >= 1440)) && ((localUserSleepModify2.sleepEnd < -1440) || (localUserSleepModify2.sleepEnd >= 1440)))
                {
                  Debug.i("sleepAnalyze", "sleepReference2 not valid!!!");
                  localUserSleepModify2 = null;
                }
              }
            }
            localArrayList5 = new ArrayList();
            if (a)
              Debug.i("DataAnalysis", "last=" + paramDaySportData1 + ",curr=" + paramDaySportData2 + ",next=" + paramDaySportData3);
            if (a)
              Debug.i("sleepAnalyze", ">>Analyze " + paramDaySportData2.getYear() + ":" + paramDaySportData2.getMonth() + ":" + paramDaySportData2.getDay());
            localPersonInfo = Keeper.readPersonInfo();
            if ((localPersonInfo != null) && (localPersonInfo.height > 0))
              break;
            throw new NullPointerException("Keeper.readPersonInfo");
            localArrayList4.addAll(localArrayList3);
          }
          double d3 = 0.42D * localPersonInfo.height / 100.0D;
          int i1 = Keeper.readPersonInfo().getDaySportGoalSteps();
          if (i1 < 0)
            throw new NullPointerException("Keeper.readDaySportGoals");
          if (paramContext != null);
          for (SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(String.valueOf(localPersonInfo.uid), 0); ; localSharedPreferences = null)
          {
            Calendar localCalendar1 = Calendar.getInstance();
            localCalendar1.clear();
            localCalendar1.set(paramDaySportData2.getYear(), paramDaySportData2.getMonth(), paramDaySportData2.getDay(), 0, 0);
            int i2 = localCalendar1.get(7);
            if ((i2 == 7) || (i2 == 1));
            for (boolean bool3 = false; ; bool3 = true)
            {
              int i3;
              label665: int i4;
              label675: int i5;
              label685: b localb1;
              int i6;
              label724: int i7;
              int i105;
              int i106;
              int i107;
              int i108;
              int i109;
              SharedPreferences.Editor localEditor;
              int i110;
              int i111;
              int i112;
              int i113;
              int i114;
              label975: int i8;
              label1096: int i10;
              label1129: int i11;
              label1139: int i12;
              label1166: int i14;
              int i15;
              int i102;
              label1309: int i16;
              if (bool1)
              {
                i3 = 0;
                if (!bool1)
                  break label2585;
                i4 = 1080;
                if (!bool1)
                  break label2593;
                i5 = -1440;
                localb1 = a(localArrayList4, i3, i4, i5, bool2, bool1, localUserSleepModify1, 1440);
                if (localb1.f <= 0)
                  break label2599;
                i6 = -1 + localb1.f;
                i7 = localb1.h;
                if ((!bool1) && (localb1.a < localb1.b))
                {
                  i105 = localb1.a;
                  i106 = localb1.b;
                  i107 = localb1.e;
                  i108 = localb1.f;
                  i109 = localb1.g;
                  localEditor = localSharedPreferences.edit();
                  if (localSharedPreferences != null)
                  {
                    if (!bool3)
                      break label2605;
                    i110 = (i105 + localSharedPreferences.getInt("start1", 1440)) / 2;
                    i111 = (i106 + localSharedPreferences.getInt("stop1", 1920)) / 2;
                    i112 = (i107 * 100 / (1 + (i106 - i105)) + localSharedPreferences.getInt("quality1", 85)) / 2;
                    i113 = (i108 + localSharedPreferences.getInt("wakecnt1", 1)) / 2;
                    i114 = (i109 + localSharedPreferences.getInt("maxnrem", 60)) / 2;
                    localEditor.putInt("start1", i110);
                    localEditor.putInt("stop1", i111);
                    localEditor.putInt("quality1", i112);
                    localEditor.putInt("wakecnt1", i113);
                    localEditor.putInt("maxnrem", i114);
                    if (a)
                      Debug.i("sleepAnalyze", "storeRef: " + i110 + "->" + i111 + ",quality=" + i112 + ",wakecnt=" + i113 + ",maxnrem=" + i114 + ",store1=" + bool3);
                    localEditor.commit();
                  }
                }
                i8 = 1 + localb1.d;
                if (localb1.a == localb1.b)
                {
                  if (!bool1)
                    break label2780;
                  i8 = 0;
                }
                int i9 = -1 + Math.min(i4, localArrayList4.size());
                a(localArrayList4, i8, i9);
                if (!bool1)
                  break label2788;
                i10 = 1080;
                if (!bool1)
                  break label2796;
                i11 = 2520;
                if (bool2)
                  i11 = i10 - 1080 + localArrayList2.size();
                if (!bool1)
                  break label2804;
                i12 = 0;
                int i13 = i11 - 1;
                b localb2 = a(localArrayList4, i10, i13, i12, bool2, bool1, localUserSleepModify2, 2880);
                if (bool2)
                {
                  if (a)
                    Debug.i("DataAnalysis", "no next day, so reset " + localb2.c + "->" + localb2.d);
                  if (localb2.c < localb2.d)
                  {
                    int i103 = localb2.c;
                    int i104 = localb2.d;
                    a(localArrayList4, i103, i104);
                  }
                }
                i14 = localb1.a;
                i15 = localb1.b;
                if (i14 != i15)
                  break label5449;
                if (!bool1)
                  break label2812;
                i102 = 0;
                i16 = i102;
              }
              for (int i17 = i102; ; i17 = i14)
              {
                if (a)
                  Debug.i("sleepAnalyze", "sleep " + i17 + "->" + i16);
                if (a)
                  Debug.i("DataAnalysis", ">>>>height=" + localPersonInfo.height + ",weight=" + localPersonInfo.weight);
                int i18 = 0;
                label1411: ArrayList localArrayList6;
                int i19;
                if (i18 >= j.length)
                {
                  localArrayList6 = new ArrayList();
                  if (!bool1)
                    break label2929;
                  i19 = 0;
                  label1437: if (!bool1)
                    break label2952;
                }
                int i22;
                int i23;
                int i24;
                int i25;
                ArrayList localArrayList7;
                double d4;
                int i26;
                int i27;
                int i28;
                int i29;
                int i57;
                label1625: int i58;
                int i59;
                int i60;
                int i61;
                int i62;
                ArrayList localArrayList8;
                int i63;
                int i64;
                ArrayList localArrayList9;
                int i65;
                label1783: int i83;
                label1807: label1838: int i68;
                SleepInfo localSleepInfo;
                Calendar localCalendar2;
                Calendar localCalendar3;
                label2050: int i79;
                label2069: int i82;
                label2146: int i80;
                label2210: label2293: ArrayList localArrayList10;
                int i81;
                label2952: for (int i20 = 0; ; i20 = 1440)
                {
                  int i21 = Math.min(i20 + 1440, localArrayList4.size());
                  if (a)
                    Debug.i("sleepAnalyze", "startAnalyze=" + i19 + ",stopSleep=" + i16 + ",time:" + paramDaySportData2.getMonth() + ":" + paramDaySportData2.getDay());
                  i22 = 0;
                  i23 = 0;
                  i24 = 0;
                  i25 = 0;
                  localArrayList7 = new ArrayList();
                  d4 = 1.5D;
                  i26 = 0;
                  i27 = i19 + 1;
                  i28 = i19;
                  i29 = -1;
                  if (i27 < i21)
                    break label2960;
                  if (i24 > 0)
                  {
                    StageSteps localStageSteps2 = new StageSteps();
                    localStageSteps2.time = i25;
                    localStageSteps2.steps = i24;
                    localStageSteps2.distance = i22;
                    if (i23 <= 60)
                      break label3905;
                    i57 = i23 / 60;
                    localStageSteps2.count = i57;
                    n += localStageSteps2.count;
                    localArrayList5.add(localStageSteps2);
                  }
                  HashMap localHashMap2 = new HashMap();
                  localHashMap2.put("start", Integer.valueOf(i28));
                  localHashMap2.put("stop", Integer.valueOf(i21 - 1));
                  localHashMap2.put("mode", Integer.valueOf(((SportData)localArrayList4.get(i28)).getSportMode()));
                  localArrayList6.add(localHashMap2);
                  i58 = 0;
                  i59 = 0;
                  i60 = 0;
                  i61 = 0;
                  i62 = 0;
                  if (i62 < localArrayList6.size())
                    break label3911;
                  localArrayList8 = new ArrayList();
                  i63 = i19 + 1;
                  i64 = i19;
                  if (i63 < i21)
                    break label4326;
                  localArrayList9 = new ArrayList();
                  i65 = 1;
                  if (i65 < localArrayList8.size())
                    break label4574;
                  if (localArrayList8.size() > 0)
                  {
                    i83 = i21 - 1;
                    if (i83 > ((Integer)((HashMap)localArrayList8.get(-1 + localArrayList8.size())).get("stop")).intValue())
                      break label4676;
                    boolean bool5 = false;
                    if (i29 > 0)
                    {
                      int i85 = 1 + ((Integer)((HashMap)localArrayList8.get(-1 + localArrayList8.size())).get("stop")).intValue();
                      bool5 = false;
                      if (i29 >= i85)
                      {
                        bool5 = false;
                        if (i29 <= i83)
                          bool5 = true;
                      }
                    }
                    int i84 = 1 + ((Integer)((HashMap)localArrayList8.get(-1 + localArrayList8.size())).get("stop")).intValue();
                    a(localArrayList4, i84, i83, localArrayList9, bool5);
                  }
                  i68 = 0;
                  if (i68 < localArrayList9.size())
                    break label4700;
                  if (a)
                    Debug.i("DataAnalysis", "filter done");
                  localSleepInfo = new SleepInfo();
                  StepsInfo localStepsInfo = new StepsInfo();
                  localCalendar2 = Calendar.getInstance();
                  localCalendar3 = Calendar.getInstance();
                  localCalendar2.clear();
                  localCalendar3.clear();
                  if (!bool1)
                    break label5109;
                  localCalendar2.set(paramDaySportData2.getYear(), paramDaySportData2.getMonth(), paramDaySportData2.getDay(), 0, 0);
                  localCalendar3.set(paramDaySportData2.getYear(), paramDaySportData2.getMonth(), paramDaySportData2.getDay(), 0, 0);
                  if (i16 <= i17)
                    break label5150;
                  i79 = 1 + (i16 - i17) - i7;
                  if (i79 <= 0)
                    break label5163;
                  localCalendar2.add(12, i17);
                  localCalendar3.add(12, i16 + 1);
                  localSleepInfo.setStartDate(localCalendar2.getTime());
                  localSleepInfo.setStopDate(localCalendar3.getTime());
                  localSleepInfo.setSleepCount(i79);
                  localSleepInfo.setRemCount(i61);
                  localSleepInfo.setNonRemCount(i79 - i61);
                  if (i7 >= 0)
                    break label5156;
                  i82 = 0;
                  localSleepInfo.setAwakeCount(i82);
                  localSleepInfo.setAwakeNum(i6);
                  localCalendar2.add(12, localb1.c - i17);
                  localCalendar3.add(12, localb1.d - i16);
                  localSleepInfo.setStartOnBedDate(localCalendar2.getTime());
                  localSleepInfo.setStopOnBedDate(localCalendar3.getTime());
                  localSleepInfo.setHasSleep(localb1.i);
                  if ((localUserSleepModify1 != null) && (localUserSleepModify1.sleepStart > -2147483648))
                    localSleepInfo.setUserSleepStart(localUserSleepModify1.sleepStart);
                  if ((localUserSleepModify1 != null) && (localUserSleepModify1.sleepEnd > -2147483648))
                    localSleepInfo.setUserSleepEnd(localUserSleepModify1.sleepEnd);
                  localStepsInfo.setStepsCount(m);
                  if (n < i59)
                    break label5233;
                  i80 = n - i59;
                  localStepsInfo.setStepsTimeCount(i80);
                  localStepsInfo.setRunTimeCount(i59);
                  localStepsInfo.setDistance((int)d1);
                  localStepsInfo.setCalories((int)d2);
                  localStepsInfo.setActMinutes(n);
                  localStepsInfo.setContinuesActive(i58);
                  localStepsInfo.setStageSteps(localArrayList5);
                  localStepsInfo.setActiveList(localArrayList9);
                  if (a)
                    Debug.i("DataAnalysis", "Sleep(" + localCalendar2.toString() + "->" + localCalendar3.toString() + "), sleeps=" + i79 + ",REM=" + i61 + ",NREM=" + i60 + ",Steps=" + m + ",totalStepMins=" + n + ",totalRunMins=" + i59);
                  paramDaySportData2.setStepsInfo(localStepsInfo);
                  paramDaySportData2.setSleepInfo(localSleepInfo);
                  paramDaySportData2.setAnalysisData(localArrayList2);
                  paramDaySportData2.setNeedPostProcess(false);
                  if ((localUserSleepModify1 != null) && (!bool1) && (localUserSleepModify1.sleepStart < 0))
                  {
                    localArrayList10 = new ArrayList(1440);
                    i81 = 0;
                    if (i81 < 1440)
                      break label5240;
                    label2526: paramDaySportData1.setAnalysisData(localArrayList10);
                    paramDaySportData1.setNeedPostProcess(false);
                  }
                  if (!a)
                    break;
                  Debug.i("DataAnalysis", "used " + (System.currentTimeMillis() - l) + "ms!");
                  return;
                  i3 = 1080;
                  break label665;
                  label2585: i4 = 2520;
                  break label675;
                  label2593: i5 = 0;
                  break label685;
                  label2599: i6 = 0;
                  break label724;
                  label2605: i110 = (i105 + localSharedPreferences.getInt("start2", 1440)) / 2;
                  i111 = (i106 + localSharedPreferences.getInt("stop2", 1920)) / 2;
                  i112 = (i107 * 100 / (1 + (i106 - i105)) + localSharedPreferences.getInt("quality2", 85)) / 2;
                  i113 = (i108 + localSharedPreferences.getInt("wakecnt2", 1)) / 2;
                  i114 = (i109 + localSharedPreferences.getInt("maxnrem", 60)) / 2;
                  localEditor.putInt("start2", i110);
                  localEditor.putInt("stop2", i111);
                  localEditor.putInt("quality2", i112);
                  localEditor.putInt("wakecnt2", i113);
                  localEditor.putInt("maxnrem", i114);
                  break label975;
                  label2780: i8 = 1440;
                  break label1096;
                  label2788: i10 = 2520;
                  break label1129;
                  label2796: i11 = 3960;
                  break label1139;
                  label2804: i12 = 1440;
                  break label1166;
                  label2812: i102 = 1440;
                  break label1309;
                  arrayOfDouble[i18][0] = ((int)(1609.0D * j[i18][1] / (60.0D * d3)));
                  if (a)
                    Debug.i("DataAnalysis", "alist " + i18 + ":" + arrayOfDouble[i18][0]);
                  arrayOfDouble[i18][1] = j[i18][0];
                  arrayOfDouble[i18][2] = j[i18][1];
                  i18++;
                  break label1411;
                  label2929: if (i17 < 1440)
                  {
                    i19 = i17;
                    break label1437;
                  }
                  i19 = 1440;
                  break label1437;
                }
                label2960: int i30 = ((SportData)localArrayList4.get(i27)).getStep();
                int i31 = ((SportData)localArrayList4.get(i27)).getSportMode();
                a locala = new a((byte)0);
                int i43;
                int i44;
                label3119: double d8;
                label3138: double d9;
                int i45;
                label3148: label3159: double d10;
                int i46;
                int i47;
                label3290: int i48;
                int i49;
                label3351: int i50;
                label3381: int i51;
                int i36;
                int i39;
                int i38;
                double d5;
                int i33;
                int i34;
                double d6;
                int i32;
                double d7;
                int i35;
                int i37;
                if ((i31 >= 0) && (i31 <= 7) && (i31 != 6) && (i30 > 0) && (i27 >= i20))
                {
                  i43 = m + i30;
                  if (a)
                    Debug.i("DataAnalysis", "i=" + i27 + ":steps=" + i30);
                  if (a)
                    Debug.i("DataAnalysis", "alist size=" + arrayOfDouble.length);
                  if (i30 > 120)
                  {
                    i44 = 125;
                    if (i30 > 90)
                      break label3633;
                    d8 = 0.9D * (d3 * i30);
                    d9 = d1 + d8;
                    i45 = 0;
                    if (i45 < -1 + k.length)
                      break label3652;
                    locala.a = d8;
                    locala.b = (d8 * (2.2046D * localPersonInfo.weight * k[i45][1]) / (60.0D * k[i45][0]));
                    d10 = d2 + locala.b;
                    if (a)
                      Debug.i("DataAnalysis", "iDistance=" + d8 + ",p=" + i45 + ",cals=" + d10);
                    i46 = i26 + i30;
                    if ((i46 < i1) || (i29 >= 0))
                      break label5395;
                    i47 = i27;
                    i48 = (i27 - i20) / 60;
                    if (i48 == i25)
                      break label3743;
                    StageSteps localStageSteps1 = new StageSteps();
                    localStageSteps1.time = i25;
                    localStageSteps1.steps = i24;
                    localStageSteps1.distance = i22;
                    if (i23 <= 60)
                      break label3672;
                    i49 = i23 / 60;
                    localStageSteps1.count = i49;
                    if (i24 <= 0)
                      break label5388;
                    i50 = n + localStageSteps1.count;
                    localArrayList5.add(localStageSteps1);
                    i51 = (int)d8;
                    if ((i30 <= 0) || (i30 > 60))
                      break label3678;
                    int i52 = (int)(i30 / d4);
                    i36 = i46;
                    i39 = i50;
                    i38 = i52;
                    d5 = d4;
                    i33 = i48;
                    i34 = i30;
                    d6 = d10;
                    i32 = i51;
                    d7 = d9;
                    i35 = i47;
                    i37 = i43;
                  }
                }
                while (true)
                {
                  label3451: localArrayList7.add(locala);
                  int i40 = ((SportData)localArrayList4.get(i27)).getSportMode();
                  int i41 = i27 - 1;
                  if (i40 != ((SportData)localArrayList4.get(i41)).getSportMode())
                  {
                    HashMap localHashMap1 = new HashMap();
                    localHashMap1.put("start", Integer.valueOf(i28));
                    localHashMap1.put("stop", Integer.valueOf(i27 - 1));
                    localHashMap1.put("mode", Integer.valueOf(((SportData)localArrayList4.get(i28)).getSportMode()));
                    localArrayList6.add(localHashMap1);
                  }
                  label3633: label3652: label3672: label3678: int i53;
                  label3743: int i54;
                  label3995: label5150: for (int i42 = i27; ; i42 = i28)
                  {
                    i27++;
                    i28 = i42;
                    d1 = d7;
                    n = i39;
                    m = i37;
                    i23 = i38;
                    i22 = i32;
                    d2 = d6;
                    i26 = i36;
                    i24 = i34;
                    i29 = i35;
                    i25 = i33;
                    d4 = d5;
                    break;
                    i44 = 100;
                    break label3119;
                    d8 = d3 * i30 * i30 / i44;
                    break label3138;
                    if (d8 <= k[i45][0])
                      break label3159;
                    i45++;
                    break label3148;
                    i49 = 1;
                    break label3351;
                    if (i30 <= 60)
                      break label5341;
                    d5 = (d4 + i30 / 60) / 2.0D;
                    i33 = i48;
                    i34 = i30;
                    i39 = i50;
                    i32 = i51;
                    d6 = d10;
                    i35 = i47;
                    d7 = d9;
                    i37 = i43;
                    i38 = 60;
                    i36 = i46;
                    break label3451;
                    i53 = i24 + i30;
                    i54 = i22 + (int)d8;
                    if ((i30 > 0) && (i30 <= 60))
                    {
                      int i56 = i23 + (int)(i30 / d4);
                      i32 = i54;
                      i39 = n;
                      d6 = d10;
                      d7 = d9;
                      i37 = i43;
                      double d11 = d4;
                      i33 = i25;
                      i34 = i53;
                      i35 = i47;
                      i36 = i46;
                      i38 = i56;
                      d5 = d11;
                      break label3451;
                    }
                    if (i30 <= 60)
                      break label5294;
                    int i55 = i23 + 60;
                    d5 = (d4 + i30 / 60) / 2.0D;
                    i33 = i25;
                    i34 = i53;
                    i39 = n;
                    i35 = i47;
                    i36 = i46;
                    i38 = i55;
                    i32 = i54;
                    d6 = d10;
                    d7 = d9;
                    i37 = i43;
                    break label3451;
                    label3905: i57 = 1;
                    break label1625;
                    label3911: int i91 = ((Integer)((HashMap)localArrayList6.get(i62)).get("start")).intValue();
                    int i92 = ((Integer)((HashMap)localArrayList6.get(i62)).get("stop")).intValue();
                    int i93 = ((Integer)((HashMap)localArrayList6.get(i62)).get("mode")).intValue();
                    int i94;
                    int i95;
                    int i96;
                    int i97;
                    int i98;
                    if ((i93 == 3) || (i93 == 0))
                    {
                      i94 = 0;
                      if (a)
                        Debug.i("sleepAnalyze", "mList[" + i62 + "]:[" + i91 + "->" + i92 + "],mode=" + i93);
                      if ((i93 == 6) || (i93 == 7))
                        break label4307;
                      if ((i93 != 4) && (i93 != 5))
                        break label4200;
                      if (i92 > i16)
                        break label4307;
                      if (4 != i93)
                        break label4169;
                      int i100 = i61 + (1 + (i92 - i91));
                      i95 = i58;
                      i96 = i59;
                      i97 = i60;
                      i98 = i100;
                    }
                    while (true)
                    {
                      i62++;
                      i60 = i97;
                      i61 = i98;
                      i58 = i95;
                      i59 = i96;
                      break;
                      if ((i93 == 1) || (i93 == 2))
                      {
                        i94 = 1;
                        break label3995;
                      }
                      i94 = 2;
                      break label3995;
                      label4169: int i99 = i60 + (1 + (i92 - i91));
                      i95 = i58;
                      i96 = i59;
                      i97 = i99;
                      i98 = i61;
                      continue;
                      label4200: if (1 == i94)
                      {
                        int i101 = 1 + (i92 - i91);
                        if ((i20 > i91) && (i92 >= i20))
                          i101 = 1 + (i92 - i20);
                        if (i93 == 2)
                          i59 += i101;
                        i58 = Math.max(i58, i101);
                      }
                      if ((i93 == 3) && (i92 - i91 < 30))
                      {
                        a(localArrayList4, i91, i92, 0);
                        ((HashMap)localArrayList6.get(i62)).put("mode", Integer.valueOf(0));
                      }
                      label4307: i95 = i58;
                      i96 = i59;
                      i97 = i60;
                      i98 = i61;
                    }
                    label4326: int i86 = ((SportData)localArrayList4.get(i63)).getSportMode();
                    int i87 = i63 - 1;
                    HashMap localHashMap3;
                    if (i86 != ((SportData)localArrayList4.get(i87)).getSportMode())
                    {
                      int i89 = i63 - 1;
                      int i90 = ((SportData)localArrayList4.get(i89)).getSportMode();
                      if (((i90 == 0) && (i63 - i64 >= 10)) || ((i90 != 1) && (i90 != 2) && (i90 != 0)))
                      {
                        if (a)
                          Debug.i("dataAnalysis", "intv " + i64 + "->" + (i63 - 1));
                        localHashMap3 = new HashMap();
                        if (i64 < i20)
                          break label4526;
                        localHashMap3.put("start", Integer.valueOf(i64));
                        localHashMap3.put("stop", Integer.valueOf(i63 - 1));
                        localArrayList8.add(localHashMap3);
                      }
                    }
                    label4512: for (int i88 = i63; ; i88 = i64)
                    {
                      while (true)
                      {
                        i63++;
                        i64 = i88;
                        break;
                        label4526: if (i63 - 1 < i20)
                          break label4512;
                        localHashMap3.put("start", Integer.valueOf(i20));
                        localHashMap3.put("stop", Integer.valueOf(i63 - 1));
                        localArrayList8.add(localHashMap3);
                        break label4512;
                        label4574: int i66 = 1 + ((Integer)((HashMap)localArrayList8.get(i65 - 1)).get("stop")).intValue();
                        int i67 = -1 + ((Integer)((HashMap)localArrayList8.get(i65)).get("start")).intValue();
                        boolean bool4 = false;
                        if (i29 > 0)
                        {
                          bool4 = false;
                          if (i29 >= i66)
                          {
                            bool4 = false;
                            if (i29 <= i67)
                              bool4 = true;
                          }
                        }
                        a(localArrayList4, i66, i67, localArrayList9, bool4);
                        i65++;
                        break label1783;
                        label4676: if (((SportData)localArrayList4.get(i83)).getSportMode() != 126)
                          break label1838;
                        i83--;
                        break label1807;
                        label4700: int i69;
                        int i70;
                        int i71;
                        int i72;
                        int i73;
                        double d12;
                        double d13;
                        int i74;
                        int i75;
                        int i77;
                        label4833: ActiveItem localActiveItem2;
                        if (((ActiveItem)localArrayList9.get(i68)).flag == 0)
                        {
                          i69 = ((ActiveItem)localArrayList9.get(i68)).start;
                          i70 = ((ActiveItem)localArrayList9.get(i68)).stop;
                          i71 = 0;
                          i72 = 1;
                          i73 = 0;
                          d12 = 0.0D;
                          d13 = 0.0D;
                          i74 = 0;
                          i75 = i69;
                          if (i75 <= i70)
                            break label4958;
                          if (i71 == 1 + (i70 - i69))
                            i72 = 2;
                          ((ActiveItem)localArrayList9.get(i68)).mode = i72;
                          ActiveItem localActiveItem1 = (ActiveItem)localArrayList9.get(i68);
                          if (i69 < 1440)
                            break label5095;
                          i77 = i69 - 1440;
                          localActiveItem1.start = i77;
                          localActiveItem2 = (ActiveItem)localArrayList9.get(i68);
                          if (i70 < 1440)
                            break label5102;
                        }
                        label4958: label5095: label5102: for (int i78 = i70 - 1440; ; i78 = i70)
                        {
                          localActiveItem2.stop = i78;
                          ((ActiveItem)localArrayList9.get(i68)).distance = ((int)d12);
                          ((ActiveItem)localArrayList9.get(i68)).calories = ((int)d13);
                          ((ActiveItem)localArrayList9.get(i68)).runtime = i71;
                          ((ActiveItem)localArrayList9.get(i68)).steps = i74;
                          ((ActiveItem)localArrayList9.get(i68)).activeTime = i73;
                          i68++;
                          break;
                          int i76 = -1 + (i75 - i19);
                          d12 += ((a)localArrayList7.get(i76)).a;
                          d13 += ((a)localArrayList7.get(i76)).b;
                          if (((SportData)localArrayList4.get(i75)).getSportMode() == 2)
                          {
                            i71++;
                            i73++;
                          }
                          while (true)
                          {
                            i74 += ((SportData)localArrayList4.get(i75)).getStep();
                            i75++;
                            break;
                            if (((SportData)localArrayList4.get(i75)).getSportMode() == 1)
                              i73++;
                            else if (((SportData)localArrayList4.get(i75)).getSportMode() == 0)
                              i72 = 0;
                          }
                          i77 = i69;
                          break label4833;
                        }
                        label5109: localCalendar2.set(paramDaySportData1.getYear(), paramDaySportData1.getMonth(), paramDaySportData1.getDay(), 0, 0);
                        localCalendar3.set(paramDaySportData1.getYear(), paramDaySportData1.getMonth(), paramDaySportData1.getDay(), 0, 0);
                        break label2050;
                        i79 = 0;
                        break label2069;
                        label5156: i82 = i7;
                        break label2146;
                        label5163: if (!bool1)
                        {
                          localCalendar2.add(5, 1);
                          localCalendar3.add(5, 1);
                        }
                        localSleepInfo.setStartDate(localCalendar2.getTime());
                        localSleepInfo.setStopDate(localCalendar3.getTime());
                        localSleepInfo.setStartOnBedDate(localCalendar2.getTime());
                        localSleepInfo.setStopOnBedDate(localCalendar3.getTime());
                        localSleepInfo.setNosleepReason(SleepInfo.NOSLEEP_NONWEAR);
                        break label2210;
                        label5233: i80 = n;
                        break label2293;
                        try
                        {
                          label5240: localArrayList10.add(((SportData)localArrayList4.get(i81)).copy());
                          i81++;
                        }
                        catch (CloneNotSupportedException localCloneNotSupportedException)
                        {
                          localCloneNotSupportedException.printStackTrace();
                          localArrayList10.clear();
                        }
                      }
                      break label2526;
                    }
                  }
                  label5294: d5 = d4;
                  i32 = i54;
                  i33 = i25;
                  i34 = i53;
                  d6 = d10;
                  i36 = i46;
                  i35 = i47;
                  d7 = d9;
                  i37 = i43;
                  i38 = i23;
                  i39 = n;
                  continue;
                  label5341: d5 = d4;
                  i36 = i46;
                  i33 = i48;
                  i34 = i30;
                  i38 = i23;
                  i32 = i51;
                  i39 = i50;
                  d6 = d10;
                  i35 = i47;
                  d7 = d9;
                  i37 = i43;
                  continue;
                  label5388: i50 = n;
                  break label3381;
                  label5395: i47 = i29;
                  break label3290;
                  d5 = d4;
                  i32 = i22;
                  i33 = i25;
                  i34 = i24;
                  i35 = i29;
                  d6 = d2;
                  i36 = i26;
                  d7 = d1;
                  i37 = m;
                  i38 = i23;
                  i39 = n;
                }
                label5449: i16 = i15;
              }
            }
          }
          localArrayList4 = localArrayList1;
          bool1 = false;
        }
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.analysis.DataAnalysis
 * JD-Core Version:    0.6.2
 */