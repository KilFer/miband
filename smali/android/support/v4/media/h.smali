.class final Landroid/support/v4/media/h;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/media/AudioManager$OnAudioFocusChangeListener;


# instance fields
.field private synthetic a:Landroid/support/v4/media/d;


# direct methods
.method constructor <init>(Landroid/support/v4/media/d;)V
    .locals 0

    iput-object p1, p0, Landroid/support/v4/media/h;->a:Landroid/support/v4/media/d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAudioFocusChange(I)V
    .locals 1

    iget-object v0, p0, Landroid/support/v4/media/h;->a:Landroid/support/v4/media/d;

    iget-object v0, v0, Landroid/support/v4/media/d;->a:Landroid/support/v4/media/c;

    invoke-virtual {v0, p1}, Landroid/support/v4/media/c;->b(I)V

    return-void
.end method
