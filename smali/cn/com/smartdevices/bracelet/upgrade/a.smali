.class final Lcn/com/smartdevices/bracelet/upgrade/a;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcn/com/smartdevices/bracelet/upgrade/OtaVersionInfo;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static a(Landroid/os/Parcel;)Lcn/com/smartdevices/bracelet/upgrade/OtaVersionInfo;
    .locals 2

    new-instance v0, Lcn/com/smartdevices/bracelet/upgrade/OtaVersionInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcn/com/smartdevices/bracelet/upgrade/OtaVersionInfo;-><init>(Landroid/os/Parcel;B)V

    return-object v0
.end method

.method private static a(I)[Lcn/com/smartdevices/bracelet/upgrade/OtaVersionInfo;
    .locals 1

    new-array v0, p0, [Lcn/com/smartdevices/bracelet/upgrade/OtaVersionInfo;

    return-object v0
.end method


# virtual methods
.method public final synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 2

    new-instance v0, Lcn/com/smartdevices/bracelet/upgrade/OtaVersionInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcn/com/smartdevices/bracelet/upgrade/OtaVersionInfo;-><init>(Landroid/os/Parcel;B)V

    return-object v0
.end method

.method public final bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    new-array v0, p1, [Lcn/com/smartdevices/bracelet/upgrade/OtaVersionInfo;

    return-object v0
.end method
