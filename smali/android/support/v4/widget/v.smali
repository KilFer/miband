.class Landroid/support/v4/widget/v;
.super Landroid/support/v4/widget/z;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/widget/z;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Landroid/view/View;
    .locals 1

    new-instance v0, Landroid/widget/SearchView;

    invoke-direct {v0, p1}, Landroid/widget/SearchView;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public final a(Landroid/view/View;)Ljava/lang/CharSequence;
    .locals 1

    check-cast p1, Landroid/widget/SearchView;

    invoke-virtual {p1}, Landroid/widget/SearchView;->getQuery()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public final a(Landroid/support/v4/widget/SearchViewCompat$OnCloseListenerCompat;)Ljava/lang/Object;
    .locals 2

    new-instance v0, Landroid/support/v4/widget/m;

    invoke-direct {v0, p0, p1}, Landroid/support/v4/widget/m;-><init>(Landroid/support/v4/widget/v;Landroid/support/v4/widget/SearchViewCompat$OnCloseListenerCompat;)V

    new-instance v1, Landroid/support/v4/widget/D;

    invoke-direct {v1, v0}, Landroid/support/v4/widget/D;-><init>(Landroid/support/v4/widget/m;)V

    return-object v1
.end method

.method public final a(Landroid/support/v4/widget/SearchViewCompat$OnQueryTextListenerCompat;)Ljava/lang/Object;
    .locals 2

    new-instance v0, Landroid/support/v4/widget/t;

    invoke-direct {v0, p0, p1}, Landroid/support/v4/widget/t;-><init>(Landroid/support/v4/widget/v;Landroid/support/v4/widget/SearchViewCompat$OnQueryTextListenerCompat;)V

    new-instance v1, Landroid/support/v4/widget/C;

    invoke-direct {v1, v0}, Landroid/support/v4/widget/C;-><init>(Landroid/support/v4/widget/t;)V

    return-object v1
.end method

.method public final a(Landroid/view/View;I)V
    .locals 0

    check-cast p1, Landroid/widget/SearchView;

    invoke-virtual {p1, p2}, Landroid/widget/SearchView;->setMaxWidth(I)V

    return-void
.end method

.method public final a(Landroid/view/View;Landroid/content/ComponentName;)V
    .locals 2

    check-cast p1, Landroid/widget/SearchView;

    invoke-virtual {p1}, Landroid/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "search"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/SearchManager;

    invoke-virtual {v0, p2}, Landroid/app/SearchManager;->getSearchableInfo(Landroid/content/ComponentName;)Landroid/app/SearchableInfo;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/widget/SearchView;->setSearchableInfo(Landroid/app/SearchableInfo;)V

    return-void
.end method

.method public final a(Landroid/view/View;Ljava/lang/CharSequence;)V
    .locals 0

    check-cast p1, Landroid/widget/SearchView;

    invoke-virtual {p1, p2}, Landroid/widget/SearchView;->setQueryHint(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public final a(Landroid/view/View;Ljava/lang/CharSequence;Z)V
    .locals 0

    check-cast p1, Landroid/widget/SearchView;

    invoke-virtual {p1, p2, p3}, Landroid/widget/SearchView;->setQuery(Ljava/lang/CharSequence;Z)V

    return-void
.end method

.method public final a(Landroid/view/View;Z)V
    .locals 0

    check-cast p1, Landroid/widget/SearchView;

    invoke-virtual {p1, p2}, Landroid/widget/SearchView;->setIconified(Z)V

    return-void
.end method

.method public final a(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Landroid/widget/SearchView;

    check-cast p2, Landroid/widget/SearchView$OnQueryTextListener;

    invoke-virtual {p1, p2}, Landroid/widget/SearchView;->setOnQueryTextListener(Landroid/widget/SearchView$OnQueryTextListener;)V

    return-void
.end method

.method public final b(Landroid/view/View;Z)V
    .locals 0

    check-cast p1, Landroid/widget/SearchView;

    invoke-virtual {p1, p2}, Landroid/widget/SearchView;->setSubmitButtonEnabled(Z)V

    return-void
.end method

.method public final b(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Landroid/widget/SearchView;

    check-cast p2, Landroid/widget/SearchView$OnCloseListener;

    invoke-virtual {p1, p2}, Landroid/widget/SearchView;->setOnCloseListener(Landroid/widget/SearchView$OnCloseListener;)V

    return-void
.end method

.method public final b(Landroid/view/View;)Z
    .locals 1

    check-cast p1, Landroid/widget/SearchView;

    invoke-virtual {p1}, Landroid/widget/SearchView;->isIconified()Z

    move-result v0

    return v0
.end method

.method public final c(Landroid/view/View;Z)V
    .locals 0

    check-cast p1, Landroid/widget/SearchView;

    invoke-virtual {p1, p2}, Landroid/widget/SearchView;->setQueryRefinementEnabled(Z)V

    return-void
.end method

.method public final c(Landroid/view/View;)Z
    .locals 1

    check-cast p1, Landroid/widget/SearchView;

    invoke-virtual {p1}, Landroid/widget/SearchView;->isSubmitButtonEnabled()Z

    move-result v0

    return v0
.end method

.method public final d(Landroid/view/View;)Z
    .locals 1

    check-cast p1, Landroid/widget/SearchView;

    invoke-virtual {p1}, Landroid/widget/SearchView;->isQueryRefinementEnabled()Z

    move-result v0

    return v0
.end method
