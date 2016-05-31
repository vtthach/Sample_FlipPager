package dmt.dynamicpageradapter.adapter.fragment.helper;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Project:  and_exp
 * Author:   Khuong Vo
 * Since:    5/19/2016
 * Time:     2:07 PM
 */
public interface FragmentPagerHelper {

    void addPage(Class<?> cls, Bundle b);

    void removePage(int position);

    void goToNextPage();

    void goToPreviousPage();

    void goToPage(int pos);

    int getCount();

    Fragment getCurrentFragment();

    Fragment getFragmentAtPosition(int position);

    int getPositionAtClass(Class className);

}
