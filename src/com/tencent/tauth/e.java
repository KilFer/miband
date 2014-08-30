package com.tencent.tauth;

import org.json.JSONObject;

final class e extends d
{
  private IUiListener a;

  public e(LocationApi paramLocationApi, IUiListener paramIUiListener)
  {
    super(paramLocationApi, (byte)0);
    this.a = paramIUiListener;
  }

  protected final void a(Exception paramException)
  {
    if (this.a != null)
      this.a.onError(new UiError(100, paramException.getMessage(), null));
  }

  public final void onComplete(JSONObject paramJSONObject)
  {
    if (this.a != null)
      this.a.onComplete(paramJSONObject);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.tauth.e
 * JD-Core Version:    0.6.2
 */