package de.greenrobot.dao.identityscope;

public enum IdentityScopeType
{
  static
  {
    None = new IdentityScopeType("None", 1);
    IdentityScopeType[] arrayOfIdentityScopeType = new IdentityScopeType[2];
    arrayOfIdentityScopeType[0] = Session;
    arrayOfIdentityScopeType[1] = None;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.identityscope.IdentityScopeType
 * JD-Core Version:    0.6.2
 */