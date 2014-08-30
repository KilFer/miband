package com.tencent.a.a;

import java.io.File;
import java.io.FileFilter;

final class j
  implements FileFilter
{
  j(h paramh)
  {
  }

  public final boolean accept(File paramFile)
  {
    if (!paramFile.getName().endsWith(this.a.j()));
    while (h.d(paramFile) == -1)
      return false;
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.a.a.j
 * JD-Core Version:    0.6.2
 */