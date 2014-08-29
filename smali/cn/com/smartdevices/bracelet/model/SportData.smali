.class public Lcn/com/smartdevices/bracelet/model/SportData;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/io/Serializable;
.implements Ljava/lang/Cloneable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private activity:I

.field private mode:I

.field private step:I

.field private timeIndex:I


# direct methods
.method public constructor <init>(III)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcn/com/smartdevices/bracelet/model/SportData;->timeIndex:I

    iput p1, p0, Lcn/com/smartdevices/bracelet/model/SportData;->mode:I

    iput p2, p0, Lcn/com/smartdevices/bracelet/model/SportData;->activity:I

    iput p3, p0, Lcn/com/smartdevices/bracelet/model/SportData;->step:I

    return-void
.end method

.method public constructor <init>(IIII)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcn/com/smartdevices/bracelet/model/SportData;->timeIndex:I

    iput p1, p0, Lcn/com/smartdevices/bracelet/model/SportData;->timeIndex:I

    iput p2, p0, Lcn/com/smartdevices/bracelet/model/SportData;->mode:I

    iput p3, p0, Lcn/com/smartdevices/bracelet/model/SportData;->activity:I

    iput p4, p0, Lcn/com/smartdevices/bracelet/model/SportData;->step:I

    return-void
.end method


# virtual methods
.method public copy()Lcn/com/smartdevices/bracelet/model/SportData;
    .locals 1

    invoke-virtual {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/model/SportData;

    return-object v0
.end method

.method public getActivity()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/model/SportData;->activity:I

    return v0
.end method

.method public getSportMode()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/model/SportData;->mode:I

    return v0
.end method

.method public getStep()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/model/SportData;->step:I

    return v0
.end method

.method public getTimeIndex()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/model/SportData;->timeIndex:I

    return v0
.end method

.method public setActivity(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/model/SportData;->activity:I

    return-void
.end method

.method public setMode(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/model/SportData;->mode:I

    return-void
.end method

.method public setStep(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/model/SportData;->step:I

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "<"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Lcn/com/smartdevices/bracelet/model/SportData;->timeIndex:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/model/SportData;->mode:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/model/SportData;->activity:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/model/SportData;->step:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ">"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
