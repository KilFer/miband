package u.aly;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class cP
  implements Comparator
{
  public final int compare(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null))
      return 0;
    if (paramObject1 == null)
      return -1;
    if (paramObject2 == null)
      return 1;
    if ((paramObject1 instanceof List))
      return ca.a((List)paramObject1, (List)paramObject2);
    if ((paramObject1 instanceof Set))
      return ca.a((Set)paramObject1, (Set)paramObject2);
    if ((paramObject1 instanceof Map))
      return ca.a((Map)paramObject1, (Map)paramObject2);
    if ((paramObject1 instanceof byte[]))
      return ca.a((byte[])paramObject1, (byte[])paramObject2);
    return ca.a((Comparable)paramObject1, (Comparable)paramObject2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.cP
 * JD-Core Version:    0.6.2
 */