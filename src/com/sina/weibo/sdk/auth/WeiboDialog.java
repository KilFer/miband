package com.sina.weibo.sdk.auth;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.Utility;

public class WeiboDialog extends Dialog
{
  private static final String TAG = "WeiboDialog";
  private static final int WEBVIEW_CONTAINER_MARGIN_TOP = 25;
  private static final int WEBVIEW_MARGIN = 10;
  private static int theme = 16973840;
  private String mAuthUrl;
  private Context mContext;
  private boolean mIsDetached = false;
  private WeiboAuthListener mListener;
  private ProgressDialog mLoadingDlg;
  private RelativeLayout mRootContainer;
  private WebView mWebView;
  private RelativeLayout mWebViewContainer;
  private WeiboAuth mWeibo;

  public WeiboDialog(Context paramContext, String paramString, WeiboAuthListener paramWeiboAuthListener, WeiboAuth paramWeiboAuth)
  {
    super(paramContext, theme);
    this.mAuthUrl = paramString;
    this.mListener = paramWeiboAuthListener;
    this.mContext = paramContext;
    this.mWeibo = paramWeiboAuth;
  }

  private void handleRedirectUrl(String paramString)
  {
    Bundle localBundle = Utility.parseUrl(paramString);
    String str1 = localBundle.getString("error");
    String str2 = localBundle.getString("error_code");
    String str3 = localBundle.getString("error_description");
    if ((str1 == null) && (str2 == null))
    {
      this.mListener.onComplete(localBundle);
      return;
    }
    this.mListener.onWeiboException(new WeiboAuthException(str2, str1, str3));
  }

  private void initCloseButton()
  {
    ImageView localImageView = new ImageView(this.mContext);
    Drawable localDrawable = ResourceManager.getDrawable(this.mContext, 2);
    localImageView.setImageDrawable(localDrawable);
    localImageView.setOnClickListener(new WeiboDialog.1(this));
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.mWebViewContainer.getLayoutParams();
    localLayoutParams1.leftMargin = (5 + (localLayoutParams2.leftMargin - localDrawable.getIntrinsicWidth() / 2));
    localLayoutParams1.topMargin = (5 + (localLayoutParams2.topMargin - localDrawable.getIntrinsicHeight() / 2));
    this.mRootContainer.addView(localImageView, localLayoutParams1);
  }

  private void initLoadingDlg()
  {
    this.mLoadingDlg = new ProgressDialog(getContext());
    this.mLoadingDlg.requestWindowFeature(1);
    this.mLoadingDlg.setMessage(ResourceManager.getString(this.mContext, 1));
  }

  private void initWebView()
  {
    this.mWebViewContainer = new RelativeLayout(getContext());
    this.mWebView = new WebView(getContext());
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    this.mWebView.getSettings().setSavePassword(false);
    this.mWebView.setWebViewClient(new WeiboDialog.WeiboWebViewClient(this, null));
    this.mWebView.requestFocus();
    this.mWebView.setScrollBarStyle(0);
    this.mWebView.setVisibility(4);
    NetworkHelper.clearCookies(this.mContext, this.mAuthUrl);
    this.mWebView.loadUrl(this.mAuthUrl);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    int i = (int)(10.0F * localDisplayMetrics.density);
    localLayoutParams2.setMargins(i, i, i, i);
    Drawable localDrawable = ResourceManager.getNinePatchDrawable(this.mContext, 1);
    this.mWebViewContainer.setBackgroundDrawable(localDrawable);
    this.mWebViewContainer.addView(this.mWebView, localLayoutParams2);
    this.mWebViewContainer.setGravity(17);
    int j = 1 + ResourceManager.getDrawable(this.mContext, 2).getIntrinsicWidth() / 2;
    localLayoutParams1.setMargins(j, (int)(25.0F * localDisplayMetrics.density), j, j);
    this.mRootContainer.addView(this.mWebViewContainer, localLayoutParams1);
  }

  private void initWindow()
  {
    requestWindowFeature(1);
    getWindow().setFeatureDrawableAlpha(0, 0);
    getWindow().setSoftInputMode(16);
    this.mRootContainer = new RelativeLayout(getContext());
    this.mRootContainer.setBackgroundColor(0);
    addContentView(this.mRootContainer, new ViewGroup.LayoutParams(-1, -1));
  }

  public void dismiss()
  {
    if (!this.mIsDetached)
    {
      if ((this.mLoadingDlg != null) && (this.mLoadingDlg.isShowing()))
        this.mLoadingDlg.dismiss();
      super.dismiss();
    }
  }

  public void onAttachedToWindow()
  {
    this.mIsDetached = false;
    super.onAttachedToWindow();
  }

  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.mListener != null)
      this.mListener.onCancel();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initWindow();
    initLoadingDlg();
    initWebView();
    initCloseButton();
  }

  public void onDetachedFromWindow()
  {
    if (this.mWebView != null)
    {
      this.mWebViewContainer.removeView(this.mWebView);
      this.mWebView.stopLoading();
      this.mWebView.removeAllViews();
      this.mWebView.destroy();
      this.mWebView = null;
    }
    this.mIsDetached = true;
    super.onDetachedFromWindow();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.auth.WeiboDialog
 * JD-Core Version:    0.6.2
 */