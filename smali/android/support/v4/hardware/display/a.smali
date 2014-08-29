.class final Landroid/support/v4/hardware/display/a;
.super Landroid/support/v4/hardware/display/DisplayManagerCompat;


# instance fields
.field private final a:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    invoke-direct {p0}, Landroid/support/v4/hardware/display/DisplayManagerCompat;-><init>()V

    const-string v0, "display"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/hardware/display/a;->a:Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public final getDisplay(I)Landroid/view/Display;
    .locals 1

    iget-object v0, p0, Landroid/support/v4/hardware/display/a;->a:Ljava/lang/Object;

    check-cast v0, Landroid/hardware/display/DisplayManager;

    invoke-virtual {v0, p1}, Landroid/hardware/display/DisplayManager;->getDisplay(I)Landroid/view/Display;

    move-result-object v0

    return-object v0
.end method

.method public final getDisplays()[Landroid/view/Display;
    .locals 1

    iget-object v0, p0, Landroid/support/v4/hardware/display/a;->a:Ljava/lang/Object;

    check-cast v0, Landroid/hardware/display/DisplayManager;

    invoke-virtual {v0}, Landroid/hardware/display/DisplayManager;->getDisplays()[Landroid/view/Display;

    move-result-object v0

    return-object v0
.end method

.method public final getDisplays(Ljava/lang/String;)[Landroid/view/Display;
    .locals 1

    iget-object v0, p0, Landroid/support/v4/hardware/display/a;->a:Ljava/lang/Object;

    check-cast v0, Landroid/hardware/display/DisplayManager;

    invoke-virtual {v0, p1}, Landroid/hardware/display/DisplayManager;->getDisplays(Ljava/lang/String;)[Landroid/view/Display;

    move-result-object v0

    return-object v0
.end method
