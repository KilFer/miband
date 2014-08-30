package android.support.v4.text;

final class i
  implements j
{
  public static final i a = new i();

  public final int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    int j = 2;
    while ((paramInt1 < i) && (j == 2))
    {
      j = TextDirectionHeuristicsCompat.a(Character.getDirectionality(paramCharSequence.charAt(paramInt1)));
      paramInt1++;
    }
    return j;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.i
 * JD-Core Version:    0.6.2
 */