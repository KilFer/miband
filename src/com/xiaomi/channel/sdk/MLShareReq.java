package com.xiaomi.channel.sdk;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public class MLShareReq
  implements IShareReq
{
  private int a;
  private MLShareMessage b;
  private final int c;
  private MLExtraInfo d;

  public MLShareReq(int paramInt1, MLShareMessage paramMLShareMessage, int paramInt2)
  {
    this(paramMLShareMessage, paramInt2);
  }

  public MLShareReq(MLShareMessage paramMLShareMessage, int paramInt)
  {
    this.b = paramMLShareMessage;
    this.c = paramInt;
  }

  public MLExtraInfo getJumpBackInfo()
  {
    return this.d;
  }

  public int getShareType()
  {
    return this.a;
  }

  public void parseFromBundle(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.a = paramBundle.getInt("share_type");
      String str = paramBundle.getString("share_title");
      this.b = new MLShareMessage();
      this.b.title = str;
      if (paramBundle.containsKey("share_text"))
        this.b.text = paramBundle.getString("share_text");
      if (paramBundle.containsKey("share_url"))
        this.b.url = paramBundle.getString("share_url");
      if (paramBundle.containsKey("share_img_data_bmp"))
      {
        MLImgObj localMLImgObj = new MLImgObj((Bitmap)paramBundle.getParcelable("share_img_data_bmp"));
        this.b.imgObj = localMLImgObj;
      }
    }
  }

  public void setJumpBackInfo(MLExtraInfo paramMLExtraInfo)
  {
    this.d = paramMLExtraInfo;
  }

  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("share_target", this.c);
    if (this.b != null)
    {
      if (TextUtils.isEmpty(this.b.title))
        break label367;
      localBundle.putString("share_title", this.b.title);
    }
    label138: label303: label360: label367: for (int i = 1; ; i = 0)
    {
      if (!TextUtils.isEmpty(this.b.text))
      {
        localBundle.putString("share_text", this.b.text);
        i = 1;
      }
      if (!TextUtils.isEmpty(this.b.url))
        localBundle.putString("share_url", this.b.url);
      for (int j = 1; ; j = 0)
      {
        int k;
        if (!TextUtils.isEmpty(this.b.imgUrl))
        {
          localBundle.putString("share_img_url", this.b.imgUrl);
          k = 1;
          if ((i == 0) || (k != 0) || (j != 0))
            break label303;
          this.a = 100100;
        }
        while (true)
        {
          localBundle.putInt("share_type", this.a);
          return localBundle;
          MLImgObj localMLImgObj = this.b.imgObj;
          k = 0;
          if (localMLImgObj == null)
            break label138;
          Bitmap localBitmap = this.b.imgObj.getCompressBmp();
          k = 0;
          if (localBitmap == null)
            break label138;
          File localFile = ShareUtils.getTmpImgFile();
          if (localFile != null)
          {
            if (localFile.exists())
              localFile.delete();
            String str = localFile.getAbsolutePath();
            if (ShareUtils.saveBitmap(localBitmap, str))
            {
              Log.d("MLShare", "MLShare shareFilePath:" + str);
              localBundle.putString("share_img_file_path", str);
              break;
            }
            localBundle.putParcelable("share_img_data_bmp", localBitmap);
            break;
          }
          localBundle.putParcelable("share_img_data_bmp", localBitmap);
          break;
          if ((k != 0) && (i == 0) && (j == 0))
          {
            this.a = 100101;
          }
          else
          {
            if (((k == 0) || (i == 0)) && ((k == 0) || (j == 0)) && ((i == 0) || (j == 0)))
              break label360;
            this.a = 100104;
          }
        }
        return null;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.sdk.MLShareReq
 * JD-Core Version:    0.6.2
 */