package com.tencent.mm.sdk.storage;

import android.database.Cursor;
import java.lang.reflect.Field;

final class x
  implements CursorFieldHelper.ISetMethod
{
  public final void invoke(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    CursorFieldHelper.c(paramField, paramObject, paramCursor, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.x
 * JD-Core Version:    0.6.2
 */