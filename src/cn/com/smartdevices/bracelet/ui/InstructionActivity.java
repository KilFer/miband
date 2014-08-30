package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.ui.widget.PageIndicator;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class InstructionActivity extends Activity
  implements View.OnClickListener
{
  private View a;
  private ViewPager b;
  private PageIndicator c;
  private an d;
  private ArrayList<Fragment> e;
  private int f;

  private static byte[] b(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
      {
        localByteArrayOutputStream.flush();
        return localByteArrayOutputStream.toByteArray();
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165230:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903042);
    this.a = ((TextView)findViewById(2131165230));
    this.a.setOnClickListener(this);
    this.b = ((ViewPager)findViewById(2131165231));
    this.c = ((PageIndicator)findViewById(2131165232));
    this.e = new ArrayList(3);
    this.e.add(Fragment.instantiate(this, InstructionActivity.InstructionPage1.class.getName()));
    this.e.add(Fragment.instantiate(this, InstructionActivity.InstructionPage2.class.getName()));
    this.e.add(Fragment.instantiate(this, InstructionActivity.InstructionPage3.class.getName()));
    this.d = new an(this, getFragmentManager());
    this.b.setAdapter(this.d);
    this.b.setOffscreenPageLimit(3);
    this.c.setViewPager(this.b);
    this.c.setOnPageChangeListener(new am(this));
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageInstruction");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageInstruction");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.InstructionActivity
 * JD-Core Version:    0.6.2
 */