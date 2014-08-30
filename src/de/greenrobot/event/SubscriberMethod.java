package de.greenrobot.event;

import java.lang.reflect.Method;

final class SubscriberMethod
{
  final Class<?> eventType;
  final Method method;
  String methodString;
  final ThreadMode threadMode;

  SubscriberMethod(Method paramMethod, ThreadMode paramThreadMode, Class<?> paramClass)
  {
    this.method = paramMethod;
    this.threadMode = paramThreadMode;
    this.eventType = paramClass;
  }

  private void checkMethodString()
  {
    try
    {
      if (this.methodString == null)
      {
        StringBuilder localStringBuilder = new StringBuilder(64);
        localStringBuilder.append(this.method.getDeclaringClass().getName());
        localStringBuilder.append('#').append(this.method.getName());
        localStringBuilder.append('(').append(this.eventType.getName());
        this.methodString = localStringBuilder.toString();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof SubscriberMethod))
    {
      checkMethodString();
      return this.methodString.equals(((SubscriberMethod)paramObject).methodString);
    }
    return false;
  }

  public final int hashCode()
  {
    return this.method.hashCode();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.event.SubscriberMethod
 * JD-Core Version:    0.6.2
 */