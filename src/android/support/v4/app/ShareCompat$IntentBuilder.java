package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Html;
import java.util.ArrayList;

public class ShareCompat$IntentBuilder
{
  private Activity a;
  private Intent b;
  private CharSequence c;
  private ArrayList<String> d;
  private ArrayList<String> e;
  private ArrayList<String> f;
  private ArrayList<Uri> g;

  private ShareCompat$IntentBuilder(Activity paramActivity)
  {
    this.a = paramActivity;
    this.b = new Intent().setAction("android.intent.action.SEND");
    this.b.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", paramActivity.getPackageName());
    this.b.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", paramActivity.getComponentName());
    this.b.addFlags(524288);
  }

  private void a(String paramString, ArrayList<String> paramArrayList)
  {
    String[] arrayOfString1 = this.b.getStringArrayExtra(paramString);
    if (arrayOfString1 != null);
    for (int i = arrayOfString1.length; ; i = 0)
    {
      String[] arrayOfString2 = new String[i + paramArrayList.size()];
      paramArrayList.toArray(arrayOfString2);
      if (arrayOfString1 != null)
        System.arraycopy(arrayOfString1, 0, arrayOfString2, paramArrayList.size(), i);
      this.b.putExtra(paramString, arrayOfString2);
      return;
    }
  }

  private void a(String paramString, String[] paramArrayOfString)
  {
    Intent localIntent = getIntent();
    String[] arrayOfString1 = localIntent.getStringArrayExtra(paramString);
    if (arrayOfString1 != null);
    for (int i = arrayOfString1.length; ; i = 0)
    {
      String[] arrayOfString2 = new String[i + paramArrayOfString.length];
      if (arrayOfString1 != null)
        System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, i);
      System.arraycopy(paramArrayOfString, 0, arrayOfString2, i, paramArrayOfString.length);
      localIntent.putExtra(paramString, arrayOfString2);
      return;
    }
  }

  public static IntentBuilder from(Activity paramActivity)
  {
    return new IntentBuilder(paramActivity);
  }

  final Activity a()
  {
    return this.a;
  }

  public IntentBuilder addEmailBcc(String paramString)
  {
    if (this.f == null)
      this.f = new ArrayList();
    this.f.add(paramString);
    return this;
  }

  public IntentBuilder addEmailBcc(String[] paramArrayOfString)
  {
    a("android.intent.extra.BCC", paramArrayOfString);
    return this;
  }

  public IntentBuilder addEmailCc(String paramString)
  {
    if (this.e == null)
      this.e = new ArrayList();
    this.e.add(paramString);
    return this;
  }

  public IntentBuilder addEmailCc(String[] paramArrayOfString)
  {
    a("android.intent.extra.CC", paramArrayOfString);
    return this;
  }

  public IntentBuilder addEmailTo(String paramString)
  {
    if (this.d == null)
      this.d = new ArrayList();
    this.d.add(paramString);
    return this;
  }

  public IntentBuilder addEmailTo(String[] paramArrayOfString)
  {
    a("android.intent.extra.EMAIL", paramArrayOfString);
    return this;
  }

  public IntentBuilder addStream(Uri paramUri)
  {
    Uri localUri = (Uri)this.b.getParcelableExtra("android.intent.extra.STREAM");
    if (localUri == null)
      return setStream(paramUri);
    if (this.g == null)
      this.g = new ArrayList();
    if (localUri != null)
    {
      this.b.removeExtra("android.intent.extra.STREAM");
      this.g.add(localUri);
    }
    this.g.add(paramUri);
    return this;
  }

  public Intent createChooserIntent()
  {
    return Intent.createChooser(getIntent(), this.c);
  }

  public Intent getIntent()
  {
    if (this.d != null)
    {
      a("android.intent.extra.EMAIL", this.d);
      this.d = null;
    }
    if (this.e != null)
    {
      a("android.intent.extra.CC", this.e);
      this.e = null;
    }
    if (this.f != null)
    {
      a("android.intent.extra.BCC", this.f);
      this.f = null;
    }
    int i;
    if ((this.g != null) && (this.g.size() > 1))
    {
      i = 1;
      boolean bool = this.b.getAction().equals("android.intent.action.SEND_MULTIPLE");
      if ((i == 0) && (bool))
      {
        this.b.setAction("android.intent.action.SEND");
        if ((this.g == null) || (this.g.isEmpty()))
          break label219;
        this.b.putExtra("android.intent.extra.STREAM", (Parcelable)this.g.get(0));
        label155: this.g = null;
      }
      if ((i != 0) && (!bool))
      {
        this.b.setAction("android.intent.action.SEND_MULTIPLE");
        if ((this.g == null) || (this.g.isEmpty()))
          break label231;
        this.b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.g);
      }
    }
    while (true)
    {
      return this.b;
      i = 0;
      break;
      label219: this.b.removeExtra("android.intent.extra.STREAM");
      break label155;
      label231: this.b.removeExtra("android.intent.extra.STREAM");
    }
  }

  public IntentBuilder setChooserTitle(int paramInt)
  {
    return setChooserTitle(this.a.getText(paramInt));
  }

  public IntentBuilder setChooserTitle(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
    return this;
  }

  public IntentBuilder setEmailBcc(String[] paramArrayOfString)
  {
    this.b.putExtra("android.intent.extra.BCC", paramArrayOfString);
    return this;
  }

  public IntentBuilder setEmailCc(String[] paramArrayOfString)
  {
    this.b.putExtra("android.intent.extra.CC", paramArrayOfString);
    return this;
  }

  public IntentBuilder setEmailTo(String[] paramArrayOfString)
  {
    if (this.d != null)
      this.d = null;
    this.b.putExtra("android.intent.extra.EMAIL", paramArrayOfString);
    return this;
  }

  public IntentBuilder setHtmlText(String paramString)
  {
    this.b.putExtra("android.intent.extra.HTML_TEXT", paramString);
    if (!this.b.hasExtra("android.intent.extra.TEXT"))
      setText(Html.fromHtml(paramString));
    return this;
  }

  public IntentBuilder setStream(Uri paramUri)
  {
    if (!this.b.getAction().equals("android.intent.action.SEND"))
      this.b.setAction("android.intent.action.SEND");
    this.g = null;
    this.b.putExtra("android.intent.extra.STREAM", paramUri);
    return this;
  }

  public IntentBuilder setSubject(String paramString)
  {
    this.b.putExtra("android.intent.extra.SUBJECT", paramString);
    return this;
  }

  public IntentBuilder setText(CharSequence paramCharSequence)
  {
    this.b.putExtra("android.intent.extra.TEXT", paramCharSequence);
    return this;
  }

  public IntentBuilder setType(String paramString)
  {
    this.b.setType(paramString);
    return this;
  }

  public void startChooser()
  {
    this.a.startActivity(createChooserIntent());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ShareCompat.IntentBuilder
 * JD-Core Version:    0.6.2
 */