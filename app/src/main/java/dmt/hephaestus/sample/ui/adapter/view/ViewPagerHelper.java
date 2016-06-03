package dmt.hephaestus.sample.ui.adapter.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import sample.dynamic_pager_adapter.R;
import sample.util.LibUtils;

/**
 * Project:  and_exp
 * Author:   Khuong Vo
 * Since:    5/18/2016
 * Time:     2:06 PM
 */
public class ViewPagerHelper {

    ViewPager pager;
    private ViewItemPagerAdapter pagerAdapter = null;

    public ViewPagerHelper(ViewPager vp, ViewItemPagerAdapter a) {
        pager = vp;
        pagerAdapter = a;

        pager.setAdapter(pagerAdapter);

        // Create an initial view to display; must be a subclass of FrameLayout.
        FrameLayout v0 = createViewInstance(vp.getContext());
        pagerAdapter.addView(v0, 0);
        pagerAdapter.notifyDataSetChanged();
    }



    //-----------------------------------------------------------------------------
    // Here's what the app should do to add a view to the ViewPager.
    public void addView(View newPage) {
        int pageIndex = pagerAdapter.addView(newPage);
        pagerAdapter.notifyDataSetChanged();
        // You might want to make "newPage" the currently displayed page:
        pager.setCurrentItem(pageIndex, true);

    }

    //-----------------------------------------------------------------------------
    // Here's what the app should do to remove a view from the ViewPager.
    public void removeView(View defunctPage) {
        int pageIndex = pagerAdapter.removeView(pager, defunctPage);
        // You might want to choose what page to display, if the current page was "defunctPage".
        if (pageIndex == pagerAdapter.getCount())
            pageIndex--;
        pager.setCurrentItem(pageIndex);
    }

    //-----------------------------------------------------------------------------
    // Here's what the app should do to get the currently displayed page.
    public View getCurrentPage() {
        return pagerAdapter.getView(pager.getCurrentItem());
    }

    //-----------------------------------------------------------------------------
    // Here's what the app should do to set the currently displayed page.  "pageToShow" must
    // currently be in the adapter, or this will crash.
    public void setCurrentPage(View pageToShow) {
        pager.setCurrentItem(pagerAdapter.getItemPosition(pageToShow), true);
    }

    //-----------------------------------------------------------------------------
    @NonNull
    public FrameLayout createViewInstance(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        FrameLayout v0 = (FrameLayout) inflater.inflate(R.layout.one_of_my_page_layouts, null);
        v0.setBackgroundColor(LibUtils.generateRandomColor());
        return v0;
    }
}
