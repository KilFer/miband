package cn.com.smartdevices.bracelet.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;

final class i
  implements View.OnClickListener
{
  i(PersonInfoFinishedActivity paramPersonInfoFinishedActivity)
  {
  }

  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, SearchSingleBraceletActivity.class);
    this.a.startActivity(localIntent);
    this.a.finish();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.i
 * JD-Core Version:    0.6.2
 */