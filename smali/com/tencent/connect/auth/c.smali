.class final Lcom/tencent/connect/auth/c;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/tencent/tauth/IUiListener;


# instance fields
.field private a:Lcom/tencent/tauth/IUiListener;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private synthetic e:Lcom/tencent/connect/auth/AuthAgent;


# direct methods
.method public constructor <init>(Lcom/tencent/connect/auth/AuthAgent;Lcom/tencent/tauth/IUiListener;)V
    .locals 1

    iput-object p1, p0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "sendinstall"

    iput-object v0, p0, Lcom/tencent/connect/auth/c;->b:Ljava/lang/String;

    const-string v0, "installwording"

    iput-object v0, p0, Lcom/tencent/connect/auth/c;->c:Ljava/lang/String;

    const-string v0, "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi"

    iput-object v0, p0, Lcom/tencent/connect/auth/c;->d:Ljava/lang/String;

    iput-object p2, p0, Lcom/tencent/connect/auth/c;->a:Lcom/tencent/tauth/IUiListener;

    return-void
.end method

.method private static a(Ljava/lang/String;Landroid/content/Context;)Landroid/graphics/drawable/Drawable;
    .locals 7

    const/4 v1, 0x0

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    :try_start_0
    invoke-virtual {v0, p0}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v2

    if-nez v2, :cond_0

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ".9.png"

    invoke-virtual {p0, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-static {v2}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getNinePatchChunk()[B

    move-result-object v3

    invoke-static {v3}, Landroid/graphics/NinePatch;->isNinePatchChunk([B)Z

    new-instance v0, Landroid/graphics/drawable/NinePatchDrawable;

    new-instance v4, Landroid/graphics/Rect;

    invoke-direct {v4}, Landroid/graphics/Rect;-><init>()V

    const/4 v5, 0x0

    invoke-direct {v0, v2, v3, v4, v5}, Landroid/graphics/drawable/NinePatchDrawable;-><init>(Landroid/graphics/Bitmap;[BLandroid/graphics/Rect;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    move-object v6, v0

    move-object v0, v1

    move-object v1, v6

    :goto_1
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    :cond_1
    move-object v0, v1

    goto :goto_0

    :cond_2
    :try_start_1
    invoke-static {v2, p0}, Landroid/graphics/drawable/Drawable;->createFromStream(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v0

    :try_start_2
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    :catch_1
    move-exception v1

    goto :goto_1
.end method

.method private a(Landroid/content/Context;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;)Landroid/view/View;
    .locals 9

    new-instance v1, Landroid/util/DisplayMetrics;

    invoke-direct {v1}, Landroid/util/DisplayMetrics;-><init>()V

    const-string v0, "window"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    iget v0, v1, Landroid/util/DisplayMetrics;->density:F

    new-instance v1, Landroid/widget/RelativeLayout;

    invoke-direct {v1, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    new-instance v2, Landroid/widget/ImageView;

    invoke-direct {v2, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2, p2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    sget-object v3, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setId(I)V

    const/high16 v3, 0x42700000

    mul-float/2addr v3, v0

    float-to-int v3, v3

    const/high16 v4, 0x41600000

    mul-float/2addr v4, v0

    float-to-int v4, v4

    const/high16 v5, 0x41900000

    mul-float/2addr v5, v0

    float-to-int v5, v5

    const/high16 v6, 0x40c00000

    mul-float/2addr v6, v0

    float-to-int v6, v6

    new-instance v7, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v7, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/16 v3, 0x9

    invoke-virtual {v7, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    const/4 v3, 0x0

    invoke-virtual {v7, v3, v5, v6, v5}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    invoke-virtual {v1, v2, v7}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v2, Landroid/widget/TextView;

    invoke-direct {v2, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2, p3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    const/high16 v3, 0x41600000

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextSize(F)V

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setGravity(I)V

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setIncludeFontPadding(Z)V

    const/4 v3, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual {v2, v3, v5, v6, v7}, Landroid/widget/TextView;->setPadding(IIII)V

    const/4 v3, 0x2

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setLines(I)V

    const/4 v3, 0x5

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setId(I)V

    const/high16 v3, 0x43390000

    mul-float/2addr v3, v0

    float-to-int v3, v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setMinWidth(I)V

    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v5, -0x2

    const/4 v6, -0x2

    invoke-direct {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/4 v5, 0x1

    const/4 v6, 0x1

    invoke-virtual {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v5, 0x6

    const/4 v6, 0x1

    invoke-virtual {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/high16 v7, 0x40a00000

    mul-float/2addr v7, v0

    float-to-int v7, v7

    const/4 v8, 0x0

    invoke-virtual {v3, v5, v6, v7, v8}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    invoke-virtual {v1, v2, v3}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v2, Landroid/view/View;

    invoke-direct {v2, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    const/16 v3, 0xd6

    const/16 v5, 0xd6

    const/16 v6, 0xd6

    invoke-static {v3, v5, v6}, Landroid/graphics/Color;->rgb(III)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/view/View;->setBackgroundColor(I)V

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Landroid/view/View;->setId(I)V

    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v5, -0x2

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/4 v5, 0x3

    const/4 v6, 0x1

    invoke-virtual {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v5, 0x5

    const/4 v6, 0x1

    invoke-virtual {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v5, 0x7

    const/4 v6, 0x5

    invoke-virtual {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/high16 v8, 0x41400000

    mul-float/2addr v8, v0

    float-to-int v8, v8

    invoke-virtual {v3, v5, v6, v7, v8}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    invoke-virtual {v1, v2, v3}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v2, Landroid/widget/LinearLayout;

    invoke-direct {v2, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v5, -0x2

    const/4 v6, -0x2

    invoke-direct {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/4 v5, 0x5

    const/4 v6, 0x1

    invoke-virtual {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v5, 0x7

    const/4 v6, 0x5

    invoke-virtual {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v5, 0x3

    const/4 v6, 0x3

    invoke-virtual {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    new-instance v5, Landroid/widget/Button;

    invoke-direct {v5, p1}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    const-string v6, "\u8df3\u8fc7"

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    const-string v6, "buttonNegt.png"

    invoke-static {v6, p1}, Lcom/tencent/connect/auth/c;->a(Ljava/lang/String;Landroid/content/Context;)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    const/16 v6, 0x24

    const/16 v7, 0x61

    const/16 v8, 0x83

    invoke-static {v6, v7, v8}, Landroid/graphics/Color;->rgb(III)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setTextColor(I)V

    const/high16 v6, 0x41a00000

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setTextSize(F)V

    invoke-virtual {v5, p5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const/4 v6, 0x4

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setId(I)V

    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v7, 0x0

    const/high16 v8, 0x42340000

    mul-float/2addr v8, v0

    float-to-int v8, v8

    invoke-direct {v6, v7, v8}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    iput v4, v6, Landroid/widget/LinearLayout$LayoutParams;->rightMargin:I

    const/high16 v7, 0x40800000

    mul-float/2addr v7, v0

    float-to-int v7, v7

    iput v7, v6, Landroid/widget/LinearLayout$LayoutParams;->leftMargin:I

    const/high16 v7, 0x3f800000

    iput v7, v6, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    invoke-virtual {v2, v5, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v5, Landroid/widget/Button;

    invoke-direct {v5, p1}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    const-string v6, "\u786e\u5b9a"

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    const/high16 v6, 0x41a00000

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setTextSize(F)V

    const/16 v6, 0xff

    const/16 v7, 0xff

    const/16 v8, 0xff

    invoke-static {v6, v7, v8}, Landroid/graphics/Color;->rgb(III)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setTextColor(I)V

    const-string v6, "buttonPost.png"

    invoke-static {v6, p1}, Lcom/tencent/connect/auth/c;->a(Ljava/lang/String;Landroid/content/Context;)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    invoke-virtual {v5, p4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v7, 0x0

    const/high16 v8, 0x42340000

    mul-float/2addr v8, v0

    float-to-int v8, v8

    invoke-direct {v6, v7, v8}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    const/high16 v7, 0x3f800000

    iput v7, v6, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    const/high16 v7, 0x40800000

    mul-float/2addr v7, v0

    float-to-int v7, v7

    iput v7, v6, Landroid/widget/LinearLayout$LayoutParams;->rightMargin:I

    invoke-virtual {v2, v5, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    invoke-virtual {v1, v2, v3}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    const v2, 0x438b8000

    mul-float/2addr v2, v0

    float-to-int v2, v2

    const/high16 v3, 0x43230000

    mul-float/2addr v3, v0

    float-to-int v3, v3

    new-instance v5, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v5, v2, v3}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    const/4 v2, 0x0

    const/high16 v3, 0x41400000

    mul-float/2addr v3, v0

    float-to-int v3, v3

    const/high16 v6, 0x41400000

    mul-float/2addr v6, v0

    float-to-int v6, v6

    invoke-virtual {v1, v4, v2, v3, v6}, Landroid/widget/RelativeLayout;->setPadding(IIII)V

    invoke-virtual {v1, v5}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    const/16 v2, 0xf7

    const/16 v3, 0xfb

    const/16 v4, 0xf7

    invoke-static {v2, v3, v4}, Landroid/graphics/Color;->rgb(III)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    new-instance v2, Landroid/graphics/drawable/PaintDrawable;

    const/16 v3, 0xf7

    const/16 v4, 0xfb

    const/16 v5, 0xf7

    invoke-static {v3, v4, v5}, Landroid/graphics/Color;->rgb(III)I

    move-result v3

    invoke-direct {v2, v3}, Landroid/graphics/drawable/PaintDrawable;-><init>(I)V

    const/high16 v3, 0x40a00000

    mul-float/2addr v0, v3

    invoke-virtual {v2, v0}, Landroid/graphics/drawable/PaintDrawable;->setCornerRadius(F)V

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    return-object v1
.end method

.method private a(Ljava/lang/String;Lcom/tencent/tauth/IUiListener;Ljava/lang/Object;)V
    .locals 15

    new-instance v5, Landroid/app/Dialog;

    iget-object v2, p0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v2}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v2

    invoke-direct {v5, v2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V

    const/4 v2, 0x1

    invoke-virtual {v5, v2}, Landroid/app/Dialog;->requestWindowFeature(I)Z

    iget-object v2, p0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v2}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    const/4 v4, 0x0

    const/4 v2, 0x0

    :try_start_0
    iget-object v3, p0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v3}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v7, 0x0

    invoke-virtual {v6, v3, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    :goto_0
    if-eqz v3, :cond_1

    iget-object v2, v3, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v2, v6}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    move-object v3, v2

    :goto_1
    new-instance v4, Lcom/tencent/connect/auth/d;

    move-object/from16 v0, p2

    move-object/from16 v1, p3

    invoke-direct {v4, p0, v5, v0, v1}, Lcom/tencent/connect/auth/d;-><init>(Lcom/tencent/connect/auth/c;Landroid/app/Dialog;Lcom/tencent/tauth/IUiListener;Ljava/lang/Object;)V

    new-instance v6, Lcom/tencent/connect/auth/e;

    move-object/from16 v0, p2

    move-object/from16 v1, p3

    invoke-direct {v6, p0, v5, v0, v1}, Lcom/tencent/connect/auth/e;-><init>(Lcom/tencent/connect/auth/c;Landroid/app/Dialog;Lcom/tencent/tauth/IUiListener;Ljava/lang/Object;)V

    new-instance v2, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v2}, Landroid/graphics/drawable/ColorDrawable;-><init>()V

    const/4 v7, 0x0

    invoke-virtual {v2, v7}, Landroid/graphics/drawable/ColorDrawable;->setAlpha(I)V

    invoke-virtual {v5}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v7

    invoke-virtual {v7, v2}, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    iget-object v2, p0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v2}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v7

    new-instance v8, Landroid/util/DisplayMetrics;

    invoke-direct {v8}, Landroid/util/DisplayMetrics;-><init>()V

    const-string v2, "window"

    invoke-virtual {v7, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/WindowManager;

    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2, v8}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    iget v2, v8, Landroid/util/DisplayMetrics;->density:F

    new-instance v8, Landroid/widget/RelativeLayout;

    invoke-direct {v8, v7}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    new-instance v9, Landroid/widget/ImageView;

    invoke-direct {v9, v7}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    invoke-virtual {v9, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    sget-object v3, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v9, v3}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    const/4 v3, 0x1

    invoke-virtual {v9, v3}, Landroid/widget/ImageView;->setId(I)V

    const/high16 v3, 0x42700000

    mul-float/2addr v3, v2

    float-to-int v3, v3

    const/high16 v10, 0x41600000

    mul-float/2addr v10, v2

    float-to-int v10, v10

    const/high16 v11, 0x41900000

    mul-float/2addr v11, v2

    float-to-int v11, v11

    const/high16 v12, 0x40c00000

    mul-float/2addr v12, v2

    float-to-int v12, v12

    new-instance v13, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v13, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/16 v3, 0x9

    invoke-virtual {v13, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    const/4 v3, 0x0

    invoke-virtual {v13, v3, v11, v12, v11}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    invoke-virtual {v8, v9, v13}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v3, Landroid/widget/TextView;

    invoke-direct {v3, v7}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    move-object/from16 v0, p1

    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    const/high16 v9, 0x41600000

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setTextSize(F)V

    const/4 v9, 0x3

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setGravity(I)V

    const/4 v9, 0x0

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setIncludeFontPadding(Z)V

    const/4 v9, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-virtual {v3, v9, v11, v12, v13}, Landroid/widget/TextView;->setPadding(IIII)V

    const/4 v9, 0x2

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setLines(I)V

    const/4 v9, 0x5

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setId(I)V

    const/high16 v9, 0x43390000

    mul-float/2addr v9, v2

    float-to-int v9, v9

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setMinWidth(I)V

    new-instance v9, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v11, -0x2

    const/4 v12, -0x2

    invoke-direct {v9, v11, v12}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/4 v11, 0x1

    const/4 v12, 0x1

    invoke-virtual {v9, v11, v12}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x6

    const/4 v12, 0x1

    invoke-virtual {v9, v11, v12}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/high16 v13, 0x40a00000

    mul-float/2addr v13, v2

    float-to-int v13, v13

    const/4 v14, 0x0

    invoke-virtual {v9, v11, v12, v13, v14}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    invoke-virtual {v8, v3, v9}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v3, Landroid/view/View;

    invoke-direct {v3, v7}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    const/16 v9, 0xd6

    const/16 v11, 0xd6

    const/16 v12, 0xd6

    invoke-static {v9, v11, v12}, Landroid/graphics/Color;->rgb(III)I

    move-result v9

    invoke-virtual {v3, v9}, Landroid/view/View;->setBackgroundColor(I)V

    const/4 v9, 0x3

    invoke-virtual {v3, v9}, Landroid/view/View;->setId(I)V

    new-instance v9, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v11, -0x2

    const/4 v12, 0x2

    invoke-direct {v9, v11, v12}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/4 v11, 0x3

    const/4 v12, 0x1

    invoke-virtual {v9, v11, v12}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x5

    const/4 v12, 0x1

    invoke-virtual {v9, v11, v12}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x7

    const/4 v12, 0x5

    invoke-virtual {v9, v11, v12}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/high16 v14, 0x41400000

    mul-float/2addr v14, v2

    float-to-int v14, v14

    invoke-virtual {v9, v11, v12, v13, v14}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    invoke-virtual {v8, v3, v9}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v3, Landroid/widget/LinearLayout;

    invoke-direct {v3, v7}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    new-instance v9, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v11, -0x2

    const/4 v12, -0x2

    invoke-direct {v9, v11, v12}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/4 v11, 0x5

    const/4 v12, 0x1

    invoke-virtual {v9, v11, v12}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x7

    const/4 v12, 0x5

    invoke-virtual {v9, v11, v12}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x3

    const/4 v12, 0x3

    invoke-virtual {v9, v11, v12}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    new-instance v11, Landroid/widget/Button;

    invoke-direct {v11, v7}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    const-string v12, "\u8df3\u8fc7"

    invoke-virtual {v11, v12}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    const-string v12, "buttonNegt.png"

    invoke-static {v12, v7}, Lcom/tencent/connect/auth/c;->a(Ljava/lang/String;Landroid/content/Context;)Landroid/graphics/drawable/Drawable;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    const/16 v12, 0x24

    const/16 v13, 0x61

    const/16 v14, 0x83

    invoke-static {v12, v13, v14}, Landroid/graphics/Color;->rgb(III)I

    move-result v12

    invoke-virtual {v11, v12}, Landroid/widget/Button;->setTextColor(I)V

    const/high16 v12, 0x41a00000

    invoke-virtual {v11, v12}, Landroid/widget/Button;->setTextSize(F)V

    invoke-virtual {v11, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const/4 v6, 0x4

    invoke-virtual {v11, v6}, Landroid/widget/Button;->setId(I)V

    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v12, 0x0

    const/high16 v13, 0x42340000

    mul-float/2addr v13, v2

    float-to-int v13, v13

    invoke-direct {v6, v12, v13}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    iput v10, v6, Landroid/widget/LinearLayout$LayoutParams;->rightMargin:I

    const/high16 v12, 0x40800000

    mul-float/2addr v12, v2

    float-to-int v12, v12

    iput v12, v6, Landroid/widget/LinearLayout$LayoutParams;->leftMargin:I

    const/high16 v12, 0x3f800000

    iput v12, v6, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    invoke-virtual {v3, v11, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v6, Landroid/widget/Button;

    invoke-direct {v6, v7}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    const-string v11, "\u786e\u5b9a"

    invoke-virtual {v6, v11}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    const/high16 v11, 0x41a00000

    invoke-virtual {v6, v11}, Landroid/widget/Button;->setTextSize(F)V

    const/16 v11, 0xff

    const/16 v12, 0xff

    const/16 v13, 0xff

    invoke-static {v11, v12, v13}, Landroid/graphics/Color;->rgb(III)I

    move-result v11

    invoke-virtual {v6, v11}, Landroid/widget/Button;->setTextColor(I)V

    const-string v11, "buttonPost.png"

    invoke-static {v11, v7}, Lcom/tencent/connect/auth/c;->a(Ljava/lang/String;Landroid/content/Context;)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    invoke-virtual {v6, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v7, 0x0

    const/high16 v11, 0x42340000

    mul-float/2addr v11, v2

    float-to-int v11, v11

    invoke-direct {v4, v7, v11}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    const/high16 v7, 0x3f800000

    iput v7, v4, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    const/high16 v7, 0x40800000

    mul-float/2addr v7, v2

    float-to-int v7, v7

    iput v7, v4, Landroid/widget/LinearLayout$LayoutParams;->rightMargin:I

    invoke-virtual {v3, v6, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    invoke-virtual {v8, v3, v9}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    const v3, 0x438b8000

    mul-float/2addr v3, v2

    float-to-int v3, v3

    const/high16 v4, 0x43230000

    mul-float/2addr v4, v2

    float-to-int v4, v4

    new-instance v6, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v6, v3, v4}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    const/4 v3, 0x0

    const/high16 v4, 0x41400000

    mul-float/2addr v4, v2

    float-to-int v4, v4

    const/high16 v7, 0x41400000

    mul-float/2addr v7, v2

    float-to-int v7, v7

    invoke-virtual {v8, v10, v3, v4, v7}, Landroid/widget/RelativeLayout;->setPadding(IIII)V

    invoke-virtual {v8, v6}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    const/16 v3, 0xf7

    const/16 v4, 0xfb

    const/16 v6, 0xf7

    invoke-static {v3, v4, v6}, Landroid/graphics/Color;->rgb(III)I

    move-result v3

    invoke-virtual {v8, v3}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    new-instance v3, Landroid/graphics/drawable/PaintDrawable;

    const/16 v4, 0xf7

    const/16 v6, 0xfb

    const/16 v7, 0xf7

    invoke-static {v4, v6, v7}, Landroid/graphics/Color;->rgb(III)I

    move-result v4

    invoke-direct {v3, v4}, Landroid/graphics/drawable/PaintDrawable;-><init>(I)V

    const/high16 v4, 0x40a00000

    mul-float/2addr v2, v4

    invoke-virtual {v3, v2}, Landroid/graphics/drawable/PaintDrawable;->setCornerRadius(F)V

    invoke-virtual {v8, v3}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    invoke-virtual {v5, v8}, Landroid/app/Dialog;->setContentView(Landroid/view/View;)V

    new-instance v2, Lcom/tencent/connect/auth/f;

    move-object/from16 v0, p2

    move-object/from16 v1, p3

    invoke-direct {v2, p0, v0, v1}, Lcom/tencent/connect/auth/f;-><init>(Lcom/tencent/connect/auth/c;Lcom/tencent/tauth/IUiListener;Ljava/lang/Object;)V

    invoke-virtual {v5, v2}, Landroid/app/Dialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    iget-object v2, p0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v2}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v2}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->isFinishing()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {v5}, Landroid/app/Dialog;->show()V

    :cond_0
    return-void

    :catch_0
    move-exception v3

    invoke-virtual {v3}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    move-object v3, v4

    goto/16 :goto_0

    :cond_1
    move-object v3, v2

    goto/16 :goto_1
.end method


# virtual methods
.method protected final a()V
    .locals 6

    iget-object v0, p0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v0}, Lcom/tencent/connect/auth/AuthAgent;->j(Lcom/tencent/connect/auth/AuthAgent;)Landroid/os/Bundle;

    move-result-object v3

    iget-object v0, p0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v0}, Lcom/tencent/connect/auth/AuthAgent;->k(Lcom/tencent/connect/auth/AuthAgent;)Lcom/tencent/connect/auth/QQToken;

    move-result-object v0

    iget-object v1, p0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v1}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/tencent/connect/auth/c;->d:Ljava/lang/String;

    const-string v4, "POST"

    const/4 v5, 0x0

    invoke-static/range {v0 .. v5}, Lcom/tencent/utils/HttpUtils;->requestAsync(Lcom/tencent/connect/auth/QQToken;Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Lcom/tencent/tauth/IRequestListener;)V

    return-void
.end method

.method public final onCancel()V
    .locals 1

    iget-object v0, p0, Lcom/tencent/connect/auth/c;->a:Lcom/tencent/tauth/IUiListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/connect/auth/c;->a:Lcom/tencent/tauth/IUiListener;

    invoke-interface {v0}, Lcom/tencent/tauth/IUiListener;->onCancel()V

    :cond_0
    return-void
.end method

.method public final onComplete(Ljava/lang/Object;)V
    .locals 17

    if-eqz p1, :cond_3

    move-object/from16 v2, p1

    check-cast v2, Lorg/json/JSONObject;

    if-eqz v2, :cond_0

    const/4 v4, 0x0

    const-string v3, ""

    :try_start_0
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/tencent/connect/auth/c;->b:Ljava/lang/String;

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_1

    const/4 v4, 0x1

    :goto_0
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/tencent/connect/auth/c;->c:Ljava/lang/String;

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    move v3, v4

    :goto_1
    invoke-static {v2}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v2, "TAG"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v6, " WORDING = "

    invoke-direct {v4, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "xx"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    if-eqz v3, :cond_2

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/tencent/connect/auth/c;->a:Lcom/tencent/tauth/IUiListener;

    new-instance v7, Landroid/app/Dialog;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v2}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v2

    invoke-direct {v7, v2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V

    const/4 v2, 0x1

    invoke-virtual {v7, v2}, Landroid/app/Dialog;->requestWindowFeature(I)Z

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v2}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    const/4 v4, 0x0

    const/4 v2, 0x0

    :try_start_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v3}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v9, 0x0

    invoke-virtual {v8, v3, v9}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v3

    :goto_2
    if-eqz v3, :cond_4

    iget-object v2, v3, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v2, v8}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    move-object v3, v2

    :goto_3
    new-instance v4, Lcom/tencent/connect/auth/d;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v4, v0, v7, v6, v1}, Lcom/tencent/connect/auth/d;-><init>(Lcom/tencent/connect/auth/c;Landroid/app/Dialog;Lcom/tencent/tauth/IUiListener;Ljava/lang/Object;)V

    new-instance v8, Lcom/tencent/connect/auth/e;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v8, v0, v7, v6, v1}, Lcom/tencent/connect/auth/e;-><init>(Lcom/tencent/connect/auth/c;Landroid/app/Dialog;Lcom/tencent/tauth/IUiListener;Ljava/lang/Object;)V

    new-instance v2, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v2}, Landroid/graphics/drawable/ColorDrawable;-><init>()V

    const/4 v9, 0x0

    invoke-virtual {v2, v9}, Landroid/graphics/drawable/ColorDrawable;->setAlpha(I)V

    invoke-virtual {v7}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v9

    invoke-virtual {v9, v2}, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v2}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v9

    new-instance v10, Landroid/util/DisplayMetrics;

    invoke-direct {v10}, Landroid/util/DisplayMetrics;-><init>()V

    const-string v2, "window"

    invoke-virtual {v9, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/WindowManager;

    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2, v10}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    iget v2, v10, Landroid/util/DisplayMetrics;->density:F

    new-instance v10, Landroid/widget/RelativeLayout;

    invoke-direct {v10, v9}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    new-instance v11, Landroid/widget/ImageView;

    invoke-direct {v11, v9}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    invoke-virtual {v11, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    sget-object v3, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v11, v3}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    const/4 v3, 0x1

    invoke-virtual {v11, v3}, Landroid/widget/ImageView;->setId(I)V

    const/high16 v3, 0x42700000

    mul-float/2addr v3, v2

    float-to-int v3, v3

    const/high16 v12, 0x41600000

    mul-float/2addr v12, v2

    float-to-int v12, v12

    const/high16 v13, 0x41900000

    mul-float/2addr v13, v2

    float-to-int v13, v13

    const/high16 v14, 0x40c00000

    mul-float/2addr v14, v2

    float-to-int v14, v14

    new-instance v15, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v15, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/16 v3, 0x9

    invoke-virtual {v15, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    const/4 v3, 0x0

    invoke-virtual {v15, v3, v13, v14, v13}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    invoke-virtual {v10, v11, v15}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v3, Landroid/widget/TextView;

    invoke-direct {v3, v9}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    const/high16 v5, 0x41600000

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setTextSize(F)V

    const/4 v5, 0x3

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setGravity(I)V

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setIncludeFontPadding(Z)V

    const/4 v5, 0x0

    const/4 v11, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    invoke-virtual {v3, v5, v11, v13, v14}, Landroid/widget/TextView;->setPadding(IIII)V

    const/4 v5, 0x2

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setLines(I)V

    const/4 v5, 0x5

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setId(I)V

    const/high16 v5, 0x43390000

    mul-float/2addr v5, v2

    float-to-int v5, v5

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setMinWidth(I)V

    new-instance v5, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v11, -0x2

    const/4 v13, -0x2

    invoke-direct {v5, v11, v13}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/4 v11, 0x1

    const/4 v13, 0x1

    invoke-virtual {v5, v11, v13}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x6

    const/4 v13, 0x1

    invoke-virtual {v5, v11, v13}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x0

    const/4 v13, 0x0

    const/high16 v14, 0x40a00000

    mul-float/2addr v14, v2

    float-to-int v14, v14

    const/4 v15, 0x0

    invoke-virtual {v5, v11, v13, v14, v15}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    invoke-virtual {v10, v3, v5}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v3, Landroid/view/View;

    invoke-direct {v3, v9}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    const/16 v5, 0xd6

    const/16 v11, 0xd6

    const/16 v13, 0xd6

    invoke-static {v5, v11, v13}, Landroid/graphics/Color;->rgb(III)I

    move-result v5

    invoke-virtual {v3, v5}, Landroid/view/View;->setBackgroundColor(I)V

    const/4 v5, 0x3

    invoke-virtual {v3, v5}, Landroid/view/View;->setId(I)V

    new-instance v5, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v11, -0x2

    const/4 v13, 0x2

    invoke-direct {v5, v11, v13}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/4 v11, 0x3

    const/4 v13, 0x1

    invoke-virtual {v5, v11, v13}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x5

    const/4 v13, 0x1

    invoke-virtual {v5, v11, v13}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x7

    const/4 v13, 0x5

    invoke-virtual {v5, v11, v13}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/high16 v15, 0x41400000

    mul-float/2addr v15, v2

    float-to-int v15, v15

    invoke-virtual {v5, v11, v13, v14, v15}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    invoke-virtual {v10, v3, v5}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v3, Landroid/widget/LinearLayout;

    invoke-direct {v3, v9}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    new-instance v5, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v11, -0x2

    const/4 v13, -0x2

    invoke-direct {v5, v11, v13}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/4 v11, 0x5

    const/4 v13, 0x1

    invoke-virtual {v5, v11, v13}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x7

    const/4 v13, 0x5

    invoke-virtual {v5, v11, v13}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/4 v11, 0x3

    const/4 v13, 0x3

    invoke-virtual {v5, v11, v13}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    new-instance v11, Landroid/widget/Button;

    invoke-direct {v11, v9}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    const-string v13, "\u8df3\u8fc7"

    invoke-virtual {v11, v13}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    const-string v13, "buttonNegt.png"

    invoke-static {v13, v9}, Lcom/tencent/connect/auth/c;->a(Ljava/lang/String;Landroid/content/Context;)Landroid/graphics/drawable/Drawable;

    move-result-object v13

    invoke-virtual {v11, v13}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    const/16 v13, 0x24

    const/16 v14, 0x61

    const/16 v15, 0x83

    invoke-static {v13, v14, v15}, Landroid/graphics/Color;->rgb(III)I

    move-result v13

    invoke-virtual {v11, v13}, Landroid/widget/Button;->setTextColor(I)V

    const/high16 v13, 0x41a00000

    invoke-virtual {v11, v13}, Landroid/widget/Button;->setTextSize(F)V

    invoke-virtual {v11, v8}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const/4 v8, 0x4

    invoke-virtual {v11, v8}, Landroid/widget/Button;->setId(I)V

    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v13, 0x0

    const/high16 v14, 0x42340000

    mul-float/2addr v14, v2

    float-to-int v14, v14

    invoke-direct {v8, v13, v14}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    iput v12, v8, Landroid/widget/LinearLayout$LayoutParams;->rightMargin:I

    const/high16 v13, 0x40800000

    mul-float/2addr v13, v2

    float-to-int v13, v13

    iput v13, v8, Landroid/widget/LinearLayout$LayoutParams;->leftMargin:I

    const/high16 v13, 0x3f800000

    iput v13, v8, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    invoke-virtual {v3, v11, v8}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v8, Landroid/widget/Button;

    invoke-direct {v8, v9}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    const-string v11, "\u786e\u5b9a"

    invoke-virtual {v8, v11}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    const/high16 v11, 0x41a00000

    invoke-virtual {v8, v11}, Landroid/widget/Button;->setTextSize(F)V

    const/16 v11, 0xff

    const/16 v13, 0xff

    const/16 v14, 0xff

    invoke-static {v11, v13, v14}, Landroid/graphics/Color;->rgb(III)I

    move-result v11

    invoke-virtual {v8, v11}, Landroid/widget/Button;->setTextColor(I)V

    const-string v11, "buttonPost.png"

    invoke-static {v11, v9}, Lcom/tencent/connect/auth/c;->a(Ljava/lang/String;Landroid/content/Context;)Landroid/graphics/drawable/Drawable;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    invoke-virtual {v8, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v9, 0x0

    const/high16 v11, 0x42340000

    mul-float/2addr v11, v2

    float-to-int v11, v11

    invoke-direct {v4, v9, v11}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    const/high16 v9, 0x3f800000

    iput v9, v4, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    const/high16 v9, 0x40800000

    mul-float/2addr v9, v2

    float-to-int v9, v9

    iput v9, v4, Landroid/widget/LinearLayout$LayoutParams;->rightMargin:I

    invoke-virtual {v3, v8, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    invoke-virtual {v10, v3, v5}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    const v3, 0x438b8000

    mul-float/2addr v3, v2

    float-to-int v3, v3

    const/high16 v4, 0x43230000

    mul-float/2addr v4, v2

    float-to-int v4, v4

    new-instance v5, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v5, v3, v4}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    const/4 v3, 0x0

    const/high16 v4, 0x41400000

    mul-float/2addr v4, v2

    float-to-int v4, v4

    const/high16 v8, 0x41400000

    mul-float/2addr v8, v2

    float-to-int v8, v8

    invoke-virtual {v10, v12, v3, v4, v8}, Landroid/widget/RelativeLayout;->setPadding(IIII)V

    invoke-virtual {v10, v5}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    const/16 v3, 0xf7

    const/16 v4, 0xfb

    const/16 v5, 0xf7

    invoke-static {v3, v4, v5}, Landroid/graphics/Color;->rgb(III)I

    move-result v3

    invoke-virtual {v10, v3}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    new-instance v3, Landroid/graphics/drawable/PaintDrawable;

    const/16 v4, 0xf7

    const/16 v5, 0xfb

    const/16 v8, 0xf7

    invoke-static {v4, v5, v8}, Landroid/graphics/Color;->rgb(III)I

    move-result v4

    invoke-direct {v3, v4}, Landroid/graphics/drawable/PaintDrawable;-><init>(I)V

    const/high16 v4, 0x40a00000

    mul-float/2addr v2, v4

    invoke-virtual {v3, v2}, Landroid/graphics/drawable/PaintDrawable;->setCornerRadius(F)V

    invoke-virtual {v10, v3}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    invoke-virtual {v7, v10}, Landroid/app/Dialog;->setContentView(Landroid/view/View;)V

    new-instance v2, Lcom/tencent/connect/auth/f;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v2, v0, v6, v1}, Lcom/tencent/connect/auth/f;-><init>(Lcom/tencent/connect/auth/c;Lcom/tencent/tauth/IUiListener;Ljava/lang/Object;)V

    invoke-virtual {v7, v2}, Landroid/app/Dialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v2}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v2

    if-eqz v2, :cond_0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v2}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->isFinishing()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {v7}, Landroid/app/Dialog;->show()V

    :cond_0
    :goto_4
    return-void

    :cond_1
    const/4 v4, 0x0

    goto/16 :goto_0

    :catch_0
    move-exception v2

    move-object/from16 v16, v2

    move v2, v4

    move-object/from16 v4, v16

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/tencent/connect/auth/c;->e:Lcom/tencent/connect/auth/AuthAgent;

    invoke-static {v5}, Lcom/tencent/connect/auth/AuthAgent;->i(Lcom/tencent/connect/auth/AuthAgent;)Landroid/app/Activity;

    move-result-object v5

    const-string v6, "json error"

    const/4 v7, 0x1

    invoke-static {v5, v6, v7}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    invoke-virtual {v4}, Lorg/json/JSONException;->printStackTrace()V

    move-object/from16 v16, v3

    move v3, v2

    move-object/from16 v2, v16

    goto/16 :goto_1

    :catch_1
    move-exception v3

    invoke-virtual {v3}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    move-object v3, v4

    goto/16 :goto_2

    :cond_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/tencent/connect/auth/c;->a:Lcom/tencent/tauth/IUiListener;

    if-eqz v2, :cond_0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/tencent/connect/auth/c;->a:Lcom/tencent/tauth/IUiListener;

    move-object/from16 v0, p1

    invoke-interface {v2, v0}, Lcom/tencent/tauth/IUiListener;->onComplete(Ljava/lang/Object;)V

    goto :goto_4

    :cond_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/tencent/connect/auth/c;->a:Lcom/tencent/tauth/IUiListener;

    if-eqz v2, :cond_0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/tencent/connect/auth/c;->a:Lcom/tencent/tauth/IUiListener;

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Lcom/tencent/tauth/IUiListener;->onComplete(Ljava/lang/Object;)V

    goto :goto_4

    :cond_4
    move-object v3, v2

    goto/16 :goto_3
.end method

.method public final onError(Lcom/tencent/tauth/UiError;)V
    .locals 1

    iget-object v0, p0, Lcom/tencent/connect/auth/c;->a:Lcom/tencent/tauth/IUiListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/connect/auth/c;->a:Lcom/tencent/tauth/IUiListener;

    invoke-interface {v0, p1}, Lcom/tencent/tauth/IUiListener;->onError(Lcom/tencent/tauth/UiError;)V

    :cond_0
    return-void
.end method
