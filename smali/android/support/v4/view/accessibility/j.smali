.class final Landroid/support/v4/view/accessibility/j;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;


# instance fields
.field private synthetic a:Landroid/support/v4/view/accessibility/d;


# direct methods
.method constructor <init>(Landroid/support/v4/view/accessibility/d;)V
    .locals 0

    iput-object p1, p0, Landroid/support/v4/view/accessibility/j;->a:Landroid/support/v4/view/accessibility/d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAccessibilityStateChanged(Z)V
    .locals 1

    iget-object v0, p0, Landroid/support/v4/view/accessibility/j;->a:Landroid/support/v4/view/accessibility/d;

    invoke-virtual {v0, p1}, Landroid/support/v4/view/accessibility/d;->a(Z)V

    return-void
.end method
