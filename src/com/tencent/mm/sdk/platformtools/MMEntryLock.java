package com.tencent.mm.sdk.platformtools;

import java.util.HashSet;
import java.util.Set;

public final class MMEntryLock
{
  private static Set<String> a = new HashSet();

  public static boolean isLocked(String paramString)
  {
    return a.contains(paramString);
  }

  public static boolean lock(String paramString)
  {
    if (isLocked(paramString))
    {
      Log.d("MicroMsg.MMEntryLock", "locked-" + paramString);
      return false;
    }
    Log.d("MicroMsg.MMEntryLock", "lock-" + paramString);
    return a.add(paramString);
  }

  public static void unlock(String paramString)
  {
    a.remove(paramString);
    Log.d("MicroMsg.MMEntryLock", "unlock-" + paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMEntryLock
 * JD-Core Version:    0.6.2
 */