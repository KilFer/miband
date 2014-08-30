package org.achartengine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import org.achartengine.util.IndexXYMap;
import org.achartengine.util.XYEntry;

public class XYSeries
  implements Serializable
{
  private static final double h = 1.0E-012D;
  private String a;
  private final IndexXYMap<Double, Double> b = new IndexXYMap();
  private double c = 1.7976931348623157E+308D;
  private double d = -1.797693134862316E+308D;
  private double e = 1.7976931348623157E+308D;
  private double f = -1.797693134862316E+308D;
  private final int g;
  private List<String> i = new ArrayList();
  private final IndexXYMap<Double, Double> j = new IndexXYMap();

  public XYSeries(String paramString)
  {
    this(paramString, 0);
  }

  public XYSeries(String paramString, int paramInt)
  {
    this.a = paramString;
    this.g = paramInt;
    a();
  }

  private void a()
  {
    this.c = 1.7976931348623157E+308D;
    this.d = -1.797693134862316E+308D;
    this.e = 1.7976931348623157E+308D;
    this.f = -1.797693134862316E+308D;
    int k = getItemCount();
    for (int m = 0; m < k; m++)
      a(getX(m), getY(m));
  }

  private void a(double paramDouble1, double paramDouble2)
  {
    this.c = Math.min(this.c, paramDouble1);
    this.d = Math.max(this.d, paramDouble1);
    this.e = Math.min(this.e, paramDouble2);
    this.f = Math.max(this.f, paramDouble2);
  }

  public void add(double paramDouble1, double paramDouble2)
  {
    try
    {
      while (this.b.get(Double.valueOf(paramDouble1)) != null)
        paramDouble1 += getPadding();
      this.b.put(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2));
      a(paramDouble1, paramDouble2);
      return;
    }
    finally
    {
    }
  }

  public void add(int paramInt, double paramDouble1, double paramDouble2)
  {
    try
    {
      while (this.b.get(Double.valueOf(paramDouble1)) != null)
        paramDouble1 += getPadding();
      this.b.put(paramInt, Double.valueOf(paramDouble1), Double.valueOf(paramDouble2));
      a(paramDouble1, paramDouble2);
      return;
    }
    finally
    {
    }
  }

  public void addAnnotation(String paramString, double paramDouble1, double paramDouble2)
  {
    this.i.add(paramString);
    this.j.put(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2));
  }

  public void clear()
  {
    try
    {
      this.b.clear();
      this.j.clear();
      a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAnnotationAt(int paramInt)
  {
    return (String)this.i.get(paramInt);
  }

  public int getAnnotationCount()
  {
    return this.i.size();
  }

  public double getAnnotationX(int paramInt)
  {
    return ((Double)this.j.getXByIndex(paramInt)).doubleValue();
  }

  public double getAnnotationY(int paramInt)
  {
    return ((Double)this.j.getYByIndex(paramInt)).doubleValue();
  }

  public int getIndexForKey(double paramDouble)
  {
    return this.b.getIndexForKey(Double.valueOf(paramDouble));
  }

  public int getItemCount()
  {
    try
    {
      int k = this.b.size();
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public double getMaxX()
  {
    return this.d;
  }

  public double getMaxY()
  {
    return this.f;
  }

  public double getMinX()
  {
    return this.c;
  }

  public double getMinY()
  {
    return this.e;
  }

  protected double getPadding()
  {
    return 1.0E-012D;
  }

  public SortedMap<Double, Double> getRange(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    if (paramBoolean);
    try
    {
      SortedMap localSortedMap2 = this.b.headMap(Double.valueOf(paramDouble1));
      if (!localSortedMap2.isEmpty())
        paramDouble1 = ((Double)localSortedMap2.lastKey()).doubleValue();
      SortedMap localSortedMap3 = this.b.tailMap(Double.valueOf(paramDouble2));
      Iterator localIterator;
      Double localDouble;
      if (!localSortedMap3.isEmpty())
      {
        localIterator = localSortedMap3.keySet().iterator();
        localDouble = (Double)localIterator.next();
        if (!localIterator.hasNext())
          break label139;
      }
      label139: double d1;
      for (paramDouble2 = ((Double)localIterator.next()).doubleValue(); ; paramDouble2 += d1)
      {
        SortedMap localSortedMap1 = this.b.subMap(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2));
        return localSortedMap1;
        d1 = localDouble.doubleValue();
      }
    }
    finally
    {
    }
  }

  public int getScaleNumber()
  {
    return this.g;
  }

  public String getTitle()
  {
    return this.a;
  }

  public double getX(int paramInt)
  {
    try
    {
      double d1 = ((Double)this.b.getXByIndex(paramInt)).doubleValue();
      return d1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public double getY(int paramInt)
  {
    try
    {
      double d1 = ((Double)this.b.getYByIndex(paramInt)).doubleValue();
      return d1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void remove(int paramInt)
  {
    try
    {
      XYEntry localXYEntry = this.b.removeByIndex(paramInt);
      double d1 = ((Double)localXYEntry.getKey()).doubleValue();
      double d2 = ((Double)localXYEntry.getValue()).doubleValue();
      if ((d1 == this.c) || (d1 == this.d) || (d2 == this.e) || (d2 == this.f))
        a();
      return;
    }
    finally
    {
    }
  }

  public void removeAnnotation(int paramInt)
  {
    this.i.remove(paramInt);
    this.j.removeByIndex(paramInt);
  }

  public void setTitle(String paramString)
  {
    this.a = paramString;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.model.XYSeries
 * JD-Core Version:    0.6.2
 */