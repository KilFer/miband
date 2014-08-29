.class final Lcn/com/smartdevices/bracelet/ui/bR;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/ui/UnlockScreenInvalidHelperActivity;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/UnlockScreenInvalidHelperActivity;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/bR;->a:Lcn/com/smartdevices/bracelet/ui/UnlockScreenInvalidHelperActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/bR;->a:Lcn/com/smartdevices/bracelet/ui/UnlockScreenInvalidHelperActivity;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/UnlockScreenInvalidHelperActivity;->finish()V

    return-void
.end method
