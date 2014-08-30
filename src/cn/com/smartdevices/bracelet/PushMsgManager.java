package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.model.BasePushItem;
import java.util.ArrayList;
import java.util.Iterator;

public class PushMsgManager
{
  private static PushMsgManager c = null;
  private ArrayList<BasePushItem> a = new ArrayList();
  private ArrayList<BasePushItem> b = new ArrayList();

  public static PushMsgManager getInstance()
  {
    if (c == null)
      c = new PushMsgManager();
    return c;
  }

  public void addItem(BasePushItem paramBasePushItem)
  {
    this.a.add(paramBasePushItem);
    if (!paramBasePushItem.hasRead)
      this.b.add(paramBasePushItem);
  }

  public ArrayList<BasePushItem> getAllMsgs()
  {
    return this.a;
  }

  public ArrayList<BasePushItem> getUnReadMsgs()
  {
    return this.b;
  }

  public void setAllRead()
  {
    Iterator localIterator = this.b.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        this.a.addAll(this.b);
        this.b.clear();
        return;
      }
      ((BasePushItem)localIterator.next()).hasRead = true;
    }
  }

  public int sizeOfUnreadMsgs()
  {
    return this.b.size();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.PushMsgManager
 * JD-Core Version:    0.6.2
 */