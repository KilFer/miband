.class final Lcn/com/smartdevices/bracelet/ui/ax;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/ui/MainUIActivity;

.field private final synthetic b:Landroid/os/Handler;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/MainUIActivity;Landroid/os/Handler;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/ax;->a:Lcn/com/smartdevices/bracelet/ui/MainUIActivity;

    iput-object p2, p0, Lcn/com/smartdevices/bracelet/ui/ax;->b:Landroid/os/Handler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ax;->a:Lcn/com/smartdevices/bracelet/ui/MainUIActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/MainUIActivity;->u(Lcn/com/smartdevices/bracelet/ui/MainUIActivity;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ax;->a:Lcn/com/smartdevices/bracelet/ui/MainUIActivity;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/MainUIActivity;->listAnim()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ax;->b:Landroid/os/Handler;

    invoke-virtual {v0, p0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    return-void
.end method
