package com.sina.weibo.sdk.api.share;

import android.content.Context;
import com.sina.weibo.sdk.api.CmdObject;
import com.sina.weibo.sdk.api.VoiceObject;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.utils.LogUtil;

public class VersionCheckHandler
  implements IVersionCheckHandler
{
  private static final String TAG = "VersionCheckHandler";
  private String mPackageName;

  public VersionCheckHandler()
  {
  }

  public VersionCheckHandler(String paramString)
  {
    this.mPackageName = paramString;
  }

  public boolean check(Context paramContext, WeiboMessage paramWeiboMessage)
  {
    LogUtil.d("VersionCheckHandler", "check WeiboMessage package : " + this.mPackageName);
    if ((this.mPackageName == null) || (this.mPackageName.length() == 0));
    ApiUtils.WeiboInfo localWeiboInfo;
    do
    {
      return false;
      localWeiboInfo = ApiUtils.queryWeiboInfoByPackage(paramContext, this.mPackageName);
    }
    while (localWeiboInfo == null);
    LogUtil.d("VersionCheckHandler", "check WeiboMessage WeiboInfo supportApi : " + localWeiboInfo.supportApi);
    if ((localWeiboInfo.supportApi < 10351) && (paramWeiboMessage.mediaObject != null) && ((paramWeiboMessage.mediaObject instanceof VoiceObject)))
      paramWeiboMessage.mediaObject = null;
    if ((localWeiboInfo.supportApi < 10352) && (paramWeiboMessage.mediaObject != null) && ((paramWeiboMessage.mediaObject instanceof CmdObject)))
      paramWeiboMessage.mediaObject = null;
    return true;
  }

  public boolean check(Context paramContext, WeiboMultiMessage paramWeiboMultiMessage)
  {
    LogUtil.d("VersionCheckHandler", "check WeiboMultiMessage package : " + this.mPackageName);
    if ((this.mPackageName == null) || (this.mPackageName.length() == 0));
    ApiUtils.WeiboInfo localWeiboInfo;
    do
    {
      do
      {
        return false;
        localWeiboInfo = ApiUtils.queryWeiboInfoByPackage(paramContext, this.mPackageName);
      }
      while (localWeiboInfo == null);
      LogUtil.d("VersionCheckHandler", "check WeiboMultiMessage WeiboInfo supportApi : " + localWeiboInfo.supportApi);
    }
    while (localWeiboInfo.supportApi < 10351);
    if ((localWeiboInfo.supportApi < 10352) && (paramWeiboMultiMessage.mediaObject != null) && ((paramWeiboMultiMessage.mediaObject instanceof CmdObject)))
      paramWeiboMultiMessage.mediaObject = null;
    return true;
  }

  public void setPackageName(String paramString)
  {
    this.mPackageName = paramString;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.share.VersionCheckHandler
 * JD-Core Version:    0.6.2
 */