.class final Landroid/support/v4/media/a;
.super Ljava/lang/Object;


# instance fields
.field private synthetic a:Landroid/support/v4/media/TransportMediator;


# direct methods
.method constructor <init>(Landroid/support/v4/media/TransportMediator;)V
    .locals 0

    iput-object p1, p0, Landroid/support/v4/media/c;->a:Landroid/support/v4/media/TransportMediator;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()J
    .locals 2

    iget-object v0, p0, Landroid/support/v4/media/c;->a:Landroid/support/v4/media/TransportMediator;

    iget-object v0, v0, Landroid/support/v4/media/TransportMediator;->a:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0}, Landroid/support/v4/media/TransportPerformer;->onGetCurrentPosition()J

    move-result-wide v0

    return-wide v0
.end method

.method public final a(I)V
    .locals 1

    iget-object v0, p0, Landroid/support/v4/media/c;->a:Landroid/support/v4/media/TransportMediator;

    iget-object v0, v0, Landroid/support/v4/media/TransportMediator;->a:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0, p1}, Landroid/support/v4/media/TransportPerformer;->onAudioFocusChange(I)V

    return-void
.end method

.method public final a(J)V
    .locals 1

    iget-object v0, p0, Landroid/support/v4/media/c;->a:Landroid/support/v4/media/TransportMediator;

    iget-object v0, v0, Landroid/support/v4/media/TransportMediator;->a:Landroid/support/v4/media/TransportPerformer;

    invoke-virtual {v0, p1, p2}, Landroid/support/v4/media/TransportPerformer;->onSeekTo(J)V

    return-void
.end method

.method public final a(Landroid/view/KeyEvent;)V
    .locals 1

    iget-object v0, p0, Landroid/support/v4/media/c;->a:Landroid/support/v4/media/TransportMediator;

    iget-object v0, v0, Landroid/support/v4/media/TransportMediator;->b:Landroid/view/KeyEvent$Callback;

    invoke-virtual {p1, v0}, Landroid/view/KeyEvent;->dispatch(Landroid/view/KeyEvent$Callback;)Z

    return-void
.end method
