.class final Lcom/tencent/a/a/k;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Ljava/io/File;",
        ">;"
    }
.end annotation


# instance fields
.field private synthetic a:Lcom/tencent/a/a/h;


# direct methods
.method constructor <init>(Lcom/tencent/a/a/h;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static a(Ljava/io/File;Ljava/io/File;)I
    .locals 2

    invoke-static {p0}, Lcom/tencent/a/a/h;->d(Ljava/io/File;)I

    move-result v0

    invoke-static {p1}, Lcom/tencent/a/a/h;->d(Ljava/io/File;)I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method


# virtual methods
.method public final synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 2

    check-cast p1, Ljava/io/File;

    check-cast p2, Ljava/io/File;

    invoke-static {p1}, Lcom/tencent/a/a/h;->d(Ljava/io/File;)I

    move-result v0

    invoke-static {p2}, Lcom/tencent/a/a/h;->d(Ljava/io/File;)I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method
