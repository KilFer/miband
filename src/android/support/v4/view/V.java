package android.support.v4.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

final class V extends SingleLineTransformationMethod
{
  private static final String a = "SingleLineAllCapsTransform";
  private Locale b;

  public V(Context paramContext)
  {
    this.b = paramContext.getResources().getConfiguration().locale;
  }

  public final CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    CharSequence localCharSequence = super.getTransformation(paramCharSequence, paramView);
    if (localCharSequence != null)
      return localCharSequence.toString().toUpperCase(this.b);
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.V
 * JD-Core Version:    0.6.2
 */