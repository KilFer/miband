.class Landroid/support/v4/view/r;
.super Landroid/support/v4/view/t;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/view/t;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/view/View;)Ljava/lang/Object;
    .locals 1

    invoke-virtual {p1}, Landroid/view/View;->getKeyDispatcherState()Landroid/view/KeyEvent$DispatcherState;

    move-result-object v0

    return-object v0
.end method

.method public final a(Landroid/view/KeyEvent;)V
    .locals 0

    invoke-virtual {p1}, Landroid/view/KeyEvent;->startTracking()V

    return-void
.end method

.method public final a(Landroid/view/KeyEvent;Landroid/view/KeyEvent$Callback;Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 1

    check-cast p3, Landroid/view/KeyEvent$DispatcherState;

    invoke-virtual {p1, p2, p3, p4}, Landroid/view/KeyEvent;->dispatch(Landroid/view/KeyEvent$Callback;Landroid/view/KeyEvent$DispatcherState;Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final b(Landroid/view/KeyEvent;)Z
    .locals 1

    invoke-virtual {p1}, Landroid/view/KeyEvent;->isTracking()Z

    move-result v0

    return v0
.end method
