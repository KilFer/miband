.class public Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;
.super Landroid/app/Activity;


# static fields
.field private static final a:Ljava/lang/String; = "SettingAboutActivity"


# instance fields
.field private b:Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;

.field private c:Landroid/content/BroadcastReceiver;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->b:Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;

    return-void
.end method

.method private a()V
    .locals 3

    new-instance v0, Lcn/com/smartdevices/bracelet/ui/bf;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/ui/bf;-><init>(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->c:Landroid/content/BroadcastReceiver;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->c:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "android.intent.action.DOWNLOAD_COMPLETE"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    invoke-static {}, Lde/greenrobot/event/EventBus;->getDefault()Lde/greenrobot/event/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lde/greenrobot/event/EventBus;->register(Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    const-class v0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Landroid/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->b:Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;

    const v0, 0x1020002

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->b:Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;

    invoke-virtual {v1, v0, v2}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    new-instance v0, Lcn/com/smartdevices/bracelet/ui/bf;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/ui/bf;-><init>(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->c:Landroid/content/BroadcastReceiver;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->c:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "android.intent.action.DOWNLOAD_COMPLETE"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    invoke-static {}, Lde/greenrobot/event/EventBus;->getDefault()Lde/greenrobot/event/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lde/greenrobot/event/EventBus;->register(Ljava/lang/Object;)V

    return-void
.end method

.method protected onDestroy()V
    .locals 1

    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->c:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->c:Landroid/content/BroadcastReceiver;

    invoke-static {}, Lde/greenrobot/event/EventBus;->getDefault()Lde/greenrobot/event/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lde/greenrobot/event/EventBus;->unregister(Ljava/lang/Object;)V

    return-void
.end method

.method public onEvent(Lcn/com/smartdevices/bracelet/eventbus/EventApkupgrade;)V
    .locals 3

    const-string v0, "SettingAboutActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "onEvent, + changelog="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/eventbus/EventApkupgrade;->getChangeLog()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", force="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/eventbus/EventApkupgrade;->isForceCheck()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " HasWindowfocus="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->hasWindowFocus()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->hasWindowFocus()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/eventbus/EventApkupgrade;->isForceCheck()Z

    move-result v0

    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/eventbus/EventApkupgrade;->getChangeLog()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v0, v1}, Lcn/com/smartdevices/bracelet/Utils;->checkXiaomiApkUpdate(Landroid/app/Activity;ZLjava/lang/String;)V

    :cond_0
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x102002c

    if-ne v0, v1, :cond_0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity;->finish()V

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onPause()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    invoke-static {p0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->endSession(Landroid/content/Context;)V

    return-void
.end method

.method protected onResume()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    invoke-static {p0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->startSession(Landroid/content/Context;)V

    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 0

    return-void
.end method
