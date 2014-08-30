package com.xiaomi.hm.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class GifDecoder extends Thread
{
  private static final int H = 4096;
  private static final int N = 15;
  public static final int STATUS_FINISH = -1;
  public static final int STATUS_FORMAT_ERROR = 1;
  public static final int STATUS_OPEN_ERROR = 2;
  public static final int STATUS_PARSING;
  private byte[] A = new byte[256];
  private int B = 0;
  private int C = 0;
  private int D = 0;
  private boolean E = false;
  private int F = 0;
  private int G;
  private short[] I;
  private byte[] J;
  private byte[] K;
  private byte[] L;
  private int M;
  private Queue<GifFrame> O = new ArrayBlockingQueue(15);
  private final ReentrantLock P = new ReentrantLock();
  private final Condition Q = this.P.newCondition();
  private final Condition R = this.P.newCondition();
  private int S = 0;
  private boolean T = false;
  private ArrayList<GifFrame> U = new ArrayList(this.M);
  private int V = 0;
  private boolean W = false;
  private GifAction X = null;
  private byte[] Y = null;
  private boolean Z = false;
  private InputStream a;
  private int aa = 0;
  private Resources ab = null;
  private int ac = 0;
  private String ad = null;
  private int[] ae = null;
  private int[] af = new int[256];
  private InputStream b;
  private int c;
  private boolean d;
  private int e;
  private int f = 1;
  private int[] g;
  private int[] h;
  public int height;
  private int[] i;
  public boolean isDestroy = false;
  private int j;
  private int k;
  private int l;
  private int m;
  private boolean n;
  private boolean o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  public int width;
  private int x;
  private Bitmap y;
  private Bitmap z;

  public GifDecoder(GifAction paramGifAction)
  {
    this.X = paramGifAction;
  }

  public GifDecoder(GifAction paramGifAction, boolean paramBoolean)
  {
    this.X = paramGifAction;
    this.Z = paramBoolean;
  }

  private void a()
  {
    this.a = new ByteArrayInputStream(this.Y);
  }

  private int[] a(int paramInt)
  {
    int i1 = 0;
    int i2 = paramInt * 3;
    byte[] arrayOfByte = new byte[i2];
    while (true)
    {
      int i4;
      try
      {
        int i12 = this.a.read(arrayOfByte);
        i3 = i12;
        if (i3 < i2)
        {
          this.c = 1;
          return this.af;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        int i3 = 0;
        continue;
        i4 = 0;
      }
      while (i4 < paramInt)
      {
        int i5 = i1 + 1;
        int i6 = 0xFF & arrayOfByte[i1];
        int i7 = i5 + 1;
        int i8 = 0xFF & arrayOfByte[i5];
        int i9 = i7 + 1;
        int i10 = 0xFF & arrayOfByte[i7];
        int[] arrayOfInt = this.af;
        int i11 = i4 + 1;
        arrayOfInt[i4] = (i10 | (0xFF000000 | i6 << 16 | i8 << 8));
        i4 = i11;
        i1 = i9;
      }
    }
  }

  private void b()
  {
    this.a = this.ab.openRawResource(this.ac);
  }

  private void c()
  {
    try
    {
      this.a = new FileInputStream(this.ad);
      return;
    }
    catch (Exception localException)
    {
      Log.e("open failed", localException.toString());
    }
  }

  private void d()
  {
    if (this.a != null);
    try
    {
      this.a.close();
      label14: this.a = null;
      this.Y = null;
      this.c = 0;
      if (this.U != null)
      {
        this.U.clear();
        this.U = null;
      }
      if (this.O != null)
      {
        this.O.clear();
        this.O = null;
      }
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }

  private void e()
  {
    int i4;
    int i3;
    int i2;
    label252: int i10;
    int i12;
    label330: int i5;
    label420: int i1;
    int i6;
    int i7;
    while (true)
    {
      int i19;
      int i20;
      int i11;
      try
      {
        if (this.ae == null)
          this.ae = new int[this.width * this.height];
        if (this.D <= 0)
          break label448;
        if (this.D == 3)
        {
          if (-2 + this.M <= 0)
            this.z = null;
          this.z = null;
        }
        if (this.z == null)
          break label448;
        this.z.getPixels(this.ae, 0, this.width, 0, 0, this.width, this.height);
        if (this.D != 2)
          break label448;
        if (this.E)
          break label439;
        i17 = this.l;
        break label442;
        if (i18 >= this.x)
        {
          break label448;
          if (i4 >= this.t)
            this.y = Bitmap.createBitmap(this.ae, this.width, this.height, Bitmap.Config.RGB_565);
        }
        else
        {
          i19 = (i18 + this.v) * this.width + this.u;
          i20 = i19 + this.w;
          break label464;
          this.ae[i19] = i17;
          i19++;
          break label464;
        }
        if (!this.o)
          break label420;
        if (i3 < this.t)
          break;
        i2++;
        switch (i2)
        {
        default:
          int i8 = i3 + this.r;
          if (i8 >= this.height)
            break label502;
          int i9 = i8 * this.width;
          i10 = i9 + this.q;
          i11 = i10 + this.s;
          if (i9 + this.width < i11)
          {
            i12 = i9 + this.width;
            int i13 = i4 * this.s;
            break label495;
            byte[] arrayOfByte = this.L;
            int i14 = i13 + 1;
            int i15 = 0xFF & arrayOfByte[i13];
            int i16 = this.i[i15];
            if (i16 != 0)
              this.ae[i10] = i16;
            i10++;
            i13 = i14;
          }
          break;
        case 2:
        case 3:
        case 4:
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return;
      }
      catch (StackOverflowError localStackOverflowError)
      {
        localStackOverflowError.printStackTrace();
        return;
      }
      catch (Exception localException)
      {
        Log.e("GifView decode setpixel", localException.toString());
        return;
      }
      i12 = i11;
      continue;
      i5 = i3;
      i6 = i1;
      i7 = i2;
      i3 = i4;
      continue;
      label439: int i17 = 0;
      label442: int i18 = 0;
      continue;
      label448: i1 = 8;
      i2 = 1;
      i3 = 0;
      i4 = 0;
      continue;
      label464: if (i19 >= i20)
        i18++;
    }
    while (true)
    {
      i5 = i3 + i1;
      i6 = i1;
      i7 = i2;
      break label252;
      label495: if (i10 < i12)
        break label330;
      label502: i4++;
      i3 = i5;
      i1 = i6;
      i2 = i7;
      break;
      i3 = 4;
      continue;
      i3 = 2;
      i1 = 4;
      continue;
      i3 = 1;
      i1 = 2;
    }
  }

  private int f()
  {
    this.c = 0;
    if (!this.T)
      this.M = 0;
    this.g = null;
    this.h = null;
    this.S = 0;
    String str;
    int i1;
    if (this.a != null)
    {
      str = "";
      i1 = 0;
      label45: if (i1 >= 6)
      {
        if (str.startsWith("GIF"))
          break label287;
        this.c = 1;
        label66: if (!i())
        {
          m();
          if ((!this.T) && (this.M < 0))
          {
            this.c = 1;
            if (this.X != null)
              this.X.parseReturn(4);
          }
        }
      }
    }
    while (true)
    {
      try
      {
        if (this.a != null)
          this.a.close();
        this.a = null;
        if ((this.Z) && (!this.W))
          if (this.M > 15)
            break label431;
      }
      catch (Exception localException1)
      {
        try
        {
          this.P.lockInterruptibly();
          this.W = true;
          this.c = -1;
          if (this.X != null)
            this.X.parseReturn(2);
          this.Q.signal();
          this.P.unlock();
          switch (this.aa)
          {
          default:
            this.T = true;
            if (!this.isDestroy)
              f();
            return this.c;
            str = str + (char)k();
            i1++;
            break label45;
            label287: this.width = s();
            this.height = s();
            int i2 = k();
            int i3 = i2 & 0x80;
            boolean bool = false;
            if (i3 != 0)
              bool = true;
            this.d = bool;
            this.e = (2 << (i2 & 0x7));
            this.j = k();
            k();
            if ((!this.d) || (i()))
              break label66;
            this.g = a(this.e);
            this.k = this.g[this.j];
            break label66;
            localException1 = localException1;
            localException1.printStackTrace();
            continue;
          case 1:
          case 2:
          case 3:
          }
        }
        catch (Exception localException2)
        {
          this.P.unlock();
          continue;
        }
        finally
        {
          this.P.unlock();
        }
      }
      label431: if (this.U != null)
      {
        this.U.clear();
        continue;
        b();
        continue;
        c();
        continue;
        a();
        continue;
        this.c = 2;
        if (this.X != null)
          this.X.parseReturn(4);
      }
    }
  }

  private void g()
  {
    if ((!this.Z) || (this.W))
      label14: return;
    if (this.M <= 15);
    while (true)
    {
      try
      {
        this.P.lockInterruptibly();
        this.W = true;
        this.c = -1;
        if (this.X != null)
          this.X.parseReturn(2);
        this.Q.signal();
        this.P.unlock();
        switch (this.aa)
        {
        default:
          this.T = true;
          if (this.isDestroy)
            break label14;
          f();
          return;
        case 1:
        case 2:
        case 3:
        }
      }
      catch (Exception localException)
      {
        this.P.unlock();
        continue;
      }
      finally
      {
        this.P.unlock();
      }
      if (this.U != null)
      {
        this.U.clear();
        continue;
        b();
        continue;
        c();
        continue;
        a();
      }
    }
  }

  private void h()
  {
    int i1 = this.s * this.t;
    if ((this.L == null) || (this.L.length < i1))
      this.L = new byte[i1];
    if (this.I == null)
      this.I = new short[4096];
    if (this.J == null)
      this.J = new byte[4096];
    if (this.K == null)
      this.K = new byte[4097];
    int i2 = k();
    int i3 = 1 << i2;
    int i4 = i3 + 1;
    int i5 = i3 + 2;
    int i6 = -1;
    int i7 = i2 + 1;
    int i8 = -1 + (1 << i7);
    int i9 = 0;
    int i10;
    int i11;
    int i12;
    int i13;
    int i14;
    int i15;
    int i16;
    int i17;
    if (i9 >= i3)
    {
      i10 = 0;
      i11 = 0;
      i12 = 0;
      i13 = 0;
      i14 = 0;
      i15 = 0;
      i16 = 0;
      i17 = 0;
      label149: if (i14 < i1)
        break label190;
    }
    int i35;
    label159: label190: label221: label252: int i29;
    int i30;
    int i31;
    label393: int i33;
    do
    {
      do
      {
        do
        {
          i35 = i10;
          if (i35 < i1)
            break label636;
          return;
          this.I[i9] = 0;
          this.J[i9] = ((byte)i9);
          i9++;
          break;
          if (i11 != 0)
            break label661;
          if (i16 >= i7)
            break label252;
          if (i15 != 0)
            break label221;
          i15 = l();
        }
        while (i15 <= 0);
        i17 = 0;
        i13 += ((0xFF & this.A[i17]) << i16);
        i16 += 8;
        i17++;
        i15--;
        break label149;
        i29 = i13 & i8;
        i13 >>= i7;
        i16 -= i7;
      }
      while ((i29 > i5) || (i29 == i4));
      if (i29 == i3)
      {
        i7 = i2 + 1;
        i8 = -1 + (1 << i7);
        i5 = i3 + 2;
        i6 = -1;
        break label149;
      }
      if (i6 == -1)
      {
        byte[] arrayOfByte5 = this.K;
        int i36 = i11 + 1;
        arrayOfByte5[i11] = this.J[i29];
        i11 = i36;
        i6 = i29;
        i12 = i29;
        break label149;
      }
      if (i29 != i5)
        break label650;
      byte[] arrayOfByte4 = this.K;
      i30 = i11 + 1;
      arrayOfByte4[i11] = ((byte)i12);
      i31 = i6;
      if (i31 > i3)
        break label596;
      i33 = 0xFF & this.J[i31];
    }
    while (i5 >= 4096);
    byte[] arrayOfByte3 = this.K;
    int i34 = i30 + 1;
    arrayOfByte3[i30] = ((byte)i33);
    this.I[i5] = ((short)i6);
    this.J[i5] = ((byte)i33);
    int i25 = i5 + 1;
    if (((i25 & i8) == 0) && (i25 < 4096))
    {
      i7++;
      i8 += i25;
    }
    int i23 = i13;
    int i24 = i29;
    int i18 = i8;
    int i19 = i33;
    int i20 = i16;
    int i21 = i7;
    int i22 = i34;
    while (true)
    {
      int i26 = i22 - 1;
      byte[] arrayOfByte1 = this.L;
      int i27 = i10 + 1;
      arrayOfByte1[i10] = this.K[i26];
      i14++;
      i10 = i27;
      i7 = i21;
      i16 = i20;
      i12 = i19;
      i8 = i18;
      int i28 = i24;
      i13 = i23;
      i11 = i26;
      i5 = i25;
      i6 = i28;
      break;
      label596: byte[] arrayOfByte2 = this.K;
      int i32 = i30 + 1;
      arrayOfByte2[i30] = this.J[i31];
      i31 = this.I[i31];
      i30 = i32;
      break label393;
      label636: this.L[i35] = 0;
      i35++;
      break label159;
      label650: i30 = i11;
      i31 = i29;
      break label393;
      label661: i18 = i8;
      i19 = i12;
      i20 = i16;
      i21 = i7;
      i22 = i11;
      i23 = i13;
      i24 = i6;
      i25 = i5;
    }
  }

  private boolean i()
  {
    return this.c != 0;
  }

  private void j()
  {
    this.c = 0;
    if (!this.T)
      this.M = 0;
    this.g = null;
    this.h = null;
    this.S = 0;
  }

  private int k()
  {
    try
    {
      int i1 = this.a.read();
      return i1;
    }
    catch (Exception localException)
    {
      this.c = 1;
    }
    return 0;
  }

  private int l()
  {
    this.B = k();
    int i1 = this.B;
    int i2 = 0;
    if (i1 > 0);
    try
    {
      while (true)
      {
        int i3 = this.B;
        if (i2 >= i3);
        int i4;
        do
        {
          if (i2 < this.B)
            this.c = 1;
          return i2;
          i4 = this.a.read(this.A, i2, this.B - i2);
        }
        while (i4 == -1);
        i2 += i4;
      }
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private void m()
  {
    int i1 = 0;
    boolean bool2;
    label126: boolean bool3;
    label143: label187: int i5;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    int i13;
    int i14;
    label421: int i15;
    int i16;
    int i17;
    int i18;
    int i19;
    int i20;
    int i21;
    int i22;
    label452: label459: int i40;
    label463: 
    do
    {
      do
      {
        while (true)
        {
          if ((i1 != 0) || (i()) || (this.isDestroy))
            return;
          switch (k())
          {
          case 0:
          default:
            this.c = 1;
          case 44:
          case 33:
          case 59:
          }
        }
        this.q = s();
        this.r = s();
        this.s = s();
        this.t = s();
        int i4 = k();
        if ((i4 & 0x80) == 0)
          break;
        bool2 = true;
        this.n = bool2;
        if ((i4 & 0x40) == 0)
          break label750;
        bool3 = true;
        this.o = bool3;
        this.p = (2 << (i4 & 0x7));
        if (!this.n)
          break label756;
        this.h = a(this.p);
        this.i = this.h;
        boolean bool4 = this.E;
        i5 = 0;
        if (bool4)
        {
          int[] arrayOfInt = this.i;
          i5 = 0;
          if (arrayOfInt != null)
          {
            int i42 = this.i.length;
            i5 = 0;
            if (i42 > 0)
            {
              int i43 = this.i.length;
              int i44 = this.G;
              i5 = 0;
              if (i43 > i44)
              {
                i5 = this.i[this.G];
                this.i[this.G] = 0;
              }
            }
          }
        }
        if (this.i == null)
          this.c = 1;
      }
      while (i());
      int i6 = this.s * this.t;
      if ((this.L == null) || (this.L.length < i6))
        this.L = new byte[i6];
      if (this.I == null)
        this.I = new short[4096];
      if (this.J == null)
        this.J = new byte[4096];
      if (this.K == null)
        this.K = new byte[4097];
      i7 = k();
      i8 = 1 << i7;
      i9 = i8 + 1;
      i10 = i8 + 2;
      i11 = -1;
      i12 = i7 + 1;
      i13 = -1 + (1 << i12);
      i14 = 0;
      if (i14 < i8)
        break label783;
      i15 = 0;
      i16 = 0;
      i17 = 0;
      i18 = 0;
      i19 = 0;
      i20 = 0;
      i21 = 0;
      i22 = 0;
      if (i19 < i6)
        break label807;
      i40 = i15;
      if (i40 < i6)
        break label1257;
      u();
    }
    while (i());
    if (!this.T)
      this.M = (1 + this.M);
    e();
    while (true)
    {
      label750: label756: int i34;
      label783: label807: int i35;
      int i36;
      int i30;
      int i28;
      int i29;
      int i23;
      int i24;
      int i25;
      int i26;
      int i27;
      try
      {
        this.P.lockInterruptibly();
      }
      catch (Exception localException)
      {
        try
        {
          if ((this.O == null) || (this.O.size() < 15))
          {
            if (this.O != null)
            {
              GifFrame localGifFrame = new GifFrame(this.y, this.F);
              this.O.add(localGifFrame);
              if (!this.T)
                this.U.add(localGifFrame);
              this.Q.signal();
              if ((!this.T) && (this.S >= 0))
              {
                this.S = (1 + this.S);
                if (this.S < 15)
                  continue;
                this.X.parseReturn(3);
                this.S = -1;
              }
            }
            this.P.unlock();
            if (this.E)
              this.i[this.G] = i5;
            this.D = this.C;
            this.u = this.q;
            this.v = this.r;
            this.w = this.s;
            this.x = this.t;
            this.z = this.y;
            this.l = this.k;
            this.C = 0;
            this.E = false;
            this.F = 0;
            this.h = null;
            break;
            bool2 = false;
            break label126;
            bool3 = false;
            break label143;
            this.i = this.g;
            if (this.j != this.G)
              break label187;
            this.k = 0;
            break label187;
            this.I[i14] = 0;
            this.J[i14] = ((byte)i14);
            i14++;
            break label421;
            if (i16 != 0)
              break label1570;
            if (i21 < i12)
            {
              if (i20 == 0)
              {
                i20 = l();
                if (i20 <= 0)
                  break label459;
                i22 = 0;
              }
              i18 += ((0xFF & this.A[i22]) << i21);
              i21 += 8;
              i22++;
              i20--;
              break label452;
            }
            i34 = i18 & i13;
            i18 >>= i12;
            i21 -= i12;
            if ((i34 > i10) || (i34 == i9))
              break label459;
            if (i34 == i8)
            {
              i12 = i7 + 1;
              i13 = -1 + (1 << i12);
              i10 = i8 + 2;
              i11 = -1;
              break label452;
            }
            if (i11 == -1)
            {
              byte[] arrayOfByte5 = this.K;
              int i41 = i16 + 1;
              arrayOfByte5[i16] = this.J[i34];
              i16 = i41;
              i11 = i34;
              i17 = i34;
              break label452;
            }
            if (i34 != i10)
              break label1559;
            byte[] arrayOfByte4 = this.K;
            i35 = i16 + 1;
            arrayOfByte4[i16] = ((byte)i17);
            i36 = i11;
            if (i36 <= i8)
            {
              int i38 = 0xFF & this.J[i36];
              if (i10 >= 4096)
                break label459;
              byte[] arrayOfByte3 = this.K;
              int i39 = i35 + 1;
              arrayOfByte3[i35] = ((byte)i38);
              this.I[i10] = ((short)i11);
              this.J[i10] = ((byte)i38);
              i30 = i10 + 1;
              if (((i30 & i13) == 0) && (i30 < 4096))
              {
                i12++;
                i13 += i30;
              }
              i28 = i18;
              i29 = i34;
              i23 = i13;
              i24 = i38;
              i25 = i21;
              i26 = i12;
              i27 = i39;
              int i31 = i27 - 1;
              byte[] arrayOfByte1 = this.L;
              int i32 = i15 + 1;
              arrayOfByte1[i15] = this.K[i31];
              i19++;
              i15 = i32;
              i12 = i26;
              i21 = i25;
              i17 = i24;
              i13 = i23;
              int i33 = i29;
              i18 = i28;
              i16 = i31;
              i10 = i30;
              i11 = i33;
              break label452;
            }
            byte[] arrayOfByte2 = this.K;
            int i37 = i35 + 1;
            arrayOfByte2[i35] = this.J[i36];
            i36 = this.I[i36];
            i35 = i37;
            continue;
            label1257: this.L[i40] = 0;
            i40++;
            break label463;
          }
          this.R.await();
          continue;
        }
        catch (InterruptedException localInterruptedException)
        {
          this.R.signal();
          this.P.unlock();
          continue;
          localException = localException;
          localException.printStackTrace();
          continue;
          if (this.S != 1)
            continue;
          this.X.parseReturn(1);
          continue;
        }
        finally
        {
          this.P.unlock();
        }
      }
      switch (k())
      {
      default:
        u();
        break;
      case 249:
        k();
        int i3 = k();
        this.C = ((i3 & 0x1C) >> 2);
        if (this.C == 0)
          this.C = 1;
        if ((i3 & 0x1) != 0);
        for (boolean bool1 = true; ; bool1 = false)
        {
          this.E = bool1;
          this.F = (10 * s());
          if (this.F == 0)
            this.F = 100;
          this.G = k();
          k();
          break;
        }
      case 255:
        l();
        String str = "";
        for (int i2 = 0; ; i2++)
        {
          if (i2 >= 11)
          {
            if (!str.equals("NETSCAPE2.0"))
              break label1547;
            r();
            break;
          }
          str = str + (char)this.A[i2];
        }
        label1547: u();
        break;
        i1 = 1;
        break;
        label1559: i35 = i16;
        i36 = i34;
        continue;
        label1570: i23 = i13;
        i24 = i17;
        i25 = i21;
        i26 = i12;
        i27 = i16;
        i28 = i18;
        i29 = i11;
        i30 = i10;
      }
    }
  }

  private void n()
  {
    int i1 = 1;
    k();
    int i2 = k();
    this.C = ((i2 & 0x1C) >> 2);
    if (this.C == 0)
      this.C = i1;
    if ((i2 & 0x1) != 0);
    while (true)
    {
      this.E = i1;
      this.F = (10 * s());
      if (this.F == 0)
        this.F = 100;
      this.G = k();
      k();
      return;
      i1 = 0;
    }
  }

  private void o()
  {
    int i1 = 1;
    String str = "";
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= 6)
      {
        if (str.startsWith("GIF"))
          break;
        this.c = i1;
        return;
      }
      str = str + (char)k();
    }
    this.width = s();
    this.height = s();
    int i3 = k();
    if ((i3 & 0x80) != 0);
    while (true)
    {
      this.d = i1;
      this.e = (2 << (i3 & 0x7));
      this.j = k();
      k();
      if ((!this.d) || (i()))
        break;
      this.g = a(this.e);
      this.k = this.g[this.j];
      return;
      i1 = 0;
    }
  }

  // ERROR //
  private void p()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: invokespecial 326	com/xiaomi/hm/view/GifDecoder:s	()I
    //   5: putfield 262	com/xiaomi/hm/view/GifDecoder:q	I
    //   8: aload_0
    //   9: aload_0
    //   10: invokespecial 326	com/xiaomi/hm/view/GifDecoder:s	()I
    //   13: putfield 260	com/xiaomi/hm/view/GifDecoder:r	I
    //   16: aload_0
    //   17: aload_0
    //   18: invokespecial 326	com/xiaomi/hm/view/GifDecoder:s	()I
    //   21: putfield 264	com/xiaomi/hm/view/GifDecoder:s	I
    //   24: aload_0
    //   25: aload_0
    //   26: invokespecial 326	com/xiaomi/hm/view/GifDecoder:s	()I
    //   29: putfield 238	com/xiaomi/hm/view/GifDecoder:t	I
    //   32: aload_0
    //   33: invokespecial 319	com/xiaomi/hm/view/GifDecoder:k	()I
    //   36: istore_1
    //   37: iload_1
    //   38: sipush 128
    //   41: iand
    //   42: ifeq +172 -> 214
    //   45: iconst_1
    //   46: istore_2
    //   47: aload_0
    //   48: iload_2
    //   49: putfield 359	com/xiaomi/hm/view/GifDecoder:n	Z
    //   52: iload_1
    //   53: bipush 64
    //   55: iand
    //   56: ifeq +163 -> 219
    //   59: iconst_1
    //   60: istore_3
    //   61: aload_0
    //   62: iload_3
    //   63: putfield 258	com/xiaomi/hm/view/GifDecoder:o	Z
    //   66: aload_0
    //   67: iconst_2
    //   68: iload_1
    //   69: bipush 7
    //   71: iand
    //   72: ishl
    //   73: putfield 361	com/xiaomi/hm/view/GifDecoder:p	I
    //   76: aload_0
    //   77: getfield 359	com/xiaomi/hm/view/GifDecoder:n	Z
    //   80: ifeq +144 -> 224
    //   83: aload_0
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 361	com/xiaomi/hm/view/GifDecoder:p	I
    //   89: invokespecial 334	com/xiaomi/hm/view/GifDecoder:a	(I)[I
    //   92: putfield 277	com/xiaomi/hm/view/GifDecoder:h	[I
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 277	com/xiaomi/hm/view/GifDecoder:h	[I
    //   100: putfield 268	com/xiaomi/hm/view/GifDecoder:i	[I
    //   103: aload_0
    //   104: getfield 107	com/xiaomi/hm/view/GifDecoder:E	Z
    //   107: istore 4
    //   109: iconst_0
    //   110: istore 5
    //   112: iload 4
    //   114: ifeq +76 -> 190
    //   117: aload_0
    //   118: getfield 268	com/xiaomi/hm/view/GifDecoder:i	[I
    //   121: astore 81
    //   123: iconst_0
    //   124: istore 5
    //   126: aload 81
    //   128: ifnull +62 -> 190
    //   131: aload_0
    //   132: getfield 268	com/xiaomi/hm/view/GifDecoder:i	[I
    //   135: arraylength
    //   136: istore 82
    //   138: iconst_0
    //   139: istore 5
    //   141: iload 82
    //   143: ifle +47 -> 190
    //   146: aload_0
    //   147: getfield 268	com/xiaomi/hm/view/GifDecoder:i	[I
    //   150: arraylength
    //   151: istore 83
    //   153: aload_0
    //   154: getfield 363	com/xiaomi/hm/view/GifDecoder:G	I
    //   157: istore 84
    //   159: iconst_0
    //   160: istore 5
    //   162: iload 83
    //   164: iload 84
    //   166: if_icmple +24 -> 190
    //   169: aload_0
    //   170: getfield 268	com/xiaomi/hm/view/GifDecoder:i	[I
    //   173: aload_0
    //   174: getfield 363	com/xiaomi/hm/view/GifDecoder:G	I
    //   177: iaload
    //   178: istore 5
    //   180: aload_0
    //   181: getfield 268	com/xiaomi/hm/view/GifDecoder:i	[I
    //   184: aload_0
    //   185: getfield 363	com/xiaomi/hm/view/GifDecoder:G	I
    //   188: iconst_0
    //   189: iastore
    //   190: iload 5
    //   192: istore 6
    //   194: aload_0
    //   195: getfield 268	com/xiaomi/hm/view/GifDecoder:i	[I
    //   198: ifnonnull +8 -> 206
    //   201: aload_0
    //   202: iconst_1
    //   203: putfield 181	com/xiaomi/hm/view/GifDecoder:c	I
    //   206: aload_0
    //   207: invokespecial 290	com/xiaomi/hm/view/GifDecoder:i	()Z
    //   210: ifeq +41 -> 251
    //   213: return
    //   214: iconst_0
    //   215: istore_2
    //   216: goto -169 -> 47
    //   219: iconst_0
    //   220: istore_3
    //   221: goto -160 -> 61
    //   224: aload_0
    //   225: aload_0
    //   226: getfield 275	com/xiaomi/hm/view/GifDecoder:g	[I
    //   229: putfield 268	com/xiaomi/hm/view/GifDecoder:i	[I
    //   232: aload_0
    //   233: getfield 332	com/xiaomi/hm/view/GifDecoder:j	I
    //   236: aload_0
    //   237: getfield 363	com/xiaomi/hm/view/GifDecoder:G	I
    //   240: if_icmpne -137 -> 103
    //   243: aload_0
    //   244: iconst_0
    //   245: putfield 336	com/xiaomi/hm/view/GifDecoder:k	I
    //   248: goto -145 -> 103
    //   251: aload_0
    //   252: getfield 264	com/xiaomi/hm/view/GifDecoder:s	I
    //   255: aload_0
    //   256: getfield 238	com/xiaomi/hm/view/GifDecoder:t	I
    //   259: imul
    //   260: istore 7
    //   262: aload_0
    //   263: getfield 266	com/xiaomi/hm/view/GifDecoder:L	[B
    //   266: ifnull +13 -> 279
    //   269: aload_0
    //   270: getfield 266	com/xiaomi/hm/view/GifDecoder:L	[B
    //   273: arraylength
    //   274: iload 7
    //   276: if_icmpge +11 -> 287
    //   279: aload_0
    //   280: iload 7
    //   282: newarray byte
    //   284: putfield 266	com/xiaomi/hm/view/GifDecoder:L	[B
    //   287: aload_0
    //   288: getfield 344	com/xiaomi/hm/view/GifDecoder:I	[S
    //   291: ifnonnull +12 -> 303
    //   294: aload_0
    //   295: sipush 4096
    //   298: newarray short
    //   300: putfield 344	com/xiaomi/hm/view/GifDecoder:I	[S
    //   303: aload_0
    //   304: getfield 346	com/xiaomi/hm/view/GifDecoder:J	[B
    //   307: ifnonnull +12 -> 319
    //   310: aload_0
    //   311: sipush 4096
    //   314: newarray byte
    //   316: putfield 346	com/xiaomi/hm/view/GifDecoder:J	[B
    //   319: aload_0
    //   320: getfield 348	com/xiaomi/hm/view/GifDecoder:K	[B
    //   323: ifnonnull +12 -> 335
    //   326: aload_0
    //   327: sipush 4097
    //   330: newarray byte
    //   332: putfield 348	com/xiaomi/hm/view/GifDecoder:K	[B
    //   335: aload_0
    //   336: invokespecial 319	com/xiaomi/hm/view/GifDecoder:k	()I
    //   339: istore 8
    //   341: iconst_1
    //   342: iload 8
    //   344: ishl
    //   345: istore 9
    //   347: iload 9
    //   349: iconst_1
    //   350: iadd
    //   351: istore 10
    //   353: iload 9
    //   355: iconst_2
    //   356: iadd
    //   357: istore 11
    //   359: iconst_m1
    //   360: istore 12
    //   362: iload 8
    //   364: iconst_1
    //   365: iadd
    //   366: istore 13
    //   368: iconst_m1
    //   369: iconst_1
    //   370: iload 13
    //   372: ishl
    //   373: iadd
    //   374: istore 14
    //   376: iconst_0
    //   377: istore 15
    //   379: iload 15
    //   381: iload 9
    //   383: if_icmplt +477 -> 860
    //   386: iconst_0
    //   387: istore 16
    //   389: iconst_0
    //   390: istore 17
    //   392: iconst_0
    //   393: istore 18
    //   395: iconst_0
    //   396: istore 19
    //   398: iconst_0
    //   399: istore 20
    //   401: iconst_0
    //   402: istore 21
    //   404: iconst_0
    //   405: istore 22
    //   407: iconst_0
    //   408: istore 23
    //   410: iload 20
    //   412: iload 7
    //   414: if_icmplt +470 -> 884
    //   417: iload 16
    //   419: istore 44
    //   421: iload 44
    //   423: iload 7
    //   425: if_icmplt +909 -> 1334
    //   428: aload_0
    //   429: invokespecial 365	com/xiaomi/hm/view/GifDecoder:u	()V
    //   432: aload_0
    //   433: invokespecial 290	com/xiaomi/hm/view/GifDecoder:i	()Z
    //   436: ifne -223 -> 213
    //   439: aload_0
    //   440: getfield 133	com/xiaomi/hm/view/GifDecoder:T	Z
    //   443: ifne +13 -> 456
    //   446: aload_0
    //   447: iconst_1
    //   448: aload_0
    //   449: getfield 137	com/xiaomi/hm/view/GifDecoder:M	I
    //   452: iadd
    //   453: putfield 137	com/xiaomi/hm/view/GifDecoder:M	I
    //   456: aload_0
    //   457: getfield 160	com/xiaomi/hm/view/GifDecoder:ae	[I
    //   460: ifnonnull +18 -> 478
    //   463: aload_0
    //   464: aload_0
    //   465: getfield 222	com/xiaomi/hm/view/GifDecoder:width	I
    //   468: aload_0
    //   469: getfield 224	com/xiaomi/hm/view/GifDecoder:height	I
    //   472: imul
    //   473: newarray int
    //   475: putfield 160	com/xiaomi/hm/view/GifDecoder:ae	[I
    //   478: aload_0
    //   479: getfield 105	com/xiaomi/hm/view/GifDecoder:D	I
    //   482: ifle +1287 -> 1769
    //   485: aload_0
    //   486: getfield 105	com/xiaomi/hm/view/GifDecoder:D	I
    //   489: iconst_3
    //   490: if_icmpne +23 -> 513
    //   493: bipush 254
    //   495: aload_0
    //   496: getfield 137	com/xiaomi/hm/view/GifDecoder:M	I
    //   499: iadd
    //   500: ifgt +8 -> 508
    //   503: aload_0
    //   504: aconst_null
    //   505: putfield 226	com/xiaomi/hm/view/GifDecoder:z	Landroid/graphics/Bitmap;
    //   508: aload_0
    //   509: aconst_null
    //   510: putfield 226	com/xiaomi/hm/view/GifDecoder:z	Landroid/graphics/Bitmap;
    //   513: aload_0
    //   514: getfield 226	com/xiaomi/hm/view/GifDecoder:z	Landroid/graphics/Bitmap;
    //   517: ifnull +1252 -> 1769
    //   520: aload_0
    //   521: getfield 226	com/xiaomi/hm/view/GifDecoder:z	Landroid/graphics/Bitmap;
    //   524: aload_0
    //   525: getfield 160	com/xiaomi/hm/view/GifDecoder:ae	[I
    //   528: iconst_0
    //   529: aload_0
    //   530: getfield 222	com/xiaomi/hm/view/GifDecoder:width	I
    //   533: iconst_0
    //   534: iconst_0
    //   535: aload_0
    //   536: getfield 222	com/xiaomi/hm/view/GifDecoder:width	I
    //   539: aload_0
    //   540: getfield 224	com/xiaomi/hm/view/GifDecoder:height	I
    //   543: invokevirtual 232	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   546: aload_0
    //   547: getfield 105	com/xiaomi/hm/view/GifDecoder:D	I
    //   550: iconst_2
    //   551: if_icmpne +1218 -> 1769
    //   554: aload_0
    //   555: getfield 107	com/xiaomi/hm/view/GifDecoder:E	Z
    //   558: istore 73
    //   560: iconst_0
    //   561: istore 74
    //   563: iload 73
    //   565: ifne +1198 -> 1763
    //   568: aload_0
    //   569: getfield 234	com/xiaomi/hm/view/GifDecoder:l	I
    //   572: istore 74
    //   574: goto +1189 -> 1763
    //   577: iload 75
    //   579: aload_0
    //   580: getfield 236	com/xiaomi/hm/view/GifDecoder:x	I
    //   583: if_icmplt +765 -> 1348
    //   586: goto +1183 -> 1769
    //   589: iload 58
    //   591: aload_0
    //   592: getfield 238	com/xiaomi/hm/view/GifDecoder:t	I
    //   595: if_icmplt +799 -> 1394
    //   598: aload_0
    //   599: aload_0
    //   600: getfield 160	com/xiaomi/hm/view/GifDecoder:ae	[I
    //   603: aload_0
    //   604: getfield 222	com/xiaomi/hm/view/GifDecoder:width	I
    //   607: aload_0
    //   608: getfield 224	com/xiaomi/hm/view/GifDecoder:height	I
    //   611: getstatic 244	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   614: invokestatic 248	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   617: putfield 250	com/xiaomi/hm/view/GifDecoder:y	Landroid/graphics/Bitmap;
    //   620: aload_0
    //   621: getfield 121	com/xiaomi/hm/view/GifDecoder:P	Ljava/util/concurrent/locks/ReentrantLock;
    //   624: invokevirtual 300	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   627: aload_0
    //   628: getfield 116	com/xiaomi/hm/view/GifDecoder:O	Ljava/util/Queue;
    //   631: ifnull +17 -> 648
    //   634: aload_0
    //   635: getfield 116	com/xiaomi/hm/view/GifDecoder:O	Ljava/util/Queue;
    //   638: invokeinterface 370 1 0
    //   643: bipush 15
    //   645: if_icmpge +970 -> 1615
    //   648: aload_0
    //   649: getfield 116	com/xiaomi/hm/view/GifDecoder:O	Ljava/util/Queue;
    //   652: ifnull +106 -> 758
    //   655: new 372	com/xiaomi/hm/view/GifFrame
    //   658: dup
    //   659: aload_0
    //   660: getfield 250	com/xiaomi/hm/view/GifDecoder:y	Landroid/graphics/Bitmap;
    //   663: aload_0
    //   664: getfield 109	com/xiaomi/hm/view/GifDecoder:F	I
    //   667: invokespecial 375	com/xiaomi/hm/view/GifFrame:<init>	(Landroid/graphics/Bitmap;I)V
    //   670: astore 50
    //   672: aload_0
    //   673: getfield 116	com/xiaomi/hm/view/GifDecoder:O	Ljava/util/Queue;
    //   676: aload 50
    //   678: invokeinterface 379 2 0
    //   683: pop
    //   684: aload_0
    //   685: getfield 133	com/xiaomi/hm/view/GifDecoder:T	Z
    //   688: ifne +13 -> 701
    //   691: aload_0
    //   692: getfield 140	com/xiaomi/hm/view/GifDecoder:U	Ljava/util/ArrayList;
    //   695: aload 50
    //   697: invokevirtual 380	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   700: pop
    //   701: aload_0
    //   702: getfield 127	com/xiaomi/hm/view/GifDecoder:Q	Ljava/util/concurrent/locks/Condition;
    //   705: invokeinterface 305 1 0
    //   710: aload_0
    //   711: getfield 133	com/xiaomi/hm/view/GifDecoder:T	Z
    //   714: ifne +44 -> 758
    //   717: aload_0
    //   718: getfield 131	com/xiaomi/hm/view/GifDecoder:S	I
    //   721: iflt +37 -> 758
    //   724: aload_0
    //   725: iconst_1
    //   726: aload_0
    //   727: getfield 131	com/xiaomi/hm/view/GifDecoder:S	I
    //   730: iadd
    //   731: putfield 131	com/xiaomi/hm/view/GifDecoder:S	I
    //   734: aload_0
    //   735: getfield 131	com/xiaomi/hm/view/GifDecoder:S	I
    //   738: bipush 15
    //   740: if_icmplt +918 -> 1658
    //   743: aload_0
    //   744: getfield 146	com/xiaomi/hm/view/GifDecoder:X	Lcom/xiaomi/hm/view/GifAction;
    //   747: iconst_3
    //   748: invokeinterface 297 2 0
    //   753: aload_0
    //   754: iconst_m1
    //   755: putfield 131	com/xiaomi/hm/view/GifDecoder:S	I
    //   758: aload_0
    //   759: getfield 121	com/xiaomi/hm/view/GifDecoder:P	Ljava/util/concurrent/locks/ReentrantLock;
    //   762: invokevirtual 308	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   765: aload_0
    //   766: getfield 107	com/xiaomi/hm/view/GifDecoder:E	Z
    //   769: ifeq +14 -> 783
    //   772: aload_0
    //   773: getfield 268	com/xiaomi/hm/view/GifDecoder:i	[I
    //   776: aload_0
    //   777: getfield 363	com/xiaomi/hm/view/GifDecoder:G	I
    //   780: iload 6
    //   782: iastore
    //   783: aload_0
    //   784: aload_0
    //   785: getfield 103	com/xiaomi/hm/view/GifDecoder:C	I
    //   788: putfield 105	com/xiaomi/hm/view/GifDecoder:D	I
    //   791: aload_0
    //   792: aload_0
    //   793: getfield 262	com/xiaomi/hm/view/GifDecoder:q	I
    //   796: putfield 254	com/xiaomi/hm/view/GifDecoder:u	I
    //   799: aload_0
    //   800: aload_0
    //   801: getfield 260	com/xiaomi/hm/view/GifDecoder:r	I
    //   804: putfield 252	com/xiaomi/hm/view/GifDecoder:v	I
    //   807: aload_0
    //   808: aload_0
    //   809: getfield 264	com/xiaomi/hm/view/GifDecoder:s	I
    //   812: putfield 256	com/xiaomi/hm/view/GifDecoder:w	I
    //   815: aload_0
    //   816: aload_0
    //   817: getfield 238	com/xiaomi/hm/view/GifDecoder:t	I
    //   820: putfield 236	com/xiaomi/hm/view/GifDecoder:x	I
    //   823: aload_0
    //   824: aload_0
    //   825: getfield 250	com/xiaomi/hm/view/GifDecoder:y	Landroid/graphics/Bitmap;
    //   828: putfield 226	com/xiaomi/hm/view/GifDecoder:z	Landroid/graphics/Bitmap;
    //   831: aload_0
    //   832: aload_0
    //   833: getfield 336	com/xiaomi/hm/view/GifDecoder:k	I
    //   836: putfield 234	com/xiaomi/hm/view/GifDecoder:l	I
    //   839: aload_0
    //   840: iconst_0
    //   841: putfield 103	com/xiaomi/hm/view/GifDecoder:C	I
    //   844: aload_0
    //   845: iconst_0
    //   846: putfield 107	com/xiaomi/hm/view/GifDecoder:E	Z
    //   849: aload_0
    //   850: iconst_0
    //   851: putfield 109	com/xiaomi/hm/view/GifDecoder:F	I
    //   854: aload_0
    //   855: aconst_null
    //   856: putfield 277	com/xiaomi/hm/view/GifDecoder:h	[I
    //   859: return
    //   860: aload_0
    //   861: getfield 344	com/xiaomi/hm/view/GifDecoder:I	[S
    //   864: iload 15
    //   866: iconst_0
    //   867: sastore
    //   868: aload_0
    //   869: getfield 346	com/xiaomi/hm/view/GifDecoder:J	[B
    //   872: iload 15
    //   874: iload 15
    //   876: i2b
    //   877: bastore
    //   878: iinc 15 1
    //   881: goto -502 -> 379
    //   884: iload 17
    //   886: ifne +842 -> 1728
    //   889: iload 21
    //   891: iload 13
    //   893: if_icmpge +53 -> 946
    //   896: iload 22
    //   898: ifne +17 -> 915
    //   901: aload_0
    //   902: invokespecial 350	com/xiaomi/hm/view/GifDecoder:l	()I
    //   905: istore 22
    //   907: iload 22
    //   909: ifle -492 -> 417
    //   912: iconst_0
    //   913: istore 23
    //   915: iload 19
    //   917: sipush 255
    //   920: aload_0
    //   921: getfield 99	com/xiaomi/hm/view/GifDecoder:A	[B
    //   924: iload 23
    //   926: baload
    //   927: iand
    //   928: iload 21
    //   930: ishl
    //   931: iadd
    //   932: istore 19
    //   934: iinc 21 8
    //   937: iinc 23 1
    //   940: iinc 22 255
    //   943: goto -533 -> 410
    //   946: iload 19
    //   948: iload 14
    //   950: iand
    //   951: istore 36
    //   953: iload 19
    //   955: iload 13
    //   957: ishr
    //   958: istore 19
    //   960: iload 21
    //   962: iload 13
    //   964: isub
    //   965: istore 21
    //   967: iload 36
    //   969: iload 11
    //   971: if_icmpgt -554 -> 417
    //   974: iload 36
    //   976: iload 10
    //   978: if_icmpeq -561 -> 417
    //   981: iload 36
    //   983: iload 9
    //   985: if_icmpne +29 -> 1014
    //   988: iload 8
    //   990: iconst_1
    //   991: iadd
    //   992: istore 13
    //   994: iconst_m1
    //   995: iconst_1
    //   996: iload 13
    //   998: ishl
    //   999: iadd
    //   1000: istore 14
    //   1002: iload 9
    //   1004: iconst_2
    //   1005: iadd
    //   1006: istore 11
    //   1008: iconst_m1
    //   1009: istore 12
    //   1011: goto -601 -> 410
    //   1014: iload 12
    //   1016: iconst_m1
    //   1017: if_icmpne +42 -> 1059
    //   1020: aload_0
    //   1021: getfield 348	com/xiaomi/hm/view/GifDecoder:K	[B
    //   1024: astore 79
    //   1026: iload 17
    //   1028: iconst_1
    //   1029: iadd
    //   1030: istore 80
    //   1032: aload 79
    //   1034: iload 17
    //   1036: aload_0
    //   1037: getfield 346	com/xiaomi/hm/view/GifDecoder:J	[B
    //   1040: iload 36
    //   1042: baload
    //   1043: bastore
    //   1044: iload 80
    //   1046: istore 17
    //   1048: iload 36
    //   1050: istore 12
    //   1052: iload 36
    //   1054: istore 18
    //   1056: goto -646 -> 410
    //   1059: iload 36
    //   1061: iload 11
    //   1063: if_icmpne +654 -> 1717
    //   1066: aload_0
    //   1067: getfield 348	com/xiaomi/hm/view/GifDecoder:K	[B
    //   1070: astore 78
    //   1072: iload 17
    //   1074: iconst_1
    //   1075: iadd
    //   1076: istore 37
    //   1078: aload 78
    //   1080: iload 17
    //   1082: iload 18
    //   1084: i2b
    //   1085: bastore
    //   1086: iload 12
    //   1088: istore 38
    //   1090: iload 38
    //   1092: iload 9
    //   1094: if_icmpgt +200 -> 1294
    //   1097: sipush 255
    //   1100: aload_0
    //   1101: getfield 346	com/xiaomi/hm/view/GifDecoder:J	[B
    //   1104: iload 38
    //   1106: baload
    //   1107: iand
    //   1108: istore 41
    //   1110: iload 11
    //   1112: sipush 4096
    //   1115: if_icmpge -698 -> 417
    //   1118: aload_0
    //   1119: getfield 348	com/xiaomi/hm/view/GifDecoder:K	[B
    //   1122: astore 42
    //   1124: iload 37
    //   1126: iconst_1
    //   1127: iadd
    //   1128: istore 43
    //   1130: aload 42
    //   1132: iload 37
    //   1134: iload 41
    //   1136: i2b
    //   1137: bastore
    //   1138: aload_0
    //   1139: getfield 344	com/xiaomi/hm/view/GifDecoder:I	[S
    //   1142: iload 11
    //   1144: iload 12
    //   1146: i2s
    //   1147: sastore
    //   1148: aload_0
    //   1149: getfield 346	com/xiaomi/hm/view/GifDecoder:J	[B
    //   1152: iload 11
    //   1154: iload 41
    //   1156: i2b
    //   1157: bastore
    //   1158: iload 11
    //   1160: iconst_1
    //   1161: iadd
    //   1162: istore 31
    //   1164: iload 31
    //   1166: iload 14
    //   1168: iand
    //   1169: ifne +21 -> 1190
    //   1172: iload 31
    //   1174: sipush 4096
    //   1177: if_icmpge +13 -> 1190
    //   1180: iinc 13 1
    //   1183: iload 14
    //   1185: iload 31
    //   1187: iadd
    //   1188: istore 14
    //   1190: iload 19
    //   1192: istore 29
    //   1194: iload 36
    //   1196: istore 30
    //   1198: iload 14
    //   1200: istore 24
    //   1202: iload 41
    //   1204: istore 25
    //   1206: iload 21
    //   1208: istore 26
    //   1210: iload 13
    //   1212: istore 27
    //   1214: iload 43
    //   1216: istore 28
    //   1218: iload 28
    //   1220: iconst_1
    //   1221: isub
    //   1222: istore 32
    //   1224: aload_0
    //   1225: getfield 266	com/xiaomi/hm/view/GifDecoder:L	[B
    //   1228: astore 33
    //   1230: iload 16
    //   1232: iconst_1
    //   1233: iadd
    //   1234: istore 34
    //   1236: aload 33
    //   1238: iload 16
    //   1240: aload_0
    //   1241: getfield 348	com/xiaomi/hm/view/GifDecoder:K	[B
    //   1244: iload 32
    //   1246: baload
    //   1247: bastore
    //   1248: iinc 20 1
    //   1251: iload 34
    //   1253: istore 16
    //   1255: iload 27
    //   1257: istore 13
    //   1259: iload 26
    //   1261: istore 21
    //   1263: iload 25
    //   1265: istore 18
    //   1267: iload 24
    //   1269: istore 14
    //   1271: iload 30
    //   1273: istore 35
    //   1275: iload 29
    //   1277: istore 19
    //   1279: iload 32
    //   1281: istore 17
    //   1283: iload 31
    //   1285: istore 11
    //   1287: iload 35
    //   1289: istore 12
    //   1291: goto -881 -> 410
    //   1294: aload_0
    //   1295: getfield 348	com/xiaomi/hm/view/GifDecoder:K	[B
    //   1298: astore 39
    //   1300: iload 37
    //   1302: iconst_1
    //   1303: iadd
    //   1304: istore 40
    //   1306: aload 39
    //   1308: iload 37
    //   1310: aload_0
    //   1311: getfield 346	com/xiaomi/hm/view/GifDecoder:J	[B
    //   1314: iload 38
    //   1316: baload
    //   1317: bastore
    //   1318: aload_0
    //   1319: getfield 344	com/xiaomi/hm/view/GifDecoder:I	[S
    //   1322: iload 38
    //   1324: saload
    //   1325: istore 38
    //   1327: iload 40
    //   1329: istore 37
    //   1331: goto -241 -> 1090
    //   1334: aload_0
    //   1335: getfield 266	com/xiaomi/hm/view/GifDecoder:L	[B
    //   1338: iload 44
    //   1340: iconst_0
    //   1341: bastore
    //   1342: iinc 44 1
    //   1345: goto -924 -> 421
    //   1348: iload 75
    //   1350: aload_0
    //   1351: getfield 252	com/xiaomi/hm/view/GifDecoder:v	I
    //   1354: iadd
    //   1355: aload_0
    //   1356: getfield 222	com/xiaomi/hm/view/GifDecoder:width	I
    //   1359: imul
    //   1360: aload_0
    //   1361: getfield 254	com/xiaomi/hm/view/GifDecoder:u	I
    //   1364: iadd
    //   1365: istore 76
    //   1367: iload 76
    //   1369: aload_0
    //   1370: getfield 256	com/xiaomi/hm/view/GifDecoder:w	I
    //   1373: iadd
    //   1374: istore 77
    //   1376: goto +409 -> 1785
    //   1379: aload_0
    //   1380: getfield 160	com/xiaomi/hm/view/GifDecoder:ae	[I
    //   1383: iload 76
    //   1385: iload 74
    //   1387: iastore
    //   1388: iinc 76 1
    //   1391: goto +394 -> 1785
    //   1394: aload_0
    //   1395: getfield 258	com/xiaomi/hm/view/GifDecoder:o	Z
    //   1398: ifeq +300 -> 1698
    //   1401: iload 57
    //   1403: aload_0
    //   1404: getfield 238	com/xiaomi/hm/view/GifDecoder:t	I
    //   1407: if_icmplt +391 -> 1798
    //   1410: iinc 55 1
    //   1413: iload 55
    //   1415: tableswitch	default:+383 -> 1798, 2:+426->1841, 3:+432->1847, 4:+441->1856
    //   1441: dstore 42
    //   1443: getfield 260	com/xiaomi/hm/view/GifDecoder:r	I
    //   1446: iadd
    //   1447: istore 62
    //   1449: iload 62
    //   1451: aload_0
    //   1452: getfield 224	com/xiaomi/hm/view/GifDecoder:height	I
    //   1455: if_icmpge +368 -> 1823
    //   1458: iload 62
    //   1460: aload_0
    //   1461: getfield 222	com/xiaomi/hm/view/GifDecoder:width	I
    //   1464: imul
    //   1465: istore 63
    //   1467: iload 63
    //   1469: aload_0
    //   1470: getfield 262	com/xiaomi/hm/view/GifDecoder:q	I
    //   1473: iadd
    //   1474: istore 64
    //   1476: iload 64
    //   1478: aload_0
    //   1479: getfield 264	com/xiaomi/hm/view/GifDecoder:s	I
    //   1482: iadd
    //   1483: istore 65
    //   1485: iload 63
    //   1487: aload_0
    //   1488: getfield 222	com/xiaomi/hm/view/GifDecoder:width	I
    //   1491: iadd
    //   1492: iload 65
    //   1494: if_icmpge +197 -> 1691
    //   1497: iload 63
    //   1499: aload_0
    //   1500: getfield 222	com/xiaomi/hm/view/GifDecoder:width	I
    //   1503: iadd
    //   1504: istore 66
    //   1506: iload 58
    //   1508: aload_0
    //   1509: getfield 264	com/xiaomi/hm/view/GifDecoder:s	I
    //   1512: imul
    //   1513: istore 67
    //   1515: iload 64
    //   1517: istore 68
    //   1519: goto +297 -> 1816
    //   1522: aload_0
    //   1523: getfield 266	com/xiaomi/hm/view/GifDecoder:L	[B
    //   1526: astore 69
    //   1528: iload 67
    //   1530: iconst_1
    //   1531: iadd
    //   1532: istore 70
    //   1534: sipush 255
    //   1537: aload 69
    //   1539: iload 67
    //   1541: baload
    //   1542: iand
    //   1543: istore 71
    //   1545: aload_0
    //   1546: getfield 268	com/xiaomi/hm/view/GifDecoder:i	[I
    //   1549: iload 71
    //   1551: iaload
    //   1552: istore 72
    //   1554: iload 72
    //   1556: ifeq +12 -> 1568
    //   1559: aload_0
    //   1560: getfield 160	com/xiaomi/hm/view/GifDecoder:ae	[I
    //   1563: iload 68
    //   1565: iload 72
    //   1567: iastore
    //   1568: iinc 68 1
    //   1571: iload 70
    //   1573: istore 67
    //   1575: goto +241 -> 1816
    //   1578: astore 54
    //   1580: aload 54
    //   1582: invokevirtual 269	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1585: goto -965 -> 620
    //   1588: astore 53
    //   1590: aload 53
    //   1592: invokevirtual 270	java/lang/StackOverflowError:printStackTrace	()V
    //   1595: goto -975 -> 620
    //   1598: astore 45
    //   1600: ldc_w 272
    //   1603: aload 45
    //   1605: invokevirtual 202	java/lang/Exception:toString	()Ljava/lang/String;
    //   1608: invokestatic 207	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1611: pop
    //   1612: goto -992 -> 620
    //   1615: aload_0
    //   1616: getfield 129	com/xiaomi/hm/view/GifDecoder:R	Ljava/util/concurrent/locks/Condition;
    //   1619: invokeinterface 383 1 0
    //   1624: goto -997 -> 627
    //   1627: astore 49
    //   1629: aload_0
    //   1630: getfield 129	com/xiaomi/hm/view/GifDecoder:R	Ljava/util/concurrent/locks/Condition;
    //   1633: invokeinterface 305 1 0
    //   1638: aload_0
    //   1639: getfield 121	com/xiaomi/hm/view/GifDecoder:P	Ljava/util/concurrent/locks/ReentrantLock;
    //   1642: invokevirtual 308	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1645: goto -880 -> 765
    //   1648: astore 47
    //   1650: aload 47
    //   1652: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   1655: goto -890 -> 765
    //   1658: aload_0
    //   1659: getfield 131	com/xiaomi/hm/view/GifDecoder:S	I
    //   1662: iconst_1
    //   1663: if_icmpne -905 -> 758
    //   1666: aload_0
    //   1667: getfield 146	com/xiaomi/hm/view/GifDecoder:X	Lcom/xiaomi/hm/view/GifAction;
    //   1670: iconst_1
    //   1671: invokeinterface 297 2 0
    //   1676: goto -918 -> 758
    //   1679: astore 48
    //   1681: aload_0
    //   1682: getfield 121	com/xiaomi/hm/view/GifDecoder:P	Ljava/util/concurrent/locks/ReentrantLock;
    //   1685: invokevirtual 308	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1688: aload 48
    //   1690: athrow
    //   1691: iload 65
    //   1693: istore 66
    //   1695: goto -189 -> 1506
    //   1698: iload 57
    //   1700: istore 59
    //   1702: iload 56
    //   1704: istore 60
    //   1706: iload 55
    //   1708: istore 61
    //   1710: iload 58
    //   1712: istore 57
    //   1714: goto -274 -> 1440
    //   1717: iload 17
    //   1719: istore 37
    //   1721: iload 36
    //   1723: istore 38
    //   1725: goto -635 -> 1090
    //   1728: iload 14
    //   1730: istore 24
    //   1732: iload 18
    //   1734: istore 25
    //   1736: iload 21
    //   1738: istore 26
    //   1740: iload 13
    //   1742: istore 27
    //   1744: iload 17
    //   1746: istore 28
    //   1748: iload 19
    //   1750: istore 29
    //   1752: iload 12
    //   1754: istore 30
    //   1756: iload 11
    //   1758: istore 31
    //   1760: goto -542 -> 1218
    //   1763: iconst_0
    //   1764: istore 75
    //   1766: goto -1189 -> 577
    //   1769: iconst_1
    //   1770: istore 55
    //   1772: bipush 8
    //   1774: istore 56
    //   1776: iconst_0
    //   1777: istore 57
    //   1779: iconst_0
    //   1780: istore 58
    //   1782: goto -1193 -> 589
    //   1785: iload 76
    //   1787: iload 77
    //   1789: if_icmplt -410 -> 1379
    //   1792: iinc 75 1
    //   1795: goto -1218 -> 577
    //   1798: iload 57
    //   1800: iload 56
    //   1802: iadd
    //   1803: istore 59
    //   1805: iload 56
    //   1807: istore 60
    //   1809: iload 55
    //   1811: istore 61
    //   1813: goto -373 -> 1440
    //   1816: iload 68
    //   1818: iload 66
    //   1820: if_icmplt -298 -> 1522
    //   1823: iinc 58 1
    //   1826: iload 59
    //   1828: istore 57
    //   1830: iload 60
    //   1832: istore 56
    //   1834: iload 61
    //   1836: istore 55
    //   1838: goto -1249 -> 589
    //   1841: iconst_4
    //   1842: istore 57
    //   1844: goto -46 -> 1798
    //   1847: iconst_2
    //   1848: istore 57
    //   1850: iconst_4
    //   1851: istore 56
    //   1853: goto -55 -> 1798
    //   1856: iconst_1
    //   1857: istore 57
    //   1859: iconst_2
    //   1860: istore 56
    //   1862: goto -64 -> 1798
    //
    // Exception table:
    //   from	to	target	type
    //   456	478	1578	java/lang/OutOfMemoryError
    //   478	508	1578	java/lang/OutOfMemoryError
    //   508	513	1578	java/lang/OutOfMemoryError
    //   513	560	1578	java/lang/OutOfMemoryError
    //   568	574	1578	java/lang/OutOfMemoryError
    //   577	586	1578	java/lang/OutOfMemoryError
    //   589	620	1578	java/lang/OutOfMemoryError
    //   1348	1376	1578	java/lang/OutOfMemoryError
    //   1379	1388	1578	java/lang/OutOfMemoryError
    //   1394	1410	1578	java/lang/OutOfMemoryError
    //   1440	1506	1578	java/lang/OutOfMemoryError
    //   1506	1515	1578	java/lang/OutOfMemoryError
    //   1522	1528	1578	java/lang/OutOfMemoryError
    //   1534	1554	1578	java/lang/OutOfMemoryError
    //   1559	1568	1578	java/lang/OutOfMemoryError
    //   456	478	1588	java/lang/StackOverflowError
    //   478	508	1588	java/lang/StackOverflowError
    //   508	513	1588	java/lang/StackOverflowError
    //   513	560	1588	java/lang/StackOverflowError
    //   568	574	1588	java/lang/StackOverflowError
    //   577	586	1588	java/lang/StackOverflowError
    //   589	620	1588	java/lang/StackOverflowError
    //   1348	1376	1588	java/lang/StackOverflowError
    //   1379	1388	1588	java/lang/StackOverflowError
    //   1394	1410	1588	java/lang/StackOverflowError
    //   1440	1506	1588	java/lang/StackOverflowError
    //   1506	1515	1588	java/lang/StackOverflowError
    //   1522	1528	1588	java/lang/StackOverflowError
    //   1534	1554	1588	java/lang/StackOverflowError
    //   1559	1568	1588	java/lang/StackOverflowError
    //   456	478	1598	java/lang/Exception
    //   478	508	1598	java/lang/Exception
    //   508	513	1598	java/lang/Exception
    //   513	560	1598	java/lang/Exception
    //   568	574	1598	java/lang/Exception
    //   577	586	1598	java/lang/Exception
    //   589	620	1598	java/lang/Exception
    //   1348	1376	1598	java/lang/Exception
    //   1379	1388	1598	java/lang/Exception
    //   1394	1410	1598	java/lang/Exception
    //   1440	1506	1598	java/lang/Exception
    //   1506	1515	1598	java/lang/Exception
    //   1522	1528	1598	java/lang/Exception
    //   1534	1554	1598	java/lang/Exception
    //   1559	1568	1598	java/lang/Exception
    //   627	648	1627	java/lang/InterruptedException
    //   648	701	1627	java/lang/InterruptedException
    //   701	758	1627	java/lang/InterruptedException
    //   1615	1624	1627	java/lang/InterruptedException
    //   1658	1676	1627	java/lang/InterruptedException
    //   620	627	1648	java/lang/Exception
    //   758	765	1648	java/lang/Exception
    //   1638	1645	1648	java/lang/Exception
    //   1681	1691	1648	java/lang/Exception
    //   627	648	1679	finally
    //   648	701	1679	finally
    //   701	758	1679	finally
    //   1615	1624	1679	finally
    //   1629	1638	1679	finally
    //   1658	1676	1679	finally
  }

  private void q()
  {
    this.width = s();
    this.height = s();
    int i1 = k();
    if ((i1 & 0x80) != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      this.e = (2 << (i1 & 0x7));
      this.j = k();
      k();
      return;
    }
  }

  private void r()
  {
    do
    {
      l();
      if (this.A[0] == 1)
        this.f = (0xFF & this.A[1] | (0xFF & this.A[2]) << 8);
    }
    while ((this.B > 0) && (!i()));
  }

  private int s()
  {
    return k() | k() << 8;
  }

  private void t()
  {
    this.D = this.C;
    this.u = this.q;
    this.v = this.r;
    this.w = this.s;
    this.x = this.t;
    this.z = this.y;
    this.l = this.k;
    this.C = 0;
    this.E = false;
    this.F = 0;
    this.h = null;
  }

  private void u()
  {
    do
      l();
    while ((this.B > 0) && (!i()));
  }

  public void destroy()
  {
    this.isDestroy = true;
    if (this.a != null);
    try
    {
      this.a.close();
      label19: this.a = null;
      this.Y = null;
      this.c = 0;
      if (this.U != null)
      {
        this.U.clear();
        this.U = null;
      }
      if (this.O != null)
      {
        this.O.clear();
        this.O = null;
      }
      this.X = null;
      return;
    }
    catch (Exception localException)
    {
      break label19;
    }
  }

  public GifFrame getCurrentFrame()
  {
    if ((this.W) && (this.O.size() == 0))
    {
      if (this.V >= this.M)
      {
        this.V = 0;
        this.X.loopEnd();
      }
      GifFrame localGifFrame2 = (GifFrame)this.U.get(this.V);
      this.V = (1 + this.V);
      return localGifFrame2;
    }
    try
    {
      this.P.lockInterruptibly();
      try
      {
        while (true)
        {
          if ((this.W) || (this.O.size() != 0))
          {
            GifFrame localGifFrame1 = (GifFrame)this.O.poll();
            this.R.signal();
            this.V = (1 + this.V);
            if ((this.T) && (this.V >= this.M))
            {
              this.X.loopEnd();
              this.V = 0;
            }
            return localGifFrame1;
          }
          this.Q.await();
        }
      }
      catch (Exception localException2)
      {
        this.Q.signal();
        return null;
      }
    }
    catch (Exception localException1)
    {
      return null;
    }
    finally
    {
      this.P.unlock();
    }
  }

  public int getFrameCount()
  {
    if ((!this.T) && (this.c != -1))
      return -1;
    return this.M;
  }

  public Bitmap getFrameImage()
  {
    GifFrame localGifFrame = getCurrentFrame();
    if (localGifFrame == null)
      return null;
    return localGifFrame.image;
  }

  public Bitmap getImage()
  {
    return getFrameImage();
  }

  public InputStream getInputStream()
  {
    return null;
  }

  public int getLoopCount()
  {
    return this.f;
  }

  public int getStatus()
  {
    return this.c;
  }

  public GifFrame next()
  {
    return getCurrentFrame();
  }

  public void run()
  {
    try
    {
      f();
      return;
    }
    catch (Exception localException)
    {
      Log.e("GifView decode run", localException.toString());
      localException.printStackTrace();
    }
  }

  public void setGifImage(Resources paramResources, int paramInt)
  {
    this.ab = paramResources;
    this.ac = paramInt;
    b();
    this.aa = 1;
  }

  public void setGifImage(String paramString)
  {
    this.ad = paramString;
    this.aa = 2;
    c();
  }

  public void setGifImage(byte[] paramArrayOfByte)
  {
    this.Y = paramArrayOfByte;
    a();
    this.aa = 3;
  }

  public void setLoopAnimation()
  {
    this.Z = true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.view.GifDecoder
 * JD-Core Version:    0.6.2
 */