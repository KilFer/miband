.class final Landroid/support/v4/app/l;
.super Landroid/support/v4/app/FragmentTransaction;

# interfaces
.implements Landroid/support/v4/app/FragmentManager$BackStackEntry;
.implements Ljava/lang/Runnable;


# static fields
.field private static l:Ljava/lang/String; = "FragmentManager"

.field private static n:I = 0x0

.field private static o:I = 0x1

.field private static p:I = 0x2

.field private static q:I = 0x3

.field private static r:I = 0x4

.field private static s:I = 0x5

.field private static t:I = 0x6

.field private static u:I = 0x7


# instance fields
.field private A:Z

.field private B:Z

.field a:Landroid/support/v4/app/m;

.field b:I

.field c:I

.field d:I

.field e:Z

.field f:Ljava/lang/String;

.field g:I

.field h:I

.field i:Ljava/lang/CharSequence;

.field j:I

.field k:Ljava/lang/CharSequence;

.field private m:Landroid/support/v4/app/v;

.field private v:Landroid/support/v4/app/m;

.field private w:I

.field private x:I

.field private y:I

.field private z:I


# direct methods
.method public constructor <init>(Landroid/support/v4/app/v;)V
    .locals 1

    invoke-direct {p0}, Landroid/support/v4/app/FragmentTransaction;-><init>()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/l;->A:Z

    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v4/app/l;->g:I

    iput-object p1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    return-void
.end method

.method private a()I
    .locals 1

    iget v0, p0, Landroid/support/v4/app/l;->c:I

    return v0
.end method

.method private a(ILandroid/support/v4/app/Fragment;Ljava/lang/String;I)V
    .locals 3

    iget-object v0, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iput-object v0, p2, Landroid/support/v4/app/Fragment;->s:Landroid/support/v4/app/v;

    if-eqz p3, :cond_1

    iget-object v0, p2, Landroid/support/v4/app/Fragment;->y:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p2, Landroid/support/v4/app/Fragment;->y:Ljava/lang/String;

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Can\'t change tag of fragment "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ": was "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p2, Landroid/support/v4/app/Fragment;->y:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " now "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p3, p2, Landroid/support/v4/app/Fragment;->y:Ljava/lang/String;

    :cond_1
    if-eqz p1, :cond_3

    iget v0, p2, Landroid/support/v4/app/Fragment;->w:I

    if-eqz v0, :cond_2

    iget v0, p2, Landroid/support/v4/app/Fragment;->w:I

    if-eq v0, p1, :cond_2

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Can\'t change container ID of fragment "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ": was "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p2, Landroid/support/v4/app/Fragment;->w:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " now "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    iput p1, p2, Landroid/support/v4/app/Fragment;->w:I

    iput p1, p2, Landroid/support/v4/app/Fragment;->x:I

    :cond_3
    new-instance v0, Landroid/support/v4/app/m;

    invoke-direct {v0}, Landroid/support/v4/app/m;-><init>()V

    iput p4, v0, Landroid/support/v4/app/m;->c:I

    iput-object p2, v0, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    invoke-virtual {p0, v0}, Landroid/support/v4/app/l;->a(Landroid/support/v4/app/m;)V

    return-void
.end method

.method private b()I
    .locals 1

    iget v0, p0, Landroid/support/v4/app/l;->d:I

    return v0
.end method

.method private b(Z)I
    .locals 3

    iget-boolean v0, p0, Landroid/support/v4/app/l;->B:Z

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "commit already called"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    sget-boolean v0, Landroid/support/v4/app/v;->a:Z

    if-eqz v0, :cond_1

    const-string v0, "FragmentManager"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Commit: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v0, Landroid/support/v4/util/LogWriter;

    const-string v1, "FragmentManager"

    invoke-direct {v0, v1}, Landroid/support/v4/util/LogWriter;-><init>(Ljava/lang/String;)V

    new-instance v1, Ljava/io/PrintWriter;

    invoke-direct {v1, v0}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    const-string v0, "  "

    invoke-virtual {p0, v0, v1}, Landroid/support/v4/app/l;->a(Ljava/lang/String;Ljava/io/PrintWriter;)V

    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/l;->B:Z

    iget-boolean v0, p0, Landroid/support/v4/app/l;->e:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    invoke-virtual {v0, p0}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/l;)I

    move-result v0

    iput v0, p0, Landroid/support/v4/app/l;->g:I

    :goto_0
    iget-object v0, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/app/v;->a(Ljava/lang/Runnable;Z)V

    iget v0, p0, Landroid/support/v4/app/l;->g:I

    return v0

    :cond_2
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v4/app/l;->g:I

    goto :goto_0
.end method


# virtual methods
.method final a(I)V
    .locals 6

    iget-boolean v0, p0, Landroid/support/v4/app/l;->e:Z

    if-nez v0, :cond_1

    :cond_0
    return-void

    :cond_1
    sget-boolean v0, Landroid/support/v4/app/v;->a:Z

    if-eqz v0, :cond_2

    const-string v0, "FragmentManager"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Bump nesting in "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " by "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_2
    iget-object v0, p0, Landroid/support/v4/app/l;->a:Landroid/support/v4/app/m;

    move-object v2, v0

    :goto_0
    if-eqz v2, :cond_0

    iget-object v0, v2, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    if-eqz v0, :cond_3

    iget-object v0, v2, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v1, v0, Landroid/support/v4/app/Fragment;->r:I

    add-int/2addr v1, p1

    iput v1, v0, Landroid/support/v4/app/Fragment;->r:I

    sget-boolean v0, Landroid/support/v4/app/v;->a:Z

    if-eqz v0, :cond_3

    const-string v0, "FragmentManager"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "Bump nesting of "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, v2, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " to "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, v2, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v3, v3, Landroid/support/v4/app/Fragment;->r:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_3
    iget-object v0, v2, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    if-eqz v0, :cond_5

    iget-object v0, v2, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    move v1, v0

    :goto_1
    if-ltz v1, :cond_5

    iget-object v0, v2, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    iget v3, v0, Landroid/support/v4/app/Fragment;->r:I

    add-int/2addr v3, p1

    iput v3, v0, Landroid/support/v4/app/Fragment;->r:I

    sget-boolean v3, Landroid/support/v4/app/v;->a:Z

    if-eqz v3, :cond_4

    const-string v3, "FragmentManager"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Bump nesting of "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " to "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget v0, v0, Landroid/support/v4/app/Fragment;->r:I

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_4
    add-int/lit8 v0, v1, -0x1

    move v1, v0

    goto :goto_1

    :cond_5
    iget-object v0, v2, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/m;

    move-object v2, v0

    goto :goto_0
.end method

.method final a(Landroid/support/v4/app/m;)V
    .locals 1

    iget-object v0, p0, Landroid/support/v4/app/l;->a:Landroid/support/v4/app/m;

    if-nez v0, :cond_0

    iput-object p1, p0, Landroid/support/v4/app/l;->v:Landroid/support/v4/app/m;

    iput-object p1, p0, Landroid/support/v4/app/l;->a:Landroid/support/v4/app/m;

    :goto_0
    iget v0, p0, Landroid/support/v4/app/l;->w:I

    iput v0, p1, Landroid/support/v4/app/m;->e:I

    iget v0, p0, Landroid/support/v4/app/l;->x:I

    iput v0, p1, Landroid/support/v4/app/m;->f:I

    iget v0, p0, Landroid/support/v4/app/l;->y:I

    iput v0, p1, Landroid/support/v4/app/m;->g:I

    iget v0, p0, Landroid/support/v4/app/l;->z:I

    iput v0, p1, Landroid/support/v4/app/m;->h:I

    iget v0, p0, Landroid/support/v4/app/l;->b:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroid/support/v4/app/l;->b:I

    return-void

    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/l;->v:Landroid/support/v4/app/m;

    iput-object v0, p1, Landroid/support/v4/app/m;->b:Landroid/support/v4/app/m;

    iget-object v0, p0, Landroid/support/v4/app/l;->v:Landroid/support/v4/app/m;

    iput-object p1, v0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/m;

    iput-object p1, p0, Landroid/support/v4/app/l;->v:Landroid/support/v4/app/m;

    goto :goto_0
.end method

.method public final a(Ljava/lang/String;Ljava/io/PrintWriter;)V
    .locals 1

    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, v0}, Landroid/support/v4/app/l;->a(Ljava/lang/String;Ljava/io/PrintWriter;Z)V

    return-void
.end method

.method public final a(Ljava/lang/String;Ljava/io/PrintWriter;Z)V
    .locals 7

    const/4 v1, 0x0

    if-eqz p3, :cond_8

    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mName="

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/support/v4/app/l;->f:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, " mIndex="

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/l;->g:I

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(I)V

    const-string v0, " mCommitted="

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/support/v4/app/l;->B:Z

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Z)V

    iget v0, p0, Landroid/support/v4/app/l;->c:I

    if-eqz v0, :cond_0

    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mTransition=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/l;->c:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, " mTransitionStyle=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/l;->d:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    :cond_0
    iget v0, p0, Landroid/support/v4/app/l;->w:I

    if-nez v0, :cond_1

    iget v0, p0, Landroid/support/v4/app/l;->x:I

    if-eqz v0, :cond_2

    :cond_1
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mEnterAnim=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/l;->w:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, " mExitAnim=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/l;->x:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    :cond_2
    iget v0, p0, Landroid/support/v4/app/l;->y:I

    if-nez v0, :cond_3

    iget v0, p0, Landroid/support/v4/app/l;->z:I

    if-eqz v0, :cond_4

    :cond_3
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mPopEnterAnim=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/l;->y:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, " mPopExitAnim=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/l;->z:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    :cond_4
    iget v0, p0, Landroid/support/v4/app/l;->h:I

    if-nez v0, :cond_5

    iget-object v0, p0, Landroid/support/v4/app/l;->i:Ljava/lang/CharSequence;

    if-eqz v0, :cond_6

    :cond_5
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mBreadCrumbTitleRes=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/l;->h:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, " mBreadCrumbTitleText="

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/support/v4/app/l;->i:Ljava/lang/CharSequence;

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    :cond_6
    iget v0, p0, Landroid/support/v4/app/l;->j:I

    if-nez v0, :cond_7

    iget-object v0, p0, Landroid/support/v4/app/l;->k:Ljava/lang/CharSequence;

    if-eqz v0, :cond_8

    :cond_7
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mBreadCrumbShortTitleRes=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/l;->j:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, " mBreadCrumbShortTitleText="

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/support/v4/app/l;->k:Ljava/lang/CharSequence;

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    :cond_8
    iget-object v0, p0, Landroid/support/v4/app/l;->a:Landroid/support/v4/app/m;

    if-eqz v0, :cond_10

    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "Operations:"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "    "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iget-object v0, p0, Landroid/support/v4/app/l;->a:Landroid/support/v4/app/m;

    move v2, v1

    move-object v3, v0

    :goto_0
    if-eqz v3, :cond_10

    iget v0, v3, Landroid/support/v4/app/m;->c:I

    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v5, "cmd="

    invoke-direct {v0, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v5, v3, Landroid/support/v4/app/m;->c:I

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_1
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v5, "  Op #"

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    invoke-virtual {p2, v2}, Ljava/io/PrintWriter;->print(I)V

    const-string v5, ": "

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, " "

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, v3, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    if-eqz p3, :cond_c

    iget v0, v3, Landroid/support/v4/app/m;->e:I

    if-nez v0, :cond_9

    iget v0, v3, Landroid/support/v4/app/m;->f:I

    if-eqz v0, :cond_a

    :cond_9
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "enterAnim=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, v3, Landroid/support/v4/app/m;->e:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, " exitAnim=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, v3, Landroid/support/v4/app/m;->f:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    :cond_a
    iget v0, v3, Landroid/support/v4/app/m;->g:I

    if-nez v0, :cond_b

    iget v0, v3, Landroid/support/v4/app/m;->h:I

    if-eqz v0, :cond_c

    :cond_b
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "popEnterAnim=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, v3, Landroid/support/v4/app/m;->g:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, " popExitAnim=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, v3, Landroid/support/v4/app/m;->h:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    :cond_c
    iget-object v0, v3, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    if-eqz v0, :cond_f

    iget-object v0, v3, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_f

    move v0, v1

    :goto_2
    iget-object v5, v3, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-ge v0, v5, :cond_f

    invoke-virtual {p2, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v5, v3, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_d

    const-string v5, "Removed: "

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    :goto_3
    iget-object v5, v3, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :pswitch_0
    const-string v0, "NULL"

    goto/16 :goto_1

    :pswitch_1
    const-string v0, "ADD"

    goto/16 :goto_1

    :pswitch_2
    const-string v0, "REPLACE"

    goto/16 :goto_1

    :pswitch_3
    const-string v0, "REMOVE"

    goto/16 :goto_1

    :pswitch_4
    const-string v0, "HIDE"

    goto/16 :goto_1

    :pswitch_5
    const-string v0, "SHOW"

    goto/16 :goto_1

    :pswitch_6
    const-string v0, "DETACH"

    goto/16 :goto_1

    :pswitch_7
    const-string v0, "ATTACH"

    goto/16 :goto_1

    :cond_d
    if-nez v0, :cond_e

    const-string v5, "Removed:"

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    :cond_e
    invoke-virtual {p2, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v5, "  #"

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(I)V

    const-string v5, ": "

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    goto :goto_3

    :cond_f
    iget-object v3, v3, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/m;

    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto/16 :goto_0

    :cond_10
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public final a(Z)V
    .locals 7

    const/4 v6, -0x1

    const/4 v2, 0x0

    sget-boolean v0, Landroid/support/v4/app/v;->a:Z

    if-eqz v0, :cond_0

    const-string v0, "FragmentManager"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "popFromBackStack: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v0, Landroid/support/v4/util/LogWriter;

    const-string v1, "FragmentManager"

    invoke-direct {v0, v1}, Landroid/support/v4/util/LogWriter;-><init>(Ljava/lang/String;)V

    new-instance v1, Ljava/io/PrintWriter;

    invoke-direct {v1, v0}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    const-string v0, "  "

    invoke-virtual {p0, v0, v1}, Landroid/support/v4/app/l;->a(Ljava/lang/String;Ljava/io/PrintWriter;)V

    :cond_0
    invoke-virtual {p0, v6}, Landroid/support/v4/app/l;->a(I)V

    iget-object v0, p0, Landroid/support/v4/app/l;->v:Landroid/support/v4/app/m;

    move-object v3, v0

    :goto_0
    if-eqz v3, :cond_3

    iget v0, v3, Landroid/support/v4/app/m;->c:I

    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unknown cmd: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, v3, Landroid/support/v4/app/m;->c:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    iget-object v0, v3, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v1, v3, Landroid/support/v4/app/m;->h:I

    iput v1, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v4, p0, Landroid/support/v4/app/l;->c:I

    invoke-static {v4}, Landroid/support/v4/app/v;->b(I)I

    move-result v4

    iget v5, p0, Landroid/support/v4/app/l;->d:I

    invoke-virtual {v1, v0, v4, v5}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/Fragment;II)V

    :cond_1
    :goto_1
    iget-object v0, v3, Landroid/support/v4/app/m;->b:Landroid/support/v4/app/m;

    move-object v3, v0

    goto :goto_0

    :pswitch_1
    iget-object v0, v3, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    if-eqz v0, :cond_2

    iget v1, v3, Landroid/support/v4/app/m;->h:I

    iput v1, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v4, p0, Landroid/support/v4/app/l;->c:I

    invoke-static {v4}, Landroid/support/v4/app/v;->b(I)I

    move-result v4

    iget v5, p0, Landroid/support/v4/app/l;->d:I

    invoke-virtual {v1, v0, v4, v5}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/Fragment;II)V

    :cond_2
    iget-object v0, v3, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    move v1, v2

    :goto_2
    iget-object v0, v3, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    iget-object v0, v3, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    iget v4, v3, Landroid/support/v4/app/m;->g:I

    iput v4, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v4, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    invoke-virtual {v4, v0, v2}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/Fragment;Z)V

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_2

    :pswitch_2
    iget-object v0, v3, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v1, v3, Landroid/support/v4/app/m;->g:I

    iput v1, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    invoke-virtual {v1, v0, v2}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_1

    :pswitch_3
    iget-object v0, v3, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v1, v3, Landroid/support/v4/app/m;->g:I

    iput v1, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v4, p0, Landroid/support/v4/app/l;->c:I

    invoke-static {v4}, Landroid/support/v4/app/v;->b(I)I

    move-result v4

    iget v5, p0, Landroid/support/v4/app/l;->d:I

    invoke-virtual {v1, v0, v4, v5}, Landroid/support/v4/app/v;->c(Landroid/support/v4/app/Fragment;II)V

    goto :goto_1

    :pswitch_4
    iget-object v0, v3, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v1, v3, Landroid/support/v4/app/m;->h:I

    iput v1, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v4, p0, Landroid/support/v4/app/l;->c:I

    invoke-static {v4}, Landroid/support/v4/app/v;->b(I)I

    move-result v4

    iget v5, p0, Landroid/support/v4/app/l;->d:I

    invoke-virtual {v1, v0, v4, v5}, Landroid/support/v4/app/v;->b(Landroid/support/v4/app/Fragment;II)V

    goto :goto_1

    :pswitch_5
    iget-object v0, v3, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v1, v3, Landroid/support/v4/app/m;->g:I

    iput v1, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v4, p0, Landroid/support/v4/app/l;->c:I

    invoke-static {v4}, Landroid/support/v4/app/v;->b(I)I

    move-result v4

    iget v5, p0, Landroid/support/v4/app/l;->d:I

    invoke-virtual {v1, v0, v4, v5}, Landroid/support/v4/app/v;->e(Landroid/support/v4/app/Fragment;II)V

    goto/16 :goto_1

    :pswitch_6
    iget-object v0, v3, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v1, v3, Landroid/support/v4/app/m;->g:I

    iput v1, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v4, p0, Landroid/support/v4/app/l;->c:I

    invoke-static {v4}, Landroid/support/v4/app/v;->b(I)I

    move-result v4

    iget v5, p0, Landroid/support/v4/app/l;->d:I

    invoke-virtual {v1, v0, v4, v5}, Landroid/support/v4/app/v;->d(Landroid/support/v4/app/Fragment;II)V

    goto/16 :goto_1

    :cond_3
    if-eqz p1, :cond_4

    iget-object v0, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v1, v1, Landroid/support/v4/app/v;->d:I

    iget v2, p0, Landroid/support/v4/app/l;->c:I

    invoke-static {v2}, Landroid/support/v4/app/v;->b(I)I

    move-result v2

    iget v3, p0, Landroid/support/v4/app/l;->d:I

    const/4 v4, 0x1

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/support/v4/app/v;->a(IIIZ)V

    :cond_4
    iget v0, p0, Landroid/support/v4/app/l;->g:I

    if-ltz v0, :cond_5

    iget-object v0, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v1, p0, Landroid/support/v4/app/l;->g:I

    invoke-virtual {v0, v1}, Landroid/support/v4/app/v;->a(I)V

    iput v6, p0, Landroid/support/v4/app/l;->g:I

    :cond_5
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method public final add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    .locals 2

    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct {p0, p1, p2, v0, v1}, Landroid/support/v4/app/l;->a(ILandroid/support/v4/app/Fragment;Ljava/lang/String;I)V

    return-object p0
.end method

.method public final add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;
    .locals 1

    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, p3, v0}, Landroid/support/v4/app/l;->a(ILandroid/support/v4/app/Fragment;Ljava/lang/String;I)V

    return-object p0
.end method

.method public final add(Landroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;
    .locals 2

    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct {p0, v0, p1, p2, v1}, Landroid/support/v4/app/l;->a(ILandroid/support/v4/app/Fragment;Ljava/lang/String;I)V

    return-object p0
.end method

.method public final addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;
    .locals 2

    iget-boolean v0, p0, Landroid/support/v4/app/l;->A:Z

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "This FragmentTransaction is not allowed to be added to the back stack."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/l;->e:Z

    iput-object p1, p0, Landroid/support/v4/app/l;->f:Ljava/lang/String;

    return-object p0
.end method

.method public final attach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    .locals 2

    new-instance v0, Landroid/support/v4/app/m;

    invoke-direct {v0}, Landroid/support/v4/app/m;-><init>()V

    const/4 v1, 0x7

    iput v1, v0, Landroid/support/v4/app/m;->c:I

    iput-object p1, v0, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    invoke-virtual {p0, v0}, Landroid/support/v4/app/l;->a(Landroid/support/v4/app/m;)V

    return-object p0
.end method

.method public final commit()I
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/support/v4/app/l;->b(Z)I

    move-result v0

    return v0
.end method

.method public final commitAllowingStateLoss()I
    .locals 1

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroid/support/v4/app/l;->b(Z)I

    move-result v0

    return v0
.end method

.method public final detach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    .locals 2

    new-instance v0, Landroid/support/v4/app/m;

    invoke-direct {v0}, Landroid/support/v4/app/m;-><init>()V

    const/4 v1, 0x6

    iput v1, v0, Landroid/support/v4/app/m;->c:I

    iput-object p1, v0, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    invoke-virtual {p0, v0}, Landroid/support/v4/app/l;->a(Landroid/support/v4/app/m;)V

    return-object p0
.end method

.method public final disallowAddToBackStack()Landroid/support/v4/app/FragmentTransaction;
    .locals 2

    iget-boolean v0, p0, Landroid/support/v4/app/l;->e:Z

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "This transaction is already being added to the back stack"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/app/l;->A:Z

    return-object p0
.end method

.method public final getBreadCrumbShortTitle()Ljava/lang/CharSequence;
    .locals 2

    iget v0, p0, Landroid/support/v4/app/l;->j:I

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget-object v0, v0, Landroid/support/v4/app/v;->e:Landroid/support/v4/app/FragmentActivity;

    iget v1, p0, Landroid/support/v4/app/l;->j:I

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/l;->k:Ljava/lang/CharSequence;

    goto :goto_0
.end method

.method public final getBreadCrumbShortTitleRes()I
    .locals 1

    iget v0, p0, Landroid/support/v4/app/l;->j:I

    return v0
.end method

.method public final getBreadCrumbTitle()Ljava/lang/CharSequence;
    .locals 2

    iget v0, p0, Landroid/support/v4/app/l;->h:I

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget-object v0, v0, Landroid/support/v4/app/v;->e:Landroid/support/v4/app/FragmentActivity;

    iget v1, p0, Landroid/support/v4/app/l;->h:I

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/l;->i:Ljava/lang/CharSequence;

    goto :goto_0
.end method

.method public final getBreadCrumbTitleRes()I
    .locals 1

    iget v0, p0, Landroid/support/v4/app/l;->h:I

    return v0
.end method

.method public final getId()I
    .locals 1

    iget v0, p0, Landroid/support/v4/app/l;->g:I

    return v0
.end method

.method public final getName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Landroid/support/v4/app/l;->f:Ljava/lang/String;

    return-object v0
.end method

.method public final hide(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    .locals 2

    new-instance v0, Landroid/support/v4/app/m;

    invoke-direct {v0}, Landroid/support/v4/app/m;-><init>()V

    const/4 v1, 0x4

    iput v1, v0, Landroid/support/v4/app/m;->c:I

    iput-object p1, v0, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    invoke-virtual {p0, v0}, Landroid/support/v4/app/l;->a(Landroid/support/v4/app/m;)V

    return-object p0
.end method

.method public final isAddToBackStackAllowed()Z
    .locals 1

    iget-boolean v0, p0, Landroid/support/v4/app/l;->A:Z

    return v0
.end method

.method public final isEmpty()Z
    .locals 1

    iget v0, p0, Landroid/support/v4/app/l;->b:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final remove(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    .locals 2

    new-instance v0, Landroid/support/v4/app/m;

    invoke-direct {v0}, Landroid/support/v4/app/m;-><init>()V

    const/4 v1, 0x3

    iput v1, v0, Landroid/support/v4/app/m;->c:I

    iput-object p1, v0, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    invoke-virtual {p0, v0}, Landroid/support/v4/app/l;->a(Landroid/support/v4/app/m;)V

    return-object p0
.end method

.method public final replace(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Landroid/support/v4/app/l;->replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    return-object v0
.end method

.method public final replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;
    .locals 2

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Must use non-zero containerViewId"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const/4 v0, 0x2

    invoke-direct {p0, p1, p2, p3, v0}, Landroid/support/v4/app/l;->a(ILandroid/support/v4/app/Fragment;Ljava/lang/String;I)V

    return-object p0
.end method

.method public final run()V
    .locals 9

    const/4 v8, 0x1

    const/4 v2, 0x0

    sget-boolean v0, Landroid/support/v4/app/v;->a:Z

    if-eqz v0, :cond_0

    const-string v0, "FragmentManager"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "Run: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    iget-boolean v0, p0, Landroid/support/v4/app/l;->e:Z

    if-eqz v0, :cond_1

    iget v0, p0, Landroid/support/v4/app/l;->g:I

    if-gez v0, :cond_1

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "addToBackStack() called after commit()"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    invoke-virtual {p0, v8}, Landroid/support/v4/app/l;->a(I)V

    iget-object v0, p0, Landroid/support/v4/app/l;->a:Landroid/support/v4/app/m;

    move-object v4, v0

    :goto_0
    if-eqz v4, :cond_b

    iget v0, v4, Landroid/support/v4/app/m;->c:I

    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unknown cmd: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, v4, Landroid/support/v4/app/m;->c:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    iget-object v0, v4, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v1, v4, Landroid/support/v4/app/m;->e:I

    iput v1, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    invoke-virtual {v1, v0, v2}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/Fragment;Z)V

    :cond_2
    :goto_1
    iget-object v0, v4, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/m;

    move-object v4, v0

    goto :goto_0

    :pswitch_1
    iget-object v0, v4, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget-object v1, v1, Landroid/support/v4/app/v;->c:Ljava/util/ArrayList;

    if-eqz v1, :cond_9

    move v1, v2

    move-object v3, v0

    :goto_2
    iget-object v0, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget-object v0, v0, Landroid/support/v4/app/v;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_a

    iget-object v0, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget-object v0, v0, Landroid/support/v4/app/v;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    sget-boolean v5, Landroid/support/v4/app/v;->a:Z

    if-eqz v5, :cond_3

    const-string v5, "FragmentManager"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "OP_REPLACE: adding="

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " old="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_3
    if-eqz v3, :cond_4

    iget v5, v0, Landroid/support/v4/app/Fragment;->x:I

    iget v6, v3, Landroid/support/v4/app/Fragment;->x:I

    if-ne v5, v6, :cond_5

    :cond_4
    if-ne v0, v3, :cond_6

    const/4 v3, 0x0

    iput-object v3, v4, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    :cond_5
    :goto_3
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_2

    :cond_6
    iget-object v5, v4, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    if-nez v5, :cond_7

    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, v4, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    :cond_7
    iget-object v5, v4, Landroid/support/v4/app/m;->i:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iget v5, v4, Landroid/support/v4/app/m;->f:I

    iput v5, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-boolean v5, p0, Landroid/support/v4/app/l;->e:Z

    if-eqz v5, :cond_8

    iget v5, v0, Landroid/support/v4/app/Fragment;->r:I

    add-int/lit8 v5, v5, 0x1

    iput v5, v0, Landroid/support/v4/app/Fragment;->r:I

    sget-boolean v5, Landroid/support/v4/app/v;->a:Z

    if-eqz v5, :cond_8

    const-string v5, "FragmentManager"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Bump nesting of "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " to "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget v7, v0, Landroid/support/v4/app/Fragment;->r:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_8
    iget-object v5, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v6, p0, Landroid/support/v4/app/l;->c:I

    iget v7, p0, Landroid/support/v4/app/l;->d:I

    invoke-virtual {v5, v0, v6, v7}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/Fragment;II)V

    goto :goto_3

    :cond_9
    move-object v3, v0

    :cond_a
    if-eqz v3, :cond_2

    iget v0, v4, Landroid/support/v4/app/m;->e:I

    iput v0, v3, Landroid/support/v4/app/Fragment;->G:I

    iget-object v0, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    invoke-virtual {v0, v3, v2}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_1

    :pswitch_2
    iget-object v0, v4, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v1, v4, Landroid/support/v4/app/m;->f:I

    iput v1, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v3, p0, Landroid/support/v4/app/l;->c:I

    iget v5, p0, Landroid/support/v4/app/l;->d:I

    invoke-virtual {v1, v0, v3, v5}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/Fragment;II)V

    goto/16 :goto_1

    :pswitch_3
    iget-object v0, v4, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v1, v4, Landroid/support/v4/app/m;->f:I

    iput v1, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v3, p0, Landroid/support/v4/app/l;->c:I

    iget v5, p0, Landroid/support/v4/app/l;->d:I

    invoke-virtual {v1, v0, v3, v5}, Landroid/support/v4/app/v;->b(Landroid/support/v4/app/Fragment;II)V

    goto/16 :goto_1

    :pswitch_4
    iget-object v0, v4, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v1, v4, Landroid/support/v4/app/m;->e:I

    iput v1, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v3, p0, Landroid/support/v4/app/l;->c:I

    iget v5, p0, Landroid/support/v4/app/l;->d:I

    invoke-virtual {v1, v0, v3, v5}, Landroid/support/v4/app/v;->c(Landroid/support/v4/app/Fragment;II)V

    goto/16 :goto_1

    :pswitch_5
    iget-object v0, v4, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v1, v4, Landroid/support/v4/app/m;->f:I

    iput v1, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v3, p0, Landroid/support/v4/app/l;->c:I

    iget v5, p0, Landroid/support/v4/app/l;->d:I

    invoke-virtual {v1, v0, v3, v5}, Landroid/support/v4/app/v;->d(Landroid/support/v4/app/Fragment;II)V

    goto/16 :goto_1

    :pswitch_6
    iget-object v0, v4, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    iget v1, v4, Landroid/support/v4/app/m;->e:I

    iput v1, v0, Landroid/support/v4/app/Fragment;->G:I

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v3, p0, Landroid/support/v4/app/l;->c:I

    iget v5, p0, Landroid/support/v4/app/l;->d:I

    invoke-virtual {v1, v0, v3, v5}, Landroid/support/v4/app/v;->e(Landroid/support/v4/app/Fragment;II)V

    goto/16 :goto_1

    :cond_b
    iget-object v0, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget-object v1, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    iget v1, v1, Landroid/support/v4/app/v;->d:I

    iget v2, p0, Landroid/support/v4/app/l;->c:I

    iget v3, p0, Landroid/support/v4/app/l;->d:I

    invoke-virtual {v0, v1, v2, v3, v8}, Landroid/support/v4/app/v;->a(IIIZ)V

    iget-boolean v0, p0, Landroid/support/v4/app/l;->e:Z

    if-eqz v0, :cond_c

    iget-object v0, p0, Landroid/support/v4/app/l;->m:Landroid/support/v4/app/v;

    invoke-virtual {v0, p0}, Landroid/support/v4/app/v;->b(Landroid/support/v4/app/l;)V

    :cond_c
    return-void

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method public final setBreadCrumbShortTitle(I)Landroid/support/v4/app/FragmentTransaction;
    .locals 1

    iput p1, p0, Landroid/support/v4/app/l;->j:I

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/app/l;->k:Ljava/lang/CharSequence;

    return-object p0
.end method

.method public final setBreadCrumbShortTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/FragmentTransaction;
    .locals 1

    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v4/app/l;->j:I

    iput-object p1, p0, Landroid/support/v4/app/l;->k:Ljava/lang/CharSequence;

    return-object p0
.end method

.method public final setBreadCrumbTitle(I)Landroid/support/v4/app/FragmentTransaction;
    .locals 1

    iput p1, p0, Landroid/support/v4/app/l;->h:I

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/app/l;->i:Ljava/lang/CharSequence;

    return-object p0
.end method

.method public final setBreadCrumbTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/FragmentTransaction;
    .locals 1

    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v4/app/l;->h:I

    iput-object p1, p0, Landroid/support/v4/app/l;->i:Ljava/lang/CharSequence;

    return-object p0
.end method

.method public final setCustomAnimations(II)Landroid/support/v4/app/FragmentTransaction;
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0, v0}, Landroid/support/v4/app/l;->setCustomAnimations(IIII)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    return-object v0
.end method

.method public final setCustomAnimations(IIII)Landroid/support/v4/app/FragmentTransaction;
    .locals 0

    iput p1, p0, Landroid/support/v4/app/l;->w:I

    iput p2, p0, Landroid/support/v4/app/l;->x:I

    iput p3, p0, Landroid/support/v4/app/l;->y:I

    iput p4, p0, Landroid/support/v4/app/l;->z:I

    return-object p0
.end method

.method public final setTransition(I)Landroid/support/v4/app/FragmentTransaction;
    .locals 0

    iput p1, p0, Landroid/support/v4/app/l;->c:I

    return-object p0
.end method

.method public final setTransitionStyle(I)Landroid/support/v4/app/FragmentTransaction;
    .locals 0

    iput p1, p0, Landroid/support/v4/app/l;->d:I

    return-object p0
.end method

.method public final show(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    .locals 2

    new-instance v0, Landroid/support/v4/app/m;

    invoke-direct {v0}, Landroid/support/v4/app/m;-><init>()V

    const/4 v1, 0x5

    iput v1, v0, Landroid/support/v4/app/m;->c:I

    iput-object p1, v0, Landroid/support/v4/app/m;->d:Landroid/support/v4/app/Fragment;

    invoke-virtual {p0, v0}, Landroid/support/v4/app/l;->a(Landroid/support/v4/app/m;)V

    return-object p0
.end method

.method public final toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x80

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v1, "BackStackEntry{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Landroid/support/v4/app/l;->g:I

    if-ltz v1, :cond_0

    const-string v1, " #"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Landroid/support/v4/app/l;->g:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    :cond_0
    iget-object v1, p0, Landroid/support/v4/app/l;->f:Ljava/lang/String;

    if-eqz v1, :cond_1

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Landroid/support/v4/app/l;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_1
    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
