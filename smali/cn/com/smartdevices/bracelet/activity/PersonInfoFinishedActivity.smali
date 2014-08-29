.class public Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;
.super Landroid/app/Activity;


# static fields
.field private static a:Landroid/os/Handler;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    sput-object v0, Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;->a:Landroid/os/Handler;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method private a()V
    .locals 5

    const/4 v2, 0x1

    const v0, 0x7f070163

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    invoke-virtual {v1, v2}, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V

    const/4 v1, 0x0

    invoke-virtual {v0, v2, v1}, Landroid/webkit/WebView;->setLayerType(ILandroid/graphics/Paint;)V

    const-string v1, "file:///android_asset/set_finish.gif"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    sget-object v1, Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;->a:Landroid/os/Handler;

    new-instance v2, Lcn/com/smartdevices/bracelet/activity/j;

    invoke-direct {v2, p0, v0}, Lcn/com/smartdevices/bracelet/activity/j;-><init>(Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;Landroid/webkit/WebView;)V

    const-wide/16 v3, 0x3e8

    invoke-virtual {v1, v2, v3, v4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5

    const/4 v2, 0x1

    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    const v0, 0x7f030050

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;->setContentView(I)V

    const v0, 0x7f070165

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    new-instance v1, Lcn/com/smartdevices/bracelet/activity/i;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/activity/i;-><init>(Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f070163

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    invoke-virtual {v1, v2}, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V

    const/4 v1, 0x0

    invoke-virtual {v0, v2, v1}, Landroid/webkit/WebView;->setLayerType(ILandroid/graphics/Paint;)V

    const-string v1, "file:///android_asset/set_finish.gif"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    sget-object v1, Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;->a:Landroid/os/Handler;

    new-instance v2, Lcn/com/smartdevices/bracelet/activity/j;

    invoke-direct {v2, p0, v0}, Lcn/com/smartdevices/bracelet/activity/j;-><init>(Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;Landroid/webkit/WebView;)V

    const-wide/16 v3, 0x3e8

    invoke-virtual {v1, v2, v3, v4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void
.end method

.method protected onPause()V
    .locals 1

    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    const-string v0, "PagePersonGuideFinish"

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->endPage(Ljava/lang/String;)V

    invoke-static {p0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->endSession(Landroid/content/Context;)V

    return-void
.end method

.method protected onResume()V
    .locals 1

    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    const-string v0, "PagePersonGuideFinish"

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->startPage(Ljava/lang/String;)V

    invoke-static {p0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->startSession(Landroid/content/Context;)V

    return-void
.end method
