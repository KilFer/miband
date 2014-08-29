.class public Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;
.super Ljava/lang/Object;


# static fields
.field private static a:Z


# instance fields
.field private b:Landroid/telephony/TelephonyManager;

.field private c:Landroid/telephony/PhoneStateListener;

.field private d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher$PhoneCallListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->d:Ljava/util/List;

    return-void
.end method

.method static synthetic a(Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;)Ljava/util/List;
    .locals 1

    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->d:Ljava/util/List;

    return-object v0
.end method

.method static synthetic a(Z)Z
    .locals 0

    sput-boolean p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->a:Z

    return p0
.end method

.method public static isCalling()Z
    .locals 1

    sget-boolean v0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->a:Z

    return v0
.end method


# virtual methods
.method public addPhoneCallListener(Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher$PhoneCallListener;)V
    .locals 1

    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->d:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public begin(Landroid/content/Context;)V
    .locals 3

    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->b:Landroid/telephony/TelephonyManager;

    if-nez v0, :cond_0

    const-string v0, "phone"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    iput-object v0, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->b:Landroid/telephony/TelephonyManager;

    :cond_0
    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->c:Landroid/telephony/PhoneStateListener;

    if-nez v0, :cond_1

    new-instance v0, Lcom/tencent/mm/sdk/platformtools/p;

    invoke-direct {v0, p0}, Lcom/tencent/mm/sdk/platformtools/p;-><init>(Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;)V

    iput-object v0, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->c:Landroid/telephony/PhoneStateListener;

    :cond_1
    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->b:Landroid/telephony/TelephonyManager;

    iget-object v1, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->c:Landroid/telephony/PhoneStateListener;

    const/16 v2, 0x20

    invoke-virtual {v0, v1, v2}, Landroid/telephony/TelephonyManager;->listen(Landroid/telephony/PhoneStateListener;I)V

    return-void
.end method

.method public clearPhoneCallListener()V
    .locals 1

    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    return-void
.end method

.method public end()V
    .locals 3

    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->b:Landroid/telephony/TelephonyManager;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->b:Landroid/telephony/TelephonyManager;

    iget-object v1, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->c:Landroid/telephony/PhoneStateListener;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/telephony/TelephonyManager;->listen(Landroid/telephony/PhoneStateListener;I)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->c:Landroid/telephony/PhoneStateListener;

    :cond_0
    return-void
.end method

.method public removePhoneCallListener(Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher$PhoneCallListener;)V
    .locals 1

    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;->d:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    return-void
.end method
