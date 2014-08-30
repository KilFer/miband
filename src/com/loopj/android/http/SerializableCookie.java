package com.loopj.android.http;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class SerializableCookie
  implements Serializable
{
  private static final long serialVersionUID = 6374381828722046732L;
  private final transient Cookie a;
  private transient BasicClientCookie b;

  public SerializableCookie(Cookie paramCookie)
  {
    this.a = paramCookie;
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    this.b = new BasicClientCookie((String)paramObjectInputStream.readObject(), (String)paramObjectInputStream.readObject());
    this.b.setComment((String)paramObjectInputStream.readObject());
    this.b.setDomain((String)paramObjectInputStream.readObject());
    this.b.setExpiryDate((Date)paramObjectInputStream.readObject());
    this.b.setPath((String)paramObjectInputStream.readObject());
    this.b.setVersion(paramObjectInputStream.readInt());
    this.b.setSecure(paramObjectInputStream.readBoolean());
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeObject(this.a.getName());
    paramObjectOutputStream.writeObject(this.a.getValue());
    paramObjectOutputStream.writeObject(this.a.getComment());
    paramObjectOutputStream.writeObject(this.a.getDomain());
    paramObjectOutputStream.writeObject(this.a.getExpiryDate());
    paramObjectOutputStream.writeObject(this.a.getPath());
    paramObjectOutputStream.writeInt(this.a.getVersion());
    paramObjectOutputStream.writeBoolean(this.a.isSecure());
  }

  public Cookie getCookie()
  {
    Object localObject = this.a;
    if (this.b != null)
      localObject = this.b;
    return localObject;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.SerializableCookie
 * JD-Core Version:    0.6.2
 */