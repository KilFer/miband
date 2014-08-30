package com.xiaomi.infra.galaxy.common.auth;

public class Galaxy4Signer$HeaderSigningResult
{
  private String dateTime;
  private byte[] kSigning;
  private String scope;
  private byte[] signature;

  public Galaxy4Signer$HeaderSigningResult(Galaxy4Signer paramGalaxy4Signer, String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.dateTime = paramString1;
    this.scope = paramString2;
    this.kSigning = paramArrayOfByte1;
    this.signature = paramArrayOfByte2;
  }

  public String getDateTime()
  {
    return this.dateTime;
  }

  public byte[] getKSigning()
  {
    byte[] arrayOfByte = new byte[this.kSigning.length];
    System.arraycopy(this.kSigning, 0, arrayOfByte, 0, this.kSigning.length);
    return arrayOfByte;
  }

  public String getScope()
  {
    return this.scope;
  }

  public byte[] getSignature()
  {
    byte[] arrayOfByte = new byte[this.signature.length];
    System.arraycopy(this.signature, 0, arrayOfByte, 0, this.signature.length);
    return arrayOfByte;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.auth.Galaxy4Signer.HeaderSigningResult
 * JD-Core Version:    0.6.2
 */