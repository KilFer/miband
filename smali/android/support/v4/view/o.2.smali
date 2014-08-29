.class final Landroid/support/v4/view/o;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/support/v4/view/m;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(II)I
    .locals 1

    invoke-static {p1, p2}, Landroid/view/Gravity;->getAbsoluteGravity(II)I

    move-result v0

    return v0
.end method

.method public final a(IIILandroid/graphics/Rect;IILandroid/graphics/Rect;I)V
    .locals 0

    invoke-static/range {p1 .. p8}, Landroid/view/Gravity;->apply(IIILandroid/graphics/Rect;IILandroid/graphics/Rect;I)V

    return-void
.end method

.method public final a(IIILandroid/graphics/Rect;Landroid/graphics/Rect;I)V
    .locals 0

    invoke-static/range {p1 .. p6}, Landroid/view/Gravity;->apply(IIILandroid/graphics/Rect;Landroid/graphics/Rect;I)V

    return-void
.end method

.method public final a(ILandroid/graphics/Rect;Landroid/graphics/Rect;I)V
    .locals 0

    invoke-static {p1, p2, p3, p4}, Landroid/view/Gravity;->applyDisplay(ILandroid/graphics/Rect;Landroid/graphics/Rect;I)V

    return-void
.end method
