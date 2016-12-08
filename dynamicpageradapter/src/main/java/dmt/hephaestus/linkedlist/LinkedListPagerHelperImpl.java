package dmt.hephaestus.linkedlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;

public class LinkedListPagerHelperImpl implements LinkedListPagerHelper {

    private static final int FIRST_CENTER_POSITION = 5000;
    private ViewPager mViewPager;

    private LinkedListPagerAdapter mAdapter;

    public LinkedListPagerHelperImpl(ViewPager viewPager, FragmentManager fragmentManager, LinkedListDynamicFragmentModel firstItem) {
        mViewPager = viewPager;
        mViewPager.setOffscreenPageLimit(1);
        firstItem.setCenterPosition(FIRST_CENTER_POSITION);
        mAdapter = new LinkedListPagerAdapter(viewPager.getContext(), fragmentManager, firstItem);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(FIRST_CENTER_POSITION);
    }

    @Override
    public void addPage(Class<?> cls, Bundle b) {
        mAdapter.addNextPage(cls, b);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void removePage(int position) {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException("This feature is under construction");
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("This feature is under construction");
    }

    @Override
    public Fragment getCurrentFragment() {
        return mAdapter.getCurrentFragment();
    }

    @Override
    public Fragment getFragmentAtPosition(int position) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getPositionAtClass(Class className) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void goToNextPage(Class<?> cls, Bundle b) {
        mAdapter.addNextPage(cls, b);
        mAdapter.notifyDataSetChanged();
        goToNextPage();
    }

    @Override
    public void addPreviousPage(Class<?> cls, Bundle b) {
        mAdapter.addPreviousPage(cls, b);
        mAdapter.notifyDataSetChanged();
        Log.i("vtt", "goTo Previous page 2: " + mViewPager.getCurrentItem());
    }
}
