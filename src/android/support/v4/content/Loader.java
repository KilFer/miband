package android.support.v4.content;

import android.content.Context;
import android.support.v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D>
{
  boolean a = false;
  private int b;
  private Loader.OnLoadCompleteListener<D> c;
  private Context d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = true;
  private boolean h = false;

  public Loader(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
  }

  public void abandon()
  {
    this.f = true;
    onAbandon();
  }

  public void commitContentChanged()
  {
    this.h = false;
  }

  public String dataToString(D paramD)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    DebugUtils.buildShortClassTag(paramD, localStringBuilder);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  public void deliverResult(D paramD)
  {
    if (this.c != null)
      this.c.onLoadComplete(this, paramD);
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.b);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.c);
    if ((this.e) || (this.a) || (this.h))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.e);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.a);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.h);
    }
    if ((this.f) || (this.g))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.f);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.g);
    }
  }

  public void forceLoad()
  {
    onForceLoad();
  }

  public Context getContext()
  {
    return this.d;
  }

  public int getId()
  {
    return this.b;
  }

  public boolean isAbandoned()
  {
    return this.f;
  }

  public boolean isReset()
  {
    return this.g;
  }

  public boolean isStarted()
  {
    return this.e;
  }

  protected void onAbandon()
  {
  }

  public void onContentChanged()
  {
    if (this.e)
    {
      forceLoad();
      return;
    }
    this.a = true;
  }

  protected void onForceLoad()
  {
  }

  protected void onReset()
  {
  }

  protected void onStartLoading()
  {
  }

  protected void onStopLoading()
  {
  }

  public void registerListener(int paramInt, Loader.OnLoadCompleteListener<D> paramOnLoadCompleteListener)
  {
    if (this.c != null)
      throw new IllegalStateException("There is already a listener registered");
    this.c = paramOnLoadCompleteListener;
    this.b = paramInt;
  }

  public void reset()
  {
    onReset();
    this.g = true;
    this.e = false;
    this.f = false;
    this.a = false;
    this.h = false;
  }

  public void rollbackContentChanged()
  {
    if (this.h)
      this.a = true;
  }

  public final void startLoading()
  {
    this.e = true;
    this.g = false;
    this.f = false;
    onStartLoading();
  }

  public void stopLoading()
  {
    this.e = false;
    onStopLoading();
  }

  public boolean takeContentChanged()
  {
    boolean bool = this.a;
    this.a = false;
    this.h = (bool | this.h);
    return bool;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    DebugUtils.buildShortClassTag(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  public void unregisterListener(Loader.OnLoadCompleteListener<D> paramOnLoadCompleteListener)
  {
    if (this.c == null)
      throw new IllegalStateException("No listener register");
    if (this.c != paramOnLoadCompleteListener)
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    this.c = null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.Loader
 * JD-Core Version:    0.6.2
 */