.class final Landroid/support/v4/media/e;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/ViewTreeObserver$OnWindowAttachListener;


# instance fields
.field private synthetic a:Landroid/support/v4/media/d;


# direct methods
.method constructor <init>(Landroid/support/v4/media/d;)V
    .locals 0

    iput-object p1, p0, Landroid/support/v4/media/e;->a:Landroid/support/v4/media/d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onWindowAttached()V
    .locals 1

    iget-object v0, p0, Landroid/support/v4/media/e;->a:Landroid/support/v4/media/d;

    invoke-virtual {v0}, Landroid/support/v4/media/d;->c()V

    return-void
.end method

.method public final onWindowDetached()V
    .locals 1

    iget-object v0, p0, Landroid/support/v4/media/e;->a:Landroid/support/v4/media/d;

    invoke-virtual {v0}, Landroid/support/v4/media/d;->i()V

    return-void
.end method
