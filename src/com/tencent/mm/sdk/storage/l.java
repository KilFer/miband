package com.tencent.mm.sdk.storage;

import android.database.Cursor;
import java.lang.reflect.Field;

final class l
  implements CursorFieldHelper.ISetMethod
{
  public final void invoke(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    CursorFieldHelper.b(paramField, paramObject, paramCursor, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.l
 * JD-Core Version:    0.6.2
 */