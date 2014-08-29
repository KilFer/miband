.class final Landroid/support/v4/view/C;
.super Landroid/support/v4/view/B;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/view/B;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/view/MenuItem;Landroid/support/v4/view/MenuItemCompat$OnActionExpandListener;)Landroid/view/MenuItem;
    .locals 1

    if-nez p2, :cond_0

    const/4 v0, 0x0

    invoke-static {p1, v0}, Landroid/support/v4/view/G;->a(Landroid/view/MenuItem;Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;)Landroid/view/MenuItem;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;

    invoke-direct {v0, p0, p2}, Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;-><init>(Landroid/support/v4/view/C;Landroid/support/v4/view/MenuItemCompat$OnActionExpandListener;)V

    invoke-static {p1, v0}, Landroid/support/v4/view/G;->a(Landroid/view/MenuItem;Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;)Landroid/view/MenuItem;

    move-result-object v0

    goto :goto_0
.end method

.method public final b(Landroid/view/MenuItem;)Z
    .locals 1

    invoke-interface {p1}, Landroid/view/MenuItem;->expandActionView()Z

    move-result v0

    return v0
.end method

.method public final c(Landroid/view/MenuItem;)Z
    .locals 1

    invoke-interface {p1}, Landroid/view/MenuItem;->collapseActionView()Z

    move-result v0

    return v0
.end method

.method public final d(Landroid/view/MenuItem;)Z
    .locals 1

    invoke-interface {p1}, Landroid/view/MenuItem;->isActionViewExpanded()Z

    move-result v0

    return v0
.end method
