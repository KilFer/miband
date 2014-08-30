package com.xiaomi.infra.galaxy.common.auth;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;

public abstract interface Signer
{
  public abstract void sign(BasicGalaxyRequest paramBasicGalaxyRequest, GalaxyCredentials paramGalaxyCredentials);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.auth.Signer
 * JD-Core Version:    0.6.2
 */