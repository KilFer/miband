package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;

public abstract interface MDBItem
{
  public abstract void convertFrom(Cursor paramCursor);

  public abstract ContentValues convertTo();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MDBItem
 * JD-Core Version:    0.6.2
 */