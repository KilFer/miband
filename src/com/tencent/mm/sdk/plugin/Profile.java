package com.tencent.mm.sdk.plugin;

import android.net.Uri;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public class Profile extends BaseProfile
{
  public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/profile");
  protected static IAutoDBItem.MAutoDBInfo bO = BaseProfile.initAutoDBInfo(Profile.class);
  public static String[] columns = { "username", "bindqq", "bindmobile", "bindemail", "alias", "nickname", "signature", "province", "city", "weibo", "avatar" };

  protected IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return bO;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.Profile
 * JD-Core Version:    0.6.2
 */