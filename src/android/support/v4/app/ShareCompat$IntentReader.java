package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import java.util.ArrayList;

public class ShareCompat$IntentReader
{
  private static final String a = "IntentReader";
  private Activity b;
  private Intent c;
  private String d;
  private ComponentName e;
  private ArrayList<Uri> f;

  private ShareCompat$IntentReader(Activity paramActivity)
  {
    this.b = paramActivity;
    this.c = paramActivity.getIntent();
    this.d = ShareCompat.getCallingPackage(paramActivity);
    this.e = ShareCompat.getCallingActivity(paramActivity);
  }

  public static IntentReader from(Activity paramActivity)
  {
    return new IntentReader(paramActivity);
  }

  public ComponentName getCallingActivity()
  {
    return this.e;
  }

  public Drawable getCallingActivityIcon()
  {
    if (this.e == null)
      return null;
    PackageManager localPackageManager = this.b.getPackageManager();
    try
    {
      Drawable localDrawable = localPackageManager.getActivityIcon(this.e);
      return localDrawable;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("IntentReader", "Could not retrieve icon for calling activity", localNameNotFoundException);
    }
    return null;
  }

  public Drawable getCallingApplicationIcon()
  {
    if (this.d == null)
      return null;
    PackageManager localPackageManager = this.b.getPackageManager();
    try
    {
      Drawable localDrawable = localPackageManager.getApplicationIcon(this.d);
      return localDrawable;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("IntentReader", "Could not retrieve icon for calling application", localNameNotFoundException);
    }
    return null;
  }

  public CharSequence getCallingApplicationLabel()
  {
    if (this.d == null)
      return null;
    PackageManager localPackageManager = this.b.getPackageManager();
    try
    {
      CharSequence localCharSequence = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(this.d, 0));
      return localCharSequence;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("IntentReader", "Could not retrieve label for calling application", localNameNotFoundException);
    }
    return null;
  }

  public String getCallingPackage()
  {
    return this.d;
  }

  public String[] getEmailBcc()
  {
    return this.c.getStringArrayExtra("android.intent.extra.BCC");
  }

  public String[] getEmailCc()
  {
    return this.c.getStringArrayExtra("android.intent.extra.CC");
  }

  public String[] getEmailTo()
  {
    return this.c.getStringArrayExtra("android.intent.extra.EMAIL");
  }

  public String getHtmlText()
  {
    String str = this.c.getStringExtra("android.intent.extra.HTML_TEXT");
    if (this.c == null)
    {
      CharSequence localCharSequence = getText();
      if ((localCharSequence instanceof Spanned))
        return Html.toHtml((Spanned)localCharSequence);
      if (localCharSequence != null)
        return ShareCompat.a().a(localCharSequence);
    }
    return str;
  }

  public Uri getStream()
  {
    return (Uri)this.c.getParcelableExtra("android.intent.extra.STREAM");
  }

  public Uri getStream(int paramInt)
  {
    if ((this.f == null) && (isMultipleShare()))
      this.f = this.c.getParcelableArrayListExtra("android.intent.extra.STREAM");
    if (this.f != null)
      return (Uri)this.f.get(paramInt);
    if (paramInt == 0)
      return (Uri)this.c.getParcelableExtra("android.intent.extra.STREAM");
    throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + paramInt);
  }

  public int getStreamCount()
  {
    if ((this.f == null) && (isMultipleShare()))
      this.f = this.c.getParcelableArrayListExtra("android.intent.extra.STREAM");
    if (this.f != null)
      return this.f.size();
    if (this.c.hasExtra("android.intent.extra.STREAM"))
      return 1;
    return 0;
  }

  public String getSubject()
  {
    return this.c.getStringExtra("android.intent.extra.SUBJECT");
  }

  public CharSequence getText()
  {
    return this.c.getCharSequenceExtra("android.intent.extra.TEXT");
  }

  public String getType()
  {
    return this.c.getType();
  }

  public boolean isMultipleShare()
  {
    return "android.intent.action.SEND_MULTIPLE".equals(this.c.getAction());
  }

  public boolean isShareIntent()
  {
    String str = this.c.getAction();
    return ("android.intent.action.SEND".equals(str)) || ("android.intent.action.SEND_MULTIPLE".equals(str));
  }

  public boolean isSingleShare()
  {
    return "android.intent.action.SEND".equals(this.c.getAction());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ShareCompat.IntentReader
 * JD-Core Version:    0.6.2
 */