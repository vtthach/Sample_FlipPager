package dmt.hephaestus.sample.ui.adapter.fragment.helper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import dmt.hephaestus.sample.ui.adapter.fragment.HorizontalFragmentAdapter;
import dmt.hephaestus.sample.ui.fragment.ContainerFragment;

/**
 * Project:  and_exp
 * Author:   Khuong Vo
 * Since:    5/19/2016
 * Time:     1:46 PM
 */
public class HorizontalFragmentPagerHelperImpl implements FragmentPagerHelper {
    ViewPager mViewPager;
    HorizontalFragmentAdapter mAdapter;

    public HorizontalFragmentPagerHelperImpl(ViewPager viewPager, FragmentManager fragmentManager) {
        mViewPager = viewPager;
        mAdapter = new HorizontalFragmentAdapter(viewPager.getContext(), fragmentManager);

        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void addPage(Class<?> cls, Bundle b) {
        mAdapter.addPage(cls, b);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void addFirstFlipPage(Class<?> cls, Bundle b) {
        ContainerFragment f = (ContainerFragment) getFragmentAtPosition(mViewPager.getCurrentItem() + 1);
        //if (f != null)
        f.replaceFragment(cls, b);
    }

    @Override
    public void removePage(int position) {
        mAdapter.removePage(position);
        mAdapter.notifyDataSetChanged();
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
