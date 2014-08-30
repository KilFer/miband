package com.xiaomi.infra.galaxy.common.model;

import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

public class JsonMarshaller
  implements GalaxyMarshaller
{
  private static final JsonMarshaller marshaller = new JsonMarshaller();
  private ObjectMapper mapper = new ObjectMapper();

  private JsonMarshaller()
  {
    this.mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    this.mapper.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
    this.mapper.getDeserializationConfig().set(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public static JsonMarshaller getInstance()
  {
    return marshaller;
  }

  public <T> String marshall(T paramT)
  {
    try
    {
      String str = this.mapper.writeValueAsString(paramT);
      return str;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public <T> byte[] marshallBytes(T paramT)
  {
    try
    {
      byte[] arrayOfByte = this.mapper.writeValueAsBytes(paramT);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public <T> T unmarshall(Class<T> paramClass, String paramString)
  {
    try
    {
      Object localObject = this.mapper.readValue(paramString, paramClass);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.JsonMarshaller
 * JD-Core Version:    0.6.2
 */