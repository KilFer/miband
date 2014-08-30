package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.model.MicroBlogItem;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import java.util.ArrayList;

public class BaseMicroBlogManager
{
  public static final int PAGE_BLOG_COUNT = 10;
  private PersonInfo a;
  private ArrayList<MicroBlogItem> b = new ArrayList();
  private int c = 0;

  public void addBlog(MicroBlogItem paramMicroBlogItem)
  {
    this.b.add(paramMicroBlogItem);
  }

  public void addBlogs(ArrayList<MicroBlogItem> paramArrayList)
  {
    this.b.addAll(paramArrayList);
  }

  public void clearBlogs()
  {
    this.b.clear();
    this.c = 0;
  }

  public MicroBlogItem getBlog(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > -1 + this.b.size()))
      return null;
    return (MicroBlogItem)this.b.get(paramInt);
  }

  public ArrayList<MicroBlogItem> getBlogs()
  {
    return this.b;
  }

  public PersonInfo getCurOwner()
  {
    return this.a;
  }

  public int pageCount()
  {
    return this.c;
  }

  public void setCurOwner(PersonInfo paramPersonInfo)
  {
    this.a = paramPersonInfo;
  }

  public void setCurOwner(ArrayList<MicroBlogItem> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
      this.a = ((MicroBlogItem)paramArrayList.get(0)).info;
  }

  public void setPageCount(int paramInt)
  {
    this.c = paramInt;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BaseMicroBlogManager
 * JD-Core Version:    0.6.2
 */