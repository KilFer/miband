package com.sina.weibo.sdk.auth;

import android.view.View;
import android.view.View.OnClickListener;

class WeiboDialog$1
  implements View.OnClickListener
{
  WeiboDialog$1(WeiboDialog paramWeiboDialog)
  {
  }

  public void onClick(View paramView)
  {
    this.this$0.dismiss();
    if (WeiboDialog.access$0(this.this$0) != null)
      WeiboDialog.access$0(this.this$0).onCancel();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.auth.WeiboDialog.1
 * JD-Core Version:    0.6.2
 */