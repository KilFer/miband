.class public Lcom/tencent/mm/sdk/platformtools/ObserverPool$Event;
.super Ljava/lang/Object;


# static fields
.field public static final FLAG_ORDER_EXE:I = 0x1


# instance fields
.field private final a:Ljava/lang/String;

.field private b:I

.field public final data:Landroid/os/Bundle;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/tencent/mm/sdk/platformtools/ObserverPool$Event;->data:Landroid/os/Bundle;

    invoke-static {p1}, Ljunit/framework/Assert;->assertNotNull(Ljava/lang/Object;)V

    iput-object p1, p0, Lcom/tencent/mm/sdk/platformtools/ObserverPool$Event;->a:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getFlag()I
    .locals 1

    iget v0, p0, Lcom/tencent/mm/sdk/platformtools/ObserverPool$Event;->b:I

    return v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/ObserverPool$Event;->a:Ljava/lang/String;

    return-object v0
.end method

.method public onComplete()V
    .locals 0

    return-void
.end method

.method public setFlag(I)Lcom/tencent/mm/sdk/platformtools/ObserverPool$Event;
    .locals 0

    iput p1, p0, Lcom/tencent/mm/sdk/platformtools/ObserverPool$Event;->b:I

    return-object p0
.end method
