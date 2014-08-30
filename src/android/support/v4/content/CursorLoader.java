package android.support.v4.content;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor>
{
  private Loader<Cursor>.ForceLoadContentObserver b = new Loader.ForceLoadContentObserver(this);
  private Uri c;
  private String[] d;
  private String e;
  private String[] f;
  private String g;
  private Cursor h;

  public CursorLoader(Context paramContext)
  {
    super(paramContext);
  }

  public CursorLoader(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    super(paramContext);
    this.c = paramUri;
    this.d = paramArrayOfString1;
    this.e = paramString1;
    this.f = paramArrayOfString2;
    this.g = paramString2;
  }

  public void deliverResult(Cursor paramCursor)
  {
    if (isReset())
      if (paramCursor != null)
        paramCursor.close();
    Cursor localCursor;
    do
    {
      return;
      localCursor = this.h;
      this.h = paramCursor;
      if (isStarted())
        super.deliverResult(paramCursor);
    }
    while ((localCursor == null) || (localCursor == paramCursor) || (localCursor.isClosed()));
    localCursor.close();
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mUri=");
    paramPrintWriter.println(this.c);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mProjection=");
    paramPrintWriter.println(Arrays.toString(this.d));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelection=");
    paramPrintWriter.println(this.e);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelectionArgs=");
    paramPrintWriter.println(Arrays.toString(this.f));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSortOrder=");
    paramPrintWriter.println(this.g);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mCursor=");
    paramPrintWriter.println(this.h);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mContentChanged=");
    paramPrintWriter.println(this.a);
  }

  public String[] getProjection()
  {
    return this.d;
  }

  public String getSelection()
  {
    return this.e;
  }

  public String[] getSelectionArgs()
  {
    return this.f;
  }

  public String getSortOrder()
  {
    return this.g;
  }

  public Uri getUri()
  {
    return this.c;
  }

  public Cursor loadInBackground()
  {
    Cursor localCursor = getContext().getContentResolver().query(this.c, this.d, this.e, this.f, this.g);
    if (localCursor != null)
    {
      localCursor.getCount();
      localCursor.registerContentObserver(this.b);
    }
    return localCursor;
  }

  public void onCanceled(Cursor paramCursor)
  {
    if ((paramCursor != null) && (!paramCursor.isClosed()))
      paramCursor.close();
  }

  protected void onReset()
  {
    super.onReset();
    onStopLoading();
    if ((this.h != null) && (!this.h.isClosed()))
      this.h.close();
    this.h = null;
  }

  protected void onStartLoading()
  {
    if (this.h != null)
      deliverResult(this.h);
    if ((takeContentChanged()) || (this.h == null))
      forceLoad();
  }

  protected void onStopLoading()
  {
    cancelLoad();
  }

  public void setProjection(String[] paramArrayOfString)
  {
    this.d = paramArrayOfString;
  }

  public void setSelection(String paramString)
  {
    this.e = paramString;
  }

  public void setSelectionArgs(String[] paramArrayOfString)
  {
    this.f = paramArrayOfString;
  }

  public void setSortOrder(String paramString)
  {
    this.g = paramString;
  }

  public void setUri(Uri paramUri)
  {
    this.c = paramUri;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.CursorLoader
 * JD-Core Version:    0.6.2
 */