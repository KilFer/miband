package android.support.v4.app;

import android.view.MenuItem;

class Z
{
  private static void a(StringBuilder paramStringBuilder, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramCharSequence.charAt(i);
      if (c == '<')
        paramStringBuilder.append("&lt;");
      while (true)
      {
        i++;
        break;
        if (c == '>')
        {
          paramStringBuilder.append("&gt;");
        }
        else if (c == '&')
        {
          paramStringBuilder.append("&amp;");
        }
        else if ((c > '~') || (c < ' '))
        {
          paramStringBuilder.append("&#" + c + ";");
        }
        else if (c == ' ')
        {
          while ((i + 1 < paramInt2) && (paramCharSequence.charAt(i + 1) == ' '))
          {
            paramStringBuilder.append("&nbsp;");
            i++;
          }
          paramStringBuilder.append(' ');
        }
        else
        {
          paramStringBuilder.append(c);
        }
      }
    }
  }

  public String a(CharSequence paramCharSequence)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Y.a(localStringBuilder, paramCharSequence, 0, paramCharSequence.length());
    return localStringBuilder.toString();
  }

  public void a(MenuItem paramMenuItem, ShareCompat.IntentBuilder paramIntentBuilder)
  {
    paramMenuItem.setIntent(paramIntentBuilder.createChooserIntent());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.Z
 * JD-Core Version:    0.6.2
 */