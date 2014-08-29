.class final Landroid/support/v4/app/y;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Ljava/lang/String;

.field private synthetic b:I

.field private synthetic c:Landroid/support/v4/app/v;


# direct methods
.method constructor <init>(Landroid/support/v4/app/v;Ljava/lang/String;I)V
    .locals 0

    iput-object p1, p0, Landroid/support/v4/app/y;->c:Landroid/support/v4/app/v;

    iput-object p2, p0, Landroid/support/v4/app/y;->a:Ljava/lang/String;

    iput p3, p0, Landroid/support/v4/app/y;->b:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    iget-object v0, p0, Landroid/support/v4/app/y;->c:Landroid/support/v4/app/v;

    iget-object v1, p0, Landroid/support/v4/app/y;->c:Landroid/support/v4/app/v;

    iget-object v1, v1, Landroid/support/v4/app/v;->e:Landroid/support/v4/app/FragmentActivity;

    iget-object v1, v1, Landroid/support/v4/app/FragmentActivity;->a:Landroid/os/Handler;

    iget-object v1, p0, Landroid/support/v4/app/y;->a:Ljava/lang/String;

    const/4 v2, -0x1

    iget v3, p0, Landroid/support/v4/app/y;->b:I

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/v;->a(Ljava/lang/String;II)Z

    return-void
.end method
