package com.nineoldandroids.view;

import java.util.ArrayList;

final class m
{
  int a;
  ArrayList<l> b;

  m(int paramInt, ArrayList<l> paramArrayList)
  {
    this.a = paramInt;
    this.b = paramArrayList;
  }

  final boolean a(int paramInt)
  {
    int i;
    if (((paramInt & this.a) != 0) && (this.b != null))
      i = this.b.size();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return false;
      if (((l)this.b.get(j)).a == paramInt)
      {
        this.b.remove(j);
        this.a &= (paramInt ^ 0xFFFFFFFF);
        return true;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.m
 * JD-Core Version:    0.6.2
 */