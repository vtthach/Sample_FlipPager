package dmt.hephaestus.adapter.helper;

import android.os.Bundle;

/**
 * Project:  hephaestus
 * Author:   Khuong Vo
 * Since:    6/3/2016
 * Time:     7:41 PM
 */
public interface FlipFragmentPagerHelper {

    void addPage(Class<?> cls, Bundle b);

    void removePage(int position);

    void goToNextPage();

    void goToPreviousPage();

    void goToPage(int pos);
}
