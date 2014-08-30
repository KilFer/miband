package de.greenrobot.dao.test;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import de.greenrobot.dao.DbUtils;
import java.util.Random;

public abstract class DbTest extends AndroidTestCase
{
  public static final String DB_NAME = "greendao-unittest-db.temp";
  private Application application;
  protected SQLiteDatabase db;
  protected final boolean inMemory;
  protected final Random random;

  public DbTest()
  {
    this(true);
  }

  public DbTest(boolean paramBoolean)
  {
    this.inMemory = paramBoolean;
    this.random = new Random();
  }

  public <T extends Application> T createApplication(Class<T> paramClass)
  {
    assertNull("Application already created", this.application);
    try
    {
      Application localApplication = Instrumentation.newApplication(paramClass, getContext());
      localApplication.onCreate();
      this.application = localApplication;
      return localApplication;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Could not create application " + paramClass, localException);
    }
  }

  protected SQLiteDatabase createDatabase()
  {
    if (this.inMemory)
      return SQLiteDatabase.create(null);
    getContext().deleteDatabase("greendao-unittest-db.temp");
    return getContext().openOrCreateDatabase("greendao-unittest-db.temp", 0, null);
  }

  public <T extends Application> T getApplication()
  {
    assertNotNull("Application not yet created", this.application);
    return this.application;
  }

  protected void logTableDump(String paramString)
  {
    DbUtils.logTableDump(this.db, paramString);
  }

  protected void setUp()
  {
    super.setUp();
    this.db = createDatabase();
  }

  protected void tearDown()
  {
    if (this.application != null)
      terminateApplication();
    this.db.close();
    if (!this.inMemory)
      getContext().deleteDatabase("greendao-unittest-db.temp");
    super.tearDown();
  }

  public void terminateApplication()
  {
    assertNotNull("Application not yet created", this.application);
    this.application.onTerminate();
    this.application = null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.test.DbTest
 * JD-Core Version:    0.6.2
 */