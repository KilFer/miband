.class public Landroid/support/v4/view/accessibility/AccessibilityManagerCompat;
.super Ljava/lang/Object;


# static fields
.field private static final a:Landroid/support/v4/view/accessibility/h;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    new-instance v0, Landroid/support/v4/view/accessibility/e;

    invoke-direct {v0}, Landroid/support/v4/view/accessibility/e;-><init>()V

    sput-object v0, Landroid/support/v4/view/accessibility/AccessibilityManagerCompat;->a:Landroid/support/v4/view/accessibility/h;

    :goto_0
    return-void

    :cond_0
    new-instance v0, Landroid/support/v4/view/accessibility/h;

    invoke-direct {v0}, Landroid/support/v4/view/accessibility/h;-><init>()V

    sput-object v0, Landroid/support/v4/view/accessibility/AccessibilityManagerCompat;->a:Landroid/support/v4/view/accessibility/h;

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic a()Landroid/support/v4/view/accessibility/h;
    .locals 1

    sget-object v0, Landroid/support/v4/view/accessibility/AccessibilityManagerCompat;->a:Landroid/support/v4/view/accessibility/h;

    return-object v0
.end method

.method public static addAccessibilityStateChangeListener(Landroid/view/accessibility/AccessibilityManager;Landroid/support/v4/view/accessibility/AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat;)Z
    .locals 1

    sget-object v0, Landroid/support/v4/view/accessibility/AccessibilityManagerCompat;->a:Landroid/support/v4/view/accessibility/h;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/accessibility/h;->a(Landroid/view/accessibility/AccessibilityManager;Landroid/support/v4/view/accessibility/AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat;)Z

    move-result v0

    return v0
.end method

.method public static getEnabledAccessibilityServiceList(Landroid/view/accessibility/AccessibilityManager;I)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/accessibility/AccessibilityManager;",
            "I)",
            "Ljava/util/List",
            "<",
            "Landroid/accessibilityservice/AccessibilityServiceInfo;",
            ">;"
        }
    .end annotation

    sget-object v0, Landroid/support/v4/view/accessibility/AccessibilityManagerCompat;->a:Landroid/support/v4/view/accessibility/h;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/accessibility/h;->a(Landroid/view/accessibility/AccessibilityManager;I)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getInstalledAccessibilityServiceList(Landroid/view/accessibility/AccessibilityManager;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/accessibility/AccessibilityManager;",
            ")",
            "Ljava/util/List",
            "<",
            "Landroid/accessibilityservice/AccessibilityServiceInfo;",
            ">;"
        }
    .end annotation

    sget-object v0, Landroid/support/v4/view/accessibility/AccessibilityManagerCompat;->a:Landroid/support/v4/view/accessibility/h;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/accessibility/h;->a(Landroid/view/accessibility/AccessibilityManager;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static isTouchExplorationEnabled(Landroid/view/accessibility/AccessibilityManager;)Z
    .locals 1

    sget-object v0, Landroid/support/v4/view/accessibility/AccessibilityManagerCompat;->a:Landroid/support/v4/view/accessibility/h;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/accessibility/h;->b(Landroid/view/accessibility/AccessibilityManager;)Z

    move-result v0

    return v0
.end method

.method public static removeAccessibilityStateChangeListener(Landroid/view/accessibility/AccessibilityManager;Landroid/support/v4/view/accessibility/AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat;)Z
    .locals 1

    sget-object v0, Landroid/support/v4/view/accessibility/AccessibilityManagerCompat;->a:Landroid/support/v4/view/accessibility/h;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/accessibility/h;->b(Landroid/view/accessibility/AccessibilityManager;Landroid/support/v4/view/accessibility/AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat;)Z

    move-result v0

    return v0
.end method
