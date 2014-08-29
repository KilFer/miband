.class final Lcn/com/smartdevices/bracelet/activity/j;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;

.field private final synthetic b:Landroid/webkit/WebView;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;Landroid/webkit/WebView;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/activity/j;->a:Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;

    iput-object p2, p0, Lcn/com/smartdevices/bracelet/activity/j;->b:Landroid/webkit/WebView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/activity/j;->a:Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;

    const v1, 0x7f07008c

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/activity/j;->b:Landroid/webkit/WebView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setVisibility(I)V

    return-void
.end method
