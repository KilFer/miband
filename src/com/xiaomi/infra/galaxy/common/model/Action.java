package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;

public enum Action
{
  private String value;

  static
  {
    ADD = new Action("ADD", 1, "ADD");
    Action[] arrayOfAction = new Action[2];
    arrayOfAction[0] = PUT;
    arrayOfAction[1] = ADD;
  }

  private Action(String paramString)
  {
    this.value = paramString;
  }

  public static Action fromValue(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
      throw new GalaxyClientException(ReturnCode.SET_ACTION_IS_BLANK);
    if ("PUT".equals(paramString))
      return PUT;
    if ("ADD".equals(paramString))
      return ADD;
    throw new GalaxyClientException(ReturnCode.SET_ACTION_IS_INVALID, paramString);
  }

  public final String toString()
  {
    return this.value;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.Action
 * JD-Core Version:    0.6.2
 */