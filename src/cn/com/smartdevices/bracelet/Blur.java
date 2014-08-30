package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Allocation.MipmapControl;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import java.lang.reflect.Array;

public class Blur
{
  private static final String a = "Blur";

  public static Bitmap fastblur(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    if (Build.VERSION.SDK_INT > 16)
    {
      Bitmap localBitmap2 = paramBitmap.copy(paramBitmap.getConfig(), true);
      RenderScript localRenderScript = RenderScript.create(paramContext);
      Allocation localAllocation1 = Allocation.createFromBitmap(localRenderScript, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
      Allocation localAllocation2 = Allocation.createTyped(localRenderScript, localAllocation1.getType());
      ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(localRenderScript, Element.U8_4(localRenderScript));
      localScriptIntrinsicBlur.setRadius(paramInt);
      localScriptIntrinsicBlur.setInput(localAllocation1);
      localScriptIntrinsicBlur.forEach(localAllocation2);
      localAllocation2.copyTo(localBitmap2);
      return localBitmap2;
    }
    Bitmap localBitmap1 = paramBitmap.copy(paramBitmap.getConfig(), true);
    if (paramInt <= 0)
      return null;
    int i = localBitmap1.getWidth();
    int j = localBitmap1.getHeight();
    int[] arrayOfInt1 = new int[i * j];
    Debug.e("pix", i + " " + j + " " + arrayOfInt1.length);
    localBitmap1.getPixels(arrayOfInt1, 0, i, 0, 0, i, j);
    int k = i - 1;
    int m = j - 1;
    int n = i * j;
    int i1 = 1 + (paramInt + paramInt);
    int[] arrayOfInt2 = new int[n];
    int[] arrayOfInt3 = new int[n];
    int[] arrayOfInt4 = new int[n];
    int[] arrayOfInt5 = new int[Math.max(i, j)];
    int i2 = i1 + 1 >> 1;
    int i3 = i2 * i2;
    int[] arrayOfInt6 = new int[i3 * 256];
    int[][] arrayOfInt;
    int i5;
    int i6;
    int i7;
    int i8;
    int i39;
    for (int i4 = 0; ; i4++)
    {
      if (i4 >= i3 * 256)
      {
        int[] arrayOfInt7 = { i1, 3 };
        arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt7);
        i5 = paramInt + 1;
        i6 = 0;
        i7 = 0;
        i8 = 0;
        if (i8 < j)
          break;
        i39 = 0;
        if (i39 < i)
          break label972;
        Debug.e("pix", i + " " + j + " " + arrayOfInt1.length);
        localBitmap1.setPixels(arrayOfInt1, 0, i, 0, 0, i, j);
        return localBitmap1;
      }
      arrayOfInt6[i4] = (i4 / i3);
    }
    int i9 = 0;
    int i10 = -paramInt;
    int i11 = 0;
    int i12 = 0;
    int i13 = 0;
    int i14 = 0;
    int i15 = i10;
    int i16 = 0;
    int i17 = 0;
    int i18 = 0;
    int i19 = 0;
    int i22;
    int i23;
    int i24;
    int i25;
    int i26;
    if (i15 > paramInt)
    {
      i22 = i18;
      i23 = i17;
      i24 = i16;
      i25 = 0;
      i26 = paramInt;
    }
    while (true)
    {
      if (i25 >= i)
      {
        int i37 = i6 + i;
        int i38 = i8 + 1;
        i6 = i37;
        i8 = i38;
        break;
        int i20 = arrayOfInt1[(i7 + Math.min(k, Math.max(i15, 0)))];
        int[] arrayOfInt8 = arrayOfInt[(i15 + paramInt)];
        arrayOfInt8[0] = (0xFF & i20 >> 16);
        arrayOfInt8[1] = (0xFF & i20 >> 8);
        arrayOfInt8[2] = (i20 & 0xFF);
        int i21 = i5 - Math.abs(i15);
        i18 += i21 * arrayOfInt8[0];
        i17 += i21 * arrayOfInt8[1];
        i16 += i21 * arrayOfInt8[2];
        if (i15 > 0)
        {
          i11 += arrayOfInt8[0];
          i19 += arrayOfInt8[1];
          i9 += arrayOfInt8[2];
        }
        while (true)
        {
          i15++;
          break;
          i14 += arrayOfInt8[0];
          i13 += arrayOfInt8[1];
          i12 += arrayOfInt8[2];
        }
      }
      arrayOfInt2[i7] = arrayOfInt6[i22];
      arrayOfInt3[i7] = arrayOfInt6[i23];
      arrayOfInt4[i7] = arrayOfInt6[i24];
      int i27 = i22 - i14;
      int i28 = i23 - i13;
      int i29 = i24 - i12;
      int[] arrayOfInt9 = arrayOfInt[((i1 + (i26 - paramInt)) % i1)];
      int i30 = i14 - arrayOfInt9[0];
      int i31 = i13 - arrayOfInt9[1];
      int i32 = i12 - arrayOfInt9[2];
      if (i8 == 0)
        arrayOfInt5[i25] = Math.min(1 + (i25 + paramInt), k);
      int i33 = arrayOfInt1[(i6 + arrayOfInt5[i25])];
      arrayOfInt9[0] = (0xFF & i33 >> 16);
      arrayOfInt9[1] = (0xFF & i33 >> 8);
      arrayOfInt9[2] = (i33 & 0xFF);
      int i34 = i11 + arrayOfInt9[0];
      int i35 = i19 + arrayOfInt9[1];
      int i36 = i9 + arrayOfInt9[2];
      i22 = i27 + i34;
      i23 = i28 + i35;
      i24 = i29 + i36;
      i26 = (i26 + 1) % i1;
      int[] arrayOfInt10 = arrayOfInt[(i26 % i1)];
      i14 = i30 + arrayOfInt10[0];
      i13 = i31 + arrayOfInt10[1];
      i12 = i32 + arrayOfInt10[2];
      i11 = i34 - arrayOfInt10[0];
      i19 = i35 - arrayOfInt10[1];
      i9 = i36 - arrayOfInt10[2];
      i7++;
      i25++;
    }
    label972: int i40 = 0;
    int i41 = i * -paramInt;
    int i42 = -paramInt;
    int i43 = 0;
    int i44 = 0;
    int i45 = 0;
    int i46 = 0;
    int i47 = i42;
    int i48 = 0;
    int i49 = 0;
    int i50 = 0;
    int i51 = i41;
    int i52 = 0;
    int i58;
    int i59;
    int i60;
    int i61;
    int i62;
    int i63;
    int i64;
    int i65;
    int i66;
    int i67;
    int i68;
    int i69;
    if (i47 > paramInt)
    {
      i58 = i49;
      i59 = i50;
      i60 = 0;
      i61 = i48;
      i62 = paramInt;
      i63 = i40;
      i64 = i52;
      i65 = i43;
      i66 = i44;
      i67 = i45;
      i68 = i46;
      i69 = i39;
    }
    while (true)
    {
      if (i60 >= j)
      {
        i39++;
        break;
        int i53 = i39 + Math.max(0, i51);
        int[] arrayOfInt11 = arrayOfInt[(i47 + paramInt)];
        arrayOfInt11[0] = arrayOfInt2[i53];
        arrayOfInt11[1] = arrayOfInt3[i53];
        arrayOfInt11[2] = arrayOfInt4[i53];
        int i54 = i5 - Math.abs(i47);
        int i55 = i50 + i54 * arrayOfInt2[i53];
        int i56 = i49 + i54 * arrayOfInt3[i53];
        int i57 = i48 + i54 * arrayOfInt4[i53];
        if (i47 > 0)
        {
          i43 += arrayOfInt11[0];
          i52 += arrayOfInt11[1];
          i40 += arrayOfInt11[2];
        }
        while (true)
        {
          if (i47 < m)
            i51 += i;
          i47++;
          i48 = i57;
          i49 = i56;
          i50 = i55;
          break;
          i46 += arrayOfInt11[0];
          i45 += arrayOfInt11[1];
          i44 += arrayOfInt11[2];
        }
      }
      arrayOfInt1[i69] = (0xFF000000 & arrayOfInt1[i69] | arrayOfInt6[i59] << 16 | arrayOfInt6[i58] << 8 | arrayOfInt6[i61]);
      int i70 = i59 - i68;
      int i71 = i58 - i67;
      int i72 = i61 - i66;
      int[] arrayOfInt12 = arrayOfInt[((i1 + (i62 - paramInt)) % i1)];
      int i73 = i68 - arrayOfInt12[0];
      int i74 = i67 - arrayOfInt12[1];
      int i75 = i66 - arrayOfInt12[2];
      if (i39 == 0)
        arrayOfInt5[i60] = (i * Math.min(i60 + i5, m));
      int i76 = i39 + arrayOfInt5[i60];
      arrayOfInt12[0] = arrayOfInt2[i76];
      arrayOfInt12[1] = arrayOfInt3[i76];
      arrayOfInt12[2] = arrayOfInt4[i76];
      int i77 = i65 + arrayOfInt12[0];
      int i78 = i64 + arrayOfInt12[1];
      int i79 = i63 + arrayOfInt12[2];
      i59 = i70 + i77;
      i58 = i71 + i78;
      i61 = i72 + i79;
      i62 = (i62 + 1) % i1;
      int[] arrayOfInt13 = arrayOfInt[i62];
      i68 = i73 + arrayOfInt13[0];
      i67 = i74 + arrayOfInt13[1];
      i66 = i75 + arrayOfInt13[2];
      i65 = i77 - arrayOfInt13[0];
      i64 = i78 - arrayOfInt13[1];
      i63 = i79 - arrayOfInt13[2];
      i69 += i;
      i60++;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.Blur
 * JD-Core Version:    0.6.2
 */