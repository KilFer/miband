package cn.com.smartdevices.bracelet.lua;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import cn.com.smartdevices.bracelet.Debug;

final class e
  implements View.OnTouchListener
{
  e(LuaListAdapterFake paramLuaListAdapterFake)
  {
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Debug.i("chenee", "blank list item touched");
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.e
 * JD-Core Version:    0.6.2
 */