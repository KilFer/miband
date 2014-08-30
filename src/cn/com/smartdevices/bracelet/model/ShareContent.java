package cn.com.smartdevices.bracelet.model;

import java.util.ArrayList;

public class ShareContent
{
  public static final int SHARE_TYPE_PICTURE = 2;
  public static final int SHARE_TYPE_SPORT_DATA = 1;
  public String message = "";
  public ArrayList<PicUrl> pics = new ArrayList();
  public String picturePath = "";
  public ShareSportData shareSportData = new ShareSportData();
  public int shareType = 0;
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.ShareContent
 * JD-Core Version:    0.6.2
 */