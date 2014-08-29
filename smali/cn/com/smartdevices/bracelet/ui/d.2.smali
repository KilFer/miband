.class final Lcn/com/smartdevices/bracelet/ui/d;
.super Landroid/database/ContentObserver;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/ui/AlarmActivity;

.field private final synthetic b:Landroid/content/ContentResolver;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/AlarmActivity;Landroid/os/Handler;Landroid/content/ContentResolver;)V
    .locals 1

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/d;->a:Lcn/com/smartdevices/bracelet/ui/AlarmActivity;

    iput-object p3, p0, Lcn/com/smartdevices/bracelet/ui/d;->b:Landroid/content/ContentResolver;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    return-void
.end method


# virtual methods
.method public final onChange(ZLandroid/net/Uri;)V
    .locals 2

    invoke-super {p0, p1, p2}, Landroid/database/ContentObserver;->onChange(ZLandroid/net/Uri;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/d;->a:Lcn/com/smartdevices/bracelet/ui/AlarmActivity;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/d;->b:Landroid/content/ContentResolver;

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/ui/AlarmActivity;->a(Lcn/com/smartdevices/bracelet/ui/AlarmActivity;Landroid/content/ContentResolver;)V

    return-void
.end method
