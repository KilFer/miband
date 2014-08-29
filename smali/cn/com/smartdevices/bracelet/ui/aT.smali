.class final Lcn/com/smartdevices/bracelet/ui/aT;
.super Ljava/lang/Object;

# interfaces
.implements Lcn/com/smartdevices/bracelet/ui/DimPanelFragment$OpClickListener;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/aT;->a:Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onEmptyAreaClicked(Landroid/app/DialogFragment;)V
    .locals 0

    return-void
.end method

.method public final onLeftClicked(Landroid/app/DialogFragment;)V
    .locals 1

    invoke-virtual {p1}, Landroid/app/DialogFragment;->dismiss()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/aT;->a:Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;->d(Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;)V

    return-void
.end method

.method public final onRightClicked(Landroid/app/DialogFragment;)V
    .locals 0

    invoke-virtual {p1}, Landroid/app/DialogFragment;->dismiss()V

    return-void
.end method
