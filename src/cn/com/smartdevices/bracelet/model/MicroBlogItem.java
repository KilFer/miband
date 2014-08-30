package cn.com.smartdevices.bracelet.model;

import java.util.ArrayList;

public class MicroBlogItem
{
  private static final int MAX_COMMENT_COUNT = 5;
  public String allComments = "";
  public ArrayList<CommentItem> comments = new ArrayList();
  public int commentsNum = 0;
  public String createTime = "";
  public UploadData data = new UploadData();
  public PersonInfo info = new PersonInfo();
  public int likeNum = 0;
  public ArrayList<PersonInfo> likePersons = new ArrayList();
  public long postid = -1L;
  public ShareContent shareContent = new ShareContent();
  public String source = "";
  public int systemFlag = 0;
  public int visible = 1;
  public String webUrl = "";

  public static MicroBlogItem getDefaultBlogItem()
  {
    MicroBlogItem localMicroBlogItem = new MicroBlogItem();
    localMicroBlogItem.systemFlag = 1;
    localMicroBlogItem.visible = 0;
    localMicroBlogItem.webUrl = "file:///android_asset/help.html";
    localMicroBlogItem.source = "如何玩转小米手环";
    localMicroBlogItem.createTime = "1401206400000";
    localMicroBlogItem.shareContent.shareType = 2;
    PicUrl localPicUrl = new PicUrl();
    localPicUrl.thumbUrl = "drawable://2130837594";
    localPicUrl.originUrl = localPicUrl.thumbUrl;
    localMicroBlogItem.shareContent.pics.add(localPicUrl);
    return localMicroBlogItem;
  }

  public String getAllComments()
  {
    int i;
    if ((this.allComments.length() <= 0) && (this.comments.size() > 0))
    {
      i = this.comments.size();
      if (i > 5)
        i = 5;
    }
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return this.allComments;
      CommentItem localCommentItem = (CommentItem)this.comments.get(j);
      this.allComments = (this.allComments + localCommentItem.userInfo.nickname + " : " + localCommentItem.message + "\n");
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.MicroBlogItem
 * JD-Core Version:    0.6.2
 */