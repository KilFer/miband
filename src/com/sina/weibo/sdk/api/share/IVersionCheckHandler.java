package com.sina.weibo.sdk.api.share;

import android.content.Context;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

abstract interface IVersionCheckHandler
{
  public abstract boolean check(Context paramContext, WeiboMessage paramWeiboMessage);

  public abstract boolean check(Context paramContext, WeiboMultiMessage paramWeiboMultiMessage);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.share.IVersionCheckHandler
 * JD-Core Version:    0.6.2
 */