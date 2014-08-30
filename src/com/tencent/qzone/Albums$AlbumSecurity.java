package com.tencent.qzone;

public enum Albums$AlbumSecurity
{
  private final String a;

  static
  {
    privateOnly = new AlbumSecurity("privateOnly", 1, "2");
    friendsOnly = new AlbumSecurity("friendsOnly", 2, "4");
    needQuestion = new AlbumSecurity("needQuestion", 3, "5");
    AlbumSecurity[] arrayOfAlbumSecurity = new AlbumSecurity[4];
    arrayOfAlbumSecurity[0] = publicToAll;
    arrayOfAlbumSecurity[1] = privateOnly;
    arrayOfAlbumSecurity[2] = friendsOnly;
    arrayOfAlbumSecurity[3] = needQuestion;
  }

  private Albums$AlbumSecurity(String paramString)
  {
    this.a = paramString;
  }

  public final String getSecurity()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.qzone.Albums.AlbumSecurity
 * JD-Core Version:    0.6.2
 */