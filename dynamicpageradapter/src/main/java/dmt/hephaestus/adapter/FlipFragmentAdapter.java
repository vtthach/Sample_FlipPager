package dmt.hephaestus.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;

import java.util.List;

/**
 * Project:  hephaestus
 * Author:   Khuong Vo
 * Since:    6/3/2016
 * Time:     7:33 PM
 */
public class FlipFragmentAdapter extends DynamicFragmentAdapter {

    public FlipFragmentAdapter(Context context, FragmentManager fm) {
        super(context, fm);
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
    public void updatePositionIndex(int pos, int currentItem) {
        List<DynamicFragmentModel> list = fragmentItems.subList(0, pos);
        list.add(fragmentItems.get(currentItem));
        fragmentItems = list;
        notifyDataSetChanged();
    }
}
