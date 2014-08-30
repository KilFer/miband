package com.xiaomi.hm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class GifView extends ImageView
  implements GifAction, GifReDraw
{
  private GifDecoder a = null;
  private Bitmap b = null;
  private GifAnimation c = null;
  private boolean d = false;
  private int e = -1;
  private boolean f = false;
  private int g = 0;
  private int h = 0;
  private GifListener i = null;
  private boolean j = false;
  private int k = 0;
  private GifImageType l = GifImageType.SYNC_DECODER;
  private Handler m = new b(this);

  public GifView(Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.FIT_XY);
    this.c = new GifAnimation();
    this.c.setRedraw(this);
  }

  public GifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public GifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setScaleType(ImageView.ScaleType.FIT_XY);
    this.c = new GifAnimation();
    this.c.setRedraw(this);
  }

  private void a()
  {
    b();
    if (this.b != null)
      this.b = null;
    if (this.a != null)
    {
      c();
      this.a.destroy();
      this.a = null;
    }
    this.g = 0;
    this.a = new GifDecoder(this);
    if (this.f)
      this.a.setLoopAnimation();
  }

  private void a(Resources paramResources, int paramInt)
  {
    a();
    this.a.setGifImage(paramResources, paramInt);
    this.a.start();
  }

  private void a(byte[] paramArrayOfByte)
  {
    a();
    this.a.setGifImage(paramArrayOfByte);
    this.a.start();
  }

  private void b()
  {
    if (this.j)
      return;
    this.c.stopAnimation();
    this.d = false;
  }

  private void c()
  {
    if ((this.a != null) && (this.a.getState() != Thread.State.TERMINATED))
    {
      this.a.interrupt();
      this.a.destroy();
    }
  }

  private void d()
  {
    if (this.j)
      return;
    b();
    this.g = 0;
    this.c.runAnimation();
  }

  private int e()
  {
    GifFrame localGifFrame;
    if (this.a != null)
    {
      localGifFrame = this.a.next();
      if (localGifFrame != null);
    }
    else
    {
      return -1;
    }
    if (localGifFrame.image != null)
      this.b = localGifFrame.image;
    return localGifFrame.delay;
  }

  private void f()
  {
    if (this.m != null)
    {
      Message localMessage = this.m.obtainMessage();
      this.m.sendMessage(localMessage);
    }
  }

  private void g()
  {
    if ((this.b == null) || ((this.b != null) && (!this.b.isRecycled())))
    {
      setImageBitmap(this.b);
      invalidate();
      if ((this.i != null) && ((this.k == 2) || (this.k == 3)))
      {
        this.h = (1 + this.h);
        this.i.frameCount(this.h);
      }
    }
  }

  public void destroy()
  {
    b();
    c();
    this.c.destroy();
    this.a.destroy();
    this.a = null;
    this.c = null;
  }

  public void dispatchWindowVisibilityChanged(int paramInt)
  {
    if ((paramInt == 8) || (paramInt == 4))
      pauseGifAnimation();
    while (true)
    {
      super.dispatchWindowVisibilityChanged(paramInt);
      return;
      if (paramInt == 0)
        restartGifAnimation();
    }
  }

  public void loopEnd()
  {
    this.g = (1 + this.g);
    if ((this.e > 0) && (this.g >= this.e))
    {
      b();
      c();
    }
    if (this.i != null)
    {
      if ((this.k == 1) || (this.k == 3))
        this.i.gifEnd(this.g);
      this.h = 0;
    }
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
  }

  public void parseReturn(int paramInt)
  {
    if ((getVisibility() == 8) || (getVisibility() == 4));
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt)
          {
          default:
            return;
          case 1:
            Log.d("parseReturn", "FIRST");
          case 2:
          case 3:
          case 4:
          }
        }
        while ((this.l != GifImageType.COVER) && (this.l != GifImageType.SYNC_DECODER));
        this.b = this.a.getFrameImage();
        f();
        return;
        Log.d("parseReturn", "FINISH");
        if (this.a.getFrameCount() == 1)
        {
          e();
          f();
          b();
          c();
          this.j = true;
          return;
        }
        this.j = false;
      }
      while (this.d);
      d();
      this.d = true;
      return;
      Log.d("parseReturn", "CACHE_FINISH");
    }
    while (this.d);
    d();
    this.d = true;
    return;
    Log.e("parseReturn", "ERROR");
  }

  public void pauseGifAnimation()
  {
    if (this.j)
      return;
    this.c.pauseAnimation();
  }

  public int reDraw()
  {
    int n = e();
    g();
    return n;
  }

  public void restartGifAnimation()
  {
    if (this.j);
    while (!this.d)
      return;
    this.c.restartAnimation();
  }

  public void setGifImage(int paramInt)
  {
    Resources localResources = getResources();
    a();
    this.a.setGifImage(localResources, paramInt);
    this.a.start();
  }

  public void setGifImage(String paramString)
  {
    a();
    this.a.setGifImage(paramString);
    this.a.start();
  }

  public void setGifImage(byte[] paramArrayOfByte)
  {
    a();
    this.a.setGifImage(paramArrayOfByte);
    this.a.start();
  }

  public void setGifImageType(GifImageType paramGifImageType)
  {
    if (this.a == null)
      this.l = paramGifImageType;
  }

  public void setListener(GifListener paramGifListener, int paramInt)
  {
    this.i = paramGifListener;
    if ((paramInt > 0) && (paramInt <= 3))
      this.k = paramInt;
  }

  public void setLoopAnimation()
  {
    this.f = true;
    if (this.a != null)
      this.a.setLoopAnimation();
  }

  public void setLoopNumber(int paramInt)
  {
    if (paramInt > 1)
    {
      this.e = paramInt;
      setLoopAnimation();
    }
  }

  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
      b();
    while (paramInt != 0)
      return;
    d();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.view.GifView
 * JD-Core Version:    0.6.2
 */