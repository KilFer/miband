.class final Lcn/com/smartdevices/bracelet/ui/ao;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;


# direct methods
.method private constructor <init>(Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;B)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/ui/ao;-><init>(Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;)V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    const-string v0, "DDDD"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Gif End : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->a(Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->a(Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->mTip:Landroid/widget/TextSwitcher;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    const v2, 0x7f0c0188

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextSwitcher;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->mGifView:Lcom/xiaomi/hm/view/GifView;

    const v1, 0x7f020079

    invoke-virtual {v0, v1}, Lcom/xiaomi/hm/view/GifView;->setGifImage(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    const/4 v1, 0x2

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->a(Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;I)V

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->mTip:Landroid/widget/TextSwitcher;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    const v2, 0x7f0c0189

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextSwitcher;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->mGifView:Lcom/xiaomi/hm/view/GifView;

    const v1, 0x7f02007a

    invoke-virtual {v0, v1}, Lcom/xiaomi/hm/view/GifView;->setGifImage(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    const/4 v1, 0x3

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->a(Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;I)V

    goto :goto_0

    :pswitch_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->mTip:Landroid/widget/TextSwitcher;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    const v2, 0x7f0c018a

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextSwitcher;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->mGifView:Lcom/xiaomi/hm/view/GifView;

    const v1, 0x7f02007b

    invoke-virtual {v0, v1}, Lcom/xiaomi/hm/view/GifView;->setGifImage(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    const/4 v1, 0x4

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->a(Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;I)V

    goto :goto_0

    :pswitch_3
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->mTip:Landroid/widget/TextSwitcher;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    const v2, 0x7f0c018b

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextSwitcher;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->mGifView:Lcom/xiaomi/hm/view/GifView;

    const v1, 0x7f02007c

    invoke-virtual {v0, v1}, Lcom/xiaomi/hm/view/GifView;->setGifImage(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    const/4 v1, 0x5

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->a(Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->mGifView:Lcom/xiaomi/hm/view/GifView;

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/ao;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    invoke-direct {v1, v2}, Lcn/com/smartdevices/bracelet/ui/ao;-><init>(Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;)V

    const-wide/16 v2, 0x7d0

    invoke-virtual {v0, v1, v2, v3}, Lcom/xiaomi/hm/view/GifView;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    :pswitch_4
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->mTip:Landroid/widget/TextSwitcher;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    const v2, 0x7f0c0187

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextSwitcher;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->mGifView:Lcom/xiaomi/hm/view/GifView;

    const v1, 0x7f020078

    invoke-virtual {v0, v1}, Lcom/xiaomi/hm/view/GifView;->setGifImage(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ao;->a:Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;->a(Lcn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2;I)V

    goto/16 :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method
