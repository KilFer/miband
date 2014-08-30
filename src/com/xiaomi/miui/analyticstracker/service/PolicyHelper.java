package com.xiaomi.miui.analyticstracker.service;

import android.text.TextUtils;
import com.xiaomi.miui.analyticstracker.ObjectBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

public class PolicyHelper
{
  private static final String c = ":";
  private Map<String, Policy> a = new HashMap();
  private ObjectBuilder<Policy> b = new ObjectBuilder();

  public PolicyHelper()
  {
    this.b.registerClass(LastPolicy.class, "last");
    this.b.registerClass(NormalPolicy.class, "normal");
    this.b.registerClass(CountPolicy.class, "count");
  }

  public void clear()
  {
    this.a.clear();
  }

  public void end()
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((Policy)this.a.get(str)).end();
    }
  }

  public Policy getPolicy(String paramString)
  {
    if (!TextUtils.isEmpty(paramString));
    while (true)
    {
      try
      {
        String[] arrayOfString = paramString.split(":");
        if (arrayOfString.length > 0)
        {
          localPolicy = (Policy)this.a.get(arrayOfString[0]);
          try
          {
            if (arrayOfString.length <= 1)
              break label125;
            str = arrayOfString[1];
            if (localPolicy == null)
            {
              localPolicy = (Policy)this.b.buildObject(paramString);
              if (localPolicy == null)
                break label123;
              this.a.put(paramString, localPolicy);
              localPolicy.setParam(str);
              localPolicy.prepare();
              return localPolicy;
            }
            localPolicy.setParam(str);
            return localPolicy;
          }
          catch (PatternSyntaxException localPatternSyntaxException2)
          {
          }
          localPatternSyntaxException2.printStackTrace();
          return localPolicy;
        }
      }
      catch (PatternSyntaxException localPatternSyntaxException1)
      {
        Object localObject = localPatternSyntaxException1;
        localPolicy = null;
        continue;
      }
      Policy localPolicy = null;
      label123: return localPolicy;
      label125: String str = "";
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.service.PolicyHelper
 * JD-Core Version:    0.6.2
 */