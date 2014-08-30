package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import cn.com.smartdevices.bracelet.Debug;

public class MyListView extends ListView
  implements AbsListView.OnScrollListener
{
  private static final int MAX_Y_OVERSCROLL_DISTANCE = 200;
  private Boolean disableDrag = Boolean.valueOf(false);
  private Context mContext;
  private int mMaxYOverscrollDistance;
  private SlidingUpPanelLayout parentPanelLayout = null;

  public MyListView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    initBounceListView();
  }

  public MyListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    initBounceListView();
  }

  public MyListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initBounceListView();
  }

  private void initBounceListView()
  {
    this.mMaxYOverscrollDistance = ((int)(200.0F * this.mContext.getResources().getDisplayMetrics().density));
    super.setOnScrollListener(this);
  }

  public Boolean getDisableDrag()
  {
    return this.disableDrag;
  }

  public SlidingUpPanelLayout getParentPanelLayout()
  {
    return this.parentPanelLayout;
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Debug.i("chenee", "on scroll + firstVisibleItem = " + paramInt1);
    if ((this.parentPanelLayout != null) && (!this.parentPanelLayout.isCollapsed()))
      this.parentPanelLayout.setSlidingEnabled(false);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }

  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if ((!this.disableDrag.booleanValue()) && (paramInt2 < 0))
      this.parentPanelLayout.setSlidingEnabled(true);
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, this.mMaxYOverscrollDistance, paramBoolean);
  }

  public void setDisableDrag(Boolean paramBoolean)
  {
    this.disableDrag = paramBoolean;
  }

  public void setParentPanelLayout(SlidingUpPanelLayout paramSlidingUpPanelLayout)
  {
    this.parentPanelLayout = paramSlidingUpPanelLayout;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.MyListView
 * JD-Core Version:    0.6.2
 */