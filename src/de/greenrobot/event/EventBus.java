package de.greenrobot.event;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class EventBus
{
  public static String TAG = "Event";
  private static volatile EventBus defaultInstance;
  private static final Map<Class<?>, List<Class<?>>> eventTypesCache = new HashMap();
  static ExecutorService executorService = Executors.newCachedThreadPool();
  private final AsyncPoster asyncPoster = new AsyncPoster(this);
  private final BackgroundPoster backgroundPoster = new BackgroundPoster(this);
  private final ThreadLocal<List<Object>> currentThreadEventQueue = new EventBus.1(this);
  private final ThreadLocal<EventBus.BooleanWrapper> currentThreadIsPosting = new EventBus.2(this);
  private String defaultMethodName = "onEvent";
  private boolean logSubscriberExceptions = true;
  private final HandlerPoster mainThreadPoster = new HandlerPoster(this, Looper.getMainLooper(), 10);
  private final Map<Class<?>, Object> stickyEvents = new ConcurrentHashMap();
  private boolean subscribed;
  private final SubscriberMethodFinder subscriberMethodFinder = new SubscriberMethodFinder();
  private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType = new HashMap();
  private final Map<Object, List<Class<?>>> typesBySubscriber = new HashMap();

  static void addInterfaces(List<Class<?>> paramList, Class<?>[] paramArrayOfClass)
  {
    int i = paramArrayOfClass.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return;
      Class<?> localClass = paramArrayOfClass[j];
      if (!paramList.contains(localClass))
      {
        paramList.add(localClass);
        addInterfaces(paramList, localClass.getInterfaces());
      }
    }
  }

  public static void clearCaches()
  {
    SubscriberMethodFinder.clearCaches();
    eventTypesCache.clear();
  }

  public static void clearSkipMethodNameVerifications()
  {
    SubscriberMethodFinder.clearSkipMethodNameVerifications();
  }

  private List<Class<?>> findEventTypes(Class<?> paramClass)
  {
    synchronized (eventTypesCache)
    {
      Object localObject2 = (List)eventTypesCache.get(paramClass);
      if (localObject2 == null)
      {
        localObject2 = new ArrayList();
        localObject3 = paramClass;
        if (localObject3 == null)
          eventTypesCache.put(paramClass, localObject2);
      }
      else
      {
        return localObject2;
      }
      ((List)localObject2).add(localObject3);
      addInterfaces((List)localObject2, ((Class)localObject3).getInterfaces());
      Class localClass = ((Class)localObject3).getSuperclass();
      Object localObject3 = localClass;
    }
  }

  public static EventBus getDefault()
  {
    if (defaultInstance == null);
    try
    {
      if (defaultInstance == null)
        defaultInstance = new EventBus();
      return defaultInstance;
    }
    finally
    {
    }
  }

  private void postSingleEvent(Object paramObject, boolean paramBoolean)
  {
    Class localClass1 = paramObject.getClass();
    List localList = findEventTypes(localClass1);
    int i = localList.size();
    int j = 0;
    int k = 0;
    if (j >= i)
    {
      if (k == 0)
      {
        Log.d(TAG, "No subscripers registered for event " + localClass1);
        if ((localClass1 != NoSubscriberEvent.class) && (localClass1 != SubscriberExceptionEvent.class))
          post(new NoSubscriberEvent(this, paramObject));
      }
      return;
    }
    Class localClass2 = (Class)localList.get(j);
    while (true)
    {
      Iterator localIterator;
      try
      {
        CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.subscriptionsByEventType.get(localClass2);
        if (localCopyOnWriteArrayList == null)
          break label183;
        localIterator = localCopyOnWriteArrayList.iterator();
        if (!localIterator.hasNext())
        {
          m = 1;
          j++;
          k = m;
        }
      }
      finally
      {
      }
      continue;
      label183: int m = k;
    }
  }

  private void postToSubscription(Subscription paramSubscription, Object paramObject, boolean paramBoolean)
  {
    switch ($SWITCH_TABLE$de$greenrobot$event$ThreadMode()[paramSubscription.subscriberMethod.threadMode.ordinal()])
    {
    default:
      throw new IllegalStateException("Unknown thread mode: " + paramSubscription.subscriberMethod.threadMode);
    case 1:
      invokeSubscriber(paramSubscription, paramObject);
      return;
    case 2:
      if (paramBoolean)
      {
        invokeSubscriber(paramSubscription, paramObject);
        return;
      }
      this.mainThreadPoster.enqueue(paramSubscription, paramObject);
      return;
    case 3:
      if (paramBoolean)
      {
        this.backgroundPoster.enqueue(paramSubscription, paramObject);
        return;
      }
      invokeSubscriber(paramSubscription, paramObject);
      return;
    case 4:
    }
    this.asyncPoster.enqueue(paramSubscription, paramObject);
  }

  private void register(Object paramObject, String paramString, boolean paramBoolean)
  {
    Iterator localIterator = this.subscriberMethodFinder.findSubscriberMethods(paramObject.getClass(), paramString).iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      subscribe(paramObject, (SubscriberMethod)localIterator.next(), paramBoolean);
    }
  }

  private void register(Object paramObject, String paramString, boolean paramBoolean, Class<?> paramClass, Class<?>[] paramArrayOfClass)
  {
    label130: 
    while (true)
    {
      SubscriberMethod localSubscriberMethod;
      try
      {
        Class localClass = paramObject.getClass();
        Iterator localIterator = this.subscriberMethodFinder.findSubscriberMethods(localClass, paramString).iterator();
        boolean bool = localIterator.hasNext();
        if (!bool)
          return;
        localSubscriberMethod = (SubscriberMethod)localIterator.next();
        if (paramClass == localSubscriberMethod.eventType)
        {
          subscribe(paramObject, localSubscriberMethod, paramBoolean);
          continue;
        }
      }
      finally
      {
      }
      if (paramArrayOfClass != null)
      {
        int i = paramArrayOfClass.length;
        for (int j = 0; ; j++)
        {
          if (j >= i)
            break label130;
          if (paramArrayOfClass[j] == localSubscriberMethod.eventType)
          {
            subscribe(paramObject, localSubscriberMethod, paramBoolean);
            break;
          }
        }
      }
    }
  }

  public static void skipMethodNameVerificationFor(Class<?> paramClass)
  {
    SubscriberMethodFinder.skipMethodNameVerificationFor(paramClass);
  }

  private void subscribe(Object paramObject, SubscriberMethod paramSubscriberMethod, boolean paramBoolean)
  {
    this.subscribed = true;
    Class localClass = paramSubscriberMethod.eventType;
    CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.subscriptionsByEventType.get(localClass);
    Subscription localSubscription = new Subscription(paramObject, paramSubscriberMethod);
    if (localCopyOnWriteArrayList == null)
    {
      localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      this.subscriptionsByEventType.put(localClass, localCopyOnWriteArrayList);
      paramSubscriberMethod.method.setAccessible(true);
      localCopyOnWriteArrayList.add(localSubscription);
      Object localObject1 = (List)this.typesBySubscriber.get(paramObject);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        this.typesBySubscriber.put(paramObject, localObject1);
      }
      ((List)localObject1).add(localClass);
      if (!paramBoolean);
    }
    while (true)
    {
      synchronized (this.stickyEvents)
      {
        Object localObject3 = this.stickyEvents.get(localClass);
        if (localObject3 != null)
        {
          if (Looper.getMainLooper() == Looper.myLooper())
          {
            bool = true;
            postToSubscription(localSubscription, localObject3, bool);
          }
        }
        else
        {
          return;
          Iterator localIterator = localCopyOnWriteArrayList.iterator();
          if (!localIterator.hasNext())
            break;
          if (!((Subscription)localIterator.next()).equals(localSubscription))
            continue;
          throw new EventBusException("Subscriber " + paramObject.getClass() + " already registered to event " + localClass);
        }
      }
      boolean bool = false;
    }
  }

  private void unubscribeByEventType(Object paramObject, Class<?> paramClass)
  {
    List localList = (List)this.subscriptionsByEventType.get(paramClass);
    int i;
    int j;
    if (localList != null)
    {
      i = localList.size();
      j = 0;
      if (j < i);
    }
    else
    {
      return;
    }
    int k;
    if (((Subscription)localList.get(j)).subscriber == paramObject)
    {
      localList.remove(j);
      k = j - 1;
    }
    for (int m = i - 1; ; m = i)
    {
      int n = k + 1;
      i = m;
      j = n;
      break;
      k = j;
    }
  }

  public final void configureLogSubscriberExceptions(boolean paramBoolean)
  {
    if (this.subscribed)
      throw new EventBusException("This method must be called before any registration");
    this.logSubscriberExceptions = paramBoolean;
  }

  public final Object getStickyEvent(Class<?> paramClass)
  {
    synchronized (this.stickyEvents)
    {
      Object localObject2 = this.stickyEvents.get(paramClass);
      return localObject2;
    }
  }

  final void invokeSubscriber(PendingPost paramPendingPost)
  {
    Object localObject = paramPendingPost.event;
    Subscription localSubscription = paramPendingPost.subscription;
    PendingPost.releasePendingPost(paramPendingPost);
    invokeSubscriber(localSubscription, localObject);
  }

  final void invokeSubscriber(Subscription paramSubscription, Object paramObject)
  {
    try
    {
      paramSubscription.subscriberMethod.method.invoke(paramSubscription.subscriber, new Object[] { paramObject });
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      if ((paramObject instanceof SubscriberExceptionEvent))
      {
        Log.e(TAG, "SubscriberExceptionEvent subscriber " + paramSubscription.subscriber.getClass() + " threw an exception", localThrowable);
        SubscriberExceptionEvent localSubscriberExceptionEvent = (SubscriberExceptionEvent)paramObject;
        Log.e(TAG, "Initial event " + localSubscriberExceptionEvent.causingEvent + " caused exception in " + localSubscriberExceptionEvent.causingSubscriber, localSubscriberExceptionEvent.throwable);
        return;
      }
      if (this.logSubscriberExceptions)
        Log.e(TAG, "Could not dispatch event: " + paramObject.getClass() + " to subscribing class " + paramSubscription.subscriber.getClass(), localThrowable);
      post(new SubscriberExceptionEvent(this, localThrowable, paramObject, paramSubscription.subscriber));
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalStateException("Unexpected exception", localIllegalAccessException);
    }
  }

  public final void post(Object paramObject)
  {
    List localList = (List)this.currentThreadEventQueue.get();
    localList.add(paramObject);
    EventBus.BooleanWrapper localBooleanWrapper = (EventBus.BooleanWrapper)this.currentThreadIsPosting.get();
    if (localBooleanWrapper.value)
      return;
    boolean bool1;
    if (Looper.getMainLooper() == Looper.myLooper())
      bool1 = true;
    while (true)
    {
      localBooleanWrapper.value = true;
      try
      {
        while (true)
        {
          boolean bool2 = localList.isEmpty();
          if (bool2)
          {
            return;
            bool1 = false;
            break;
          }
          postSingleEvent(localList.remove(0), bool1);
        }
      }
      finally
      {
        localBooleanWrapper.value = false;
      }
    }
  }

  public final void postSticky(Object paramObject)
  {
    post(paramObject);
    synchronized (this.stickyEvents)
    {
      this.stickyEvents.put(paramObject.getClass(), paramObject);
      return;
    }
  }

  public final void register(Object paramObject)
  {
    register(paramObject, this.defaultMethodName, false);
  }

  public final void register(Object paramObject, Class<?> paramClass, Class<?>[] paramArrayOfClass)
  {
    register(paramObject, this.defaultMethodName, false, paramClass, paramArrayOfClass);
  }

  public final void register(Object paramObject, String paramString)
  {
    register(paramObject, paramString, false);
  }

  public final void register(Object paramObject, String paramString, Class<?> paramClass, Class<?>[] paramArrayOfClass)
  {
    try
    {
      register(paramObject, paramString, false, paramClass, paramArrayOfClass);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void registerSticky(Object paramObject)
  {
    register(paramObject, this.defaultMethodName, true);
  }

  public final void registerSticky(Object paramObject, Class<?> paramClass, Class<?>[] paramArrayOfClass)
  {
    register(paramObject, this.defaultMethodName, true, paramClass, paramArrayOfClass);
  }

  public final void registerSticky(Object paramObject, String paramString)
  {
    register(paramObject, paramString, true);
  }

  public final void registerSticky(Object paramObject, String paramString, Class<?> paramClass, Class<?>[] paramArrayOfClass)
  {
    try
    {
      register(paramObject, paramString, true, paramClass, paramArrayOfClass);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final Object removeStickyEvent(Class<?> paramClass)
  {
    synchronized (this.stickyEvents)
    {
      Object localObject2 = this.stickyEvents.remove(paramClass);
      return localObject2;
    }
  }

  public final boolean removeStickyEvent(Object paramObject)
  {
    synchronized (this.stickyEvents)
    {
      Class localClass = paramObject.getClass();
      if (paramObject.equals(this.stickyEvents.get(localClass)))
      {
        this.stickyEvents.remove(localClass);
        return true;
      }
      return false;
    }
  }

  public final void unregister(Object paramObject)
  {
    while (true)
    {
      try
      {
        List localList = (List)this.typesBySubscriber.get(paramObject);
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          if (!localIterator.hasNext())
          {
            this.typesBySubscriber.remove(paramObject);
            return;
          }
          unubscribeByEventType(paramObject, (Class)localIterator.next());
          continue;
        }
      }
      finally
      {
      }
      Log.w(TAG, "Subscriber to unregister was not registered before: " + paramObject.getClass());
    }
  }

  public final void unregister(Object paramObject, Class<?>[] paramArrayOfClass)
  {
    try
    {
      if (paramArrayOfClass.length == 0)
        throw new IllegalArgumentException("Provide at least one event class");
    }
    finally
    {
    }
    List localList = (List)this.typesBySubscriber.get(paramObject);
    int j;
    if (localList != null)
    {
      int i = paramArrayOfClass.length;
      j = 0;
      if (j >= i)
        if (localList.isEmpty())
          this.typesBySubscriber.remove(paramObject);
    }
    while (true)
    {
      return;
      Class<?> localClass = paramArrayOfClass[j];
      unubscribeByEventType(paramObject, localClass);
      localList.remove(localClass);
      j++;
      break;
      Log.w(TAG, "Subscriber to unregister was not registered before: " + paramObject.getClass());
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.event.EventBus
 * JD-Core Version:    0.6.2
 */