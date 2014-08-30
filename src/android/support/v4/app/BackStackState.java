package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new n();
  private int[] a;
  private int b;
  private int c;
  private String d;
  private int e;
  private int f;
  private CharSequence g;
  private int h;
  private CharSequence i;

  public BackStackState(Parcel paramParcel)
  {
    this.a = paramParcel.createIntArray();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.h = paramParcel.readInt();
    this.i = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
  }

  public BackStackState(l paraml)
  {
    m localm1 = paraml.a;
    int j = 0;
    while (localm1 != null)
    {
      if (localm1.i != null)
        j += localm1.i.size();
      localm1 = localm1.a;
    }
    this.a = new int[j + 7 * paraml.b];
    if (!paraml.e)
      throw new IllegalStateException("Not on back stack");
    m localm2 = paraml.a;
    int k = 0;
    if (localm2 != null)
    {
      int[] arrayOfInt1 = this.a;
      int m = k + 1;
      arrayOfInt1[k] = localm2.c;
      int[] arrayOfInt2 = this.a;
      int n = m + 1;
      if (localm2.d != null);
      int i5;
      int i7;
      for (int i1 = localm2.d.f; ; i1 = -1)
      {
        arrayOfInt2[m] = i1;
        int[] arrayOfInt3 = this.a;
        int i2 = n + 1;
        arrayOfInt3[n] = localm2.e;
        int[] arrayOfInt4 = this.a;
        int i3 = i2 + 1;
        arrayOfInt4[i2] = localm2.f;
        int[] arrayOfInt5 = this.a;
        int i4 = i3 + 1;
        arrayOfInt5[i3] = localm2.g;
        int[] arrayOfInt6 = this.a;
        i5 = i4 + 1;
        arrayOfInt6[i4] = localm2.h;
        if (localm2.i == null)
          break label343;
        int i6 = localm2.i.size();
        int[] arrayOfInt8 = this.a;
        i7 = i5 + 1;
        arrayOfInt8[i5] = i6;
        int i8 = 0;
        while (i8 < i6)
        {
          int[] arrayOfInt9 = this.a;
          int i9 = i7 + 1;
          arrayOfInt9[i7] = ((Fragment)localm2.i.get(i8)).f;
          i8++;
          i7 = i9;
        }
      }
      k = i7;
      while (true)
      {
        localm2 = localm2.a;
        break;
        label343: int[] arrayOfInt7 = this.a;
        k = i5 + 1;
        arrayOfInt7[i5] = 0;
      }
    }
    this.b = paraml.c;
    this.c = paraml.d;
    this.d = paraml.f;
    this.e = paraml.g;
    this.f = paraml.h;
    this.g = paraml.i;
    this.h = paraml.j;
    this.i = paraml.k;
  }

  public final l a(v paramv)
  {
    l locall = new l(paramv);
    int j = 0;
    int i6;
    for (int k = 0; k < this.a.length; k = i6)
    {
      m localm = new m();
      int[] arrayOfInt1 = this.a;
      int m = k + 1;
      localm.c = arrayOfInt1[k];
      if (v.a)
        Log.v("FragmentManager", "Instantiate " + locall + " op #" + j + " base fragment #" + this.a[m]);
      int[] arrayOfInt2 = this.a;
      int n = m + 1;
      int i1 = arrayOfInt2[m];
      if (i1 >= 0);
      for (localm.d = ((Fragment)paramv.b.get(i1)); ; localm.d = null)
      {
        int[] arrayOfInt3 = this.a;
        int i2 = n + 1;
        localm.e = arrayOfInt3[n];
        int[] arrayOfInt4 = this.a;
        int i3 = i2 + 1;
        localm.f = arrayOfInt4[i2];
        int[] arrayOfInt5 = this.a;
        int i4 = i3 + 1;
        localm.g = arrayOfInt5[i3];
        int[] arrayOfInt6 = this.a;
        int i5 = i4 + 1;
        localm.h = arrayOfInt6[i4];
        int[] arrayOfInt7 = this.a;
        i6 = i5 + 1;
        int i7 = arrayOfInt7[i5];
        if (i7 <= 0)
          break;
        localm.i = new ArrayList(i7);
        int i8 = 0;
        while (i8 < i7)
        {
          if (v.a)
            Log.v("FragmentManager", "Instantiate " + locall + " set remove fragment #" + this.a[i6]);
          ArrayList localArrayList = paramv.b;
          int[] arrayOfInt8 = this.a;
          int i9 = i6 + 1;
          Fragment localFragment = (Fragment)localArrayList.get(arrayOfInt8[i6]);
          localm.i.add(localFragment);
          i8++;
          i6 = i9;
        }
      }
      locall.a(localm);
      j++;
    }
    locall.c = this.b;
    locall.d = this.c;
    locall.f = this.d;
    locall.g = this.e;
    locall.e = true;
    locall.h = this.f;
    locall.i = this.g;
    locall.j = this.h;
    locall.k = this.i;
    locall.a(1);
    return locall;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    TextUtils.writeToParcel(this.g, paramParcel, 0);
    paramParcel.writeInt(this.h);
    TextUtils.writeToParcel(this.i, paramParcel, 0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.6.2
 */