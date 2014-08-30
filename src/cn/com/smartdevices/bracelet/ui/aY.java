package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

final class aY
  implements AdapterView.OnItemClickListener
{
  aY(SearchSingleBraceletActivity paramSearchSingleBraceletActivity)
  {
  }

  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    SearchSingleBraceletActivity.a(this.a, ((bc)SearchSingleBraceletActivity.a(this.a).get(paramInt)).a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aY
 * JD-Core Version:    0.6.2
 */