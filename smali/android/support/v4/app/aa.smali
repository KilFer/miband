.class Landroid/support/v4/app/aa;
.super Landroid/support/v4/app/Y;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/app/Y;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/view/MenuItem;Landroid/support/v4/app/ShareCompat$IntentBuilder;)V
    .locals 5

    invoke-virtual {p2}, Landroid/support/v4/app/ShareCompat$IntentBuilder;->a()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {p2}, Landroid/support/v4/app/ShareCompat$IntentBuilder;->getIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-interface {p1}, Landroid/view/MenuItem;->getActionProvider()Landroid/view/ActionProvider;

    move-result-object v0

    instance-of v3, v0, Landroid/widget/ShareActionProvider;

    if-nez v3, :cond_1

    new-instance v0, Landroid/widget/ShareActionProvider;

    invoke-direct {v0, v1}, Landroid/widget/ShareActionProvider;-><init>(Landroid/content/Context;)V

    :goto_0
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, ".sharecompat_"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ShareActionProvider;->setShareHistoryFileName(Ljava/lang/String;)V

    invoke-virtual {v0, v2}, Landroid/widget/ShareActionProvider;->setShareIntent(Landroid/content/Intent;)V

    invoke-interface {p1, v0}, Landroid/view/MenuItem;->setActionProvider(Landroid/view/ActionProvider;)Landroid/view/MenuItem;

    invoke-virtual {p0, p1}, Landroid/support/v4/app/aa;->a(Landroid/view/MenuItem;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p2}, Landroid/support/v4/app/ShareCompat$IntentBuilder;->createChooserIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/view/MenuItem;->setIntent(Landroid/content/Intent;)Landroid/view/MenuItem;

    :cond_0
    return-void

    :cond_1
    check-cast v0, Landroid/widget/ShareActionProvider;

    goto :goto_0
.end method

.method a(Landroid/view/MenuItem;)Z
    .locals 1

    invoke-interface {p1}, Landroid/view/MenuItem;->hasSubMenu()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
