.class final Lorg/achartengine/a;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lorg/achartengine/GraphicalView;


# direct methods
.method constructor <init>(Lorg/achartengine/GraphicalView;)V
    .locals 0

    iput-object p1, p0, Lorg/achartengine/a;->a:Lorg/achartengine/GraphicalView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    iget-object v0, p0, Lorg/achartengine/a;->a:Lorg/achartengine/GraphicalView;

    invoke-virtual {v0}, Lorg/achartengine/GraphicalView;->invalidate()V

    return-void
.end method
