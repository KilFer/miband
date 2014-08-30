package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.BraceletImageLoader;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import com.edmodo.cropper.CropImageView;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CropImageActivity extends Activity
  implements View.OnClickListener
{
  public static final String CROPPED_FILE_PATH = "CROPPED_FILE_PATH";
  private static final String a = "CropImageActivity";
  private static final int e = 1080;
  private static final int f = 1920;
  private final int b;
  private CropImageView c;
  private Bitmap d;
  private View g;
  private View h;

  private void a(String paramString)
  {
    Debug.i("CropImageActivity", "path = " + paramString);
    Uri localUri = Uri.parse(paramString);
    try
    {
      InputStream localInputStream2 = getContentResolver().openInputStream(localUri);
      localInputStream1 = localInputStream2;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeStream(localInputStream1, null, localOptions);
      i = localOptions.outWidth;
      j = localOptions.outHeight;
      Debug.i("CropImageActivity", "selected image, origin width=" + i + ", height=" + j);
      if (i * j > 2073600)
      {
        if (i / j > 0)
        {
          j = j * 1080 / i;
          i = 1080;
        }
      }
      else
      {
        Debug.i("CropImageActivity", "selected image, new width=" + i + ", height=" + j);
        if ((i <= 0) || (j <= 0))
        {
          j = 1920;
          i = 1080;
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      try
      {
        while (true)
        {
          Bitmap localBitmap2 = BraceletImageLoader.getInstance().loadImageSync(paramString, new ImageSize(i, j));
          localBitmap1 = localBitmap2;
          if (localBitmap1 != null)
            break;
          Toast.makeText(this, 2131493098, 1).show();
          setResult(0);
          finish();
          return;
          localFileNotFoundException = localFileNotFoundException;
          localFileNotFoundException.printStackTrace();
          InputStream localInputStream1 = null;
        }
        int i = i * 1920 / j;
        int j = 1920;
      }
      catch (Exception localException)
      {
        Bitmap localBitmap1;
        while (true)
        {
          localException.printStackTrace();
          localBitmap1 = null;
        }
        this.c.setImageBitmap(localBitmap1);
      }
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    Uri localUri;
    if (paramInt1 == 18)
    {
      if (paramIntent != null)
      {
        str = paramIntent.getDataString();
        Debug.i("CropImageActivity", "path = " + str);
        localUri = Uri.parse(str);
      }
    }
    else
      try
      {
        InputStream localInputStream2 = getContentResolver().openInputStream(localUri);
        localInputStream1 = localInputStream2;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(localInputStream1, null, localOptions);
        i = localOptions.outWidth;
        j = localOptions.outHeight;
        Debug.i("CropImageActivity", "selected image, origin width=" + i + ", height=" + j);
        if (i * j > 2073600)
        {
          if (i / j > 0)
          {
            j = j * 1080 / i;
            i = 1080;
          }
        }
        else
        {
          Debug.i("CropImageActivity", "selected image, new width=" + i + ", height=" + j);
          if ((i <= 0) || (j <= 0))
          {
            j = 1920;
            i = 1080;
          }
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        try
        {
          while (true)
          {
            Bitmap localBitmap2 = BraceletImageLoader.getInstance().loadImageSync(str, new ImageSize(i, j));
            localBitmap1 = localBitmap2;
            if (localBitmap1 != null)
              break;
            Toast.makeText(this, 2131493098, 1).show();
            setResult(0);
            finish();
            return;
            localFileNotFoundException = localFileNotFoundException;
            localFileNotFoundException.printStackTrace();
            InputStream localInputStream1 = null;
          }
          int i = i * 1920 / j;
          int j = 1920;
        }
        catch (Exception localException)
        {
          Bitmap localBitmap1;
          while (true)
          {
            localException.printStackTrace();
            localBitmap1 = null;
          }
          this.c.setImageBitmap(localBitmap1);
          return;
        }
      }
    finish();
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165333:
    default:
      return;
    case 2131165332:
      setResult(0);
      finish();
      return;
    case 2131165334:
    }
    this.d = this.c.getCroppedImage(320, 320);
    if (this.d == null)
    {
      Toast.makeText(this, 2131493098, 1).show();
      setResult(0);
      finish();
      return;
    }
    String str = ((BraceletApp)getApplication()).getStoragePath() + "/bracelet_icon.jpg";
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(str);
      this.d.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
      localFileOutputStream.close();
      Intent localIntent = new Intent();
      localIntent.putExtra("CROPPED_FILE_PATH", str);
      setResult(-1, localIntent);
      finish();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (true)
        localFileNotFoundException.printStackTrace();
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903063);
    Intent localIntent = new Intent();
    localIntent.setType("image/*");
    localIntent.setAction("android.intent.action.GET_CONTENT");
    startActivityForResult(localIntent, 18);
    this.c = ((CropImageView)findViewById(2131165328));
    this.g = findViewById(2131165334);
    this.g.setOnClickListener(this);
    this.h = findViewById(2131165332);
    this.h.setOnClickListener(this);
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PagePersonInfoAvatarCrop");
  }

  public void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PagePersonInfoAvatarCrop");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.CropImageActivity
 * JD-Core Version:    0.6.2
 */