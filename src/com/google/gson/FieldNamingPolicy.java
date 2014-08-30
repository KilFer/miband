package com.google.gson;

public enum FieldNamingPolicy
  implements FieldNamingStrategy
{
  static
  {
    LOWER_CASE_WITH_UNDERSCORES = new e("LOWER_CASE_WITH_UNDERSCORES", 3);
    LOWER_CASE_WITH_DASHES = new f("LOWER_CASE_WITH_DASHES", 4);
    FieldNamingPolicy[] arrayOfFieldNamingPolicy = new FieldNamingPolicy[5];
    arrayOfFieldNamingPolicy[0] = IDENTITY;
    arrayOfFieldNamingPolicy[1] = UPPER_CAMEL_CASE;
    arrayOfFieldNamingPolicy[2] = UPPER_CAMEL_CASE_WITH_SPACES;
    arrayOfFieldNamingPolicy[3] = LOWER_CASE_WITH_UNDERSCORES;
    arrayOfFieldNamingPolicy[4] = LOWER_CASE_WITH_DASHES;
  }

  private static String a(char paramChar, String paramString, int paramInt)
  {
    if (paramInt < paramString.length())
      return paramChar + paramString.substring(paramInt);
    return String.valueOf(paramChar);
  }

  private static String b(String paramString)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    for (char c1 = paramString.charAt(0); (i < -1 + paramString.length()) && (!Character.isLetter(c1)); c1 = paramString.charAt(i))
    {
      localStringBuilder.append(c1);
      i++;
    }
    if (i == paramString.length())
      paramString = localStringBuilder.toString();
    while (Character.isUpperCase(c1))
      return paramString;
    char c2 = Character.toUpperCase(c1);
    int j = i + 1;
    if (j < paramString.length());
    for (String str = c2 + paramString.substring(j); ; str = String.valueOf(c2))
      return str;
  }

  private static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramString1.length(); i++)
    {
      char c = paramString1.charAt(i);
      if ((Character.isUpperCase(c)) && (localStringBuilder.length() != 0))
        localStringBuilder.append(paramString2);
      localStringBuilder.append(c);
    }
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.FieldNamingPolicy
 * JD-Core Version:    0.6.2
 */