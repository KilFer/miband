package de.greenrobot.dao.internal;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public final class FastCursor
  implements Cursor
{
  private final int count;
  private int position;
  private final CursorWindow window;

  public FastCursor(CursorWindow paramCursorWindow)
  {
    this.window = paramCursorWindow;
    this.count = paramCursorWindow.getNumRows();
  }

  public final void close()
  {
    throw new UnsupportedOperationException();
  }

  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    throw new UnsupportedOperationException();
  }

  public final void deactivate()
  {
    throw new UnsupportedOperationException();
  }

  public final byte[] getBlob(int paramInt)
  {
    return this.window.getBlob(this.position, paramInt);
  }

  public final int getColumnCount()
  {
    throw new UnsupportedOperationException();
  }

  public final int getColumnIndex(String paramString)
  {
    throw new UnsupportedOperationException();
  }

  public final int getColumnIndexOrThrow(String paramString)
  {
    throw new UnsupportedOperationException();
  }

  public final String getColumnName(int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public final String[] getColumnNames()
  {
    throw new UnsupportedOperationException();
  }

  public final int getCount()
  {
    return this.window.getNumRows();
  }

  public final double getDouble(int paramInt)
  {
    return this.window.getDouble(this.position, paramInt);
  }

  public final Bundle getExtras()
  {
    throw new UnsupportedOperationException();
  }

  public final float getFloat(int paramInt)
  {
    return this.window.getFloat(this.position, paramInt);
  }

  public final int getInt(int paramInt)
  {
    return this.window.getInt(this.position, paramInt);
  }

  public final long getLong(int paramInt)
  {
    return this.window.getLong(this.position, paramInt);
  }

  public final Uri getNotificationUri()
  {
    return null;
  }

  public final int getPosition()
  {
    return this.position;
  }

  public final short getShort(int paramInt)
  {
    return this.window.getShort(this.position, paramInt);
  }

  public final String getString(int paramInt)
  {
    return this.window.getString(this.position, paramInt);
  }

  public final int getType(int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public final boolean getWantsAllOnMoveCalls()
  {
    throw new UnsupportedOperationException();
  }

  public final boolean isAfterLast()
  {
    throw new UnsupportedOperationException();
  }

  public final boolean isBeforeFirst()
  {
    throw new UnsupportedOperationException();
  }

  public final boolean isClosed()
  {
    throw new UnsupportedOperationException();
  }

  public final boolean isFirst()
  {
    return this.position == 0;
  }

  public final boolean isLast()
  {
    return this.position == -1 + this.count;
  }

  public final boolean isNull(int paramInt)
  {
    return this.window.isNull(this.position, paramInt);
  }

  public final boolean move(int paramInt)
  {
    return moveToPosition(paramInt + this.position);
  }

  public final boolean moveToFirst()
  {
    this.position = 0;
    int i = this.count;
    boolean bool = false;
    if (i > 0)
      bool = true;
    return bool;
  }

  public final boolean moveToLast()
  {
    if (this.count > 0)
    {
      this.position = (-1 + this.count);
      return true;
    }
    return false;
  }

  public final boolean moveToNext()
  {
    if (this.position < -1 + this.count)
    {
      this.position = (1 + this.position);
      return true;
    }
    return false;
  }

  public final boolean moveToPosition(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.count))
    {
      this.position = paramInt;
      return true;
    }
    return false;
  }

  public final boolean moveToPrevious()
  {
    if (this.position > 0)
    {
      this.position = (-1 + this.position);
      return true;
    }
    return false;
  }

  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    throw new UnsupportedOperationException();
  }

  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    throw new UnsupportedOperationException();
  }

  public final boolean requery()
  {
    throw new UnsupportedOperationException();
  }

  public final Bundle respond(Bundle paramBundle)
  {
    throw new UnsupportedOperationException();
  }

  public final void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    throw new UnsupportedOperationException();
  }

  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    throw new UnsupportedOperationException();
  }

  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.internal.FastCursor
 * JD-Core Version:    0.6.2
 */