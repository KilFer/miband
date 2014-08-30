package com.xiaomi.infra.galaxy.common.constants;

public enum Operation
{
  private String value;

  static
  {
    Scan = new Operation("Scan", 5, "Scan");
    Delete = new Operation("Delete", 6, "Delete");
    Batch = new Operation("Batch", 7, "Batch");
    Auth = new Operation("Auth", 8, "Auth");
    ShowTables = new Operation("ShowTables", 9, "ShowTables");
    AlterTable = new Operation("AlterTable", 10, "AlterTable");
    AlterAppInfo = new Operation("AlterAppInfo", 11, "AlterAppInfo");
    GetAppInfo = new Operation("GetAppInfo", 12, "GetAppInfo");
    ScanAppUser = new Operation("ScanAppUser", 13, "ScanAppUser");
    Operation[] arrayOfOperation = new Operation[14];
    arrayOfOperation[0] = CreateTable;
    arrayOfOperation[1] = DeleteTable;
    arrayOfOperation[2] = DescribeTable;
    arrayOfOperation[3] = Get;
    arrayOfOperation[4] = Set;
    arrayOfOperation[5] = Scan;
    arrayOfOperation[6] = Delete;
    arrayOfOperation[7] = Batch;
    arrayOfOperation[8] = Auth;
    arrayOfOperation[9] = ShowTables;
    arrayOfOperation[10] = AlterTable;
    arrayOfOperation[11] = AlterAppInfo;
    arrayOfOperation[12] = GetAppInfo;
    arrayOfOperation[13] = ScanAppUser;
  }

  private Operation(String paramString)
  {
    this.value = paramString;
  }

  public static Operation fromValue(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
      throw new IllegalArgumentException("Value cannot be null or empty!");
    if ("CreateTable".equals(paramString))
      return CreateTable;
    if ("DeleteTable".equals(paramString))
      return DeleteTable;
    if ("DescribeTable".equals(paramString))
      return DescribeTable;
    if ("Get".equals(paramString))
      return Get;
    if ("Set".equals(paramString))
      return Set;
    if ("Scan".equals(paramString))
      return Scan;
    if ("Delete".equals(paramString))
      return Delete;
    if ("Batch".equals(paramString))
      return Batch;
    if ("Auth".equals(paramString))
      return Auth;
    if ("ShowTables".equals(paramString))
      return ShowTables;
    if ("AlterTable".equals(paramString))
      return AlterTable;
    if ("GetAppInfo".equals(paramString))
      return GetAppInfo;
    if ("AlterAppInfo".equals(paramString))
      return AlterAppInfo;
    if ("ScanAppUser".equals(paramString))
      return ScanAppUser;
    throw new IllegalArgumentException("Cannot create enum from " + paramString + " value!");
  }

  public final String toString()
  {
    return this.value;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.constants.Operation
 * JD-Core Version:    0.6.2
 */