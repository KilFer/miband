.class public Lcom/hm/cheneehealth/wxapi/WXEntryActivity;
.super Landroid/app/Activity;

# interfaces
.implements Lcom/tencent/mm/sdk/openapi/IWXAPIEventHandler;


# static fields
.field private static final a:I = 0x21020001


# instance fields
.field private b:Landroid/widget/TextView;

.field private c:Lcom/tencent/mm/sdk/openapi/IWXAPI;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/hm/cheneehealth/wxapi/WXEntryActivity;)Lcom/tencent/mm/sdk/openapi/IWXAPI;
    .locals 1

    iget-object v0, p0, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->c:Lcom/tencent/mm/sdk/openapi/IWXAPI;

    return-object v0
.end method

.method private a(Lcom/tencent/mm/sdk/openapi/ShowMessageFromWX$Req;)V
    .locals 4

    const-string v0, "chenee"

    const-string v1, "goto show............... msg"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v1, p1, Lcom/tencent/mm/sdk/openapi/ShowMessageFromWX$Req;->message:Lcom/tencent/mm/sdk/openapi/WXMediaMessage;

    iget-object v0, v1, Lcom/tencent/mm/sdk/openapi/WXMediaMessage;->mediaObject:Lcom/tencent/mm/sdk/openapi/WXMediaMessage$IMediaObject;

    check-cast v0, Lcom/tencent/mm/sdk/openapi/WXAppExtendObject;

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "---extInfo(uid): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v3, v0, Lcom/tencent/mm/sdk/openapi/WXAppExtendObject;->extInfo:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v3, "---description: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v3, v1, Lcom/tencent/mm/sdk/openapi/WXMediaMessage;->description:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v3, "---filePath: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v0, v0, Lcom/tencent/mm/sdk/openapi/WXAppExtendObject;->filePath:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v0, p0, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->b:Landroid/widget/TextView;

    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v1, v1, Lcom/tencent/mm/sdk/openapi/WXMediaMessage;->title:Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v3, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "\n"

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    const v0, 0x7f03001b

    invoke-virtual {p0, v0}, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->setContentView(I)V

    const-string v0, "wx28e2610e92fbe111"

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lcom/tencent/mm/sdk/openapi/WXAPIFactory;->createWXAPI(Landroid/content/Context;Ljava/lang/String;Z)Lcom/tencent/mm/sdk/openapi/IWXAPI;

    move-result-object v0

    iput-object v0, p0, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->c:Lcom/tencent/mm/sdk/openapi/IWXAPI;

    const v0, 0x7f070099

    invoke-virtual {p0, v0}, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    new-instance v1, Lcom/hm/cheneehealth/wxapi/a;

    invoke-direct {v1, p0}, Lcom/hm/cheneehealth/wxapi/a;-><init>(Lcom/hm/cheneehealth/wxapi/WXEntryActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f07009a

    invoke-virtual {p0, v0}, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    new-instance v1, Lcom/hm/cheneehealth/wxapi/b;

    invoke-direct {v1, p0}, Lcom/hm/cheneehealth/wxapi/b;-><init>(Lcom/hm/cheneehealth/wxapi/WXEntryActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f070098

    invoke-virtual {p0, v0}, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->b:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->c:Lcom/tencent/mm/sdk/openapi/IWXAPI;

    invoke-virtual {p0}, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-interface {v0, v1, p0}, Lcom/tencent/mm/sdk/openapi/IWXAPI;->handleIntent(Landroid/content/Intent;Lcom/tencent/mm/sdk/openapi/IWXAPIEventHandler;)Z

    const-string v0, "chenee"

    const-string v1, "on create......"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 1

    invoke-super {p0, p1}, Landroid/app/Activity;->onNewIntent(Landroid/content/Intent;)V

    invoke-virtual {p0, p1}, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->setIntent(Landroid/content/Intent;)V

    iget-object v0, p0, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->c:Lcom/tencent/mm/sdk/openapi/IWXAPI;

    invoke-interface {v0, p1, p0}, Lcom/tencent/mm/sdk/openapi/IWXAPI;->handleIntent(Landroid/content/Intent;Lcom/tencent/mm/sdk/openapi/IWXAPIEventHandler;)Z

    return-void
.end method

.method public onReq(Lcom/tencent/mm/sdk/openapi/BaseReq;)V
    .locals 4

    invoke-virtual {p1}, Lcom/tencent/mm/sdk/openapi/BaseReq;->getType()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    const-string v0, "chenee"

    const-string v1, "never come here ??????"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    :pswitch_1
    check-cast p1, Lcom/tencent/mm/sdk/openapi/ShowMessageFromWX$Req;

    const-string v0, "chenee"

    const-string v1, "goto show............... msg"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v1, p1, Lcom/tencent/mm/sdk/openapi/ShowMessageFromWX$Req;->message:Lcom/tencent/mm/sdk/openapi/WXMediaMessage;

    iget-object v0, v1, Lcom/tencent/mm/sdk/openapi/WXMediaMessage;->mediaObject:Lcom/tencent/mm/sdk/openapi/WXMediaMessage$IMediaObject;

    check-cast v0, Lcom/tencent/mm/sdk/openapi/WXAppExtendObject;

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "---extInfo(uid): "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v3, v0, Lcom/tencent/mm/sdk/openapi/WXAppExtendObject;->extInfo:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v3, "---description: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v3, v1, Lcom/tencent/mm/sdk/openapi/WXMediaMessage;->description:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v3, "---filePath: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v0, v0, Lcom/tencent/mm/sdk/openapi/WXAppExtendObject;->filePath:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v0, p0, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->b:Landroid/widget/TextView;

    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v1, v1, Lcom/tencent/mm/sdk/openapi/WXMediaMessage;->title:Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v3, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "\n"

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onResp(Lcom/tencent/mm/sdk/openapi/BaseResp;)V
    .locals 4

    iget v0, p1, Lcom/tencent/mm/sdk/openapi/BaseResp;->errCode:I

    packed-switch v0, :pswitch_data_0

    :pswitch_0
    const-string v0, "\u53d1\u9001\u8fd4\u56de"

    :goto_0
    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    const-string v1, "chenee"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "onResp..............."

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {p0}, Lcom/hm/cheneehealth/wxapi/WXEntryActivity;->finish()V

    return-void

    :pswitch_1
    const-string v0, "\u53d1\u9001\u6210\u529f!"

    goto :goto_0

    :pswitch_2
    const-string v0, "\u53d1\u9001\u53d6\u6d88"

    goto :goto_0

    :pswitch_3
    const-string v0, "\u53d1\u9001\u88ab\u62d2\u7edd"

    goto :goto_0

    :pswitch_data_0
    .packed-switch -0x4
        :pswitch_3
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
