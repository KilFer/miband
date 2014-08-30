package cn.com.smartdevices.bracelet.chart.typeface;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TypefaceManager
{
  private static final TypefaceManager a = new TypefaceManager();
  private final HashMap<TypefaceManager.TextStyle, WeakReference<Typeface>> b = new HashMap();
  private final HashSet<TypefaceManager.TextStyleExtractor> c = new HashSet();

  public static void addTextStyleExtractor(TypefaceManager.TextStyleExtractor paramTextStyleExtractor)
  {
    a.c.add(paramTextStyleExtractor);
  }

  public static TypefaceManager getInstance()
  {
    return a;
  }

  public void applyTypeface(TextView paramTextView, Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16843692 });
    applyTypeface(paramTextView, localTypedArray.getString(0));
    localTypedArray.recycle();
  }

  public void applyTypeface(TextView paramTextView, TypefaceManager.TextStyle paramTextStyle)
  {
    Typeface localTypeface = getTypeface(paramTextView.getContext(), paramTextStyle);
    if (localTypeface != null)
      paramTextView.setTypeface(localTypeface);
  }

  public void applyTypeface(TextView paramTextView, String paramString)
  {
    Typeface localTypeface = getTypeface(paramTextView.getContext(), paramString);
    if (localTypeface != null)
      paramTextView.setTypeface(localTypeface);
  }

  public Typeface getTypeface(Context paramContext, TypefaceManager.TextStyle paramTextStyle)
  {
    Object localObject1 = null;
    if (paramTextStyle == null);
    do
    {
      return localObject1;
      if (!this.b.containsKey(paramTextStyle))
        break;
      localObject1 = (Typeface)((WeakReference)this.b.get(paramTextStyle)).get();
    }
    while (localObject1 != null);
    for (Object localObject2 = localObject1; ; localObject2 = null)
      try
      {
        Typeface localTypeface = Typeface.createFromAsset(paramContext.getAssets(), paramTextStyle.getFontName());
        localObject1 = localTypeface;
        if (localObject1 == null)
          break;
        this.b.put(paramTextStyle, new WeakReference(localObject1));
        return localObject1;
      }
      catch (Exception localException)
      {
        while (true)
        {
          localException.printStackTrace();
          localObject1 = localObject2;
        }
      }
  }

  public Typeface getTypeface(Context paramContext, String paramString)
  {
    Iterator localIterator;
    if (!TextUtils.isEmpty(paramString))
      localIterator = this.c.iterator();
    TypefaceManager.TextStyle localTextStyle;
    do
    {
      if (!localIterator.hasNext())
        return null;
      localTextStyle = ((TypefaceManager.TextStyleExtractor)localIterator.next()).getTextStyle(paramString);
    }
    while (localTextStyle == null);
    return getTypeface(paramContext, localTextStyle);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.typeface.TypefaceManager
 * JD-Core Version:    0.6.2
 */