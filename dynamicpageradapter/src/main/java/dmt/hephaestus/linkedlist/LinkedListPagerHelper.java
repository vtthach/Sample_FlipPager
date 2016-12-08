package dmt.hephaestus.linkedlist;

import android.os.Bundle;

import dmt.hephaestus.adapter.helper.FragmentPagerHelper;

/**
 * Project:  hephaestus
 * Author:   Khuong Vo
 * Since:    5/19/2016
 * Time:     2:07 PM
 */
public interface LinkedListPagerHelper extends FragmentPagerHelper {
    void goToNextPage(Class<?> cls, Bundle b);

    void addPreviousPage(Class<?> cls, Bundle b);
}
