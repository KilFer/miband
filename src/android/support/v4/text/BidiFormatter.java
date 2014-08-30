package android.support.v4.text;

import java.util.Locale;

public final class BidiFormatter
{
  private static TextDirectionHeuristicCompat a = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
  private static final char b = '‪';
  private static final char c = '‫';
  private static final char d = '‬';
  private static final char e = '‎';
  private static final char f = '‏';
  private static final String g = Character.toString('‎');
  private static final String h = Character.toString('‏');
  private static final String i = "";
  private static final int j = 2;
  private static final int k = 2;
  private static final BidiFormatter l = new BidiFormatter(false, 2, a);
  private static final BidiFormatter m = new BidiFormatter(true, 2, a);
  private static final int q = -1;
  private static final int r = 0;
  private static final int s = 1;
  private final boolean n;
  private final int o;
  private final TextDirectionHeuristicCompat p;

  private BidiFormatter(boolean paramBoolean, int paramInt, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    this.n = paramBoolean;
    this.o = paramInt;
    this.p = paramTextDirectionHeuristicCompat;
  }

  private static int a(String paramString)
  {
    return new b(paramString, false).b();
  }

  private String a(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
    if ((!this.n) && ((bool) || (a(paramString) == 1)))
      return g;
    if ((this.n) && ((!bool) || (a(paramString) == -1)))
      return h;
    return "";
  }

  private static int b(String paramString)
  {
    return new b(paramString, false).a();
  }

  private String b(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
    if ((!this.n) && ((bool) || (b(paramString) == 1)))
      return g;
    if ((this.n) && ((!bool) || (b(paramString) == -1)))
      return h;
    return "";
  }

  private static boolean b(Locale paramLocale)
  {
    return TextUtilsCompat.getLayoutDirectionFromLocale(paramLocale) == 1;
  }

  public static BidiFormatter getInstance()
  {
    return new BidiFormatter.Builder().build();
  }

  public static BidiFormatter getInstance(Locale paramLocale)
  {
    return new BidiFormatter.Builder(paramLocale).build();
  }

  public static BidiFormatter getInstance(boolean paramBoolean)
  {
    return new BidiFormatter.Builder(paramBoolean).build();
  }

  public final boolean getStereoReset()
  {
    return (0x2 & this.o) != 0;
  }

  public final boolean isRtl(String paramString)
  {
    return this.p.isRtl(paramString, 0, paramString.length());
  }

  public final boolean isRtlContext()
  {
    return this.n;
  }

  public final String unicodeWrap(String paramString)
  {
    return unicodeWrap(paramString, this.p, true);
  }

  public final String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    return unicodeWrap(paramString, paramTextDirectionHeuristicCompat, true);
  }

  public final String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean)
  {
    boolean bool1 = paramTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    TextDirectionHeuristicCompat localTextDirectionHeuristicCompat2;
    boolean bool3;
    String str2;
    label84: label111: TextDirectionHeuristicCompat localTextDirectionHeuristicCompat1;
    label135: label149: boolean bool2;
    String str1;
    if ((getStereoReset()) && (paramBoolean))
    {
      if (bool1)
      {
        localTextDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.RTL;
        bool3 = localTextDirectionHeuristicCompat2.isRtl(paramString, 0, paramString.length());
        if ((this.n) || ((!bool3) && (b(paramString) != 1)))
          break label211;
        str2 = g;
        localStringBuilder.append(str2);
      }
    }
    else
    {
      if (bool1 == this.n)
        break label254;
      if (!bool1)
        break label246;
      int i1 = 8235;
      localStringBuilder.append(i1);
      localStringBuilder.append(paramString);
      localStringBuilder.append('‬');
      if (paramBoolean)
      {
        if (!bool1)
          break label264;
        localTextDirectionHeuristicCompat1 = TextDirectionHeuristicsCompat.RTL;
        bool2 = localTextDirectionHeuristicCompat1.isRtl(paramString, 0, paramString.length());
        if ((this.n) || ((!bool2) && (a(paramString) != 1)))
          break label272;
        str1 = g;
      }
    }
    while (true)
    {
      localStringBuilder.append(str1);
      return localStringBuilder.toString();
      localTextDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.LTR;
      break;
      label211: if ((this.n) && ((!bool3) || (b(paramString) == -1)))
      {
        str2 = h;
        break label84;
      }
      str2 = "";
      break label84;
      label246: int i2 = 8234;
      break label111;
      label254: localStringBuilder.append(paramString);
      break label135;
      label264: localTextDirectionHeuristicCompat1 = TextDirectionHeuristicsCompat.LTR;
      break label149;
      label272: if ((this.n) && ((!bool2) || (a(paramString) == -1)))
        str1 = h;
      else
        str1 = "";
    }
  }

  public final String unicodeWrap(String paramString, boolean paramBoolean)
  {
    return unicodeWrap(paramString, this.p, paramBoolean);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.BidiFormatter
 * JD-Core Version:    0.6.2
 */