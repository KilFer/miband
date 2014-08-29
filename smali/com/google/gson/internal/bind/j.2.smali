.class abstract Lcom/google/gson/internal/bind/j;
.super Ljava/lang/Object;


# instance fields
.field final a:Ljava/lang/String;

.field final b:Z

.field final c:Z


# direct methods
.method protected constructor <init>(Ljava/lang/String;ZZ)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/gson/internal/bind/j;->a:Ljava/lang/String;

    iput-boolean p2, p0, Lcom/google/gson/internal/bind/j;->b:Z

    iput-boolean p3, p0, Lcom/google/gson/internal/bind/j;->c:Z

    return-void
.end method


# virtual methods
.method abstract a(Lcom/google/gson/stream/JsonReader;Ljava/lang/Object;)V
.end method

.method abstract a(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
.end method
