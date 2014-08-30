package android.support.v4.text;

final class h
  implements j
{
  public static final h a = new h(true);
  private static h c;
  private final boolean b;

  static
  {
    new h(false);
  }

  private h(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public final int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = paramInt1 + paramInt2;
    int k = 0;
    while (true)
      if (paramInt1 < j)
        switch (TextDirectionHeuristicsCompat.b(Character.getDirectionality(paramCharSequence.charAt(paramInt1))))
        {
        default:
          paramInt1++;
          break;
        case 0:
          if (this.b)
            i = 0;
          break;
        case 1:
        }
    do
    {
      do
      {
        return i;
        k = i;
        break;
      }
      while (!this.b);
      k = i;
      break;
      if (k == 0)
        break label106;
    }
    while (this.b);
    return 0;
    label106: return 2;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.h
 * JD-Core Version:    0.6.2
 */