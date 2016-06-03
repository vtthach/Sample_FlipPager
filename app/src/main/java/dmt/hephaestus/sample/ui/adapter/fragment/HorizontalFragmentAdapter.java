package dmt.hephaestus.sample.ui.adapter.fragment;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;

/**
 * Project:  and_exp
 * Author:   Khuong Vo
 * Since:    5/18/2016
 * Time:     5:19 PM
 */
public class HorizontalFragmentAdapter extends DynamicFragmentAdapter {

    public HorizontalFragmentAdapter(Context context, FragmentManager fm) {
        super(context, fm);
    }

    @Override
    public void removePageFrom(int position) {
        if (isSynchronizeData
                && position >= 0
                && position + 2 < fragmentItems.size() - 1) { // change position + 2 for specific purpose
            for (int i = fragmentItems.size() - 1; i > position + 1; i--) {
               // fragmentItems.remove(i);
            }
            notifyDataSetChanged();
        }
    }

    @Override
    public void updatePositionIndex(int pos, int currentItem) {
        if (currentItem > pos) {
           /* List<DynamicFragmentModel> list = fragmentItems.subList(0, pos + 1);
            //list.add(fragmentItems.get(currentItem));
            //list.add(fragmentItems.get(currentItem + 1));
            fragmentItems = list;
            Bundle b = new Bundle();
            b.putInt(Constants.KEY_INDEX, fragmentItems.size());
            addPage(ContainerFragment.class, null);
            notifyDataSetChanged();*/
        } else if (currentItem <= pos) {
            // do nothing
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        fragmentItems.get(position).setFragment(null);
    }
}
