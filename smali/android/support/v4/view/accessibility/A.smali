.class Landroid/support/v4/view/accessibility/A;
.super Landroid/support/v4/view/accessibility/C;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/view/accessibility/C;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()Ljava/lang/Object;
    .locals 1

    invoke-static {}, Landroid/view/accessibility/AccessibilityRecord;->obtain()Landroid/view/accessibility/AccessibilityRecord;

    move-result-object v0

    return-object v0
.end method

.method public final a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-static {p1}, Landroid/view/accessibility/AccessibilityRecord;->obtain(Landroid/view/accessibility/AccessibilityRecord;)Landroid/view/accessibility/AccessibilityRecord;

    move-result-object v0

    return-object v0
.end method

.method public final a(Ljava/lang/Object;I)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setAddedCount(I)V

    return-void
.end method

.method public final a(Ljava/lang/Object;Landroid/os/Parcelable;)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setParcelableData(Landroid/os/Parcelable;)V

    return-void
.end method

.method public final a(Ljava/lang/Object;Landroid/view/View;)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setSource(Landroid/view/View;)V

    return-void
.end method

.method public final a(Ljava/lang/Object;Ljava/lang/CharSequence;)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setBeforeText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public final a(Ljava/lang/Object;Z)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setChecked(Z)V

    return-void
.end method

.method public final b(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getAddedCount()I

    move-result v0

    return v0
.end method

.method public final b(Ljava/lang/Object;I)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setCurrentItemIndex(I)V

    return-void
.end method

.method public final b(Ljava/lang/Object;Ljava/lang/CharSequence;)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setClassName(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public final b(Ljava/lang/Object;Z)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setEnabled(Z)V

    return-void
.end method

.method public final c(Ljava/lang/Object;)Ljava/lang/CharSequence;
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getBeforeText()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public final c(Ljava/lang/Object;I)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setFromIndex(I)V

    return-void
.end method

.method public final c(Ljava/lang/Object;Ljava/lang/CharSequence;)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setContentDescription(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public final c(Ljava/lang/Object;Z)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setFullScreen(Z)V

    return-void
.end method

.method public final d(Ljava/lang/Object;)Ljava/lang/CharSequence;
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getClassName()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public final d(Ljava/lang/Object;I)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setItemCount(I)V

    return-void
.end method

.method public final d(Ljava/lang/Object;Z)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setPassword(Z)V

    return-void
.end method

.method public final e(Ljava/lang/Object;)Ljava/lang/CharSequence;
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getContentDescription()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public final e(Ljava/lang/Object;I)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setRemovedCount(I)V

    return-void
.end method

.method public final e(Ljava/lang/Object;Z)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setScrollable(Z)V

    return-void
.end method

.method public final f(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getCurrentItemIndex()I

    move-result v0

    return v0
.end method

.method public final f(Ljava/lang/Object;I)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setScrollX(I)V

    return-void
.end method

.method public final g(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getFromIndex()I

    move-result v0

    return v0
.end method

.method public final g(Ljava/lang/Object;I)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setScrollY(I)V

    return-void
.end method

.method public final h(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getItemCount()I

    move-result v0

    return v0
.end method

.method public final h(Ljava/lang/Object;I)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1, p2}, Landroid/view/accessibility/AccessibilityRecord;->setToIndex(I)V

    return-void
.end method

.method public final i(Ljava/lang/Object;)Landroid/os/Parcelable;
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getParcelableData()Landroid/os/Parcelable;

    move-result-object v0

    return-object v0
.end method

.method public final j(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getRemovedCount()I

    move-result v0

    return v0
.end method

.method public final k(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getScrollX()I

    move-result v0

    return v0
.end method

.method public final l(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getScrollY()I

    move-result v0

    return v0
.end method

.method public final m(Ljava/lang/Object;)Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getSource()Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v0

    invoke-static {v0}, Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;->a(Ljava/lang/Object;)Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;

    move-result-object v0

    return-object v0
.end method

.method public final n(Ljava/lang/Object;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getText()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public final o(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getToIndex()I

    move-result v0

    return v0
.end method

.method public final p(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->getWindowId()I

    move-result v0

    return v0
.end method

.method public final q(Ljava/lang/Object;)Z
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->isChecked()Z

    move-result v0

    return v0
.end method

.method public final r(Ljava/lang/Object;)Z
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->isEnabled()Z

    move-result v0

    return v0
.end method

.method public final s(Ljava/lang/Object;)Z
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->isFullScreen()Z

    move-result v0

    return v0
.end method

.method public final t(Ljava/lang/Object;)Z
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->isPassword()Z

    move-result v0

    return v0
.end method

.method public final u(Ljava/lang/Object;)Z
    .locals 1

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->isScrollable()Z

    move-result v0

    return v0
.end method

.method public final v(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Landroid/view/accessibility/AccessibilityRecord;

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityRecord;->recycle()V

    return-void
.end method
