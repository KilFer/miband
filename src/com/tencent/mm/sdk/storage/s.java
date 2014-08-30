package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import java.lang.reflect.Field;

final class s
  implements CursorFieldHelper.IGetMethod
{
  public final void invoke(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    CursorFieldHelper.g(paramField, paramObject, paramContentValues);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.s
 * JD-Core Version:    0.6.2
 */