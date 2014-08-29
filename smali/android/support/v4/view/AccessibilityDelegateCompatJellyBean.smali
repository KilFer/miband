.class Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;
.super Ljava/lang/Object;


# instance fields
.field final synthetic a:Landroid/support/v4/view/MenuItemCompat$OnActionExpandListener;

.field final synthetic b:Landroid/support/v4/view/C;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method constructor <init>(Landroid/support/v4/view/C;Landroid/support/v4/view/MenuItemCompat$OnActionExpandListener;)V
    .locals 0

    iput-object p2, p0, Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;->a:Landroid/support/v4/view/MenuItemCompat$OnActionExpandListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a(Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean;)Ljava/lang/Object;
    .locals 1

    new-instance v0, Landroid/support/v4/view/h;

    invoke-direct {v0, p0}, Landroid/support/v4/view/h;-><init>(Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean;)V

    return-object v0
.end method

.method public static a(Ljava/lang/Object;Landroid/view/View;)Ljava/lang/Object;
    .locals 1

    check-cast p0, Landroid/view/View$AccessibilityDelegate;

    invoke-virtual {p0, p1}, Landroid/view/View$AccessibilityDelegate;->getAccessibilityNodeProvider(Landroid/view/View;)Landroid/view/accessibility/AccessibilityNodeProvider;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/Object;Landroid/view/View;ILandroid/os/Bundle;)Z
    .locals 1

    check-cast p0, Landroid/view/View$AccessibilityDelegate;

    invoke-virtual {p0, p1, p2, p3}, Landroid/view/View$AccessibilityDelegate;->performAccessibilityAction(Landroid/view/View;ILandroid/os/Bundle;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public a(Landroid/view/MenuItem;)Z
    .locals 1

    iget-object v0, p0, Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;->a:Landroid/support/v4/view/MenuItemCompat$OnActionExpandListener;

    invoke-interface {v0, p1}, Landroid/support/v4/view/MenuItemCompat$OnActionExpandListener;->onMenuItemActionExpand(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public b(Landroid/view/MenuItem;)Z
    .locals 1

    iget-object v0, p0, Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;->a:Landroid/support/v4/view/MenuItemCompat$OnActionExpandListener;

    invoke-interface {v0, p1}, Landroid/support/v4/view/MenuItemCompat$OnActionExpandListener;->onMenuItemActionCollapse(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method
