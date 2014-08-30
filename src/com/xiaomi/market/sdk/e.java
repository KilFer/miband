package com.xiaomi.market.sdk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class e extends i
{
  private File a;

  public e(c paramc, File paramFile)
  {
    super(paramc, new FileOutputStream(paramFile));
    this.a = paramFile;
  }

  public void reset()
  {
    try
    {
      this.S.close();
      label7: this.a.delete();
      try
      {
        this.S = new FileOutputStream(this.a);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
      }
    }
    catch (IOException localIOException)
    {
      break label7;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.e
 * JD-Core Version:    0.6.2
 */