.class final Lcn/com/smartdevices/bracelet/ui/ak;
.super Landroid/webkit/WebViewClient;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/ui/HelpFragment;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/HelpFragment;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/ak;->a:Lcn/com/smartdevices/bracelet/ui/HelpFragment;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public final onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ak;->a:Lcn/com/smartdevices/bracelet/ui/HelpFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/HelpFragment;->a(Lcn/com/smartdevices/bracelet/ui/HelpFragment;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    return-void
.end method

.method public final onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ak;->a:Lcn/com/smartdevices/bracelet/ui/HelpFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/HelpFragment;->a(Lcn/com/smartdevices/bracelet/ui/HelpFragment;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    return-void
.end method
