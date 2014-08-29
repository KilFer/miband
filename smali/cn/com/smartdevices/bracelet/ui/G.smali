.class final Lcn/com/smartdevices/bracelet/ui/G;
.super Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/G;->a:Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;-><init>()V

    return-void
.end method


# virtual methods
.method public final onFailed(Ljava/lang/Object;)V
    .locals 3

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;->onFailed(Ljava/lang/Object;)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/view/Util;->hideProgressDialog()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/G;->a:Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/G;->a:Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const v2, 0x7f0c0049

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    return-void
.end method

.method public final onFinish(Ljava/lang/Object;)V
    .locals 0

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;->onFinish(Ljava/lang/Object;)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/view/Util;->hideProgressDialog()V

    return-void
.end method

.method public final onStart()V
    .locals 3

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;->onStart()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/G;->a:Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const-string v1, "\u6b63\u5728\u91cd\u7f6e\u624b\u73af"

    const-string v2, "\u8bf7\u7a0d\u7b49\uff01"

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/view/Util;->showProgressDialog(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
