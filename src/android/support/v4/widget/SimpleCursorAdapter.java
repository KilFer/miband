package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleCursorAdapter extends ResourceCursorAdapter
{
  private int a = -1;
  private SimpleCursorAdapter.CursorToStringConverter b;
  private SimpleCursorAdapter.ViewBinder c;
  private String[] d;
  protected int[] mFrom;
  protected int[] mTo;

  public SimpleCursorAdapter(Context paramContext, int paramInt, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramContext, paramInt, paramCursor);
    this.mTo = paramArrayOfInt;
    this.d = paramArrayOfString;
    a(paramArrayOfString);
  }

  public SimpleCursorAdapter(Context paramContext, int paramInt1, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt2)
  {
    super(paramContext, paramInt1, paramCursor, paramInt2);
    this.mTo = paramArrayOfInt;
    this.d = paramArrayOfString;
    a(paramArrayOfString);
  }

  private void a(String[] paramArrayOfString)
  {
    if (this.mCursor != null)
    {
      int i = paramArrayOfString.length;
      if ((this.mFrom == null) || (this.mFrom.length != i))
        this.mFrom = new int[i];
      for (int j = 0; j < i; j++)
        this.mFrom[j] = this.mCursor.getColumnIndexOrThrow(paramArrayOfString[j]);
    }
    this.mFrom = null;
  }

  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    SimpleCursorAdapter.ViewBinder localViewBinder = this.c;
    int i = this.mTo.length;
    int[] arrayOfInt1 = this.mFrom;
    int[] arrayOfInt2 = this.mTo;
    int j = 0;
    View localView;
    if (j < i)
    {
      localView = paramView.findViewById(arrayOfInt2[j]);
      if (localView != null)
        if (localViewBinder == null)
          break label182;
    }
    label147: label182: for (boolean bool = localViewBinder.setViewValue(localView, paramCursor, arrayOfInt1[j]); ; bool = false)
    {
      String str;
      if (!bool)
      {
        str = paramCursor.getString(arrayOfInt1[j]);
        if (str == null)
          str = "";
        if (!(localView instanceof TextView))
          break label125;
        setViewText((TextView)localView, str);
      }
      while (true)
      {
        j++;
        break;
        label125: if (!(localView instanceof ImageView))
          break label147;
        setViewImage((ImageView)localView, str);
      }
      throw new IllegalStateException(localView.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
      return;
    }
  }

  public void changeCursorAndColumns(Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.d = paramArrayOfString;
    this.mTo = paramArrayOfInt;
    super.changeCursor(paramCursor);
    a(this.d);
  }

  public CharSequence convertToString(Cursor paramCursor)
  {
    if (this.b != null)
      return this.b.convertToString(paramCursor);
    if (this.a >= 0)
      return paramCursor.getString(this.a);
    return super.convertToString(paramCursor);
  }

  public SimpleCursorAdapter.CursorToStringConverter getCursorToStringConverter()
  {
    return this.b;
  }

  public int getStringConversionColumn()
  {
    return this.a;
  }

  public SimpleCursorAdapter.ViewBinder getViewBinder()
  {
    return this.c;
  }

  public void setCursorToStringConverter(SimpleCursorAdapter.CursorToStringConverter paramCursorToStringConverter)
  {
    this.b = paramCursorToStringConverter;
  }

  public void setStringConversionColumn(int paramInt)
  {
    this.a = paramInt;
  }

  public void setViewBinder(SimpleCursorAdapter.ViewBinder paramViewBinder)
  {
    this.c = paramViewBinder;
  }

  public void setViewImage(ImageView paramImageView, String paramString)
  {
    try
    {
      paramImageView.setImageResource(Integer.parseInt(paramString));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramImageView.setImageURI(Uri.parse(paramString));
    }
  }

  public void setViewText(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
  }

  public Cursor swapCursor(Cursor paramCursor)
  {
    Cursor localCursor = super.swapCursor(paramCursor);
    a(this.d);
    return localCursor;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SimpleCursorAdapter
 * JD-Core Version:    0.6.2
 */