.class final Lcom/tencent/open/D;
.super Landroid/widget/LinearLayout;


# instance fields
.field private a:Landroid/widget/TextView;

.field private b:Landroid/widget/Button;

.field private c:Lcom/tencent/open/A;

.field private synthetic d:Lcom/tencent/open/TaskGuide;


# direct methods
.method public constructor <init>(Lcom/tencent/open/TaskGuide;Landroid/content/Context;Lcom/tencent/open/A;)V
    .locals 8

    const/16 v7, 0xd3

    const/16 v6, 0xc7

    const/16 v5, 0xff

    const/high16 v4, 0x3f800000

    const/4 v3, 0x0

    iput-object p1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    invoke-direct {p0, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object p3, p0, Lcom/tencent/open/D;->c:Lcom/tencent/open/A;

    invoke-virtual {p0, v3}, Lcom/tencent/open/D;->setOrientation(I)V

    new-instance v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    invoke-static {v1}, Lcom/tencent/open/TaskGuide;->m(Lcom/tencent/open/TaskGuide;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    invoke-static {v5, v5, v5}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    const/high16 v1, 0x41700000

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextSize(F)V

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    const/16 v1, 0xf2

    invoke-static {v1, v7, v6}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v4, v4, v4, v1}, Landroid/widget/TextView;->setShadowLayer(FFFI)V

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    sget-object v1, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setIncludeFontPadding(Z)V

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setSingleLine(Z)V

    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v1, -0x2

    invoke-direct {v0, v3, v1}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    iput v4, v0, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    const/4 v2, 0x4

    invoke-static {v1, v2}, Lcom/tencent/open/TaskGuide;->d(Lcom/tencent/open/TaskGuide;I)I

    move-result v1

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->leftMargin:I

    iget-object v1, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    invoke-virtual {p0, v1, v0}, Lcom/tencent/open/D;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v0, Landroid/widget/Button;

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    invoke-static {v1}, Lcom/tencent/open/TaskGuide;->n(Lcom/tencent/open/TaskGuide;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-virtual {v0, v3, v3, v3, v3}, Landroid/widget/Button;->setPadding(IIII)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    const/high16 v1, 0x41800000

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextSize(F)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-static {v5, v5, v5}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextColor(I)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    const/16 v1, 0xf2

    invoke-static {v1, v7, v6}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v4, v4, v4, v1}, Landroid/widget/Button;->setShadowLayer(FFFI)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setIncludeFontPadding(Z)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    new-instance v1, Lcom/tencent/open/B;

    iget-object v2, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    iget-object v3, p0, Lcom/tencent/open/D;->c:Lcom/tencent/open/A;

    iget v3, v3, Lcom/tencent/open/A;->a:I

    invoke-direct {v1, v2, v3}, Lcom/tencent/open/B;-><init>(Lcom/tencent/open/TaskGuide;I)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    invoke-static {}, Lcom/tencent/open/TaskGuide;->a()I

    move-result v2

    invoke-static {v1, v2}, Lcom/tencent/open/TaskGuide;->d(Lcom/tencent/open/TaskGuide;I)I

    move-result v1

    iget-object v2, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    invoke-static {}, Lcom/tencent/open/TaskGuide;->c()I

    move-result v3

    invoke-static {v2, v3}, Lcom/tencent/open/TaskGuide;->d(Lcom/tencent/open/TaskGuide;I)I

    move-result v2

    invoke-direct {v0, v1, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    const/4 v2, 0x2

    invoke-static {v1, v2}, Lcom/tencent/open/TaskGuide;->d(Lcom/tencent/open/TaskGuide;I)I

    move-result v1

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->leftMargin:I

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    const/16 v2, 0x8

    invoke-static {v1, v2}, Lcom/tencent/open/TaskGuide;->d(Lcom/tencent/open/TaskGuide;I)I

    move-result v1

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->rightMargin:I

    iget-object v1, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-virtual {p0, v1, v0}, Lcom/tencent/open/D;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    return-void
.end method

.method private a()V
    .locals 8

    const/16 v7, 0xd3

    const/16 v6, 0xc7

    const/16 v5, 0xff

    const/4 v4, 0x0

    const/high16 v3, 0x3f800000

    new-instance v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    invoke-static {v1}, Lcom/tencent/open/TaskGuide;->m(Lcom/tencent/open/TaskGuide;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    invoke-static {v5, v5, v5}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    const/high16 v1, 0x41700000

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextSize(F)V

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    const/16 v1, 0xf2

    invoke-static {v1, v7, v6}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v3, v3, v3, v1}, Landroid/widget/TextView;->setShadowLayer(FFFI)V

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    sget-object v1, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setIncludeFontPadding(Z)V

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setSingleLine(Z)V

    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v1, -0x2

    invoke-direct {v0, v4, v1}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    iput v3, v0, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    const/4 v2, 0x4

    invoke-static {v1, v2}, Lcom/tencent/open/TaskGuide;->d(Lcom/tencent/open/TaskGuide;I)I

    move-result v1

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->leftMargin:I

    iget-object v1, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    invoke-virtual {p0, v1, v0}, Lcom/tencent/open/D;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v0, Landroid/widget/Button;

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    invoke-static {v1}, Lcom/tencent/open/TaskGuide;->n(Lcom/tencent/open/TaskGuide;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-virtual {v0, v4, v4, v4, v4}, Landroid/widget/Button;->setPadding(IIII)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    const/high16 v1, 0x41800000

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextSize(F)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-static {v5, v5, v5}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextColor(I)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    const/16 v1, 0xf2

    invoke-static {v1, v7, v6}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v3, v3, v3, v1}, Landroid/widget/Button;->setShadowLayer(FFFI)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-virtual {v0, v4}, Landroid/widget/Button;->setIncludeFontPadding(Z)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    new-instance v1, Lcom/tencent/open/B;

    iget-object v2, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    iget-object v3, p0, Lcom/tencent/open/D;->c:Lcom/tencent/open/A;

    iget v3, v3, Lcom/tencent/open/A;->a:I

    invoke-direct {v1, v2, v3}, Lcom/tencent/open/B;-><init>(Lcom/tencent/open/TaskGuide;I)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    invoke-static {}, Lcom/tencent/open/TaskGuide;->a()I

    move-result v2

    invoke-static {v1, v2}, Lcom/tencent/open/TaskGuide;->d(Lcom/tencent/open/TaskGuide;I)I

    move-result v1

    iget-object v2, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    invoke-static {}, Lcom/tencent/open/TaskGuide;->c()I

    move-result v3

    invoke-static {v2, v3}, Lcom/tencent/open/TaskGuide;->d(Lcom/tencent/open/TaskGuide;I)I

    move-result v2

    invoke-direct {v0, v1, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    const/4 v2, 0x2

    invoke-static {v1, v2}, Lcom/tencent/open/TaskGuide;->d(Lcom/tencent/open/TaskGuide;I)I

    move-result v1

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->leftMargin:I

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    const/16 v2, 0x8

    invoke-static {v1, v2}, Lcom/tencent/open/TaskGuide;->d(Lcom/tencent/open/TaskGuide;I)I

    move-result v1

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->rightMargin:I

    iget-object v1, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-virtual {p0, v1, v0}, Lcom/tencent/open/D;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    return-void
.end method


# virtual methods
.method public final a(Lcom/tencent/open/z;)V
    .locals 5

    const/4 v4, 0x1

    const/16 v3, 0xff

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/tencent/open/D;->c:Lcom/tencent/open/A;

    iget-object v0, v0, Lcom/tencent/open/A;->b:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/tencent/open/D;->a:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/tencent/open/D;->c:Lcom/tencent/open/A;

    iget-object v1, v1, Lcom/tencent/open/A;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_0
    sget-object v0, Lcom/tencent/open/q;->a:[I

    invoke-virtual {p1}, Lcom/tencent/open/z;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    :cond_1
    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setEnabled(Z)V

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcom/tencent/open/D;->c:Lcom/tencent/open/A;

    iget v0, v0, Lcom/tencent/open/A;->d:I

    if-ne v0, v4, :cond_2

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    iget-object v1, p0, Lcom/tencent/open/D;->c:Lcom/tencent/open/A;

    iget-object v1, v1, Lcom/tencent/open/A;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    const/16 v1, 0xf6

    invoke-static {v3, v1, v2}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextColor(I)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setEnabled(Z)V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/tencent/open/D;->c:Lcom/tencent/open/A;

    iget v0, v0, Lcom/tencent/open/A;->d:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    const-string v1, "\u9886\u53d6\u5956\u52b1"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-static {v3, v3, v3}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextColor(I)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    invoke-static {v1}, Lcom/tencent/open/TaskGuide;->o(Lcom/tencent/open/TaskGuide;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-virtual {v0, v4}, Landroid/widget/Button;->setEnabled(Z)V

    goto :goto_0

    :pswitch_2
    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    const-string v1, "\u9886\u53d6\u4e2d..."

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setEnabled(Z)V

    goto :goto_0

    :pswitch_3
    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    const-string v1, "\u5df2\u9886\u53d6"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    iget-object v1, p0, Lcom/tencent/open/D;->d:Lcom/tencent/open/TaskGuide;

    invoke-static {v1}, Lcom/tencent/open/TaskGuide;->p(Lcom/tencent/open/TaskGuide;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    iget-object v0, p0, Lcom/tencent/open/D;->b:Landroid/widget/Button;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setEnabled(Z)V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
