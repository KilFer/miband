package de.greenrobot.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class SubscriberMethodFinder
{
  private static final Map<String, List<SubscriberMethod>> methodCache = new HashMap();
  private static final Map<Class<?>, Class<?>> skipMethodNameVerificationForClasses = new ConcurrentHashMap();

  static void clearCaches()
  {
    methodCache.clear();
  }

  public static void clearSkipMethodNameVerifications()
  {
    skipMethodNameVerificationForClasses.clear();
  }

  static void skipMethodNameVerificationFor(Class<?> paramClass)
  {
    if (!methodCache.isEmpty())
      throw new IllegalStateException("This method must be called before registering anything");
    skipMethodNameVerificationForClasses.put(paramClass, paramClass);
  }

  List<SubscriberMethod> findSubscriberMethods(Class<?> paramClass, String paramString)
  {
    String str1 = paramClass.getName() + '.' + paramString;
    synchronized (methodCache)
    {
      List localList = (List)methodCache.get(str1);
      if (localList != null)
        return localList;
    }
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder();
    Method[] arrayOfMethod;
    int j;
    for (Object localObject2 = paramClass; ; localObject2 = ((Class)localObject2).getSuperclass())
    {
      if (localObject2 == null);
      String str2;
      do
      {
        if (!localArrayList.isEmpty())
          break;
        throw new EventBusException("Subscriber " + paramClass + " has no methods called " + paramString);
        str2 = ((Class)localObject2).getName();
      }
      while ((str2.startsWith("java.")) || (str2.startsWith("javax.")) || (str2.startsWith("android.")));
      arrayOfMethod = ((Class)localObject2).getDeclaredMethods();
      int i = arrayOfMethod.length;
      j = 0;
      if (j < i)
        break;
    }
    Method localMethod = arrayOfMethod[j];
    String str3 = localMethod.getName();
    String str4;
    ThreadMode localThreadMode;
    if (str3.startsWith(paramString))
    {
      Class[] arrayOfClass = localMethod.getParameterTypes();
      if (arrayOfClass.length == 1)
      {
        str4 = str3.substring(paramString.length());
        if (str4.length() != 0)
          break label352;
        localThreadMode = ThreadMode.PostThread;
        label276: Class localClass = arrayOfClass[0];
        localStringBuilder.setLength(0);
        localStringBuilder.append(str3);
        localStringBuilder.append('>').append(localClass.getName());
        if (localHashSet.add(localStringBuilder.toString()))
          localArrayList.add(new SubscriberMethod(localMethod, localThreadMode, localClass));
      }
    }
    label352: 
    do
    {
      j++;
      break;
      if (str4.equals("MainThread"))
      {
        localThreadMode = ThreadMode.MainThread;
        break label276;
      }
      if (str4.equals("BackgroundThread"))
      {
        localThreadMode = ThreadMode.BackgroundThread;
        break label276;
      }
      if (str4.equals("Async"))
      {
        localThreadMode = ThreadMode.Async;
        break label276;
      }
    }
    while (skipMethodNameVerificationForClasses.containsKey(localObject2));
    throw new EventBusException("Illegal onEvent method, check for typos: " + localMethod);
    synchronized (methodCache)
    {
      methodCache.put(str1, localArrayList);
      return localArrayList;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.event.SubscriberMethodFinder
 * JD-Core Version:    0.6.2
 */