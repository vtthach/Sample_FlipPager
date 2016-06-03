package dmt.hephaestus.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Project:  hephaestus
 * Author:   Khuong Vo
 * Since:    6/3/2016
 * Time:     7:33 PM
 */
public class FlipFragmentAdapter extends FragmentPagerAdapter {

    List<DynamicFragmentModel> fragmentItems = new ArrayList<>();

    private boolean mIsSynchronizeData = false;
    private Context mContext;

    public FlipFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return fragmentItems.size();
    }

    @Override
    public Fragment getItem(int position) {
        DynamicFragmentModel fragmentItem = fragmentItems.get(position);
        if (fragmentItem.getFragment() != null)
            return fragmentItem.getFragment();
        else
            return Fragment.instantiate(mContext, fragmentItem.getCls().getName(), fragmentItem.getBundle());
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment f = (Fragment) super.instantiateItem(container, position);
        if (position >= fragmentItems.size()) {
            DynamicFragmentModel fragmentItem = fragmentItems.get(position);
            fragmentItem.setFragment(f);
        }
        return f;
    }


    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);

        // remove all items from current item to last item
        removePageFrom(position);
    }


    public void addPage(Class<?> cls, Bundle b) {
        DynamicFragmentModel fragmentItem = new DynamicFragmentModel(cls, null, b);
        fragmentItems.add(fragmentItem);
    }

    public void removePageFrom(int position) {
        // remove all items from current item to last item
        if (mIsSynchronizeData
                && position >= 0
                && position + 1 < fragmentItems.size()) {
            for (int i = fragmentItems.size() - 1; i > position; i--) {
                fragmentItems.remove(i);
            }

            notifyDataSetChanged();
        }
    }

    @Override
    public void notifyDataSetChanged() {
        mIsSynchronizeData = false;
        super.notifyDataSetChanged();
        mIsSynchronizeData = true;
    }

    public void updatePositionIndex(int pos, int currentItem) {
        List<DynamicFragmentModel> list = fragmentItems.subList(0, pos);
        list.add(fragmentItems.get(currentItem));
        fragmentItems = list;
        notifyDataSetChanged();
    }
}
