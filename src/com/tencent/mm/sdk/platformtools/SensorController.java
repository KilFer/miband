package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorController extends BroadcastReceiver
  implements SensorEventListener
{
  private static float a = 4.294967E+009F;
  private static float d = 0.5F;
  private SensorManager b;
  private float c;
  private SensorController.SensorEventCallBack e;
  private Sensor f;
  private final boolean g;
  private boolean h = false;
  private boolean i = false;

  public SensorController(Context paramContext)
  {
    this.b = ((SensorManager)paramContext.getSystemService("sensor"));
    this.f = this.b.getDefaultSensor(8);
    if (this.f != null);
    for (boolean bool = true; ; bool = false)
    {
      this.g = bool;
      this.c = (1.0F + d);
      return;
    }
  }

  public boolean isSensorEnable()
  {
    return this.g;
  }

  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"))
    {
      int j = paramIntent.getIntExtra("state", 0);
      if (j == 1)
        this.h = true;
      if (j == 0)
        this.h = false;
    }
  }

  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.h)
      return;
    float f1 = paramSensorEvent.values[0];
    switch (paramSensorEvent.sensor.getType())
    {
    default:
      return;
    case 8:
    }
    if (f1 < a)
    {
      a = f1;
      d = 0.5F + f1;
    }
    if ((this.c >= d) && (f1 < d))
      if (this.e != null)
      {
        Log.v("MicroMsg.SensorController", "sensor event false");
        this.e.onSensorEvent(false);
      }
    while (true)
    {
      this.c = f1;
      return;
      if ((this.c <= d) && (f1 > d) && (this.e != null))
      {
        Log.v("MicroMsg.SensorController", "sensor event true");
        this.e.onSensorEvent(true);
      }
    }
  }

  public void removeSensorCallBack()
  {
    Log.v("MicroMsg.SensorController", "sensor callback removed");
    this.b.unregisterListener(this, this.f);
    this.b.unregisterListener(this);
    this.i = false;
    this.e = null;
  }

  public void setSensorCallBack(SensorController.SensorEventCallBack paramSensorEventCallBack)
  {
    Log.v("MicroMsg.SensorController", "sensor callback set");
    if (!this.i)
    {
      this.b.registerListener(this, this.f, 2);
      this.i = true;
    }
    this.e = paramSensorEventCallBack;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SensorController
 * JD-Core Version:    0.6.2
 */