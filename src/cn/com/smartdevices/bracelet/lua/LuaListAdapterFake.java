package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LuaListAdapterFake extends BaseAdapter
{
  private Animation animB2T;
  private Animation animT2B;
  private List<f> infoList = new ArrayList();
  private Context mContext = null;
  private int newItemCount = 0;
  private TranslateAnimation taBlow;
  private TranslateAnimation taLeft;
  private TranslateAnimation taRight;
  private TranslateAnimation taTop;

  public LuaListAdapterFake(Context paramContext)
  {
    this.mContext = paramContext;
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
  }

  private String getDate()
  {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
  }

  public void add(String paramString1, String paramString2)
  {
    f localf = new f(this);
    this.infoList.add(localf);
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

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    f localf = (f)this.infoList.get(paramInt);
    g localg = new g(this);
    View localView = LayoutInflater.from(this.mContext).inflate(2130903116, null);
    localg.a = ((TextView)localView.findViewById(2131165525));
    localg.a.setTypeface(Typeface.DEFAULT, 1);
    localg.b = ((TextView)localView.findViewById(2131165526));
    localg.b.setTypeface(Typeface.DEFAULT, 1);
    ((ImageView)localView.findViewById(2131165524)).setVisibility(8);
    localView.setOnTouchListener(new e(this));
    localg.a.setText("");
    localg.b.setText("");
    localView.setTag(localg);
    localg.a.setTag(localf);
    return localView;
  }

  public void setList(List<f> paramList)
  {
    if (paramList != null)
      notifyDataSetChanged();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.LuaListAdapterFake
 * JD-Core Version:    0.6.2
 */