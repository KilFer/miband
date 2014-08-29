.class final Lcom/tencent/mm/sdk/platformtools/t;
.super Landroid/telephony/PhoneStateListener;


# instance fields
.field private synthetic a:Lcom/tencent/mm/sdk/platformtools/s;


# direct methods
.method constructor <init>(Lcom/tencent/mm/sdk/platformtools/s;)V
    .locals 0

    iput-object p1, p0, Lcom/tencent/mm/sdk/platformtools/t;->a:Lcom/tencent/mm/sdk/platformtools/s;

    invoke-direct {p0}, Landroid/telephony/PhoneStateListener;-><init>()V

    return-void
.end method


# virtual methods
.method public final onSignalStrengthsChanged(Landroid/telephony/SignalStrength;)V
    .locals 3

    invoke-super {p0, p1}, Landroid/telephony/PhoneStateListener;->onSignalStrengthsChanged(Landroid/telephony/SignalStrength;)V

    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/t;->a:Lcom/tencent/mm/sdk/platformtools/s;

    invoke-static {v0}, Lcom/tencent/mm/sdk/platformtools/s;->a(Lcom/tencent/mm/sdk/platformtools/s;)I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    invoke-virtual {p1}, Landroid/telephony/SignalStrength;->getCdmaDbm()I

    move-result v0

    invoke-static {v0}, Lcom/tencent/mm/sdk/platformtools/s;->a(I)I

    :cond_0
    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/t;->a:Lcom/tencent/mm/sdk/platformtools/s;

    invoke-static {v0}, Lcom/tencent/mm/sdk/platformtools/s;->a(Lcom/tencent/mm/sdk/platformtools/s;)I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    invoke-virtual {p1}, Landroid/telephony/SignalStrength;->getGsmSignalStrength()I

    move-result v0

    shl-int/lit8 v0, v0, 0x1

    add-int/lit8 v0, v0, -0x71

    invoke-static {v0}, Lcom/tencent/mm/sdk/platformtools/s;->a(I)I

    :cond_1
    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/t;->a:Lcom/tencent/mm/sdk/platformtools/s;

    invoke-static {v0}, Lcom/tencent/mm/sdk/platformtools/s;->b(Lcom/tencent/mm/sdk/platformtools/s;)Landroid/telephony/TelephonyManager;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/t;->a:Lcom/tencent/mm/sdk/platformtools/s;

    invoke-static {v0}, Lcom/tencent/mm/sdk/platformtools/s;->b(Lcom/tencent/mm/sdk/platformtools/s;)Landroid/telephony/TelephonyManager;

    move-result-object v0

    iget-object v1, p0, Lcom/tencent/mm/sdk/platformtools/t;->a:Lcom/tencent/mm/sdk/platformtools/s;

    invoke-static {v1}, Lcom/tencent/mm/sdk/platformtools/s;->c(Lcom/tencent/mm/sdk/platformtools/s;)Landroid/telephony/PhoneStateListener;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/telephony/TelephonyManager;->listen(Landroid/telephony/PhoneStateListener;I)V

    :cond_2
    return-void
.end method
