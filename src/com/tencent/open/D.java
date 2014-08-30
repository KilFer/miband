package com.tencent.open;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

final class D extends LinearLayout
{
  private TextView a;
  private Button b;
  private A c;

  public D(TaskGuide paramTaskGuide, Context paramContext, A paramA)
  {
    super(paramContext);
    this.c = paramA;
    setOrientation(0);
    this.a = new TextView(TaskGuide.m(this.d));
    this.a.setTextColor(Color.rgb(255, 255, 255));
    this.a.setTextSize(15.0F);
    this.a.setShadowLayer(1.0F, 1.0F, 1.0F, Color.rgb(242, 211, 199));
    this.a.setGravity(3);
    this.a.setEllipsize(TextUtils.TruncateAt.END);
    this.a.setIncludeFontPadding(false);
    this.a.setSingleLine(true);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams1.weight = 1.0F;
    localLayoutParams1.leftMargin = TaskGuide.d(this.d, 4);
    addView(this.a, localLayoutParams1);
    this.b = new Button(TaskGuide.n(this.d));
    this.b.setPadding(0, 0, 0, 0);
    this.b.setTextSize(16.0F);
    this.b.setTextColor(Color.rgb(255, 255, 255));
    this.b.setShadowLayer(1.0F, 1.0F, 1.0F, Color.rgb(242, 211, 199));
    this.b.setIncludeFontPadding(false);
    this.b.setOnClickListener(new B(this.d, this.c.a));
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(TaskGuide.d(this.d, TaskGuide.a()), TaskGuide.d(this.d, TaskGuide.c()));
    localLayoutParams2.leftMargin = TaskGuide.d(this.d, 2);
    localLayoutParams2.rightMargin = TaskGuide.d(this.d, 8);
    addView(this.b, localLayoutParams2);
  }

  private void a()
  {
    this.a = new TextView(TaskGuide.m(this.d));
    this.a.setTextColor(Color.rgb(255, 255, 255));
    this.a.setTextSize(15.0F);
    this.a.setShadowLayer(1.0F, 1.0F, 1.0F, Color.rgb(242, 211, 199));
    this.a.setGravity(3);
    this.a.setEllipsize(TextUtils.TruncateAt.END);
    this.a.setIncludeFontPadding(false);
    this.a.setSingleLine(true);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams1.weight = 1.0F;
    localLayoutParams1.leftMargin = TaskGuide.d(this.d, 4);
    addView(this.a, localLayoutParams1);
    this.b = new Button(TaskGuide.n(this.d));
    this.b.setPadding(0, 0, 0, 0);
    this.b.setTextSize(16.0F);
    this.b.setTextColor(Color.rgb(255, 255, 255));
    this.b.setShadowLayer(1.0F, 1.0F, 1.0F, Color.rgb(242, 211, 199));
    this.b.setIncludeFontPadding(false);
    this.b.setOnClickListener(new B(this.d, this.c.a));
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(TaskGuide.d(this.d, TaskGuide.a()), TaskGuide.d(this.d, TaskGuide.c()));
    localLayoutParams2.leftMargin = TaskGuide.d(this.d, 2);
    localLayoutParams2.rightMargin = TaskGuide.d(this.d, 8);
    addView(this.b, localLayoutParams2);
  }

  public final void a(z paramz)
  {
    if (!TextUtils.isEmpty(this.c.b))
      this.a.setText(this.c.b);
    switch (q.a[paramz.ordinal()])
    {
    default:
    case 1:
    case 2:
      do
      {
        return;
        this.b.setEnabled(false);
        return;
        if (this.c.d == 1)
        {
          this.b.setText(this.c.c);
          this.b.setBackgroundDrawable(null);
          this.b.setTextColor(Color.rgb(255, 246, 0));
          this.b.setEnabled(false);
          return;
        }
      }
      while (this.c.d != 2);
      this.b.setText("领取奖励");
      this.b.setTextColor(Color.rgb(255, 255, 255));
      this.b.setBackgroundDrawable(TaskGuide.o(this.d));
      this.b.setEnabled(true);
      return;
    case 3:
      this.b.setText("领取中...");
      this.b.setEnabled(false);
      return;
    case 4:
    }
    this.b.setText("已领取");
    this.b.setBackgroundDrawable(TaskGuide.p(this.d));
    this.b.setEnabled(false);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.D
 * JD-Core Version:    0.6.2
 */