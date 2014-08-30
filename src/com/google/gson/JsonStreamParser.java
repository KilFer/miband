package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class JsonStreamParser
  implements Iterator<JsonElement>
{
  private final JsonReader a;
  private final Object b;

  public JsonStreamParser(Reader paramReader)
  {
    this.a = new JsonReader(paramReader);
    this.a.setLenient(true);
    this.b = new Object();
  }

  public JsonStreamParser(String paramString)
  {
    this(new StringReader(paramString));
  }

  public final boolean hasNext()
  {
    while (true)
    {
      try
      {
        synchronized (this.b)
        {
          try
          {
            JsonToken localJsonToken1 = this.a.peek();
            JsonToken localJsonToken2 = JsonToken.END_DOCUMENT;
            if (localJsonToken1 != localJsonToken2)
            {
              bool = true;
              return bool;
            }
          }
          catch (MalformedJsonException localMalformedJsonException)
          {
            throw new JsonSyntaxException(localMalformedJsonException);
          }
        }
      }
      catch (IOException localIOException)
      {
        throw new JsonIOException(localIOException);
      }
      boolean bool = false;
    }
  }

  public final JsonElement next()
  {
    if (!hasNext())
      throw new NoSuchElementException();
    try
    {
      JsonElement localJsonElement = Streams.parse(this.a);
      return localJsonElement;
    }
    catch (StackOverflowError localStackOverflowError)
    {
      throw new JsonParseException("Failed parsing JSON source to Json", localStackOverflowError);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      throw new JsonParseException("Failed parsing JSON source to Json", localOutOfMemoryError);
    }
    catch (JsonParseException localJsonParseException)
    {
      NoSuchElementException localNoSuchElementException;
      if ((localJsonParseException.getCause() instanceof EOFException))
        localNoSuchElementException = new NoSuchElementException();
      throw localNoSuchElementException;
    }
  }

  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.JsonStreamParser
 * JD-Core Version:    0.6.2
 */