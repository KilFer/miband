package com.xiaomi.infra.galaxy.common.model;

public class Result
{
  public static final int SUCCESS = 1;
  protected int code;
  protected String message;

  public Result()
  {
    this.code = 1;
    this.message = "success";
  }

  public Result(int paramInt, String paramString)
  {
    this.code = paramInt;
    this.message = paramString;
  }

  public Result(Result paramResult)
  {
    this(paramResult.getCode(), paramResult.getMessage());
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    Result localResult;
    int i;
    int j;
    do
    {
      boolean bool2;
      do
      {
        do
        {
          return bool1;
          bool1 = false;
        }
        while (paramObject == null);
        bool2 = paramObject instanceof Result;
        bool1 = false;
      }
      while (!bool2);
      localResult = (Result)paramObject;
      i = localResult.getCode();
      j = getCode();
      bool1 = false;
    }
    while (i != j);
    int k;
    if (localResult.getMessage() == null)
    {
      k = 1;
      label65: if (getMessage() != null)
        break label126;
    }
    label126: for (int m = 1; ; m = 0)
    {
      int n = k ^ m;
      bool1 = false;
      if (n != 0)
        break;
      if (localResult.getMessage() != null)
      {
        boolean bool3 = localResult.getMessage().equals(getMessage());
        bool1 = false;
        if (!bool3)
          break;
      }
      return true;
      k = 0;
      break label65;
    }
  }

  public int getCode()
  {
    return this.code;
  }

  public String getMessage()
  {
    return this.message;
  }

  public int hashCode()
  {
    int i = 31 * (31 + getCode());
    if (getMessage() == null);
    for (int j = 0; ; j = getMessage().hashCode())
      return j + i;
  }

  public void setCode(int paramInt)
  {
    this.code = paramInt;
  }

  public void setMessage(String paramString)
  {
    this.message = paramString;
  }

  public void setResult(Result paramResult)
  {
    setCode(paramResult.getCode());
    setMessage(paramResult.getMessage());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.Result
 * JD-Core Version:    0.6.2
 */