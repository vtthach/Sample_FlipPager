package dmt.hephaestus.adapter.helper;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Project:  hephaestus
 * Author:   Khuong Vo
 * Since:    5/19/2016
 * Time:     2:07 PM
 */
public interface FragmentPagerHelper {

    void addNextPage(Class<?> cls, Bundle b);

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
