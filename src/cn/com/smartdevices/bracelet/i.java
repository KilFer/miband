package cn.com.smartdevices.bracelet;

import android.app.Activity;
import android.widget.Toast;
import com.xiaomi.market.sdk.UpdateResponse;
import com.xiaomi.market.sdk.XiaomiUpdateListener;

final class i
  implements XiaomiUpdateListener
{
  i(Activity paramActivity, String paramString, boolean paramBoolean)
  {
  }

  public final void onUpdateReturned(int paramInt, UpdateResponse paramUpdateResponse)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                Debug.i("Utils", "有更新， UpdateResponse为本次更新的详细信息: " + paramUpdateResponse);
              }
              while (this.a.isDestroyed());
              Utils.a(paramUpdateResponse, this.a, this.b);
              return;
            }
            while (!this.c);
            Toast.makeText(this.a, 2131493125, 1).show();
            return;
          }
          while (!this.c);
          Toast.makeText(this.a, 2131492902, 1).show();
          return;
        }
        while (!this.c);
        Toast.makeText(this.a, 2131492902, 1).show();
        return;
      }
      while (!this.c);
      Toast.makeText(this.a, 2131492902, 1).show();
      return;
    }
    while (!this.c);
    Toast.makeText(this.a, 2131493126, 1).show();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.i
 * JD-Core Version:    0.6.2
 */