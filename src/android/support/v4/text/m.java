package android.support.v4.text;

import java.util.Locale;

final class m extends k
{
  public static final m a = new m();

  public m()
  {
    super(null);
  }

  protected final boolean a()
  {
    return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.m
 * JD-Core Version:    0.6.2
 */