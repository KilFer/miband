package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.InputStreamEntity;

public class RepeatableInputStreamRequestEntity extends BasicHttpEntity
{
  private static final Log log = LogFactory.getLog(RepeatableInputStreamRequestEntity.class);
  private InputStream content;
  private boolean firstAttempt = true;
  private InputStreamEntity inputStreamRequestEntity;
  private IOException originalException;

  public RepeatableInputStreamRequestEntity(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    setChunked(false);
    long l1 = -1L;
    try
    {
      String str2 = (String)paramBasicGalaxyRequest.getHeaders().get("Content-Length");
      if (str2 != null)
      {
        long l2 = Long.parseLong(str2);
        l3 = l2;
        l1 = l3;
        String str1 = (String)paramBasicGalaxyRequest.getHeaders().get("Content-Type");
        this.inputStreamRequestEntity = new InputStreamEntity(paramBasicGalaxyRequest.getContent(), l1);
        this.inputStreamRequestEntity.setContentType(str1);
        this.content = paramBasicGalaxyRequest.getContent();
        setContent(this.content);
        setContentType(str1);
        setContentLength(l1);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        log.warn("Unable to parse content length from request.  Buffering contents in memory.");
        continue;
        long l3 = l1;
      }
    }
  }

  public boolean isChunked()
  {
    return false;
  }

  public boolean isRepeatable()
  {
    return (this.content.markSupported()) || (this.inputStreamRequestEntity.isRepeatable());
  }

  public void writeTo(OutputStream paramOutputStream)
  {
    try
    {
      if ((!this.firstAttempt) && (isRepeatable()))
        this.content.reset();
      this.firstAttempt = false;
      this.inputStreamRequestEntity.writeTo(paramOutputStream);
      return;
    }
    catch (IOException localIOException)
    {
      if (this.originalException == null)
        this.originalException = localIOException;
    }
    throw this.originalException;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.http.RepeatableInputStreamRequestEntity
 * JD-Core Version:    0.6.2
 */