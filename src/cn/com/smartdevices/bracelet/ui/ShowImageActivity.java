package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.BraceletImageLoader;
import cn.com.smartdevices.bracelet.Debug;
import com.nostra13.universalimageloader.core.assist.ImageSize;

public class ShowImageActivity extends Activity
{
  private ImageView a = null;
  private Uri b = null;
  private Bitmap c = null;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getIntent().getData();
    Debug.i("WPJ", "URI:" + this.b.toString());
    setContentView(2130903058);
    this.a = ((ImageView)findViewById(2131165316));
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    ImageSize localImageSize = new ImageSize(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    BraceletImageLoader.getInstance().loadImageAsync(this.b.toString(), localImageSize, new bG(this));
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.c != null)
    {
      this.c.recycle();
      this.c = null;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.ShowImageActivity
 * JD-Core Version:    0.6.2
 */