package cn.com.smartdevices.bracelet.model;

public enum SportMode
{
  static
  {
    RUNNING = new SportMode("RUNNING", 2);
    NONWEAR = new SportMode("NONWEAR", 3);
    REM = new SportMode("REM", 4);
    NOREM = new SportMode("NOREM", 5);
    SportMode[] arrayOfSportMode = new SportMode[6];
    arrayOfSportMode[0] = SILENT;
    arrayOfSportMode[1] = WALKING;
    arrayOfSportMode[2] = RUNNING;
    arrayOfSportMode[3] = NONWEAR;
    arrayOfSportMode[4] = REM;
    arrayOfSportMode[5] = NOREM;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.SportMode
 * JD-Core Version:    0.6.2
 */