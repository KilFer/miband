.class public Lcn/com/smartdevices/bracelet/activity/WebActivity;
.super Landroid/app/Activity;

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field private static final a:Ljava/lang/String; = "WebActivity"


# instance fields
.field private b:Landroid/webkit/WebView;

.field private c:Landroid/widget/ProgressBar;

.field private d:I

.field private e:Ljava/lang/String;

.field private f:Landroid/webkit/WebChromeClient;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->b:Landroid/webkit/WebView;

    const/4 v0, 0x1

    iput v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->d:I

    new-instance v0, Lcn/com/smartdevices/bracelet/activity/k;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/activity/k;-><init>(Lcn/com/smartdevices/bracelet/activity/WebActivity;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->f:Landroid/webkit/WebChromeClient;

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/activity/WebActivity;)Landroid/widget/ProgressBar;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->c:Landroid/widget/ProgressBar;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/activity/WebActivity;->finish()V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x7f07002e
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    const/4 v3, 0x1

    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    const v0, 0x7f03002a

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/activity/WebActivity;->setContentView(I)V

    const v0, 0x7f070022

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/activity/WebActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->b:Landroid/webkit/WebView;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->b:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/activity/WebActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v0, "web_type"

    invoke-virtual {v1, v0, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->d:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->d:I

    if-nez v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->b:Landroid/webkit/WebView;

    const-string v2, "https://account.xiaomi.com/pass/wap/register?qs=callback%3Dhttps%253A%252F%252Faccount.xiaomi.com%252Fsts%253Fsign%253D8VUxGitrfXxS7XlgXfr7V0uceQc%25253D%2526followup%253Dhttps%25253A%25252F%25252Faccount.xiaomi.com%25252Foauth2%25252Fauthorize%25253Fskip_confirm%25253Dfalse%252526client_id%25253D2882303761517154077%252526redirect_uri%25253Dhttps%2525253A%2525252F%2525252Fhm.xiaomi.com%2525252Fhuami.health.loginview.do%252526response_type%25253Dcode%2526sid%253Doauth2.0%26sid%3Doauth2.0%26_customDisplay%3D0%26mini%3Dtrue%26lsrp_appName%3D%25E4%25BD%25BF%25E7%2594%25A8%25E4%25BD%25A0%25E7%259A%2584%25E5%25B0%258F%25E7%25B1%25B3%25E5%25B8%2590%25E5%258F%25B7%25E8%25AE%25BF%25E9%2597%25AE%2524%257B%25E5%25B0%258F%25E7%25B1%25B3%25E6%2589%258B%25E7%258E%25AF%257D%2524%26_ssign%3DrBm1F4Qu%252F%252FE074tgruygkG18tX0%253D"

    invoke-virtual {v0, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->b:Landroid/webkit/WebView;

    new-instance v2, Lcn/com/smartdevices/bracelet/activity/WebActivity$LoginJsObject;

    invoke-direct {v2, p0}, Lcn/com/smartdevices/bracelet/activity/WebActivity$LoginJsObject;-><init>(Lcn/com/smartdevices/bracelet/activity/WebActivity;)V

    const-string v3, "login"

    invoke-virtual {v0, v2, v3}, Landroid/webkit/WebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    :cond_0
    :goto_0
    const v0, 0x7f07002e

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/activity/WebActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const-string v2, "Label"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->e:Ljava/lang/String;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->e:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_1
    const v0, 0x7f0700d1

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/activity/WebActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->c:Landroid/widget/ProgressBar;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->b:Landroid/webkit/WebView;

    new-instance v1, Lcn/com/smartdevices/bracelet/activity/l;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/activity/l;-><init>(Lcn/com/smartdevices/bracelet/activity/WebActivity;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->b:Landroid/webkit/WebView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->f:Landroid/webkit/WebChromeClient;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    return-void

    :cond_2
    iget v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->d:I

    if-ne v0, v3, :cond_3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->b:Landroid/webkit/WebView;

    const-string v2, "https://hm.xiaomi.com/huami.health.login.json"

    invoke-virtual {v0, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->b:Landroid/webkit/WebView;

    new-instance v2, Lcn/com/smartdevices/bracelet/activity/WebActivity$LoginJsObject;

    invoke-direct {v2, p0}, Lcn/com/smartdevices/bracelet/activity/WebActivity$LoginJsObject;-><init>(Lcn/com/smartdevices/bracelet/activity/WebActivity;)V

    const-string v3, "login"

    invoke-virtual {v0, v2, v3}, Landroid/webkit/WebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    iget v0, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->d:I

    const/4 v2, 0x2

    if-ne v0, v2, :cond_0

    const-string v0, "web_url"

    invoke-virtual {v1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "file://"

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->b:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V

    :cond_4
    iget-object v2, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->b:Landroid/webkit/WebView;

    invoke-virtual {v2, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x102002c

    if-ne v0, v1, :cond_0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/activity/WebActivity;->finish()V

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onPause()V
    .locals 3

    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    const-string v0, "PageWeb"

    iget v1, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->d:I

    packed-switch v1, :pswitch_data_0

    :cond_0
    :goto_0
    :pswitch_0
    invoke-static {v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->endPage(Ljava/lang/String;)V

    invoke-static {p0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->endSession(Landroid/content/Context;)V

    return-void

    :pswitch_1
    const-string v0, "PageWebRegister"

    goto :goto_0

    :pswitch_2
    const v1, 0x7f0c00d0

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/activity/WebActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->e:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v0, "PageWebUserAgreement"

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method protected onResume()V
    .locals 3

    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    const-string v0, "PageWeb"

    iget v1, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->d:I

    packed-switch v1, :pswitch_data_0

    :cond_0
    :goto_0
    :pswitch_0
    invoke-static {v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->startPage(Ljava/lang/String;)V

    invoke-static {p0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->startSession(Landroid/content/Context;)V

    return-void

    :pswitch_1
    const-string v0, "PageWebRegister"

    goto :goto_0

    :pswitch_2
    const v1, 0x7f0c00d0

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/activity/WebActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/activity/WebActivity;->e:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v0, "PageWebUserAgreement"

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method
