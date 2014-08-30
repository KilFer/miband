package com.xiaomi.infra.galaxy.common.auth;

public enum SigningAlgorithm
{
  static
  {
    SigningAlgorithm[] arrayOfSigningAlgorithm = new SigningAlgorithm[2];
    arrayOfSigningAlgorithm[0] = HmacSHA1;
    arrayOfSigningAlgorithm[1] = HmacSHA256;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.auth.SigningAlgorithm
 * JD-Core Version:    0.6.2
 */