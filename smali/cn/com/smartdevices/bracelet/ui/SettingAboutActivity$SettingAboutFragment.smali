.class public Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;
.super Landroid/app/Fragment;

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field private static final a:Ljava/lang/String; = "SettingAboutActivity"


# instance fields
.field private b:Landroid/view/View;

.field private c:Landroid/widget/TextView;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;

.field private f:Landroid/view/View;

.field private g:Landroid/widget/LinearLayout;

.field private h:Landroid/widget/TextView;

.field private i:Landroid/widget/TextView;

.field private final j:I

.field private final k:I

.field private final l:I

.field private final m:I

.field private n:Landroid/app/ProgressDialog;

.field private o:I

.field private p:Landroid/os/Handler;


# direct methods
.method public constructor <init>()V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->f:Landroid/view/View;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->n:Landroid/app/ProgressDialog;

    const/4 v0, 0x0

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->o:I

    new-instance v0, Lcn/com/smartdevices/bracelet/ui/bg;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/ui/bg;-><init>(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->p:Landroid/os/Handler;

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)Landroid/app/ProgressDialog;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->n:Landroid/app/ProgressDialog;

    return-object v0
.end method

.method private a()V
    .locals 3

    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v1, "\u4e0a\u4f20\u8c03\u8bd5\u65e5\u5fd7"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    const-string v1, "\u8bf7\u786e\u4fdd\u662fwifi\u7f51\u7edc\u8fde\u63a5\uff0c\u5426\u5219\u4f1a\u8017\u8d39\u60a8\u7684\u6570\u636e\u6d41\u91cf\uff0c\u786e\u5b9a\u4e0a\u4f20\uff1f"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    const-string v1, "\u786e\u5b9a"

    new-instance v2, Lcn/com/smartdevices/bracelet/ui/bi;

    invoke-direct {v2, p0}, Lcn/com/smartdevices/bracelet/ui/bi;-><init>(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    const-string v1, "\u53d6\u6d88"

    new-instance v2, Lcn/com/smartdevices/bracelet/ui/bj;

    invoke-direct {v2, p0}, Lcn/com/smartdevices/bracelet/ui/bj;-><init>(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    return-void
.end method

.method private a(Landroid/view/View;)V
    .locals 2

    const v1, 0x7f070103

    const v0, 0x7f07002e

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->b:Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->b:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f070100

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    const v0, 0x7f070108

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->d:Landroid/view/View;

    const v0, 0x7f070105

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->e:Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->d:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->e:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f070107

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f070101

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    const v0, 0x7f070102

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    const v0, 0x7f0700fe

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->i:Landroid/widget/TextView;

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bh;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/bh;-><init>(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    const v0, 0x7f0700fc

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->f:Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->f:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;I)V
    .locals 1

    const/4 v0, 0x0

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->o:I

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;Landroid/app/ProgressDialog;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->n:Landroid/app/ProgressDialog;

    return-void
.end method

.method private b()V
    .locals 2

    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bk;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/bk;-><init>(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    return-void
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)V
    .locals 3

    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v1, "\u4e0a\u4f20\u8c03\u8bd5\u65e5\u5fd7"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    const-string v1, "\u8bf7\u786e\u4fdd\u662fwifi\u7f51\u7edc\u8fde\u63a5\uff0c\u5426\u5219\u4f1a\u8017\u8d39\u60a8\u7684\u6570\u636e\u6d41\u91cf\uff0c\u786e\u5b9a\u4e0a\u4f20\uff1f"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    const-string v1, "\u786e\u5b9a"

    new-instance v2, Lcn/com/smartdevices/bracelet/ui/bi;

    invoke-direct {v2, p0}, Lcn/com/smartdevices/bracelet/ui/bi;-><init>(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    const-string v1, "\u53d6\u6d88"

    new-instance v2, Lcn/com/smartdevices/bracelet/ui/bj;

    invoke-direct {v2, p0}, Lcn/com/smartdevices/bracelet/ui/bj;-><init>(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    return-void
.end method

.method private c()V
    .locals 10

    :try_start_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->p:Landroid/os/Handler;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->p:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    :cond_0
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyyMMddHHmmss"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    new-instance v3, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "/mili_log_"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, ".zip"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v3, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {v3}, Ljava/io/File;->delete()Z

    :cond_1
    const/16 v1, 0x1000

    new-array v4, v1, [B

    new-instance v1, Ljava/io/File;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v5, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v0, "/mili_log.txt"

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    new-instance v5, Ljava/io/FileInputStream;

    invoke-direct {v5, v1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v1}, Ljava/io/File;->length()J

    move-result-wide v0

    const-wide/32 v6, 0x3200000

    sub-long/2addr v0, v6

    :goto_0
    const-wide/16 v6, 0x0

    cmp-long v6, v0, v6

    if-gtz v6, :cond_3

    :cond_2
    new-instance v0, Ljava/util/zip/ZipEntry;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v6, "mili_log_"

    invoke-direct {v1, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ".txt"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/zip/ZipEntry;-><init>(Ljava/lang/String;)V

    new-instance v1, Ljava/io/FileOutputStream;

    invoke-direct {v1, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    new-instance v2, Ljava/util/zip/ZipOutputStream;

    invoke-direct {v2, v1}, Ljava/util/zip/ZipOutputStream;-><init>(Ljava/io/OutputStream;)V

    invoke-virtual {v2, v0}, Ljava/util/zip/ZipOutputStream;->putNextEntry(Ljava/util/zip/ZipEntry;)V

    :goto_1
    const/4 v0, 0x0

    array-length v1, v4

    invoke-virtual {v5, v4, v0, v1}, Ljava/io/FileInputStream;->read([BII)I

    move-result v0

    if-gtz v0, :cond_4

    invoke-virtual {v2}, Ljava/util/zip/ZipOutputStream;->closeEntry()V

    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V

    invoke-virtual {v2}, Ljava/util/zip/ZipOutputStream;->close()V

    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readLoginData()Lcn/com/smartdevices/bracelet/model/LoginData;

    move-result-object v0

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bl;

    invoke-direct {v1, p0, v3}, Lcn/com/smartdevices/bracelet/ui/bl;-><init>(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;Ljava/io/File;)V

    invoke-static {v0, v3, v1}, Lcn/com/smartdevices/bracelet/webapi/WebAPI;->uploadLogFileBlock(Lcn/com/smartdevices/bracelet/model/LoginData;Ljava/io/File;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    :goto_2
    return-void

    :cond_3
    invoke-virtual {v5, v0, v1}, Ljava/io/FileInputStream;->skip(J)J

    move-result-wide v6

    const-wide/16 v8, -0x1

    cmp-long v8, v6, v8

    if-eqz v8, :cond_2

    sub-long/2addr v0, v6

    goto :goto_0

    :cond_4
    const/4 v1, 0x0

    invoke-virtual {v2, v4, v1, v0}, Ljava/util/zip/ZipOutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_2
.end method

.method static synthetic c(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)V
    .locals 2

    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bk;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/bk;-><init>(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    return-void
.end method

.method private d()V
    .locals 3

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readFileDebugFlag()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/Debug;->enable(Z)V

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/Keeper;->keepDebugFlag(Z)V

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/Keeper;->keepFileDebugFlag(Z)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0c01b3

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    :goto_0
    return-void

    :cond_0
    invoke-static {v1}, Lcn/com/smartdevices/bracelet/Debug;->enable(Z)V

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/Keeper;->keepDebugFlag(Z)V

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/Keeper;->keepFileDebugFlag(Z)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0c01b2

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

.method static synthetic d(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)V
    .locals 10

    :try_start_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->p:Landroid/os/Handler;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->p:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    :cond_0
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyyMMddHHmmss"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    new-instance v3, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "/mili_log_"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, ".zip"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v3, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {v3}, Ljava/io/File;->delete()Z

    :cond_1
    const/16 v1, 0x1000

    new-array v4, v1, [B

    new-instance v1, Ljava/io/File;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v5, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v0, "/mili_log.txt"

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    new-instance v5, Ljava/io/FileInputStream;

    invoke-direct {v5, v1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v1}, Ljava/io/File;->length()J

    move-result-wide v0

    const-wide/32 v6, 0x3200000

    sub-long/2addr v0, v6

    :goto_0
    const-wide/16 v6, 0x0

    cmp-long v6, v0, v6

    if-gtz v6, :cond_3

    :cond_2
    new-instance v0, Ljava/util/zip/ZipEntry;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v6, "mili_log_"

    invoke-direct {v1, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ".txt"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/zip/ZipEntry;-><init>(Ljava/lang/String;)V

    new-instance v1, Ljava/io/FileOutputStream;

    invoke-direct {v1, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    new-instance v2, Ljava/util/zip/ZipOutputStream;

    invoke-direct {v2, v1}, Ljava/util/zip/ZipOutputStream;-><init>(Ljava/io/OutputStream;)V

    invoke-virtual {v2, v0}, Ljava/util/zip/ZipOutputStream;->putNextEntry(Ljava/util/zip/ZipEntry;)V

    :goto_1
    const/4 v0, 0x0

    array-length v1, v4

    invoke-virtual {v5, v4, v0, v1}, Ljava/io/FileInputStream;->read([BII)I

    move-result v0

    if-gtz v0, :cond_4

    invoke-virtual {v2}, Ljava/util/zip/ZipOutputStream;->closeEntry()V

    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V

    invoke-virtual {v2}, Ljava/util/zip/ZipOutputStream;->close()V

    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readLoginData()Lcn/com/smartdevices/bracelet/model/LoginData;

    move-result-object v0

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bl;

    invoke-direct {v1, p0, v3}, Lcn/com/smartdevices/bracelet/ui/bl;-><init>(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;Ljava/io/File;)V

    invoke-static {v0, v3, v1}, Lcn/com/smartdevices/bracelet/webapi/WebAPI;->uploadLogFileBlock(Lcn/com/smartdevices/bracelet/model/LoginData;Ljava/io/File;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    :goto_2
    return-void

    :cond_3
    invoke-virtual {v5, v0, v1}, Ljava/io/FileInputStream;->skip(J)J

    move-result-wide v6

    const-wide/16 v8, -0x1

    cmp-long v8, v6, v8

    if-eqz v8, :cond_2

    sub-long/2addr v0, v6

    goto :goto_0

    :cond_4
    const/4 v1, 0x0

    invoke-virtual {v2, v4, v1, v0}, Ljava/util/zip/ZipOutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_2
.end method

.method static synthetic e(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)Landroid/os/Handler;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->p:Landroid/os/Handler;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    const/4 v4, 0x4

    const/4 v3, 0x1

    const/4 v2, 0x0

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    :goto_0
    return-void

    :sswitch_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    goto :goto_0

    :sswitch_1
    const-string v0, "file:///android_asset/useragreement.html"

    const v1, 0x7f0c00d0

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/Utils;->gotoWeb(Ljava/lang/String;Ljava/lang/String;Landroid/app/Activity;)V

    goto :goto_0

    :sswitch_2
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "http://www.mi.com"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    :sswitch_3
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/Utils;->isNetworkConnected(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0, v3}, Lcn/com/smartdevices/bracelet/Utils;->checkApkUpgrade(Landroid/app/Activity;Z)V

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0c01bc

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    :sswitch_4
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-class v2, Lcn/com/smartdevices/bracelet/ui/SettingFeedbackActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    :sswitch_5
    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->o:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->o:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->o:I

    const/4 v1, 0x5

    if-ne v0, v1, :cond_1

    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readFileDebugFlag()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/Debug;->enable(Z)V

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/Keeper;->keepDebugFlag(Z)V

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/Keeper;->keepFileDebugFlag(Z)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0c01b3

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    :cond_1
    :goto_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->p:Landroid/os/Handler;

    invoke-virtual {v0, v4}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->p:Landroid/os/Handler;

    const-wide/16 v1, 0x12c

    invoke-virtual {v0, v4, v1, v2}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto/16 :goto_0

    :cond_2
    invoke-static {v3}, Lcn/com/smartdevices/bracelet/Debug;->enable(Z)V

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/Keeper;->keepDebugFlag(Z)V

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/Keeper;->keepFileDebugFlag(Z)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0c01b2

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_1

    :sswitch_data_0
    .sparse-switch
        0x7f07002e -> :sswitch_0
        0x7f0700fc -> :sswitch_5
        0x7f070103 -> :sswitch_4
        0x7f070105 -> :sswitch_2
        0x7f070107 -> :sswitch_3
        0x7f070108 -> :sswitch_1
    .end sparse-switch
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    const v2, 0x7f070103

    const v0, 0x7f03003c

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    const v0, 0x7f07002e

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->b:Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->b:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f070100

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    const v0, 0x7f070108

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->d:Landroid/view/View;

    const v0, 0x7f070105

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->e:Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->d:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->e:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f070107

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f070101

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    const v0, 0x7f070102

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    const v0, 0x7f0700fe

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->i:Landroid/widget/TextView;

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v2, Lcn/com/smartdevices/bracelet/ui/bh;

    invoke-direct {v2, p0}, Lcn/com/smartdevices/bracelet/ui/bh;-><init>(Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;)V

    invoke-virtual {v0, v2}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    const v0, 0x7f0700fc

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->f:Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->f:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-object v1
.end method

.method public onDestroy()V
    .locals 2

    const/4 v1, 0x0

    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->p:Landroid/os/Handler;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->p:Landroid/os/Handler;

    return-void
.end method

.method public onPause()V
    .locals 1

    invoke-super {p0}, Landroid/app/Fragment;->onPause()V

    const-string v0, "PageAbout"

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->endPage(Ljava/lang/String;)V

    return-void
.end method

.method public onResume()V
    .locals 3

    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    const-string v0, "SettingAboutActivity"

    const-string v1, "onResume() "

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    :try_start_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SettingAboutActivity$SettingAboutFragment;->i:Landroid/widget/TextView;

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    const-string v0, "PageAbout"

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->startPage(Ljava/lang/String;)V

    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0
.end method
