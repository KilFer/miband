package com.tencent.connect.common;

import com.tencent.tauth.IUiListener;

public class BaseApi$ApiTask
{
  public IUiListener mListener;
  public int mRequestCode;

  public BaseApi$ApiTask(BaseApi paramBaseApi, int paramInt, IUiListener paramIUiListener)
  {
    this.mRequestCode = paramInt;
    this.mListener = paramIUiListener;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.common.BaseApi.ApiTask
 * JD-Core Version:    0.6.2
 */