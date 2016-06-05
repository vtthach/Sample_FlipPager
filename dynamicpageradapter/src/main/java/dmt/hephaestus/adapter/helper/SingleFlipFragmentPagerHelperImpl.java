package dmt.hephaestus.adapter.helper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import dmt.hephaestus.adapter.SingleFlipFragmentAdapter;


/**
 * Project:  hephaestus
 * Author:   Khuong Vo
 * Since:    5/19/2016
 * Time:     1:46 PM
 */
public abstract class SingleFlipFragmentPagerHelperImpl implements SingleFlipFragmentPagerHelper {

    private ViewPager mViewPager;

    private SingleFlipFragmentAdapter mAdapter;

    public abstract void onAddNextPage(Fragment f, Class<?> cls, Bundle b);

    public SingleFlipFragmentPagerHelperImpl(ViewPager viewPager, FragmentManager fragmentManager) {
        mViewPager = viewPager;
        mAdapter = new SingleFlipFragmentAdapter(viewPager.getContext(), fragmentManager);

        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void addPage(Class<?> cls, Bundle b) {
        mAdapter.addPage(cls, b);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void addNextPage(Class<?> cls, Bundle b) {
        onAddNextPage(getFragmentAtPosition(mViewPager.getCurrentItem() + 1), cls, b);
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

    @Override
    public int getCount() {
        return mAdapter.getCount();
    }

    @Override
    public Fragment getCurrentFragment() {
        return mAdapter.getCurrentFragment();
    }

    @Override
    public Fragment getFragmentAtPosition(int position) {
        return mAdapter.getFragmentAtPosition(position);
    }

    @Override
    public int getPositionAtClass(Class className) {
        return mAdapter.getPositionAtClass(className);
    }
}
