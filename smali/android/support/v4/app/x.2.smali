.class final Landroid/support/v4/app/x;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Landroid/support/v4/app/v;


# direct methods
.method constructor <init>(Landroid/support/v4/app/v;)V
    .locals 0

    iput-object p1, p0, Landroid/support/v4/app/x;->a:Landroid/support/v4/app/v;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    iget-object v0, p0, Landroid/support/v4/app/x;->a:Landroid/support/v4/app/v;

    iget-object v1, p0, Landroid/support/v4/app/x;->a:Landroid/support/v4/app/v;

    iget-object v1, v1, Landroid/support/v4/app/v;->e:Landroid/support/v4/app/FragmentActivity;

    iget-object v1, v1, Landroid/support/v4/app/FragmentActivity;->a:Landroid/os/Handler;

    const/4 v1, 0x0

    const/4 v2, -0x1

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/v;->a(Ljava/lang/String;II)Z

    return-void
.end method
