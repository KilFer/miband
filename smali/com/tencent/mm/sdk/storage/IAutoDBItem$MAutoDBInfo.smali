.class public Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;
.super Ljava/lang/Object;


# instance fields
.field public colsMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public columns:[Ljava/lang/String;

.field public fields:[Ljava/lang/reflect/Field;

.field public primaryKey:Ljava/lang/String;

.field public sql:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;->colsMap:Ljava/util/Map;

    return-void
.end method
