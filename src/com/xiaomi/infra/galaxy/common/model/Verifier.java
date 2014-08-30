package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.Constants;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verifier
{
  public static void validateAttributeName(String paramString, boolean paramBoolean)
  {
    if (StringUtils.isBlank(paramString))
      throw new GalaxyClientException(ReturnCode.ATTRIBUTE_NAME_IS_BLANK);
    if (paramString.length() > 255)
      throw new GalaxyClientException(ReturnCode.ATTRIBUTE_NAME_TOO_LONG, paramString);
    if ((paramBoolean) && (!Constants.AttributeNamePattern.matcher(paramString).matches()))
      throw new GalaxyClientException(ReturnCode.ATTRIBUTE_NAME_IS_INVALID, paramString);
  }

  public static void validateAttributeNames(Collection<String> paramCollection, boolean paramBoolean)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()));
    while (true)
    {
      return;
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
        validateAttributeName((String)localIterator.next(), paramBoolean);
    }
  }

  public static void validateAttributeValue(String paramString, AttributeValue paramAttributeValue, boolean paramBoolean)
  {
    validateAttributeName(paramString, paramBoolean);
    if (paramAttributeValue == null)
      throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_NULL, paramString);
    validateValue(paramAttributeValue.getType(), paramAttributeValue.getValue(), paramString);
  }

  public static void validateKeyValues(RowKey paramRowKey, boolean paramBoolean)
  {
    if (paramRowKey != null)
      validateKeyValues(paramRowKey.getKey(), paramBoolean);
  }

  public static void validateKeyValues(Map<String, AttributeValue> paramMap, boolean paramBoolean)
  {
    int i = -1;
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      int j = i;
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        AttributeValue localAttributeValue = (AttributeValue)localEntry.getValue();
        validateAttributeValue(str, localAttributeValue, paramBoolean);
        AttributeType localAttributeType = AttributeType.fromValue(localAttributeValue.getType());
        switch (Verifier.1.$SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[localAttributeType.ordinal()])
        {
        case 1:
        default:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        }
        for (int k = j; ; k = j + 3 * localAttributeValue.getValue().length() / 4)
        {
          while (true)
          {
            j = k;
            break;
            j++;
            break;
            j += 2;
            break;
            j += 4;
            break;
            j += 8;
            break;
            j += 4;
            break;
            j += 8;
            break;
            try
            {
              int m = localAttributeValue.getValue().getBytes("utf-8").length;
              j = m + j;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              localUnsupportedEncodingException.printStackTrace();
            }
          }
          break;
        }
      }
      i = j;
    }
    if (i > 1024)
      throw new GalaxyClientException(ReturnCode.KEY_IS_TOO_LONG, i);
  }

  public static void validateTableName(String paramString)
  {
    validateTableName(paramString, true);
  }

  public static void validateTableName(String paramString, boolean paramBoolean)
  {
    if (StringUtils.isBlank(paramString))
      throw new GalaxyClientException(ReturnCode.TABLE_NAME_IS_BLANK);
    if (paramString.length() > 255)
      throw new GalaxyClientException(ReturnCode.TABLE_NAME_TOO_LONG, paramString);
    if ((paramBoolean) && (!Constants.TableNamePattern.matcher(paramString).matches()))
      throw new GalaxyClientException(ReturnCode.TABLE_NAME_IS_INVALID, paramString);
  }

  private static void validateValue(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      AttributeType localAttributeType = AttributeType.fromValue(paramString1);
      switch (Verifier.1.$SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[localAttributeType.ordinal()])
      {
      default:
        throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_INVALID, "unused attribute type of " + paramString3 + "@" + paramString1);
      case 1:
      case 2:
      case 6:
      case 7:
      case 8:
      case 9:
      case 3:
      case 4:
      case 5:
      }
    }
    catch (GalaxyClientException localGalaxyClientException)
    {
      throw localGalaxyClientException;
    }
    if ((!"true".equalsIgnoreCase(paramString2)) && (!"false".equalsIgnoreCase(paramString2)))
      throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_INVALID, "expected 'true' or 'false' for boolean attribute type of " + paramString3 + "@" + paramString2);
    try
    {
      Byte.parseByte(paramString2);
      return;
    }
    catch (Exception localException4)
    {
      throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_INVALID, "expected [-128,127] for int8 attribute type of " + paramString3 + "@" + paramString2);
    }
    try
    {
      Short.parseShort(paramString2);
      return;
    }
    catch (Exception localException3)
    {
      throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_INVALID, "expected [-32768,32767] for int16 attribute type of " + paramString3 + "@" + paramString2);
    }
    try
    {
      Integer.parseInt(paramString2);
      return;
    }
    catch (Exception localException2)
    {
      throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_INVALID, "expected [-2147483648,2147483647] for int32 attribute type of " + paramString3 + "@" + paramString2);
    }
    try
    {
      Long.parseLong(paramString2);
      return;
    }
    catch (Exception localException1)
    {
    }
    throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_INVALID, "expected [-9223372036854775808,9223372036854775807] for int64 attribute type of " + paramString3 + "@" + paramString2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.Verifier
 * JD-Core Version:    0.6.2
 */