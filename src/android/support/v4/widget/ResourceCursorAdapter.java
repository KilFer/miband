package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ResourceCursorAdapter extends CursorAdapter
{
  private int a;
  private int b;
  private LayoutInflater c;

  public ResourceCursorAdapter(Context paramContext, int paramInt, Cursor paramCursor)
  {
    super(paramContext, paramCursor);
    this.b = paramInt;
    this.a = paramInt;
    this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }

  public ResourceCursorAdapter(Context paramContext, int paramInt1, Cursor paramCursor, int paramInt2)
  {
    super(paramContext, paramCursor, paramInt2);
    this.b = paramInt1;
    this.a = paramInt1;
    this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }

  public ResourceCursorAdapter(Context paramContext, int paramInt, Cursor paramCursor, boolean paramBoolean)
  {
    super(paramContext, paramCursor, paramBoolean);
    this.b = paramInt;
    this.a = paramInt;
    this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }

  public View newDropDownView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.c.inflate(this.b, paramViewGroup, false);
  }

  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.c.inflate(this.a, paramViewGroup, false);
  }

  public void setDropDownViewResource(int paramInt)
  {
    this.b = paramInt;
  }

  public void setViewResource(int paramInt)
  {
    this.a = paramInt;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ResourceCursorAdapter
 * JD-Core Version:    0.6.2
 */