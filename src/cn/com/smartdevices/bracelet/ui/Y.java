package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.activity.WebActivity;
import java.util.ArrayList;

final class Y extends BaseAdapter
{
  private Y(DynamicListFragment paramDynamicListFragment)
  {
  }

  private void a(DynamicListFragment.DynamicItem paramDynamicItem)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.a.getActivity(), WebActivity.class);
    localIntent.putExtra("web_type", 2);
    localIntent.putExtra("web_url", paramDynamicItem.uri.toString());
    localIntent.putExtra("Label", paramDynamicItem.title);
    this.a.getActivity().startActivity(localIntent);
  }

  public final int getCount()
  {
    Debug.i("Dynamic.List", "GetCount : " + DynamicListFragment.a(this.a).size());
    return DynamicListFragment.a(this.a).size();
  }

  public final Object getItem(int paramInt)
  {
    return DynamicListFragment.a(this.a).get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Debug.i("Dynamic.List", "GetView : " + paramInt);
    if (paramView == null)
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2130903079, paramViewGroup, false);
    DynamicListFragment.DynamicItem localDynamicItem = (DynamicListFragment.DynamicItem)getItem(paramInt);
    TextView localTextView1 = (TextView)paramView.findViewById(2131165387);
    TextView localTextView2 = (TextView)paramView.findViewById(2131165388);
    localTextView1.setText(localDynamicItem.title);
    localTextView2.setText(localDynamicItem.summary);
    paramView.setOnClickListener(new Z(this, localDynamicItem));
    return paramView;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.Y
 * JD-Core Version:    0.6.2
 */