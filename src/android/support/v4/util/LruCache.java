package android.support.v4.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;

  public LruCache(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("maxSize <= 0");
    this.c = paramInt;
    this.a = new LinkedHashMap(0, 0.75F, true);
  }

  private int a(K paramK, V paramV)
  {
    int i = sizeOf(paramK, paramV);
    if (i < 0)
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
    return i;
  }

  protected V create(K paramK)
  {
    return null;
  }

  public final int createCount()
  {
    try
    {
      int i = this.e;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2)
  {
  }

  public final void evictAll()
  {
    trimToSize(-1);
  }

  public final int evictionCount()
  {
    try
    {
      int i = this.f;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final V get(K paramK)
  {
    if (paramK == null)
      throw new NullPointerException("key == null");
    Object localObject3;
    try
    {
      Object localObject2 = this.a.get(paramK);
      if (localObject2 != null)
      {
        this.g = (1 + this.g);
        return localObject2;
      }
      this.h = (1 + this.h);
      localObject3 = create(paramK);
      if (localObject3 == null)
        return null;
    }
    finally
    {
    }
    try
    {
      this.e = (1 + this.e);
      Object localObject5 = this.a.put(paramK, localObject3);
      if (localObject5 != null)
        this.a.put(paramK, localObject5);
      while (true)
      {
        if (localObject5 == null)
          break;
        entryRemoved(false, paramK, localObject3, localObject5);
        return localObject5;
        this.b += a(paramK, localObject3);
      }
    }
    finally
    {
    }
    trimToSize(this.c);
    return localObject3;
  }

  public final int hitCount()
  {
    try
    {
      int i = this.g;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final int maxSize()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final int missCount()
  {
    try
    {
      int i = this.h;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null))
      throw new NullPointerException("key == null || value == null");
    try
    {
      this.d = (1 + this.d);
      this.b += a(paramK, paramV);
      Object localObject2 = this.a.put(paramK, paramV);
      if (localObject2 != null)
        this.b -= a(paramK, localObject2);
      if (localObject2 != null)
        entryRemoved(false, paramK, localObject2, paramV);
      trimToSize(this.c);
      return localObject2;
    }
    finally
    {
    }
  }

  public final int putCount()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final V remove(K paramK)
  {
    if (paramK == null)
      throw new NullPointerException("key == null");
    try
    {
      Object localObject2 = this.a.remove(paramK);
      if (localObject2 != null)
        this.b -= a(paramK, localObject2);
      if (localObject2 != null)
        entryRemoved(false, paramK, localObject2, null);
      return localObject2;
    }
    finally
    {
    }
  }

  public final int size()
  {
    try
    {
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected int sizeOf(K paramK, V paramV)
  {
    return 1;
  }

  public final Map<K, V> snapshot()
  {
    try
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.a);
      return localLinkedHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String toString()
  {
    try
    {
      int i = this.g + this.h;
      int j = 0;
      if (i != 0)
        j = 100 * this.g / i;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(this.c);
      arrayOfObject[1] = Integer.valueOf(this.g);
      arrayOfObject[2] = Integer.valueOf(this.h);
      arrayOfObject[3] = Integer.valueOf(j);
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", arrayOfObject);
      return str;
    }
    finally
    {
    }
  }

  // ERROR //
  public void trimToSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 100	android/support/v4/util/LruCache:b	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 38	android/support/v4/util/LruCache:a	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 137	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 100	android/support/v4/util/LruCache:b	I
    //   23: ifeq +41 -> 64
    //   26: new 44	java/lang/IllegalStateException
    //   29: dup
    //   30: new 46	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 142	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 147	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 149
    //   49: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 63	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 100	android/support/v4/util/LruCache:b	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 38	android/support/v4/util/LruCache:a	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 137	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 38	android/support/v4/util/LruCache:a	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 153	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 159 1 0
    //   97: invokeinterface 165 1 0
    //   102: checkcast 167	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 170 1 0
    //   112: astore 4
    //   114: aload_3
    //   115: invokeinterface 173 1 0
    //   120: astore 5
    //   122: aload_0
    //   123: getfield 38	android/support/v4/util/LruCache:a	Ljava/util/LinkedHashMap;
    //   126: aload 4
    //   128: invokevirtual 113	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   131: pop
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 100	android/support/v4/util/LruCache:b	I
    //   137: aload_0
    //   138: aload 4
    //   140: aload 5
    //   142: invokespecial 102	android/support/v4/util/LruCache:a	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   145: isub
    //   146: putfield 100	android/support/v4/util/LruCache:b	I
    //   149: aload_0
    //   150: iconst_1
    //   151: aload_0
    //   152: getfield 78	android/support/v4/util/LruCache:f	I
    //   155: iadd
    //   156: putfield 78	android/support/v4/util/LruCache:f	I
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_0
    //   162: iconst_1
    //   163: aload 4
    //   165: aload 5
    //   167: aconst_null
    //   168: invokevirtual 98	android/support/v4/util/LruCache:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   171: goto -171 -> 0
    //
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	59	59	finally
    //   64	82	59	finally
    //   82	84	59	finally
    //   85	161	59	finally
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.LruCache
 * JD-Core Version:    0.6.2
 */