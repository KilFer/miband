package de.greenrobot.event;

final class Subscription
{
  final Object subscriber;
  final SubscriberMethod subscriberMethod;

  Subscription(Object paramObject, SubscriberMethod paramSubscriberMethod)
  {
    this.subscriber = paramObject;
    this.subscriberMethod = paramSubscriberMethod;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Subscription;
    boolean bool2 = false;
    if (bool1)
    {
      Subscription localSubscription = (Subscription)paramObject;
      Object localObject1 = this.subscriber;
      Object localObject2 = localSubscription.subscriber;
      bool2 = false;
      if (localObject1 == localObject2)
      {
        boolean bool3 = this.subscriberMethod.equals(localSubscription.subscriberMethod);
        bool2 = false;
        if (bool3)
          bool2 = true;
      }
    }
    return bool2;
  }

  public final int hashCode()
  {
    return this.subscriber.hashCode() + this.subscriberMethod.methodString.hashCode();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.event.Subscription
 * JD-Core Version:    0.6.2
 */