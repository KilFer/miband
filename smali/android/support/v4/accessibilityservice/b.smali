.class final Landroid/support/v4/accessibilityservice/b;
.super Landroid/support/v4/accessibilityservice/a;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/accessibilityservice/a;-><init>()V

    return-void
.end method


# virtual methods
.method public final f(Landroid/accessibilityservice/AccessibilityServiceInfo;)I
    .locals 1

    invoke-virtual {p1}, Landroid/accessibilityservice/AccessibilityServiceInfo;->getCapabilities()I

    move-result v0

    return v0
.end method
