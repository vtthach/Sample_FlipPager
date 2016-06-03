package dmt.hephaestus.sample.ui.adapter.fragment.helper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import dmt.hephaestus.sample.ui.fragment.BaseHorizontalSampleFragment;

/**
 * Project:  and_exp
 * Author:   Khuong Vo
 * Since:    5/19/2016
 * Time:     1:46 PM
 */
public class SimpleFragmentPagerHelperImpl implements FragmentPagerHelper {
    ViewPager mViewPager;
    FragmentPagerAdapter mAdapter;

    public SimpleFragmentPagerHelperImpl(final ViewPager viewPager, FragmentManager fragmentManager) {
        mViewPager = viewPager;
        mAdapter = new FragmentPagerAdapter(fragmentManager) {

            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public Fragment getItem(int position) {

                Bundle b = new Bundle();
                b.putInt("INDEX", position);
                return Fragment.instantiate(viewPager.getContext(), BaseHorizontalSampleFragment.class.getName(), b);
            }
        };

        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void addPage(Class<?> cls, Bundle b) {
        //mAdapter.addPage(cls, b);
        //mAdapter.notifyDataSetChanged();
    }

    @Override
    public void addFirstFlipPage(Class<?> cls, Bundle b) {
        //TODO: implementing
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public void removePage(int position) {
        //mAdapter.removePageFrom(position);
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
        //mAdapter.updatePositionIndex(pos, mViewPager.getCurrentItem());
        mViewPager.setCurrentItem(pos, true);
    }

    @Override
    public int getCount() {
        return mAdapter.getCount();
    }

    @Override
    public Fragment getCurrentFragment() {
        //TODO: implementing
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public Fragment getFragmentAtPosition(int position) {
        return mAdapter.getItem(position);
    }

    @Override
    public int getPositionAtClass(Class className) {
        //TODO: implementing
        throw new UnsupportedOperationException("Not Implemented");
    }
}
