package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateTableRequest extends Request
{
  private String accessMethod;
  private List<AttributeDefinition> attributeDefinitions;
  private List<String> keySchema;
  private String tableName;
  private String tableType;

  public CreateTableRequest()
  {
  }

  public CreateTableRequest(String paramString, List<String> paramList)
  {
    setTableName(paramString);
    setKeySchema(paramList);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    CreateTableRequest localCreateTableRequest;
    int i;
    label43: int j;
    label53: int m;
    label107: int n;
    label117: int i2;
    label171: int i3;
    label181: int i5;
    label235: int i6;
    label245: boolean bool4;
    do
    {
      int i7;
      do
      {
        boolean bool5;
        do
        {
          int i4;
          do
          {
            boolean bool6;
            do
            {
              int i1;
              do
              {
                boolean bool7;
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
                      bool2 = paramObject instanceof CreateTableRequest;
                      bool1 = false;
                    }
                    while (!bool2);
                    localCreateTableRequest = (CreateTableRequest)paramObject;
                    if (localCreateTableRequest.getAttributeDefinitions() != null)
                      break;
                    i = 1;
                    if (getAttributeDefinitions() != null)
                      break label360;
                    j = 1;
                    k = i ^ j;
                    bool1 = false;
                  }
                  while (k != 0);
                  if (localCreateTableRequest.getAttributeDefinitions() == null)
                    break;
                  bool7 = localCreateTableRequest.getAttributeDefinitions().equals(getAttributeDefinitions());
                  bool1 = false;
                }
                while (!bool7);
                if (localCreateTableRequest.getTableName() != null)
                  break label366;
                m = 1;
                if (getTableName() != null)
                  break label372;
                n = 1;
                i1 = m ^ n;
                bool1 = false;
              }
              while (i1 != 0);
              if (localCreateTableRequest.getTableName() == null)
                break;
              bool6 = localCreateTableRequest.getTableName().equals(getTableName());
              bool1 = false;
            }
            while (!bool6);
            if (localCreateTableRequest.getKeySchema() != null)
              break label378;
            i2 = 1;
            if (getKeySchema() != null)
              break label384;
            i3 = 1;
            i4 = i2 ^ i3;
            bool1 = false;
          }
          while (i4 != 0);
          if (localCreateTableRequest.getKeySchema() == null)
            break;
          bool5 = localCreateTableRequest.getKeySchema().equals(getKeySchema());
          bool1 = false;
        }
        while (!bool5);
        if (localCreateTableRequest.getTableType() != null)
          break label390;
        i5 = 1;
        if (getTableType() != null)
          break label396;
        i6 = 1;
        i7 = i5 ^ i6;
        bool1 = false;
      }
      while (i7 != 0);
      if (localCreateTableRequest.getTableType() == null)
        break;
      bool4 = localCreateTableRequest.getTableType().equals(getTableType());
      bool1 = false;
    }
    while (!bool4);
    int i8;
    if (localCreateTableRequest.getAccessMethod() == null)
    {
      i8 = 1;
      label299: if (getAccessMethod() != null)
        break label408;
    }
    label384: label390: label396: label408: for (int i9 = 1; ; i9 = 0)
    {
      int i10 = i8 ^ i9;
      bool1 = false;
      if (i10 != 0)
        break;
      if (localCreateTableRequest.getAccessMethod() != null)
      {
        boolean bool3 = localCreateTableRequest.getAccessMethod().equals(getAccessMethod());
        bool1 = false;
        if (!bool3)
          break;
      }
      return true;
      i = 0;
      break label43;
      label360: j = 0;
      break label53;
      label366: m = 0;
      break label107;
      label372: n = 0;
      break label117;
      label378: i2 = 0;
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

  public String getAccessMethod()
  {
    return this.accessMethod;
  }

  public List<AttributeDefinition> getAttributeDefinitions()
  {
    return this.attributeDefinitions;
  }

  public List<String> getKeySchema()
  {
    return this.keySchema;
  }

  public String getTableName()
  {
    return this.tableName;
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
    label64: int i3;
    int i4;
    if (getAttributeDefinitions() == null)
    {
      i = 0;
      int j = 31 * (i + 31);
      if (getTableName() != null)
        break label105;
      k = 0;
      int m = 31 * (k + j);
      if (getKeySchema() != null)
        break label116;
      n = 0;
      int i1 = 31 * (n + m);
      if (getTableType() != null)
        break label128;
      i2 = 0;
      i3 = 31 * (i2 + i1);
      String str = getAccessMethod();
      i4 = 0;
      if (str != null)
        break label140;
    }
    while (true)
    {
      return i3 + i4;
      i = getAttributeDefinitions().hashCode();
      break;
      label105: k = getTableName().hashCode();
      break label26;
      label116: n = getKeySchema().hashCode();
      break label44;
      label128: i2 = getTableType().hashCode();
      break label64;
      label140: i4 = getAccessMethod().hashCode();
    }
  }

  public BasicGalaxyRequest internalGetGalaxyRequest(String paramString, APILevel paramAPILevel)
  {
    BasicGalaxyRequest localBasicGalaxyRequest = new BasicGalaxyRequest(this, "Galaxy");
    TargetAction localTargetAction = new TargetAction();
    localTargetAction.setApiVersion(GalaxyVersion.getVersion());
    localTargetAction.setLevel(APILevel.Developer);
    localTargetAction.setOperation(Operation.CreateTable);
    localTargetAction.setServiceName("Galaxy");
    localBasicGalaxyRequest.addHeader("X-XiaoMi-Action", localTargetAction.format());
    super.setRequestContent(localBasicGalaxyRequest, paramString);
    return localBasicGalaxyRequest;
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

  public void setAttributeDefinitions(List<AttributeDefinition> paramList)
  {
    this.attributeDefinitions = paramList;
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

  public void setKeySchema(List<String> paramList)
  {
    this.keySchema = paramList;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }

  public void setTableType(String paramString)
  {
    this.tableType = paramString;
  }

  // ERROR //
  public void validate()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/xiaomi/infra/galaxy/common/model/CreateTableRequest:tableName	Ljava/lang/String;
    //   4: invokestatic 151	com/xiaomi/infra/galaxy/common/model/Verifier:validateTableName	(Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 62	com/xiaomi/infra/galaxy/common/model/CreateTableRequest:tableType	Ljava/lang/String;
    //   11: invokestatic 157	com/xiaomi/infra/galaxy/common/model/TableType:fromValue	(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/TableType;
    //   14: astore_2
    //   15: aload_0
    //   16: getfield 54	com/xiaomi/infra/galaxy/common/model/CreateTableRequest:accessMethod	Ljava/lang/String;
    //   19: invokestatic 162	com/xiaomi/infra/galaxy/common/model/AccessMethod:fromValue	(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;
    //   22: astore 4
    //   24: aload_2
    //   25: getstatic 166	com/xiaomi/infra/galaxy/common/model/TableType:USER	Lcom/xiaomi/infra/galaxy/common/model/TableType;
    //   28: if_acmpne +84 -> 112
    //   31: aload 4
    //   33: getstatic 170	com/xiaomi/infra/galaxy/common/model/AccessMethod:LoginReadLoginWrite	Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;
    //   36: if_acmpeq +76 -> 112
    //   39: new 172	com/xiaomi/infra/galaxy/common/GalaxyClientException
    //   42: dup
    //   43: getstatic 178	com/xiaomi/infra/galaxy/common/constants/ReturnCode:ACCESS_METHOD_IS_INVALID	Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;
    //   46: new 180	java/lang/StringBuilder
    //   49: dup
    //   50: ldc 182
    //   52: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   55: getstatic 170	com/xiaomi/infra/galaxy/common/model/AccessMethod:LoginReadLoginWrite	Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;
    //   58: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: ldc 190
    //   63: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: getfield 54	com/xiaomi/infra/galaxy/common/model/CreateTableRequest:accessMethod	Ljava/lang/String;
    //   70: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokespecial 199	com/xiaomi/infra/galaxy/common/GalaxyClientException:<init>	(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V
    //   79: athrow
    //   80: astore_1
    //   81: new 172	com/xiaomi/infra/galaxy/common/GalaxyClientException
    //   84: dup
    //   85: getstatic 202	com/xiaomi/infra/galaxy/common/constants/ReturnCode:TABLE_TYPE_IS_INVALID	Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;
    //   88: aload_0
    //   89: getfield 62	com/xiaomi/infra/galaxy/common/model/CreateTableRequest:tableType	Ljava/lang/String;
    //   92: invokespecial 199	com/xiaomi/infra/galaxy/common/GalaxyClientException:<init>	(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V
    //   95: athrow
    //   96: astore_3
    //   97: new 172	com/xiaomi/infra/galaxy/common/GalaxyClientException
    //   100: dup
    //   101: getstatic 178	com/xiaomi/infra/galaxy/common/constants/ReturnCode:ACCESS_METHOD_IS_INVALID	Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;
    //   104: aload_0
    //   105: getfield 54	com/xiaomi/infra/galaxy/common/model/CreateTableRequest:accessMethod	Ljava/lang/String;
    //   108: invokespecial 199	com/xiaomi/infra/galaxy/common/GalaxyClientException:<init>	(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V
    //   111: athrow
    //   112: aload_0
    //   113: getfield 56	com/xiaomi/infra/galaxy/common/model/CreateTableRequest:attributeDefinitions	Ljava/util/List;
    //   116: ifnull +15 -> 131
    //   119: aload_0
    //   120: getfield 56	com/xiaomi/infra/galaxy/common/model/CreateTableRequest:attributeDefinitions	Ljava/util/List;
    //   123: invokeinterface 206 1 0
    //   128: ifeq +14 -> 142
    //   131: new 172	com/xiaomi/infra/galaxy/common/GalaxyClientException
    //   134: dup
    //   135: getstatic 209	com/xiaomi/infra/galaxy/common/constants/ReturnCode:ATTRIBUTE_DEFINITIONS_IS_NULL	Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;
    //   138: invokespecial 212	com/xiaomi/infra/galaxy/common/GalaxyClientException:<init>	(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V
    //   141: athrow
    //   142: new 214	java/util/HashSet
    //   145: dup
    //   146: invokespecial 215	java/util/HashSet:<init>	()V
    //   149: astore 5
    //   151: aload_0
    //   152: getfield 56	com/xiaomi/infra/galaxy/common/model/CreateTableRequest:attributeDefinitions	Ljava/util/List;
    //   155: invokeinterface 219 1 0
    //   160: astore 6
    //   162: aload 6
    //   164: invokeinterface 224 1 0
    //   169: ifeq +118 -> 287
    //   172: aload 6
    //   174: invokeinterface 228 1 0
    //   179: checkcast 230	com/xiaomi/infra/galaxy/common/model/AttributeDefinition
    //   182: astore 11
    //   184: aload 11
    //   186: invokevirtual 232	com/xiaomi/infra/galaxy/common/model/AttributeDefinition:validate	()V
    //   189: aload 11
    //   191: invokevirtual 235	com/xiaomi/infra/galaxy/common/model/AttributeDefinition:getAttributeName	()Ljava/lang/String;
    //   194: astore 12
    //   196: aload 5
    //   198: aload 12
    //   200: invokeinterface 240 2 0
    //   205: ifeq +16 -> 221
    //   208: new 172	com/xiaomi/infra/galaxy/common/GalaxyClientException
    //   211: dup
    //   212: getstatic 243	com/xiaomi/infra/galaxy/common/constants/ReturnCode:DUPLICATE_ATTRIBUTE_NAME	Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;
    //   215: aload 12
    //   217: invokespecial 199	com/xiaomi/infra/galaxy/common/GalaxyClientException:<init>	(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V
    //   220: athrow
    //   221: aload 11
    //   223: invokevirtual 246	com/xiaomi/infra/galaxy/common/model/AttributeDefinition:getAttributeType	()Ljava/lang/String;
    //   226: invokestatic 251	com/xiaomi/infra/galaxy/common/model/AttributeType:fromValue	(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeType;
    //   229: pop
    //   230: aload 5
    //   232: aload 12
    //   234: invokeinterface 254 2 0
    //   239: pop
    //   240: goto -78 -> 162
    //   243: astore 13
    //   245: new 172	com/xiaomi/infra/galaxy/common/GalaxyClientException
    //   248: dup
    //   249: getstatic 257	com/xiaomi/infra/galaxy/common/constants/ReturnCode:ATTRIBUTE_TYPE_IS_INVALID	Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;
    //   252: new 180	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   259: aload 12
    //   261: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc_w 260
    //   267: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aconst_null
    //   271: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   274: ldc_w 262
    //   277: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokespecial 199	com/xiaomi/infra/galaxy/common/GalaxyClientException:<init>	(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V
    //   286: athrow
    //   287: aload_0
    //   288: getfield 58	com/xiaomi/infra/galaxy/common/model/CreateTableRequest:keySchema	Ljava/util/List;
    //   291: ifnonnull +4 -> 295
    //   294: return
    //   295: new 214	java/util/HashSet
    //   298: dup
    //   299: invokespecial 215	java/util/HashSet:<init>	()V
    //   302: astore 7
    //   304: aload_0
    //   305: getfield 58	com/xiaomi/infra/galaxy/common/model/CreateTableRequest:keySchema	Ljava/util/List;
    //   308: invokeinterface 219 1 0
    //   313: astore 8
    //   315: aload 8
    //   317: invokeinterface 224 1 0
    //   322: ifeq -28 -> 294
    //   325: aload 8
    //   327: invokeinterface 228 1 0
    //   332: checkcast 42	java/lang/String
    //   335: astore 9
    //   337: aload 9
    //   339: invokestatic 268	com/xiaomi/infra/galaxy/common/util/StringUtils:isBlank	(Ljava/lang/CharSequence;)Z
    //   342: ifeq +14 -> 356
    //   345: new 172	com/xiaomi/infra/galaxy/common/GalaxyClientException
    //   348: dup
    //   349: getstatic 271	com/xiaomi/infra/galaxy/common/constants/ReturnCode:KEY_NAME_IS_BLANK	Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;
    //   352: invokespecial 212	com/xiaomi/infra/galaxy/common/GalaxyClientException:<init>	(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V
    //   355: athrow
    //   356: aload 5
    //   358: aload 9
    //   360: invokeinterface 240 2 0
    //   365: ifne +16 -> 381
    //   368: new 172	com/xiaomi/infra/galaxy/common/GalaxyClientException
    //   371: dup
    //   372: getstatic 274	com/xiaomi/infra/galaxy/common/constants/ReturnCode:KEY_NAME_IS_UNDEFINED	Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;
    //   375: aload 9
    //   377: invokespecial 199	com/xiaomi/infra/galaxy/common/GalaxyClientException:<init>	(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V
    //   380: athrow
    //   381: aload 7
    //   383: aload 9
    //   385: invokeinterface 240 2 0
    //   390: ifeq +16 -> 406
    //   393: new 172	com/xiaomi/infra/galaxy/common/GalaxyClientException
    //   396: dup
    //   397: getstatic 277	com/xiaomi/infra/galaxy/common/constants/ReturnCode:DUPLICATE_KEY_NAME	Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;
    //   400: aload 9
    //   402: invokespecial 199	com/xiaomi/infra/galaxy/common/GalaxyClientException:<init>	(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V
    //   405: athrow
    //   406: aload 7
    //   408: aload 9
    //   410: invokeinterface 254 2 0
    //   415: pop
    //   416: goto -101 -> 315
    //
    // Exception table:
    //   from	to	target	type
    //   7	15	80	java/lang/Exception
    //   15	24	96	java/lang/Exception
    //   221	230	243	java/lang/Exception
  }

  public CreateTableRequest withAccessMethod(AccessMethod paramAccessMethod)
  {
    setAccessMethod(paramAccessMethod.name());
    return this;
  }

  public CreateTableRequest withAttributeDefinitions(Collection<AttributeDefinition> paramCollection)
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

  public CreateTableRequest withAttributeDefinitions(AttributeDefinition[] paramArrayOfAttributeDefinition)
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

  public CreateTableRequest withKeySchema(Collection<String> paramCollection)
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

  public CreateTableRequest withKeySchema(String[] paramArrayOfString)
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

  public CreateTableRequest withTableName(String paramString)
  {
    this.tableName = paramString;
    return this;
  }

  public CreateTableRequest withTableType(TableType paramTableType)
  {
    setTableType(paramTableType.name());
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.CreateTableRequest
 * JD-Core Version:    0.6.2
 */