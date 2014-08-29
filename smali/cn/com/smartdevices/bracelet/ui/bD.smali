.class final Lcn/com/smartdevices/bracelet/ui/bD;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/ui/bC;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/bC;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/bD;->a:Lcn/com/smartdevices/bracelet/ui/bC;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/bD;->a:Lcn/com/smartdevices/bracelet/ui/bC;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/bC;->a(Lcn/com/smartdevices/bracelet/ui/bC;)Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;->a(Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;)Landroid/app/ProgressDialog;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/bD;->a:Lcn/com/smartdevices/bracelet/ui/bC;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/bC;->a(Lcn/com/smartdevices/bracelet/ui/bC;)Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;->a(Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;)Landroid/app/ProgressDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/bD;->a:Lcn/com/smartdevices/bracelet/ui/bC;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/bC;->a(Lcn/com/smartdevices/bracelet/ui/bC;)Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;->a(Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;Landroid/app/ProgressDialog;)V

    :cond_0
    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->getDefaultPeripheral()Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    const-class v1, Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v0

    invoke-static {v1, v0}, Lcn/com/smartdevices/bracelet/Utils;->removeBond(Ljava/lang/Class;Landroid/bluetooth/BluetoothDevice;)Z

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/bD;->a:Lcn/com/smartdevices/bracelet/ui/bC;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/bC;->a(Lcn/com/smartdevices/bracelet/ui/bC;)Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;->b(Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;)Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_1

    const-string v0, ""

    const-string v1, "getActivity is null! System.exit(-1) now!"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, -0x1

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    :goto_0
    return-void

    :cond_1
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/bD;->a:Lcn/com/smartdevices/bracelet/ui/bC;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/bC;->a(Lcn/com/smartdevices/bracelet/ui/bC;)Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;

    move-result-object v1

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/ui/SettingResetBraceletFragment;->dismiss()V

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    const-class v2, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    const v2, 0x10008000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    goto :goto_0
.end method
