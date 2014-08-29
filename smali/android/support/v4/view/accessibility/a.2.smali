.class final Landroid/support/v4/view/accessibility/a;
.super Landroid/support/v4/view/accessibility/c;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/view/accessibility/c;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/view/accessibility/AccessibilityEvent;)I
    .locals 1

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityEvent;->getRecordCount()I

    move-result v0

    return v0
.end method

.method public final a(Landroid/view/accessibility/AccessibilityEvent;I)Ljava/lang/Object;
    .locals 1

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityEvent;->getRecord(I)Landroid/view/accessibility/AccessibilityRecord;

    move-result-object v0

    return-object v0
.end method

.method public final a(Landroid/view/accessibility/AccessibilityEvent;Ljava/lang/Object;)V
    .locals 0

    check-cast p2, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityEvent;->appendRecord(Landroid/view/accessibility/AccessibilityRecord;)V

    return-void
.end method
