package com.tencent.mm.sdk.storage;

import android.database.Cursor;
import java.lang.reflect.Field;

final class z
  implements CursorFieldHelper.ISetMethod
{
  public final void invoke(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    CursorFieldHelper.d(paramField, paramObject, paramCursor, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.z
 * JD-Core Version:    0.6.2
 */