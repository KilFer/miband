package com.tencent.stat;

import com.tencent.stat.common.StatLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class q
  implements Runnable
{
  q(StatStore paramStatStore, int paramInt)
  {
  }

  public final void run()
  {
    if (this.b.a == 0)
      return;
    StatStore.a().i("Load " + Integer.toString(this.b.a) + " unsent events");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = this.a;
    if ((i == -1) || (i > StatConfig.a()));
    for (int j = StatConfig.a(); ; j = i)
    {
      StatStore localStatStore = this.b;
      localStatStore.a -= j;
      StatStore.b(this.b, localArrayList2, j);
      StatStore.a().i("Peek " + Integer.toString(localArrayList2.size()) + " unsent events.");
      if (localArrayList2.isEmpty())
        break;
      StatStore.a(this.b, localArrayList2, 2);
      Iterator localIterator = localArrayList2.iterator();
      while (localIterator.hasNext())
        localArrayList1.add(((t)localIterator.next()).b);
      c.b().b(localArrayList1, new r(this, localArrayList2, j));
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.q
 * JD-Core Version:    0.6.2
 */