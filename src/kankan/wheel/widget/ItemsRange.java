package kankan.wheel.widget;

public class ItemsRange
{
  private int a;
  private int b;

  public ItemsRange()
  {
    this(0, 0);
  }

  public ItemsRange(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public boolean contains(int paramInt)
  {
    return (paramInt >= getFirst()) && (paramInt <= getLast());
  }

  public int getCount()
  {
    return this.b;
  }

  public int getFirst()
  {
    return this.a;
  }

  public int getLast()
  {
    return -1 + (getFirst() + getCount());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.ItemsRange
 * JD-Core Version:    0.6.2
 */