package android.support.v4.text;

import java.util.Locale;

public class TextUtilsCompat
{
  public static final Locale ROOT = new Locale("", "");
  private static String a = "Arab";
  private static String b = "Hebr";

  private static int a(Locale paramLocale)
  {
    switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
    {
    default:
      return 0;
    case 1:
    case 2:
    }
    return 1;
  }

  public static int getLayoutDirectionFromLocale(Locale paramLocale)
  {
    int i = 1;
    if ((paramLocale != null) && (!paramLocale.equals(ROOT)))
    {
      String str = ICUCompat.getScript(ICUCompat.addLikelySubtags(paramLocale.toString()));
      if (str == null)
        switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
        {
        default:
          i = 0;
        case 1:
        case 2:
        }
      while ((str.equalsIgnoreCase(a)) || (str.equalsIgnoreCase(b)))
        return i;
    }
    return 0;
  }

  public static String htmlEncode(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default:
        localStringBuilder.append(c);
      case '<':
      case '>':
      case '&':
      case '\'':
      case '"':
      }
      while (true)
      {
        i++;
        break;
        localStringBuilder.append("&lt;");
        continue;
        localStringBuilder.append("&gt;");
        continue;
        localStringBuilder.append("&amp;");
        continue;
        localStringBuilder.append("&#39;");
        continue;
        localStringBuilder.append("&quot;");
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.TextUtilsCompat
 * JD-Core Version:    0.6.2
 */