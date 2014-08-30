package com.xiaomi.infra.galaxy.common.model;

public abstract interface GalaxyMarshaller
{
  public abstract <T> String marshall(T paramT);

  public abstract <T> T unmarshall(Class<T> paramClass, String paramString);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.GalaxyMarshaller
 * JD-Core Version:    0.6.2
 */