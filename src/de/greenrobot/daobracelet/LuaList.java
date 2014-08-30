package de.greenrobot.daobracelet;

public class LuaList
{
  private String date;
  private Long id;
  private String index;
  private String jsonString;
  private String luaActionScript;
  private String right;
  private String scriptVersion;
  private String start;
  private String stop;
  private String text1;
  private String text2;
  private String time;
  private String type;

  public LuaList()
  {
  }

  public LuaList(Long paramLong)
  {
    this.id = paramLong;
  }

  public LuaList(Long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    this.id = paramLong;
    this.date = paramString1;
    this.time = paramString2;
    this.type = paramString3;
    this.right = paramString4;
    this.index = paramString5;
    this.jsonString = paramString6;
    this.scriptVersion = paramString7;
    this.luaActionScript = paramString8;
    this.text1 = paramString9;
    this.text2 = paramString10;
    this.start = paramString11;
    this.stop = paramString12;
  }

  public String getDate()
  {
    return this.date;
  }

  public Long getId()
  {
    return this.id;
  }

  public String getIndex()
  {
    return this.index;
  }

  public String getJsonString()
  {
    return this.jsonString;
  }

  public String getLuaActionScript()
  {
    return this.luaActionScript;
  }

  public String getRight()
  {
    return this.right;
  }

  public String getScriptVersion()
  {
    return this.scriptVersion;
  }

  public String getStart()
  {
    return this.start;
  }

  public String getStop()
  {
    return this.stop;
  }

  public String getText1()
  {
    return this.text1;
  }

  public String getText2()
  {
    return this.text2;
  }

  public String getTime()
  {
    return this.time;
  }

  public String getType()
  {
    return this.type;
  }

  public void setDate(String paramString)
  {
    this.date = paramString;
  }

  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }

  public void setIndex(String paramString)
  {
    this.index = paramString;
  }

  public void setJsonString(String paramString)
  {
    this.jsonString = paramString;
  }

  public void setLuaActionScript(String paramString)
  {
    this.luaActionScript = paramString;
  }

  public void setRight(String paramString)
  {
    this.right = paramString;
  }

  public void setScriptVersion(String paramString)
  {
    this.scriptVersion = paramString;
  }

  public void setStart(String paramString)
  {
    this.start = paramString;
  }

  public void setStop(String paramString)
  {
    this.stop = paramString;
  }

  public void setText1(String paramString)
  {
    this.text1 = paramString;
  }

  public void setText2(String paramString)
  {
    this.text2 = paramString;
  }

  public void setTime(String paramString)
  {
    this.time = paramString;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.daobracelet.LuaList
 * JD-Core Version:    0.6.2
 */