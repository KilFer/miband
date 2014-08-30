package com.tencent.weiyun;

import com.tencent.tauth.UiError;
import java.util.List;

public abstract interface IGetFileListListener
{
  public abstract void onComplete(List<WeiyunFile> paramList);

  public abstract void onError(UiError paramUiError);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.weiyun.IGetFileListListener
 * JD-Core Version:    0.6.2
 */