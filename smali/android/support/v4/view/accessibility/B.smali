.class Landroid/support/v4/view/accessibility/B;
.super Landroid/support/v4/view/accessibility/A;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/view/accessibility/A;-><init>()V

    return-void
.end method


# virtual methods
.method public final i(Ljava/lang/Object;I)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setMaxScrollX(I)V

    return-void
.end method

.method public final j(Ljava/lang/Object;I)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setMaxScrollY(I)V

    return-void
.end method

.method public final w(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getMaxScrollX()I

    move-result v0

    return v0
.end method

.method public final x(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getMaxScrollY()I

    move-result v0

    return v0
.end method
