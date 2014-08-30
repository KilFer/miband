package cn.com.smartdevices.bracelet.activity;

import android.content.Intent;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebRes;

public class WebActivity$LoginJsObject
{
  public WebActivity$LoginJsObject(WebActivity paramWebActivity)
  {
  }

  public void callback(String paramString1, String paramString2)
  {
    Debug.i("WPJ", "uid:" + paramString1 + ",security:" + paramString2);
  }

  public void setUserInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    int i = 1;
    Debug.i("WebActivity", "uid:" + paramString1 + ",security:" + paramString2 + ",iconUrl:" + paramString3 + ",nick name:" + paramString4 + ",has bind:" + paramString5);
    Keeper.keepLoginData(Long.parseLong(paramString1), paramString2);
    if (Integer.parseInt(paramString5) == i);
    while (true)
    {
      if (i != 0)
      {
        Debug.i("WebActivity", "userInfo=" + paramString6);
        PersonInfo localPersonInfo = Keeper.readPersonInfo();
        WebRes.parseBindedUserInfo(paramString6, localPersonInfo);
        localPersonInfo.uid = Long.parseLong(paramString1);
        Keeper.keepPersonInfo(localPersonInfo);
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("miliao_icon_url", paramString3);
      localIntent.putExtra("miliao_nick_name", paramString4);
      localIntent.putExtra("miliao_has_binded", i);
      this.a.setResult(3, localIntent);
      this.a.finish();
      return;
      int j = 0;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.WebActivity.LoginJsObject
 * JD-Core Version:    0.6.2
 */