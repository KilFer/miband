package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeInfoCompat
{
  public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
  public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
  public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
  public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
  public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
  public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
  public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
  public static final int ACTION_CLEAR_FOCUS = 2;
  public static final int ACTION_CLEAR_SELECTION = 8;
  public static final int ACTION_CLICK = 16;
  public static final int ACTION_COPY = 16384;
  public static final int ACTION_CUT = 65536;
  public static final int ACTION_FOCUS = 1;
  public static final int ACTION_LONG_CLICK = 32;
  public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
  public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
  public static final int ACTION_PASTE = 32768;
  public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
  public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
  public static final int ACTION_SCROLL_BACKWARD = 8192;
  public static final int ACTION_SCROLL_FORWARD = 4096;
  public static final int ACTION_SELECT = 4;
  public static final int ACTION_SET_SELECTION = 131072;
  public static final int FOCUS_ACCESSIBILITY = 2;
  public static final int FOCUS_INPUT = 1;
  public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
  public static final int MOVEMENT_GRANULARITY_LINE = 4;
  public static final int MOVEMENT_GRANULARITY_PAGE = 16;
  public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
  public static final int MOVEMENT_GRANULARITY_WORD = 2;
  private static final m a = new m();
  private final Object b;

  static
  {
    if ("JellyBeanMR2".equals(Build.VERSION.CODENAME))
    {
      a = new o();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new n();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new l();
      return;
    }
  }

  public AccessibilityNodeInfoCompat(Object paramObject)
  {
    this.b = paramObject;
  }

  static AccessibilityNodeInfoCompat a(Object paramObject)
  {
    if (paramObject != null)
      return new AccessibilityNodeInfoCompat(paramObject);
    return null;
  }

  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "ACTION_UNKNOWN";
    case 1:
      return "ACTION_FOCUS";
    case 2:
      return "ACTION_CLEAR_FOCUS";
    case 4:
      return "ACTION_SELECT";
    case 8:
      return "ACTION_CLEAR_SELECTION";
    case 16:
      return "ACTION_CLICK";
    case 32:
      return "ACTION_LONG_CLICK";
    case 64:
      return "ACTION_ACCESSIBILITY_FOCUS";
    case 128:
      return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    case 256:
      return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    case 512:
      return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    case 1024:
      return "ACTION_NEXT_HTML_ELEMENT";
    case 2048:
      return "ACTION_PREVIOUS_HTML_ELEMENT";
    case 4096:
      return "ACTION_SCROLL_FORWARD";
    case 8192:
      return "ACTION_SCROLL_BACKWARD";
    case 65536:
      return "ACTION_CUT";
    case 16384:
      return "ACTION_COPY";
    case 32768:
      return "ACTION_PASTE";
    case 131072:
    }
    return "ACTION_SET_SELECTION";
  }

  public static AccessibilityNodeInfoCompat obtain()
  {
    return a(a.a());
  }

  public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    return a(a.a(paramAccessibilityNodeInfoCompat.b));
  }

  public static AccessibilityNodeInfoCompat obtain(View paramView)
  {
    return a(a.a(paramView));
  }

  public static AccessibilityNodeInfoCompat obtain(View paramView, int paramInt)
  {
    return a(a.a(paramView, paramInt));
  }

  public void addAction(int paramInt)
  {
    a.a(this.b, paramInt);
  }

  public void addChild(View paramView)
  {
    a.a(this.b, paramView);
  }

  public void addChild(View paramView, int paramInt)
  {
    a.b(this.b, paramView, paramInt);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat;
    do
    {
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localAccessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)paramObject;
        if (this.b != null)
          break;
      }
      while (localAccessibilityNodeInfoCompat.b == null);
      return false;
    }
    while (this.b.equals(localAccessibilityNodeInfoCompat.b));
    return false;
  }

  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a.a(this.b, paramString);
    int i = localList.size();
    for (int j = 0; j < i; j++)
      localArrayList.add(new AccessibilityNodeInfoCompat(localList.get(j)));
    return localArrayList;
  }

  public AccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    return a(a.d(this.b, paramInt));
  }

  public AccessibilityNodeInfoCompat focusSearch(int paramInt)
  {
    return a(a.e(this.b, paramInt));
  }

  public int getActions()
  {
    return a.b(this.b);
  }

  public void getBoundsInParent(Rect paramRect)
  {
    a.a(this.b, paramRect);
  }

  public void getBoundsInScreen(Rect paramRect)
  {
    a.b(this.b, paramRect);
  }

  public AccessibilityNodeInfoCompat getChild(int paramInt)
  {
    return a(a.b(this.b, paramInt));
  }

  public int getChildCount()
  {
    return a.c(this.b);
  }

  public CharSequence getClassName()
  {
    return a.d(this.b);
  }

  public CharSequence getContentDescription()
  {
    return a.e(this.b);
  }

  public Object getInfo()
  {
    return this.b;
  }

  public int getMovementGranularities()
  {
    return a.u(this.b);
  }

  public CharSequence getPackageName()
  {
    return a.f(this.b);
  }

  public AccessibilityNodeInfoCompat getParent()
  {
    return a(a.g(this.b));
  }

  public CharSequence getText()
  {
    return a.h(this.b);
  }

  public String getViewIdResourceName()
  {
    return a.x(this.b);
  }

  public int getWindowId()
  {
    return a.i(this.b);
  }

  public int hashCode()
  {
    if (this.b == null)
      return 0;
    return this.b.hashCode();
  }

  public boolean isAccessibilityFocused()
  {
    return a.w(this.b);
  }

  public boolean isCheckable()
  {
    return a.j(this.b);
  }

  public boolean isChecked()
  {
    return a.k(this.b);
  }

  public boolean isClickable()
  {
    return a.l(this.b);
  }

  public boolean isEnabled()
  {
    return a.m(this.b);
  }

  public boolean isFocusable()
  {
    return a.n(this.b);
  }

  public boolean isFocused()
  {
    return a.o(this.b);
  }

  public boolean isLongClickable()
  {
    return a.p(this.b);
  }

  public boolean isPassword()
  {
    return a.q(this.b);
  }

  public boolean isScrollable()
  {
    return a.r(this.b);
  }

  public boolean isSelected()
  {
    return a.s(this.b);
  }

  public boolean isVisibleToUser()
  {
    return a.v(this.b);
  }

  public boolean performAction(int paramInt)
  {
    return a.c(this.b, paramInt);
  }

  public boolean performAction(int paramInt, Bundle paramBundle)
  {
    return a.a(this.b, paramInt, paramBundle);
  }

  public void recycle()
  {
    a.t(this.b);
  }

  public void setAccessibilityFocused(boolean paramBoolean)
  {
    a.l(this.b, paramBoolean);
  }

  public void setBoundsInParent(Rect paramRect)
  {
    a.c(this.b, paramRect);
  }

  public void setBoundsInScreen(Rect paramRect)
  {
    a.d(this.b, paramRect);
  }

  public void setCheckable(boolean paramBoolean)
  {
    a.a(this.b, paramBoolean);
  }

  public void setChecked(boolean paramBoolean)
  {
    a.b(this.b, paramBoolean);
  }

  public void setClassName(CharSequence paramCharSequence)
  {
    a.a(this.b, paramCharSequence);
  }

  public void setClickable(boolean paramBoolean)
  {
    a.c(this.b, paramBoolean);
  }

  public void setContentDescription(CharSequence paramCharSequence)
  {
    a.b(this.b, paramCharSequence);
  }

  public void setEnabled(boolean paramBoolean)
  {
    a.d(this.b, paramBoolean);
  }

  public void setFocusable(boolean paramBoolean)
  {
    a.e(this.b, paramBoolean);
  }

  public void setFocused(boolean paramBoolean)
  {
    a.f(this.b, paramBoolean);
  }

  public void setLongClickable(boolean paramBoolean)
  {
    a.g(this.b, paramBoolean);
  }

  public void setMovementGranularities(int paramInt)
  {
    a.f(this.b, paramInt);
  }

  public void setPackageName(CharSequence paramCharSequence)
  {
    a.c(this.b, paramCharSequence);
  }

  public void setParent(View paramView)
  {
    a.b(this.b, paramView);
  }

  public void setParent(View paramView, int paramInt)
  {
    a.c(this.b, paramView, paramInt);
  }

  public void setPassword(boolean paramBoolean)
  {
    a.h(this.b, paramBoolean);
  }

  public void setScrollable(boolean paramBoolean)
  {
    a.i(this.b, paramBoolean);
  }

  public void setSelected(boolean paramBoolean)
  {
    a.j(this.b, paramBoolean);
  }

  public void setSource(View paramView)
  {
    a.c(this.b, paramView);
  }

  public void setSource(View paramView, int paramInt)
  {
    a.a(this.b, paramView, paramInt);
  }

  public void setText(CharSequence paramCharSequence)
  {
    a.d(this.b, paramCharSequence);
  }

  public void setViewIdResourceName(String paramString)
  {
    a.b(this.b, paramString);
  }

  public void setVisibleToUser(boolean paramBoolean)
  {
    a.k(this.b, paramBoolean);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Rect localRect = new Rect();
    getBoundsInParent(localRect);
    localStringBuilder.append("; boundsInParent: " + localRect);
    getBoundsInScreen(localRect);
    localStringBuilder.append("; boundsInScreen: " + localRect);
    localStringBuilder.append("; packageName: ").append(getPackageName());
    localStringBuilder.append("; className: ").append(getClassName());
    localStringBuilder.append("; text: ").append(getText());
    localStringBuilder.append("; contentDescription: ").append(getContentDescription());
    localStringBuilder.append("; viewId: ").append(getViewIdResourceName());
    localStringBuilder.append("; checkable: ").append(isCheckable());
    localStringBuilder.append("; checked: ").append(isChecked());
    localStringBuilder.append("; focusable: ").append(isFocusable());
    localStringBuilder.append("; focused: ").append(isFocused());
    localStringBuilder.append("; selected: ").append(isSelected());
    localStringBuilder.append("; clickable: ").append(isClickable());
    localStringBuilder.append("; longClickable: ").append(isLongClickable());
    localStringBuilder.append("; enabled: ").append(isEnabled());
    localStringBuilder.append("; password: ").append(isPassword());
    localStringBuilder.append("; scrollable: " + isScrollable());
    localStringBuilder.append("; [");
    int i = getActions();
    if (i != 0)
    {
      int j = 1 << Integer.numberOfTrailingZeros(i);
      int k = i & (j ^ 0xFFFFFFFF);
      String str;
      switch (j)
      {
      default:
        str = "ACTION_UNKNOWN";
      case 1:
      case 2:
      case 4:
      case 8:
      case 16:
      case 32:
      case 64:
      case 128:
      case 256:
      case 512:
      case 1024:
      case 2048:
      case 4096:
      case 8192:
      case 65536:
      case 16384:
      case 32768:
      case 131072:
      }
      while (true)
      {
        localStringBuilder.append(str);
        if (k != 0)
          localStringBuilder.append(", ");
        i = k;
        break;
        str = "ACTION_FOCUS";
        continue;
        str = "ACTION_CLEAR_FOCUS";
        continue;
        str = "ACTION_SELECT";
        continue;
        str = "ACTION_CLEAR_SELECTION";
        continue;
        str = "ACTION_CLICK";
        continue;
        str = "ACTION_LONG_CLICK";
        continue;
        str = "ACTION_ACCESSIBILITY_FOCUS";
        continue;
        str = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        continue;
        str = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        continue;
        str = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        continue;
        str = "ACTION_NEXT_HTML_ELEMENT";
        continue;
        str = "ACTION_PREVIOUS_HTML_ELEMENT";
        continue;
        str = "ACTION_SCROLL_FORWARD";
        continue;
        str = "ACTION_SCROLL_BACKWARD";
        continue;
        str = "ACTION_CUT";
        continue;
        str = "ACTION_COPY";
        continue;
        str = "ACTION_PASTE";
        continue;
        str = "ACTION_SET_SELECTION";
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat
 * JD-Core Version:    0.6.2
 */