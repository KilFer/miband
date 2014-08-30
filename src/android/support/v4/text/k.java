package android.support.v4.text;

import java.nio.CharBuffer;

abstract class k
  implements TextDirectionHeuristicCompat
{
  private final j a;

  public k(j paramj)
  {
    this.a = paramj;
  }

  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    switch (this.a.a(paramCharSequence, paramInt1, paramInt2))
    {
    default:
      return a();
    case 0:
      return true;
    case 1:
    }
    return false;
  }

  protected abstract boolean a();

  public boolean isRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramCharSequence == null) || (paramInt1 < 0) || (paramInt2 < 0) || (paramCharSequence.length() - paramInt2 < paramInt1))
      throw new IllegalArgumentException();
    if (this.a == null)
      return a();
    switch (this.a.a(paramCharSequence, paramInt1, paramInt2))
    {
    default:
      return a();
    case 0:
      return true;
    case 1:
    }
    return false;
  }

  public boolean isRtl(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return isRtl(CharBuffer.wrap(paramArrayOfChar), paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.k
 * JD-Core Version:    0.6.2
 */