package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SettingFeedbackFragment extends Fragment
  implements View.OnClickListener
{
  private static final String d = "^[\\w\\-\\.]+@[\\w\\-]+(\\.\\w+)+$";
  private static final String e = "^\\d+$";
  private EditText a;
  private EditText b;
  private View c;

  private void a(String paramString1, String paramString2)
  {
    WebAPI.sendFeedback(Keeper.readLoginData(), paramString1, paramString2, new bo(this));
  }

  public static boolean isContentValid(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }

  public static boolean isEmailValid(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (Pattern.compile("^[\\w\\-\\.]+@[\\w\\-]+(\\.\\w+)+$").matcher(paramString).matches());
      while (Pattern.compile("^\\d+$").matcher(paramString).matches())
        return true;
    }
    return false;
  }

  public void onClick(View paramView)
  {
    String str1 = this.a.getText().toString();
    String str2 = this.b.getText().toString();
    if (isContentValid(str1))
    {
      if (isEmailValid(str2))
      {
        WebAPI.sendFeedback(Keeper.readLoginData(), str1, str2, new bo(this));
        return;
      }
      Toast.makeText(getActivity(), "联系方式无效，请重填!", 0).show();
      return;
    }
    Toast.makeText(getActivity(), "请填写反馈内容!", 0).show();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903103, paramViewGroup, false);
    this.a = ((EditText)localView.findViewById(2131165450));
    this.b = ((EditText)localView.findViewById(2131165449));
    this.c = localView.findViewById(2131165451);
    this.c.setOnClickListener(this);
    this.b.setOnEditorActionListener(new bm(this));
    ((TextView)localView.findViewById(2131165230)).setOnClickListener(new bn(this));
    return localView;
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageFeedback");
  }

  public void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageFeedback");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SettingFeedbackFragment
 * JD-Core Version:    0.6.2
 */