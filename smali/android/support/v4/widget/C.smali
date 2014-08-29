.class final Landroid/support/v4/widget/C;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/widget/SearchView$OnQueryTextListener;


# instance fields
.field private synthetic a:Landroid/support/v4/widget/t;


# direct methods
.method constructor <init>(Landroid/support/v4/widget/t;)V
    .locals 0

    iput-object p1, p0, Landroid/support/v4/widget/C;->a:Landroid/support/v4/widget/t;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onQueryTextChange(Ljava/lang/String;)Z
    .locals 1

    iget-object v0, p0, Landroid/support/v4/widget/C;->a:Landroid/support/v4/widget/t;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/t;->b(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public final onQueryTextSubmit(Ljava/lang/String;)Z
    .locals 1

    iget-object v0, p0, Landroid/support/v4/widget/C;->a:Landroid/support/v4/widget/t;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/t;->a(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
