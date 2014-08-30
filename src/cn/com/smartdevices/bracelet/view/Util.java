package cn.com.smartdevices.bracelet.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.Debug;

public class Util
{
  private static final String a = "Util";
  private static ProgressDialog b = null;

  // ERROR //
  public static Bitmap bitmapFromFilePath(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 25	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokestatic 34	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   11: astore_2
    //   12: aload_0
    //   13: invokevirtual 40	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   16: aload_2
    //   17: invokevirtual 46	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   20: astore 10
    //   22: aload 10
    //   24: astore 4
    //   26: aload 4
    //   28: aconst_null
    //   29: invokestatic 52	android/graphics/drawable/Drawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   32: astore 12
    //   34: aload 12
    //   36: astore 8
    //   38: aload 4
    //   40: ifnull +8 -> 48
    //   43: aload 4
    //   45: invokevirtual 57	java/io/InputStream:close	()V
    //   48: aload 8
    //   50: checkcast 59	android/graphics/drawable/BitmapDrawable
    //   53: invokevirtual 63	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   56: areturn
    //   57: astore 7
    //   59: aconst_null
    //   60: astore 4
    //   62: ldc 65
    //   64: new 67	java/lang/StringBuilder
    //   67: dup
    //   68: ldc 69
    //   70: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_2
    //   74: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 84	cn/com/smartdevices/bracelet/Debug:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aconst_null
    //   84: astore 8
    //   86: aload 4
    //   88: ifnull -40 -> 48
    //   91: aload 4
    //   93: invokevirtual 57	java/io/InputStream:close	()V
    //   96: aconst_null
    //   97: astore 8
    //   99: goto -51 -> 48
    //   102: astore 9
    //   104: ldc 65
    //   106: new 67	java/lang/StringBuilder
    //   109: dup
    //   110: ldc 86
    //   112: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload_2
    //   116: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 84	cn/com/smartdevices/bracelet/Debug:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aconst_null
    //   126: astore 8
    //   128: goto -80 -> 48
    //   131: astore_3
    //   132: aconst_null
    //   133: astore 4
    //   135: aload_3
    //   136: astore 5
    //   138: aload 4
    //   140: ifnull +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 57	java/io/InputStream:close	()V
    //   148: aload 5
    //   150: athrow
    //   151: astore 6
    //   153: ldc 65
    //   155: new 67	java/lang/StringBuilder
    //   158: dup
    //   159: ldc 86
    //   161: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: aload_2
    //   165: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 84	cn/com/smartdevices/bracelet/Debug:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: goto -26 -> 148
    //   177: astore 13
    //   179: ldc 65
    //   181: new 67	java/lang/StringBuilder
    //   184: dup
    //   185: ldc 86
    //   187: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   190: aload_2
    //   191: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 84	cn/com/smartdevices/bracelet/Debug:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: goto -152 -> 48
    //   203: astore 5
    //   205: goto -67 -> 138
    //   208: astore 11
    //   210: goto -148 -> 62
    //
    // Exception table:
    //   from	to	target	type
    //   12	22	57	java/lang/Exception
    //   91	96	102	java/io/IOException
    //   12	22	131	finally
    //   143	148	151	java/io/IOException
    //   43	48	177	java/io/IOException
    //   26	34	203	finally
    //   62	83	203	finally
    //   26	34	208	java/lang/Exception
  }

  public static Bitmap clipToRoundBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      return null;
    int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    Debug.i("Util", "round bitmap w=" + paramBitmap.getWidth() + ", h=" + paramBitmap.getHeight());
    Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect();
    RectF localRectF = new RectF();
    if (paramBitmap.getWidth() > paramBitmap.getHeight())
    {
      localRect.left = ((paramBitmap.getWidth() - i) / 2);
      localRect.top = 0;
      localRect.right = (paramBitmap.getWidth() - localRect.left);
      localRect.bottom = paramBitmap.getHeight();
    }
    while (true)
    {
      localRectF.left = 0.0F;
      localRectF.top = 0.0F;
      localRectF.right = i;
      localRectF.bottom = i;
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-16777216);
      int j = i / 2;
      localCanvas.drawRoundRect(localRectF, j, j, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect, localRectF, localPaint);
      return localBitmap;
      if (paramBitmap.getWidth() < paramBitmap.getHeight())
      {
        localRect.left = 0;
        localRect.top = ((paramBitmap.getHeight() - i) / 2);
        localRect.right = paramBitmap.getWidth();
        localRect.bottom = (paramBitmap.getHeight() - localRect.top);
      }
      else
      {
        localRect.left = 0;
        localRect.top = 0;
        localRect.right = paramBitmap.getWidth();
        localRect.bottom = paramBitmap.getHeight();
      }
    }
  }

  public static void hideProgressDialog()
  {
    try
    {
      Debug.i("Util", "mPd = " + b + ", is showing=" + b.isShowing());
      if (b != null)
      {
        b.dismiss();
        b.hide();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Debug.i("Util", "Exception: mPd = " + b);
    }
  }

  public static void showProgressDialog(Context paramContext, String paramString1, String paramString2)
  {
    showProgressDialog(paramContext, paramString1, paramString2, false);
  }

  public static void showProgressDialog(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((b != null) && (b.isShowing()))
    {
      updateProgressDialog(paramString2);
      return;
    }
    try
    {
      ProgressDialog localProgressDialog = ProgressDialog.show(paramContext, paramString1, paramString2);
      b = localProgressDialog;
      localProgressDialog.setCancelable(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void updateProgressDialog(String paramString)
  {
    try
    {
      if ((b != null) && (b.isShowing()))
        b.setMessage(paramString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.Util
 * JD-Core Version:    0.6.2
 */