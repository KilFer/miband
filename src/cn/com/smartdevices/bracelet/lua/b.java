package cn.com.smartdevices.bracelet.lua;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import de.greenrobot.daobracelet.LuaList;
import java.util.HashMap;

final class b
  implements View.OnClickListener
{
  b(LuaListAdapter paramLuaListAdapter)
  {
  }

  public final void onClick(View paramView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "EventSlidePanelListItemClick");
    UmengAnalytics.event(LuaListAdapter.access$0(this.a), "EventSlidePanel", localHashMap);
    String str = ((LuaList)((d)paramView.getTag()).a.getTag()).getLuaActionScript();
    if ((str == null) || (str.length() < 5))
      return;
    try
    {
      if (str.startsWith("http://"))
      {
        Debug.e("chenee", "should not use http:// use script directly instead!!(script:" + str + ")");
        return;
      }
    }
    catch (Exception localException)
    {
      Debug.e("chenee", localException.getMessage());
      return;
    }
    if (str.startsWith("file://"))
    {
      Debug.e("chenee", "should not use file:// use script directly instead!!(script:" + str + ")");
      return;
    }
    LuaAction.getInstance(LuaListAdapter.access$0(this.a)).doLuaAction(str);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.b
 * JD-Core Version:    0.6.2
 */