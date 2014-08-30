package com.xiaomi.infra.galaxy.common;

public enum HttpMethodName
{
  static
  {
    DELETE = new HttpMethodName("DELETE", 3);
    HEAD = new HttpMethodName("HEAD", 4);
    HttpMethodName[] arrayOfHttpMethodName = new HttpMethodName[5];
    arrayOfHttpMethodName[0] = GET;
    arrayOfHttpMethodName[1] = POST;
    arrayOfHttpMethodName[2] = PUT;
    arrayOfHttpMethodName[3] = DELETE;
    arrayOfHttpMethodName[4] = HEAD;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.HttpMethodName
 * JD-Core Version:    0.6.2
 */