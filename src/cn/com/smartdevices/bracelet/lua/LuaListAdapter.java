package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DaoManager;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import de.greenrobot.daobracelet.LuaList;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaListDao.Properties;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class LuaListAdapter extends BaseAdapter
{
  private static Boolean isFirstTimeBoolean = Boolean.valueOf(true);
  private Animation animB2T;
  private Animation animT2B;
  private List<c> infoList = null;
  private Context mContext = null;
  private int newItemCount = 0;
  private TranslateAnimation taBlow;
  private TranslateAnimation taLeft;
  private TranslateAnimation taRight;
  private TranslateAnimation taTop;

  public LuaListAdapter(Context paramContext, List<LuaList> paramList)
  {
    this.mContext = paramContext;
    isFirstTimeBoolean = Boolean.valueOf(true);
    getNewList(paramList);
    InitAnim();
  }

  private void InitAnim()
  {
    this.taLeft = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.taRight = new TranslateAnimation(2, -1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.taTop = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
    this.taBlow = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    this.taLeft.setDuration(1000L);
    this.taRight.setDuration(1000L);
    this.taTop.setDuration(1000L);
    this.taBlow.setDuration(1000L);
    this.animB2T = AnimationUtils.loadAnimation(this.mContext, 2130968582);
    this.animT2B = AnimationUtils.loadAnimation(this.mContext, 2130968583);
  }

  private String getDate()
  {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
  }

  private void getNewList(List<LuaList> paramList)
  {
    this.newItemCount = 0;
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.infoList = null;
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.infoList == null) || (this.infoList.size() == 0))
      for (int i = 0; ; i++)
      {
        if (i >= paramList.size())
        {
          this.newItemCount = localArrayList.size();
          this.infoList = localArrayList;
          return;
        }
        c localc1 = new c(this);
        localc1.a = ((LuaList)paramList.get(i));
        localc1.b = Boolean.valueOf(false);
        localArrayList.add(localc1);
      }
    int j = 0;
    label127: c localc2;
    if (j < paramList.size())
    {
      localc2 = new c(this);
      localc2.a = ((LuaList)paramList.get(j));
      if (!judgeIsNew(localc2.a).booleanValue())
        break label211;
      this.newItemCount = (1 + this.newItemCount);
    }
    label211: for (localc2.b = Boolean.valueOf(true); ; localc2.b = Boolean.valueOf(false))
    {
      localArrayList.add(localc2);
      j++;
      break label127;
      break;
    }
  }

  private Boolean judgeIsNew(LuaList paramLuaList)
  {
    for (int i = 0; ; i++)
    {
      if (i >= this.infoList.size())
        return Boolean.valueOf(true);
      LuaList localLuaList = ((c)this.infoList.get(i)).a;
      Boolean localBoolean = ((c)this.infoList.get(i)).b;
      if (paramLuaList.getId() == localLuaList.getId())
      {
        if (localBoolean.booleanValue())
          return Boolean.valueOf(true);
        return Boolean.valueOf(false);
      }
    }
  }

  public int getCount()
  {
    if (this.infoList != null)
      return this.infoList.size();
    return 0;
  }

  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getListSize()
  {
    if (this.infoList == null)
      return 0;
    return this.infoList.size();
  }

  public int getNewItemCount()
  {
    if (isFirstTimeBoolean.booleanValue())
    {
      isFirstTimeBoolean = Boolean.valueOf(false);
      return 0;
    }
    return this.newItemCount;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    c localc = (c)this.infoList.get(paramInt);
    LuaList localLuaList = localc.a;
    d locald = new d(this);
    View localView;
    String str;
    if (localLuaList.getType().compareTo("1005") == 0)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2130903117, null);
      locald.a = ((TextView)localView.findViewById(2131165525));
      locald.a.setTypeface(Typeface.DEFAULT, 1);
      locald.b = ((TextView)localView.findViewById(2131165526));
      localView.setOnClickListener(new b(this));
      locald.a.setText(localLuaList.getText1());
      str = localLuaList.getText2();
      if ((str != null) && (str.length() != 0))
        break label225;
      locald.b.setVisibility(8);
    }
    while (true)
    {
      localView.setTag(locald);
      locald.a.setTag(localLuaList);
      if (localc.b.booleanValue())
        localView.startAnimation(this.animT2B);
      localc.b = Boolean.valueOf(false);
      return localView;
      localView = LayoutInflater.from(this.mContext).inflate(2130903116, null);
      break;
      label225: locald.b.setVisibility(0);
      locald.b.setText(str);
    }
  }

  public void refreshList()
  {
    LuaListDao localLuaListDao = DaoManager.getInstance().getLuaListDao();
    String str = getDate();
    QueryBuilder localQueryBuilder = localLuaListDao.queryBuilder().where(LuaListDao.Properties.Date.eq(str), new WhereCondition[0]).where(LuaListDao.Properties.Type.notEq("8888"), new WhereCondition[0]).where(LuaListDao.Properties.Type.notEq("9999"), new WhereCondition[0]);
    Property[] arrayOfProperty = new Property[1];
    arrayOfProperty[0] = LuaListDao.Properties.Id;
    List localList = localQueryBuilder.orderDesc(arrayOfProperty).list();
    Collections.sort(localList, new LuaListAdapter.MyComparator(this));
    setList(localList);
  }

  public void setFlagsToFalse()
  {
    for (int i = 0; ; i++)
    {
      if (i >= this.infoList.size())
        return;
      ((c)this.infoList.get(i)).b = Boolean.valueOf(false);
    }
  }

  public void setList(List<LuaList> paramList)
  {
    if (paramList != null)
    {
      getNewList(paramList);
      notifyDataSetChanged();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.LuaListAdapter
 * JD-Core Version:    0.6.2
 */