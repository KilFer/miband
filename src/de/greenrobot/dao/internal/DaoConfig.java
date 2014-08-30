package de.greenrobot.dao.internal;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.identityscope.IdentityScope;
import de.greenrobot.dao.identityscope.IdentityScopeLong;
import de.greenrobot.dao.identityscope.IdentityScopeObject;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class DaoConfig
  implements Cloneable
{
  public final String[] allColumns;
  public final SQLiteDatabase db;
  private IdentityScope<?, ?> identityScope;
  public final boolean keyIsNumeric;
  public final String[] nonPkColumns;
  public final String[] pkColumns;
  public final Property pkProperty;
  public final Property[] properties;
  public final TableStatements statements;
  public final String tablename;

  public DaoConfig(SQLiteDatabase paramSQLiteDatabase, Class<? extends AbstractDao<?, ?>> paramClass)
  {
    this.db = paramSQLiteDatabase;
    while (true)
    {
      int i;
      Object localObject2;
      try
      {
        this.tablename = ((String)paramClass.getField("TABLENAME").get(null));
        Property[] arrayOfProperty = reflectProperties(paramClass);
        this.properties = arrayOfProperty;
        this.allColumns = new String[arrayOfProperty.length];
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        i = 0;
        localObject1 = null;
        if (i < arrayOfProperty.length)
        {
          localObject2 = arrayOfProperty[i];
          String str = ((Property)localObject2).columnName;
          this.allColumns[i] = str;
          if (((Property)localObject2).primaryKey)
          {
            localArrayList1.add(str);
          }
          else
          {
            localArrayList2.add(str);
            localObject2 = localObject1;
          }
        }
        else
        {
          this.nonPkColumns = ((String[])localArrayList2.toArray(new String[localArrayList2.size()]));
          this.pkColumns = ((String[])localArrayList1.toArray(new String[localArrayList1.size()]));
          if (this.pkColumns.length != 1)
            break label372;
          this.pkProperty = localObject1;
          this.statements = new TableStatements(paramSQLiteDatabase, this.tablename, this.allColumns, this.pkColumns);
          if (this.pkProperty != null)
          {
            Class localClass = this.pkProperty.type;
            if ((localClass.equals(Long.TYPE)) || (localClass.equals(Long.class)) || (localClass.equals(Integer.TYPE)) || (localClass.equals(Integer.class)) || (localClass.equals(Short.TYPE)) || (localClass.equals(Short.class)) || (localClass.equals(Byte.TYPE)))
              break label366;
            if (!localClass.equals(Byte.class))
              break label378;
            break label366;
            this.keyIsNumeric = bool;
            return;
          }
          this.keyIsNumeric = false;
          return;
        }
      }
      catch (Exception localException)
      {
        throw new DaoException("Could not init DAOConfig", localException);
      }
      i++;
      Object localObject1 = localObject2;
      continue;
      label366: boolean bool = true;
      continue;
      label372: localObject1 = null;
      continue;
      label378: bool = false;
    }
  }

  public DaoConfig(DaoConfig paramDaoConfig)
  {
    this.db = paramDaoConfig.db;
    this.tablename = paramDaoConfig.tablename;
    this.properties = paramDaoConfig.properties;
    this.allColumns = paramDaoConfig.allColumns;
    this.pkColumns = paramDaoConfig.pkColumns;
    this.nonPkColumns = paramDaoConfig.nonPkColumns;
    this.pkProperty = paramDaoConfig.pkProperty;
    this.statements = paramDaoConfig.statements;
    this.keyIsNumeric = paramDaoConfig.keyIsNumeric;
  }

  private static Property[] reflectProperties(Class<? extends AbstractDao<?, ?>> paramClass)
  {
    Field[] arrayOfField = Class.forName(paramClass.getName() + "$Properties").getDeclaredFields();
    ArrayList localArrayList = new ArrayList();
    int i = arrayOfField.length;
    for (int j = 0; j < i; j++)
    {
      Field localField = arrayOfField[j];
      if ((0x9 & localField.getModifiers()) == 9)
      {
        Object localObject = localField.get(null);
        if ((localObject instanceof Property))
          localArrayList.add((Property)localObject);
      }
    }
    Property[] arrayOfProperty = new Property[localArrayList.size()];
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      Property localProperty = (Property)localIterator.next();
      if (arrayOfProperty[localProperty.ordinal] != null)
        throw new DaoException("Duplicate property ordinals");
      arrayOfProperty[localProperty.ordinal] = localProperty;
    }
    return arrayOfProperty;
  }

  public final DaoConfig clone()
  {
    return new DaoConfig(this);
  }

  public final IdentityScope<?, ?> getIdentityScope()
  {
    return this.identityScope;
  }

  public final void initIdentityScope(IdentityScopeType paramIdentityScopeType)
  {
    if (paramIdentityScopeType == IdentityScopeType.None)
    {
      this.identityScope = null;
      return;
    }
    if (paramIdentityScopeType == IdentityScopeType.Session)
    {
      if (this.keyIsNumeric)
      {
        this.identityScope = new IdentityScopeLong();
        return;
      }
      this.identityScope = new IdentityScopeObject();
      return;
    }
    throw new IllegalArgumentException("Unsupported type: " + paramIdentityScopeType);
  }

  public final void setIdentityScope(IdentityScope<?, ?> paramIdentityScope)
  {
    this.identityScope = paramIdentityScope;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.internal.DaoConfig
 * JD-Core Version:    0.6.2
 */