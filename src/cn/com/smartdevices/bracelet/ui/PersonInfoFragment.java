package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.AnalyticsTrackerManager;
import cn.com.smartdevices.bracelet.BleTask.BleSetPersonalInfoTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.DaoManager;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.activity.LoginActivity;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SwitchOperator;
import cn.com.smartdevices.bracelet.model.UploadData;
import cn.com.smartdevices.bracelet.model.UserLocationData;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;
import cn.com.smartdevices.bracelet.view.Util;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.google.gson.Gson;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaZipFileDao;
import de.greenrobot.event.EventBus;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

public class PersonInfoFragment extends Fragment
  implements View.OnClickListener
{
  public static final String EXTRA_PERSON_INFO = "person_info_json";
  public static final int REQ_SELECT_CROP_IMAGE = 17;
  public static final int REQ_TAKE_PHOTO = 18;
  private static final String a = "PersonInfoFragment";
  private ImageButton A;
  private Bitmap B;
  private View C;
  private TextView D;
  private TextView b;
  private View c;
  private TextView d;
  private View e;
  private TextView f;
  private View g;
  private TextView h;
  private View i;
  private String j;
  private String k;
  private PersonInfo l = null;
  private View m;
  private ImageButton n;
  private TextView o;
  private TextView p;
  private TextView q;
  private ImageView r;
  private ImageButton s;
  private ImageButton t;
  private TextView u;
  private TextView v;
  private TextView w;
  private View x;
  private View y;
  private View z;

  private void a()
  {
    WebAPI.getUserInfo(Keeper.readLoginData(), this.l.uid, new aP(this));
  }

  private void a(View paramView)
  {
    this.b = ((TextView)paramView.findViewById(2131165545));
    this.c = paramView.findViewById(2131165544);
    this.c.setOnClickListener(this);
    this.d = ((TextView)paramView.findViewById(2131165549));
    this.e = paramView.findViewById(2131165548);
    this.e.setOnClickListener(this);
    this.f = ((TextView)paramView.findViewById(2131165551));
    this.g = paramView.findViewById(2131165550);
    this.g.setOnClickListener(this);
    this.h = ((TextView)paramView.findViewById(2131165547));
    this.i = paramView.findViewById(2131165546);
    this.i.setOnClickListener(this);
    paramView.findViewById(2131165552).setOnClickListener(this);
    this.m = paramView.findViewById(2131165542);
    this.C = paramView.findViewById(2131165543);
    if (Keeper.readPersonInfo().uid == this.l.uid)
      this.C.setVisibility(0);
    while (true)
    {
      this.n = ((ImageButton)this.m.findViewById(2131165554));
      this.n.setOnClickListener(this);
      this.o = ((TextView)this.m.findViewById(2131165556));
      this.p = ((TextView)this.m.findViewById(2131165558));
      this.q = ((TextView)this.m.findViewById(2131165559));
      this.q.setOnClickListener(this);
      this.r = ((ImageView)this.m.findViewById(2131165557));
      this.v = ((TextView)this.m.findViewById(2131165560));
      this.u = ((TextView)this.m.findViewById(2131165563));
      this.w = ((TextView)this.m.findViewById(2131165561));
      this.D = ((TextView)this.m.findViewById(2131165562));
      this.t = ((ImageButton)this.m.findViewById(2131165565));
      this.t.setOnClickListener(this);
      this.s = ((ImageButton)this.m.findViewById(2131165567));
      this.s.setOnClickListener(this);
      this.m.findViewById(2131165566);
      this.x = this.m.findViewById(2131165564);
      this.z = this.m.findViewById(2131165230);
      this.z.setOnClickListener(this);
      return;
      this.C.setVisibility(8);
    }
  }

  private static void a(PersonInfo paramPersonInfo)
  {
    int i1 = 0;
    if (paramPersonInfo.age <= 0)
      paramPersonInfo.age = 25;
    for (int i2 = 0; ; i2 = 1)
    {
      if ((paramPersonInfo.height < 90) || (paramPersonInfo.height > 230))
      {
        paramPersonInfo.height = 170;
        i2 = 0;
      }
      if ((paramPersonInfo.weight < 20) || (paramPersonInfo.weight > 205))
      {
        paramPersonInfo.weight = 60;
        i2 = 0;
      }
      if (paramPersonInfo.gender < 0)
        paramPersonInfo.gender = 1;
      while (true)
      {
        if (i1 == 0)
          Keeper.keepPersonInfo(paramPersonInfo);
        return;
        i1 = i2;
      }
    }
  }

  private void a(boolean paramBoolean)
  {
    Utils.hideProgressDialog(getActivity());
    if (paramBoolean)
    {
      j();
      return;
    }
    MiliExitLoginFragment localMiliExitLoginFragment = new MiliExitLoginFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("exit_login_type", 1);
    localMiliExitLoginFragment.setArguments(localBundle);
    localMiliExitLoginFragment.setOpClickListener(new aT(this));
    DimPanelFragment.showPanel(getActivity(), localMiliExitLoginFragment);
  }

  private void b()
  {
    new Thread(new aQ(this)).start();
  }

  private void c()
  {
    this.n = ((ImageButton)this.m.findViewById(2131165554));
    this.n.setOnClickListener(this);
    this.o = ((TextView)this.m.findViewById(2131165556));
    this.p = ((TextView)this.m.findViewById(2131165558));
    this.q = ((TextView)this.m.findViewById(2131165559));
    this.q.setOnClickListener(this);
    this.r = ((ImageView)this.m.findViewById(2131165557));
    this.v = ((TextView)this.m.findViewById(2131165560));
    this.u = ((TextView)this.m.findViewById(2131165563));
    this.w = ((TextView)this.m.findViewById(2131165561));
    this.D = ((TextView)this.m.findViewById(2131165562));
    this.t = ((ImageButton)this.m.findViewById(2131165565));
    this.t.setOnClickListener(this);
    this.s = ((ImageButton)this.m.findViewById(2131165567));
    this.s.setOnClickListener(this);
    this.m.findViewById(2131165566);
    this.x = this.m.findViewById(2131165564);
    this.z = this.m.findViewById(2131165230);
    this.z.setOnClickListener(this);
  }

  private void d()
  {
    int i1 = 0;
    PersonInfo localPersonInfo = this.l;
    if (localPersonInfo.age <= 0)
      localPersonInfo.age = 25;
    for (int i2 = 0; ; i2 = 1)
    {
      if ((localPersonInfo.height < 90) || (localPersonInfo.height > 230))
      {
        localPersonInfo.height = 170;
        i2 = 0;
      }
      if ((localPersonInfo.weight < 20) || (localPersonInfo.weight > 205))
      {
        localPersonInfo.weight = 60;
        i2 = 0;
      }
      if (localPersonInfo.gender < 0)
        localPersonInfo.gender = 1;
      while (true)
      {
        if (i1 == 0)
          Keeper.keepPersonInfo(localPersonInfo);
        if (getActivity() == null)
          return;
        TextView localTextView = this.b;
        if (this.l.gender == 1);
        for (String str = "男"; ; str = "女")
        {
          localTextView.setText(str);
          this.d.setText(this.l.height + getString(2131492959));
          this.f.setText(this.l.weight + getString(2131492964));
          this.h.setText(this.l.age);
          e();
          return;
        }
        i1 = i2;
      }
    }
  }

  private void e()
  {
    Utils.updateAvatarUI(this.l, this.n);
    this.o.setText(this.l.nickname);
    this.p.setText(this.l.personSignature);
    this.v.setText(String.valueOf(this.l.uid));
    if (this.l.gender == 0)
      this.r.setImageResource(2130837598);
    while (true)
    {
      if (this.l.location.city.equals(""))
        this.l.location.city = getString(2131492982);
      this.q.setText(this.l.location.city);
      Object localObject1;
      if ((this.l.totalSportData != null) && (this.l.totalSportData.isValid()))
        localObject1 = Float.valueOf(0.0F);
      try
      {
        Float localFloat3 = Float.valueOf(this.l.totalSportData.distance);
        localObject1 = localFloat3;
        Float localFloat1 = Float.valueOf(100.0F * (int)(((Float)localObject1).floatValue() / 100.0F) / 1000.0F);
        this.u.setText(localFloat1);
        localObject2 = Float.valueOf(0.0F);
      }
      catch (Exception localException1)
      {
        try
        {
          Float localFloat2 = Float.valueOf(this.l.totalSportData.averageSteps);
          Object localObject2 = localFloat2;
          this.w.setText(((Float)localObject2).intValue());
          this.D.setText(this.l.totalSportData.totalwearingdays);
          if (this.l.uid == Keeper.readPersonInfo().uid)
          {
            this.x.setVisibility(0);
            return;
            this.r.setImageResource(2130837599);
            continue;
            localException1 = localException1;
            localException1.printStackTrace();
          }
        }
        catch (Exception localException2)
        {
          while (true)
            localException2.printStackTrace();
          this.x.setVisibility(4);
        }
      }
    }
  }

  private void f()
  {
    MiliExitLoginFragment localMiliExitLoginFragment = new MiliExitLoginFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("exit_login_type", 0);
    localMiliExitLoginFragment.setArguments(localBundle);
    localMiliExitLoginFragment.setOpClickListener(new aS(this));
    DimPanelFragment.showPanel(getActivity(), localMiliExitLoginFragment);
  }

  private void g()
  {
    MiliExitLoginFragment localMiliExitLoginFragment = new MiliExitLoginFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("exit_login_type", 1);
    localMiliExitLoginFragment.setArguments(localBundle);
    localMiliExitLoginFragment.setOpClickListener(new aT(this));
    DimPanelFragment.showPanel(getActivity(), localMiliExitLoginFragment);
  }

  private static void h()
  {
    SwitchOperator localSwitchOperator = Keeper.readSwitchOperator();
    SharedPreferences.Editor localEditor = Keeper.getSharedPref().edit();
    localEditor.clear();
    localEditor.commit();
    Keeper.keepSwitchOperator(localSwitchOperator);
    DaoManager.getInstance().getLuaListDao().deleteAll();
    DaoManager.getInstance().getLuaZipFileDao().deleteAll();
    DataManager.getInstance().clearAll();
  }

  private void i()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(getActivity(), LoginActivity.class);
    localIntent.setFlags(268468224);
    startActivity(localIntent);
  }

  private void j()
  {
    Debug.f("switch", "exit login now!");
    Utils.showProgressDialog(getActivity(), 2131493296);
    Utils.switchBracelet(getActivity(), 1);
    SwitchOperator localSwitchOperator = Keeper.readSwitchOperator();
    SharedPreferences.Editor localEditor = Keeper.getSharedPref().edit();
    localEditor.clear();
    localEditor.commit();
    Keeper.keepSwitchOperator(localSwitchOperator);
    DaoManager.getInstance().getLuaListDao().deleteAll();
    DaoManager.getInstance().getLuaZipFileDao().deleteAll();
    DataManager.getInstance().clearAll();
    new Handler().postDelayed(new aU(this), 3000L);
  }

  private void k()
  {
    ArrayList localArrayList = DataManager.getInstance().getNeedSyncDatas();
    if ((localArrayList == null) || (localArrayList.size() == 0))
    {
      j();
      return;
    }
    Utils.showProgressDialog(getActivity(), 2131493267);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = localArrayList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        WebAPI.syncToServer(Keeper.readLoginData(), Keeper.readDeviceId(), 0, 0, localJSONArray.toString(), new aV(this));
        return;
      }
      localJSONArray.put(((UploadData)localIterator.next()).toJSONObject());
    }
  }

  private void l()
  {
    new BleSetPersonalInfoTask(this.l, new aW(this)).work();
  }

  public static Fragment newInstance()
  {
    PersonInfoFragment localPersonInfoFragment = new PersonInfoFragment();
    Bundle localBundle = new Bundle();
    PersonInfo localPersonInfo = Keeper.readPersonInfo();
    if (localPersonInfo != null)
      localBundle.putString("person_info_json", new Gson().toJson(localPersonInfo));
    localPersonInfoFragment.setArguments(localBundle);
    return localPersonInfoFragment;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 17) && (paramIntent != null))
    {
      this.l.avatarPath = paramIntent.getStringExtra("CROPPED_FILE_PATH");
      e();
      this.l.setNeedSyncServer(1);
      Keeper.keepPersonInfo(this.l);
      Debug.i("PersonInfoFragment", "onActivityResult requst_code =" + paramInt1);
      EventBus.getDefault().post(new EventPersonInfoUpdate("update_avatar"));
    }
    do
    {
      do
        return;
      while ((paramInt1 != 18) || (paramIntent == null) || (paramIntent.getExtras() == null));
      this.B = ((Bitmap)paramIntent.getExtras().get("data"));
    }
    while (this.B == null);
    try
    {
      String str = ((BraceletApp)getActivity().getApplication()).getStoragePath() + "/bracelet_icon.jpg";
      FileOutputStream localFileOutputStream = new FileOutputStream(str);
      this.B.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
      localFileOutputStream.close();
      this.l.avatarPath = str;
      this.n.setBackground(new BitmapDrawable(getResources(), Util.clipToRoundBitmap(this.B)));
      this.B.recycle();
      this.B = null;
      this.l.setNeedSyncServer(1);
      Keeper.keepPersonInfo(this.l);
      Debug.i("PersonInfoFragment", "onActivityResult requst_code =" + paramInt1 + " task photo post evnetbus");
      EventBus.getDefault().post(new EventPersonInfoUpdate("update_avatar"));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165552:
      MiliExitLoginFragment localMiliExitLoginFragment = new MiliExitLoginFragment();
      Bundle localBundle = new Bundle();
      localBundle.putInt("exit_login_type", 0);
      localMiliExitLoginFragment.setArguments(localBundle);
      localMiliExitLoginFragment.setOpClickListener(new aS(this));
      DimPanelFragment.showPanel(getActivity(), localMiliExitLoginFragment);
      return;
    case 2131165424:
      DimPanelFragment.showPanel(getActivity(), PersonInfoSettingSignatureFragment.class);
      return;
    case 2131165423:
      DimPanelFragment.showPanel(getActivity(), PersonInfoSettingNicknameFragment.class);
      return;
    case 2131165544:
      DimPanelFragment.showPanel(getActivity(), PersonInfoSettingGenderFragment.class);
      return;
    case 2131165548:
      DimPanelFragment.showPanel(getActivity(), PersonInfoSettingHeightFragment.class);
      return;
    case 2131165550:
      DimPanelFragment.showPanel(getActivity(), PersonInfoSettingWeightFragment.class);
      return;
    case 2131165546:
      DimPanelFragment.showPanel(getActivity(), PersonInfoSettingAgeFragment.class);
      return;
    case 2131165554:
      DimPanelFragment.showPanel(getActivity(), SelectImageQuestionFragment.class);
      return;
    case 2131165230:
      getActivity().finish();
      return;
    case 2131165565:
    }
    Intent localIntent = new Intent();
    localIntent.setClass(getActivity(), StatisticActivity.class);
    startActivity(localIntent);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    String str = getArguments().getString("person_info_json");
    PersonInfo localPersonInfo = (PersonInfo)new Gson().fromJson(str, PersonInfo.class);
    Debug.i("PersonInfoFragment", "thisperson=" + localPersonInfo);
    this.l = localPersonInfo;
    EventBus.getDefault().register(this);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903121, null);
    this.b = ((TextView)localView.findViewById(2131165545));
    this.c = localView.findViewById(2131165544);
    this.c.setOnClickListener(this);
    this.d = ((TextView)localView.findViewById(2131165549));
    this.e = localView.findViewById(2131165548);
    this.e.setOnClickListener(this);
    this.f = ((TextView)localView.findViewById(2131165551));
    this.g = localView.findViewById(2131165550);
    this.g.setOnClickListener(this);
    this.h = ((TextView)localView.findViewById(2131165547));
    this.i = localView.findViewById(2131165546);
    this.i.setOnClickListener(this);
    localView.findViewById(2131165552).setOnClickListener(this);
    this.m = localView.findViewById(2131165542);
    this.C = localView.findViewById(2131165543);
    if (Keeper.readPersonInfo().uid == this.l.uid)
      this.C.setVisibility(0);
    while (true)
    {
      this.n = ((ImageButton)this.m.findViewById(2131165554));
      this.n.setOnClickListener(this);
      this.o = ((TextView)this.m.findViewById(2131165556));
      this.p = ((TextView)this.m.findViewById(2131165558));
      this.q = ((TextView)this.m.findViewById(2131165559));
      this.q.setOnClickListener(this);
      this.r = ((ImageView)this.m.findViewById(2131165557));
      this.v = ((TextView)this.m.findViewById(2131165560));
      this.u = ((TextView)this.m.findViewById(2131165563));
      this.w = ((TextView)this.m.findViewById(2131165561));
      this.D = ((TextView)this.m.findViewById(2131165562));
      this.t = ((ImageButton)this.m.findViewById(2131165565));
      this.t.setOnClickListener(this);
      this.s = ((ImageButton)this.m.findViewById(2131165567));
      this.s.setOnClickListener(this);
      this.m.findViewById(2131165566);
      this.x = this.m.findViewById(2131165564);
      this.z = this.m.findViewById(2131165230);
      this.z.setOnClickListener(this);
      new Thread(new aQ(this)).start();
      d();
      if (this.l.getNeedSyncServer() != 0)
        onEvent(new EventPersonInfoUpdate());
      return localView;
      this.C.setVisibility(8);
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
  }

  public void onEvent(EventPersonInfoUpdate paramEventPersonInfoUpdate)
  {
    this.l = Keeper.readPersonInfo();
    Debug.i("PersonInfoFragment", "update ... ui " + this.l);
    if (!"update_avatar".equals(paramEventPersonInfoUpdate.type))
    {
      d();
      new BleSetPersonalInfoTask(this.l, new aW(this)).work();
    }
    Utils.updateProfile(this.l);
  }

  public void onPause()
  {
    super.onPause();
    AnalyticsTrackerManager.endTimedEvent(new String[] { "EventPersonPage" });
    UmengAnalytics.endPage("PagePersonInfo");
  }

  public void onResume()
  {
    super.onResume();
    AnalyticsTrackerManager.trackTimedEvent("EventPersonPage");
    UmengAnalytics.startPage("PagePersonInfo");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.PersonInfoFragment
 * JD-Core Version:    0.6.2
 */