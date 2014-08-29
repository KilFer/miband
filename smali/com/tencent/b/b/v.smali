.class public final Lcom/tencent/b/b/v;
.super Ljava/lang/Object;


# static fields
.field private static b:Lcom/tencent/b/b/v;


# instance fields
.field private a:I


# direct methods
.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a()Lcom/tencent/b/b/v;
    .locals 1

    sget-object v0, Lcom/tencent/b/b/v;->b:Lcom/tencent/b/b/v;

    if-nez v0, :cond_0

    new-instance v0, Lcom/tencent/b/b/v;

    invoke-direct {v0}, Lcom/tencent/b/b/v;-><init>()V

    sput-object v0, Lcom/tencent/b/b/v;->b:Lcom/tencent/b/b/v;

    :cond_0
    sget-object v0, Lcom/tencent/b/b/v;->b:Lcom/tencent/b/b/v;

    return-object v0
.end method
