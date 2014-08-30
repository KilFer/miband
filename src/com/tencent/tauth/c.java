package com.tencent.tauth;

import com.tencent.connect.a.a;

final class c
  implements Runnable
{
  c(LocationApi paramLocationApi, String[] paramArrayOfString, String paramString)
  {
  }

  public final void run()
  {
    if ((this.a == null) || (this.a.length == 0))
      return;
    if ("search_nearby".equals(this.b));
    for (String str = "id_search_nearby"; ; str = "id_delete_location")
    {
      a.a(LocationApi.d(this.c), LocationApi.e(this.c), str, this.a);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.tauth.c
 * JD-Core Version:    0.6.2
 */