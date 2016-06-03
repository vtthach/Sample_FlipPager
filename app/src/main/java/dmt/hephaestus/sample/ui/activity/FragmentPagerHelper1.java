package dmt.hephaestus.sample.ui.activity;

import android.os.Bundle;

/**
 * Project:  and_exp
 * Author:   Khuong Vo
 * Since:    5/19/2016
 * Time:     2:07 PM
 */
public interface FragmentPagerHelper1 {

    void addPage(Class<?> cls, Bundle b);

    void removePage(int position);

    void goToNextPage();

    void goToPreviousPage();

    void goToPage(int pos);
}
