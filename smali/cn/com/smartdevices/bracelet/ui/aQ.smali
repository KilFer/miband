.class final Lcn/com/smartdevices/bracelet/ui/aQ;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/aQ;->a:Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/aQ;)Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/aQ;->a:Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;

    return-object v0
.end method


# virtual methods
.method public final run()V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/aQ;->a:Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;->a(Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;)Lcn/com/smartdevices/bracelet/model/PersonInfo;

    move-result-object v0

    invoke-static {}, Lcn/com/smartdevices/bracelet/DataManager;->getInstance()Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v1

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/DataManager;->getUserTotalSportData()Lcn/com/smartdevices/bracelet/model/UserTotalSportData;

    move-result-object v1

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/model/PersonInfo;->totalSportData:Lcn/com/smartdevices/bracelet/model/UserTotalSportData;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/aQ;->a:Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/aQ;->a:Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/aR;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/aR;-><init>(Lcn/com/smartdevices/bracelet/ui/aQ;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
