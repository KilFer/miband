.class public Lcom/sina/weibo/sdk/api/share/ProvideMultiMessageForWeiboResponse;
.super Lcom/sina/weibo/sdk/api/share/BaseResponse;


# instance fields
.field public multiMessage:Lcom/sina/weibo/sdk/api/WeiboMultiMessage;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/sina/weibo/sdk/api/share/BaseResponse;-><init>()V

    return-void
.end method

.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 0

    invoke-direct {p0}, Lcom/sina/weibo/sdk/api/share/BaseResponse;-><init>()V

    invoke-virtual {p0, p1}, Lcom/sina/weibo/sdk/api/share/ProvideMultiMessageForWeiboResponse;->fromBundle(Landroid/os/Bundle;)V

    return-void
.end method


# virtual methods
.method final check(Landroid/content/Context;Lcom/sina/weibo/sdk/api/share/VersionCheckHandler;)Z
    .locals 2

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/sina/weibo/sdk/api/share/ProvideMultiMessageForWeiboResponse;->multiMessage:Lcom/sina/weibo/sdk/api/WeiboMultiMessage;

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    if-eqz p2, :cond_2

    iget-object v1, p0, Lcom/sina/weibo/sdk/api/share/ProvideMultiMessageForWeiboResponse;->reqPackageName:Ljava/lang/String;

    invoke-virtual {p2, v1}, Lcom/sina/weibo/sdk/api/share/VersionCheckHandler;->setPackageName(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/sina/weibo/sdk/api/share/ProvideMultiMessageForWeiboResponse;->multiMessage:Lcom/sina/weibo/sdk/api/WeiboMultiMessage;

    invoke-virtual {p2, p1, v1}, Lcom/sina/weibo/sdk/api/share/VersionCheckHandler;->check(Landroid/content/Context;Lcom/sina/weibo/sdk/api/WeiboMultiMessage;)Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_2
    iget-object v0, p0, Lcom/sina/weibo/sdk/api/share/ProvideMultiMessageForWeiboResponse;->multiMessage:Lcom/sina/weibo/sdk/api/WeiboMultiMessage;

    invoke-virtual {v0}, Lcom/sina/weibo/sdk/api/WeiboMultiMessage;->checkArgs()Z

    move-result v0

    goto :goto_0
.end method

.method public fromBundle(Landroid/os/Bundle;)V
    .locals 1

    invoke-super {p0, p1}, Lcom/sina/weibo/sdk/api/share/BaseResponse;->fromBundle(Landroid/os/Bundle;)V

    new-instance v0, Lcom/sina/weibo/sdk/api/WeiboMultiMessage;

    invoke-direct {v0, p1}, Lcom/sina/weibo/sdk/api/WeiboMultiMessage;-><init>(Landroid/os/Bundle;)V

    iput-object v0, p0, Lcom/sina/weibo/sdk/api/share/ProvideMultiMessageForWeiboResponse;->multiMessage:Lcom/sina/weibo/sdk/api/WeiboMultiMessage;

    return-void
.end method

.method public getType()I
    .locals 1

    const/4 v0, 0x2

    return v0
.end method

.method public toBundle(Landroid/os/Bundle;)V
    .locals 1

    invoke-super {p0, p1}, Lcom/sina/weibo/sdk/api/share/BaseResponse;->toBundle(Landroid/os/Bundle;)V

    iget-object v0, p0, Lcom/sina/weibo/sdk/api/share/ProvideMultiMessageForWeiboResponse;->multiMessage:Lcom/sina/weibo/sdk/api/WeiboMultiMessage;

    invoke-virtual {v0, p1}, Lcom/sina/weibo/sdk/api/WeiboMultiMessage;->toBundle(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    return-void
.end method
