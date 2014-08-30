package cn.com.smartdevices.bracelet.lua;

import de.greenrobot.daobracelet.LuaList;
import java.util.Comparator;

public class LuaListAdapter$MyComparator
  implements Comparator<LuaList>
{
  public LuaListAdapter$MyComparator(LuaListAdapter paramLuaListAdapter)
  {
  }

  public int compare(LuaList paramLuaList1, LuaList paramLuaList2)
  {
    int i = -1;
    String str1 = paramLuaList2.getRight();
    String str2 = paramLuaList1.getRight();
    if ((str1 == null) && (str2 == null))
      i = 0;
    do
    {
      do
        return i;
      while ((str1 == null) && (str2 != null));
      if ((str1 != null) && (str2 == null))
        return 1;
      if (str1.length() > str2.length())
        return 1;
    }
    while (str1.length() < str2.length());
    return str1.compareTo(str2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.LuaListAdapter.MyComparator
 * JD-Core Version:    0.6.2
 */