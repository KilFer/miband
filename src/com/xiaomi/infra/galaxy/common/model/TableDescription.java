package com.xiaomi.infra.galaxy.common.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class TableDescription
{
  private String accessMethod;
  private List<AttributeDefinition> attributeDefinitions;
  private Long creationDateTime;
  private Set<String> grantedApps;
  private Long itemCount;
  private List<String> keySchema;
  private String tableName;
  private Long tableSizeBytes;
  private String tableStatus;
  private String tableType;

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    TableDescription localTableDescription;
    int i;
    label43: int j;
    label53: int m;
    label107: int n;
    label117: int i2;
    label171: int i3;
    label181: int i5;
    label254: int i6;
    label264: int i8;
    label318: int i9;
    label328: int i11;
    label382: int i12;
    label392: boolean bool5;
    do
    {
      int i13;
      do
      {
        boolean bool6;
        do
        {
          int i10;
          do
          {
            boolean bool7;
            do
            {
              int i7;
              do
              {
                boolean bool3;
                do
                {
                  boolean bool8;
                  do
                  {
                    int i4;
                    do
                    {
                      boolean bool9;
                      do
                      {
                        int i1;
                        do
                        {
                          boolean bool10;
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
                                bool2 = paramObject instanceof TableDescription;
                                bool1 = false;
                              }
                              while (!bool2);
                              localTableDescription = (TableDescription)paramObject;
                              if (localTableDescription.getAttributeDefinitions() != null)
                                break;
                              i = 1;
                              if (getAttributeDefinitions() != null)
                                break label507;
                              j = 1;
                              k = i ^ j;
                              bool1 = false;
                            }
                            while (k != 0);
                            if (localTableDescription.getAttributeDefinitions() == null)
                              break;
                            bool10 = localTableDescription.getAttributeDefinitions().equals(getAttributeDefinitions());
                            bool1 = false;
                          }
                          while (!bool10);
                          if (localTableDescription.getTableName() != null)
                            break label513;
                          m = 1;
                          if (getTableName() != null)
                            break label519;
                          n = 1;
                          i1 = m ^ n;
                          bool1 = false;
                        }
                        while (i1 != 0);
                        if (localTableDescription.getTableName() == null)
                          break;
                        bool9 = localTableDescription.getTableName().equals(getTableName());
                        bool1 = false;
                      }
                      while (!bool9);
                      if (localTableDescription.getTableStatus() != null)
                        break label525;
                      i2 = 1;
                      if (getTableStatus() != null)
                        break label531;
                      i3 = 1;
                      i4 = i2 ^ i3;
                      bool1 = false;
                    }
                    while (i4 != 0);
                    if (localTableDescription.getTableStatus() == null)
                      break;
                    bool8 = localTableDescription.getTableStatus().equals(getTableStatus());
                    bool1 = false;
                  }
                  while (!bool8);
                  bool3 = localTableDescription.getCreationDateTime() < getCreationDateTime();
                  bool1 = false;
                }
                while (bool3);
                if (localTableDescription.getTableSizeBytes() != null)
                  break label537;
                i5 = 1;
                if (getTableSizeBytes() != null)
                  break label543;
                i6 = 1;
                i7 = i5 ^ i6;
                bool1 = false;
              }
              while (i7 != 0);
              if (localTableDescription.getTableSizeBytes() == null)
                break;
              bool7 = localTableDescription.getTableSizeBytes().equals(getTableSizeBytes());
              bool1 = false;
            }
            while (!bool7);
            if (localTableDescription.getItemCount() != null)
              break label549;
            i8 = 1;
            if (getItemCount() != null)
              break label555;
            i9 = 1;
            i10 = i8 ^ i9;
            bool1 = false;
          }
          while (i10 != 0);
          if (localTableDescription.getItemCount() == null)
            break;
          bool6 = localTableDescription.getItemCount().equals(getItemCount());
          bool1 = false;
        }
        while (!bool6);
        if (localTableDescription.getTableType() != null)
          break label561;
        i11 = 1;
        if (getTableType() != null)
          break label567;
        i12 = 1;
        i13 = i11 ^ i12;
        bool1 = false;
      }
      while (i13 != 0);
      if (localTableDescription.getTableType() == null)
        break;
      bool5 = localTableDescription.getTableType().equals(getTableType());
      bool1 = false;
    }
    while (!bool5);
    int i14;
    if (localTableDescription.getAccessMethod() == null)
    {
      i14 = 1;
      label446: if (getAccessMethod() != null)
        break label579;
    }
    label513: label519: label525: label531: label537: label543: label549: label555: label561: label567: label579: for (int i15 = 1; ; i15 = 0)
    {
      int i16 = i14 ^ i15;
      bool1 = false;
      if (i16 != 0)
        break;
      if (localTableDescription.getAccessMethod() != null)
      {
        boolean bool4 = localTableDescription.getAccessMethod().equals(getAccessMethod());
        bool1 = false;
        if (!bool4)
          break;
      }
      return true;
      i = 0;
      break label43;
      label507: j = 0;
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
      break label254;
      i6 = 0;
      break label264;
      i8 = 0;
      break label318;
      i9 = 0;
      break label328;
      i11 = 0;
      break label382;
      i12 = 0;
      break label392;
      i14 = 0;
      break label446;
    }
  }

  public String getAccessMethod()
  {
    return this.accessMethod;
  }

  public List<AttributeDefinition> getAttributeDefinitions()
  {
    return this.attributeDefinitions;
  }

  public long getCreationDateTime()
  {
    return this.creationDateTime.longValue();
  }

  public Set<String> getGrantedApps()
  {
    return this.grantedApps;
  }

  public Long getItemCount()
  {
    return this.itemCount;
  }

  public List<String> getKeySchema()
  {
    return this.keySchema;
  }

  public String getTableName()
  {
    return this.tableName;
  }

  public Long getTableSizeBytes()
  {
    return this.tableSizeBytes;
  }

  public String getTableStatus()
  {
    return this.tableStatus;
  }

  public String getTableType()
  {
    return this.tableType;
  }

  public int hashCode()
  {
    int i;
    int k;
    label26: int n;
    label44: int i2;
    label73: int i4;
    label93: int i6;
    label113: int i7;
    int i8;
    if (getAttributeDefinitions() == null)
    {
      i = 0;
      int j = 31 * (i + 31);
      if (getTableName() != null)
        break label154;
      k = 0;
      int m = 31 * (k + j);
      if (getTableStatus() != null)
        break label165;
      n = 0;
      int i1 = 31 * (31 * (n + m) + (int)getCreationDateTime());
      if (getTableSizeBytes() != null)
        break label177;
      i2 = 0;
      int i3 = 31 * (i2 + i1);
      if (getItemCount() != null)
        break label189;
      i4 = 0;
      int i5 = 31 * (i4 + i3);
      if (getTableType() != null)
        break label201;
      i6 = 0;
      i7 = 31 * (i6 + i5);
      String str = getAccessMethod();
      i8 = 0;
      if (str != null)
        break label213;
    }
    while (true)
    {
      return i7 + i8;
      i = getAttributeDefinitions().hashCode();
      break;
      label154: k = getTableName().hashCode();
      break label26;
      label165: n = getTableStatus().hashCode();
      break label44;
      label177: i2 = getTableSizeBytes().hashCode();
      break label73;
      label189: i4 = getItemCount().hashCode();
      break label93;
      label201: i6 = getTableType().hashCode();
      break label113;
      label213: i8 = getAccessMethod().hashCode();
    }
  }

  public void setAccessMethod(String paramString)
  {
    this.accessMethod = paramString;
  }

  public void setAttributeDefinitions(Collection<AttributeDefinition> paramCollection)
  {
    if (paramCollection == null)
    {
      this.attributeDefinitions = null;
      return;
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    localArrayList.addAll(paramCollection);
    this.attributeDefinitions = localArrayList;
  }

  public void setCreationDateTime(long paramLong)
  {
    this.creationDateTime = Long.valueOf(paramLong);
  }

  public void setGrantedApps(Set<String> paramSet)
  {
    this.grantedApps = paramSet;
  }

  public void setItemCount(Long paramLong)
  {
    this.itemCount = paramLong;
  }

  public void setKeySchema(Collection<String> paramCollection)
  {
    if (paramCollection == null)
    {
      this.keySchema = null;
      return;
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    localArrayList.addAll(paramCollection);
    this.keySchema = localArrayList;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }

  public void setTableSizeBytes(Long paramLong)
  {
    this.tableSizeBytes = paramLong;
  }

  public void setTableStatus(String paramString)
  {
    this.tableStatus = paramString;
  }

  public void setTableType(String paramString)
  {
    this.tableType = paramString;
  }

  public TableDescription withAccessMethod(AccessMethod paramAccessMethod)
  {
    setAccessMethod(paramAccessMethod.name());
    return this;
  }

  public TableDescription withAttributeDefinitions(Collection<AttributeDefinition> paramCollection)
  {
    if (paramCollection == null)
    {
      this.attributeDefinitions = null;
      return this;
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    localArrayList.addAll(paramCollection);
    this.attributeDefinitions = localArrayList;
    return this;
  }

  public TableDescription withAttributeDefinitions(AttributeDefinition[] paramArrayOfAttributeDefinition)
  {
    if (getAttributeDefinitions() == null)
      setAttributeDefinitions(new ArrayList(paramArrayOfAttributeDefinition.length));
    int i = paramArrayOfAttributeDefinition.length;
    for (int j = 0; j < i; j++)
    {
      AttributeDefinition localAttributeDefinition = paramArrayOfAttributeDefinition[j];
      getAttributeDefinitions().add(localAttributeDefinition);
    }
    return this;
  }

  public TableDescription withCreationDateTime(long paramLong)
  {
    this.creationDateTime = Long.valueOf(paramLong);
    return this;
  }

  public TableDescription withGrantedApps(Set<String> paramSet)
  {
    setGrantedApps(paramSet);
    return this;
  }

  public TableDescription withItemCount(Long paramLong)
  {
    this.itemCount = paramLong;
    return this;
  }

  public TableDescription withKeySchema(Collection<String> paramCollection)
  {
    if (paramCollection == null)
    {
      this.keySchema = null;
      return this;
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    localArrayList.addAll(paramCollection);
    this.keySchema = localArrayList;
    return this;
  }

  public TableDescription withKeySchema(String[] paramArrayOfString)
  {
    if (getKeySchema() == null)
      setKeySchema(new ArrayList(paramArrayOfString.length));
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString[j];
      getKeySchema().add(str);
    }
    return this;
  }

  public TableDescription withTableName(String paramString)
  {
    this.tableName = paramString;
    return this;
  }

  public TableDescription withTableSizeBytes(Long paramLong)
  {
    this.tableSizeBytes = paramLong;
    return this;
  }

  public TableDescription withTableStatus(TableStatus paramTableStatus)
  {
    this.tableStatus = paramTableStatus.toString();
    return this;
  }

  public TableDescription withTableStatus(String paramString)
  {
    this.tableStatus = paramString;
    return this;
  }

  public TableDescription withTableType(TableType paramTableType)
  {
    setTableType(paramTableType.name());
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.TableDescription
 * JD-Core Version:    0.6.2
 */