package dmt.hephaestus.sample.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;


/**
 * Project:  and_exp
 * Author:   Khuong Vo
 * Since:    5/19/2016
 * Time:     1:46 PM
 */
public class FragmentPagerHelperImpl1 implements FragmentPagerHelper1 {
    ViewPager mViewPager;
    DynamicFragmentAdapter1 mAdapter;

    public FragmentPagerHelperImpl1(ViewPager viewPager, FragmentManager fragmentManager) {
        mViewPager = viewPager;
        mAdapter = new DynamicFragmentAdapter1(viewPager.getContext(), fragmentManager);

        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void addPage(Class<?> cls, Bundle b) {
        mAdapter.addPage(cls, b);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void removePage(int position) {
        mAdapter.removePageFrom(position);
    }

    @Override
    public void goToNextPage() {
        if (mViewPager.getCurrentItem() < mViewPager.getAdapter().getCount() - 1)
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
    }

    @Override
    public void goToPreviousPage() {
        if (mViewPager.getCurrentItem() > 0) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void goToPage(int pos) {
        mAdapter.updatePositionIndex(pos, mViewPager.getCurrentItem());
        mViewPager.setCurrentItem(pos, true);
    }
}
