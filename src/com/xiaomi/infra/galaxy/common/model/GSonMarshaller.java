package com.xiaomi.infra.galaxy.common.model;

import com.google.gson.Gson;

public class GSonMarshaller
  implements GalaxyMarshaller
{
  private static final GSonMarshaller marshaller = new GSonMarshaller();

  public static GSonMarshaller getInstance()
  {
    return marshaller;
  }

  public <T> String marshall(T paramT)
  {
    return new Gson().toJson(paramT);
  }

  public <T> T unmarshall(Class<T> paramClass, String paramString)
  {
    return new Gson().fromJson(paramString, paramClass);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.GSonMarshaller
 * JD-Core Version:    0.6.2
 */