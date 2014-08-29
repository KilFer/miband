.class final Lcn/com/smartdevices/bracelet/ui/aR;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/ui/aQ;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/aQ;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/aR;->a:Lcn/com/smartdevices/bracelet/ui/aQ;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/aR;->a:Lcn/com/smartdevices/bracelet/ui/aQ;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/aQ;->a:Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;->b(Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;)V

    return-void
.end method
