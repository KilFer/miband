package com.tencent.mm.sdk.plugin;

final class a
  implements Runnable
{
  a(MMPluginOAuth paramMMPluginOAuth)
  {
  }

  public final void run()
  {
    if (MMPluginOAuth.b(this.a) != null)
      MMPluginOAuth.b(this.a).onResult(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.a
 * JD-Core Version:    0.6.2
 */