package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentState> CREATOR = new C();
  Bundle a;
  Fragment b;
  private String c;
  private int d;
  private boolean e;
  private int f;
  private int g;
  private String h;
  private boolean i;
  private boolean j;
  private Bundle k;

  public FragmentState(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
    boolean bool2;
    boolean bool3;
    if (paramParcel.readInt() != 0)
    {
      bool2 = bool1;
      this.e = bool2;
      this.f = paramParcel.readInt();
      this.g = paramParcel.readInt();
      this.h = paramParcel.readString();
      if (paramParcel.readInt() == 0)
        break label110;
      bool3 = bool1;
      label70: this.i = bool3;
      if (paramParcel.readInt() == 0)
        break label116;
    }
    while (true)
    {
      this.j = bool1;
      this.k = paramParcel.readBundle();
      this.a = paramParcel.readBundle();
      return;
      bool2 = false;
      break;
      label110: bool3 = false;
      break label70;
      label116: bool1 = false;
    }
  }

  public FragmentState(Fragment paramFragment)
  {
    this.c = paramFragment.getClass().getName();
    this.d = paramFragment.f;
    this.e = paramFragment.o;
    this.f = paramFragment.w;
    this.g = paramFragment.x;
    this.h = paramFragment.y;
    this.i = paramFragment.B;
    this.j = paramFragment.A;
    this.k = paramFragment.h;
  }

  public final Fragment a(FragmentActivity paramFragmentActivity, Fragment paramFragment)
  {
    if (this.b != null)
      return this.b;
    if (this.k != null)
      this.k.setClassLoader(paramFragmentActivity.getClassLoader());
    this.b = Fragment.instantiate(paramFragmentActivity, this.c, this.k);
    if (this.a != null)
    {
      this.a.setClassLoader(paramFragmentActivity.getClassLoader());
      this.b.d = this.a;
    }
    this.b.a(this.d, paramFragment);
    this.b.o = this.e;
    this.b.q = true;
    this.b.w = this.f;
    this.b.x = this.g;
    this.b.y = this.h;
    this.b.B = this.i;
    this.b.A = this.j;
    this.b.s = paramFragmentActivity.b;
    if (v.a)
      Log.v("FragmentManager", "Instantiated fragment " + this.b);
    return this.b;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
    int n;
    int i1;
    if (this.e)
    {
      n = m;
      paramParcel.writeInt(n);
      paramParcel.writeInt(this.f);
      paramParcel.writeInt(this.g);
      paramParcel.writeString(this.h);
      if (!this.i)
        break label109;
      i1 = m;
      label68: paramParcel.writeInt(i1);
      if (!this.j)
        break label115;
    }
    while (true)
    {
      paramParcel.writeInt(m);
      paramParcel.writeBundle(this.k);
      paramParcel.writeBundle(this.a);
      return;
      n = 0;
      break;
      label109: i1 = 0;
      break label68;
      label115: m = 0;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentState
 * JD-Core Version:    0.6.2
 */