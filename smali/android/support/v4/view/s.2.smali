.class final Landroid/support/v4/view/s;
.super Landroid/support/v4/view/r;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/view/r;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)I
    .locals 1

    invoke-static {p1}, Landroid/view/KeyEvent;->normalizeMetaState(I)I

    move-result v0

    return v0
.end method

.method public final a(II)Z
    .locals 1

    invoke-static {p1, p2}, Landroid/view/KeyEvent;->metaStateHasModifiers(II)Z

    move-result v0

    return v0
.end method

.method public final b(I)Z
    .locals 1

    invoke-static {p1}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v0

    return v0
.end method
