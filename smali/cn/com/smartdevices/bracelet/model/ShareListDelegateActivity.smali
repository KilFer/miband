.class public Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;
.super Landroid/app/Activity;


# static fields
.field private static final REF_REPORT_DATA:Ljava/lang/String; = "REF_REPORT_DATA"

.field public static final SHARE_TYPE_CONTIUE_REACH_GOAL:Ljava/lang/String; = "SHARE_TYPE_CONTIUE_REACH_GOAL"

.field public static final SHARE_TYPE_LAST_MONTH:Ljava/lang/String; = "SHARE_TYPE_LAST_MONTH"

.field public static final SHARE_TYPE_LAST_WEEK:Ljava/lang/String; = "SHARE_TYPE_LAST_WEEK"

.field public static final SHARE_TYPE_NEW_RECORD:Ljava/lang/String; = "SHARE_TYPE_NEW_RECORD"

.field private static final TAG:Ljava/lang/String; = "ShareListDelegateActivity"


# instance fields
.field private mNewRecordSteps:I

.field private mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

.field private mShareType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method private getSportDayFromDateStr(Ljava/lang/String;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 5

    const-string v0, "-"

    invoke-virtual {p1, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :try_start_0
    aget-object v2, v0, v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    const/4 v3, 0x1

    aget-object v3, v0, v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    const/4 v4, 0x2

    aget-object v0, v0, v4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v4

    new-instance v0, Lcn/com/smartdevices/bracelet/model/SportDay;

    add-int/lit8 v3, v3, -0x1

    invoke-direct {v0, v2, v3, v4}, Lcn/com/smartdevices/bracelet/model/SportDay;-><init>(III)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    move-object v0, v1

    goto :goto_0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 12

    const/4 v0, 0x0

    const v11, 0x7f0c017a

    const v10, 0x7f0c003f

    const/4 v9, 0x1

    const/4 v2, 0x0

    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v4, ""

    if-eqz v1, :cond_9

    const-string v3, "REF_REPORT_DATA"

    invoke-virtual {v1, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/model/ReportData;->fromJsonStr(Ljava/lang/String;)Lcn/com/smartdevices/bracelet/model/ReportData;

    move-result-object v1

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    if-nez v1, :cond_1

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->finish()V

    :goto_0
    return-void

    :cond_0
    const-string v0, "ShareListDelegateActivity"

    const-string v1, "intent of mReportData is null"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->finish()V

    goto :goto_0

    :cond_1
    const-string v1, "ShareListDelegateActivity"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v5, "mReportData = "

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget-object v5, v5, Lcn/com/smartdevices/bracelet/model/ReportData;->type:Ljava/lang/String;

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/model/ReportData;->type:Ljava/lang/String;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mShareType:Ljava/lang/String;

    const-string v1, "SHARE_TYPE_LAST_WEEK"

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mShareType:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "SHARE_TYPE_LAST_MONTH"

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mShareType:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    :cond_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/model/ReportData;->timeFrom:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getSportDayFromDateStr(Ljava/lang/String;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/model/ReportData;->timeTo:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getSportDayFromDateStr(Ljava/lang/String;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget-object v3, v3, Lcn/com/smartdevices/bracelet/model/ReportData;->maxDateStr:Ljava/lang/String;

    invoke-direct {p0, v3}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getSportDayFromDateStr(Ljava/lang/String;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v3

    const-string v4, ""

    if-eqz v3, :cond_a

    invoke-virtual {v3, p0}, Lcn/com/smartdevices/bracelet/model/SportDay;->formatStringDay(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    move-object v6, v0

    move-object v7, v1

    :goto_1
    new-instance v8, Lcn/com/smartdevices/bracelet/model/ShareData;

    invoke-direct {v8}, Lcn/com/smartdevices/bracelet/model/ShareData;-><init>()V

    const-string v0, "SHARE_TYPE_LAST_MONTH"

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mShareType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    iget v1, v7, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    invoke-virtual {v0, v1}, Ljava/util/Date;->setMonth(I)V

    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v2, "MMMM, "

    invoke-direct {v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v11}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->title:Ljava/lang/String;

    const/4 v0, 0x6

    invoke-virtual {v8, v0}, Lcn/com/smartdevices/bracelet/model/ShareData;->setType(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget v1, v0, Lcn/com/smartdevices/bracelet/model/ReportData;->steps:I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget v2, v0, Lcn/com/smartdevices/bracelet/model/ReportData;->distance:I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget v3, v0, Lcn/com/smartdevices/bracelet/model/ReportData;->calories:I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget v5, v0, Lcn/com/smartdevices/bracelet/model/ReportData;->maxDateStep:I

    move-object v0, p0

    invoke-static/range {v0 .. v5}, Lcn/com/smartdevices/bracelet/Utils;->getMonthShareTips(Landroid/content/Context;IIILjava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->description:Ljava/lang/String;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget v0, v0, Lcn/com/smartdevices/bracelet/model/ReportData;->steps:I

    invoke-virtual {p0, v10}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->contentUnit:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Lcn/com/smartdevices/bracelet/model/SportDay;->formatStringDayShort()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v6}, Lcn/com/smartdevices/bracelet/model/SportDay;->formatStringDayShort()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->time:Ljava/lang/String;

    :goto_2
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->content:Ljava/lang/String;

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-class v1, Lcn/com/smartdevices/bracelet/ui/ShareActivity;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    const-string v1, "share_data"

    invoke-virtual {v0, v1, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->startActivity(Landroid/content/Intent;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->finish()V

    goto/16 :goto_0

    :cond_3
    const-string v1, "SHARE_TYPE_NEW_RECORD"

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mShareType:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/model/ReportData;->getSteps()I

    move-result v1

    iput v1, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mNewRecordSteps:I

    move-object v6, v0

    move-object v7, v0

    goto/16 :goto_1

    :cond_4
    const-string v1, "SHARE_TYPE_CONTIUE_REACH_GOAL"

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mShareType:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/model/ReportData;->timeFrom:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getSportDayFromDateStr(Ljava/lang/String;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/model/ReportData;->timeTo:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getSportDayFromDateStr(Ljava/lang/String;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    move-object v6, v0

    move-object v7, v1

    goto/16 :goto_1

    :cond_5
    const-string v0, "SHARE_TYPE_LAST_WEEK"

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mShareType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    new-instance v0, Ljava/lang/StringBuilder;

    const v1, 0x7f0c017b

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v11}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->title:Ljava/lang/String;

    const/4 v0, 0x7

    invoke-virtual {v8, v0}, Lcn/com/smartdevices/bracelet/model/ShareData;->setType(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget v0, v0, Lcn/com/smartdevices/bracelet/model/ReportData;->distance:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget v1, v1, Lcn/com/smartdevices/bracelet/model/ReportData;->calories:I

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget v2, v2, Lcn/com/smartdevices/bracelet/model/ReportData;->maxDateStep:I

    invoke-static {p0, v0, v1, v4, v2}, Lcn/com/smartdevices/bracelet/Utils;->getWeekShareTips(Landroid/content/Context;IILjava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->description:Ljava/lang/String;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget v0, v0, Lcn/com/smartdevices/bracelet/model/ReportData;->steps:I

    invoke-virtual {p0, v10}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->contentUnit:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Lcn/com/smartdevices/bracelet/model/SportDay;->formatStringDayShort()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v6}, Lcn/com/smartdevices/bracelet/model/SportDay;->formatStringDayShort()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->time:Ljava/lang/String;

    goto/16 :goto_2

    :cond_6
    const-string v0, "SHARE_TYPE_NEW_RECORD"

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mShareType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    const/4 v0, 0x5

    invoke-virtual {v8, v0}, Lcn/com/smartdevices/bracelet/model/ShareData;->setType(I)V

    const v0, 0x7f0c018d

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->title:Ljava/lang/String;

    iget v0, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mNewRecordSteps:I

    invoke-virtual {p0, v10}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->contentUnit:Ljava/lang/String;

    new-instance v1, Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-direct {v1}, Lcn/com/smartdevices/bracelet/model/SportDay;-><init>()V

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->formatString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->time:Ljava/lang/String;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/model/ReportData;->getDistance()I

    move-result v1

    invoke-static {p0, v1}, Lcn/com/smartdevices/bracelet/chart/util/ChartData;->formatDistance(Landroid/content/Context;I)[Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    aget-object v4, v1, v2

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v1, v1, v9

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    invoke-virtual {v4}, Lcn/com/smartdevices/bracelet/model/ReportData;->getCalories()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const v4, 0x7f0c018e

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    aput-object v1, v5, v2

    aput-object v3, v5, v9

    invoke-virtual {p0, v4, v5}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->description:Ljava/lang/String;

    goto/16 :goto_2

    :cond_7
    const-string v0, "SHARE_TYPE_CONTIUE_REACH_GOAL"

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mShareType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    const/16 v0, 0x8

    invoke-virtual {v8, v0}, Lcn/com/smartdevices/bracelet/model/ShareData;->setType(I)V

    const v0, 0x7f0c018f

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->title:Ljava/lang/String;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget v0, v0, Lcn/com/smartdevices/bracelet/model/ReportData;->continueDays:I

    const v1, 0x7f0c00d7

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->contentUnit:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Lcn/com/smartdevices/bracelet/model/SportDay;->formatStringDayShort()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "-"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v6}, Lcn/com/smartdevices/bracelet/model/SportDay;->formatStringDayShort()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->time:Ljava/lang/String;

    const v1, 0x7f0c0190

    new-array v3, v9, [Ljava/lang/Object;

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    iget v4, v4, Lcn/com/smartdevices/bracelet/model/ReportData;->maxContinueDays:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v2

    invoke-virtual {p0, v1, v3}, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->time_tips:Ljava/lang/String;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/model/ReportData;->getSteps()I

    move-result v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    invoke-virtual {v2}, Lcn/com/smartdevices/bracelet/model/ReportData;->getDistance()I

    move-result v2

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    invoke-virtual {v3}, Lcn/com/smartdevices/bracelet/model/ReportData;->getCalories()I

    move-result v3

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/model/ShareListDelegateActivity;->mReportData:Lcn/com/smartdevices/bracelet/model/ReportData;

    invoke-virtual {v4}, Lcn/com/smartdevices/bracelet/model/ReportData;->getContinueDays()I

    move-result v4

    invoke-static {p0, v1, v2, v3, v4}, Lcn/com/smartdevices/bracelet/Utils;->getContinueReachGoalShareTips(Landroid/content/Context;IIII)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v8, Lcn/com/smartdevices/bracelet/model/ShareData;->description:Ljava/lang/String;

    goto/16 :goto_2

    :cond_8
    move v0, v2

    goto/16 :goto_2

    :cond_9
    move-object v6, v0

    move-object v7, v0

    goto/16 :goto_1

    :cond_a
    move-object v6, v0

    move-object v7, v1

    goto/16 :goto_1
.end method
