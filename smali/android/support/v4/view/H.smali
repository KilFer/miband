.class final Landroid/support/v4/view/H;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/MenuItem$OnActionExpandListener;


# instance fields
.field private a:Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;


# direct methods
.method public constructor <init>(Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/support/v4/view/H;->a:Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;

    return-void
.end method


# virtual methods
.method public final onMenuItemActionCollapse(Landroid/view/MenuItem;)Z
    .locals 1

    iget-object v0, p0, Landroid/support/v4/view/H;->a:Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;

    invoke-virtual {v0, p1}, Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;->b(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public final onMenuItemActionExpand(Landroid/view/MenuItem;)Z
    .locals 1

    iget-object v0, p0, Landroid/support/v4/view/H;->a:Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;

    invoke-virtual {v0, p1}, Landroid/support/v4/view/AccessibilityDelegateCompatJellyBean;->a(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method
