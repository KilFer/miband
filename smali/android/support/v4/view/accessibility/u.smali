.class final Landroid/support/v4/view/accessibility/u;
.super Landroid/support/v4/view/accessibility/t;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/view/accessibility/t;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/support/v4/view/accessibility/AccessibilityNodeProviderCompat;)Ljava/lang/Object;
    .locals 2

    new-instance v0, Landroid/support/v4/view/accessibility/i;

    invoke-direct {v0, p0, p1}, Landroid/support/v4/view/accessibility/i;-><init>(Landroid/support/v4/view/accessibility/u;Landroid/support/v4/view/accessibility/AccessibilityNodeProviderCompat;)V

    new-instance v1, Landroid/support/v4/view/accessibility/y;

    invoke-direct {v1, v0}, Landroid/support/v4/view/accessibility/y;-><init>(Landroid/support/v4/view/accessibility/i;)V

    return-object v1
.end method
