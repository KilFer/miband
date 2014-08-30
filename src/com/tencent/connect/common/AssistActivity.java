package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AssistActivity extends Activity
{
  private static BaseApi a;
  private BaseApi b;

  public static Intent getAssistActivityIntent(Context paramContext)
  {
    return new Intent(paramContext, AssistActivity.class);
  }

  public static void setApiObject(BaseApi paramBaseApi)
  {
    a = paramBaseApi;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.b != null)
      this.b.onActivityResult(paramInt1, paramInt2, paramIntent);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (a == null)
    {
      finish();
      return;
    }
    this.b = a;
    a = null;
    int i = this.b.b().getIntExtra("key_request_code", 0);
    startActivityForResult(this.b.b(), i);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.common.AssistActivity
 * JD-Core Version:    0.6.2
 */