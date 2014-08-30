package org.achartengine.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MathHelper
{
  public static final double NULL_VALUE = 1.7976931348623157E+308D;
  private static final NumberFormat a = NumberFormat.getNumberInstance();

  private static double a(double paramDouble)
  {
    double d1 = 5.0D;
    int i = (int)Math.floor(Math.log10(paramDouble));
    double d2 = paramDouble * Math.pow(10.0D, -i);
    if (d2 > d1)
      d1 = 10.0D;
    while (true)
    {
      return d1 * Math.pow(10.0D, i);
      if (d2 <= 2.0D)
        if (d2 > 1.0D)
          d1 = 2.0D;
        else
          d1 = d2;
    }
  }

  private static double[] a(double paramDouble1, double paramDouble2, int paramInt)
  {
    if (Math.abs(paramDouble1 - paramDouble2) < 1.000000011686097E-007D)
      return new double[] { paramDouble1, paramDouble1, 0.0D };
    if (paramDouble1 > paramDouble2);
    for (int i = 1; ; i = 0)
    {
      double d2 = Math.abs(paramDouble2 - paramDouble1) / paramInt;
      int j = (int)Math.floor(Math.log10(d2));
      double d3 = d2 * Math.pow(10.0D, -j);
      if (d3 > 5.0D)
        d3 = 10.0D;
      double d4;
      double d5;
      double d6;
      while (true)
      {
        d4 = d3 * Math.pow(10.0D, j);
        d5 = d4 * Math.ceil(paramDouble2 / d4);
        d6 = d4 * Math.floor(paramDouble1 / d4);
        if (i == 0)
          break;
        double[] arrayOfDouble = new double[3];
        arrayOfDouble[0] = d6;
        arrayOfDouble[1] = d5;
        arrayOfDouble[2] = (d4 * -1.0D);
        return arrayOfDouble;
        if (d3 > 2.0D)
          d3 = 5.0D;
        else if (d3 > 1.0D)
          d3 = 2.0D;
      }
      return new double[] { d5, d6, d4 };
      double d1 = paramDouble2;
      paramDouble2 = paramDouble1;
      paramDouble1 = d1;
    }
  }

  public static List<Double> getLabels(double paramDouble1, double paramDouble2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt <= 0)
      return localArrayList;
    a.setMaximumFractionDigits(5);
    double[] arrayOfDouble;
    if (Math.abs(paramDouble1 - paramDouble2) < 1.000000011686097E-007D)
      arrayOfDouble = new double[] { paramDouble1, paramDouble1, 0.0D };
    while (true)
    {
      int i = 1 + (int)((arrayOfDouble[1] - arrayOfDouble[0]) / arrayOfDouble[2]);
      int j = 0;
      label76: double d1;
      if (j < i)
        d1 = arrayOfDouble[0] + j * arrayOfDouble[2];
      try
      {
        double d2 = a.parse(a.format(d1)).doubleValue();
        d1 = d2;
        localArrayList.add(Double.valueOf(d1));
        j++;
        break label76;
        if (paramDouble1 > paramDouble2)
        {
          k = 1;
          double d4 = Math.abs(paramDouble2 - paramDouble1) / paramInt;
          int m = (int)Math.floor(Math.log10(d4));
          double d5 = d4 * Math.pow(10.0D, -m);
          if (d5 > 5.0D)
            d5 = 10.0D;
          double d6;
          double d7;
          double d8;
          while (true)
          {
            d6 = d5 * Math.pow(10.0D, m);
            d7 = d6 * Math.ceil(paramDouble2 / d6);
            d8 = d6 * Math.floor(paramDouble1 / d6);
            if (k == 0)
              break label306;
            arrayOfDouble = new double[3];
            arrayOfDouble[0] = d8;
            arrayOfDouble[1] = d7;
            arrayOfDouble[2] = (d6 * -1.0D);
            break;
            if (d5 > 2.0D)
              d5 = 5.0D;
            else if (d5 > 1.0D)
              d5 = 2.0D;
          }
          label306: arrayOfDouble = new double[] { d7, d8, d6 };
          continue;
          return localArrayList;
        }
      }
      catch (ParseException localParseException)
      {
        while (true)
        {
          continue;
          double d3 = paramDouble2;
          paramDouble2 = paramDouble1;
          paramDouble1 = d3;
          int k = 0;
        }
      }
    }
  }

  public static double[] minmax(List<Double> paramList)
  {
    if (paramList.size() == 0)
      return new double[2];
    double d1 = ((Double)paramList.get(0)).doubleValue();
    int i = paramList.size();
    double d2 = d1;
    double d3 = d1;
    for (int j = 1; j < i; j++)
    {
      double d4 = ((Double)paramList.get(j)).doubleValue();
      d3 = Math.min(d3, d4);
      d2 = Math.max(d2, d4);
    }
    return new double[] { d3, d2 };
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.util.MathHelper
 * JD-Core Version:    0.6.2
 */