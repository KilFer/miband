package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import java.util.ArrayList;
import java.util.List;

public class ScanRequest extends Request
{
  private List<String> attributes;
  private ComplexCondition condition;
  private int limit;
  private boolean reverse = false;
  private RowKey startKey;
  private RowKey stopKey;
  private String tableName;
  private String userId;

  public void addAttribute(String paramString)
  {
    if (this.attributes == null)
      this.attributes = new ArrayList();
    this.attributes.add(paramString);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    ScanRequest localScanRequest;
    int i;
    label43: int j;
    label53: int m;
    label107: int n;
    label117: int i2;
    label171: int i3;
    label181: int i5;
    label235: int i6;
    label245: boolean bool6;
    do
    {
      int i7;
      do
      {
        boolean bool7;
        do
        {
          int i4;
          do
          {
            boolean bool8;
            do
            {
              int i1;
              do
              {
                boolean bool9;
                do
                {
                  int k;
                  do
                  {
                    boolean bool2;
                    do
                    {
                      do
                      {
                        return bool1;
                        bool1 = false;
                      }
                      while (paramObject == null);
                      bool2 = paramObject instanceof ScanRequest;
                      bool1 = false;
                    }
                    while (!bool2);
                    localScanRequest = (ScanRequest)paramObject;
                    if (localScanRequest.getTableName() != null)
                      break;
                    i = 1;
                    if (getTableName() != null)
                      break label404;
                    j = 1;
                    k = i ^ j;
                    bool1 = false;
                  }
                  while (k != 0);
                  if (localScanRequest.getTableName() == null)
                    break;
                  bool9 = localScanRequest.getTableName().equals(getTableName());
                  bool1 = false;
                }
                while (!bool9);
                if (localScanRequest.getAttributes() != null)
                  break label410;
                m = 1;
                if (getAttributes() != null)
                  break label416;
                n = 1;
                i1 = m ^ n;
                bool1 = false;
              }
              while (i1 != 0);
              if (localScanRequest.getAttributes() == null)
                break;
              bool8 = localScanRequest.getAttributes().equals(getAttributes());
              bool1 = false;
            }
            while (!bool8);
            if (localScanRequest.getCondition() != null)
              break label422;
            i2 = 1;
            if (getCondition() != null)
              break label428;
            i3 = 1;
            i4 = i2 ^ i3;
            bool1 = false;
          }
          while (i4 != 0);
          if (localScanRequest.getCondition() == null)
            break;
          bool7 = localScanRequest.getCondition().equals(getCondition());
          bool1 = false;
        }
        while (!bool7);
        if (localScanRequest.getStartKey() != null)
          break label434;
        i5 = 1;
        if (getStartKey() != null)
          break label440;
        i6 = 1;
        i7 = i5 ^ i6;
        bool1 = false;
      }
      while (i7 != 0);
      if (localScanRequest.getStartKey() == null)
        break;
      bool6 = localScanRequest.getStartKey().equals(getStartKey());
      bool1 = false;
    }
    while (!bool6);
    int i8;
    if (localScanRequest.getStopKey() == null)
    {
      i8 = 1;
      label299: if (getStopKey() != null)
        break label452;
    }
    label404: label410: label416: label422: label428: label434: label440: label452: for (int i9 = 1; ; i9 = 0)
    {
      int i10 = i8 ^ i9;
      bool1 = false;
      if (i10 != 0)
        break;
      if (localScanRequest.getStopKey() != null)
      {
        boolean bool5 = localScanRequest.getStopKey().equals(getStopKey());
        bool1 = false;
        if (!bool5)
          break;
      }
      int i11 = localScanRequest.getLimit();
      int i12 = getLimit();
      bool1 = false;
      if (i11 != i12)
        break;
      boolean bool3 = localScanRequest.getReverse();
      boolean bool4 = getReverse();
      bool1 = false;
      if (bool3 != bool4)
        break;
      return true;
      i = 0;
      break label43;
      j = 0;
      break label53;
      m = 0;
      break label107;
      n = 0;
      break label117;
      i2 = 0;
      break label171;
      i3 = 0;
      break label181;
      i5 = 0;
      break label235;
      i6 = 0;
      break label245;
      i8 = 0;
      break label299;
    }
  }

  public List<String> getAttributes()
  {
    return this.attributes;
  }

  public ComplexCondition getCondition()
  {
    return this.condition;
  }

  public int getLimit()
  {
    return this.limit;
  }

  public boolean getReverse()
  {
    return this.reverse;
  }

  public RowKey getStartKey()
  {
    return this.startKey;
  }

  public RowKey getStopKey()
  {
    return this.stopKey;
  }

  public String getTableName()
  {
    return this.tableName;
  }

  public String getUserId()
  {
    return this.userId;
  }

  public int hashCode()
  {
    int i;
    int k;
    label26: int n;
    label44: int i2;
    label64: int i3;
    int i4;
    if (getTableName() == null)
    {
      i = 0;
      int j = 31 * (i + 31);
      if (getAttributes() != null)
        break label113;
      k = 0;
      int m = 31 * (k + j);
      if (getCondition() != null)
        break label124;
      n = 0;
      int i1 = 31 * (n + m);
      if (getStartKey() != null)
        break label136;
      i2 = 0;
      i3 = 31 * (i2 + i1);
      RowKey localRowKey = getStopKey();
      i4 = 0;
      if (localRowKey != null)
        break label148;
    }
    while (true)
    {
      return 31 * (i3 + i4) + getLimit();
      i = getTableName().hashCode();
      break;
      label113: k = getAttributes().hashCode();
      break label26;
      label124: n = getCondition().hashCode();
      break label44;
      label136: i2 = getStartKey().hashCode();
      break label64;
      label148: i4 = getStopKey().hashCode();
    }
  }

  public BasicGalaxyRequest internalGetGalaxyRequest(String paramString, APILevel paramAPILevel)
  {
    BasicGalaxyRequest localBasicGalaxyRequest = new BasicGalaxyRequest(this, "Galaxy");
    TargetAction localTargetAction = new TargetAction();
    localTargetAction.setApiVersion(GalaxyVersion.getVersion());
    localTargetAction.setLevel(paramAPILevel);
    localTargetAction.setOperation(Operation.Scan);
    localTargetAction.setServiceName("Galaxy");
    localBasicGalaxyRequest.addHeader("X-XiaoMi-Action", localTargetAction.format());
    super.setRequestContent(localBasicGalaxyRequest, paramString);
    return localBasicGalaxyRequest;
  }

  public void setAttributes(List<String> paramList)
  {
    this.attributes = paramList;
  }

  public void setCondition(ComplexCondition paramComplexCondition)
  {
    this.condition = paramComplexCondition;
  }

  public void setLimit(int paramInt)
  {
    this.limit = paramInt;
  }

  public void setReverse(boolean paramBoolean)
  {
    this.reverse = paramBoolean;
  }

  public void setStartKey(RowKey paramRowKey)
  {
    this.startKey = paramRowKey;
  }

  public void setStopKey(RowKey paramRowKey)
  {
    this.stopKey = paramRowKey;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }

  public void validate()
  {
    Verifier.validateTableName(this.tableName, false);
    Verifier.validateKeyValues(this.startKey, false);
    Verifier.validateKeyValues(this.stopKey, false);
    Verifier.validateAttributeNames(this.attributes, false);
    if (this.condition != null)
      this.condition.check(new CollisionCheckStack());
  }

  public ScanRequest withAttributes(List<String> paramList)
  {
    setAttributes(paramList);
    return this;
  }

  public ScanRequest withCondition(ComplexCondition paramComplexCondition)
  {
    setCondition(paramComplexCondition);
    return this;
  }

  public ScanRequest withLimit(int paramInt)
  {
    setLimit(paramInt);
    return this;
  }

  public ScanRequest withReverse(boolean paramBoolean)
  {
    setReverse(paramBoolean);
    return this;
  }

  public ScanRequest withStartKey(RowKey paramRowKey)
  {
    setStartKey(paramRowKey);
    return this;
  }

  public ScanRequest withStopKey(RowKey paramRowKey)
  {
    setStopKey(paramRowKey);
    return this;
  }

  public ScanRequest withTableName(String paramString)
  {
    setTableName(paramString);
    return this;
  }

  public ScanRequest withUserId(String paramString)
  {
    setUserId(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.ScanRequest
 * JD-Core Version:    0.6.2
 */