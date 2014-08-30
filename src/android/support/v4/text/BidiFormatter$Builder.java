package android.support.v4.text;

import java.util.Locale;

public final class BidiFormatter$Builder
{
  private boolean a;
  private int b;
  private TextDirectionHeuristicCompat c;

  public BidiFormatter$Builder()
  {
    a(BidiFormatter.a(Locale.getDefault()));
  }

  public BidiFormatter$Builder(Locale paramLocale)
  {
    a(BidiFormatter.a(paramLocale));
  }

  public BidiFormatter$Builder(boolean paramBoolean)
  {
    a(paramBoolean);
  }

  private void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    this.c = BidiFormatter.a();
    this.b = 2;
  }

  private static BidiFormatter b(boolean paramBoolean)
  {
    if (paramBoolean)
      return BidiFormatter.b();
    return BidiFormatter.c();
  }

  public final BidiFormatter build()
  {
    if ((this.b == 2) && (this.c == BidiFormatter.a()))
    {
      if (this.a)
        return BidiFormatter.b();
      return BidiFormatter.c();
    }
    return new BidiFormatter(this.a, this.b, this.c, (byte)0);
  }

  public final Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    this.c = paramTextDirectionHeuristicCompat;
    return this;
  }

  public final Builder stereoReset(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b = (0x2 | this.b);
      return this;
    }
    this.b = (0xFFFFFFFD & this.b);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.BidiFormatter.Builder
 * JD-Core Version:    0.6.2
 */