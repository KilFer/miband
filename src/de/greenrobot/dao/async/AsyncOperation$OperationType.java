package de.greenrobot.dao.async;

public enum AsyncOperation$OperationType
{
  static
  {
    InsertInTxArray = new OperationType("InsertInTxArray", 2);
    InsertOrReplace = new OperationType("InsertOrReplace", 3);
    InsertOrReplaceInTxIterable = new OperationType("InsertOrReplaceInTxIterable", 4);
    InsertOrReplaceInTxArray = new OperationType("InsertOrReplaceInTxArray", 5);
    Update = new OperationType("Update", 6);
    UpdateInTxIterable = new OperationType("UpdateInTxIterable", 7);
    UpdateInTxArray = new OperationType("UpdateInTxArray", 8);
    Delete = new OperationType("Delete", 9);
    DeleteInTxIterable = new OperationType("DeleteInTxIterable", 10);
    DeleteInTxArray = new OperationType("DeleteInTxArray", 11);
    DeleteByKey = new OperationType("DeleteByKey", 12);
    DeleteAll = new OperationType("DeleteAll", 13);
    TransactionRunnable = new OperationType("TransactionRunnable", 14);
    TransactionCallable = new OperationType("TransactionCallable", 15);
    QueryList = new OperationType("QueryList", 16);
    QueryUnique = new OperationType("QueryUnique", 17);
    Load = new OperationType("Load", 18);
    LoadAll = new OperationType("LoadAll", 19);
    Count = new OperationType("Count", 20);
    Refresh = new OperationType("Refresh", 21);
    OperationType[] arrayOfOperationType = new OperationType[22];
    arrayOfOperationType[0] = Insert;
    arrayOfOperationType[1] = InsertInTxIterable;
    arrayOfOperationType[2] = InsertInTxArray;
    arrayOfOperationType[3] = InsertOrReplace;
    arrayOfOperationType[4] = InsertOrReplaceInTxIterable;
    arrayOfOperationType[5] = InsertOrReplaceInTxArray;
    arrayOfOperationType[6] = Update;
    arrayOfOperationType[7] = UpdateInTxIterable;
    arrayOfOperationType[8] = UpdateInTxArray;
    arrayOfOperationType[9] = Delete;
    arrayOfOperationType[10] = DeleteInTxIterable;
    arrayOfOperationType[11] = DeleteInTxArray;
    arrayOfOperationType[12] = DeleteByKey;
    arrayOfOperationType[13] = DeleteAll;
    arrayOfOperationType[14] = TransactionRunnable;
    arrayOfOperationType[15] = TransactionCallable;
    arrayOfOperationType[16] = QueryList;
    arrayOfOperationType[17] = QueryUnique;
    arrayOfOperationType[18] = Load;
    arrayOfOperationType[19] = LoadAll;
    arrayOfOperationType[20] = Count;
    arrayOfOperationType[21] = Refresh;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.async.AsyncOperation.OperationType
 * JD-Core Version:    0.6.2
 */