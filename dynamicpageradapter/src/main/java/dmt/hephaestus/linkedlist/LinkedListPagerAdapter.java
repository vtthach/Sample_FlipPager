package dmt.hephaestus.linkedlist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class LinkedListPagerAdapter extends FragmentStatePagerAdapter {

    LinkedListDynamicFragmentModel centerItem;

    private Context mContext;

    public LinkedListPagerAdapter(Context context, FragmentManager fm, LinkedListDynamicFragmentModel fragmentModel) {
        super(fm);
        mContext = context;
        centerItem = fragmentModel;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Fragment getItem(int position) {
        if (isCenterItem(position)) {
            // Center
            return getFragment(centerItem);
        } else if (isLeftItem(position)) {
            // Left
            return getFragment(getLeftFromCenter(centerItem.getCenterPosition() - position));
        } else {
            // Right
            return getFragment(getRightFromCenter(position - centerItem.getCenterPosition()));
        }
    }

    private LinkedListDynamicFragmentModel getLeftFromCenter(int numberItem) {
        LinkedListDynamicFragmentModel item = centerItem;
        for (int i = 0; i < numberItem; i++) {
            // Get next item
            LinkedListDynamicFragmentModel previous = item.getPrevious();
            if (previous == null) {
                item = getLeftEmptyModel(item);
            } else {
                item = previous;
            }
        }
        return item;
    }

    private LinkedListDynamicFragmentModel getRightFromCenter(int numberItem) {
        LinkedListDynamicFragmentModel item = centerItem;
        for (int i = 0; i < numberItem; i++) {
            LinkedListDynamicFragmentModel next = item.getNext();
            if (next == null) {
                item = getRightEmptyModel(item);
            } else {
                item = next;
            }
        }
        return item;
    }

    private LinkedListDynamicFragmentModel getLeftEmptyModel(LinkedListDynamicFragmentModel item) {
        LinkedListDynamicFragmentModel linkedListDynamicFragmentModel = new LinkedListDynamicFragmentModel(EmptyFragment.class, null, null);
        item.setPrevious(linkedListDynamicFragmentModel);
        linkedListDynamicFragmentModel.setNext(item);
        return linkedListDynamicFragmentModel;
    }

    private LinkedListDynamicFragmentModel getRightEmptyModel(LinkedListDynamicFragmentModel item) {
        LinkedListDynamicFragmentModel linkedListDynamicFragmentModel = new LinkedListDynamicFragmentModel(EmptyFragment.class, null, null);
        linkedListDynamicFragmentModel.setPrevious(item);
        item.setNext(linkedListDynamicFragmentModel);
        return linkedListDynamicFragmentModel;
    }

    private boolean isLeftItem(int position) {
        return position < centerItem.getCenterPosition();
    }

    private Fragment getFragment(@NonNull LinkedListDynamicFragmentModel dynamicFragmentModel) {
        if (dynamicFragmentModel.getFragment() == null) {
            dynamicFragmentModel.setFragment(Fragment.instantiate(mContext, dynamicFragmentModel.getCls().getName(), dynamicFragmentModel.getBundle()));
        }
        return dynamicFragmentModel.getFragment();
    }

    private boolean isCenterItem(int position) {
        return centerItem.getCenterPosition() == position;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        int oldCenterPosition = centerItem.getCenterPosition();
        if (position != oldCenterPosition) {
            if (position > oldCenterPosition) {
                // New center item is right
                centerItem = centerItem.getNext();
            } else {
                // New center item is left
                centerItem = centerItem.getPrevious();
            }
            centerItem.setCenterPosition(position);
        }
        super.setPrimaryItem(container, position, object);
    }

    public Fragment getCurrentFragment() {
        Fragment f = centerItem.getFragment();
        if (f != null)
            return f;
        return null;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void addPreviousPage(Class<?> cls, Bundle b) {
        LinkedListDynamicFragmentModel newLeftItem = new LinkedListDynamicFragmentModel(cls, null, b);
        LinkedListDynamicFragmentModel oldLeftItem = centerItem.getPrevious();
        centerItem.setPrevious(newLeftItem);
        if (oldLeftItem != null) {
            newLeftItem.setPrevious(oldLeftItem);
            oldLeftItem.setNext(newLeftItem);
        } else {
            getLeftEmptyModel(newLeftItem);
        }
        newLeftItem.setNext(centerItem);
    }

    public void addNextPage(Class<?> cls, Bundle b) {
        LinkedListDynamicFragmentModel newRightItem = new LinkedListDynamicFragmentModel(cls, null, b);
        LinkedListDynamicFragmentModel oldRightItem = centerItem.getNext();
        centerItem.setNext(newRightItem);
        newRightItem.setPrevious(centerItem);
        if (oldRightItem != null) {
            newRightItem.setNext(oldRightItem);
            oldRightItem.setPrevious(newRightItem);
        } else {
            getRightEmptyModel(newRightItem);
        }
    }
}
